package android.support.v7.c.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.c.a.i;
import android.support.v4.a.a.g;
import android.support.v4.g.m;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a extends d {
    private static final String a = "a";
    private b b;
    private f c;
    private int d;
    private int e;
    private boolean f;

    private static class e implements TimeInterpolator {
        private int[] a;
        private int b;
        private int c;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        int a() {
            return this.c;
        }

        int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.b = numberOfFrames;
            if (this.a == null || this.a.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr = this.a;
            int i = 0;
            int i2 = 0;
            while (i < numberOfFrames) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i) - 1 : i);
                iArr[i] = duration;
                i2 += duration;
                i++;
            }
            this.c = i2;
            return i2;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.c)) + 0.5f);
            int i2 = this.b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.c) : 0.0f);
        }
    }

    private static abstract class f {
        private f() {
        }

        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }
    }

    private static class a extends f {
        private final Animatable a;

        a(Animatable animatable) {
            super();
            this.a = animatable;
        }

        public void a() {
            this.a.start();
        }

        public void b() {
            this.a.stop();
        }
    }

    private static class c extends f {
        private final android.support.c.a.c a;

        c(android.support.c.a.c cVar) {
            super();
            this.a = cVar;
        }

        public void a() {
            this.a.start();
        }

        public void b() {
            this.a.stop();
        }
    }

    private static class d extends f {
        private final ObjectAnimator a;
        private final boolean b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            numberOfFrames = z ? 0 : numberOfFrames - 1;
            TimeInterpolator eVar = new e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, numberOfFrames});
            if (VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.a());
            ofInt.setInterpolator(eVar);
            this.b = z2;
            this.a = ofInt;
        }

        public void a() {
            this.a.start();
        }

        public void b() {
            this.a.cancel();
        }

        public boolean c() {
            return this.b;
        }

        public void d() {
            this.a.reverse();
        }
    }

    static class b extends a {
        android.support.v4.g.f<Long> a;
        m<Integer> b;

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001b in {2, 4, 5} preds:[]
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
            	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:32)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
            	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
            	at jadx.core.ProcessClass.process(ProcessClass.java:37)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
            */
        b(android.support.v7.c.a.a.b r1, android.support.v7.c.a.a r2, android.content.res.Resources r3) {
            /*
            r0 = this;
            r0.<init>(r1, r2, r3);
            if (r1 == 0) goto L_0x000e;
        L_0x0005:
            r2 = r1.a;
            r0.a = r2;
            r1 = r1.b;
        L_0x000b:
            r0.b = r1;
            return;
        L_0x000e:
            r1 = new android.support.v4.g.f;
            r1.<init>();
            r0.a = r1;
            r1 = new android.support.v4.g.m;
            r1.<init>();
            goto L_0x000b;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.a.b.<init>(android.support.v7.c.a.a$b, android.support.v7.c.a.a, android.content.res.Resources):void");
        }

        private static long f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        int a(int i) {
            return i < 0 ? 0 : ((Integer) this.b.a(i, Integer.valueOf(0))).intValue();
        }

        int a(int i, int i2) {
            return (int) ((Long) this.a.a(f(i, i2), Long.valueOf(-1))).longValue();
        }

        int a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.a(drawable);
            long f = f(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a;
            this.a.c(f, Long.valueOf(j2 | j));
            if (z) {
                this.a.c(f(i2, i), Long.valueOf((4294967296L | j2) | j));
            }
            return a;
        }

        int a(int[] iArr) {
            int b = super.b(iArr);
            return b >= 0 ? b : super.b(StateSet.WILD_CARD);
        }

        int a(int[] iArr, Drawable drawable, int i) {
            int a = super.a(iArr, drawable);
            this.b.b(a, Integer.valueOf(i));
            return a;
        }

        void a() {
            this.a = this.a.clone();
            this.b = this.b.clone();
        }

        boolean b(int i, int i2) {
            return (((Long) this.a.a(f(i, i2), Long.valueOf(-1))).longValue() & 4294967296L) != 0;
        }

        boolean c(int i, int i2) {
            return (((Long) this.a.a(f(i, i2), Long.valueOf(-1))).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new a(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super(null);
        this.d = -1;
        this.e = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": invalid animated-selector tag ");
        stringBuilder.append(name);
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private void a(TypedArray typedArray) {
        b bVar = this.b;
        if (VERSION.SDK_INT >= 21) {
            bVar.f |= typedArray.getChangingConfigurations();
        }
        bVar.a(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_variablePadding, bVar.k));
        bVar.b(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_constantSize, bVar.n));
        bVar.c(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.C));
        bVar.d(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.D));
        setDither(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_dither, bVar.z));
    }

    private boolean b(int i) {
        int d;
        f fVar = this.c;
        if (fVar == null) {
            d = d();
        } else if (i == this.d) {
            return true;
        } else {
            if (i == this.e && fVar.c()) {
                fVar.d();
                this.d = this.e;
                this.e = i;
                return true;
            }
            d = this.d;
            fVar.b();
        }
        this.c = null;
        this.e = -1;
        this.d = -1;
        b bVar = this.b;
        int a = bVar.a(d);
        int a2 = bVar.a(i);
        if (a2 == 0 || a == 0) {
            return false;
        }
        int a3 = bVar.a(a, a2);
        if (a3 < 0) {
            return false;
        }
        f dVar;
        boolean c = bVar.c(a, a2);
        a(a3);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            dVar = new d((AnimationDrawable) current, bVar.b(a, a2), c);
        } else if (current instanceof android.support.c.a.c) {
            dVar = new c((android.support.c.a.c) current);
        } else {
            if (current instanceof Animatable) {
                dVar = new a((Animatable) current);
            }
            return false;
        }
        dVar.a();
        this.c = dVar;
        this.e = d;
        this.d = i;
        return true;
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2) {
                    if (depth2 <= depth) {
                        if (xmlPullParser.getName().equals("item")) {
                            e(context, resources, xmlPullParser, attributeSet, theme);
                        } else if (xmlPullParser.getName().equals("transition")) {
                            d(context, resources, xmlPullParser, attributeSet, theme);
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        StringBuilder stringBuilder;
        TypedArray a = g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableTransition);
        int resourceId = a.getResourceId(j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a.getResourceId(j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a.getResourceId(j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable b = resourceId3 > 0 ? android.support.v7.b.a.a.b(context, resourceId3) : null;
        boolean z = a.getBoolean(j.AnimatedStateListDrawableTransition_android_reversible, false);
        a.recycle();
        if (b == null) {
            int next;
            while (true) {
                next = xmlPullParser.next();
                if (next != 4) {
                    break;
                }
            }
            if (next != 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(stringBuilder.toString());
            }
            b = xmlPullParser.getName().equals("animated-vector") ? android.support.c.a.c.a(context, resources, xmlPullParser, attributeSet, theme) : VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (b == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.b.a(resourceId, resourceId2, b, z);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(xmlPullParser.getPositionDescription());
            stringBuilder.append(": <transition> tag requires 'fromId' & 'toId' attributes");
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        StringBuilder stringBuilder;
        TypedArray a = g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableItem);
        int resourceId = a.getResourceId(j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a.getResourceId(j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable b = resourceId2 > 0 ? android.support.v7.b.a.a.b(context, resourceId2) : null;
        a.recycle();
        int[] a2 = a(attributeSet);
        if (b == null) {
            int next;
            while (true) {
                next = xmlPullParser.next();
                if (next != 4) {
                    break;
                }
            }
            if (next != 2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(xmlPullParser.getPositionDescription());
                stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                throw new XmlPullParserException(stringBuilder.toString());
            }
            b = xmlPullParser.getName().equals("vector") ? i.a(resources, xmlPullParser, attributeSet, theme) : VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (b != null) {
            return this.b.a(a2, b, resourceId);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser.getPositionDescription());
        stringBuilder.append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        throw new XmlPullParserException(stringBuilder.toString());
    }

    private void e() {
        onStateChange(getState());
    }

    /* renamed from: a */
    b c() {
        return new b(this.b, this, null);
    }

    protected void a(b bVar) {
        super.a(bVar);
        if (bVar instanceof b) {
            this.b = (b) bVar;
        }
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray a = g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableCompat);
        setVisible(a.getBoolean(j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a);
        a(resources);
        a.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        e();
    }

    public ConstantState getConstantState() {
        return this.b;
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.c != null) {
            this.c.b();
            this.c = null;
            a(this.d);
            this.d = -1;
            this.e = -1;
        }
    }

    public Drawable mutate() {
        if (!this.f && super.mutate() == this) {
            this.b.a();
            this.f = true;
        }
        return this;
    }

    protected boolean onStateChange(int[] iArr) {
        int a = this.b.a(iArr);
        boolean z = a != d() && (b(a) || a(a));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.c != null && (visible || z2)) {
            if (z) {
                this.c.a();
                return visible;
            }
            jumpToCurrentState();
        }
        return visible;
    }
}
