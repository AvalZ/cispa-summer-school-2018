package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.support.v4.h.c;
import android.support.v4.h.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.k;
import android.support.v7.widget.ag;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class g extends MenuInflater {
    static final Class<?>[] a = new Class[]{Context.class};
    static final Class<?>[] b = a;
    final Object[] c;
    final Object[] d = this.c;
    Context e;
    private Object f;

    private static class a implements OnMenuItemClickListener {
        private static final Class<?>[] a = new Class[]{MenuItem.class};
        private Object b;
        private Method c;

        public a(Object obj, String str) {
            this.b = obj;
            Class cls = obj.getClass();
            try {
                this.c = cls.getMethod(str, a);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(str);
                stringBuilder.append(" in class ");
                stringBuilder.append(cls.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.c.invoke(this.b, new Object[]{menuItem})).booleanValue();
                }
                this.c.invoke(this.b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private Mode F = null;
        c a;
        private Menu c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private int l;
        private CharSequence m;
        private CharSequence n;
        private int o;
        private char p;
        private int q;
        private char r;
        private int s;
        private int t;
        private boolean u;
        private boolean v;
        private boolean w;
        private int x;
        private int y;
        private String z;

        public b(Menu menu) {
            this.c = menu;
            a();
        }

        private char a(String str) {
            return str == null ? 0 : str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = g.this.e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot instantiate class: ");
                stringBuilder.append(str);
                Log.w("SupportMenuInflater", stringBuilder.toString(), e);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.u).setVisible(this.v).setEnabled(this.w).setCheckable(this.t >= 1).setTitleCondensed(this.n).setIcon(this.o);
            if (this.x >= 0) {
                menuItem.setShowAsAction(this.x);
            }
            if (this.B != null) {
                if (g.this.e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
            }
            boolean z2 = menuItem instanceof j;
            if (z2) {
                j jVar = (j) menuItem;
            }
            if (this.t >= 2) {
                if (z2) {
                    ((j) menuItem).a(true);
                } else if (menuItem instanceof k) {
                    ((k) menuItem).a(true);
                }
            }
            if (this.z != null) {
                menuItem.setActionView((View) a(this.z, g.a, g.this.c));
                z = true;
            }
            if (this.y > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.y);
                }
            }
            if (this.a != null) {
                h.a(menuItem, this.a);
            }
            h.a(menuItem, this.C);
            h.b(menuItem, this.D);
            h.b(menuItem, this.p, this.q);
            h.a(menuItem, this.r, this.s);
            if (this.F != null) {
                h.a(menuItem, this.F);
            }
            if (this.E != null) {
                h.a(menuItem, this.E);
            }
        }

        public void a() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = true;
            this.i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, android.support.v7.a.a.j.MenuGroup);
            this.d = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuGroup_android_id, 0);
            this.e = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_menuCategory, 0);
            this.f = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_orderInCategory, 0);
            this.g = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuGroup_android_checkableBehavior, 0);
            this.h = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuGroup_android_visible, true);
            this.i = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b() {
            this.j = true;
            a(this.c.add(this.d, this.k, this.l, this.m));
        }

        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.e.obtainStyledAttributes(attributeSet, android.support.v7.a.a.j.MenuItem);
            this.k = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_android_id, 0);
            this.l = (obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_android_menuCategory, this.e) & -65536) | (obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_android_orderInCategory, this.f) & 65535);
            this.m = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_android_title);
            this.n = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_android_titleCondensed);
            this.o = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_android_icon, 0);
            this.p = a(obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_alphabeticShortcut));
            this.q = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_alphabeticModifiers, 4096);
            this.r = a(obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_numericShortcut));
            this.s = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_numericModifiers, 4096);
            this.t = obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_android_checkable) ? obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_checkable, false) : this.g;
            this.u = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_checked, false);
            this.v = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_visible, this.h);
            this.w = obtainStyledAttributes.getBoolean(android.support.v7.a.a.j.MenuItem_android_enabled, this.i);
            this.x = obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_showAsAction, -1);
            this.B = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_android_onClick);
            this.y = obtainStyledAttributes.getResourceId(android.support.v7.a.a.j.MenuItem_actionLayout, 0);
            this.z = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_actionViewClass);
            this.A = obtainStyledAttributes.getString(android.support.v7.a.a.j.MenuItem_actionProviderClass);
            boolean z = this.A != null;
            if (z && this.y == 0 && this.z == null) {
                this.a = (c) a(this.A, g.b, g.this.d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.a = null;
            }
            this.C = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_contentDescription);
            this.D = obtainStyledAttributes.getText(android.support.v7.a.a.j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_iconTintMode)) {
                this.F = ag.a(obtainStyledAttributes.getInt(android.support.v7.a.a.j.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.j.MenuItem_iconTint)) {
                this.E = obtainStyledAttributes.getColorStateList(android.support.v7.a.a.j.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            obtainStyledAttributes.recycle();
            this.j = false;
        }

        public SubMenu c() {
            this.j = true;
            SubMenu addSubMenu = this.c.addSubMenu(this.d, this.k, this.l, this.m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.j;
        }
    }

    public g(Context context) {
        super(context);
        this.e = context;
        this.c = new Object[]{context};
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            eventType = xmlPullParser.next();
            if (eventType == 1) {
                break;
            }
        }
        String name = xmlPullParser.getName();
        if (name.equals("menu")) {
            eventType = xmlPullParser.next();
            int i = eventType;
            Object obj = null;
            Object obj2 = null;
            Object obj3 = obj2;
            while (obj2 == null) {
                String name2;
                switch (i) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (obj3 == null) {
                            name2 = xmlPullParser.getName();
                            if (!name2.equals("group")) {
                                if (!name2.equals("item")) {
                                    if (!name2.equals("menu")) {
                                        obj3 = 1;
                                        obj = name2;
                                        break;
                                    }
                                    a(xmlPullParser, attributeSet, bVar.c());
                                    break;
                                }
                                bVar.b(attributeSet);
                                break;
                            }
                            bVar.a(attributeSet);
                            break;
                        }
                        break;
                    case 3:
                        name2 = xmlPullParser.getName();
                        if (obj3 == null || !name2.equals(obj)) {
                            if (!name2.equals("group")) {
                                if (!name2.equals("item")) {
                                    if (!name2.equals("menu")) {
                                        break;
                                    }
                                    obj2 = 1;
                                    break;
                                } else if (!bVar.d()) {
                                    if (bVar.a != null && bVar.a.e()) {
                                        bVar.c();
                                        break;
                                    } else {
                                        bVar.b();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            bVar.a();
                            break;
                        }
                        obj = null;
                        obj3 = null;
                        break;
                    default:
                        break;
                }
                i = xmlPullParser.next();
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expecting menu, got ");
        stringBuilder.append(name);
        throw new RuntimeException(stringBuilder.toString());
    }

    Object a() {
        if (this.f == null) {
            this.f = a(this.e);
        }
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003f  */
    public void inflate(int r3, android.view.Menu r4) {
        /*
        r2 = this;
        r0 = r4 instanceof android.support.v4.b.a.a;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        super.inflate(r3, r4);
        return;
    L_0x0008:
        r0 = 0;
        r1 = r2.e;	 Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
        r1 = r1.getResources();	 Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
        r3 = r1.getLayout(r3);	 Catch:{ XmlPullParserException -> 0x0034, IOException -> 0x002b }
        r0 = android.util.Xml.asAttributeSet(r3);	 Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
        r2.a(r3, r0, r4);	 Catch:{ XmlPullParserException -> 0x0026, IOException -> 0x0023, all -> 0x0020 }
        if (r3 == 0) goto L_0x001f;
    L_0x001c:
        r3.close();
    L_0x001f:
        return;
    L_0x0020:
        r2 = move-exception;
        r0 = r3;
        goto L_0x003d;
    L_0x0023:
        r2 = move-exception;
        r0 = r3;
        goto L_0x002c;
    L_0x0026:
        r2 = move-exception;
        r0 = r3;
        goto L_0x0035;
    L_0x0029:
        r2 = move-exception;
        goto L_0x003d;
    L_0x002b:
        r2 = move-exception;
    L_0x002c:
        r3 = new android.view.InflateException;	 Catch:{ all -> 0x0029 }
        r4 = "Error inflating menu XML";
        r3.<init>(r4, r2);	 Catch:{ all -> 0x0029 }
        throw r3;	 Catch:{ all -> 0x0029 }
    L_0x0034:
        r2 = move-exception;
    L_0x0035:
        r3 = new android.view.InflateException;	 Catch:{ all -> 0x0029 }
        r4 = "Error inflating menu XML";
        r3.<init>(r4, r2);	 Catch:{ all -> 0x0029 }
        throw r3;	 Catch:{ all -> 0x0029 }
    L_0x003d:
        if (r0 == 0) goto L_0x0042;
    L_0x003f:
        r0.close();
    L_0x0042:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.inflate(int, android.view.Menu):void");
    }
}
