package com.company;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Mylabel extends Label{
    // アニメーションを行うためのTimeLineオブジェクト
    private Timeline timer;

    // スロットが回っている状態かを管理するフィールド
    private boolean isSlotStarted;

    Mylabel(String text){
        super();
        isSlotStarted = false;
        this.setPrefSize(50,50);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
    }

    public void setSlotStarted(){
        if(isSlotStarted){
            return;
        }
        isSlotStarted = true;
        Random rand = new Random();
        timer = new Timeline(new KeyFrame(Duration.millis(100), e->{
            int randomNumber = rand.nextInt(9)+1;
            this.setText(String.valueOf(randomNumber));
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void stopSlot() {
        //ストップボタンを押したらＳＴＯＰ
        if(isSlotStarted){
            timer.stop();
            isSlotStarted = false;
        }

    }
}
