package android.support.v4.d;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b implements Parcelable {
    public static final Creator<b> CREATOR = new Creator<b>() {
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* renamed from: a */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    final boolean a = false;
    final Handler b = null;
    a c;

    class b implements Runnable {
        final int a;
        final Bundle b;

        b(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        public void run() {
            b.this.a(this.a, this.b);
        }
    }

    class a extends android.support.v4.d.a.a {
        a() {
        }

        public void a(int i, Bundle bundle) {
            if (b.this.b != null) {
                b.this.b.post(new b(i, bundle));
            } else {
                b.this.a(i, bundle);
            }
        }
    }

    b(Parcel parcel) {
        this.c = android.support.v4.d.a.a.a(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
