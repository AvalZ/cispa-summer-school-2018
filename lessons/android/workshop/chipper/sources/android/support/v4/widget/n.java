package android.support.v4.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.support.v4.g.k;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class n {

    private static class a implements Callback {
        private final Callback a;
        private final TextView b;
        private Class c;
        private Method d;
        private boolean e;
        private boolean f = false;

        a(Callback callback, TextView textView) {
            this.a = callback;
            this.b = textView;
        }

        private Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        private Intent a(ResolveInfo resolveInfo, TextView textView) {
            return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", a(textView) ^ 1).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private List<ResolveInfo> a(Context context, PackageManager packageManager) {
            List<ResolveInfo> arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (a(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad A:{RETURN, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException), Splitter: B:6:0x0034} */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00ad A:{RETURN, ExcHandler: java.lang.NoSuchMethodException (unused java.lang.NoSuchMethodException), Splitter: B:6:0x0034} */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x002d A:{ExcHandler: java.lang.ClassNotFoundException (unused java.lang.ClassNotFoundException), Splitter: B:3:0x0012} */
        /* JADX WARNING: Missing block: B:5:0x002d, code:
            r8.c = null;
            r8.d = null;
            r8.e = false;
     */
        /* JADX WARNING: Missing block: B:25:0x00ad, code:
            return;
     */
        private void a(android.view.Menu r9) {
            /*
            r8 = this;
            r0 = r8.b;
            r0 = r0.getContext();
            r1 = r0.getPackageManager();
            r2 = r8.f;
            r3 = 0;
            r4 = 1;
            if (r2 != 0) goto L_0x0034;
        L_0x0010:
            r8.f = r4;
            r2 = "com.android.internal.view.menu.MenuBuilder";
            r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.c = r2;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r2 = r8.c;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r5 = "removeItemAt";
            r6 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r7 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r6[r3] = r7;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r2 = r2.getDeclaredMethod(r5, r6);	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.d = r2;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            r8.e = r4;	 Catch:{ ClassNotFoundException -> 0x002d, ClassNotFoundException -> 0x002d }
            goto L_0x0034;
        L_0x002d:
            r2 = 0;
            r8.c = r2;
            r8.d = r2;
            r8.e = r3;
        L_0x0034:
            r2 = r8.e;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            if (r2 == 0) goto L_0x0043;
        L_0x0038:
            r2 = r8.c;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r2 = r2.isInstance(r9);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            if (r2 == 0) goto L_0x0043;
        L_0x0040:
            r2 = r8.d;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            goto L_0x0053;
        L_0x0043:
            r2 = r9.getClass();	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r5 = "removeItemAt";
            r6 = new java.lang.Class[r4];	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r7 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r6[r3] = r7;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r2 = r2.getDeclaredMethod(r5, r6);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
        L_0x0053:
            r5 = r9.size();	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r5 = r5 - r4;
        L_0x0058:
            if (r5 < 0) goto L_0x0082;
        L_0x005a:
            r6 = r9.getItem(r5);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r7 = r6.getIntent();	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            if (r7 == 0) goto L_0x007f;
        L_0x0064:
            r7 = "android.intent.action.PROCESS_TEXT";
            r6 = r6.getIntent();	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r6 = r6.getAction();	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r6 = r7.equals(r6);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            if (r6 == 0) goto L_0x007f;
        L_0x0074:
            r6 = new java.lang.Object[r4];	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r7 = java.lang.Integer.valueOf(r5);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r6[r3] = r7;	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
            r2.invoke(r9, r6);	 Catch:{ NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad, NoSuchMethodException -> 0x00ad }
        L_0x007f:
            r5 = r5 + -1;
            goto L_0x0058;
        L_0x0082:
            r0 = r8.a(r0, r1);
            r2 = r3;
        L_0x0087:
            r5 = r0.size();
            if (r2 >= r5) goto L_0x00ad;
        L_0x008d:
            r5 = r0.get(r2);
            r5 = (android.content.pm.ResolveInfo) r5;
            r6 = r2 + 100;
            r7 = r5.loadLabel(r1);
            r6 = r9.add(r3, r3, r6, r7);
            r7 = r8.b;
            r5 = r8.a(r5, r7);
            r5 = r6.setIntent(r5);
            r5.setShowAsAction(r4);
            r2 = r2 + 1;
            goto L_0x0087;
        L_0x00ad:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.n.a.a(android.view.Menu):void");
        }

        private boolean a(ResolveInfo resolveInfo, Context context) {
            boolean z = true;
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (!resolveInfo.activityInfo.exported) {
                return false;
            }
            if (resolveInfo.activityInfo.permission != null) {
                if (context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0) {
                    return true;
                }
                z = false;
            }
            return z;
        }

        private boolean a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.a.onActionItemClicked(actionMode, menuItem);
        }

        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.a.onCreateActionMode(actionMode, menu);
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            this.a.onDestroyActionMode(actionMode);
        }

        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            a(menu);
            return this.a.onPrepareActionMode(actionMode, menu);
        }
    }

    private static int a(TextDirectionHeuristic textDirectionHeuristic) {
        return (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) ? 1 : textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR ? 2 : textDirectionHeuristic == TextDirectionHeuristics.LTR ? 3 : textDirectionHeuristic == TextDirectionHeuristics.RTL ? 4 : textDirectionHeuristic == TextDirectionHeuristics.LOCALE ? 5 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR ? 6 : textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    /* JADX WARNING: Missing block: B:9:0x0017, code:
            return r3;
     */
    public static android.view.ActionMode.Callback a(android.widget.TextView r2, android.view.ActionMode.Callback r3) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 26;
        if (r0 < r1) goto L_0x0017;
    L_0x0006:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 27;
        if (r0 > r1) goto L_0x0017;
    L_0x000c:
        r0 = r3 instanceof android.support.v4.widget.n.a;
        if (r0 == 0) goto L_0x0011;
    L_0x0010:
        return r3;
    L_0x0011:
        r0 = new android.support.v4.widget.n$a;
        r0.<init>(r3, r2);
        return r0;
    L_0x0017:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.n.a(android.widget.TextView, android.view.ActionMode$Callback):android.view.ActionMode$Callback");
    }

    public static void a(TextView textView, int i) {
        if (VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (VERSION.SDK_INT >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (VERSION.SDK_INT >= 17) {
            Object obj = 1;
            if (textView.getLayoutDirection() != 1) {
                obj = null;
            }
            Drawable drawable5 = obj != null ? drawable3 : drawable;
            if (obj == null) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void a(TextView textView, android.support.v4.f.b.a aVar) {
        if (VERSION.SDK_INT >= 18) {
            textView.setTextDirection(a(aVar.b()));
        }
        if (VERSION.SDK_INT < 23) {
            float textScaleX = aVar.a().getTextScaleX();
            textView.getPaint().set(aVar.a());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.a());
        textView.setBreakStrategy(aVar.c());
        textView.setHyphenationFrequency(aVar.d());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:9:0x0024 in {2, 4, 8} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    public static void a(android.widget.TextView r2, android.support.v4.f.b r3) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 28;
        if (r0 < r1) goto L_0x000e;
    L_0x0006:
        r3 = r3.a();
    L_0x000a:
        r2.setText(r3);
        return;
    L_0x000e:
        r0 = d(r2);
        r1 = r3.b();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x000a;
    L_0x001c:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Given text can not be applied to TextView.";
        r2.<init>(r3);
        throw r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.n.a(android.widget.TextView, android.support.v4.f.b):void");
    }

    public static Drawable[] a(TextView textView) {
        if (VERSION.SDK_INT >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (VERSION.SDK_INT < 17) {
            return textView.getCompoundDrawables();
        }
        int i = 1;
        if (textView.getLayoutDirection() != 1) {
            i = 0;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (i != 0) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static void b(TextView textView, int i) {
        k.a(i);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i - (-i2), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void c(TextView textView, int i) {
        k.a(i);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = (VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static android.support.v4.f.b.a d(TextView textView) {
        if (VERSION.SDK_INT >= 28) {
            return new android.support.v4.f.b.a(textView.getTextMetricsParams());
        }
        android.support.v4.f.b.a.a aVar = new android.support.v4.f.b.a.a(new TextPaint(textView.getPaint()));
        if (VERSION.SDK_INT >= 23) {
            aVar.a(textView.getBreakStrategy());
            aVar.b(textView.getHyphenationFrequency());
        }
        if (VERSION.SDK_INT >= 18) {
            aVar.a(e(textView));
        }
        return aVar.a();
    }

    public static void d(TextView textView, int i) {
        k.a(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing((float) (i - fontMetricsInt), 1.0f);
        }
    }

    private static TextDirectionHeuristic e(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        int i = 1;
        if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() != 1) {
                i = 0;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    return TextDirectionHeuristics.ANYRTL_LTR;
                case 3:
                    return TextDirectionHeuristics.LTR;
                case 4:
                    return TextDirectionHeuristics.RTL;
                case 5:
                    return TextDirectionHeuristics.LOCALE;
                case 6:
                    return TextDirectionHeuristics.FIRSTSTRONG_LTR;
                case 7:
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                default:
                    return i != 0 ? TextDirectionHeuristics.FIRSTSTRONG_RTL : TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == (byte) 1 || directionality == (byte) 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
    }
}
