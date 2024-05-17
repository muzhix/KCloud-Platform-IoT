/*
 * Copyright (c) 2022-2024 KCloud-Platform-IoT Author or Authors. All Rights Reserved.
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

package org.laokou.iot.config;

import org.laokou.common.netty.config.Server;
import org.laokou.common.netty.config.TcpServer;
import org.laokou.common.netty.config.TcpProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author laokou
 */
@Configuration
public class TcpConfig {

	@Bean(name = "tcpServer", initMethod = "start", destroyMethod = "stop")
	public Server tcpServer(TcpProperties tcpProperties, TcpChannelInitializer tcpChannelInitializer) {
		return new TcpServer(tcpProperties.getPort(), tcpChannelInitializer);
	}

}
