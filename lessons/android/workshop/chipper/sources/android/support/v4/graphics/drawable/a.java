package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    private static Method a;
    private static boolean b;
    private static Method c;
    private static boolean d;

    @Deprecated
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void a(Drawable drawable, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    public static void a(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
            return;
        }
        if (drawable instanceof b) {
            ((b) drawable).setTint(i);
        }
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
            return;
        }
        if (drawable instanceof b) {
            ((b) drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static void a(Drawable drawable, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
            return;
        }
        if (drawable instanceof b) {
            ((b) drawable).setTintMode(mode);
        }
    }

    public static void a(Drawable drawable, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static boolean b(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.isAutoMirrored() : false;
    }

    public static boolean b(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (VERSION.SDK_INT >= 17) {
            if (!b) {
                try {
                    a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    a.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                b = true;
            }
            if (a != null) {
                try {
                    a.invoke(drawable, new Object[]{Integer.valueOf(i)});
                    return true;
                } catch (Throwable e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    a = null;
                }
            }
        }
        return false;
    }

    public static int c(Drawable drawable) {
        return VERSION.SDK_INT >= 19 ? drawable.getAlpha() : 0;
    }

    public static boolean d(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.canApplyTheme() : false;
    }

    public static ColorFilter e(Drawable drawable) {
        return VERSION.SDK_INT >= 21 ? drawable.getColorFilter() : null;
    }

    public static void f(Drawable drawable) {
        if (VERSION.SDK_INT < 23 && VERSION.SDK_INT >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                drawable = ((InsetDrawable) drawable).getDrawable();
            } else if (drawable instanceof c) {
                drawable = ((c) drawable).a();
            } else {
                if (drawable instanceof DrawableContainer) {
                    DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                    if (drawableContainerState != null) {
                        int childCount = drawableContainerState.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            Drawable child = drawableContainerState.getChild(i);
                            if (child != null) {
                                f(child);
                            }
                        }
                    }
                }
                return;
            }
            f(drawable);
            return;
        }
        drawable.clearColorFilter();
    }

    public static Drawable g(Drawable drawable) {
        return VERSION.SDK_INT >= 23 ? drawable : VERSION.SDK_INT >= 21 ? !(drawable instanceof b) ? new e(drawable) : drawable : !(drawable instanceof b) ? new d(drawable) : drawable;
    }

    public static int h(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (VERSION.SDK_INT >= 17) {
            if (!d) {
                try {
                    c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    c.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                d = true;
            }
            if (c != null) {
                try {
                    return ((Integer) c.invoke(drawable, new Object[0])).intValue();
                } catch (Throwable e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    c = null;
                }
            }
        }
        return 0;
    }
}
