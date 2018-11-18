package android.support.v4.e;

import android.support.v4.g.k;
import android.util.Base64;
import java.util.List;

public final class a {
    private final String a;
    private final String b;
    private final String c;
    private final List<List<byte[]>> d;
    private final int e = 0;
    private final String f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = (String) k.a((Object) str);
        this.b = (String) k.a((Object) str2);
        this.c = (String) k.a((Object) str3);
        this.d = (List) k.a((Object) list);
        StringBuilder stringBuilder = new StringBuilder(this.a);
        stringBuilder.append("-");
        stringBuilder.append(this.b);
        stringBuilder.append("-");
        stringBuilder.append(this.c);
        this.f = stringBuilder.toString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<List<byte[]>> d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i = 0; i < this.d.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mCertificatesArray: ");
        stringBuilder2.append(this.e);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}
