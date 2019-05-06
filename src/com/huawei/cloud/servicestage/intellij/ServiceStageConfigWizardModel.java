package com.huawei.cloud.servicestage.intellij;

import com.intellij.ui.wizard.WizardModel;

public class ServiceStageConfigWizardModel extends WizardModel {

    public ServiceStageConfigWizardModel() {
        super("ServiceStage application configuration");
        initSteps();
    }

    private void initSteps() {
        add(new AppBasicConfigStep("Describe your application", this));
        add(new AppServiceConfigStep("Additional services", this));
        add(new AppEnvConfigStep("Environment Variables", this));
    }
}
