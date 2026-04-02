package com.jabberpoint.command;

import com.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import static org.junit.jupiter.api.Assertions.*;

public class SavePresentationCommandTest {
    @Test
    public void testSaveCommand() {
        if (GraphicsEnvironment.isHeadless()) return;
        Presentation p = new Presentation();
        SavePresentationCommand cmd = new SavePresentationCommand(p, new Frame());
        assertNotNull(cmd);
    }
}
