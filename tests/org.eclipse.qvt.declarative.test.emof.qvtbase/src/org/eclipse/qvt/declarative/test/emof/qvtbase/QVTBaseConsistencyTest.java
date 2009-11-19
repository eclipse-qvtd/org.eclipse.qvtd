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
package org.eclipse.qvt.declarative.test.emof.qvtbase;

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
import org.eclipse.qvt.declarative.emof.QVTBase.util.QVTBaseMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class QVTBaseConsistencyTest extends AbstractEssentialOCLConsistencyTest
{		
	public static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences, ResourceSet rightResourceSet) {
		changeOfPrefix(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eINSTANCE);			
		changeOfURI(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eINSTANCE);
		changeOfObject(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		//
		//	Ecore limitation on EBoolean rather than EBooleanObject
		//
		changeOfUnsettable(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.DOMAIN__IS_CHECKABLE);
		changeOfUnsettable(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.DOMAIN__IS_ENFORCEABLE);
		//
		//	Ecore added value
		//
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.DOMAIN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.FUNCTION);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.PATTERN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.PREDICATE);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.RULE);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TRANSFORMATION);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TYPED_MODEL);
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TRANSFORMATION, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TRANSFORMATION, "getFunction"));
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.Literals.TRANSFORMATION, "getModelParameter"));
	}

	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfPrefix(differences, helper, QVTBasePackage.eINSTANCE);			
		changeOfURI(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfName(differences, helper, QVTBasePackage.eINSTANCE);
	}

	public static void expectedEmof2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		missingURI(differences, helper, org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE);
		missingPrefix(differences, helper, org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE);
		changeOfName(differences, helper, org.eclipse.qvt.declarative.emof.QVTBase.QVTBasePackage.eINSTANCE);
	}
	
	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		QVTBaseConsistencyTest.expectedEcoreDifferences(helper, differences, rightResourceSet);
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTBasePackage.eINSTANCE);			
		changeOfURI(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfName(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfAbstract(differences, helper, QVTBasePackage.Literals.DOMAIN);
		changeOfAbstract(differences, helper, QVTBasePackage.Literals.RULE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.RULE__TRANSFORMATION);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.PATTERN__BINDS_TO);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.PATTERN__PREDICATE);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__RULE);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__DEPENDS_ON);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__USED_PACKAGE);
		missingOpposite(differences, helper, QVTBasePackage.Literals.RULE__OVERRIDES);
		missingOpposite(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__EXTENDS);
		missingOpposite(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__DEPENDS_ON);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfName(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfAbstract(differences, helper, QVTBasePackage.Literals.DOMAIN);
		changeOfAbstract(differences, helper, QVTBasePackage.Literals.RULE);
		changeOfTransient(differences, helper, QVTBasePackage.Literals.DOMAIN__RULE);
		changeOfTransient(differences, helper, QVTBasePackage.Literals.PREDICATE__PATTERN);
		changeOfTransient(differences, helper, QVTBasePackage.Literals.RULE__TRANSFORMATION);
		changeOfTransient(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__TRANSFORMATION);
		changeOfLower(differences, helper, QVTBasePackage.Literals.DOMAIN__IS_CHECKABLE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.DOMAIN__IS_ENFORCEABLE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.DOMAIN__TYPED_MODEL);
		changeOfLower(differences, helper, QVTBasePackage.Literals.FUNCTION__QUERY_EXPRESSION);
		changeOfLower(differences, helper, QVTBasePackage.Literals.PATTERN__BINDS_TO);
		changeOfLower(differences, helper, QVTBasePackage.Literals.PATTERN__PREDICATE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.RULE__DOMAIN);
		changeOfLower(differences, helper, QVTBasePackage.Literals.RULE__OVERRIDES);
		changeOfLower(differences, helper, QVTBasePackage.Literals.RULE__TRANSFORMATION);
		changeOfLower(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__EXTENDS);
		changeOfLower(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER);
		changeOfLower(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__OWNED_TAG);
		changeOfLower(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__RULE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__DEPENDS_ON);
		missingOpposite(differences, helper, QVTBasePackage.Literals.RULE__OVERRIDES);
		missingOpposite(differences, helper, QVTBasePackage.Literals.TRANSFORMATION__EXTENDS);
		missingOpposite(differences, helper, QVTBasePackage.Literals.TYPED_MODEL__DEPENDS_ON);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		missingPrefix(differences, helper, QVTBasePackage.eINSTANCE);
		EssentialOCLConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTBasePackage.eINSTANCE);			
		changeOfURI(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfName(differences, helper, QVTBasePackage.eINSTANCE);
		changeOfLower(differences, helper, QVTBasePackage.Literals.RULE__TRANSFORMATION);
		changeOfOrdered(differences, helper, QVTBasePackage.Literals.RULE__DOMAIN);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTBasePackage.eINSTANCE);			
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTBaseMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return QVTBASE_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
	}
	
	public void testQVTBaseConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(QVTBasePackage.eNS_URI, "qvtbase.ecore");
		emof2OmgEcoreConsistencyTest(QVTBasePackage.eNS_URI, "qvtbase.ecore");
		emof2OmgEmofConsistencyTest(QVTBasePackage.eNS_URI);
		emof2RoseConsistencyTest(QVTBasePackage.eNS_URI, "QVTBase.ecore");
		ecore2EmofConsistencyTest(org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage.eNS_URI,
				QVTBasePackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}
}
