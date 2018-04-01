package com.company;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.Collections;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        //部品を作成
        ArrayList<Mylabel> label_array = new ArrayList<>();
        for(int i=0;i<3;i++){
            label_array.add(new Mylabel("1"));
        }

        //部品を入れる箱を設定
        HBox label_box = new HBox(10d);
        label_box.setPrefSize(50,50);
        label_box.setAlignment(Pos.CENTER);
        label_box.getChildren().addAll(label_array);

        //ボタンを作成
        Button start_button= new Button("START");
        Button stop_button= new Button("STOP");

        //ボタンイベントを作成
        start_button.setOnAction(event -> {
            for(int i=0;i < label_array.size();i++){
                label_array.get(i).setSlotStarted();
            }
        });

        stop_button.setOnAction(event->{
            for(int i=0;i < label_array.size();i++){
                label_array.get(i).stopSlot();
            }
            ArrayList<String> res = new ArrayList<>();
            for (int i =0; i<label_array.size();i++){
                res.add(label_array.get(i).getText());
            }
            // resの0番目の値がres全体で何個かを調べる
            // それが配列全体と同じだったら、スロットの値がすべて一致しているとみなす
            // Collection.frequency(配列やリスト名, 検索対象の値)でその値が配列のどのくらい含まれているか確認できる
            if (Collections.frequency(res, res.get(0)) == res.size()) {
                //新しいウィンドウを作成
                Stage newStage = new Stage();
                //モーダルウィンドウに設定
                newStage.initModality(Modality.APPLICATION_MODAL);

                //新しいウィンドウ内に配置するコンテンツを生成
                HBox omedetou = new HBox();
                Label label =new Label("おめでとう！");
                omedetou.getChildren().add(label);
                newStage.setScene(new Scene(omedetou));

                //新しいウィンドウを表示
                newStage.show();
            }
        });

        //ボタンを入れる箱を作成
        HBox button_box = new HBox(20d);
        button_box.setAlignment(Pos.CENTER);
        button_box.getChildren().add(start_button);
        button_box.getChildren().add(stop_button);

        //BorderPaneに追加
        BorderPane borderPane =new BorderPane();
        borderPane.setPadding(new Insets(30,10,10,10));
            //ラベルボックスを設置
        borderPane.setCenter(label_box);
            //ボタンボックスを設置
        borderPane.setBottom(button_box);

        //最終的な表示準備
        Scene scene = new Scene(borderPane,320,320);
        stage.setScene(scene);
        stage.show();
    }
}
