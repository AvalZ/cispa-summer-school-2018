package android.arch.lifecycle;

import android.arch.lifecycle.c.a;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {
    private final b[] a;

    CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        this.a = bVarArr;
    }

    public void a(e eVar, a aVar) {
        i iVar = new i();
        int i = 0;
        for (b a : this.a) {
            a.a(eVar, aVar, false, iVar);
        }
        b[] bVarArr = this.a;
        int length = bVarArr.length;
        while (i < length) {
            bVarArr[i].a(eVar, aVar, true, iVar);
            i++;
        }
    }
}
