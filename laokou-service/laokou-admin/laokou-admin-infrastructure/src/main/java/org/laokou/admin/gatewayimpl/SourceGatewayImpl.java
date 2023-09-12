/*
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
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

package org.laokou.admin.gatewayimpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.laokou.admin.domain.annotation.DataFilter;
import org.laokou.admin.domain.gateway.SourceGateway;
import org.laokou.admin.domain.source.Source;
import org.laokou.admin.gatewayimpl.database.SourceMapper;
import org.laokou.admin.gatewayimpl.database.dataobject.SourceDO;
import org.laokou.common.core.utils.ConvertUtil;
import org.laokou.common.i18n.dto.Datas;
import org.laokou.common.i18n.dto.PageQuery;
import org.springframework.stereotype.Component;

import static org.laokou.admin.common.DsConstant.BOOT_SYS_SOURCE;

/**
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class SourceGatewayImpl implements SourceGateway {

    private final SourceMapper sourceMapper;

    @Override
    @DataFilter(alias = BOOT_SYS_SOURCE)
    public Datas<Source> list(Source source, PageQuery pageQuery) {
        IPage<SourceDO> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        IPage<SourceDO> newPage = sourceMapper.getSourceListByLikeNameFilter(page, source.getName(), pageQuery.getSqlFilter());
        Datas<Source> datas = new Datas<>();
        datas.setTotal(newPage.getTotal());
        datas.setRecords(ConvertUtil.sourceToTarget(newPage.getRecords(),Source.class));
        return datas;
    }
}
