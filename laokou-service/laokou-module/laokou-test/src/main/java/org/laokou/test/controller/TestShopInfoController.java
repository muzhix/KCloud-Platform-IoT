/**
 * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laokou.test.controller;

import lombok.RequiredArgsConstructor;
import org.laokou.common.i18n.core.HttpResult;
import org.laokou.test.entity.Shop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laokou
 */
@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class TestShopInfoController {

//    private final ShopMapper shopMapper;

    @GetMapping
    public HttpResult<Shop> get() {
        // 因节约时间，故在controller
//        return new HttpResult<Shop>().ok(shopMapper.selectOne(Wrappers.query()));
        return null;
    }

}
