/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
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
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseUtil
{
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
	public static @NonNull Set<org.eclipse.ocl.pivot.Package> getAllUsedPackages(@NonNull TypedModel typedModel) {
		Set<org.eclipse.ocl.pivot.Package> allUsedPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
		getAllUsedPackagesInternal(allUsedPackages, typedModel);
		return allUsedPackages;
	}

	private static void getAllUsedPackagesInternal(@NonNull Set<org.eclipse.ocl.pivot.Package> allUsedPackages,
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
        	ownedContext = PivotFactory.eINSTANCE.createVariable();
        	ownedContext.setName("this");
        	ownedContext.setType(((StandardLibraryInternal)standardLibrary).getLibraryType("Transformation"));		// FIXME promote API
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
        	ownedContext = PivotFactory.eINSTANCE.createVariable();
        	ownedContext.setName(typedModel.getName());
        	ownedContext.setType(standardLibrary.getLibraryType("Model"));
//        	ownedContext.setTypeValue(typedModel);
        	ownedContext.setIsRequired(true);
        	typedModel.setOwnedContext(ownedContext);
        }
		return ownedContext;
	}

	public static @NonNull Type getElementalType(@NonNull Type type) {
		Type elementType = type;
		while (elementType instanceof CollectionType) {
			elementType = ((CollectionType)elementType).getElementType();
			assert elementType != null;
		}
		return elementType;
	}
	
    public static @NonNull Transformation loadTransformation(@NonNull Class<? extends Model> modelClass, @NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		// Load the transformation resource
        CSResource xtextResource = (CSResource) environmentFactory.getResourceSet().getResource(transformationURI, true);
        if (xtextResource == null) {
            throw new IOException("Failed to load '" + transformationURI + "'");
        }
		String csMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(xtextResource.getErrors()), "Failed to load '" + transformationURI + "'", "\n");
		if (csMessage != null) {
			throw new IOException(csMessage);
		}
		try {
			ASResource asResource = xtextResource.getASResource();
			String asMessage = PivotUtil.formatResourceDiagnostics(ClassUtil.nonNullEMF(asResource.getErrors()), "Failed to load '" + asResource.getURI() + "'", "\n");
			if (asMessage != null) {
				throw new IOException(asMessage);
			}
			for (EObject eContent : asResource.getContents()) {
				if (modelClass.isInstance(eContent)) {
	    			for (org.eclipse.ocl.pivot.Package asPackage : ((Model)eContent).getOwnedPackages()) {
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
        throw new IOException("Failed to locate a transformation in '" + transformationURI + "'");
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