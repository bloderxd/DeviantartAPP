package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;
import java.util.zip.Inflater;

import br.com.bloder.helloworld_bloder_verisoft.repo.ContentRepo;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;

/**
 * Created by denis on 18/11/15.
 */
public class ContentAdapter extends BaseAdapter {

    private List<Content> contentList;
    private Context context;

    public ContentAdapter(List<Content> contentList, Context context){
        this.contentList = contentList;
        this.context = context;
    }

    @Override
    public int getCount() {
       return contentList.size();
    }

    @Override
    public Content getItem(int position) {
        return contentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ContentViewHolder view;
        if(convertView == null) {
            view = ContentViewHolder_.build(context);
        }
        else {
            view = (ContentViewHolder) convertView;
        }
        view.setContent(getItem(position));
        return view;
    }
}
