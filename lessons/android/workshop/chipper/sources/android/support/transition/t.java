package android.support.transition;

import android.support.transition.r.a;
import android.view.View;
import android.view.ViewGroup;

public class t {
    private ViewGroup a;
    private Runnable b;

    static t a(View view) {
        return (t) view.getTag(a.transition_current_scene);
    }

    static void a(View view, t tVar) {
        view.setTag(a.transition_current_scene, tVar);
    }

    public void a() {
        if (a(this.a) == this && this.b != null) {
            this.b.run();
        }
    }
}
