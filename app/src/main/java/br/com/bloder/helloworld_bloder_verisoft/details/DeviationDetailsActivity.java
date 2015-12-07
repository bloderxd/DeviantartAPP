package br.com.bloder.helloworld_bloder_verisoft.details;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.R;

/**
 * Created by denis on 18/11/15.
 */

@EActivity(R.layout.deviation_detail)
public class DeviationDetailsActivity extends ActionBarActivity {

    @ViewById protected TextView authorNameDetail;
    @ViewById protected ImageView authorIconDetail;
    @ViewById protected ImageView imageDetail;

    @Extra protected String userName;
    @Extra protected String userUrlImage;
    @Extra protected String deviationImageUrl;
    @Extra protected String deviationName;

    @OptionsItem(android.R.id.home)
    protected void selectedHome(){
        finish();
    }

    @AfterViews
    protected void showDeviation(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        authorNameDetail.setText(userName);
        Picasso.with(this).load(userUrlImage).into(authorIconDetail);
        Picasso.with(this).load(deviationImageUrl).into(imageDetail);
        setTitle(deviationName);
    }
}
