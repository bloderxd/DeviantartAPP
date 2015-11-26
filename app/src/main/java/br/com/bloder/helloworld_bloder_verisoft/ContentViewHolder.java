package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.repo.values.Deviation;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.DeviationList;

/**
 * Created by denis on 18/11/15.
 */

@EViewGroup(R.layout.photolist)
public class ContentViewHolder extends LinearLayout {

    @ViewById(R.id.txtTitle)
    TextView txtTitle;
    @ViewById(R.id.txtCount)
    TextView txtCount;
    @ViewById(R.id.imageView)
    ImageView imgURL;

    public ContentViewHolder(Context context) {
        super(context);
    }

    public void setContent(Deviation deviation) {
        try {
            txtTitle.setText(deviation.title);
            txtCount.setText(deviation.author.username);
            Picasso.with(getContext()).load(deviation.content.src).resize(900,900).into(imgURL);
        }
        catch (Exception ex){

        }
    }

}
