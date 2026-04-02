package com.jabberpoint.model;

import com.jabberpoint.observer.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class PresentationTest {

    @Test
    void clearResetsPresentationState() {
        Presentation presentation = new Presentation();
        presentation.append(new Slide());
        presentation.setSlideNumber(0);

        presentation.clear();

        assertEquals(0, presentation.getSize());
        assertEquals(-1, presentation.getSlideNumber());
        assertNull(presentation.getCurrentSlide());
    }

    @Test
    void appendAndGetSlideWorkAsExpected() {
        Presentation presentation = new Presentation();
        Slide first = new Slide();
        Slide second = new Slide();

        presentation.append(first);
        presentation.append(second);

        assertEquals(2, presentation.getSize());
        assertEquals(first, presentation.getSlide(0));
        assertEquals(second, presentation.getSlide(1));
        assertNull(presentation.getSlide(-1));
        assertNull(presentation.getSlide(2));
    }

    @Test
    void nextAndPreviousSlideStayWithinBounds() {
        Presentation presentation = new Presentation();
        presentation.append(new Slide());
        presentation.append(new Slide());

        presentation.setSlideNumber(0);
        presentation.prevSlide();
        assertEquals(0, presentation.getSlideNumber());

        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());

        presentation.nextSlide();
        assertEquals(1, presentation.getSlideNumber());
    }

    @Test
    void observerIsNotifiedOnSlideChangeAndCanBeRemoved() {
        Presentation presentation = new Presentation();
        Slide slide = new Slide();
        presentation.append(slide);

        CountingObserver observer = new CountingObserver();
        presentation.addObserver(observer);

        presentation.setSlideNumber(0);

        assertEquals(1, observer.updateCount);
        assertEquals(presentation, observer.lastPresentation);
        assertEquals(slide, observer.lastSlide);

        presentation.removeObserver(observer);
        presentation.setSlideNumber(-1);
        assertEquals(1, observer.updateCount);
    }

    private static final class CountingObserver implements Observer {
        private int updateCount;
        private Presentation lastPresentation;
        private Slide lastSlide;

        @Override
        public void update(Presentation presentation, Slide slide) {
            this.updateCount++;
            this.lastPresentation = presentation;
            this.lastSlide = slide;
            assertNotNull(presentation);
        }
    }
}
