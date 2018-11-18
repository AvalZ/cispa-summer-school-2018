package android.support.v7.widget;

import android.support.v7.widget.at.i;
import android.support.v7.widget.at.u;
import android.view.View;

class ax {
    static int a(u uVar, as asVar, View view, View view2, i iVar, boolean z) {
        if (iVar.v() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.d(view) - iVar.d(view2)) + 1;
        }
        return Math.min(asVar.f(), asVar.b(view2) - asVar.a(view));
    }

    /* JADX WARNING: Missing block: B:15:0x0070, code:
            return 0;
     */
    static int a(android.support.v7.widget.at.u r4, android.support.v7.widget.as r5, android.view.View r6, android.view.View r7, android.support.v7.widget.at.i r8, boolean r9, boolean r10) {
        /*
        r0 = r8.v();
        r1 = 0;
        if (r0 == 0) goto L_0x0070;
    L_0x0007:
        r0 = r4.e();
        if (r0 == 0) goto L_0x0070;
    L_0x000d:
        if (r6 == 0) goto L_0x0070;
    L_0x000f:
        if (r7 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r8.d(r6);
        r2 = r8.d(r7);
        r0 = java.lang.Math.min(r0, r2);
        r2 = r8.d(r6);
        r3 = r8.d(r7);
        r2 = java.lang.Math.max(r2, r3);
        if (r10 == 0) goto L_0x0038;
    L_0x002c:
        r4 = r4.e();
        r4 = r4 - r2;
        r4 = r4 + -1;
        r4 = java.lang.Math.max(r1, r4);
        goto L_0x003c;
    L_0x0038:
        r4 = java.lang.Math.max(r1, r0);
    L_0x003c:
        if (r9 != 0) goto L_0x003f;
    L_0x003e:
        return r4;
    L_0x003f:
        r9 = r5.b(r7);
        r10 = r5.a(r6);
        r9 = r9 - r10;
        r9 = java.lang.Math.abs(r9);
        r10 = r8.d(r6);
        r7 = r8.d(r7);
        r10 = r10 - r7;
        r7 = java.lang.Math.abs(r10);
        r7 = r7 + 1;
        r8 = (float) r9;
        r7 = (float) r7;
        r8 = r8 / r7;
        r4 = (float) r4;
        r4 = r4 * r8;
        r7 = r5.c();
        r5 = r5.a(r6);
        r7 = r7 - r5;
        r5 = (float) r7;
        r4 = r4 + r5;
        r4 = java.lang.Math.round(r4);
        return r4;
    L_0x0070:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ax.a(android.support.v7.widget.at$u, android.support.v7.widget.as, android.view.View, android.view.View, android.support.v7.widget.at$i, boolean, boolean):int");
    }

    static int b(u uVar, as asVar, View view, View view2, i iVar, boolean z) {
        if (iVar.v() == 0 || uVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.e();
        }
        return (int) ((((float) (asVar.b(view2) - asVar.a(view))) / ((float) (Math.abs(iVar.d(view) - iVar.d(view2)) + 1))) * ((float) uVar.e()));
    }
}
