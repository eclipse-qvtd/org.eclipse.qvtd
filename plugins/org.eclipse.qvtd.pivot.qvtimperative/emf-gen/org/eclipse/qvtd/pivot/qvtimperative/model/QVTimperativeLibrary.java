/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.*;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;

/**
 * This is the http://www.eclipse.org/qvt/2015/QVTimperativeLibrary Standard Library
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
@SuppressWarnings({"nls", "unused"})
public class QVTimperativeLibrary extends ASResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Standard Library.
	 */
	private static QVTimperativeLibrary INSTANCE = null;
	
	/**
	 *	The URI of this Standard Library.
	 */
	public static final @NonNull String STDLIB_URI = "http://www.eclipse.org/qvt/2015/QVTimperativeLibrary";

	/**
	 * Return the default http://www.eclipse.org/qvt/2015/QVTimperativeLibrary standard Library Resource. 
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered.
	 * It cannot be unloaded or rather unloading has no effect.
	 */
	public static @NonNull QVTimperativeLibrary getDefault() {
		QVTimperativeLibrary oclstdlib = INSTANCE;
		if (oclstdlib == null) {
			Contents contents = new Contents("http://www.eclipse.org/qvt/2015/QVTbaseLibrary");
			oclstdlib = INSTANCE = new QVTimperativeLibrary(STDLIB_URI + PivotConstants.DOT_OCL_AS_FILE_EXTENSION, contents.getModel());
		}
		return oclstdlib;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2015/QVTimperativeLibrary standard Library model. 
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperativeLibrary.oclstdlib
	 *  is used as the default when no overriding copy is registered. 
	 */
	public static @NonNull Model getDefaultModel() {
		Model model = (Model)(getDefault().getContents().get(0));
		assert model != null;
		return model;
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}.
	 * This method may be invoked by standalone applications to replicate
	 * the registration that should appear as a standard_library plugin
	 * extension when running within Eclipse. 
	 */
	public static void install() {
		StandardLibraryContribution.REGISTRY.put(STDLIB_URI, new Loader());
	}

	/**
	 * Install this library in the {@link StandardLibraryContribution#REGISTRY}
	 * unless some other library contribution has already been installed.
	 */
	public static void lazyInstall() {
		if (StandardLibraryContribution.REGISTRY.get(STDLIB_URI) == null) {
			install();
		}
	}

	/**
	 * Unnstall this library from the {@link StandardLibraryContribution#REGISTRY}.
	 * This method may be invoked by standalone applications to release the library
	 * resources for garbage collection and memory leakage detection. 
	 */
	public static void uninstall() {
		StandardLibraryContribution.REGISTRY.remove(STDLIB_URI);
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

	/**
	 * Overridden to inhibit entry of the static shared instance in any ResourceSet.
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		if (this != INSTANCE) {
			return super.basicSetResourceSet(resourceSet, notifications);
		}
		else {
			return notifications;
		}
	}

	/**
	 * Overridden to inhibit unloading of the static shared instance.
	 */
	@Override
	protected void doUnload() {
		if (this != INSTANCE) {
			super.doUnload();
		}
	}

	/**
	 * Ensure xmi:ids are auto-generated before reference.
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		if (getEObjectToIDMap().isEmpty()) {
			new AS2XMIid().assignIds(this, null);
		}
		return super.getEObject(uriFragment);
	}

	/**
	 * Overridden to trivialise loading of the static shared instance.
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
	 * Overridden to inhibit unloading of the static shared instance.
	 */
	@Override
	protected Notification setLoaded(boolean isLoaded) {
		if (isLoaded || (this != INSTANCE)) {
			return super.setLoaded(isLoaded);
		}
		else {
			return null;
		}
	}

	private static class Contents extends AbstractContents
	{
		private final @NonNull Model model;
		private final @NonNull Library qvtbaselibrary;
		private final @NonNull Package orphanage;

		private Contents(@NonNull String asURI)
		{
			model = createModel(asURI);
			qvtbaselibrary = createLibrary("qvtbaselibrary", "qvtbaselib", "http://www.eclipse.org/qvt/2015/QVTbaseLibrary", null);
			orphanage = createPackage("$$", "orphanage", "http://www.eclipse.org/ocl/2015/Orphanage", null);
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
			model.getOwnedPackages().add(qvtbaselibrary);
			model.getOwnedPackages().add(orphanage);
			model.getOwnedImports().add(createImport(null, _ocl));
		}
		
		private final @NonNull Class _Model = createClass("Model");
		private final @NonNull Class _Transformation = createClass("Transformation");
		
		private final @NonNull TemplateParameter tp_Model_objectsOfKind_TT = createTemplateParameter("TT");
		private final @NonNull TemplateParameter tp_Model_objectsOfType_TT = createTemplateParameter("TT");
		
		private final @NonNull CollectionType _Collection_OclElement = createCollectionType(_Collection, _OclElement);
		private final @NonNull CollectionType _Collection_Model_objectsOfKind_TT = createCollectionType(_Collection, tp_Model_objectsOfKind_TT);
		private final @NonNull CollectionType _Collection_Model_objectsOfType_TT = createCollectionType(_Collection, tp_Model_objectsOfType_TT);
		private final @NonNull SetType _Set_OclElement = createSetType(_Set, _OclElement);
		private final @NonNull SetType _Set_Model_objectsOfKind_TT = createSetType(_Set, tp_Model_objectsOfKind_TT);
		private final @NonNull SetType _Set_Model_objectsOfType_TT = createSetType(_Set, tp_Model_objectsOfType_TT);
		private final @NonNull CollectionType _UniqueCollection_OclElement = createCollectionType(_UniqueCollection, _OclElement);
		private final @NonNull CollectionType _UniqueCollection_Model_objectsOfKind_TT = createCollectionType(_UniqueCollection, tp_Model_objectsOfKind_TT);
		private final @NonNull CollectionType _UniqueCollection_Model_objectsOfType_TT = createCollectionType(_UniqueCollection, tp_Model_objectsOfType_TT);
		
		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;
		
			ownedClasses = qvtbaselibrary.getOwnedClasses();
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
			ownedClasses.add(type = _Set_OclElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_OclElement);
			ownedClasses.add(type = _Set_Model_objectsOfKind_TT);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Model_objectsOfKind_TT);
			ownedClasses.add(type = _Set_Model_objectsOfType_TT);
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
		
		private final @NonNull Operation op_Model_allObjects = createOperation("allObjects", _Set_OclElement, "org.eclipse.qvtd.pivot.qvtimperative.library.model.AllObjectsOperation", org.eclipse.qvtd.pivot.qvtimperative.library.model.AllObjectsOperation.INSTANCE);
		private final @NonNull Operation op_Model_objectsOfKind = createOperation("objectsOfKind", _Set_Model_objectsOfKind_TT, "org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfKindOperation", org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfKindOperation.INSTANCE, tp_Model_objectsOfKind_TT);
		private final @NonNull Operation op_Model_objectsOfType = createOperation("objectsOfType", _Set_Model_objectsOfType_TT, "org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfTypeOperation", org.eclipse.qvtd.pivot.qvtimperative.library.model.ModelObjectsOfTypeOperation.INSTANCE, tp_Model_objectsOfType_TT);
		private final @NonNull Operation op_Model_rootObjects = createOperation("rootObjects", _Set_OclElement, "org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation", org.eclipse.qvtd.pivot.qvtimperative.library.model.RootObjectsOperation.INSTANCE);
		
		private void installOperations() {
			List<Operation> ownedOperations;
			List<Parameter> ownedParameters;
			Operation operation;
			Parameter parameter;
		
			ownedOperations = _Model.getOwnedOperations();
			ownedOperations.add(operation = op_Model_allObjects);
			ownedOperations.add(operation = op_Model_objectsOfKind);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("type", tp_Model_objectsOfKind_TT, false));
			parameter.setIsTypeof(true);
			ownedOperations.add(operation = op_Model_objectsOfType);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("type", tp_Model_objectsOfType_TT, false));
			parameter.setIsTypeof(true);
			ownedOperations.add(operation = op_Model_rootObjects);
		}
		
		private void installTemplateBindings() {
			_Collection_Model_objectsOfKind_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, tp_Model_objectsOfKind_TT)));
			_Collection_Model_objectsOfType_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, tp_Model_objectsOfType_TT)));
			_Collection_OclElement.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _OclElement)));
			_Set_Model_objectsOfKind_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, tp_Model_objectsOfKind_TT)));
			_Set_Model_objectsOfType_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, tp_Model_objectsOfType_TT)));
			_Set_OclElement.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _OclElement)));
			_UniqueCollection_Model_objectsOfKind_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, tp_Model_objectsOfKind_TT)));
			_UniqueCollection_Model_objectsOfType_TT.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, tp_Model_objectsOfType_TT)));
			_UniqueCollection_OclElement.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _OclElement)));
		}
		
		private void installComments() {
		}
	}
}
