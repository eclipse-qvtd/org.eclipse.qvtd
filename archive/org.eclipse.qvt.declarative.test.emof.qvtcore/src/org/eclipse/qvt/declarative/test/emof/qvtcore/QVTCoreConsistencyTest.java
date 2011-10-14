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
package org.eclipse.qvt.declarative.test.emof.qvtcore;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.emof.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.emof.QVTCore.util.QVTCoreMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtbase.QVTBaseConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class QVTCoreConsistencyTest extends AbstractEssentialOCLConsistencyTest
{	
	public static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eINSTANCE);			
		//
		//	EMOF to Ecore
		//
		changeOfInterface(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.AREA);
		//
		//	Ecore limitation on EBoolean rather than EBooleanObject
		//
		changeOfUnsettable(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.ASSIGNMENT__IS_DEFAULT);
		//
		//	Ecore added value
		//
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.ASSIGNMENT);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.BOTTOM_PATTERN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.CORE_PATTERN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.MAPPING);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.PROPERTY_ASSIGNMENT);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.REALIZED_VARIABLE);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.VARIABLE_ASSIGNMENT);
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.AREA, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.AREA, "getAllVariables"));
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.CORE_PATTERN, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.CORE_PATTERN, "getAllVariables"));
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.CORE_PATTERN, "getArea"));
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.MAPPING, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.Literals.MAPPING, "getAllMappings"));
	}

	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		QVTCoreConsistencyTest.expectedEcoreDifferences(helper, differences, rightResourceSet);		
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfName(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfList(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfList(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfAbstract(differences, helper, QVTCorePackage.Literals.ASSIGNMENT);
		changeOfContainment(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP);
		changeOfContainment(differences, helper, QVTCorePackage.Literals.MAPPING__LOCAL);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.MAPPING__CONTEXT);

		changeOfSize(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Assignment"), "slotExpression"));
		changeOfSize(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);

		changeOfSize(differences, helper, QVTCorePackage.Literals.CORE_PATTERN, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.CORE_PATTERN__VARIABLE);		

		missingOppositeFeatureAndContext(differences, helper, QVTCorePackage.Literals.MAPPING__REFINEMENT);

		changeOfOrdered(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__ASSIGNMENT);
		changeOfOrdered(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__ENFORCEMENT_OPERATION);
		changeOfOrdered(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__REALIZED_VARIABLE);
		changeOfOrdered(differences, helper, QVTCorePackage.Literals.MAPPING__LOCAL);
		changeOfOrdered(differences, helper, QVTCorePackage.Literals.MAPPING__SPECIFICATION);
		missingOpposite(differences, helper, QVTCorePackage.Literals.ASSIGNMENT__VALUE);
		missingOpposite(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__TARGET_PROPERTY);
		missingOpposite(differences, helper, QVTCorePackage.Literals.VARIABLE_ASSIGNMENT__TARGET_VARIABLE);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		missingOppositeAnnotation(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		QVTBaseConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfName(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfList(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfList(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfAbstract(differences, helper, QVTCorePackage.Literals.ASSIGNMENT);
		changeOfContainment(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP);
		changeOfContainment(differences, helper, QVTCorePackage.Literals.MAPPING__LOCAL);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.ASSIGNMENT__BOTTOM_PATTERN);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__AREA);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.GUARD_PATTERN__AREA);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__BOTTOM_PATTERN);
		changeOfTransient(differences, helper, QVTCorePackage.Literals.MAPPING__CONTEXT);

		changeOfSize(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Assignment"), "slotExpression"));
		changeOfSize(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);

		changeOfSize(differences, helper, QVTCorePackage.Literals.CORE_PATTERN, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.CORE_PATTERN__VARIABLE);		

		changeOfSize(differences, helper, QVTCorePackage.Literals.MAPPING, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.MAPPING__REFINEMENT);
		missingOppositeFeature(differences, helper, QVTCorePackage.Literals.MAPPING__SPECIFICATION);
		
		changeOfSize(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_MODE, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_MODE.getEEnumLiteral("Creation"));
		missingEnumerationLiteral(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_MODE.getEEnumLiteral("Deletion"));
		
		changeOfLower(differences, helper, QVTCorePackage.Literals.ASSIGNMENT__IS_DEFAULT);
		changeOfLower(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__ASSIGNMENT);
		changeOfLower(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__ENFORCEMENT_OPERATION);
		changeOfLower(differences, helper, QVTCorePackage.Literals.BOTTOM_PATTERN__REALIZED_VARIABLE);
		changeOfLower(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__BOTTOM_PATTERN);
		changeOfLower(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE);
		changeOfLower(differences, helper, QVTCorePackage.Literals.MAPPING__CONTEXT);
		changeOfLower(differences, helper, QVTCorePackage.Literals.MAPPING__LOCAL);
		changeOfLower(differences, helper, QVTCorePackage.Literals.MAPPING__SPECIFICATION);
		missingOpposite(differences, helper, QVTCorePackage.Literals.ASSIGNMENT__VALUE);
		missingOpposite(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__TARGET_PROPERTY);
		missingOpposite(differences, helper, QVTCorePackage.Literals.VARIABLE_ASSIGNMENT__TARGET_VARIABLE);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		missingOppositeAnnotation(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		missingPrefix(differences, helper, QVTCorePackage.eINSTANCE);
		QVTBaseConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EssentialOCLConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTCorePackage.eINSTANCE);
		changeOfName(differences, helper, QVTCorePackage.eINSTANCE);

		changeOfList(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfList(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfAbstract(differences, helper, QVTCorePackage.Literals.ASSIGNMENT);
		changeOfContainment(differences, helper, QVTCorePackage.Literals.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP);

		changeOfSize(differences, helper, QVTCorePackage.Literals.ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Assignment"), "slotExpression"));
		changeOfSize(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		missingOppositeAnnotation(differences, helper, QVTCorePackage.Literals.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION);
		extraOppositeAnnotation(differences, helper, getFeature(getClass(rightPackage, "Assignment"), "slotExpression"));

		changeOfSize(differences, helper, QVTCorePackage.Literals.CORE_PATTERN, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.CORE_PATTERN__VARIABLE);		

		changeOfSize(differences, helper, QVTCorePackage.Literals.MAPPING, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTCorePackage.Literals.MAPPING__REFINEMENT);
		missingOppositeFeature(differences, helper, QVTCorePackage.Literals.MAPPING__SPECIFICATION);
		extraOppositeAnnotation(differences, helper, getFeature(getClass(rightPackage, "Mapping"), "specification"));
		changeOfSize(differences, helper, QVTCorePackage.Literals.MAPPING__SPECIFICATION, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);

		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		QVTBaseConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTCorePackage.eINSTANCE);			
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTCoreMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return QVTCORE_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eINSTANCE, getPackage(resourceSet, QVTCORE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTCorePackage.eINSTANCE, getPackage(resourceSet, QVTCORE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTCorePackage.eINSTANCE, getPackage(resourceSet, QVTCORE_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTCorePackage.eINSTANCE, getPackage(resourceSet, QVTCORE_PACKAGE_NAME.toLowerCase()));
	}
	
	public void testQVTCoreConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(QVTCorePackage.eNS_URI, "qvtcore.ecore");
		emof2OmgEcoreConsistencyTest(QVTCorePackage.eNS_URI, "qvtcore.ecore");
		emof2OmgEmofConsistencyTest(QVTCorePackage.eNS_URI);
		emof2RoseConsistencyTest(QVTCorePackage.eNS_URI, "QVTCore.ecore");
		ecore2EmofConsistencyTest(org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage.eNS_URI,
				QVTCorePackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}

}
