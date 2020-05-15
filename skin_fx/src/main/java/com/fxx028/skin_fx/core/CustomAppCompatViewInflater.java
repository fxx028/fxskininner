package com.fxx028.skin_fx.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.fxx028.skin_fx.views.SkinnableButton;
import com.fxx028.skin_fx.views.SkinnableImageView;
import com.fxx028.skin_fx.views.SkinnableLinearLayout;
import com.fxx028.skin_fx.views.SkinnableRelativeLayout;
import com.fxx028.skin_fx.views.SkinnableTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatViewInflater;

/**
 * @author: fengxin
 * @date: 2020/5/15
 * @mark:自定义控件加载器（可以考虑该类不被继承）
 */
public final class CustomAppCompatViewInflater extends AppCompatViewInflater {
    /**控件名*/
    private String name;
    /**上下文*/
    private Context context;
    /**某控件对应所有属性*/
    private AttributeSet attrs;

    public CustomAppCompatViewInflater(@NonNull Context context) {
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttrs(AttributeSet attrs) {
        this.attrs = attrs;
    }

    public View autoMatch(){
        View view = null;
        switch (name) {
            case "LinearLayout":
                // view = super.createTextView(context, attrs); // 源码写法
                view = new SkinnableLinearLayout(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "RelativeLayout":
                view = new SkinnableRelativeLayout(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "TextView":
                view = new SkinnableTextView(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "ImageView":
                view = new SkinnableImageView(context, attrs);
                this.verifyNotNull(view, name);
                break;
            case "Button":
                view = new SkinnableButton(context, attrs);
                this.verifyNotNull(view, name);
                break;
        }
        return view;
    }

    /**
     * 校验控件不为空（源码方法，由于private修饰，只能复制过来了。为了代码健壮，可有可无）
     *
     * @param view 被校验控件，如：AppCompatTextView extends TextView（v7兼容包，兼容是重点！！！）
     * @param name 控件名，如："ImageView"
     */
    public void verifyNotNull(View view,String name){
        if (view == null) {
            throw new IllegalStateException(this.getClass().getName() + " asked to inflate view for <" + name + ">, but returned null");
        }
    }
}
