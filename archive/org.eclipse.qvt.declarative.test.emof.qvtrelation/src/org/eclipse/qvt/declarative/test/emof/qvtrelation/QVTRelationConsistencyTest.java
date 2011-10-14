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
 * $Id: QVTRelationConsistencyTest.java,v 1.7 2009/11/19 10:49:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.emof.qvtrelation;

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
import org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.emof.QVTRelation.util.QVTRelationMappingMetaData;
import org.eclipse.qvt.declarative.emof.QVTTemplate.QVTTemplatePackage;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.essentialocl.EssentialOCLConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvtbase.QVTBaseConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.qvttemplate.QVTTemplateConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class QVTRelationConsistencyTest extends AbstractEssentialOCLConsistencyTest
{	
	public static void expectedEcoreDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eINSTANCE);
		//
		//	Ecore limitation on EBoolean rather than EBooleanObject
		//
		changeOfUnsettable(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION__IS_TOP_LEVEL);
		//
		//	Ecore added value
		//
		changeOfObject(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.KEY__OPPOSITE_PART, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);	
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATIONAL_TRANSFORMATION, "getRelation"));
		changeOfSize(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATIONAL_TRANSFORMATION, EcorePackage.Literals.ECLASS__EOPERATIONS);		
		missingOperation(differences, helper, getOperation(org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION, "getRelationalTransformation"));
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.DOMAIN_PATTERN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.KEY);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION_CALL_EXP);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION_DOMAIN);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATION_IMPLEMENTATION);
		missingConstraint(differences, helper, org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.Literals.RELATIONAL_TRANSFORMATION);
	}

	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, QVTRelationPackage.eINSTANCE);
		changeOfPrefix(differences, helper, QVTRelationPackage.eINSTANCE);
		changeOfName(differences, helper, QVTRelationPackage.eINSTANCE);
		//
		//	Support for opposite navigation
		//
		changeOfSize(differences, helper, QVTRelationPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	public static void expectedEmof2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		missingURI(differences, helper, QVTRelationPackage.eINSTANCE);
		missingPrefix(differences, helper, QVTRelationPackage.eINSTANCE);
		changeOfName(differences, helper, QVTRelationPackage.eINSTANCE);
		//
		//	Support for opposite navigation
		//
		changeOfSize(differences, helper, QVTRelationPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	@Override
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		QVTRelationConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);		
		helper.setLogStream(null);
		EssentialOCLConsistencyTest.expectedEcoreDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEcore2RoseDifferences(helper, differences, rightResourceSet);		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		expectedEmofDifferences(differences, helper, rightResourceSet);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_CALL_EXP__ARGUMENT);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_CALL_EXP__REFERRED_RELATION);
		changeOfContainment(differences, helper, QVTRelationPackage.Literals.RELATION__OPERATIONAL_IMPL);
		changeOfTransient(differences, helper, QVTRelationPackage.Literals.RELATION_IMPLEMENTATION__RELATION);
		changeOfOrdered(differences, helper, QVTRelationPackage.Literals.KEY__PART);
		changeOfOrdered(differences, helper, QVTRelationPackage.Literals.RELATION__OPERATIONAL_IMPL);
		changeOfOrdered(differences, helper, QVTRelationPackage.Literals.RELATION__VARIABLE);
		changeOfOrdered(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		changeOfOrdered(differences, helper, QVTRelationPackage.Literals.RELATIONAL_TRANSFORMATION__OWNED_KEY);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION__WHEN);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION__WHERE);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VARIABLE);
		//
		//	Support for opposite navigation
		//
		changeOfSize(differences, helper, QVTRelationPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		missingObject(differences, helper, QVTRelationPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP);		
		changeOfLower(differences, helper, QVTRelationPackage.Literals.KEY__PART);
		changeOfSize(differences, helper, QVTRelationPackage.Literals.KEY, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);		
		missingOppositeAnnotation(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);
			
		helper.setLogStream(null);
		QVTTemplateConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		QVTBaseConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, QVTRelationPackage.eINSTANCE);
		changeOfName(differences, helper, QVTRelationPackage.eINSTANCE);
		changeOfContainment(differences, helper, QVTRelationPackage.Literals.RELATION__OPERATIONAL_IMPL);
		changeOfTransient(differences, helper, QVTRelationPackage.Literals.KEY__TRANSFORMATION);
		changeOfTransient(differences, helper, QVTRelationPackage.Literals.RELATION_IMPLEMENTATION__RELATION);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.DOMAIN_PATTERN__TEMPLATE_EXPRESSION);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.KEY__TRANSFORMATION);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION__IS_TOP_LEVEL);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION__OPERATIONAL_IMPL);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION__VARIABLE);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION__WHEN);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION__WHERE);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_CALL_EXP__ARGUMENT);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN__PATTERN);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_IMPLEMENTATION__RELATION);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATIONAL_TRANSFORMATION__OWNED_KEY);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION__WHEN);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION__WHERE);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN__DEFAULT_ASSIGNMENT);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP);
		missingOpposite(differences, helper, QVTRelationPackage.Literals.RELATION_DOMAIN_ASSIGNMENT__VARIABLE);
		//
		//	Support for opposite navigation
		//
		changeOfSize(differences, helper, QVTRelationPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		missingObject(differences, helper, QVTRelationPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP);		
		changeOfLower(differences, helper, QVTRelationPackage.Literals.KEY__PART);
		changeOfSize(differences, helper, QVTRelationPackage.Literals.KEY, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);		
		missingOppositeAnnotation(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);
			
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		missingPrefix(differences, helper, QVTRelationPackage.eINSTANCE);
		QVTTemplateConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		QVTBaseConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EssentialOCLConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		expectedEmofDifferences(differences, helper, rightResourceSet);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_CALL_EXP__ARGUMENT);
		changeOfLower(differences, helper, QVTRelationPackage.Literals.RELATION_CALL_EXP__REFERRED_RELATION);
		//
		//	Support for opposite navigation
		//
		changeOfSize(differences, helper, QVTRelationPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		missingObject(differences, helper, QVTRelationPackage.Literals.OPPOSITE_PROPERTY_CALL_EXP);		
		changeOfLower(differences, helper, QVTRelationPackage.Literals.KEY__PART);
		changeOfSize(differences, helper, QVTRelationPackage.Literals.KEY, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);		
		missingOppositeAnnotation(differences, helper, QVTRelationPackage.Literals.KEY__OPPOSITE_PART);
			
		helper.setLogStream(null);
		QVTTemplateConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		QVTBaseConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfPrefix(differences, helper, QVTRelationPackage.eINSTANCE);		
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		QVTRelationMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return QVTRELATION_PACKAGE_NAME;
	}

	@Override
	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEcoreEclipseMappings(comparator, resourceSet);
		comparator.putEquivalence(org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME));
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
//		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME));
		comparator.putEquivalence(QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME.toLowerCase()));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		comparator.putEquivalence(QVTBasePackage.eINSTANCE, getPackage(resourceSet, QVTBASE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTTemplatePackage.eINSTANCE, getPackage(resourceSet, QVTTEMPLATE_PACKAGE_NAME.toLowerCase()));
		comparator.putEquivalence(QVTRelationPackage.eINSTANCE, getPackage(resourceSet, QVTRELATION_PACKAGE_NAME.toLowerCase()));
	}
	
	public void testQVTRelationConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		getExpectedDerivedPackageInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(QVTRelationPackage.eNS_URI, "qvtrelation.ecore");
		emof2OmgEcoreConsistencyTest(QVTRelationPackage.eNS_URI, "qvtrelation.ecore");
		emof2OmgEmofConsistencyTest(QVTRelationPackage.eNS_URI);
		emof2RoseConsistencyTest(QVTRelationPackage.eNS_URI, "QVTRelation.ecore");
		ecore2EmofConsistencyTest(org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage.eNS_URI,
				QVTRelationPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage.eINSTANCE,
				org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage.eINSTANCE);
	}
}
