package com.huawei.cloud.servicestage.intellij;

import com.intellij.ui.wizard.WizardNavigationState;
import com.intellij.ui.wizard.WizardStep;

import javax.swing.*;

public class AppServiceConfigStep extends WizardStep<ServiceStageConfigWizardModel> {
    private final ServiceStageConfigWizardModel model;
    private JPanel rootPanel;
    private JTextField dcsInstanceInput;

    public AppServiceConfigStep(final String title, final ServiceStageConfigWizardModel model) {
        super(title, null);
        this.model = model;
    }

    @Override
    public JComponent prepare(WizardNavigationState wizardNavigationState) {
        rootPanel.revalidate();
        return rootPanel;
    }
}
