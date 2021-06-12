package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Component;
import model.TimeServer;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class Controller {
    public Text time;
    public Label scores;
    public Label sign;
    public Label lb1;
    public Label lb2;
    public Label lb3;
    int a;
    int b;
    int c;
    int count = 0;
    TimeServer timeServer;
    Component component;


    public void run(){
        int q = Integer.parseInt(String.valueOf(2));
        a = (int) (Math.random() * 27);
        b = (int) (Math.random() * 27);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a+b);
        list.add(a-b);
        list.add(a*b);
        list.add(a/b);
        int x = (int) (Math.random() * 3);
        c = list.get(x);
        lb1.setText(Integer.toString(a, q));
        lb2.setText(Integer.toString(b, q));
        lb3.setText(Integer.toString(c, q));
    }

    public void onStart(ActionEvent actionEvent) {
        run();
        timeServer = new TimeServer();
        component = new Component(timeServer, time, true);
        timeServer.attach(new Component(timeServer, time, false));
    }

    public void selection(KeyEvent event) {
        if(event.getCode() == KeyCode.ADD){
            if(a+b == c){
                count++;
                scores.setText(String.valueOf(count));
            }
            else {
                count--;
                scores.setText(String.valueOf(count));
            }
            run();
        }
        if(event.getCode() == KeyCode.SUBTRACT){
            if(a-b == c) {
                count++;
                scores.setText(String.valueOf(count));
            }
            else {
                count--;
                scores.setText(String.valueOf(count));
            }
            run();
        }
        if(event.getCode() == KeyCode.MULTIPLY){
            if(a*b == c) {
                count++;
                scores.setText(String.valueOf(count));
            }
            else {
                count--;
                scores.setText(String.valueOf(count));
            }
            run();
        }
        if(event.getCode() == KeyCode.DIVIDE){
            if(a/b == c) {
                count++;
                scores.setText(String.valueOf(count));
            }
            else {
                count--;
                scores.setText(String.valueOf(count));
            }
            run();
        }
    }
}
