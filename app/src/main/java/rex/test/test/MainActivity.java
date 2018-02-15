package rex.test.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private void ToView(String Show)
    {
        Context context=getApplicationContext();
        Toast.makeText(context, Show, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToView("onCreate complete !");

        //Quit Button

        Button quit = findViewById(R.id.Quit);
        ButtonListener quitListener =new ButtonListener();
        quit.setOnClickListener(quitListener);

        //Play Button

        Button Play = findViewById(R.id.Play);
        PlayButtonListener PlayListener = new PlayButtonListener();
        Play.setOnClickListener(PlayListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Context context=getApplicationContext();
        //Toast.makeText(context, "onStart Complete! ", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, "OnStart ! ", Toast.LENGTH_SHORT).show();
        ToView("onStart complete !");
    }

    @Override
    protected void onResume() {
        super.onResume();
       //Context context=getApplicationContext();
        //Toast.makeText(this, "OnResume ! ", Toast.LENGTH_SHORT).show();
        ToView("onResume complete !");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Context context=getApplicationContext();
        ToView("onPause complete !");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Context context=getApplicationContext();
        //Toast.makeText(this, "OnStop ! ", Toast.LENGTH_SHORT).show();
        ToView("onStop complete !");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Context context=getApplicationContext();
        //Toast.makeText(this, "OnDestroy ! ", Toast.LENGTH_SHORT).show();
        ToView("onDestroy complete !");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Context context=getApplicationContext();
        //Toast.makeText(this, "OnRestart ! ", Toast.LENGTH_SHORT).show();
        ToView("onRestart complete !");
    }
    //Quit Functions

    private class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
           finish();
            ToView("ButtonListener complete !");
        }
    }
    //Play Functions

    private void StartPlay()
    {
        Intent IntentInstants = new Intent(this,PlayActivity.class);
        startActivity(IntentInstants);
    }

    private class PlayButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            StartPlay();
        }
    }
}
