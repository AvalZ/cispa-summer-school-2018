package android.support.v4.app;

import android.arch.lifecycle.p;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class o implements Parcelable {
    public static final Creator<o> CREATOR = new Creator<o>() {
        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* renamed from: a */
        public o[] newArray(int i) {
            return new o[i];
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    f l;

    o(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        boolean z = false;
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readBundle();
        if (parcel.readInt() != 0) {
            z = true;
        }
        this.j = z;
        this.k = parcel.readBundle();
    }

    o(f fVar) {
        this.a = fVar.getClass().getName();
        this.b = fVar.f;
        this.c = fVar.n;
        this.d = fVar.y;
        this.e = fVar.z;
        this.f = fVar.A;
        this.g = fVar.D;
        this.h = fVar.C;
        this.i = fVar.h;
        this.j = fVar.B;
    }

    public f a(j jVar, h hVar, f fVar, m mVar, p pVar) {
        if (this.l == null) {
            Context g = jVar.g();
            if (this.i != null) {
                this.i.setClassLoader(g.getClassLoader());
            }
            this.l = hVar != null ? hVar.a(g, this.a, this.i) : f.a(g, this.a, this.i);
            if (this.k != null) {
                this.k.setClassLoader(g.getClassLoader());
                this.l.c = this.k;
            }
            this.l.a(this.b, fVar);
            this.l.n = this.c;
            this.l.p = true;
            this.l.y = this.d;
            this.l.z = this.e;
            this.l.A = this.f;
            this.l.D = this.g;
            this.l.C = this.h;
            this.l.B = this.j;
            this.l.s = jVar.b;
            if (l.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Instantiated fragment ");
                stringBuilder.append(this.l);
                Log.v("FragmentManager", stringBuilder.toString());
            }
        }
        this.l.v = mVar;
        this.l.w = pVar;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeBundle(this.i);
        parcel.writeInt(this.j);
        parcel.writeBundle(this.k);
    }
}
