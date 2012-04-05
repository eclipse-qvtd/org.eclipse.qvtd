/******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.environment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.qvt.declarative.ecore.utils.CSTFormattingHelper;
import org.eclipse.qvt.declarative.parser.unresolved.UnresolvedPackage;

public abstract class CSTEnvironment<E extends ICSTEnvironment> extends EcoreEnvironment implements ICSTEnvironment
{
	protected CSTEnvironment(EPackage.Registry reg) {
		super(reg);
	}

	public CSTEnvironment(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
	}

	public CSTEnvironment(ICSTEnvironment parent) {
		super(parent);
	}

	@Override
	protected CSTFormattingHelper createFormattingHelper() {
		return CSTFormattingHelper.INSTANCE;
	}
	
	@Override
	public CSTFormattingHelper getFormatter() {
		return (CSTFormattingHelper) super.getFormatter();
	}
	   
	@Deprecated
	public EAttribute getUnresolvedAttribute() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedAttribute();
	}

	@Deprecated
	public EClass getUnresolvedClass() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass();
	}

	@Deprecated
	public EClassifier getUnresolvedClassifier() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClassifier();
	}

	@Deprecated
	public EDataType getUnresolvedDataType() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedDataType();
	}

	@Deprecated
	public EOperation getUnresolvedOperation() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass().getEOperations().get(0);
	}

	@Deprecated
	public EStructuralFeature getUnresolvedProperty() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedProperty();
	}

	@Deprecated
	public EReference getUnresolvedReference() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedReference();
	}
}
