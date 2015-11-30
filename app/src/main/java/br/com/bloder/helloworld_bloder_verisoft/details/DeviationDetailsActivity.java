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

    @ViewById(R.id.btn_back)
    protected Button btn_back;

    @AfterViews
    protected void afterViews(){
        getBundle();
    }

    @Click(R.id.btn_back)
    protected void finishClick(){
        finish();
    }

    protected void getBundle(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("Nome")){
            TextView txtName = (TextView) findViewById(R.id.txt_name);
            txtName.setText(bundle.getString("Nome"));
        }
        if(bundle.containsKey("Views")){
            TextView txtViews = (TextView) findViewById(R.id.txt_views);
            txtViews.setText(bundle.getString("Views"));
        }
        if(bundle.containsKey("Image")){
            ImageView imageView = (ImageView) findViewById(R.id.image_view);
            Picasso.with(this).load(bundle.getString("Image")).resize(700,700).into(imageView);
        }
    }

}
