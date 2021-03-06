package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.a.a.g;
import android.support.v7.app.b;
import android.support.v7.view.menu.o.a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class i implements OnClickListener, OnDismissListener, OnKeyListener, a {
    f a;
    private h b;
    private b c;
    private a d;

    public i(h hVar) {
        this.b = hVar;
    }

    public void a() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void a(IBinder iBinder) {
        h hVar = this.b;
        b.a aVar = new b.a(hVar.f());
        this.a = new f(aVar.a(), g.abc_list_menu_item_layout);
        this.a.a((a) this);
        this.b.a(this.a);
        aVar.a(this.a.a(), this);
        View p = hVar.p();
        if (p != null) {
            aVar.a(p);
        } else {
            aVar.a(hVar.o()).a(hVar.n());
        }
        aVar.a((OnKeyListener) this);
        this.c = aVar.b();
        this.c.setOnDismissListener(this);
        LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.c.show();
    }

    public void a(h hVar, boolean z) {
        if (z || hVar == this.b) {
            a();
        }
        if (this.d != null) {
            this.d.a(hVar, z);
        }
    }

    public boolean a(h hVar) {
        return this.d != null ? this.d.a(hVar) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.b.a((j) this.a.a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.a.a(this.b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.c.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.c.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.b.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.b.performShortcut(i, keyEvent, 0);
    }
}
