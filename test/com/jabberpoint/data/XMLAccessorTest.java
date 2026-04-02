package com.jabberpoint.data;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;
import com.jabberpoint.model.SlideItem;
import com.jabberpoint.model.TextItem;
import com.jabberpoint.model.BitmapItem;
import com.jabberpoint.factory.SlideItemFactory;
import com.jabberpoint.factory.DefaultSlideItemFactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XMLAccessorTest {

    private XMLAccessor accessor;
    private Presentation presentation;

    @BeforeEach
    void setUp() {
        accessor = new XMLAccessor();
        presentation = new Presentation();
    }

    @Test
    void loadFileReadsPresentationTitleAndSlidesFromTestXml() throws IOException {
        Path testXml = Paths.get("test.xml");
        assertTrue(Files.exists(testXml), "Expected test.xml in project root");

        accessor.loadFile(presentation, testXml.toString());

        assertEquals("XML-Based Presentation for Jabberpoint", presentation.getTitle());
        assertEquals(5, presentation.getSize());
        assertEquals("JabberPoint XML-Demo", presentation.getSlide(0).getTitle());
    }

    @Test
    void loadFileThrowsIOExceptionForMissingFile() throws IOException {
        accessor.loadFile(presentation, "non_existent_file.xml");
        assertEquals(0, presentation.getSize()); 
    }

    @Test
    void saveAndLoadRoundTripKeepsCoreContent() throws IOException {
        presentation.setTitle("Roundtrip");
        Slide slide = new Slide();
        slide.setTitle("Slide 1");
        slide.append(1, "Hello world");
        presentation.append(slide);

        Path out = Files.createTempFile(Paths.get("."), "jabberpoint-roundtrip", ".xml");
        out.toFile().deleteOnExit();

        accessor.saveFile(presentation, out.toString());

        Presentation reloaded = new Presentation();
        accessor.loadFile(reloaded, out.toString());

        assertEquals("Roundtrip", reloaded.getTitle());
        assertEquals(1, reloaded.getSize());
        assertEquals("Slide 1", reloaded.getSlide(0).getTitle());
        assertFalse(reloaded.getSlide(0).getSlideItems().isEmpty());

        SlideItem reloadedItem = reloaded.getSlide(0).getSlideItem(0);
        assertTrue(reloadedItem instanceof TextItem);
        assertEquals("Hello world", ((TextItem) reloadedItem).getText());
    }

    @Test
    void saveAndLoadWithBitmapItem() throws IOException {
        presentation.setTitle("Bitmap Test");
        Slide slide = new Slide();
        slide.setTitle("Bitmap Slide");
        
        BitmapItem bmp = new BitmapItem(2, "JabberPoint.gif");
        slide.append(bmp);
        presentation.append(slide);

        Path out = Files.createTempFile(Paths.get("."), "jabberpoint-bitmap", ".xml");
        out.toFile().deleteOnExit();

        accessor.saveFile(presentation, out.toString());

        Presentation reloaded = new Presentation();
        accessor.loadFile(reloaded, out.toString());

        SlideItem item = reloaded.getSlide(0).getSlideItem(0);
        assertTrue(item instanceof BitmapItem);
        assertEquals("JabberPoint.gif", ((BitmapItem) item).getName());
        assertEquals(2, item.getLevel());
    }
}
