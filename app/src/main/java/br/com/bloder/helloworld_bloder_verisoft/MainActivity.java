package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.repo.ContentRepo;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;

import static android.widget.AdapterView.*;

public class MainActivity extends ActionBarActivity{

    private ListView photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoList = (ListView) findViewById(R.id.lst);
        List<Content> ContList = ContentRepo.fetchContent();
        ContentAdapter ContAdapter = new ContentAdapter(ContList,getApplicationContext());
        photoList.setAdapter(ContAdapter);

        photoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplication(), DataActivity.class);
                Content content = (Content) photoList.getAdapter().getItem(position);
                intent.putExtra("Nome", content.title);
                intent.putExtra("Views", String.valueOf(content.views));
                intent.putExtra("Image", content.photoUrl);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
