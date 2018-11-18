package android.arch.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class a {
    static a a = new a();
    private final Map<Class, a> b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    static class a {
        final Map<android.arch.lifecycle.c.a, List<b>> a = new HashMap();
        final Map<b, android.arch.lifecycle.c.a> b;

        a(Map<b, android.arch.lifecycle.c.a> map) {
            this.b = map;
            for (Entry entry : map.entrySet()) {
                android.arch.lifecycle.c.a aVar = (android.arch.lifecycle.c.a) entry.getValue();
                List list = (List) this.a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(aVar, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void a(List<b> list, e eVar, android.arch.lifecycle.c.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(eVar, aVar, obj);
                }
            }
        }

        void a(e eVar, android.arch.lifecycle.c.a aVar, Object obj) {
            a((List) this.a.get(aVar), eVar, aVar, obj);
            a((List) this.a.get(android.arch.lifecycle.c.a.ON_ANY), eVar, aVar, obj);
        }
    }

    static class b {
        final int a;
        final Method b;

        b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        void a(e eVar, android.arch.lifecycle.c.a aVar, Object obj) {
            try {
                switch (this.a) {
                    case 0:
                        this.b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.b.invoke(obj, new Object[]{eVar});
                        return;
                    case 2:
                        this.b.invoke(obj, new Object[]{eVar, aVar});
                        return;
                    default:
                        return;
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public int hashCode() {
            return (this.a * 31) + this.b.getName().hashCode();
        }
    }

    a() {
    }

    private a a(Class cls, Method[] methodArr) {
        Class superclass = cls.getSuperclass();
        Map hashMap = new HashMap();
        if (superclass != null) {
            a b = b(superclass);
            if (b != null) {
                hashMap.putAll(b.b);
            }
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Entry entry : b(b2).b.entrySet()) {
                a(hashMap, (b) entry.getKey(), (android.arch.lifecycle.c.a) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        int length = methodArr.length;
        int i = 0;
        boolean z = i;
        while (i < length) {
            Method method = methodArr[i];
            l lVar = (l) method.getAnnotation(l.class);
            if (lVar != null) {
                int i2;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(e.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                android.arch.lifecycle.c.a a = lVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(android.arch.lifecycle.c.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a != android.arch.lifecycle.c.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i2 = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new b(i2, method), a, cls);
                z = true;
            }
            i++;
        }
        a aVar = new a(hashMap);
        this.b.put(cls, aVar);
        this.c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    private void a(Map<b, android.arch.lifecycle.c.a> map, b bVar, android.arch.lifecycle.c.a aVar, Class cls) {
        android.arch.lifecycle.c.a aVar2 = (android.arch.lifecycle.c.a) map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(method.getName());
            stringBuilder.append(" in ");
            stringBuilder.append(cls.getName());
            stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
            stringBuilder.append(aVar2);
            stringBuilder.append(", new value ");
            stringBuilder.append(aVar);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Throwable e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    boolean a(Class cls) {
        if (this.c.containsKey(cls)) {
            return ((Boolean) this.c.get(cls)).booleanValue();
        }
        Method[] c = c(cls);
        for (Method annotation : c) {
            if (((l) annotation.getAnnotation(l.class)) != null) {
                a(cls, c);
                return true;
            }
        }
        this.c.put(cls, Boolean.valueOf(false));
        return false;
    }

    a b(Class cls) {
        a aVar = (a) this.b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }
}
