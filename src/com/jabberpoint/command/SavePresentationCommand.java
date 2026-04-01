package com.jabberpoint.command;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.jabberpoint.data.Accessor;
import com.jabberpoint.data.XMLAccessor;
import com.jabberpoint.model.Presentation;

public class SavePresentationCommand implements Command {

    private final Presentation presentation;
    private final Frame parent;

    protected static final String IOEX = "IO Exception: ";
	protected static final String SAVEERR = "Save Error";
    protected static final String SAVEFILE = "dump.xml";

    public SavePresentationCommand(Presentation presentation, Frame parent) 
    {
        this.presentation = presentation;
        this.parent = parent;
    }

    @Override
    public void execute() 
    {
        Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, SAVEFILE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc, 
							SAVEERR, JOptionPane.ERROR_MESSAGE);
				}
    }

}
