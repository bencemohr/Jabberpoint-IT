package com.jabberpoint.factory;

import com.jabberpoint.model.BitmapItem;
import com.jabberpoint.model.SlideItem;
import com.jabberpoint.model.TextItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;

class DefaultSlideItemFactoryTest {

    @Test
    void createReturnsTextItemForTextKind() {
        DefaultSlideItemFactory factory = new DefaultSlideItemFactory();

        SlideItem item = factory.create(1, "Hello", "text");

        assertInstanceOf(TextItem.class, item);
    }

    @Test
    void createReturnsBitmapItemForImageKind() {
        DefaultSlideItemFactory factory = new DefaultSlideItemFactory();

        SlideItem item = factory.create(1, "non-existing-file.jpg", "image");

        assertInstanceOf(BitmapItem.class, item);
    }

    @Test
    void createReturnsNullForUnknownKind() {
        DefaultSlideItemFactory factory = new DefaultSlideItemFactory();

        SlideItem item = factory.create(1, "Hello", "unknown");

        assertNull(item);
    }
}
