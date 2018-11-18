package android.support.v7.widget;

import java.util.List;

class ar {
    final a a;

    interface a {
        b a(int i, int i2, int i3, Object obj);

        void a(b bVar);
    }

    ar(a aVar) {
        this.a = aVar;
    }

    private void a(List<b> list, int i, int i2) {
        b bVar = (b) list.get(i);
        b bVar2 = (b) list.get(i2);
        int i3 = bVar2.a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    c(list, i, bVar, i2, bVar2);
                    return;
                case 2:
                    a(list, i, bVar, i2, bVar2);
                    return;
                default:
                    return;
            }
        }
        b(list, i, bVar, i2, bVar2);
    }

    private int b(List<b> list) {
        int i = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((b) list.get(size)).a != 8) {
                i = 1;
            } else if (i != 0) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<b> list, int i, b bVar, int i2, b bVar2) {
        int i3 = bVar.d < bVar2.b ? -1 : 0;
        if (bVar.b < bVar2.b) {
            i3++;
        }
        if (bVar2.b <= bVar.b) {
            bVar.b += bVar2.d;
        }
        if (bVar2.b <= bVar.d) {
            bVar.d += bVar2.d;
        }
        bVar2.b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    void a(List<b> list) {
        while (true) {
            int b = b(list);
            if (b != -1) {
                a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Missing block: B:44:0x00c7, code:
            if (r11.d > r13.b) goto L_0x00c9;
     */
    /* JADX WARNING: Missing block: B:57:0x00fe, code:
            if (r11.d >= r13.b) goto L_0x00c9;
     */
    void a(java.util.List<android.support.v7.widget.e.b> r9, int r10, android.support.v7.widget.e.b r11, int r12, android.support.v7.widget.e.b r13) {
        /*
        r8 = this;
        r0 = r11.b;
        r1 = r11.d;
        r2 = 0;
        r3 = 1;
        if (r0 >= r1) goto L_0x001c;
    L_0x0008:
        r0 = r13.b;
        r1 = r11.b;
        if (r0 != r1) goto L_0x001a;
    L_0x000e:
        r0 = r13.d;
        r1 = r11.d;
        r4 = r11.b;
        r1 = r1 - r4;
        if (r0 != r1) goto L_0x001a;
    L_0x0017:
        r0 = r2;
        r2 = r3;
        goto L_0x0030;
    L_0x001a:
        r0 = r2;
        goto L_0x0030;
    L_0x001c:
        r0 = r13.b;
        r1 = r11.d;
        r1 = r1 + r3;
        if (r0 != r1) goto L_0x002f;
    L_0x0023:
        r0 = r13.d;
        r1 = r11.b;
        r4 = r11.d;
        r1 = r1 - r4;
        if (r0 != r1) goto L_0x002f;
    L_0x002c:
        r0 = r3;
        r2 = r0;
        goto L_0x0030;
    L_0x002f:
        r0 = r3;
    L_0x0030:
        r1 = r11.d;
        r4 = r13.b;
        r5 = 2;
        if (r1 >= r4) goto L_0x003d;
    L_0x0037:
        r1 = r13.b;
        r1 = r1 - r3;
        r13.b = r1;
        goto L_0x005c;
    L_0x003d:
        r1 = r11.d;
        r4 = r13.b;
        r6 = r13.d;
        r4 = r4 + r6;
        if (r1 >= r4) goto L_0x005c;
    L_0x0046:
        r10 = r13.d;
        r10 = r10 - r3;
        r13.d = r10;
        r11.a = r5;
        r11.d = r3;
        r10 = r13.d;
        if (r10 != 0) goto L_0x005b;
    L_0x0053:
        r9.remove(r12);
        r8 = r8.a;
        r8.a(r13);
    L_0x005b:
        return;
    L_0x005c:
        r1 = r11.b;
        r4 = r13.b;
        r6 = 0;
        if (r1 > r4) goto L_0x0069;
    L_0x0063:
        r1 = r13.b;
        r1 = r1 + r3;
        r13.b = r1;
        goto L_0x008a;
    L_0x0069:
        r1 = r11.b;
        r4 = r13.b;
        r7 = r13.d;
        r4 = r4 + r7;
        if (r1 >= r4) goto L_0x008a;
    L_0x0072:
        r1 = r13.b;
        r4 = r13.d;
        r1 = r1 + r4;
        r4 = r11.b;
        r1 = r1 - r4;
        r4 = r8.a;
        r7 = r11.b;
        r7 = r7 + r3;
        r6 = r4.a(r5, r7, r1, r6);
        r1 = r11.b;
        r3 = r13.b;
        r1 = r1 - r3;
        r13.d = r1;
    L_0x008a:
        if (r2 == 0) goto L_0x0098;
    L_0x008c:
        r9.set(r10, r13);
        r9.remove(r12);
        r8 = r8.a;
        r8.a(r11);
        return;
    L_0x0098:
        if (r0 == 0) goto L_0x00d1;
    L_0x009a:
        if (r6 == 0) goto L_0x00b6;
    L_0x009c:
        r8 = r11.b;
        r0 = r6.b;
        if (r8 <= r0) goto L_0x00a9;
    L_0x00a2:
        r8 = r11.b;
        r0 = r6.d;
        r8 = r8 - r0;
        r11.b = r8;
    L_0x00a9:
        r8 = r11.d;
        r0 = r6.b;
        if (r8 <= r0) goto L_0x00b6;
    L_0x00af:
        r8 = r11.d;
        r0 = r6.d;
        r8 = r8 - r0;
        r11.d = r8;
    L_0x00b6:
        r8 = r11.b;
        r0 = r13.b;
        if (r8 <= r0) goto L_0x00c3;
    L_0x00bc:
        r8 = r11.b;
        r0 = r13.d;
        r8 = r8 - r0;
        r11.b = r8;
    L_0x00c3:
        r8 = r11.d;
        r0 = r13.b;
        if (r8 <= r0) goto L_0x0101;
    L_0x00c9:
        r8 = r11.d;
        r0 = r13.d;
        r8 = r8 - r0;
        r11.d = r8;
        goto L_0x0101;
    L_0x00d1:
        if (r6 == 0) goto L_0x00ed;
    L_0x00d3:
        r8 = r11.b;
        r0 = r6.b;
        if (r8 < r0) goto L_0x00e0;
    L_0x00d9:
        r8 = r11.b;
        r0 = r6.d;
        r8 = r8 - r0;
        r11.b = r8;
    L_0x00e0:
        r8 = r11.d;
        r0 = r6.b;
        if (r8 < r0) goto L_0x00ed;
    L_0x00e6:
        r8 = r11.d;
        r0 = r6.d;
        r8 = r8 - r0;
        r11.d = r8;
    L_0x00ed:
        r8 = r11.b;
        r0 = r13.b;
        if (r8 < r0) goto L_0x00fa;
    L_0x00f3:
        r8 = r11.b;
        r0 = r13.d;
        r8 = r8 - r0;
        r11.b = r8;
    L_0x00fa:
        r8 = r11.d;
        r0 = r13.b;
        if (r8 < r0) goto L_0x0101;
    L_0x0100:
        goto L_0x00c9;
    L_0x0101:
        r9.set(r10, r13);
        r8 = r11.b;
        r13 = r11.d;
        if (r8 == r13) goto L_0x010e;
    L_0x010a:
        r9.set(r12, r11);
        goto L_0x0111;
    L_0x010e:
        r9.remove(r12);
    L_0x0111:
        if (r6 == 0) goto L_0x0116;
    L_0x0113:
        r9.add(r10, r6);
    L_0x0116:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ar.a(java.util.List, int, android.support.v7.widget.e$b, int, android.support.v7.widget.e$b):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    void b(java.util.List<android.support.v7.widget.e.b> r8, int r9, android.support.v7.widget.e.b r10, int r11, android.support.v7.widget.e.b r12) {
        /*
        r7 = this;
        r0 = r10.d;
        r1 = r12.b;
        r2 = 4;
        r3 = 0;
        r4 = 1;
        if (r0 >= r1) goto L_0x000f;
    L_0x0009:
        r0 = r12.b;
        r0 = r0 - r4;
        r12.b = r0;
        goto L_0x0028;
    L_0x000f:
        r0 = r10.d;
        r1 = r12.b;
        r5 = r12.d;
        r1 = r1 + r5;
        if (r0 >= r1) goto L_0x0028;
    L_0x0018:
        r0 = r12.d;
        r0 = r0 - r4;
        r12.d = r0;
        r0 = r7.a;
        r1 = r10.b;
        r5 = r12.c;
        r0 = r0.a(r2, r1, r4, r5);
        goto L_0x0029;
    L_0x0028:
        r0 = r3;
    L_0x0029:
        r1 = r10.b;
        r5 = r12.b;
        if (r1 > r5) goto L_0x0035;
    L_0x002f:
        r1 = r12.b;
        r1 = r1 + r4;
        r12.b = r1;
        goto L_0x0056;
    L_0x0035:
        r1 = r10.b;
        r5 = r12.b;
        r6 = r12.d;
        r5 = r5 + r6;
        if (r1 >= r5) goto L_0x0056;
    L_0x003e:
        r1 = r12.b;
        r3 = r12.d;
        r1 = r1 + r3;
        r3 = r10.b;
        r1 = r1 - r3;
        r3 = r7.a;
        r5 = r10.b;
        r5 = r5 + r4;
        r4 = r12.c;
        r3 = r3.a(r2, r5, r1, r4);
        r2 = r12.d;
        r2 = r2 - r1;
        r12.d = r2;
    L_0x0056:
        r8.set(r11, r10);
        r10 = r12.d;
        if (r10 <= 0) goto L_0x0061;
    L_0x005d:
        r8.set(r9, r12);
        goto L_0x0069;
    L_0x0061:
        r8.remove(r9);
        r7 = r7.a;
        r7.a(r12);
    L_0x0069:
        if (r0 == 0) goto L_0x006e;
    L_0x006b:
        r8.add(r9, r0);
    L_0x006e:
        if (r3 == 0) goto L_0x0073;
    L_0x0070:
        r8.add(r9, r3);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ar.b(java.util.List, int, android.support.v7.widget.e$b, int, android.support.v7.widget.e$b):void");
    }
}
