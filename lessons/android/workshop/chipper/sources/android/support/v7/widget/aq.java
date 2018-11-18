package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.h;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

public class aq extends ao implements ap {
    private static Method a;
    private ap b;

    public static class a extends ah {
        final int b;
        final int c;
        private ap d;
        private MenuItem e;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.b = 22;
                this.c = 21;
                return;
            }
            this.b = 21;
            this.c = 22;
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.d != null) {
                int headersCount;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                }
                g gVar = (g) adapter;
                MenuItem menuItem = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        pointToPosition -= headersCount;
                        if (pointToPosition >= 0 && pointToPosition < gVar.getCount()) {
                            menuItem = gVar.getItem(pointToPosition);
                        }
                    }
                }
                MenuItem menuItem2 = this.e;
                if (menuItem2 != menuItem) {
                    h a = gVar.a();
                    if (menuItem2 != null) {
                        this.d.a(a, menuItem2);
                    }
                    this.e = menuItem;
                    if (menuItem != null) {
                        this.d.b(a, menuItem);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.c) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((g) getAdapter()).a().a(false);
                return true;
            }
        }

        public void setHoverListener(ap apVar) {
            this.d = apVar;
        }
    }

    static {
        try {
            a = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public aq(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    ah a(Context context, boolean z) {
        ah aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a(h hVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.a(hVar, menuItem);
        }
    }

    public void a(ap apVar) {
        this.b = apVar;
    }

    public void a(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setEnterTransition((Transition) obj);
        }
    }

    public void b(h hVar, MenuItem menuItem) {
        if (this.b != null) {
            this.b.b(hVar, menuItem);
        }
    }

    public void b(Object obj) {
        if (VERSION.SDK_INT >= 23) {
            this.g.setExitTransition((Transition) obj);
        }
    }

    public void c(boolean z) {
        if (a != null) {
            try {
                a.invoke(this.g, new Object[]{Boolean.valueOf(z)});
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
