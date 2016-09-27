package com.indooratlas.android.sdk.indoornavigation.imageview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.indooratlas.android.sdk.indoornavigation.R;

/**
 * Extends great ImageView library by Dave Morrissey. See more:
 * https://github.com/davemorrissey/subsampling-scale-image-view.
 */
public class BlueDotView extends SubsamplingScaleImageView {
    private static final double EARTH_RADIUS = 6378100.0;
    private int offset;
    private float radius = 1.0f;
    private PointF dotCenter = null;

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setDotCenter(PointF dotCenter) {
        this.dotCenter = dotCenter;
    }

    public BlueDotView(Context context) {
        this(context, null);
    }

    public BlueDotView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    private void initialise() {
        setWillNotDraw(false);
        setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isReady()) {
            return;
        }

        if (dotCenter != null) {
            PointF vPoint = sourceToViewCoord(dotCenter);
            float scaledRadius = getScale() * radius;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getResources().getColor(R.color.ia_blue));

            // fill color
            Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint1.setColor(0x110000FF);
            paint1.setStyle(Paint.Style.FILL);

            // stroke color
            Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint2.setColor(0xFF0000FF);
            paint2.setStyle(Paint.Style.STROKE);

            float subx1 = scaledRadius + 100;
            float subx2 = scaledRadius + 100;
            canvas.drawCircle(vPoint.x, vPoint.y, scaledRadius, paint);
            canvas.drawCircle(vPoint.x, vPoint.y, subx1, paint1);
            canvas.drawCircle(vPoint.x, vPoint.y, subx2, paint2);
        }
    }
}
