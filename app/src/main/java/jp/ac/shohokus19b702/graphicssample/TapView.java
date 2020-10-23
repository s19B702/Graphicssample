package jp.ac.shohokus19b702.graphicssample;

 import android.content.Context;
 import android.content.res.Resources;
 import android.graphics.Bitmap;
 import android.graphics.BitmapFactory;
 import android.graphics.Canvas;
 import android.graphics.Color;
 import android.graphics.Paint;
 import android.util.AttributeSet;
 import android.view.MotionEvent;
 import android.view.View;

 public class TapView extends View {
 private Paint mPaint = new Paint(); //描画用のスタイル設定など
 private Bitmap mBmp = null; //表示用の Bitmap
 private int mTop, mLeft, mW, mH; //画像の幅と高さ

 /**
  * コンストラクタ
  * @param context
  * @param attrs
  */
         public TapView(Context context, AttributeSet attrs) {
         super(context, attrs);
         Resources rs = this.getResources(); //リソースを取得 (R クラスから取得)
         mBmp = BitmapFactory.decodeResource(rs, R.drawable.pikachu_crunk); //リソースから画像を取得
         mTop = 100;
         mLeft = 100;
         mW = mBmp.getWidth();
         mH = mBmp.getHeight();

         }

         /**
  * このメソッドで描画をします．
  *
  * @param canvas 画像表示用のキャンバス
  */
         protected void onDraw(Canvas canvas) {
         super.onDraw(canvas);
         canvas.drawColor(Color.WHITE);
         canvas.drawBitmap(mBmp, mLeft, mTop, mPaint);
         }

         /*
 * タップされたときに実行されるメソッド<br />
 * タップされたときに，押されたかどうかの状態をチェックし，変化させる．
 */
         @Override
 public boolean onTouchEvent(MotionEvent event) {
         int x = (int) event.getX();
         int y = (int) event.getY();
         mLeft = x - mW/2; //描画場所を変更

         mTop = y - mH/2;

         invalidate(); //再描画する
         return super.onTouchEvent(event);
         }
 }
