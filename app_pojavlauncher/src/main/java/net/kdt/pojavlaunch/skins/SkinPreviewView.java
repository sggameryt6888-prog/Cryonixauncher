package net.kdt.pojavlaunch.skins;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SkinPreviewView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mPixelPaint = new Paint();
    private final Rect mSourceRect = new Rect();
    private final RectF mDestinationRect = new RectF();
    private Bitmap mSkinBitmap;
    private long mStartTime;

    public SkinPreviewView(Context context) {
        this(context, null);
    }

    public SkinPreviewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPixelPaint.setFilterBitmap(false);
        mStartTime = System.currentTimeMillis();
    }

    public void setSkinBitmap(@Nullable Bitmap skinBitmap) {
        mSkinBitmap = skinBitmap;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);
        if(mSkinBitmap == null) {
            drawPlaceholder(canvas);
        } else {
            drawPlayer(canvas);
        }
        postInvalidateOnAnimation();
    }

    private void drawPlaceholder(Canvas canvas) {
        mPaint.setColor(0xff172029);
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), 18, 18, mPaint);
        mPaint.setColor(0xff35cfff);
        float cx = getWidth() / 2f;
        float cy = getHeight() / 2f;
        canvas.drawRoundRect(cx - 44, cy - 80, cx + 44, cy + 82, 12, 12, mPaint);
    }

    private void drawPlayer(Canvas canvas) {
        float rotation = (System.currentTimeMillis() - mStartTime) / 900f;
        float facing = (float) Math.cos(rotation);
        boolean drawBack = facing < 0;
        float xScale = 0.42f + 0.58f * Math.abs(facing);
        float unit = Math.min(getWidth() / 25f, getHeight() / 36f);
        float centerX = getWidth() / 2f;
        float top = (getHeight() - unit * 32f) / 2f;

        canvas.save();
        canvas.scale(xScale, 1f, centerX, getHeight() / 2f);
        drawSkinPart(canvas, drawBack ? 24 : 8, 8, 8, 8, centerX - unit * 4f, top, unit * 8f, unit * 8f);
        drawSkinPart(canvas, drawBack ? 32 : 20, 20, 8, 12, centerX - unit * 4f, top + unit * 8f, unit * 8f, unit * 12f);
        drawSkinPart(canvas, drawBack ? 56 : 44, 20, 4, 12, centerX - unit * 8f, top + unit * 8f, unit * 4f, unit * 12f);
        drawSkinPart(canvas, drawBack ? 48 : 36, 52, 4, 12, centerX + unit * 4f, top + unit * 8f, unit * 4f, unit * 12f);
        drawSkinPart(canvas, drawBack ? 12 : 4, 20, 4, 12, centerX - unit * 4f, top + unit * 20f, unit * 4f, unit * 12f);
        drawSkinPart(canvas, drawBack ? 28 : 20, 52, 4, 12, centerX, top + unit * 20f, unit * 4f, unit * 12f);
        canvas.restore();
    }

    private void drawSkinPart(Canvas canvas, int sx, int sy, int sw, int sh, float dx, float dy, float dw, float dh) {
        mSourceRect.set(sx, sy, sx + sw, sy + sh);
        mDestinationRect.set(dx, dy, dx + dw, dy + dh);
        canvas.drawBitmap(mSkinBitmap, mSourceRect, mDestinationRect, mPixelPaint);
    }
}
