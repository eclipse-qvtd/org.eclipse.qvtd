/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ICommonPlugin.java,v 1.5 2009/01/14 20:44:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.runtime.IPluginLog;
import org.osgi.framework.Bundle;

/**
 * ICommonPlugin defines capabilities that an editing plugin should
 * provide to support the common editing framework.
 */
public interface ICommonPlugin extends IPluginLog
{
	public Bundle getBundle();
	public CommonEditorDefinition getEditorDefinition();
	public String getID();
	public String getLanguageID();
	public void logException(String string, Throwable e);
}
