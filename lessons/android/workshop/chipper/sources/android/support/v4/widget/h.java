package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ImageView;

public class h {
    public static ColorStateList a(ImageView imageView) {
        return VERSION.SDK_INT >= 21 ? imageView.getImageTintList() : imageView instanceof p ? ((p) imageView).getSupportImageTintList() : null;
    }

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (!(drawable == null || obj == null)) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } else if (imageView instanceof p) {
            ((p) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static void a(ImageView imageView, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                Object obj = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? null : 1;
                if (!(drawable == null || obj == null)) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView.getDrawableState());
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        } else if (imageView instanceof p) {
            ((p) imageView).setSupportImageTintMode(mode);
        }
    }

    public static Mode b(ImageView imageView) {
        return VERSION.SDK_INT >= 21 ? imageView.getImageTintMode() : imageView instanceof p ? ((p) imageView).getSupportImageTintMode() : null;
    }
}
