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
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.util.EMOFMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class EMOFConsistencyTest extends AbstractEMOFConsistencyTest
{
	private static void expectedEcoreDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences) {
		//
		//	EMOF to Ecore
		//
		changeOfName(differences, helper, EcorePackage.eINSTANCE);
		changeOfPrefix(differences, helper, EcorePackage.eINSTANCE);
		changeOfURI(differences, helper, EcorePackage.eINSTANCE);
		changeOfSize(differences, helper, EcorePackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		changeOfName(differences, helper, EcorePackage.Literals.EBOOLEAN);
		changeOfName(differences, helper, EcorePackage.Literals.ECLASS);
		changeOfName(differences, helper, EcorePackage.Literals.ECLASSIFIER);
		changeOfName(differences, helper, EcorePackage.Literals.EMODEL_ELEMENT);
		changeOfName(differences, helper, EcorePackage.Literals.ENAMED_ELEMENT);
		changeOfName(differences, helper, EcorePackage.Literals.EOBJECT);
		changeOfName(differences, helper, EcorePackage.Literals.EOPERATION);
		changeOfName(differences, helper, EcorePackage.Literals.EOPERATION__EPARAMETERS);
		changeOfName(differences, helper, EcorePackage.Literals.EPACKAGE);
		changeOfName(differences, helper, EcorePackage.Literals.EPARAMETER);
		changeOfName(differences, helper, EcorePackage.Literals.EPARAMETER__EOPERATION);
		changeOfName(differences, helper, EcorePackage.Literals.ESTRING);
		changeOfName(differences, helper, EcorePackage.Literals.ESTRUCTURAL_FEATURE);
		changeOfName(differences, helper, EcorePackage.Literals.ETYPED_ELEMENT);
		changeOfSize(differences, helper, EcorePackage.Literals.EBOOLEAN, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.ECLASS, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.ECLASS, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfSize(differences, helper, EcorePackage.Literals.ECLASSIFIER, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.ECLASSIFIER, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfSize(differences, helper, EcorePackage.Literals.EMODEL_ELEMENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.EMODEL_ELEMENT, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfSize(differences, helper, EcorePackage.Literals.EOBJECT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.EOPERATION, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.EOPERATION, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfSize(differences, helper, EcorePackage.Literals.EOPERATION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfSize(differences, helper, EcorePackage.Literals.EPACKAGE, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.EPACKAGE, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfSize(differences, helper, EcorePackage.Literals.EPARAMETER, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfSize(differences, helper, EcorePackage.Literals.ESTRING, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.ESTRUCTURAL_FEATURE, EcorePackage.Literals.ECLASS__EOPERATIONS);
		changeOfSize(differences, helper, EcorePackage.Literals.ESTRUCTURAL_FEATURE, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfSize(differences, helper, EcorePackage.Literals.ESTRUCTURAL_FEATURE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		changeOfSize(differences, helper, EcorePackage.Literals.ETYPED_ELEMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		changeOfAbstract(differences, helper, EcorePackage.Literals.ESTRUCTURAL_FEATURE);
		changeOfChangeable(differences, helper, EcorePackage.Literals.EPARAMETER__EOPERATION);
	}

	public static void expectedEmof2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		missingURI(differences, helper, EMOFPackage.eINSTANCE);
		missingPrefix(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	public static void expectedEcore2RoseDifferences(EquivalenceHelper helper, Set<EcoreDifference> differences, ResourceSet rightResourceSet) {
		EPackage emofPackage = getPackage(rightResourceSet, "EMOF");
		changeOfListObject(differences, helper, EcorePackage.Literals.EMODEL_ELEMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES,
				EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, getFeature(getClass(emofPackage, "Element"), "ownedComment"));
		expectedEcoreDifferences(helper, differences);
	}
	
	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfURI(differences, helper, EMOFPackage.eINSTANCE);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.Literals.PROPERTY__IS_ID);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		helper.println("'Factory' should be defined");
		helper.println("'ReflectiveCollection' should be defined");
		helper.println("'ReflectiveSequence' should be defined");
		missingObject(differences, helper, EMOFPackage.Literals.COMMENT__BODY);
		changeOfSize(differences, helper, EMOFPackage.Literals.COMMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, EMOFPackage.Literals.FACTORY__PACKAGE);

		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Element"), "tag"));
		extraFeature(differences, helper, EMOFPackage.Literals.TAG__ELEMENT, EcorePackage.Literals.EREFERENCE__EOPPOSITE, getFeature(getClass(rightPackage, "Element"), "tag"));

		changeOfLower(differences, helper, EMOFPackage.Literals.OPERATION__CLASS);
		changeOfLower(differences, helper, EMOFPackage.Literals.TYPE__PACKAGE);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__CLASS);

		changeOfOrdered(differences, helper, EMOFPackage.Literals.CLASS__SUPER_CLASS);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.COMMENT__ANNOTATED_ELEMENT);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.ELEMENT__OWNED_COMMENT);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.OPERATION__RAISED_EXCEPTION);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.PACKAGE__OWNED_TYPE);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.TAG__ELEMENT);
		
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.CLASS__IS_ABSTRACT);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_COMPOSITE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_DERIVED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_READ_ONLY);
		
		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "container"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "equals"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "getMetaClass"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "isSet"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "set"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "unset"));

		changeOfSize(differences, helper, EMOFPackage.Literals.EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "elements"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "useContainment"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.FACTORY, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "convertToString"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "create"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "createFromString"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_COLLECTION, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "addAll"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "clear"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "size"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_SEQUENCE, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "set"));

		changeOfSize(differences, helper, EMOFPackage.Literals.TYPE, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.TYPE, "isInstance"));

		changeOfSize(differences, helper, EMOFPackage.Literals.URI_EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "contextURI"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "element"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "uri"));

		missingOppositeFeatureAndContext(differences, helper, EMOFPackage.Literals.PACKAGE__NESTING_PACKAGE);
		
		helper.setLogStream(null);
		
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.Literals.PROPERTY__IS_ID);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		helper.println("'Factory' should be defined");
		missingObject(differences, helper, EMOFPackage.Literals.REAL);
		helper.println("'ReflectiveCollection' should be defined");
		helper.println("'ReflectiveSequence' should be defined");
		missingObject(differences, helper, EMOFPackage.Literals.COMMENT__BODY);
		changeOfSize(differences, helper, EMOFPackage.Literals.COMMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, EMOFPackage.Literals.FACTORY__PACKAGE);

		missingObject(differences, helper, EMOFPackage.Literals.BOOLEAN);
		missingObject(differences, helper, EMOFPackage.Literals.INTEGER);
		missingObject(differences, helper, EMOFPackage.Literals.STRING);
		missingObject(differences, helper, EMOFPackage.Literals.UNLIMITED_NATURAL);
		
		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Element"), "tag"));
		extraFeature(differences, helper, EMOFPackage.Literals.TAG__ELEMENT, EcorePackage.Literals.EREFERENCE__EOPPOSITE, getFeature(getClass(rightPackage, "Element"), "tag"));
		
		changeOfProxyObject(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfProxyObject(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
			
		changeOfLower(differences, helper, EMOFPackage.Literals.CLASS__IS_ABSTRACT);
		changeOfLower(differences, helper, EMOFPackage.Literals.CLASS__OWNED_ATTRIBUTE);
		changeOfLower(differences, helper, EMOFPackage.Literals.CLASS__OWNED_OPERATION);
		changeOfLower(differences, helper, EMOFPackage.Literals.CLASS__SUPER_CLASS);
		changeOfLower(differences, helper, EMOFPackage.Literals.COMMENT__ANNOTATED_ELEMENT);
		changeOfLower(differences, helper, EMOFPackage.Literals.ELEMENT__OWNED_COMMENT);
		changeOfLower(differences, helper, EMOFPackage.Literals.ENUMERATION__OWNED_LITERAL);
		changeOfLower(differences, helper, EMOFPackage.Literals.ENUMERATION_LITERAL__ENUMERATION);
		changeOfLower(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED);
		changeOfLower(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE);
		changeOfLower(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		changeOfLower(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		changeOfLower(differences, helper, EMOFPackage.Literals.NAMED_ELEMENT__NAME);
		changeOfLower(differences, helper, EMOFPackage.Literals.OPERATION__CLASS);
		changeOfLower(differences, helper, EMOFPackage.Literals.OPERATION__OWNED_PARAMETER);
		changeOfLower(differences, helper, EMOFPackage.Literals.OPERATION__RAISED_EXCEPTION);
		changeOfLower(differences, helper, EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE);
		changeOfLower(differences, helper, EMOFPackage.Literals.PACKAGE__OWNED_TYPE);
		changeOfLower(differences, helper, EMOFPackage.Literals.PACKAGE__URI);
		changeOfLower(differences, helper, EMOFPackage.Literals.PARAMETER__OPERATION);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__CLASS);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__DEFAULT);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__IS_COMPOSITE);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__IS_DERIVED);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__IS_ID);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__IS_READ_ONLY);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__OPPOSITE);
		changeOfLower(differences, helper, EMOFPackage.Literals.TAG__ELEMENT);
		changeOfLower(differences, helper, EMOFPackage.Literals.TAG__NAME);
		changeOfLower(differences, helper, EMOFPackage.Literals.TAG__VALUE);
		changeOfLower(differences, helper, EMOFPackage.Literals.TYPE__PACKAGE);
		changeOfLower(differences, helper, EMOFPackage.Literals.TYPED_ELEMENT__TYPE);

		changeOfTransient(differences, helper, EMOFPackage.Literals.ENUMERATION_LITERAL__ENUMERATION);
		changeOfTransient(differences, helper, EMOFPackage.Literals.OPERATION__CLASS);
		changeOfTransient(differences, helper, EMOFPackage.Literals.PARAMETER__OPERATION);
		changeOfTransient(differences, helper, EMOFPackage.Literals.PROPERTY__CLASS);
		changeOfTransient(differences, helper, EMOFPackage.Literals.TYPE__PACKAGE);
		
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.CLASS__IS_ABSTRACT);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_COMPOSITE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_DERIVED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_READ_ONLY);
		
		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "container"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "equals"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "getMetaClass"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "isSet"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "set"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "unset"));

		changeOfSize(differences, helper, EMOFPackage.Literals.EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "elements"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "useContainment"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.FACTORY, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "convertToString"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "create"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "createFromString"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_COLLECTION, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "addAll"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "clear"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "size"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_SEQUENCE, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "set"));

		changeOfSize(differences, helper, EMOFPackage.Literals.TYPE, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.TYPE, "isInstance"));

		changeOfSize(differences, helper, EMOFPackage.Literals.URI_EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "contextURI"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "element"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "uri"));

		missingOppositeFeatureAndContext(differences, helper, EMOFPackage.Literals.PACKAGE__NESTING_PACKAGE);
		
		helper.setLogStream(null);

		missingPrefix(differences, helper, EMOFPackage.eINSTANCE);
		missingURI(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.eINSTANCE);
		changeOfName(differences, helper, EMOFPackage.Literals.PROPERTY__IS_ID);
		changeOfSize(differences, helper, EMOFPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		helper.println("'Factory' should be defined");
		helper.println("'ReflectiveCollection' should be defined");
		helper.println("'ReflectiveSequence' should be defined");
		missingObject(differences, helper, EMOFPackage.Literals.COMMENT__BODY);
		changeOfSize(differences, helper, EMOFPackage.Literals.COMMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, EMOFPackage.Literals.FACTORY__PACKAGE);

		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		extraObject(differences, helper, getFeature(getClass(rightPackage, "Element"), "tag"));
		extraFeature(differences, helper, EMOFPackage.Literals.TAG__ELEMENT, EcorePackage.Literals.EREFERENCE__EOPPOSITE, getFeature(getClass(rightPackage, "Element"), "tag"));

		changeOfLower(differences, helper, EMOFPackage.Literals.OPERATION__CLASS);
		changeOfLower(differences, helper, EMOFPackage.Literals.TYPE__PACKAGE);
		changeOfLower(differences, helper, EMOFPackage.Literals.PROPERTY__CLASS);

		changeOfOrdered(differences, helper, EMOFPackage.Literals.CLASS__OWNED_ATTRIBUTE);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.CLASS__OWNED_OPERATION);
		changeOfOrdered(differences, helper, EMOFPackage.Literals.OPERATION__OWNED_PARAMETER);
		
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.CLASS__IS_ABSTRACT);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_COMPOSITE);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_DERIVED);
		changeOfDefaultValue(differences, helper, EMOFPackage.Literals.PROPERTY__IS_READ_ONLY);
		
		changeOfSize(differences, helper, EMOFPackage.Literals.ELEMENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "container"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "equals"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "getMetaClass"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "isSet"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "set"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.ELEMENT, "unset"));

		changeOfSize(differences, helper, EMOFPackage.Literals.EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "elements"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.EXTENT, "useContainment"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.FACTORY, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "convertToString"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "create"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.FACTORY, "createFromString"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_COLLECTION, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "addAll"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "clear"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_COLLECTION, "size"));

		differences.add(new EcoreDifference(helper, null, null, EMOFPackage.Literals.REFLECTIVE_SEQUENCE, null, "Null right object"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "add"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "get"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "remove"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.REFLECTIVE_SEQUENCE, "set"));

		changeOfSize(differences, helper, EMOFPackage.Literals.TYPE, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.TYPE, "isInstance"));

		changeOfSize(differences, helper, EMOFPackage.Literals.URI_EXTENT, EcorePackage.Literals.ECLASS__EOPERATIONS);
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "contextURI"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "element"));
		missingOperation(differences, helper, getOperation(EMOFPackage.Literals.URI_EXTENT, "uri"));

		changeOfSize(differences, helper, EMOFPackage.Literals.PACKAGE, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, EMOFPackage.Literals.PACKAGE__NESTING_PACKAGE);
		extraOpposite(differences, helper, EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE, getFeature(getClass(rightPackage, "Package"), "nestedPackage"));
		changeOfFeature(differences, helper, EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE, EcorePackage.Literals.EREFERENCE__EOPPOSITE, helper.getRight(EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE), "Null right feature");

		extraOpposite(differences, helper, EMOFPackage.Literals.CLASS__SUPER_CLASS, getFeature(getClass(rightPackage, "Class"), "superClass"));
		extraOpposite(differences, helper, EMOFPackage.Literals.PROPERTY__OPPOSITE, getFeature(getClass(rightPackage, "Property"), "opposite"));

		helper.setLogStream(null);		
		return differences;
	}
	
	@Override
	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		helper.println("No differences");
		helper.setLogStream(null);
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		EMOFMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return "EMOF";
	}
	
	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, "EMOF".toLowerCase());
		comparator.putEquivalence(EMOFPackage.Literals.PROPERTY__IS_ID, getFeature(getClass(emofPackage, "Property"), "isId"));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, "EMOF".toLowerCase());
		comparator.putEquivalence(EMOFPackage.Literals.PROPERTY__IS_ID, getFeature(getClass(emofPackage, "Property"), "isId"));
//		comparator.putEquivalence(EMOFPackage.eINSTANCE, emofPackage);
//		comparator.putEquivalence(EMOFPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, getFeature(getClass(emofPackage, "ExpressionInOcl"), "context"));
//		comparator.putEquivalence(EMOFPackage.Literals.FEATURE_CALL_EXP, getClass(emofPackage, "FeaturePropertyCall"));
//		comparator.putEquivalence(EMOFPackage.Literals.VARIABLE__REPRESENTED_PARAMETER, getFeature(getClass(emofPackage, "Variable"), "bindParameter"));
	}

	public void testEMOFConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		expectedEMOFInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);				
		emof2OmgRoseConsistencyTest(EMOFPackage.eNS_URI, "emof.ecore");
		emof2OmgEcoreConsistencyTest(EMOFPackage.eNS_URI, "emof.ecore");
		emof2OmgEmofConsistencyTest(EMOFPackage.eNS_URI);
		emof2RoseConsistencyTest(EMOFPackage.eNS_URI, "EMOF.ecore");
// FIXME Following will do detailed OCL differences
//		ecore2EmofConsistencyTest(EcorePackage.eNS_URI,
//				EMOFPackageEMOF.EMOFPackage.eINSTANCE);
	}
}
