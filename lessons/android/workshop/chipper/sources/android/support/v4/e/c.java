package android.support.v4.e;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    private final Object a = new Object();
    private HandlerThread b;
    private Handler c;
    private int d;
    private Callback e = new Callback() {
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    c.this.a();
                    return true;
                case 1:
                    c.this.a((Runnable) message.obj);
                    return true;
                default:
                    return true;
            }
        }
    };
    private final int f;
    private final int g;
    private final String h;

    public interface a<T> {
        void a(T t);
    }

    public c(String str, int i, int i2) {
        this.h = str;
        this.g = i;
        this.f = i2;
        this.d = 0;
    }

    private void b(Runnable runnable) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new HandlerThread(this.h, this.g);
                this.b.start();
                this.c = new Handler(this.b.getLooper(), this.e);
                this.d++;
            }
            this.c.removeMessages(0);
            this.c.sendMessage(this.c.obtainMessage(1, runnable));
        }
    }

    public <T> T a(Callable<T> callable, int i) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicReference atomicReference2 = atomicReference;
        final Callable<T> callable2 = callable;
        final ReentrantLock reentrantLock2 = reentrantLock;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        final Condition condition = newCondition;
        b(new Runnable() {
            public void run() {
                try {
                    atomicReference2.set(callable2.call());
                } catch (Exception unused) {
                    reentrantLock2.lock();
                    atomicBoolean2.set(false);
                    condition.signal();
                } finally {
                    reentrantLock2.unlock();
                }
            }
        });
        reentrantLock.lock();
        long toNanos;
        T t;
        try {
            if (atomicBoolean.get()) {
                toNanos = TimeUnit.MILLISECONDS.toNanos((long) i);
                while (true) {
                    toNanos = newCondition.awaitNanos(toNanos);
                }
                return t;
            }
            t = atomicReference.get();
            return t;
        } catch (InterruptedException unused) {
            if (!atomicBoolean.get()) {
                t = atomicReference.get();
                break;
            } else if (toNanos <= 0) {
                throw new InterruptedException("timeout");
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    void a() {
        synchronized (this.a) {
            if (this.c.hasMessages(1)) {
                return;
            }
            this.b.quit();
            this.b = null;
            this.c = null;
        }
    }

    void a(Runnable runnable) {
        runnable.run();
        synchronized (this.a) {
            this.c.removeMessages(0);
            this.c.sendMessageDelayed(this.c.obtainMessage(0), (long) this.f);
        }
    }

    public <T> void a(final Callable<T> callable, final a<T> aVar) {
        final Handler handler = new Handler();
        b(new Runnable() {
            public void run() {
                Object call;
                try {
                    call = callable.call();
                } catch (Exception unused) {
                    call = null;
                }
                handler.post(new Runnable() {
                    public void run() {
                        aVar.a(call);
                    }
                });
            }
        });
    }
}
