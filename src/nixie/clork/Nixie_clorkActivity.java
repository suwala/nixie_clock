package nixie.clork;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.RemoteViews.RemoteView;
import android.view.SurfaceHolder;
import android.graphics.drawable.BitmapDrawable;

public class Nixie_clorkActivity extends Activity {
    /** Called when the activity is first created. */
	
	private SurfaceHolder holder;  
	private Handler timerHandler = new Handler();
	private Handler deleteHandler = new Handler();
	private int counter = 0;

	private Bitmap dgits[] = new Bitmap[11];
	
	
	

	
	
	
	
    @Override
	protected void onStart() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStart();
		
		timerHandler.postDelayed(CallbackTimer, 1000);
	}

	@Override
	protected void onStop() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStop();
		
		deleteHandler.postDelayed(CallbackDelete, 0);
		Log.v("stop","STOP!");
	}

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        
        
        timerHandler.removeCallbacks(CallbackTimer);
        timerHandler.postDelayed(CallbackTimer, 1000);
        //deleteHandler.postDelayed(CallbackDelete, 6000);
        

        

        
            
        
    }
    
   
    
    private Runnable CallbackTimer = new Runnable(){
        

		@SuppressWarnings("null")
		public void run() {
            /* カウンタ値を更新 */
            counter += 1;
            Log.d("->", String.valueOf(counter));

            /* 次の通知を設定 */
            timerHandler.postDelayed(this, 1000);
            
            
            
            
            
            
                        
            
            
            Log.v("clock",this.toString());
            
            //RemoteViews rv = new RemoteViews(getPackageName(), R.layout.main);
            
            //int resID = getResources().getIdentifier("c"+String.valueOf(x[0]),"drawable",getPackageName());
            setContentView(R.layout.main);
            
            
            //int i = dgits[0].getWidth();
                        
            //Canvas canvas = null;
            //canvas = holder.lockCanvas();
            
            
            //canvas.drawBitmap(dgits[0],1*i,0,null);
        	

            TestView tv = new TestView(getApplicationContext());
            setContentView(tv);
            //tv.onDraw(canvas);
            //holder.unlockCanvasAndPost(canvas);
            
//            ImageView imageView = (ImageView)findViewById(R.id.imageView2);
//            imageView.setImageBitmap(dgits[0]);

        }

		
    };         
    
    private Runnable CallbackDelete = new Runnable() {
        public void run() {
            /* コールバックを削除して周期処理を停止 */
            timerHandler.removeCallbacks(CallbackTimer);
        }
    };
}