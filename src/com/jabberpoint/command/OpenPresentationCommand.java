package com.jabberpoint.command;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.jabberpoint.data.Accessor;
import com.jabberpoint.data.XMLAccessor;
import com.jabberpoint.model.Presentation;

public class OpenPresentationCommand implements Command
{

    private final Presentation presentation;
    private final Frame parent;
	
	protected static final String TESTFILE = "test.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";

    public OpenPresentationCommand(Presentation presentation, Frame parent) 
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() 
    {
        presentation.clear();
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.loadFile(presentation, TESTFILE);
					presentation.setSlideNumber(0);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc, 
         			LOADERR, JOptionPane.ERROR_MESSAGE);
				}
				parent.repaint();
    }

}
