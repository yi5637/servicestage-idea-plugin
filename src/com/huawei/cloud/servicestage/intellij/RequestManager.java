/**
 * Copyright 2016 - 2018 Huawei Technologies Co., Ltd. All rights reserved.
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
package com.huawei.cloud.servicestage.intellij;

import com.intellij.openapi.diagnostic.Logger;

import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RequestManager {

    private static final Logger LOGGER = Logger.getInstance(RequestManager.class);

    private static RequestManager instance = null;

    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyyMMddHHmmss");

    // cached
    private Map<String, String> appTShirtSizes = null;

    private Map<String, String> applicationTypes = null;

    private Map<String, String> regions = null;

    private Map<String, String> elbs = null;

    private Map<String, String> vpcs = null;

    private Map<String, String> dcsInstances = null;

    private Map<String, String> rdsInstances = null;

    private Map<String, String> ccseClusters = null;

    private Set<String> swrNamespaces = null;

    private RequestManager() {
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            instance = new RequestManager();
        }
        return instance;
    }

    public Map<String, String> getRegions() {
        if (this.regions == null) {
            // hard code regions for now
            this.regions = new LinkedHashMap<>();
            this.regions.put("CN North-Beijing1", "cn-north-1");
            this.regions.put("CN North-Beijing4", "cn-north-4");
            this.regions.put("CN Northeast-DaLian", "cn-northeast-1");
            this.regions.put("CN East-Shanghai2", "cn-east-2");
            this.regions.put("CN South-Guangzhou", "cn-south-1");
            this.regions.put("AP-Hong Kong", "ap-southeast-1");
            // this.regions = HuaweiCloudClient.getRegions(getAuthToken());
        }

        return this.regions;
    }

}
