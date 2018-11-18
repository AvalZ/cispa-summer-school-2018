package android.arch.lifecycle;

public class o {
    private final a a;
    private final p b;

    public interface a {
        <T extends n> T a(Class<T> cls);
    }

    public o(p pVar, a aVar) {
        this.a = aVar;
        this.b = pVar;
    }

    public <T extends n> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
        stringBuilder.append(canonicalName);
        return a(stringBuilder.toString(), cls);
    }

    public <T extends n> T a(String str, Class<T> cls) {
        T a = this.b.a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        T a2 = this.a.a(cls);
        this.b.a(str, a2);
        return a2;
    }
}
