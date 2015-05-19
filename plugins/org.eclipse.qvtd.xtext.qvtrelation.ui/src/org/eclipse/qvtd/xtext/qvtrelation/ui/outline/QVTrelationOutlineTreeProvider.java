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
package org.eclipse.qvtd.xtext.qvtrelation.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.xtext.qvtbase.ui.outline.QVTbaseOutlineTreeProvider;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * customization of the default outline structure
 * 
 */
public class QVTrelationOutlineTreeProvider extends QVTbaseOutlineTreeProvider
{
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
	}

	protected void _createChildren(IOutlineNode parentNode, Function ele) {
		for (Parameter parameter : ele.getOwnedParameters()) {
			createNode(parentNode, parameter);
		}
		createNode(parentNode, ele.getQueryExpression());
	}

	protected void _createChildren(IOutlineNode parentNode, Pattern ele) {
		EStructuralFeature eContainingFeature = ele.eContainingFeature();
		if ((eContainingFeature == QVTrelationPackage.Literals.RELATION__WHEN)
		 || (eContainingFeature == QVTrelationPackage.Literals.RELATION__WHERE)) {
			for (Predicate asPredicate : ele.getPredicate()) {
				createChildren(parentNode, asPredicate);
			}
		}
		else {
			super._createChildren(parentNode, ele);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, Relation ele) {
		for (Variable asVariable : ele.getVariable()) {
			createNode(parentNode, asVariable);
		}
		Pattern asWhen = ele.getWhen();
		if (asWhen != null) {
			createNode(parentNode, asWhen);
		}
		for (Domain asDomain : ele.getDomain()) {
			if (asDomain.isIsCheckable() && !asDomain.isIsEnforceable()) {
				createNode(parentNode, asDomain);
			}
		}
		for (Domain asDomain : ele.getDomain()) {
			if (!asDomain.isIsCheckable() && !asDomain.isIsEnforceable()) {
				createNode(parentNode, asDomain);
			}
		}
		for (Domain asDomain : ele.getDomain()) {
			if (asDomain.isIsCheckable() && asDomain.isIsEnforceable()) {
				createNode(parentNode, asDomain);
			}
		}
		for (Domain asDomain : ele.getDomain()) {
			if (!asDomain.isIsCheckable() && asDomain.isIsEnforceable()) {
				createNode(parentNode, asDomain);
			}
		}
		Pattern asWhere = ele.getWhere();
		if (asWhere != null) {
			createNode(parentNode, asWhere);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, RelationalTransformation ele) {
		for (TypedModel asTypedModel : ele.getModelParameter()) {
			createNode(parentNode, asTypedModel);
		}
		for (Key asKey : ele.getOwnedKey()) {
			createNode(parentNode, asKey);
		}
		for (Operation asOperation : ele.getOwnedOperations()) {
			createNode(parentNode, asOperation);
		}
		for (Rule asRule : ele.getRule()) {
			createNode(parentNode, asRule);
		}
	}

	protected void _createNode(IOutlineNode parentNode, DomainPattern pattern) {
		createNode(parentNode, pattern.getTemplateExpression());
	}

	protected void _createNode(IOutlineNode parentNode, PathNameCS csPath) {
		Element element = csPath.getReferredElement();
		if ((element != null) && !element.eIsProxy()) {
			createNode(parentNode, element);
		}
	}

	protected void _createNode(IOutlineNode parentNode, PredicateCS csPredicate) {
		createNode(parentNode, csPredicate.getOwnedCondition());
	}

	protected void _createNode(IOutlineNode parentNode, TopLevelCS ele) {
		_createNode(parentNode, (EObject)ele);
	}

	protected void _createNode(IOutlineNode parentNode, VarDeclarationCS csVars) {
		for (VarDeclarationIdCS var : csVars.getOwnedVarDeclarationIds()) {
			createNode(parentNode, var);
		}
	}
}
