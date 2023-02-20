package dk.tec.movingeinstein;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

public class GraphicsEinstein extends View implements Runnable
{
    int xPos = 300;
    int yPos = 300;

    int xMove = 1;
    int yMove = 1;

    Drawable drwEinstein;
    int drwWidth;
    int drwHeight;
    int viewWidth;
    int viewHeight;

    public GraphicsEinstein(Context context)
    {
        super(context);
        drwEinstein =
                ResourcesCompat.getDrawable(getResources(), R.drawable.einstein, null);
        drwWidth = drwEinstein.getIntrinsicWidth()/5;
        drwHeight = drwEinstein.getIntrinsicHeight()/5;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;
        viewHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drwEinstein.setBounds(xPos, yPos, xPos+ drwWidth, yPos + drwHeight);
        drwEinstein.draw(canvas);
    }

    @Override
    public void run()  //Køres i anden tråd
    {
        while(true)
        {
            xPos += xMove;
            yPos += yMove;

            if(xPos + drwWidth > viewWidth || xPos <= 0)
            {
                xMove *= -1;
            }
            if(yPos + drwHeight > viewHeight || yPos <= 0)
            {
                yMove *= -1;
            }
            postInvalidate(); // Kaldes fra anden tråd.
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}














