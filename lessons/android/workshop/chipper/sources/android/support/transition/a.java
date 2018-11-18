package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a {
    private static final d a;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0014 in {2, 4, 5} preds:[]
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
    static {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 < r1) goto L_0x000e;
    L_0x0006:
        r0 = new android.support.transition.c;
        r0.<init>();
    L_0x000b:
        a = r0;
        return;
    L_0x000e:
        r0 = new android.support.transition.b;
        r0.<init>();
        goto L_0x000b;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.a.<clinit>():void");
    }

    static void a(Animator animator) {
        a.a(animator);
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        a.a(animator, animatorListenerAdapter);
    }

    static void b(Animator animator) {
        a.b(animator);
    }
}
