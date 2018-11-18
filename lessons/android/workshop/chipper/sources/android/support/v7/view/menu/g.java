package android.support.v7.view.menu;

import android.support.v7.view.menu.p.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public class g extends BaseAdapter {
    h a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = hVar;
        this.f = i;
        b();
    }

    public h a() {
        return this.a;
    }

    /* renamed from: a */
    public j getItem(int i) {
        ArrayList m = this.d ? this.a.m() : this.a.j();
        if (this.b >= 0 && i >= this.b) {
            i++;
        }
        return (j) m.get(i);
    }

    public void a(boolean z) {
        this.c = z;
    }

    void b() {
        j s = this.a.s();
        if (s != null) {
            ArrayList m = this.a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                if (((j) m.get(i)) == s) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public int getCount() {
        ArrayList m = this.d ? this.a.m() : this.a.j();
        return this.b < 0 ? m.size() : m.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        boolean z = this.a.b() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId);
        listMenuItemView.setGroupDividerEnabled(z);
        a aVar = (a) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
