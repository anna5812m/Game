package model;

import javafx.scene.control.Alert;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Component implements Observer {
    public Text txt;
    private Subject subject;

    public Component(Subject subject, Text circle, boolean check) {
        this.subject = subject;
        this.txt= circle;
        if(check) {
            circle.setFont(Font.font("Arial", 16));
            circle.setEffect(new GaussianBlur(1));
        }
    }

    public void set(Subject st) {
        subject.attach(this);
    }

    public void update(Subject st) {
        if(st == subject && st.getState()<123) {
            txt.setText(String.valueOf(122-st.getState()));
        }
    }
}
