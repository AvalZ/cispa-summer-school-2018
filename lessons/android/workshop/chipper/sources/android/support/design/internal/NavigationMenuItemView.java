package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.v4.h.b;
import android.support.v4.h.r;
import android.support.v4.widget.n;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p.a;
import android.support.v7.widget.an;
import android.support.v7.widget.bi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView extends a implements a {
    private static final int[] d = new int[]{16842912};
    boolean c;
    private final int e;
    private boolean f;
    private final CheckedTextView g;
    private FrameLayout h;
    private j i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final b m;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new b() {
            public void a(View view, android.support.v4.h.a.b bVar) {
                super.a(view, bVar);
                bVar.a(NavigationMenuItemView.this.c);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(h.design_navigation_menu_item, this, true);
        this.e = context.getResources().getDimensionPixelSize(d.design_navigation_icon_size);
        this.g = (CheckedTextView) findViewById(f.design_menu_item_text);
        this.g.setDuplicateParentStateEnabled(true);
        r.a(this.g, this.m);
    }

    private boolean b() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    private void c() {
        LayoutParams layoutParams;
        int i;
        if (b()) {
            this.g.setVisibility(8);
            if (this.h != null) {
                layoutParams = (an.a) this.h.getLayoutParams();
                i = -1;
            }
            return;
        }
        this.g.setVisibility(0);
        if (this.h != null) {
            an.a layoutParams2 = (an.a) this.h.getLayoutParams();
            i = -2;
        }
        return;
        layoutParams2.width = i;
        this.h.setLayoutParams(layoutParams2);
    }

    private StateListDrawable d() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(android.support.v7.a.a.a.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout) ((ViewStub) findViewById(f.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    public void a(j jVar, int i) {
        this.i = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            r.a((View) this, d());
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        bi.a(this, jVar.getTooltipText());
        c();
    }

    public boolean a() {
        return false;
    }

    public j getItemData() {
        return this.i;
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.i != null && this.i.isCheckable() && this.i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, d);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.c != z) {
            this.c = z;
            this.m.a(this.g, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.g.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.k) {
                ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = android.support.v4.graphics.drawable.a.g(drawable).mutate();
                android.support.v4.graphics.drawable.a.a(drawable, this.j);
            }
            drawable.setBounds(0, 0, this.e, this.e);
        } else if (this.f) {
            if (this.l == null) {
                this.l = android.support.v4.a.a.f.a(getResources(), e.navigation_empty_icon, getContext().getTheme());
                if (this.l != null) {
                    this.l.setBounds(0, 0, this.e, this.e);
                }
            }
            drawable = this.l;
        }
        n.a(this.g, drawable, null, null, null);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.k = this.j != null;
        if (this.i != null) {
            setIcon(this.i.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f = z;
    }

    public void setTextAppearance(int i) {
        n.a(this.g, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.g.setText(charSequence);
    }
}
