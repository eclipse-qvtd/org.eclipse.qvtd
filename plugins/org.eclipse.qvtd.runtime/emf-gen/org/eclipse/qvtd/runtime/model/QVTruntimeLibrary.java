/*******************************************************************************
 * Copyright (c) 2010, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: /org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib
 * by: org.eclipse.ocl.examples.build.xtend.generateOCLstdlib.xtend
 * and: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvtd.runtime.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.*;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage;

/**
 * This is the http://www.eclipse.org/qvt/2019/QVTruntimeLibrary Standard Library
 * auto-generated from /org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib.
 * It facilitates efficient library loading without the overheads of model reading.
 * <p>
 * This Standard Library may be registered as the definition of a Standard Library for
 * the OCL evaluation framework by invoking {@link #install}.
 * <p>
 * The Standard Library is normally activated when the MetamodelManager attempts
 * to locate a library type when its default Standard Library URI is the same
 * as this Standard Library.
 */
@SuppressWarnings("unused")
public class QVTruntimeLibrary extends ASResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	private static QVTruntimeLibrary INSTANCE = null;

	/**
	 *	The URI of this Standard Library.
	 */
	public static final @NonNull String STDLIB_URI = "http://www.eclipse.org/qvt/2019/QVTruntimeLibrary";

	/**
	 *	The URI of the AS representation of this Standard Library.
	 */
	public static final @NonNull URI STDLIB_AS_URI = URI.createURI("http://www.eclipse.org/qvt/2019/QVTruntimeLibrary" + PivotConstants.DOT_OCL_AS_FILE_EXTENSION);

	/**
	 * Return the default http://www.eclipse.org/qvt/2019/QVTruntimeLibrary standard Library Resource
	 * if it jas been created, or null if not.
	 *  This static definition auto-generated from /org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @Nullable QVTruntimeLibrary basicGetDefault() {
		return INSTANCE;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2019/QVTruntimeLibrary standard Library Resource.
	 *  This static definition auto-generated from /org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @NonNull QVTruntimeLibrary getDefault() {
		QVTruntimeLibrary oclstdlib = INSTANCE;
		if (oclstdlib == null) {
			Contents contents = new Contents("http://www.eclipse.org/qvt/2019/QVTruntimeLibrary");
			String asURI = STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION;
			oclstdlib = INSTANCE = new ReadOnly(asURI, contents.getModel());
		}
		return oclstdlib;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2019/QVTruntimeLibrary standard Library model.
	 *  This static definition auto-generated from /org.eclipse.qvtd.runtime/model/QVTruntimeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 */
	public static @NonNull Model getDefaultModel() {
		Model model = (Model)(getDefault().getContents().get(0));
		assert model != null;
		return model;
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}
	 * and the {@link OCLASResourceFactory#REGISTRY}.
	 * This method may be invoked by standalone applications to replicate
	 * the registration that should appear as a standard_library plugin
	 * extension when running within Eclipse.
	 */
	public static void install() {
		EPackage.Registry.INSTANCE.put(OCLstdlibPackage.eNS_URI, OCLstdlibPackage.eINSTANCE);
		Loader contribution = new Loader();
		StandardLibraryContribution.REGISTRY.put(STDLIB_URI, contribution);
		OCLASResourceFactory.REGISTRY.put(STDLIB_AS_URI, contribution);
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}
	 * and the {@link OCLASResourceFactory#REGISTRY}
	 * unless some other library contribution has already been installed.
	 */
	public static void lazyInstall() {
		if (StandardLibraryContribution.REGISTRY.get(STDLIB_URI) == null) {
			install();
		}
	}

	/**
	 * Uninstall this library from the {@link StandardLibraryContribution#REGISTRY}
	 * and the {@link OCLASResourceFactory#REGISTRY}.
	 * This method may be invoked by standalone applications to release the library
	 * resources for garbage collection and memory leakage detection.
	 */
	public static void uninstall() {
		StandardLibraryContribution.REGISTRY.remove(STDLIB_URI);
		OCLASResourceFactory.REGISTRY.remove(STDLIB_AS_URI);
		INSTANCE = null;
	}

	/**
	 * The Loader shares the Standard Library instance whenever this default library
	 * is loaded from the registry of Standard Libraries populated by the standard_library
	 * extension point.
	 */
	public static class Loader implements StandardLibraryContribution
	{
		@Override
		public @NonNull StandardLibraryContribution getContribution() {
			return this;
		}

		@Override
		public @NonNull Resource getResource() {
			return getDefault();
		}
	}

	/**
	 * A ReadOnly QVTruntimeLibrary overrides inherited functionality to impose immutable shared behaviour.
	 */
	protected static class ReadOnly extends QVTruntimeLibrary implements ImmutableResource
	{
		protected ReadOnly(@NonNull String asURI, @NonNull Model libraryModel) {
			super(asURI, libraryModel);
			setSaveable(false);
		}

		/**
		 * Overridden to inhibit entry of the shared instance in any ResourceSet.
		 */
		@Override
		public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
			return notifications;
		}

		/**
		 * Overridden to inhibit unloading of the shared instance.
		 */
		@Override
		protected void doUnload() {}

		@Override
		public boolean isCompatibleWith(@NonNull String metamodelURI) {
			return OCLmetamodel.PIVOT_URI.equals(metamodelURI);
		}

		/**
		 * Overridden to trivialise loading of the shared instance.
		 */
		@Override
		public void load(Map<?, ?> options) throws IOException {
			if (this != INSTANCE) {
				super.load(options);
			}
			else {
				setLoaded(true);
			}
		}

		/**
		 * Overridden to inhibit unloading of the shared instance.
		 */
		@Override
		protected Notification setLoaded(boolean isLoaded) {
			if (isLoaded) {
				return super.setLoaded(isLoaded);
			}
			else {
				return null;
			}
		}
	}

	/**
	 *	Construct a copy of the OCL Standard Library with specified resource URI,
	 *  and package name, prefix and namespace URI.
	 */
	public static @NonNull QVTruntimeLibrary create(@NonNull String asURI) {
		Contents contents = new Contents(asURI);
		return new QVTruntimeLibrary(asURI, contents.getModel());
	}

	/**
	 *	Construct an OCL Standard Library with specified resource URI and library content.
	 */
	private QVTruntimeLibrary(@NonNull String asURI, @NonNull Model libraryModel) {
		super(ClassUtil.nonNullState(URI.createURI(asURI)), OCLASResourceFactory.getInstance());
		assert PivotUtilInternal.isASURI(asURI);
		getContents().add(libraryModel);
	}

	private static class Contents extends AbstractContents
	{
		private final @NonNull Model model;
		private final @NonNull Package ocl;
		private final @NonNull Library qvtruntimelibrary;
		private final @NonNull Package orphanage;

		private Contents(@NonNull String asURI)
		{
			model = createModel(asURI);
			ocl = createPackage("ocl", "ocl", "http://www.eclipse.org/ocl/2015/Library", IdManager.METAMODEL);
			qvtruntimelibrary = createLibrary("qvtruntimelibrary", "qvtrtlib", "http://www.eclipse.org/qvt/2019/QVTruntimeLibrary", null);
			orphanage = createPackage("$$", "orphanage", "http://www.eclipse.org/ocl/2015/Orphanage", null);
			installPackages();
			installClassTypes();
			installCollectionTypes();
			installOperations();
			installProperties();
			installTemplateBindings();
			installComments();
		}

		public @NonNull Model getModel() {
			return model;
		}
		
		private final @NonNull Package _ocl = getPackage(org.eclipse.ocl.pivot.model.OCLstdlib.getDefaultModel(), "ocl");
		private final @NonNull Package _pivot = getPackage(org.eclipse.ocl.pivot.model.OCLmetamodel.getDefaultModel(), "pivot");
		private final @NonNull CollectionType _Collection = getCollectionType(_ocl, "Collection");
		private final @NonNull Class _CollectionItem = getClass(_pivot, "CollectionItem");
		private final @NonNull Class _CollectionLiteralExp = getClass(_pivot, "CollectionLiteralExp");
		private final @NonNull Class _CollectionRange = getClass(_pivot, "CollectionRange");
		private final @NonNull Class _Element = getClass(_pivot, "Element");
		private final @NonNull Class _MapLiteralExp = getClass(_pivot, "MapLiteralExp");
		private final @NonNull Class _MapLiteralPart = getClass(_pivot, "MapLiteralPart");
		private final @NonNull Class _OCLExpression = getClass(_pivot, "OCLExpression");
		private final @NonNull AnyType _OclAny = getAnyType(_ocl, "OclAny");
		private final @NonNull Class _OclElement = getClass(_ocl, "OclElement");
		private final @NonNull VoidType _OclVoid = getVoidType(_ocl, "OclVoid");
		private final @NonNull CollectionType _OrderedCollection = getCollectionType(_ocl, "OrderedCollection");
		private final @NonNull OrderedSetType _OrderedSet = getOrderedSetType(_ocl, "OrderedSet");
		private final @NonNull Class _Property = getClass(_pivot, "Property");
		private final @NonNull SetType _Set = getSetType(_ocl, "Set");
		private final @NonNull Class _ShadowExp = getClass(_pivot, "ShadowExp");
		private final @NonNull Class _TupleLiteralExp = getClass(_pivot, "TupleLiteralExp");
		private final @NonNull Class _TupleLiteralPart = getClass(_pivot, "TupleLiteralPart");
		private final @NonNull Class _TypeExp = getClass(_pivot, "TypeExp");
		private final @NonNull CollectionType _UniqueCollection = getCollectionType(_ocl, "UniqueCollection");
		private final @NonNull TemplateParameter _Collection_T = getTemplateParameter(_Collection, 0);
		private final @NonNull TemplateParameter _OrderedCollection_T = getTemplateParameter(_OrderedCollection, 0);
		private final @NonNull TemplateParameter _OrderedSet_T = getTemplateParameter(_OrderedSet, 0);
		private final @NonNull TemplateParameter _Set_T = getTemplateParameter(_Set, 0);
		private final @NonNull TemplateParameter _UniqueCollection_T = getTemplateParameter(_UniqueCollection, 0);
		
		private void installPackages() {
			model.getOwnedPackages().add(ocl);
			model.getOwnedPackages().add(qvtruntimelibrary);
			model.getOwnedPackages().add(orphanage);
			model.getOwnedImports().add(createImport(null, _ocl));
			model.getOwnedImports().add(createImport("ocl", _pivot));
		}
		
		private final @NonNull Class _OclElement_1 = createClass("OclElement");
		
		private final @NonNull Class _Extent = createClass(QVTruntimeLibraryPackage.Literals.EXTENT);
		private final @NonNull Class _Model = createClass(QVTruntimeLibraryPackage.Literals.MODEL);
		private final @NonNull Class _PseudoOperations = createClass("PseudoOperations");
		private final @NonNull Class _Transformation = createClass(QVTruntimeLibraryPackage.Literals.TRANSFORMATION);
		
		private final @NonNull TemplateParameter tp_PseudoOperations_collection_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_error_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_if_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_loop_E = createTemplateParameter("E");
		private final @NonNull TemplateParameter tp_PseudoOperations_mapPart_K = createTemplateParameter("K");
		private final @NonNull TemplateParameter tp_PseudoOperations_mapPart_V = createTemplateParameter("V");
		private final @NonNull TemplateParameter tp_PseudoOperations_map_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_range_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_shadow_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_tuple_T = createTemplateParameter("T");
		private final @NonNull TemplateParameter tp_PseudoOperations_type_V = createTemplateParameter("V");
		
		private final @NonNull CollectionType _Collection_OclElement = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_CollectionItem = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Element = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Property = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_TupleLiteralPart = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_PseudoOperations_loop_E = createCollectionType(_Collection);
		private final @NonNull CollectionType _OrderedCollection_OclElement = createCollectionType(_OrderedCollection);
		private final @NonNull OrderedSetType _OrderedSet_OclElement_NullFree = createOrderedSetType(_OrderedSet);
		private final @NonNull SetType _Set_CollectionItem = createSetType(_Set);
		private final @NonNull SetType _Set_Element = createSetType(_Set);
		private final @NonNull SetType _Set_Property = createSetType(_Set);
		private final @NonNull SetType _Set_TupleLiteralPart = createSetType(_Set);
		private final @NonNull SetType _Set_PseudoOperations_loop_E = createSetType(_Set);
		private final @NonNull CollectionType _UniqueCollection_OclElement = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_CollectionItem = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Element = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Property = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_TupleLiteralPart = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_PseudoOperations_loop_E = createCollectionType(_UniqueCollection);
		
		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;
		
			ownedClasses = ocl.getOwnedClasses();
			ownedClasses.add(type = _OclElement_1);
		
			ownedClasses = qvtruntimelibrary.getOwnedClasses();
			ownedClasses.add(type = _Extent);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Model);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _PseudoOperations);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Transformation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		}
		
		private void installCollectionTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			CollectionType type;
		
			ownedClasses = orphanage.getOwnedClasses();
			ownedClasses.add(type = _Collection_OclElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_CollectionItem);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Element);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Property);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_TupleLiteralPart);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_PseudoOperations_loop_E);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _OrderedCollection_OclElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_OclElement);
			ownedClasses.add(type = _OrderedSet_OclElement_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_OclElement);
			superClasses.add(_UniqueCollection_OclElement);
			ownedClasses.add(type = _Set_CollectionItem);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_CollectionItem);
			ownedClasses.add(type = _Set_Element);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Element);
			ownedClasses.add(type = _Set_Property);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Property);
			ownedClasses.add(type = _Set_TupleLiteralPart);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_TupleLiteralPart);
			ownedClasses.add(type = _Set_PseudoOperations_loop_E);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_PseudoOperations_loop_E);
			ownedClasses.add(type = _UniqueCollection_OclElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_OclElement);
			ownedClasses.add(type = _UniqueCollection_CollectionItem);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_CollectionItem);
			ownedClasses.add(type = _UniqueCollection_Element);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Element);
			ownedClasses.add(type = _UniqueCollection_Property);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Property);
			ownedClasses.add(type = _UniqueCollection_TupleLiteralPart);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TupleLiteralPart);
			ownedClasses.add(type = _UniqueCollection_PseudoOperations_loop_E);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_PseudoOperations_loop_E);
		}
		
		private final @NonNull Operation op_PseudoOperations_collection = createOperation("collection", _CollectionLiteralExp, null, null, tp_PseudoOperations_collection_T);
		private final @NonNull Operation op_PseudoOperations_error = createOperation("error", _OclVoid, null, null, tp_PseudoOperations_error_T);
		private final @NonNull Operation op_PseudoOperations_if = createOperation("if", tp_PseudoOperations_if_T, null, null, tp_PseudoOperations_if_T);
		private final @NonNull Operation op_PseudoOperations_loop = createOperation("loop", _OclAny, null, null, tp_PseudoOperations_loop_E);
		private final @NonNull Operation op_PseudoOperations_mapPart = createOperation("mapPart", _MapLiteralPart, null, null, tp_PseudoOperations_mapPart_K, tp_PseudoOperations_mapPart_V);
		private final @NonNull Operation op_PseudoOperations_map = createOperation("map", _MapLiteralExp, null, null, tp_PseudoOperations_map_T);
		private final @NonNull Operation op_PseudoOperations_range = createOperation("range", _CollectionRange, null, null, tp_PseudoOperations_range_T);
		private final @NonNull Operation op_PseudoOperations_shadow = createOperation("shadow", _ShadowExp, null, null, tp_PseudoOperations_shadow_T);
		private final @NonNull Operation op_PseudoOperations_tuple = createOperation("tuple", _TupleLiteralExp, null, null, tp_PseudoOperations_tuple_T);
		private final @NonNull Operation op_PseudoOperations_type = createOperation("type", _TypeExp, null, null, tp_PseudoOperations_type_V);
		
		private void installOperations() {
			List<Operation> ownedOperations;
			List<Parameter> ownedParameters;
			Operation operation;
			Parameter parameter;
		
			ownedOperations = _PseudoOperations.getOwnedOperations();
			ownedOperations.add(operation = op_PseudoOperations_collection);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("items", _Set_CollectionItem, true));
			ownedOperations.add(operation = op_PseudoOperations_error);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("elements", _Set_Element, true));
			ownedOperations.add(operation = op_PseudoOperations_if);
			operation.setIsRequired(false);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("condition", tp_PseudoOperations_if_T, false));
			ownedParameters.add(parameter = createParameter("then", tp_PseudoOperations_if_T, false));
			ownedParameters.add(parameter = createParameter("else", tp_PseudoOperations_if_T, false));
			ownedOperations.add(operation = op_PseudoOperations_loop);
			operation.setIsRequired(false);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("source", _OCLExpression, true));
			ownedParameters.add(parameter = createParameter("iterators", _Set_PseudoOperations_loop_E, true));
			ownedParameters.add(parameter = createParameter("body", _OCLExpression, true));
			ownedOperations.add(operation = op_PseudoOperations_mapPart);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("key", tp_PseudoOperations_mapPart_K, false));
			ownedParameters.add(parameter = createParameter("value", tp_PseudoOperations_mapPart_V, false));
			ownedOperations.add(operation = op_PseudoOperations_map);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("parts", _Set_Property, true));
			ownedOperations.add(operation = op_PseudoOperations_range);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("first", tp_PseudoOperations_range_T, false));
			ownedParameters.add(parameter = createParameter("last", tp_PseudoOperations_range_T, false));
			ownedOperations.add(operation = op_PseudoOperations_shadow);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("parts", _Set_Property, true));
			ownedOperations.add(operation = op_PseudoOperations_tuple);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("parts", _Set_TupleLiteralPart, true));
			ownedOperations.add(operation = op_PseudoOperations_type);
			operation.setIsStatic(true);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("type", tp_PseudoOperations_type_V, false));
		}
		
		
		private final @NonNull Property pr_OclElement_extent_elements = createProperty("extent", _Extent);
		
		private final @NonNull Property pr_Extent_elements = createProperty("elements", _OrderedSet_OclElement_NullFree);
		
		private void installProperties() {
			List<Property> ownedProperties;
			Property property;
		
			ownedProperties = _OclElement_1.getOwnedProperties();
			ownedProperties.add(property = pr_OclElement_extent_elements);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Extent_elements);
		
			ownedProperties = _Extent.getOwnedProperties();
			ownedProperties.add(property = pr_Extent_elements);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_OclElement_extent_elements);
		}
		
		private void installTemplateBindings() {
			addBinding(_Collection_CollectionItem, _CollectionItem);
			addBinding(_Collection_Element, _Element);
			addBinding(_Collection_OclElement, _OclElement);
			addBinding(_Collection_Property, _Property);
			addBinding(_Collection_PseudoOperations_loop_E, tp_PseudoOperations_loop_E);
			addBinding(_Collection_TupleLiteralPart, _TupleLiteralPart);
			addBinding(_OrderedCollection_OclElement, _OclElement);
			addBinding(_OrderedSet_OclElement_NullFree, _OclElement);
			addBinding(_Set_CollectionItem, _CollectionItem);
			addBinding(_Set_Element, _Element);
			addBinding(_Set_Property, _Property);
			addBinding(_Set_PseudoOperations_loop_E, tp_PseudoOperations_loop_E);
			addBinding(_Set_TupleLiteralPart, _TupleLiteralPart);
			addBinding(_UniqueCollection_CollectionItem, _CollectionItem);
			addBinding(_UniqueCollection_Element, _Element);
			addBinding(_UniqueCollection_OclElement, _OclElement);
			addBinding(_UniqueCollection_Property, _Property);
			addBinding(_UniqueCollection_PseudoOperations_loop_E, tp_PseudoOperations_loop_E);
			addBinding(_UniqueCollection_TupleLiteralPart, _TupleLiteralPart);
		}
		
		private void installComments() {
			installComment(op_PseudoOperations_collection, "The PseudoOperations::collection(items) pseudo-operation provides items to allow a collection construction to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_error, "The PseudoOperations::error(elements) pseudo-operation provides parameters to allow an error construction to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_if, "The PseudoOperations::if(condition, then, else) pseudo-operation provides parameters to allow an IfExp to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_loop, "The PseudoOperations::loop(source, iterators, body) pseudo-operation provides parameters to allow a LoopExp to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_mapPart, "The PseudoOperations::mapPart(key, value) pseudo-operation provides parameters to allow a MapLiteralPart to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_map, "The PseudoOperations::map(parts) pseudo-operation provides parameters to allow a map construction to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_range, "The PseudoOperations::range(first, last) pseudo-operation provides parameters to allow a CollectionRange to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_shadow, "The PseudoOperations::shadow(parts) pseudo-operation provides parameters to allow a shadow Class construction to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_tuple, "The PseudoOperations::tuple(parts) pseudo-operation provides parameters to allow a tuple construction to be treated\nas an Operation within QVTs.");
			installComment(op_PseudoOperations_type, "The PseudoOperations::type(value) pseudo-operation provides parameters to allow a Type to be treated\nas an Operation within QVTs.");
		}
	}
}
