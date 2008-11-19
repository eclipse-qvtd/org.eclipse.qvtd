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
package org.eclipse.qvt.declarative.editor.ui.format;

import java.util.HashMap;
import java.util.Map;

/**
 * AbstractFormatResult builds the formatted description on behalf of a
 * IFormatManager.
 */
public abstract class AbstractFormatResult implements IFormatResult
{	
	protected final IFormatManager manager;
	protected Map<IFormatOption<?>, Object> options = null;
	
	protected AbstractFormatResult(IFormatManager manager, Map<IFormatOption<?>, Object> options) {
		this.manager = manager;
		this.options = options;
	}

	public void format(Object object) {
		manager.format(this, object);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getOption(IFormatOption<T> option) {
		return options != null ? (T) options.get(option) : null;
	}

	public <T> void setOption(IFormatOption<T> option, T value) {
		if (options == null)
			options = new HashMap<IFormatOption<?>, Object>();
		options.put(option, value);
	}	

	public void subformat(Object object) {
		manager.subformat(this, object);
	}
}