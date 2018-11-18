package android.support.design.widget;

import android.graphics.Outline;

class d extends c {
    d() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
