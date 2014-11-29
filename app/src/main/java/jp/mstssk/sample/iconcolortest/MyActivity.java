package jp.mstssk.sample.iconcolortest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;


public class MyActivity extends Activity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        this.notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification1();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification2();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification3();
            }
        });
    }

    private void showNotification1() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Test1")
                .setContentText("Test1");
        notificationManager.notify(0, builder.build());
    }

    private void showNotification2() {
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Test2")
                .setContentText("Test2")
                .setLargeIcon(loadBitmap());
        notificationManager.notify(1, builder.build());
    }

    private void showNotification3() {
        // same with showNotification1()
        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(R.drawable.small_icon)
                .setContentTitle("Test3")
                .setContentText("Test3");
        notificationManager.notify(3, builder.build());
    }

    private Bitmap loadBitmap() {
        try {
            return BitmapFactory.decodeStream(getAssets().open("bitmap.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to load bitmap.", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
}
