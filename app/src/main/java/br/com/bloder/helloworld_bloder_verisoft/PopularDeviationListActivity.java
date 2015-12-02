package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.AbsListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviationsRepository;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity {

    @ViewById protected RecyclerView deviationList;

    @AfterViews
    protected void afterViews() {
        deviationList.setHasFixedSize(true);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        deviationList.setLayoutManager(layoutManager);
        fetchPopularDeviations();
        deviationList.setOnScrollListener(new DeviationEndlessScroll(layoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                Log.v("EE","KOIJOI");
            }
        });
    }

    @Background
    protected void fetchPopularDeviations() {
        showPopularDeviations(DeviationsRepository.fetchPopularDeviations());
    }

    @UiThread
    protected void showPopularDeviations(List<Deviation> popularDeviations) {
        deviationList.setAdapter(new DeviationListAdapter(popularDeviations, getApplicationContext()));
    }
}
