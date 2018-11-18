package android.support.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.graphics.b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

public class g implements Interpolator {
    private float[] a;
    private float[] b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public g(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = android.support.v4.a.a.g.a(resources, theme, attributeSet, a.l);
        a(a, xmlPullParser);
        a.recycle();
    }

    private void a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        a(path);
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        a(path);
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (android.support.v4.a.a.g.a(xmlPullParser, "pathData")) {
            String a = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "pathData", 4);
            Path a2 = b.a(a);
            if (a2 == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("The path is null, which is created from ");
                stringBuilder.append(a);
                throw new InflateException(stringBuilder.toString());
            }
            a(a2);
        } else if (!android.support.v4.a.a.g.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (android.support.v4.a.a.g.a(xmlPullParser, "controlY1")) {
            float a3 = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float a4 = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a5 = android.support.v4.a.a.g.a(xmlPullParser, "controlX2");
            if (a5 != android.support.v4.a.a.g.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (a5) {
                a(a3, a4, android.support.v4.a.a.g.a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), android.support.v4.a.a.g.a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            } else {
                a(a3, a4);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    private void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        StringBuilder stringBuilder;
        if (min <= 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("The Path has a invalid length ");
            stringBuilder.append(length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i2;
        this.a = new float[min];
        this.b = new float[min];
        float[] fArr = new float[2];
        for (i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (min - 1)), fArr, null);
            this.a[i2] = fArr[0];
            this.b[i2] = fArr[1];
        }
        if (((double) Math.abs(this.a[0])) <= 1.0E-5d && ((double) Math.abs(this.b[0])) <= 1.0E-5d) {
            int i3 = min - 1;
            if (((double) Math.abs(this.a[i3] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.b[i3] - 1.0f)) <= 1.0E-5d) {
                float f = 0.0f;
                int i4 = 0;
                while (i < min) {
                    i2 = i4 + 1;
                    length = this.a[i4];
                    if (length < f) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The Path cannot loop back on itself, x :");
                        stringBuilder.append(length);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    this.a[i] = length;
                    i++;
                    f = length;
                    i4 = i2;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("The Path must start at (0,0) and end at (1,1) start: ");
        stringBuilder.append(this.a[0]);
        stringBuilder.append(",");
        stringBuilder.append(this.b[0]);
        stringBuilder.append(" end:");
        min--;
        stringBuilder.append(this.a[min]);
        stringBuilder.append(",");
        stringBuilder.append(this.b[min]);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.a[length] - this.a[i];
        if (f2 == 0.0f) {
            return this.b[i];
        }
        f = (f - this.a[i]) / f2;
        float f3 = this.b[i];
        return f3 + (f * (this.b[length] - f3));
    }
}
