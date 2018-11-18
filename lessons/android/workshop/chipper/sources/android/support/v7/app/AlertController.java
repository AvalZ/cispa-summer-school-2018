package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.h.r;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class AlertController {
    private int A;
    private boolean B = false;
    private CharSequence C;
    private Drawable D;
    private CharSequence E;
    private Drawable F;
    private CharSequence G;
    private Drawable H;
    private int I = 0;
    private Drawable J;
    private ImageView K;
    private TextView L;
    private TextView M;
    private View N;
    private int O;
    private int P;
    private boolean Q;
    private int R = 0;
    private final OnClickListener S = new OnClickListener() {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
        public void onClick(android.view.View r2) {
            /*
            r1 = this;
            r0 = android.support.v7.app.AlertController.this;
            r0 = r0.c;
            if (r2 != r0) goto L_0x0015;
        L_0x0006:
            r0 = android.support.v7.app.AlertController.this;
            r0 = r0.d;
            if (r0 == 0) goto L_0x0015;
        L_0x000c:
            r2 = android.support.v7.app.AlertController.this;
            r2 = r2.d;
        L_0x0010:
            r2 = android.os.Message.obtain(r2);
            goto L_0x0038;
        L_0x0015:
            r0 = android.support.v7.app.AlertController.this;
            r0 = r0.e;
            if (r2 != r0) goto L_0x0026;
        L_0x001b:
            r0 = android.support.v7.app.AlertController.this;
            r0 = r0.f;
            if (r0 == 0) goto L_0x0026;
        L_0x0021:
            r2 = android.support.v7.app.AlertController.this;
            r2 = r2.f;
            goto L_0x0010;
        L_0x0026:
            r0 = android.support.v7.app.AlertController.this;
            r0 = r0.g;
            if (r2 != r0) goto L_0x0037;
        L_0x002c:
            r2 = android.support.v7.app.AlertController.this;
            r2 = r2.h;
            if (r2 == 0) goto L_0x0037;
        L_0x0032:
            r2 = android.support.v7.app.AlertController.this;
            r2 = r2.h;
            goto L_0x0010;
        L_0x0037:
            r2 = 0;
        L_0x0038:
            if (r2 == 0) goto L_0x003d;
        L_0x003a:
            r2.sendToTarget();
        L_0x003d:
            r2 = android.support.v7.app.AlertController.this;
            r2 = r2.p;
            r0 = 1;
            r1 = android.support.v7.app.AlertController.this;
            r1 = r1.a;
            r1 = r2.obtainMessage(r0, r1);
            r1.sendToTarget();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AlertController.1.onClick(android.view.View):void");
        }
    };
    final g a;
    ListView b;
    Button c;
    Message d;
    Button e;
    Message f;
    Button g;
    Message h;
    NestedScrollView i;
    ListAdapter j;
    int k = -1;
    int l;
    int m;
    int n;
    int o;
    Handler p;
    private final Context q;
    private final Window r;
    private final int s;
    private CharSequence t;
    private CharSequence u;
    private View v;
    private int w;
    private int x;
    private int y;
    private int z;

    public static class RecycleListView extends ListView {
        private final int a;
        private final int b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.RecycleListView);
            this.b = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingBottomNoButtons, -1);
            this.a = obtainStyledAttributes.getDimensionPixelOffset(j.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.a, getPaddingRight(), z2 ? getPaddingBottom() : this.b);
            }
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E = false;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public int I = -1;
        public OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public OnItemSelectedListener N;
        public a O;
        public boolean P = true;
        public final Context a;
        public final LayoutInflater b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public OnCancelListener s;
        public OnDismissListener t;
        public OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        public interface a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.a = context;
            this.r = true;
            this.b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00a1  */
        private void b(final android.support.v7.app.AlertController r11) {
            /*
            r10 = this;
            r0 = r10.b;
            r1 = r11.l;
            r2 = 0;
            r0 = r0.inflate(r1, r2);
            r0 = (android.support.v7.app.AlertController.RecycleListView) r0;
            r1 = r10.G;
            r8 = 1;
            if (r1 == 0) goto L_0x0035;
        L_0x0010:
            r1 = r10.K;
            if (r1 != 0) goto L_0x0026;
        L_0x0014:
            r9 = new android.support.v7.app.AlertController$a$1;
            r3 = r10.a;
            r4 = r11.m;
            r5 = 16908308; // 0x1020014 float:2.3877285E-38 double:8.353814E-317;
            r6 = r10.v;
            r1 = r9;
            r2 = r10;
            r7 = r0;
            r1.<init>(r3, r4, r5, r6, r7);
            goto L_0x006e;
        L_0x0026:
            r9 = new android.support.v7.app.AlertController$a$2;
            r3 = r10.a;
            r4 = r10.K;
            r5 = 0;
            r1 = r9;
            r2 = r10;
            r6 = r0;
            r7 = r11;
            r1.<init>(r3, r4, r5, r6, r7);
            goto L_0x006e;
        L_0x0035:
            r1 = r10.H;
            if (r1 == 0) goto L_0x003d;
        L_0x0039:
            r1 = r11.n;
        L_0x003b:
            r4 = r1;
            goto L_0x0040;
        L_0x003d:
            r1 = r11.o;
            goto L_0x003b;
        L_0x0040:
            r1 = r10.K;
            r2 = 16908308; // 0x1020014 float:2.3877285E-38 double:8.353814E-317;
            if (r1 == 0) goto L_0x005e;
        L_0x0047:
            r1 = new android.widget.SimpleCursorAdapter;
            r3 = r10.a;
            r5 = r10.K;
            r6 = new java.lang.String[r8];
            r7 = r10.L;
            r9 = 0;
            r6[r9] = r7;
            r7 = new int[r8];
            r7[r9] = r2;
            r2 = r1;
            r2.<init>(r3, r4, r5, r6, r7);
            r9 = r1;
            goto L_0x006e;
        L_0x005e:
            r1 = r10.w;
            if (r1 == 0) goto L_0x0065;
        L_0x0062:
            r9 = r10.w;
            goto L_0x006e;
        L_0x0065:
            r9 = new android.support.v7.app.AlertController$c;
            r1 = r10.a;
            r3 = r10.v;
            r9.<init>(r1, r4, r2, r3);
        L_0x006e:
            r1 = r10.O;
            if (r1 == 0) goto L_0x0077;
        L_0x0072:
            r1 = r10.O;
            r1.a(r0);
        L_0x0077:
            r11.j = r9;
            r1 = r10.I;
            r11.k = r1;
            r1 = r10.x;
            if (r1 == 0) goto L_0x008a;
        L_0x0081:
            r1 = new android.support.v7.app.AlertController$a$3;
            r1.<init>(r11);
        L_0x0086:
            r0.setOnItemClickListener(r1);
            goto L_0x0094;
        L_0x008a:
            r1 = r10.J;
            if (r1 == 0) goto L_0x0094;
        L_0x008e:
            r1 = new android.support.v7.app.AlertController$a$4;
            r1.<init>(r0, r11);
            goto L_0x0086;
        L_0x0094:
            r1 = r10.N;
            if (r1 == 0) goto L_0x009d;
        L_0x0098:
            r1 = r10.N;
            r0.setOnItemSelectedListener(r1);
        L_0x009d:
            r1 = r10.H;
            if (r1 == 0) goto L_0x00a5;
        L_0x00a1:
            r0.setChoiceMode(r8);
            goto L_0x00ad;
        L_0x00a5:
            r10 = r10.G;
            if (r10 == 0) goto L_0x00ad;
        L_0x00a9:
            r10 = 2;
            r0.setChoiceMode(r10);
        L_0x00ad:
            r11.b = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AlertController.a.b(android.support.v7.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            if (this.g != null) {
                alertController.b(this.g);
            } else {
                if (this.f != null) {
                    alertController.a(this.f);
                }
                if (this.d != null) {
                    alertController.a(this.d);
                }
                if (this.c != 0) {
                    alertController.b(this.c);
                }
                if (this.e != 0) {
                    alertController.b(alertController.c(this.e));
                }
            }
            if (this.h != null) {
                alertController.b(this.h);
            }
            if (!(this.i == null && this.j == null)) {
                alertController.a(-1, this.i, this.k, null, this.j);
            }
            if (!(this.l == null && this.m == null)) {
                alertController.a(-2, this.l, this.n, null, this.m);
            }
            if (!(this.o == null && this.p == null)) {
                alertController.a(-3, this.o, this.q, null, this.p);
            }
            if (!(this.v == null && this.K == null && this.w == null)) {
                b(alertController);
            }
            if (this.z == null) {
                if (this.y != 0) {
                    alertController.a(this.y);
                }
            } else if (this.E) {
                alertController.a(this.z, this.A, this.B, this.C, this.D);
            } else {
                alertController.c(this.z);
            }
        }
    }

    private static final class b extends Handler {
        private WeakReference<DialogInterface> a;

        public b(DialogInterface dialogInterface) {
            this.a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                switch (i) {
                    case -3:
                    case -2:
                    case -1:
                        ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.a.get(), message.what);
                        return;
                    default:
                        return;
                }
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, g gVar, Window window) {
        this.q = context;
        this.a = gVar;
        this.r = window;
        this.p = new b(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.AlertDialog, android.support.v7.a.a.a.alertDialogStyle, 0);
        this.O = obtainStyledAttributes.getResourceId(j.AlertDialog_android_layout, 0);
        this.P = obtainStyledAttributes.getResourceId(j.AlertDialog_buttonPanelSideLayout, 0);
        this.l = obtainStyledAttributes.getResourceId(j.AlertDialog_listLayout, 0);
        this.m = obtainStyledAttributes.getResourceId(j.AlertDialog_multiChoiceItemLayout, 0);
        this.n = obtainStyledAttributes.getResourceId(j.AlertDialog_singleChoiceItemLayout, 0);
        this.o = obtainStyledAttributes.getResourceId(j.AlertDialog_listItemLayout, 0);
        this.Q = obtainStyledAttributes.getBoolean(j.AlertDialog_showTitle, true);
        this.s = obtainStyledAttributes.getDimensionPixelSize(j.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        gVar.a(1);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    static void a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }

    private void a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.v != null ? this.v : this.w != 0 ? LayoutInflater.from(this.q).inflate(this.w, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && a(inflate))) {
            this.r.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.r.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.B) {
                frameLayout.setPadding(this.x, this.y, this.z, this.A);
            }
            if (this.b != null) {
                ((android.support.v7.widget.an.a) viewGroup.getLayoutParams()).g = 0.0f;
                return;
            }
        }
        viewGroup.setVisibility(8);
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View findViewById = this.r.findViewById(f.scrollIndicatorUp);
        View findViewById2 = this.r.findViewById(f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            r.a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
        }
        view = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (!(findViewById == null && view == null)) {
            if (this.u != null) {
                this.i.setOnScrollChangeListener(new android.support.v4.widget.NestedScrollView.b() {
                    public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.a(nestedScrollView, findViewById, view);
                    }
                });
                this.i.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.i, findViewById, view);
                    }
                });
            } else if (this.b != null) {
                this.b.setOnScrollListener(new OnScrollListener() {
                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.a(absListView, findViewById, view);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.b.post(new Runnable() {
                    public void run() {
                        AlertController.a(AlertController.this.b, findViewById, view);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view != null) {
                    viewGroup.removeView(view);
                }
            }
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int b() {
        return this.P == 0 ? this.O : this.R == 1 ? this.P : this.O;
    }

    private void b(ViewGroup viewGroup) {
        if (this.N != null) {
            viewGroup.addView(this.N, 0, new LayoutParams(-1, -2));
            this.r.findViewById(f.title_template).setVisibility(8);
            return;
        }
        this.K = (ImageView) this.r.findViewById(16908294);
        if ((TextUtils.isEmpty(this.t) ^ 1) == 0 || !this.Q) {
            this.r.findViewById(f.title_template).setVisibility(8);
            this.K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.L = (TextView) this.r.findViewById(f.alertTitle);
        this.L.setText(this.t);
        if (this.I != 0) {
            this.K.setImageResource(this.I);
        } else if (this.J != null) {
            this.K.setImageDrawable(this.J);
        } else {
            this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
            this.K.setVisibility(8);
        }
    }

    private void c() {
        View findViewById = this.r.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        a(viewGroup);
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        View findViewById6 = viewGroup.findViewById(f.contentPanel);
        View findViewById7 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup a = a(findViewById5, findViewById2);
        ViewGroup a2 = a(findViewById6, findViewById3);
        ViewGroup a3 = a(findViewById7, findViewById4);
        c(a2);
        d(a3);
        b(a);
        int i = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById5 = a2.findViewById(f.textSpacerNoButtons);
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
        }
        if (z2) {
            if (this.i != null) {
                this.i.setClipToPadding(true);
            }
            findViewById5 = null;
            if (!(this.u == null && this.b == null)) {
                findViewById5 = a.findViewById(f.titleDividerNoCustom);
            }
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
        } else if (a2 != null) {
            findViewById2 = a2.findViewById(f.textSpacerNoTitle);
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        if (this.b instanceof RecycleListView) {
            ((RecycleListView) this.b).a(z2, z3);
        }
        if (!z) {
            findViewById = this.b != null ? this.b : this.i;
            if (findViewById != null) {
                if (z3) {
                    i = 2;
                }
                a(a2, findViewById, z2 | i, 3);
            }
        }
        ListView listView = this.b;
        if (listView != null && this.j != null) {
            listView.setAdapter(this.j);
            int i2 = this.k;
            if (i2 > -1) {
                listView.setItemChecked(i2, true);
                listView.setSelection(i2);
            }
        }
    }

    private void c(ViewGroup viewGroup) {
        this.i = (NestedScrollView) this.r.findViewById(f.scrollView);
        this.i.setFocusable(false);
        this.i.setNestedScrollingEnabled(false);
        this.M = (TextView) viewGroup.findViewById(16908299);
        if (this.M != null) {
            if (this.u != null) {
                this.M.setText(this.u);
                return;
            }
            this.M.setVisibility(8);
            this.i.removeView(this.M);
            if (this.b != null) {
                viewGroup = (ViewGroup) this.i.getParent();
                int indexOfChild = viewGroup.indexOfChild(this.i);
                viewGroup.removeViewAt(indexOfChild);
                viewGroup.addView(this.b, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void d(ViewGroup viewGroup) {
        int i;
        this.c = (Button) viewGroup.findViewById(16908313);
        this.c.setOnClickListener(this.S);
        int i2 = 1;
        if (TextUtils.isEmpty(this.C) && this.D == null) {
            this.c.setVisibility(8);
            i = 0;
        } else {
            this.c.setText(this.C);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.c.setVisibility(0);
            i = 1;
        }
        this.e = (Button) viewGroup.findViewById(16908314);
        this.e.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.E) && this.F == null) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(this.E);
            if (this.F != null) {
                this.F.setBounds(0, 0, this.s, this.s);
                this.e.setCompoundDrawables(this.F, null, null, null);
            }
            this.e.setVisibility(0);
            i |= 2;
        }
        this.g = (Button) viewGroup.findViewById(16908315);
        this.g.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.G) && this.H == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.G);
            if (this.D != null) {
                this.D.setBounds(0, 0, this.s, this.s);
                this.c.setCompoundDrawables(this.D, null, null, null);
            }
            this.g.setVisibility(0);
            i |= 4;
        }
        if (a(this.q)) {
            Button button;
            if (i == 1) {
                button = this.c;
            } else if (i == 2) {
                button = this.e;
            } else if (i == 4) {
                button = this.g;
            }
            a(button);
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void a() {
        this.a.setContentView(b());
        c();
    }

    public void a(int i) {
        this.v = null;
        this.w = i;
        this.B = false;
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.G = charSequence;
                this.h = message;
                this.H = drawable;
                return;
            case -2:
                this.E = charSequence;
                this.f = message;
                this.F = drawable;
                return;
            case -1:
                this.C = charSequence;
                this.d = message;
                this.D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.J = drawable;
        this.I = 0;
        if (this.K != null) {
            if (drawable != null) {
                this.K.setVisibility(0);
                this.K.setImageDrawable(drawable);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.v = view;
        this.w = 0;
        this.B = true;
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.A = i4;
    }

    public void a(CharSequence charSequence) {
        this.t = charSequence;
        if (this.L != null) {
            this.L.setText(charSequence);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public void b(int i) {
        this.J = null;
        this.I = i;
        if (this.K != null) {
            if (i != 0) {
                this.K.setVisibility(0);
                this.K.setImageResource(this.I);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void b(View view) {
        this.N = view;
    }

    public void b(CharSequence charSequence) {
        this.u = charSequence;
        if (this.M != null) {
            this.M.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return this.i != null && this.i.a(keyEvent);
    }

    public int c(int i) {
        TypedValue typedValue = new TypedValue();
        this.q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(View view) {
        this.v = view;
        this.w = 0;
        this.B = false;
    }
}
