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

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ContainmentAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.InheritanceAnalysis;
import org.eclipse.qvtd.xtext.qvtbase.tests.XtextTestCase;
import org.junit.Test;

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
	public void testContainmentAnalysis_Ecore() throws ParserException {
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
}
