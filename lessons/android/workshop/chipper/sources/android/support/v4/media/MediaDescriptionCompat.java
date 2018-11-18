package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final String a;
    private final CharSequence b;
    private final CharSequence c;
    private final CharSequence d;
    private final Bitmap e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    public static final class a {
        private String a;
        private CharSequence b;
        private CharSequence c;
        private CharSequence d;
        private Bitmap e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public a a(String str) {
            this.a = str;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.e = (Bitmap) parcel.readParcelable(null);
        this.f = (Uri) parcel.readParcelable(null);
        this.g = parcel.readBundle();
        this.h = (Uri) parcel.readParcelable(null);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.a = str;
        this.b = charSequence;
        this.c = charSequence2;
        this.d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r6) {
        /*
        r0 = 0;
        if (r6 == 0) goto L_0x0081;
    L_0x0003:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 21;
        if (r1 < r2) goto L_0x0081;
    L_0x0009:
        r1 = new android.support.v4.media.MediaDescriptionCompat$a;
        r1.<init>();
        r2 = android.support.v4.media.a.a(r6);
        r1.a(r2);
        r2 = android.support.v4.media.a.b(r6);
        r1.a(r2);
        r2 = android.support.v4.media.a.c(r6);
        r1.b(r2);
        r2 = android.support.v4.media.a.d(r6);
        r1.c(r2);
        r2 = android.support.v4.media.a.e(r6);
        r1.a(r2);
        r2 = android.support.v4.media.a.f(r6);
        r1.a(r2);
        r2 = android.support.v4.media.a.g(r6);
        if (r2 != 0) goto L_0x0040;
    L_0x003e:
        r3 = r0;
        goto L_0x0048;
    L_0x0040:
        r3 = "android.support.v4.media.description.MEDIA_URI";
        r3 = r2.getParcelable(r3);
        r3 = (android.net.Uri) r3;
    L_0x0048:
        if (r3 == 0) goto L_0x0064;
    L_0x004a:
        r4 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
        r4 = r2.containsKey(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0052:
        r4 = r2.size();
        r5 = 2;
        if (r4 != r5) goto L_0x005a;
    L_0x0059:
        goto L_0x0065;
    L_0x005a:
        r0 = "android.support.v4.media.description.MEDIA_URI";
        r2.remove(r0);
        r0 = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
        r2.remove(r0);
    L_0x0064:
        r0 = r2;
    L_0x0065:
        r1.a(r0);
        if (r3 == 0) goto L_0x006e;
    L_0x006a:
        r1.b(r3);
        goto L_0x007b;
    L_0x006e:
        r0 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        if (r0 < r2) goto L_0x007b;
    L_0x0074:
        r0 = android.support.v4.media.b.h(r6);
        r1.b(r0);
    L_0x007b:
        r0 = r1.a();
        r0.i = r6;
    L_0x0081:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object a() {
        if (this.i != null || VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a = a.a();
        a.a(a, this.a);
        a.a(a, this.b);
        a.b(a, this.c);
        a.c(a, this.d);
        a.a(a, this.e);
        a.a(a, this.f);
        Bundle bundle = this.g;
        if (VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.a(a, bundle);
        if (VERSION.SDK_INT >= 23) {
            a.b(a, this.h);
        }
        this.i = a.a(a);
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.a);
            TextUtils.writeToParcel(this.b, parcel, i);
            TextUtils.writeToParcel(this.c, parcel, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        a.a(a(), parcel, i);
    }
}
