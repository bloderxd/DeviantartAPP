package br.com.bloder.helloworld_bloder_verisoft.details;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.R;

/**
 * Created by denis on 18/11/15.
 */


@EActivity(R.layout.deviationlayout)
public class DeviationDetailsActivity extends ActionBarActivity {

    @ViewById(R.id.txt_views)
    protected TextView txtViews;

    @ViewById(R.id.user_profile_icon_show)
    protected ImageView userImageShow;

    @ViewById(R.id.image_view)
    protected ImageView imageView;

    @Extra
    protected String userName;

    @Extra
    protected String userUrlImage;

    @Extra
    protected String deviationImageUrl;

    @Extra
    protected String deviationName;

    @AfterViews
    protected void afterViews(){
        getBundle();
    }

    @OptionsItem(android.R.id.home)
    void selectedHome(){
        finish();
    }

    protected void getBundle(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtViews.setText(userName);
        Picasso.with(this).load(userUrlImage).into(userImageShow);
        Picasso.with(this).load(deviationImageUrl).resize(900, 1200).into(imageView);
        setTitle(deviationName);
    }

}
