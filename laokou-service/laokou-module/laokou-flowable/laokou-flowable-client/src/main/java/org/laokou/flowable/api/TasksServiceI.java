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

package org.laokou.flowable.api;

import org.laokou.common.i18n.dto.Datas;
import org.laokou.common.i18n.dto.Result;
import org.laokou.flowable.dto.task.*;
import org.laokou.flowable.dto.task.clientobject.AssigneeCO;
import org.laokou.flowable.dto.task.clientobject.AuditCO;
import org.laokou.flowable.dto.task.clientobject.StartCO;
import org.laokou.flowable.dto.task.clientobject.TaskCO;

/**
 * @author laokou
 */
public interface TasksServiceI {

	/**
	 * @param qry
	 * @return
	 */
	Result<Datas<TaskCO>> list(TaskListQry qry);

	/**
	 * @param cmd
	 * @return
	 */
	Result<AuditCO> audit(TaskAuditCmd cmd);

	/**
	 * @param cmd
	 * @return
	 */
	Result<Boolean> resolve(TaskResolveCmd cmd);

	/**
	 * @param cmd
	 * @return
	 */
	Result<StartCO> start(TaskStartCmd cmd);

	/**
	 * @param qry
	 * @return
	 */
	Result<String> diagram(TaskDiagramGetQry qry);

	/**
	 * @param cmd
	 * @return
	 */
	Result<Boolean> transfer(TaskTransferCmd cmd);

	/**
	 * @param cmd
	 * @return
	 */
	Result<Boolean> delegate(TaskDelegateCmd cmd);

	/**
	 * @param qry
	 * @return
	 */
	Result<AssigneeCO> assignee(TaskAssigneeGetQry qry);

}
