package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.f.b.a;
import android.support.v4.h.q;
import android.support.v4.widget.b;
import android.support.v4.widget.n;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.Future;

public class aa extends TextView implements q, b {
    private final g b;
    private final z c;
    private Future<android.support.v4.f.b> d;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(bd.a(context), attributeSet, i);
        this.b = new g(this);
        this.b.a(attributeSet, i);
        this.c = new z(this);
        this.c.a(attributeSet, i);
        this.c.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0012 A:{RETURN, ExcHandler: java.lang.InterruptedException (unused java.lang.InterruptedException), Splitter: B:2:0x0004} */
    /* JADX WARNING: Missing block: B:4:0x0012, code:
            return;
     */
    private void a() {
        /*
        r2 = this;
        r0 = r2.d;
        if (r0 == 0) goto L_0x0012;
    L_0x0004:
        r0 = r2.d;	 Catch:{ InterruptedException -> 0x0012, InterruptedException -> 0x0012 }
        r1 = 0;
        r2.d = r1;	 Catch:{ InterruptedException -> 0x0012, InterruptedException -> 0x0012 }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x0012, InterruptedException -> 0x0012 }
        r0 = (android.support.v4.f.b) r0;	 Catch:{ InterruptedException -> 0x0012, InterruptedException -> 0x0012 }
        android.support.v4.widget.n.a(r2, r0);	 Catch:{ InterruptedException -> 0x0012, InterruptedException -> 0x0012 }
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aa.a():void");
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    public int getAutoSizeMaxTextSize() {
        return a ? super.getAutoSizeMaxTextSize() : this.c != null ? this.c.g() : -1;
    }

    public int getAutoSizeMinTextSize() {
        return a ? super.getAutoSizeMinTextSize() : this.c != null ? this.c.f() : -1;
    }

    public int getAutoSizeStepGranularity() {
        return a ? super.getAutoSizeStepGranularity() : this.c != null ? this.c.e() : -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return a ? super.getAutoSizeTextAvailableSizes() : this.c != null ? this.c.h() : new int[0];
    }

    public int getAutoSizeTextType() {
        return a ? super.getAutoSizeTextType() == 1 ? 1 : 0 : this.c != null ? this.c.d() : 0;
    }

    public int getFirstBaselineToTopHeight() {
        return n.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return n.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    public CharSequence getText() {
        a();
        return super.getText();
    }

    public a getTextMetricsParamsCompat() {
        return n.d(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return n.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null) {
            this.c.a(z, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        a();
        super.onMeasure(i, i2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.c != null && !a && this.c.c()) {
            this.c.b();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        if (this.c != null) {
            this.c.a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        if (this.c != null) {
            this.c.a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b != null) {
            this.b.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.b != null) {
            this.b.a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(n.a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            n.b(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            n.c(this, i);
        }
    }

    public void setLineHeight(int i) {
        n.d(this, i);
    }

    public void setPrecomputedText(android.support.v4.f.b bVar) {
        n.a((TextView) this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            this.b.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.b != null) {
            this.b.a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.c != null) {
            this.c.a(context, i);
        }
    }

    public void setTextFuture(Future<android.support.v4.f.b> future) {
        this.d = future;
        requestLayout();
    }

    public void setTextMetricsParamsCompat(a aVar) {
        n.a((TextView) this, aVar);
    }

    public void setTextSize(int i, float f) {
        if (a) {
            super.setTextSize(i, f);
            return;
        }
        if (this.c != null) {
            this.c.a(i, f);
        }
    }
}
