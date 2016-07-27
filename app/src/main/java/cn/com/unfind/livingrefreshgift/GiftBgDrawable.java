package cn.com.unfind.livingrefreshgift;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by gongyasen on 16/7/26.
 */
public class GiftBgDrawable extends Drawable {

    private final Paint paint;
    private final Path path;
    private RectF boundF = new RectF();

    public GiftBgDrawable() {
        super();
        paint = new Paint();
        paint.setColor(0x22000000);
        paint.setAntiAlias(true);
        path = new Path();

    }

    @Override
    public void draw(Canvas canvas) {
        boundF.set(getBounds());
        float radius = boundF.height() / 2;
        path.addRoundRect(boundF,
                radius, radius, Path.Direction.CCW);
//        path.addCircle(boundF.right-radius,boundF.bottom,boundF.height(),Path.Direction.CCW);
        path.close();

        canvas.drawPath(path,paint);

    }

    @Override
    public void setAlpha(int i) {
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
    }
    @Override
    public int getOpacity() {
        return 0;
    }
}
