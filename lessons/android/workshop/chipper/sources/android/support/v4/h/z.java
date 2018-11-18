package android.support.v4.h;

import android.os.Build.VERSION;
import android.view.WindowInsets;

public class z {
    private final Object a;

    private z(Object obj) {
        this.a = obj;
    }

    static z a(Object obj) {
        return obj == null ? null : new z(obj);
    }

    static Object a(z zVar) {
        return zVar == null ? null : zVar.a;
    }

    public int a() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetLeft() : 0;
    }

    public z a(int i, int i2, int i3, int i4) {
        return VERSION.SDK_INT >= 20 ? new z(((WindowInsets) this.a).replaceSystemWindowInsets(i, i2, i3, i4)) : null;
    }

    public int b() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetTop() : 0;
    }

    public int c() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetRight() : 0;
    }

    public int d() {
        return VERSION.SDK_INT >= 20 ? ((WindowInsets) this.a).getSystemWindowInsetBottom() : 0;
    }

    public boolean e() {
        return VERSION.SDK_INT >= 21 ? ((WindowInsets) this.a).isConsumed() : false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.a == null ? zVar.a == null : this.a.equals(zVar.a);
    }

    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
