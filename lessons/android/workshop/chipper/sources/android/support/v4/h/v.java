package android.support.v4.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class v {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    static class a implements w {
        v a;
        boolean b;

        a(v vVar) {
            this.a = vVar;
        }

        public void a(View view) {
            this.b = false;
            w wVar = null;
            if (this.a.c > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                Runnable runnable = this.a.a;
                this.a.a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof w) {
                wVar = (w) tag;
            }
            if (wVar != null) {
                wVar.a(view);
            }
        }

        public void b(View view) {
            w wVar = null;
            if (this.a.c > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (VERSION.SDK_INT >= 16 || !this.b) {
                if (this.a.b != null) {
                    Runnable runnable = this.a.b;
                    this.a.b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof w) {
                    wVar = (w) tag;
                }
                if (wVar != null) {
                    wVar.b(view);
                }
                this.b = true;
            }
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            w wVar = tag instanceof w ? (w) tag : null;
            if (wVar != null) {
                wVar.c(view);
            }
        }
    }

    v(View view) {
        this.d = new WeakReference(view);
    }

    private void a(final View view, final w wVar) {
        if (wVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    wVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    wVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    wVar.a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    public long a() {
        View view = (View) this.d.get();
        return view != null ? view.animate().getDuration() : 0;
    }

    public v a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public v a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public v a(w wVar) {
        View view = (View) this.d.get();
        if (view == null) {
            return this;
        }
        if (VERSION.SDK_INT < 16) {
            view.setTag(2113929216, wVar);
            wVar = new a(this);
        }
        a(view, wVar);
        return this;
    }

    public v a(final y yVar) {
        final View view = (View) this.d.get();
        if (view != null && VERSION.SDK_INT >= 19) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (yVar != null) {
                animatorUpdateListener = new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        yVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public v a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public v b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public v b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
