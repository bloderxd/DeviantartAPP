package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviationsRepository;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

@OptionsMenu(R.menu.menu_main)
@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity {

    @ViewById protected RecyclerView deviationList;
    @ViewById protected RelativeLayout loadingMore;
    private int windowMode = 0;
    private StaggeredGridLayoutManager layoutManager;

    @AfterViews
    protected void afterViews() {
        setupLayoutManager();
        deviationList.setAdapter(new DeviationListAdapter(new ArrayList<Deviation>(), getApplicationContext(), windowMode));
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

    private void setupLayoutManager() {
        layoutManager = new StaggeredGridLayoutManager(windowMode == 0 ? 2 : 1, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        deviationList.setHasFixedSize(true);
        deviationList.setLayoutManager(layoutManager);
    }

    @OptionsItem(R.id.action_change_mode)
    void changeModeDeviation() {
        windowMode = windowMode == 0 ? 1 : 0;
        setupLayoutManager();
        deviationList.setOnScrollListener(new DeviationEndlessScroll(layoutManager, getApplicationContext()) {
            @Override
            public void onLoadMore(int currentPage) {
                loadingMore.setVisibility(View.VISIBLE);
                fetchDeviationsPage(currentPage);
            }
        });
        ((DeviationListAdapter)deviationList.getAdapter()).changeMode(windowMode);
    }
}
