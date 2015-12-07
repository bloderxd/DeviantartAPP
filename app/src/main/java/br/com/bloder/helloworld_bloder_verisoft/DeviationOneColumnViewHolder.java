package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

/**
 * Created by denis on 04/12/15.
 */
@EViewGroup(R.layout.deviation_item_simple)
public class DeviationOneColumnViewHolder extends LinearLayout {

    @ViewById protected ImageView imageOneColumn;
    @ViewById protected ImageView authorIconOneColumn;
    @ViewById protected TextView authorNameOneColumn;
    @ViewById protected TextView deviationNameOneColumn;

    public DeviationOneColumnViewHolder(Context context) {
        super(context);
    }

    public void bind(Deviation deviation){
        authorNameOneColumn.setText(deviation.authorName);
        deviationNameOneColumn.setText(deviation.title);
        Picasso.with(getContext()).load(deviation.imageUrl).into(imageOneColumn);
        Picasso.with(getContext()).load(deviation.authorImageUrl).into(authorIconOneColumn);
    }
}
