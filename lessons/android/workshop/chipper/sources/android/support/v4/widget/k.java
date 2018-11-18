package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.h.d;
import android.support.v4.h.r;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class k {
    private static Method a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    public static void a(PopupWindow popupWindow, int i) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!b) {
            try {
                a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                a.setAccessible(true);
            } catch (Exception unused) {
                b = true;
            }
        }
        if (a != null) {
            try {
                a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }

    public static void a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((d.a(i3, r.e(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            if (!d) {
                try {
                    c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    c.setAccessible(true);
                } catch (Throwable e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                d = true;
            }
            if (c != null) {
                try {
                    c.set(popupWindow, Boolean.valueOf(z));
                } catch (Throwable e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }
}
