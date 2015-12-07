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
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviationsRepository;
import br.com.bloder.helloworld_bloder_verisoft.preferences.UiModePrefs_;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

@OptionsMenu(R.menu.menu_main)
@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity {

    @ViewById protected RecyclerView deviationList;
    @ViewById protected RelativeLayout loadingMore;
    private StaggeredGridLayoutManager layoutManager;
    @Pref protected UiModePrefs_ prefs;

    @AfterViews
    protected void afterViews() {
        setupLayoutManager();
        deviationList.setAdapter(new DeviationListAdapter(new ArrayList<Deviation>(), getApplicationContext(), prefs));
        scrollLoading();
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
        layoutManager = new StaggeredGridLayoutManager(columnSize(), StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        deviationList.setHasFixedSize(true);
        deviationList.setLayoutManager(layoutManager);
    }

    private int columnSize() {
        return UI_MODE.current(prefs) == UI_MODE.SIMPLE ? 2 : 1;
    }

    @OptionsItem(R.id.action_change_mode)
    void changeModeDeviation() {
        UI_MODE.switchMode(prefs);
        setupLayoutManager();
        scrollLoading();
        deviationList.getAdapter().notifyDataSetChanged();
    }

    private void scrollLoading(){
        deviationList.setOnScrollListener(new DeviationEndlessScroll(layoutManager, getApplicationContext()) {
            @Override
            public void onLoadMore(int currentPage) {
                loadingMore.setVisibility(View.VISIBLE);
                fetchDeviationsPage(currentPage);
            }
        });
    }
}