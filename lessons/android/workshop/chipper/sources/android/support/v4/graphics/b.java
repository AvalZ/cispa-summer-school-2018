package android.support.v4.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class b {

    private static class a {
        int a;
        boolean b;

        a() {
        }
    }

    public static class b {
        public char a;
        public float[] b;

        b(char c, float[] fArr) {
            this.a = c;
            this.b = fArr;
        }

        b(b bVar) {
            this.a = bVar.a;
            this.b = b.a(bVar.b, 0, bVar.b.length);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            d11 *= sin;
            double d14 = d4 * cos;
            sin2 = (sin2 * d11) + (cos2 * d14);
            double d15 = d9 / ((double) ceil);
            int i = 0;
            double d16 = d6;
            double d17 = sin2;
            double d18 = (d12 * sin2) - (d13 * cos2);
            double d19 = d5;
            double d20 = d8;
            while (i < ceil) {
                double d21 = d11;
                d11 = d20 + d15;
                double sin3 = Math.sin(d11);
                double cos3 = Math.cos(d11);
                double d22 = d15;
                d15 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                d10 = (d2 + ((d10 * sin) * cos3)) + (d14 * sin3);
                double d23 = (d12 * sin3) - (d13 * cos3);
                sin3 = (sin3 * d21) + (cos3 * d14);
                d20 = d11 - d20;
                double d24 = d14;
                d14 = Math.tan(d20 / 2.0d);
                double d25 = d11;
                d20 = (Math.sin(d20) * (Math.sqrt(((d14 * 3.0d) * d14) + 4.0d) - 1.0d)) / 3.0d;
                d11 = d19 + (d18 * d20);
                d14 = d16 + (d17 * d20);
                int i2 = ceil;
                double d26 = cos;
                double d27 = d15 - (d20 * d23);
                d20 = d10 - (d20 * sin3);
                double d28 = sin;
                Path path2 = path;
                path2.rLineTo(0.0f, 0.0f);
                path2.cubicTo((float) d11, (float) d14, (float) d27, (float) d20, (float) d15, (float) d10);
                i++;
                d16 = d10;
                d19 = d15;
                d11 = d21;
                d17 = sin3;
                d18 = d23;
                d15 = d22;
                d14 = d24;
                d20 = d25;
                ceil = i2;
                cos = d26;
                sin = d28;
                d10 = d3;
            }
        }

        private static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            float f11 = f6;
            boolean z3 = z2;
            double toRadians = Math.toRadians((double) f7);
            double cos = Math.cos(toRadians);
            double sin = Math.sin(toRadians);
            double d = (double) f8;
            double d2 = toRadians;
            toRadians = (double) f2;
            double d3 = d;
            d = (double) f10;
            double d4 = ((d * cos) + (toRadians * sin)) / d;
            double d5 = toRadians;
            toRadians = (double) f11;
            double d6 = ((((double) (-f8)) * sin) + (toRadians * cos)) / toRadians;
            double d7 = (double) f4;
            double d8 = ((((double) f9) * cos) + (d7 * sin)) / d;
            double d9 = d;
            d = ((((double) (-f9)) * sin) + (d7 * cos)) / toRadians;
            d7 = d4 - d8;
            double d10 = d6 - d;
            double d11 = (d4 + d8) / 2.0d;
            double d12 = (d6 + d) / 2.0d;
            double d13 = sin;
            sin = (d7 * d7) + (d10 * d10);
            if (sin == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d14 = cos;
            cos = (1.0d / sin) - 0.25d;
            if (cos < 0.0d) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Points are too far apart ");
                stringBuilder.append(sin);
                Log.w("PathParser", stringBuilder.toString());
                f8 = (float) (Math.sqrt(sin) / 1.99999d);
                a(path, f, f2, f9, f4, f10 * f8, f11 * f8, f7, z, z2);
                return;
            }
            boolean z4 = z2;
            double sqrt = Math.sqrt(cos);
            d7 *= sqrt;
            sqrt *= d10;
            if (z == z4) {
                d11 -= sqrt;
                d12 += d7;
            } else {
                d11 += sqrt;
                d12 -= d7;
            }
            sqrt = Math.atan2(d6 - d12, d4 - d11);
            double atan2 = Math.atan2(d - d12, d8 - d11) - sqrt;
            int i = (atan2 > 0.0d ? 1 : (atan2 == 0.0d ? 0 : -1));
            if (z4 != (i >= 0)) {
                atan2 = i > 0 ? atan2 - 6.283185307179586d : atan2 + 6.283185307179586d;
            }
            d11 *= d9;
            d12 *= toRadians;
            a(path, (d11 * d14) - (d12 * d13), (d11 * d13) + (d12 * d14), d9, toRadians, d3, d5, d2, sqrt, atan2);
        }

        /* JADX WARNING: Missing block: B:2:0x001d, code:
            r20 = 2;
     */
        /* JADX WARNING: Missing block: B:8:0x0034, code:
            r20 = r6;
     */
        /* JADX WARNING: Missing block: B:9:0x0036, code:
            r8 = r0;
            r7 = r1;
            r21 = r4;
            r22 = r5;
            r9 = 0;
            r0 = r29;
     */
        /* JADX WARNING: Missing block: B:11:0x0040, code:
            if (r9 >= r13.length) goto L_0x02d8;
     */
        /* JADX WARNING: Missing block: B:12:0x0042, code:
            r1 = 0.0f;
     */
        /* JADX WARNING: Missing block: B:13:0x004f, code:
            switch(r30) {
                case 65: goto L_0x0296;
                case 67: goto L_0x026c;
                case 72: goto L_0x025e;
                case 76: goto L_0x024b;
                case 77: goto L_0x0229;
                case 81: goto L_0x0208;
                case 83: goto L_0x01cd;
                case 84: goto L_0x01a6;
                case 86: goto L_0x0198;
                case 97: goto L_0x014c;
                case 99: goto L_0x0120;
                case 104: goto L_0x0114;
                case 108: goto L_0x0101;
                case 109: goto L_0x00df;
                case 113: goto L_0x00c0;
                case 115: goto L_0x0088;
                case 116: goto L_0x0063;
                case 118: goto L_0x0058;
                default: goto L_0x0052;
            };
     */
        /* JADX WARNING: Missing block: B:14:0x0052, code:
            r12 = r7;
            r11 = r8;
     */
        /* JADX WARNING: Missing block: B:15:0x0054, code:
            r26 = r9;
     */
        /* JADX WARNING: Missing block: B:16:0x0058, code:
            r0 = r9 + 0;
            r10.rLineTo(0.0f, r13[r0]);
            r0 = r13[r0];
     */
        /* JADX WARNING: Missing block: B:17:0x0063, code:
            if (r0 == 'q') goto L_0x006e;
     */
        /* JADX WARNING: Missing block: B:18:0x0065, code:
            if (r0 == 't') goto L_0x006e;
     */
        /* JADX WARNING: Missing block: B:19:0x0067, code:
            if (r0 == 'Q') goto L_0x006e;
     */
        /* JADX WARNING: Missing block: B:20:0x0069, code:
            if (r0 != 'T') goto L_0x006c;
     */
        /* JADX WARNING: Missing block: B:21:0x006c, code:
            r0 = 0.0f;
     */
        /* JADX WARNING: Missing block: B:22:0x006e, code:
            r1 = r8 - r2;
            r0 = r7 - r3;
     */
        /* JADX WARNING: Missing block: B:23:0x0072, code:
            r2 = r9 + 0;
            r4 = r9 + 1;
            r10.rQuadTo(r1, r0, r13[r2], r13[r4]);
            r1 = r1 + r8;
            r0 = r0 + r7;
            r8 = r8 + r13[r2];
            r7 = r7 + r13[r4];
            r3 = r0;
            r2 = r1;
     */
        /* JADX WARNING: Missing block: B:24:0x0088, code:
            if (r0 == 'c') goto L_0x0099;
     */
        /* JADX WARNING: Missing block: B:26:0x008c, code:
            if (r0 == 's') goto L_0x0099;
     */
        /* JADX WARNING: Missing block: B:28:0x0090, code:
            if (r0 == 'C') goto L_0x0099;
     */
        /* JADX WARNING: Missing block: B:30:0x0094, code:
            if (r0 != 'S') goto L_0x0097;
     */
        /* JADX WARNING: Missing block: B:31:0x0097, code:
            r2 = 0.0f;
     */
        /* JADX WARNING: Missing block: B:32:0x0099, code:
            r0 = r8 - r2;
            r2 = r7 - r3;
            r1 = r0;
     */
        /* JADX WARNING: Missing block: B:33:0x009f, code:
            r14 = r9 + 0;
            r15 = r9 + 1;
            r23 = r9 + 2;
            r24 = r9 + 3;
            r10.rCubicTo(r1, r2, r13[r14], r13[r15], r13[r23], r13[r24]);
            r0 = r13[r14] + r8;
            r1 = r13[r15] + r7;
            r8 = r8 + r13[r23];
            r2 = r13[r24];
     */
        /* JADX WARNING: Missing block: B:34:0x00c0, code:
            r0 = r9 + 0;
            r2 = r9 + 1;
            r4 = r9 + 2;
            r6 = r9 + 3;
            r10.rQuadTo(r13[r0], r13[r2], r13[r4], r13[r6]);
            r0 = r13[r0] + r8;
            r1 = r13[r2] + r7;
            r8 = r8 + r13[r4];
            r2 = r13[r6];
     */
        /* JADX WARNING: Missing block: B:35:0x00df, code:
            r0 = r9 + 0;
            r8 = r8 + r13[r0];
            r1 = r9 + 1;
            r7 = r7 + r13[r1];
     */
        /* JADX WARNING: Missing block: B:36:0x00e9, code:
            if (r9 <= 0) goto L_0x00f4;
     */
        /* JADX WARNING: Missing block: B:37:0x00eb, code:
            r10.rLineTo(r13[r0], r13[r1]);
     */
        /* JADX WARNING: Missing block: B:38:0x00f4, code:
            r10.rMoveTo(r13[r0], r13[r1]);
            r22 = r7;
            r21 = r8;
     */
        /* JADX WARNING: Missing block: B:39:0x0101, code:
            r0 = r9 + 0;
            r4 = r9 + 1;
            r10.rLineTo(r13[r0], r13[r4]);
            r8 = r8 + r13[r0];
            r0 = r13[r4];
     */
        /* JADX WARNING: Missing block: B:40:0x0111, code:
            r7 = r7 + r0;
     */
        /* JADX WARNING: Missing block: B:41:0x0114, code:
            r0 = r9 + 0;
            r10.rLineTo(r13[r0], 0.0f);
            r8 = r8 + r13[r0];
     */
        /* JADX WARNING: Missing block: B:42:0x0120, code:
            r14 = r9 + 2;
            r15 = r9 + 3;
            r23 = r9 + 4;
            r24 = r9 + 5;
            r10.rCubicTo(r13[r9 + 0], r13[r9 + 1], r13[r14], r13[r15], r13[r23], r13[r24]);
            r0 = r13[r14] + r8;
            r1 = r13[r15] + r7;
            r8 = r8 + r13[r23];
            r2 = r13[r24];
     */
        /* JADX WARNING: Missing block: B:43:0x0147, code:
            r7 = r7 + r2;
            r2 = r0;
            r3 = r1;
     */
        /* JADX WARNING: Missing block: B:44:0x014c, code:
            r14 = r9 + 5;
            r3 = r13[r14] + r8;
            r15 = r9 + 6;
            r4 = r13[r15] + r7;
            r5 = r13[r9 + 0];
            r6 = r13[r9 + 1];
            r23 = r13[r9 + 2];
     */
        /* JADX WARNING: Missing block: B:45:0x016a, code:
            if (r13[r9 + 3] == 0.0f) goto L_0x016f;
     */
        /* JADX WARNING: Missing block: B:46:0x016c, code:
            r24 = true;
     */
        /* JADX WARNING: Missing block: B:47:0x016f, code:
            r24 = false;
     */
        /* JADX WARNING: Missing block: B:49:0x0177, code:
            if (r13[r9 + 4] == 0.0f) goto L_0x017c;
     */
        /* JADX WARNING: Missing block: B:50:0x0179, code:
            r25 = true;
     */
        /* JADX WARNING: Missing block: B:51:0x017c, code:
            r25 = false;
     */
        /* JADX WARNING: Missing block: B:52:0x017e, code:
            r12 = r7;
            r11 = r8;
            r26 = r9;
            a(r10, r8, r7, r3, r4, r5, r6, r23, r24, r25);
            r8 = r11 + r13[r14];
            r7 = r12 + r13[r15];
     */
        /* JADX WARNING: Missing block: B:53:0x0198, code:
            r26 = r9;
            r9 = r26 + 0;
            r10.lineTo(r8, r13[r9]);
            r7 = r13[r9];
     */
        /* JADX WARNING: Missing block: B:54:0x01a6, code:
            r12 = r7;
            r11 = r8;
            r26 = r9;
     */
        /* JADX WARNING: Missing block: B:55:0x01aa, code:
            if (r0 == 'q') goto L_0x01b2;
     */
        /* JADX WARNING: Missing block: B:56:0x01ac, code:
            if (r0 == 't') goto L_0x01b2;
     */
        /* JADX WARNING: Missing block: B:57:0x01ae, code:
            if (r0 == 'Q') goto L_0x01b2;
     */
        /* JADX WARNING: Missing block: B:58:0x01b0, code:
            if (r0 != 'T') goto L_0x01ba;
     */
        /* JADX WARNING: Missing block: B:59:0x01b2, code:
            r12 = (r12 * 2.0f) - r3;
            r11 = (r11 * 2.0f) - r2;
     */
        /* JADX WARNING: Missing block: B:60:0x01ba, code:
            r9 = r26 + 0;
            r1 = r26 + 1;
            r10.quadTo(r11, r12, r13[r9], r13[r1]);
            r8 = r13[r9];
            r7 = r13[r1];
            r2 = r11;
            r3 = r12;
     */
        /* JADX WARNING: Missing block: B:61:0x01cd, code:
            r12 = r7;
            r11 = r8;
            r26 = r9;
     */
        /* JADX WARNING: Missing block: B:62:0x01d1, code:
            if (r0 == 'c') goto L_0x01e3;
     */
        /* JADX WARNING: Missing block: B:64:0x01d5, code:
            if (r0 == 's') goto L_0x01e3;
     */
        /* JADX WARNING: Missing block: B:66:0x01d9, code:
            if (r0 == 'C') goto L_0x01e3;
     */
        /* JADX WARNING: Missing block: B:68:0x01dd, code:
            if (r0 != 'S') goto L_0x01e0;
     */
        /* JADX WARNING: Missing block: B:69:0x01e0, code:
            r1 = r11;
            r2 = r12;
     */
        /* JADX WARNING: Missing block: B:70:0x01e3, code:
            r8 = (r11 * 2.0f) - r2;
            r2 = (r12 * 2.0f) - r3;
            r1 = r8;
     */
        /* JADX WARNING: Missing block: B:71:0x01eb, code:
            r9 = r26 + 0;
            r7 = r26 + 1;
            r8 = r26 + 2;
            r11 = r26 + 3;
            r10.cubicTo(r1, r2, r13[r9], r13[r7], r13[r8], r13[r11]);
            r0 = r13[r9];
            r1 = r13[r7];
            r8 = r13[r8];
            r7 = r13[r11];
     */
        /* JADX WARNING: Missing block: B:72:0x0208, code:
            r26 = r9;
            r9 = r26 + 0;
            r1 = r26 + 1;
            r3 = r26 + 2;
            r5 = r26 + 3;
            r10.quadTo(r13[r9], r13[r1], r13[r3], r13[r5]);
            r0 = r13[r9];
            r1 = r13[r1];
            r8 = r13[r3];
            r7 = r13[r5];
     */
        /* JADX WARNING: Missing block: B:73:0x0225, code:
            r2 = r0;
            r3 = r1;
     */
        /* JADX WARNING: Missing block: B:74:0x0229, code:
            r26 = r9;
            r9 = r26 + 0;
            r8 = r13[r9];
            r0 = r26 + 1;
            r7 = r13[r0];
     */
        /* JADX WARNING: Missing block: B:75:0x0233, code:
            if (r26 <= 0) goto L_0x023e;
     */
        /* JADX WARNING: Missing block: B:76:0x0235, code:
            r10.lineTo(r13[r9], r13[r0]);
     */
        /* JADX WARNING: Missing block: B:77:0x023e, code:
            r10.moveTo(r13[r9], r13[r0]);
            r22 = r7;
            r21 = r8;
     */
        /* JADX WARNING: Missing block: B:78:0x024b, code:
            r26 = r9;
            r9 = r26 + 0;
            r1 = r26 + 1;
            r10.lineTo(r13[r9], r13[r1]);
            r8 = r13[r9];
            r7 = r13[r1];
     */
        /* JADX WARNING: Missing block: B:79:0x025e, code:
            r26 = r9;
            r9 = r26 + 0;
            r10.lineTo(r13[r9], r7);
            r8 = r13[r9];
     */
        /* JADX WARNING: Missing block: B:80:0x026c, code:
            r26 = r9;
            r9 = r26 + 2;
            r7 = r26 + 3;
            r8 = r26 + 4;
            r11 = r26 + 5;
            r0 = r10;
            r0.cubicTo(r13[r26 + 0], r13[r26 + 1], r13[r9], r13[r7], r13[r8], r13[r11]);
            r8 = r13[r8];
            r0 = r13[r11];
            r1 = r13[r9];
            r2 = r13[r7];
            r7 = r0;
            r3 = r2;
            r2 = r1;
     */
        /* JADX WARNING: Missing block: B:81:0x0296, code:
            r12 = r7;
            r11 = r8;
            r26 = r9;
            r14 = r26 + 5;
            r3 = r13[r14];
            r15 = r26 + 6;
            r4 = r13[r15];
            r5 = r13[r26 + 0];
            r6 = r13[r26 + 1];
            r7 = r13[r26 + 2];
     */
        /* JADX WARNING: Missing block: B:82:0x02b4, code:
            if (r13[r26 + 3] == 0.0f) goto L_0x02b8;
     */
        /* JADX WARNING: Missing block: B:83:0x02b6, code:
            r8 = true;
     */
        /* JADX WARNING: Missing block: B:84:0x02b8, code:
            r8 = false;
     */
        /* JADX WARNING: Missing block: B:86:0x02bf, code:
            if (r13[r26 + 4] == 0.0f) goto L_0x02c3;
     */
        /* JADX WARNING: Missing block: B:87:0x02c1, code:
            r9 = true;
     */
        /* JADX WARNING: Missing block: B:88:0x02c3, code:
            r9 = false;
     */
        /* JADX WARNING: Missing block: B:89:0x02c4, code:
            a(r10, r11, r12, r3, r4, r5, r6, r7, r8, r9);
            r8 = r13[r14];
            r7 = r13[r15];
     */
        /* JADX WARNING: Missing block: B:90:0x02ce, code:
            r3 = r7;
            r2 = r8;
     */
        /* JADX WARNING: Missing block: B:91:0x02d0, code:
            r9 = r26 + r20;
            r0 = r30;
            r14 = 0;
     */
        /* JADX WARNING: Missing block: B:92:0x02d8, code:
            r12 = r7;
            r28[r14] = r8;
            r28[1] = r12;
            r28[2] = r2;
            r28[3] = r3;
            r28[4] = r21;
            r28[5] = r22;
     */
        /* JADX WARNING: Missing block: B:93:0x02e7, code:
            return;
     */
        private static void a(android.graphics.Path r27, float[] r28, char r29, char r30, float[] r31) {
            /*
            r10 = r27;
            r13 = r31;
            r14 = 0;
            r0 = r28[r14];
            r15 = 1;
            r1 = r28[r15];
            r16 = 2;
            r2 = r28[r16];
            r17 = 3;
            r3 = r28[r17];
            r18 = 4;
            r4 = r28[r18];
            r19 = 5;
            r5 = r28[r19];
            switch(r30) {
                case 65: goto L_0x0033;
                case 67: goto L_0x0031;
                case 72: goto L_0x002e;
                case 76: goto L_0x001d;
                case 77: goto L_0x001d;
                case 81: goto L_0x002b;
                case 83: goto L_0x002b;
                case 84: goto L_0x001d;
                case 86: goto L_0x002e;
                case 90: goto L_0x0020;
                case 97: goto L_0x0033;
                case 99: goto L_0x0031;
                case 104: goto L_0x002e;
                case 108: goto L_0x001d;
                case 109: goto L_0x001d;
                case 113: goto L_0x002b;
                case 115: goto L_0x002b;
                case 116: goto L_0x001d;
                case 118: goto L_0x002e;
                case 122: goto L_0x0020;
                default: goto L_0x001d;
            };
        L_0x001d:
            r20 = r16;
            goto L_0x0036;
        L_0x0020:
            r27.close();
            r10.moveTo(r4, r5);
            r0 = r4;
            r2 = r0;
            r1 = r5;
            r3 = r1;
            goto L_0x001d;
        L_0x002b:
            r20 = r18;
            goto L_0x0036;
        L_0x002e:
            r20 = r15;
            goto L_0x0036;
        L_0x0031:
            r6 = 6;
            goto L_0x0034;
        L_0x0033:
            r6 = 7;
        L_0x0034:
            r20 = r6;
        L_0x0036:
            r8 = r0;
            r7 = r1;
            r21 = r4;
            r22 = r5;
            r9 = r14;
            r0 = r29;
        L_0x003f:
            r1 = r13.length;
            if (r9 >= r1) goto L_0x02d8;
        L_0x0042:
            r4 = 99;
            r5 = 84;
            r6 = 81;
            r15 = 116; // 0x74 float:1.63E-43 double:5.73E-322;
            r14 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
            r23 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r1 = 0;
            switch(r30) {
                case 65: goto L_0x0296;
                case 67: goto L_0x026c;
                case 72: goto L_0x025e;
                case 76: goto L_0x024b;
                case 77: goto L_0x0229;
                case 81: goto L_0x0208;
                case 83: goto L_0x01cd;
                case 84: goto L_0x01a6;
                case 86: goto L_0x0198;
                case 97: goto L_0x014c;
                case 99: goto L_0x0120;
                case 104: goto L_0x0114;
                case 108: goto L_0x0101;
                case 109: goto L_0x00df;
                case 113: goto L_0x00c0;
                case 115: goto L_0x0088;
                case 116: goto L_0x0063;
                case 118: goto L_0x0058;
                default: goto L_0x0052;
            };
        L_0x0052:
            r12 = r7;
            r11 = r8;
        L_0x0054:
            r26 = r9;
            goto L_0x02d0;
        L_0x0058:
            r0 = r9 + 0;
            r4 = r13[r0];
            r10.rLineTo(r1, r4);
            r0 = r13[r0];
            goto L_0x0111;
        L_0x0063:
            if (r0 == r14) goto L_0x006e;
        L_0x0065:
            if (r0 == r15) goto L_0x006e;
        L_0x0067:
            if (r0 == r6) goto L_0x006e;
        L_0x0069:
            if (r0 != r5) goto L_0x006c;
        L_0x006b:
            goto L_0x006e;
        L_0x006c:
            r0 = r1;
            goto L_0x0072;
        L_0x006e:
            r1 = r8 - r2;
            r0 = r7 - r3;
        L_0x0072:
            r2 = r9 + 0;
            r3 = r13[r2];
            r4 = r9 + 1;
            r5 = r13[r4];
            r10.rQuadTo(r1, r0, r3, r5);
            r1 = r1 + r8;
            r0 = r0 + r7;
            r2 = r13[r2];
            r8 = r8 + r2;
            r2 = r13[r4];
            r7 = r7 + r2;
            r3 = r0;
            r2 = r1;
            goto L_0x0054;
        L_0x0088:
            if (r0 == r4) goto L_0x0099;
        L_0x008a:
            r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
            if (r0 == r4) goto L_0x0099;
        L_0x008e:
            r4 = 67;
            if (r0 == r4) goto L_0x0099;
        L_0x0092:
            r4 = 83;
            if (r0 != r4) goto L_0x0097;
        L_0x0096:
            goto L_0x0099;
        L_0x0097:
            r2 = r1;
            goto L_0x009f;
        L_0x0099:
            r0 = r8 - r2;
            r1 = r7 - r3;
            r2 = r1;
            r1 = r0;
        L_0x009f:
            r14 = r9 + 0;
            r3 = r13[r14];
            r15 = r9 + 1;
            r4 = r13[r15];
            r23 = r9 + 2;
            r5 = r13[r23];
            r24 = r9 + 3;
            r6 = r13[r24];
            r0 = r10;
            r0.rCubicTo(r1, r2, r3, r4, r5, r6);
            r0 = r13[r14];
            r0 = r0 + r8;
            r1 = r13[r15];
            r1 = r1 + r7;
            r2 = r13[r23];
            r8 = r8 + r2;
            r2 = r13[r24];
            goto L_0x0147;
        L_0x00c0:
            r0 = r9 + 0;
            r1 = r13[r0];
            r2 = r9 + 1;
            r3 = r13[r2];
            r4 = r9 + 2;
            r5 = r13[r4];
            r6 = r9 + 3;
            r14 = r13[r6];
            r10.rQuadTo(r1, r3, r5, r14);
            r0 = r13[r0];
            r0 = r0 + r8;
            r1 = r13[r2];
            r1 = r1 + r7;
            r2 = r13[r4];
            r8 = r8 + r2;
            r2 = r13[r6];
            goto L_0x0147;
        L_0x00df:
            r0 = r9 + 0;
            r1 = r13[r0];
            r8 = r8 + r1;
            r1 = r9 + 1;
            r4 = r13[r1];
            r7 = r7 + r4;
            if (r9 <= 0) goto L_0x00f4;
        L_0x00eb:
            r0 = r13[r0];
            r1 = r13[r1];
            r10.rLineTo(r0, r1);
            goto L_0x0054;
        L_0x00f4:
            r0 = r13[r0];
            r1 = r13[r1];
            r10.rMoveTo(r0, r1);
            r22 = r7;
            r21 = r8;
            goto L_0x0054;
        L_0x0101:
            r0 = r9 + 0;
            r1 = r13[r0];
            r4 = r9 + 1;
            r5 = r13[r4];
            r10.rLineTo(r1, r5);
            r0 = r13[r0];
            r8 = r8 + r0;
            r0 = r13[r4];
        L_0x0111:
            r7 = r7 + r0;
            goto L_0x0054;
        L_0x0114:
            r0 = r9 + 0;
            r4 = r13[r0];
            r10.rLineTo(r4, r1);
            r0 = r13[r0];
            r8 = r8 + r0;
            goto L_0x0054;
        L_0x0120:
            r0 = r9 + 0;
            r1 = r13[r0];
            r0 = r9 + 1;
            r2 = r13[r0];
            r14 = r9 + 2;
            r3 = r13[r14];
            r15 = r9 + 3;
            r4 = r13[r15];
            r23 = r9 + 4;
            r5 = r13[r23];
            r24 = r9 + 5;
            r6 = r13[r24];
            r0 = r10;
            r0.rCubicTo(r1, r2, r3, r4, r5, r6);
            r0 = r13[r14];
            r0 = r0 + r8;
            r1 = r13[r15];
            r1 = r1 + r7;
            r2 = r13[r23];
            r8 = r8 + r2;
            r2 = r13[r24];
        L_0x0147:
            r7 = r7 + r2;
            r2 = r0;
            r3 = r1;
            goto L_0x0054;
        L_0x014c:
            r14 = r9 + 5;
            r0 = r13[r14];
            r3 = r0 + r8;
            r15 = r9 + 6;
            r0 = r13[r15];
            r4 = r0 + r7;
            r0 = r9 + 0;
            r5 = r13[r0];
            r0 = r9 + 1;
            r6 = r13[r0];
            r0 = r9 + 2;
            r23 = r13[r0];
            r0 = r9 + 3;
            r0 = r13[r0];
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x016f;
        L_0x016c:
            r24 = 1;
            goto L_0x0171;
        L_0x016f:
            r24 = 0;
        L_0x0171:
            r0 = r9 + 4;
            r0 = r13[r0];
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x017c;
        L_0x0179:
            r25 = 1;
            goto L_0x017e;
        L_0x017c:
            r25 = 0;
        L_0x017e:
            r0 = r10;
            r1 = r8;
            r2 = r7;
            r12 = r7;
            r7 = r23;
            r11 = r8;
            r8 = r24;
            r26 = r9;
            r9 = r25;
            a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
            r0 = r13[r14];
            r8 = r11 + r0;
            r0 = r13[r15];
            r7 = r12 + r0;
            goto L_0x02ce;
        L_0x0198:
            r11 = r8;
            r26 = r9;
            r9 = r26 + 0;
            r0 = r13[r9];
            r10.lineTo(r11, r0);
            r7 = r13[r9];
            goto L_0x02d0;
        L_0x01a6:
            r12 = r7;
            r11 = r8;
            r26 = r9;
            if (r0 == r14) goto L_0x01b2;
        L_0x01ac:
            if (r0 == r15) goto L_0x01b2;
        L_0x01ae:
            if (r0 == r6) goto L_0x01b2;
        L_0x01b0:
            if (r0 != r5) goto L_0x01ba;
        L_0x01b2:
            r8 = r11 * r23;
            r8 = r8 - r2;
            r7 = r12 * r23;
            r7 = r7 - r3;
            r12 = r7;
            r11 = r8;
        L_0x01ba:
            r9 = r26 + 0;
            r0 = r13[r9];
            r1 = r26 + 1;
            r2 = r13[r1];
            r10.quadTo(r11, r12, r0, r2);
            r8 = r13[r9];
            r7 = r13[r1];
            r2 = r11;
            r3 = r12;
            goto L_0x02d0;
        L_0x01cd:
            r12 = r7;
            r11 = r8;
            r26 = r9;
            if (r0 == r4) goto L_0x01e3;
        L_0x01d3:
            r1 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
            if (r0 == r1) goto L_0x01e3;
        L_0x01d7:
            r1 = 67;
            if (r0 == r1) goto L_0x01e3;
        L_0x01db:
            r1 = 83;
            if (r0 != r1) goto L_0x01e0;
        L_0x01df:
            goto L_0x01e3;
        L_0x01e0:
            r1 = r11;
            r2 = r12;
            goto L_0x01eb;
        L_0x01e3:
            r8 = r11 * r23;
            r8 = r8 - r2;
            r7 = r12 * r23;
            r7 = r7 - r3;
            r2 = r7;
            r1 = r8;
        L_0x01eb:
            r9 = r26 + 0;
            r3 = r13[r9];
            r7 = r26 + 1;
            r4 = r13[r7];
            r8 = r26 + 2;
            r5 = r13[r8];
            r11 = r26 + 3;
            r6 = r13[r11];
            r0 = r10;
            r0.cubicTo(r1, r2, r3, r4, r5, r6);
            r0 = r13[r9];
            r1 = r13[r7];
            r8 = r13[r8];
            r7 = r13[r11];
            goto L_0x0225;
        L_0x0208:
            r26 = r9;
            r9 = r26 + 0;
            r0 = r13[r9];
            r1 = r26 + 1;
            r2 = r13[r1];
            r3 = r26 + 2;
            r4 = r13[r3];
            r5 = r26 + 3;
            r6 = r13[r5];
            r10.quadTo(r0, r2, r4, r6);
            r0 = r13[r9];
            r1 = r13[r1];
            r8 = r13[r3];
            r7 = r13[r5];
        L_0x0225:
            r2 = r0;
            r3 = r1;
            goto L_0x02d0;
        L_0x0229:
            r26 = r9;
            r9 = r26 + 0;
            r8 = r13[r9];
            r0 = r26 + 1;
            r7 = r13[r0];
            if (r26 <= 0) goto L_0x023e;
        L_0x0235:
            r1 = r13[r9];
            r0 = r13[r0];
            r10.lineTo(r1, r0);
            goto L_0x02d0;
        L_0x023e:
            r1 = r13[r9];
            r0 = r13[r0];
            r10.moveTo(r1, r0);
            r22 = r7;
            r21 = r8;
            goto L_0x02d0;
        L_0x024b:
            r26 = r9;
            r9 = r26 + 0;
            r0 = r13[r9];
            r1 = r26 + 1;
            r4 = r13[r1];
            r10.lineTo(r0, r4);
            r8 = r13[r9];
            r7 = r13[r1];
            goto L_0x02d0;
        L_0x025e:
            r12 = r7;
            r26 = r9;
            r9 = r26 + 0;
            r0 = r13[r9];
            r10.lineTo(r0, r12);
            r8 = r13[r9];
            goto L_0x02d0;
        L_0x026c:
            r26 = r9;
            r9 = r26 + 0;
            r1 = r13[r9];
            r9 = r26 + 1;
            r2 = r13[r9];
            r9 = r26 + 2;
            r3 = r13[r9];
            r7 = r26 + 3;
            r4 = r13[r7];
            r8 = r26 + 4;
            r5 = r13[r8];
            r11 = r26 + 5;
            r6 = r13[r11];
            r0 = r10;
            r0.cubicTo(r1, r2, r3, r4, r5, r6);
            r8 = r13[r8];
            r0 = r13[r11];
            r1 = r13[r9];
            r2 = r13[r7];
            r7 = r0;
            r3 = r2;
            r2 = r1;
            goto L_0x02d0;
        L_0x0296:
            r12 = r7;
            r11 = r8;
            r26 = r9;
            r14 = r26 + 5;
            r3 = r13[r14];
            r15 = r26 + 6;
            r4 = r13[r15];
            r9 = r26 + 0;
            r5 = r13[r9];
            r9 = r26 + 1;
            r6 = r13[r9];
            r9 = r26 + 2;
            r7 = r13[r9];
            r9 = r26 + 3;
            r0 = r13[r9];
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x02b8;
        L_0x02b6:
            r8 = 1;
            goto L_0x02b9;
        L_0x02b8:
            r8 = 0;
        L_0x02b9:
            r9 = r26 + 4;
            r0 = r13[r9];
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 == 0) goto L_0x02c3;
        L_0x02c1:
            r9 = 1;
            goto L_0x02c4;
        L_0x02c3:
            r9 = 0;
        L_0x02c4:
            r0 = r10;
            r1 = r11;
            r2 = r12;
            a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
            r8 = r13[r14];
            r7 = r13[r15];
        L_0x02ce:
            r3 = r7;
            r2 = r8;
        L_0x02d0:
            r9 = r26 + r20;
            r0 = r30;
            r14 = 0;
            r15 = 1;
            goto L_0x003f;
        L_0x02d8:
            r12 = r7;
            r1 = r14;
            r28[r1] = r8;
            r1 = 1;
            r28[r1] = r12;
            r28[r16] = r2;
            r28[r17] = r3;
            r28[r18] = r21;
            r28[r19] = r22;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.b.b.a(android.graphics.Path, float[], char, char, float[]):void");
        }

        public static void a(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                a(path, fArr, c, bVarArr[i].a, bVarArr[i].b);
                c = bVarArr[i].a;
            }
        }

        public void a(b bVar, b bVar2, float f) {
            for (int i = 0; i < bVar.b.length; i++) {
                this.b[i] = (bVar.b[i] * (1.0f - f)) + (bVar2.b[i] * f);
            }
        }
    }

    private static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static Path a(String str) {
        Path path = new Path();
        b[] b = b(str);
        if (b == null) {
            return null;
        }
        try {
            b.a(b, path);
            return path;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error in parsing ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A:{LOOP_END, LOOP:0: B:1:0x0007->B:19:0x0038} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A:{SYNTHETIC} */
    /* JADX WARNING: Missing block: B:12:0x0027, code:
            r10.b = true;
     */
    /* JADX WARNING: Missing block: B:14:0x002c, code:
            if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Missing block: B:15:0x002f, code:
            r2 = false;
     */
    private static void a(java.lang.String r8, int r9, android.support.v4.graphics.b.a r10) {
        /*
        r0 = 0;
        r10.b = r0;
        r1 = r9;
        r2 = r0;
        r3 = r2;
        r4 = r3;
    L_0x0007:
        r5 = r8.length();
        if (r1 >= r5) goto L_0x003b;
    L_0x000d:
        r5 = r8.charAt(r1);
        r6 = 32;
        r7 = 1;
        if (r5 == r6) goto L_0x0033;
    L_0x0016:
        r6 = 69;
        if (r5 == r6) goto L_0x0031;
    L_0x001a:
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 == r6) goto L_0x0031;
    L_0x001e:
        switch(r5) {
            case 44: goto L_0x0033;
            case 45: goto L_0x002a;
            case 46: goto L_0x0022;
            default: goto L_0x0021;
        };
    L_0x0021:
        goto L_0x002f;
    L_0x0022:
        if (r3 != 0) goto L_0x0027;
    L_0x0024:
        r2 = r0;
        r3 = r7;
        goto L_0x0035;
    L_0x0027:
        r10.b = r7;
        goto L_0x0033;
    L_0x002a:
        if (r1 == r9) goto L_0x002f;
    L_0x002c:
        if (r2 != 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0027;
    L_0x002f:
        r2 = r0;
        goto L_0x0035;
    L_0x0031:
        r2 = r7;
        goto L_0x0035;
    L_0x0033:
        r2 = r0;
        r4 = r7;
    L_0x0035:
        if (r4 == 0) goto L_0x0038;
    L_0x0037:
        goto L_0x003b;
    L_0x0038:
        r1 = r1 + 1;
        goto L_0x0007;
    L_0x003b:
        r10.a = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.b.a(java.lang.String, int, android.support.v4.graphics.b$a):void");
    }

    private static void a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr));
    }

    public static boolean a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        int i = 0;
        while (i < bVarArr.length) {
            if (bVarArr[i].a != bVarArr2[i].a || bVarArr[i].b.length != bVarArr2[i].b.length) {
                return false;
            }
            i++;
        }
        return true;
    }

    static float[] a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        i2 -= i;
        length = Math.min(i2, length - i);
        Object obj = new float[i2];
        System.arraycopy(fArr, i, obj, 0, length);
        return obj;
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    public static void b(b[] bVarArr, b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].a = bVarArr2[i].a;
            for (int i2 = 0; i2 < bVarArr2[i].b.length; i2++) {
                bVarArr[i].b[i2] = bVarArr2[i].b[i2];
            }
        }
    }

    public static b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            i = a(str, i);
            String trim = str.substring(i2, i).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), c(trim));
            }
            i2 = i;
            i++;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    private static float[] c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                a(str, i, aVar);
                int i3 = aVar.a;
                if (i < i3) {
                    int i4 = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2 = i4;
                }
                i = aVar.b ? i3 : i3 + 1;
            }
            return a(fArr, 0, i2);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error in parsing \"");
            stringBuilder.append(str);
            stringBuilder.append("\"");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }
}
