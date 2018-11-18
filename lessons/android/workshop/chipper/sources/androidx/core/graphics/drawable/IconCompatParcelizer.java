package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = aVar.b(iconCompat.a, 1);
        iconCompat.c = aVar.b(iconCompat.c, 2);
        iconCompat.d = aVar.b(iconCompat.d, 3);
        iconCompat.e = aVar.b(iconCompat.e, 4);
        iconCompat.f = aVar.b(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.b(iconCompat.g, 6);
        iconCompat.j = aVar.b(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.a());
        aVar.a(iconCompat.a, 1);
        aVar.a(iconCompat.c, 2);
        aVar.a(iconCompat.d, 3);
        aVar.a(iconCompat.e, 4);
        aVar.a(iconCompat.f, 5);
        aVar.a(iconCompat.g, 6);
        aVar.a(iconCompat.j, 7);
    }
}
