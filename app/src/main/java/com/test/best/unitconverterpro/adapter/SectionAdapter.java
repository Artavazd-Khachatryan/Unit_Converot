package com.test.best.unitconverterpro.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.best.unitconverterpro.R;
import com.test.best.unitconverterpro.section.Section;

import java.util.List;


public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {


    Context context;
    List<Section> sectionList;

    OnSectionItemClickListener onSectionItemClickListener = section -> {
    };

    public SectionAdapter(Context context, List<Section> list) {
        this.context = context;
        this.sectionList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvTitle.setText(sectionList.get(i).getTitle().toUpperCase());
        viewHolder.ivImage.setImageDrawable(context.getDrawable(sectionList.get(i).getImage()));
        viewHolder.setOnSectionItemClickListener(onSectionItemClickListener);
    }

    @Override
    public int getItemCount() {
        return sectionList.size();
    }

    public void setOnSectionItemClickListener(OnSectionItemClickListener onSectionItemClickListener) {
        this.onSectionItemClickListener = onSectionItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        ImageView ivImage;

        OnSectionItemClickListener onSectionItemClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            ivImage = itemView.findViewById(R.id.iv_image);

            itemView.setOnClickListener(v -> onSectionItemClickListener.onSectionClick(sectionList.get(getAdapterPosition())));

        }

        public void setOnSectionItemClickListener(OnSectionItemClickListener onSectionItemClickListener) {
            this.onSectionItemClickListener = onSectionItemClickListener;
        }
    }

    public interface OnSectionItemClickListener {
        void onSectionClick(Section section);
    }
}
