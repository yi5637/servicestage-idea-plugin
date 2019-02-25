package com.huawei.cloud;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.apache.log4j.Logger;

public class ServiceStageStatusAction extends AnAction {
    private static Logger logger=Logger.getLogger(ServiceStageStatusAction.class);

    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            Messages.showMessageDialog(
                    "You must first select the project",
                    "WARNNING",
                    Messages.getWarningIcon()
            );
            return;

        }
        logger.trace(project.getName());


    }
}