package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.j;
import android.arch.lifecycle.k;
import android.arch.lifecycle.n;
import android.arch.lifecycle.o;
import android.arch.lifecycle.p;
import android.os.Bundle;
import android.support.v4.g.d;
import android.support.v4.g.m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class LoaderManagerImpl extends t {
    static boolean a = false;
    private final e b;
    private final LoaderViewModel c;

    static class LoaderViewModel extends n {
        private static final android.arch.lifecycle.o.a a = new android.arch.lifecycle.o.a() {
            public <T extends n> T a(Class<T> cls) {
                return new LoaderViewModel();
            }
        };
        private m<a> b = new m();
        private boolean c = false;

        LoaderViewModel() {
        }

        static LoaderViewModel a(p pVar) {
            return (LoaderViewModel) new o(pVar, a).a(LoaderViewModel.class);
        }

        protected void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                ((a) this.b.e(i)).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("    ");
                String stringBuilder2 = stringBuilder.toString();
                for (int i = 0; i < this.b.b(); i++) {
                    a aVar = (a) this.b.e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.a(stringBuilder2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                ((a) this.b.e(i)).g();
            }
        }
    }

    static class b<D> implements k<D> {
        private final android.support.v4.a.b<D> a;
        private final android.support.v4.app.t.a<D> b;
        private boolean c;

        public void a(D d) {
            if (LoaderManagerImpl.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.a);
                stringBuilder.append(": ");
                stringBuilder.append(this.a.a((Object) d));
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.b.a(this.a, d);
            this.c = true;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (LoaderManagerImpl.a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.a);
                    Log.v("LoaderManager", stringBuilder.toString());
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    public static class a<D> extends j<D> implements android.support.v4.a.b.a<D> {
        private final int a;
        private final Bundle b;
        private final android.support.v4.a.b<D> c;
        private e d;
        private b<D> e;
        private android.support.v4.a.b<D> f;

        android.support.v4.a.b<D> a(boolean z) {
            if (LoaderManagerImpl.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Destroying: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.c();
            this.c.g();
            k kVar = this.e;
            if (kVar != null) {
                a(kVar);
                if (z) {
                    kVar.b();
                }
            }
            this.c.a((android.support.v4.a.b.a) this);
            if ((kVar == null || kVar.a()) && !z) {
                return this.c;
            }
            this.c.i();
            return this.f;
        }

        public void a(k<? super D> kVar) {
            super.a((k) kVar);
            this.d = null;
            this.e = null;
        }

        public void a(D d) {
            super.a(d);
            if (this.f != null) {
                this.f.i();
                this.f = null;
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            android.support.v4.a.b bVar = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("  ");
            bVar.a(stringBuilder.toString(), fileDescriptor, printWriter, strArr);
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                b bVar2 = this.e;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("  ");
                bVar2.a(stringBuilder2.toString(), printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(f().a(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }

        protected void b() {
            if (LoaderManagerImpl.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Starting: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.a();
        }

        protected void c() {
            if (LoaderManagerImpl.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Stopping: ");
                stringBuilder.append(this);
                Log.v("LoaderManager", stringBuilder.toString());
            }
            this.c.e();
        }

        android.support.v4.a.b<D> f() {
            return this.c;
        }

        void g() {
            e eVar = this.d;
            k kVar = this.e;
            if (eVar != null && kVar != null) {
                super.a(kVar);
                a(eVar, kVar);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.a);
            stringBuilder.append(" : ");
            d.a(this.c, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    LoaderManagerImpl(e eVar, p pVar) {
        this.b = eVar;
        this.c = LoaderViewModel.a(pVar);
    }

    public void a() {
        this.c.b();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        d.a(this.b, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
