package android.support.v4.f;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class e {
    private static final Locale a = new Locale("", "");

    public static int a(Locale locale) {
        if (VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (!(locale == null || locale.equals(a))) {
            String a = a.a(locale);
            if (a == null) {
                return b(locale);
            }
            if (a.equalsIgnoreCase("Arab") || a.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }

    private static int b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case (byte) 1:
            case (byte) 2:
                return 1;
            default:
                return 0;
        }
    }
}
