package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

class b extends a {
    private final SparseIntArray a;
    private final Parcel b;
    private final int c;
    private final int d;
    private final String e;
    private int f;
    private int g;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    b(Parcel parcel, int i, int i2, String str) {
        this.a = new SparseIntArray();
        this.f = -1;
        this.g = 0;
        this.b = parcel;
        this.c = i;
        this.d = i2;
        this.g = this.c;
        this.e = str;
    }

    private int d(int i) {
        while (this.g < this.d) {
            this.b.setDataPosition(this.g);
            int readInt = this.b.readInt();
            int readInt2 = this.b.readInt();
            this.g += readInt;
            if (readInt2 == i) {
                return this.b.dataPosition();
            }
        }
        return -1;
    }

    public void a(int i) {
        this.b.writeInt(i);
    }

    public void a(Parcelable parcelable) {
        this.b.writeParcelable(parcelable, 0);
    }

    public void a(String str) {
        this.b.writeString(str);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.b.writeInt(bArr.length);
            this.b.writeByteArray(bArr);
            return;
        }
        this.b.writeInt(-1);
    }

    public void b() {
        if (this.f >= 0) {
            int i = this.a.get(this.f);
            int dataPosition = this.b.dataPosition();
            int i2 = dataPosition - i;
            this.b.setDataPosition(i);
            this.b.writeInt(i2);
            this.b.setDataPosition(dataPosition);
        }
    }

    public boolean b(int i) {
        i = d(i);
        if (i == -1) {
            return false;
        }
        this.b.setDataPosition(i);
        return true;
    }

    protected a c() {
        Parcel parcel = this.b;
        int dataPosition = this.b.dataPosition();
        int i = this.g == this.c ? this.d : this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append("  ");
        return new b(parcel, dataPosition, i, stringBuilder.toString());
    }

    public void c(int i) {
        b();
        this.f = i;
        this.a.put(i, this.b.dataPosition());
        a(0);
        a(i);
    }

    public int d() {
        return this.b.readInt();
    }

    public String e() {
        return this.b.readString();
    }

    public byte[] f() {
        int readInt = this.b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.b.readByteArray(bArr);
        return bArr;
    }

    public <T extends Parcelable> T g() {
        return this.b.readParcelable(getClass().getClassLoader());
    }
}
