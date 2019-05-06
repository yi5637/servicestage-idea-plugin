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

import com.huawei.cloud.servicestage.client.AuthClient;
import com.huawei.cloud.servicestage.client.Token;
import com.huawei.cloud.servicestage.intellij.model.SettingModel;
import com.huawei.cloud.servicestage.intellij.setting.SettingState;
import com.intellij.openapi.diagnostic.Logger;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
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


    public Token getAuthToken() throws IOException {
        return getAuthToken(false);
    }

    public Token getAuthToken(boolean forceNewToken) throws IOException {
        SettingModel sm = SettingState.getInstance().getSettingModel();
        return getAuthToken(forceNewToken, false, sm.getRegion(), sm.getUsername(), sm.getPassword(), sm.getDomain());
    }

    public Token getAuthToken(boolean forceNewToken, boolean testConnection, String region, String username, String password, String domain) throws IOException {
        SettingModel sm = SettingState.getInstance().getSettingModel();
        // get existing token, if any
        String tokenStr = sm.getTokenContent();

        Token token = null;

        // token found in store
        if (tokenStr != null && !tokenStr.isEmpty() && !forceNewToken) {
            Token t = Token.fromString(tokenStr);

            // check if token is valid and not expired
            if (t.getUsername().equals(username) && t.getRegion().equals(region)
                    && !t.isExpired()) {
                token = t;
            }
        }

        // no valid token found
        if (token == null) {
            LOGGER.info("No valid token found, getting new token");
            token = AuthClient.getAuthToken(region, username, password,
                    StringUtils.isEmpty(domain) ? username : domain);
            if (!testConnection) { // only save to preference when user apply changes in preference page
                LOGGER.info("Apply new token to preference store");
                sm.setTokenContent(token.toString());
            }
        }

        return token;
    }

}
