package com.valentun.learn.lesson6;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringHolder> {
    private List<String> data;

    public StringAdapter(List<String> data) {
        this.data = data;
    }

    public void addItem(String item) {
        data.add(item);
        notifyItemInserted(data.size() -  1);
    }

    @NonNull
    @Override
    public StringHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new StringHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StringHolder stringHolder, int i) {
        String item = data.get(i);
        stringHolder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class StringHolder extends RecyclerView.ViewHolder {
        private TextView content;

        StringHolder(@NonNull View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.item_text);
        }

        private void bind(String s) {
            content.setText(s);
        }
    }
}
