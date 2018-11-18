package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

final class n {
    ValueAnimator a = null;
    private final ArrayList<a> b = new ArrayList();
    private a c = null;
    private final AnimatorListener d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            if (n.this.a == animator) {
                n.this.a = null;
            }
        }
    };

    static class a {
        final int[] a;
        final ValueAnimator b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }

    n() {
    }

    private void a(a aVar) {
        this.a = aVar.b;
        this.a.start();
    }

    private void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.end();
            this.a = null;
        }
    }

    void a(int[] iArr) {
        a aVar;
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.b.get(i);
            if (StateSet.stateSetMatches(aVar.a, iArr)) {
                break;
            }
        }
        aVar = null;
        if (aVar != this.c) {
            if (this.c != null) {
                b();
            }
            this.c = aVar;
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.b.add(aVar);
    }
}
