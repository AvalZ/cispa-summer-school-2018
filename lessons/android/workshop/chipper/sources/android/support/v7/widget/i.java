package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.o;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class i extends CheckBox implements o {
    private final k a;

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(bd.a(context), attributeSet, i);
        this.a = new k(this);
        this.a.a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.a != null ? this.a.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.a != null ? this.a.a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.a != null ? this.a.b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(android.support.v7.b.a.a.b(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            this.a.a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.a != null) {
            this.a.a(mode);
        }
    }
}
