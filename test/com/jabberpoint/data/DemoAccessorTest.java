package com.jabberpoint.data;

import com.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoAccessorTest {
    @Test
    public void testLoadDemo() throws Exception {
        Presentation presentation = new Presentation();
        DemoAccessor accessor = new DemoAccessor();
        accessor.loadFile(presentation, "");
        assertTrue(presentation.getSize() > 0, "Demo presentation should have slides");
    }

    @Test
    public void testSaveDemoThrows() {
        Presentation presentation = new Presentation();
        DemoAccessor accessor = new DemoAccessor();
        assertThrows(IllegalStateException.class, () -> accessor.saveFile(presentation, ""));
    }
}
