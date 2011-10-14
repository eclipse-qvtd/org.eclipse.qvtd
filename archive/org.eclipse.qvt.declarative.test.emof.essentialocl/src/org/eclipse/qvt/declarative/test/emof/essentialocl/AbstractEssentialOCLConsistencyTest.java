/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.essentialocl;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;
import org.eclipse.qvt.declarative.test.emof.emof.AbstractEMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public abstract class AbstractEssentialOCLConsistencyTest extends AbstractEMOFConsistencyTest
{
	protected void expectedEssentialOCLInconsistencies(Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies, Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) {
		org.eclipse.emf.ecore.EcorePackage ecore = org.eclipse.emf.ecore.EcorePackage.eINSTANCE;
		ExpressionsPackage oclExpr = ExpressionsPackage.eINSTANCE;
		TypesPackage oclType = TypesPackage.eINSTANCE;
		UtilitiesPackage oclUtil = UtilitiesPackage.eINSTANCE;

		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getCollectionLiteralExp_Part(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclType.getCollectionType_ElementType(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclUtil.getExpressionInOCL_ContextVariable(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclUtil.getExpressionInOCL_ParameterVariable(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getIfExp_Condition(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getIfExp_ElseExpression(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getIfExp_ThenExpression(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getLetExp_In(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getLetExp_Variable(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getLoopExp_Body(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getTupleLiteralExp_Part(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getTupleLiteralPart_Value(), ecore.getETypedElement_LowerBound()), new InconsistencyValue(Integer.valueOf(0), Integer.valueOf(1)));
//
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getNavigationCallExp_NavigationSource(), null), new InconsistencyValue(oclExpr.getNavigationCallExp_NavigationSource(), null));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(oclExpr.getNavigationCallExp_Qualifier(), null), new InconsistencyValue(oclExpr.getNavigationCallExp_Qualifier(), null));
		if (htmlStream != null)
			htmlStream.println("<p>");
	}

	@Override
	protected void getExpectedDerivedPackageInconsistencies(
			Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies,
			Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) {
		super.getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		expectedEssentialOCLInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		installEcoreOcl2EssentialOclMappings(comparator, getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME));
	}

	private void installEcoreOcl2EssentialOclMappings(EquivalenceMap comparator, EPackage essentialOclPackage) {
		if (essentialOclPackage == null)
			return;
		comparator.putEquivalence(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, essentialOclPackage);
//		comparator.putEquivalence(org.eclipse.ocl.expressions.ExpressionsPackage.eINSTANCE, essentialOclPackage);
//		comparator.putEquivalence(org.eclipse.ocl.types.TypesPackage.eINSTANCE, essentialOclPackage);
//		comparator.putEquivalence(org.eclipse.ocl.utilities.UtilitiesPackage.eINSTANCE, essentialOclPackage);
		comparator.putEquivalence(org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION, getClass(essentialOclPackage, "OclExpression"));
//		comparator.putEquivalence(org.eclipse.ocl.ecore.EcorePackage.Literals.OPERATION_CALL_EXP, getClass(essentialOclPackage, "OperationCallExp"));
//		comparator.putEquivalence(org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE, getClass(essentialOclPackage, "Variable"));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		installEssentialOcl2EssentialOclMappings(comparator, getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		installEssentialOcl2EssentialOclMappings(comparator, getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		EPackage oclPackage = getPackage(resourceSet, "essentialocl");
		installEssentialOcl2EssentialOclMappings(comparator, oclPackage);
		comparator.putEquivalence(org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.Literals.OCL_EXPRESSION, getClass(oclPackage, "OclExpression"));
	}

	private void installEssentialOcl2EssentialOclMappings(EquivalenceMap comparator, EPackage essentialOclPackage) {
		if (essentialOclPackage == null)
			return;
		comparator.putEquivalence(EssentialOCLPackage.eINSTANCE, essentialOclPackage);
	}
}
