package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.transition.u.c;
import android.support.v4.h.r;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

public class f extends u {
    private static final String[] g = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> h = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        private Rect a = new Rect();

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            return new PointF((float) this.a.left, (float) this.a.top);
        }

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    };
    private static final Property<a, PointF> i = new Property<a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };
    private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };
    private static final Property<View, PointF> k = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            am.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            am.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            am.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static s q = new s();
    private int[] n = new int[2];
    private boolean o = false;
    private boolean p = false;

    private static class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        private void a() {
            am.a(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        void b(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }
    }

    /* JADX WARNING: Missing block: B:9:0x0013, code:
            if (r4 == r2.b) goto L_0x0015;
     */
    private boolean a(android.view.View r3, android.view.View r4) {
        /*
        r2 = this;
        r0 = r2.p;
        r1 = 1;
        if (r0 == 0) goto L_0x0015;
    L_0x0005:
        r2 = r2.b(r3, r1);
        r0 = 0;
        if (r2 != 0) goto L_0x0011;
    L_0x000c:
        if (r3 != r4) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r1 = r0;
        return r1;
    L_0x0011:
        r2 = r2.b;
        if (r4 != r2) goto L_0x000f;
    L_0x0015:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.f.a(android.view.View, android.view.View):boolean");
    }

    private void d(aa aaVar) {
        View view = aaVar.b;
        if (r.u(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            aaVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            aaVar.a.put("android:changeBounds:parent", aaVar.b.getParent());
            if (this.p) {
                aaVar.b.getLocationInWindow(this.n);
                aaVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.n[0]));
                aaVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.n[1]));
            }
            if (this.o) {
                aaVar.a.put("android:changeBounds:clip", r.w(view));
            }
        }
    }

    public Animator a(ViewGroup viewGroup, aa aaVar, aa aaVar2) {
        aa aaVar3 = aaVar;
        aa aaVar4 = aaVar2;
        if (aaVar3 == null || aaVar4 == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) aaVar3.a.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) aaVar4.a.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = aaVar4.b;
        int i;
        int i2;
        int i3;
        Animator animator;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect = (Rect) aaVar3.a.get("android:changeBounds:bounds");
            Rect rect2 = (Rect) aaVar4.a.get("android:changeBounds:bounds");
            int i4 = rect.left;
            int i5 = rect2.left;
            int i6 = rect.top;
            int i7 = rect2.top;
            int i8 = rect.right;
            int i9 = rect2.right;
            i = rect.bottom;
            int i10 = rect2.bottom;
            int i11 = i8 - i4;
            i2 = i - i6;
            int i12 = i9 - i5;
            int i13 = i10 - i7;
            View view2 = view;
            Rect rect3 = (Rect) aaVar3.a.get("android:changeBounds:clip");
            Rect rect4 = (Rect) aaVar4.a.get("android:changeBounds:clip");
            if ((i11 == 0 || i2 == 0) && (i12 == 0 || i13 == 0)) {
                i3 = 0;
            } else {
                i3 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i == i10)) {
                    i3++;
                }
            }
            if (!(rect3 == null || rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                i3++;
            }
            if (i3 > 0) {
                Animator a;
                Rect rect5 = rect4;
                Rect rect6 = rect3;
                if (this.o) {
                    Rect rect7;
                    view = view2;
                    am.a(view, i4, i6, Math.max(i11, i12) + i4, Math.max(i2, i13) + i6);
                    Animator a2 = (i4 == i5 && i6 == i7) ? null : h.a(view, m, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                    if (rect6 == null) {
                        i = 0;
                        rect7 = new Rect(0, 0, i11, i2);
                    } else {
                        i = 0;
                        rect7 = rect6;
                    }
                    if (rect7.equals(rect5 == null ? new Rect(i, i, i12, i13) : rect5)) {
                        animator = null;
                    } else {
                        r.a(view, rect7);
                        animator = ObjectAnimator.ofObject(view, "clipBounds", q, new Object[]{rect7, r2});
                        final View view3 = view;
                        rect = rect5;
                        i13 = i5;
                        i11 = i7;
                        i4 = i9;
                        i5 = i10;
                        animator.addListener(new AnimatorListenerAdapter() {
                            private boolean h;

                            public void onAnimationCancel(Animator animator) {
                                this.h = true;
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (!this.h) {
                                    r.a(view3, rect);
                                    am.a(view3, i13, i11, i4, i5);
                                }
                            }
                        });
                    }
                    a = z.a(a2, animator);
                } else {
                    Path a3;
                    Property property;
                    view = view2;
                    am.a(view, i4, i6, i8, i);
                    if (i3 == 2) {
                        if (i11 == i12 && i2 == i13) {
                            a3 = l().a((float) i4, (float) i6, (float) i5, (float) i7);
                            property = m;
                        } else {
                            final a aVar = new a(view);
                            ObjectAnimator a4 = h.a(aVar, i, l().a((float) i4, (float) i6, (float) i5, (float) i7));
                            ObjectAnimator a5 = h.a(aVar, j, l().a((float) i8, (float) i, (float) i9, (float) i10));
                            Animator animatorSet = new AnimatorSet();
                            animatorSet.playTogether(new Animator[]{a4, a5});
                            animatorSet.addListener(new AnimatorListenerAdapter() {
                                private a mViewBounds = aVar;
                            });
                            a = animatorSet;
                        }
                    } else if (i4 == i5 && i6 == i7) {
                        a3 = l().a((float) i8, (float) i, (float) i9, (float) i10);
                        property = k;
                    } else {
                        a3 = l().a((float) i4, (float) i6, (float) i5, (float) i7);
                        property = l;
                    }
                    a = h.a(view, property, a3);
                }
                if (view.getParent() instanceof ViewGroup) {
                    final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    af.a(viewGroup4, true);
                    a(new v() {
                        boolean a = false;

                        public void a(u uVar) {
                            if (!this.a) {
                                af.a(viewGroup4, false);
                            }
                            uVar.b((c) this);
                        }

                        public void b(u uVar) {
                            af.a(viewGroup4, false);
                        }

                        public void c(u uVar) {
                            af.a(viewGroup4, true);
                        }
                    });
                }
                return a;
            }
        }
        i2 = ((Integer) aaVar3.a.get("android:changeBounds:windowX")).intValue();
        int intValue = ((Integer) aaVar3.a.get("android:changeBounds:windowY")).intValue();
        i = ((Integer) aaVar4.a.get("android:changeBounds:windowX")).intValue();
        i3 = ((Integer) aaVar4.a.get("android:changeBounds:windowY")).intValue();
        if (!(i2 == i && intValue == i3)) {
            ViewGroup viewGroup5 = viewGroup;
            viewGroup5.getLocationInWindow(this.n);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            Drawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c = am.c(view);
            am.a(view, 0.0f);
            am.a(viewGroup).a(bitmapDrawable);
            PropertyValuesHolder a6 = n.a(h, l().a((float) (i2 - this.n[0]), (float) (intValue - this.n[1]), (float) (i - this.n[0]), (float) (i3 - this.n[1])));
            animator = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{a6});
            final ViewGroup viewGroup6 = viewGroup5;
            final Drawable drawable = bitmapDrawable;
            final View view4 = view;
            final float f = c;
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    am.a(viewGroup6).b(drawable);
                    am.a(view4, f);
                }
            });
            return animator;
        }
        return null;
    }

    public void a(aa aaVar) {
        d(aaVar);
    }

    public String[] a() {
        return g;
    }

    public void b(aa aaVar) {
        d(aaVar);
    }
}
