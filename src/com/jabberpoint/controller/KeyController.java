package com.jabberpoint.controller;
import java.awt.event.KeyEvent;

import com.jabberpoint.command.Command;
import com.jabberpoint.command.ExitCommand;
import com.jabberpoint.command.NextSlideCommand;
import com.jabberpoint.command.PreviousSlideCommand;
import com.jabberpoint.model.Presentation;

import java.awt.event.KeyAdapter;

/** <p>This is the KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	private Presentation presentation; // Commands are given to the presentation

	public KeyController(Presentation p) {
		presentation = p; // CI test trigger
	}

	public void keyPressed(KeyEvent keyEvent) {
		Command command = null;
		switch(keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				command = new NextSlideCommand(this.presentation);
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				command = new PreviousSlideCommand(this.presentation);
				break;
			case 'q':
			case 'Q':
				command = new ExitCommand();
				break; // Probably never reached!!
			default:
				break;
		}

		if (command != null) 
		{
			command.execute();
		}
	}
}
