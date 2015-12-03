package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviationsRepository;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity {

    @ViewById protected RecyclerView deviationList;
    @ViewById protected RelativeLayout loadingMore;

    @AfterViews
    protected void afterViews() {
        deviationList.setHasFixedSize(true);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        deviationList.setLayoutManager(layoutManager);
        deviationList.setAdapter(new DeviationListAdapter(new ArrayList<Deviation>(), getApplicationContext()));
        deviationList.setOnScrollListener(new DeviationEndlessScroll(layoutManager, getApplicationContext()) {
            @Override
            public void onLoadMore(int currentPage) {
                loadingMore.setVisibility(View.VISIBLE);
                fetchDeviationsPage(currentPage);
            }
        });
        fetchDeviationsPage(0);
    }

    @Background
    protected void fetchDeviationsPage(int page) {
        showDeviations(DeviationsRepository.fetchPopularDeviations(page));
    }

    @UiThread
    protected void showDeviations(final List<Deviation> nextDeviations){
        loadingMore.setVisibility(View.GONE);
        ((DeviationListAdapter)deviationList.getAdapter()).addNewDeviations(nextDeviations);
    }
}
