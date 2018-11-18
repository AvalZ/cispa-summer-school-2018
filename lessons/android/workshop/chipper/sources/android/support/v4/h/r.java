package android.support.v4.h;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class r {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static Field b = null;
    private static boolean c = false;
    private static Field d = null;
    private static boolean e = false;
    private static WeakHashMap<View, String> f = null;
    private static WeakHashMap<View, v> g = null;
    private static Field h = null;
    private static boolean i = false;
    private static ThreadLocal<Rect> j;

    public interface a {
        boolean a(View view, KeyEvent keyEvent);
    }

    static class b {
        private static final ArrayList<WeakReference<View>> a = new ArrayList();
        private WeakHashMap<View, Boolean> b = null;
        private SparseArray<WeakReference<View>> c = null;
        private WeakReference<KeyEvent> d = null;

        b() {
        }

        static b a(View view) {
            b bVar = (b) view.getTag(android.support.a.a.b.tag_unhandled_key_event_manager);
            if (bVar != null) {
                return bVar;
            }
            bVar = new b();
            view.setTag(android.support.a.a.b.tag_unhandled_key_event_manager, bVar);
            return bVar;
        }

        private SparseArray<WeakReference<View>> a() {
            if (this.c == null) {
                this.c = new SparseArray();
            }
            return this.c;
        }

        private View b(View view, KeyEvent keyEvent) {
            if (this.b == null || !this.b.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View b = b(viewGroup.getChildAt(childCount), keyEvent);
                    if (b != null) {
                        return b;
                    }
                }
            }
            return c(view, keyEvent) ? view : null;
        }

        private void b() {
            if (this.b != null) {
                this.b.clear();
            }
            if (!a.isEmpty()) {
                synchronized (a) {
                    if (this.b == null) {
                        this.b = new WeakHashMap();
                    }
                    for (int size = a.size() - 1; size >= 0; size--) {
                        View view = (View) ((WeakReference) a.get(size)).get();
                        if (view == null) {
                            a.remove(size);
                        } else {
                            this.b.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }

        private boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(android.support.a.a.b.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((a) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean a(KeyEvent keyEvent) {
            if (this.d != null && this.d.get() == keyEvent) {
                return false;
            }
            this.d = new WeakReference(keyEvent);
            WeakReference weakReference = null;
            SparseArray a = a();
            if (keyEvent.getAction() == 1) {
                int indexOfKey = a.indexOfKey(keyEvent.getKeyCode());
                if (indexOfKey >= 0) {
                    weakReference = (WeakReference) a.valueAt(indexOfKey);
                    a.removeAt(indexOfKey);
                }
            }
            if (weakReference == null) {
                weakReference = (WeakReference) a.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && r.x(view)) {
                c(view, keyEvent);
            }
            return true;
        }

        boolean a(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                b();
            }
            view = b(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (!(view == null || KeyEvent.isModifierKey(keyCode))) {
                    a().put(keyCode, new WeakReference(view));
                }
            }
            return view != null;
        }
    }

    private static void A(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    private static Rect a() {
        if (j == null) {
            j = new ThreadLocal();
        }
        Rect rect = (Rect) j.get();
        if (rect == null) {
            rect = new Rect();
            j.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static z a(View view, z zVar) {
        if (VERSION.SDK_INT < 21) {
            return zVar;
        }
        Object obj = (WindowInsets) z.a(zVar);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
        if (onApplyWindowInsets != obj) {
            obj = new WindowInsets(onApplyWindowInsets);
        }
        return z.a(obj);
    }

    public static void a(View view, float f) {
        if (VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static void a(View view, int i) {
        if (VERSION.SDK_INT < 19) {
            if (VERSION.SDK_INT < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    public static void a(View view, int i, int i2) {
        if (VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, i2);
        }
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public static void a(View view, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
                if (!(background == null || obj == null)) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof q) {
            ((q) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static void a(View view, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
                if (!(background == null || obj == null)) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof q) {
            ((q) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void a(View view, Rect rect) {
        if (VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(View view, b bVar) {
        view.setAccessibilityDelegate(bVar == null ? null : bVar.a());
    }

    public static void a(View view, final p pVar) {
        if (VERSION.SDK_INT >= 21) {
            if (pVar == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) z.a(pVar.a(view, z.a((Object) windowInsets)));
                }
            });
        }
    }

    public static void a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void a(View view, Runnable runnable, long j) {
        if (VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static void a(View view, String str) {
        if (VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f == null) {
            f = new WeakHashMap();
        }
        f.put(view, str);
    }

    public static void a(View view, boolean z) {
        if (VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static boolean a(View view) {
        boolean z = false;
        if (i) {
            return false;
        }
        if (h == null) {
            try {
                h = View.class.getDeclaredField("mAccessibilityDelegate");
                h.setAccessible(true);
            } catch (Throwable unused) {
                i = true;
                return false;
            }
        }
        try {
            if (h.get(view) != null) {
                z = true;
            }
            return z;
        } catch (Throwable unused2) {
            i = true;
            return false;
        }
    }

    static boolean a(View view, KeyEvent keyEvent) {
        return VERSION.SDK_INT >= 28 ? false : b.a(view).a(keyEvent);
    }

    public static void b(View view, int i) {
        if (VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    @Deprecated
    public static void b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean b(View view) {
        return VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
    }

    static boolean b(View view, KeyEvent keyEvent) {
        return VERSION.SDK_INT >= 28 ? false : b.a(view).a(view, keyEvent);
    }

    public static void c(View view) {
        if (VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void c(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect a = a();
            int i2 = 0;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                i2 = a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            }
            e(view, i);
            if (i2 != 0 && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a);
                return;
            }
        }
        e(view, i);
    }

    public static int d(View view) {
        return VERSION.SDK_INT >= 16 ? view.getImportantForAccessibility() : 0;
    }

    public static void d(View view, int i) {
        if (VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect a = a();
            int i2 = 0;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                i2 = a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            }
            f(view, i);
            if (i2 != 0 && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(a);
                return;
            }
        }
        f(view, i);
    }

    public static int e(View view) {
        return VERSION.SDK_INT >= 17 ? view.getLayoutDirection() : 0;
    }

    private static void e(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            A(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                A((View) parent);
            }
        }
    }

    public static int f(View view) {
        return VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    private static void f(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            A(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                A((View) parent);
            }
        }
    }

    public static int g(View view) {
        return VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int h(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!c) {
            try {
                b = View.class.getDeclaredField("mMinWidth");
                b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                c = true;
            }
        }
        if (b != null) {
            try {
                return ((Integer) b.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
    }

    public static int i(View view) {
        if (VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinHeight");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                e = true;
            }
        }
        if (d != null) {
            try {
                return ((Integer) d.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }
    }

    public static v j(View view) {
        if (g == null) {
            g = new WeakHashMap();
        }
        v vVar = (v) g.get(view);
        if (vVar != null) {
            return vVar;
        }
        vVar = new v(view);
        g.put(view, vVar);
        return vVar;
    }

    public static String k(View view) {
        return VERSION.SDK_INT >= 21 ? view.getTransitionName() : f == null ? null : (String) f.get(view);
    }

    public static int l(View view) {
        return VERSION.SDK_INT >= 16 ? view.getWindowSystemUiVisibility() : 0;
    }

    public static void m(View view) {
        if (VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    public static boolean n(View view) {
        return VERSION.SDK_INT >= 16 ? view.getFitsSystemWindows() : false;
    }

    public static boolean o(View view) {
        return VERSION.SDK_INT >= 16 ? view.hasOverlappingRendering() : true;
    }

    public static boolean p(View view) {
        return VERSION.SDK_INT >= 17 ? view.isPaddingRelative() : false;
    }

    public static ColorStateList q(View view) {
        return VERSION.SDK_INT >= 21 ? view.getBackgroundTintList() : view instanceof q ? ((q) view).getSupportBackgroundTintList() : null;
    }

    public static Mode r(View view) {
        return VERSION.SDK_INT >= 21 ? view.getBackgroundTintMode() : view instanceof q ? ((q) view).getSupportBackgroundTintMode() : null;
    }

    public static boolean s(View view) {
        return VERSION.SDK_INT >= 21 ? view.isNestedScrollingEnabled() : view instanceof j ? ((j) view).isNestedScrollingEnabled() : false;
    }

    public static void t(View view) {
        if (VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
            return;
        }
        if (view instanceof j) {
            ((j) view).stopNestedScroll();
        }
    }

    public static boolean u(View view) {
        return VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float v(View view) {
        return VERSION.SDK_INT >= 21 ? view.getZ() : 0.0f;
    }

    public static Rect w(View view) {
        return VERSION.SDK_INT >= 18 ? view.getClipBounds() : null;
    }

    public static boolean x(View view) {
        return VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean y(View view) {
        return VERSION.SDK_INT >= 15 ? view.hasOnClickListeners() : false;
    }

    public static Display z(View view) {
        return VERSION.SDK_INT >= 17 ? view.getDisplay() : x(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
    }
}
