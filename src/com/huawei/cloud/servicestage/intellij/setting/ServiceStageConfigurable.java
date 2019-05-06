package com.huawei.cloud.servicestage.intellij.setting;

import com.huawei.cloud.servicestage.intellij.ServiceStageSettingForm;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * ServiceStage setting configuration
 */
public class ServiceStageConfigurable implements Configurable {

    private ServiceStageSettingForm mGUI;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "ServiceStage";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mGUI = new ServiceStageSettingForm();
        mGUI.createUI();
        return mGUI.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return mGUI != null && mGUI.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        if (mGUI != null) {
            mGUI.apply();
        }
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Override
    public void reset() {
        if (mGUI != null) {
            mGUI.reset();
        }
    }

    @Override
    public void disposeUIResources() {
        mGUI = null;
    }
}
