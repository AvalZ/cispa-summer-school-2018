package android.support.v4.h;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.h.a.c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class b {
    private static final AccessibilityDelegate a = new AccessibilityDelegate();
    private final AccessibilityDelegate b = new a(this);

    private static final class a extends AccessibilityDelegate {
        private final b a;

        a(b bVar) {
            this.a = bVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.d(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            c a = this.a.a(view);
            return a != null ? (AccessibilityNodeProvider) a.a() : null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.a(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.a.a(view, android.support.v4.h.a.b.a(accessibilityNodeInfo));
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.b(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.a.a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }
    }

    public c a(View view) {
        if (VERSION.SDK_INT >= 16) {
            AccessibilityNodeProvider accessibilityNodeProvider = a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new c(accessibilityNodeProvider);
            }
        }
        return null;
    }

    AccessibilityDelegate a() {
        return this.b;
    }

    public void a(View view, int i) {
        a.sendAccessibilityEvent(view, i);
    }

    public void a(View view, android.support.v4.h.a.b bVar) {
        a.onInitializeAccessibilityNodeInfo(view, bVar.a());
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean a(View view, int i, Bundle bundle) {
        return VERSION.SDK_INT >= 16 ? a.performAccessibilityAction(view, i, bundle) : false;
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean d(View view, AccessibilityEvent accessibilityEvent) {
        return a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
}
