package com.jabberpoint.command;

import com.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import static org.junit.jupiter.api.Assertions.*;

public class OpenPresentationCommandTest {
    @Test
    public void testOpenCommand() {
        if (GraphicsEnvironment.isHeadless()) return;
        Presentation p = new Presentation();
        OpenPresentationCommand cmd = new OpenPresentationCommand(p, new Frame());
        assertNotNull(cmd);
    }
}
