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

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.repo.ContentRepo;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;

/**
 * Created by denis on 18/11/15.
 */
public class ContentViewHolder extends LinearLayout {

    private TextView txtTitle;
    private TextView txtCount;
    private ImageView imgURL;

    public ContentViewHolder(Context context) {
        super(context);
        init();
    }

    public ContentViewHolder(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    public ContentViewHolder(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        init();
    }

    public void setContent(Content content) {
        txtTitle.setText(content.title);
        txtCount.setText(String.valueOf(content.views));
        Picasso.with(getContext()).load(content.photoUrl).into(imgURL);
    }

    private void init() {
        inflate(getContext(), R.layout.photolist, this);
        txtTitle = (TextView)findViewById(R.id.txtTitle);
        txtCount = (TextView)findViewById(R.id.txtCount);
        imgURL = (ImageView)findViewById(R.id.imageView);
    }

}
