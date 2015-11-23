package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.repo.ContentRepo;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;

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

    public void setContent(Content content) {
        txtTitle.setText(content.title);
        txtCount.setText(String.valueOf(content.views));
        Picasso.with(getContext()).load(content.photoUrl).into(imgURL);
    }



}
