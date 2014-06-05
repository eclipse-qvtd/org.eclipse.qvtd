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
package org.eclipse.qvtd.xtext.qvtrelation.ui.outline;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.xtext.qvtbase.ui.outline.QVTbaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelation.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 * 
 */
public class QVTrelationOutlineTreeProvider extends QVTbaseOutlineTreeProvider
{

	protected void _createNode(IOutlineNode parentNode, DomainPattern pattern) {
		createNode(parentNode, pattern.getTemplateExpression());
	}

	protected void _createNode(IOutlineNode parentNode, PathNameCS csPath) {
		Element element = csPath.getElement();
		if ((element != null) && !element.eIsProxy()) {
			createNode(parentNode, element);
		}
	}

	protected void _createNode(IOutlineNode parentNode, PredicateCS csPredicate) {
		createNode(parentNode, csPredicate.getExpr());
	}

	protected void _createNode(IOutlineNode parentNode, VarDeclarationCS csVars) {
		for (VarDeclarationIdCS var : csVars.getVarDeclarationIds()) {
			createNode(parentNode, var);
		}
	}
}
