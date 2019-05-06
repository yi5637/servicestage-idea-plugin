package com.huawei.cloud.servicestage.intellij;

import com.intellij.ui.wizard.WizardDialog;

import java.awt.*;

public class ServiceStageConfigWizard extends WizardDialog<ServiceStageConfigWizardModel> {

    public ServiceStageConfigWizard() {
        super(true, true, new ServiceStageConfigWizardModel());
    }

    public static void run() {
        new ServiceStageConfigWizard().show();
    }

    @Override
    protected Dimension getWindowPreferredSize() {
        return new Dimension(600, 350);
    }
}
