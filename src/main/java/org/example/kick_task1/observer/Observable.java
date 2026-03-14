package org.example.kick_task1.observer;

public interface Observable {

  void addObserver(Observer observer);

  void removeObserver(Observer observer);

  void notifyObservers();
}
