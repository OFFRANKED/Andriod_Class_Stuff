package rex.test.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;


public class PlayActivity extends AppCompatActivity {
    private Paint paint;
    private Canvas gameCanvas;
    private Bitmap gameBitmap;
    private Circle circle;
    private ImageView gameFrame;
    private Rectangle rectangle;

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
        gameCanvas.drawText("Rectangle ",50,100,paint);
        gameFrame.setImageBitmap(gameBitmap);
        //Values for Xs and Ys
        rectangle = new Rectangle(new Point(250,250), new Point(500,400));
        drawRectangle(rectangle,"DRAW");

    }
    //Draw function for rectangle
    private void drawRectangle(Rectangle rectangle, String action)
    {
        if (action.equals("DRAW"))
            paint.setColor(Color.WHITE);
        else
            paint.setColor(Color.BLACK);
        //Get Function for x's and y's for rectangle
        Rect temp= new Rect(rectangle.getM_TopLeft().getM_X(),rectangle.getM_TopLeft().getM_Y(), rectangle.getM_BottomRight().getM_X(),rectangle.getM_BottomRight().getM_Y());

        gameCanvas.drawRect(temp, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float newX = event.getX();
        float newY = event.getY();

        //Paint Old Rectangle black to erase it
        drawRectangle(rectangle,"ERASE");

        rectangle.translate(new Point((int)newX, (int)newY));

        //Move the rectangle in white color
        drawRectangle(rectangle,"DRAW");


        gameFrame.invalidate();
        return super.onTouchEvent(event);
    }
}
