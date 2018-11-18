package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.h.s;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class h implements android.support.v4.b.a.a {
    private static final int[] d = new int[]{1, 4, 5, 3, 2, 0};
    private boolean A;
    CharSequence a;
    Drawable b;
    View c;
    private final Context e;
    private final Resources f;
    private boolean g;
    private boolean h;
    private a i;
    private ArrayList<j> j;
    private ArrayList<j> k;
    private boolean l;
    private ArrayList<j> m;
    private ArrayList<j> n;
    private boolean o;
    private int p = 0;
    private ContextMenuInfo q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private ArrayList<j> w = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<o>> x = new CopyOnWriteArrayList();
    private j y;
    private boolean z = false;

    public interface a {
        void a(h hVar);

        boolean a(h hVar, MenuItem menuItem);
    }

    public interface b {
        boolean a(j jVar);
    }

    public h(Context context) {
        this.e = context;
        this.f = context.getResources();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = true;
        e(true);
    }

    private static int a(ArrayList<j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((j) arrayList.get(size)).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private j a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new j(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources e = e();
        if (view != null) {
            this.c = view;
            this.a = null;
            this.b = null;
        } else {
            if (i > 0) {
                this.a = e.getText(i);
            } else if (charSequence != null) {
                this.a = charSequence;
            }
            if (i2 > 0) {
                this.b = android.support.v4.a.a.a(f(), i2);
            } else if (drawable != null) {
                this.b = drawable;
            }
            this.c = null;
        }
        b(false);
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.j.size()) {
            this.j.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    private boolean a(u uVar, o oVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        if (oVar != null) {
            z = oVar.a(uVar);
        }
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            o oVar2 = (o) weakReference.get();
            if (oVar2 == null) {
                this.x.remove(weakReference);
            } else if (!z) {
                z = oVar2.a(uVar);
            }
        }
        return z;
    }

    private void d(boolean z) {
        if (!this.x.isEmpty()) {
            h();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.x.remove(weakReference);
                } else {
                    oVar.b(z);
                }
            }
            i();
        }
    }

    private void e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f.getConfiguration().keyboard != 1 && s.c(ViewConfiguration.get(this.e), this.e))) {
            z2 = false;
        }
        this.h = z2;
    }

    private static int f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 < 0 || i2 >= d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & 65535) | (d[i2] << 16);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (((j) this.j.get(i2)).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public h a(int i) {
        this.p = i;
        return this;
    }

    protected h a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected h a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    protected h a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    j a(int i, KeyEvent keyEvent) {
        List list = this.w;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (j) list.get(0);
        }
        boolean c = c();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) list.get(i2);
            char alphabeticShortcut = c ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (c && alphabeticShortcut == 8 && i == 67))) {
                return jVar;
            }
        }
        return null;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int f = f(i3);
        MenuItem a = a(i, i2, i3, f, charSequence, this.p);
        if (this.q != null) {
            a.a(this.q);
        }
        this.j.add(a(this.j, f), a);
        b(true);
        return a;
    }

    protected String a() {
        return "android:menu:actionviewstates";
    }

    public void a(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((u) item.getSubMenu()).a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(a(), sparseArray);
        }
    }

    public void a(a aVar) {
        this.i = aVar;
    }

    void a(j jVar) {
        this.l = true;
        b(true);
    }

    public void a(o oVar) {
        a(oVar, this.e);
    }

    public void a(o oVar, Context context) {
        this.x.add(new WeakReference(oVar));
        oVar.a(context, this);
        this.o = true;
    }

    void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.j.size();
        h();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (j) this.j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.g() && menuItem2.isCheckable()) {
                menuItem2.b(menuItem2 == menuItem);
            }
        }
        i();
    }

    void a(List<j> list, int i, KeyEvent keyEvent) {
        boolean c = c();
        int modifiers = keyEvent.getModifiers();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = (j) this.j.get(i2);
                if (jVar.hasSubMenu()) {
                    ((h) jVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = c ? jVar.getAlphabeticShortcut() : jVar.getNumericShortcut();
                if (!(((modifiers & 69647) == ((c ? jVar.getAlphabeticModifiers() : jVar.getNumericModifiers()) & 69647) ? 1 : 0) == 0 || alphabeticShortcut == 0 || ((alphabeticShortcut != keyData.meta[0] && alphabeticShortcut != keyData.meta[2] && (!c || alphabeticShortcut != 8 || i != 67)) || !jVar.isEnabled()))) {
                    list.add(jVar);
                }
            }
        }
    }

    public final void a(boolean z) {
        if (!this.v) {
            this.v = true;
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.x.remove(weakReference);
                } else {
                    oVar.a(this, z);
                }
            }
            this.v = false;
        }
    }

    boolean a(h hVar, MenuItem menuItem) {
        return this.i != null && this.i.a(hVar, menuItem);
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, null, i);
    }

    /* JADX WARNING: Missing block: B:14:0x002b, code:
            if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Missing block: B:21:0x003c, code:
            if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Missing block: B:32:0x0068, code:
            if (r1 == false) goto L_0x002d;
     */
    /* JADX WARNING: Missing block: B:33:0x006b, code:
            return r1;
     */
    public boolean a(android.view.MenuItem r7, android.support.v7.view.menu.o r8, int r9) {
        /*
        r6 = this;
        r7 = (android.support.v7.view.menu.j) r7;
        r0 = 0;
        if (r7 == 0) goto L_0x006c;
    L_0x0005:
        r1 = r7.isEnabled();
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = r7.b();
        r2 = r7.a();
        r3 = 1;
        if (r2 == 0) goto L_0x001f;
    L_0x0017:
        r4 = r2.e();
        if (r4 == 0) goto L_0x001f;
    L_0x001d:
        r4 = r3;
        goto L_0x0020;
    L_0x001f:
        r4 = r0;
    L_0x0020:
        r5 = r7.n();
        if (r5 == 0) goto L_0x0031;
    L_0x0026:
        r7 = r7.expandActionView();
        r1 = r1 | r7;
        if (r1 == 0) goto L_0x006b;
    L_0x002d:
        r6.a(r3);
        return r1;
    L_0x0031:
        r5 = r7.hasSubMenu();
        if (r5 != 0) goto L_0x003f;
    L_0x0037:
        if (r4 == 0) goto L_0x003a;
    L_0x0039:
        goto L_0x003f;
    L_0x003a:
        r7 = r9 & 1;
        if (r7 != 0) goto L_0x006b;
    L_0x003e:
        goto L_0x002d;
    L_0x003f:
        r9 = r9 & 4;
        if (r9 != 0) goto L_0x0046;
    L_0x0043:
        r6.a(r0);
    L_0x0046:
        r9 = r7.hasSubMenu();
        if (r9 != 0) goto L_0x0058;
    L_0x004c:
        r9 = new android.support.v7.view.menu.u;
        r0 = r6.f();
        r9.<init>(r0, r6, r7);
        r7.a(r9);
    L_0x0058:
        r7 = r7.getSubMenu();
        r7 = (android.support.v7.view.menu.u) r7;
        if (r4 == 0) goto L_0x0063;
    L_0x0060:
        r2.a(r7);
    L_0x0063:
        r7 = r6.a(r7, r8);
        r1 = r1 | r7;
        if (r1 != 0) goto L_0x006b;
    L_0x006a:
        goto L_0x002d;
    L_0x006b:
        return r1;
    L_0x006c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.h.a(android.view.MenuItem, android.support.v7.view.menu.o, int):boolean");
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.e.getPackageManager();
        int i5 = 0;
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        while (i5 < size) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
            i5++;
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        j jVar = (j) a(i, i2, i3, charSequence);
        u uVar = new u(this.e, this, jVar);
        jVar.a(uVar);
        return uVar;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((j) this.j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void b(Bundle bundle) {
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(a());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((u) item.getSubMenu()).b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                MenuItem findItem = findItem(i2);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
        }
    }

    void b(j jVar) {
        this.o = true;
        b(true);
    }

    public void b(o oVar) {
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            o oVar2 = (o) weakReference.get();
            if (oVar2 == null || oVar2 == oVar) {
                this.x.remove(weakReference);
            }
        }
    }

    public void b(boolean z) {
        if (this.r) {
            this.s = true;
            if (z) {
                this.t = true;
            }
            return;
        }
        if (z) {
            this.l = true;
            this.o = true;
        }
        d(z);
    }

    public boolean b() {
        return this.z;
    }

    public int c(int i) {
        return a(i, 0);
    }

    public void c(boolean z) {
        this.A = z;
    }

    boolean c() {
        return this.g;
    }

    public boolean c(j jVar) {
        boolean z = false;
        if (this.x.isEmpty()) {
            return false;
        }
        h();
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            o oVar = (o) weakReference.get();
            if (oVar == null) {
                this.x.remove(weakReference);
            } else {
                z = oVar.a(this, jVar);
                if (z) {
                    break;
                }
            }
        }
        i();
        if (z) {
            this.y = jVar;
        }
        return z;
    }

    public void clear() {
        if (this.y != null) {
            d(this.y);
        }
        this.j.clear();
        b(true);
    }

    public void clearHeader() {
        this.b = null;
        this.a = null;
        this.c = null;
        b(false);
    }

    public void close() {
        a(true);
    }

    protected h d(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public boolean d() {
        return this.h;
    }

    public boolean d(j jVar) {
        boolean z = false;
        if (!this.x.isEmpty()) {
            if (this.y != jVar) {
                return false;
            }
            h();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.x.remove(weakReference);
                } else {
                    z = oVar.b(this, jVar);
                    if (z) {
                        break;
                    }
                }
            }
            i();
            if (z) {
                this.y = null;
            }
        }
        return z;
    }

    Resources e() {
        return this.f;
    }

    protected h e(int i) {
        a(0, null, i, null, null);
        return this;
    }

    public Context f() {
        return this.e;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.j.get(i2);
            if (jVar.getItemId() == i) {
                return jVar;
            }
            if (jVar.hasSubMenu()) {
                MenuItem findItem = jVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void g() {
        if (this.i != null) {
            this.i.a(this);
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.j.get(i);
    }

    public void h() {
        if (!this.r) {
            this.r = true;
            this.s = false;
            this.t = false;
        }
    }

    public boolean hasVisibleItems() {
        if (this.A) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((j) this.j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        this.r = false;
        if (this.s) {
            this.s = false;
            b(this.t);
        }
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public ArrayList<j> j() {
        if (!this.l) {
            return this.k;
        }
        this.k.clear();
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            j jVar = (j) this.j.get(i);
            if (jVar.isVisible()) {
                this.k.add(jVar);
            }
        }
        this.l = false;
        this.o = true;
        return this.k;
    }

    public void k() {
        ArrayList j = j();
        if (this.o) {
            Iterator it = this.x.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                o oVar = (o) weakReference.get();
                if (oVar == null) {
                    this.x.remove(weakReference);
                } else {
                    i |= oVar.b();
                }
            }
            if (i != 0) {
                this.m.clear();
                this.n.clear();
                int size = j.size();
                for (i = 0; i < size; i++) {
                    j jVar = (j) j.get(i);
                    (jVar.j() ? this.m : this.n).add(jVar);
                }
            } else {
                this.m.clear();
                this.n.clear();
                this.n.addAll(j());
            }
            this.o = false;
        }
    }

    public ArrayList<j> l() {
        k();
        return this.m;
    }

    public ArrayList<j> m() {
        k();
        return this.n;
    }

    public CharSequence n() {
        return this.a;
    }

    public Drawable o() {
        return this.b;
    }

    public View p() {
        return this.c;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean a2 = a != null ? a(a, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a2;
    }

    public h q() {
        return this;
    }

    boolean r() {
        return this.u;
    }

    public void removeGroup(int i) {
        int c = c(i);
        if (c >= 0) {
            int size = this.j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((j) this.j.get(c)).getGroupId() != i) {
                    b(true);
                } else {
                    a(c, false);
                    i2 = i3;
                }
            }
            b(true);
        }
    }

    public void removeItem(int i) {
        a(b(i), true);
    }

    public j s() {
        return this.y;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.j.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.a(z2);
                jVar.setCheckable(z);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        this.z = z;
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) this.j.get(i2);
            if (jVar.getGroupId() == i) {
                jVar.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.j.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            j jVar = (j) this.j.get(i2);
            if (jVar.getGroupId() == i && jVar.c(z)) {
                i3 = true;
            }
            i2++;
        }
        if (i3 != 0) {
            b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.g = z;
        b(false);
    }

    public int size() {
        return this.j.size();
    }
}
