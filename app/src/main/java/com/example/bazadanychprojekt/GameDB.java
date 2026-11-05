package com.example.bazadanychprojekt;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class}, version = 1)
public abstract class GameDB extends RoomDatabase {

    public abstract GameDAO returnGameDAO();
}
