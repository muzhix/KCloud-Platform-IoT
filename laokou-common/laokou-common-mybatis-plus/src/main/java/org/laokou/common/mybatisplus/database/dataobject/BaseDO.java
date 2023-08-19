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
package org.laokou.common.mybatisplus.database.dataobject;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.laokou.common.i18n.dto.DTO;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * @author laokou
 */
@Data
@Schema(name = "BaseDO", description = "数据映射基类")
public abstract class BaseDO extends DTO {

	@Serial
	private static final long serialVersionUID = -5855413730985647400L;

	@TableId(type = IdType.AUTO)
	@Schema(name = "id", description = "ID")
	private Long id;

	@Schema(name = "creator", description = "创建人")
	@TableField(fill = FieldFill.INSERT)
	private Long creator;

	@Schema(name = "editor", description = "修改人")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Long editor;

	@Schema(name = "createDate", description = "创建时间")
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createDate;

	@Schema(name = "updateDate", description = "修改时间")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateDate;

	@Schema(name = "delFlag", description = "删除标识 0未删除 1已删除")
	@TableField(fill = FieldFill.INSERT)
	@TableLogic
	private Integer delFlag;

	@Version
	@Schema(name = "version", description = "版本号")
	@TableField(fill = FieldFill.INSERT)
	private Integer version;

}