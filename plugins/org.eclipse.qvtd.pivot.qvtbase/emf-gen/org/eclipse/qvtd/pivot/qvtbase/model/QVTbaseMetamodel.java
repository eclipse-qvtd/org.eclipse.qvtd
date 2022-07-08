/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 *******************************************************************************
 * This code is 100% auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * by: org.eclipse.ocl.examples.build.xtend.GenerateOCLmetamodel.xtend
 * and: org.eclipse.ocl.examples.build.GeneratePivotMetamodel.mwe2
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.BagType;
import org.eclipse.ocl.pivot.BooleanType;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Enumeration;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OrderedSetType;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.SequenceType;
import org.eclipse.ocl.pivot.SetType;
import org.eclipse.ocl.pivot.TemplateParameter;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.library.StandardLibraryContribution;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.PivotConstants;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

/**
 * This is the pivot representation of the http://www.eclipse.org/qvt/2015/QVTbase metamodel
 * auto-generated from /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore.
 * It facilitates efficient model loading without the overheads of model reading.
 */
@SuppressWarnings("unused")
public class QVTbaseMetamodel extends ASResourceImpl
{
	/**
	 *	The static package-of-types pivot model of the Pivot Metamodel.
	 */
	private static QVTbaseMetamodel INSTANCE = null;

	/**
	 *	The URI of this Metamodel.
	 */
	public static final @NonNull String PIVOT_URI = "http://www.eclipse.org/qvt/2015/QVTbase";

	/**
	 *	The URI of the AS representation of this Metamodel.
	 */
	public static final @NonNull URI PIVOT_AS_URI = URI.createURI("http://www.eclipse.org/qvt/2015/QVTbase" + PivotConstants.DOT_OCL_AS_FILE_EXTENSION);

	public static @NonNull Package create(@NonNull StandardLibraryInternal standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
		QVTbaseMetamodel resource = new ReadOnly(PIVOT_AS_URI);
		Package standardLibraryPackage = standardLibrary.getOclAnyType().getOwningPackage();
		assert standardLibraryPackage != null;
		Contents contents = new Contents(standardLibraryPackage, name, nsPrefix, nsURI);
		Model model = contents.getModel();
		resource.getContents().add(model);
		@SuppressWarnings("null")@NonNull Package pkge = model.getOwnedPackages().get(0);
		return pkge;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2015/QVTbase metamodel Resource using the default OCL Standard Library.
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
	 *  is used as the default when no overriding copy is registered.
	 */
	public static @NonNull QVTbaseMetamodel getDefault() {
		QVTbaseMetamodel metamodel = INSTANCE;
		if (metamodel == null) {
			metamodel = INSTANCE = new ReadOnly(PIVOT_AS_URI);
			Contents contents = new Contents(OCLstdlib.getDefaultPackage(), "qvtbase", "qvtb", PIVOT_URI);
			metamodel.getContents().add(contents.getModel());
			metamodel.setSaveable(false);
		}
		return metamodel;
	}

	/**
	 * Return the default http://www.eclipse.org/qvt/2015/QVTbase metamodel Model using the default OCL Standard Library.
	 *  This static definition auto-generated from /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
	 *  is used as the default when no overriding copy is registered.
	 */
	public static @NonNull Model getDefaultModel() {
		Model model = (Model)(getDefault().getContents().get(0));
		assert model != null;
		return model;
	}

	/**
	 * Install this metamodel in the {@link OCLASResourceFactory#REGISTRY}.
	 * This method may be invoked by standalone applications to replicate
	 * the registration that should appear as a standard_library plugin
	 * extension when running within Eclipse.
	 */
	public static void install() {
		Loader contribution = new Loader();
		OCLASResourceFactory.REGISTRY.put(PIVOT_AS_URI, contribution);
	}

	/**
	 * Install this metamodel in the {@link OCLASResourceFactory#REGISTRY}
	 * unless some other metamodel contribution has already been installed.
	 */
	public static void lazyInstall() {
		if (OCLASResourceFactory.REGISTRY.get(PIVOT_AS_URI) == null) {
			install();
		}
	}

	/**
	 * Uninstall this metamodel from the {@link OCLASResourceFactory#REGISTRY}.
	 * This method may be invoked by standalone applications to release the library
	 * resources for garbage collection and memory leakage detection.
	 */
	public static void uninstall() {
		OCLASResourceFactory.REGISTRY.remove(PIVOT_AS_URI);
		INSTANCE = null;
	}

	protected QVTbaseMetamodel(@NonNull URI uri) {
		super(uri, OCLASResourceFactory.getInstance());
	}

	protected static class LibraryContents extends AbstractContents
	{
		protected final @NonNull Package standardLibrary;

		protected LibraryContents(@NonNull Package standardLibrary) {
			this.standardLibrary = standardLibrary;
		}
	}

	/**
	 * The Loader shares the metamodel instance whenever this default metamodel
	 * is loaded from the registry of known pivot metamodels.
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
	 * A ReadOnly QVTbaseMetamodel overrides inherited functionality to impose immutable shared behaviour.
	 */
	protected static class ReadOnly extends QVTbaseMetamodel implements ImmutableResource
	{
		protected ReadOnly(@NonNull URI uri) {
			super(uri);
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
			return PIVOT_URI.equals(metamodelURI);
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

	private static class Contents extends LibraryContents
	{
		private final @NonNull Model root;
		private final @NonNull Package pivot;
		private final @NonNull Package qvtbase;
		private final @NonNull Package orphanage;

		protected Contents(@NonNull Package standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
			super(standardLibrary);
			root = createModel("http://www.eclipse.org/qvt/2015/QVTbase");
			pivot = createPackage("pivot", "pivot", "http://www.eclipse.org/ocl/2015/Pivot", IdManager.METAMODEL, PivotPackage.eINSTANCE);
			qvtbase = createPackage("qvtbase", "qvtb", "http://www.eclipse.org/qvt/2015/QVTbase", null, QVTbasePackage.eINSTANCE);
			orphanage = createPackage("$$", "orphanage", "http://www.eclipse.org/ocl/2015/Orphanage", null, null);
			installPackages();
			installClassTypes();
			installEnumerations();
			installCollectionTypes();
			installOperations();
			installProperties();
			installTemplateBindings();
			installComments();
		}

		public @NonNull Model getModel() {
			return root;
		}

		private final @NonNull Package _ocl = standardLibrary;
		private final @NonNull Package _pivot = getPackage(org.eclipse.ocl.pivot.model.OCLmetamodel.getDefaultModel(), "pivot");
		private final @NonNull Class _Annotation = getClass(_pivot, "Annotation");
		private final @NonNull BagType _Bag = getBagType(_ocl, "Bag");
		private final @NonNull Class _Boolean = getBooleanType(_ocl, "Boolean");
		private final @NonNull CollectionType _Collection = getCollectionType(_ocl, "Collection");
		private final @NonNull Class _Integer = getPrimitiveType(_ocl, "Integer");
		private final @NonNull AnyType _OclAny = getAnyType(_ocl, "OclAny");
		private final @NonNull Class _OclElement = getClass(_ocl, "OclElement");
		private final @NonNull Class _OclEnumeration = getClass(_ocl, "OclEnumeration");
		private final @NonNull CollectionType _OrderedCollection = getCollectionType(_ocl, "OrderedCollection");
		private final @NonNull OrderedSetType _OrderedSet = getOrderedSetType(_ocl, "OrderedSet");
		private final @NonNull Class _Package = getClass(_pivot, "Package");
		private final @NonNull Class _Real = getPrimitiveType(_ocl, "Real");
		private final @NonNull SetType _Set = getSetType(_ocl, "Set");
		private final @NonNull Class _String = getPrimitiveType(_ocl, "String");
		private final @NonNull CollectionType _UniqueCollection = getCollectionType(_ocl, "UniqueCollection");
		private final @NonNull Class _UnlimitedNatural = getPrimitiveType(_ocl, "UnlimitedNatural");
		private final @NonNull Class _Variable = getClass(_pivot, "Variable");
		private final @NonNull TemplateParameter _Bag_T = getTemplateParameter(_Bag, 0);
		private final @NonNull TemplateParameter _Collection_T = getTemplateParameter(_Collection, 0);
		private final @NonNull TemplateParameter _OrderedCollection_T = getTemplateParameter(_OrderedCollection, 0);
		private final @NonNull TemplateParameter _OrderedSet_T = getTemplateParameter(_OrderedSet, 0);
		private final @NonNull TemplateParameter _Set_T = getTemplateParameter(_Set, 0);
		private final @NonNull TemplateParameter _UniqueCollection_T = getTemplateParameter(_UniqueCollection, 0);

		private void installPackages() {
			root.getOwnedPackages().add(pivot);
			root.getOwnedPackages().add(qvtbase);
			root.getOwnedPackages().add(orphanage);
			root.getOwnedImports().add(createImport(null, _ocl));
		}

		private final @NonNull Class _Annotation_1 = createClass("Annotation");
		private final @NonNull Class _OCLExpression = createClass("OCLExpression");
		private final @NonNull Class _Package_1 = createClass("Package");
		private final @NonNull Class _Parameter = createClass("Parameter");
		private final @NonNull Class _ParameterVariable = createClass("ParameterVariable");
		private final @NonNull Class _Variable_1 = createClass("Variable");

		private final @NonNull Class _BaseModel = createClass(QVTbasePackage.Literals.BASE_MODEL);
		private final @NonNull Class _CompoundTargetElement = createClass(QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT);
		private final @NonNull Class _Domain = createClass(QVTbasePackage.Literals.DOMAIN);
		private final @NonNull Class _Function = createClass(QVTbasePackage.Literals.FUNCTION);
		private final @NonNull Class _FunctionBody = createClass(QVTbasePackage.Literals.FUNCTION_BODY);
		private final @NonNull Class _FunctionParameter = createClass(QVTbasePackage.Literals.FUNCTION_PARAMETER);
		private final @NonNull Class _Pattern = createClass(QVTbasePackage.Literals.PATTERN);
		private final @NonNull Class _Predicate = createClass(QVTbasePackage.Literals.PREDICATE);
		private final @NonNull Class _Rule = createClass(QVTbasePackage.Literals.RULE);
		private final @NonNull Class _SimpleTargetElement = createClass(QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT);
		private final @NonNull Class _Target = createClass(QVTbasePackage.Literals.TARGET);
		private final @NonNull Class _TargetElement = createClass(QVTbasePackage.Literals.TARGET_ELEMENT);
		private final @NonNull Class _Transformation = createClass(QVTbasePackage.Literals.TRANSFORMATION);
		private final @NonNull Class _TypedModel = createClass(QVTbasePackage.Literals.TYPED_MODEL);

		private final @NonNull Enumeration _TargetElementKind = createEnumeration(QVTbasePackage.Literals.TARGET_ELEMENT_KIND);
		private final @NonNull EnumerationLiteral el__TargetElementKind_INPUT = createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("INPUT"));
		private final @NonNull EnumerationLiteral el__TargetElementKind_VIA = createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("VIA"));
		private final @NonNull EnumerationLiteral el__TargetElementKind_OUTPUT = createEnumerationLiteral(QVTbasePackage.Literals.TARGET_ELEMENT_KIND.getEEnumLiteral("OUTPUT"));

		private final @NonNull BagType _Bag_Domain = createBagType(_Bag);
		private final @NonNull BagType _Bag_Function = createBagType(_Bag);
		private final @NonNull BagType _Bag_Pattern = createBagType(_Bag);
		private final @NonNull BagType _Bag_SimpleTargetElement = createBagType(_Bag);
		private final @NonNull BagType _Bag_TypedModel = createBagType(_Bag);
		private final @NonNull CollectionType _Collection_Annotation = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Domain = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Function = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Package = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Pattern = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Predicate = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Rule = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_SimpleTargetElement = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Target = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_TargetElement = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_TypedModel = createCollectionType(_Collection);
		private final @NonNull CollectionType _Collection_Variable = createCollectionType(_Collection);
		private final @NonNull CollectionType _OrderedCollection_Domain = createCollectionType(_OrderedCollection);
		private final @NonNull CollectionType _OrderedCollection_Rule = createCollectionType(_OrderedCollection);
		private final @NonNull CollectionType _OrderedCollection_SimpleTargetElement = createCollectionType(_OrderedCollection);
		private final @NonNull CollectionType _OrderedCollection_TypedModel = createCollectionType(_OrderedCollection);
		private final @NonNull OrderedSetType _OrderedSet_Domain_NullFree = createOrderedSetType(_OrderedSet);
		private final @NonNull OrderedSetType _OrderedSet_Rule_NullFree = createOrderedSetType(_OrderedSet);
		private final @NonNull OrderedSetType _OrderedSet_SimpleTargetElement_NullFree = createOrderedSetType(_OrderedSet);
		private final @NonNull OrderedSetType _OrderedSet_TypedModel_NullFree = createOrderedSetType(_OrderedSet);
		private final @NonNull SetType _Set_Annotation_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Package_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Predicate_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Rule_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Target_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_TargetElement_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_TypedModel_NullFree = createSetType(_Set);
		private final @NonNull SetType _Set_Variable_NullFree = createSetType(_Set);
		private final @NonNull CollectionType _UniqueCollection_Annotation = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Domain = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Package = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Predicate = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Rule = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_SimpleTargetElement = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Target = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_TargetElement = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_TypedModel = createCollectionType(_UniqueCollection);
		private final @NonNull CollectionType _UniqueCollection_Variable = createCollectionType(_UniqueCollection);

		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;

			ownedClasses = pivot.getOwnedClasses();
			ownedClasses.add(type = _Annotation_1);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _OCLExpression);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Package_1);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Parameter);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _ParameterVariable);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Variable_1);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);

			ownedClasses = qvtbase.getOwnedClasses();
			ownedClasses.add(type = _BaseModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _CompoundTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_TargetElement);
			ownedClasses.add(type = _Domain);
			type.setIsAbstract(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Function);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _FunctionBody);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _FunctionParameter);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Pattern);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Predicate);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Rule);
			type.setIsAbstract(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _SimpleTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_TargetElement);
			ownedClasses.add(type = _Target);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _TargetElement);
			type.setIsAbstract(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Transformation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		}

		private void installEnumerations() {
			List<Class> ownedClasses;
			Enumeration type;
			List<EnumerationLiteral> enumerationLiterals;

			ownedClasses = qvtbase.getOwnedClasses();
			ownedClasses.add(type = _TargetElementKind);
			enumerationLiterals = type.getOwnedLiterals();
			enumerationLiterals.add(el__TargetElementKind_INPUT);
			enumerationLiterals.add(el__TargetElementKind_VIA);
			enumerationLiterals.add(el__TargetElementKind_OUTPUT);
			type.getSuperClasses().add(_OclEnumeration);
		}

		private void installCollectionTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			CollectionType type;

			ownedClasses = orphanage.getOwnedClasses();
			ownedClasses.add(type = _Bag_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Domain);
			ownedClasses.add(type = _Bag_Function);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Function);
			ownedClasses.add(type = _Bag_Pattern);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Pattern);
			ownedClasses.add(type = _Bag_SimpleTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_SimpleTargetElement);
			ownedClasses.add(type = _Bag_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _Collection_Annotation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Function);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Package);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Pattern);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Predicate);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Rule);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_SimpleTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Target);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_TargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Variable);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _OrderedCollection_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Domain);
			ownedClasses.add(type = _OrderedCollection_Rule);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Rule);
			ownedClasses.add(type = _OrderedCollection_SimpleTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_SimpleTargetElement);
			ownedClasses.add(type = _OrderedCollection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _OrderedSet_Domain_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_Domain);
			superClasses.add(_UniqueCollection_Domain);
			ownedClasses.add(type = _OrderedSet_Rule_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_Rule);
			superClasses.add(_UniqueCollection_Rule);
			ownedClasses.add(type = _OrderedSet_SimpleTargetElement_NullFree);
			type.setLower(2);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_SimpleTargetElement);
			superClasses.add(_UniqueCollection_SimpleTargetElement);
			ownedClasses.add(type = _OrderedSet_TypedModel_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_TypedModel);
			superClasses.add(_UniqueCollection_TypedModel);
			ownedClasses.add(type = _Set_Annotation_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Annotation);
			ownedClasses.add(type = _Set_Package_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Package);
			ownedClasses.add(type = _Set_Predicate_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Predicate);
			ownedClasses.add(type = _Set_Rule_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Rule);
			ownedClasses.add(type = _Set_Target_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Target);
			ownedClasses.add(type = _Set_TargetElement_NullFree);
			type.setLower(2);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_TargetElement);
			ownedClasses.add(type = _Set_TypedModel_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_TypedModel);
			ownedClasses.add(type = _Set_Variable_NullFree);
			type.setIsNullFree(true);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Variable);
			ownedClasses.add(type = _UniqueCollection_Annotation);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Annotation);
			ownedClasses.add(type = _UniqueCollection_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Domain);
			ownedClasses.add(type = _UniqueCollection_Package);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Package);
			ownedClasses.add(type = _UniqueCollection_Predicate);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Predicate);
			ownedClasses.add(type = _UniqueCollection_Rule);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Rule);
			ownedClasses.add(type = _UniqueCollection_SimpleTargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_SimpleTargetElement);
			ownedClasses.add(type = _UniqueCollection_Target);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Target);
			ownedClasses.add(type = _UniqueCollection_TargetElement);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TargetElement);
			ownedClasses.add(type = _UniqueCollection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _UniqueCollection_Variable);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Variable);
		}

		private final @NonNull Operation op_Transformation_getFunction = createOperation(QVTbasePackage.Literals.TRANSFORMATION___GET_FUNCTION__STRING, _Function, null, null);
		private final @NonNull Operation op_Transformation_getModelParameter = createOperation(QVTbasePackage.Literals.TRANSFORMATION___GET_MODEL_PARAMETER__STRING, _TypedModel, null, null);

		private void installOperations() {
			List<Operation> ownedOperations;
			List<Parameter> ownedParameters;
			Operation operation;
			Parameter parameter;

			ownedOperations = _Transformation.getOwnedOperations();
			ownedOperations.add(operation = op_Transformation_getFunction);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("name", _String, true));
			ownedOperations.add(operation = op_Transformation_getModelParameter);
			ownedParameters = operation.getOwnedParameters();
			ownedParameters.add(parameter = createParameter("name", _String, true));
		}


		private final @NonNull Property pr_Annotation_Transformation_ownedTag = createProperty("Transformation", _Transformation);
		private final @NonNull Property pr_OCLExpression_Function_queryExpression = createProperty("Function", _Bag_Function);
		private final @NonNull Property pr_OCLExpression_predicate_conditionExpression = createProperty("predicate", _Predicate);
		private final @NonNull Property pr_Package_TypedModel_usedPackage = createProperty("TypedModel", _Bag_TypedModel);
		private final @NonNull Property pr_Parameter_Transformation_ownedContext = createProperty("Transformation", _Transformation);
		private final @NonNull Property pr_Parameter_TypedModel_ownedContext = createProperty("TypedModel", _TypedModel);
		private final @NonNull Property pr_ParameterVariable_Rule_ownedContext = createProperty("Rule", _Rule);
		private final @NonNull Property pr_Variable_Pattern_bindsTo = createProperty("Pattern", _Bag_Pattern);

		private final @NonNull Property pr_CompoundTargetElement_ownedTargetElements = createProperty(QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT__OWNED_TARGET_ELEMENTS, _OrderedSet_SimpleTargetElement_NullFree);
		private final @NonNull Property pr_Domain_isCheckable = createProperty(QVTbasePackage.Literals.DOMAIN__IS_CHECKABLE, _Boolean);
		private final @NonNull Property pr_Domain_isEnforceable = createProperty(QVTbasePackage.Literals.DOMAIN__IS_ENFORCEABLE, _Boolean);
		private final @NonNull Property pr_Domain_rule = createProperty(QVTbasePackage.Literals.DOMAIN__RULE, _Rule);
		private final @NonNull Property pr_Domain_typedModel = createProperty(QVTbasePackage.Literals.DOMAIN__TYPED_MODEL, _TypedModel);
		private final @NonNull Property pr_Function_queryExpression = createProperty(QVTbasePackage.Literals.FUNCTION__QUERY_EXPRESSION, _OCLExpression);
		private final @NonNull Property pr_Pattern_bindsTo = createProperty(QVTbasePackage.Literals.PATTERN__BINDS_TO, _Set_Variable_NullFree);
		private final @NonNull Property pr_Pattern_predicate = createProperty(QVTbasePackage.Literals.PATTERN__PREDICATE, _Set_Predicate_NullFree);
		private final @NonNull Property pr_Predicate_conditionExpression = createProperty(QVTbasePackage.Literals.PREDICATE__CONDITION_EXPRESSION, _OCLExpression);
		private final @NonNull Property pr_Predicate_pattern = createProperty(QVTbasePackage.Literals.PREDICATE__PATTERN, _Pattern);
		private final @NonNull Property pr_Rule_domain = createProperty(QVTbasePackage.Literals.RULE__DOMAIN, _OrderedSet_Domain_NullFree);
		private final @NonNull Property pr_Rule_isAbstract = createProperty(QVTbasePackage.Literals.RULE__IS_ABSTRACT, _Boolean);
		private final @NonNull Property pr_Rule_overridden = createProperty(QVTbasePackage.Literals.RULE__OVERRIDDEN, _Rule);
		private final @NonNull Property pr_Rule_overrides = createProperty(QVTbasePackage.Literals.RULE__OVERRIDES, _OrderedSet_Rule_NullFree);
		private final @NonNull Property pr_Rule_ownedContext = createProperty(QVTbasePackage.Literals.RULE__OWNED_CONTEXT, _ParameterVariable);
		private final @NonNull Property pr_Rule_transformation = createProperty(QVTbasePackage.Literals.RULE__TRANSFORMATION, _Transformation);
		private final @NonNull Property pr_SimpleTargetElement_iterates = createProperty(QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__ITERATES, _Set_TypedModel_NullFree);
		private final @NonNull Property pr_SimpleTargetElement_kind = createProperty(QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__KIND, _TargetElementKind);
		private final @NonNull Property pr_SimpleTargetElement_typedModel = createProperty(QVTbasePackage.Literals.SIMPLE_TARGET_ELEMENT__TYPED_MODEL, _TypedModel);
		private final @NonNull Property pr_SimpleTargetElement_CompoundTargetElement_ownedTargetElements = createProperty("CompoundTargetElement", _CompoundTargetElement);
		private final @NonNull Property pr_Target_ownedTargetElements = createProperty(QVTbasePackage.Literals.TARGET__OWNED_TARGET_ELEMENTS, _Set_TargetElement_NullFree);
		private final @NonNull Property pr_Target_owningTransformation = createProperty(QVTbasePackage.Literals.TARGET__OWNING_TRANSFORMATION, _Transformation);
		private final @NonNull Property pr_TargetElement_Target_ownedTargetElements = createProperty("Target", _Target);
		private final @NonNull Property pr_Transformation_extends = createProperty(QVTbasePackage.Literals.TRANSFORMATION__EXTENDS, _Transformation);
		private final @NonNull Property pr_Transformation_modelParameter = createProperty(QVTbasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER, _OrderedSet_TypedModel_NullFree);
		private final @NonNull Property pr_Transformation_ownedContext = createProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT, _Parameter);
		private final @NonNull Property pr_Transformation_ownedTag = createProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_TAG, _Set_Annotation_NullFree);
		private final @NonNull Property pr_Transformation_ownedTargets = createProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_TARGETS, _Set_Target_NullFree);
		private final @NonNull Property pr_Transformation_rule = createProperty(QVTbasePackage.Literals.TRANSFORMATION__RULE, _Set_Rule_NullFree);
		private final @NonNull Property pr_Transformation_extendedBy_extends = createProperty("extendedBy", _Transformation);
		private final @NonNull Property pr_TypedModel_dependsOn = createProperty(QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON, _Set_TypedModel_NullFree);
		private final @NonNull Property pr_TypedModel_isPrimitive = createProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_PRIMITIVE, _Boolean);
		private final @NonNull Property pr_TypedModel_isThis = createProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_THIS, _Boolean);
		private final @NonNull Property pr_TypedModel_isTrace = createProperty(QVTbasePackage.Literals.TYPED_MODEL__IS_TRACE, _Boolean);
		private final @NonNull Property pr_TypedModel_iterates = createProperty(QVTbasePackage.Literals.TYPED_MODEL__ITERATES, _Set_TypedModel_NullFree);
		private final @NonNull Property pr_TypedModel_ownedContext = createProperty(QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT, _Parameter);
		private final @NonNull Property pr_TypedModel_transformation = createProperty(QVTbasePackage.Literals.TYPED_MODEL__TRANSFORMATION, _Transformation);
		private final @NonNull Property pr_TypedModel_usedPackage = createProperty(QVTbasePackage.Literals.TYPED_MODEL__USED_PACKAGE, _Set_Package_NullFree);
		private final @NonNull Property pr_TypedModel_Domain_typedModel = createProperty("Domain", _Bag_Domain);
		private final @NonNull Property pr_TypedModel_SimpleTargetElement_iterates = createProperty("SimpleTargetElement", _Bag_SimpleTargetElement);
		private final @NonNull Property pr_TypedModel_SimpleTargetElement_typedModel = createProperty("SimpleTargetElement", _Bag_SimpleTargetElement);
		private final @NonNull Property pr_TypedModel_TypedModel_iterates = createProperty("TypedModel", _Bag_TypedModel);
		private final @NonNull Property pr_TypedModel_dependent_dependsOn = createProperty("dependent", _TypedModel);

		private void installProperties() {
			List<Property> ownedProperties;
			Property property;

			ownedProperties = _Annotation_1.getOwnedProperties();
			ownedProperties.add(property = pr_Annotation_Transformation_ownedTag);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_ownedTag);

			ownedProperties = _OCLExpression.getOwnedProperties();
			ownedProperties.add(property = pr_OCLExpression_Function_queryExpression);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Function_queryExpression);
			ownedProperties.add(property = pr_OCLExpression_predicate_conditionExpression);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Predicate_conditionExpression);

			ownedProperties = _Package_1.getOwnedProperties();
			ownedProperties.add(property = pr_Package_TypedModel_usedPackage);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_usedPackage);

			ownedProperties = _Parameter.getOwnedProperties();
			ownedProperties.add(property = pr_Parameter_Transformation_ownedContext);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_ownedContext);
			ownedProperties.add(property = pr_Parameter_TypedModel_ownedContext);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_ownedContext);

			ownedProperties = _ParameterVariable.getOwnedProperties();
			ownedProperties.add(property = pr_ParameterVariable_Rule_ownedContext);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_ownedContext);

			ownedProperties = _Variable_1.getOwnedProperties();
			ownedProperties.add(property = pr_Variable_Pattern_bindsTo);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Pattern_bindsTo);

			ownedProperties = _CompoundTargetElement.getOwnedProperties();
			ownedProperties.add(property = pr_CompoundTargetElement_ownedTargetElements);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_SimpleTargetElement_CompoundTargetElement_ownedTargetElements);

			ownedProperties = _Domain.getOwnedProperties();
			ownedProperties.add(property = pr_Domain_isCheckable);
			property.setIsResolveProxies(true);
			property.setIsUnsettable(true);
			ownedProperties.add(property = pr_Domain_isEnforceable);
			property.setIsResolveProxies(true);
			property.setIsUnsettable(true);
			ownedProperties.add(property = pr_Domain_rule);
			property.setIsResolveProxies(true);
			property.setIsTransient(true);
			property.setOpposite(pr_Rule_domain);
			ownedProperties.add(property = pr_Domain_typedModel);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_Domain_typedModel);

			ownedProperties = _Function.getOwnedProperties();
			ownedProperties.add(property = pr_Function_queryExpression);
			property.setIsDerived(true);
			property.setIsRequired(false);
			property.setIsTransient(true);
			property.setIsVolatile(true);
			property.setOpposite(pr_OCLExpression_Function_queryExpression);

			ownedProperties = _Pattern.getOwnedProperties();
			ownedProperties.add(property = pr_Pattern_bindsTo);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Variable_Pattern_bindsTo);
			ownedProperties.add(property = pr_Pattern_predicate);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Predicate_pattern);

			ownedProperties = _Predicate.getOwnedProperties();
			ownedProperties.add(property = pr_Predicate_conditionExpression);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_OCLExpression_predicate_conditionExpression);
			ownedProperties.add(property = pr_Predicate_pattern);
			property.setIsResolveProxies(true);
			property.setIsTransient(true);
			property.setOpposite(pr_Pattern_predicate);

			ownedProperties = _Rule.getOwnedProperties();
			ownedProperties.add(property = pr_Rule_domain);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Domain_rule);
			ownedProperties.add(property = pr_Rule_isAbstract);
			property.setIsResolveProxies(true);
			property.setDefaultValueString("false");
			ownedProperties.add(property = pr_Rule_overridden);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_overrides);
			ownedProperties.add(property = pr_Rule_overrides);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_overridden);
			ownedProperties.add(property = pr_Rule_ownedContext);
			property.setIsComposite(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_ParameterVariable_Rule_ownedContext);
			ownedProperties.add(property = pr_Rule_transformation);
			property.setIsRequired(false);
			property.setIsTransient(true);
			property.setOpposite(pr_Transformation_rule);

			ownedProperties = _SimpleTargetElement.getOwnedProperties();
			ownedProperties.add(property = pr_SimpleTargetElement_iterates);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_SimpleTargetElement_iterates);
			ownedProperties.add(property = pr_SimpleTargetElement_kind);
			property.setIsResolveProxies(true);
			ownedProperties.add(property = pr_SimpleTargetElement_typedModel);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_SimpleTargetElement_typedModel);
			ownedProperties.add(property = pr_SimpleTargetElement_CompoundTargetElement_ownedTargetElements);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_CompoundTargetElement_ownedTargetElements);

			ownedProperties = _Target.getOwnedProperties();
			ownedProperties.add(property = pr_Target_ownedTargetElements);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TargetElement_Target_ownedTargetElements);
			ownedProperties.add(property = pr_Target_owningTransformation);
			property.setIsResolveProxies(true);
			property.setIsTransient(true);
			property.setOpposite(pr_Transformation_ownedTargets);

			ownedProperties = _TargetElement.getOwnedProperties();
			ownedProperties.add(property = pr_TargetElement_Target_ownedTargetElements);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Target_ownedTargetElements);

			ownedProperties = _Transformation.getOwnedProperties();
			ownedProperties.add(property = pr_Transformation_extends);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_extendedBy_extends);
			ownedProperties.add(property = pr_Transformation_modelParameter);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_transformation);
			ownedProperties.add(property = pr_Transformation_ownedContext);
			property.setIsComposite(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Parameter_Transformation_ownedContext);
			ownedProperties.add(property = pr_Transformation_ownedTag);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Annotation_Transformation_ownedTag);
			ownedProperties.add(property = pr_Transformation_ownedTargets);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Target_owningTransformation);
			ownedProperties.add(property = pr_Transformation_rule);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_transformation);
			ownedProperties.add(property = pr_Transformation_extendedBy_extends);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_extends);

			ownedProperties = _TypedModel.getOwnedProperties();
			ownedProperties.add(property = pr_TypedModel_dependsOn);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_dependent_dependsOn);
			ownedProperties.add(property = pr_TypedModel_isPrimitive);
			property.setIsResolveProxies(true);
			property.setDefaultValueString("false");
			ownedProperties.add(property = pr_TypedModel_isThis);
			property.setIsResolveProxies(true);
			property.setDefaultValueString("false");
			ownedProperties.add(property = pr_TypedModel_isTrace);
			property.setIsResolveProxies(true);
			property.setDefaultValueString("false");
			ownedProperties.add(property = pr_TypedModel_iterates);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_TypedModel_iterates);
			ownedProperties.add(property = pr_TypedModel_ownedContext);
			property.setIsComposite(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Parameter_TypedModel_ownedContext);
			ownedProperties.add(property = pr_TypedModel_transformation);
			property.setIsResolveProxies(true);
			property.setIsTransient(true);
			property.setOpposite(pr_Transformation_modelParameter);
			ownedProperties.add(property = pr_TypedModel_usedPackage);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Package_TypedModel_usedPackage);
			ownedProperties.add(property = pr_TypedModel_Domain_typedModel);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Domain_typedModel);
			ownedProperties.add(property = pr_TypedModel_SimpleTargetElement_iterates);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_SimpleTargetElement_iterates);
			ownedProperties.add(property = pr_TypedModel_SimpleTargetElement_typedModel);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_SimpleTargetElement_typedModel);
			ownedProperties.add(property = pr_TypedModel_TypedModel_iterates);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_iterates);
			ownedProperties.add(property = pr_TypedModel_dependent_dependsOn);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_dependsOn);
		}

		private void installTemplateBindings() {
			addBinding(_Bag_Domain, _Domain);
			addBinding(_Bag_Function, _Function);
			addBinding(_Bag_Pattern, _Pattern);
			addBinding(_Bag_SimpleTargetElement, _SimpleTargetElement);
			addBinding(_Bag_TypedModel, _TypedModel);
			addBinding(_Collection_Annotation, _Annotation);
			addBinding(_Collection_Domain, _Domain);
			addBinding(_Collection_Function, _Function);
			addBinding(_Collection_Package, _Package);
			addBinding(_Collection_Pattern, _Pattern);
			addBinding(_Collection_Predicate, _Predicate);
			addBinding(_Collection_Rule, _Rule);
			addBinding(_Collection_SimpleTargetElement, _SimpleTargetElement);
			addBinding(_Collection_Target, _Target);
			addBinding(_Collection_TargetElement, _TargetElement);
			addBinding(_Collection_TypedModel, _TypedModel);
			addBinding(_Collection_Variable, _Variable);
			addBinding(_OrderedCollection_Domain, _Domain);
			addBinding(_OrderedCollection_Rule, _Rule);
			addBinding(_OrderedCollection_SimpleTargetElement, _SimpleTargetElement);
			addBinding(_OrderedCollection_TypedModel, _TypedModel);
			addBinding(_OrderedSet_Domain_NullFree, _Domain);
			addBinding(_OrderedSet_Rule_NullFree, _Rule);
			addBinding(_OrderedSet_SimpleTargetElement_NullFree, _SimpleTargetElement);
			addBinding(_OrderedSet_TypedModel_NullFree, _TypedModel);
			addBinding(_Set_Annotation_NullFree, _Annotation);
			addBinding(_Set_Package_NullFree, _Package);
			addBinding(_Set_Predicate_NullFree, _Predicate);
			addBinding(_Set_Rule_NullFree, _Rule);
			addBinding(_Set_TargetElement_NullFree, _TargetElement);
			addBinding(_Set_Target_NullFree, _Target);
			addBinding(_Set_TypedModel_NullFree, _TypedModel);
			addBinding(_Set_Variable_NullFree, _Variable);
			addBinding(_UniqueCollection_Annotation, _Annotation);
			addBinding(_UniqueCollection_Domain, _Domain);
			addBinding(_UniqueCollection_Package, _Package);
			addBinding(_UniqueCollection_Predicate, _Predicate);
			addBinding(_UniqueCollection_Rule, _Rule);
			addBinding(_UniqueCollection_SimpleTargetElement, _SimpleTargetElement);
			addBinding(_UniqueCollection_Target, _Target);
			addBinding(_UniqueCollection_TargetElement, _TargetElement);
			addBinding(_UniqueCollection_TypedModel, _TypedModel);
			addBinding(_UniqueCollection_Variable, _Variable);
		}

		private void installComments() {
			installComment(pr_Domain_isCheckable, "A checkable domain may be selected as the target of a transformation in check mode. An enforceable domain is always checkable. A not-checkable domain cannot be selected as the target of a transformation. See Bug 549776.See Bug 549776.");
			installComment(pr_Domain_isEnforceable, "An enforceable domain may be selected as the target of a transformation in check or enforce mode. An enforceable domain is always checkable. A not-checkable domain cannot be selected as the target of a transformation. See Bug 549776.");
			installComment(_FunctionBody, "FunctionBody refines ExpressionInOCL to avoid the inconvenience of a timely setType() by deriving the type from the bodyExpression. See Bug 481664.");
			installComment(pr_SimpleTargetElement_iterates, "The set of typed models whose elements are also part of this TypedModel. An input TypedModel that iterates an output TypedModel specfies a fixed point iteration.");
			installComment(pr_Transformation_ownedTargets, "The set of typed models that need to be checked/enforced before this TypedModel can be checked/enforced.");
			installComment(pr_TypedModel_dependsOn, "The set of typed models that need to be checked/enforced before this TypedModel can be checked/enforced.");
			installComment(pr_TypedModel_isPrimitive, "The TypedModel is for a primitive domain. It may be added automatically.");
			installComment(pr_TypedModel_isThis, "The TypedModel is for the transformation instance trace. It may be added automatically.");
			installComment(pr_TypedModel_isTrace, "The TypedModel is for the execution trace. It may be added automatically.");
			installComment(pr_TypedModel_iterates, "The set of typed models whose elements are also part of this TypedModel. An input TypedModel that iterates an output TypedModel specfies a fixed point iteration.");
		}
	}
}
