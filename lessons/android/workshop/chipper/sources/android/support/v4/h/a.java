package android.support.v4.h;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;

public abstract class a implements Parcelable {
    public static final Creator<a> CREATOR = new ClassLoaderCreator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.d;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public static final a d = new a() {
    };
    private final Parcelable a;

    private a() {
        this.a = null;
    }

    protected a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = d;
        }
        this.a = readParcelable;
    }

    protected a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == d) {
            parcelable = null;
        }
        this.a = parcelable;
    }

    public final Parcelable a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
    }
}
