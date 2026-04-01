package com.jabberpoint.command;

import javax.swing.JOptionPane;

import com.jabberpoint.model.Presentation;

public class GoToSlideCommand implements Command 
{

    protected static final String PAGENR = "Page number?";

    private final Presentation presentation;

    public GoToSlideCommand(Presentation presentation) 
    {
        this.presentation = presentation;
    }

    @Override
    public void execute() 
    {        
	    String pageNumberStr = JOptionPane.showInputDialog((Object)PAGENR);
	    int pageNumber = Integer.parseInt(pageNumberStr);
	    presentation.setSlideNumber(pageNumber - 1);
    }

}
