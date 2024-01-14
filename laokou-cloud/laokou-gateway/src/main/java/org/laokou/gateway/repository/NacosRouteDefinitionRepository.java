/*
 * Copyright (c) 2022 KCloud-Platform-Alibaba Author or Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.laokou.gateway.repository;

import com.alibaba.nacos.api.config.ConfigService;
import io.micrometer.common.lang.NonNullApi;
import lombok.extern.slf4j.Slf4j;
import org.laokou.common.core.utils.JacksonUtil;
import org.laokou.common.i18n.common.exception.GatewayException;
import org.laokou.common.i18n.utils.LogUtil;
import org.laokou.common.nacos.utils.ConfigUtil;
import org.laokou.common.redis.utils.RedisKeyUtil;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;

import static org.laokou.common.i18n.common.ErrorCodes.ROUTE_NOT_EXIST;
import static org.laokou.common.i18n.common.RouterConstants.DATA_ID;

/**
 * <a href=
 * "https://github.com/alibaba/spring-cloud-alibaba/blob/2.2.x/spring-cloud-alibaba-examples/nacos-example/nacos-config-example/src/main/java/com/alibaba/cloud/examples/example/ConfigListenerExample.java">...</a>
 *
 * @author laokou
 */
@Component
@Slf4j
@NonNullApi
@Repository
public class NacosRouteDefinitionRepository implements RouteDefinitionRepository {

	private final ConfigUtil configUtil;

	private final ReactiveHashOperations<String, String, RouteDefinition> reactiveHashOperations;

	public NacosRouteDefinitionRepository(ConfigUtil configUtil,
			ReactiveRedisTemplate<String, Object> reactiveRedisTemplate) {
		this.configUtil = configUtil;
		this.reactiveHashOperations = reactiveRedisTemplate.opsForHash();
	}

	@Override
	public Flux<RouteDefinition> getRouteDefinitions() {
		return reactiveHashOperations.entries(RedisKeyUtil.getRouteDefinitionHashKey())
			.mapNotNull(Map.Entry::getValue)
			.onErrorContinue((throwable, routeDefinition) -> {
				if (log.isErrorEnabled()) {
					log.error("get routes from redis error cause : {}", throwable.toString(), throwable);
				}
			});
	}

	// @formatter:off
	@Override
	public Mono<Void> save(Mono<RouteDefinition> route) {
		return Mono.empty();
	}

	@Override
	public Mono<Void> delete(Mono<String> routeId) {
		return Mono.empty();
	}

	public Flux<Boolean> syncRouters() {
		return Flux.fromIterable(pullRouters())
			.flatMap(router -> reactiveHashOperations.putIfAbsent(RedisKeyUtil.getRouteDefinitionHashKey(), router.getId(), router));
	}

	public Mono<Boolean> deleteRouters() {
		return reactiveHashOperations.delete(RedisKeyUtil.getRouteDefinitionHashKey());
	}

	private Collection<RouteDefinition> pullRouters() {
		try {
			// pull nacos config info
			String group = configUtil.getGroup();
			ConfigService configService = configUtil.getConfigService();
			String configInfo = configService.getConfig(DATA_ID, group, 5000);
			return JacksonUtil.toList(configInfo, RouteDefinition.class);
		}
		catch (Exception e) {
			log.error("错误信息：{}，详情见日志", LogUtil.result(e.getMessage()), e);
			throw new GatewayException(ROUTE_NOT_EXIST);
		}
	}
	// @formatter:on

}
