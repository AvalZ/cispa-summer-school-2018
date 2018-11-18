package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class bk {
    private final Context a;
    private final View b;
    private final TextView c;
    private final LayoutParams d = new LayoutParams();
    private final Rect e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    bk(Context context) {
        this.a = context;
        this.b = LayoutInflater.from(this.a).inflate(g.abc_tooltip, null);
        this.c = (TextView) this.b.findViewById(f.message);
        this.d.setTitle(getClass().getSimpleName());
        this.d.packageName = this.a.getPackageName();
        this.d.type = 1002;
        this.d.width = -2;
        this.d.height = -2;
        this.d.format = -3;
        this.d.windowAnimations = i.Animation_AppCompat_Tooltip;
        this.d.flags = 24;
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof LayoutParams) && ((LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:35:0x00f3 in {2, 3, 6, 7, 10, 11, 15, 22, 23, 24, 27, 29, 31, 34} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    private void a(android.view.View r9, int r10, int r11, boolean r12, android.view.WindowManager.LayoutParams r13) {
        /*
        r8 = this;
        r0 = r9.getApplicationWindowToken();
        r13.token = r0;
        r0 = r8.a;
        r0 = r0.getResources();
        r1 = android.support.v7.a.a.d.tooltip_precise_anchor_threshold;
        r0 = r0.getDimensionPixelOffset(r1);
        r1 = r9.getWidth();
        if (r1 < r0) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r10 = r9.getWidth();
        r10 = r10 / 2;
    L_0x001f:
        r1 = r9.getHeight();
        r2 = 0;
        if (r1 < r0) goto L_0x0036;
    L_0x0026:
        r0 = r8.a;
        r0 = r0.getResources();
        r1 = android.support.v7.a.a.d.tooltip_precise_anchor_extra_offset;
        r0 = r0.getDimensionPixelOffset(r1);
        r1 = r11 + r0;
        r11 = r11 - r0;
        goto L_0x003b;
    L_0x0036:
        r1 = r9.getHeight();
        r11 = r2;
    L_0x003b:
        r0 = 49;
        r13.gravity = r0;
        r0 = r8.a;
        r0 = r0.getResources();
        if (r12 == 0) goto L_0x004a;
    L_0x0047:
        r3 = android.support.v7.a.a.d.tooltip_y_offset_touch;
        goto L_0x004c;
    L_0x004a:
        r3 = android.support.v7.a.a.d.tooltip_y_offset_non_touch;
    L_0x004c:
        r0 = r0.getDimensionPixelOffset(r3);
        r3 = a(r9);
        if (r3 != 0) goto L_0x005e;
    L_0x0056:
        r8 = "TooltipPopup";
        r9 = "Cannot find app view";
        android.util.Log.e(r8, r9);
        return;
    L_0x005e:
        r4 = r8.e;
        r3.getWindowVisibleDisplayFrame(r4);
        r4 = r8.e;
        r4 = r4.left;
        if (r4 >= 0) goto L_0x0094;
    L_0x0069:
        r4 = r8.e;
        r4 = r4.top;
        if (r4 >= 0) goto L_0x0094;
    L_0x006f:
        r4 = r8.a;
        r4 = r4.getResources();
        r5 = "status_bar_height";
        r6 = "dimen";
        r7 = "android";
        r5 = r4.getIdentifier(r5, r6, r7);
        if (r5 == 0) goto L_0x0086;
    L_0x0081:
        r5 = r4.getDimensionPixelSize(r5);
        goto L_0x0087;
    L_0x0086:
        r5 = r2;
    L_0x0087:
        r4 = r4.getDisplayMetrics();
        r6 = r8.e;
        r7 = r4.widthPixels;
        r4 = r4.heightPixels;
        r6.set(r2, r5, r7, r4);
    L_0x0094:
        r4 = r8.g;
        r3.getLocationOnScreen(r4);
        r4 = r8.f;
        r9.getLocationOnScreen(r4);
        r9 = r8.f;
        r4 = r9[r2];
        r5 = r8.g;
        r5 = r5[r2];
        r4 = r4 - r5;
        r9[r2] = r4;
        r9 = r8.f;
        r4 = 1;
        r5 = r9[r4];
        r6 = r8.g;
        r6 = r6[r4];
        r5 = r5 - r6;
        r9[r4] = r5;
        r9 = r8.f;
        r9 = r9[r2];
        r9 = r9 + r10;
        r10 = r3.getWidth();
        r10 = r10 / 2;
        r9 = r9 - r10;
        r13.x = r9;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r2);
        r10 = r8.b;
        r10.measure(r9, r9);
        r9 = r8.b;
        r9 = r9.getMeasuredHeight();
        r10 = r8.f;
        r10 = r10[r4];
        r10 = r10 + r11;
        r10 = r10 - r0;
        r10 = r10 - r9;
        r11 = r8.f;
        r11 = r11[r4];
        r11 = r11 + r1;
        r11 = r11 + r0;
        if (r12 == 0) goto L_0x00e9;
    L_0x00e1:
        if (r10 < 0) goto L_0x00e6;
    L_0x00e3:
        r13.y = r10;
        return;
    L_0x00e6:
        r13.y = r11;
        return;
    L_0x00e9:
        r9 = r9 + r11;
        r8 = r8.e;
        r8 = r8.height();
        if (r9 > r8) goto L_0x00e3;
    L_0x00f2:
        goto L_0x00e6;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.bk.a(android.view.View, int, int, boolean, android.view.WindowManager$LayoutParams):void");
    }

    void a() {
        if (b()) {
            ((WindowManager) this.a.getSystemService("window")).removeView(this.b);
        }
    }

    void a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.c.setText(charSequence);
        a(view, i, i2, z, this.d);
        ((WindowManager) this.a.getSystemService("window")).addView(this.b, this.d);
    }

    boolean b() {
        return this.b.getParent() != null;
    }
}
