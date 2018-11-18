package android.support.v7.widget;

import android.support.v7.widget.at.p;
import android.support.v7.widget.at.u;
import android.view.View;

class am {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f = 0;
    int g = 0;
    boolean h;
    boolean i;

    am() {
    }

    View a(p pVar) {
        View c = pVar.c(this.c);
        this.c += this.d;
        return c;
    }

    boolean a(u uVar) {
        return this.c >= 0 && this.c < uVar.e();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutState{mAvailable=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mCurrentPosition=");
        stringBuilder.append(this.c);
        stringBuilder.append(", mItemDirection=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mLayoutDirection=");
        stringBuilder.append(this.e);
        stringBuilder.append(", mStartLine=");
        stringBuilder.append(this.f);
        stringBuilder.append(", mEndLine=");
        stringBuilder.append(this.g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
