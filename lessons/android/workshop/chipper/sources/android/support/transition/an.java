package android.support.transition;

import android.graphics.Matrix;
import android.support.transition.r.a;
import android.view.View;
import android.view.ViewParent;

class an implements as {
    an() {
    }

    public al a(View view) {
        return aj.d(view);
    }

    public void a(View view, float f) {
        Float f2 = (Float) view.getTag(a.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }

    public void a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public aw b(View view) {
        return new au(view.getWindowToken());
    }

    public void b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    public float c(View view) {
        Float f = (Float) view.getTag(a.save_non_transition_alpha);
        return f != null ? view.getAlpha() / f.floatValue() : view.getAlpha();
    }

    public void d(View view) {
        if (view.getTag(a.save_non_transition_alpha) == null) {
            view.setTag(a.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(a.save_non_transition_alpha, null);
        }
    }
}
