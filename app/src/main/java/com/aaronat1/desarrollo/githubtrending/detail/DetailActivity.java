package com.aaronat1.desarrollo.githubtrending.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aaronat1.desarrollo.githubtrending.R;
import com.aaronat1.desarrollo.githubtrending.entities.TrendingRepository;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private TrendingRepository trendingRepository;

    @BindView(R.id.tvName)
    TextView tvName;

    @BindView(R.id.tvLanguage)
    TextView tvLanguage;

    @BindView(R.id.tvLicense)
    TextView tvLicense;

    @BindView(R.id.tvDescription)
    TextView tvDescription;

    @BindView(R.id.tvOwner)
    TextView tvOwner;

    @BindView(R.id.ivOwner)
    ImageView ivOwner;

    @BindView(R.id.tvCreated)
    TextView tvCreated;

    @BindView(R.id.tvUpdated)
    TextView tvUpdated;

    @BindView(R.id.tvPushed)
    TextView tvPushed;

    @BindView(R.id.tvScore)
    TextView tvScore;

    @BindView(R.id.tvWatchers)
    TextView tvWatchers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        trendingRepository = (TrendingRepository) getIntent().getExtras().getSerializable("trendingRepositorySelected");
        showTrendingRepositorySelected();
    }

    private void showTrendingRepositorySelected() {
        tvName.setText(trendingRepository.getName());
        tvLanguage.setText(" " + trendingRepository.getLanguage());
        if (trendingRepository.getLicense() != null) {
            tvLicense.setText(" " + trendingRepository.getLicense().getName());
        }
        tvDescription.setText(trendingRepository.getDescription());
        tvOwner.setText(trendingRepository.getOwner().getLogin());
        if (trendingRepository.getOwner() != null) {
            Picasso.with(getApplicationContext()).load(trendingRepository.getOwner().getAvatar_url()).into(ivOwner);
        }
        tvCreated.setText(" " + trendingRepository.getCreated_at());
        tvUpdated.setText(" " + trendingRepository.getUpdated_at());
        tvPushed.setText(" " + trendingRepository.getPushed_at());
        tvScore.setText(" " + trendingRepository.getScore());
        tvWatchers.setText(" " + trendingRepository.getWatchers());
    }
}
