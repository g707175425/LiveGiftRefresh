package cn.com.unfind.livingrefreshgift;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by gongyasen on 16/7/27.
 */
public class GiftLayout extends LinearLayout {
    private GiftShowManager giftManger;

    public GiftLayout(Context context) {
        this(context,null);
    }

    public GiftLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GiftLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutTransition(new LayoutTransition());

        giftManger = new GiftShowManager(getContext(), this);
        int padding = (int) dip2px(5);
        setOrientation(VERTICAL);
        setPadding(padding,padding,padding,padding);

        Observable.interval(0,300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onNext(final Long aLong) {
                        if(aLong>100)unsubscribe();
                        System.out.println("次数:"+aLong);
                        giftManger.addGift(new GiftVo() {
                            @Override
                            public String getUserId() {
                                if(aLong > 40){
                                    return new Random().nextInt(3)+"";
                                }
                                if(aLong >10){
                                    return aLong%3+"";
                                }
                                return 1+"";
                            }

                            @Override
                            public String getName() {
                                return "啥玩意"+aLong;
                            }

                            @Override
                            public int getNum() {
                                return 1;
                            }

                            @Override
                            public int getGiftId() {
                                return 0;
                            }

                            @Override
                            public String generateId() {
                                return getUserId()+"_"+getGiftId();
                            }
                        });
                    }
                });
    }

    /**
     * dip转换px
     */
    public float dip2px(float dip) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return dip * scale + 0.5f;
    }

    public void start(){
        giftManger.showGift();//开始显示礼物
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(giftManger != null)giftManger.stop();
    }
}
