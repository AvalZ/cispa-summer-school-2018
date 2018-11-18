package android.support.v4.f;

import android.os.Build.VERSION;
import android.support.v4.g.i;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

public class b implements Spannable {
    private static final Object a = new Object();
    private static Executor b;
    private final Spannable c;
    private final a d;
    private final PrecomputedText e;

    public static final class a {
        final Params a;
        private final TextPaint b;
        private final TextDirectionHeuristic c;
        private final int d;
        private final int e;

        public static class a {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:10:0x0023 in {2, 3, 6, 8, 9} preds:[]
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:238)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
                	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
                	at jadx.core.ProcessClass.process(ProcessClass.java:32)
                	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
                	at jadx.api.JavaClass.decompile(JavaClass.java:62)
                	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
                */
            public a(android.text.TextPaint r2) {
                /*
                r1 = this;
                r1.<init>();
                r1.a = r2;
                r2 = android.os.Build.VERSION.SDK_INT;
                r0 = 23;
                if (r2 < r0) goto L_0x0011;
            L_0x000b:
                r2 = 1;
                r1.c = r2;
                r1.d = r2;
                goto L_0x0016;
            L_0x0011:
                r2 = 0;
                r1.d = r2;
                r1.c = r2;
            L_0x0016:
                r2 = android.os.Build.VERSION.SDK_INT;
                r0 = 18;
                if (r2 < r0) goto L_0x0021;
            L_0x001c:
                r2 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR;
            L_0x001e:
                r1.b = r2;
                return;
            L_0x0021:
                r2 = 0;
                goto L_0x001e;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.b.a.a.<init>(android.text.TextPaint):void");
            }

            public a a(int i) {
                this.c = i;
                return this;
            }

            public a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.a, this.b, this.c, this.d);
            }

            public a b(int i) {
                this.d = i;
                return this;
            }
        }

        public a(Params params) {
            this.b = params.getTextPaint();
            this.c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.a = params;
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.a = VERSION.SDK_INT >= 28 ? new Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build() : null;
            this.b = textPaint;
            this.c = textDirectionHeuristic;
            this.d = i;
            this.e = i2;
        }

        public TextPaint a() {
            return this.b;
        }

        public TextDirectionHeuristic b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.a != null) {
                return this.a.equals(aVar.a);
            }
            if (VERSION.SDK_INT >= 23 && (this.d != aVar.c() || this.e != aVar.d())) {
                return false;
            }
            if ((VERSION.SDK_INT >= 18 && this.c != aVar.b()) || this.b.getTextSize() != aVar.a().getTextSize() || this.b.getTextScaleX() != aVar.a().getTextScaleX() || this.b.getTextSkewX() != aVar.a().getTextSkewX()) {
                return false;
            }
            if ((VERSION.SDK_INT >= 21 && (this.b.getLetterSpacing() != aVar.a().getLetterSpacing() || !TextUtils.equals(this.b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) || this.b.getFlags() != aVar.a().getFlags()) {
                return false;
            }
            if (VERSION.SDK_INT >= 24) {
                if (!this.b.getTextLocales().equals(aVar.a().getTextLocales())) {
                    return false;
                }
            } else if (VERSION.SDK_INT >= 17 && !this.b.getTextLocale().equals(aVar.a().getTextLocale())) {
                return false;
            }
            if (this.b.getTypeface() == null) {
                if (aVar.a().getTypeface() != null) {
                    return false;
                }
            } else if (!this.b.getTypeface().equals(aVar.a().getTypeface())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object[] objArr = VERSION.SDK_INT >= 24 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocales(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : VERSION.SDK_INT >= 21 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Float.valueOf(this.b.getLetterSpacing()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), Boolean.valueOf(this.b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : VERSION.SDK_INT >= 18 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : VERSION.SDK_INT >= 17 ? new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTextLocale(), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)} : new Object[]{Float.valueOf(this.b.getTextSize()), Float.valueOf(this.b.getTextScaleX()), Float.valueOf(this.b.getTextSkewX()), Integer.valueOf(this.b.getFlags()), this.b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e)};
            return i.a(objArr);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x00e7  */
        public java.lang.String toString() {
            /*
            r3 = this;
            r0 = new java.lang.StringBuilder;
            r1 = "{";
            r0.<init>(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "textSize=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTextSize();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", textScaleX=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTextScaleX();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", textSkewX=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTextSkewX();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = android.os.Build.VERSION.SDK_INT;
            r2 = 21;
            if (r1 < r2) goto L_0x008f;
        L_0x005b:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", letterSpacing=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getLetterSpacing();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", elegantTextHeight=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.isElegantTextHeight();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
        L_0x008f:
            r1 = android.os.Build.VERSION.SDK_INT;
            r2 = 24;
            if (r1 < r2) goto L_0x00b0;
        L_0x0095:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", textLocale=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTextLocales();
        L_0x00a5:
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            goto L_0x00c7;
        L_0x00b0:
            r1 = android.os.Build.VERSION.SDK_INT;
            r2 = 17;
            if (r1 < r2) goto L_0x00c7;
        L_0x00b6:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", textLocale=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTextLocale();
            goto L_0x00a5;
        L_0x00c7:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", typeface=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getTypeface();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = android.os.Build.VERSION.SDK_INT;
            r2 = 26;
            if (r1 < r2) goto L_0x0101;
        L_0x00e7:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", variationSettings=";
            r1.append(r2);
            r2 = r3.b;
            r2 = r2.getFontVariationSettings();
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
        L_0x0101:
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", textDir=";
            r1.append(r2);
            r2 = r3.c;
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", breakStrategy=";
            r1.append(r2);
            r2 = r3.d;
            r1.append(r2);
            r1 = r1.toString();
            r0.append(r1);
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = ", hyphenationFrequency=";
            r1.append(r2);
            r3 = r3.e;
            r1.append(r3);
            r3 = r1.toString();
            r0.append(r3);
            r3 = "}";
            r0.append(r3);
            r3 = r0.toString();
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.f.b.a.toString():java.lang.String");
        }
    }

    public PrecomputedText a() {
        return this.c instanceof PrecomputedText ? (PrecomputedText) this.c : null;
    }

    public a b() {
        return this.d;
    }

    public char charAt(int i) {
        return this.c.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return VERSION.SDK_INT >= 28 ? this.e.getSpans(i, i2, cls) : this.c.getSpans(i, i2, cls);
    }

    public int length() {
        return this.c.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (VERSION.SDK_INT >= 28) {
            this.e.removeSpan(obj);
        } else {
            this.c.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (VERSION.SDK_INT >= 28) {
            this.e.setSpan(obj, i, i2, i3);
        } else {
            this.c.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    public String toString() {
        return this.c.toString();
    }
}
