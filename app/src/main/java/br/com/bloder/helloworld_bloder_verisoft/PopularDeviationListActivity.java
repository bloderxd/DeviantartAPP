package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

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

    private StaggeredGridLayoutManager layoutManager;

    @AfterViews
    protected void afterViews() {
        deviationList.setHasFixedSize(true);
        layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        deviationList.setLayoutManager(layoutManager);
        fetchPopularDeviations();
        deviationList.setOnScrollListener(new DeviationEndlessScroll(layoutManager, getApplicationContext()) {
            @Override
            public void onLoadMore(int currentPage) {
                fetchNextPage(currentPage);
            }
        });
    }

    @Background
    protected void fetchNextPage(int page) {
        showNextDeviations(DeviationsRepository.fetchPopularDeviations(page));
    }

    @UiThread
    protected void showNextDeviations(final List<Deviation> nextDeviations){
        ((DeviationListAdapter)deviationList.getAdapter()).addNewDeviations(nextDeviations);
    }

    @Background
    protected void fetchPopularDeviations() {
        showPopularDeviations(DeviationsRepository.fetchPopularDeviations(0));
    }

    @UiThread
    protected void showPopularDeviations(List<Deviation> popularDeviations) {
        deviationList.setAdapter(new DeviationListAdapter(popularDeviations, getApplicationContext()));
    }
}
