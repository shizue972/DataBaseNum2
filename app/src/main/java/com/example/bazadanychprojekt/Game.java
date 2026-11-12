package com.example.bazadanychprojekt;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "games")
public class Game {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String GameName;
    public int Price;
    public boolean isMultiplayer;
    //true multiplayer
    //false singleplayer
    public int GameAge;
    public Game(String gameName, int price, boolean isMultiplayer, int gameAge) {
        GameName = gameName;
        Price = price;
        this.isMultiplayer = isMultiplayer;
        GameAge = gameAge;
    }
    public Game(){

    }
    @Override
    public String toString(){
        return  "Name:" + GameName + "price: " + Price + "Is multiplayer?" + isMultiplayer + "\n";
    }
}
