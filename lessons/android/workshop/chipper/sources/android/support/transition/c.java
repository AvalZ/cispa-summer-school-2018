package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class c implements d {
    c() {
    }

    public void a(Animator animator) {
        animator.pause();
    }

    public void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public void b(Animator animator) {
        animator.resume();
    }
}
