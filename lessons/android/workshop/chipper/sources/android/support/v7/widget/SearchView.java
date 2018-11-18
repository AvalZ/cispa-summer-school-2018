package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.h.r;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends an implements android.support.v7.view.c {
    static final a i = new a();
    private c A;
    private b B;
    private d C;
    private OnClickListener D;
    private boolean E;
    private boolean F;
    private boolean G;
    private CharSequence H;
    private boolean I;
    private boolean J;
    private int K;
    private boolean L;
    private CharSequence M;
    private CharSequence N;
    private boolean O;
    private int P;
    private Bundle Q;
    private final Runnable R;
    private Runnable S;
    private final WeakHashMap<String, ConstantState> T;
    private final OnClickListener U;
    private final OnEditorActionListener V;
    private final OnItemClickListener W;
    final SearchAutoComplete a;
    private final OnItemSelectedListener aa;
    private TextWatcher ab;
    final ImageView b;
    final ImageView c;
    final ImageView d;
    final ImageView e;
    OnFocusChangeListener f;
    android.support.v4.widget.d g;
    SearchableInfo h;
    OnKeyListener j;
    private final View k;
    private final View l;
    private final View m;
    private final View n;
    private f o;
    private Rect p;
    private Rect q;
    private int[] r;
    private int[] s;
    private final ImageView t;
    private final Drawable u;
    private final int v;
    private final int w;
    private final Intent x;
    private final Intent y;
    private final CharSequence z;

    private static class a {
        private Method a;
        private Method b;
        private Method c;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:7:0x003c, code:
            return;
     */
        a() {
            /*
            r6 = this;
            r6.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.widget.AutoCompleteTextView.class;
            r3 = "doBeforeTextChanged";
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0016 }
            r6.a = r2;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2 = r6.a;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0016 }
        L_0x0016:
            r2 = android.widget.AutoCompleteTextView.class;
            r3 = "doAfterTextChanged";
            r4 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0027 }
            r6.b = r2;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2 = r6.b;	 Catch:{ NoSuchMethodException -> 0x0027 }
            r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0027 }
        L_0x0027:
            r2 = android.widget.AutoCompleteTextView.class;
            r3 = "ensureImeVisible";
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x003c }
            r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x003c }
            r0 = r2.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x003c }
            r6.c = r0;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = r6.c;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x003c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.a.<init>():void");
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            if (this.a != null) {
                try {
                    this.a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.c != null) {
                try {
                    this.c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            if (this.b != null) {
                try {
                    this.b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface b {
        boolean a();
    }

    public interface c {
        boolean a(String str);

        boolean b(String str);
    }

    public interface d {
        boolean a(int i);

        boolean b(int i);
    }

    private static class f extends TouchDelegate {
        private final View a;
        private final Rect b = new Rect();
        private final Rect c = new Rect();
        private final Rect d = new Rect();
        private final int e;
        private boolean f;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.b.set(rect);
            this.d.set(rect);
            this.d.inset(-this.e, -this.e);
            this.c.set(rect2);
        }

        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r0 = r7.getX();
            r0 = (int) r0;
            r1 = r7.getY();
            r1 = (int) r1;
            r2 = r7.getAction();
            r3 = 1;
            r4 = 0;
            switch(r2) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0019;
                case 2: goto L_0x0019;
                case 3: goto L_0x0014;
                default: goto L_0x0013;
            };
        L_0x0013:
            goto L_0x0033;
        L_0x0014:
            r2 = r6.f;
            r6.f = r4;
            goto L_0x0034;
        L_0x0019:
            r2 = r6.f;
            if (r2 == 0) goto L_0x0034;
        L_0x001d:
            r5 = r6.d;
            r5 = r5.contains(r0, r1);
            if (r5 != 0) goto L_0x0034;
        L_0x0025:
            r3 = r4;
            goto L_0x0034;
        L_0x0027:
            r2 = r6.b;
            r2 = r2.contains(r0, r1);
            if (r2 == 0) goto L_0x0033;
        L_0x002f:
            r6.f = r3;
            r2 = r3;
            goto L_0x0034;
        L_0x0033:
            r2 = r4;
        L_0x0034:
            if (r2 == 0) goto L_0x0067;
        L_0x0036:
            if (r3 == 0) goto L_0x0052;
        L_0x0038:
            r2 = r6.c;
            r2 = r2.contains(r0, r1);
            if (r2 != 0) goto L_0x0052;
        L_0x0040:
            r0 = r6.a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            goto L_0x005d;
        L_0x0052:
            r2 = r6.c;
            r2 = r2.left;
            r0 = r0 - r2;
            r0 = (float) r0;
            r2 = r6.c;
            r2 = r2.top;
            r1 = r1 - r2;
        L_0x005d:
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            r6 = r6.a;
            r4 = r6.dispatchTouchEvent(r7);
        L_0x0067:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static class e extends android.support.v4.h.a {
        public static final Creator<e> CREATOR = new ClassLoaderCreator<e>() {
            /* renamed from: a */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel, null);
            }

            /* renamed from: a */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            /* renamed from: a */
            public e[] newArray(int i) {
                return new e[i];
            }
        };
        boolean a;

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SearchView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" isIconified=");
            stringBuilder.append(this.a);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.a));
        }
    }

    public static class SearchAutoComplete extends f {
        final Runnable a;
        private int b;
        private SearchView c;
        private boolean d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, android.support.v7.a.a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.a = new Runnable() {
                public void run() {
                    SearchAutoComplete.this.b();
                }
            };
            this.b = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            return (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160 : 256;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void b() {
            if (this.d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.d = false;
            }
        }

        public boolean enoughToFilter() {
            return this.b <= 0 || super.enoughToFilter();
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.d) {
                removeCallbacks(this.a);
                post(this.a);
            }
            return onCreateInputConnection;
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.c.i();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.c.hasFocus() && getVisibility() == 0) {
                this.d = true;
                if (SearchView.a(getContext())) {
                    SearchView.i.a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.d = false;
                removeCallbacks(this.a);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.d = true;
            }
        }

        void setSearchView(SearchView searchView) {
            this.c = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.b = i;
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new Rect();
        this.q = new Rect();
        this.r = new int[2];
        this.s = new int[2];
        this.R = new Runnable() {
            public void run() {
                SearchView.this.d();
            }
        };
        this.S = new Runnable() {
            public void run() {
                if (SearchView.this.g != null && (SearchView.this.g instanceof ba)) {
                    SearchView.this.g.a(null);
                }
            }
        };
        this.T = new WeakHashMap();
        this.U = new OnClickListener() {
            public void onClick(View view) {
                if (view == SearchView.this.b) {
                    SearchView.this.g();
                } else if (view == SearchView.this.d) {
                    SearchView.this.f();
                } else if (view == SearchView.this.c) {
                    SearchView.this.e();
                } else if (view == SearchView.this.e) {
                    SearchView.this.h();
                } else {
                    if (view == SearchView.this.a) {
                        SearchView.this.l();
                    }
                }
            }
        };
        this.j = new OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.h == null) {
                    return false;
                }
                if (SearchView.this.a.isPopupShowing() && SearchView.this.a.getListSelection() != -1) {
                    return SearchView.this.a(view, i, keyEvent);
                }
                if (SearchView.this.a.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView.this.a(0, null, SearchView.this.a.getText().toString());
                return true;
            }
        };
        this.V = new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.e();
                return true;
            }
        };
        this.W = new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.a(i, 0, null);
            }
        };
        this.aa = new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.a(i);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
        this.ab = new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.b(charSequence);
            }
        };
        bg a = bg.a(context, attributeSet, j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(a.g(j.SearchView_layout, g.abc_search_view), this, true);
        this.a = (SearchAutoComplete) findViewById(android.support.v7.a.a.f.search_src_text);
        this.a.setSearchView(this);
        this.k = findViewById(android.support.v7.a.a.f.search_edit_frame);
        this.l = findViewById(android.support.v7.a.a.f.search_plate);
        this.m = findViewById(android.support.v7.a.a.f.submit_area);
        this.b = (ImageView) findViewById(android.support.v7.a.a.f.search_button);
        this.c = (ImageView) findViewById(android.support.v7.a.a.f.search_go_btn);
        this.d = (ImageView) findViewById(android.support.v7.a.a.f.search_close_btn);
        this.e = (ImageView) findViewById(android.support.v7.a.a.f.search_voice_btn);
        this.t = (ImageView) findViewById(android.support.v7.a.a.f.search_mag_icon);
        r.a(this.l, a.a(j.SearchView_queryBackground));
        r.a(this.m, a.a(j.SearchView_submitBackground));
        this.b.setImageDrawable(a.a(j.SearchView_searchIcon));
        this.c.setImageDrawable(a.a(j.SearchView_goIcon));
        this.d.setImageDrawable(a.a(j.SearchView_closeIcon));
        this.e.setImageDrawable(a.a(j.SearchView_voiceIcon));
        this.t.setImageDrawable(a.a(j.SearchView_searchIcon));
        this.u = a.a(j.SearchView_searchHintIcon);
        bi.a(this.b, getResources().getString(h.abc_searchview_description_search));
        this.v = a.g(j.SearchView_suggestionRowLayout, g.abc_search_dropdown_item_icons_2line);
        this.w = a.g(j.SearchView_commitIcon, 0);
        this.b.setOnClickListener(this.U);
        this.d.setOnClickListener(this.U);
        this.c.setOnClickListener(this.U);
        this.e.setOnClickListener(this.U);
        this.a.setOnClickListener(this.U);
        this.a.addTextChangedListener(this.ab);
        this.a.setOnEditorActionListener(this.V);
        this.a.setOnItemClickListener(this.W);
        this.a.setOnItemSelectedListener(this.aa);
        this.a.setOnKeyListener(this.j);
        this.a.setOnFocusChangeListener(new OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (SearchView.this.f != null) {
                    SearchView.this.f.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(a.a(j.SearchView_iconifiedByDefault, true));
        int e = a.e(j.SearchView_android_maxWidth, -1);
        if (e != -1) {
            setMaxWidth(e);
        }
        this.z = a.c(j.SearchView_defaultQueryHint);
        this.H = a.c(j.SearchView_queryHint);
        e = a.a(j.SearchView_android_imeOptions, -1);
        if (e != -1) {
            setImeOptions(e);
        }
        e = a.a(j.SearchView_android_inputType, -1);
        if (e != -1) {
            setInputType(e);
        }
        setFocusable(a.a(j.SearchView_android_focusable, true));
        a.a();
        this.x = new Intent("android.speech.action.WEB_SEARCH");
        this.x.addFlags(268435456);
        this.x.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.y = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.y.addFlags(268435456);
        this.n = findViewById(this.a.getDropDownAnchor());
        if (this.n != null) {
            this.n.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    SearchView.this.k();
                }
            });
        }
        a(this.E);
        r();
    }

    private Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent a(Cursor cursor, int i, String str) {
        try {
            String a = ba.a(cursor, "suggest_intent_action");
            if (a == null) {
                a = this.h.getSuggestIntentAction();
            }
            if (a == null) {
                a = "android.intent.action.SEARCH";
            }
            String str2 = a;
            a = ba.a(cursor, "suggest_intent_data");
            if (a == null) {
                a = this.h.getSuggestIntentData();
            }
            if (a != null) {
                String a2 = ba.a(cursor, "suggest_intent_data_id");
                if (a2 != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append("/");
                    stringBuilder.append(Uri.encode(a2));
                    a = stringBuilder.toString();
                }
            }
            return a(str2, a == null ? null : Uri.parse(a), ba.a(cursor, "suggest_intent_extra_data"), ba.a(cursor, "suggest_intent_query"), i, str);
        } catch (Throwable e) {
            int position;
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Search suggestions cursor at row ");
            stringBuilder2.append(position);
            stringBuilder2.append(" returned exception.");
            Log.w("SearchView", stringBuilder2.toString(), e);
            return null;
        }
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.N);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.Q != null) {
            intent.putExtra("app_data", this.Q);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.h.getSearchActivity());
        return intent;
    }

    private void a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed launch activity: ");
                stringBuilder.append(intent);
                Log.e("SearchView", stringBuilder.toString(), e);
            }
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.r);
        getLocationInWindow(this.s);
        int i = this.r[1] - this.s[1];
        int i2 = this.r[0] - this.s[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private void a(boolean z) {
        this.F = z;
        int i = 8;
        boolean z2 = false;
        boolean isEmpty = TextUtils.isEmpty(this.a.getText()) ^ true;
        this.b.setVisibility(z ? 0 : 8);
        b(isEmpty);
        this.k.setVisibility(z ? 8 : 0);
        if (!(this.t.getDrawable() == null || this.E)) {
            i = 0;
        }
        this.t.setVisibility(i);
        p();
        if (!isEmpty) {
            z2 = true;
        }
        c(z2);
        o();
    }

    static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        Parcelable activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        if (this.Q != null) {
            bundle.putParcelable("app_data", this.Q);
        }
        Intent intent3 = new Intent(intent);
        String str = "free_form";
        int i = 1;
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        }
        String str2 = null;
        String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", string);
        intent3.putExtra("android.speech.extra.LANGUAGE", string2);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i);
        string2 = "calling_package";
        if (searchActivity != null) {
            str2 = searchActivity.flattenToShortString();
        }
        intent3.putExtra(string2, str2);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private void b(boolean z) {
        int i = (this.G && n() && hasFocus() && (z || !this.L)) ? 0 : 8;
        this.c.setVisibility(i);
    }

    private boolean b(int i, int i2, String str) {
        Cursor a = this.g.a();
        if (a == null || !a.moveToPosition(i)) {
            return false;
        }
        a(a(a, i2, str));
        return true;
    }

    private CharSequence c(CharSequence charSequence) {
        if (!this.E || this.u == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.a.getTextSize()) * 1.25d);
        this.u.setBounds(0, 0, textSize, textSize);
        CharSequence spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.u), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void c(boolean z) {
        int i;
        if (this.L && !c() && z) {
            i = 0;
            this.c.setVisibility(8);
        } else {
            i = 8;
        }
        this.e.setVisibility(i);
    }

    private void e(int i) {
        CharSequence text = this.a.getText();
        Cursor a = this.g.a();
        if (a != null) {
            if (a.moveToPosition(i)) {
                CharSequence c = this.g.c(a);
                if (c != null) {
                    setQuery(c);
                    return;
                }
            }
            setQuery(text);
        }
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.a.a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(android.support.v7.a.a.d.abc_search_view_preferred_width);
    }

    private boolean m() {
        if (this.h == null || !this.h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.h.getVoiceSearchLaunchWebSearch()) {
            intent = this.x;
        } else if (this.h.getVoiceSearchLaunchRecognizer()) {
            intent = this.y;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean n() {
        return (this.G || this.L) && !c();
    }

    private void o() {
        int i = (n() && (this.c.getVisibility() == 0 || this.e.getVisibility() == 0)) ? 0 : 8;
        this.m.setVisibility(i);
    }

    private void p() {
        int i = 1;
        int isEmpty = TextUtils.isEmpty(this.a.getText()) ^ 1;
        int i2 = 0;
        if (isEmpty == 0 && (!this.E || this.O)) {
            i = 0;
        }
        ImageView imageView = this.d;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.d.getDrawable();
        if (drawable != null) {
            drawable.setState(isEmpty != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void q() {
        post(this.R);
    }

    private void r() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(c(queryHint));
    }

    private void s() {
        this.a.setThreshold(this.h.getSuggestThreshold());
        this.a.setImeOptions(this.h.getImeOptions());
        int inputType = this.h.getInputType();
        int i = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.h.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.a.setInputType(inputType);
        if (this.g != null) {
            this.g.a(null);
        }
        if (this.h.getSuggestAuthority() != null) {
            this.g = new ba(getContext(), this, this.h, this.T);
            this.a.setAdapter(this.g);
            ba baVar = (ba) this.g;
            if (this.I) {
                i = 2;
            }
            baVar.a(i);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.a.setText(charSequence);
        this.a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    private void t() {
        this.a.dismissDropDown();
    }

    public void a() {
        if (!this.O) {
            this.O = true;
            this.P = this.a.getImeOptions();
            this.a.setImeOptions(this.P | 33554432);
            this.a.setText("");
            setIconified(false);
        }
    }

    void a(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    void a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void a(CharSequence charSequence, boolean z) {
        this.a.setText(charSequence);
        if (charSequence != null) {
            this.a.setSelection(this.a.length());
            this.N = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            e();
        }
    }

    boolean a(int i) {
        if (this.C != null && this.C.a(i)) {
            return false;
        }
        e(i);
        return true;
    }

    boolean a(int i, int i2, String str) {
        if (this.C != null && this.C.b(i)) {
            return false;
        }
        b(i, 0, null);
        this.a.setImeVisibility(false);
        t();
        return true;
    }

    boolean a(View view, int i, KeyEvent keyEvent) {
        if (this.h != null && this.g != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return a(this.a.getListSelection(), 0, null);
            }
            if (i == 21 || i == 22) {
                this.a.setSelection(i == 21 ? 0 : this.a.length());
                this.a.setListSelection(0);
                this.a.clearListSelection();
                i.a(this.a, true);
                return true;
            } else if (i != 19 || this.a.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    public void b() {
        a((CharSequence) "", false);
        clearFocus();
        a(true);
        this.a.setImeOptions(this.P);
        this.O = false;
    }

    void b(CharSequence charSequence) {
        CharSequence text = this.a.getText();
        this.N = text;
        boolean z = true;
        boolean isEmpty = TextUtils.isEmpty(text) ^ true;
        b(isEmpty);
        if (isEmpty) {
            z = false;
        }
        c(z);
        p();
        o();
        if (!(this.A == null || TextUtils.equals(charSequence, this.M))) {
            this.A.b(charSequence.toString());
        }
        this.M = charSequence.toString();
    }

    public boolean c() {
        return this.F;
    }

    public void clearFocus() {
        this.J = true;
        super.clearFocus();
        this.a.clearFocus();
        this.a.setImeVisibility(false);
        this.J = false;
    }

    void d() {
        int[] iArr = this.a.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.l.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        background = this.m.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        invalidate();
    }

    void e() {
        CharSequence text = this.a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.A == null || !this.A.a(text.toString())) {
                if (this.h != null) {
                    a(0, null, text.toString());
                }
                this.a.setImeVisibility(false);
                t();
            }
        }
    }

    void f() {
        if (!TextUtils.isEmpty(this.a.getText())) {
            this.a.setText("");
            this.a.requestFocus();
            this.a.setImeVisibility(true);
        } else if (this.E && (this.B == null || !this.B.a())) {
            clearFocus();
            a(true);
        }
    }

    void g() {
        a(false);
        this.a.requestFocus();
        this.a.setImeVisibility(true);
        if (this.D != null) {
            this.D.onClick(this);
        }
    }

    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    public int getInputType() {
        return this.a.getInputType();
    }

    public int getMaxWidth() {
        return this.K;
    }

    public CharSequence getQuery() {
        return this.a.getText();
    }

    public CharSequence getQueryHint() {
        return this.H != null ? this.H : (this.h == null || this.h.getHintId() == 0) ? this.z : getContext().getText(this.h.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.w;
    }

    int getSuggestionRowLayout() {
        return this.v;
    }

    public android.support.v4.widget.d getSuggestionsAdapter() {
        return this.g;
    }

    void h() {
        if (this.h != null) {
            SearchableInfo searchableInfo = this.h;
            try {
                Intent a;
                if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                    a = a(this.x, searchableInfo);
                } else {
                    if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        a = b(this.y, searchableInfo);
                    }
                    return;
                }
                getContext().startActivity(a);
            } catch (ActivityNotFoundException unused) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void i() {
        a(c());
        q();
        if (this.a.hasFocus()) {
            l();
        }
    }

    void k() {
        if (this.n.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.l.getPaddingLeft();
            Rect rect = new Rect();
            boolean a = bo.a(this);
            int dimensionPixelSize = this.E ? resources.getDimensionPixelSize(android.support.v7.a.a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(android.support.v7.a.a.d.abc_dropdownitem_text_padding_left) : 0;
            this.a.getDropDownBackground().getPadding(rect);
            this.a.setDropDownHorizontalOffset(a ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.a.setDropDownWidth((((this.n.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void l() {
        i.a(this.a);
        i.b(this.a);
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.R);
        post(this.S);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.a, this.p);
            this.q.set(this.p.left, 0, this.p.right, i4 - i2);
            if (this.o == null) {
                this.o = new f(this.q, this.p, this.a);
                setTouchDelegate(this.o);
                return;
            }
            this.o.a(this.q, this.p);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Missing block: B:9:0x001f, code:
            if (r3.K <= 0) goto L_0x003e;
     */
    protected void onMeasure(int r4, int r5) {
        /*
        r3 = this;
        r0 = r3.c();
        if (r0 == 0) goto L_0x000a;
    L_0x0006:
        super.onMeasure(r4, r5);
        return;
    L_0x000a:
        r0 = android.view.View.MeasureSpec.getMode(r4);
        r4 = android.view.View.MeasureSpec.getSize(r4);
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 == r1) goto L_0x002e;
    L_0x0018:
        if (r0 == 0) goto L_0x0022;
    L_0x001a:
        if (r0 == r2) goto L_0x001d;
    L_0x001c:
        goto L_0x003e;
    L_0x001d:
        r0 = r3.K;
        if (r0 <= 0) goto L_0x003e;
    L_0x0021:
        goto L_0x0032;
    L_0x0022:
        r4 = r3.K;
        if (r4 <= 0) goto L_0x0029;
    L_0x0026:
        r4 = r3.K;
        goto L_0x003e;
    L_0x0029:
        r4 = r3.getPreferredWidth();
        goto L_0x003e;
    L_0x002e:
        r0 = r3.K;
        if (r0 <= 0) goto L_0x0039;
    L_0x0032:
        r0 = r3.K;
    L_0x0034:
        r4 = java.lang.Math.min(r0, r4);
        goto L_0x003e;
    L_0x0039:
        r0 = r3.getPreferredWidth();
        goto L_0x0034;
    L_0x003e:
        r0 = android.view.View.MeasureSpec.getMode(r5);
        r5 = android.view.View.MeasureSpec.getSize(r5);
        if (r0 == r1) goto L_0x0050;
    L_0x0048:
        if (r0 == 0) goto L_0x004b;
    L_0x004a:
        goto L_0x0058;
    L_0x004b:
        r5 = r3.getPreferredHeight();
        goto L_0x0058;
    L_0x0050:
        r0 = r3.getPreferredHeight();
        r5 = java.lang.Math.min(r0, r5);
    L_0x0058:
        r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2);
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2);
        super.onMeasure(r4, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.onMeasure(int, int):void");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof e) {
            e eVar = (e) parcelable;
            super.onRestoreInstanceState(eVar.a());
            a(eVar.a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable eVar = new e(super.onSaveInstanceState());
        eVar.a = c();
        return eVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        q();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.J || !isFocusable()) {
            return false;
        }
        if (c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.a.requestFocus(i, rect);
        if (requestFocus) {
            a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.Q = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            f();
        } else {
            g();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.E != z) {
            this.E = z;
            a(z);
            r();
        }
    }

    public void setImeOptions(int i) {
        this.a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.K = i;
        requestLayout();
    }

    public void setOnCloseListener(b bVar) {
        this.B = bVar;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(c cVar) {
        this.A = cVar;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.D = onClickListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.C = dVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.H = charSequence;
        r();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.I = z;
        if (this.g instanceof ba) {
            ((ba) this.g).a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.h = searchableInfo;
        if (this.h != null) {
            s();
            r();
        }
        this.L = m();
        if (this.L) {
            this.a.setPrivateImeOptions("nm");
        }
        a(c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.G = z;
        a(c());
    }

    public void setSuggestionsAdapter(android.support.v4.widget.d dVar) {
        this.g = dVar;
        this.a.setAdapter(this.g);
    }
}
