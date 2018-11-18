package android.support.v4.h;

import android.view.MotionEvent;

public final class i {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
