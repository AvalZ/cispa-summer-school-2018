package android.support.v4.g;

public class d {
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:12:0x003f in {1, 3, 7, 10, 11} preds:[]
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
    public static void a(java.lang.Object r2, java.lang.StringBuilder r3) {
        /*
        if (r2 != 0) goto L_0x0008;
    L_0x0002:
        r2 = "null";
    L_0x0004:
        r3.append(r2);
        return;
    L_0x0008:
        r0 = r2.getClass();
        r0 = r0.getSimpleName();
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r1 = r0.length();
        if (r1 > 0) goto L_0x002e;
    L_0x0018:
        r0 = r2.getClass();
        r0 = r0.getName();
        r1 = 46;
        r1 = r0.lastIndexOf(r1);
        if (r1 <= 0) goto L_0x002e;
    L_0x0028:
        r1 = r1 + 1;
        r0 = r0.substring(r1);
    L_0x002e:
        r3.append(r0);
        r0 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r3.append(r0);
        r2 = java.lang.System.identityHashCode(r2);
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0004;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.g.d.a(java.lang.Object, java.lang.StringBuilder):void");
    }
}
