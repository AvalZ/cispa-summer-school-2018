package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.e;
import android.arch.lifecycle.j;
import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.g.d;
import android.support.v4.g.l;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class f implements e, q, ComponentCallbacks, OnCreateContextMenuListener {
    private static final l<String, Class<?>> X = new l();
    static final Object a = new Object();
    String A;
    boolean B;
    boolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G = true;
    boolean H;
    ViewGroup I;
    View J;
    View K;
    boolean L;
    boolean M = true;
    a N;
    boolean O;
    boolean P;
    float Q;
    LayoutInflater R;
    boolean S;
    android.arch.lifecycle.f T = new android.arch.lifecycle.f(this);
    android.arch.lifecycle.f U;
    e V;
    j<e> W = new j();
    int b = 0;
    Bundle c;
    SparseArray<Parcelable> d;
    Boolean e;
    int f = -1;
    String g;
    Bundle h;
    f i;
    int j = -1;
    int k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    l s;
    j t;
    l u;
    m v;
    p w;
    f x;
    int y;
    int z;

    static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        int f;
        Object g = null;
        Object h = f.a;
        Object i = null;
        Object j = f.a;
        Object k = null;
        Object l = f.a;
        Boolean m;
        Boolean n;
        w o = null;
        w p = null;
        boolean q;
        c r;
        boolean s;

        a() {
        }
    }

    public static class b extends RuntimeException {
        public b(String str, Exception exception) {
            super(str, exception);
        }
    }

    interface c {
        void a();

        void b();
    }

    private a Z() {
        if (this.N == null) {
            this.N = new a();
        }
        return this.N;
    }

    public static f a(Context context, String str, Bundle bundle) {
        StringBuilder stringBuilder;
        try {
            Class cls = (Class) X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            f fVar = (f) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fVar.getClass().getClassLoader());
                fVar.b(bundle);
            }
            return fVar;
        } catch (Exception e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new b(stringBuilder.toString(), e);
        } catch (Exception e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new b(stringBuilder.toString(), e2);
        } catch (Exception e22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": make sure class name exists, is public, and has an");
            stringBuilder.append(" empty constructor that is public");
            throw new b(stringBuilder.toString(), e22);
        } catch (Exception e222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": could not find Fragment constructor");
            throw new b(stringBuilder.toString(), e222);
        } catch (Exception e2222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to instantiate fragment ");
            stringBuilder.append(str);
            stringBuilder.append(": calling Fragment constructor caused an exception");
            throw new b(stringBuilder.toString(), e2222);
        }
    }

    static boolean a(Context context, String str) {
        try {
            Class cls = (Class) X.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                X.put(str, cls);
            }
            return f.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public Object A() {
        return this.N == null ? null : this.N.l == a ? z() : this.N.l;
    }

    public boolean B() {
        return (this.N == null || this.N.n == null) ? true : this.N.n.booleanValue();
    }

    public boolean C() {
        return (this.N == null || this.N.m == null) ? true : this.N.m.booleanValue();
    }

    public void D() {
        if (this.s == null || this.s.m == null) {
            Z().q = false;
        } else if (Looper.myLooper() != this.s.m.h().getLooper()) {
            this.s.m.h().postAtFrontOfQueue(new Runnable() {
                public void run() {
                    f.this.E();
                }
            });
        } else {
            E();
        }
    }

    void E() {
        c cVar;
        if (this.N == null) {
            cVar = null;
        } else {
            this.N.q = false;
            cVar = this.N.r;
            this.N.r = null;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    void F() {
        if (this.t == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.u = new l();
        this.u.a(this.t, new h() {
            public f a(Context context, String str, Bundle bundle) {
                return f.this.t.a(context, str, bundle);
            }

            public View a(int i) {
                if (f.this.J != null) {
                    return f.this.J.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            public boolean a() {
                return f.this.J != null;
            }
        }, this);
    }

    void G() {
        if (this.u != null) {
            this.u.l();
            this.u.f();
        }
        this.b = 3;
        this.H = false;
        m();
        if (this.H) {
            if (this.u != null) {
                this.u.o();
            }
            this.T.a(android.arch.lifecycle.c.a.ON_START);
            if (this.J != null) {
                this.U.a(android.arch.lifecycle.c.a.ON_START);
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onStart()");
        throw new x(stringBuilder.toString());
    }

    void H() {
        if (this.u != null) {
            this.u.l();
            this.u.f();
        }
        this.b = 4;
        this.H = false;
        n();
        if (this.H) {
            if (this.u != null) {
                this.u.p();
                this.u.f();
            }
            this.T.a(android.arch.lifecycle.c.a.ON_RESUME);
            if (this.J != null) {
                this.U.a(android.arch.lifecycle.c.a.ON_RESUME);
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onResume()");
        throw new x(stringBuilder.toString());
    }

    void I() {
        if (this.u != null) {
            this.u.l();
        }
    }

    void J() {
        onLowMemory();
        if (this.u != null) {
            this.u.u();
        }
    }

    void K() {
        if (this.J != null) {
            this.U.a(android.arch.lifecycle.c.a.ON_PAUSE);
        }
        this.T.a(android.arch.lifecycle.c.a.ON_PAUSE);
        if (this.u != null) {
            this.u.q();
        }
        this.b = 3;
        this.H = false;
        o();
        if (!this.H) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onPause()");
            throw new x(stringBuilder.toString());
        }
    }

    void L() {
        this.T.a(android.arch.lifecycle.c.a.ON_STOP);
        if (this.u != null) {
            this.u.r();
        }
        this.b = 2;
        this.H = false;
        p();
        if (!this.H) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onStop()");
            throw new x(stringBuilder.toString());
        }
    }

    void M() {
        if (this.u != null) {
            this.u.s();
        }
        this.b = 1;
        this.H = false;
        q();
        if (this.H) {
            t.a(this).a();
            this.q = false;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroyView()");
        throw new x(stringBuilder.toString());
    }

    void N() {
        this.T.a(android.arch.lifecycle.c.a.ON_DESTROY);
        if (this.u != null) {
            this.u.t();
        }
        this.b = 0;
        this.H = false;
        this.S = false;
        r();
        if (this.H) {
            this.u = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onDestroy()");
        throw new x(stringBuilder.toString());
    }

    void O() {
        this.H = false;
        t();
        this.R = null;
        StringBuilder stringBuilder;
        if (!this.H) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onDetach()");
            throw new x(stringBuilder.toString());
        } else if (this.u == null) {
        } else {
            if (this.E) {
                this.u.t();
                this.u = null;
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Child FragmentManager of ");
            stringBuilder.append(this);
            stringBuilder.append(" was not ");
            stringBuilder.append(" destroyed and this fragment is not retaining instance");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    int P() {
        return this.N == null ? 0 : this.N.d;
    }

    int Q() {
        return this.N == null ? 0 : this.N.e;
    }

    int R() {
        return this.N == null ? 0 : this.N.f;
    }

    w S() {
        return this.N == null ? null : this.N.o;
    }

    w T() {
        return this.N == null ? null : this.N.p;
    }

    View U() {
        return this.N == null ? null : this.N.a;
    }

    Animator V() {
        return this.N == null ? null : this.N.b;
    }

    int W() {
        return this.N == null ? 0 : this.N.c;
    }

    boolean X() {
        return this.N == null ? false : this.N.q;
    }

    boolean Y() {
        return this.N == null ? false : this.N.s;
    }

    public android.arch.lifecycle.c a() {
        return this.T;
    }

    f a(String str) {
        return str.equals(this.g) ? this : this.u != null ? this.u.b(str) : null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    void a(int i) {
        if (this.N != null || i != 0) {
            Z().d = i;
        }
    }

    void a(int i, int i2) {
        if (this.N != null || i != 0 || i2 != 0) {
            Z();
            this.N.e = i;
            this.N.f = i2;
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0027 in {2, 4, 5} preds:[]
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
    final void a(int r1, android.support.v4.app.f r2) {
        /*
        r0 = this;
        r0.f = r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0004:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r2.g;
        r1.append(r2);
        r2 = ":";
    L_0x0010:
        r1.append(r2);
        r2 = r0.f;
        r1.append(r2);
        r1 = r1.toString();
        r0.g = r1;
        return;
    L_0x001f:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "android:fragment:";
        goto L_0x0010;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.f.a(int, android.support.v4.app.f):void");
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    void a(Animator animator) {
        Z().b = animator;
    }

    @Deprecated
    public void a(Activity activity) {
        this.H = true;
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
    }

    public void a(Context context) {
        this.H = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.H = false;
            a(f);
        }
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.H = true;
        Activity f = this.t == null ? null : this.t.f();
        if (f != null) {
            this.H = false;
            a(f, attributeSet, bundle);
        }
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.u != null) {
            this.u.a(configuration);
        }
    }

    final void a(Bundle bundle) {
        if (this.d != null) {
            this.K.restoreHierarchyState(this.d);
            this.d = null;
        }
        this.H = false;
        i(bundle);
        if (!this.H) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onViewStateRestored()");
            throw new x(stringBuilder.toString());
        }
    }

    void a(c cVar) {
        Z();
        if (cVar != this.N.r) {
            if (cVar == null || this.N.r == null) {
                if (this.N.q) {
                    this.N.r = cVar;
                }
                if (cVar != null) {
                    cVar.b();
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to set a replacement startPostponedEnterTransition on ");
            stringBuilder.append(this);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void a(f fVar) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    void a(View view) {
        Z().a = view;
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.z));
        printWriter.print(" mTag=");
        printWriter.println(this.A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f);
        printWriter.print(" mWho=");
        printWriter.print(this.g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.B);
        printWriter.print(" mDetached=");
        printWriter.print(this.C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.M);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.x);
        }
        if (this.h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.h);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        if (this.i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.k);
        }
        if (P() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(P());
        }
        if (this.I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.I);
        }
        if (this.J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.J);
        }
        if (this.K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.J);
        }
        if (U() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(U());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(W());
        }
        if (e() != null) {
            t.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        if (this.u != null) {
            printWriter.print(str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Child ");
            stringBuilder.append(this.u);
            stringBuilder.append(":");
            printWriter.println(stringBuilder.toString());
            l lVar = this.u;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            lVar.a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
        }
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    public p b() {
        if (e() == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.w == null) {
            this.w = new p();
        }
        return this.w;
    }

    void b(int i) {
        Z().c = i;
    }

    public void b(Bundle bundle) {
        if (this.f < 0 || !d()) {
            this.h = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already active and state has been saved");
    }

    void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.u != null) {
            this.u.l();
        }
        this.q = true;
        this.V = new e() {
            public android.arch.lifecycle.c a() {
                if (f.this.U == null) {
                    f.this.U = new android.arch.lifecycle.f(f.this.V);
                }
                return f.this.U;
            }
        };
        this.U = null;
        this.J = a(layoutInflater, viewGroup, bundle);
        if (this.J != null) {
            this.V.a();
            this.W.a(this.V);
        } else if (this.U != null) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        } else {
            this.V = null;
        }
    }

    public void b(Menu menu) {
    }

    public void b(boolean z) {
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            z = true;
            a(menu, menuInflater);
        }
        return this.u != null ? z | this.u.a(menu, menuInflater) : z;
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater c(Bundle bundle) {
        return e(bundle);
    }

    public void c(boolean z) {
    }

    final boolean c() {
        return this.r > 0;
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.B) {
            return false;
        }
        if (this.F && this.G) {
            z = true;
            a(menu);
        }
        return this.u != null ? z | this.u.a(menu) : z;
    }

    boolean c(MenuItem menuItem) {
        if (!this.B) {
            if (this.F && this.G && a(menuItem)) {
                return true;
            }
            if (this.u != null && this.u.a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    LayoutInflater d(Bundle bundle) {
        this.R = c(bundle);
        return this.R;
    }

    void d(Menu menu) {
        if (!this.B) {
            if (this.F && this.G) {
                b(menu);
            }
            if (this.u != null) {
                this.u.b(menu);
            }
        }
    }

    void d(boolean z) {
        b(z);
        if (this.u != null) {
            this.u.a(z);
        }
    }

    public final boolean d() {
        return this.s == null ? false : this.s.c();
    }

    boolean d(MenuItem menuItem) {
        if (!this.B) {
            if (b(menuItem)) {
                return true;
            }
            if (this.u != null && this.u.b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Context e() {
        return this.t == null ? null : this.t.g();
    }

    @Deprecated
    public LayoutInflater e(Bundle bundle) {
        if (this.t == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater b = this.t.b();
        j();
        android.support.v4.h.f.a(b, this.u.w());
        return b;
    }

    void e(boolean z) {
        c(z);
        if (this.u != null) {
            this.u.b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final Context f() {
        Context e = e();
        if (e != null) {
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" not attached to a context.");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void f(Bundle bundle) {
        this.H = true;
        g(bundle);
        if (this.u != null && !this.u.a(1)) {
            this.u.m();
        }
    }

    void f(boolean z) {
        Z().s = z;
    }

    public final g g() {
        return this.t == null ? null : (g) this.t.f();
    }

    void g(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.u == null) {
                    F();
                }
                this.u.a(parcelable, this.v);
                this.v = null;
                this.u.m();
            }
        }
    }

    public final Resources h() {
        return f().getResources();
    }

    public void h(Bundle bundle) {
        this.H = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final k i() {
        return this.s;
    }

    public void i(Bundle bundle) {
        this.H = true;
        if (this.J != null) {
            this.U.a(android.arch.lifecycle.c.a.ON_CREATE);
        }
    }

    public final k j() {
        if (this.u == null) {
            F();
            if (this.b >= 4) {
                this.u.p();
            } else if (this.b >= 3) {
                this.u.o();
            } else if (this.b >= 2) {
                this.u.n();
            } else if (this.b >= 1) {
                this.u.m();
            }
        }
        return this.u;
    }

    public void j(Bundle bundle) {
    }

    k k() {
        return this.u;
    }

    void k(Bundle bundle) {
        if (this.u != null) {
            this.u.l();
        }
        this.b = 1;
        this.H = false;
        f(bundle);
        this.S = true;
        if (this.H) {
            this.T.a(android.arch.lifecycle.c.a.ON_CREATE);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment ");
        stringBuilder.append(this);
        stringBuilder.append(" did not call through to super.onCreate()");
        throw new x(stringBuilder.toString());
    }

    public View l() {
        return this.J;
    }

    void l(Bundle bundle) {
        if (this.u != null) {
            this.u.l();
        }
        this.b = 2;
        this.H = false;
        h(bundle);
        if (!this.H) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Fragment ");
            stringBuilder.append(this);
            stringBuilder.append(" did not call through to super.onActivityCreated()");
            throw new x(stringBuilder.toString());
        } else if (this.u != null) {
            this.u.n();
        }
    }

    public void m() {
        this.H = true;
    }

    void m(Bundle bundle) {
        j(bundle);
        if (this.u != null) {
            Parcelable k = this.u.k();
            if (k != null) {
                bundle.putParcelable("android:support:fragments", k);
            }
        }
    }

    public void n() {
        this.H = true;
    }

    public void o() {
        this.H = true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        g().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.H = true;
    }

    public void p() {
        this.H = true;
    }

    public void q() {
        this.H = true;
        if (this.J != null) {
            this.U.a(android.arch.lifecycle.c.a.ON_DESTROY);
        }
    }

    public void r() {
        boolean z = true;
        this.H = true;
        g g = g();
        if (g == null || !g.isChangingConfigurations()) {
            z = false;
        }
        if (this.w != null && !z) {
            this.w.a();
        }
    }

    void s() {
        this.f = -1;
        this.g = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = null;
        this.u = null;
        this.t = null;
        this.y = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = false;
        this.E = false;
    }

    public void t() {
        this.H = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        d.a(this, stringBuilder);
        if (this.f >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f);
        }
        if (this.y != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.y));
        }
        if (this.A != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.A);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u() {
    }

    public Object v() {
        return this.N == null ? null : this.N.g;
    }

    public Object w() {
        return this.N == null ? null : this.N.h == a ? v() : this.N.h;
    }

    public Object x() {
        return this.N == null ? null : this.N.i;
    }

    public Object y() {
        return this.N == null ? null : this.N.j == a ? x() : this.N.j;
    }

    public Object z() {
        return this.N == null ? null : this.N.k;
    }
}
