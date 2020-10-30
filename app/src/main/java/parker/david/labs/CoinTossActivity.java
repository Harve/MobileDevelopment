package parker.david.labs;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;

import java.util.Random;

import android.widget.TextView;
import android.widget.Toast;


public class CoinTossActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_toss);
        Log.i("Activity Lifecycle",  "onCreate");

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("ExtraName");


        int numberOfTosses = retrievePreviousTosses();
        if(numberOfTosses ==-1){
            numberOfTosses=1;
        }
        else {numberOfTosses++;}
        Toast.makeText(getApplicationContext(),"This coin has been tossed off: " + numberOfTosses +" times.",Toast.LENGTH_LONG).show();
        storePreviousTosses(numberOfTosses);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i( "Activity Lifecycle", "onPause");
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.i("Activity Lifecycle", "onResume");
        TextView coinTossView = findViewById(R.id.coinTossView);

        String result = getCoinToss();

        coinTossView.setText(result);
    }

    @Override
    public  void finish(){
        Intent data = new Intent();
        TextView coinTossView = findViewById(R.id.coinTossView);
        String responseString = coinTossView.getText().toString();
        data.putExtra("ResponseString",responseString);
        setResult(RESULT_OK, data);
        super.finish();
    }

    private String getCoinToss() {
        Random random = new Random();
        if(random.nextBoolean()){
            return "Heads!";
        }
        return  "Tails!";
    }

    private void storePreviousTosses(int pNumberOfTosses) {
        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(
                "parker.david.labs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("numberOfTosses",pNumberOfTosses
        );
        editor.commit();
    }

    private  int retrievePreviousTosses() {
        int previousTosses = 0;
        SharedPreferences sharedPreferences =
                this.getApplication().getSharedPreferences("parker.david.labs",Context.MODE_PRIVATE);
        previousTosses = sharedPreferences.getInt("numberOfTosses",-1);
        return previousTosses;
    }

}