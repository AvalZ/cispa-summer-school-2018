package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class d implements Parcelable {
    public static final Creator<d> CREATOR = new Creator<d>() {
        /* renamed from: a */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        /* renamed from: a */
        public d[] newArray(int i) {
            return new d[i];
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public d(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        this.l = parcel.readInt() != 0;
    }

    public d(c cVar) {
        int size = cVar.b.size();
        this.a = new int[(size * 6)];
        if (cVar.i) {
            int i = 0;
            int i2 = 0;
            while (i < size) {
                a aVar = (a) cVar.b.get(i);
                int i3 = i2 + 1;
                this.a[i2] = aVar.a;
                int i4 = i3 + 1;
                this.a[i3] = aVar.b != null ? aVar.b.f : -1;
                i3 = i4 + 1;
                this.a[i4] = aVar.c;
                i4 = i3 + 1;
                this.a[i3] = aVar.d;
                i3 = i4 + 1;
                this.a[i4] = aVar.e;
                i4 = i3 + 1;
                this.a[i3] = aVar.f;
                i++;
                i2 = i4;
            }
            this.b = cVar.g;
            this.c = cVar.h;
            this.d = cVar.k;
            this.e = cVar.m;
            this.f = cVar.n;
            this.g = cVar.o;
            this.h = cVar.p;
            this.i = cVar.q;
            this.j = cVar.r;
            this.k = cVar.s;
            this.l = cVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public c a(l lVar) {
        c cVar = new c(lVar);
        int i = 0;
        int i2 = 0;
        while (i < this.a.length) {
            a aVar = new a();
            int i3 = i + 1;
            aVar.a = this.a[i];
            if (l.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Instantiate ");
                stringBuilder.append(cVar);
                stringBuilder.append(" op #");
                stringBuilder.append(i2);
                stringBuilder.append(" base fragment #");
                stringBuilder.append(this.a[i3]);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            int i4 = i3 + 1;
            i = this.a[i3];
            aVar.b = i >= 0 ? (f) lVar.f.get(i) : null;
            i3 = i4 + 1;
            aVar.c = this.a[i4];
            i4 = i3 + 1;
            aVar.d = this.a[i3];
            i3 = i4 + 1;
            aVar.e = this.a[i4];
            i4 = i3 + 1;
            aVar.f = this.a[i3];
            cVar.c = aVar.c;
            cVar.d = aVar.d;
            cVar.e = aVar.e;
            cVar.f = aVar.f;
            cVar.a(aVar);
            i2++;
            i = i4;
        }
        cVar.g = this.b;
        cVar.h = this.c;
        cVar.k = this.d;
        cVar.m = this.e;
        cVar.i = true;
        cVar.n = this.f;
        cVar.o = this.g;
        cVar.p = this.h;
        cVar.q = this.i;
        cVar.r = this.j;
        cVar.s = this.k;
        cVar.t = this.l;
        cVar.a(1);
        return cVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
        parcel.writeStringList(this.j);
        parcel.writeStringList(this.k);
        parcel.writeInt(this.l);
    }
}
