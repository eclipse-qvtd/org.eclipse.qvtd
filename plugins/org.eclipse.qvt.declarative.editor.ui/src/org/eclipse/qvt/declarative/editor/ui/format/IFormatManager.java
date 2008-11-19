/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.format;

/**
 * IFormatManager defines the interface of an object able to manage the
 * generation of a formatted description of another object.
 */
public interface IFormatManager
{
	public <T> void format(IFormatResult s, T object);
	public IFormatHelper<?> get(Class<?> formattedClass);
	public void install(IFormatHelper<?> helper);
	public <T> void subformat(IFormatResult s, T object);
}
