package com.jabberpoint.ui;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.awt.GraphicsEnvironment;

public class UICoverageTest {
    @Test
    public void testAboutBoxInstantiation() {
        Assumptions.assumeFalse(GraphicsEnvironment.isHeadless(),
                "Skipping AboutBox test in headless environment");
        AboutBox.show(null);
    }
}
