package com.jabberpoint.styling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StyleTest {

    @Test
    void createStylesInitializesRetrievableStyles() {
        Style.createStyles();

        Style style0 = Style.getStyle(0);
        Style style2 = Style.getStyle(2);

        assertNotNull(style0);
        assertNotNull(style2);
        assertEquals(0, style0.indent);
        assertEquals(50, style2.indent);
    }

    @Test
    void getStyleClampsTooHighLevelToLastStyle() {
        Style.createStyles();

        Style style4 = Style.getStyle(4);
        Style clamped = Style.getStyle(999);

        assertEquals(style4, clamped);
    }

    @Test
    void getFontScalesFontSize() {
        Style style = new Style(10, java.awt.Color.BLACK, 20, 5);

        int fontSize = style.getFont(1.5f).getSize();

        assertEquals(30, fontSize);
    }
}
