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
package org.eclipse.qvtd.xtext.qvtimperative.tests;

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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassRelationships;
import org.junit.Test;

import com.google.common.collect.Sets;

import junit.framework.TestCase;

public class AnalysisTests extends TestCase
{
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		OCLstdlib.install();
	}

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
		ClassRelationships inheritanceAnalysis = new ClassRelationships(environmentFactory);
		//
		Set<@NonNull CompleteClass> oclAnyContainerClasses = inheritanceAnalysis.getContainerClasses(oclAnyClass);
		assertEquals(Sets.newHashSet(), oclAnyContainerClasses);
		//
		Set<@NonNull CompleteClass> eAnnotationContainerClasses = inheritanceAnalysis.getContainerClasses(eAnnotationClass);
		assertEquals(Sets.newHashSet(eAnnotationClass, eAttributeClass, eClassClass, eClassifierClass, eDataTypeClass, eEnumClass, eEnumLiteralClass, eFactoryClass, eModelElementClass, eNamedElementClass, eOperationClass, ePackageClass, eParameterClass, eReferenceClass, eStructuralFeatureClass, eTypeParameterClass, eTypedElementClass), eAnnotationContainerClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureContainerClasses = inheritanceAnalysis.getContainerClasses(eStructuralFeatureClass);
		assertEquals(Sets.newHashSet(eClassClass), eStructuralFeatureContainerClasses);
		//
		Set<@NonNull CompleteClass> eReferenceSubClasses = inheritanceAnalysis.getContainerClasses(eReferenceClass);
		assertEquals(Sets.newHashSet(eClassClass), eReferenceSubClasses);
		//
		Set<@NonNull CompleteClass> eClassifierSubClasses = inheritanceAnalysis.getContainerClasses(eClassifierClass);
		assertEquals(Sets.newHashSet(ePackageClass), eClassifierSubClasses);
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
		CompleteClass eModelElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EMODEL_ELEMENT.getName()));
		CompleteClass eNamedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ENAMED_ELEMENT.getName()));
		CompleteClass eReferenceClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.EREFERENCE.getName()));
		CompleteClass eStructuralFeatureClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName()));
		CompleteClass eTypedElementClass = ClassUtil.nonNullState(ecorePackage.getOwnedCompleteClass(EcorePackage.Literals.ETYPED_ELEMENT.getName()));
		//
		ClassRelationships inheritanceAnalysis = new ClassRelationships(environmentFactory);
		//
		Set<@NonNull CompleteClass> oclAnySuperClasses = inheritanceAnalysis.getAllSuperClasses(oclAnyClass);
		assertEquals(Sets.newHashSet(), oclAnySuperClasses);
		//
		Set<@NonNull CompleteClass> eAnnotationSuperClasses = inheritanceAnalysis.getAllSuperClasses(eAnnotationClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eModelElementClass), eAnnotationSuperClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureSuperClasses = inheritanceAnalysis.getAllSuperClasses(eStructuralFeatureClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eModelElementClass, eNamedElementClass, eTypedElementClass), eStructuralFeatureSuperClasses);
		//
		Set<@NonNull CompleteClass> eReferenceSuperClasses = inheritanceAnalysis.getAllSuperClasses(eReferenceClass);
		assertEquals(Sets.newHashSet(oclAnyClass, oclElementClass, eModelElementClass, eNamedElementClass, eStructuralFeatureClass, eTypedElementClass), eReferenceSuperClasses);
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
		ClassRelationships inheritanceAnalysis = new ClassRelationships(environmentFactory);
		//
		Set<@NonNull CompleteClass> eReferenceSubClasses = inheritanceAnalysis.getAllSubClasses(eReferenceClass);
		assertEquals(Sets.newHashSet(), eReferenceSubClasses);
		//
		Set<@NonNull CompleteClass> eStructuralFeatureSubClasses = inheritanceAnalysis.getAllSubClasses(eStructuralFeatureClass);
		assertEquals(Sets.newHashSet(eAttributeClass, eReferenceClass), eStructuralFeatureSubClasses);
		//
		ocl.dispose();
	}
}
