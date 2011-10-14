package org.eclipse.qvt.declarative.test.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**
 * A ButtonPress may be queued by Display.asyncExec just before
 * triggering the activation of a Dialog, so that a button
 * with designated label is pressed on the next opportunity.
 * The required button must be a sibling of the default dialog button.
 */
public final class ButtonPress implements Runnable
{
	private final Display display;
	private final String buttonLabel;

	public ButtonPress(Display display, String buttonLabel) {
		this.display = display;
		this.buttonLabel = buttonLabel;
	}

	public void run() {
		Shell[] shells = display.getShells();
		for (int i = shells.length; --i >= 0; ) {
			Shell shell = shells[i];
			Button defaultButton = shell.getDefaultButton();
			Composite buttonParent = defaultButton.getParent();
			for (Control buttonSibling : buttonParent.getChildren()) {
				if (buttonSibling instanceof Button) {
					Button button = (Button) buttonSibling;
					if (buttonLabel.equals(button.getText())) {
						Event e = new Event();
						e.type = SWT.Selection;
						e.widget = button;
						for (Listener listener : button.getListeners(SWT.Selection))
							listener.handleEvent(e);
						return;
					}
				}
			}
		}
	}
}