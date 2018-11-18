package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.h.r;
import android.support.v7.a.a.j;
import android.support.v7.view.d;
import android.support.v7.widget.aa;
import android.support.v7.widget.bd;
import android.support.v7.widget.f;
import android.support.v7.widget.h;
import android.support.v7.widget.i;
import android.support.v7.widget.m;
import android.support.v7.widget.o;
import android.support.v7.widget.q;
import android.support.v7.widget.u;
import android.support.v7.widget.v;
import android.support.v7.widget.w;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater {
    private static final Class<?>[] a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] b = new int[]{16843375};
    private static final String[] c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> d = new android.support.v4.g.a();
    private final Object[] e = new Object[2];

    private static class a implements OnClickListener {
        private final View a;
        private final String b;
        private Method c;
        private Context d;

        public a(View view, String str) {
            this.a = view;
            this.b = str;
        }

        private void a(Context context, String str) {
            String str2;
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        Method method = context.getClass().getMethod(this.b, new Class[]{View.class});
                        if (method != null) {
                            this.c = method;
                            this.d = context;
                            return;
                        }
                    }
                } catch (NoSuchMethodException unused) {
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
            }
            int id = this.a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" with id '");
                stringBuilder.append(this.a.getContext().getResources().getResourceEntryName(id));
                stringBuilder.append("'");
                str2 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not find method ");
            stringBuilder2.append(this.b);
            stringBuilder2.append("(View) in a parent or ancestor Context for android:onClick ");
            stringBuilder2.append("attribute defined on view ");
            stringBuilder2.append(this.a.getClass());
            stringBuilder2.append(str2);
            throw new IllegalStateException(stringBuilder2.toString());
        }

        public void onClick(View view) {
            if (this.c == null) {
                a(this.a.getContext(), this.b);
            }
            try {
                this.c.invoke(this.d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    private static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(j.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof d) && ((d) context).a() == resourceId) ? context : new d(context, resourceId) : context;
    }

    private View a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) d.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(str);
                    str2 = stringBuilder.toString();
                } else {
                    str2 = str;
                }
                constructor = classLoader.loadClass(str2).asSubclass(View.class).getConstructor(a);
                d.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.e);
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && (VERSION.SDK_INT < 15 || r.y(view))) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void a(View view, String str) {
        if (view == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" asked to inflate view for <");
            stringBuilder.append(str);
            stringBuilder.append(">, but returned null");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private View b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.e[0] = context;
            this.e[1] = attributeSet;
            if (-1 == str.indexOf(46)) {
                for (String a : c) {
                    View a2 = a(context, str, a);
                    if (a2 != null) {
                        this.e[0] = null;
                        this.e[1] = null;
                        return a2;
                    }
                }
                this.e[0] = null;
                this.e[1] = null;
                return null;
            }
            View a3 = a(context, str, null);
            this.e[0] = null;
            this.e[1] = null;
            return a3;
        } catch (Exception unused) {
            this.e[0] = null;
            this.e[1] = null;
            return null;
        } catch (Throwable th) {
            this.e[0] = null;
            this.e[1] = null;
            throw th;
        }
    }

    protected aa a(Context context, AttributeSet attributeSet) {
        return new aa(context, attributeSet);
    }

    protected View a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        View a;
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = bd.a(context2);
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                a = a(context2, attributeSet);
                break;
            case 1:
                a = b(context2, attributeSet);
                break;
            case 2:
                a = c(context2, attributeSet);
                break;
            case 3:
                a = d(context2, attributeSet);
                break;
            case 4:
                a = e(context2, attributeSet);
                break;
            case 5:
                a = f(context2, attributeSet);
                break;
            case 6:
                a = g(context2, attributeSet);
                break;
            case 7:
                a = h(context2, attributeSet);
                break;
            case 8:
                a = i(context2, attributeSet);
                break;
            case 9:
                a = j(context2, attributeSet);
                break;
            case 10:
                a = k(context2, attributeSet);
                break;
            case 11:
                a = l(context2, attributeSet);
                break;
            case 12:
                a = m(context2, attributeSet);
                break;
            default:
                a = a(context2, str, attributeSet);
                break;
        }
        a(a, str);
        if (a == null && context != context2) {
            a = b(context2, str, attributeSet);
        }
        if (a != null) {
            a(a, attributeSet);
        }
        return a;
    }

    protected q b(Context context, AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    protected h c(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    protected m d(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    protected y e(Context context, AttributeSet attributeSet) {
        return new y(context, attributeSet);
    }

    protected o f(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected i g(Context context, AttributeSet attributeSet) {
        return new i(context, attributeSet);
    }

    protected u h(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected android.support.v7.widget.j i(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.j(context, attributeSet);
    }

    protected f j(Context context, AttributeSet attributeSet) {
        return new f(context, attributeSet);
    }

    protected android.support.v7.widget.r k(Context context, AttributeSet attributeSet) {
        return new android.support.v7.widget.r(context, attributeSet);
    }

    protected v l(Context context, AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    protected w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }
}
