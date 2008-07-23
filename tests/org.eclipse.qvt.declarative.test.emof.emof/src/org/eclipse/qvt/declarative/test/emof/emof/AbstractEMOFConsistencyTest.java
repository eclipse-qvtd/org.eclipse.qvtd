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
package org.eclipse.qvt.declarative.test.emof.emof;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.test.emof.AbstractConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public abstract class AbstractEMOFConsistencyTest extends AbstractConsistencyTest
{
	protected void expectedEMOFInconsistencies(Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies, Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) {
		org.eclipse.emf.ecore.EcorePackage ecore = org.eclipse.emf.ecore.EcorePackage.eINSTANCE;
		EMOFPackage emof = EMOFPackage.eINSTANCE;
//		for (EClassifier emofClassifier : emof.getEClassifiers()) {
//FIXME name changes			
//		}
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEClass_ESuperTypes(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEClass_ESuperTypes(), ecore.getEStructuralFeature_Unsettable()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
//		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEFactory_EPackage(), ecore.getEStructuralFeature_Transient()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEOperation_EExceptions(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEOperation_EExceptions(), ecore.getEStructuralFeature_Unsettable()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEPackage_EClassifiers(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEPackage_ESubpackages(), ecore.getETypedElement_Ordered()), new InconsistencyValue(Boolean.TRUE, Boolean.FALSE));
		//
		extraEcoreObjectInconsistency(ecoreInconsistencies, new InconsistencyKey(ecore.getEReference_EKeys(), null), new InconsistencyValue(ecore.getEReference_EKeys(), null));
		//
		extraAdaptingObjectInconsistency(adaptingInconsistencies, new InconsistencyKey(emof.getFactory_Package(), null), new InconsistencyValue(emof.getFactory_Package(), null));
		extraAdaptingObjectInconsistency(adaptingInconsistencies, new InconsistencyKey(emof.getComment_AnnotatedElement(), null), new InconsistencyValue(emof.getComment_AnnotatedElement(), null));
		extraAdaptingObjectInconsistency(adaptingInconsistencies, new InconsistencyKey(emof.getTag_Element(), null), new InconsistencyValue(emof.getTag_Element(), null));
	//	extraEcoreObjectInconsistency(adaptingInconsistencies, new InconsistencyKey(emof.getTag_Value(), null), new InconsistencyValue(emof.getTag_Value(), null));
		if (htmlStream != null)
			htmlStream.println("<p>");
	}

	@Override
	protected void getExpectedDerivedPackageInconsistencies(
			Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies,
			Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) {
		super.getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		expectedEMOFInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		installEcore2EmofMappings(comparator, getPackage(resourceSet, EMOF_PACKAGE_NAME));
	}

	private void installEcore2EmofMappings(EquivalenceMap comparator, EPackage emofPackage) {
		comparator.putEquivalence(EcorePackage.eINSTANCE, emofPackage);
		comparator.putEquivalence(EcorePackage.Literals.EBOOLEAN, getDataType(emofPackage, "Boolean"));
		comparator.putEquivalence(EcorePackage.Literals.ECLASS, getClass(emofPackage, "Class"));
		comparator.putEquivalence(EcorePackage.Literals.ECLASSIFIER, getClass(emofPackage, "Type"));
		comparator.putEquivalence(EcorePackage.Literals.EMODEL_ELEMENT, getClass(emofPackage, "Element"));
		comparator.putEquivalence(EcorePackage.Literals.ENAMED_ELEMENT, getClass(emofPackage, "NamedElement"));
		comparator.putEquivalence(EcorePackage.Literals.ENAMED_ELEMENT__NAME, getFeature(getClass(emofPackage, "NamedElement"), "name"));
		comparator.putEquivalence(EcorePackage.Literals.EOBJECT, getClass(emofPackage, "Object"));
		comparator.putEquivalence(EcorePackage.Literals.EOPERATION, getClass(emofPackage, "Operation"));
		comparator.putEquivalence(EcorePackage.Literals.EOPERATION__EPARAMETERS, getFeature(getClass(emofPackage, "Operation"), "ownedParameter"));
		comparator.putEquivalence(EcorePackage.Literals.EPACKAGE, getClass(emofPackage, "Package"));
		comparator.putEquivalence(EcorePackage.Literals.EPARAMETER, getClass(emofPackage, "Parameter"));
		comparator.putEquivalence(EcorePackage.Literals.EPARAMETER__EOPERATION, getFeature(getClass(emofPackage, "Parameter"), "operation"));
		comparator.putEquivalence(EcorePackage.Literals.ESTRING, getDataType(emofPackage, "String"));
		comparator.putEquivalence(EcorePackage.Literals.ESTRUCTURAL_FEATURE, getClass(emofPackage, "Property"));
		comparator.putEquivalence(EcorePackage.Literals.ETYPED_ELEMENT, getClass(emofPackage, "TypedElement"));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		installEmof2EmofMappings(comparator, getPackage(resourceSet, EMOF_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		installEmof2EmofMappings(comparator, getPackage(resourceSet, EMOF_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		EPackage primitivePackage = getPackage(resourceSet, "primitivetypes");
		installEmof2EmofMappings(comparator, getPackage(resourceSet, EMOF_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.Literals.BOOLEAN, getDataType(primitivePackage, "Boolean"));
		comparator.putEquivalence(org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.Literals.INTEGER, getDataType(primitivePackage, "Integer"));
		comparator.putEquivalence(org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.Literals.STRING, getDataType(primitivePackage, "String"));
		comparator.putEquivalence(org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.Literals.UNLIMITED_NATURAL, getDataType(primitivePackage, "UnlimitedNatural"));
	}

	private void installEmof2EmofMappings(EquivalenceMap comparator, EPackage emofPackage) {
		comparator.putEquivalence(EMOFPackage.eINSTANCE, emofPackage);
		// Need to map anything that may be out of order in an unordered list
		comparator.putEquivalence(EMOFPackage.Literals.MULTIPLICITY_ELEMENT, getClass(emofPackage, "MultiplicityElement"));
		comparator.putEquivalence(EMOFPackage.Literals.PARAMETER, getClass(emofPackage, "Parameter"));
		comparator.putEquivalence(EMOFPackage.Literals.TYPED_ELEMENT, getClass(emofPackage, "TypedElement"));
	}
}
