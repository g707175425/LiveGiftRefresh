package cn.com.unfind.livingrefreshgift;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

/**
 * @author zhongxf
 * @Description
 * @Date 2016/6/6.
 */
public class GiftQueueActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gift);

        GiftLayout giftCon = (GiftLayout) findViewById(R.id.gift_con);

        giftCon.start();
    }

}
