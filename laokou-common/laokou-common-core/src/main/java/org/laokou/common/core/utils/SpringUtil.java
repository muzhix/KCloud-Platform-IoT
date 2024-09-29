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

package org.laokou.common.core.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import static org.laokou.common.core.utils.SpringContextUtil.APPLICATION_NAME;
import static org.laokou.common.core.utils.SpringContextUtil.DEFAULT_SERVICE_ID;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class SpringUtil {

	/**
	 * 虚拟线程开关.
	 */
	private static final String THREADS_VIRTUAL_ENABLED = "spring.threads.virtual.enabled";

	private final Environment environment;

	public String getServiceId() {
		return environment.getProperty(APPLICATION_NAME, DEFAULT_SERVICE_ID);
	}

	public boolean isVirtualThread() {
		return environment.getProperty(THREADS_VIRTUAL_ENABLED, Boolean.class, false);
	}

}
