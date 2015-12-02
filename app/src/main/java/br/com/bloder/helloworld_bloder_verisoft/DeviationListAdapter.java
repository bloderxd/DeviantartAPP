package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.details.DeviationDetailsActivity_;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

/**
 * Created by denis on 01/12/15.
 */
public class DeviationListAdapter extends RecyclerView.Adapter<DeviationListAdapter.InternalViewHolder> {

    private List<Deviation> deviationList;
    private Context context;

    public DeviationListAdapter(List<Deviation> deviations, Context context){
        this.deviationList = deviations;
        this.context = context;
    }


    @Override
    public InternalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InternalViewHolder();
    }

    @Override
    public void onBindViewHolder(InternalViewHolder holder, final int position) {
        holder.bind(deviationList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviationDetailsActivity_.intent(context)
                        .userName(deviationList.get(position).authorName)
                        .flags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .userUrlImage(deviationList.get(position).authorImageUrl)
                        .deviationImageUrl(deviationList.get(position).imageUrl)
                        .deviationName(deviationList.get(position).title)
                        .start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return deviationList.size();
    }

    public class InternalViewHolder extends RecyclerView.ViewHolder{

        public InternalViewHolder() {
            super(DeviationViewHolder_.build(context));
        }

        public void bind(Deviation deviation){
            ((DeviationViewHolder) this.itemView).bind(deviation);
        }
    }

}
