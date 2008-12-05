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
 * $Id: OCLContentProposals.java,v 1.1 2008/12/05 22:18:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui.imp;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonContentProposals;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController;
import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

public class OCLContentProposals extends CommonContentProposals
{
	public OCLContentProposals(CommonParseController commonParseController, int offset) {
		super(commonParseController, offset);
	}

	@Override
	public Set<EClass> getCompletableTypes(EClassifier requiredType) {
		Set<EClass> completableClasses = super.getCompletableTypes(requiredType);
		if (requiredType instanceof OclExpression) {
			completableClasses.add(org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE);
//			completableClasses.add(org.eclipse.emf.ecore.EcorePackage.Literals.ESTRING);
		}
		return completableClasses;
	}
}
