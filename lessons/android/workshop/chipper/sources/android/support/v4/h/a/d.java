package android.support.v4.h.a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityRecord;

public class d {
    private final AccessibilityRecord a;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a == null) {
            if (dVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(dVar.a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }
}
