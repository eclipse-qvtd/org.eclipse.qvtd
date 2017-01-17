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
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseUtil extends PivotUtil
{
	public static final class DomainNameComparator implements Comparator<@NonNull Domain>
	{
		public static final @NonNull DomainNameComparator INSTANCE = new DomainNameComparator();

		@Override
		public int compare(@NonNull Domain o1, @NonNull Domain o2) {
			TypedModel t1 = o1.getTypedModel();
			TypedModel t2 = o2.getTypedModel();
			String n1 = t1 != null ? t1.getName() : null;
			String n2 = t2 != null ? t2.getName() : null;
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static class Internal extends PivotUtilInternal
	{
		public static @NonNull List<@NonNull TypedModel> getModelParameterList(@NonNull Transformation asTransformation) {
			return ClassUtil.nullFree(asTransformation.getModelParameter());
		}

		public static @NonNull List<@NonNull Predicate> getPredicatesList(@NonNull Pattern asPattern) {
			return ClassUtil.nullFree(asPattern.getPredicate());
		}

		public static @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> getUsedPackagesList(@NonNull TypedModel asTypedModel) {
			return ClassUtil.nullFree(asTypedModel.getUsedPackage());
		}
	}

	/**
	 * Return all transformations in asModel.
	 */
	public static @NonNull List<@NonNull Transformation> getAllTransformations(@NonNull Model asModel) {
		List<@NonNull Transformation> asTransformations = new ArrayList<>();
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
	public static @NonNull Set<@NonNull TypedModel> getAllTypedModels(@NonNull TypedModel typedModel) {
		Set<@NonNull TypedModel> allTypedModels = new HashSet<>();
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
	public static @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> getAllUsedPackages(@NonNull Transformation transformation) {
		Set<org.eclipse.ocl.pivot.@NonNull Package> allPackages = new HashSet<>();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			getAllUsedPackagesInternal(allPackages, typedModel);
		}
		return allPackages;
	}

	/**
	 * Return the closure of typedModel.usedPackages and their importedPackages.
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> getAllUsedPackages(@NonNull TypedModel typedModel) {
		Set<org.eclipse.ocl.pivot.@NonNull Package> allUsedPackages = new HashSet<>();
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

	public static @NonNull OCLExpression getConditionExpression(@NonNull Predicate asPredicate) {
		return ClassUtil.nonNullState(asPredicate.getConditionExpression());
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
			ownedContext = PivotFactory.eINSTANCE.createParameterVariable();
			ownedContext.setName("this");
			ownedContext.setType(transformation);		// FIXME promote API
			ownedContext.setTypeValue(transformation);
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
			ownedContext = PivotFactory.eINSTANCE.createParameterVariable();
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

	/**
	 * Return the TypedModels that are enforced by all domains that reference them throughout the transformation.
	 */
	public static @NonNull Set<@NonNull TypedModel> getEnforceableTypedModels(@NonNull Transformation transformation) {
		Set<@NonNull TypedModel> enforceableTypedModels = new HashSet<>();
		Set<@NonNull TypedModel> notEnforceableTypedModels = new HashSet<>();
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

	public static @NonNull Iterable<@NonNull TypedModel> getModelParameters(@NonNull Transformation asTransformation) {
		return ClassUtil.nullFree(asTransformation.getModelParameter());
	}

	public static @NonNull Iterable<@NonNull Comment> getOwnedComments(@NonNull Element asElement) {
		return ClassUtil.nullFree(asElement.getOwnedComments());
	}

	public static @NonNull Iterable<@NonNull Import> getOwnedImports(@NonNull Model asModel) {
		return ClassUtil.nullFree(asModel.getOwnedImports());
	}

	public static @NonNull List<@NonNull Operation> getOwnedOperations(@NonNull Transformation asTransformation) {
		return ClassUtil.nullFree(asTransformation.getOwnedOperations());
	}

	//	public static @NonNull List<@NonNull Predicate> getOwnedPredicates(@NonNull Pattern asPattern) {
	//		return ClassUtil.nullFree(asPattern.getPredicate());
	//	}

	public static org.eclipse.ocl.pivot.@NonNull Package getOwningPackage(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		return ClassUtil.nonNullState(asClass.getOwningPackage());
	}

	public static @NonNull Iterable<@NonNull Predicate> getPredicates(@NonNull Pattern asPattern) {
		return ClassUtil.nullFree(asPattern.getPredicate());
	}

	public static @NonNull Variable getReferredVariable(@NonNull VariableExp asVariableExp) {
		return (Variable) ClassUtil.nonNullState(asVariableExp.getReferredVariable());
	}

	public static @NonNull List<@NonNull Rule> getRule(@NonNull Transformation asTransformation) {
		return ClassUtil.nullFree(asTransformation.getRule());
	}

	public static @NonNull TypedModel getTypedModel(@NonNull Domain asDomain) {
		return ClassUtil.nonNullState(asDomain.getTypedModel());
	}

	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Class> getUsedClasses(@NonNull TypedModel asTypedModel) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> usedClasses = new HashSet<>();
		for (org.eclipse.ocl.pivot.@NonNull Package rPackage : ClassUtil.nullFree(asTypedModel.getUsedPackage())) {
			usedClasses.addAll(ClassUtil.nullFree(rPackage.getOwnedClasses()));
		}
		return usedClasses;
	}

	public static @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> getUsedPackages(@NonNull TypedModel asTypedModel) {
		return ClassUtil.nullFree(asTypedModel.getUsedPackage());
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
	public static @Nullable List<@NonNull OperationCallExp> rewriteMissingOperationCallSources(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource asResource) {
		List<@NonNull OperationCallExp> missingSources = null;
		for (TreeIterator<EObject> tit = asResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp)eObject;
				if (operationCallExp.getOwnedSource() == null) {
					if (missingSources == null) {
						missingSources = new ArrayList<>();
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
					VariableDeclaration thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
					operationCallExp.setOwnedSource(PivotUtil.createVariableExp(thisVariable));
				}
			}
		}
		return missingSources;
	}
}