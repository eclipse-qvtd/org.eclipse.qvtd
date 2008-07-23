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
package org.eclipse.qvt.declarative.test.emof.qvttemplate;

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
import org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage;
import org.eclipse.qvt.declarative.emof.QVTTemplate.util.QVTTemplateMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class QVTTemplateConsistencyTest extends AbstractEssentialOCLConsistencyTest
{	
	public static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences) {
		changeOfURI(differences, helper, org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eINSTANCE);
		//
		//	Ecore added value
		//
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP);
	}

	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper) {
		changeOfURI(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfName(differences, helper, QVTTemplatePackage.eINSTANCE);
	}

	public static void expectedEmo2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper) {
		missingURI(differences, helper, QVTTemplatePackage.eINSTANCE);
		missingPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfName(differences, helper, QVTTemplatePackage.eINSTANCE);
	}

	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		QVTTemplateConsistencyTest.expectedEcoreDifferences(helper, differences);
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightPackage.eResource().getResourceSet());		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfName(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfObject(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfSize(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "CollectionTemplateExp"), "kind"));
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE);
		changeOfOrdered(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		changeOfOrdered(differences, helper, QVTTemplatePackage.Literals.OBJECT_TEMPLATE_EXP__PART);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.TEMPLATE_EXP__WHERE);
		helper.setLogStream(null);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfName(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfObject(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfTransient(differences, helper, QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.OBJECT_TEMPLATE_EXP__PART);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.TEMPLATE_EXP__BINDS_TO);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.TEMPLATE_EXP__WHERE);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM__VALUE);
		missingOpposite(differences, helper, QVTTemplatePackage.Literals.TEMPLATE_EXP__WHERE);
		helper.setLogStream(null);
		missingPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);
		EssentialOCLConsistencyTest.expectedEmo2OmgEmofDifferences(differences, helper);
		EMOFConsistencyTest.expectedEmo2OmgEmofDifferences(differences, helper);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfName(differences, helper, QVTTemplatePackage.eINSTANCE);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__MEMBER);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REST);
		changeOfLower(differences, helper, QVTTemplatePackage.Literals.COLLECTION_TEMPLATE_EXP__REFERRED_COLLECTION_TYPE);
		helper.setLogStream(null);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTTemplatePackage.eINSTANCE);			
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTTemplateMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return QVTTEMPLATE_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME.toLowerCase()));
	}
	
	public void testQVTTemplateConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(QVTTemplatePackage.eNS_URI, "qvttemplate.ecore");
		emof2OmgEcoreConsistencyTest(QVTTemplatePackage.eNS_URI, "qvttemplate.ecore");
		emof2OmgEmofConsistencyTest(QVTTemplatePackage.eNS_URI);
		emof2RoseConsistencyTest(QVTTemplatePackage.eNS_URI, "QVTTemplate.ecore");
		ecore2EmofConsistencyTest(org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage.eNS_URI,
				QVTTemplatePackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}
}
