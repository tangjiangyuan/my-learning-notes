package com.design_pattern.behaviorPattern.observe.weath_issue.improve;

public interface Subjective {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Observer observer);
}
