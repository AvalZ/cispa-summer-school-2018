package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.k;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public abstract class b<B extends b<B>> {
    static final Handler a = new Handler(Looper.getMainLooper(), new Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    ((b) message.obj).b();
                    return true;
                case 1:
                    ((b) message.obj).b(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    });
    private static final boolean d;
    final f b;
    final a c;
    private final ViewGroup e;
    private final c f;
    private List<a<B>> g;
    private final AccessibilityManager h;

    public static abstract class a<B> {
        public void a(B b) {
        }

        public void a(B b, int i) {
        }
    }

    public interface c {
        void a(int i, int i2);

        void b(int i, int i2);
    }

    interface d {
        void a(View view);

        void b(View view);
    }

    interface e {
        void a(View view, int i, int i2, int i3, int i4);
    }

    static class f extends FrameLayout {
        private e a;
        private d b;

        f(Context context) {
            this(context, null);
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(k.SnackbarLayout_elevation)) {
                r.a((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.b != null) {
                this.b.a(this);
            }
            r.m(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.b != null) {
                this.b.b(this);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.a != null) {
                this.a.a(this, i, i2, i3, i4);
            }
        }

        void setOnAttachStateChangeListener(d dVar) {
            this.b = dVar;
        }

        void setOnLayoutChangeListener(e eVar) {
            this.a = eVar;
        }
    }

    final class b extends SwipeDismissBehavior<f> {
        b() {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, f fVar, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.a((View) fVar, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            m.a().c(b.this.c);
                            break;
                        }
                        break;
                    case 1:
                        break;
                }
            }
            m.a().d(b.this.c);
            return super.a(coordinatorLayout, (View) fVar, motionEvent);
        }

        public boolean a(View view) {
            return view instanceof f;
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        d = z;
    }

    private void d(final int i) {
        if (VERSION.SDK_INT >= 12) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{0, this.b.getHeight()});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    b.this.c(i);
                }

                public void onAnimationStart(Animator animator) {
                    b.this.f.b(0, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                private int b = 0;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.d) {
                        r.c(b.this.b, intValue - this.b);
                    } else {
                        b.this.b.setTranslationY((float) intValue);
                    }
                    this.b = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), android.support.design.a.a.design_snackbar_out);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                b.this.c(i);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    void a(int i) {
        m.a().a(this.c, i);
    }

    public boolean a() {
        return m.a().e(this.c);
    }

    final void b() {
        if (this.b.getParent() == null) {
            LayoutParams layoutParams = this.b.getLayoutParams();
            if (layoutParams instanceof android.support.design.widget.CoordinatorLayout.e) {
                android.support.design.widget.CoordinatorLayout.e eVar = (android.support.design.widget.CoordinatorLayout.e) layoutParams;
                android.support.design.widget.CoordinatorLayout.b bVar = new b();
                bVar.a(0.1f);
                bVar.b(0.6f);
                bVar.a(0);
                bVar.a(new android.support.design.widget.SwipeDismissBehavior.a() {
                    public void a(int i) {
                        switch (i) {
                            case 0:
                                m.a().d(b.this.c);
                                return;
                            case 1:
                            case 2:
                                m.a().c(b.this.c);
                                return;
                            default:
                                return;
                        }
                    }

                    public void a(View view) {
                        view.setVisibility(8);
                        b.this.a(0);
                    }
                });
                eVar.a(bVar);
                eVar.g = 80;
            }
            this.e.addView(this.b);
        }
        this.b.setOnAttachStateChangeListener(new d() {
            public void a(View view) {
            }

            public void b(View view) {
                if (b.this.a()) {
                    b.a.post(new Runnable() {
                        public void run() {
                            b.this.c(3);
                        }
                    });
                }
            }
        });
        if (!r.u(this.b)) {
            this.b.setOnLayoutChangeListener(new e() {
                public void a(View view, int i, int i2, int i3, int i4) {
                    b.this.b.setOnLayoutChangeListener(null);
                    if (b.this.e()) {
                        b.this.c();
                    } else {
                        b.this.d();
                    }
                }
            });
        } else if (e()) {
            c();
        } else {
            d();
        }
    }

    final void b(int i) {
        if (e() && this.b.getVisibility() == 0) {
            d(i);
        } else {
            c(i);
        }
    }

    void c() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.b.getHeight();
            if (d) {
                r.c(this.b, height);
            } else {
                this.b.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(a.b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    b.this.d();
                }

                public void onAnimationStart(Animator animator) {
                    b.this.f.a(70, 180);
                }
            });
            valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                private int c = height;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (b.d) {
                        r.c(b.this.b, intValue - this.c);
                    } else {
                        b.this.b.setTranslationY((float) intValue);
                    }
                    this.c = intValue;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b.getContext(), android.support.design.a.a.design_snackbar_in);
        loadAnimation.setInterpolator(a.b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                b.this.d();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(loadAnimation);
    }

    void c(int i) {
        m.a().a(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                ((a) this.g.get(size)).a(this, i);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.b.setVisibility(8);
        }
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.b);
        }
    }

    void d() {
        m.a().b(this.c);
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                ((a) this.g.get(size)).a(this);
            }
        }
    }

    boolean e() {
        return this.h.isEnabled() ^ 1;
    }
}
