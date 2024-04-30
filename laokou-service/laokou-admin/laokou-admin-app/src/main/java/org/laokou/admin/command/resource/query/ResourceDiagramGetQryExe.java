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

package org.laokou.admin.command.resource.query;

import lombok.RequiredArgsConstructor;
import org.laokou.admin.dto.resource.ResourceDiagramGetQry;
import org.laokou.common.i18n.dto.Result;
import org.springframework.stereotype.Component;

/**
 * 查看资源任务流程图执行器.
 *
 * @author laokou
 */
@Component
@RequiredArgsConstructor
public class ResourceDiagramGetQryExe {

	// private final TasksFeignClient tasksFeignClient;

	/**
	 * 执行查看资源任务流程图.
	 * @param qry 查看资源任务流程图
	 * @return 资源流程图
	 */
	public Result<String> execute(ResourceDiagramGetQry qry) {
		return null;
		// return tasksFeignClient.diagram(qry.getInstanceId());
	}

}
