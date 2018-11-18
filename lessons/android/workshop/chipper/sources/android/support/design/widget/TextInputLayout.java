package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.f;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.a.k;
import android.support.v4.h.r;
import android.support.v4.widget.m;
import android.support.v4.widget.n;
import android.support.v7.a.a.c;
import android.support.v7.widget.aa;
import android.support.v7.widget.ag;
import android.support.v7.widget.bg;
import android.support.v7.widget.bp;
import android.support.v7.widget.l;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextInputLayout extends LinearLayout implements bp {
    private boolean A;
    private Drawable B;
    private Drawable C;
    private ColorStateList D;
    private boolean E;
    private Mode F;
    private boolean G;
    private ColorStateList H;
    private ColorStateList I;
    private boolean J;
    private boolean K;
    private ValueAnimator L;
    private boolean M;
    private boolean N;
    private boolean O;
    EditText a;
    TextView b;
    boolean c;
    final e d;
    private final FrameLayout e;
    private CharSequence f;
    private boolean g;
    private CharSequence h;
    private Paint i;
    private final Rect j;
    private LinearLayout k;
    private int l;
    private Typeface m;
    private boolean n;
    private int o;
    private boolean p;
    private CharSequence q;
    private TextView r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private Drawable x;
    private CharSequence y;
    private CheckableImageButton z;

    static class a extends android.support.v4.h.a {
        public static final Creator<a> CREATOR = new ClassLoaderCreator<a>() {
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel, null);
            }

            /* renamed from: a */
            public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new a(parcel, classLoader);
            }

            /* renamed from: a */
            public a[] newArray(int i) {
                return new a[i];
            }
        };
        CharSequence a;
        boolean b;

        a(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.b = z;
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TextInputLayout.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" error=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.a, parcel, i);
            parcel.writeInt(this.b);
        }
    }

    private class b extends android.support.v4.h.b {
        b() {
        }

        public void a(View view, android.support.v4.h.a.b bVar) {
            super.a(view, bVar);
            bVar.a(TextInputLayout.class.getSimpleName());
            CharSequence g = TextInputLayout.this.d.g();
            if (!TextUtils.isEmpty(g)) {
                bVar.b(g);
            }
            if (TextInputLayout.this.a != null) {
                bVar.a(TextInputLayout.this.a);
            }
            CharSequence text = TextInputLayout.this.b != null ? TextInputLayout.this.b.getText() : null;
            if (!TextUtils.isEmpty(text)) {
                bVar.d(true);
                bVar.c(text);
            }
        }

        public void a(View view, AccessibilityEvent accessibilityEvent) {
            super.a(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            CharSequence g = TextInputLayout.this.d.g();
            if (!TextUtils.isEmpty(g)) {
                accessibilityEvent.getText().add(g);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.j = new Rect();
        this.d = new e(this);
        p.a(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.e = new FrameLayout(context);
        this.e.setAddStatesFromChildren(true);
        addView(this.e);
        this.d.a(a.b);
        this.d.b(new AccelerateInterpolator());
        this.d.b(8388659);
        bg a = bg.a(context, attributeSet, k.TextInputLayout, i, j.Widget_Design_TextInputLayout);
        this.g = a.a(k.TextInputLayout_hintEnabled, true);
        setHint(a.c(k.TextInputLayout_android_hint));
        this.K = a.a(k.TextInputLayout_hintAnimationEnabled, true);
        if (a.g(k.TextInputLayout_android_textColorHint)) {
            ColorStateList e = a.e(k.TextInputLayout_android_textColorHint);
            this.I = e;
            this.H = e;
        }
        if (a.g(k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(a.g(k.TextInputLayout_hintTextAppearance, 0));
        }
        this.o = a.g(k.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = a.a(k.TextInputLayout_errorEnabled, false);
        boolean a3 = a.a(k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(a.a(k.TextInputLayout_counterMaxLength, -1));
        this.t = a.g(k.TextInputLayout_counterTextAppearance, 0);
        this.u = a.g(k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.w = a.a(k.TextInputLayout_passwordToggleEnabled, false);
        this.x = a.a(k.TextInputLayout_passwordToggleDrawable);
        this.y = a.c(k.TextInputLayout_passwordToggleContentDescription);
        if (a.g(k.TextInputLayout_passwordToggleTint)) {
            this.E = true;
            this.D = a.e(k.TextInputLayout_passwordToggleTint);
        }
        if (a.g(k.TextInputLayout_passwordToggleTintMode)) {
            this.G = true;
            this.F = s.a(a.a(k.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        a.a();
        setErrorEnabled(a2);
        setCounterEnabled(a3);
        h();
        if (r.d(this) == 0) {
            r.a((View) this, 1);
        }
        r.a((View) this, new b());
    }

    private void a() {
        int i;
        LayoutParams layoutParams = (LayoutParams) this.e.getLayoutParams();
        if (this.g) {
            if (this.i == null) {
                this.i = new Paint();
            }
            this.i.setTypeface(this.d.b());
            this.i.setTextSize(this.d.e());
            i = (int) (-this.i.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.e.requestLayout();
        }
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    private void a(TextView textView) {
        if (this.k != null) {
            this.k.removeView(textView);
            int i = this.l - 1;
            this.l = i;
            if (i == 0) {
                this.k.setVisibility(8);
            }
        }
    }

    private void a(TextView textView, int i) {
        if (this.k == null) {
            this.k = new LinearLayout(getContext());
            this.k.setOrientation(0);
            addView(this.k, -1, -2);
            this.k.addView(new m(getContext()), new LayoutParams(0, 0, 1.0f));
            if (this.a != null) {
                b();
            }
        }
        this.k.setVisibility(0);
        this.k.addView(textView, i);
        this.l++;
    }

    private void a(final CharSequence charSequence, boolean z) {
        ViewPropertyAnimator listener;
        this.q = charSequence;
        if (!this.n) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        this.p = TextUtils.isEmpty(charSequence) ^ true;
        this.b.animate().cancel();
        if (this.p) {
            this.b.setText(charSequence);
            this.b.setVisibility(0);
            if (z) {
                if (this.b.getAlpha() == 1.0f) {
                    this.b.setAlpha(0.0f);
                }
                listener = this.b.animate().alpha(1.0f).setDuration(200).setInterpolator(a.d).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                        TextInputLayout.this.b.setVisibility(0);
                    }
                });
            } else {
                this.b.setAlpha(1.0f);
                c();
                a(z);
            }
        }
        if (this.b.getVisibility() == 0) {
            if (z) {
                listener = this.b.animate().alpha(0.0f).setDuration(200).setInterpolator(a.c).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.b.setText(charSequence);
                        TextInputLayout.this.b.setVisibility(4);
                    }
                });
            } else {
                this.b.setText(charSequence);
                this.b.setVisibility(4);
            }
        }
        c();
        a(z);
        listener.start();
        c();
        a(z);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void b() {
        r.a(this.k, r.f(this.a), 0, r.g(this.a), this.a.getPaddingBottom());
    }

    private void b(boolean z) {
        if (this.w) {
            boolean z2;
            int selectionEnd = this.a.getSelectionEnd();
            if (f()) {
                this.a.setTransformationMethod(null);
                z2 = true;
            } else {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                z2 = false;
            }
            this.A = z2;
            this.z.setChecked(this.A);
            if (z) {
                this.z.jumpDrawablesToCurrentState();
            }
            this.a.setSelection(selectionEnd);
        }
    }

    private void c() {
        if (this.a != null) {
            Drawable background = this.a.getBackground();
            if (background != null) {
                TextView textView;
                d();
                if (ag.b(background)) {
                    background = background.mutate();
                }
                if (this.p && this.b != null) {
                    textView = this.b;
                } else if (!this.v || this.r == null) {
                    android.support.v4.graphics.drawable.a.f(background);
                    this.a.refreshDrawableState();
                    return;
                } else {
                    textView = this.r;
                }
                background.setColorFilter(l.a(textView.getCurrentTextColor(), Mode.SRC_IN));
            }
        }
    }

    private void c(boolean z) {
        if (this.L != null && this.L.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(1.0f);
        } else {
            this.d.b(1.0f);
        }
        this.J = false;
    }

    private void d() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.a.getBackground();
            if (!(background == null || this.M)) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.M = f.a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.M) {
                    r.a(this.a, newDrawable);
                    this.M = true;
                }
            }
        }
    }

    private void d(boolean z) {
        if (this.L != null && this.L.isRunning()) {
            this.L.cancel();
        }
        if (z && this.K) {
            a(0.0f);
        } else {
            this.d.b(0.0f);
        }
        this.J = true;
    }

    private void e() {
        if (this.a != null) {
            Drawable[] a;
            if (g()) {
                if (this.z == null) {
                    this.z = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(h.design_text_input_password_icon, this.e, false);
                    this.z.setImageDrawable(this.x);
                    this.z.setContentDescription(this.y);
                    this.e.addView(this.z);
                    this.z.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.b(false);
                        }
                    });
                }
                if (this.a != null && r.i(this.a) <= 0) {
                    this.a.setMinimumHeight(r.i(this.z));
                }
                this.z.setVisibility(0);
                this.z.setChecked(this.A);
                if (this.B == null) {
                    this.B = new ColorDrawable();
                }
                this.B.setBounds(0, 0, this.z.getMeasuredWidth(), 1);
                a = n.a(this.a);
                if (a[2] != this.B) {
                    this.C = a[2];
                }
                n.a(this.a, a[0], a[1], this.B, a[3]);
                this.z.setPadding(this.a.getPaddingLeft(), this.a.getPaddingTop(), this.a.getPaddingRight(), this.a.getPaddingBottom());
                return;
            }
            if (this.z != null && this.z.getVisibility() == 0) {
                this.z.setVisibility(8);
            }
            if (this.B != null) {
                a = n.a(this.a);
                if (a[2] == this.B) {
                    n.a(this.a, a[0], a[1], this.C, a[3]);
                    this.B = null;
                }
            }
        }
    }

    private boolean f() {
        return this.a != null && (this.a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean g() {
        return this.w && (f() || this.A);
    }

    private void h() {
        if (this.x == null) {
            return;
        }
        if (this.E || this.G) {
            this.x = android.support.v4.graphics.drawable.a.g(this.x).mutate();
            if (this.E) {
                android.support.v4.graphics.drawable.a.a(this.x, this.D);
            }
            if (this.G) {
                android.support.v4.graphics.drawable.a.a(this.x, this.F);
            }
            if (this.z != null && this.z.getDrawable() != this.x) {
                this.z.setImageDrawable(this.x);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof o)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.a = editText;
        if (!f()) {
            this.d.a(this.a.getTypeface());
        }
        this.d.a(this.a.getTextSize());
        int gravity = this.a.getGravity();
        this.d.b((gravity & -113) | 48);
        this.d.a(gravity);
        this.a.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.a(TextInputLayout.this.O ^ 1);
                if (TextInputLayout.this.c) {
                    TextInputLayout.this.a(editable.length());
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.H == null) {
            this.H = this.a.getHintTextColors();
        }
        if (this.g && TextUtils.isEmpty(this.h)) {
            this.f = this.a.getHint();
            setHint(this.f);
            this.a.setHint(null);
        }
        if (this.r != null) {
            a(this.a.getText().length());
        }
        if (this.k != null) {
            b();
        }
        e();
        a(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        this.h = charSequence;
        this.d.a(charSequence);
    }

    void a(float f) {
        if (this.d.d() != f) {
            if (this.L == null) {
                this.L = new ValueAnimator();
                this.L.setInterpolator(a.a);
                this.L.setDuration(200);
                this.L.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.d.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.L.setFloatValues(new float[]{this.d.d(), f});
            this.L.start();
        }
    }

    void a(int i) {
        boolean z = this.v;
        if (this.s == -1) {
            this.r.setText(String.valueOf(i));
            this.v = false;
        } else {
            this.v = i > this.s;
            if (z != this.v) {
                n.a(this.r, this.v ? this.u : this.t);
            }
            this.r.setText(getContext().getString(i.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.s)}));
        }
        if (this.a != null && z != this.v) {
            a(false);
            c();
        }
    }

    void a(boolean z) {
        a(z, false);
    }

    void a(boolean z, boolean z2) {
        e eVar;
        ColorStateList textColors;
        boolean isEnabled = isEnabled();
        int i = (this.a == null || TextUtils.isEmpty(this.a.getText())) ? 0 : 1;
        boolean a = a(getDrawableState(), 16842908);
        int isEmpty = 1 ^ TextUtils.isEmpty(getError());
        if (this.H != null) {
            this.d.b(this.H);
        }
        if (isEnabled && this.v && this.r != null) {
            eVar = this.d;
            textColors = this.r.getTextColors();
        } else if (isEnabled && a && this.I != null) {
            eVar = this.d;
            textColors = this.I;
        } else {
            if (this.H != null) {
                eVar = this.d;
                textColors = this.H;
            }
            if (i == 0 || (isEnabled() && (a || isEmpty != 0))) {
                if (z2 || this.J) {
                    c(z);
                }
            } else if (z2 || !this.J) {
                d(z);
                return;
            }
        }
        eVar.a(textColors);
        if (i == 0) {
        }
        c(z);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.e.addView(view, layoutParams2);
            this.e.setLayoutParams(layoutParams);
            a();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f == null || this.a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        CharSequence hint = this.a.getHint();
        this.a.setHint(this.f);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.a.setHint(hint);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.O = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.O = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.g) {
            this.d.a(canvas);
        }
    }

    protected void drawableStateChanged() {
        if (!this.N) {
            boolean z = true;
            this.N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!(r.u(this) && isEnabled())) {
                z = false;
            }
            a(z);
            c();
            if ((this.d != null ? this.d.a(drawableState) | 0 : 0) != 0) {
                invalidate();
            }
            this.N = false;
        }
    }

    public int getCounterMaxLength() {
        return this.s;
    }

    public EditText getEditText() {
        return this.a;
    }

    public CharSequence getError() {
        return this.n ? this.q : null;
    }

    public CharSequence getHint() {
        return this.g ? this.h : null;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.y;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.x;
    }

    public Typeface getTypeface() {
        return this.m;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g && this.a != null) {
            Rect rect = this.j;
            android.support.v4.widget.r.b(this, this.a, rect);
            i = rect.left + this.a.getCompoundPaddingLeft();
            i3 = rect.right - this.a.getCompoundPaddingRight();
            this.d.a(i, rect.top + this.a.getCompoundPaddingTop(), i3, rect.bottom - this.a.getCompoundPaddingBottom());
            this.d.b(i, getPaddingTop(), i3, (i4 - i2) - getPaddingBottom());
            this.d.f();
        }
    }

    protected void onMeasure(int i, int i2) {
        e();
        super.onMeasure(i, i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof a) {
            a aVar = (a) parcelable;
            super.onRestoreInstanceState(aVar.a());
            setError(aVar.a);
            if (aVar.b) {
                b(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable aVar = new a(super.onSaveInstanceState());
        if (this.p) {
            aVar.a = getError();
        }
        aVar.b = this.A;
        return aVar;
    }

    public void setCounterEnabled(boolean z) {
        if (this.c != z) {
            if (z) {
                this.r = new aa(getContext());
                this.r.setId(f.textinput_counter);
                if (this.m != null) {
                    this.r.setTypeface(this.m);
                }
                this.r.setMaxLines(1);
                try {
                    n.a(this.r, this.t);
                } catch (Exception unused) {
                    n.a(this.r, android.support.v7.a.a.i.TextAppearance_AppCompat_Caption);
                    this.r.setTextColor(android.support.v4.a.a.c(getContext(), c.error_color_material));
                }
                a(this.r, -1);
                a(this.a == null ? 0 : this.a.getText().length());
            } else {
                a(this.r);
                this.r = null;
            }
            this.c = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.s != i) {
            if (i <= 0) {
                i = -1;
            }
            this.s = i;
            if (this.c) {
                a(this.a == null ? 0 : this.a.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    public void setError(CharSequence charSequence) {
        boolean z = r.u(this) && isEnabled() && (this.b == null || !TextUtils.equals(this.b.getText(), charSequence));
        a(charSequence, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    public void setErrorEnabled(boolean r6) {
        /*
        r5 = this;
        r0 = r5.n;
        if (r0 == r6) goto L_0x008a;
    L_0x0004:
        r0 = r5.b;
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r5.b;
        r0 = r0.animate();
        r0.cancel();
    L_0x0011:
        r0 = 0;
        if (r6 == 0) goto L_0x007b;
    L_0x0014:
        r1 = new android.support.v7.widget.aa;
        r2 = r5.getContext();
        r1.<init>(r2);
        r5.b = r1;
        r1 = r5.b;
        r2 = android.support.design.a.f.textinput_error;
        r1.setId(r2);
        r1 = r5.m;
        if (r1 == 0) goto L_0x0031;
    L_0x002a:
        r1 = r5.b;
        r2 = r5.m;
        r1.setTypeface(r2);
    L_0x0031:
        r1 = 1;
        r2 = r5.b;	 Catch:{ Exception -> 0x0051 }
        r3 = r5.o;	 Catch:{ Exception -> 0x0051 }
        android.support.v4.widget.n.a(r2, r3);	 Catch:{ Exception -> 0x0051 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0051 }
        r3 = 23;
        if (r2 < r3) goto L_0x004f;
    L_0x003f:
        r2 = r5.b;	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getTextColors();	 Catch:{ Exception -> 0x0051 }
        r2 = r2.getDefaultColor();	 Catch:{ Exception -> 0x0051 }
        r3 = -65281; // 0xffffffffffff00ff float:NaN double:NaN;
        if (r2 != r3) goto L_0x004f;
    L_0x004e:
        goto L_0x0051;
    L_0x004f:
        r2 = r0;
        goto L_0x0052;
    L_0x0051:
        r2 = r1;
    L_0x0052:
        if (r2 == 0) goto L_0x006a;
    L_0x0054:
        r2 = r5.b;
        r3 = android.support.v7.a.a.i.TextAppearance_AppCompat_Caption;
        android.support.v4.widget.n.a(r2, r3);
        r2 = r5.b;
        r3 = r5.getContext();
        r4 = android.support.v7.a.a.c.error_color_material;
        r3 = android.support.v4.a.a.c(r3, r4);
        r2.setTextColor(r3);
    L_0x006a:
        r2 = r5.b;
        r3 = 4;
        r2.setVisibility(r3);
        r2 = r5.b;
        android.support.v4.h.r.b(r2, r1);
        r1 = r5.b;
        r5.a(r1, r0);
        goto L_0x0088;
    L_0x007b:
        r5.p = r0;
        r5.c();
        r0 = r5.b;
        r5.a(r0);
        r0 = 0;
        r5.b = r0;
    L_0x0088:
        r5.n = r6;
    L_0x008a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.setErrorEnabled(boolean):void");
    }

    public void setErrorTextAppearance(int i) {
        this.o = i;
        if (this.b != null) {
            n.a(this.b, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.g) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.K = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.g) {
            this.g = z;
            CharSequence hint = this.a.getHint();
            if (!this.g) {
                if (!TextUtils.isEmpty(this.h) && TextUtils.isEmpty(hint)) {
                    this.a.setHint(this.h);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.h)) {
                    setHint(hint);
                }
                this.a.setHint(null);
            }
            if (this.a != null) {
                a();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.d.c(i);
        this.I = this.d.h();
        if (this.a != null) {
            a(false);
            a();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.y = charSequence;
        if (this.z != null) {
            this.z.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? android.support.v7.b.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.x = drawable;
        if (this.z != null) {
            this.z.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!(z || !this.A || this.a == null)) {
                this.a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.A = false;
            e();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.D = colorStateList;
        this.E = true;
        h();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.F = mode;
        this.G = true;
        h();
    }

    public void setTypeface(Typeface typeface) {
        if ((this.m != null && !this.m.equals(typeface)) || (this.m == null && typeface != null)) {
            this.m = typeface;
            this.d.a(typeface);
            if (this.r != null) {
                this.r.setTypeface(typeface);
            }
            if (this.b != null) {
                this.b.setTypeface(typeface);
            }
        }
    }
}
