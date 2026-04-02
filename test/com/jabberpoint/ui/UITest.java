package com.jabberpoint.ui;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import com.jabberpoint.model.TextItem;
import org.junit.jupiter.api.Test;

import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UITest {

    @Test
    void testPresentationWindowCreation() {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Headless environment, skipping UI test");
            return;
        }

        Presentation presentation = new Presentation();
        Slide slide = new Slide();
        slide.append(new TextItem(1, "UI test"));
        presentation.append(slide);

        PresentationWindow window = new PresentationWindow("Test Window", presentation);
        assertNotNull(window);
        assertTrue(window.isVisible());
        assertEquals("Jabberpoint 1.6 - OU", window.getTitle());

        window.dispose();
    }
}
