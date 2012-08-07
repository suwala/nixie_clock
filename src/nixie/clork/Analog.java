package nixie.clork;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.ImageView;

public class Analog extends Activity {
	
	private SurfaceHolder holder;  
	private Handler timerHandler = new Handler();
	private Handler deleteHandler = new Handler();
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.aaa);
		
	}

	@Override
	protected void onStart() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStart();
		
		timerHandler.postDelayed(CallbackTimer, 1000);
	}

	@Override
	protected void onStop() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStop();
		deleteHandler.postDelayed(CallbackDelete, 0);
		
	}
	
	private Runnable CallbackTimer = new Runnable(){
        

		int h,w;
		
		@SuppressWarnings("null")
		public void run() {
            /* �J�E���^�l���X�V */
            counter += 1;

            /* ���̒ʒm��ݒ� */
            timerHandler.postDelayed(this, 1000);
            
            /*imageview��matrix��ύX���Ă���]���o���Ȃ������̂�
            	bitmap�ɕϊ�(BitmapFactory�g�p)���Ă���������]������
            	���̌�imageview�ɖ߂�
            
            
            ImageView iv = (ImageView)findViewById(R.id.imageView1);
            
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.noname); 
            

            w=bitmap1.getWidth();
            h=bitmap1.getHeight();

            	
            Matrix matrix = new Matrix();
            
            matrix.postRotate(counter*20,w/2.0f,h);
            
            bitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, w, h, matrix, true);
            iv.setImageBitmap(bitmap1);
            */
            
            TestView tv = new TestView(getApplicationContext(),counter);
            setContentView(tv);
		}


		
    };         

    private Runnable CallbackDelete = new Runnable() {
        public void run() {
            /* �R�[���o�b�N���폜���Ď����������~ */
            timerHandler.removeCallbacks(CallbackTimer);
        }
    };

}