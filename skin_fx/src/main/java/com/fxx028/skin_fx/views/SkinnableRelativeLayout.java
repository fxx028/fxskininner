package com.fxx028.skin_fx.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.fxx028.skin_fx.R;
import com.fxx028.skin_fx.bean.AttrsBean;
import com.fxx028.skin_fx.core.ViewsMatch;

import androidx.core.content.ContextCompat;

/**
 * @author: fengxin
 * @date: 2020/5/15
 * @mark:
 */
public class SkinnableRelativeLayout extends RelativeLayout implements ViewsMatch {


    private  AttrsBean attrsBean;

    public SkinnableRelativeLayout(Context context) {
        super(context,null);
    }

    public SkinnableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public SkinnableRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        attrsBean = new AttrsBean();

        // 根据自定义属性，匹配控件属性的类型集合，如：background
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.SkinnableRelativeLayout,
                defStyleAttr, 0);
        // 存储到临时JavaBean对象
        attrsBean.saveViewResource(typedArray, R.styleable.SkinnableRelativeLayout);
        // 这一句回收非常重要！obtainStyledAttributes()有语法提示！！
        typedArray.recycle();
    }



    @Override
    public void skinnableView() {
// 根据自定义属性，获取styleable中的background属性
        int key = R.styleable.SkinnableRelativeLayout[R.styleable.SkinnableRelativeLayout_android_background];
        // 根据styleable获取控件某属性的resourceId
        int backgroundResourceId = attrsBean.getViewResource(key);
        if (backgroundResourceId > 0) {
            // 兼容包转换
            Drawable drawable = ContextCompat.getDrawable(getContext(), backgroundResourceId);
            // 控件自带api，这里不用setBackgroundColor()因为在9.0测试不通过
            // setBackgroundDrawable在这里是过时了
            setBackground(drawable);
        }
    }
}
