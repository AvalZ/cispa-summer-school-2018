package android.support.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i extends h {
    static final Mode a = Mode.SRC_IN;
    private g b;
    private PorterDuffColorFilter d;
    private ColorFilter e;
    private boolean f;
    private boolean g;
    private ConstantState h;
    private final float[] i;
    private final Matrix j;
    private final Rect k;

    private static abstract class d {
        private d() {
        }

        public boolean a(int[] iArr) {
            return false;
        }

        public boolean b() {
            return false;
        }
    }

    private static class f {
        private static final Matrix n = new Matrix();
        Paint a;
        Paint b;
        final c c;
        float d;
        float e;
        float f;
        float g;
        int h;
        String i;
        Boolean j;
        final android.support.v4.g.a<String, Object> k;
        private final Path l;
        private final Path m;
        private final Matrix o;
        private PathMeasure p;
        private int q;

        public f() {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new android.support.v4.g.a();
            this.c = new c();
            this.l = new Path();
            this.m = new Path();
        }

        public f(f fVar) {
            this.o = new Matrix();
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.h = 255;
            this.i = null;
            this.j = null;
            this.k = new android.support.v4.g.a();
            this.c = new c(fVar.c, this.k);
            this.l = new Path(fVar.l);
            this.m = new Path(fVar.m);
            this.d = fVar.d;
            this.e = fVar.e;
            this.f = fVar.f;
            this.g = fVar.g;
            this.q = fVar.q;
            this.h = fVar.h;
            this.i = fVar.i;
            if (fVar.i != null) {
                this.k.put(fVar.i, this);
            }
            this.j = fVar.j;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            return max > 0.0f ? Math.abs(a) / max : 0.0f;
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.a.set(matrix);
            cVar.a.preConcat(cVar.d);
            canvas.save();
            for (int i3 = 0; i3 < cVar.b.size(); i3++) {
                d dVar = (d) cVar.b.get(i3);
                if (dVar instanceof c) {
                    a((c) dVar, cVar.a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof e) {
                    a(cVar, (e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        private void a(c cVar, e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f;
            float f2 = ((float) i2) / this.g;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.a;
            this.o.set(matrix);
            this.o.postScale(f, f2);
            float a = a(matrix);
            if (a != 0.0f) {
                eVar.a(this.l);
                Path path = this.l;
                this.m.reset();
                if (eVar.a()) {
                    this.m.addPath(path, this.o);
                    canvas.clipPath(this.m);
                    return;
                }
                android.support.v4.a.a.b bVar;
                Paint paint;
                Shader a2;
                b bVar2 = (b) eVar;
                if (!(bVar2.g == 0.0f && bVar2.h == 1.0f)) {
                    float f3 = (bVar2.g + bVar2.i) % 1.0f;
                    float f4 = (bVar2.h + bVar2.i) % 1.0f;
                    if (this.p == null) {
                        this.p = new PathMeasure();
                    }
                    this.p.setPath(this.l, false);
                    float length = this.p.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.p.getSegment(f3, length, path, true);
                        this.p.getSegment(0.0f, f4, path, true);
                    } else {
                        this.p.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.m.addPath(path, this.o);
                if (bVar2.c.e()) {
                    bVar = bVar2.c;
                    if (this.b == null) {
                        this.b = new Paint(1);
                        this.b.setStyle(Style.FILL);
                    }
                    paint = this.b;
                    if (bVar.c()) {
                        a2 = bVar.a();
                        a2.setLocalMatrix(this.o);
                        paint.setShader(a2);
                        paint.setAlpha(Math.round(bVar2.f * 255.0f));
                    } else {
                        paint.setColor(i.a(bVar.b(), bVar2.f));
                    }
                    paint.setColorFilter(colorFilter);
                    this.m.setFillType(bVar2.e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                    canvas.drawPath(this.m, paint);
                }
                if (bVar2.a.e()) {
                    bVar = bVar2.a;
                    if (this.a == null) {
                        this.a = new Paint(1);
                        this.a.setStyle(Style.STROKE);
                    }
                    paint = this.a;
                    if (bVar2.k != null) {
                        paint.setStrokeJoin(bVar2.k);
                    }
                    if (bVar2.j != null) {
                        paint.setStrokeCap(bVar2.j);
                    }
                    paint.setStrokeMiter(bVar2.l);
                    if (bVar.c()) {
                        a2 = bVar.a();
                        a2.setLocalMatrix(this.o);
                        paint.setShader(a2);
                        paint.setAlpha(Math.round(bVar2.d * 255.0f));
                    } else {
                        paint.setColor(i.a(bVar.b(), bVar2.d));
                    }
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth(bVar2.b * (min * a));
                    canvas.drawPath(this.m, paint);
                }
            }
        }

        public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            a(this.c, n, canvas, i, i2, colorFilter);
        }

        public boolean a() {
            if (this.j == null) {
                this.j = Boolean.valueOf(this.c.b());
            }
            return this.j.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.c.a(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.h;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.h = i;
        }
    }

    private static class g extends ConstantState {
        int a;
        f b;
        ColorStateList c;
        Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;

        public g() {
            this.c = null;
            this.d = i.a;
            this.b = new f();
        }

        public g(g gVar) {
            this.c = null;
            this.d = i.a;
            if (gVar != null) {
                this.a = gVar.a;
                this.b = new f(gVar.b);
                if (gVar.b.b != null) {
                    this.b.b = new Paint(gVar.b.b);
                }
                if (gVar.b.a != null) {
                    this.b.a = new Paint(gVar.b.a);
                }
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        public Paint a(ColorFilter colorFilter) {
            if (!a() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new Paint();
                this.l.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public void a(int i, int i2) {
            this.f.eraseColor(0);
            this.b.a(new Canvas(this.f), i, i2, null);
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, null, rect, a(colorFilter));
        }

        public boolean a() {
            return this.b.getRootAlpha() < 255;
        }

        public boolean a(int[] iArr) {
            boolean a = this.b.a(iArr);
            this.k |= a;
            return a;
        }

        public void b(int i, int i2) {
            if (this.f == null || !c(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.k = true;
            }
        }

        public boolean b() {
            return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
        }

        public void c() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        public boolean c(int i, int i2) {
            return i == this.f.getWidth() && i2 == this.f.getHeight();
        }

        public boolean d() {
            return this.b.a();
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            return new i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }
    }

    private static class h extends ConstantState {
        private final ConstantState a;

        public h(ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable iVar = new i();
            iVar.c = (VectorDrawable) this.a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable iVar = new i();
            iVar.c = (VectorDrawable) this.a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable iVar = new i();
            iVar.c = (VectorDrawable) this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    private static class c extends d {
        final Matrix a = new Matrix();
        final ArrayList<d> b = new ArrayList();
        float c = 0.0f;
        final Matrix d = new Matrix();
        int e;
        private float f = 0.0f;
        private float g = 0.0f;
        private float h = 1.0f;
        private float i = 1.0f;
        private float j = 0.0f;
        private float k = 0.0f;
        private int[] l;
        private String m = null;

        public c() {
            super();
        }

        public c(c cVar, android.support.v4.g.a<String, Object> aVar) {
            super();
            this.c = cVar.c;
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.e = cVar.e;
            if (this.m != null) {
                aVar.put(this.m, this);
            }
            this.d.set(cVar.d);
            ArrayList arrayList = cVar.b;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.b.add(new c((c) obj, aVar));
                } else {
                    e bVar;
                    if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        bVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.b.add(bVar);
                    if (bVar.n != null) {
                        aVar.put(bVar.n, bVar);
                    }
                }
            }
        }

        private void a() {
            this.d.reset();
            this.d.postTranslate(-this.f, -this.g);
            this.d.postScale(this.h, this.i);
            this.d.postRotate(this.c, 0.0f, 0.0f);
            this.d.postTranslate(this.j + this.f, this.k + this.g);
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.f = typedArray.getFloat(1, this.f);
            this.g = typedArray.getFloat(2, this.g);
            this.h = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "scaleX", 3, this.h);
            this.i = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "scaleY", 4, this.i);
            this.j = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "translateX", 6, this.j);
            this.k = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "translateY", 7, this.k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.a.a.g.a(resources, theme, attributeSet, a.b);
            a(a, xmlPullParser);
            a.recycle();
        }

        public boolean a(int[] iArr) {
            int i = 0;
            boolean z = false;
            while (i < this.b.size()) {
                z |= ((d) this.b.get(i)).a(iArr);
                i++;
            }
            return z;
        }

        public boolean b() {
            for (int i = 0; i < this.b.size(); i++) {
                if (((d) this.b.get(i)).b()) {
                    return true;
                }
            }
            return false;
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.d;
        }

        public float getPivotX() {
            return this.f;
        }

        public float getPivotY() {
            return this.g;
        }

        public float getRotation() {
            return this.c;
        }

        public float getScaleX() {
            return this.h;
        }

        public float getScaleY() {
            return this.i;
        }

        public float getTranslateX() {
            return this.j;
        }

        public float getTranslateY() {
            return this.k;
        }

        public void setPivotX(float f) {
            if (f != this.f) {
                this.f = f;
                a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.g) {
                this.g = f;
                a();
            }
        }

        public void setRotation(float f) {
            if (f != this.c) {
                this.c = f;
                a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.h) {
                this.h = f;
                a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.i) {
                this.i = f;
                a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.j) {
                this.j = f;
                a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.k) {
                this.k = f;
                a();
            }
        }
    }

    private static abstract class e extends d {
        protected android.support.v4.graphics.b.b[] m = null;
        String n;
        int o;

        public e() {
            super();
        }

        public e(e eVar) {
            super();
            this.n = eVar.n;
            this.o = eVar.o;
            this.m = android.support.v4.graphics.b.a(eVar.m);
        }

        public void a(Path path) {
            path.reset();
            if (this.m != null) {
                android.support.v4.graphics.b.b.a(this.m, path);
            }
        }

        public boolean a() {
            return false;
        }

        public android.support.v4.graphics.b.b[] getPathData() {
            return this.m;
        }

        public String getPathName() {
            return this.n;
        }

        public void setPathData(android.support.v4.graphics.b.b[] bVarArr) {
            if (android.support.v4.graphics.b.a(this.m, bVarArr)) {
                android.support.v4.graphics.b.b(this.m, bVarArr);
            } else {
                this.m = android.support.v4.graphics.b.a(bVarArr);
            }
        }
    }

    private static class a extends e {
        public a(a aVar) {
            super(aVar);
        }

        private void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.m = android.support.v4.graphics.b.b(string2);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (android.support.v4.a.a.g.a(xmlPullParser, "pathData")) {
                TypedArray a = android.support.v4.a.a.g.a(resources, theme, attributeSet, a.d);
                a(a);
                a.recycle();
            }
        }

        public boolean a() {
            return true;
        }
    }

    private static class b extends e {
        android.support.v4.a.a.b a;
        float b = 0.0f;
        android.support.v4.a.a.b c;
        float d = 1.0f;
        int e = 0;
        float f = 1.0f;
        float g = 0.0f;
        float h = 1.0f;
        float i = 0.0f;
        Cap j = Cap.BUTT;
        Join k = Join.MITER;
        float l = 4.0f;
        private int[] p;

        public b(b bVar) {
            super(bVar);
            this.p = bVar.p;
            this.a = bVar.a;
            this.b = bVar.b;
            this.d = bVar.d;
            this.c = bVar.c;
            this.e = bVar.e;
            this.f = bVar.f;
            this.g = bVar.g;
            this.h = bVar.h;
            this.i = bVar.i;
            this.j = bVar.j;
            this.k = bVar.k;
            this.l = bVar.l;
        }

        private Cap a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme) {
            this.p = null;
            if (android.support.v4.a.a.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = android.support.v4.graphics.b.b(string);
                }
                Theme theme2 = theme;
                this.c = android.support.v4.a.a.g.a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.f);
                this.j = a(android.support.v4.a.a.g.a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.j);
                this.k = a(android.support.v4.a.a.g.a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.k);
                this.l = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.l);
                this.a = android.support.v4.a.a.g.a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.d = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.d);
                this.b = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.b);
                this.h = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.h);
                this.i = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.i);
                this.g = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.g);
                this.e = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "fillType", 13, this.e);
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = android.support.v4.a.a.g.a(resources, theme, attributeSet, a.c);
            a(a, xmlPullParser, theme);
            a.recycle();
        }

        public boolean a(int[] iArr) {
            return this.a.a(iArr) | this.c.a(iArr);
        }

        public boolean b() {
            return this.c.d() || this.a.d();
        }

        float getFillAlpha() {
            return this.f;
        }

        int getFillColor() {
            return this.c.b();
        }

        float getStrokeAlpha() {
            return this.d;
        }

        int getStrokeColor() {
            return this.a.b();
        }

        float getStrokeWidth() {
            return this.b;
        }

        float getTrimPathEnd() {
            return this.h;
        }

        float getTrimPathOffset() {
            return this.i;
        }

        float getTrimPathStart() {
            return this.g;
        }

        void setFillAlpha(float f) {
            this.f = f;
        }

        void setFillColor(int i) {
            this.c.b(i);
        }

        void setStrokeAlpha(float f) {
            this.d = f;
        }

        void setStrokeColor(int i) {
            this.a.b(i);
        }

        void setStrokeWidth(float f) {
            this.b = f;
        }

        void setTrimPathEnd(float f) {
            this.h = f;
        }

        void setTrimPathOffset(float f) {
            this.i = f;
        }

        void setTrimPathStart(float f) {
            this.g = f;
        }
    }

    i() {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = new g();
    }

    i(g gVar) {
        this.g = true;
        this.i = new float[9];
        this.j = new Matrix();
        this.k = new Rect();
        this.b = gVar;
        this.d = a(this.d, gVar.c, gVar.d);
    }

    static int a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    private static Mode a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A:{Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A:{Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A:{ExcHandler: org.xmlpull.v1.XmlPullParserException (r4_5 'e' java.lang.Throwable), Splitter: B:4:0x001f} */
    /* JADX WARNING: Missing block: B:16:0x0041, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:17:0x0042, code:
            android.util.Log.e("VectorDrawableCompat", "parser error", r4);
     */
    /* JADX WARNING: Missing block: B:18:0x004a, code:
            return null;
     */
    public static android.support.c.a.i a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x001f;
    L_0x0006:
        r0 = new android.support.c.a.i;
        r0.<init>();
        r4 = android.support.v4.a.a.f.a(r4, r5, r6);
        r0.c = r4;
        r4 = new android.support.c.a.i$h;
        r5 = r0.c;
        r5 = r5.getConstantState();
        r4.<init>(r5);
        r0.h = r4;
        return r0;
    L_0x001f:
        r5 = r4.getXml(r5);	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
        r0 = android.util.Xml.asAttributeSet(r5);	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
    L_0x0027:
        r1 = r5.next();	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
        r2 = 2;
        if (r1 == r2) goto L_0x0032;
    L_0x002e:
        r3 = 1;
        if (r1 == r3) goto L_0x0032;
    L_0x0031:
        goto L_0x0027;
    L_0x0032:
        if (r1 == r2) goto L_0x003c;
    L_0x0034:
        r4 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
        r5 = "No start tag found";
        r4.<init>(r5);	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
        throw r4;	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
    L_0x003c:
        r4 = a(r4, r5, r0, r6);	 Catch:{ XmlPullParserException -> 0x0041, XmlPullParserException -> 0x0041 }
        return r4;
    L_0x0041:
        r4 = move-exception;
        r5 = "VectorDrawableCompat";
        r6 = "parser error";
        android.util.Log.e(r5, r6, r4);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.c.a.i.a(android.content.res.Resources, int, android.content.res.Resources$Theme):android.support.c.a.i");
    }

    public static i a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        g gVar = this.b;
        f fVar = gVar.b;
        gVar.d = a(android.support.v4.a.a.g.a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            gVar.c = colorStateList;
        }
        gVar.e = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.e);
        fVar.f = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f);
        fVar.g = android.support.v4.a.a.g.a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.g);
        StringBuilder stringBuilder;
        if (fVar.f <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (fVar.g <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else {
            fVar.d = typedArray.getDimension(3, fVar.d);
            fVar.e = typedArray.getDimension(2, fVar.e);
            if (fVar.d <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (fVar.e <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else {
                fVar.setAlpha(android.support.v4.a.a.g.a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.i = string;
                    fVar.k.put(string, fVar);
                }
            }
        }
    }

    private boolean a() {
        return VERSION.SDK_INT >= 17 && isAutoMirrored() && android.support.v4.graphics.drawable.a.h(this) == 1;
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        g gVar = this.b;
        f fVar = gVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        int i = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                int i2;
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.k.put(bVar.getPathName(), bVar);
                    }
                    i = 0;
                    i2 = gVar.a;
                    eventType = bVar.o;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.k.put(aVar.getPathName(), aVar);
                    }
                    i2 = gVar.a;
                    eventType = aVar.o;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.a(resources, attributeSet, theme, xmlPullParser);
                    cVar.b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.k.put(cVar2.getGroupName(), cVar2);
                    }
                    i2 = gVar.a;
                    eventType = cVar2.e;
                }
                gVar.a = eventType | i2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (i != 0) {
            throw new XmlPullParserException("no path defined");
        }
    }

    PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object a(String str) {
        return this.b.b.k.get(str);
    }

    void a(boolean z) {
        this.g = z;
    }

    public boolean canApplyTheme() {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.d(this.c);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
            return;
        }
        copyBounds(this.k);
        if (this.k.width() > 0 && this.k.height() > 0) {
            ColorFilter colorFilter = this.e == null ? this.d : this.e;
            canvas.getMatrix(this.j);
            this.j.getValues(this.i);
            float abs = Math.abs(this.i[0]);
            float abs2 = Math.abs(this.i[4]);
            float abs3 = Math.abs(this.i[1]);
            float abs4 = Math.abs(this.i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = abs;
            }
            int height = (int) (((float) this.k.height()) * abs2);
            int min = Math.min(2048, (int) (((float) this.k.width()) * abs));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.k.left, (float) this.k.top);
                if (a()) {
                    canvas.translate((float) this.k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.k.offsetTo(0, 0);
                this.b.b(min, height);
                if (!this.g) {
                    this.b.a(min, height);
                } else if (!this.b.b()) {
                    this.b.a(min, height);
                    this.b.c();
                }
                this.b.a(canvas, colorFilter, this.k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.c != null ? android.support.v4.graphics.drawable.a.c(this.c) : this.b.b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        if (this.c != null) {
            return this.c.getChangingConfigurations();
        }
        return this.b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.c != null && VERSION.SDK_INT >= 24) {
            return new h(this.c.getConstantState());
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    public int getIntrinsicHeight() {
        return this.c != null ? this.c.getIntrinsicHeight() : (int) this.b.b.e;
    }

    public int getIntrinsicWidth() {
        return this.c != null ? this.c.getIntrinsicWidth() : (int) this.b.b.d;
    }

    public int getOpacity() {
        return this.c != null ? this.c.getOpacity() : -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.c != null) {
            this.c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.b;
        gVar.b = new f();
        TypedArray a = android.support.v4.a.a.g.a(resources, theme, attributeSet, a.a);
        a(a, xmlPullParser);
        a.recycle();
        gVar.a = getChangingConfigurations();
        gVar.k = true;
        b(resources, xmlPullParser, attributeSet, theme);
        this.d = a(this.d, gVar.c, gVar.d);
    }

    public void invalidateSelf() {
        if (this.c != null) {
            this.c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.c != null ? android.support.v4.graphics.drawable.a.b(this.c) : this.b.e;
    }

    public boolean isStateful() {
        return this.c != null ? this.c.isStateful() : super.isStateful() || (this.b != null && (this.b.d() || (this.b.c != null && this.b.c.isStateful())));
    }

    public Drawable mutate() {
        if (this.c != null) {
            this.c.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.b = new g(this.b);
            this.f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.c != null) {
            return this.c.setState(iArr);
        }
        boolean z = false;
        g gVar = this.b;
        if (!(gVar.c == null || gVar.d == null)) {
            this.d = a(this.d, gVar.c, gVar.d);
            invalidateSelf();
            z = true;
        }
        if (gVar.d() && gVar.a(iArr)) {
            invalidateSelf();
            z = true;
        }
        return z;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.c != null) {
            this.c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.c != null) {
            this.c.setAlpha(i);
            return;
        }
        if (this.b.b.getRootAlpha() != i) {
            this.b.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, z);
        } else {
            this.b.e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != null) {
            this.c.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, colorStateList);
            return;
        }
        g gVar = this.b;
        if (gVar.c != colorStateList) {
            gVar.c = colorStateList;
            this.d = a(this.d, colorStateList, gVar.d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, mode);
            return;
        }
        g gVar = this.b;
        if (gVar.d != mode) {
            gVar.d = mode;
            this.d = a(this.d, gVar.c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.c != null ? this.c.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.c != null) {
            this.c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
