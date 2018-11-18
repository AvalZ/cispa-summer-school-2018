package android.support.v7.widget;

import android.content.Context;
import android.support.v4.widget.n;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class j extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private final z b;

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(bd.a(context), attributeSet, i);
        this.b = new z(this);
        this.b.a(attributeSet, i);
        this.b.a();
        bg a = bg.a(getContext(), attributeSet, a, i, 0);
        setCheckMarkDrawable(a.a(0));
        a.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return n.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.b(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(n.a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.b != null) {
            this.b.a(context, i);
        }
    }
}
