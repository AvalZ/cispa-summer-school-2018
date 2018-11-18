package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

interface k {
    <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path);
}
