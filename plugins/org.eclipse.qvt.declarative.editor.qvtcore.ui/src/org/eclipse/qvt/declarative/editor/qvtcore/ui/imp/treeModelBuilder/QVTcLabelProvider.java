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
 * $Id: QVTcLabelProvider.java,v 1.1 2008/08/09 17:55:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.qvtcore.ui.imp.treeModelBuilder;

import java.util.List;

import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.qvt.declarative.editor.qvtcore.ui.QVTcPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonLabelProvider;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonPlugin;

public class QVTcLabelProvider extends CommonLabelProvider
{
//	private static ImageRegistry sImageRegistry = QVTcPlugin.getInstance().getImageRegistry();

//	private static Image DEFAULT_IMAGE = sImageRegistry
//			.get(IQVTcResources.QVTC_DEFAULT_IMAGE);

	@Override
	protected String formatObject(Object object, Object node, int index) {
		if (object instanceof List) {
			StringBuffer s = new StringBuffer();
			for (Object o : (List<?>)object) {
				if (s.length() > 0)
					s.append("::");
				s.append(formatObject(o, node, index));
			}
			return s.toString();
		}
		else if (object instanceof TypeCS) {
			return formatType((TypeCS)object);
		}
		else if (object instanceof OCLExpressionCS) {
			return formatExpression((OCLExpressionCS)object);
		}
		else
			return super.formatObject(object, node, index);
	}
	
	@Override
	protected ICommonPlugin getPlugin() {
		return QVTcPlugin.getInstance();
	}
	
	public String getText(Object element) {
		String text = super.getText(element);
		return (text != null) ? text : "<???>";
	}
}
