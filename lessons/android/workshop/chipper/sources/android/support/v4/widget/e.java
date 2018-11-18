package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class e extends Filter {
    a a;

    interface a {
        Cursor a();

        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence c(Cursor cursor);
    }

    e(a aVar) {
        this.a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.a.c((Cursor) obj);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x001b in {2, 4, 5} preds:[]
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
    protected android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r2) {
        /*
        r1 = this;
        r1 = r1.a;
        r1 = r1.a(r2);
        r2 = new android.widget.Filter$FilterResults;
        r2.<init>();
        if (r1 == 0) goto L_0x0016;
    L_0x000d:
        r0 = r1.getCount();
        r2.count = r0;
    L_0x0013:
        r2.values = r1;
        return r2;
    L_0x0016:
        r1 = 0;
        r2.count = r1;
        r1 = 0;
        goto L_0x0013;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.e.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.a.a();
        if (filterResults.values != null && filterResults.values != a) {
            this.a.a((Cursor) filterResults.values);
        }
    }
}
