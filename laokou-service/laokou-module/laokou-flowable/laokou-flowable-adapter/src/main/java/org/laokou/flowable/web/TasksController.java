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

package org.laokou.flowable.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.laokou.common.i18n.dto.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author laokou
 */
@RestController
@Tag(name = "TasksController", description = "流程任务")
@RequiredArgsConstructor
public class TasksController {

	@PostMapping(value = "v1/task/list")
	@Operation(summary = "查询", description = "查询")
	public Result<?> list() {
		return Result.of(null);
	}

	@PostMapping(value = "v1/task/audit")
	@Operation(summary = "审批", description = "审批")
	public Result<?> audit() {
		return Result.of(null);
	}

	@PostMapping(value = "v1/task/resolve")
	@Operation(summary = "处理", description = "处理")
	public Result<?> resolve() {
		return Result.of(null);
	}

	@PostMapping(value = "v1/task/start")
	@Operation(summary = "开始", description = "开始")
	public Result<?> start() {
		return Result.of(null);
	}

	@GetMapping(value = "v1/task/diagram/{instanceId}")
	@Operation(summary = "流程图", description = "流程图")
	public Result<String> diagram(@PathVariable("instanceId") String instanceId) {
		return Result.of(null);
	}

	@PostMapping("v1/task/transfer")
	@Operation(summary = "转办", description = "转办")
	public Result<?> transfer() {
		return Result.of(null);
	}

	@PostMapping("v1/task/delegate")
	@Operation(summary = "委派", description = "委派")
	public Result<?> delegate() {
		return Result.of(null);
	}

}