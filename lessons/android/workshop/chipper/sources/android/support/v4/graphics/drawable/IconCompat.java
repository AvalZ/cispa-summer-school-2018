package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;

public class IconCompat extends CustomVersionedParcelable {
    static final Mode h = Mode.SRC_IN;
    public int a;
    Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g = null;
    Mode i = h;
    public String j;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022 A:{ExcHandler: java.lang.IllegalAccessException (r5_4 'e' java.lang.Throwable), Splitter: B:5:0x000c} */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022 A:{ExcHandler: java.lang.IllegalAccessException (r5_4 'e' java.lang.Throwable), Splitter: B:5:0x000c} */
    /* JADX WARNING: Missing block: B:8:0x0022, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x0023, code:
            android.util.Log.e("IconCompat", "Unable to get icon package", r5);
     */
    /* JADX WARNING: Missing block: B:10:0x002a, code:
            return null;
     */
    private static java.lang.String a(android.graphics.drawable.Icon r5) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 28;
        if (r0 < r1) goto L_0x000b;
    L_0x0006:
        r5 = r5.getResPackage();
        return r5;
    L_0x000b:
        r0 = 0;
        r1 = r5.getClass();	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        r2 = "getResPackage";
        r3 = 0;
        r4 = new java.lang.Class[r3];	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        r2 = new java.lang.Object[r3];	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        r5 = r1.invoke(r5, r2);	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        r5 = (java.lang.String) r5;	 Catch:{ IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022, IllegalAccessException -> 0x0022 }
        return r5;
    L_0x0022:
        r5 = move-exception;
        r1 = "IconCompat";
        r2 = "Unable to get icon package";
        android.util.Log.e(r1, r2, r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.a(android.graphics.drawable.Icon):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025 A:{ExcHandler: java.lang.IllegalAccessException (r4_5 'e' java.lang.Throwable), Splitter: B:5:0x000c} */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025 A:{ExcHandler: java.lang.IllegalAccessException (r4_5 'e' java.lang.Throwable), Splitter: B:5:0x000c} */
    /* JADX WARNING: Missing block: B:8:0x0025, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x0026, code:
            android.util.Log.e("IconCompat", "Unable to get icon resource", r4);
     */
    /* JADX WARNING: Missing block: B:10:0x002d, code:
            return 0;
     */
    private static int b(android.graphics.drawable.Icon r4) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 28;
        if (r0 < r1) goto L_0x000b;
    L_0x0006:
        r4 = r4.getResId();
        return r4;
    L_0x000b:
        r0 = 0;
        r1 = r4.getClass();	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r2 = "getResId";
        r3 = new java.lang.Class[r0];	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r1 = r1.getMethod(r2, r3);	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r2 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r4 = r1.invoke(r4, r2);	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r4 = (java.lang.Integer) r4;	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        r4 = r4.intValue();	 Catch:{ IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025, IllegalAccessException -> 0x0025 }
        return r4;
    L_0x0025:
        r4 = move-exception;
        r1 = "IconCompat";
        r2 = "Unable to get icon resource";
        android.util.Log.e(r1, r2, r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.b(android.graphics.drawable.Icon):int");
    }

    public String a() {
        if (this.a == -1 && VERSION.SDK_INT >= 23) {
            return a((Icon) this.b);
        }
        if (this.a == 2) {
            return ((String) this.b).split(":", -1)[0];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResPackage() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /* JADX WARNING: Missing block: B:7:0x0021, code:
            r4 = r4.getBytes(java.nio.charset.Charset.forName("UTF-16"));
     */
    /* JADX WARNING: Missing block: B:8:0x002b, code:
            r3.c = r4;
     */
    /* JADX WARNING: Missing block: B:9:0x002d, code:
            return;
     */
    public void a(boolean r4) {
        /*
        r3 = this;
        r0 = r3.i;
        r0 = r0.name();
        r3.j = r0;
        r0 = r3.a;
        r1 = -1;
        if (r0 == r1) goto L_0x0045;
    L_0x000d:
        switch(r0) {
            case 1: goto L_0x002e;
            case 2: goto L_0x001d;
            case 3: goto L_0x0018;
            case 4: goto L_0x0011;
            case 5: goto L_0x002e;
            default: goto L_0x0010;
        };
    L_0x0010:
        return;
    L_0x0011:
        r4 = r3.b;
        r4 = r4.toString();
        goto L_0x0021;
    L_0x0018:
        r4 = r3.b;
        r4 = (byte[]) r4;
        goto L_0x002b;
    L_0x001d:
        r4 = r3.b;
        r4 = (java.lang.String) r4;
    L_0x0021:
        r0 = "UTF-16";
        r0 = java.nio.charset.Charset.forName(r0);
        r4 = r4.getBytes(r0);
    L_0x002b:
        r3.c = r4;
        return;
    L_0x002e:
        if (r4 == 0) goto L_0x004f;
    L_0x0030:
        r4 = r3.b;
        r4 = (android.graphics.Bitmap) r4;
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = android.graphics.Bitmap.CompressFormat.PNG;
        r2 = 90;
        r4.compress(r1, r2, r0);
        r4 = r0.toByteArray();
        goto L_0x002b;
    L_0x0045:
        if (r4 == 0) goto L_0x004f;
    L_0x0047:
        r3 = new java.lang.IllegalArgumentException;
        r4 = "Can't serialize Icon created with IconCompat#createFromIcon";
        r3.<init>(r4);
        throw r3;
    L_0x004f:
        r4 = r3.b;
        r4 = (android.os.Parcelable) r4;
        r3.d = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.a(boolean):void");
    }

    public int b() {
        if (this.a == -1 && VERSION.SDK_INT >= 23) {
            return b((Icon) this.b);
        }
        if (this.a == 2) {
            return this.e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("called getResId() on ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:16:0x0040 in {3, 4, 5, 7, 10, 12, 15, 18} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public void c() {
        /*
        r3 = this;
        r0 = r3.j;
        r0 = android.graphics.PorterDuff.Mode.valueOf(r0);
        r3.i = r0;
        r0 = r3.a;
        r1 = -1;
        if (r0 == r1) goto L_0x0039;
    L_0x000d:
        switch(r0) {
            case 1: goto L_0x0024;
            case 2: goto L_0x0014;
            case 3: goto L_0x0011;
            case 4: goto L_0x0014;
            case 5: goto L_0x0024;
            default: goto L_0x0010;
        };
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.c;
        goto L_0x0021;
    L_0x0014:
        r0 = new java.lang.String;
        r1 = r3.c;
        r2 = "UTF-16";
        r2 = java.nio.charset.Charset.forName(r2);
        r0.<init>(r1, r2);
    L_0x0021:
        r3.b = r0;
        return;
    L_0x0024:
        r0 = r3.d;
        if (r0 == 0) goto L_0x0029;
    L_0x0028:
        goto L_0x003d;
    L_0x0029:
        r0 = r3.c;
        r3.b = r0;
        r0 = 3;
        r3.a = r0;
        r0 = 0;
        r3.e = r0;
        r0 = r3.c;
        r0 = r0.length;
        r3.f = r0;
        return;
    L_0x0039:
        r0 = r3.d;
        if (r0 == 0) goto L_0x0041;
    L_0x003d:
        r0 = r3.d;
        goto L_0x0021;
        return;
    L_0x0041:
        r3 = new java.lang.IllegalArgumentException;
        r0 = "Invalid icon";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.c():void");
    }

    public java.lang.String toString() {
        /*
        r5 = this;
        r0 = r5.a;
        r1 = -1;
        if (r0 != r1) goto L_0x000c;
    L_0x0005:
        r5 = r5.b;
        r5 = java.lang.String.valueOf(r5);
        return r5;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r1 = "Icon(typ=";
        r0.<init>(r1);
        r1 = r5.a;
        r1 = a(r1);
        r0.append(r1);
        r1 = r5.a;
        switch(r1) {
            case 1: goto L_0x006c;
            case 2: goto L_0x0043;
            case 3: goto L_0x002d;
            case 4: goto L_0x0022;
            case 5: goto L_0x006c;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x008c;
    L_0x0022:
        r1 = " uri=";
        r0.append(r1);
        r1 = r5.b;
        r0.append(r1);
        goto L_0x008c;
    L_0x002d:
        r1 = " len=";
        r0.append(r1);
        r1 = r5.e;
        r0.append(r1);
        r1 = r5.f;
        if (r1 == 0) goto L_0x008c;
    L_0x003b:
        r1 = " off=";
        r0.append(r1);
        r1 = r5.f;
        goto L_0x0089;
    L_0x0043:
        r1 = " pkg=";
        r0.append(r1);
        r1 = r5.a();
        r0.append(r1);
        r1 = " id=";
        r0.append(r1);
        r1 = "0x%08x";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r5.b();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r1 = java.lang.String.format(r1, r2);
        r0.append(r1);
        goto L_0x008c;
    L_0x006c:
        r1 = " size=";
        r0.append(r1);
        r1 = r5.b;
        r1 = (android.graphics.Bitmap) r1;
        r1 = r1.getWidth();
        r0.append(r1);
        r1 = "x";
        r0.append(r1);
        r1 = r5.b;
        r1 = (android.graphics.Bitmap) r1;
        r1 = r1.getHeight();
    L_0x0089:
        r0.append(r1);
    L_0x008c:
        r1 = r5.g;
        if (r1 == 0) goto L_0x009a;
    L_0x0090:
        r1 = " tint=";
        r0.append(r1);
        r1 = r5.g;
        r0.append(r1);
    L_0x009a:
        r1 = r5.i;
        r2 = h;
        if (r1 == r2) goto L_0x00aa;
    L_0x00a0:
        r1 = " mode=";
        r0.append(r1);
        r5 = r5.i;
        r0.append(r5);
    L_0x00aa:
        r5 = ")";
        r0.append(r5);
        r5 = r0.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
