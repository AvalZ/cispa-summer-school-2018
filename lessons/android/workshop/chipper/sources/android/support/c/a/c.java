package android.support.c.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.a.a.g;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class c extends h implements b {
    ArrayList<Object> a;
    final Callback b;
    private a d;
    private Context e;
    private ArgbEvaluator f;
    private AnimatorListener g;

    private static class a extends ConstantState {
        int a;
        i b;
        AnimatorSet c;
        ArrayList<Animator> d;
        android.support.v4.g.a<Animator, String> e;

        public a(Context context, a aVar, Callback callback, Resources resources) {
            if (aVar != null) {
                this.a = aVar.a;
                int i = 0;
                if (aVar.b != null) {
                    ConstantState constantState = aVar.b.getConstantState();
                    this.b = (i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.b = (i) this.b.mutate();
                    this.b.setCallback(callback);
                    this.b.setBounds(aVar.b.getBounds());
                    this.b.a(false);
                }
                if (aVar.d != null) {
                    int size = aVar.d.size();
                    this.d = new ArrayList(size);
                    this.e = new android.support.v4.g.a(size);
                    while (i < size) {
                        Animator animator = (Animator) aVar.d.get(i);
                        Animator clone = animator.clone();
                        String str = (String) aVar.e.get(animator);
                        clone.setTarget(this.b.a(str));
                        this.d.add(clone);
                        this.e.put(clone, str);
                        i++;
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class b extends ConstantState {
        private final ConstantState a;

        public b(ConstantState constantState) {
            this.a = constantState;
        }

        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable cVar = new c();
            cVar.c = this.a.newDrawable();
            cVar.c.setCallback(cVar.b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable cVar = new c();
            cVar.c = this.a.newDrawable(resources);
            cVar.c.setCallback(cVar.b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable cVar = new c();
            cVar.c = this.a.newDrawable(resources, theme);
            cVar.c.setCallback(cVar.b);
            return cVar;
        }
    }

    c() {
        this(null, null, null);
    }

    private c(Context context) {
        this(context, null, null);
    }

    private c(Context context, a aVar, Resources resources) {
        this.f = null;
        this.g = null;
        this.a = null;
        this.b = new Callback() {
            public void invalidateDrawable(Drawable drawable) {
                c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                c.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                c.this.unscheduleSelf(runnable);
            }
        };
        this.e = context;
        if (aVar != null) {
            this.d = aVar;
        } else {
            this.d = new a(context, aVar, this.b, resources);
        }
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f == null) {
                    this.f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f);
            }
        }
    }

    private void a(String str, Animator animator) {
        animator.setTarget(this.d.b.a(str));
        if (VERSION.SDK_INT < 21) {
            a(animator);
        }
        if (this.d.d == null) {
            this.d.d = new ArrayList();
            this.d.e = new android.support.v4.g.a();
        }
        this.d.d.add(animator);
        this.d.e.put(animator, str);
    }

    public void applyTheme(Theme theme) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.c != null ? android.support.v4.graphics.drawable.a.d(this.c) : false;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
            return;
        }
        this.d.b.draw(canvas);
        if (this.d.c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.c != null ? android.support.v4.graphics.drawable.a.c(this.c) : this.d.b.getAlpha();
    }

    public int getChangingConfigurations() {
        if (this.c != null) {
            return this.c.getChangingConfigurations();
        }
        return this.d.a | super.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        return (this.c == null || VERSION.SDK_INT < 24) ? null : new b(this.c.getConstantState());
    }

    public int getIntrinsicHeight() {
        return this.c != null ? this.c.getIntrinsicHeight() : this.d.b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.c != null ? this.c.getIntrinsicWidth() : this.d.b.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.c != null ? this.c.getOpacity() : this.d.b.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                TypedArray a;
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    a = g.a(resources, theme, attributeSet, a.e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i a2 = i.a(resources, resourceId, theme);
                        a2.a(false);
                        a2.setCallback(this.b);
                        if (this.d.b != null) {
                            this.d.b.setCallback(null);
                        }
                        this.d.b = a2;
                    }
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, a.f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.e != null) {
                            a(string, e.a(this.e, resourceId2));
                        } else {
                            a.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                a.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.d.a();
    }

    public boolean isAutoMirrored() {
        return this.c != null ? android.support.v4.graphics.drawable.a.b(this.c) : this.d.b.isAutoMirrored();
    }

    public boolean isRunning() {
        return this.c != null ? ((AnimatedVectorDrawable) this.c).isRunning() : this.d.c.isRunning();
    }

    public boolean isStateful() {
        return this.c != null ? this.c.isStateful() : this.d.b.isStateful();
    }

    public Drawable mutate() {
        if (this.c != null) {
            this.c.mutate();
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c != null) {
            this.c.setBounds(rect);
        } else {
            this.d.b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.c != null ? this.c.setLevel(i) : this.d.b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.c != null ? this.c.setState(iArr) : this.d.b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.c != null) {
            this.c.setAlpha(i);
        } else {
            this.d.b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, z);
        } else {
            this.d.b.setAutoMirrored(z);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.c != null) {
            this.c.setColorFilter(colorFilter);
        } else {
            this.d.b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, i);
        } else {
            this.d.b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, colorStateList);
        } else {
            this.d.b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.c != null) {
            android.support.v4.graphics.drawable.a.a(this.c, mode);
        } else {
            this.d.b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.c != null) {
            return this.c.setVisible(z, z2);
        }
        this.d.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.c != null) {
            ((AnimatedVectorDrawable) this.c).start();
        } else if (!this.d.c.isStarted()) {
            this.d.c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.c != null) {
            ((AnimatedVectorDrawable) this.c).stop();
        } else {
            this.d.c.end();
        }
    }
}
