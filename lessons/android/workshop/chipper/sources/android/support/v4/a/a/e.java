package android.support.v4.a.a;

import java.lang.reflect.Array;

final class e {
    static final /* synthetic */ boolean a = true;

    private e() {
    }

    public static int a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static int[] a(int[] iArr, int i, int i2) {
        if (a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static <T> T[] a(T[] tArr, int i, T t) {
        if (a || i <= tArr.length) {
            if (i + 1 > tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
                tArr = tArr2;
            }
            tArr[i] = t;
            return tArr;
        }
        throw new AssertionError();
    }
}
