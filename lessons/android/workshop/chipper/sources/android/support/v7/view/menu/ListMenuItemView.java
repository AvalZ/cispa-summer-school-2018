package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.h.r;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.bg;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements a, SelectionBoundsAdjuster {
    private j a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        bg a = bg.a(getContext(), attributeSet, j.MenuView, i, 0);
        this.j = a.a(j.MenuView_android_itemBackground);
        this.k = a.g(j.MenuView_android_itemTextAppearance, -1);
        this.m = a.a(j.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a.a(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, android.support.v7.a.a.a.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i) {
        if (this.i != null) {
            this.i.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    private void b() {
        this.b = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, this, false);
        a(this.b, 0);
    }

    private void c() {
        this.c = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, this, false);
        a(this.c);
    }

    private void d() {
        this.e = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, this, false);
        a(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.g != null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void a(j jVar, int i) {
        this.a = jVar;
        this.p = i;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a((a) this));
        setCheckable(jVar.isCheckable());
        a(jVar.f(), jVar.d());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    public void a(boolean z, char c) {
        int i = (z && this.a.f()) ? 0 : 8;
        if (i == 0) {
            this.f.setText(this.a.e());
        }
        if (this.f.getVisibility() != i) {
            this.f.setVisibility(i);
        }
    }

    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.h != null && this.h.getVisibility() == 0) {
            LayoutParams layoutParams = (LayoutParams) this.h.getLayoutParams();
            rect.top += (this.h.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
        }
    }

    public j getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        r.a((View) this, this.j);
        this.d = (TextView) findViewById(f.title);
        if (this.k != -1) {
            this.d.setTextAppearance(this.l, this.k);
        }
        this.f = (TextView) findViewById(f.shortcut);
        this.g = (ImageView) findViewById(f.submenuarrow);
        if (this.g != null) {
            this.g.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(f.group_divider);
        this.i = (LinearLayout) findViewById(f.content);
    }

    protected void onMeasure(int i, int i2) {
        if (this.b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.c != null || this.e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.a.g()) {
                if (this.c == null) {
                    c();
                }
                compoundButton = this.c;
                compoundButton2 = this.e;
            } else {
                if (this.e == null) {
                    d();
                }
                compoundButton = this.e;
                compoundButton2 = this.c;
            }
            if (z) {
                compoundButton.setChecked(this.a.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (!(compoundButton2 == null || compoundButton2.getVisibility() == 8)) {
                    compoundButton2.setVisibility(8);
                    return;
                }
            }
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.a.g()) {
            if (this.c == null) {
                c();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                d();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.m = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        if (this.h != null) {
            ImageView imageView = this.h;
            int i = (this.o || !z) ? 8 : 0;
            imageView.setVisibility(i);
        }
    }

    public void setIcon(Drawable drawable) {
        int i = (this.a.i() || this.r) ? 1 : 0;
        if (i == 0 && !this.m) {
            return;
        }
        if (this.b != null || drawable != null || this.m) {
            if (this.b == null) {
                b();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.b.getVisibility() != 0) {
                    this.b.setVisibility(0);
                }
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }
}
