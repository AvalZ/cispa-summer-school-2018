package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;

public class a extends android.support.v4.a.a {
    private static b a;

    public interface a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public interface b {
        boolean a(Activity activity, int i, int i2, Intent intent);

        boolean a(Activity activity, String[] strArr, int i);
    }

    public interface c {
        void a(int i);
    }

    public static b a() {
        return a;
    }

    public static void a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void a(final Activity activity, final String[] strArr, final int i) {
        if (a != null && a.a(activity, strArr, i)) {
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).a(i);
            }
            activity.requestPermissions(strArr, i);
            return;
        }
        if (activity instanceof a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
