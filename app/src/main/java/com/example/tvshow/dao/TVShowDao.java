package com.example.tvshow.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tvshow.models.TVShow;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

//data access objects (DAO). The app accesses these operations
// through data access objects (DAO)
@Dao
public interface TVShowDao {

@Query("SELECT * FROM tvshows")
  Flowable<List<TVShow>> getWatchlist();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  Completable addToWatchlist(TVShow tvShow);


    @Delete
    Completable removeFromWatchlist(TVShow tvShow);

    @Query("SELECT * FROM tvShows WHERE id = :tvShowId")
  Flowable<TVShow> getTVShowFromWatchlist(String tvShowId);

}
