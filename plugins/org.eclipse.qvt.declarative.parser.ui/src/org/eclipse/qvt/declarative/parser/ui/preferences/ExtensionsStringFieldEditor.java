/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.ui.preferences;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * Class used to edit a "*.xxx" extension.
 */
public class ExtensionsStringFieldEditor extends StringFieldEditor
{
	private String oldExtensions = null;
	
	public ExtensionsStringFieldEditor(String name, String labelText, Composite parent) {
		super(name, labelText, parent);
		setEmptyStringAllowed(false);
        setErrorMessage("File-name patterns starting with *. and separated by commas required");
	}
	
    @Override protected boolean checkState() {
        if (getExtensionsFromControl() != null) {
			clearErrorMessage();
			return true;
		}
        else {
			showErrorMessage();
			return false;
        }
    }

	@Override protected void doLoad() {
        String value = getPreferenceStore().getString(getPreferenceName());
		setStringValue(value);
	}

	@Override protected void doLoadDefault() {
        String value = getPreferenceStore().getDefaultString(getPreferenceName());
		setStringValue(value);
	}

	@Override protected void doStore() {
		String extensionsString = getNonNullExtensionsFromControl();
		getPreferenceStore().setValue(getPreferenceName(), extensionsString);
	}

	protected String getExtensionsFromControl() {
		Text textField = getTextControl();
        if (textField == null)
			return null;
        StringBuffer s = null;
        for (String extensionString : textField.getText().split(",")) {
	        String trimmedString = extensionString.trim();
	        if (!trimmedString.startsWith("*."))
	        	return null;
	        if (s == null)
	        	s = new StringBuffer();
	        else
	        	s.append(",");
	        s.append(trimmedString.substring(2));
        }
        return s != null ? s.toString() : null;
	}

	protected String getNonNullExtensionsFromControl() {
		String extensionsString = getExtensionsFromControl();
        return extensionsString != null ? extensionsString : "";
	}

	@Override public String getStringValue() {
		String value = getExtensionsFromControl();
		if (value != null)
			return value;
	    return getPreferenceStore().getString(getPreferenceName());
	}
	
	@Override public void setStringValue(String value) {
		Text textField = getTextControl();
        if (textField != null) {
        	String newExtensions = value != null ? value : "";
            oldExtensions = getNonNullExtensionsFromControl();
            if (!oldExtensions.equals(newExtensions)) {
                StringBuffer s = null;
                for (String newExtension : newExtensions.split(",")) {
        	        if (s == null)
        	        	s = new StringBuffer();
        	        else
        	        	s.append(",");
        	        s.append("*.");
        	        s.append(newExtension);
                }
                textField.setText(s != null ? s.toString() : "");
                valueChanged();
            }
        }
    }

	@Override protected void valueChanged() {
        setPresentsDefaultValue(false);
        boolean oldState = isValid();
        refreshValidState();
        boolean newState = isValid();
        if (newState != oldState) {
			fireStateChanged(IS_VALID, oldState, newState);
		}
		String newExtensions = getNonNullExtensionsFromControl();
        if (!oldExtensions.equals(newExtensions)) {
            fireValueChanged(VALUE, oldExtensions, newExtensions);
            oldExtensions = newExtensions;
        }
	}	
}
