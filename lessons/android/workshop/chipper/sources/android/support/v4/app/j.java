package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.support.v4.g.k;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class j<E> extends h {
    private final Activity a;
    final l b;
    private final Context c;
    private final Handler d;
    private final int e;

    j(Activity activity, Context context, Handler handler, int i) {
        this.b = new l();
        this.a = activity;
        this.c = (Context) k.a(context, "context == null");
        this.d = (Handler) k.a(handler, "handler == null");
        this.e = i;
    }

    j(g gVar) {
        this(gVar, gVar, gVar.a, 0);
    }

    public View a(int i) {
        return null;
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(f fVar) {
        return true;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.c);
    }

    void b(f fVar) {
    }

    public void c() {
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return this.e;
    }

    Activity f() {
        return this.a;
    }

    Context g() {
        return this.c;
    }

    Handler h() {
        return this.d;
    }

    l i() {
        return this.b;
    }
}
