package com.huawei.cloud.servicestage.intellij;

import com.huawei.cloud.servicestage.client.Token;
import com.huawei.cloud.servicestage.intellij.model.SettingModel;
import com.huawei.cloud.servicestage.intellij.setting.SettingState;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.messages.MessageDialog;

import javax.swing.*;
import java.util.Map;

public class ServiceStageSettingForm {
    private static final Logger LOGGER = Logger.getInstance(ServiceStageSettingForm.class);

    private JPanel rootPanel;
    private JTextField usernameText;
    private JTextField domainText;
    private JLabel titleLable;
    private JLabel regionLable;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel domainLabel;
    private JPasswordField passwordField;
    private JButton testConnectionButton;
    private JButton resetTokenButton;
    private JComboBox regionComboBox;

    /**
     * PersistentStateComponent
     */
    private SettingState settingState;

    public ServiceStageSettingForm() {
        testConnectionButton.addActionListener(event -> {
            try {
                String regionText = String.valueOf(regionComboBox.getSelectedItem());
                String region = RequestManager.getInstance().getRegions().get(regionText);
                String username = usernameText.getText();
                String password = String.valueOf(passwordField.getPassword());
                String domain = domainText.getText();

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
        regions.keySet().forEach(el -> regionComboBox.addItem(el));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isModified() {
        SettingModel sm = settingState.getSettingModel();
        return sm == null || sm.isModified(String.valueOf(regionComboBox.getSelectedItem()),
                domainText.getText(), usernameText.getText(), String.valueOf(passwordField.getPassword()));
    }

    public void apply() {
        SettingModel sm = new SettingModel(String.valueOf(regionComboBox.getSelectedItem()), domainText.getText(),
                usernameText.getText(), String.valueOf(passwordField.getPassword()));
        settingState.setSettingModel(sm);
        LOGGER.info("---- " + sm);
    }

    public void reset() {
        SettingModel sm = settingState.getSettingModel();
        LOGGER.info("---- " + sm);
        if (sm != null) {
            regionComboBox.setSelectedItem(sm.getRegionText());
            domainText.setText(sm.getDomain());
            usernameText.setText(sm.getUsername());
            passwordField.setText(sm.getPassword());
        }
    }
}
