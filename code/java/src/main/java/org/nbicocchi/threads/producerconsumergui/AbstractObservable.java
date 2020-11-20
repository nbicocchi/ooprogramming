package org.nbicocchi.threads.producerconsumergui;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObservable {
    List<SizeListener> listeners;

    public AbstractObservable() {
        listeners = new ArrayList<>();
    }

    public void addListener(SizeListener toAdd) {
        listeners.add(toAdd);
    }

    public void notifyListeners(int size) {
        for (SizeListener sl : listeners)
            sl.sizeChanged(size);
    }

}