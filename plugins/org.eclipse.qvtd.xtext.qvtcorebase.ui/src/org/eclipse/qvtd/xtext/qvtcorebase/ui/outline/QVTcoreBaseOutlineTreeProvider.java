/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.ui.outline;

import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.xtext.qvtbase.ui.outline.QVTbaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
public class QVTcoreBaseOutlineTreeProvider extends QVTbaseOutlineTreeProvider
{
//	protected void _createChildren(IOutlineNode parentNode, AssignmentCS csOperator) {
//		createNode(parentNode, csOperator.getInitialiser());
//	}

	protected void _createChildren(IOutlineNode parentNode, BottomPattern ele) {
		for (Variable asVariable : ele.getRealizedVariable()) {
			createNode(parentNode, asVariable);
		}
		for (Variable asVariable : ele.getVariable()) {
			createNode(parentNode, asVariable);
		}
		for (Predicate asPredicate : ele.getPredicate()) {
			createNode(parentNode, asPredicate);
		}
		for (Assignment asAssignment : ele.getAssignment()) {
			createNode(parentNode, asAssignment);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, GuardPattern ele) {
		for (Variable asVariable : ele.getVariable()) {
			createNode(parentNode, asVariable);
		}
		for (Predicate asPredicate : ele.getPredicate()) {
			createNode(parentNode, asPredicate);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, PropertyAssignment ele) {
		createNode(parentNode, ele.getValue());
	}

	protected void _createChildren(IOutlineNode parentNode, TransformationCS ele) {
		for (DirectionCS csDirection : ele.getOwnedDirections()) {
			createNode(parentNode, csDirection);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, VariableAssignment ele) {
		createNode(parentNode, ele.getValue());
	}

/*	protected void _createNode(IOutlineNode parentNode, Predicate ele) {
		OCLExpression conditionExpression = ele.getConditionExpression();
		if (conditionExpression != null) {
			createNode(parentNode, conditionExpression);
		}
		else {
			super._createNode(parentNode, ele);
		}
	} */

	protected boolean _isLeaf(QueryCS csExp) {
		return csExp.getOwnedExpression() == null;
	}
}
