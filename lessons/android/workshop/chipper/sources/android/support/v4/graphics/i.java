package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class i {
    /* JADX WARNING: Missing block: B:13:0x004a, code:
            continue;
     */
    public static java.io.File a(android.content.Context r5) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = ".font";
        r0.append(r1);
        r1 = android.os.Process.myPid();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.os.Process.myTid();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r0 = r0.toString();
        r1 = 0;
    L_0x0027:
        r2 = 100;
        if (r1 >= r2) goto L_0x004d;
    L_0x002b:
        r2 = new java.io.File;
        r3 = r5.getCacheDir();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r0);
        r4.append(r1);
        r4 = r4.toString();
        r2.<init>(r3, r4);
        r3 = r2.createNewFile();	 Catch:{ IOException -> 0x004a }
        if (r3 == 0) goto L_0x004a;
    L_0x0049:
        return r2;
    L_0x004a:
        r1 = r1 + 1;
        goto L_0x0027;
    L_0x004d:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.i.a(android.content.Context):java.io.File");
    }

    public static ByteBuffer a(Context context, Resources resources, int i) {
        File a = a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!a(a, resources, i)) {
                return null;
            }
            ByteBuffer a2 = a(a);
            a.delete();
            return a2;
        } finally {
            a.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0051 A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:7:0x0013} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:34:0x0051, code:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:35:0x0052, code:
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:39:0x0056, code:
            r10 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x0057, code:
            r7 = r10;
            r10 = r9;
            r9 = r7;
     */
    public static java.nio.ByteBuffer a(android.content.Context r8, android.os.CancellationSignal r9, android.net.Uri r10) {
        /*
        r8 = r8.getContentResolver();
        r0 = 0;
        r1 = "r";
        r8 = r8.openFileDescriptor(r10, r1, r9);	 Catch:{ IOException -> 0x006b }
        if (r8 != 0) goto L_0x0013;
    L_0x000d:
        if (r8 == 0) goto L_0x0012;
    L_0x000f:
        r8.close();	 Catch:{ IOException -> 0x006b }
    L_0x0012:
        return r0;
    L_0x0013:
        r9 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r10 = r8.getFileDescriptor();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r9.<init>(r10);	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r1 = r9.getChannel();	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        r5 = r1.size();	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        r3 = 0;
        r10 = r1.map(r2, r3, r5);	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        if (r9 == 0) goto L_0x0031;
    L_0x002e:
        r9.close();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
    L_0x0031:
        if (r8 == 0) goto L_0x0036;
    L_0x0033:
        r8.close();	 Catch:{ IOException -> 0x006b }
    L_0x0036:
        return r10;
    L_0x0037:
        r10 = move-exception;
        r1 = r0;
        goto L_0x0040;
    L_0x003a:
        r10 = move-exception;
        throw r10;	 Catch:{ all -> 0x003c }
    L_0x003c:
        r1 = move-exception;
        r7 = r1;
        r1 = r10;
        r10 = r7;
    L_0x0040:
        if (r9 == 0) goto L_0x0050;
    L_0x0042:
        if (r1 == 0) goto L_0x004d;
    L_0x0044:
        r9.close();	 Catch:{ Throwable -> 0x0048, all -> 0x0051 }
        goto L_0x0050;
    L_0x0048:
        r9 = move-exception;
        r1.addSuppressed(r9);	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        goto L_0x0050;
    L_0x004d:
        r9.close();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
    L_0x0050:
        throw r10;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
    L_0x0051:
        r9 = move-exception;
        r10 = r0;
        goto L_0x005a;
    L_0x0054:
        r9 = move-exception;
        throw r9;	 Catch:{ all -> 0x0056 }
    L_0x0056:
        r10 = move-exception;
        r7 = r10;
        r10 = r9;
        r9 = r7;
    L_0x005a:
        if (r8 == 0) goto L_0x006a;
    L_0x005c:
        if (r10 == 0) goto L_0x0067;
    L_0x005e:
        r8.close();	 Catch:{ Throwable -> 0x0062 }
        goto L_0x006a;
    L_0x0062:
        r8 = move-exception;
        r10.addSuppressed(r8);	 Catch:{ IOException -> 0x006b }
        goto L_0x006a;
    L_0x0067:
        r8.close();	 Catch:{ IOException -> 0x006b }
    L_0x006a:
        throw r9;	 Catch:{ IOException -> 0x006b }
    L_0x006b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.i.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    private static ByteBuffer a(File file) {
        Throwable th;
        Throwable th2;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                ByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return map;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            throw th;
            if (fileInputStream != null) {
                if (th22 != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th22.addSuppressed(th4);
                    }
                } else {
                    fileInputStream.close();
                }
            }
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(File file, Resources resources, int i) {
        Throwable th;
        Closeable openRawResource;
        try {
            openRawResource = resources.openRawResource(i);
            try {
                boolean a = a(file, openRawResource);
                a(openRawResource);
                return a;
            } catch (Throwable th2) {
                th = th2;
                a(openRawResource);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            openRawResource = null;
            a(openRawResource);
            throw th;
        }
    }

    public static boolean a(File file, InputStream inputStream) {
        IOException e;
        StringBuilder stringBuilder;
        Throwable th;
        ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        Closeable closeable = null;
        try {
            Closeable fileOutputStream = new FileOutputStream(file, false);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        a(fileOutputStream);
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                closeable = fileOutputStream;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error copying resource contents to temp file: ");
                    stringBuilder.append(e.getMessage());
                    Log.e("TypefaceCompatUtil", stringBuilder.toString());
                    a(closeable);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    a(closeable);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = fileOutputStream;
                a(closeable);
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error copying resource contents to temp file: ");
            stringBuilder.append(e.getMessage());
            Log.e("TypefaceCompatUtil", stringBuilder.toString());
            a(closeable);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        }
    }
}
