package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.c;
import android.arch.lifecycle.c.b;
import android.arch.lifecycle.e;
import android.arch.lifecycle.f;
import android.arch.lifecycle.m;
import android.os.Bundle;
import android.support.v4.g.l;
import android.support.v4.h.e.a;
import android.view.KeyEvent;
import android.view.View;

public class y extends Activity implements e, a {
    private l<Class<? extends Object>, Object> a = new l();
    private f b = new f(this);

    public c a() {
        return this.b;
    }

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        return (decorView == null || !android.support.v4.h.e.a(decorView, keyEvent)) ? android.support.v4.h.e.a(this, decorView, this, keyEvent) : true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        return (decorView == null || !android.support.v4.h.e.a(decorView, keyEvent)) ? super.dispatchKeyShortcutEvent(keyEvent) : true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m.a((Activity) this);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.b.a(b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
