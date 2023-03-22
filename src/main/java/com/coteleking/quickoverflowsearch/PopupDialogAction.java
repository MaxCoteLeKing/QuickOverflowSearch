package com.coteleking.quickoverflowsearch;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;


public class PopupDialogAction extends AnAction {

    public PopupDialogAction() throws IOException {
        super();
    }


    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String stackOverflow = "https://stackoverflow.com/search?q=";
        CaretModel caretModel = e.getData(LangDataKeys.EDITOR).getCaretModel();
        Caret currentCaret =
                caretModel.getCurrentCaret();
        String selectedText = currentCaret.getSelectedText().trim();
        try {
            selectedText = selectedText.replaceAll(" ", "+");
        } catch (NullPointerException ex) {
            System.out.print("Text can't be empty" + ex.getMessage());
        }

        if (StringUtils.isNotBlank(selectedText)) {
            BrowserUtil.browse(stackOverflow + selectedText);
        } else {
            BrowserUtil.browse(stackOverflow);
        }
    }
}