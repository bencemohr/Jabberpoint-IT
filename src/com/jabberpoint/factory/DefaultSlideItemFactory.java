package com.jabberpoint.factory;

import com.jabberpoint.model.BitmapItem;
import com.jabberpoint.model.SlideItem;
import com.jabberpoint.model.TextItem;

public class DefaultSlideItemFactory implements SlideItemFactory 
{
    @Override
    public SlideItem create(int level, String data, String kind) {
        if (kind.equals("text")) {
            return new TextItem(level, data);
        }
        else if (kind.equals("image")) {
            return new BitmapItem(level, data);
        }
        else {
            System.err.println("Unknown kind: " + kind);
            return null;
        }
    }
}
