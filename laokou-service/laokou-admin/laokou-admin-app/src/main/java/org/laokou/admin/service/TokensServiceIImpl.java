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

package org.laokou.admin.service;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.api.TokensServiceI;
import org.laokou.admin.command.token.qry.TokenGetQryExe;
import org.laokou.admin.dto.token.TokenGetQry;
import org.laokou.admin.dto.token.clientobject.TokenCO;
import org.laokou.common.i18n.dto.Result;
import org.springframework.stereotype.Service;

/**
 * 令牌管理.
 *
 * @author laokou
 */
@Service
@RequiredArgsConstructor
public class TokensServiceIImpl implements TokensServiceI {

	private final TokenGetQryExe tokenGetQryExe;

	/**
	 * 生成令牌.
	 * @param qry 生成令牌参数
	 * @return 令牌
	 */
	@Override
	public Result<TokenCO> generate(TokenGetQry qry) {
		return tokenGetQryExe.execute(qry);
	}

}
