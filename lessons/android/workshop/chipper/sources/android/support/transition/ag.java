package android.support.transition;

import android.animation.LayoutTransition;
import android.support.transition.r.a;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ag implements ai {
    private static LayoutTransition a;
    private static Field b;
    private static boolean c;
    private static Method d;
    private static boolean e;

    ag() {
    }

    private static void a(LayoutTransition layoutTransition) {
        String str;
        String str2;
        if (!e) {
            try {
                d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            e = true;
        }
        if (d != null) {
            try {
                d.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                str = "ViewGroupUtilsApi14";
                str2 = "Failed to access cancel method by reflection";
                Log.i(str, str2);
            } catch (InvocationTargetException unused3) {
                str = "ViewGroupUtilsApi14";
                str2 = "Failed to invoke cancel method by reflection";
                Log.i(str, str2);
            }
        }
    }

    public ae a(ViewGroup viewGroup) {
        return ac.a(viewGroup);
    }

    public void a(ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        boolean z2 = false;
        if (a == null) {
            a = new LayoutTransition() {
                public boolean isChangingLayout() {
                    return true;
                }
            };
            a.setAnimator(2, null);
            a.setAnimator(0, null);
            a.setAnimator(1, null);
            a.setAnimator(3, null);
            a.setAnimator(4, null);
        }
        if (z) {
            layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    a(layoutTransition);
                }
                if (layoutTransition != a) {
                    viewGroup.setTag(a.transition_layout_save, layoutTransition);
                }
            }
            layoutTransition = a;
        } else {
            viewGroup.setLayoutTransition(null);
            if (!c) {
                try {
                    b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    b.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                    Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
                }
                c = true;
            }
            if (b != null) {
                try {
                    boolean z3 = b.getBoolean(viewGroup);
                    if (z3) {
                        try {
                            b.setBoolean(viewGroup, false);
                        } catch (IllegalAccessException unused2) {
                            z2 = z3;
                        }
                    }
                    z2 = z3;
                } catch (IllegalAccessException unused3) {
                    Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                }
            }
            if (z2) {
                viewGroup.requestLayout();
            }
            layoutTransition = (LayoutTransition) viewGroup.getTag(a.transition_layout_save);
            if (layoutTransition != null) {
                viewGroup.setTag(a.transition_layout_save, null);
            } else {
                return;
            }
        }
        viewGroup.setLayoutTransition(layoutTransition);
    }
}
