package android.support.transition;

import android.support.transition.u.b;
import android.support.transition.u.c;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class y extends u {
    private ArrayList<u> g = new ArrayList();
    private boolean h = true;
    private int i;
    private boolean j = false;

    static class a extends v {
        y a;

        a(y yVar) {
            this.a = yVar;
        }

        public void a(u uVar) {
            y.b(this.a);
            if (this.a.i == 0) {
                this.a.j = false;
                this.a.k();
            }
            uVar.b((c) this);
        }

        public void d(u uVar) {
            if (!this.a.j) {
                this.a.j();
                this.a.j = true;
            }
        }
    }

    private void p() {
        c aVar = new a(this);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((u) it.next()).a(aVar);
        }
        this.i = this.g.size();
    }

    public y a(int i) {
        boolean z;
        switch (i) {
            case 0:
                z = true;
                break;
            case 1:
                z = false;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
                stringBuilder.append(i);
                throw new AndroidRuntimeException(stringBuilder.toString());
        }
        this.h = z;
        return this;
    }

    String a(String str) {
        String a = super.a(str);
        for (int i = 0; i < this.g.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("\n");
            u uVar = (u) this.g.get(i);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("  ");
            stringBuilder.append(uVar.a(stringBuilder2.toString()));
            a = stringBuilder.toString();
        }
        return a;
    }

    public void a(aa aaVar) {
        if (a(aaVar.b)) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.a(aaVar.b)) {
                    uVar.a(aaVar);
                    aaVar.c.add(uVar);
                }
            }
        }
    }

    public void a(b bVar) {
        super.a(bVar);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((u) this.g.get(i)).a(bVar);
        }
    }

    protected void a(ViewGroup viewGroup, ab abVar, ab abVar2, ArrayList<aa> arrayList, ArrayList<aa> arrayList2) {
        long c = c();
        int size = this.g.size();
        int i = 0;
        while (i < size) {
            u uVar = (u) this.g.get(i);
            if (c > 0 && (this.h || i == 0)) {
                long c2 = uVar.c();
                if (c2 > 0) {
                    uVar.b(c2 + c);
                } else {
                    uVar.b(c);
                }
            }
            uVar.a(viewGroup, abVar, abVar2, arrayList, arrayList2);
            i++;
        }
    }

    public u b(int i) {
        return (i < 0 || i >= this.g.size()) ? null : (u) this.g.get(i);
    }

    public y b(u uVar) {
        this.g.add(uVar);
        uVar.d = this;
        if (this.a >= 0) {
            uVar.a(this.a);
        }
        return this;
    }

    public void b(aa aaVar) {
        if (a(aaVar.b)) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.a(aaVar.b)) {
                    uVar.b(aaVar);
                    aaVar.c.add(uVar);
                }
            }
        }
    }

    /* renamed from: c */
    public y a(long j) {
        super.a(j);
        if (this.a >= 0) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ((u) this.g.get(i)).a(j);
            }
        }
        return this;
    }

    /* renamed from: c */
    public y a(c cVar) {
        return (y) super.a(cVar);
    }

    void c(aa aaVar) {
        super.c(aaVar);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((u) this.g.get(i)).c(aaVar);
        }
    }

    /* renamed from: d */
    public y b(long j) {
        return (y) super.b(j);
    }

    /* renamed from: d */
    public y b(c cVar) {
        return (y) super.b(cVar);
    }

    public void d(View view) {
        super.d(view);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((u) this.g.get(i)).d(view);
        }
    }

    protected void e() {
        if (this.g.isEmpty()) {
            j();
            k();
            return;
        }
        p();
        if (this.h) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((u) it.next()).e();
            }
        } else {
            for (int i = 1; i < this.g.size(); i++) {
                final u uVar = (u) this.g.get(i);
                ((u) this.g.get(i - 1)).a(new v() {
                    public void a(u uVar) {
                        uVar.e();
                        uVar.b((c) this);
                    }
                });
            }
            u uVar2 = (u) this.g.get(0);
            if (uVar2 != null) {
                uVar2.e();
            }
        }
    }

    public void e(View view) {
        super.e(view);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((u) this.g.get(i)).e(view);
        }
    }

    /* renamed from: f */
    public y b(View view) {
        for (int i = 0; i < this.g.size(); i++) {
            ((u) this.g.get(i)).b(view);
        }
        return (y) super.b(view);
    }

    /* renamed from: g */
    public y c(View view) {
        for (int i = 0; i < this.g.size(); i++) {
            ((u) this.g.get(i)).c(view);
        }
        return (y) super.c(view);
    }

    /* renamed from: m */
    public u clone() {
        y yVar = (y) super.clone();
        yVar.g = new ArrayList();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            yVar.b(((u) this.g.get(i)).clone());
        }
        return yVar;
    }

    public int o() {
        return this.g.size();
    }
}
