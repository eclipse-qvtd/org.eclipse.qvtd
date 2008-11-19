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
 * IFormatHelper defines the interface of an object able to help format the descriptions
 * of a class of other objects.
 */
public interface IFormatHelper<T>
{
	public void format(IFormatResult s, T object);
	public Class<T> getFormattedClass();
	public IFormatManager getFormatManager();
}