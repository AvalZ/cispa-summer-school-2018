package android.support.transition;

import android.os.IBinder;

class au implements aw {
    private final IBinder a;

    au(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof au) && ((au) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
