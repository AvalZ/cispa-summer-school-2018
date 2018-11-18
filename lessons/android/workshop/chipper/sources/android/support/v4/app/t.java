package android.support.v4.app;

import android.arch.lifecycle.e;
import android.arch.lifecycle.q;
import android.support.v4.a.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class t {

    public interface a<D> {
        void a(b<D> bVar);

        void a(b<D> bVar, D d);
    }

    public static <T extends e & q> t a(T t) {
        return new LoaderManagerImpl(t, ((q) t).b());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
