package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

public class bl extends Resources {
    private static boolean a = false;
    private final WeakReference<Context> b;

    public bl(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.b = new WeakReference(context);
    }

    public static boolean a() {
        return b() && VERSION.SDK_INT <= 20;
    }

    public static boolean b() {
        return a;
    }

    final Drawable a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.b.get();
        return context != null ? l.a().a(context, this, i) : super.getDrawable(i);
    }
}
