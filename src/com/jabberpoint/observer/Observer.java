package com.jabberpoint.observer;

import com.jabberpoint.model.Presentation;
import com.jabberpoint.model.Slide;

public interface Observer 
{
	void update(Presentation presentation, Slide slide);
}
