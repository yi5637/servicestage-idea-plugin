package com.huawei.cloud.servicestage.intellij;

import com.huawei.cloud.servicestage.client.Token;
import com.huawei.cloud.servicestage.intellij.setting.SettingState;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.Messages;

import javax.swing.*;
import java.util.Map;

/**
 * ServiceStage setting form
 */
public class ServiceStageSettingForm {
    private static final Logger LOGGER = Logger.getInstance(ServiceStageSettingForm.class);

    private JPanel rootPanel;
    private JTextField usernameInput;
    private JTextField domainInput;
    private JPasswordField passwordInput;
    private JButton testConnectionButton;
    private JButton resetTokenButton;
    private JComboBox regionSelector;

    /**
     * PersistentStateComponent
     */
    private SettingState settingState;

    public ServiceStageSettingForm() {
        testConnectionButton.addActionListener(event -> {
            try {
                String regionText = String.valueOf(regionSelector.getSelectedItem());
                String region = RequestManager.getInstance().getRegions().get(regionText);
                String username = usernameInput.getText();
                String password = String.valueOf(passwordInput.getPassword());
                String domain = domainInput.getText();

                Token token = RequestManager.getInstance().getAuthToken(true, false,
                        region, username, password, domain);
                if (token != null) {
                    Messages.showInfoMessage("Test Connection Success!", "Test Connection");
                } else {
                    throw new Exception("Invalid Token");
                }
            } catch (Exception e) {
                LOGGER.error(e);
                Messages.showWarningDialog("Test Connection Failed!", "Test Connection");
                //pop up error dialog here
            }
        });
        resetTokenButton.addActionListener(event -> {
            Messages.showInfoMessage("Reset Token Success!", "Reset Token");
        });
    }

    public void createUI() {
        settingState = SettingState.getInstance();
        Map<String, String> regions = RequestManager.getInstance().getRegions();
        regions.keySet().forEach(el -> regionSelector.addItem(el));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isModified() {
        return settingState == null || settingState.isModified(String.valueOf(regionSelector.getSelectedItem()),
                domainInput.getText(), usernameInput.getText(), String.valueOf(passwordInput.getPassword()));
    }

    public void apply() {
        settingState.updateValue(String.valueOf(regionSelector.getSelectedItem()), domainInput.getText(),
                usernameInput.getText(), String.valueOf(passwordInput.getPassword()));
        LOGGER.info("---- " + settingState);
    }

    public void reset() {
        LOGGER.info("---- " + settingState);
        if (settingState != null) {
            regionSelector.setSelectedItem(settingState.getRegionText());
            domainInput.setText(settingState.getDomain());
            usernameInput.setText(settingState.getUsername());
            passwordInput.setText(settingState.getPassword());
        }
    }
}
