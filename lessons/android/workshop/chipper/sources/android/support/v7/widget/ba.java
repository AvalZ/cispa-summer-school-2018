package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.l;
import android.support.v7.a.a.f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class ba extends l implements OnClickListener {
    private final SearchManager j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView k;
    private final SearchableInfo l;
    private final Context m;
    private final WeakHashMap<String, ConstantState> n;
    private final int o;
    private boolean p = false;
    private int q = 1;
    private ColorStateList r;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;

    private static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.a = (TextView) view.findViewById(16908308);
            this.b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public ba(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.k = searchView;
        this.l = searchableInfo;
        this.o = searchView.getSuggestionCommitIconResId();
        this.m = context;
        this.n = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Object obj = null;
        if (this.n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.m.getResources());
        } else {
            Drawable b = b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable a(String str) {
        Drawable drawable = null;
        if (!(str == null || str.isEmpty())) {
            if ("0".equals(str)) {
                return null;
            }
            try {
                int parseInt = Integer.parseInt(str);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("android.resource://");
                stringBuilder.append(this.m.getPackageName());
                stringBuilder.append("/");
                stringBuilder.append(parseInt);
                String stringBuilder2 = stringBuilder.toString();
                Drawable b = b(stringBuilder2);
                if (b != null) {
                    return b;
                }
                Drawable a = android.support.v4.a.a.a(this.m, parseInt);
                a(stringBuilder2, a);
                return a;
            } catch (NumberFormatException unused) {
                drawable = b(str);
                if (drawable != null) {
                    return drawable;
                }
                drawable = b(Uri.parse(str));
                a(str, drawable);
            } catch (NotFoundException unused2) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Icon resource not found: ");
                stringBuilder3.append(str);
                Log.w("SuggestionsAdapter", stringBuilder3.toString());
                return null;
            }
        }
        return drawable;
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0011 in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    private void a(android.widget.TextView r1, java.lang.CharSequence r2) {
        /*
        r0 = this;
        r1.setText(r2);
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 == 0) goto L_0x000f;
    L_0x0009:
        r0 = 8;
    L_0x000b:
        r1.setVisibility(r0);
        return;
    L_0x000f:
        r0 = 0;
        goto L_0x000b;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ba.a(android.widget.TextView, java.lang.CharSequence):void");
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.n.put(str, drawable.getConstantState());
        }
    }

    private Drawable b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid icon resource ");
            stringBuilder.append(iconResource);
            stringBuilder.append(" for ");
            stringBuilder.append(componentName.flattenToShortString());
            Log.w("SuggestionsAdapter", stringBuilder.toString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable b(Uri uri) {
        StringBuilder stringBuilder;
        InputStream openInputStream;
        StringBuilder stringBuilder2;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return a(uri);
            }
            openInputStream = this.m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to open ");
                stringBuilder2.append(uri);
                throw new FileNotFoundException(stringBuilder2.toString());
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error closing icon stream for ");
                stringBuilder.append(uri);
                Log.e("SuggestionsAdapter", stringBuilder.toString(), e);
                return createFromStream;
            }
        } catch (NotFoundException unused) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Resource does not exist: ");
            stringBuilder2.append(uri);
            throw new FileNotFoundException(stringBuilder2.toString());
        } catch (FileNotFoundException e2) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Icon not found: ");
            stringBuilder3.append(uri);
            stringBuilder3.append(", ");
            stringBuilder3.append(e2.getMessage());
            Log.w("SuggestionsAdapter", stringBuilder3.toString());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error closing icon stream for ");
                stringBuilder.append(uri);
                Log.e("SuggestionsAdapter", stringBuilder.toString(), e3);
            }
        }
    }

    private Drawable b(String str) {
        ConstantState constantState = (ConstantState) this.n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(android.support.v7.a.a.a.textColorSearchUrl, typedValue, true);
            this.r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    private Drawable e(Cursor cursor) {
        if (this.v == -1) {
            return null;
        }
        Drawable a = a(cursor.getString(this.v));
        return a != null ? a : g(cursor);
    }

    private Drawable f(Cursor cursor) {
        return this.w == -1 ? null : a(cursor.getString(this.w));
    }

    private Drawable g(Cursor cursor) {
        Drawable a = a(this.l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String[] strArr = null;
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.k.getVisibility() != 0 || this.k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = a(this.l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable a(Uri uri) {
        String authority = uri.getAuthority();
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(authority)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("No authority: ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("No path: ");
                stringBuilder.append(uri);
                throw new FileNotFoundException(stringBuilder.toString());
            }
            int parseInt;
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Single path segment is not a resource ID: ");
                    stringBuilder.append(uri);
                    throw new FileNotFoundException(stringBuilder.toString());
                }
            } else if (size == 2) {
                parseInt = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("More than two path segments: ");
                stringBuilder.append(uri);
                throw new FileNotFoundException(stringBuilder.toString());
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("No resource found for: ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        } catch (NameNotFoundException unused2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("No package found for authority: ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.a(context, cursor, viewGroup);
        a.setTag(new a(a));
        ((ImageView) a.findViewById(f.edit_query)).setImageResource(this.o);
        return a;
    }

    public void a(int i) {
        this.q = i;
    }

    public void a(Cursor cursor) {
        if (this.p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.s = cursor.getColumnIndex("suggest_text_1");
                this.t = cursor.getColumnIndex("suggest_text_2");
                this.u = cursor.getColumnIndex("suggest_text_2_url");
                this.v = cursor.getColumnIndex("suggest_icon_1");
                this.w = cursor.getColumnIndex("suggest_icon_2");
                this.x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void a(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i = this.x != -1 ? cursor.getInt(this.x) : 0;
        if (aVar.a != null) {
            a(aVar.a, a(cursor, this.s));
        }
        if (aVar.b != null) {
            CharSequence a = a(cursor, this.u);
            a = a != null ? b(a) : a(cursor, this.t);
            if (TextUtils.isEmpty(a)) {
                if (aVar.a != null) {
                    aVar.a.setSingleLine(false);
                    aVar.a.setMaxLines(2);
                }
            } else if (aVar.a != null) {
                aVar.a.setSingleLine(true);
                aVar.a.setMaxLines(1);
            }
            a(aVar.b, a);
        }
        if (aVar.c != null) {
            a(aVar.c, e(cursor), 4);
        }
        if (aVar.d != null) {
            a(aVar.d, f(cursor), 8);
        }
        if (this.q == 2 || (this.q == 1 && (i & 1) != 0)) {
            aVar.e.setVisibility(0);
            aVar.e.setTag(aVar.a.getText());
            aVar.e.setOnClickListener(this);
            return;
        }
        aVar.e.setVisibility(8);
    }

    public CharSequence c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CharSequence a = a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.l.shouldRewriteQueryFromData()) {
            a = a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (this.l.shouldRewriteQueryFromText()) {
            CharSequence a2 = a(cursor, "suggest_text_1");
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View b = b(this.d, this.c, viewGroup);
            if (b != null) {
                ((a) b.getTag()).a.setText(e.toString());
            }
            return b;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = a(this.d, this.c, viewGroup);
            if (a != null) {
                ((a) a.getTag()).a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        d(a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        d(a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.k.a((CharSequence) tag);
        }
    }
}
