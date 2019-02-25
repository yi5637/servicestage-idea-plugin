package com.huawei.cloud;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ProjectAction extends AnAction {

    private Project project;

    @Override
    public void actionPerformed(AnActionEvent e) {
        project = e.getData(PlatformDataKeys.PROJECT);
        DataContext dataContext = e.getDataContext();
        if (!("jar".equals(getFileExtension(dataContext))
                || "war".equals(getFileExtension(dataContext)))) {
            VirtualFile file = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
            Messages.showMessageDialog(
                    project,
                    "Please select correct file ",
                    "WARNING",
                    Messages.getWarningIcon()
            );
            return;
        }

        // deploy
    }



    public  static  String getFileExtension(DataContext dataContext){
        VirtualFile file = DataKeys.VIRTUAL_FILE.getData(dataContext);
        return file == null ? null : file.getExtension();
    }
}
