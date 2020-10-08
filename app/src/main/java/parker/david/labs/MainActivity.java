package parker.david.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCoinToss(View view) {
        Intent openCoinTossIntent = new Intent(getApplicationContext(),CoinTossActivity.class);
        openCoinTossIntent.putExtra("ExtraName","ExtraValue");
        startActivity(openCoinTossIntent);
    }

    public void  openUrl(View view) {
        Intent openImplicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goparker.com"));
        startActivity(openImplicitIntent);
    }
}