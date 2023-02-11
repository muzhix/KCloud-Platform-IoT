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
package org.laokou.admin.client.vo;

import lombok.Data;

/**
 * @author laokou
 * @version 1.0
 * @date 2022/8/19 0019 下午 3:45
 */
@Data
public class SysResourceVO {

    private Long id;
    private String title;
    private String url;
    private Integer status;
    private String code;
    private String remark;
    private String processInstanceId;

}
