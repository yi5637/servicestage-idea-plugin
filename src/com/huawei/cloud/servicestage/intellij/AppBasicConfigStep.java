package com.huawei.cloud.servicestage.intellij;

import com.intellij.ui.wizard.WizardNavigationState;
import com.intellij.ui.wizard.WizardStep;

import javax.swing.*;

public class AppBasicConfigStep extends WizardStep<ServiceStageConfigWizardModel> {
    private final ServiceStageConfigWizardModel model;
    private JPanel rootPanel;
    private JTextField appIdInput;
    private JButton resetAppIdButton;

    public AppBasicConfigStep(final String title, final ServiceStageConfigWizardModel model) {
        super(title, null);
        this.model = model;
    }

    @Override
    public JComponent prepare(WizardNavigationState wizardNavigationState) {
        rootPanel.revalidate();
        return rootPanel;
    }
}
