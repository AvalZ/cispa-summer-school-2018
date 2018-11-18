package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.h.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class au extends b {
    final at a;
    final b b = new a(this);

    public static class a extends b {
        final au a;

        public a(au auVar) {
            this.a = auVar;
        }

        public void a(View view, android.support.v4.h.a.b bVar) {
            super.a(view, bVar);
            if (!this.a.b() && this.a.a.getLayoutManager() != null) {
                this.a.a.getLayoutManager().a(view, bVar);
            }
        }

        public boolean a(View view, int i, Bundle bundle) {
            return super.a(view, i, bundle) ? true : (this.a.b() || this.a.a.getLayoutManager() == null) ? false : this.a.a.getLayoutManager().a(view, i, bundle);
        }
    }

    public au(at atVar) {
        this.a = atVar;
    }

    public void a(View view, android.support.v4.h.a.b bVar) {
        super.a(view, bVar);
        bVar.a(at.class.getName());
        if (!b() && this.a.getLayoutManager() != null) {
            this.a.getLayoutManager().a(bVar);
        }
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        super.a(view, accessibilityEvent);
        accessibilityEvent.setClassName(at.class.getName());
        if ((view instanceof at) && !b()) {
            at atVar = (at) view;
            if (atVar.getLayoutManager() != null) {
                atVar.getLayoutManager().a(accessibilityEvent);
            }
        }
    }

    public boolean a(View view, int i, Bundle bundle) {
        return super.a(view, i, bundle) ? true : (b() || this.a.getLayoutManager() == null) ? false : this.a.getLayoutManager().a(i, bundle);
    }

    boolean b() {
        return this.a.v();
    }

    public b c() {
        return this.b;
    }
}
