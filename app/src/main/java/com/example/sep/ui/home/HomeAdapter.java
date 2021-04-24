package com.example.sep.ui.home;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeVH> {
    private List<Info> infos;

    public HomeAdapter(List<Info> infos) {
        this.infos = infos;
    }

    @NonNull
    @Override
    public HomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.info_list, parent, false);
        return new HomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVH holder, int position) {
        holder.infoOfTextView.setText(infos.get(position).getInfoOf());

        if(position == 0){

            holder.levelTextView.setText(String.valueOf(infos.get(position).getLevel()) + "C°");

            if(infos.get(position).getLevel() < 20 || infos.get(position).getLevel() > 22){
                holder.levelTextView.setTextColor(Color.RED);
            }
        }
        else if(position == 1){
            holder.levelTextView.setText(String.valueOf(infos.get(position).getLevel()) + "%");
            if(infos.get(position).getLevel() > 60 || infos.get(position).getLevel() < 40){
                holder.levelTextView.setTextColor(Color.RED);
            }
        }

        else if(position == 2){
            holder.levelTextView.setText(String.valueOf(infos.get(position).getLevel()) + "ppm");
            if(infos.get(position).getLevel() > 1000){
                holder.levelTextView.setTextColor(Color.RED);
            }
        }

        holder.detailsTextView.setText(infos.get(position).getDetails());
        boolean isExpandable = infos.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        holder.imageView.setImageResource(infos.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public void setInfos(ArrayList<Info> infos){
        this.infos = infos;
        notifyDataSetChanged();
    }

    public class HomeVH extends RecyclerView.ViewHolder {
        TextView infoOfTextView;
        TextView levelTextView;
        TextView detailsTextView;
        ImageView imageView;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public HomeVH(@NonNull View itemView) {
            super(itemView);
            infoOfTextView = itemView.findViewById(R.id.infoOfTextView);
            levelTextView = itemView.findViewById(R.id.level_textView);
            detailsTextView = itemView.findViewById(R.id.detailsDescriptionTextView);
            imageView = itemView.findViewById(R.id.Image);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            linearLayout = itemView.findViewById(R.id.linearLayoutInfo);

            linearLayout.setOnClickListener(v -> {
                Info info = infos.get(getAdapterPosition());
                info.setExpandable(!info.isExpandable());
                notifyItemChanged(getAdapterPosition());
            });


        }
    }
}
