package com.jabberpoint.controller;

import com.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;

import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuControllerTest {

    @Test
    void testMenuControllerCreation() {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Headless environment, skipping UI test");
            return;
        }
        
        Frame dummyFrame = new Frame();
        Presentation presentation = new Presentation();
        
        MenuController menu = new MenuController(dummyFrame, presentation);
        assertNotNull(menu);
        assertEquals(3, menu.getMenuCount(), "File, View, Help menus expected");
        
        dummyFrame.dispose();
    }
}
