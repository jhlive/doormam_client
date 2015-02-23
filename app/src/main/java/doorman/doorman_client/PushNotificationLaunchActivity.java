package doorman.doorman_client;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;
import com.microsoft.windowsazure.notifications.NotificationsManager;


public class PushNotificationLaunchActivity extends ActionBarActivity {
    public static final String SENDER_ID = "ninth-potion-864";
    public static MobileServiceClient mClient;
    TextView pushMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_notification_launch);
        NotificationsManager.handleNotifications(this, SENDER_ID, PushNotificationHandler.class);
        pushMessage = (TextView) findViewById(R.id.pushMessage);
        Intent intent = getIntent();
        if(intent != null){
          String message = intent.getStringExtra("PUSH_NOTIFICATION_MESSAGE");
          pushMessage.setText(message);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_push_notification_launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
