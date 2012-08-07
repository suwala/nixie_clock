package nixie.clork;

import java.util.Calendar;

import android.app.Activity;
import android.util.Log;

public class Time extends Activity{
	final Calendar calendar = Calendar.getInstance();
	final int year = calendar.get(Calendar.YEAR);
	final int month = calendar.get(Calendar.MONTH);
	final int day = calendar.get(Calendar.DAY_OF_MONTH);
	final int hour = calendar.get(Calendar.HOUR_OF_DAY);
	final int minute = calendar.get(Calendar.MINUTE);
	final int second = calendar.get(Calendar.SECOND);
	final int ms = calendar.get(Calendar.MILLISECOND);
	
	int[] i=new int[6];
	
	int h;
	int h2;
	
	int min;
	int min2;
	
	int sec;
	int sec2;

	public int[] getT(){
		Log.v("year/month/day hour:minute:second",
			    year + "/" + (month + 1) + "/" + day + "/" + " " +
			    hour + ":" + minute + ":" + second + "." + ms);
		
		int[] i=new int[6];
		
		int h = i[0] =  hour / 10;
		int h2 = i[1] =hour % 10;
		
		int min = i[2] =minute / 10;
		int min2 = i[3] =minute % 10;
		
		int sec = i[4] =second / 10;
		int sec2 = i[5] =second % 10;
		
		Log.v("test",h*10+h2+":"+min+min2+":"+sec+sec2);
		
	
		
		return i;
		//int resID = getResources().getIdentifier("c"+String.valueOf(month+1),"drawable", this.getPackageName());
		
		
	}
	
	public void get_t(){
		h = i[0] =  hour / 10;
		h2 = i[1] =hour % 10;
		
		min = i[2] =minute / 10;
		min2 = i[3] =minute % 10;
		
		sec = i[4] =second / 10;
		sec2 = i[5] =second % 10;
		
	}
	
	public void run(){
//		int resID = getResources().getIdentifier("c"+String.valueOf(x[0]),"drawable", this.getPackageName());
//        setContentView(R.layout.main);
//        this.iv = (ImageView)this.findViewById(R.id.imageView2);
//        this.iv.setImageResource(resID);
	}

}
