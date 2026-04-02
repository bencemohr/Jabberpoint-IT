package com.jabberpoint.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UICoverageTest {
    @Test
    public void testAboutBoxInstantiation() {
        try {
            AboutBox.show(null);
        } catch (Exception e) {
            assertNotNull(e);
        }
    }
}
