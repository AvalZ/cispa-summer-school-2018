package android.support.transition;

import android.graphics.Rect;
import android.support.transition.u.b;
import android.support.transition.u.c;
import android.support.v4.app.s;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport extends s {
    private static boolean a(u uVar) {
        return (s.a(uVar.f()) && s.a(uVar.h()) && s.a(uVar.i())) ? false : true;
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        y yVar = new y();
        if (obj != null) {
            yVar.b((u) obj);
        }
        if (obj2 != null) {
            yVar.b((u) obj2);
        }
        if (obj3 != null) {
            yVar.b((u) obj3);
        }
        return yVar;
    }

    public void a(ViewGroup viewGroup, Object obj) {
        w.a(viewGroup, (u) obj);
    }

    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((u) obj).a(new b() {
            });
        }
    }

    public void a(Object obj, View view) {
        if (view != null) {
            u uVar = (u) obj;
            final Rect rect = new Rect();
            a(view, rect);
            uVar.a(new b() {
            });
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        obj = (y) obj;
        List g = obj.g();
        g.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            s.a(g, (View) arrayList.get(i));
        }
        g.add(view);
        arrayList.add(view);
        a(obj, (ArrayList) arrayList);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((u) obj).a(new c() {
            public void a(u uVar) {
            }

            public void b(u uVar) {
            }

            public void c(u uVar) {
            }

            public void d(u uVar) {
                if (obj5 != null) {
                    FragmentTransitionSupport.this.b(obj5, arrayList4, null);
                }
                if (obj6 != null) {
                    FragmentTransitionSupport.this.b(obj6, arrayList5, null);
                }
                if (obj7 != null) {
                    FragmentTransitionSupport.this.b(obj7, arrayList6, null);
                }
            }
        });
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        u uVar = (u) obj;
        if (uVar != null) {
            int i = 0;
            if (uVar instanceof y) {
                y yVar = (y) uVar;
                int o = yVar.o();
                while (i < o) {
                    a(yVar.b(i), (ArrayList) arrayList);
                    i++;
                }
            } else if (!a(uVar) && s.a(uVar.g())) {
                int size = arrayList.size();
                while (i < size) {
                    uVar.b((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        obj = (y) obj;
        if (obj != null) {
            obj.g().clear();
            obj.g().addAll(arrayList2);
            b(obj, (ArrayList) arrayList, (ArrayList) arrayList2);
        }
    }

    public boolean a(Object obj) {
        return obj instanceof u;
    }

    public Object b(Object obj) {
        return obj != null ? ((u) obj).clone() : null;
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        u uVar = (u) obj;
        u uVar2 = (u) obj2;
        u uVar3 = (u) obj3;
        if (uVar != null && uVar2 != null) {
            uVar = new y().b(uVar).b(uVar2).a(1);
        } else if (uVar == null) {
            uVar = uVar2 != null ? uVar2 : null;
        }
        if (uVar3 == null) {
            return uVar;
        }
        y yVar = new y();
        if (uVar != null) {
            yVar.b(uVar);
        }
        yVar.b(uVar3);
        return yVar;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((u) obj).b(view);
        }
    }

    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((u) obj).a(new c() {
            public void a(u uVar) {
                uVar.b((c) this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }

            public void b(u uVar) {
            }

            public void c(u uVar) {
            }

            public void d(u uVar) {
            }
        });
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        u uVar = (u) obj;
        int i = 0;
        if (uVar instanceof y) {
            y yVar = (y) uVar;
            int o = yVar.o();
            while (i < o) {
                b(yVar.b(i), (ArrayList) arrayList, (ArrayList) arrayList2);
                i++;
            }
        } else if (!a(uVar)) {
            List g = uVar.g();
            if (g.size() == arrayList.size() && g.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i < size) {
                    uVar.b((View) arrayList2.get(i));
                    i++;
                }
                for (size = arrayList.size() - 1; size >= 0; size--) {
                    uVar.c((View) arrayList.get(size));
                }
            }
        }
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        y yVar = new y();
        yVar.b((u) obj);
        return yVar;
    }

    public void c(Object obj, View view) {
        if (obj != null) {
            ((u) obj).c(view);
        }
    }
}
