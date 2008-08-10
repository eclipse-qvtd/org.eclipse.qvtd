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
 * $Id: QVTcHoverHelper.java,v 1.1 2008/08/10 13:52:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp;

import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonHoverHelper;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;

public class QVTcHoverHelper extends CommonHoverHelper
{
	@Override
	protected ICommonPlugin getPlugin() {
		return QVTcPlugin.getInstance();
	}
}
