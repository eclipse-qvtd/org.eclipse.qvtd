/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
 * by: org.eclipse.ocl.examples.build.xtend.generateOCLstdlib.xtend
 * and: org.eclipse.ocl.examples.build.GenerateOCLstdlibModel.mwe2
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.AssociativityKind;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LambdaType;
import org.eclipse.ocl.pivot.Library;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Precedence;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SelfType;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.model.OCLmetamodel;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.qvtd.runtime.qvtruntimelibrary.QVTruntimeLibraryPackage;

/**
 * This is the http://www.eclipse.org/qvt/2016/QVTimperativeLibrary Standard Library
 * auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib.
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
public class QVTimperativeLibrary extends ASResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	private static QVTimperativeLibrary INSTANCE = null;

	/**
	 *	The URI of this Standard Library.
	 */
	public static final @NonNull String STDLIB_URI = "http://www.eclipse.org/qvt/2016/QVTimperativeLibrary";

	/**
	 *	The URI of the AS representation of this Standard Library.
	 */
	public static final @NonNull URI STDLIB_AS_URI = URI.createURI("http://www.eclipse.org/qvt/2016/QVTimperativeLibrary" + PivotConstants.DOT_OCL_AS_FILE_EXTENSION);

	/**
	 * Return the default http://www.eclipse.org/qvt/2016/QVTimperativeLibrary standard Library Resource
	 * if it jas been created, or null if not.
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @Nullable QVTimperativeLibrary basicGetDefault() {
		return INSTANCE;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2016/QVTimperativeLibrary standard Library Resource.
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @NonNull QVTimperativeLibrary getDefault() {
		QVTimperativeLibrary oclstdlib = INSTANCE;
		if (oclstdlib == null) {
			Contents contents = new Contents("http://www.eclipse.org/qvt/2019/QVTruntimeLibrary");
			String asURI = STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION;
			oclstdlib = INSTANCE = new ReadOnly(asURI, contents.getModel());
			oclstdlib.setSaveable(false);
		}
		return oclstdlib;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2016/QVTimperativeLibrary standard Library model.
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
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
	 * A ReadOnly QVTimperativeLibrary overrides inherited functionality to impose immutable shared behaviour.
	 */
	protected static class ReadOnly extends QVTimperativeLibrary implements ImmutableResource
	{
		protected ReadOnly(@NonNull String asURI, @NonNull Model libraryModel) {
			super(asURI, libraryModel);
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
	public static @NonNull QVTimperativeLibrary create(@NonNull String asURI) {
		Contents contents = new Contents(asURI);
		return new QVTimperativeLibrary(asURI, contents.getModel());
	}

	/**
	 *	Construct an OCL Standard Library with specified resource URI and library content.
	 */
	private QVTimperativeLibrary(@NonNull String asURI, @NonNull Model libraryModel) {
		super(ClassUtil.nonNullState(URI.createURI(asURI)), OCLASResourceFactory.getInstance());
		assert PivotUtilInternal.isASURI(asURI);
		getContents().add(libraryModel);
	}

	private static class Contents extends AbstractContents
	{
		private final @NonNull Model model;
		private final @NonNull Library qvtruntimelibrary;
		private final @NonNull Package orphanage;

		private Contents(@NonNull String asURI)
		{
			model = createModel(asURI);
			qvtruntimelibrary = createLibrary("qvtruntimelibrary", "qvtrtlib", "http://www.eclipse.org/qvt/2019/QVTruntimeLibrary", null, QVTruntimeLibraryPackage.eINSTANCE);
			orphanage = createPackage("$$", "orphanage", "http://www.eclipse.org/ocl/2015/Orphanage", null, null);
			installPackages();
			installClassTypes();
			installCollectionTypes();
			installOperations();
			installTemplateBindings();
			installComments();
		}

		public @NonNull Model getModel() {
			return model;
		}

		private final @NonNull Package _ocl = getPackage(org.eclipse.ocl.pivot.model.OCLstdlib.getDefaultModel(), "ocl");
		private final @NonNull CollectionType _Collection = getCollectionType(_ocl, "Collection");
		private final @NonNull AnyType _OclAny = getAnyType(_ocl, "OclAny");
		private final @NonNull Class _OclElement = getClass(_ocl, "OclElement");
		private final @NonNull SetType _Set = getSetType(_ocl, "Set");
		private final @NonNull CollectionType _UniqueCollection = getCollectionType(_ocl, "UniqueCollection");
		private final @NonNull TemplateParameter _Collection_T = getTemplateParameter(_Collection, 0);
		private final @NonNull TemplateParameter _Set_T = getTemplateParameter(_Set, 0);
		private final @NonNull TemplateParameter _UniqueCollection_T = getTemplateParameter(_UniqueCollection, 0);

		private void installPackages() {
			model.getOwnedPackages().add(qvtruntimelibrary);
			model.getOwnedPackages().add(orphanage);
			model.getOwnedImports().add(createImport(null, _ocl));
		}

		private final @NonNull Class _Model = createClass("Model");
		private final @NonNull Class _Transformation = createClass("Transformation");

		private final @NonNull TemplateParameter tp_Model_objectsOfKind_TT = createTemplateParameter("TT");
		private final @NonNull TemplateParameter tp_Model_objectsOfType_TT = createTemplateParameter("TT");

		private final @NonNull CollectionType _Collection_OclElement = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Model_objectsOfKind_TT = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Model_objectsOfType_TT = createCollectionType(_Collection);
		private final @NonNull SetType _Set_OclElement_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Model_objectsOfKind_TT_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Model_objectsOfType_TT_NullFree = createSetType(_Set);
		private final @NonNull CollectionType _UniqueCollection_OclElement = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Model_objectsOfKind_TT = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Model_objectsOfType_TT = createCollectionType(_UniqueCollection);

		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;

			ownedClasses = qvtruntimelibrary.getOwnedClasses();
			ownedClasses.add(type = _Model);
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
			ownedClasses.add(type = _Collection_Model_objectsOfKind_TT);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Model_objectsOfType_TT);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Set_OclElement_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_OclElement);
			ownedClasses.add(type = _Set_Model_objectsOfKind_TT_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Model_objectsOfKind_TT);
			ownedClasses.add(type = _Set_Model_objectsOfType_TT_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Model_objectsOfType_TT);
			ownedClasses.add(type = _UniqueCollection_OclElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_OclElement);
			ownedClasses.add(type = _UniqueCollection_Model_objectsOfKind_TT);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Model_objectsOfKind_TT);
			ownedClasses.add(type = _UniqueCollection_Model_objectsOfType_TT);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Model_objectsOfType_TT);
		}

		private final @NonNull Operation op_Model_allObjects = createOperation("allObjects", _Set_OclElement_NullFree, "org.eclipse.qvtd.runtime.library.model.AllObjectsOperation", org.eclipse.qvtd.runtime.library.model.AllObjectsOperation.INSTANCE);
		private final @NonNull Operation op_Model_objectsOfKind = createOperation("objectsOfKind", _Set_Model_objectsOfKind_TT_NullFree, "org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation", org.eclipse.qvtd.runtime.library.model.ModelObjectsOfKindOperation.INSTANCE, tp_Model_objectsOfKind_TT);
		private final @NonNull Operation op_Model_objectsOfType = createOperation("objectsOfType", _Set_Model_objectsOfType_TT_NullFree, "org.eclipse.qvtd.runtime.library.model.ModelObjectsOfTypeOperation", org.eclipse.qvtd.runtime.library.model.ModelObjectsOfTypeOperation.INSTANCE, tp_Model_objectsOfType_TT);
		private final @NonNull Operation op_Model_rootObjects = createOperation("rootObjects", _Set_OclElement_NullFree, "org.eclipse.qvtd.runtime.library.model.RootObjectsOperation", org.eclipse.qvtd.runtime.library.model.RootObjectsOperation.INSTANCE);

		private void installOperations() {
			List<Operation> ownedOperations;
			List<Parameter> ownedParameters;
			Operation operation;
			Parameter parameter;

			ownedOperations = _Model.getOwnedOperations();
			ownedOperations.add(operation = op_Model_allObjects);
			ownedOperations.add(operation = op_Model_objectsOfKind);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("type", tp_Model_objectsOfKind_TT, true));
			parameter.setIsTypeof(true);
			ownedOperations.add(operation = op_Model_objectsOfType);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("type", tp_Model_objectsOfType_TT, true));
			parameter.setIsTypeof(true);
			ownedOperations.add(operation = op_Model_rootObjects);
		}

		private void installTemplateBindings() {
			addBinding(_Collection_Model_objectsOfKind_TT, tp_Model_objectsOfKind_TT);
			addBinding(_Collection_Model_objectsOfType_TT, tp_Model_objectsOfType_TT);
			addBinding(_Collection_OclElement, _OclElement);
			addBinding(_Set_Model_objectsOfKind_TT_NullFree, tp_Model_objectsOfKind_TT);
			addBinding(_Set_Model_objectsOfType_TT_NullFree, tp_Model_objectsOfType_TT);
			addBinding(_Set_OclElement_NullFree, _OclElement);
			addBinding(_UniqueCollection_Model_objectsOfKind_TT, tp_Model_objectsOfKind_TT);
			addBinding(_UniqueCollection_Model_objectsOfType_TT, tp_Model_objectsOfType_TT);
			addBinding(_UniqueCollection_OclElement, _OclElement);
		}

		private void installComments() {
		}
	}
}
