package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by denis on 01/12/15.
 */
public class DeviationListViewHolder extends RecyclerView.ViewHolder {

    public TextView txtTitle;
    public TextView txtCount;
    public ImageView imgURL;
    public ImageView user_profile_icon;

    public DeviationListViewHolder(View itemView) {
        super(itemView);
        txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        txtCount = (TextView) itemView.findViewById(R.id.txtCount);
        imgURL = (ImageView) itemView.findViewById(R.id.imageView);
        user_profile_icon = (ImageView) itemView.findViewById(R.id.user_profile_icon);
    }


}
