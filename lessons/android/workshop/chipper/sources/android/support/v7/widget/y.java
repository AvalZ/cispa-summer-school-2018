package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.h.q;
import android.support.v4.h.r;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class y extends Spinner implements q {
    private static final int[] d = new int[]{16843505};
    b a;
    int b;
    final Rect c;
    private final g e;
    private final Context f;
    private ak g;
    private SpinnerAdapter h;
    private final boolean i;

    private static class a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        public a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof bc) {
                    bc bcVar = (bc) spinnerAdapter;
                    if (bcVar.a() == null) {
                        bcVar.a(theme);
                    }
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.a == null ? 0 : this.a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.a == null ? null : this.a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.a == null ? null : this.a.getItem(i);
        }

        public long getItemId(int i) {
            return this.a == null ? -1 : this.a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    private class b extends ao {
        ListAdapter a;
        private CharSequence h;
        private final Rect i = new Rect();

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            b((View) y.this);
            a(true);
            a(0);
            a(new OnItemClickListener(y.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    y.this.setSelection(i);
                    if (y.this.getOnItemClickListener() != null) {
                        y.this.performItemClick(view, i, b.this.a.getItemId(i));
                    }
                    b.this.c();
                }
            });
        }

        public void a() {
            boolean d = d();
            f();
            h(2);
            super.a();
            e().setChoiceMode(1);
            i(y.this.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    final OnGlobalLayoutListener anonymousClass2 = new OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (b.this.a(y.this)) {
                                b.this.f();
                                super.a();
                                return;
                            }
                            b.this.c();
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
                    a(new OnDismissListener() {
                        public void onDismiss() {
                            ViewTreeObserver viewTreeObserver = y.this.getViewTreeObserver();
                            if (viewTreeObserver != null) {
                                viewTreeObserver.removeGlobalOnLayoutListener(anonymousClass2);
                            }
                        }
                    });
                }
            }
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        boolean a(View view) {
            return r.x(view) && view.getGlobalVisibleRect(this.i);
        }

        public CharSequence b() {
            return this.h;
        }

        void f() {
            int a;
            Drawable h = h();
            int i = 0;
            if (h != null) {
                h.getPadding(y.this.c);
                i = bo.a(y.this) ? y.this.c.right : -y.this.c.left;
            } else {
                Rect rect = y.this.c;
                y.this.c.right = 0;
                rect.left = 0;
            }
            int paddingLeft = y.this.getPaddingLeft();
            int paddingRight = y.this.getPaddingRight();
            int width = y.this.getWidth();
            if (y.this.b == -2) {
                a = y.this.a((SpinnerAdapter) this.a, h());
                int i2 = (y.this.getContext().getResources().getDisplayMetrics().widthPixels - y.this.c.left) - y.this.c.right;
                if (a > i2) {
                    a = i2;
                }
                a = Math.max(a, (width - paddingLeft) - paddingRight);
            } else {
                a = y.this.b == -1 ? (width - paddingLeft) - paddingRight : y.this.b;
            }
            g(a);
            c(bo.a(y.this) ? i + ((width - paddingRight) - l()) : i + paddingLeft);
        }
    }

    public y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.spinnerStyle);
    }

    public y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Missing block: B:23:0x0055, code:
            if (r12 != null) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:24:0x0057, code:
            r12.recycle();
     */
    /* JADX WARNING: Missing block: B:32:0x0069, code:
            if (r12 != null) goto L_0x0057;
     */
    public y(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
        r7 = this;
        r7.<init>(r8, r9, r10);
        r0 = new android.graphics.Rect;
        r0.<init>();
        r7.c = r0;
        r0 = android.support.v7.a.a.j.Spinner;
        r1 = 0;
        r0 = android.support.v7.widget.bg.a(r8, r9, r0, r10, r1);
        r2 = new android.support.v7.widget.g;
        r2.<init>(r7);
        r7.e = r2;
        r2 = 0;
        if (r12 == 0) goto L_0x0023;
    L_0x001b:
        r3 = new android.support.v7.view.d;
        r3.<init>(r8, r12);
    L_0x0020:
        r7.f = r3;
        goto L_0x003c;
    L_0x0023:
        r12 = android.support.v7.a.a.j.Spinner_popupTheme;
        r12 = r0.g(r12, r1);
        if (r12 == 0) goto L_0x0031;
    L_0x002b:
        r3 = new android.support.v7.view.d;
        r3.<init>(r8, r12);
        goto L_0x0020;
    L_0x0031:
        r12 = android.os.Build.VERSION.SDK_INT;
        r3 = 23;
        if (r12 >= r3) goto L_0x0039;
    L_0x0037:
        r12 = r8;
        goto L_0x003a;
    L_0x0039:
        r12 = r2;
    L_0x003a:
        r7.f = r12;
    L_0x003c:
        r12 = r7.f;
        r3 = 1;
        if (r12 == 0) goto L_0x00ab;
    L_0x0041:
        r12 = -1;
        if (r11 != r12) goto L_0x0073;
    L_0x0044:
        r12 = d;	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r12 = r8.obtainStyledAttributes(r9, r12, r10, r1);	 Catch:{ Exception -> 0x0060, all -> 0x005d }
        r4 = r12.hasValue(r1);	 Catch:{ Exception -> 0x005b }
        if (r4 == 0) goto L_0x0055;
    L_0x0050:
        r4 = r12.getInt(r1, r1);	 Catch:{ Exception -> 0x005b }
        r11 = r4;
    L_0x0055:
        if (r12 == 0) goto L_0x0073;
    L_0x0057:
        r12.recycle();
        goto L_0x0073;
    L_0x005b:
        r4 = move-exception;
        goto L_0x0062;
    L_0x005d:
        r7 = move-exception;
        r12 = r2;
        goto L_0x006d;
    L_0x0060:
        r4 = move-exception;
        r12 = r2;
    L_0x0062:
        r5 = "AppCompatSpinner";
        r6 = "Could not read android:spinnerMode";
        android.util.Log.i(r5, r6, r4);	 Catch:{ all -> 0x006c }
        if (r12 == 0) goto L_0x0073;
    L_0x006b:
        goto L_0x0057;
    L_0x006c:
        r7 = move-exception;
    L_0x006d:
        if (r12 == 0) goto L_0x0072;
    L_0x006f:
        r12.recycle();
    L_0x0072:
        throw r7;
    L_0x0073:
        if (r11 != r3) goto L_0x00ab;
    L_0x0075:
        r11 = new android.support.v7.widget.y$b;
        r12 = r7.f;
        r11.<init>(r12, r9, r10);
        r12 = r7.f;
        r4 = android.support.v7.a.a.j.Spinner;
        r12 = android.support.v7.widget.bg.a(r12, r9, r4, r10, r1);
        r1 = android.support.v7.a.a.j.Spinner_android_dropDownWidth;
        r4 = -2;
        r1 = r12.f(r1, r4);
        r7.b = r1;
        r1 = android.support.v7.a.a.j.Spinner_android_popupBackground;
        r1 = r12.a(r1);
        r11.a(r1);
        r1 = android.support.v7.a.a.j.Spinner_android_prompt;
        r1 = r0.d(r1);
        r11.a(r1);
        r12.a();
        r7.a = r11;
        r12 = new android.support.v7.widget.y$1;
        r12.<init>(r7, r11);
        r7.g = r12;
    L_0x00ab:
        r11 = android.support.v7.a.a.j.Spinner_android_entries;
        r11 = r0.f(r11);
        if (r11 == 0) goto L_0x00c3;
    L_0x00b3:
        r12 = new android.widget.ArrayAdapter;
        r1 = 17367048; // 0x1090008 float:2.5162948E-38 double:8.580462E-317;
        r12.<init>(r8, r1, r11);
        r8 = android.support.v7.a.a.g.support_simple_spinner_dropdown_item;
        r12.setDropDownViewResource(r8);
        r7.setAdapter(r12);
    L_0x00c3:
        r0.a();
        r7.i = r3;
        r8 = r7.h;
        if (r8 == 0) goto L_0x00d3;
    L_0x00cc:
        r8 = r7.h;
        r7.setAdapter(r8);
        r7.h = r2;
    L_0x00d3:
        r7 = r7.e;
        r7.a(r9, r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.y.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i2 = 0;
        View view = null;
        for (max = Math.max(0, max - (15 - (min - max))); max < min; max++) {
            int itemViewType = spinnerAdapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.c);
            i2 += this.c.left + this.c.right;
        }
        return i2;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null) {
            this.e.c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.a != null ? this.a.j() : VERSION.SDK_INT >= 16 ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.a != null ? this.a.k() : VERSION.SDK_INT >= 16 ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.a != null ? this.b : VERSION.SDK_INT >= 16 ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.a != null ? this.a.h() : VERSION.SDK_INT >= 16 ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.a != null ? this.f : VERSION.SDK_INT >= 23 ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.a != null ? this.a.b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.e != null ? this.e.a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.e != null ? this.e.b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null && this.a.d()) {
            this.a.c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.g == null || !this.g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.a == null) {
            return super.performClick();
        }
        if (!this.a.d()) {
            this.a.a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.i) {
            super.setAdapter(spinnerAdapter);
            if (this.a != null) {
                this.a.a(new a(spinnerAdapter, (this.f == null ? getContext() : this.f).getTheme()));
            }
            return;
        }
        this.h = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.e != null) {
            this.e.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.e != null) {
            this.e.a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.a != null) {
            this.a.c(i);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.a != null) {
            this.a.d(i);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.a != null) {
            this.b = i;
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.a != null) {
            this.a.a(drawable);
            return;
        }
        if (VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(android.support.v7.b.a.a.b(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.a != null) {
            this.a.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.e != null) {
            this.e.a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.e != null) {
            this.e.a(mode);
        }
    }
}
