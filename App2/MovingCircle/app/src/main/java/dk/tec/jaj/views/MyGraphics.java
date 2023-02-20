package dk.tec.jaj.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import dk.tec.jaj.MainActivity;

public class MyGraphics extends View implements View.OnTouchListener
{
    int xPos = 100, yPos = 100;
    int xPrevious, yPrevious;
    boolean moving;
    int radius = 200;
    int screenWidth, screenHeight;


    public MyGraphics(MainActivity context)
    {
        super(context);
        Display display = context.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        screenWidth = point.x;
        screenHeight = point.y;
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint = new Paint();

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(xPos, yPos, radius, paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("Noget grafik", screenWidth/2, 200, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        int xNew = (int)event.getX();
        int yNew = (int)event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                if(Math.sqrt((xNew - xPos)*(xNew - xPos) + (yNew - yPos)*(yNew - yPos)) <= radius)
                {
                    moving = true;
                    xPrevious = xNew;
                    yPrevious = yNew;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(moving)
                {
                    xPos += xNew - xPrevious;
                    yPos += yNew - yPrevious;
                    xPrevious = xNew;
                    yPrevious = yNew;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                moving = false;
                break;
        }

        if(event.getPointerCount() == 2)
        {
            int x1 = (int)event.getX(0);
            int y1 = (int)event.getY(0);
            int x2 = (int)event.getX(1);
            int y2 = (int)event.getY(1);
            radius = (int)Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
            invalidate();
        }

        return true;
    }
}
