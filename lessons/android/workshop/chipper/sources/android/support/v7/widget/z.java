package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.b;
import android.support.v4.widget.n;
import android.support.v7.a.a.j;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class z {
    private final TextView a;
    private be b;
    private be c;
    private be d;
    private be e;
    private be f;
    private be g;
    private final ab h;
    private int i = 0;
    private Typeface j;
    private boolean k;

    z(TextView textView) {
        this.a = textView;
        this.h = new ab(this.a);
    }

    private static be a(Context context, l lVar, int i) {
        ColorStateList b = lVar.b(context, i);
        if (b == null) {
            return null;
        }
        be beVar = new be();
        beVar.d = true;
        beVar.a = b;
        return beVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A:{ExcHandler: java.lang.UnsupportedOperationException (unused java.lang.UnsupportedOperationException), Splitter: B:21:0x005e} */
    /* JADX WARNING: Missing block: B:27:0x0070, code:
            if (r4.j == null) goto L_0x0072;
     */
    /* JADX WARNING: Missing block: B:28:0x0072, code:
            r5 = r6.d(r0);
     */
    /* JADX WARNING: Missing block: B:29:0x0076, code:
            if (r5 != null) goto L_0x0078;
     */
    /* JADX WARNING: Missing block: B:30:0x0078, code:
            r4.j = android.graphics.Typeface.create(r5, r4.i);
     */
    /* JADX WARNING: Missing block: B:31:0x0080, code:
            return;
     */
    private void a(android.content.Context r5, android.support.v7.widget.bg r6) {
        /*
        r4 = this;
        r0 = android.support.v7.a.a.j.TextAppearance_android_textStyle;
        r1 = r4.i;
        r0 = r6.a(r0, r1);
        r4.i = r0;
        r0 = android.support.v7.a.a.j.TextAppearance_android_fontFamily;
        r0 = r6.g(r0);
        r1 = 1;
        r2 = 0;
        if (r0 != 0) goto L_0x003c;
    L_0x0014:
        r0 = android.support.v7.a.a.j.TextAppearance_fontFamily;
        r0 = r6.g(r0);
        if (r0 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x003c;
    L_0x001d:
        r5 = android.support.v7.a.a.j.TextAppearance_android_typeface;
        r5 = r6.g(r5);
        if (r5 == 0) goto L_0x003b;
    L_0x0025:
        r4.k = r2;
        r5 = android.support.v7.a.a.j.TextAppearance_android_typeface;
        r5 = r6.a(r5, r1);
        switch(r5) {
            case 1: goto L_0x0037;
            case 2: goto L_0x0034;
            case 3: goto L_0x0031;
            default: goto L_0x0030;
        };
    L_0x0030:
        return;
    L_0x0031:
        r5 = android.graphics.Typeface.MONOSPACE;
        goto L_0x0039;
    L_0x0034:
        r5 = android.graphics.Typeface.SERIF;
        goto L_0x0039;
    L_0x0037:
        r5 = android.graphics.Typeface.SANS_SERIF;
    L_0x0039:
        r4.j = r5;
    L_0x003b:
        return;
    L_0x003c:
        r0 = 0;
        r4.j = r0;
        r0 = android.support.v7.a.a.j.TextAppearance_fontFamily;
        r0 = r6.g(r0);
        if (r0 == 0) goto L_0x004a;
    L_0x0047:
        r0 = android.support.v7.a.a.j.TextAppearance_fontFamily;
        goto L_0x004c;
    L_0x004a:
        r0 = android.support.v7.a.a.j.TextAppearance_android_fontFamily;
    L_0x004c:
        r5 = r5.isRestricted();
        if (r5 != 0) goto L_0x006e;
    L_0x0052:
        r5 = new java.lang.ref.WeakReference;
        r3 = r4.a;
        r5.<init>(r3);
        r3 = new android.support.v7.widget.z$1;
        r3.<init>(r5);
        r5 = r4.i;	 Catch:{ UnsupportedOperationException -> 0x006e, UnsupportedOperationException -> 0x006e }
        r5 = r6.a(r0, r5, r3);	 Catch:{ UnsupportedOperationException -> 0x006e, UnsupportedOperationException -> 0x006e }
        r4.j = r5;	 Catch:{ UnsupportedOperationException -> 0x006e, UnsupportedOperationException -> 0x006e }
        r5 = r4.j;	 Catch:{ UnsupportedOperationException -> 0x006e, UnsupportedOperationException -> 0x006e }
        if (r5 != 0) goto L_0x006b;
    L_0x006a:
        goto L_0x006c;
    L_0x006b:
        r1 = r2;
    L_0x006c:
        r4.k = r1;	 Catch:{ UnsupportedOperationException -> 0x006e, UnsupportedOperationException -> 0x006e }
    L_0x006e:
        r5 = r4.j;
        if (r5 != 0) goto L_0x0080;
    L_0x0072:
        r5 = r6.d(r0);
        if (r5 == 0) goto L_0x0080;
    L_0x0078:
        r6 = r4.i;
        r5 = android.graphics.Typeface.create(r5, r6);
        r4.j = r5;
    L_0x0080:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.z.a(android.content.Context, android.support.v7.widget.bg):void");
    }

    private void a(Drawable drawable, be beVar) {
        if (drawable != null && beVar != null) {
            l.a(drawable, beVar, this.a.getDrawableState());
        }
    }

    private void b(int i, float f) {
        this.h.a(i, f);
    }

    void a() {
        Drawable[] compoundDrawables;
        if (!(this.b == null && this.c == null && this.d == null && this.e == null)) {
            compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f != null || this.g != null) {
            compoundDrawables = this.a.getCompoundDrawablesRelative();
            a(compoundDrawables[0], this.f);
            a(compoundDrawables[2], this.g);
        }
    }

    void a(int i) {
        this.h.a(i);
    }

    void a(int i, float f) {
        if (!b.a && !c()) {
            b(i, f);
        }
    }

    void a(int i, int i2, int i3, int i4) {
        this.h.a(i, i2, i3, i4);
    }

    void a(Context context, int i) {
        bg a = bg.a(context, i, j.TextAppearance);
        if (a.g(j.TextAppearance_textAllCaps)) {
            a(a.a(j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.g(j.TextAppearance_android_textColor)) {
            ColorStateList e = a.e(j.TextAppearance_android_textColor);
            if (e != null) {
                this.a.setTextColor(e);
            }
        }
        if (a.g(j.TextAppearance_android_textSize) && a.e(j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        a(context, a);
        a.a();
        if (this.j != null) {
            this.a.setTypeface(this.j, this.i);
        }
    }

    @SuppressLint({"NewApi"})
    void a(AttributeSet attributeSet, int i) {
        bg a;
        boolean z;
        boolean z2;
        ColorStateList e;
        ColorStateList e2;
        AttributeSet attributeSet2 = attributeSet;
        int i2 = i;
        Context context = this.a.getContext();
        l a2 = l.a();
        bg a3 = bg.a(context, attributeSet2, j.AppCompatTextHelper, i2, 0);
        int g = a3.g(j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(j.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(j.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (VERSION.SDK_INT >= 17) {
            if (a3.g(j.AppCompatTextHelper_android_drawableStart)) {
                this.f = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(j.AppCompatTextHelper_android_drawableEnd)) {
                this.g = a(context, a2, a3.g(j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        if (g != -1) {
            a = bg.a(context, g, j.TextAppearance);
            if (z3 || !a.g(j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = z;
            } else {
                z2 = a.a(j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a);
            if (VERSION.SDK_INT < 23) {
                e = a.g(j.TextAppearance_android_textColor) ? a.e(j.TextAppearance_android_textColor) : null;
                e2 = a.g(j.TextAppearance_android_textColorHint) ? a.e(j.TextAppearance_android_textColorHint) : null;
                if (a.g(j.TextAppearance_android_textColorLink)) {
                    colorStateList = a.e(j.TextAppearance_android_textColorLink);
                }
                ColorStateList colorStateList2 = e;
                e = colorStateList;
                colorStateList = colorStateList2;
            } else {
                e = null;
                e2 = e;
            }
            a.a();
        } else {
            z = false;
            z2 = z;
            e = null;
            e2 = e;
        }
        a = bg.a(context, attributeSet2, j.TextAppearance, i2, 0);
        if (!z3 && a.g(j.TextAppearance_textAllCaps)) {
            z2 = a.a(j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (VERSION.SDK_INT < 23) {
            if (a.g(j.TextAppearance_android_textColor)) {
                colorStateList = a.e(j.TextAppearance_android_textColor);
            }
            if (a.g(j.TextAppearance_android_textColorHint)) {
                e2 = a.e(j.TextAppearance_android_textColorHint);
            }
            if (a.g(j.TextAppearance_android_textColorLink)) {
                e = a.e(j.TextAppearance_android_textColorLink);
            }
        }
        if (VERSION.SDK_INT >= 28 && a.g(j.TextAppearance_android_textSize) && a.e(j.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        a(context, a);
        a.a();
        if (colorStateList != null) {
            this.a.setTextColor(colorStateList);
        }
        if (e2 != null) {
            this.a.setHintTextColor(e2);
        }
        if (e != null) {
            this.a.setLinkTextColor(e);
        }
        if (!z3 && r11) {
            a(z2);
        }
        if (this.j != null) {
            this.a.setTypeface(this.j, this.i);
        }
        this.h.a(attributeSet2, i2);
        if (b.a && this.h.a() != 0) {
            int[] e3 = this.h.e();
            if (e3.length > 0) {
                if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.h.c(), this.h.d(), this.h.b(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(e3, 0);
                }
            }
        }
        bg a4 = bg.a(context, attributeSet2, j.AppCompatTextView);
        i2 = a4.e(j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int e4 = a4.e(j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int e5 = a4.e(j.AppCompatTextView_lineHeight, -1);
        a4.a();
        if (i2 != -1) {
            n.b(this.a, i2);
        }
        if (e4 != -1) {
            n.c(this.a, e4);
        }
        if (e5 != -1) {
            n.d(this.a, e5);
        }
    }

    void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.i);
            }
        }
    }

    void a(boolean z) {
        this.a.setAllCaps(z);
    }

    void a(boolean z, int i, int i2, int i3, int i4) {
        if (!b.a) {
            b();
        }
    }

    void a(int[] iArr, int i) {
        this.h.a(iArr, i);
    }

    void b() {
        this.h.f();
    }

    boolean c() {
        return this.h.g();
    }

    int d() {
        return this.h.a();
    }

    int e() {
        return this.h.b();
    }

    int f() {
        return this.h.c();
    }

    int g() {
        return this.h.d();
    }

    int[] h() {
        return this.h.e();
    }
}
