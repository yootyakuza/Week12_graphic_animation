package com.example.apple.week12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}

class BallAnimation extends View {

    Handler h;

    public BallAnimation(Context context) {
        super(context);
    }

    public BallAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        h = new Handler();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            invalidate();//refresh
        }
    };

    int xBall = 0, xBar = 0,xBarB = 0, delay = 0;//ถ้าเปิดทิ้งไว้ ค่าของ int จะสุดที่ 2147483647

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        Paint paint1 = new Paint();
        paint1.setColor(Color.BLUE);
//        canvas.drawCircle(50 + xBall,50,50,paint);
//
//        h.postDelayed(r,1000);//1 วินาที วิ่งไปทางขวาทีละ 10
//
//        xBall += 10;

        canvas.drawLine(100, 1000, 100, 100, paint);//Y
        canvas.drawLine(100, 1000, 1000, 1000, paint);//X
        canvas.drawRect(100, 280, 100+ xBar, 380, paint);//A
        canvas.drawRect(100,540,100+xBarB,640,paint1);//B
        if(xBar <= 600){
            xBar +=10;
        }
        if(xBarB <= 900){
            xBarB +=10;
        }


        canvas.save();
        canvas.scale(4, 4, 100, 80);//scale ขนาดและการหมุน
        canvas.drawText("Y", 100, 80, paint);
        canvas.restore();

        canvas.save();
        canvas.scale(4, 4, 1010, 1000);
        canvas.drawText("x", 1010, 1000, paint);
        canvas.restore();
        //A
        canvas.save();
        canvas.scale(4, 4, 50, 300);
        canvas.drawText("A", 50, 300, paint);
        canvas.restore();
        //B
        canvas.save();
        canvas.scale(4, 4, 50, 600);
        canvas.drawText("B", 50, 600, paint1);
        canvas.restore();

        paint.setColor(Color.WHITE);
        canvas.drawArc(300,1100,800,1600,0,360,true,paint);
        canvas.drawArc(300,1100,800,1600,0,0+ delay,true,paint1);
        canvas.drawCircle(550,1350,180,paint);

        if(delay <= 360){
            delay += 10;
        }
        h.postDelayed(r, 40);
    }
}
