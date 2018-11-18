package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class z implements Iterable<Intent> {
    private final ArrayList<Intent> a = new ArrayList();
    private final Context b;

    public interface a {
        Intent a_();
    }

    private z(Context context) {
        this.b = context;
    }

    public static z a(Context context) {
        return new z(context);
    }

    public z a(Activity activity) {
        Intent a_ = activity instanceof a ? ((a) activity).a_() : null;
        if (a_ == null) {
            a_ = u.a(activity);
        }
        if (a_ != null) {
            ComponentName component = a_.getComponent();
            if (component == null) {
                component = a_.resolveActivity(this.b.getPackageManager());
            }
            a(component);
            a(a_);
        }
        return this;
    }

    public z a(ComponentName componentName) {
        int size = this.a.size();
        try {
            Context context = this.b;
            while (true) {
                Intent a = u.a(context, componentName);
                if (a == null) {
                    return this;
                }
                this.a.add(size, a);
                context = this.b;
                componentName = a.getComponent();
            }
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public z a(Intent intent) {
        this.a.add(intent);
        return this;
    }

    public void a() {
        a(null);
    }

    public void a(Bundle bundle) {
        if (this.a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.a.toArray(new Intent[this.a.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!android.support.v4.a.a.a(this.b, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.b.startActivity(intent);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }
}
