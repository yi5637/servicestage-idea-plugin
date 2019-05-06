package com.huawei.cloud.servicestage.intellij.setting;

import com.huawei.cloud.servicestage.intellij.model.SettingModel;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "ServiceStageSetting", storages = {@Storage("ServiceStageSetting.xml")})
public class SettingState implements PersistentStateComponent<SettingState> {

    /**
     * data
     */
    private SettingModel settingModel = new SettingModel();

    public SettingState() {
    }

    public static SettingState getInstance() {
        return ServiceManager.getService(SettingState.class);
    }

    @Nullable
    @Override
    public SettingState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SettingState settingState) {
        XmlSerializerUtil.copyBean(settingState, this);
    }

    @Override
    public void noStateLoaded() {

    }

    public SettingModel getSettingModel() {
        return settingModel;
    }

    public void setSettingModel(SettingModel settingModel) {
        this.settingModel = settingModel;
    }

}
