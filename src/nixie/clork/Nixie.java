package nixie.clork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Nixie extends Activity{

	
	private Handler timerHandler = new Handler();
	private Handler deleteHandler = new Handler();
	private int counter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.view);
	}
	
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
	
	private Runnable CallbackDelete = new Runnable() {
        public void run() {
            /* コールバックを削除して周期処理を停止 */
            timerHandler.removeCallbacks(CallbackTimer);
        }
    };
    
    private Runnable CallbackTimer = new Runnable(){   
    	 
    	ImageView iv;
    	int redID;

		@SuppressWarnings("null")
		public void run() {
            /* カウンタ値を更新 */
            counter += 1;
            Log.d("->", String.valueOf(counter));

            /* 次の通知を設定 */
            timerHandler.postDelayed(this, 1000);
            
            
            
            /*redID = getResources().getIdentifier("c"+String.valueOf(time[0]),"drawable",getPackageName());
            R.id～の部分を文字列で取得できる
            getResources().getIdentifier("c0","drawable",getpakename) = nixie~.drawable.c0に相当
            */
            Time t = new Time();
            int[] time = t.getT();
            redID = getResources().getIdentifier("c"+String.valueOf(time[0]),"drawable",getPackageName());
            iv = (ImageView)findViewById(R.id.h1);
            iv.setImageResource(redID);
            
            
            iv = (ImageView)findViewById(R.id.h2);
            redID = getResources().getIdentifier("c"+String.valueOf(time[1]),"drawable",getPackageName());
            iv.setImageResource(redID);
       
            
            iv = (ImageView)findViewById(R.id.m1);
            redID = getResources().getIdentifier("c"+String.valueOf(time[2]),"drawable",getPackageName());
            iv.setImageResource(redID);
            
            iv = (ImageView)findViewById(R.id.m2);
            redID = getResources().getIdentifier("c"+String.valueOf(time[3]),"drawable",getPackageName());
            iv.setImageResource(redID);
            
            iv = (ImageView)findViewById(R.id.s1);
            redID = getResources().getIdentifier("c"+String.valueOf(time[4]),"drawable",getPackageName());
            iv.setImageResource(redID);
            
            iv = (ImageView)findViewById(R.id.s2);
            redID = getResources().getIdentifier("c"+String.valueOf(time[5]),"drawable",getPackageName());
            iv.setImageResource(redID);
    	}
			
    };
    
    public void changeClock(View v){
    	//deleteHandler.postDelayed(CallbackDelete, 0);
    	Intent i = new Intent(this,Analog.class);
    	Log.d("aaa","aaa");
    	this.startActivity(i);
    	
    }
    

}
