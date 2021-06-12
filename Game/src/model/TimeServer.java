package model;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TimeServer implements Subject {

    private long delay = 0;
    private long period = 1000;
    private TimerTask task;
    private Timer timer;
    private int timeState;
    private List<Observer> observers = new ArrayList<>();

    public TimeServer() {
        this.timer = new Timer();
        task = new TimerTask() {
            public void run() {
                tick();
            }
        };
        timer.schedule(task, delay, period);
    }

    private void tick() {
        timeState++;
        notifyAllObserver();
    }

    public int getState() {
        return timeState;
    }

    public void setState(int timeState) {
        this.timeState = timeState;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
