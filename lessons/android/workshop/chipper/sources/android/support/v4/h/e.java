package android.support.v4.h;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class e {
    private static boolean a = false;
    private static Method b = null;
    private static boolean c = false;
    private static Field d;

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    private static OnKeyListener a(Dialog dialog) {
        if (!c) {
            try {
                d = Dialog.class.getDeclaredField("mOnKeyListener");
                d.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                c = true;
            }
        }
        if (d != null) {
            try {
                return (OnKeyListener) d.get(dialog);
            } catch (IllegalAccessException unused2) {
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f A:{RETURN, ExcHandler: java.lang.IllegalAccessException (unused java.lang.IllegalAccessException), Splitter: B:7:0x001e} */
    /* JADX WARNING: Missing block: B:10:0x002f, code:
            return false;
     */
    private static boolean a(android.app.ActionBar r6, android.view.KeyEvent r7) {
        /*
        r0 = a;
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x001a;
    L_0x0006:
        r0 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x0018 }
        r3 = "onMenuKeyEvent";
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0018 }
        r5 = android.view.KeyEvent.class;
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0018 }
        r0 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0018 }
        b = r0;	 Catch:{ NoSuchMethodException -> 0x0018 }
    L_0x0018:
        a = r2;
    L_0x001a:
        r0 = b;
        if (r0 == 0) goto L_0x002f;
    L_0x001e:
        r0 = b;	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        r2[r1] = r7;	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        r6 = r0.invoke(r6, r2);	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        r6 = (java.lang.Boolean) r6;	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        r6 = r6.booleanValue();	 Catch:{ IllegalAccessException -> 0x002f, IllegalAccessException -> 0x002f }
        return r6;
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.h.e.a(android.app.ActionBar, android.view.KeyEvent):boolean");
    }

    private static boolean a(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (r.b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    private static boolean a(Dialog dialog, KeyEvent keyEvent) {
        OnKeyListener a = a(dialog);
        if (a != null && a.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (r.b(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean a(a aVar, View view, Callback callback, KeyEvent keyEvent) {
        boolean z = false;
        if (aVar == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 28) {
            return aVar.a(keyEvent);
        }
        if (callback instanceof Activity) {
            return a((Activity) callback, keyEvent);
        }
        if (callback instanceof Dialog) {
            return a((Dialog) callback, keyEvent);
        }
        if ((view != null && r.b(view, keyEvent)) || aVar.a(keyEvent)) {
            z = true;
        }
        return z;
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return r.a(view, keyEvent);
    }
}
