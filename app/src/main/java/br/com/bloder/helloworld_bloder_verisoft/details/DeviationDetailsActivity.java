package br.com.bloder.helloworld_bloder_verisoft.details;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.R;

/**
 * Created by denis on 18/11/15.
 */

@EActivity(R.layout.deviationlayout)
public class DeviationDetailsActivity extends ActionBarActivity {

    @ViewById(R.id.txt_views)
    TextView txtViews;

    @ViewById(R.id.user_profile_icon_show)
    ImageView userImageShow;

    @ViewById(R.id.image_view)
    ImageView imageView;

    @AfterViews
    protected void afterViews(){
        getBundle();
    }

    protected void getBundle(){
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Bundle bundle = getIntent().getExtras();

            if (bundle.containsKey("userName")) {
                txtViews.setText(bundle.getString("userName"));
            }
            if (bundle.containsKey("userUrlImage")) {
                Picasso.with(this).load(bundle.getString("userUrlImage")).into(userImageShow);
            }
            if (bundle.containsKey("DeviationImageURL")) {
                Picasso.with(this).load(bundle.getString("DeviationImageURL")).resize(900, 1150).into(imageView);
            }
        }catch (Exception ex){

        }
    }

}