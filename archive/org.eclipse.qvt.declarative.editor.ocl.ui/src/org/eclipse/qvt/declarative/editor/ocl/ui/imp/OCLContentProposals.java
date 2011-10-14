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
 * $Id: OCLContentProposals.java,v 1.4 2009/08/20 20:22:31 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonContentProposals;
import org.eclipse.qvt.declarative.editor.ui.imp.ICommonParseResult;

public class OCLContentProposals extends CommonContentProposals
{
	public OCLContentProposals(ICommonParseResult parseResult, int offset) {
		super(parseResult, offset);
	}

	@Override
	public Set<EClass> getCompletableTypes(EClassifier requiredType, CSTNode cstNode) {
		Set<EClass> completableClasses = super.getCompletableTypes(requiredType, cstNode);
		if (requiredType instanceof EClass) {
			EClass requiredClass = (EClass) requiredType;
			if (ExpressionsPackage.Literals.OCL_EXPRESSION.isSuperTypeOf(requiredClass)) {
				completableClasses.add(org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE);
				Object astNode = cstNode.getAst();
				if ((astNode instanceof InvalidLiteralExp) && (cstNode instanceof SimpleNameCS))
					completableClasses.add(org.eclipse.emf.ecore.EcorePackage.Literals.ENAMED_ELEMENT);
			}
		}
		return completableClasses;
	}

	/**
	 * Return the text to appear in the list of proposals for proposal for which newText is the replacement.
	 * 
	 * @param labelProvider
	 * @param proposal
	 * @param newText
	 * @return
	 */
	@Override
	protected String getProposalDisplayText(ILabelProvider labelProvider, EObject proposal, String newText) {
		EObject container = proposal.eContainer();
		if (container instanceof EModelElement) {
			EAnnotation annotation = ((EModelElement) container).getEAnnotation(Environment.OCL_NAMESPACE_URI);
			if (annotation != null) {
				EList<EObject> references = annotation.getReferences();
				if (references.size() >= 1) {
					EObject reference = references.get(0);
					if (reference instanceof EClassifier)
						container = reference;		// Use the augmented class for an extended class
				}
			}
		}
		String containerText = EcoreUtils.formatQualifiedName(container, "::");
//		String containerText = labelProvider.getText(container);
		return newText + " - " + containerText;
	}
}
