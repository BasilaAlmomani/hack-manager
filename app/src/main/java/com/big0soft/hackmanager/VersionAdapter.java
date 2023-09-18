package com.big0soft.hackmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.big0soft.hackmanager.model.ApplicationVersion;

import java.util.List;


public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionsViewHolder> {
    private List<ApplicationVersion> istdata;
    private OnClickItem onClickItem;

    public void clearData() {
        if (istdata.size() > 0) {
            notifyItemRangeRemoved(0, istdata.size());
            istdata.clear();
        }

    }

    public interface OnClickItem{
        void onClick(ApplicationVersion applicationVersion);
    }

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    // RecyclerView recyclerView;
    public VersionAdapter(List<ApplicationVersion>listdata) {
        this.istdata = listdata;
    }

    @Override
    public VersionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.version_item, parent, false);
        VersionsViewHolder viewHolder = new VersionsViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VersionsViewHolder holder, int position) {
        ApplicationVersion data=istdata.get(position);

        holder.bindView(data);

    }

    @Override
    public int getItemCount() {
        return istdata.size() ;
    }

    public void addItems(List<ApplicationVersion> items) {
       int oldCount =istdata.size();
       istdata.addAll(items);
       notifyItemRangeInserted(oldCount,istdata.size());
    }

    public class VersionsViewHolder extends RecyclerView.ViewHolder {
        TextView pmName;
        TextView version;
        TextView id;

        public VersionsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bindView(ApplicationVersion applicationVersion){
            pmName = itemView.findViewById(R.id.pack);
            pmName.setText(applicationVersion.getPackageName());

            version=itemView.findViewById(R.id.versio);
            version.setText(applicationVersion.getVersion());

//            id=itemView.findViewById(R.id.id);
//            id.setText(String.valueOf(applicationVersion.getId()));


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem.onClick(applicationVersion);
                }
            });
        }
    }

}