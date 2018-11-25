package com.aaronat1.desarrollo.githubtrending.main.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import com.aaronat1.desarrollo.githubtrending.R;
import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.ViewHolder> {


    private List<TrendingRepository> trendingRepositories;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {

        void onItemClick(TrendingRepository trendingRepository);
    }

    public RepositoriesAdapter(List<TrendingRepository> trendingRepositories, OnItemClickListener listener) {
        this.trendingRepositories = trendingRepositories;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TrendingRepository trendingRepository = trendingRepositories.get(position);
        holder.bindTrendingRepository(trendingRepository);
    }

    @Override
    public int getItemCount() {
        return trendingRepositories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cdView)
        CardView cdView;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDescription)
        TextView tvDescription;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.tvOwner)
        TextView tvOwner;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTrendingRepository(final TrendingRepository trendingRepository) {
            if (trendingRepository != null) {
                tvName.setText(trendingRepository.getName());
                tvDescription.setText(trendingRepository.getDescription());
                tvOwner.setText(trendingRepository.getOwner().getLogin());
                tvDate.setText(trendingRepository.getUpdated_at());
                cdView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.onItemClick(trendingRepository);
                    }
                });

            }
        }
    }

}

