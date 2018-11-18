package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.support.transition.u.c;
import android.support.v4.h.r;
import android.view.View;
import android.view.ViewGroup;

public class g extends at {

    private static class a extends AnimatorListenerAdapter {
        private final View a;
        private boolean b = false;

        a(View view) {
            this.a = view;
        }

        public void onAnimationEnd(Animator animator) {
            am.a(this.a, 1.0f);
            if (this.b) {
                this.a.setLayerType(0, null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (r.o(this.a) && this.a.getLayerType() == 0) {
                this.b = true;
                this.a.setLayerType(2, null);
            }
        }
    }

    public g(int i) {
        a(i);
    }

    private static float a(aa aaVar, float f) {
        if (aaVar == null) {
            return f;
        }
        Float f2 = (Float) aaVar.a.get("android:fade:transitionAlpha");
        return f2 != null ? f2.floatValue() : f;
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        am.a(view, f);
        Animator ofFloat = ObjectAnimator.ofFloat(view, am.a, new float[]{f2});
        ofFloat.addListener(new a(view));
        a(new v() {
            public void a(u uVar) {
                am.a(view, 1.0f);
                am.e(view);
                uVar.b((c) this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        float f = 0.0f;
        float a = a(aaVar, 0.0f);
        if (a != 1.0f) {
            f = a;
        }
        return a(view, f, 1.0f);
    }

    public void a(aa aaVar) {
        super.a(aaVar);
        aaVar.a.put("android:fade:transitionAlpha", Float.valueOf(am.c(aaVar.b)));
    }

    public Animator b(ViewGroup viewGroup, View view, aa aaVar, aa aaVar2) {
        am.d(view);
        return a(view, a(aaVar, 1.0f), 0.0f);
    }
}
