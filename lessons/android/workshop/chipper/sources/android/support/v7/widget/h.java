package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.h.q;
import android.support.v4.widget.b;
import android.support.v4.widget.n;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class h extends Button implements q, b {
    private final g b;
    private final z c;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(bd.a(context), attributeSet, i);
        this.b = new g(this);
        this.b.a(attributeSet, i);
        this.c = new z(this);
        this.c.a(attributeSet, i);
        this.c.a();
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

    public ColorStateList getSupportBackgroundTintList() {
        return this.b != null ? this.b.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.b != null ? this.b.b() : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.c != null) {
            this.c.a(z, i, i2, i3, i4);
        }
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

    public void setSupportAllCaps(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
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
