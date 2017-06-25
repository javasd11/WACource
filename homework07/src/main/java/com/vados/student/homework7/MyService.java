package com.vados.student.homework7;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v7.app.NotificationCompat;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    NotificationManager nm;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendNotif();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        nm.cancel(NotifActivity.NOTIFICATION_ID1);
        super.onDestroy();
    }

    private void sendNotif() {
        Intent intent = new Intent(this, NotifActivity.class);
        intent.putExtra(NotifActivity.FILE_NAME, "somefile");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDefaults(Notification.DEFAULT_ALL)
                .setTicker("Notification 1!")
                .setContentTitle("Notification title 1")
                .setContentText("Notification text 1")
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_ONGOING_EVENT
                | Notification.FLAG_NO_CLEAR;

        nm.notify(NotifActivity.NOTIFICATION_ID1, notification);
    }

}
