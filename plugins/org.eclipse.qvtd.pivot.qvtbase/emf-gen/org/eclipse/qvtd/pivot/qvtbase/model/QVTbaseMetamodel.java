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
 * from: /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * by: org.eclipse.ocl.examples.build.xtend.GenerateOCLmetamodel.xtend
 * and: org.eclipse.ocl.examples.build.GeneratePivotMetamodel.mwe2
 *
 * Do not edit it.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.model;

import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.*;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AbstractContents;
import org.eclipse.ocl.pivot.library.LibraryFeature;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

/**
 * This is the pivot representation of the http://www.eclipse.org/qvt/2015/QVTbase metamodel
 * auto-generated from /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore.
 * It facilitates efficient model loading without the overheads of model reading.
 */
@SuppressWarnings({"nls", "unused"})
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

	public static @NonNull Package create(@NonNull StandardLibraryInternal standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
		QVTbaseMetamodel resource = new QVTbaseMetamodel(ClassUtil.nonNullEMF(URI.createURI(PIVOT_URI)));
		Contents contents = new Contents(standardLibrary.getPackage(), name, nsPrefix, nsURI);
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
			metamodel = INSTANCE = new QVTbaseMetamodel(ClassUtil.nonNullEMF(URI.createURI(PIVOT_URI)));
			Contents contents = new Contents(OCLstdlib.getDefaultPackage(), "qvtbase", "qvtb", PIVOT_URI);
			metamodel.getContents().add(contents.getModel());
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

	private static class Contents extends LibraryContents
	{
		private final @NonNull Model root;
		private final @NonNull Package pivot;
		private final @NonNull Package qvtbase;
		private final @NonNull Package orphanage;

		protected Contents(@NonNull Package standardLibrary, @NonNull String name, @Nullable String nsPrefix, @NonNull String nsURI) {
			super(standardLibrary);
			root = createModel("http://www.eclipse.org/qvt/2015/QVTbase");
			pivot = createPackage("pivot", "pivot", "http://www.eclipse.org/ocl/2015/Pivot", IdManager.METAMODEL);
			qvtbase = createPackage("qvtbase", "qvtb", "http://www.eclipse.org/qvt/2015/QVTbase", null);
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
			return root;
		}
		
		private final @NonNull Package _ocl = standardLibrary;
		private final @NonNull BagType _Bag = getBagType(_ocl, "Bag");
		private final @NonNull PrimitiveType _Boolean = getPrimitiveType(_ocl, "Boolean");
		private final @NonNull CollectionType _Collection = getCollectionType(_ocl, "Collection");
		private final @NonNull PrimitiveType _Integer = getPrimitiveType(_ocl, "Integer");
		private final @NonNull AnyType _OclAny = getAnyType(_ocl, "OclAny");
		private final @NonNull Class _OclElement = getClass(_ocl, "OclElement");
		private final @NonNull CollectionType _OrderedCollection = getCollectionType(_ocl, "OrderedCollection");
		private final @NonNull OrderedSetType _OrderedSet = getOrderedSetType(_ocl, "OrderedSet");
		private final @NonNull PrimitiveType _Real = getPrimitiveType(_ocl, "Real");
		private final @NonNull SetType _Set = getSetType(_ocl, "Set");
		private final @NonNull PrimitiveType _String = getPrimitiveType(_ocl, "String");
		private final @NonNull CollectionType _UniqueCollection = getCollectionType(_ocl, "UniqueCollection");
		private final @NonNull PrimitiveType _UnlimitedNatural = getPrimitiveType(_ocl, "UnlimitedNatural");
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
		
		private final @NonNull Class _Annotation = createClass(PivotPackage.Literals.ANNOTATION);
		private final @NonNull Class _OCLExpression = createClass(PivotPackage.Literals.OCL_EXPRESSION);
		private final @NonNull Class _Package = createClass(PivotPackage.Literals.PACKAGE);
		private final @NonNull Class _Variable = createClass(PivotPackage.Literals.VARIABLE);
		
		private final @NonNull Class _BaseModel = createClass(QVTbasePackage.Literals.BASE_MODEL);
		private final @NonNull Class _Domain = createClass(QVTbasePackage.Literals.DOMAIN);
		private final @NonNull Class _Function = createClass(QVTbasePackage.Literals.FUNCTION);
		private final @NonNull Class _FunctionParameter = createClass(QVTbasePackage.Literals.FUNCTION_PARAMETER);
		private final @NonNull Class _Pattern = createClass(QVTbasePackage.Literals.PATTERN);
		private final @NonNull Class _Predicate = createClass(QVTbasePackage.Literals.PREDICATE);
		private final @NonNull Class _Rule = createClass(QVTbasePackage.Literals.RULE);
		private final @NonNull Class _Transformation = createClass(QVTbasePackage.Literals.TRANSFORMATION);
		private final @NonNull Class _TypedModel = createClass(QVTbasePackage.Literals.TYPED_MODEL);
		
		private final @NonNull BagType _Bag_Domain = createBagType(_Bag, _Domain);
		private final @NonNull BagType _Bag_Pattern = createBagType(_Bag, _Pattern);
		private final @NonNull BagType _Bag_TypedModel = createBagType(_Bag, _TypedModel);
		private final @NonNull CollectionType _Collection_Annotation = createCollectionType(_Collection, _Annotation);
		private final @NonNull CollectionType _Collection_Domain = createCollectionType(_Collection, _Domain);
		private final @NonNull CollectionType _Collection_Package = createCollectionType(_Collection, _Package);
		private final @NonNull CollectionType _Collection_Pattern = createCollectionType(_Collection, _Pattern);
		private final @NonNull CollectionType _Collection_Predicate = createCollectionType(_Collection, _Predicate);
		private final @NonNull CollectionType _Collection_Rule = createCollectionType(_Collection, _Rule);
		private final @NonNull CollectionType _Collection_TypedModel = createCollectionType(_Collection, _TypedModel);
		private final @NonNull CollectionType _Collection_Variable = createCollectionType(_Collection, _Variable);
		private final @NonNull CollectionType _OrderedCollection_Domain = createCollectionType(_OrderedCollection, _Domain);
		private final @NonNull CollectionType _OrderedCollection_TypedModel = createCollectionType(_OrderedCollection, _TypedModel);
		private final @NonNull OrderedSetType _OrderedSet_Domain = createOrderedSetType(_OrderedSet, _Domain);
		private final @NonNull OrderedSetType _OrderedSet_TypedModel = createOrderedSetType(_OrderedSet, _TypedModel);
		private final @NonNull SetType _Set_Annotation = createSetType(_Set, _Annotation);
		private final @NonNull SetType _Set_Package = createSetType(_Set, _Package);
		private final @NonNull SetType _Set_Predicate = createSetType(_Set, _Predicate);
		private final @NonNull SetType _Set_Rule = createSetType(_Set, _Rule);
		private final @NonNull SetType _Set_TypedModel = createSetType(_Set, _TypedModel);
		private final @NonNull SetType _Set_Variable = createSetType(_Set, _Variable);
		private final @NonNull CollectionType _UniqueCollection_Annotation = createCollectionType(_UniqueCollection, _Annotation);
		private final @NonNull CollectionType _UniqueCollection_Domain = createCollectionType(_UniqueCollection, _Domain);
		private final @NonNull CollectionType _UniqueCollection_Package = createCollectionType(_UniqueCollection, _Package);
		private final @NonNull CollectionType _UniqueCollection_Predicate = createCollectionType(_UniqueCollection, _Predicate);
		private final @NonNull CollectionType _UniqueCollection_Rule = createCollectionType(_UniqueCollection, _Rule);
		private final @NonNull CollectionType _UniqueCollection_TypedModel = createCollectionType(_UniqueCollection, _TypedModel);
		private final @NonNull CollectionType _UniqueCollection_Variable = createCollectionType(_UniqueCollection, _Variable);
		
		private void installClassTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			Class type;
		
			ownedClasses = pivot.getOwnedClasses();
			ownedClasses.add(type = _Annotation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _OCLExpression);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Package);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Variable);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		
			ownedClasses = qvtbase.getOwnedClasses();
			ownedClasses.add(type = _BaseModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Function);
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
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Transformation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
		}
		
		private void installCollectionTypes() {
			List<Class> ownedClasses;
			List<Class> superClasses;
			CollectionType type;
		
			ownedClasses = orphanage.getOwnedClasses();
			ownedClasses.add(type = _Bag_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Domain);
			ownedClasses.add(type = _Bag_Pattern);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Pattern);
			ownedClasses.add(type = _Bag_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _Collection_Annotation);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Domain);
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
			ownedClasses.add(type = _Collection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _Collection_Variable);
			superClasses = type.getSuperClasses();
			superClasses.add(_OclElement);
			ownedClasses.add(type = _OrderedCollection_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Domain);
			ownedClasses.add(type = _OrderedCollection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _OrderedSet_Domain);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_Domain);
			superClasses.add(_UniqueCollection_Domain);
			ownedClasses.add(type = _OrderedSet_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_OrderedCollection_TypedModel);
			superClasses.add(_UniqueCollection_TypedModel);
			ownedClasses.add(type = _Set_Annotation);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Annotation);
			ownedClasses.add(type = _Set_Package);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Package);
			ownedClasses.add(type = _Set_Predicate);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Predicate);
			ownedClasses.add(type = _Set_Rule);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_Rule);
			ownedClasses.add(type = _Set_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_UniqueCollection_TypedModel);
			ownedClasses.add(type = _Set_Variable);
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
			ownedClasses.add(type = _UniqueCollection_TypedModel);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_TypedModel);
			ownedClasses.add(type = _UniqueCollection_Variable);
			superClasses = type.getSuperClasses();
			superClasses.add(_Collection_Variable);
		}
		
		private final @NonNull Operation op_Transformation_getFunction = createOperation("getFunction", _Function, null, null);
		private final @NonNull Operation op_Transformation_getModelParameter = createOperation("getModelParameter", _TypedModel, null, null);
		
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
		private final @NonNull Property pr_OCLExpression_Function_queryExpression = createProperty("Function", _Function);
		private final @NonNull Property pr_OCLExpression_predicate_conditionExpression = createProperty("predicate", _Predicate);
		private final @NonNull Property pr_Package_TypedModel_usedPackage = createProperty("TypedModel", _Bag_TypedModel);
		private final @NonNull Property pr_Variable_Pattern_bindsTo = createProperty("Pattern", _Bag_Pattern);
		private final @NonNull Property pr_Variable_Transformation_ownedContext = createProperty("Transformation", _Transformation);
		private final @NonNull Property pr_Variable_TypedModel_ownedContext = createProperty("TypedModel", _TypedModel);
		
		private final @NonNull Property pr_Domain_isCheckable = createProperty(QVTbasePackage.Literals.DOMAIN__IS_CHECKABLE, _Boolean);
		private final @NonNull Property pr_Domain_isEnforceable = createProperty(QVTbasePackage.Literals.DOMAIN__IS_ENFORCEABLE, _Boolean);
		private final @NonNull Property pr_Domain_rule = createProperty(QVTbasePackage.Literals.DOMAIN__RULE, _Rule);
		private final @NonNull Property pr_Domain_typedModel = createProperty(QVTbasePackage.Literals.DOMAIN__TYPED_MODEL, _TypedModel);
		private final @NonNull Property pr_Function_queryExpression = createProperty(QVTbasePackage.Literals.FUNCTION__QUERY_EXPRESSION, _OCLExpression);
		private final @NonNull Property pr_Pattern_bindsTo = createProperty(QVTbasePackage.Literals.PATTERN__BINDS_TO, _Set_Variable);
		private final @NonNull Property pr_Pattern_predicate = createProperty(QVTbasePackage.Literals.PATTERN__PREDICATE, _Set_Predicate);
		private final @NonNull Property pr_Predicate_conditionExpression = createProperty(QVTbasePackage.Literals.PREDICATE__CONDITION_EXPRESSION, _OCLExpression);
		private final @NonNull Property pr_Predicate_pattern = createProperty(QVTbasePackage.Literals.PREDICATE__PATTERN, _Pattern);
		private final @NonNull Property pr_Rule_domain = createProperty(QVTbasePackage.Literals.RULE__DOMAIN, _OrderedSet_Domain);
		private final @NonNull Property pr_Rule_isDefault = createProperty(QVTbasePackage.Literals.RULE__IS_DEFAULT, _Boolean);
		private final @NonNull Property pr_Rule_overridden = createProperty(QVTbasePackage.Literals.RULE__OVERRIDDEN, _Set_Rule);
		private final @NonNull Property pr_Rule_overrides = createProperty(QVTbasePackage.Literals.RULE__OVERRIDES, _Rule);
		private final @NonNull Property pr_Rule_transformation = createProperty(QVTbasePackage.Literals.RULE__TRANSFORMATION, _Transformation);
		private final @NonNull Property pr_Transformation_extends = createProperty(QVTbasePackage.Literals.TRANSFORMATION__EXTENDS, _Transformation);
		private final @NonNull Property pr_Transformation_modelParameter = createProperty(QVTbasePackage.Literals.TRANSFORMATION__MODEL_PARAMETER, _OrderedSet_TypedModel);
		private final @NonNull Property pr_Transformation_ownedContext = createProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT, _Variable);
		private final @NonNull Property pr_Transformation_ownedTag = createProperty(QVTbasePackage.Literals.TRANSFORMATION__OWNED_TAG, _Set_Annotation);
		private final @NonNull Property pr_Transformation_rule = createProperty(QVTbasePackage.Literals.TRANSFORMATION__RULE, _Set_Rule);
		private final @NonNull Property pr_Transformation_extendedBy_extends = createProperty("extendedBy", _Transformation);
		private final @NonNull Property pr_TypedModel_dependsOn = createProperty(QVTbasePackage.Literals.TYPED_MODEL__DEPENDS_ON, _Set_TypedModel);
		private final @NonNull Property pr_TypedModel_ownedContext = createProperty(QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT, _Variable);
		private final @NonNull Property pr_TypedModel_transformation = createProperty(QVTbasePackage.Literals.TYPED_MODEL__TRANSFORMATION, _Transformation);
		private final @NonNull Property pr_TypedModel_usedPackage = createProperty(QVTbasePackage.Literals.TYPED_MODEL__USED_PACKAGE, _Set_Package);
		private final @NonNull Property pr_TypedModel_Domain_typedModel = createProperty("Domain", _Bag_Domain);
		private final @NonNull Property pr_TypedModel_dependent_dependsOn = createProperty("dependent", _TypedModel);
		
		private void installProperties() {
			List<Property> ownedProperties;
			Property property;
		
			ownedProperties = _Annotation.getOwnedProperties();
			ownedProperties.add(property = pr_Annotation_Transformation_ownedTag);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_ownedTag);
		
			ownedProperties = _OCLExpression.getOwnedProperties();
			ownedProperties.add(property = pr_OCLExpression_Function_queryExpression);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Function_queryExpression);
			ownedProperties.add(property = pr_OCLExpression_predicate_conditionExpression);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Predicate_conditionExpression);
		
			ownedProperties = _Package.getOwnedProperties();
			ownedProperties.add(property = pr_Package_TypedModel_usedPackage);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_usedPackage);
		
			ownedProperties = _Variable.getOwnedProperties();
			ownedProperties.add(property = pr_Variable_Pattern_bindsTo);
			property.setIsImplicit(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Pattern_bindsTo);
			ownedProperties.add(property = pr_Variable_Transformation_ownedContext);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Transformation_ownedContext);
			ownedProperties.add(property = pr_Variable_TypedModel_ownedContext);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_ownedContext);
		
			ownedProperties = _Domain.getOwnedProperties();
			ownedProperties.add(property = pr_Domain_isCheckable);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setIsUnsettable(true);
			ownedProperties.add(property = pr_Domain_isEnforceable);
			property.setIsRequired(false);
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
			property.setIsComposite(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
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
			ownedProperties.add(property = pr_Rule_isDefault);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			ownedProperties.add(property = pr_Rule_overridden);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_overrides);
			ownedProperties.add(property = pr_Rule_overrides);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Rule_overridden);
			ownedProperties.add(property = pr_Rule_transformation);
			property.setIsRequired(false);
			property.setIsTransient(true);
			property.setOpposite(pr_Transformation_rule);
		
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
			property.setOpposite(pr_Variable_Transformation_ownedContext);
			ownedProperties.add(property = pr_Transformation_ownedTag);
			property.setIsComposite(true);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Annotation_Transformation_ownedTag);
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
			ownedProperties.add(property = pr_TypedModel_ownedContext);
			property.setIsComposite(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_Variable_TypedModel_ownedContext);
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
			ownedProperties.add(property = pr_TypedModel_dependent_dependsOn);
			property.setIsImplicit(true);
			property.setIsRequired(false);
			property.setIsResolveProxies(true);
			property.setOpposite(pr_TypedModel_dependsOn);
		}
		
		private void installTemplateBindings() {
			_Bag_Domain.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Bag_T, _Domain)));
			_Bag_Pattern.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Bag_T, _Pattern)));
			_Bag_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Bag_T, _TypedModel)));
			_Collection_Annotation.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Annotation)));
			_Collection_Domain.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Domain)));
			_Collection_Package.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Package)));
			_Collection_Pattern.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Pattern)));
			_Collection_Predicate.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Predicate)));
			_Collection_Rule.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Rule)));
			_Collection_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _TypedModel)));
			_Collection_Variable.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Collection_T, _Variable)));
			_OrderedCollection_Domain.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_OrderedCollection_T, _Domain)));
			_OrderedCollection_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_OrderedCollection_T, _TypedModel)));
			_OrderedSet_Domain.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_OrderedSet_T, _Domain)));
			_OrderedSet_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_OrderedSet_T, _TypedModel)));
			_Set_Annotation.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _Annotation)));
			_Set_Package.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _Package)));
			_Set_Predicate.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _Predicate)));
			_Set_Rule.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _Rule)));
			_Set_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _TypedModel)));
			_Set_Variable.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_Set_T, _Variable)));
			_UniqueCollection_Annotation.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Annotation)));
			_UniqueCollection_Domain.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Domain)));
			_UniqueCollection_Package.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Package)));
			_UniqueCollection_Predicate.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Predicate)));
			_UniqueCollection_Rule.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Rule)));
			_UniqueCollection_TypedModel.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _TypedModel)));
			_UniqueCollection_Variable.getOwnedBindings().add(createTemplateBinding(
				createTemplateParameterSubstitution(_UniqueCollection_T, _Variable)));
		}
		
		private void installComments() {
		}
	}
}
