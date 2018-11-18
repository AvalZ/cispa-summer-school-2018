package android.support.v4.h;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class u {
    public static void a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof n) {
            ((n) viewParent).c(view, i);
            return;
        }
        if (i == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append(viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onStopNestedScroll");
                    Log.e("ViewParentCompat", stringBuilder.toString(), e);
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof n) {
            ((n) viewParent).a(view, i, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append(viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onNestedScroll");
                    Log.e("ViewParentCompat", stringBuilder.toString(), e);
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof n) {
            ((n) viewParent).a(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append(viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onNestedPreScroll");
                    Log.e("ViewParentCompat", stringBuilder.toString(), e);
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ViewParent ");
                stringBuilder.append(viewParent);
                stringBuilder.append(" does not implement interface ");
                stringBuilder.append("method onNestedPreFling");
                Log.e("ViewParentCompat", stringBuilder.toString(), e);
            }
        } else {
            if (viewParent instanceof m) {
                return ((m) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ViewParent ");
                stringBuilder.append(viewParent);
                stringBuilder.append(" does not implement interface ");
                stringBuilder.append("method onNestedFling");
                Log.e("ViewParentCompat", stringBuilder.toString(), e);
            }
        } else {
            if (viewParent instanceof m) {
                return ((m) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof n) {
            return ((n) viewParent).a(view, view2, i, i2);
        }
        if (i2 == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append(viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onStartNestedScroll");
                    Log.e("ViewParentCompat", stringBuilder.toString(), e);
                }
            } else if (viewParent instanceof m) {
                return ((m) viewParent).onStartNestedScroll(view, view2, i);
            }
        }
        return false;
    }

    public static void b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof n) {
            ((n) viewParent).b(view, view2, i, i2);
            return;
        }
        if (i2 == 0) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i);
                } catch (Throwable e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("ViewParent ");
                    stringBuilder.append(viewParent);
                    stringBuilder.append(" does not implement interface ");
                    stringBuilder.append("method onNestedScrollAccepted");
                    Log.e("ViewParentCompat", stringBuilder.toString(), e);
                }
            } else if (viewParent instanceof m) {
                ((m) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }
}
