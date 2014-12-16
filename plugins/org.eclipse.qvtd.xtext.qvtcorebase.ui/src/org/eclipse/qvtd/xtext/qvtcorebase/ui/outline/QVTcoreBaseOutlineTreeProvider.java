/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.ui.outline;

import org.eclipse.qvtd.xtext.qvtbase.ui.outline.QVTbaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
public class QVTcoreBaseOutlineTreeProvider extends QVTbaseOutlineTreeProvider
{
	protected void _createChildren(IOutlineNode parentNode, AssignmentCS csOperator) {
		createNode(parentNode, csOperator.getInitialiser());
	}

	protected boolean _isLeaf(QueryCS csExp) {
		return csExp.getExpression() == null;
	}
}
