package com.jabberpoint.command;

import com.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;

import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BlockingCommandsTest {

    @Test
    void testExitCommandCreation() {
        Command exit = new ExitCommand();
        assertNotNull(exit, "ExitCommand should instantiate correctly.");
    }

    @Test
    void testGoToSlideCommandCreation() {
        Presentation presentation = new Presentation();
        Command goTo = new GoToSlideCommand(presentation);
        assertNotNull(goTo, "GoToSlideCommand should instantiate correctly.");
    }

    @Test
    void testOpenPresentationCommandCreation() {
        if (GraphicsEnvironment.isHeadless()) return;
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        Command open = new OpenPresentationCommand(presentation, frame);
        assertNotNull(open, "OpenPresentationCommand should instantiate correctly.");
    }

    @Test
    void testSavePresentationCommandCreation() {
        if (GraphicsEnvironment.isHeadless()) return;
        Presentation presentation = new Presentation();
        JFrame frame = new JFrame();
        Command save = new SavePresentationCommand(presentation, frame);
        assertNotNull(save, "SavePresentationCommand should instantiate correctly.");
    }
}