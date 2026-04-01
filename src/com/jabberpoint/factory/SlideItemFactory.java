package com.jabberpoint.factory;

import com.jabberpoint.model.SlideItem;

public interface SlideItemFactory 
{
    SlideItem create(int level, String data, String kind);
}
