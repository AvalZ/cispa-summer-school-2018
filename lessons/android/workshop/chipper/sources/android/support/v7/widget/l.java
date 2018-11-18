package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.c.a.i;
import android.support.v4.g.f;
import android.support.v4.g.g;
import android.support.v4.g.m;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class l {
    private static final Mode a = Mode.SRC_IN;
    private static l b;
    private static final c c = new c(6);
    private static final int[] d = new int[]{android.support.v7.a.a.e.abc_textfield_search_default_mtrl_alpha, android.support.v7.a.a.e.abc_textfield_default_mtrl_alpha, android.support.v7.a.a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] e = new int[]{android.support.v7.a.a.e.abc_ic_commit_search_api_mtrl_alpha, android.support.v7.a.a.e.abc_seekbar_tick_mark_material, android.support.v7.a.a.e.abc_ic_menu_share_mtrl_alpha, android.support.v7.a.a.e.abc_ic_menu_copy_mtrl_am_alpha, android.support.v7.a.a.e.abc_ic_menu_cut_mtrl_alpha, android.support.v7.a.a.e.abc_ic_menu_selectall_mtrl_alpha, android.support.v7.a.a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] f = new int[]{android.support.v7.a.a.e.abc_textfield_activated_mtrl_alpha, android.support.v7.a.a.e.abc_textfield_search_activated_mtrl_alpha, android.support.v7.a.a.e.abc_cab_background_top_mtrl_alpha, android.support.v7.a.a.e.abc_text_cursor_material, android.support.v7.a.a.e.abc_text_select_handle_left_mtrl_dark, android.support.v7.a.a.e.abc_text_select_handle_middle_mtrl_dark, android.support.v7.a.a.e.abc_text_select_handle_right_mtrl_dark, android.support.v7.a.a.e.abc_text_select_handle_left_mtrl_light, android.support.v7.a.a.e.abc_text_select_handle_middle_mtrl_light, android.support.v7.a.a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] g = new int[]{android.support.v7.a.a.e.abc_popup_background_mtrl_mult, android.support.v7.a.a.e.abc_cab_background_internal_bg, android.support.v7.a.a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] h = new int[]{android.support.v7.a.a.e.abc_tab_indicator_material, android.support.v7.a.a.e.abc_textfield_search_material};
    private static final int[] i = new int[]{android.support.v7.a.a.e.abc_btn_check_material, android.support.v7.a.a.e.abc_btn_radio_material};
    private WeakHashMap<Context, m<ColorStateList>> j;
    private android.support.v4.g.a<String, d> k;
    private m<String> l;
    private final WeakHashMap<Context, f<WeakReference<ConstantState>>> m = new WeakHashMap(0);
    private TypedValue n;
    private boolean o;

    private interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    static class a implements d {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.v7.c.a.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    private static class b implements d {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.c.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    private static class c extends g<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, Mode mode) {
            return (PorterDuffColorFilter) a((Object) Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) a(Integer.valueOf(b(i, mode)), porterDuffColorFilter);
        }
    }

    private static class e implements d {
        e() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    static Mode a(int i) {
        return i == android.support.v7.a.a.e.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public static synchronized PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter a;
        synchronized (l.class) {
            a = c.a(i, mode);
            if (a == null) {
                a = new PorterDuffColorFilter(i, mode);
                c.a(i, mode, a);
            }
        }
        return a;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = b(context, i);
        if (b != null) {
            if (ag.b(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.graphics.drawable.a.g(drawable);
            android.support.v4.graphics.drawable.a.a(drawable, b);
            Mode a = a(i);
            if (a != null) {
                android.support.v4.graphics.drawable.a.a(drawable, a);
                return drawable;
            }
        }
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i2;
        if (i == android.support.v7.a.a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), bb.a(context, android.support.v7.a.a.a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i2 = android.support.v7.a.a.a.colorControlNormal;
        } else if (i == android.support.v7.a.a.e.abc_ratingbar_material || i == android.support.v7.a.a.e.abc_ratingbar_indicator_material || i == android.support.v7.a.a.e.abc_ratingbar_small_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), bb.c(context, android.support.v7.a.a.a.colorControlNormal), a);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i2 = android.support.v7.a.a.a.colorControlActivated;
        } else if (!a(context, i, drawable) && z) {
            return null;
        }
        a(findDrawableByLayerId, bb.a(context, i2), a);
        a(layerDrawable.findDrawableByLayerId(16908301), bb.a(context, android.support.v7.a.a.a.colorControlActivated), a);
        return drawable;
        return drawable;
    }

    /* JADX WARNING: Missing block: B:18:0x002c, code:
            return null;
     */
    private synchronized android.graphics.drawable.Drawable a(android.content.Context r4, long r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.m;	 Catch:{ all -> 0x002d }
        r0 = r0.get(r4);	 Catch:{ all -> 0x002d }
        r0 = (android.support.v4.g.f) r0;	 Catch:{ all -> 0x002d }
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r3);
        return r1;
    L_0x000e:
        r2 = r0.a(r5);	 Catch:{ all -> 0x002d }
        r2 = (java.lang.ref.WeakReference) r2;	 Catch:{ all -> 0x002d }
        if (r2 == 0) goto L_0x002b;
    L_0x0016:
        r2 = r2.get();	 Catch:{ all -> 0x002d }
        r2 = (android.graphics.drawable.Drawable.ConstantState) r2;	 Catch:{ all -> 0x002d }
        if (r2 == 0) goto L_0x0028;
    L_0x001e:
        r4 = r4.getResources();	 Catch:{ all -> 0x002d }
        r4 = r2.newDrawable(r4);	 Catch:{ all -> 0x002d }
        monitor-exit(r3);
        return r4;
    L_0x0028:
        r0.b(r5);	 Catch:{ all -> 0x002d }
    L_0x002b:
        monitor-exit(r3);
        return r1;
    L_0x002d:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = new l();
                a(b);
            }
            lVar = b;
        }
        return lVar;
    }

    private void a(Context context, int i, ColorStateList colorStateList) {
        if (this.j == null) {
            this.j = new WeakHashMap();
        }
        m mVar = (m) this.j.get(context);
        if (mVar == null) {
            mVar = new m();
            this.j.put(context, mVar);
        }
        mVar.c(i, colorStateList);
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (ag.b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = a;
        }
        drawable.setColorFilter(a(i, mode));
    }

    static void a(Drawable drawable, be beVar, int[] iArr) {
        if (!ag.b(drawable) || drawable.mutate() == drawable) {
            if (beVar.d || beVar.c) {
                drawable.setColorFilter(a(beVar.d ? beVar.a : null, beVar.c ? beVar.b : a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    private static void a(l lVar) {
        if (VERSION.SDK_INT < 24) {
            lVar.a("vector", new e());
            lVar.a("animated-vector", new b());
            lVar.a("animated-selector", new a());
        }
    }

    private void a(String str, d dVar) {
        if (this.k == null) {
            this.k = new android.support.v4.g.a();
        }
        this.k.put(str, dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060 A:{RETURN} */
    static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
        r0 = a;
        r1 = d;
        r1 = a(r1, r7);
        r2 = 16842801; // 0x1010031 float:2.3693695E-38 double:8.3214494E-317;
        r3 = -1;
        r4 = 0;
        r5 = 1;
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r2 = android.support.v7.a.a.a.colorControlNormal;
    L_0x0012:
        r1 = r3;
    L_0x0013:
        r7 = r5;
        goto L_0x0043;
    L_0x0015:
        r1 = f;
        r1 = a(r1, r7);
        if (r1 == 0) goto L_0x0020;
    L_0x001d:
        r2 = android.support.v7.a.a.a.colorControlActivated;
        goto L_0x0012;
    L_0x0020:
        r1 = g;
        r1 = a(r1, r7);
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r0 = android.graphics.PorterDuff.Mode.MULTIPLY;
        goto L_0x0012;
    L_0x002b:
        r1 = android.support.v7.a.a.e.abc_list_divider_mtrl_alpha;
        if (r7 != r1) goto L_0x003b;
    L_0x002f:
        r2 = 16842800; // 0x1010030 float:2.3693693E-38 double:8.321449E-317;
        r7 = 1109603123; // 0x42233333 float:40.8 double:5.482167836E-315;
        r7 = java.lang.Math.round(r7);
        r1 = r7;
        goto L_0x0013;
    L_0x003b:
        r1 = android.support.v7.a.a.e.abc_dialog_material_background;
        if (r7 != r1) goto L_0x0040;
    L_0x003f:
        goto L_0x0012;
    L_0x0040:
        r1 = r3;
        r7 = r4;
        r2 = r7;
    L_0x0043:
        if (r7 == 0) goto L_0x0060;
    L_0x0045:
        r7 = android.support.v7.widget.ag.b(r8);
        if (r7 == 0) goto L_0x004f;
    L_0x004b:
        r8 = r8.mutate();
    L_0x004f:
        r6 = android.support.v7.widget.bb.a(r6, r2);
        r6 = a(r6, r0);
        r8.setColorFilter(r6);
        if (r1 == r3) goto L_0x005f;
    L_0x005c:
        r8.setAlpha(r1);
    L_0x005f:
        return r5;
    L_0x0060:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private synchronized boolean a(Context context, long j, Drawable drawable) {
        boolean z;
        ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            f fVar = (f) this.m.get(context);
            if (fVar == null) {
                fVar = new f();
                this.m.put(context, fVar);
            }
            fVar.b(j, new WeakReference(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList b(Context context) {
        return f(context, bb.a(context, android.support.v7.a.a.a.colorButtonNormal));
    }

    private ColorStateList c(Context context) {
        return f(context, 0);
    }

    private Drawable c(Context context, int i) {
        if (this.n == null) {
            this.n = new TypedValue();
        }
        TypedValue typedValue = this.n;
        context.getResources().getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        if (i == android.support.v7.a.a.e.abc_cab_background_top_material) {
            a2 = new LayerDrawable(new Drawable[]{a(context, android.support.v7.a.a.e.abc_cab_background_internal_bg), a(context, android.support.v7.a.a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a2 != null) {
            a2.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a, a2);
        }
        return a2;
    }

    private ColorStateList d(Context context) {
        return f(context, bb.a(context, android.support.v7.a.a.a.colorAccent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A:{Catch:{ Exception -> 0x00a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079 A:{Catch:{ Exception -> 0x00a8 }} */
    private android.graphics.drawable.Drawable d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r0 = r9.k;
        r1 = 0;
        if (r0 == 0) goto L_0x00ba;
    L_0x0005:
        r0 = r9.k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00ba;
    L_0x000d:
        r0 = r9.l;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        r0 = r9.l;
        r0 = r0.a(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002b;
    L_0x0021:
        if (r0 == 0) goto L_0x0033;
    L_0x0023:
        r2 = r9.k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0033;
    L_0x002b:
        return r1;
    L_0x002c:
        r0 = new android.support.v4.g.m;
        r0.<init>();
        r9.l = r0;
    L_0x0033:
        r0 = r9.n;
        if (r0 != 0) goto L_0x003e;
    L_0x0037:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.n = r0;
    L_0x003e:
        r0 = r9.n;
        r1 = r10.getResources();
        r2 = 1;
        r1.getValue(r11, r0, r2);
        r3 = a(r0);
        r5 = r9.a(r10, r3);
        if (r5 == 0) goto L_0x0053;
    L_0x0052:
        return r5;
    L_0x0053:
        r6 = r0.string;
        if (r6 == 0) goto L_0x00b0;
    L_0x0057:
        r6 = r0.string;
        r6 = r6.toString();
        r7 = ".xml";
        r6 = r6.endsWith(r7);
        if (r6 == 0) goto L_0x00b0;
    L_0x0065:
        r1 = r1.getXml(r11);	 Catch:{ Exception -> 0x00a8 }
        r6 = android.util.Xml.asAttributeSet(r1);	 Catch:{ Exception -> 0x00a8 }
    L_0x006d:
        r7 = r1.next();	 Catch:{ Exception -> 0x00a8 }
        r8 = 2;
        if (r7 == r8) goto L_0x0077;
    L_0x0074:
        if (r7 == r2) goto L_0x0077;
    L_0x0076:
        goto L_0x006d;
    L_0x0077:
        if (r7 == r8) goto L_0x0081;
    L_0x0079:
        r10 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x00a8 }
        r0 = "No start tag found";
        r10.<init>(r0);	 Catch:{ Exception -> 0x00a8 }
        throw r10;	 Catch:{ Exception -> 0x00a8 }
    L_0x0081:
        r2 = r1.getName();	 Catch:{ Exception -> 0x00a8 }
        r7 = r9.l;	 Catch:{ Exception -> 0x00a8 }
        r7.c(r11, r2);	 Catch:{ Exception -> 0x00a8 }
        r7 = r9.k;	 Catch:{ Exception -> 0x00a8 }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x00a8 }
        r2 = (android.support.v7.widget.l.d) r2;	 Catch:{ Exception -> 0x00a8 }
        if (r2 == 0) goto L_0x009d;
    L_0x0094:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x00a8 }
        r1 = r2.a(r10, r1, r6, r7);	 Catch:{ Exception -> 0x00a8 }
        r5 = r1;
    L_0x009d:
        if (r5 == 0) goto L_0x00b0;
    L_0x009f:
        r0 = r0.changingConfigurations;	 Catch:{ Exception -> 0x00a8 }
        r5.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x00a8 }
        r9.a(r10, r3, r5);	 Catch:{ Exception -> 0x00a8 }
        goto L_0x00b0;
    L_0x00a8:
        r10 = move-exception;
        r0 = "AppCompatDrawableManag";
        r1 = "Exception while inflating drawable";
        android.util.Log.e(r0, r1, r10);
    L_0x00b0:
        if (r5 != 0) goto L_0x00b9;
    L_0x00b2:
        r9 = r9.l;
        r10 = "appcompat_skip_skip";
        r9.c(r11, r10);
    L_0x00b9:
        return r5;
    L_0x00ba:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = bb.b(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
        if (b == null || !b.isStateful()) {
            iArr[0] = bb.a;
            iArr2[0] = bb.c(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
            iArr[1] = bb.e;
            iArr2[1] = bb.a(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = bb.h;
            iArr2[2] = bb.a(context, android.support.v7.a.a.a.colorSwitchThumbNormal);
        } else {
            iArr[0] = bb.a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = bb.e;
            iArr2[1] = bb.a(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = bb.h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList e(Context context, int i) {
        if (this.j == null) {
            return null;
        }
        m mVar = (m) this.j.get(context);
        return mVar != null ? (ColorStateList) mVar.a(i) : null;
    }

    private ColorStateList f(Context context, int i) {
        r0 = new int[4][];
        r4 = new int[4];
        int a = bb.a(context, android.support.v7.a.a.a.colorControlHighlight);
        int c = bb.c(context, android.support.v7.a.a.a.colorButtonNormal);
        r0[0] = bb.a;
        r4[0] = c;
        r0[1] = bb.d;
        r4[1] = android.support.v4.graphics.a.a(a, i);
        r0[2] = bb.b;
        r4[2] = android.support.v4.graphics.a.a(a, i);
        r0[3] = bb.h;
        r4[3] = i;
        return new ColorStateList(r0, r4);
    }

    private void f(Context context) {
        if (!this.o) {
            this.o = true;
            Drawable a = a(context, android.support.v7.a.a.e.abc_vector_test);
            if (a == null || !a(a)) {
                this.o = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    public synchronized Drawable a(Context context, int i) {
        return a(context, i, false);
    }

    synchronized Drawable a(Context context, int i, boolean z) {
        Drawable d;
        f(context);
        d = d(context, i);
        if (d == null) {
            d = c(context, i);
        }
        if (d == null) {
            d = android.support.v4.a.a.a(context, i);
        }
        if (d != null) {
            d = a(context, i, z, d);
        }
        if (d != null) {
            ag.a(d);
        }
        return d;
    }

    synchronized Drawable a(Context context, bl blVar, int i) {
        Drawable d = d(context, i);
        if (d == null) {
            d = blVar.a(i);
        }
        if (d == null) {
            return null;
        }
        return a(context, i, false, d);
    }

    public synchronized void a(Context context) {
        f fVar = (f) this.m.get(context);
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078  */
    synchronized android.content.res.ColorStateList b(android.content.Context r3, int r4) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.e(r3, r4);	 Catch:{ all -> 0x007d }
        if (r0 != 0) goto L_0x007b;
    L_0x0007:
        r1 = android.support.v7.a.a.e.abc_edit_text_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x0013;
    L_0x000b:
        r0 = android.support.v7.a.a.c.abc_tint_edittext;	 Catch:{ all -> 0x007d }
    L_0x000d:
        r0 = android.support.v7.b.a.a.a(r3, r0);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x0013:
        r1 = android.support.v7.a.a.e.abc_switch_track_mtrl_alpha;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x001a;
    L_0x0017:
        r0 = android.support.v7.a.a.c.abc_tint_switch_track;	 Catch:{ all -> 0x007d }
        goto L_0x000d;
    L_0x001a:
        r1 = android.support.v7.a.a.e.abc_switch_thumb_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x0023;
    L_0x001e:
        r0 = r2.e(r3);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x0023:
        r1 = android.support.v7.a.a.e.abc_btn_default_mtrl_shape;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x002c;
    L_0x0027:
        r0 = r2.b(r3);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x002c:
        r1 = android.support.v7.a.a.e.abc_btn_borderless_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x0035;
    L_0x0030:
        r0 = r2.c(r3);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x0035:
        r1 = android.support.v7.a.a.e.abc_btn_colored_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x003e;
    L_0x0039:
        r0 = r2.d(r3);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x003e:
        r1 = android.support.v7.a.a.e.abc_spinner_mtrl_am_alpha;	 Catch:{ all -> 0x007d }
        if (r4 == r1) goto L_0x0073;
    L_0x0042:
        r1 = android.support.v7.a.a.e.abc_spinner_textfield_background_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x0047;
    L_0x0046:
        goto L_0x0073;
    L_0x0047:
        r1 = e;	 Catch:{ all -> 0x007d }
        r1 = a(r1, r4);	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x0056;
    L_0x004f:
        r0 = android.support.v7.a.a.a.colorControlNormal;	 Catch:{ all -> 0x007d }
        r0 = android.support.v7.widget.bb.b(r3, r0);	 Catch:{ all -> 0x007d }
        goto L_0x0076;
    L_0x0056:
        r1 = h;	 Catch:{ all -> 0x007d }
        r1 = a(r1, r4);	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r0 = android.support.v7.a.a.c.abc_tint_default;	 Catch:{ all -> 0x007d }
        goto L_0x000d;
    L_0x0061:
        r1 = i;	 Catch:{ all -> 0x007d }
        r1 = a(r1, r4);	 Catch:{ all -> 0x007d }
        if (r1 == 0) goto L_0x006c;
    L_0x0069:
        r0 = android.support.v7.a.a.c.abc_tint_btn_checkable;	 Catch:{ all -> 0x007d }
        goto L_0x000d;
    L_0x006c:
        r1 = android.support.v7.a.a.e.abc_seekbar_thumb_material;	 Catch:{ all -> 0x007d }
        if (r4 != r1) goto L_0x0076;
    L_0x0070:
        r0 = android.support.v7.a.a.c.abc_tint_seek_thumb;	 Catch:{ all -> 0x007d }
        goto L_0x000d;
    L_0x0073:
        r0 = android.support.v7.a.a.c.abc_tint_spinner;	 Catch:{ all -> 0x007d }
        goto L_0x000d;
    L_0x0076:
        if (r0 == 0) goto L_0x007b;
    L_0x0078:
        r2.a(r3, r4, r0);	 Catch:{ all -> 0x007d }
    L_0x007b:
        monitor-exit(r2);
        return r0;
    L_0x007d:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.l.b(android.content.Context, int):android.content.res.ColorStateList");
    }
}
