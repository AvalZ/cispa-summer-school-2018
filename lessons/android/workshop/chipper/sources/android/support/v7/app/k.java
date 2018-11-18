package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.a.c;
import android.util.Log;
import java.util.Calendar;

class k {
    private static k a;
    private final Context b;
    private final LocationManager c;
    private final a d = new a();

    private static class a {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;

        a() {
        }
    }

    k(Context context, LocationManager locationManager) {
        this.b = context;
        this.c = locationManager;
    }

    private Location a(String str) {
        try {
            if (this.c.isProviderEnabled(str)) {
                return this.c.getLastKnownLocation(str);
            }
        } catch (Throwable e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
        }
        return null;
    }

    static k a(Context context) {
        if (a == null) {
            context = context.getApplicationContext();
            a = new k(context, (LocationManager) context.getSystemService("location"));
        }
        return a;
    }

    private void a(Location location) {
        long j;
        a aVar = this.d;
        long currentTimeMillis = System.currentTimeMillis();
        j a = j.a();
        j jVar = a;
        jVar.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.a;
        jVar.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = true;
        if (a.c != 1) {
            z = false;
        }
        boolean z2 = z;
        long j3 = a.b;
        long j4 = j2;
        j2 = a.a;
        long j5 = j3;
        a.a(currentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j6 = a.b;
        if (j5 == -1 || j2 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j2 ? 0 + j6 : currentTimeMillis > j5 ? 0 + j2 : 0 + j5;
            j += 60000;
        }
        aVar.a = z2;
        aVar.b = j4;
        aVar.c = j5;
        aVar.d = j2;
        aVar.e = j6;
        aVar.f = j;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location a = c.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a("network") : null;
        if (c.a(this.b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = a("gps");
        }
        if (location == null || a == null) {
            if (location != null) {
                a = location;
            }
            return a;
        }
        if (location.getTime() > a.getTime()) {
            a = location;
        }
        return a;
    }

    private boolean c() {
        return this.d.f > System.currentTimeMillis();
    }

    boolean a() {
        a aVar = this.d;
        if (c()) {
            return aVar.a;
        }
        Location b = b();
        if (b != null) {
            a(b);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
