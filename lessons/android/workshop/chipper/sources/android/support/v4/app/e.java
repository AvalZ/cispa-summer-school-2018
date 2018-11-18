package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

public final class e {

    static class a {
        private static Method a;
        private static boolean b;

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A:{ExcHandler: java.lang.reflect.InvocationTargetException (r6_3 'e' java.lang.Throwable), Splitter: B:9:0x002b} */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A:{ExcHandler: java.lang.reflect.InvocationTargetException (r6_3 'e' java.lang.Throwable), Splitter: B:9:0x002b} */
        /* JADX WARNING: Missing block: B:12:0x0038, code:
            r6 = move-exception;
     */
        /* JADX WARNING: Missing block: B:13:0x0039, code:
            android.util.Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", r6);
            a = null;
     */
        public static android.os.IBinder a(android.os.Bundle r6, java.lang.String r7) {
            /*
            r0 = b;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x0026;
        L_0x0006:
            r0 = android.os.Bundle.class;
            r3 = "getIBinder";
            r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001c }
            r5 = java.lang.String.class;
            r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x001c }
            r0 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x001c }
            a = r0;	 Catch:{ NoSuchMethodException -> 0x001c }
            r0 = a;	 Catch:{ NoSuchMethodException -> 0x001c }
            r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x001c }
            goto L_0x0024;
        L_0x001c:
            r0 = move-exception;
            r3 = "BundleCompatBaseImpl";
            r4 = "Failed to retrieve getIBinder method";
            android.util.Log.i(r3, r4, r0);
        L_0x0024:
            b = r2;
        L_0x0026:
            r0 = a;
            r3 = 0;
            if (r0 == 0) goto L_0x0042;
        L_0x002b:
            r0 = a;	 Catch:{ InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038 }
            r2 = new java.lang.Object[r2];	 Catch:{ InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038 }
            r2[r1] = r7;	 Catch:{ InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038 }
            r6 = r0.invoke(r6, r2);	 Catch:{ InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038 }
            r6 = (android.os.IBinder) r6;	 Catch:{ InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038, InvocationTargetException -> 0x0038 }
            return r6;
        L_0x0038:
            r6 = move-exception;
            r7 = "BundleCompatBaseImpl";
            r0 = "Failed to invoke getIBinder via reflection";
            android.util.Log.i(r7, r0, r6);
            a = r3;
        L_0x0042:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.e.a.a(android.os.Bundle, java.lang.String):android.os.IBinder");
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        return VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : a.a(bundle, str);
    }
}
