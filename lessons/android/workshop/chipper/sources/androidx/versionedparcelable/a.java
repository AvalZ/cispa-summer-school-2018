package androidx.versionedparcelable;

import android.os.Parcelable;

public abstract class a {
    protected static <T extends c> T a(String str, a aVar) {
        try {
            return (c) Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[]{a.class}).invoke(null, new Object[]{aVar});
        } catch (Throwable e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (Throwable e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e22);
        } catch (Throwable e222) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e222);
        }
    }

    private static Class a(Class<? extends c> cls) {
        return Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
    }

    protected static <T extends c> void a(T t, a aVar) {
        try {
            c((c) t).getDeclaredMethod("write", new Class[]{t.getClass(), a.class}).invoke(null, new Object[]{t, aVar});
        } catch (Throwable e) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
        } catch (Throwable e2) {
            if (e2.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e2.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e2);
        } catch (Throwable e22) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e22);
        } catch (Throwable e222) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e222);
        }
    }

    private void b(c cVar) {
        try {
            a(a(cVar.getClass()).getName());
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cVar.getClass().getSimpleName());
            stringBuilder.append(" does not have a Parcelizer");
            throw new RuntimeException(stringBuilder.toString(), e);
        }
    }

    private static <T extends c> Class c(T t) {
        return a(t.getClass());
    }

    protected abstract void a(int i);

    public void a(int i, int i2) {
        c(i2);
        a(i);
    }

    protected abstract void a(Parcelable parcelable);

    public void a(Parcelable parcelable, int i) {
        c(i);
        a(parcelable);
    }

    protected void a(c cVar) {
        if (cVar == null) {
            a(null);
            return;
        }
        b(cVar);
        this = c();
        a(cVar, this);
        this.b();
    }

    protected abstract void a(String str);

    public void a(String str, int i) {
        c(i);
        a(str);
    }

    public void a(boolean z, boolean z2) {
    }

    protected abstract void a(byte[] bArr);

    public void a(byte[] bArr, int i) {
        c(i);
        a(bArr);
    }

    public boolean a() {
        return false;
    }

    public int b(int i, int i2) {
        return !b(i2) ? i : d();
    }

    public <T extends Parcelable> T b(T t, int i) {
        return !b(i) ? t : g();
    }

    public String b(String str, int i) {
        return !b(i) ? str : e();
    }

    protected abstract void b();

    protected abstract boolean b(int i);

    public byte[] b(byte[] bArr, int i) {
        return !b(i) ? bArr : f();
    }

    protected abstract a c();

    protected abstract void c(int i);

    protected abstract int d();

    protected abstract String e();

    protected abstract byte[] f();

    protected abstract <T extends Parcelable> T g();

    protected <T extends c> T h() {
        String e = e();
        return e == null ? null : a(e, c());
    }
}
