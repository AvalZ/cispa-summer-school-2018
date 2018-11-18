package android.support.v4.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.g.g;
import android.support.v4.g.k;
import android.support.v4.g.l;
import android.support.v4.graphics.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {
    static final g<String, Typeface> a = new g(16);
    static final Object b = new Object();
    static final l<String, ArrayList<android.support.v4.e.c.a<c>>> c = new l();
    private static final c d = new c("fonts", 10, 10000);
    private static final Comparator<byte[]> e = new Comparator<byte[]>() {
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length != bArr2.length) {
                length = bArr.length;
                length2 = bArr2.length;
            } else {
                int i = 0;
                while (i < bArr.length) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    } else {
                        i++;
                    }
                }
                return 0;
            }
            return length - length2;
        }
    };

    public static class a {
        private final int a;
        private final b[] b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = bVarArr;
        }

        public int a() {
            return this.a;
        }

        public b[] b() {
            return this.b;
        }
    }

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) k.a((Object) uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        public Uri a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }
    }

    private static final class c {
        final Typeface a;
        final int b;

        c(Typeface typeface, int i) {
            this.a = typeface;
            this.b = i;
        }
    }

    public static ProviderInfo a(PackageManager packageManager, a aVar, Resources resources) {
        String a = aVar.a();
        int i = 0;
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a, 0);
        if (resolveContentProvider == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No package found for authority: ");
            stringBuilder.append(a);
            throw new NameNotFoundException(stringBuilder.toString());
        } else if (resolveContentProvider.packageName.equals(aVar.b())) {
            List a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, e);
            List a3 = a(aVar, resources);
            while (i < a3.size()) {
                List arrayList = new ArrayList((Collection) a3.get(i));
                Collections.sort(arrayList, e);
                if (a(a2, arrayList)) {
                    return resolveContentProvider;
                }
                i++;
            }
            return null;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Found content provider ");
            stringBuilder2.append(a);
            stringBuilder2.append(", but package was not ");
            stringBuilder2.append(aVar.b());
            throw new NameNotFoundException(stringBuilder2.toString());
        }
    }

    /* JADX WARNING: Missing block: B:33:0x007b, code:
            return null;
     */
    /* JADX WARNING: Missing block: B:37:0x008c, code:
            d.a(r1, new android.support.v4.e.b.AnonymousClass3());
     */
    /* JADX WARNING: Missing block: B:38:0x0096, code:
            return null;
     */
    public static android.graphics.Typeface a(final android.content.Context r2, final android.support.v4.e.a r3, final android.support.v4.a.a.f.a r4, final android.os.Handler r5, boolean r6, int r7, final int r8) {
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r3.f();
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r0.append(r8);
        r0 = r0.toString();
        r1 = a;
        r1 = r1.a(r0);
        r1 = (android.graphics.Typeface) r1;
        if (r1 == 0) goto L_0x0028;
    L_0x0022:
        if (r4 == 0) goto L_0x0027;
    L_0x0024:
        r4.a(r1);
    L_0x0027:
        return r1;
    L_0x0028:
        if (r6 == 0) goto L_0x0045;
    L_0x002a:
        r1 = -1;
        if (r7 != r1) goto L_0x0045;
    L_0x002d:
        r2 = a(r2, r3, r8);
        if (r4 == 0) goto L_0x0042;
    L_0x0033:
        r3 = r2.b;
        if (r3 != 0) goto L_0x003d;
    L_0x0037:
        r3 = r2.a;
        r4.a(r3, r5);
        goto L_0x0042;
    L_0x003d:
        r3 = r2.b;
        r4.a(r3, r5);
    L_0x0042:
        r2 = r2.a;
        return r2;
    L_0x0045:
        r1 = new android.support.v4.e.b$1;
        r1.<init>(r2, r3, r8, r0);
        r2 = 0;
        if (r6 == 0) goto L_0x0059;
    L_0x004d:
        r3 = d;	 Catch:{ InterruptedException -> 0x0058 }
        r3 = r3.a(r1, r7);	 Catch:{ InterruptedException -> 0x0058 }
        r3 = (android.support.v4.e.b.c) r3;	 Catch:{ InterruptedException -> 0x0058 }
        r3 = r3.a;	 Catch:{ InterruptedException -> 0x0058 }
        return r3;
    L_0x0058:
        return r2;
    L_0x0059:
        if (r4 != 0) goto L_0x005d;
    L_0x005b:
        r3 = r2;
        goto L_0x0062;
    L_0x005d:
        r3 = new android.support.v4.e.b$2;
        r3.<init>(r4, r5);
    L_0x0062:
        r4 = b;
        monitor-enter(r4);
        r5 = c;	 Catch:{ all -> 0x0097 }
        r5 = r5.containsKey(r0);	 Catch:{ all -> 0x0097 }
        if (r5 == 0) goto L_0x007c;
    L_0x006d:
        if (r3 == 0) goto L_0x007a;
    L_0x006f:
        r5 = c;	 Catch:{ all -> 0x0097 }
        r5 = r5.get(r0);	 Catch:{ all -> 0x0097 }
        r5 = (java.util.ArrayList) r5;	 Catch:{ all -> 0x0097 }
        r5.add(r3);	 Catch:{ all -> 0x0097 }
    L_0x007a:
        monitor-exit(r4);	 Catch:{ all -> 0x0097 }
        return r2;
    L_0x007c:
        if (r3 == 0) goto L_0x008b;
    L_0x007e:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x0097 }
        r5.<init>();	 Catch:{ all -> 0x0097 }
        r5.add(r3);	 Catch:{ all -> 0x0097 }
        r3 = c;	 Catch:{ all -> 0x0097 }
        r3.put(r0, r5);	 Catch:{ all -> 0x0097 }
    L_0x008b:
        monitor-exit(r4);	 Catch:{ all -> 0x0097 }
        r3 = d;
        r4 = new android.support.v4.e.b$3;
        r4.<init>(r0);
        r3.a(r1, r4);
        return r2;
    L_0x0097:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0097 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.e.b.a(android.content.Context, android.support.v4.e.a, android.support.v4.a.a.f$a, android.os.Handler, boolean, int, int):android.graphics.Typeface");
    }

    public static a a(Context context, CancellationSignal cancellationSignal, a aVar) {
        ProviderInfo a = a(context.getPackageManager(), aVar, context.getResources());
        return a == null ? new a(1, null) : new a(0, a(context, aVar, a.authority, cancellationSignal));
    }

    static c a(Context context, a aVar, int i) {
        try {
            a a = a(context, null, aVar);
            int i2 = -3;
            if (a.a() == 0) {
                Typeface a2 = android.support.v4.graphics.c.a(context, null, a.b(), i);
                if (a2 != null) {
                    i2 = 0;
                }
                return new c(a2, i2);
            }
            if (a.a() == 1) {
                i2 = -2;
            }
            return new c(null, i2);
        } catch (NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    private static List<List<byte[]>> a(a aVar, Resources resources) {
        return aVar.d() != null ? aVar.d() : android.support.v4.a.a.c.a(resources, aVar.e());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        List<byte[]> arrayList = new ArrayList();
        for (Signature toByteArray : signatureArr) {
            arrayList.add(toByteArray.toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        Map hashMap = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.e() == 0) {
                Uri a = bVar.a();
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, i.a(context, cancellationSignal, a));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /*  JADX ERROR: NullPointerException in pass: ProcessVariables
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.regions.ProcessVariables.addToUsageMap(ProcessVariables.java:271)
        	at jadx.core.dex.visitors.regions.ProcessVariables.access$000(ProcessVariables.java:31)
        	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processInsn(ProcessVariables.java:163)
        	at jadx.core.dex.visitors.regions.ProcessVariables$CollectUsageRegionVisitor.processBlockTraced(ProcessVariables.java:129)
        	at jadx.core.dex.visitors.regions.TracedRegionVisitor.processBlock(TracedRegionVisitor.java:23)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:53)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1081)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1081)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1081)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:57)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:57)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
        	at jadx.core.dex.visitors.regions.ProcessVariables.visit(ProcessVariables.java:183)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0114 A:{REMOVE} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0122 A:{ExcHandler:  FINALLY, Splitter: B:1:0x0034} */
    /* JADX WARNING: Missing block: B:39:0x0124, code:
            if (r11 == null) goto L_0x0129;
     */
    /* JADX WARNING: Missing block: B:40:0x0126, code:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:44:?, code:
            r1 = MERGE(r0 r4 );
     */
    static android.support.v4.e.b.b[] a(android.content.Context r21, android.support.v4.e.a r22, java.lang.String r23, android.os.CancellationSignal r24) {
        /*
        r1 = r23;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = new android.net.Uri$Builder;
        r3.<init>();
        r4 = "content";
        r3 = r3.scheme(r4);
        r3 = r3.authority(r1);
        r3 = r3.build();
        r4 = new android.net.Uri$Builder;
        r4.<init>();
        r5 = "content";
        r4 = r4.scheme(r5);
        r1 = r4.authority(r1);
        r4 = "file";
        r1 = r1.appendPath(r4);
        r1 = r1.build();
        r11 = 0;
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0122 }
        r5 = 16;	 Catch:{ all -> 0x0122 }
        r12 = 1;	 Catch:{ all -> 0x0122 }
        r13 = 0;	 Catch:{ all -> 0x0122 }
        if (r4 <= r5) goto L_0x0066;	 Catch:{ all -> 0x0122 }
    L_0x003c:
        r4 = r21.getContentResolver();	 Catch:{ all -> 0x0122 }
        r14 = "_id";	 Catch:{ all -> 0x0122 }
        r15 = "file_id";	 Catch:{ all -> 0x0122 }
        r16 = "font_ttc_index";	 Catch:{ all -> 0x0122 }
        r17 = "font_variation_settings";	 Catch:{ all -> 0x0122 }
        r18 = "font_weight";	 Catch:{ all -> 0x0122 }
        r19 = "font_italic";	 Catch:{ all -> 0x0122 }
        r20 = "result_code";	 Catch:{ all -> 0x0122 }
        r6 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20};	 Catch:{ all -> 0x0122 }
        r7 = "query = ?";	 Catch:{ all -> 0x0122 }
        r8 = new java.lang.String[r12];	 Catch:{ all -> 0x0122 }
        r5 = r22.c();	 Catch:{ all -> 0x0122 }
        r8[r13] = r5;	 Catch:{ all -> 0x0122 }
        r9 = 0;	 Catch:{ all -> 0x0122 }
        r5 = r3;	 Catch:{ all -> 0x0122 }
        r10 = r24;	 Catch:{ all -> 0x0122 }
        r4 = r4.query(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0122 }
    L_0x0064:
        r11 = r4;	 Catch:{ all -> 0x0122 }
        goto L_0x008d;	 Catch:{ all -> 0x0122 }
    L_0x0066:
        r4 = r21.getContentResolver();	 Catch:{ all -> 0x0122 }
        r14 = "_id";	 Catch:{ all -> 0x0122 }
        r15 = "file_id";	 Catch:{ all -> 0x0122 }
        r16 = "font_ttc_index";	 Catch:{ all -> 0x0122 }
        r17 = "font_variation_settings";	 Catch:{ all -> 0x0122 }
        r18 = "font_weight";	 Catch:{ all -> 0x0122 }
        r19 = "font_italic";	 Catch:{ all -> 0x0122 }
        r20 = "result_code";	 Catch:{ all -> 0x0122 }
        r6 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20};	 Catch:{ all -> 0x0122 }
        r7 = "query = ?";	 Catch:{ all -> 0x0122 }
        r8 = new java.lang.String[r12];	 Catch:{ all -> 0x0122 }
        r5 = r22.c();	 Catch:{ all -> 0x0122 }
        r8[r13] = r5;	 Catch:{ all -> 0x0122 }
        r9 = 0;	 Catch:{ all -> 0x0122 }
        r5 = r3;	 Catch:{ all -> 0x0122 }
        r4 = r4.query(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0122 }
        goto L_0x0064;	 Catch:{ all -> 0x0122 }
    L_0x008d:
        if (r11 == 0) goto L_0x0114;	 Catch:{ all -> 0x0122 }
    L_0x008f:
        r4 = r11.getCount();	 Catch:{ all -> 0x0122 }
        if (r4 <= 0) goto L_0x0114;	 Catch:{ all -> 0x0122 }
    L_0x0095:
        r2 = "result_code";	 Catch:{ all -> 0x0122 }
        r2 = r11.getColumnIndex(r2);	 Catch:{ all -> 0x0122 }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x0122 }
        r4.<init>();	 Catch:{ all -> 0x0122 }
        r5 = "_id";	 Catch:{ all -> 0x0122 }
        r5 = r11.getColumnIndex(r5);	 Catch:{ all -> 0x0122 }
        r6 = "file_id";	 Catch:{ all -> 0x0122 }
        r6 = r11.getColumnIndex(r6);	 Catch:{ all -> 0x0122 }
        r7 = "font_ttc_index";	 Catch:{ all -> 0x0122 }
        r7 = r11.getColumnIndex(r7);	 Catch:{ all -> 0x0122 }
        r8 = "font_weight";	 Catch:{ all -> 0x0122 }
        r8 = r11.getColumnIndex(r8);	 Catch:{ all -> 0x0122 }
        r9 = "font_italic";	 Catch:{ all -> 0x0122 }
        r9 = r11.getColumnIndex(r9);	 Catch:{ all -> 0x0122 }
    L_0x00be:
        r10 = r11.moveToNext();	 Catch:{ all -> 0x0122 }
        if (r10 == 0) goto L_0x0113;	 Catch:{ all -> 0x0122 }
    L_0x00c4:
        r10 = -1;	 Catch:{ all -> 0x0122 }
        if (r2 == r10) goto L_0x00ce;	 Catch:{ all -> 0x0122 }
    L_0x00c7:
        r14 = r11.getInt(r2);	 Catch:{ all -> 0x0122 }
        r20 = r14;	 Catch:{ all -> 0x0122 }
        goto L_0x00d0;	 Catch:{ all -> 0x0122 }
    L_0x00ce:
        r20 = r13;	 Catch:{ all -> 0x0122 }
    L_0x00d0:
        if (r7 == r10) goto L_0x00d9;	 Catch:{ all -> 0x0122 }
    L_0x00d2:
        r14 = r11.getInt(r7);	 Catch:{ all -> 0x0122 }
        r17 = r14;	 Catch:{ all -> 0x0122 }
        goto L_0x00db;	 Catch:{ all -> 0x0122 }
    L_0x00d9:
        r17 = r13;	 Catch:{ all -> 0x0122 }
    L_0x00db:
        if (r6 != r10) goto L_0x00e8;	 Catch:{ all -> 0x0122 }
    L_0x00dd:
        r14 = r11.getLong(r5);	 Catch:{ all -> 0x0122 }
        r14 = android.content.ContentUris.withAppendedId(r3, r14);	 Catch:{ all -> 0x0122 }
    L_0x00e5:
        r16 = r14;	 Catch:{ all -> 0x0122 }
        goto L_0x00f1;	 Catch:{ all -> 0x0122 }
    L_0x00e8:
        r14 = r11.getLong(r6);	 Catch:{ all -> 0x0122 }
        r14 = android.content.ContentUris.withAppendedId(r1, r14);	 Catch:{ all -> 0x0122 }
        goto L_0x00e5;	 Catch:{ all -> 0x0122 }
    L_0x00f1:
        if (r8 == r10) goto L_0x00f8;	 Catch:{ all -> 0x0122 }
    L_0x00f3:
        r14 = r11.getInt(r8);	 Catch:{ all -> 0x0122 }
        goto L_0x00fa;	 Catch:{ all -> 0x0122 }
    L_0x00f8:
        r14 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ all -> 0x0122 }
    L_0x00fa:
        r18 = r14;	 Catch:{ all -> 0x0122 }
        if (r9 == r10) goto L_0x0107;	 Catch:{ all -> 0x0122 }
    L_0x00fe:
        r10 = r11.getInt(r9);	 Catch:{ all -> 0x0122 }
        if (r10 != r12) goto L_0x0107;	 Catch:{ all -> 0x0122 }
    L_0x0104:
        r19 = r12;	 Catch:{ all -> 0x0122 }
        goto L_0x0109;	 Catch:{ all -> 0x0122 }
    L_0x0107:
        r19 = r13;	 Catch:{ all -> 0x0122 }
    L_0x0109:
        r10 = new android.support.v4.e.b$b;	 Catch:{ all -> 0x0122 }
        r15 = r10;	 Catch:{ all -> 0x0122 }
        r15.<init>(r16, r17, r18, r19, r20);	 Catch:{ all -> 0x0122 }
        r4.add(r10);	 Catch:{ all -> 0x0122 }
        goto L_0x00be;
    L_0x0113:
        r2 = r4;
    L_0x0114:
        if (r11 == 0) goto L_0x0119;
    L_0x0116:
        r11.close();
    L_0x0119:
        r1 = new android.support.v4.e.b.b[r13];
        r1 = r2.toArray(r1);
        r1 = (android.support.v4.e.b.b[]) r1;
        return r1;
    L_0x0122:
        r0 = move-exception;
        r1 = r0;
        if (r11 == 0) goto L_0x0129;
    L_0x0126:
        r11.close();
    L_0x0129:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.e.b.a(android.content.Context, android.support.v4.e.a, java.lang.String, android.os.CancellationSignal):android.support.v4.e.b$b[]");
    }
}
