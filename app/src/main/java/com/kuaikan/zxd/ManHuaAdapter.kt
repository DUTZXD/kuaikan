package com.kuaikan.zxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/1
 */
public class ManHuaAdapter extends RecyclerView.Adapter<ManViewHolder> {

    private ArrayList<ManhuaEntity> data = new ArrayList<>();

    @NonNull
    @Override
    public ManViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.manhua_item_layout, parent, false);
        return new ManViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ManViewHolder holder, int position) {
        ManhuaEntity entity = data.get(position);
        holder.bindData(entity);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<ManhuaEntity> newData) {
        data = newData;
        notifyDataSetChanged();
    }
}
