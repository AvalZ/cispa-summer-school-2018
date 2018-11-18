package android.support.v4.h.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class c {
    private final Object a;

    static class a extends AccessibilityNodeProvider {
        final c a;

        a(c cVar) {
            this.a = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            b a = this.a.a(i);
            return a == null ? null : a.a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List a = this.a.a(str, i);
            if (a == null) {
                return null;
            }
            List<AccessibilityNodeInfo> arrayList = new ArrayList();
            i = a.size();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(((b) a.get(i2)).a());
            }
            return arrayList;
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.a(i, i2, bundle);
        }
    }

    static class b extends a {
        b(c cVar) {
            super(cVar);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            b b = this.a.b(i);
            return b == null ? null : b.a();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:9:0x001f in {2, 4, 7, 8} preds:[]
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
    public c() {
        /*
        r2 = this;
        r2.<init>();
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 < r1) goto L_0x0011;
    L_0x0009:
        r0 = new android.support.v4.h.a.c$b;
        r0.<init>(r2);
    L_0x000e:
        r2.a = r0;
        return;
    L_0x0011:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x001d;
    L_0x0017:
        r0 = new android.support.v4.h.a.c$a;
        r0.<init>(r2);
        goto L_0x000e;
    L_0x001d:
        r0 = 0;
        goto L_0x000e;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.h.a.c.<init>():void");
    }

    public c(Object obj) {
        this.a = obj;
    }

    public b a(int i) {
        return null;
    }

    public Object a() {
        return this.a;
    }

    public List<b> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public b b(int i) {
        return null;
    }
}
