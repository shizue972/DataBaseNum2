package com.example.bazadanychprojekt;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameDAO {
    @Insert
    public void InsertInDB(Game game);
    @Insert
    public void InsertMoreGames(Game ... Games);
    @Delete
    public void delFromDB(Game game);
    @Update
    public void updateGame(Game game);
    @Query("SELECT * FROM games")
    public List<Game> SelectAllGames();

    @Query("Select GameName FROM games WHERE isMultiplayer = true")
    public List<String>it0returnAllGamesOlderThan(int GameAge);
}
