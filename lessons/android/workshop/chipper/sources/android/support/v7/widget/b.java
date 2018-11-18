package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer a;

    public b(ActionBarContainer actionBarContainer) {
        this.a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        if (this.a.d) {
            if (this.a.c != null) {
                drawable = this.a.c;
            }
            return;
        }
        if (this.a.a != null) {
            this.a.a.draw(canvas);
        }
        if (this.a.b != null && this.a.e) {
            drawable = this.a.b;
        }
        return;
        drawable.draw(canvas);
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.a.d) {
            if (this.a.c != null) {
                drawable = this.a.c;
            }
            return;
        }
        if (this.a.a != null) {
            drawable = this.a.a;
        }
        return;
        drawable.getOutline(outline);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
