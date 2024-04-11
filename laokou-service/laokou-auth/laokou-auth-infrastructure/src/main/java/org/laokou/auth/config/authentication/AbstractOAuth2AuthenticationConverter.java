/*
 * Copyright (c) 2022-2024 KCloud-Platform-Alibaba Author or Authors. All Rights Reserved.
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

package org.laokou.auth.config.authentication;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.laokou.auth.domain.user.Auth;
import org.laokou.common.core.utils.MapUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象认证转换器.
 *
 * @author laokou
 */
@Slf4j
public abstract class AbstractOAuth2AuthenticationConverter implements AuthenticationConverter {

	/**
	 * 获取认证类型.
	 * @return 认证类型
	 */
	abstract String getGrantType();

	/**
	 * 子类实现转换.
	 * @param clientPrincipal 认证参数
	 * @param additionalParameters 扩展参数
	 */
	abstract Authentication convert(Authentication clientPrincipal, Map<String, Object> additionalParameters);

	@Override
	public Authentication convert(HttpServletRequest request) {
		// try {
		// 请求链 FilterOrderRegistration
		String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
		if (!getGrantType().equals(grantType)) {
			return null;
		}
		// 构建请求参数集合
		MultiValueMap<String, String> parameters = MapUtil.getParameters(request);
		List<String> scopes = parameters.get(OAuth2ParameterNames.SCOPE);
		// 判断scopes
		Auth.builder().build().checkScopes(scopes);
		// 获取上下文认证信息
		Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();
		Map<String, Object> additionalParameters = new HashMap<>(parameters.size());
		parameters.forEach((key, value) -> {
			if (!key.equals(OAuth2ParameterNames.GRANT_TYPE) && !key.equals(OAuth2ParameterNames.CLIENT_ID)) {
				additionalParameters.put(key, value.getFirst());
			}
		});
		return convert(clientPrincipal, additionalParameters);
		// }

		// catch (GlobalException e) {
		// throw OAuth2ExceptionHandler.getException(e.getCode(), e.getMsg());
		// }
	}

}
