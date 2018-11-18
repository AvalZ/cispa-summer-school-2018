package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

abstract class m implements o, s, OnItemClickListener {
    private Rect a;

    m() {
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int i2 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        int i3 = 0;
        int i4 = i3;
        View view = null;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i2, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= i) {
                return i;
            }
            if (itemViewType > i4) {
                i4 = itemViewType;
            }
            i2++;
        }
        return i4;
    }

    protected static g a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (g) listAdapter;
    }

    protected static boolean b(h hVar) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i);

    public void a(Context context, h hVar) {
    }

    public void a(Rect rect) {
        this.a = rect;
    }

    public abstract void a(h hVar);

    public abstract void a(View view);

    public abstract void a(OnDismissListener onDismissListener);

    public abstract void a(boolean z);

    public boolean a(h hVar, j jVar) {
        return false;
    }

    public abstract void b(int i);

    public boolean b(h hVar, j jVar) {
        return false;
    }

    public abstract void c(int i);

    public abstract void c(boolean z);

    protected boolean f() {
        return true;
    }

    public Rect g() {
        return this.a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        a(listAdapter).a.a((MenuItem) listAdapter.getItem(i), (o) this, f() ? 0 : 4);
    }
}
