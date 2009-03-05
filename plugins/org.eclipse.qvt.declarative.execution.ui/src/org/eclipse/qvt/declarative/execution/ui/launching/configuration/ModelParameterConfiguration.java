package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ModelParameterConfiguration implements LaunchConfigChangeNotifier {
	
	
	private class ModelButtonSelectionListener implements SelectionListener {

		Text relatedText;
		int style;
		Shell shell;


		public ModelButtonSelectionListener(Text relatedText, int style, Shell shell) {
			this.relatedText = relatedText;
			this.style = style;
			this.shell = shell;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

		public void widgetSelected(SelectionEvent e) {
			ResourceDialog rd = new ResourceDialog(
					shell,
					"Model Selection",
					style | SWT.SINGLE);
			rd.open();
			if (rd.getReturnCode() == Window.OK) {
				relatedText.setText(rd.getURIText());
			}
		}
	}
	
	private static ModelParameterConfiguration target = null;
	
	private String name;
	private String uri;
	List<LaunchConfigChangeListener> launchConfigChangeListeners = new ArrayList<LaunchConfigChangeListener>();
	private boolean trace;
	
	public ModelParameterConfiguration(String name, String uri, boolean target) {
		super();
		this.name = name;
		trace = "traces".equals(name);
		this.uri = uri == null ? "" : uri;
		if (target) {
			ModelParameterConfiguration.target = this;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifyLaunchConfigChangeListener();
	}
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
		notifyLaunchConfigChangeListener();
	}
	
	public boolean isTarget() {
		return ModelParameterConfiguration.target == this;
	}
	
	public void setAsTarget() {
		ModelParameterConfiguration.target = this;
		notifyLaunchConfigChangeListener();
	}
		
	public boolean isTrace() {
		return trace;
	}

	public void draw(Composite parent) {
		Label label = new Label(parent, SWT.CENTER);
		label.setText(name);
				
		final Button targetButton = new Button(parent, SWT.RADIO);
		
		targetButton.setSelection(isTarget());
		targetButton.setEnabled(!trace);
		
		Composite subComposite = SWTHelper.createComposite(parent, parent.getFont(), 4,1, GridData.FILL_BOTH);
		SWTHelper.removeCompositeMargin(subComposite);

		Text text = SWTHelper.createSingleText(subComposite, 1);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				Text source = (Text) e.widget;
				setUri(source.getText());
			}
		});
		text.setText(getUri());
		
		Button searchModelButton = SWTHelper.createPushButton(subComposite, "Search");
		searchModelButton.addSelectionListener(new ModelButtonSelectionListener(text, SWT.OPEN, parent.getShell()));
		
		final Button newModelButton = SWTHelper.createPushButton(subComposite, "New...");
		newModelButton.addSelectionListener(new ModelButtonSelectionListener(text, SWT.SAVE, parent.getShell()));
		newModelButton.setEnabled(isTarget()|| isTrace());

		targetButton.addSelectionListener(new SelectionListener(){
			public void widgetSelected(SelectionEvent e) {
				if (targetButton.getSelection()) {
					setAsTarget();
					newModelButton.setEnabled(true);
				} else {
					newModelButton.setEnabled(false);
				}
			}
		
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	public void addLaunchConfigChangeListener(
			LaunchConfigChangeListener listener) {
		launchConfigChangeListeners.add(listener);
		
	}

	public void notifyLaunchConfigChangeListener() {
		for (LaunchConfigChangeListener listener : launchConfigChangeListeners) {
			listener.launchConfigChanged();
		}
	}

	public void removeLaunchConfigChangeListener(
			LaunchConfigChangeListener listener) {
		launchConfigChangeListeners.remove(listener);
	}

}
