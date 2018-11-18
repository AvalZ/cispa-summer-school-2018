package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.h.r;
import android.support.v4.widget.k;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;

public class ao implements s {
    private static Method a;
    private static Method b;
    private static Method h;
    private Drawable A;
    private OnItemClickListener B;
    private OnItemSelectedListener C;
    private final d D;
    private final c E;
    private final a F;
    private Runnable G;
    private final Rect H;
    private Rect I;
    private boolean J;
    ah c;
    int d;
    final e e;
    final Handler f;
    PopupWindow g;
    private Context i;
    private ListAdapter j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private boolean v;
    private View w;
    private int x;
    private DataSetObserver y;
    private View z;

    private class a implements Runnable {
        a() {
        }

        public void run() {
            ao.this.m();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            if (ao.this.d()) {
                ao.this.a();
            }
        }

        public void onInvalidated() {
            ao.this.c();
        }
    }

    private class c implements OnScrollListener {
        c() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !ao.this.n() && ao.this.g.getContentView() != null) {
                ao.this.f.removeCallbacks(ao.this.e);
                ao.this.e.run();
            }
        }
    }

    private class d implements OnTouchListener {
        d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ao.this.g != null && ao.this.g.isShowing() && x >= 0 && x < ao.this.g.getWidth() && y >= 0 && y < ao.this.g.getHeight()) {
                ao.this.f.postDelayed(ao.this.e, 250);
            } else if (action == 1) {
                ao.this.f.removeCallbacks(ao.this.e);
            }
            return false;
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void run() {
            if (ao.this.c != null && r.x(ao.this.c) && ao.this.c.getCount() > ao.this.c.getChildCount() && ao.this.c.getChildCount() <= ao.this.d) {
                ao.this.g.setInputMethodMode(2);
                ao.this.a();
            }
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public ao(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ao(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ao(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = -2;
        this.l = -2;
        this.o = 1002;
        this.q = true;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.d = Integer.MAX_VALUE;
        this.x = 0;
        this.e = new e();
        this.D = new d();
        this.E = new c();
        this.F = new a();
        this.H = new Rect();
        this.i = context;
        this.f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ListPopupWindow, i, i2);
        this.m = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.n = obtainStyledAttributes.getDimensionPixelOffset(j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.n != 0) {
            this.p = true;
        }
        obtainStyledAttributes.recycle();
        this.g = new s(context, attributeSet, i, i2);
        this.g.setInputMethodMode(1);
    }

    private int a(View view, int i, boolean z) {
        if (b != null) {
            try {
                return ((Integer) b.invoke(this.g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.g.getMaxAvailableHeight(view, i);
    }

    private void b() {
        if (this.w != null) {
            ViewParent parent = this.w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.w);
            }
        }
    }

    private void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int f() {
        int i;
        int i2;
        boolean z = true;
        if (this.c == null) {
            Context context = this.i;
            this.G = new Runnable() {
                public void run() {
                    View i = ao.this.i();
                    if (i != null && i.getWindowToken() != null) {
                        ao.this.a();
                    }
                }
            };
            this.c = a(context, this.J ^ true);
            if (this.A != null) {
                this.c.setSelector(this.A);
            }
            this.c.setAdapter(this.j);
            this.c.setOnItemClickListener(this.B);
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        ah ahVar = ao.this.c;
                        if (ahVar != null) {
                            ahVar.setListSelectionHidden(false);
                        }
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.c.setOnScrollListener(this.E);
            if (this.C != null) {
                this.c.setOnItemSelectedListener(this.C);
            }
            View view = this.c;
            View view2 = this.w;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid hint position ");
                        stringBuilder.append(this.x);
                        Log.e("ListPopupWindow", stringBuilder.toString());
                        break;
                }
                if (this.l >= 0) {
                    i = this.l;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i = 0;
                    i2 = i;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                i = (view2.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                i = 0;
            }
            this.g.setContentView(view);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.g.getContentView();
            View view3 = this.w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i = (view3.getMeasuredHeight() + layoutParams3.topMargin) + layoutParams3.bottomMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            i2 = this.H.top + this.H.bottom;
            if (!this.p) {
                this.n = -this.H.top;
            }
        } else {
            this.H.setEmpty();
            i2 = 0;
        }
        if (this.g.getInputMethodMode() != 2) {
            z = false;
        }
        int a = a(i(), this.n, z);
        if (this.u || this.k == -1) {
            return a + i2;
        }
        int makeMeasureSpec;
        switch (this.l) {
            case -2:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = this.i.getResources().getDisplayMetrics().widthPixels - (this.H.left + this.H.right);
                break;
            default:
                makeMeasureSpec = this.l;
                break;
        }
        makeMeasureSpec = MeasureSpec.makeMeasureSpec(makeMeasureSpec, 1073741824);
        makeMeasureSpec = this.c.a(makeMeasureSpec, 0, -1, a - i, -1);
        if (makeMeasureSpec > 0) {
            i += i2 + (this.c.getPaddingTop() + this.c.getPaddingBottom());
        }
        return makeMeasureSpec + i;
    }

    ah a(Context context, boolean z) {
        return new ah(context, z);
    }

    public void a() {
        int f = f();
        boolean n = n();
        k.a(this.g, this.o);
        boolean z = true;
        if (!this.g.isShowing()) {
            int width = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                f = -1;
            } else if (this.k != -2) {
                f = this.k;
            }
            this.g.setWidth(width);
            this.g.setHeight(f);
            c(true);
            PopupWindow popupWindow = this.g;
            n = (this.v || this.u) ? false : true;
            popupWindow.setOutsideTouchable(n);
            this.g.setTouchInterceptor(this.D);
            if (this.s) {
                k.a(this.g, this.r);
            }
            if (h != null) {
                try {
                    h.invoke(this.g, new Object[]{this.I});
                } catch (Throwable e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
            k.a(this.g, i(), this.m, this.n, this.t);
            this.c.setSelection(-1);
            if (!this.J || this.c.isInTouchMode()) {
                m();
            }
            if (!this.J) {
                this.f.post(this.F);
            }
        } else if (r.x(i())) {
            int width2 = this.l == -1 ? -1 : this.l == -2 ? i().getWidth() : this.l;
            if (this.k == -1) {
                if (!n) {
                    f = -1;
                }
                if (n) {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(0);
                } else {
                    this.g.setWidth(this.l == -1 ? -1 : 0);
                    this.g.setHeight(-1);
                }
            } else if (this.k != -2) {
                f = this.k;
            }
            PopupWindow popupWindow2 = this.g;
            if (this.v || this.u) {
                z = false;
            }
            popupWindow2.setOutsideTouchable(z);
            this.g.update(i(), this.m, this.n, width2 < 0 ? -1 : width2, f < 0 ? -1 : f);
        }
    }

    public void a(int i) {
        this.x = i;
    }

    public void a(Rect rect) {
        this.I = rect;
    }

    public void a(Drawable drawable) {
        this.g.setBackgroundDrawable(drawable);
    }

    public void a(OnItemClickListener onItemClickListener) {
        this.B = onItemClickListener;
    }

    public void a(ListAdapter listAdapter) {
        if (this.y == null) {
            this.y = new b();
        } else if (this.j != null) {
            this.j.unregisterDataSetObserver(this.y);
        }
        this.j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.y);
        }
        if (this.c != null) {
            this.c.setAdapter(this.j);
        }
    }

    public void a(OnDismissListener onDismissListener) {
        this.g.setOnDismissListener(onDismissListener);
    }

    public void a(boolean z) {
        this.J = z;
        this.g.setFocusable(z);
    }

    public void b(int i) {
        this.g.setAnimationStyle(i);
    }

    public void b(View view) {
        this.z = view;
    }

    public void b(boolean z) {
        this.s = true;
        this.r = z;
    }

    public void c() {
        this.g.dismiss();
        b();
        this.g.setContentView(null);
        this.c = null;
        this.f.removeCallbacks(this.e);
    }

    public void c(int i) {
        this.m = i;
    }

    public void d(int i) {
        this.n = i;
        this.p = true;
    }

    public boolean d() {
        return this.g.isShowing();
    }

    public ListView e() {
        return this.c;
    }

    public void e(int i) {
        this.t = i;
    }

    public void f(int i) {
        this.l = i;
    }

    public void g(int i) {
        Drawable background = this.g.getBackground();
        if (background != null) {
            background.getPadding(this.H);
            this.l = (this.H.left + this.H.right) + i;
            return;
        }
        f(i);
    }

    public boolean g() {
        return this.J;
    }

    public Drawable h() {
        return this.g.getBackground();
    }

    public void h(int i) {
        this.g.setInputMethodMode(i);
    }

    public View i() {
        return this.z;
    }

    public void i(int i) {
        ah ahVar = this.c;
        if (d() && ahVar != null) {
            ahVar.setListSelectionHidden(false);
            ahVar.setSelection(i);
            if (ahVar.getChoiceMode() != 0) {
                ahVar.setItemChecked(i, true);
            }
        }
    }

    public int j() {
        return this.m;
    }

    public int k() {
        return !this.p ? 0 : this.n;
    }

    public int l() {
        return this.l;
    }

    public void m() {
        ah ahVar = this.c;
        if (ahVar != null) {
            ahVar.setListSelectionHidden(true);
            ahVar.requestLayout();
        }
    }

    public boolean n() {
        return this.g.getInputMethodMode() == 2;
    }
}
