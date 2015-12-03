package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviationsRepository;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

/**
 * Created by denis on 02/12/15.
 */
public abstract class DeviationEndlessScroll extends RecyclerView.OnScrollListener {

    public int previousTotal=0;
    public Boolean loading = true;
    private int visibleThreshould = 5;
    int pastVisibleItems,visibleItemCount, totalItemCount;
    Context context;

    private int currentPage = 1;

    private StaggeredGridLayoutManager linearLayoutManager;

    public DeviationEndlessScroll(StaggeredGridLayoutManager mLinearLayoutManager, Context context){
        this.linearLayoutManager = mLinearLayoutManager;
        this.context = context;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy){
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = recyclerView.getChildCount();
        totalItemCount = linearLayoutManager.getItemCount();
        int[] firstVisibleItem = null;
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPositions(firstVisibleItem);

        if(firstVisibleItem != null && firstVisibleItem.length > 0) {
            pastVisibleItems = firstVisibleItem[0];
        }
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;

            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (pastVisibleItems + visibleThreshould)) {
            currentPage++;
            loading = true;
            onLoadMore(currentPage);
        }
    }

    public abstract void onLoadMore(int currentPage);
}
