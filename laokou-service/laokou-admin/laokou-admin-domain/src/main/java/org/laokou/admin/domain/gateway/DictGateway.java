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

package org.laokou.admin.domain.gateway;

import io.swagger.v3.oas.annotations.media.Schema;
import org.laokou.admin.domain.dict.Dict;
import org.laokou.common.i18n.dto.Datas;
import org.laokou.common.i18n.dto.PageQuery;

/**
 * @author laokou
 */
@Schema(name = "DictGateway", description = "字典网关")
public interface DictGateway {

	/**
	 * 新增字典.
	 * @param dict 字典对象
	 * @return 新增结果
	 */
	Boolean insert(Dict dict);

	/**
	 * 修改字典.
	 * @param dict 字典对象
	 * @return 修改结果
	 */
	Boolean update(Dict dict);

	/**
	 * 根据ID查看字典.
	 * @param id ID
	 * @return 字典
	 */
	Dict getById(Long id);

	/**
	 * 根据ID删除字典.
	 * @param id ID
	 * @return 删除结果
	 */
	Boolean deleteById(Long id);

	/**
	 * 查询字典列表.
	 * @param dict 字典对象
	 * @param pageQuery 分页参数
	 * @return 字典列表
	 */
	Datas<Dict> list(Dict dict, PageQuery pageQuery);

}
