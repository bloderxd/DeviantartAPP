package br.com.bloder.helloworld_bloder_verisoft;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EActivity;

/**
 * Created by denis on 18/11/15.
 */

public class DataActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceSaved) {
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.datalayout);

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

        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(finishClick());
    }

    private View.OnClickListener finishClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }
}
