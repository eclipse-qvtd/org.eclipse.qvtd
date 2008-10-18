/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.emof.EMOF.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.mappings.EAttributeMap;
import org.eclipse.qvt.declarative.ecore.mappings.EAttributeOrEReference;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.EReferenceMap;
import org.eclipse.qvt.declarative.ecore.mappings.EReferenceToEClassifierMap;
import org.eclipse.qvt.declarative.ecore.mappings.EcoreFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.ExtensionFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;

/**
 * EMOFMappingMetaData defines the mapping between an EMOF adapting model and an Ecore model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class EMOFMappingMetaData extends AbstractEMOFMappingMetaData
{
	protected static class Factory extends AbstractEMOFMappingMetaData.Factory
	{		
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EMOFMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			if (ecoreClass.getEPackage() == EMOFPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case EMOFPackage.CLASS: return getAdapter(EcoreFactory.eINSTANCE.createEClass());
					case EMOFPackage.COMMENT: return createEAnnotationCommentAdapter();
		//			case EmofPackage.DATA_TYPE: return getAdapter(EcoreFactory.eINSTANCE.createEDataType());
					case EMOFPackage.ENUMERATION: return getAdapter(EcoreFactory.eINSTANCE.createEEnum());
					case EMOFPackage.ENUMERATION_LITERAL: return getAdapter(EcoreFactory.eINSTANCE.createEEnumLiteral());
		//			case EmofPackage.EXTENT: return getAdapter(EcoreFactory.eINSTANCE.createEExtent());
					case EMOFPackage.FACTORY: return getAdapter(EcoreFactory.eINSTANCE.createEFactory());
		//			case EmofPackage.OBJECT: return getAdapter(EcoreFactory.eINSTANCE.createEObject());
					case EMOFPackage.OPERATION: return getAdapter(createEOperation());
					case EMOFPackage.PACKAGE: return getAdapter(EcoreFactory.eINSTANCE.createEPackage());
					case EMOFPackage.PARAMETER: return getAdapter(createEParameter());
					case EMOFPackage.PROPERTY: return getAdapter(createEProperty());
					case EMOFPackage.PRIMITIVE_TYPE: return getAdapter(EcoreFactory.eINSTANCE.createEDataType());
		//			case EmofPackage.REFLECTIVE_COLLECTION: return getAdapter(EcoreFactory.eINSTANCE.createEReflectiveCollection());
		//			case EmofPackage.REFLECTIVE_SEQUENCE: return getAdapter(EcoreFactory.eINSTANCE.createEReflectiveSequence());
					case EMOFPackage.TAG: return createEAnnotationTagAdapter();
		//			case EmofPackage.URI_EXTENT: return getAdapter(EcoreFactory.eINSTANCE.createEURIExtent());
				}
			}
			return super.create(ecoreClass);
		}

		protected EObject createEAnnotationCommentAdapter() {
			return getAnnotationMappingMetaData().createEAnnotationCommentAdapter(mappingMetaDataRegistry);
		}

		protected EObject createEAnnotationTagAdapter() {
			return getAnnotationMappingMetaData().createEAnnotationTagAdapter(mappingMetaDataRegistry);
		}

		protected EOperation createEOperation() {
			EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
			eOperation.setLowerBound(1);
			eOperation.setOrdered(false);
			return eOperation;
		}

		protected EParameter createEParameter() {
			EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
			eParameter.setLowerBound(1);
			eParameter.setOrdered(false);
			return eParameter;
		}

		protected EAttributeOrEReference createEProperty() {
			EAttributeOrEReference eProperty = new EAttributeOrEReference();
			eProperty.setLowerBound(1);
			eProperty.setOrdered(false);
			return eProperty;
		}

		protected EMOFAnnotationMappingMetaData getAnnotationMappingMetaData() {
			return ((EMOFMappingMetaData)mappingMetaData).getAnnotationMappingMetaData();
		}
	}
	
	public static final EMOFMappingMetaData INSTANCE = new EMOFMappingMetaData(
			EMOFPackage.eINSTANCE, EcorePackage.eINSTANCE, new String[] { EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI });

	protected final EMOFAnnotationMappingMetaData annotationMappingMetaData;
		
	protected EMOFMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
		annotationMappingMetaData = new EMOFAnnotationMappingMetaData(this);
	}

	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return EMOFPackage.eCONTENT_TYPE;
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new EMOFResourceFactoryImpl(mappingMetaDataRegistry);
	}

	public EMOFAnnotationMappingMetaData getAnnotationMappingMetaData() {
		return annotationMappingMetaData;
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return EcorePackage.eCONTENT_TYPE;
	}

	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
//	    putEDataTypeMap(EcorePackage.Literals.EBOOLEAN, PrimitiveTypesPackage.Literals.BOOLEAN);
//	    putEDataTypeMap(EcorePackage.Literals.EDOUBLE, PrimitiveTypesPackage.Literals.REAL);
//	    putEDataTypeMap(EcorePackage.Literals.EINT, PrimitiveTypesPackage.Literals.INTEGER);
//	    putEDataTypeMap(EcorePackage.Literals.ESTRING, PrimitiveTypesPackage.Literals.STRING);
		mappingMetaDataRegistry.putEDataTypeMap(EcorePackage.Literals.EBOOLEAN, EMOFPackage.Literals.BOOLEAN);
		mappingMetaDataRegistry.putEDataTypeMap(EcorePackage.Literals.EDOUBLE, EMOFPackage.Literals.REAL);
		mappingMetaDataRegistry.putEDataTypeMap(EcorePackage.Literals.EINT, EMOFPackage.Literals.INTEGER);
		mappingMetaDataRegistry.putEDataTypeMap(EcorePackage.Literals.ESTRING, EMOFPackage.Literals.STRING);
						
		annotationMappingMetaData.initialize(mappingMetaDataRegistry);
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.ECLASS, EMOFPackage.Literals.CLASS));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.ECLASSIFIER, EMOFPackage.Literals.TYPE));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EDATA_TYPE, EMOFPackage.Literals.PRIMITIVE_TYPE));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EENUM, EMOFPackage.Literals.ENUMERATION));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EENUM_LITERAL, EMOFPackage.Literals.ENUMERATION_LITERAL));
	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EFACTORY, EMOFPackage.Literals.FACTORY));
	    //
	    //	Don't transfer gratuitous generic types to/from xmi:Extension
	    //
	    mappingMetaDataRegistry.installClassToExtensionMap(new EClassMap.Extension(this, EcorePackage.Literals.EGENERIC_TYPE)
			{
				@Override public void postLoad(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
					if (MappingUtils.isGeneric((EGenericType)ecoreObject))
						super.postLoad(mappingMetaDataRegistry, ecoreObject);
				}

				@Override public void preSave(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
					if (MappingUtils.isGeneric((EGenericType)ecoreObject))
						super.preSave(mappingMetaDataRegistry, ecoreObject);
				}		
			});
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EMODEL_ELEMENT, EMOFPackage.Literals.ELEMENT));
		mappingMetaDataRegistry.installClassToExtensionMap(new EClassMap.Extension(this, EcorePackage.Literals.EOBJECT));			// never used
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EOPERATION, EMOFPackage.Literals.OPERATION));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EPACKAGE, EMOFPackage.Literals.PACKAGE));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, EcorePackage.Literals.EPARAMETER, EMOFPackage.Literals.PARAMETER));
		mappingMetaDataRegistry.installClassToExtensionMap(new EClassMap.Extension(this, EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY));
		mappingMetaDataRegistry.install(new EClassMap(this, EcorePackage.Literals.ESTRUCTURAL_FEATURE, EMOFPackage.Literals.PROPERTY)
	    {
			@Override public AdaptingEObject createAdapter(MappingMetaDataRegistry mappingMetaDataRegistry, EObject ecoreObject) {
				return new EMOFPropertyAdapter(mappingMetaDataRegistry, this, (EAttributeOrEReference) ecoreObject);			
			}	    	
	    });
		mappingMetaDataRegistry.installClassToExtensionMap(new EClassMap.Extension(this, EcorePackage.Literals.ETYPE_PARAMETER));
	    //
	    //	Must convert Property to EReference/EAttribute 
	    //
	    EClassMap attributeClassMap = new EClassMap.Direct(this, EcorePackage.Literals.EATTRIBUTE, EMOFPackage.Literals.PROPERTY);
	    EClassMap referenceClassMap = new EClassMap.Direct(this, EcorePackage.Literals.EREFERENCE, EMOFPackage.Literals.PROPERTY);
	    mappingMetaDataRegistry.putEcoreEClassMap(attributeClassMap.getEcoreEClass(), attributeClassMap);
	    mappingMetaDataRegistry.putEcoreEClassMap(referenceClassMap.getEcoreEClass(), referenceClassMap);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EATTRIBUTE__ID, EMOFPackage.Literals.PROPERTY__IS_ID);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ECLASS__ABSTRACT, EMOFPackage.Literals.CLASS__IS_ABSTRACT);
	    //
	    // Must exclude non-generic types from EClass.eGenericSuperTypes.
	    //
	    mappingMetaDataRegistry.install(
	    	new EReferenceMap(mappingMetaDataRegistry, 
	    		new EcoreFeatureElement.EReferenceElement(EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES)
	    		{
					@Override
					public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
						return MappingUtils.excludeNonGenericTypes(((EClass)object).getEGenericSuperTypes());
					}
	    		},
	    		ExtensionFeatureElement.create(EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES, null)
	    	)
	    );
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ECLASS__EOPERATIONS, EMOFPackage.Literals.CLASS__OWNED_OPERATION);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES, EMOFPackage.Literals.CLASS__OWNED_ATTRIBUTE); // ownedProperty???
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ECLASS__ESUPER_TYPES, EMOFPackage.Literals.CLASS__SUPER_CLASS);	    
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ECLASS__INTERFACE);

	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ECLASSIFIER__ETYPE_PARAMETERS);
	    //
	    //	Ignore instanceClassName if instanceClass.getName() != instanceTypeName
	    //
	    mappingMetaDataRegistry.install(
		    	new EAttributeMap(mappingMetaDataRegistry, 
		    		new EcoreFeatureElement.EAttributeElement(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)
		    		{
						@Override
						public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
							Class<?> instanceClass = (Class<?>)object.eGet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS, resolveProxies);
							Object instanceTypeName = object.eGet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME, resolveProxies);
							if ((instanceClass == null) || !instanceClass.getName().equals(instanceTypeName))
								return null;
							else
								return super.get(mappingMetaDataRegistry, object, resolveProxies);
						}
		    		},
		    		ExtensionFeatureElement.create(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME,
		    				mappingMetaDataRegistry.createDemandExtensionAttributeAsReferenceFeature(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME))
		    	)
		    );
	    //
	    //	Ignore instanceTypeName if instanceClass.getName() == instanceTypeName
	    //
	    mappingMetaDataRegistry.install(
		    	new EAttributeMap(mappingMetaDataRegistry, 
		    		new EcoreFeatureElement.EAttributeElement(EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME)
		    		{
						@Override
						public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
							Class<?> instanceClass = (Class<?>)object.eGet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS, resolveProxies);
							Object instanceTypeName = super.get(mappingMetaDataRegistry, object, resolveProxies);
							if ((instanceClass == null) || !instanceClass.getName().equals(instanceTypeName))
								return instanceTypeName;
							else
								return null;
						}
		    		},
		    		ExtensionFeatureElement.create(EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME,
		    				mappingMetaDataRegistry.createDemandExtensionAttributeAsReferenceFeature(EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME))
		    	)
		    );

	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EENUM__ELITERALS, EMOFPackage.Literals.ENUMERATION__OWNED_LITERAL);

	    // FIXME Only save literal if non-default
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EENUM_LITERAL__LITERAL);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EENUM_LITERAL__VALUE);
	    // Ecore's feature is transient
	    mappingMetaDataRegistry.installFeatureToFeatureMap(null, EMOFPackage.Literals.FACTORY__PACKAGE);

	    //
	    //	Generic types are not part of EMOF so mapping their classifiers is not necessary.
	    //
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeOrElementMap(EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EGENERIC_TYPE__ELOWER_BOUND);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EGENERIC_TYPE__ETYPE_ARGUMENTS);
	    mappingMetaDataRegistry.installFeatureToExtensionAttributeOrElementMap(EcorePackage.Literals.EGENERIC_TYPE__ETYPE_PARAMETER);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EGENERIC_TYPE__EUPPER_BOUND);
	    
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ENAMED_ELEMENT__NAME, EMOFPackage.Literals.NAMED_ELEMENT__NAME);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EOPERATION__EEXCEPTIONS, EMOFPackage.Literals.OPERATION__RAISED_EXCEPTION);
	    //
	    // Must exclude non-generic exceptions from EOperation.eGenericExceptions.
	    //
	    mappingMetaDataRegistry.install(
	    	new EReferenceMap(mappingMetaDataRegistry, 
	    		new EcoreFeatureElement.EReferenceElement(EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS)
	    		{
					@Override
					public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
						return MappingUtils.excludeNonGenericTypes(((EOperation)object).getEGenericExceptions());
					}
	    		},
	    		ExtensionFeatureElement.create(EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS, null)
	    	)
	    );
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EOPERATION__EPARAMETERS, EMOFPackage.Literals.OPERATION__OWNED_PARAMETER);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EOPERATION__ETYPE_PARAMETERS);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EPACKAGE__ECLASSIFIERS, EMOFPackage.Literals.PACKAGE__OWNED_TYPE);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EPACKAGE__ESUBPACKAGES, EMOFPackage.Literals.PACKAGE__NESTED_PACKAGE);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EPACKAGE__NS_PREFIX);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EPACKAGE__NS_URI, EMOFPackage.Literals.PACKAGE__URI);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EREFERENCE__CONTAINMENT, EMOFPackage.Literals.PROPERTY__IS_COMPOSITE);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EREFERENCE__EKEYS, null); // no property
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.EREFERENCE__EOPPOSITE, EMOFPackage.Literals.PROPERTY__OPPOSITE);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);

	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY, EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__KEY);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE);

	    //
	    // Must invert value between changeable and isReadOnly.
	    //
	    mappingMetaDataRegistry.install(
	    	new EAttributeMap(mappingMetaDataRegistry, 
	    		EcoreFeatureElement.create(EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE),
	    		EcoreFeatureElement.create(EMOFPackage.Literals.PROPERTY__IS_READ_ONLY))
	    	{
				@Override
				protected Object exportValue(EObject adaptingObject, Object ecoreValue) {
					boolean changeable = ((Boolean)ecoreValue).booleanValue();
					return super.exportValue(adaptingObject, Boolean.valueOf(!changeable));
				}

				@Override
				protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
					boolean isReadOnly = ((Boolean)adaptingValue).booleanValue();
					return super.importValue(adaptingResource, adaptingObject, Boolean.valueOf(!isReadOnly));
				}	    		
	    	}
	    );    
	    
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL, EMOFPackage.Literals.PROPERTY__DEFAULT);
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DERIVED, EMOFPackage.Literals.PROPERTY__IS_DERIVED);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE);
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE);
	    
	    mappingMetaDataRegistry.installFeatureToExtensionElementMap(EcorePackage.Literals.ETYPE_PARAMETER__EBOUNDS);

	    //
	    // Must not get ETypedElement.eGenericType if ETypedElement.eType will do.
	    //
	    mappingMetaDataRegistry.install(
		    new EReferenceMap(mappingMetaDataRegistry,
		    	new EcoreFeatureElement.EReferenceElement(EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE)
			    {
					@Override
					public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
						if (!MappingUtils.isGeneric((ETypedElement)object))
							return null;
						return super.get(mappingMetaDataRegistry, object, resolveProxies);
					}
				},
		    	ExtensionFeatureElement.create(EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE,
		    			mappingMetaDataRegistry.createDemandExtensionReferenceFeature(EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE, EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE.isContainment())))
		);
	    //
	    // Must not get ETypedElement.eType if there is an eGenericType.
	    //
	    mappingMetaDataRegistry.install(
	    	new EReferenceToEClassifierMap(mappingMetaDataRegistry,
	    		new EcoreFeatureElement.EReferenceElement(EcorePackage.Literals.ETYPED_ELEMENT__ETYPE)
				{
					@Override
					public Object get(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EObject object, boolean resolveProxies) {
						if (MappingUtils.isGeneric((ETypedElement)object))
							return null;
						return super.get(mappingMetaDataRegistry, object, resolveProxies);
					}
				},
				EcoreFeatureElement.create(EMOFPackage.Literals.TYPED_ELEMENT__TYPE))
	    );  
	    //
	    // Must force saving of values if the Ecore is not the EMOF default.
	    //
	    mappingMetaDataRegistry.install(
	    	new EAttributeMap(mappingMetaDataRegistry, 
	    		EcoreFeatureElement.create(EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND),
	    		EcoreFeatureElement.create(EMOFPackage.Literals.MULTIPLICITY_ELEMENT__LOWER))
	    	{
				@Override public boolean isSetEcore(EObject ecoreObject) {
					Object lowerBound = ecoreObject.eGet(EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND);
					return !(lowerBound instanceof Integer) || (((Integer) lowerBound).intValue() != 1);
				}
	    	}
	    );    
	    //
	    // Must force saving of values the Ecore is not the EMOF default.
	    //
	    mappingMetaDataRegistry.install(
	    	new EAttributeMap(mappingMetaDataRegistry, 
	    		EcoreFeatureElement.create(EcorePackage.Literals.ETYPED_ELEMENT__ORDERED),
	    		EcoreFeatureElement.create(EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_ORDERED))
	    	{
				@Override public boolean isSetEcore(EObject ecoreObject) {
					Object isOrdered = ecoreObject.eGet(EcorePackage.Literals.ETYPED_ELEMENT__ORDERED);
					return !(isOrdered instanceof Boolean) || (((Boolean) isOrdered).booleanValue() != false);
				}
	    	}
	    );    
	    mappingMetaDataRegistry.installFeatureToFeatureMap(EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE, EMOFPackage.Literals.MULTIPLICITY_ELEMENT__IS_UNIQUE);
	    //
	    //	Conversions between -1 and * are in EmofFactoryImpl.convert/createUnlimitedNaturalFromString,
	    //	so the inherited string conversions are suppressed.
	    //
	    mappingMetaDataRegistry.install(
			new EAttributeMap(mappingMetaDataRegistry,
				EcoreFeatureElement.create(EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND),
				EcoreFeatureElement.create(EMOFPackage.Literals.MULTIPLICITY_ELEMENT__UPPER))
			{
				@Override
				protected Object exportValue(EObject adaptingObject, Object ecoreValue) {
					return ecoreValue;
				}

				@Override
				protected Object importValue(Resource adaptingResource, EObject adaptingObject, Object adaptingValue) {
					return adaptingValue;
				}				
			});
	}
}
