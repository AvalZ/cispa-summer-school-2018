package android.support.v4.h.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

public class b {
    public int a = -1;
    private final AccessibilityNodeInfo b;

    public static class a {
        final Object a;

        a(Object obj) {
            this.a = obj;
        }

        public static a a(int i, int i2, boolean z, int i3) {
            return VERSION.SDK_INT >= 21 ? new a(CollectionInfo.obtain(i, i2, z, i3)) : VERSION.SDK_INT >= 19 ? new a(CollectionInfo.obtain(i, i2, z)) : new a(null);
        }
    }

    public static class b {
        final Object a;

        b(Object obj) {
            this.a = obj;
        }

        public static b a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return VERSION.SDK_INT >= 21 ? new b(CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : VERSION.SDK_INT >= 19 ? new b(CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new b(null);
        }
    }

    private b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.b = accessibilityNodeInfo;
    }

    public static b a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new b(accessibilityNodeInfo);
    }

    private static String b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public AccessibilityNodeInfo a() {
        return this.b;
    }

    public void a(int i) {
        this.b.addAction(i);
    }

    public void a(Rect rect) {
        this.b.getBoundsInParent(rect);
    }

    public void a(View view) {
        if (VERSION.SDK_INT >= 17) {
            this.b.setLabelFor(view);
        }
    }

    public void a(CharSequence charSequence) {
        this.b.setClassName(charSequence);
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setCollectionInfo(obj == null ? null : (CollectionInfo) ((a) obj).a);
        }
    }

    public void a(boolean z) {
        this.b.setCheckable(z);
    }

    public int b() {
        return this.b.getActions();
    }

    public void b(Rect rect) {
        this.b.getBoundsInScreen(rect);
    }

    public void b(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setCollectionItemInfo(obj == null ? null : (CollectionItemInfo) ((b) obj).a);
        }
    }

    public void b(boolean z) {
        this.b.setChecked(z);
    }

    public void c(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 21) {
            this.b.setError(charSequence);
        }
    }

    public void c(boolean z) {
        this.b.setScrollable(z);
    }

    public boolean c() {
        return this.b.isCheckable();
    }

    public void d(boolean z) {
        if (VERSION.SDK_INT >= 19) {
            this.b.setContentInvalid(z);
        }
    }

    public boolean d() {
        return this.b.isChecked();
    }

    public boolean e() {
        return this.b.isFocusable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == null) {
            if (bVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(bVar.b)) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.b.isFocused();
    }

    public boolean g() {
        return this.b.isSelected();
    }

    public boolean h() {
        return this.b.isClickable();
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean i() {
        return this.b.isLongClickable();
    }

    public boolean j() {
        return this.b.isEnabled();
    }

    public boolean k() {
        return this.b.isPassword();
    }

    public boolean l() {
        return this.b.isScrollable();
    }

    public CharSequence m() {
        return this.b.getPackageName();
    }

    public CharSequence n() {
        return this.b.getClassName();
    }

    public CharSequence o() {
        return this.b.getText();
    }

    public CharSequence p() {
        return this.b.getContentDescription();
    }

    public String q() {
        return VERSION.SDK_INT >= 18 ? this.b.getViewIdResourceName() : null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInParent: ");
        stringBuilder2.append(rect);
        stringBuilder.append(stringBuilder2.toString());
        b(rect);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("; boundsInScreen: ");
        stringBuilder2.append(rect);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("; packageName: ");
        stringBuilder.append(m());
        stringBuilder.append("; className: ");
        stringBuilder.append(n());
        stringBuilder.append("; text: ");
        stringBuilder.append(o());
        stringBuilder.append("; contentDescription: ");
        stringBuilder.append(p());
        stringBuilder.append("; viewId: ");
        stringBuilder.append(q());
        stringBuilder.append("; checkable: ");
        stringBuilder.append(c());
        stringBuilder.append("; checked: ");
        stringBuilder.append(d());
        stringBuilder.append("; focusable: ");
        stringBuilder.append(e());
        stringBuilder.append("; focused: ");
        stringBuilder.append(f());
        stringBuilder.append("; selected: ");
        stringBuilder.append(g());
        stringBuilder.append("; clickable: ");
        stringBuilder.append(h());
        stringBuilder.append("; longClickable: ");
        stringBuilder.append(i());
        stringBuilder.append("; enabled: ");
        stringBuilder.append(j());
        stringBuilder.append("; password: ");
        stringBuilder.append(k());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("; scrollable: ");
        stringBuilder3.append(l());
        stringBuilder.append(stringBuilder3.toString());
        stringBuilder.append("; [");
        int b = b();
        while (b != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b);
            b &= ~numberOfTrailingZeros;
            stringBuilder.append(b(numberOfTrailingZeros));
            if (b != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
