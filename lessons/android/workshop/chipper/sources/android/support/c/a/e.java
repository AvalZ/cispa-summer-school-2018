package android.support.c.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.a.a.g;
import android.support.v4.graphics.b.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class e {

    private static class a implements TypeEvaluator<b[]> {
        private b[] a;

        a() {
        }

        /* renamed from: a */
        public b[] evaluate(float f, b[] bVarArr, b[] bVarArr2) {
            if (android.support.v4.graphics.b.a(bVarArr, bVarArr2)) {
                if (this.a == null || !android.support.v4.graphics.b.a(this.a, bVarArr)) {
                    this.a = android.support.v4.graphics.b.a(bVarArr);
                }
                for (int i = 0; i < bVarArr.length; i++) {
                    this.a[i].a(bVarArr[i], bVarArr2[i], f);
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    private static int a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = g.a(resources, theme, attributeSet, a.j);
        int i = 0;
        TypedValue b = g.b(a, xmlPullParser, "value", 0);
        if ((b != null ? 1 : 0) != 0 && a(b.type)) {
            i = 3;
        }
        a.recycle();
        return i;
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        TypedValue peekValue = typedArray.peekValue(i);
        int i3 = 1;
        int i4 = peekValue != null ? 1 : 0;
        i = i4 != 0 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i2);
        if (peekValue2 == null) {
            i3 = 0;
        }
        return ((i4 == 0 || !a(i)) && (i3 == 0 || !a(i3 != 0 ? peekValue2.type : 0))) ? 0 : 3;
    }

    public static Animator a(Context context, int i) {
        return VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : a(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator a(Context context, Resources resources, Theme theme, int i) {
        return a(context, resources, theme, i, 1.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    public static android.animation.Animator a(android.content.Context r2, android.content.res.Resources r3, android.content.res.Resources.Theme r4, int r5, float r6) {
        /*
        r0 = 0;
        r1 = r3.getAnimation(r5);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x001a }
        r2 = a(r2, r3, r4, r1, r6);	 Catch:{ XmlPullParserException -> 0x0015, IOException -> 0x0012, all -> 0x000f }
        if (r1 == 0) goto L_0x000e;
    L_0x000b:
        r1.close();
    L_0x000e:
        return r2;
    L_0x000f:
        r2 = move-exception;
        r0 = r1;
        goto L_0x0058;
    L_0x0012:
        r2 = move-exception;
        r0 = r1;
        goto L_0x001b;
    L_0x0015:
        r2 = move-exception;
        r0 = r1;
        goto L_0x003a;
    L_0x0018:
        r2 = move-exception;
        goto L_0x0058;
    L_0x001a:
        r2 = move-exception;
    L_0x001b:
        r3 = new android.content.res.Resources$NotFoundException;	 Catch:{ all -> 0x0018 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0018 }
        r4.<init>();	 Catch:{ all -> 0x0018 }
        r6 = "Can't load animation resource ID #0x";
        r4.append(r6);	 Catch:{ all -> 0x0018 }
        r5 = java.lang.Integer.toHexString(r5);	 Catch:{ all -> 0x0018 }
        r4.append(r5);	 Catch:{ all -> 0x0018 }
        r4 = r4.toString();	 Catch:{ all -> 0x0018 }
        r3.<init>(r4);	 Catch:{ all -> 0x0018 }
        r3.initCause(r2);	 Catch:{ all -> 0x0018 }
        throw r3;	 Catch:{ all -> 0x0018 }
    L_0x0039:
        r2 = move-exception;
    L_0x003a:
        r3 = new android.content.res.Resources$NotFoundException;	 Catch:{ all -> 0x0018 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0018 }
        r4.<init>();	 Catch:{ all -> 0x0018 }
        r6 = "Can't load animation resource ID #0x";
        r4.append(r6);	 Catch:{ all -> 0x0018 }
        r5 = java.lang.Integer.toHexString(r5);	 Catch:{ all -> 0x0018 }
        r4.append(r5);	 Catch:{ all -> 0x0018 }
        r4 = r4.toString();	 Catch:{ all -> 0x0018 }
        r3.<init>(r4);	 Catch:{ all -> 0x0018 }
        r3.initCause(r2);	 Catch:{ all -> 0x0018 }
        throw r3;	 Catch:{ all -> 0x0018 }
    L_0x0058:
        if (r0 == 0) goto L_0x005d;
    L_0x005a:
        r0.close();
    L_0x005d:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, int, float):android.animation.Animator");
    }

    private static Animator a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) {
        return a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b2  */
    private static android.animation.Animator a(android.content.Context r18, android.content.res.Resources r19, android.content.res.Resources.Theme r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.animation.AnimatorSet r23, int r24, float r25) {
        /*
        r8 = r19;
        r9 = r20;
        r10 = r21;
        r11 = r23;
        r12 = r21.getDepth();
        r0 = 0;
        r13 = r0;
    L_0x000e:
        r1 = r21.next();
        r2 = 3;
        r14 = 0;
        if (r1 != r2) goto L_0x001c;
    L_0x0016:
        r2 = r21.getDepth();
        if (r2 <= r12) goto L_0x00d7;
    L_0x001c:
        r2 = 1;
        if (r1 == r2) goto L_0x00d7;
    L_0x001f:
        r3 = 2;
        if (r1 == r3) goto L_0x0023;
    L_0x0022:
        goto L_0x000e;
    L_0x0023:
        r1 = r21.getName();
        r3 = "objectAnimator";
        r3 = r1.equals(r3);
        if (r3 == 0) goto L_0x0040;
    L_0x002f:
        r0 = r18;
        r1 = r8;
        r2 = r9;
        r3 = r22;
        r4 = r25;
        r5 = r10;
        r0 = a(r0, r1, r2, r3, r4, r5);
    L_0x003c:
        r3 = r18;
        goto L_0x00ac;
    L_0x0040:
        r3 = "animator";
        r3 = r1.equals(r3);
        if (r3 == 0) goto L_0x0057;
    L_0x0048:
        r4 = 0;
        r0 = r18;
        r1 = r8;
        r2 = r9;
        r3 = r22;
        r5 = r25;
        r6 = r10;
        r0 = a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x003c;
    L_0x0057:
        r3 = "set";
        r3 = r1.equals(r3);
        if (r3 == 0) goto L_0x008b;
    L_0x005f:
        r15 = new android.animation.AnimatorSet;
        r15.<init>();
        r0 = android.support.c.a.a.h;
        r7 = r22;
        r6 = android.support.v4.a.a.g.a(r8, r9, r7, r0);
        r0 = "ordering";
        r16 = android.support.v4.a.a.g.a(r6, r10, r0, r14, r14);
        r5 = r15;
        r5 = (android.animation.AnimatorSet) r5;
        r0 = r18;
        r1 = r8;
        r2 = r9;
        r3 = r10;
        r4 = r7;
        r14 = r6;
        r6 = r16;
        r7 = r25;
        a(r0, r1, r2, r3, r4, r5, r6, r7);
        r14.recycle();
        r3 = r18;
        r0 = r15;
        r14 = 0;
        goto L_0x00ac;
    L_0x008b:
        r3 = "propertyValuesHolder";
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x00bc;
    L_0x0093:
        r1 = android.util.Xml.asAttributeSet(r21);
        r3 = r18;
        r1 = a(r3, r8, r9, r10, r1);
        if (r1 == 0) goto L_0x00ab;
    L_0x009f:
        if (r0 == 0) goto L_0x00ab;
    L_0x00a1:
        r4 = r0 instanceof android.animation.ValueAnimator;
        if (r4 == 0) goto L_0x00ab;
    L_0x00a5:
        r4 = r0;
        r4 = (android.animation.ValueAnimator) r4;
        r4.setValues(r1);
    L_0x00ab:
        r14 = r2;
    L_0x00ac:
        if (r11 == 0) goto L_0x000e;
    L_0x00ae:
        if (r14 != 0) goto L_0x000e;
    L_0x00b0:
        if (r13 != 0) goto L_0x00b7;
    L_0x00b2:
        r13 = new java.util.ArrayList;
        r13.<init>();
    L_0x00b7:
        r13.add(r0);
        goto L_0x000e;
    L_0x00bc:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unknown animator name: ";
        r1.append(r2);
        r2 = r21.getName();
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00d7:
        if (r11 == 0) goto L_0x0103;
    L_0x00d9:
        if (r13 == 0) goto L_0x0103;
    L_0x00db:
        r1 = r13.size();
        r1 = new android.animation.Animator[r1];
        r2 = r13.iterator();
        r17 = 0;
    L_0x00e7:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00fa;
    L_0x00ed:
        r3 = r2.next();
        r3 = (android.animation.Animator) r3;
        r4 = r17 + 1;
        r1[r17] = r3;
        r17 = r4;
        goto L_0x00e7;
    L_0x00fa:
        if (r24 != 0) goto L_0x0100;
    L_0x00fc:
        r11.playTogether(r1);
        return r0;
    L_0x0100:
        r11.playSequentially(r1);
    L_0x0103:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    private static Keyframe a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    private static Keyframe a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        Keyframe ofFloat;
        TypedArray a = g.a(resources, theme, attributeSet, a.j);
        float a2 = g.a(a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = g.b(a, xmlPullParser, "value", 0);
        int i2 = b != null ? 1 : 0;
        if (i == 4) {
            i = (i2 == 0 || !a(b.type)) ? 0 : 3;
        }
        if (i2 != 0) {
            if (i != 3) {
                switch (i) {
                    case 0:
                        ofFloat = Keyframe.ofFloat(a2, g.a(a, xmlPullParser, "value", 0, 0.0f));
                        break;
                    case 1:
                        break;
                    default:
                        ofFloat = null;
                        break;
                }
            }
            ofFloat = Keyframe.ofInt(a2, g.a(a, xmlPullParser, "value", 0, 0));
        } else {
            ofFloat = i == 0 ? Keyframe.ofFloat(a2) : Keyframe.ofInt(a2);
        }
        int c = g.c(a, xmlPullParser, "interpolator", 1, 0);
        if (c > 0) {
            ofFloat.setInterpolator(d.a(context, c));
        }
        a.recycle();
        return ofFloat;
    }

    private static ObjectAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    private static android.animation.PropertyValuesHolder a(android.content.Context r9, android.content.res.Resources r10, android.content.res.Resources.Theme r11, org.xmlpull.v1.XmlPullParser r12, java.lang.String r13, int r14) {
        /*
        r0 = 0;
        r1 = r14;
        r14 = r0;
    L_0x0003:
        r2 = r12.next();
        r3 = 3;
        if (r2 == r3) goto L_0x0041;
    L_0x000a:
        r4 = 1;
        if (r2 == r4) goto L_0x0041;
    L_0x000d:
        r2 = r12.getName();
        r3 = "keyframe";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0003;
    L_0x0019:
        r2 = 4;
        if (r1 != r2) goto L_0x0024;
    L_0x001c:
        r1 = android.util.Xml.asAttributeSet(r12);
        r1 = a(r10, r11, r1, r12);
    L_0x0024:
        r5 = android.util.Xml.asAttributeSet(r12);
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r6 = r1;
        r7 = r12;
        r2 = a(r2, r3, r4, r5, r6, r7);
        if (r2 == 0) goto L_0x003d;
    L_0x0033:
        if (r14 != 0) goto L_0x003a;
    L_0x0035:
        r14 = new java.util.ArrayList;
        r14.<init>();
    L_0x003a:
        r14.add(r2);
    L_0x003d:
        r12.next();
        goto L_0x0003;
    L_0x0041:
        if (r14 == 0) goto L_0x00ea;
    L_0x0043:
        r9 = r14.size();
        if (r9 <= 0) goto L_0x00ea;
    L_0x0049:
        r10 = 0;
        r11 = r14.get(r10);
        r11 = (android.animation.Keyframe) r11;
        r12 = r9 + -1;
        r12 = r14.get(r12);
        r12 = (android.animation.Keyframe) r12;
        r0 = r12.getFraction();
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        r5 = 0;
        if (r4 >= 0) goto L_0x0078;
    L_0x0063:
        r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x006b;
    L_0x0067:
        r12.setFraction(r2);
        goto L_0x0078;
    L_0x006b:
        r0 = r14.size();
        r12 = a(r12, r2);
        r14.add(r0, r12);
        r9 = r9 + 1;
    L_0x0078:
        r12 = r11.getFraction();
        r0 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x0091;
    L_0x0080:
        r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1));
        if (r12 >= 0) goto L_0x0088;
    L_0x0084:
        r11.setFraction(r5);
        goto L_0x0091;
    L_0x0088:
        r11 = a(r11, r5);
        r14.add(r10, r11);
        r9 = r9 + 1;
    L_0x0091:
        r11 = new android.animation.Keyframe[r9];
        r14.toArray(r11);
    L_0x0096:
        if (r10 >= r9) goto L_0x00dd;
    L_0x0098:
        r12 = r11[r10];
        r14 = r12.getFraction();
        r14 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1));
        if (r14 >= 0) goto L_0x00da;
    L_0x00a2:
        if (r10 != 0) goto L_0x00a8;
    L_0x00a4:
        r12.setFraction(r5);
        goto L_0x00da;
    L_0x00a8:
        r14 = r9 + -1;
        if (r10 != r14) goto L_0x00b0;
    L_0x00ac:
        r12.setFraction(r2);
        goto L_0x00da;
    L_0x00b0:
        r12 = r10 + 1;
        r0 = r10;
    L_0x00b3:
        if (r12 >= r14) goto L_0x00c6;
    L_0x00b5:
        r4 = r11[r12];
        r4 = r4.getFraction();
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r4 < 0) goto L_0x00c0;
    L_0x00bf:
        goto L_0x00c6;
    L_0x00c0:
        r0 = r12 + 1;
        r8 = r0;
        r0 = r12;
        r12 = r8;
        goto L_0x00b3;
    L_0x00c6:
        r12 = r0 + 1;
        r12 = r11[r12];
        r12 = r12.getFraction();
        r14 = r10 + -1;
        r14 = r11[r14];
        r14 = r14.getFraction();
        r12 = r12 - r14;
        a(r11, r12, r10, r0);
    L_0x00da:
        r10 = r10 + 1;
        goto L_0x0096;
    L_0x00dd:
        r0 = android.animation.PropertyValuesHolder.ofKeyframe(r13, r11);
        if (r1 != r3) goto L_0x00ea;
    L_0x00e3:
        r9 = android.support.c.a.f.a();
        r0.setEvaluator(r9);
    L_0x00ea:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, java.lang.String, int):android.animation.PropertyValuesHolder");
    }

    private static PropertyValuesHolder a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        int i4 = peekValue != null ? 1 : 0;
        int i5 = i4 != 0 ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        int i6 = peekValue2 != null ? 1 : 0;
        int i7 = i6 != 0 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((i4 == 0 || !a(i5)) && (i6 == 0 || !a(i7))) ? 0 : 3;
        }
        int i8 = i == 0 ? 1 : 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            b[] b = android.support.v4.graphics.b.b(string);
            b[] b2 = android.support.v4.graphics.b.b(string2);
            if (!(b == null && b2 == null)) {
                if (b != null) {
                    Object[] objArr;
                    TypeEvaluator aVar = new a();
                    if (b2 == null) {
                        objArr = new Object[]{b};
                    } else if (android.support.v4.graphics.b.a(b, b2)) {
                        objArr = new Object[]{b, b2};
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(" Can't morph from ");
                        stringBuilder.append(string);
                        stringBuilder.append(" to ");
                        stringBuilder.append(string2);
                        throw new InflateException(stringBuilder.toString());
                    }
                    return PropertyValuesHolder.ofObject(str, aVar, objArr);
                } else if (b2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), new Object[]{b2});
                }
            }
        }
        TypeEvaluator a = i == 3 ? f.a() : null;
        int dimension;
        if (i8 != 0) {
            PropertyValuesHolder ofFloat;
            float dimension2;
            if (i4 != 0) {
                float dimension3 = i5 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                if (i6 != 0) {
                    dimension2 = i7 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension3, dimension2});
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension3});
                }
            } else {
                dimension2 = i7 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                ofFloat = PropertyValuesHolder.ofFloat(str, new float[]{dimension2});
            }
            propertyValuesHolder = ofFloat;
        } else if (i4 != 0) {
            i2 = i5 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : a(i5) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
            if (i6 != 0) {
                dimension = i7 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i7) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2, dimension});
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2});
            }
        } else if (i6 != 0) {
            dimension = i7 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : a(i7) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{dimension});
        }
        if (!(propertyValuesHolder == null || a == null)) {
            propertyValuesHolder.setEvaluator(a);
        }
        return propertyValuesHolder;
    }

    private static ValueAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a = g.a(resources, theme, attributeSet, a.g);
        TypedArray a2 = g.a(resources, theme, attributeSet, a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        a(valueAnimator, a, a2, f, xmlPullParser);
        int c = g.c(a, xmlPullParser, "interpolator", 0, 0);
        if (c > 0) {
            valueAnimator.setInterpolator(d.a(context, c));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a = g.a(typedArray, xmlPullParser, "pathData", 1);
        if (a != null) {
            String a2 = g.a(typedArray, xmlPullParser, "propertyXName", 2);
            String a3 = g.a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (a2 == null && a3 == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append(" propertyXName or propertyYName is needed for PathData");
                throw new InflateException(stringBuilder.toString());
            }
            a(android.support.v4.graphics.b.a(a), objectAnimator, f * 0.5f, a2, a3);
            return;
        }
        objectAnimator.setPropertyName(g.a(typedArray, xmlPullParser, "propertyName", 0));
    }

    private static void a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) g.a(typedArray, xmlPullParser, "duration", 1, 300);
        long a2 = (long) g.a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = g.a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (g.a(xmlPullParser, "valueFrom") && g.a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                a3 = a(typedArray, 5, 6);
            }
            if (a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{a(typedArray, a3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(a);
        valueAnimator.setStartDelay(a2);
        valueAnimator.setRepeatCount(g.a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(g.a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            a(valueAnimator, typedArray2, a3, f, xmlPullParser);
        }
    }

    private static void a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        float[] fArr;
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        pathMeasure = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[min];
        float[] fArr4 = new float[2];
        f2 /= (float) (min - 1);
        int i = 0;
        float f3 = 0.0f;
        int i2 = i;
        while (true) {
            fArr = null;
            if (i2 >= min) {
                break;
            }
            pathMeasure.getPosTan(f3 - ((Float) arrayList.get(i)).floatValue(), fArr4, null);
            fArr2[i2] = fArr4[0];
            fArr3[i2] = fArr4[1];
            f3 += f2;
            int i3 = i + 1;
            if (i3 < arrayList.size() && f3 > ((Float) arrayList.get(i3)).floatValue()) {
                pathMeasure.nextContour();
                i = i3;
            }
            i2++;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr2) : null;
        if (str4 != null) {
            fArr = PropertyValuesHolder.ofFloat(str4, fArr3);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{fArr});
        } else if (fArr == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, fArr});
        }
    }

    private static void a(Keyframe[] keyframeArr, float f, int i, int i2) {
        f /= (float) ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f);
            i++;
        }
    }

    private static boolean a(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    private static android.animation.PropertyValuesHolder[] a(android.content.Context r17, android.content.res.Resources r18, android.content.res.Resources.Theme r19, org.xmlpull.v1.XmlPullParser r20, android.util.AttributeSet r21) {
        /*
        r6 = r20;
        r7 = 0;
        r8 = r7;
    L_0x0004:
        r0 = r20.getEventType();
        r9 = 0;
        r1 = 3;
        if (r0 == r1) goto L_0x0066;
    L_0x000c:
        r10 = 1;
        if (r0 == r10) goto L_0x0066;
    L_0x000f:
        r2 = 2;
        if (r0 == r2) goto L_0x0016;
    L_0x0012:
        r20.next();
        goto L_0x0004;
    L_0x0016:
        r0 = r20.getName();
        r3 = "propertyValuesHolder";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x005f;
    L_0x0022:
        r0 = android.support.c.a.a.i;
        r11 = r18;
        r12 = r19;
        r13 = r21;
        r14 = android.support.v4.a.a.g.a(r11, r12, r13, r0);
        r0 = "propertyName";
        r15 = android.support.v4.a.a.g.a(r14, r6, r0, r1);
        r0 = "valueType";
        r1 = 4;
        r5 = android.support.v4.a.a.g.a(r14, r6, r0, r2, r1);
        r0 = r17;
        r1 = r11;
        r2 = r12;
        r3 = r6;
        r4 = r15;
        r16 = r5;
        r0 = a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x004f;
    L_0x0049:
        r1 = r16;
        r0 = a(r14, r1, r9, r10, r15);
    L_0x004f:
        if (r0 == 0) goto L_0x005b;
    L_0x0051:
        if (r8 != 0) goto L_0x0058;
    L_0x0053:
        r8 = new java.util.ArrayList;
        r8.<init>();
    L_0x0058:
        r8.add(r0);
    L_0x005b:
        r14.recycle();
        goto L_0x0012;
    L_0x005f:
        r11 = r18;
        r12 = r19;
        r13 = r21;
        goto L_0x0012;
    L_0x0066:
        if (r8 == 0) goto L_0x007b;
    L_0x0068:
        r0 = r8.size();
        r7 = new android.animation.PropertyValuesHolder[r0];
    L_0x006e:
        if (r9 >= r0) goto L_0x007b;
    L_0x0070:
        r1 = r8.get(r9);
        r1 = (android.animation.PropertyValuesHolder) r1;
        r7[r9] = r1;
        r9 = r9 + 1;
        goto L_0x006e;
    L_0x007b:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.e.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet):android.animation.PropertyValuesHolder[]");
    }
}
