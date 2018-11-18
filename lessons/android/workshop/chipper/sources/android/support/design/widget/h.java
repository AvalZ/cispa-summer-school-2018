package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

class h extends g {
    private InsetDrawable p;

    static class a extends GradientDrawable {
        a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    h(u uVar, l lVar) {
        super(uVar, lVar);
    }

    public float a() {
        return this.n.getElevation();
    }

    void a(float f, float f2) {
        if (VERSION.SDK_INT == 21) {
            if (this.n.isEnabled()) {
                this.n.setElevation(f);
                if (this.n.isFocused() || this.n.isPressed()) {
                    this.n.setTranslationZ(f2);
                }
            } else {
                this.n.setElevation(0.0f);
            }
            this.n.setTranslationZ(0.0f);
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            Animator animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(j, animatorSet);
            animatorSet = new AnimatorSet();
            animatorSet.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{f2}).setDuration(100));
            animatorSet.setInterpolator(a);
            stateListAnimator.addState(k, animatorSet);
            Animator animatorSet2 = new AnimatorSet();
            List arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{f}).setDuration(0));
            if (VERSION.SDK_INT >= 22 && VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{this.n.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet2.playSequentially((Animator[]) arrayList.toArray(new ObjectAnimator[0]));
            animatorSet2.setInterpolator(a);
            stateListAnimator.addState(l, animatorSet2);
            Animator animatorSet3 = new AnimatorSet();
            animatorSet3.play(ObjectAnimator.ofFloat(this.n, "elevation", new float[]{0.0f}).setDuration(0)).with(ObjectAnimator.ofFloat(this.n, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(0));
            animatorSet3.setInterpolator(a);
            stateListAnimator.addState(m, animatorSet3);
            this.n.setStateListAnimator(stateListAnimator);
        }
        if (this.o.b()) {
            e();
        }
    }

    void a(int i) {
        if (this.e instanceof RippleDrawable) {
            ((RippleDrawable) this.e).setColor(ColorStateList.valueOf(i));
        } else {
            super.a(i);
        }
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.d = android.support.v4.graphics.drawable.a.g(k());
        android.support.v4.graphics.drawable.a.a(this.d, colorStateList);
        if (mode != null) {
            android.support.v4.graphics.drawable.a.a(this.d, mode);
        }
        if (i2 > 0) {
            this.f = a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f, this.d});
        } else {
            this.f = null;
            layerDrawable = this.d;
        }
        this.e = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.g = this.e;
        this.o.a(this.e);
    }

    void a(Rect rect) {
        if (this.o.b()) {
            float a = this.o.a();
            float a2 = a() + this.i;
            int ceil = (int) Math.ceil((double) k.b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) k.a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void a(int[] iArr) {
    }

    void b() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0027 in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    void b(android.graphics.Rect r8) {
        /*
        r7 = this;
        r0 = r7.o;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0022;
    L_0x0008:
        r0 = new android.graphics.drawable.InsetDrawable;
        r2 = r7.e;
        r3 = r8.left;
        r4 = r8.top;
        r5 = r8.right;
        r6 = r8.bottom;
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6);
        r7.p = r0;
        r8 = r7.o;
        r7 = r7.p;
    L_0x001e:
        r8.a(r7);
        return;
    L_0x0022:
        r8 = r7.o;
        r7 = r7.e;
        goto L_0x001e;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.h.b(android.graphics.Rect):void");
    }

    void d() {
        e();
    }

    boolean h() {
        return false;
    }

    c i() {
        return new d();
    }

    GradientDrawable l() {
        return new a();
    }
}
