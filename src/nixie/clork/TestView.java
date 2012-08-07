package nixie.clork;

import android.content.Context;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.graphics.PorterDuff;

public class TestView extends View {

	
	
	private int i;
	private Bitmap dgits[] = new Bitmap[12];
	
	public TestView(Context context) {
		super(context);
		
		Resources r = context.getResources();
    	
    	dgits[0] = BitmapFactory.decodeResource(r,R.drawable.c0);
        dgits[1] = BitmapFactory.decodeResource(r,R.drawable.c1);
        dgits[2] = BitmapFactory.decodeResource(r,R.drawable.c2);
        dgits[3] = BitmapFactory.decodeResource(r,R.drawable.c3);
        dgits[4] = BitmapFactory.decodeResource(r,R.drawable.c4);
        dgits[5] = BitmapFactory.decodeResource(r,R.drawable.c5);
        dgits[6] = BitmapFactory.decodeResource(r,R.drawable.c6);
        dgits[7] = BitmapFactory.decodeResource(r,R.drawable.c7);
        dgits[8] = BitmapFactory.decodeResource(r,R.drawable.c8);
        dgits[9] = BitmapFactory.decodeResource(r,R.drawable.c9);
        dgits[10] = BitmapFactory.decodeResource(r,R.drawable.ten01);
        dgits[11] = BitmapFactory.decodeResource(r,R.drawable.nixie02);
	}
	
	public TestView(Context context,int i) {
		super(context);
		
		this.i = i;
		Resources r = context.getResources();
    	
    	dgits[0] = BitmapFactory.decodeResource(r,R.drawable.noname);
    	dgits[1] = BitmapFactory.decodeResource(r,R.drawable.josyu);
    	dgits[2] = BitmapFactory.decodeResource(r,R.drawable.kyoma);
    	dgits[3] = BitmapFactory.decodeResource(r,R.drawable.mayuri);

	}

	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public TestView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	
	protected void onDraw(Canvas canvas) {
		/*
		int[] x = new int[6];
		Integer w = (this.getWidth()-this.dgits[11].getWidth()*8)/2,z=0;
		final Integer top = this.getHeight()/2-dgits[11].getHeight();
		Time t =new Time();
		x=t.getT();
		*/
		
		int w = this.getWidth(),h = this.getHeight();
		
		Time time = new Time();
		time.get_t();
		
		
		Matrix matrix = new Matrix();
		Bitmap bitmap2;
		
		canvas.drawColor(Color.WHITE); 
		
		//描画位置translate(x,y)オフセット？絶対値？　回転rotate(角度.f,基準点x,y)
		/*paintの再使用は可能らしい
		 canvasにセットした値は残るためクリアする必要アリ 
		 --->matrixを使うように変更*/
		
		
		Paint fill_paint = new Paint();
		
		//matrix.postRotate(time.hour*30,dgits[0].getWidth()/2, dgits[0].getHeight());
		
		matrix.postRotate(time.second*6);
		bitmap2 = Bitmap.createBitmap(dgits[0], 0, 0, dgits[0].getWidth(), dgits[0].getHeight(), matrix, true);
		canvas.drawBitmap(bitmap2, w/2-dgits[0].getWidth(),h/2-dgits[0].getHeight(), fill_paint);
		
		matrix = new Matrix();
		matrix.postRotate(time.second*6,dgits[0].getWidth()/2.0f, dgits[0].getHeight());
		bitmap2 = Bitmap.createBitmap(dgits[0], 0, 0, dgits[0].getWidth(), dgits[0].getHeight(), matrix, true);
		
		matrix = new Matrix();
		
		canvas.drawBitmap(bitmap2, w/2-dgits[0].getWidth(),h/2-dgits[0].getHeight(), fill_paint);
		

		//matrix.postRotate(0,dgits[2].getWidth()/2.0f, dgits[2].getHeight());
		bitmap2 = Bitmap.createBitmap(dgits[2], 0, 0, dgits[2].getWidth(), dgits[2].getHeight(), matrix, true);
		canvas.drawBitmap(bitmap2, w/2-dgits[2].getWidth(),h/2-dgits[2].getHeight(), fill_paint);
		
		
		
		Log.d("time",Integer.toString(time.second));
		
		
		
		
		/*
		canvas.drawBitmap(dgits[11], w,top, fill_paint);
		
		while(z < 8){
			if((z+1) % 3 == 0 ){
				canvas.drawBitmap(dgits[10], w+(dgits[11].getWidth()*z),top, fill_paint);
			}else{
				canvas.drawBitmap(dgits[11], w+(dgits[11].getWidth()*z),top, fill_paint);
			}
			z++;
			
		}
		z = 0;
		
		w = w+(dgits[11].getWidth()-dgits[0].getWidth())/2;
		
		canvas.drawBitmap(dgits[x[z++]], w,top+14, fill_paint);
		
		
		while(z < 6){
			if(z % 2 == 0 )
				w = w+dgits[11].getWidth();
			
			canvas.drawBitmap(dgits[x[z]], w+dgits[11].getWidth()*z+((dgits[11].getWidth()-dgits[0].getWidth())/2)-2,top+14, fill_paint);
			
			z++;   	
		}
		*/
    }
}
