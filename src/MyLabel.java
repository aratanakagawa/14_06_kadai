import javafx.scene.control.Label;

import java.util.Random;

public class MyLabel extends Label{
    public MyLabel(){
        super();
        this.setText("1");
        this.setPrefSize(50,50);
    }

    public void setNumber(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(10);
        this.setText(String.valueOf(randomNumber));
    }

}
