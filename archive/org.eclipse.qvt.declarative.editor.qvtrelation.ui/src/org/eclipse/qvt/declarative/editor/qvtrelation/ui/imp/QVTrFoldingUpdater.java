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
 * $Id: QVTrFoldingUpdater.java,v 1.1 2008/08/10 13:51:13 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonFoldingUpdater;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;

public class QVTrFoldingUpdater  extends CommonFoldingUpdater
{
	@Override
	protected ICommonPlugin getPlugin() {
		return QVTrPlugin.getInstance();
	}
}