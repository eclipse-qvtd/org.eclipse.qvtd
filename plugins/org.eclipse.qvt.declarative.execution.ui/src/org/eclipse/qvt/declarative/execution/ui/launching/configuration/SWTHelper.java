package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SWTHelper {
	public static Composite createComposite(Composite parent, Font font,
			int columns, int hspan, int fill) {
		Composite g = new Composite(parent, SWT.NONE);
		g.setLayout(new GridLayout(columns, false));
		g.setFont(font);
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		g.setLayoutData(gd);
		return g;
	}

	public static Group createGroup(Composite parent, String text,
			int columns, int hspan, int fill) {
		Group g = new Group(parent, SWT.NONE);
		g.setLayout(new GridLayout(columns, false));
		g.setText(text);
		g.setFont(parent.getFont());
		GridData gd = new GridData(fill);
		gd.horizontalSpan = hspan;
		g.setLayoutData(gd);
		return g;
	}

	public static void createLabel(Composite parent, String text,
			int layoutStyle) {
		Label tempLabel;
		tempLabel = new Label(parent, SWT.CENTER);
		tempLabel.setText(text);
		tempLabel.setLayoutData(new GridData(layoutStyle));
	}

	public static Composite createMainComposite(Composite parent) {
		Composite comp = createComposite(parent, parent.getFont(), 2, 1,
				GridData.FILL_HORIZONTAL);
		((GridLayout) comp.getLayout()).verticalSpacing = 0;
		return comp;
	}

	public static Text createSingleText(Composite parent, int hspan) {
		Text t = new Text(parent, SWT.SINGLE | SWT.BORDER);
		t.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = hspan;
		t.setLayoutData(gd);
		return t;
	}
	
	public static void removeCompositeMargin(Composite composite) {
		GridLayout gl = (GridLayout) composite.getLayout();
		gl.marginWidth = 0;
		gl.marginHeight = 0;
	}
	
	public static Button createPushButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		return button;
	}
}
