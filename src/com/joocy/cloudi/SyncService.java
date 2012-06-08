package com.joocy.cloudi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {
    private SyncAdapter adapter;
    private final Object adapterLock = new Object();

    @Override
    public void onCreate() {
        synchronized (adapterLock) {
            if (adapter == null) {
                adapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return adapter.getSyncAdapterBinder();
    }
}
