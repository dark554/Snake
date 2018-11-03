package main.model;

import org.joda.time.DateTime;
import org.joda.time.Seconds;

public class GameData {
    private ObjectsContainer objects;
    private int score = 0;
    private DateTime staringTime;

    public GameData(){
        objects = new ObjectsContainer();
        staringTime = new DateTime();
    }

    public int getScore(){
        return score;
    }
    public void increseScore(int value){
        score+=value;
    }
    public ObjectsContainer getObjects(){
        return objects;
    }
    public String getPeriod(){
        return getMinutes() + ":" + getSeconds();
    }
    private String getSeconds(){
        int seconds = Seconds.secondsBetween(staringTime,DateTime.now()).getSeconds();;
        while(seconds>=60){
            seconds-=60;
        }
        if(seconds<10){
            return "0" + seconds;
        }
        else return "" + seconds;
    }
    private String getMinutes(){
        int minutes = Seconds.secondsBetween(staringTime,DateTime.now()).getSeconds()/60;
        if(minutes<10){
            return "0" + minutes;
        }
        else return "" + minutes;
    }
}
