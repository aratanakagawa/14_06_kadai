import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Random;

public class App extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        ArrayList<MyLabel> label_array= new ArrayList<>();

        for(int i=0;i<5;i++){
            label_array.add(new MyLabel());
        }
        HBox numBox = new HBox(20d);
//        Border      border  = new Border( new BorderStroke( Color.BLACK ,
//                BorderStrokeStyle.SOLID,
//                CornerRadii.EMPTY,
//                null
//        ) );

        numBox.setPadding(new Insets(10,10,10,10));
        numBox.setAlignment(Pos.CENTER);
        numBox.getChildren().addAll(label_array);
//        numBox.getChildren().setBorder(border);

        //oxを設定するボタン
        Button startButton=new Button("Start");
        Button stopButton=new Button("Stop");



        Timeline timer =new Timeline(new KeyFrame(Duration.millis(100), event-> {


            for (MyLabel arr : label_array) {

                arr.setNumber();
            }

        }));
        startButton.setOnAction(e -> {
            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();
        });
        

        stopButton.setOnAction(event -> {
            timer.stop();
            if(label_array.get(0).getText().equals(label_array.get(1).getText()) && label_array.get(1).getText().equals(label_array.get(2).getText())){
                //新しいウィンドウを作成
                Stage newStage=new Stage();

                //モーダルウィンドウに設定
                newStage.initModality(Modality.APPLICATION_MODAL);
                newStage.initOwner(stage);

                //新しいウィンドウ内に配置するコンテンツを生成
                HBox hBox=new HBox();
                Label label=new Label("おめでとう");
                hBox.getChildren().add(label);

                newStage.setScene(new Scene(hBox));
                newStage.show();
            }

        });

        HBox setBox=new HBox(20);

        setBox.setPadding(new Insets(10,10,10,10));

        setBox.setAlignment(Pos.CENTER);
        setBox.getChildren().add(startButton);
        setBox.getChildren().add(stopButton);

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(numBox);
        borderPane.setBottom(setBox);

        Scene scene=new Scene(borderPane,400,120);
        stage.setScene(scene);
        stage.show();
        

        }
}

