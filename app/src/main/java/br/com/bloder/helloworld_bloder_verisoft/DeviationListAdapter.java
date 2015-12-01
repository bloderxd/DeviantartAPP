package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

/**
 * Created by denis on 01/12/15.
 */
public class DeviationListAdapter extends RecyclerView.Adapter<DeviationListViewHolder> {

    private List<Deviation> deviationList;
    private Context context;

    public DeviationListAdapter(List<Deviation> deviations, Context context){
        this.deviationList = deviations;
        this.context = context;
    }

    @Override
    public DeviationListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeviationListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.populardeviationlist, parent, false));
    }

    @Override
    public void onBindViewHolder(DeviationListViewHolder holder, int position) {
        holder.txtTitle.setText(deviationList.get(position).title);
        holder.txtCount.setText(deviationList.get(position).authorName);
        Picasso.with(context).load(deviationList.get(position).imageUrl).into(holder.imgURL);
        Picasso.with(context).load(deviationList.get(position).authorImageUrl).into(holder.user_profile_icon);
    }

    @Override
    public int getItemCount() {
        return deviationList.size();
    }

}
