package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

/**
 * Created by denis on 02/12/15.
 */
public abstract class DeviationEndlessScroll extends RecyclerView.OnScrollListener {

    public int previousTotal=0;
    public Boolean loading = true;
    private int visibleThreshould = 5;
    int pastVisibleItems,visibleItemCount, totalItemCount;

    private int currentPage = 1;

    private StaggeredGridLayoutManager linearLayoutManager;

    public DeviationEndlessScroll(StaggeredGridLayoutManager mLinearLayoutManager){
        this.linearLayoutManager = mLinearLayoutManager;
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
                Log.v("test", "TESTE");
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (pastVisibleItems + visibleThreshould)) {
            currentPage++;
            loading = true;
            onLoadMore(currentPage);
            Log.v("finish", "FIM");
        }
    }

    public abstract void onLoadMore(int currentPage);
}
