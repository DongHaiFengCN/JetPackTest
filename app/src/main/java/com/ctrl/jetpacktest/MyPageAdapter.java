package com.ctrl.jetpacktest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

class MyPageAdapter extends PagedListAdapter<Student, MyPageAdapter.ViewHolder> {


    protected MyPageAdapter() {
        super(new DiffUtil.ItemCallback<Student>() {
            @Override
            public boolean areItemsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Student oldItem, @NonNull Student newItem) {
                return oldItem.getStudentNumber() == newItem.getStudentNumber();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Student student = getItem(position);

        if (student == null) {
            holder.nameTv.setText("加载");
        } else {
            holder.nameTv.setText(getItem(position).getStudentNumber() + "");
        }


    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name);
        }
    }
}
