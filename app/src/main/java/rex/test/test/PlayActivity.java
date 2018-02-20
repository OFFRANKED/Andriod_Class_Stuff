package rex.test.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;


public class PlayActivity extends AppCompatActivity {
    private Paint paint;
    private Canvas gameCanvas;
    private Bitmap gameBitmap;
    private Circle circle;
    private ImageView gameFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        gameFrame =(ImageView) findViewById(R.id.CanvasImageView);
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics =new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        //Bitmap
        gameBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //Canvas
        gameCanvas = new Canvas(gameBitmap);
        paint = new Paint();
        //Canvas Background color
        gameCanvas.drawColor(Color.BLACK);
        // Text Color
        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        gameCanvas.drawText("Score: 42 Lives: 3 HI: 97 ",50,100,paint);
        gameFrame.setImageBitmap(gameBitmap);
        //circle=new circle(50,new Point(250,150));
        //drawCircle(circle, "Draw");
    }

    //private void drawCircle(Circle circle, String action)
    //{
      //  if(action.equals("Draw"))
    //        paint.setColor(Color.WHITE);
    //    else
   //         paint.setColor(Color.BLACK);
   //     gameCanvas.drawCircle( );
   // }

}
