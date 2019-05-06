package com.huawei.cloud.servicestage.intellij;

import org.ini4j.Config;
import org.ini4j.Configurable;

public class SettingsComponent implements Configurable {


    @Override
    public Config getConfig() {
        Config global = Config.getGlobal();
        global.setGlobalSectionName("ServiceStage");
        return global;
    }

    @Override
    public void setConfig(Config config) {

    }
}
