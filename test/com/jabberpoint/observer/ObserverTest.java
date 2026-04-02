package com.jabberpoint.observer;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObserverTest {

    static class MockSubject implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        @Override
        public void addObserver(Observer observer) { observers.add(observer); }

        @Override
        public void removeObserver(Observer observer) { observers.remove(observer); }
        
        public int count() { return observers.size(); }
    }

    static class MockObserver implements Observer {
        boolean wasUpdated = false;

        @Override
        public void update(Presentation presentation, Slide slide) {
            wasUpdated = true;
        }
    }

    @Test
    void testSubjectAddsAndRemovesObserver() {
        MockSubject subject = new MockSubject();
        MockObserver observer = new MockObserver();

        subject.addObserver(observer);
        assertEquals(1, subject.count());

        subject.removeObserver(observer);
        assertEquals(0, subject.count());
    }

    @Test
    void testObserverReceivesUpdate() {
        MockObserver observer = new MockObserver();
        observer.update(new Presentation(), new Slide());
        assertTrue(observer.wasUpdated);
    }
}