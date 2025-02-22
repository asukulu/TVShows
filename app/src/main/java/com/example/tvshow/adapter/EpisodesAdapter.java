package com.example.tvshow.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tvshow.R;
import com.example.tvshow.databinding.ItemContainerEpisodeBinding;
import com.example.tvshow.models.EpisodeModel;

import java.util.List;

public class EpisodesAdapter extends  RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>{

    private final List<EpisodeModel> episodes;
    private LayoutInflater layoutInflater;

    public EpisodesAdapter(List<EpisodeModel> episodes) {
        this.episodes = episodes;
    }


    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if (layoutInflater == null){
           layoutInflater = LayoutInflater.from(parent.getContext());
       }
       ItemContainerEpisodeBinding itemContainerEpisodeBinding = DataBindingUtil.inflate(
               layoutInflater, R.layout.item_container_episode, parent, false
       );
        return new EpisodeViewHolder(itemContainerEpisodeBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.bindEpisode(episodes.get(position));

    }

    @Override
    public int getItemCount() {
        return episodes.size();
    }

    static class EpisodeViewHolder extends RecyclerView.ViewHolder {

        private final ItemContainerEpisodeBinding itemContainerEpisodeBinding;

        public EpisodeViewHolder(@NonNull ItemContainerEpisodeBinding itemContainerEpisodeBinding) {
            super(itemContainerEpisodeBinding.getRoot());
            this.itemContainerEpisodeBinding = itemContainerEpisodeBinding;
        }
        public void bindEpisode(EpisodeModel episode){
            String title = "S";
            String season = episode.getSeason();
            if (season.length() == 1){
               season = "0".concat(season);
            }
            String episodeNumber = episode.getEpisode();
        if (episodeNumber.length() == 1) {
            episodeNumber = "0".concat(episodeNumber);

        }
        episodeNumber = "E".concat(episodeNumber);
        title = title.concat(season).concat(episodeNumber);
            itemContainerEpisodeBinding.setTitle(title);
            itemContainerEpisodeBinding.setName(episode.getName());
            itemContainerEpisodeBinding.setAirDate(episode.getAirDate());
        }
        }
    }

