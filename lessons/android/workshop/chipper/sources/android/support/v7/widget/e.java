package android.support.v7.widget;

import android.support.v7.widget.at.x;
import java.util.ArrayList;
import java.util.List;

class e implements a {
    final ArrayList<b> a;
    final ArrayList<b> b;
    final a c;
    Runnable d;
    final boolean e;
    final ar f;
    private android.support.v4.g.j.a<b> g;
    private int h;

    interface a {
        x a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    static class b {
        int a;
        int b;
        Object c;
        int d;

        b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        String a() {
            int i = this.a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a != bVar.a) {
                return false;
            }
            if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            if (this.c != null) {
                if (!this.c.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append("[");
            stringBuilder.append(a());
            stringBuilder.append(",s:");
            stringBuilder.append(this.b);
            stringBuilder.append("c:");
            stringBuilder.append(this.d);
            stringBuilder.append(",p:");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    e(a aVar) {
        this(aVar, false);
    }

    e(a aVar, boolean z) {
        this.g = new android.support.v4.g.j.b(30);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.h = 0;
        this.c = aVar;
        this.e = z;
        this.f = new ar(this);
    }

    private int b(int i, int i2) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            b bVar = (b) this.b.get(size);
            int i3;
            if (bVar.a == 8) {
                int i4;
                if (bVar.b < bVar.d) {
                    i3 = bVar.b;
                    i4 = bVar.d;
                } else {
                    i3 = bVar.d;
                    i4 = bVar.b;
                }
                if (i < i3 || i > i4) {
                    if (i < bVar.b) {
                        if (i2 == 1) {
                            bVar.b++;
                            i3 = bVar.d + 1;
                        } else if (i2 == 2) {
                            bVar.b--;
                            i3 = bVar.d - 1;
                        }
                        bVar.d = i3;
                    }
                } else if (i3 == bVar.b) {
                    if (i2 == 1) {
                        i3 = bVar.d + 1;
                    } else {
                        if (i2 == 2) {
                            i3 = bVar.d - 1;
                        }
                        i++;
                    }
                    bVar.d = i3;
                    i++;
                } else {
                    if (i2 == 1) {
                        i3 = bVar.b + 1;
                    } else {
                        if (i2 == 2) {
                            i3 = bVar.b - 1;
                        }
                        i--;
                    }
                    bVar.b = i3;
                    i--;
                }
            } else if (bVar.b > i) {
                if (i2 == 1) {
                    i3 = bVar.b + 1;
                } else if (i2 == 2) {
                    i3 = bVar.b - 1;
                }
                bVar.b = i3;
            } else if (bVar.a == 1) {
                i -= bVar.d;
            } else if (bVar.a == 2) {
                i += bVar.d;
            }
        }
        for (i2 = this.b.size() - 1; i2 >= 0; i2--) {
            b bVar2 = (b) this.b.get(i2);
            if (bVar2.a == 8) {
                if (bVar2.d != bVar2.b && bVar2.d >= 0) {
                }
            } else if (bVar2.d > 0) {
            }
            this.b.remove(i2);
            a(bVar2);
        }
        return i;
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        int i3 = bVar.b;
        int i4 = -1;
        int i5 = 0;
        while (i3 < i2) {
            int i6;
            if (this.c.a(i3) != null || d(i3)) {
                if (i4 == 0) {
                    e(a(2, i, i5, null));
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i6 = 1;
            } else {
                if (i4 == 1) {
                    g(a(2, i, i5, null));
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                i6 = 0;
            }
            if (i4 != 0) {
                i3 -= i5;
                i2 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i3++;
            i4 = i6;
        }
        if (i5 != bVar.d) {
            a(bVar);
            bVar = a(2, i, i5, null);
        }
        if (i4 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private void d(b bVar) {
        int i = bVar.b;
        int i2 = bVar.b + bVar.d;
        int i3 = bVar.b;
        int i4 = -1;
        int i5 = i;
        i = 0;
        while (i3 < i2) {
            if (this.c.a(i3) != null || d(i3)) {
                if (i4 == 0) {
                    e(a(4, i5, i, bVar.c));
                    i5 = i3;
                    i = 0;
                }
                i4 = 1;
            } else {
                if (i4 == 1) {
                    g(a(4, i5, i, bVar.c));
                    i5 = i3;
                    i = 0;
                }
                i4 = 0;
            }
            i++;
            i3++;
        }
        if (i != bVar.d) {
            Object obj = bVar.c;
            a(bVar);
            bVar = a(4, i5, i, obj);
        }
        if (i4 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.b.get(i2);
            if (bVar.a == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.a == 1) {
                int i3 = bVar.b + bVar.d;
                for (int i4 = bVar.b; i4 < i3; i4++) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        if (bVar.a == 1 || bVar.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int b = b(bVar.b, bVar.a);
        int i = bVar.b;
        int i2 = bVar.a;
        if (i2 == 2) {
            i2 = 0;
        } else if (i2 != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op should be remove or update.");
            stringBuilder.append(bVar);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            i2 = 1;
        }
        int i3 = b;
        b = 1;
        int i4 = i;
        i = b;
        while (b < bVar.d) {
            int b2 = b(bVar.b + (i2 * b), bVar.a);
            int i5 = bVar.a;
            Object obj = (i5 == 2 ? b2 != i3 : !(i5 == 4 && b2 == i3 + 1)) ? null : 1;
            if (obj != null) {
                i++;
            } else {
                b a = a(bVar.a, i3, i, bVar.c);
                a(a, i4);
                a(a);
                if (bVar.a == 4) {
                    i4 += i;
                }
                i = 1;
                i3 = b2;
            }
            b++;
        }
        Object obj2 = bVar.c;
        a(bVar);
        if (i > 0) {
            bVar = a(bVar.a, i3, i, obj2);
            a(bVar, i4);
            a(bVar);
        }
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.b.add(bVar);
        int i = bVar.a;
        if (i == 4) {
            this.c.a(bVar.b, bVar.d, bVar.c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.c.c(bVar.b, bVar.d);
                    return;
                case 2:
                    this.c.b(bVar.b, bVar.d);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown update op type for ");
                    stringBuilder.append(bVar);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } else {
            this.c.d(bVar.b, bVar.d);
        }
    }

    int a(int i, int i2) {
        int size = this.b.size();
        while (i2 < size) {
            b bVar = (b) this.b.get(i2);
            if (bVar.a == 8) {
                if (bVar.b == i) {
                    i = bVar.d;
                } else {
                    if (bVar.b < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else if (bVar.b > i) {
                continue;
            } else if (bVar.a == 2) {
                if (i < bVar.b + bVar.d) {
                    return -1;
                }
                i -= bVar.d;
            } else if (bVar.a == 1) {
                i += bVar.d;
            }
            i2++;
        }
        return i;
    }

    public b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.g.a();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.d = i3;
        bVar.c = obj;
        return bVar;
    }

    void a() {
        a(this.a);
        a(this.b);
        this.h = 0;
    }

    public void a(b bVar) {
        if (!this.e) {
            bVar.c = null;
            this.g.a(bVar);
        }
    }

    void a(b bVar, int i) {
        this.c.a(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            this.c.a(i, bVar.d);
        } else if (i2 != 4) {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        } else {
            this.c.a(i, bVar.d, bVar.c);
        }
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a((b) list.get(i));
        }
        list.clear();
    }

    boolean a(int i) {
        return (this.h & i) != 0;
    }

    int b(int i) {
        return a(i, 0);
    }

    void b() {
        this.f.a(this.a);
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.a.get(i);
            int i2 = bVar.a;
            if (i2 == 4) {
                d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        f(bVar);
                        break;
                    case 2:
                        c(bVar);
                        break;
                }
            } else {
                b(bVar);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        this.a.clear();
    }

    public int c(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.a.get(i2);
            int i3 = bVar.a;
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        if (bVar.b > i) {
                            break;
                        }
                        i += bVar.d;
                        break;
                    case 2:
                        if (bVar.b <= i) {
                            if (bVar.b + bVar.d <= i) {
                                i -= bVar.d;
                                break;
                            }
                            return -1;
                        }
                        continue;
                    default:
                        continue;
                }
            } else if (bVar.b == i) {
                i = bVar.d;
            } else {
                if (bVar.b < i) {
                    i--;
                }
                if (bVar.d <= i) {
                    i++;
                }
            }
        }
        return i;
    }

    void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.c.b((b) this.b.get(i));
        }
        a(this.b);
        this.h = 0;
    }

    boolean d() {
        return this.a.size() > 0;
    }

    void e() {
        c();
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.a.get(i);
            int i2 = bVar.a;
            if (i2 == 4) {
                this.c.b(bVar);
                this.c.a(bVar.b, bVar.d, bVar.c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.c.b(bVar);
                        this.c.c(bVar.b, bVar.d);
                        break;
                    case 2:
                        this.c.b(bVar);
                        this.c.a(bVar.b, bVar.d);
                        break;
                }
            } else {
                this.c.b(bVar);
                this.c.d(bVar.b, bVar.d);
            }
            if (this.d != null) {
                this.d.run();
            }
        }
        a(this.a);
        this.h = 0;
    }

    boolean f() {
        return (this.b.isEmpty() || this.a.isEmpty()) ? false : true;
    }
}
