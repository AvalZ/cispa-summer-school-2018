package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.a.a.j;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ab {
    private static final RectF a = new RectF();
    private static ConcurrentHashMap<String, Method> b = new ConcurrentHashMap();
    private int c = 0;
    private boolean d = false;
    private float e = -1.0f;
    private float f = -1.0f;
    private float g = -1.0f;
    private int[] h = new int[0];
    private boolean i = false;
    private TextPaint j;
    private final TextView k;
    private final Context l;

    ab(TextView textView) {
        this.k = textView;
        this.l = this.k.getContext();
    }

    private int a(RectF rectF) {
        int length = this.h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = 0;
        int i2 = 1;
        length--;
        while (true) {
            int i3 = i2;
            i2 = i;
            i = i3;
            while (i <= length) {
                i2 = (i + length) / 2;
                if (a(this.h[i2], rectF)) {
                    i2++;
                } else {
                    i2--;
                    length = i2;
                }
            }
            return this.h[i2];
        }
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.k.getLineSpacingMultiplier();
            lineSpacingExtra = this.k.getLineSpacingExtra();
            includeFontPadding = this.k.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) a(this.k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) a(this.k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) a(this.k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
        }
        return new StaticLayout(charSequence, this.j, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    private StaticLayout a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        Builder hyphenationFrequency = Builder.obtain(charSequence, 0, charSequence.length(), this.j, i).setAlignment(alignment).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    private <T> T a(Object obj, String str, T t) {
        try {
            return a(str).invoke(obj, new Object[0]);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke TextView#");
            stringBuilder.append(str);
            stringBuilder.append("() method");
            Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), e);
            return t;
        }
    }

    private Method a(String str) {
        try {
            Method method = (Method) b.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    b.put(str, method);
                }
            }
            return method;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to retrieve TextView#");
            stringBuilder.append(str);
            stringBuilder.append("() method");
            Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), e);
            return null;
        }
    }

    private void a(float f) {
        if (f != this.k.getPaint().getTextSize()) {
            this.k.getPaint().setTextSize(f);
            boolean isInLayout = VERSION.SDK_INT >= 18 ? this.k.isInLayout() : false;
            if (this.k.getLayout() != null) {
                this.d = false;
                try {
                    Method a = a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.k, new Object[0]);
                    }
                } catch (Throwable e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (isInLayout) {
                    this.k.forceLayout();
                } else {
                    this.k.requestLayout();
                }
                this.k.invalidate();
            }
        }
    }

    private void a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Minimum auto-size text size (");
            stringBuilder.append(f);
            stringBuilder.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f2 <= f) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Maximum auto-size text size (");
            stringBuilder2.append(f2);
            stringBuilder2.append("px) is less or equal to minimum auto-size ");
            stringBuilder2.append("text size (");
            stringBuilder2.append(f);
            stringBuilder2.append("px)");
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else if (f3 <= 0.0f) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("The auto-size step granularity (");
            stringBuilder3.append(f3);
            stringBuilder3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(stringBuilder3.toString());
        } else {
            this.c = 1;
            this.f = f;
            this.g = f2;
            this.e = f3;
            this.i = false;
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.h = a(iArr);
            h();
        }
    }

    /* JADX WARNING: Missing block: B:23:0x0088, code:
            return false;
     */
    private boolean a(int r6, android.graphics.RectF r7) {
        /*
        r5 = this;
        r0 = r5.k;
        r0 = r0.getText();
        r1 = r5.k;
        r1 = r1.getTransformationMethod();
        if (r1 == 0) goto L_0x0017;
    L_0x000e:
        r2 = r5.k;
        r1 = r1.getTransformation(r0, r2);
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 16;
        r3 = -1;
        if (r1 < r2) goto L_0x0025;
    L_0x001e:
        r1 = r5.k;
        r1 = r1.getMaxLines();
        goto L_0x0026;
    L_0x0025:
        r1 = r3;
    L_0x0026:
        r2 = r5.j;
        if (r2 != 0) goto L_0x0032;
    L_0x002a:
        r2 = new android.text.TextPaint;
        r2.<init>();
        r5.j = r2;
        goto L_0x0037;
    L_0x0032:
        r2 = r5.j;
        r2.reset();
    L_0x0037:
        r2 = r5.j;
        r4 = r5.k;
        r4 = r4.getPaint();
        r2.set(r4);
        r2 = r5.j;
        r6 = (float) r6;
        r2.setTextSize(r6);
        r6 = r5.k;
        r2 = "getLayoutAlignment";
        r4 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r6 = r5.a(r6, r2, r4);
        r6 = (android.text.Layout.Alignment) r6;
        r2 = android.os.Build.VERSION.SDK_INT;
        r4 = 23;
        if (r2 < r4) goto L_0x0065;
    L_0x005a:
        r2 = r7.right;
        r2 = java.lang.Math.round(r2);
        r5 = r5.a(r0, r6, r2, r1);
        goto L_0x006f;
    L_0x0065:
        r2 = r7.right;
        r2 = java.lang.Math.round(r2);
        r5 = r5.a(r0, r6, r2);
    L_0x006f:
        r6 = 0;
        r2 = 1;
        if (r1 == r3) goto L_0x0089;
    L_0x0073:
        r3 = r5.getLineCount();
        if (r3 > r1) goto L_0x0088;
    L_0x0079:
        r1 = r5.getLineCount();
        r1 = r1 - r2;
        r1 = r5.getLineEnd(r1);
        r0 = r0.length();
        if (r1 == r0) goto L_0x0089;
    L_0x0088:
        return r6;
    L_0x0089:
        r5 = r5.getHeight();
        r5 = (float) r5;
        r7 = r7.bottom;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 <= 0) goto L_0x0095;
    L_0x0094:
        return r6;
    L_0x0095:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ab.a(int, android.graphics.RectF):boolean");
    }

    private int[] a(int[] iArr) {
        int size;
        if (size == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        List arrayList = new ArrayList();
        int i = 0;
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (size == arrayList.size()) {
            return iArr;
        }
        size = arrayList.size();
        iArr = new int[size];
        while (i < size) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
            i++;
        }
        return iArr;
    }

    private boolean h() {
        int length = this.h.length;
        this.i = length > 0;
        if (this.i) {
            this.c = 1;
            this.f = (float) this.h[0];
            this.g = (float) this.h[length - 1];
            this.e = -1.0f;
        }
        return this.i;
    }

    private boolean i() {
        int i = 0;
        if (k() && this.c == 1) {
            if (!this.i || this.h.length == 0) {
                float round = (float) Math.round(this.f);
                int i2 = 1;
                while (Math.round(this.e + round) <= Math.round(this.g)) {
                    i2++;
                    round += this.e;
                }
                int[] iArr = new int[i2];
                float f = this.f;
                while (i < i2) {
                    iArr[i] = Math.round(f);
                    f += this.e;
                    i++;
                }
                this.h = a(iArr);
            }
            this.d = true;
        } else {
            this.d = false;
        }
        return this.d;
    }

    private void j() {
        this.c = 0;
        this.f = -1.0f;
        this.g = -1.0f;
        this.e = -1.0f;
        this.h = new int[0];
        this.d = false;
    }

    private boolean k() {
        return !(this.k instanceof m);
    }

    int a() {
        return this.c;
    }

    void a(int i) {
        if (k()) {
            switch (i) {
                case 0:
                    j();
                    break;
                case 1:
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (i()) {
                        f();
                        return;
                    }
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown auto-size text type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    void a(int i, float f) {
        a(TypedValue.applyDimension(i, f, (this.l == null ? Resources.getSystem() : this.l.getResources()).getDisplayMetrics()));
    }

    void a(int i, int i2, int i3, int i4) {
        if (k()) {
            DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (i()) {
                f();
            }
        }
    }

    void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.l.obtainStyledAttributes(attributeSet, j.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            this.c = obtainStyledAttributes.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = obtainStyledAttributes.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
                a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (!k()) {
            this.c = 0;
        } else if (this.c == 1) {
            if (!this.i) {
                DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    void a(int[] iArr, int i) {
        if (k()) {
            int length = iArr.length;
            int i2 = 0;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.l.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.h = a(iArr2);
                if (!h()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("None of the preset sizes is valid: ");
                    stringBuilder.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.i = false;
            if (i()) {
                f();
            }
        }
    }

    int b() {
        return Math.round(this.e);
    }

    int c() {
        return Math.round(this.f);
    }

    int d() {
        return Math.round(this.g);
    }

    int[] e() {
        return this.h;
    }

    /* JADX WARNING: Missing block: B:28:0x008c, code:
            return;
     */
    void f() {
        /*
        r5 = this;
        r0 = r5.g();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r5.d;
        if (r0 == 0) goto L_0x008d;
    L_0x000b:
        r0 = r5.k;
        r0 = r0.getMeasuredHeight();
        if (r0 <= 0) goto L_0x008c;
    L_0x0013:
        r0 = r5.k;
        r0 = r0.getMeasuredWidth();
        if (r0 > 0) goto L_0x001c;
    L_0x001b:
        return;
    L_0x001c:
        r0 = r5.k;
        r1 = "getHorizontallyScrolling";
        r2 = 0;
        r3 = java.lang.Boolean.valueOf(r2);
        r0 = r5.a(r0, r1, r3);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        goto L_0x0048;
    L_0x0034:
        r0 = r5.k;
        r0 = r0.getMeasuredWidth();
        r1 = r5.k;
        r1 = r1.getTotalPaddingLeft();
        r0 = r0 - r1;
        r1 = r5.k;
        r1 = r1.getTotalPaddingRight();
        r0 = r0 - r1;
    L_0x0048:
        r1 = r5.k;
        r1 = r1.getHeight();
        r3 = r5.k;
        r3 = r3.getCompoundPaddingBottom();
        r1 = r1 - r3;
        r3 = r5.k;
        r3 = r3.getCompoundPaddingTop();
        r1 = r1 - r3;
        if (r0 <= 0) goto L_0x008c;
    L_0x005e:
        if (r1 > 0) goto L_0x0061;
    L_0x0060:
        return;
    L_0x0061:
        r3 = a;
        monitor-enter(r3);
        r4 = a;	 Catch:{ all -> 0x0089 }
        r4.setEmpty();	 Catch:{ all -> 0x0089 }
        r4 = a;	 Catch:{ all -> 0x0089 }
        r0 = (float) r0;	 Catch:{ all -> 0x0089 }
        r4.right = r0;	 Catch:{ all -> 0x0089 }
        r0 = a;	 Catch:{ all -> 0x0089 }
        r1 = (float) r1;	 Catch:{ all -> 0x0089 }
        r0.bottom = r1;	 Catch:{ all -> 0x0089 }
        r0 = a;	 Catch:{ all -> 0x0089 }
        r0 = r5.a(r0);	 Catch:{ all -> 0x0089 }
        r0 = (float) r0;	 Catch:{ all -> 0x0089 }
        r1 = r5.k;	 Catch:{ all -> 0x0089 }
        r1 = r1.getTextSize();	 Catch:{ all -> 0x0089 }
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x0087;
    L_0x0084:
        r5.a(r2, r0);	 Catch:{ all -> 0x0089 }
    L_0x0087:
        monitor-exit(r3);	 Catch:{ all -> 0x0089 }
        goto L_0x008d;
    L_0x0089:
        r5 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0089 }
        throw r5;
    L_0x008c:
        return;
    L_0x008d:
        r0 = 1;
        r5.d = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ab.f():void");
    }

    boolean g() {
        return k() && this.c != 0;
    }
}
