/*
 * Copyright (c) 2022 KCloud-Platform-Alibaba Author or Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laokou.common.i18n.common;

/**
 * kafka消息常量.
 *
 * @author laokou
 */
public final class KafkaConstants {

	private KafkaConstants() {
	}

	/**
	 * 分布式链路主题.
	 */
	public static final String LAOKOU_TRACE_TOPIC = "laokou_trace_topic";

	/**
	 * 日志消费者组.
	 */
	public static final String LAOKOU_LOGSTASH_CONSUMER_GROUP = "laokou_logstash_consumer_group";

}
