package com.jabberpoint.controller;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Component;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeyControllerTest {
    private Presentation presentation;
    private KeyController controller;
    private Component dummyComponent;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);
        controller = new KeyController(presentation);
        
        dummyComponent = new Component() {};
    }

    private KeyEvent createEvent(int keyCode) {
        return new KeyEvent(dummyComponent, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, keyCode, KeyEvent.CHAR_UNDEFINED);
    }

    @Test
    void testNextSlideKeys() {
        assertEquals(0, presentation.getSlideNumber());
        
        controller.keyPressed(createEvent(KeyEvent.VK_PAGE_DOWN));
        assertEquals(1, presentation.getSlideNumber());
        
        controller.keyPressed(createEvent(KeyEvent.VK_DOWN));
        assertEquals(2, presentation.getSlideNumber());
        
        controller.keyPressed(createEvent(KeyEvent.VK_ENTER));
        assertEquals(2, presentation.getSlideNumber()); 
        
        presentation.setSlideNumber(0);
        controller.keyPressed(createEvent('+'));
        assertEquals(1, presentation.getSlideNumber()); 
    }

    @Test
    void testPreviousSlideKeys() {
        presentation.setSlideNumber(2);
        
        controller.keyPressed(createEvent(KeyEvent.VK_PAGE_UP));
        assertEquals(1, presentation.getSlideNumber());
        
        controller.keyPressed(createEvent(KeyEvent.VK_UP));
        assertEquals(0, presentation.getSlideNumber());
        
        presentation.setSlideNumber(2);
        controller.keyPressed(createEvent('-'));
        assertEquals(1, presentation.getSlideNumber()); 
    }
}
