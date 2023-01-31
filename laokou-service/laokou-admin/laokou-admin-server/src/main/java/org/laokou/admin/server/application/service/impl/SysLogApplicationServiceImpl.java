/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *   http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.laokou.admin.server.application.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.laokou.admin.client.excel.SysLoginLogExcel;
import org.laokou.admin.client.excel.SysOperateLogExcel;
import org.laokou.admin.server.application.service.SysLogApplicationService;
import org.laokou.common.core.utils.ConvertUtil;
import org.laokou.common.core.utils.ExcelUtil;
import org.laokou.common.data.filter.annotation.DataFilter;
import org.laokou.common.log.qo.SysLoginLogQo;
import org.laokou.common.log.qo.SysOperateLogQo;
import org.laokou.common.log.service.SysLoginLogService;
import org.laokou.common.log.service.SysOperateLogService;
import org.laokou.common.log.vo.SysLoginLogVO;
import org.laokou.common.log.vo.SysOperateLogVO;
import org.laokou.common.swagger.utils.ValidatorUtil;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * @author laokou
 */
@Service
@RequiredArgsConstructor
public class SysLogApplicationServiceImpl implements SysLogApplicationService {

    private final SysOperateLogService sysOperateLogService;

    private final SysLoginLogService sysLoginLogService;

    @Override
    @DataFilter(tableAlias = "boot_sys_operate_log")
    public IPage<SysOperateLogVO> queryOperateLogPage(SysOperateLogQo qo) {
        ValidatorUtil.validateEntity(qo);
        IPage<SysOperateLogVO> page = new Page<>(qo.getPageNum(),qo.getPageSize());
        return sysOperateLogService.getOperateLogList(page,qo);
    }

    @Override
    public void exportOperateLog(SysOperateLogQo qo, HttpServletResponse response) throws IOException {
        ExcelUtil.export(response,"", ConvertUtil.sourceToTarget(sysOperateLogService.getOperateLogList(qo),SysOperateLogExcel.class), SysOperateLogExcel.class);
    }

    @Override
    public void exportLoginLog(SysLoginLogQo qo, HttpServletResponse response) throws IOException {
        ExcelUtil.export(response,"", ConvertUtil.sourceToTarget(sysLoginLogService.getLoginLogList(qo),SysLoginLogExcel.class), SysLoginLogExcel.class);
    }

    @Override
    public IPage<SysLoginLogVO> queryLoginLogPage(SysLoginLogQo qo) {
        IPage<SysLoginLogVO> page = new Page<>(qo.getPageNum(),qo.getPageSize());
        return sysLoginLogService.getLoginLogList(page,qo);
    }

}
