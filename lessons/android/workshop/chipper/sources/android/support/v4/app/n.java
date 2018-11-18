package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class n implements Parcelable {
    public static final Creator<n> CREATOR = new Creator<n>() {
        /* renamed from: a */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        /* renamed from: a */
        public n[] newArray(int i) {
            return new n[i];
        }
    };
    o[] a;
    int[] b;
    d[] c;
    int d = -1;
    int e;

    public n(Parcel parcel) {
        this.a = (o[]) parcel.createTypedArray(o.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (d[]) parcel.createTypedArray(d.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.a, i);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }
}
