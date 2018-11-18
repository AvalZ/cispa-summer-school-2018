package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.a;

class c extends Drawable {
    final Paint a = new Paint(1);
    final Rect b = new Rect();
    final RectF c = new RectF();
    float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private ColorStateList i;
    private int j;
    private boolean k = true;
    private float l;

    public c() {
        this.a.setStyle(Style.STROKE);
    }

    private Shader a() {
        Rect rect = this.b;
        copyBounds(rect);
        float height = this.d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{a.a(this.e, this.j), a.a(this.f, this.j), a.a(a.b(this.f, 0), this.j), a.a(a.b(this.h, 0), this.j), a.a(this.h, this.j), a.a(this.g, this.j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    void a(float f) {
        if (this.d != f) {
            this.d = f;
            this.a.setStrokeWidth(f * 1.3333f);
            this.k = true;
            invalidateSelf();
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.j = colorStateList.getColorForState(getState(), this.j);
        }
        this.i = colorStateList;
        this.k = true;
        invalidateSelf();
    }

    final void b(float f) {
        if (f != this.l) {
            this.l = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.k) {
            this.a.setShader(a());
            this.k = false;
        }
        float strokeWidth = this.a.getStrokeWidth() / 2.0f;
        RectF rectF = this.c;
        copyBounds(this.b);
        rectF.set(this.b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.i != null && this.i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.i != null) {
            int colorForState = this.i.getColorForState(iArr, this.j);
            if (colorForState != this.j) {
                this.k = true;
                this.j = colorForState;
            }
        }
        if (this.k) {
            invalidateSelf();
        }
        return this.k;
    }

    public void setAlpha(int i) {
        this.a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
