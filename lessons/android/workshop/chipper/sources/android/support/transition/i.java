package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class i implements k {
    i() {
    }

    public <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new m(property, path), new float[]{0.0f, 1.0f});
    }
}
