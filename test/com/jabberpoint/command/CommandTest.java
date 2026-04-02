package com.jabberpoint.command;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    private Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.append(new Slide());
        presentation.setSlideNumber(0);
    }

    @Test
    void testNextSlideCommand() {
        Command next = new NextSlideCommand(presentation);
        
        assertEquals(0, presentation.getSlideNumber());
        next.execute();
        assertEquals(1, presentation.getSlideNumber());
        next.execute();
        assertEquals(2, presentation.getSlideNumber());
        next.execute();
        assertEquals(2, presentation.getSlideNumber()); // Should not go past end
    }

    @Test
    void testPreviousSlideCommand() {
        Command prev = new PreviousSlideCommand(presentation);
        
        presentation.setSlideNumber(2);
        prev.execute();
        assertEquals(1, presentation.getSlideNumber());
        prev.execute();
        assertEquals(0, presentation.getSlideNumber());
        prev.execute();
        assertEquals(0, presentation.getSlideNumber()); // Should not go below 0
    }
}
