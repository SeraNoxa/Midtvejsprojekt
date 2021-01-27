package logic;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import presentation.UILoader;

import java.util.TimerTask;

public class TimeTasker extends TimerTask {
    public static IntegerProperty timeLeft;
    BattleEvents battleEvents;

    public void run(){
        if(timeLeft.getValue().intValue()> 0){
            timeLeft.setValue(timeLeft.getValue().intValue()-1);
            Platform.runLater(() ->{
                UILoader.instance.battleView.setGameTime(timeLeft.getValue());
            });
        }else if(timeLeft.getValue().intValue() == 0){
            Platform.runLater(() ->{
                battleEvents.timeIsLeft=false;
                battleEvents.timeRunOut();
            });
            this.cancel();
        }
    }

    public TimeTasker (int matchTime, BattleEvents battleEvents){
        timeLeft = new SimpleIntegerProperty(matchTime);
        this.battleEvents = battleEvents;
    }
}
