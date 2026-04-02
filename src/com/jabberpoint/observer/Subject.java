package com.jabberpoint.observer;

public interface Subject 
{
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
}
