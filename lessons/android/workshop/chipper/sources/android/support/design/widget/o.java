package android.support.design.widget;

import android.support.v7.widget.bp;
import android.support.v7.widget.m;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class o extends m {
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof bp) {
                    editorInfo.hintText = ((bp) parent).getHint();
                    return onCreateInputConnection;
                }
            }
        }
        return onCreateInputConnection;
    }
}
