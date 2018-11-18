package android.support.v4.a;

import android.support.v4.g.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b<D> {
    int a;
    a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    public interface a<D> {
    }

    public String a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        b();
    }

    public void a(a<D> aVar) {
        if (this.b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.b != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.b = null;
        }
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }

    protected void b() {
    }

    public boolean c() {
        return d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.c = false;
        f();
    }

    protected void f() {
    }

    public void g() {
        this.d = true;
        h();
    }

    protected void h() {
    }

    public void i() {
        j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    protected void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        d.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
