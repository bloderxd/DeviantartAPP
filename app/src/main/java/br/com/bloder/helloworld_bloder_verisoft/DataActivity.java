package br.com.bloder.helloworld_bloder_verisoft;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;

/**
 * Created by denis on 18/11/15.
 */


@EActivity(R.layout.datalayout)
public class DataActivity extends ActionBarActivity {

    @ViewById(R.id.btn_back)
    Button btn_back;

    @AfterViews
    void afterViews(){
        getBundle();
    }

    @Click(R.id.btn_back)
    public void finishClick(){
        finish();
    }

    public void getBundle(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();

        if(bundle.containsKey("Nome")){
            TextView txtName = (TextView) findViewById(R.id.txt_name);
            txtName.setText(bundle.getString("Nome"));
        }
        if(bundle.containsKey("Views")){
            TextView txtViews = (TextView) findViewById(R.id.txt_views);
            txtViews.setText("Views: "+bundle.getString("Views"));
        }
        if(bundle.containsKey("Image")){
            ImageView imageView = (ImageView) findViewById(R.id.image_view);
            Picasso.with(this).load(bundle.getString("Image")).into(imageView);
        }
    }

}
