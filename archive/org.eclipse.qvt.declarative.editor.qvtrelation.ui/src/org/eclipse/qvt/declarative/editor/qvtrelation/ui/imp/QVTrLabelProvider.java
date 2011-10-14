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
 * $Id: QVTrLabelProvider.java,v 1.3 2008/08/14 07:58:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtrelation.ui.imp;

import org.eclipse.qvt.declarative.editor.ocl.ui.imp.OCLLabelProvider;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;

public class QVTrLabelProvider extends OCLLabelProvider
{
	@Override
	protected String formatObject(Object node) {
		if (node instanceof QueryCS)
			return super.formatObject(node);
		else
			return super.formatObject(node);
	}

	@Override
	protected ICommonPlugin getPlugin() {
		return QVTrPlugin.getInstance();
	}
}
