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

package org.laokou.admin.gatewayimpl.database;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.laokou.admin.gatewayimpl.database.dataobject.TenantDO;
import org.laokou.common.i18n.dto.PageQuery;
import org.laokou.common.mybatisplus.database.BatchMapper;
import org.springframework.stereotype.Repository;

import static org.laokou.common.i18n.dto.PageQuery.PAGE_QUERY;

/**
 * 租户.
 *
 * @author laokou
 */
@Mapper
@Repository
public interface TenantMapper extends BatchMapper<TenantDO> {

	/**
	 * 查询租户列表.
	 * @param page 分页参数
	 * @param name 租户名称
	 * @param pageQuery 分页参数
	 * @return 租户列表
	 */
	IPage<TenantDO> getTenantListFilter(IPage<TenantDO> page, @Param("name") String name,
			@Param(PAGE_QUERY) PageQuery pageQuery);

	/**
	 * 查看最大标签数字.
	 * @return 最大标签数字
	 */
	Integer maxLabelNum();

}
