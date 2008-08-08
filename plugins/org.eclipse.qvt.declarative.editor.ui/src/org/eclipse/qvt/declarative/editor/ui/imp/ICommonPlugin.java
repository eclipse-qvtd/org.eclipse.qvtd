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
 * $Id: ICommonPlugin.java,v 1.1 2008/08/08 16:42:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.imp.runtime.IPluginLog;
import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.Bundle;

/**
 * ICommonPlugin defines capabilities that an editing plugin should
 * proivide to support the common editing framework.
 */
public interface ICommonPlugin extends IPluginLog
{
	public Bundle getBundle();
	public CommonEditorDefinition getEditorDefinition();
	public ImageRegistry getImageRegistry();
}
