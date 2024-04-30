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

package org.laokou.auth.service;

import lombok.RequiredArgsConstructor;
import org.laokou.auth.api.LogoutsServiceI;
import org.laokou.auth.command.logout.LogoutCmdExe;
import org.laokou.auth.dto.logout.LogoutCmd;
import org.springframework.stereotype.Service;

/**
 * 退出登录.
 *
 * @author laokou
 */
@Service
@RequiredArgsConstructor
public class LogoutsServiceImpl implements LogoutsServiceI {

	private final LogoutCmdExe logoutCmdExe;

	/**
	 * 移除Token.
	 * @param cmd 退出登录参数
	 */
	@Override
	public void removeToken(LogoutCmd cmd) {
		logoutCmdExe.executeVoid(cmd);
	}

}
