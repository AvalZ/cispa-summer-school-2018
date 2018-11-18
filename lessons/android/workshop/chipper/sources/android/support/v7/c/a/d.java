package android.support.v7.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.a.a.g;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class d extends b {
    private a a;
    private boolean b;

    static class a extends b {
        int[][] L;

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0011 in {2, 4, 5} preds:[]
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
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
            */
        a(android.support.v7.c.a.d.a r1, android.support.v7.c.a.d r2, android.content.res.Resources r3) {
            /*
            r0 = this;
            r0.<init>(r1, r2, r3);
            if (r1 == 0) goto L_0x000a;
        L_0x0005:
            r1 = r1.L;
        L_0x0007:
            r0.L = r1;
            return;
        L_0x000a:
            r1 = r0.c();
            r1 = new int[r1][];
            goto L_0x0007;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.d.a.<init>(android.support.v7.c.a.d$a, android.support.v7.c.a.d, android.content.res.Resources):void");
        }

        int a(int[] iArr, Drawable drawable) {
            int a = a(drawable);
            this.L[a] = iArr;
            return a;
        }

        void a() {
            int[][] iArr = new int[this.L.length][];
            for (int length = this.L.length - 1; length >= 0; length--) {
                iArr[length] = this.L[length] != null ? (int[]) this.L[length].clone() : null;
            }
            this.L = iArr;
        }

        int b(int[] iArr) {
            int[][] iArr2 = this.L;
            int d = d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        public void e(int i, int i2) {
            super.e(i, i2);
            Object obj = new int[i2][];
            System.arraycopy(this.L, 0, obj, 0, i);
            this.L = obj;
        }

        public Drawable newDrawable() {
            return new d(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d() {
        this(null, null);
    }

    d(a aVar) {
        if (aVar != null) {
            a((b) aVar);
        }
    }

    d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    private void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        a aVar = this.a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2) {
                    if (depth2 > depth) {
                        continue;
                    } else if (xmlPullParser.getName().equals("item")) {
                        TypedArray a = g.a(resources, theme, attributeSet, j.StateListDrawableItem);
                        Drawable drawable = null;
                        int resourceId = a.getResourceId(j.StateListDrawableItem_android_drawable, -1);
                        if (resourceId > 0) {
                            drawable = android.support.v7.b.a.a.b(context, resourceId);
                        }
                        a.recycle();
                        int[] a2 = a(attributeSet);
                        if (drawable == null) {
                            while (true) {
                                depth2 = xmlPullParser.next();
                                if (depth2 != 4) {
                                    break;
                                }
                            }
                            if (depth2 != 2) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(xmlPullParser.getPositionDescription());
                                stringBuilder.append(": <item> tag requires a 'drawable' attribute or ");
                                stringBuilder.append("child tag defining a drawable");
                                throw new XmlPullParserException(stringBuilder.toString());
                            }
                            drawable = VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        }
                        aVar.a(a2, drawable);
                    }
                }
            } else {
                return;
            }
        }
    }

    private void a(TypedArray typedArray) {
        a aVar = this.a;
        if (VERSION.SDK_INT >= 21) {
            aVar.f |= typedArray.getChangingConfigurations();
        }
        aVar.k = typedArray.getBoolean(j.StateListDrawable_android_variablePadding, aVar.k);
        aVar.n = typedArray.getBoolean(j.StateListDrawable_android_constantSize, aVar.n);
        aVar.C = typedArray.getInt(j.StateListDrawable_android_enterFadeDuration, aVar.C);
        aVar.D = typedArray.getInt(j.StateListDrawable_android_exitFadeDuration, aVar.D);
        aVar.z = typedArray.getBoolean(j.StateListDrawable_android_dither, aVar.z);
    }

    protected void a(b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.a = (a) bVar;
        }
    }

    int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        int i2 = i;
        while (i < attributeCount) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i2 + 1;
                if (!attributeSet.getAttributeBooleanValue(i, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i2] = attributeNameResource;
                i2 = i3;
            }
            i++;
        }
        return StateSet.trimStateSet(iArr, i2);
    }

    public void applyTheme(Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* renamed from: b */
    a c() {
        return new a(this.a, this, null);
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        TypedArray a = g.a(resources, theme, attributeSet, j.StateListDrawable);
        setVisible(a.getBoolean(j.StateListDrawable_android_visible, true), true);
        a(a);
        a(resources);
        a.recycle();
        a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.b && super.mutate() == this) {
            this.a.a();
            this.b = true;
        }
        return this;
    }

    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.a.b(iArr);
        if (b < 0) {
            b = this.a.b(StateSet.WILD_CARD);
        }
        return a(b) || onStateChange;
    }
}
