package dk.tec.sensorsballroller;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

import androidx.core.content.ContextCompat;

public class BallRoller extends View implements SensorEventListener
{
    MainActivity mainAct;
    Drawable ball;
    int ballWidth, ballHeight;

    float xPos = 300;
    float yPos = 300;
    float xMove, yMove;
    float xFake, yFake;


    int screenWidth;
    int screenHeight;
    public BallRoller(MainActivity mainAct) {
        super(mainAct);
        this.mainAct = mainAct;

        ball = ContextCompat.getDrawable(mainAct.getApplicationContext(),R.drawable.kugle08);
        ballWidth = ball.getIntrinsicWidth()/2;
        ballHeight = ball.getIntrinsicHeight()/2;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenWidth = w;
        screenHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        //super.onDraw(canvas);
        ball.setBounds((int)xPos, (int)yPos, ((int)xPos) + ballWidth, ((int)yPos) + ballHeight);
        ball.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(2);
        canvas.drawLine(7,5, screenWidth - 7, 5, paint);
        canvas.drawLine(screenWidth - 7,5, screenWidth - 7, screenHeight -5, paint);
        canvas.drawLine(screenWidth - 7,screenHeight - 5, 7, screenHeight - 5, paint);
        canvas.drawLine(7,screenHeight - 5, 7, 5, paint);

    }


    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            mainAct.updateValues(event.values);

            xMove += -event.values[0];
            xPos += xMove;

            yMove += event.values[1];
            yPos += yMove;

            if(xPos < 0 - 50) {
                xMove = Math.abs(xMove) * 0.9f;
                xPos += xMove + 1;
            }
            if(xPos > screenWidth - ballWidth + 5) {
                xMove = Math.abs(xMove) * -0.9f;
                xPos += xMove - 1;
            }
            if(yPos < 0 - 10) {
                yMove = Math.abs(yMove) * 0.9f;
                yPos += yMove + 1;
            }
            if(yPos > screenHeight - ballHeight + 15) {
                yMove = Math.abs(yMove) * -0.9f;
                yPos += yMove - 1;
            }

            invalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { }
}
