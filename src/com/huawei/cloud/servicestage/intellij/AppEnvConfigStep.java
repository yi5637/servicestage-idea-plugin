package com.huawei.cloud.servicestage.intellij;

import com.intellij.ui.wizard.WizardNavigationState;
import com.intellij.ui.wizard.WizardStep;

import javax.swing.*;

public class AppEnvConfigStep  extends WizardStep<ServiceStageConfigWizardModel> {
    private final ServiceStageConfigWizardModel model;
    private JPanel rootPanel;

    public AppEnvConfigStep(final String title, final ServiceStageConfigWizardModel model) {
        super(title,null);
        this.model = model;
    }

    @Override
    public JComponent prepare(WizardNavigationState wizardNavigationState) {
        rootPanel.revalidate();
        return rootPanel;
    }
}
