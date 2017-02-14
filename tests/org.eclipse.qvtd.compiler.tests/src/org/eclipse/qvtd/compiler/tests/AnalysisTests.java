/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ContainmentAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.InheritanceAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationDependencyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationDependencyPaths;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationDependencyStep;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcTestUtil;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class AnalysisTests extends XtextTestCase
{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		OCLstdlib.install();
	}

	/*	@Test
	public void testContainmentAnalysis_Delphi() throws ParserException {
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//
		CompleteClass oclAnyClass = completeModel.getCompleteClass(standardLibrary.getOclAnyType());
		//
		String delphiNsUri = "http://www.xtext.org/example/delphi/Delphi";
		String astmNsUri = "http://modelum.es/modernization/astm";
		String ecoreNsUri = ClassUtil.nonNullState(EcorePackage.eNS_URI);
		URI delphiURI = getProjectFileURI("models/Delphi.ecore");
		ClassUtil.nonNullState(metamodelManager.loadResource(delphiURI, "", environmentFactory.getResourceSet()));
		CompletePackage astmPackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(astmNsUri));
		CompletePackage delphiPackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(delphiNsUri));
		CompleteClass CSTraceClass = ClassUtil.nonNullState(delphiPackage.getOwnedCompleteClass("CSTrace"));
		CompleteClass expressionClass = ClassUtil.nonNullState(delphiPackage.getOwnedCompleteClass("expression"));
		CompleteClass VisitableClass = ClassUtil.nonNullState(astmPackage.getOwnedCompleteClass("Visitable"));
		//
		ClassRelationships inheritanceAnalysis = new ClassRelationships(environmentFactory);
		//
		Set<@NonNull CompleteClass> VisitableContainerClasses = inheritanceAnalysis.getContainerClasses(VisitableClass);
		assertEquals(Sets.newHashSet(), VisitableContainerClasses);
		//
		Set<@NonNull CompleteClass> CSTraceContainerClasses = inheritanceAnalysis.getContainerClasses(CSTraceClass);
		assertEquals(Sets.newHashSet(), CSTraceContainerClasses);
		//
		Set<@NonNull CompleteClass> expressionContainerClasses = inheritanceAnalysis.getContainerClasses(expressionClass);
		assertEquals(Sets.newHashSet(), expressionContainerClasses);
		//
		ocl.dispose();
	} */

	@Test
	public void testContainmentAnalysis_ContainerClass_Ecore() throws ParserException {
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//
		CompleteClass oclAnyClass = completeModel.getCompleteClass(standardLibrary.getOclAnyType());
		//
		String ecoreNsUri = ClassUtil.nonNullState(EcorePackage.eNS_URI);
		ClassUtil.nonNullState(metamodelManager.loadResource(URI.createURI(ecoreNsUri), "", environmentFactory.getResourceSet()));
		CompletePackage ecorePackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(ecoreNsUri));
		CompleteClass eAnnotationClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EANNOTATION.getName()));
		CompleteClass eAttributeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EATTRIBUTE.getName()));
		CompleteClass eClassClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ECLASS.getName()));
		CompleteClass eClassifierClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ECLASSIFIER.getName()));
		CompleteClass eDataTypeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EDATA_TYPE.getName()));
		CompleteClass eEnumClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EENUM.getName()));
		CompleteClass eEnumLiteralClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EENUM_LITERAL.getName()));
		CompleteClass eFactoryClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EFACTORY.getName()));
		CompleteClass eGenericTypeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EGENERIC_TYPE.getName()));
		CompleteClass eModelElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EMODEL_ELEMENT.getName()));
		CompleteClass eNamedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ENAMED_ELEMENT.getName()));
		CompleteClass eOperationClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EOPERATION.getName()));
		CompleteClass ePackageClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EPACKAGE.getName()));
		CompleteClass eParameterClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EPARAMETER.getName()));
		CompleteClass eReferenceClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EREFERENCE.getName()));
		CompleteClass eStructuralFeatureClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName()));
		CompleteClass eTypeParameterClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPE_PARAMETER.getName()));
		CompleteClass eTypedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPED_ELEMENT.getName()));
		//
		ContainmentAnalysis containmentAnalysis = new ContainmentAnalysis(environmentFactory);
		//
		Set<@NonNull CompleteClass> oclAnyContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(oclAnyClass));
		assertTrue((100 <= oclAnyContainerClasses.size()) && (oclAnyContainerClasses.size() <= 200));		// Currently 142
		//
		Set<@NonNull CompleteClass> eAnnotationContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eAnnotationClass));
		assertEquals(Sets.newHashSet(eAnnotationClass, eAttributeClass, eClassClass, eClassifierClass, eDataTypeClass, eEnumClass, eEnumLiteralClass, eFactoryClass, eModelElementClass, eNamedElementClass, eOperationClass, ePackageClass, eParameterClass, eReferenceClass, eStructuralFeatureClass, eTypeParameterClass, eTypedElementClass), eAnnotationContainerClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eStructuralFeatureClass));
		assertEquals(Sets.newHashSet(eClassClass), eStructuralFeatureContainerClasses);
		//
		Set<@NonNull CompleteClass> eReferenceSubClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eReferenceClass));
		assertEquals(Sets.newHashSet(eClassClass), eReferenceSubClasses);
		//
		Set<@NonNull CompleteClass> eClassifierSubClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eClassifierClass));
		assertEquals(Sets.newHashSet(ePackageClass), eClassifierSubClasses);
		//
		Set<@NonNull CompleteClass> eTypedElementContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eTypedElementClass));
		assertEquals(Sets.newHashSet(eClassClass, eOperationClass), eTypedElementContainerClasses);
		//
		Set<@NonNull CompleteClass> eModelElementContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eModelElementClass));
		assertEquals(Sets.newHashSet(eAnnotationClass, eAttributeClass, eClassClass, eClassifierClass, eDataTypeClass, eEnumClass, eEnumLiteralClass, eFactoryClass, eModelElementClass, eNamedElementClass, eOperationClass, ePackageClass, eParameterClass, eReferenceClass, eStructuralFeatureClass, eTypeParameterClass, eTypedElementClass), eModelElementContainerClasses);
		//
		Set<@NonNull CompleteClass> eGenericTypeContainerClasses = Sets.newHashSet(containmentAnalysis.getContainerClasses(eGenericTypeClass));
		assertEquals(Sets.newHashSet(eAttributeClass, eClassClass, eGenericTypeClass, eOperationClass, eParameterClass, eReferenceClass, eStructuralFeatureClass, eTypeParameterClass, eTypedElementClass), eGenericTypeContainerClasses);
		//
		ocl.dispose();
	}

	@Test
	public void testContainmentAnalysis_ContainmentProperty_Ecore() throws ParserException {
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//
		CompleteClass oclAnyClass = completeModel.getCompleteClass(standardLibrary.getOclAnyType());
		//
		String ecoreNsUri = ClassUtil.nonNullState(EcorePackage.eNS_URI);
		ClassUtil.nonNullState(metamodelManager.loadResource(URI.createURI(ecoreNsUri), "", environmentFactory.getResourceSet()));
		CompletePackage ecorePackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(ecoreNsUri));
		CompleteClass eAnnotationClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EANNOTATION.getName()));
		CompleteClass eClassClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ECLASS.getName()));
		CompleteClass eClassifierClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ECLASSIFIER.getName()));
		CompleteClass eGenericTypeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EGENERIC_TYPE.getName()));
		CompleteClass eModelElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EMODEL_ELEMENT.getName()));
		CompleteClass eOperationClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EOPERATION.getName()));
		CompleteClass ePackageClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EPACKAGE.getName()));
		CompleteClass eReferenceClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EREFERENCE.getName()));
		CompleteClass eStructuralFeatureClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName()));
		CompleteClass eTypeParameterClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPE_PARAMETER.getName()));
		CompleteClass eTypedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPED_ELEMENT.getName()));
		//
		// EModelElement is not an EObject: Property eAnnotation__contents = ClassUtil.nonNullState(eAnnotationClass.getProperty(EcorePackage.Literals.EANNOTATION__CONTENTS.getName()));
		Property eClass__eGenericSuperType = ClassUtil.nonNullState(eClassClass.getProperty(EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES.getName()));
		Property eClass__eStructuralFeatures = ClassUtil.nonNullState(eClassClass.getProperty(EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES.getName()));
		Property eGenericType__eLowerBound = ClassUtil.nonNullState(eGenericTypeClass.getProperty(EcorePackage.Literals.EGENERIC_TYPE__ELOWER_BOUND.getName()));
		Property eGenericType__eTypeArguments = ClassUtil.nonNullState(eGenericTypeClass.getProperty(EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS.getName()));
		Property eGenericType__eUpperBound = ClassUtil.nonNullState(eGenericTypeClass.getProperty(EcorePackage.Literals.EGENERIC_TYPE__EUPPER_BOUND.getName()));
		Property eModelElement__eAnnotations = ClassUtil.nonNullState(eModelElementClass.getProperty(EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS.getName()));
		Property eOperation__eGenericExceptions = ClassUtil.nonNullState(eOperationClass.getProperty(EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS.getName()));
		Property ePackage__eClassifiers = ClassUtil.nonNullState(ePackageClass.getProperty(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS.getName()));
		Property eTypedElement__eGenericType = ClassUtil.nonNullState(eTypedElementClass.getProperty(EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE.getName()));
		Property eTypeParameter__eBounds = ClassUtil.nonNullState(eTypeParameterClass.getProperty(EcorePackage.Literals.ETYPE_PARAMETER__EBOUNDS.getName()));
		//
		ContainmentAnalysis containmentAnalysis = new ContainmentAnalysis(environmentFactory);
		//
		Set<@NonNull Property> oclAnyContainerProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(oclAnyClass));
		assertTrue((100 <= oclAnyContainerProperties.size()) && (oclAnyContainerProperties.size() <= 120));		// Currently 104
		//
		Set<@NonNull Property> eAnnotationContainerProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(eAnnotationClass));
		assertEquals(Sets.newHashSet(/*eAnnotation__contents,*/ eModelElement__eAnnotations), eAnnotationContainerProperties);
		//
		Set<@NonNull Property> eStructuralFeatureContainerProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(eStructuralFeatureClass));
		assertEquals(Sets.newHashSet(/*eAnnotation__contents,*/ eClass__eStructuralFeatures), eStructuralFeatureContainerProperties);
		//
		Set<@NonNull Property> eReferenceSubProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(eReferenceClass));
		assertEquals(Sets.newHashSet(/*eAnnotation__contents,*/ eClass__eStructuralFeatures), eReferenceSubProperties);
		//
		Set<@NonNull Property> eClassifierSubProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(eClassifierClass));
		assertEquals(Sets.newHashSet(/*eAnnotation__contents,*/ ePackage__eClassifiers), eClassifierSubProperties);
		//
		Set<@NonNull Property> eGenericTypeSubProperties = Sets.newHashSet(containmentAnalysis.getContainmentProperties(eGenericTypeClass));
		assertEquals(Sets.newHashSet(eClass__eGenericSuperType, eGenericType__eLowerBound, eGenericType__eTypeArguments, eGenericType__eUpperBound, eOperation__eGenericExceptions, eTypeParameter__eBounds, eTypedElement__eGenericType), eGenericTypeSubProperties);
		//
		ocl.dispose();
	}

	@Test
	public void testInheritanceAnalysis_SuperClass_Ecore() throws ParserException {
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//
		CompleteClass oclAnyClass = completeModel.getCompleteClass(standardLibrary.getOclAnyType());
		CompleteClass oclElementClass = completeModel.getCompleteClass(standardLibrary.getOclElementType());
		//
		String ecoreNsUri = ClassUtil.nonNullState(EcorePackage.eNS_URI);
		ClassUtil.nonNullState(metamodelManager.loadResource(URI.createURI(ecoreNsUri), "", environmentFactory.getResourceSet()));
		CompletePackage ecorePackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(ecoreNsUri));
		CompleteClass eAnnotationClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EANNOTATION.getName()));
		CompleteClass eAttributeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EATTRIBUTE.getName()));
		CompleteClass eModelElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EMODEL_ELEMENT.getName()));
		CompleteClass eNamedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ENAMED_ELEMENT.getName()));
		CompleteClass eReferenceClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EREFERENCE.getName()));
		CompleteClass eStructuralFeatureClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName()));
		CompleteClass eTypedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPED_ELEMENT.getName()));
		//
		InheritanceAnalysis inheritanceAnalysis = new InheritanceAnalysis(environmentFactory);
		//
		//		Set<@NonNull CompleteClass> oclAnySuperClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(oclAnyClass);
		//		assertEquals(Sets.newHashSet(), oclAnySuperClasses);
		//
		Set<@NonNull CompleteClass> eAnnotationSuperClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(eAnnotationClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eModelElementClass, eAnnotationClass), eAnnotationSuperClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureSuperClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(eStructuralFeatureClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eAttributeClass, eModelElementClass, eNamedElementClass, eReferenceClass, eStructuralFeatureClass, eTypedElementClass), eStructuralFeatureSuperClasses);

		Set<@NonNull CompleteClass> eReferenceSuperClasses = inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(eReferenceClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eModelElementClass, eNamedElementClass, eReferenceClass, eStructuralFeatureClass, eTypedElementClass), eReferenceSuperClasses);
		//
		ocl.dispose();
	}

	@Test
	public void testInheritanceAnalysis_SubClass_Ecore() throws ParserException {
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//
		String ecoreNsUri = ClassUtil.nonNullState(EcorePackage.eNS_URI);
		ClassUtil.nonNullState(metamodelManager.loadResource(URI.createURI(ecoreNsUri), "", environmentFactory.getResourceSet()));
		CompletePackage ecorePackage = ClassUtil.nonNullState(completeModel.getCompletePackageByURI(ecoreNsUri));
		CompleteClass eAttributeClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EATTRIBUTE.getName()));
		CompleteClass eReferenceClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EREFERENCE.getName()));
		CompleteClass eStructuralFeatureClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName()));
		//
		InheritanceAnalysis inheritanceAnalysis = new InheritanceAnalysis(environmentFactory);
		//
		Set<@NonNull CompleteClass> eReferenceSubClasses = inheritanceAnalysis.getAllSelfAndSubClasses(eReferenceClass);
		assertEquals(Sets.newHashSet(eReferenceClass), eReferenceSubClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureSubClasses = inheritanceAnalysis.getAllSelfAndSubClasses(eStructuralFeatureClass);
		assertEquals(Sets.newHashSet(eAttributeClass, eReferenceClass, eStructuralFeatureClass), eStructuralFeatureSubClasses);
		//
		ocl.dispose();
	}

	@Test
	public void testOperationDependencyAnalysis_Companies() throws ParserException {
		QVTcTestUtil.doCompleteOCLSetup();
		QVTcTestUtil.doQVTcoreSetup();
		OCLInternal ocl = OCLInternal.newInstance();
		EnvironmentFactoryInternal environmentFactory = ocl.getEnvironmentFactory();
		//
		URI qvtcURI = URI.createPlatformResourceURI(getClass().getPackage().getName() + "/src/" + getProjectName() + "/companies/CompaniesCS2AS.qvtc", true);
		BaseCSResource csResource = (BaseCSResource) environmentFactory.getResourceSet().getResource(qvtcURI, true);
		ASResource asResource = csResource.getASResource();
		Model asModel = (Model)asResource.getContents().get(0);
		Transformation asTransformation = QVTcoreUtil.getAllTransformations(asModel).get(0);

		ContainmentAnalysis containmentAnalysis = new ContainmentAnalysis(environmentFactory);
		QVTcoreDomainUsageAnalysis domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
		domainAnalysis.analyzeTransformation(asTransformation);
		//
		Mapping asMapping = (Mapping) NameUtil.getNameable(asTransformation.getRule(), "uemployee_2_Employee_mentor");
		Assignment asAssignment = asMapping.getBottomPattern().getAssignment().get(0);
		OCLExpression asExpression = asAssignment.getValue();
		//
		OperationDependencyAnalysis operationDependencyAnalysis = new OperationDependencyAnalysis(containmentAnalysis, domainAnalysis);
		//
		//	Overall analysis of "lEmployee.ast.oclAsType(as::Employee).lookupEmployee(lEmployee.mentor)"
		//
		OperationDependencyPaths analyze = operationDependencyAnalysis.analyze((OperationCallExp) asExpression);

		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		//		CompleteClass oclElementClass = completeModel.getCompleteClass(standardLibrary.getOclElementType());
		CompletePackage companyPackage = completeModel.getCompletePackageByURI("http://org.eclipse.qvtd.compiler.tests.companies/Company");
		CompleteClass employeeClass = companyPackage.getOwnedCompleteClass("Employee");
		//
		CompleteClass companyClass = companyPackage.getOwnedCompleteClass("Company");
		Operation companyUnqualifiedEnvEmployee = companyClass.getOperations(null, "_unqualified_env_Employee").iterator().next();
		Property companyDepts = companyClass.getProperty("depts");
		//
		CompleteClass departmentClass = companyPackage.getOwnedCompleteClass("Department");
		Operation departmentGetEmployees = departmentClass.getOperations(null, "getEmployees").iterator().next();
		Property departmentEmployees = departmentClass.getProperty("employees");
		Property departmentManager = departmentClass.getProperty("manager");
		Property departmentSubdepts = departmentClass.getProperty("subdepts");

		Set<@NonNull List<@NonNull Element>> actualReturns = toElements(analyze.getReturnPaths());
		Set<@NonNull List<@NonNull Element>> expectedReturns =  new HashSet<>();
		expectedReturns.add(Lists.newArrayList(employeeClass.getPrimaryClass()));
		assertEquals(expectedReturns, actualReturns);
		Set<@NonNull List<@NonNull Element>> actualHiddens = toElements(analyze.getHiddenPaths());
		//		Set<@NonNull List<@NonNull Element>> expectedHiddens = toExpected(Lists.newArrayList(employeeClass.getPrimaryClass()));
		assertEquals(187, actualHiddens.size());
		//
		//	"1_.getEmployees()" where 1_ is a department
		//
		//	a recursive call
		//
		OCLExpression exp1 = ((ExpressionInOCL)departmentGetEmployees.getBodyExpression()).getOwnedBody();
		OCLExpression exp2 = ((OperationCallExp)exp1).getOwnedSource();
		OCLExpression exp3 = ((OperationCallExp)exp2).getOwnedSource();
		OCLExpression exp4 = ((OperationCallExp)exp3).getOwnedSource();
		OCLExpression exp5 = ((LoopExp)exp4).getOwnedBody();
		analyze = operationDependencyAnalysis.analyze((OperationCallExp)exp5);
		//
		expectedReturns = new HashSet<>();
		expectedReturns.add(Lists.newArrayList(employeeClass.getPrimaryClass()));
		assertEquals(expectedReturns, actualReturns);
		actualHiddens = toElements(analyze.getHiddenPaths());
		Set<@NonNull List<@NonNull Element>> expectedHiddens = new HashSet<>();
		expectedHiddens.add(Lists.newArrayList(standardLibrary.getOclElementType()));
		expectedHiddens.add(Lists.newArrayList(employeeClass.getPrimaryClass()));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass()));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentEmployees));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentManager));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentSubdepts));
		assertEquals(expectedHiddens, actualHiddens);
		//
		//
		//	"self.getEmployees()" where self is a company
		//
		//	parent of a recursive call
		//
		exp1 = ((ExpressionInOCL)companyUnqualifiedEnvEmployee.getBodyExpression()).getOwnedBody();
		exp2 = ((OperationCallExp)exp1).getOwnedArguments().get(0);
		analyze = operationDependencyAnalysis.analyze((OperationCallExp)exp2);
		//
		actualReturns = toElements(analyze.getReturnPaths());
		expectedReturns =  new HashSet<>();
		expectedReturns.add(Lists.newArrayList(employeeClass.getPrimaryClass()));
		assertEquals(expectedReturns, actualReturns);
		actualHiddens = toElements(analyze.getHiddenPaths());
		expectedHiddens =  new HashSet<>();
		expectedHiddens.add(Lists.newArrayList(standardLibrary.getOclElementType()));
		expectedHiddens.add(Lists.newArrayList(employeeClass.getPrimaryClass()));
		expectedHiddens.add(Lists.newArrayList(companyClass.getPrimaryClass()));
		expectedHiddens.add(Lists.newArrayList(companyClass.getPrimaryClass(), companyDepts));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentEmployees));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentManager));
		expectedHiddens.add(Lists.newArrayList(departmentClass.getPrimaryClass(), departmentSubdepts));
		assertEquals(expectedHiddens, actualHiddens);
		//
		ocl.dispose();
	}

	private Set<@NonNull List<@NonNull Element>> toElements(@NonNull Iterable<@NonNull List<org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationDependencyStep>> paths) {
		Set<@NonNull List<@NonNull Element>> newPaths = new HashSet<>();
		for (@NonNull List<org.eclipse.qvtd.compiler.internal.qvtp2qvts.OperationDependencyStep> path : paths) {
			List<@NonNull Element> newPath = new ArrayList<>();
			for (@NonNull OperationDependencyStep step : path) {
				newPath.add(step.getPathElement());
			}
			newPaths.add(newPath);
		}
		return newPaths;
	}
}
