package android.support.c.a;

import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.a;
import android.support.v4.graphics.drawable.b;

abstract class h extends Drawable implements b {
    Drawable c;

    h() {
    }

    public void applyTheme(Theme theme) {
        if (this.c != null) {
            a.a(this.c, theme);
        }
    }

    public void clearColorFilter() {
        if (this.c != null) {
            this.c.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        return this.c != null ? a.e(this.c) : null;
    }

    public Drawable getCurrent() {
        return this.c != null ? this.c.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        return this.c != null ? this.c.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.c != null ? this.c.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.c != null ? this.c.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.c != null ? this.c.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.c != null ? this.c.getTransparentRegion() : super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        if (this.c != null) {
            a.a(this.c);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.c != null ? this.c.setLevel(i) : super.onLevelChange(i);
    }

    public void setChangingConfigurations(int i) {
        if (this.c != null) {
            this.c.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.c != null) {
            this.c.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.c != null) {
            this.c.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.c != null) {
            a.a(this.c, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.c != null) {
            a.a(this.c, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.c != null ? this.c.setState(iArr) : super.setState(iArr);
    }
}
