/*******************************************************************************
 * Copyright (c) 2010, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseUtil
{
	public static void addAllClasses(@NonNull EnvironmentView environmentView, org.eclipse.ocl.pivot.@NonNull Package pPackage) {
		String packageName = pPackage.getName();
		if ((packageName == null) || "".equals(packageName)) {
			environmentView.addNamedElements(pPackage.getOwnedClasses());
		}
		else {
			CompletePackage completePackage = environmentView.getEnvironmentFactory().getCompleteModel().getCompletePackage(pPackage);
			environmentView.addNamedElements(completePackage.getAllClasses());
		}
	}

	public static <T extends NamedElement> void addAllNamedElements(@NonNull EnvironmentView environmentView, @NonNull Iterable<T> namedElements) {
		String name = environmentView.getName();
		if (name != null) {
			for (T namedElement : namedElements) {
				if ((namedElement != null) && name.equals(namedElement.getName())) {
					environmentView.addElement(name, namedElement);
				}
			}
		}
		else {
			for (T namedElement : namedElements) {
				if (namedElement != null) {
					environmentView.addNamedElement(namedElement);
				}
			}
		}
	}

	/**
	 * Return all transformations in asModel.
	 */
	public static @NonNull List<@NonNull Transformation> getAllTransformations(@NonNull Model asModel) {
		List<@NonNull Transformation> asTransformations = new ArrayList<@NonNull Transformation>();
		getAllTransformations(ClassUtil.nullFree(asModel.getOwnedPackages()), asTransformations);
		return asTransformations;
	}

	/**
	 * Accumlate all transformations transitively in asPackages into asTransformations.
	 */
	public static void getAllTransformations(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> asPackages, @NonNull List<@NonNull Transformation> asTransformations) {
		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : asPackages) {
			for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
				if (asClass instanceof Transformation) {
					asTransformations.add((Transformation)asClass);
				}
			}
			getAllTransformations(ClassUtil.nullFree(asPackage.getOwnedPackages()), asTransformations);
		}
	}

	/**
	 * Return the closure of typedModel and its dependsOn.
	 */
	public static @NonNull Set<TypedModel> getAllTypedModels(@NonNull TypedModel typedModel) {
		Set<TypedModel> allTypedModels = new HashSet<TypedModel>();
		getAllTypedModelsInternal(allTypedModels, typedModel);
		return allTypedModels;
	}

	private static void getAllTypedModelsInternal(@NonNull Set<TypedModel> allTypedModels, @NonNull TypedModel typedModel) {
		if (allTypedModels.add(typedModel)) {
			for (@SuppressWarnings("null")@NonNull TypedModel dependsOn : typedModel.getDependsOn()) {
				getAllTypedModelsInternal(allTypedModels, dependsOn);
			}
		}
	}

	/**
	 * Return the closure of transformation.modelParameter.usedPackages and their importedPackages.
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.Package> getAllUsedPackages(@NonNull Transformation transformation) {
		Set<org.eclipse.ocl.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			getAllUsedPackagesInternal(allPackages, typedModel);
		}
		return allPackages;
	}

	/**
	 * Return the closure of typedModel.usedPackages and their importedPackages.
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> getAllUsedPackages(@NonNull TypedModel typedModel) {
		Set<org.eclipse.ocl.pivot.@NonNull Package> allUsedPackages = new HashSet<org.eclipse.ocl.pivot.@NonNull Package>();
		getAllUsedPackagesInternal(allUsedPackages, typedModel);
		return allUsedPackages;
	}

	private static void getAllUsedPackagesInternal(@NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> allUsedPackages,
			@NonNull TypedModel typedModel) {
		getAllUsedPackagesInternal(allUsedPackages, typedModel.getUsedPackage());
		for (@SuppressWarnings("null")@NonNull TypedModel dependsOn : typedModel.getDependsOn()) {
			getAllUsedPackagesInternal(allUsedPackages, dependsOn);
		}
	}

	private static void getAllUsedPackagesInternal(@NonNull Set<org.eclipse.ocl.pivot.Package> allUsedPackages,
			@NonNull Iterable<org.eclipse.ocl.pivot.Package> moreUsedPackages) {
		for (org.eclipse.ocl.pivot.Package usedPackage : moreUsedPackages) {
			if (allUsedPackages.add(usedPackage)) {
				getAllUsedPackagesInternal(allUsedPackages, usedPackage.getImportedPackages());
			}
		}
	}

	public static @Nullable Domain getContainingDomain(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Domain) {
				return (Domain) eObject;
			}
		}
		return null;
	}

	public static @Nullable BaseModel getContainingModel(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof BaseModel) {
				return (BaseModel) eObject;
			}
		}
		return null;
	}

	public static @Nullable Rule getContainingRule(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Rule) {
				return (Rule) eObject;
			}
		}
		return null;
	}

	public static @Nullable Transformation getContainingTransformation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Transformation) {
				return (Transformation) eObject;
			}
		}
		return null;
	}

	/**
	 * Return the context variable for a Transformation, creating it if not yet available.
	 */
	public static @NonNull Variable getContextVariable(@NonNull StandardLibrary standardLibrary, @NonNull Transformation transformation) {
		Variable ownedContext = transformation.getOwnedContext();
		if (ownedContext == null) {
			//			org.eclipse.ocl.pivot.Class transformationType = ((StandardLibraryInternal)standardLibrary).getLibraryType("Transformation");
			//        	if (transformationType == null) {	// FIXME BUG 487123
			//        		throw new IllegalLibraryException("No Transformation type in standard library.");		// FIXME need to be using a derived EnvironmentFactory
			//        	}
			ownedContext = PivotFactory.eINSTANCE.createVariable();
			ownedContext.setName("this");
			ownedContext.setType(transformation);		// FIXME promote API
			//           	ownedContext.setTypeValue(transformation);
			ownedContext.setIsRequired(true);
			transformation.setOwnedContext(ownedContext);
		}
		else {
			ownedContext.setTypeValue(transformation);		// FIXME BUG 484723 find a better solution for the transient declaration
		}
		return ownedContext;
	}

	/**
	 * Return the context variable for a TypedModel, creating it if not yet available.
	 */
	public static @NonNull Variable getContextVariable(@NonNull StandardLibraryInternal standardLibrary, @NonNull TypedModel typedModel) {
		Variable ownedContext = typedModel.getOwnedContext();
		if (ownedContext == null) {
			ownedContext = PivotFactory.eINSTANCE.createVariable();
			ownedContext.setName(typedModel.getName());
			ownedContext.setType(standardLibrary.getLibraryType("Model"));
			//        	ownedContext.setTypeValue(typedModel);
			ownedContext.setIsRequired(true);
			typedModel.setOwnedContext(ownedContext);
		}
		return ownedContext;
	}

	public static @Nullable Domain getDomain(@NonNull Rule rule, @NonNull TypedModel typedModel) {
		for (Domain domain : rule.getDomain()) {
			if (domain.getTypedModel() == typedModel) {
				return domain;
			}
		}
		return null;
	}

	public static @NonNull Type getElementalType(@NonNull Type type) {
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
			assert elementType != null;
		}
		return elementType;
	}

	/**
	 * Return the TypedModels that are enforced by all domains that reference them throughout the transformation.
	 */
	public static @NonNull Set<@NonNull TypedModel> getEnforceableTypedModels(@NonNull Transformation transformation) {
		Set<@NonNull TypedModel> enforceableTypedModels = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> notEnforceableTypedModels = new HashSet<@NonNull TypedModel>();
		for (Rule rule : transformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				TypedModel typedModel = domain.getTypedModel();
				assert typedModel != null;
				if (domain.isIsEnforceable()) {
					enforceableTypedModels.add(typedModel);
				}
				else {
					notEnforceableTypedModels.add(typedModel);
				}
			}
		}
		enforceableTypedModels.removeAll(notEnforceableTypedModels);
		return enforceableTypedModels;
	}

	public static @NonNull Iterable<@NonNull VariableDeclaration> getExternalVariables(@NonNull OperationCallExp operationCallExp) {
		List<@NonNull VariableDeclaration> externalVariables = new ArrayList<>();
		for (@NonNull EObject eObject : new TreeIterable(operationCallExp, false)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				assert referredVariable != null;
				EObject eContainer = referredVariable.eContainer();
				boolean gotIt = eContainer instanceof Transformation;
				for (; !gotIt && (eContainer != null); eContainer = eContainer.eContainer()) {
					if (eContainer == operationCallExp) {
						gotIt = true;
					}
				}
				if (!gotIt && !externalVariables.contains(referredVariable)) {
					externalVariables.add(referredVariable);
				}
			}
		}
		return externalVariables;
	}


	/**
	 * Return true if asOperation is an Identification - an operation whose result is a singleton object.
	 */
	public static boolean isIdentification(Operation asOperation) {
		if (asOperation instanceof Function) {
			OCLExpression queryExpression = ((Function)asOperation).getQueryExpression();
			if (queryExpression instanceof ShadowExp) {
				return true;
			}
		}
		return false;
	}

	public static @NonNull Transformation loadTransformation(@NonNull Class<? extends Model> modelClass, @NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CSResource xtextResource = null;
		ASResource asResource;
		// Load the transformation resource
		if (PivotUtilInternal.isASURI(transformationURI)) {
			asResource = (ASResource) environmentFactory.getMetamodelManager().getASResourceSet().getResource(transformationURI, true);
		}
		else {
			xtextResource = (CSResource) environmentFactory.getResourceSet().getResource(transformationURI, true);
			if (xtextResource == null) {
				throw new IOException("Failed to load '" + transformationURI + "'");
			}
			String csMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(xtextResource.getErrors()), "Failed to load '" + transformationURI + "'", "\n");
			if (csMessage != null) {
				throw new IOException(csMessage);
			}
			asResource = xtextResource.getASResource();
		}
		try {
			String asMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(asResource.getErrors()), "Failed to load '" + asResource.getURI() + "'", "\n");
			if (asMessage != null) {
				throw new IOException(asMessage);
			}
			for (EObject eContent : asResource.getContents()) {
				if (modelClass.isInstance(eContent)) {
					for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(((Model)eContent).getOwnedPackages())) {
						Transformation asTransformation = loadTransformationRecursion(asPackage);
						if (asTransformation != null) {
							return asTransformation;
						}
					}
				}
			}
		} finally {
			if (!keepDebug && (xtextResource instanceof CSResource.CSResourceExtension)) {
				((CSResource.CSResourceExtension)xtextResource).dispose();
			}
		}
		throw new IOException("Failed to locate a transformation in '" + transformationURI + "'");
	}

	private static @Nullable Transformation loadTransformationRecursion(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
			if (asClass instanceof Transformation) {
				return (Transformation)asClass;
			}
		}
		for (org.eclipse.ocl.pivot.@NonNull Package asNestedPackage : ClassUtil.nullFree(asPackage.getOwnedPackages())) {
			Transformation asTransformation = loadTransformationRecursion(asNestedPackage);
			if (asTransformation != null) {
				return asTransformation;
			}
		}
		return null;
	}

	public static @NonNull Resource loadTransformations(@NonNull Class<? extends Model> modelClass, @NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CSResource xtextResource = null;
		ASResource asResource;
		// Load the transformation resource
		if (PivotUtilInternal.isASURI(transformationURI)) {
			asResource = (ASResource) environmentFactory.getMetamodelManager().getASResourceSet().getResource(transformationURI, true);
		}
		else {
			xtextResource = (CSResource) environmentFactory.getResourceSet().getResource(transformationURI, true);
			if (xtextResource == null) {
				throw new IOException("Failed to load '" + transformationURI + "'");
			}
			String csMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(xtextResource.getErrors()), "Failed to load '" + transformationURI + "'", "\n");
			if (csMessage != null) {
				throw new IOException(csMessage);
			}
			asResource = xtextResource.getASResource();
		}
		if (asResource == null) {
			throw new IOException("Failed to load '" + transformationURI + "'");
		}
		return asResource;
		/*		try {
			String asMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(asResource.getErrors()), "Failed to load '" + asResource.getURI() + "'", "\n");
			if (asMessage != null) {
				throw new IOException(asMessage);
			}
			for (EObject eContent : asResource.getContents()) {
				if (modelClass.isInstance(eContent)) {
	    			for (org.eclipse.ocl.pivot.Package asPackage : ((Model)eContent).getOwnedPackages()) {		// FIXME nested classes
    	    			for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
    	    				if (asClass instanceof Transformation) {
    	    	                return (Transformation)asClass;
    	    				}
    	    			}
	    			}
				}
			}
		} finally {
			if (!keepDebug && (xtextResource instanceof CSResource.CSResourceExtension)) {
				((CSResource.CSResourceExtension)xtextResource).dispose();
			}
		}
        throw new IOException("Failed to locate a transformation in '" + transformationURI + "'"); */
	}

	/**
	 * Rewrite asResource to replace null OperationCallExp sources by a "this" expression.
	 */
	public static @Nullable List<OperationCallExp> rewriteMissingOperationCallSources(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource asResource) {
		List<OperationCallExp> missingSources = null;
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eObject;
				if (operationCallExp.getOwnedSource() == null) {
					if (missingSources == null) {
						missingSources = new ArrayList<OperationCallExp>();
					}
					missingSources.add(operationCallExp);
				}
			}
		}
		if (missingSources != null) {
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
			for (OperationCallExp operationCallExp : missingSources) {
				Transformation transformation = QVTbaseUtil.getContainingTransformation(operationCallExp);
				if (transformation != null) {
					Variable thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
					operationCallExp.setOwnedSource(PivotUtil.createVariableExp(thisVariable));
				}
			}
		}
		return missingSources;
	}

	/**
	 * Rewrite asTree and all its descendants to replace all "?." and "?->" navigations by their safe counterparts.
	 */
	public static void rewriteSafeNavigations(@NonNull EnvironmentFactory environmentFactory, @NonNull Element asTree) {
		//
		//	Locate all unsafe calls first to avoid CME from concurrent locate/rewrite.
		//
		List<@NonNull CallExp> unsafeCallExps = null;
		if (asTree instanceof CallExp) {
			unsafeCallExps = rewriteUnsafeCallExp_Gather(unsafeCallExps, (CallExp)asTree);
		}
		for (TreeIterator<EObject> tit = asTree.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof CallExp) {
				unsafeCallExps = rewriteUnsafeCallExp_Gather(unsafeCallExps, (CallExp)eObject);
			}
		}
		//
		//	Rewrite the unsafe calls
		//
		if (unsafeCallExps != null) {
			PivotMetamodelManager metamodelManager = (PivotMetamodelManager) environmentFactory.getMetamodelManager();
			org.eclipse.ocl.pivot.Class oclAnyType = environmentFactory.getStandardLibrary().getOclAnyType();
			Operation oclEqualsOperation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
			assert oclEqualsOperation != null;
			org.eclipse.ocl.pivot.Class collectionType = environmentFactory.getStandardLibrary().getCollectionType();
			Operation excludingOperation = NameUtil.getNameable(collectionType.getOwnedOperations(), "excluding");
			assert excludingOperation != null;
			for (CallExp unsafeCallExp : unsafeCallExps) {
				OCLExpression source = unsafeCallExp.getOwnedSource();
				assert source != null;
				if (source.getType() instanceof CollectionType) {
					rewriteUnsafeCollectionCallExp(metamodelManager, excludingOperation, unsafeCallExp);
				}
				else {
					rewriteUnsafeObjectCallExp(metamodelManager, oclEqualsOperation, unsafeCallExp);
				}
			}
		}
	}

	private static @Nullable List<@NonNull CallExp> rewriteUnsafeCallExp_Gather(@Nullable List<@NonNull CallExp> unsafeCallExps, @NonNull CallExp callExp) {
		OCLExpression source = callExp.getOwnedSource();
		if ((source != null) && callExp.isIsSafe()) {
			if (unsafeCallExps == null) {
				unsafeCallExps = new ArrayList<@NonNull CallExp>();
			}
			unsafeCallExps.add(callExp);
		}
		return unsafeCallExps;
	}

	private static void rewriteUnsafeCollectionCallExp(@NonNull PivotMetamodelManager metamodelManager, @NonNull Operation excludingOperation, @NonNull CallExp unsafeCollectionCallExp) {
		unsafeCollectionCallExp.setIsSafe(false);
		EObject eContainer = unsafeCollectionCallExp.eContainer();
		EReference eContainmentFeature = unsafeCollectionCallExp.eContainmentFeature();
		PivotUtilInternal.resetContainer(unsafeCollectionCallExp);
		//
		OCLExpression nullExpression = metamodelManager.createNullLiteralExp();
		OCLExpression safeCollectionCallExp = PivotUtil.createOperationCallExp(unsafeCollectionCallExp, excludingOperation, nullExpression);
		//
		eContainer.eSet(eContainmentFeature, safeCollectionCallExp);
	}

	private static void rewriteUnsafeObjectCallExp(@NonNull PivotMetamodelManager metamodelManager, @NonNull Operation oclEqualsOperation, @NonNull CallExp unsafeObjectCallExp) {
		unsafeObjectCallExp.setIsSafe(false);
		EObject eContainer = unsafeObjectCallExp.eContainer();
		EReference eContainmentFeature = unsafeObjectCallExp.eContainmentFeature();
		PivotUtilInternal.resetContainer(unsafeObjectCallExp);
		OCLExpression oldSourceExpression = unsafeObjectCallExp.getOwnedSource();
		assert oldSourceExpression != null;
		//
		Variable unsafeSourceVariable = PivotUtil.createVariable("unsafe", oldSourceExpression);
		OCLExpression unsafeSourceExpression1 = PivotUtil.createVariableExp(unsafeSourceVariable);
		unsafeObjectCallExp.setOwnedSource(unsafeSourceExpression1);
		//
		OCLExpression unsafeSourceExpression2 = PivotUtil.createVariableExp(unsafeSourceVariable);
		OCLExpression nullExpression = metamodelManager.createNullLiteralExp();
		OCLExpression isUnsafeExpression = PivotUtil.createOperationCallExp(unsafeSourceExpression2, oclEqualsOperation, nullExpression);
		//
		OCLExpression thenExpression = metamodelManager.createNullLiteralExp();
		OCLExpression safeObjectCallExp = metamodelManager.createIfExp(isUnsafeExpression, thenExpression, unsafeObjectCallExp);
		//
		LetExp safeExp = PivotUtil.createLetExp(unsafeSourceVariable, safeObjectCallExp);
		//
		eContainer.eSet(eContainmentFeature, safeExp);
	}
}