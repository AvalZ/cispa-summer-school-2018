package saarland.cispa.trust.chipper.pluginapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PluginReceiver extends BroadcastReceiver {

    final static String TAG = "ChipperAttack.PlugRecv";

    public PluginReceiver() {
    }

    /**
     * Attack:  Javascript Injection - Direct JS injection
     *          Javascript Injection - Poison the cache
     *          Escalate Privileges - First attack
     *          Escalate Privileges - Second attack
     * @TODO: implement
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(TAG, "Got called");

        Bundle extras = intent.getExtras();

        String username = extras.getString("username");
        String password = extras.getString("password");

        Log.d(TAG, "Username: " + username + ", password: " + password);

        /**
         * If the intent is coming from the saarland.cispa.trust.chipper app, then it might contain
         * some sensitive information leaked through your successful attacks. Check for that and
         * print intent's payload properly.
         * See https://developer.android.com/reference/android/content/Intent#getExtras()
        */
    }
}