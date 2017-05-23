/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.ui.outline.QVTbaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * Customization of the default outline structure.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#outline
 */
public class QVTimperativeOutlineTreeProvider extends QVTbaseOutlineTreeProvider
{
	protected void _createChildren(IOutlineNode parentNode, Mapping ele) {
		assert ele != null;
		for (@NonNull MappingParameter asVariable : QVTimperativeUtil.getOwnedMappingParameters(ele)) {
			createNode(parentNode, asVariable);
		}
		for (Domain asDomain : ele.getDomain()) {
			createNode(parentNode, asDomain);
		}
		for (Statement asStatement : ele.getOwnedStatements()) {
			createNode(parentNode, asStatement);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, MappingLoop ele) {
		if (ele.getOwnedExpression() != null) {
			createNode(parentNode, ele.getOwnedExpression());
		}
		for (LoopVariable asIterator : ele.getOwnedIterators()) {
			createNode(parentNode, asIterator);
		}
		for (MappingStatement asStatement : ele.getOwnedMappingStatements()) {
			createNode(parentNode, asStatement);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, SetStatement ele) {
		createNode(parentNode, ele.getOwnedExpression());
	}

	protected void _createChildren(IOutlineNode parentNode, TopLevelCS ele) {
		for (ImportCS csImport : ele.getOwnedImports()) {
			createNode(parentNode, csImport);
		}
		for (PackageCS csPackage : ele.getOwnedPackages()) {
			createNode(parentNode, csPackage);
		}
		for (TransformationCS csTransformation : ele.getOwnedTransformations()) {
			createNode(parentNode, csTransformation);
		}
		for (QueryCS csQuery : ele.getOwnedQueries()) {
			createNode(parentNode, csQuery);
		}
		for (MappingCS csMapping : ele.getOwnedMappings()) {
			createNode(parentNode, csMapping);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, TransformationCS ele) {
		for (DirectionCS csDirection : ele.getOwnedDirections()) {
			createNode(parentNode, csDirection);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, DeclareStatement ele) {
		createNode(parentNode, ele.getOwnedExpression());
	}

	protected void _createNode(IOutlineNode parentNode, TopLevelCS ele) {
		_createNode(parentNode, (EObject)ele);
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
