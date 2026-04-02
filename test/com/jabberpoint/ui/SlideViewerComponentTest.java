package com.jabberpoint.ui;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlideViewerComponentTest {

    @Test
    void testComponentInitializationSize() {
        if (GraphicsEnvironment.isHeadless()) return;
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        try {
            SlideViewerComponent component = new SlideViewerComponent(presentation, frame);

            Dimension preferredSize = component.getPreferredSize();
            assertEquals(Slide.WIDTH, preferredSize.width);
            assertEquals(Slide.HEIGHT, preferredSize.height);
        } finally {
            frame.dispose();
        }
    }
}