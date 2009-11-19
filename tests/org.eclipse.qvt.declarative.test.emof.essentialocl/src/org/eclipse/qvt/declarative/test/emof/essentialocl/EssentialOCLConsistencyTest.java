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
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;
import org.eclipse.qvt.declarative.test.emof.emof.EMOFConsistencyTest;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public class EssentialOCLConsistencyTest extends AbstractEssentialOCLConsistencyTest
{
	public static void expectedEcoreDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
		changeOfPrefix(differences, helper, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
//		extraObject(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.TYPE_TYPE);
		changeOfName(differences, helper, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE);
		changeOfName(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION);
		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.OCL_EXPRESSION, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
//		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS);
//		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
//		changeOfSize(differences, helper, org.eclipse.ocl.ecore.EcorePackage.Literals.VARIABLE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
	}
	
	public static void expectedEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		changeOfURI(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfSize(differences, helper, EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	public static void expectedEmof2OmgEmofDifferences(Set<EcoreDifference> differences, EquivalenceHelper helper, ResourceSet rightResourceSet) {
		missingURI(differences, helper, EssentialOCLPackage.eINSTANCE);
		missingPrefix(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfSize(differences, helper, EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.FEATURE_CALL_EXP);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER);

		changeOfSize(differences, helper, EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		extraObject(differences, helper, getClass(rightPackage, "OpaqueExpression"));
		missingClass(differences, helper, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP);
		missingClass(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE__SPECIFICATION);

		missingListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);

		changeOfSize(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"));

		changeOfMappedListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EMOFPackage.Literals.TYPED_ELEMENT, getClass(rightPackage, "OpaqueExpression"));
		changeOfListObject(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP, getClass(rightPackage, "FeaturePropertyCall"));
		changeOfList(differences, helper, EssentialOCLPackage.Literals.ANY_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE);
		changeOfUpper(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfAbstract(differences, helper, EssentialOCLPackage.Literals.COLLECTION_TYPE);
		changeOfContainment(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE);
		
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.COLLECTION_LITERAL_EXP__PART);
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_EXP__PART);

		missingOpposite(differences, helper, EssentialOCLPackage.Literals.CALL_EXP__SOURCE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.COLLECTION_RANGE__FIRST);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.COLLECTION_RANGE__LAST);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		missingOppositeAnnotation(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__CONDITION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__ELSE_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__THEN_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.ITERATE_EXP__RESULT);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.LOOP_EXP__BODY);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__ARGUMENT);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.VARIABLE__INIT_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		EssentialOCLConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}

	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		missingURI(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.FEATURE_CALL_EXP);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER);

		changeOfSize(differences, helper, EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		extraObject(differences, helper, getClass(rightPackage, "OpaqueExpression"));
		missingClass(differences, helper, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP);
		missingClass(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE__SPECIFICATION);

		missingListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		
		changeOfSize(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Bag"));
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"));
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("OrderedSet"));
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Sequence"));
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Set"));

		changeOfProxyObject(differences, helper, EssentialOCLPackage.Literals.INTEGER_LITERAL_EXP__INTEGER_SYMBOL, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfObject(differences, helper, EssentialOCLPackage.Literals.REAL_LITERAL_EXP__REAL_SYMBOL, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		changeOfProxyObject(differences, helper, EssentialOCLPackage.Literals.UNLIMITED_NATURAL_EXP__SYMBOL, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);

		changeOfMappedListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EMOFPackage.Literals.TYPED_ELEMENT, getClass(rightPackage, "OpaqueExpression"));
		changeOfListObject(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP, getClass(rightPackage, "FeaturePropertyCall"));
		changeOfList(differences, helper, EssentialOCLPackage.Literals.ANY_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfUpper(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfAbstract(differences, helper, EssentialOCLPackage.Literals.COLLECTION_TYPE);
		changeOfContainment(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE);

		changeOfTransient(differences, helper, EssentialOCLPackage.Literals.COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP);
		changeOfTransient(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP);
		changeOfTransient(differences, helper, EssentialOCLPackage.Literals.VARIABLE__LET_EXP);
		
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.CALL_EXP__SOURCE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.COLLECTION_LITERAL_EXP__KIND);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.COLLECTION_LITERAL_EXP__PART);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.INTEGER_LITERAL_EXP__INTEGER_SYMBOL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.ITERATE_EXP__RESULT);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.LOOP_EXP__ITERATOR);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__ARGUMENT);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.REAL_LITERAL_EXP__REAL_SYMBOL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.STRING_LITERAL_EXP__STRING_SYMBOL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_EXP__PART);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__TUPLE_LITERAL_EXP);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.TYPE_EXP__REFERRED_TYPE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.UNLIMITED_NATURAL_EXP__SYMBOL);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.VARIABLE__INIT_EXPRESSION);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.VARIABLE__LET_EXP);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER);

		missingOpposite(differences, helper, EssentialOCLPackage.Literals.CALL_EXP__SOURCE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.COLLECTION_RANGE__FIRST);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.COLLECTION_RANGE__LAST);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__BODY_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		missingOppositeAnnotation(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__RESULT_VARIABLE);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__CONDITION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__ELSE_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.IF_EXP__THEN_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.ITERATE_EXP__RESULT);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.LOOP_EXP__BODY);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__ARGUMENT);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__REFERRED_OPERATION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.VARIABLE__INIT_EXPRESSION);
		missingOpposite(differences, helper, EssentialOCLPackage.Literals.VARIABLE_EXP__REFERRED_VARIABLE);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();

		missingPrefix(differences, helper, EssentialOCLPackage.eINSTANCE);
		EMOFConsistencyTest.expectedEmof2OmgEmofDifferences(differences, helper, rightResourceSet);
		return differences;
	}
	
	@Override
	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		changeOfURI(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.eINSTANCE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.FEATURE_CALL_EXP);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE);
		changeOfName(differences, helper, EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER);
		changeOfSize(differences, helper, EssentialOCLPackage.eINSTANCE, EcorePackage.Literals.EPACKAGE__ECLASSIFIERS);
		extraObject(differences, helper, getClass(rightPackage, "OpaqueExpression"));
		missingClass(differences, helper, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP);
		missingClass(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.TEMPLATE_PARAMETER_TYPE__SPECIFICATION);
		missingListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		missingOppositeAnnotation(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__GENERATED_TYPE);
		changeOfSize(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND, EcorePackage.Literals.EENUM__ELITERALS);
		missingEnumerationLiteral(differences, helper, EssentialOCLPackage.Literals.COLLECTION_KIND.getEEnumLiteral("Collection"));
		changeOfMappedListObject(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EMOFPackage.Literals.TYPED_ELEMENT, getClass(rightPackage, "OpaqueExpression"));
		changeOfListObject(differences, helper, EssentialOCLPackage.Literals.PROPERTY_CALL_EXP, EcorePackage.Literals.ECLASS__ESUPER_TYPES, EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP, getClass(rightPackage, "FeaturePropertyCall"));
		changeOfList(differences, helper, EssentialOCLPackage.Literals.ANY_TYPE, EcorePackage.Literals.ECLASS__ESUPER_TYPES);		
		changeOfAbstract(differences, helper, EssentialOCLPackage.Literals.COLLECTION_TYPE);
		changeOfContainment(differences, helper, EssentialOCLPackage.Literals.TUPLE_LITERAL_PART__ATTRIBUTE);
		changeOfLower(differences, helper, EssentialOCLPackage.Literals.COLLECTION_TYPE__ELEMENT_TYPE);
		changeOfUpper(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.LOOP_EXP__ITERATOR);
		changeOfOrdered(differences, helper, EssentialOCLPackage.Literals.OPERATION_CALL_EXP__ARGUMENT);
		helper.setLogStream(null);
		ResourceSet rightResourceSet = rightPackage.eResource().getResourceSet();
		helper.setLogStream(null);
		EMOFConsistencyTest.expectedEmofDifferences(differences, helper, rightResourceSet);		
		return differences;
	}

	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		EssentialOCLMappingMetaData.INSTANCE.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	@Override
	public String getPackageName() {
		return ESSENTIAL_OCL_PACKAGE_NAME;
	}

	@Override
	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofEclipseMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME);
		comparator.putEquivalence(EssentialOCLPackage.Literals.OCL_EXPRESSION, getClass(emofPackage, "OclExpression"));
	}

	@Override
	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmofOmgMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME.toLowerCase());
		comparator.putEquivalence(EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP, null);
		comparator.putEquivalence(null, getClass(emofPackage, "OpaqueExpression"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, getFeature(getClass(emofPackage, "ExpressionInOcl"), "context"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.FEATURE_CALL_EXP, getClass(emofPackage, "FeaturePropertyCall"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER, getFeature(getClass(emofPackage, "Variable"), "bindParameter"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.OCL_EXPRESSION, getClass(emofPackage, "OclExpression"));
	}

	@Override
	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {
		super.installEmof2EmofMappings(comparator, resourceSet);
		EPackage emofPackage = getPackage(resourceSet, ESSENTIAL_OCL_PACKAGE_NAME.toLowerCase());
		comparator.putEquivalence(EssentialOCLPackage.Literals.NAVIGATION_CALL_EXP, null);
		comparator.putEquivalence(null, getClass(emofPackage, "OpaqueExpression"));
		comparator.putEquivalence(EssentialOCLPackage.eINSTANCE, emofPackage);
		comparator.putEquivalence(EssentialOCLPackage.Literals.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, getFeature(getClass(emofPackage, "ExpressionInOcl"), "context"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.FEATURE_CALL_EXP, getClass(emofPackage, "FeaturePropertyCall"));
		comparator.putEquivalence(EssentialOCLPackage.Literals.VARIABLE__REPRESENTED_PARAMETER, getFeature(getClass(emofPackage, "Variable"), "bindParameter"));
	}

	public void testEssentialOCLConsistency() throws IOException, MappingConfigurationException {
		Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		htmlStream.setEnabled(false);
		expectedEMOFInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		expectedEssentialOCLInconsistencies(ecoreInconsistencies, adaptingInconsistencies);
		htmlStream.setEnabled(true);
		ecore2EmofAdapterConsistencyTest(ecoreInconsistencies, adaptingInconsistencies);
		emof2OmgRoseConsistencyTest(EssentialOCLPackage.eNS_URI, "essentialocl.ecore");
		emof2OmgEcoreConsistencyTest(EssentialOCLPackage.eNS_URI, "essentialocl.ecore");
		emof2OmgEmofConsistencyTest(EssentialOCLPackage.eNS_URI);
		emof2RoseConsistencyTest(EssentialOCLPackage.eNS_URI, "EssentialOCL.ecore");
// FIXME Following will do detailed OCL differences
//		ecore2EmofConsistencyTest(org.eclipse.ocl.ecore.EcorePackage.eNS_URI,
//				EssentialOCLPackage.eINSTANCE,
//				EMOFPackage.eINSTANCE);
	}
}
