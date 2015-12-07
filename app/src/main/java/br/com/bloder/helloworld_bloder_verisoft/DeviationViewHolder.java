package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

@EViewGroup(R.layout.deviation_item_custom)
public class DeviationViewHolder extends RelativeLayout {

    @ViewById protected TextView title;
    @ViewById protected ImageView image;
    @ViewById protected TextView authorName;
    @ViewById protected ImageView authorIcon;

    public DeviationViewHolder(Context context) {
        super(context);
    }

    public void bind(Deviation deviation) {
        title.setText(deviation.title);
        authorName.setText(deviation.authorName);
        Picasso.with(getContext()).load(deviation.imageUrl).into(image);
        Picasso.with(getContext()).load(deviation.authorImageUrl).into(authorIcon);
    }
}
