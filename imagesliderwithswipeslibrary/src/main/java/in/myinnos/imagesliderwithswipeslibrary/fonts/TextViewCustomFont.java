package in.myinnos.imagesliderwithswipeslibrary.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Home on 13-07-2016.
 */
public class TextViewCustomFont extends TextView {

    public TextViewCustomFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewCustomFont(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        setTypeface(tf ,1);

    }

}