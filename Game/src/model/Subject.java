package model;

public interface Subject {
    public void notifyAllObserver();
    public void attach(Observer obs);
    public void detach(Observer obs);
    public int getState();
}
