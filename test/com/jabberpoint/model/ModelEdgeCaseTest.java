package com.jabberpoint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModelEdgeCaseTest {
    @Test
    public void testNegativeSlideIndex() {
        Presentation presentation = new Presentation();
        presentation.setSlideNumber(-1);
        assertEquals(-1, presentation.getSlideNumber());
    }

    @Test
    public void testOutOfBoundsSlideIndex() {
        Presentation presentation = new Presentation();
        presentation.setSlideNumber(999);
        assertEquals(999, presentation.getSlideNumber());
    }
}
