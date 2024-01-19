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

package org.laokou.admin.command.user;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.dto.user.OnlineUserKillCmd;
import org.laokou.common.i18n.dto.Result;
import org.laokou.common.redis.utils.RedisKeyUtil;
import org.laokou.common.redis.utils.RedisUtil;
import org.springframework.stereotype.Component;
import static org.laokou.common.i18n.common.NumberConstants.DEFAULT;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class OnlineUserKillCmdExe {

	private final RedisUtil redisUtil;

	public Result<Boolean> execute(OnlineUserKillCmd cmd) {
		String token = cmd.getToken();
		String userKillKey = RedisKeyUtil.getUserKillKey(token);
		String userInfoKey = RedisKeyUtil.getUserInfoKey(token);
		Long expire = redisUtil.getExpire(userInfoKey);
		if (expire > 0) {
			redisUtil.set(userKillKey, DEFAULT, expire);
			return Result.of(redisUtil.delete(userInfoKey));
		}
		return Result.of(false);
	}

}
