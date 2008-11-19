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
 * IFormatResult defines the interface of the object (typically a StringBuilder)
 * that builds the formatted result. The formatting may format options.
 */
public interface IFormatResult
{
	public static interface IFormatOption<T> {}
	
	/**
	 * If the SHOW_CLASS_NAME option is present and true, the value of object.getClass().getName()
	 * is prefixed to the formatted description of each object.
	 */
	public static final IFormatOption<Boolean> SHOW_CLASS_NAME = new IFormatOption<Boolean>() {};
	
	/**
	 * If the SHOW_CLASS_SIMPLE_NAME option is present and true, the value of object.getClass().getSimpleName()
	 * is prefixed to the formatted description of each object.
	 */
	public static final IFormatOption<Boolean> SHOW_CLASS_SIMPLE_NAME = new IFormatOption<Boolean>() {};
	
	public void append(String string);
	public void format(Object object);
	public <T> T getOption(IFormatOption<T> option);
	public <T> void setOption(IFormatOption<T> option, T value);
	public void subformat(Object object);
}
