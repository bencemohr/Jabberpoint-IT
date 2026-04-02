package com.jabberpoint.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class SlideTest {

    @Test
    void appendTextCreatesTextItemWithExpectedValues() {
        Slide slide = new Slide();

        slide.append(2, "Hello");

        assertEquals(1, slide.getSize());
        SlideItem item = slide.getSlideItem(0);
        assertInstanceOf(TextItem.class, item);
        assertEquals(2, item.getLevel());
        assertEquals("Hello", ((TextItem) item).getText());
    }

    @Test
    void appendSlideItemKeepsInsertionOrder() {
        Slide slide = new Slide();
        TextItem first = new TextItem(1, "A");
        TextItem second = new TextItem(3, "B");

        slide.append(first);
        slide.append(second);

        assertEquals(2, slide.getSize());
        assertEquals(first, slide.getSlideItem(0));
        assertEquals(second, slide.getSlideItem(1));
    }

    @Test
    void titleCanBeSetAndReadBack() {
        Slide slide = new Slide();

        slide.setTitle("My Slide");

        assertEquals("My Slide", slide.getTitle());
    }
}
