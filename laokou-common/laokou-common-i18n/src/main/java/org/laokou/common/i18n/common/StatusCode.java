/*
 * Copyright (c) 2022-2024 KCloud-Platform-IOT Author or Authors. All Rights Reserved.
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

package org.laokou.common.i18n.common;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author laokou
 */
@Schema(name = "StatusCode", description = "状态码")
public final class StatusCode {

	private StatusCode() {
	}

	@Schema(name = "OK", description = "请求成功")
	public static final String OK = "OK";

	@Schema(name = "BAD_REQUEST", description = "错误请求")
	public static final String BAD_REQUEST = "Bad_Request";

	@Schema(name = "UNAUTHORIZED", description = "登录状态已过期")
	public static final String UNAUTHORIZED = "Unauthorized";

	@Schema(name = "FORBIDDEN", description = "拒绝访问，没有权限")
	public static final String FORBIDDEN = "Forbidden";

	@Schema(name = "NOT_FOUND", description = "无法找到请求的资源")
	public static final String NOT_FOUND = "Not_Found";

	@Schema(name = "TOO_MANY_REQUESTS", description = "请求太频繁")
	public static final String TOO_MANY_REQUESTS = "Too_Many_Requests";

	@Schema(name = "INTERNAL_SERVER_ERROR", description = "服务器内部错误，无法完成请求")
	public static final String INTERNAL_SERVER_ERROR = "Internal_Server_Error";

	@Schema(name = "BAD_GATEWAY", description = "错误网关")
	public static final String BAD_GATEWAY = "Bad_Gateway";

	@Schema(name = "SERVICE_UNAVAILABLE", description = "服务正在维护")
	public static final String SERVICE_UNAVAILABLE = "Service_Unavailable";

}
