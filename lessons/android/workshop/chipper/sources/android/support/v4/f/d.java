package android.support.v4.f;

import java.util.Locale;

public final class d {
    public static final c a = new e(null, false);
    public static final c b = new e(null, true);
    public static final c c = new e(b.a, false);
    public static final c d = new e(b.a, true);
    public static final c e = new e(a.a, false);
    public static final c f = f.a;

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static class a implements c {
        static final a a = new a(true);
        static final a b = new a(false);
        private final boolean c;

        private a(boolean z) {
            this.c = z;
        }

        public int a(CharSequence charSequence, int i, int i2) {
            i2 += i;
            int i3 = 0;
            while (i < i2) {
                switch (d.a(Character.getDirectionality(charSequence.charAt(i)))) {
                    case 0:
                        if (this.c) {
                            return 0;
                        }
                        break;
                    case 1:
                        if (!this.c) {
                            return 1;
                        }
                        break;
                    default:
                        break;
                }
                i3 = 1;
                i++;
            }
            return i3 != 0 ? this.c : 2;
        }
    }

    private static class b implements c {
        static final b a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i, int i2) {
            i2 += i;
            int i3 = 2;
            while (i < i2 && i3 == 2) {
                i3 = d.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i3;
        }
    }

    private static abstract class d implements c {
        private final c a;

        d(c cVar) {
            this.a = cVar;
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            switch (this.a.a(charSequence, i, i2)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return a();
            }
        }

        protected abstract boolean a();

        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence != null && i >= 0 && i2 >= 0 && charSequence.length() - i2 >= i) {
                return this.a == null ? a() : b(charSequence, i, i2);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private static class e extends d {
        private final boolean a;

        e(c cVar, boolean z) {
            super(cVar);
            this.a = z;
        }

        protected boolean a() {
            return this.a;
        }
    }

    private static class f extends d {
        static final f a = new f();

        f() {
            super(null);
        }

        protected boolean a() {
            return e.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    /* JADX WARNING: Missing block: B:5:0x0009, code:
            return 0;
     */
    /* JADX WARNING: Missing block: B:7:0x000b, code:
            return 1;
     */
    static int b(int r0) {
        /*
        switch(r0) {
            case 0: goto L_0x000a;
            case 1: goto L_0x0008;
            case 2: goto L_0x0008;
            default: goto L_0x0003;
        };
    L_0x0003:
        switch(r0) {
            case 14: goto L_0x000a;
            case 15: goto L_0x000a;
            case 16: goto L_0x0008;
            case 17: goto L_0x0008;
            default: goto L_0x0006;
        };
    L_0x0006:
        r0 = 2;
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
    L_0x000a:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.d.b(int):int");
    }
}
