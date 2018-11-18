package android.support.transition;

import android.view.View;
import android.view.WindowId;

class av implements aw {
    private final WindowId a;

    av(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof av) && ((av) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
