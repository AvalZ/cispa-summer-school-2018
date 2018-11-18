package android.support.v4.app;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class c extends p implements h {
    final l a;
    ArrayList<a> b = new ArrayList();
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    static final class a {
        int a;
        f b;
        int c;
        int d;
        int e;
        int f;

        a() {
        }

        a(int i, f fVar) {
            this.a = i;
            this.b = fVar;
        }
    }

    public c(l lVar) {
        this.a = lVar;
    }

    private static boolean b(a aVar) {
        f fVar = aVar.b;
        return (fVar == null || !fVar.l || fVar.J == null || fVar.C || fVar.B || !fVar.X()) ? false : true;
    }

    f a(ArrayList<f> arrayList, f fVar) {
        f fVar2 = fVar;
        int i = 0;
        while (i < this.b.size()) {
            a aVar = (a) this.b.get(i);
            switch (aVar.a) {
                case 1:
                case 7:
                    arrayList.add(aVar.b);
                    break;
                case 2:
                    f fVar3 = aVar.b;
                    int i2 = fVar3.z;
                    f fVar4 = fVar2;
                    int i3 = i;
                    i = 0;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        f fVar5 = (f) arrayList.get(size);
                        if (fVar5.z == i2) {
                            if (fVar5 == fVar3) {
                                i = 1;
                            } else {
                                if (fVar5 == fVar4) {
                                    this.b.add(i3, new a(9, fVar5));
                                    i3++;
                                    fVar4 = null;
                                }
                                a aVar2 = new a(3, fVar5);
                                aVar2.c = aVar.c;
                                aVar2.e = aVar.e;
                                aVar2.d = aVar.d;
                                aVar2.f = aVar.f;
                                this.b.add(i3, aVar2);
                                arrayList.remove(fVar5);
                                i3++;
                            }
                        }
                    }
                    if (i != 0) {
                        this.b.remove(i3);
                        i3--;
                    } else {
                        aVar.a = 1;
                        arrayList.add(fVar3);
                    }
                    i = i3;
                    fVar2 = fVar4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.b);
                    if (aVar.b != fVar2) {
                        break;
                    }
                    this.b.add(i, new a(9, aVar.b));
                    i++;
                    fVar2 = null;
                    break;
                case 8:
                    this.b.add(i, new a(9, fVar2));
                    i++;
                    fVar2 = aVar.b;
                    break;
                default:
                    break;
            }
            i++;
        }
        return fVar2;
    }

    public void a() {
        if (this.u != null) {
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                ((Runnable) this.u.get(i)).run();
            }
            this.u = null;
        }
    }

    void a(int i) {
        if (this.i) {
            if (l.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bump nesting in ");
                stringBuilder.append(this);
                stringBuilder.append(" by ");
                stringBuilder.append(i);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) this.b.get(i2);
                if (aVar.b != null) {
                    f fVar = aVar.b;
                    fVar.r += i;
                    if (l.a) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Bump nesting of ");
                        stringBuilder2.append(aVar.b);
                        stringBuilder2.append(" to ");
                        stringBuilder2.append(aVar.b.r);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                }
            }
        }
    }

    void a(a aVar) {
        this.b.add(aVar);
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
    }

    void a(c cVar) {
        for (int i = 0; i < this.b.size(); i++) {
            a aVar = (a) this.b.get(i);
            if (b(aVar)) {
                aVar.b.a(cVar);
            }
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (!(this.c == 0 && this.d == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (!(this.e == 0 && this.f == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (!(this.n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (!(this.p == 0 && this.q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            stringBuilder.toString();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                String str2;
                a aVar = (a) this.b.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("cmd=");
                        stringBuilder2.append(aVar.a);
                        str2 = stringBuilder2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.b);
                if (z) {
                    if (!(aVar.c == 0 && aVar.d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    void a(boolean z) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            a aVar = (a) this.b.get(size);
            f fVar = aVar.b;
            if (fVar != null) {
                fVar.a(l.d(this.g), this.h);
            }
            int i = aVar.a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        fVar.a(aVar.e);
                        this.a.a(fVar, false);
                        break;
                    case 4:
                        fVar.a(aVar.e);
                        this.a.j(fVar);
                        break;
                    case 5:
                        fVar.a(aVar.f);
                        this.a.i(fVar);
                        break;
                    case 6:
                        fVar.a(aVar.e);
                        this.a.l(fVar);
                        break;
                    case 7:
                        fVar.a(aVar.f);
                        this.a.k(fVar);
                        break;
                    case 8:
                        this.a.o(null);
                        break;
                    case 9:
                        this.a.o(fVar);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown cmd: ");
                        stringBuilder.append(aVar.a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            fVar.a(aVar.f);
            this.a.h(fVar);
            if (!(this.t || aVar.a == 3 || fVar == null)) {
                this.a.e(fVar);
            }
        }
        if (!this.t && z) {
            this.a.a(this.a.l, true);
        }
    }

    boolean a(ArrayList<c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = (a) this.b.get(i4);
            int i5 = aVar.b != null ? aVar.b.z : 0;
            if (!(i5 == 0 || i5 == i3)) {
                for (i3 = i; i3 < i2; i3++) {
                    c cVar = (c) arrayList.get(i3);
                    int size2 = cVar.b.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        a aVar2 = (a) cVar.b.get(i6);
                        if ((aVar2.b != null ? aVar2.b.z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public boolean a(ArrayList<c> arrayList, ArrayList<Boolean> arrayList2) {
        if (l.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append(this);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.i) {
            this.a.a(this);
        }
        return true;
    }

    f b(ArrayList<f> arrayList, f fVar) {
        for (int i = 0; i < this.b.size(); i++) {
            a aVar = (a) this.b.get(i);
            int i2 = aVar.a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fVar = null;
                            break;
                        case 9:
                            fVar = aVar.b;
                            break;
                        default:
                            break;
                    }
                }
                arrayList.add(aVar.b);
            }
            arrayList.remove(aVar.b);
        }
        return fVar;
    }

    void b() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) this.b.get(i);
            f fVar = aVar.b;
            if (fVar != null) {
                fVar.a(this.g, this.h);
            }
            int i2 = aVar.a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        fVar.a(aVar.d);
                        this.a.h(fVar);
                        break;
                    case 4:
                        fVar.a(aVar.d);
                        this.a.i(fVar);
                        break;
                    case 5:
                        fVar.a(aVar.c);
                        this.a.j(fVar);
                        break;
                    case 6:
                        fVar.a(aVar.d);
                        this.a.k(fVar);
                        break;
                    case 7:
                        fVar.a(aVar.c);
                        this.a.l(fVar);
                        break;
                    case 8:
                        this.a.o(fVar);
                        break;
                    case 9:
                        this.a.o(null);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown cmd: ");
                        stringBuilder.append(aVar.a);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            fVar.a(aVar.c);
            this.a.a(fVar, false);
            if (!(this.t || aVar.a == 1 || fVar == null)) {
                this.a.e(fVar);
            }
        }
        if (!this.t) {
            this.a.a(this.a.l, true);
        }
    }

    boolean b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.b.get(i2);
            int i3 = aVar.b != null ? aVar.b.z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    boolean c() {
        for (int i = 0; i < this.b.size(); i++) {
            if (b((a) this.b.get(i))) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.m);
        }
        if (this.k != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.k);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
