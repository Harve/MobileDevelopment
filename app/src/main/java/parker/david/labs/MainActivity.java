package parker.david.labs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_DIALOG_RESPONSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(data.hasExtra("ResponseString")){
            String responseString = data.getExtras().getString("ResponseString");
            Toast.makeText(getApplicationContext(),"This is the response we got: " + responseString, Toast.LENGTH_LONG).show();
        }
    }



    public void openCoinToss(View view) {
        Intent openCoinTossIntent = new Intent(getApplicationContext(),CoinTossActivity.class);
        openCoinTossIntent.putExtra("ExtraName","ExtraValue");
        startActivityForResult(openCoinTossIntent,REQUEST_DIALOG_RESPONSE);
    }

    public void  openUrl(View view) {
        Intent openImplicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goparker.com"));
        startActivity(openImplicitIntent);
    }

    public  void openList(View view){
         Intent openListIntent = new Intent(getApplicationContext(),ListActivity.class);
        startActivity(openListIntent);
    }
}