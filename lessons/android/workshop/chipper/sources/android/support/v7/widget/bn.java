package android.support.v7.widget;

import android.support.v4.g.f;
import android.support.v7.widget.at.f.c;
import android.support.v7.widget.at.x;

class bn {
    final android.support.v4.g.a<x, a> a = new android.support.v4.g.a();
    final f<x> b = new f();

    static class a {
        static android.support.v4.g.j.a<a> d = new android.support.v4.g.j.b(20);
        int a;
        c b;
        c c;

        private a() {
        }

        static a a() {
            a aVar = (a) d.a();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }

        static void b() {
            while (d.a() != null) {
            }
        }
    }

    interface b {
        void a(x xVar);

        void a(x xVar, c cVar, c cVar2);

        void b(x xVar, c cVar, c cVar2);

        void c(x xVar, c cVar, c cVar2);
    }

    bn() {
    }

    private c a(x xVar, int i) {
        int a = this.a.a((Object) xVar);
        if (a < 0) {
            return null;
        }
        a aVar = (a) this.a.c(a);
        if (aVar == null || (aVar.a & i) == 0) {
            return null;
        }
        c cVar;
        aVar.a &= ~i;
        if (i == 4) {
            cVar = aVar.b;
        } else if (i == 8) {
            cVar = aVar.c;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((aVar.a & 12) == 0) {
            this.a.d(a);
            a.a(aVar);
        }
        return cVar;
    }

    x a(long j) {
        return (x) this.b.a(j);
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(long j, x xVar) {
        this.b.b(j, xVar);
    }

    void a(x xVar, c cVar) {
        a aVar = (a) this.a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(xVar, aVar);
        }
        aVar.b = cVar;
        aVar.a |= 4;
    }

    void a(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            x xVar = (x) this.a.b(size);
            a aVar = (a) this.a.d(size);
            if ((aVar.a & 3) != 3) {
                c cVar;
                c cVar2;
                if ((aVar.a & 1) == 0) {
                    if ((aVar.a & 14) != 14) {
                        if ((aVar.a & 12) == 12) {
                            bVar.c(xVar, aVar.b, aVar.c);
                        } else if ((aVar.a & 4) != 0) {
                            cVar = aVar.b;
                            cVar2 = null;
                        } else if ((aVar.a & 8) == 0) {
                            int i = aVar.a;
                        }
                        a.a(aVar);
                    }
                    bVar.b(xVar, aVar.b, aVar.c);
                    a.a(aVar);
                } else if (aVar.b != null) {
                    cVar = aVar.b;
                    cVar2 = aVar.c;
                }
                bVar.a(xVar, cVar, cVar2);
                a.a(aVar);
            }
            bVar.a(xVar);
            a.a(aVar);
        }
    }

    boolean a(x xVar) {
        a aVar = (a) this.a.get(xVar);
        return (aVar == null || (aVar.a & 1) == 0) ? false : true;
    }

    c b(x xVar) {
        return a(xVar, 4);
    }

    void b() {
        a.b();
    }

    void b(x xVar, c cVar) {
        a aVar = (a) this.a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(xVar, aVar);
        }
        aVar.a |= 2;
        aVar.b = cVar;
    }

    c c(x xVar) {
        return a(xVar, 8);
    }

    void c(x xVar, c cVar) {
        a aVar = (a) this.a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(xVar, aVar);
        }
        aVar.c = cVar;
        aVar.a |= 8;
    }

    boolean d(x xVar) {
        a aVar = (a) this.a.get(xVar);
        return (aVar == null || (aVar.a & 4) == 0) ? false : true;
    }

    void e(x xVar) {
        a aVar = (a) this.a.get(xVar);
        if (aVar == null) {
            aVar = a.a();
            this.a.put(xVar, aVar);
        }
        aVar.a |= 1;
    }

    void f(x xVar) {
        a aVar = (a) this.a.get(xVar);
        if (aVar != null) {
            aVar.a &= -2;
        }
    }

    void g(x xVar) {
        for (int b = this.b.b() - 1; b >= 0; b--) {
            if (xVar == this.b.c(b)) {
                this.b.a(b);
                break;
            }
        }
        a aVar = (a) this.a.remove(xVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }

    public void h(x xVar) {
        f(xVar);
    }
}
