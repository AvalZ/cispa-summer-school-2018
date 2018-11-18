package android.support.v4.h;

import android.view.View;
import android.view.ViewParent;

public class l {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public l(View view) {
        this.c = view;
    }

    private void a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.a = viewParent;
                return;
            case 1:
                this.b = viewParent;
                return;
            default:
                return;
        }
    }

    private ViewParent d(int i) {
        switch (i) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            default:
                return null;
        }
    }

    public void a(boolean z) {
        if (this.d) {
            r.t(this.c);
        }
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(float f, float f2) {
        if (a()) {
            ViewParent d = d(0);
            if (d != null) {
                return u.a(d, this.c, f, f2);
            }
        }
        return false;
    }

    public boolean a(float f, float f2, boolean z) {
        if (a()) {
            ViewParent d = d(0);
            if (d != null) {
                return u.a(d, this.c, f, f2, z);
            }
        }
        return false;
    }

    public boolean a(int i) {
        return d(i) != null;
    }

    public boolean a(int i, int i2) {
        if (a(i2)) {
            return true;
        }
        if (a()) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                if (u.a(parent, view, this.c, i, i2)) {
                    a(i2, parent);
                    u.b(parent, view, this.c, i, i2);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return a(i, i2, i3, i4, iArr, 0);
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        int[] iArr2 = iArr;
        if (a()) {
            int i6 = i5;
            ViewParent d = d(i6);
            if (d == null) {
                return false;
            }
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                int i7;
                int i8;
                if (iArr2 != null) {
                    this.c.getLocationInWindow(iArr2);
                    i7 = iArr2[0];
                    i8 = iArr2[1];
                } else {
                    i7 = 0;
                    i8 = i7;
                }
                u.a(d, this.c, i, i2, i3, i4, i6);
                if (iArr2 != null) {
                    this.c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i7;
                    iArr2[1] = iArr2[1] - i8;
                }
                return true;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2) {
        return a(i, i2, iArr, iArr2, 0);
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (a()) {
            ViewParent d = d(i3);
            if (d == null) {
                return false;
            }
            boolean z = true;
            if (i != 0 || i2 != 0) {
                int i4;
                int i5;
                if (iArr2 != null) {
                    this.c.getLocationInWindow(iArr2);
                    i4 = iArr2[0];
                    i5 = iArr2[1];
                } else {
                    i4 = 0;
                    i5 = i4;
                }
                if (iArr == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    iArr = this.e;
                }
                iArr[0] = 0;
                iArr[1] = 0;
                u.a(d, this.c, i, i2, iArr, i3);
                if (iArr2 != null) {
                    this.c.getLocationInWindow(iArr2);
                    iArr2[0] = iArr2[0] - i4;
                    iArr2[1] = iArr2[1] - i5;
                }
                if (iArr[0] == 0) {
                    if (iArr[1] != 0) {
                        return true;
                    }
                    z = false;
                }
                return z;
            } else if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                return false;
            }
        }
        return false;
    }

    public boolean b() {
        return a(0);
    }

    public boolean b(int i) {
        return a(i, 0);
    }

    public void c() {
        c(0);
    }

    public void c(int i) {
        ViewParent d = d(i);
        if (d != null) {
            u.a(d, this.c, i);
            a(i, null);
        }
    }
}
