package android.support.v4.h;

import android.os.Build.VERSION;
import android.support.a.a.b;
import android.view.ViewGroup;

public final class t {
    public static boolean a(ViewGroup viewGroup) {
        if (VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && r.k(viewGroup) == null) ? false : true;
    }
}
