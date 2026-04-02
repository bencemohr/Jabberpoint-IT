package com.jabberpoint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextItemTest {

    @Test
    void testTextItemConstructorAndGetters() {
        TextItem item = new TextItem(1, "Test String");
        assertEquals(1, item.getLevel());
        assertEquals("Test String", item.getText());
    }

    @Test
    void testEmptyTextItem() {
        TextItem item = new TextItem();
        assertEquals(0, item.getLevel());
        assertEquals("No Text Given", item.getText());
    }
}