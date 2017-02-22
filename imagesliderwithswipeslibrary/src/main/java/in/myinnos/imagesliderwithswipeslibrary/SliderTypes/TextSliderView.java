package in.myinnos.imagesliderwithswipeslibrary.SliderTypes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.myinnos.imagesliderwithswipeslibrary.R;

/**
 * This is a slider with a description TextView.
 */
public class TextSliderView extends BaseSliderView {
    public TextSliderView(Context context) {
        super(context);
    }

    public static TextView description_textView;

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text, null);
        ImageView target = (ImageView) v.findViewById(R.id.myinnos_slider_image);
        description_textView = (TextView) v.findViewById(R.id.description);
        description_textView.setText(getDescription());
        description_textView.setTextSize(getDescriptionSize());
        bindEventAndShow(v, target);
        return v;
    }
}
