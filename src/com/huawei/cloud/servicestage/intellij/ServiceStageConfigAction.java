package com.huawei.cloud.servicestage.intellij;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;


public class ServiceStageConfigAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
//        Project project = e.getProject();
//        ResourceBundle resources = ResourceBundle.getBundle("resources");
//        Enumeration<String> keys = resources.getKeys();
//        String string = resources.getString("wizard.srcPage.swrRepoError");
//
//
//        if (project == null) {
//            Messages.showMessageDialog(
//                    "You must first select the project",
//                    "WARNNING",
//                    Messages.getWarningIcon()
//            );
//            return;
//        }
//
//        PropertiesComponent instance = PropertiesComponent.getInstance();
//        String value = instance.getValue("");
//
//        String[] str={};
//        Messages.showEditableChooseDialog(
//                "Config you project",
//                "deploy",
//               Messages.getQuestionIcon(),
//                str,
//                "dsd",
//                null
//
//        );
//        Messages.getWarningIcon();
//        new String();
        ServiceStageConfigWizard.run();
    }
}
