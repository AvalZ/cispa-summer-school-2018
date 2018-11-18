package android.support.v4.app;

import android.arch.lifecycle.p;
import android.arch.lifecycle.q;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.a.c;
import android.support.v4.g.m;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class g extends y implements q, android.support.v4.app.a.a, c {
    final Handler a = new Handler() {
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            g.this.c();
            g.this.b.m();
        }
    };
    final i b = i.a(new a());
    boolean c;
    boolean d;
    boolean e = true;
    boolean f;
    boolean g;
    boolean h;
    int i;
    m<String> j;
    private p k;

    static final class b {
        Object a;
        p b;
        m c;

        b() {
        }
    }

    class a extends j<g> {
        public a() {
            super(g.this);
        }

        public View a(int i) {
            return g.this.findViewById(i);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            g.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a() {
            Window window = g.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean a(f fVar) {
            return g.this.isFinishing() ^ 1;
        }

        public LayoutInflater b() {
            return g.this.getLayoutInflater().cloneInContext(g.this);
        }

        public void b(f fVar) {
            g.this.a(fVar);
        }

        public void c() {
            g.this.e();
        }

        public boolean d() {
            return g.this.getWindow() != null;
        }

        public int e() {
            Window window = g.this.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }
    }

    private static boolean a(k kVar, android.arch.lifecycle.c.b bVar) {
        boolean z = false;
        for (f fVar : kVar.b()) {
            if (fVar != null) {
                if (fVar.a().a().a(android.arch.lifecycle.c.b.STARTED)) {
                    fVar.T.a(bVar);
                    z = true;
                }
                k k = fVar.k();
                if (k != null) {
                    z |= a(k, bVar);
                }
            }
        }
        return z;
    }

    static void b(int i) {
        if ((i & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void g() {
        do {
        } while (a(f(), android.arch.lifecycle.c.b.CREATED));
    }

    public android.arch.lifecycle.c a() {
        return super.a();
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.b.a(view, str, context, attributeSet);
    }

    public final void a(int i) {
        if (!this.f && i != -1) {
            b(i);
        }
    }

    public void a(f fVar) {
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public p b() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.k == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.k = bVar.b;
            }
            if (this.k == null) {
                this.k = new p();
            }
        }
        return this.k;
    }

    protected void c() {
        this.b.h();
    }

    public Object d() {
        return null;
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        String stringBuilder2 = stringBuilder.toString();
        printWriter.print(stringBuilder2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (getApplication() != null) {
            t.a(this).a(stringBuilder2, fileDescriptor, printWriter, strArr);
        }
        this.b.a().a(str, fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    public void e() {
        invalidateOptionsMenu();
    }

    public k f() {
        return this.b.a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.b.b();
        int i3 = i >> 16;
        if (i3 != 0) {
            i3--;
            String str = (String) this.j.a(i3);
            this.j.c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            f a = this.b.a(str);
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity result no fragment exists for who: ");
                stringBuilder.append(str);
                Log.w("FragmentActivity", stringBuilder.toString());
                return;
            }
            a.a(i & 65535, i2, intent);
            return;
        }
        android.support.v4.app.a.b a2 = a.a();
        if (a2 == null || !a2.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        k a = this.b.a();
        boolean c = a.c();
        if (!c || VERSION.SDK_INT > 25) {
            if (c || !a.a()) {
                super.onBackPressed();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.b();
        this.b.a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        m mVar = null;
        this.b.a(null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (!(bVar == null || bVar.b == null || this.k != null)) {
            this.k = bVar.b;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            i iVar = this.b;
            if (bVar != null) {
                mVar = bVar.c;
            }
            iVar.a(parcelable, mVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.j = new m(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.j.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.j == null) {
            this.j = new m();
            this.i = 0;
        }
        this.b.e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return this.b.a(menu, getMenuInflater()) | super.onCreatePanelMenu(i, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(view, str, context, attributeSet);
        return a == null ? super.onCreateView(view, str, context, attributeSet) : a;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a = a(null, str, context, attributeSet);
        return a == null ? super.onCreateView(str, context, attributeSet) : a;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.k == null || isChangingConfigurations())) {
            this.k.a();
        }
        this.b.k();
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.b.l();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return super.onMenuItemSelected(i, menuItem) ? true : i != 0 ? i != 6 ? false : this.b.b(menuItem) : this.b.a(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.b.a(z);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.b();
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.b.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            c();
        }
        this.b.i();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.b.b(z);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        c();
        this.b.m();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        return this.b.a(menu) | a(view, menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.b.b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            i2--;
            String str = (String) this.j.a(i2);
            this.j.c(i2);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            f a = this.b.a(str);
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Activity result no fragment exists for who: ");
                stringBuilder.append(str);
                Log.w("FragmentActivity", stringBuilder.toString());
                return;
            }
            a.a(i & 65535, strArr, iArr);
        }
    }

    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.m();
    }

    public final Object onRetainNonConfigurationInstance() {
        Object d = d();
        m d2 = this.b.d();
        if (d2 == null && this.k == null && d == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = d;
        bVar.b = this.k;
        bVar.c = d2;
        return bVar;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        g();
        Parcelable c = this.b.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.j.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.j.b()];
            String[] strArr = new String[this.j.b()];
            for (int i = 0; i < this.j.b(); i++) {
                iArr[i] = this.j.d(i);
                strArr[i] = (String) this.j.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c) {
            this.c = true;
            this.b.f();
        }
        this.b.b();
        this.b.m();
        this.b.g();
    }

    public void onStateNotSaved() {
        this.b.b();
    }

    protected void onStop() {
        super.onStop();
        this.e = true;
        g();
        this.b.j();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.h || i == -1)) {
            b(i);
        }
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.h || i == -1)) {
            b(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!(this.g || i == -1)) {
            b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.g || i == -1)) {
            b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
