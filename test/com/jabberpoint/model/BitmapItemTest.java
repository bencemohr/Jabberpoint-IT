package com.jabberpoint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BitmapItemTest {

    @Test
    void testBitmapItemConstructorSetsState() {
        BitmapItem item = new BitmapItem(2, "TestFile.jpg");
        assertEquals(2, item.getLevel());
        assertEquals("TestFile.jpg", item.getName());
    }

    @Test
    void testBitmapToString() {
        BitmapItem item = new BitmapItem(1, "logo.gif");
        assertEquals("BitmapItem[1,logo.gif]", item.toString());
    }
}