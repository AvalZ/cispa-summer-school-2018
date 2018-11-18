package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ak implements al {
    private final ViewOverlay a;

    ak(View view) {
        this.a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
