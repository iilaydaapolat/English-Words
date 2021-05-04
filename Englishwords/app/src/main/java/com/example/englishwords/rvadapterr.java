package com.example.englishwords;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvadapterr extends RecyclerView.Adapter<rvadapterr.PostHolder> {

    private ArrayList<String> words1;
    private ArrayList<String> words2;

    public rvadapterr(ArrayList<String> words1, ArrayList<String> words2) {
        this.words1 = words1;
        this.words2 = words2;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card,parent,false);
        return new PostHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        holder.textView.setText(words1.get(position));
        holder.textView1.setText(words2.get(position));
    }

    @Override
    public int getItemCount() {
        return words1.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        public PostHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.textViewword1);
            textView1= itemView.findViewById(R.id.textViewword2);
        }
    }
}
