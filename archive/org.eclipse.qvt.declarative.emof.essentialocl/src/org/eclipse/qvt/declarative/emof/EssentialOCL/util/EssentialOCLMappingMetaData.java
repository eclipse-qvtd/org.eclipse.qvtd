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
package org.eclipse.qvt.declarative.emof.EssentialOCL.util;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.qvt.declarative.ecore.mappings.EClassMap;
import org.eclipse.qvt.declarative.ecore.mappings.EStructuralFeatureMap;
import org.eclipse.qvt.declarative.ecore.mappings.EcoreFeatureElement;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.util.EMOFMappingMetaData;
import org.eclipse.qvt.declarative.emof.EMOF.util.EReferenceToPropertyMap;
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;

/**
 * EssentialOCLMappingMetaData defines the mapping between an EMOF-based Essential OCL
 * adapting model and an Ecore-based MDT OCL model.
 * The mapping is established by adapting model elements that adapt their Ecore counterparts.
 * The mapping is established lazily, typically by invoking load or save on an
 * AdaptingXMIResource.
 */
public class EssentialOCLMappingMetaData extends EMOFMappingMetaData
{
	protected static class Factory extends EMOFMappingMetaData.Factory
	{		
		protected Factory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EssentialOCLMappingMetaData mappingMetaData) {
			super(mappingMetaDataRegistry, mappingMetaData);
		}
		
		@Override
		public EObject create(EClass ecoreClass) {
			final EcoreFactory oclFactoryInstance = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;
			if (ecoreClass.getEPackage() == EssentialOCLPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
					case EssentialOCLPackage.ANY_TYPE: return getAdapter(oclFactoryInstance.createAnyType());
//					case EssentialoclPackage.AS: return getAdapter(oclFactoryInstance.createAssociationClassCallExp());
					case EssentialOCLPackage.BAG_TYPE: return getAdapter(oclFactoryInstance.createBagType());
					case EssentialOCLPackage.BOOLEAN_LITERAL_EXP: return getAdapter(oclFactoryInstance.createBooleanLiteralExp());
//					case EssentialoclPackage.CA: return getAdapter(oclFactoryInstance.createCallOperationAction());
					case EssentialOCLPackage.COLLECTION_ITEM: return getAdapter(oclFactoryInstance.createCollectionItem());
					case EssentialOCLPackage.COLLECTION_LITERAL_EXP: return getAdapter(oclFactoryInstance.createCollectionLiteralExp());
					case EssentialOCLPackage.COLLECTION_RANGE: return getAdapter(oclFactoryInstance.createCollectionRange());
					case EssentialOCLPackage.COLLECTION_TYPE: return getAdapter(oclFactoryInstance.createCollectionType());
//					case EssentialoclPackage.CO: return getAdapter(oclFactoryInstance.createConstraint());
//					case EssentialoclPackage.EL: return getAdapter(oclFactoryInstance.createElementType());
					case EssentialOCLPackage.ENUM_LITERAL_EXP: return getAdapter(oclFactoryInstance.createEnumLiteralExp());
					case EssentialOCLPackage.EXPRESSION_IN_OCL: return getAdapter(oclFactoryInstance.createExpressionInOCL());
					case EssentialOCLPackage.IF_EXP: return getAdapter(oclFactoryInstance.createIfExp());
					case EssentialOCLPackage.INTEGER_LITERAL_EXP: return getAdapter(oclFactoryInstance.createIntegerLiteralExp());
					case EssentialOCLPackage.INVALID_LITERAL_EXP: return getAdapter(oclFactoryInstance.createInvalidLiteralExp());
					case EssentialOCLPackage.INVALID_TYPE: return getAdapter(oclFactoryInstance.createInvalidType());
					case EssentialOCLPackage.ITERATE_EXP: return getAdapter(oclFactoryInstance.createIterateExp());
					case EssentialOCLPackage.ITERATOR_EXP: return getAdapter(oclFactoryInstance.createIteratorExp());
					case EssentialOCLPackage.LET_EXP: return getAdapter(oclFactoryInstance.createLetExp());
//					case EssentialoclPackage.ME: return getAdapter(oclFactoryInstance.createMessageExp());
//					case EssentialoclPackage.ME: return getAdapter(oclFactoryInstance.createMessageType());
					case EssentialOCLPackage.NULL_LITERAL_EXP: return getAdapter(oclFactoryInstance.createNullLiteralExp());
					case EssentialOCLPackage.OPERATION_CALL_EXP: return getAdapter(oclFactoryInstance.createOperationCallExp());
					case EssentialOCLPackage.ORDERED_SET_TYPE: return getAdapter(oclFactoryInstance.createOrderedSetType());
//					case EssentialoclPackage.PR: return getAdapter(oclFactoryInstance.createPrimitiveType());
					case EssentialOCLPackage.PROPERTY_CALL_EXP: return getAdapter(oclFactoryInstance.createPropertyCallExp());
					case EssentialOCLPackage.REAL_LITERAL_EXP: return getAdapter(oclFactoryInstance.createRealLiteralExp());
//					case EssentialoclPackage.SE: return getAdapter(oclFactoryInstance.createSendSignalAction());
					case EssentialOCLPackage.SEQUENCE_TYPE: return getAdapter(oclFactoryInstance.createSequenceType());
					case EssentialOCLPackage.SET_TYPE: return getAdapter(oclFactoryInstance.createSetType());
//					case EssentialoclPackage.ST: return getAdapter(oclFactoryInstance.createStateExp());
					case EssentialOCLPackage.STRING_LITERAL_EXP: return getAdapter(oclFactoryInstance.createStringLiteralExp());
					case EssentialOCLPackage.TEMPLATE_PARAMETER_TYPE: return getAdapter(oclFactoryInstance.createTemplateParameterType());
					case EssentialOCLPackage.TUPLE_LITERAL_EXP: return getAdapter(oclFactoryInstance.createTupleLiteralExp());
					case EssentialOCLPackage.TUPLE_LITERAL_PART: return getAdapter(oclFactoryInstance.createTupleLiteralPart());
					case EssentialOCLPackage.TUPLE_TYPE: return getAdapter(oclFactoryInstance.createTupleType());
					case EssentialOCLPackage.TYPE_EXP: return getAdapter(oclFactoryInstance.createTypeExp());
					case EssentialOCLPackage.UNLIMITED_NATURAL_EXP: return getAdapter(oclFactoryInstance.createUnlimitedNaturalLiteralExp());
//					case EssentialoclPackage.UN: return getAdapter(oclFactoryInstance.createUnspecifiedValueExp());
					case EssentialOCLPackage.VARIABLE: return getAdapter(oclFactoryInstance.createVariable());
					case EssentialOCLPackage.VARIABLE_EXP: return getAdapter(oclFactoryInstance.createVariableExp());
					case EssentialOCLPackage.VOID_TYPE: return getAdapter(oclFactoryInstance.createVoidType());
				}
			}
			if (ecoreClass.getEPackage() == EMOFPackage.eINSTANCE) {
				switch (ecoreClass.getClassifierID()) {
		//			case EmofPackage.DATA_TYPE: return getAdapter(EcoreFactory.eINSTANCE.createEDataType());
					case EMOFPackage.PRIMITIVE_TYPE: return getAdapter(oclFactoryInstance.createPrimitiveType());
				}
			}
			return super.create(ecoreClass);
		}
	}
	
//	@SuppressWarnings("unused") private static EMOFMappingMetaDataAdapter primitiveTypesPackageAdapter
//		= new EMOFMappingMetaDataAdapter(PrimPackage.eINSTANCE, INSTANCE);	
	public static final EssentialOCLMappingMetaData INSTANCE = new EssentialOCLMappingMetaData(
			EssentialOCLPackage.eINSTANCE, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE,
			null);
	
	protected EssentialOCLMappingMetaData(EPackage adaptingEPackage, EPackage ecoreEPackage, String[] uriAliases) {
		super(adaptingEPackage, ecoreEPackage, uriAliases);
		// Initialise OCL Standard Library -- not needed by regression tests -- find out who needs it
		OCLStandardLibrary<EClassifier> oclStandardLibrary = EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();
		EPackage oclStandardLibraryPackage = oclStandardLibrary.getBoolean().getEPackage();
		String oclStdlibURI = oclStandardLibraryPackage.getNsURI();
	    if (Registry.INSTANCE.get(oclStdlibURI) == null)
		    Registry.INSTANCE.put(oclStdlibURI, oclStandardLibraryPackage);
		EssentialOCLValidator.install();
	}


	@Override
	protected List<IMappingMetaData> computeImports(Stack<IMappingMetaData> forMappingMetaDatas) {
		List<IMappingMetaData> imports = super.computeImports(forMappingMetaDatas);
		return computeImports(forMappingMetaDatas,imports, EMOFMappingMetaData.INSTANCE);
	}

	@Override
	protected List<IMappingMetaData> computeMerges() {
		List<IMappingMetaData> merges = super.computeMerges();
		merges.add(0, EMOFMappingMetaData.INSTANCE);
		return merges;
	}

	@Override
	public Factory createFactory(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		return new Factory(mappingMetaDataRegistry, this);
	}
	
	@Override
	public String getAdaptingContentTypeIdentifier() {
		return EssentialOCLPackage.eCONTENT_TYPE;
	}

	/**
	 * Recognise and suppress the unsupported TypedElement members.
	 */
	@Override
	public EStructuralFeatureMap<? extends EStructuralFeature> getAdaptingFeatureMap(
			IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EClass adaptingEClass, EStructuralFeature adaptingFeature) {
		if (adaptingEClass.isSuperTypeOf(EssentialOCLPackage.Literals.EXPRESSION_IN_OCL)) {
			if ((adaptingFeature == EMOFPackage.Literals.TYPED_ELEMENT__TYPE))
				return null;
			if ((adaptingFeature == EMOFPackage.Literals.ELEMENT__OWNED_COMMENT))
				return null;
		}
		return super.getAdaptingFeatureMap(mappingMetaDataRegistry, adaptingEClass, adaptingFeature);
	}
	
	@Override
	public Resource.Factory getAdaptingResourceFactory(IMappingMetaDataRegistry mappingMetaDataRegistry) {
		return new EssentialOCLResourceFactoryImpl(mappingMetaDataRegistry);
	}
	
	@Override
	public String getEcoreContentTypeIdentifier() {
		return org.eclipse.ocl.ecore.EcorePackage.eCONTENT_TYPE;
	}

	/**
	 * Recognise and suppress the gratuitous ETypedElement members.
	 */
	@Override
	public EStructuralFeatureMap<? extends EStructuralFeature> getEcoreFeatureMap(
			IMappingMetaDataRegistry.Install mappingMetaDataRegistry, EClass ecoreEClass, EStructuralFeature ecoreFeature) {
		if ((ecoreFeature == EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND)
		 || (ecoreFeature == EcorePackage.Literals.ETYPED_ELEMENT__ORDERED)
		 || (ecoreFeature == EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE)
		 || (ecoreFeature == EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND)) {
			if (isNotMultiplicityElement(ecoreEClass)) {
				return null;
			}
		}
		return super.getEcoreFeatureMap(mappingMetaDataRegistry, ecoreEClass, ecoreFeature);
	}

	@Override
	public void initialize(IMappingMetaDataRegistry.Install mappingMetaDataRegistry) {
		EcoreEnvironmentFactory.INSTANCE.createEnvironment().getOCLStandardLibrary();	// Initialise OCL Standard Library
		//
		//	Non-essential MDT OCL
		//
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.ELEMENT_TYPE, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.MESSAGE_TYPE, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.TYPE_TYPE, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.CALL_OPERATION_ACTION, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.CONSTRAINT, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.SEND_SIGNAL_ACTION, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.ASSOCIATION_CLASS_CALL_EXP, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.MESSAGE_EXP, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.STATE_EXP, null));
		mappingMetaDataRegistry.install(new EClassMap.Direct(this, org.eclipse.ocl.ecore.EcorePackage.Literals.UNSPECIFIED_VALUE_EXP, null));
//	    mappingMetaDataRegistry.install(new EClassMap.Direct(this, null, EssentialOCLPackage.Literals.OPAQUE_EXPRESSION));
		
		mappingMetaDataRegistry.installFeatureToFeatureMap(ExpressionsPackage.Literals.FEATURE_CALL_EXP__MARKED_PRE, null);
		mappingMetaDataRegistry.installFeatureToFeatureMap(ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__NAVIGATION_SOURCE, null);
		mappingMetaDataRegistry.installFeatureToFeatureMap(ExpressionsPackage.Literals.NAVIGATION_CALL_EXP__QUALIFIER, null);

		//
		//	MDT OCL to EMOF
	    //
	    //	Must convert PrimitiveType to EDataType/PrimitiveType 
	    //
		mappingMetaDataRegistry.removeEcoreEClassMap(EcorePackage.Literals.EDATA_TYPE);
		mappingMetaDataRegistry.removeAdaptingEClassMap(EMOFPackage.Literals.PRIMITIVE_TYPE);
	    EClassMap primitiveTypeClassMap = mappingMetaDataRegistry.install(new EClassMap.Direct(this,
	    		org.eclipse.ocl.ecore.EcorePackage.Literals.PRIMITIVE_TYPE,
	    		EMOFPackage.Literals.PRIMITIVE_TYPE));
	    mappingMetaDataRegistry.putEcoreEClassMap(EcorePackage.Literals.EDATA_TYPE, primitiveTypeClassMap);
	    //
	    // Must resolve imported properties to determine EAttribute or EReference
	    //
	    mappingMetaDataRegistry.install(new EReferenceToPropertyMap(mappingMetaDataRegistry,
		    EcoreFeatureElement.create(ExpressionsPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY),
		    EcoreFeatureElement.create(EssentialOCLPackage.Literals.PROPERTY_CALL_EXP__REFERRED_PROPERTY))
		   );    
	    //
	    //	MDT OCL to Essential OCL
	    //
	    //	Use an extension to represent TypeType.referredType
		mappingMetaDataRegistry.installFeatureToExtensionAttributeOrElementMap(TypesPackage.Literals.TYPE_TYPE__REFERRED_TYPE);
	    // MDT OCL ExpressionInOCL is abstract and not a TypedElement
	    mappingMetaDataRegistry.installClassPair(this, org.eclipse.ocl.ecore.EcorePackage.Literals.EXPRESSION_IN_OCL, EssentialOCLPackage.Literals.EXPRESSION_IN_OCL);	    
	    // UnlimitedNaturalLiteralExp.integerSymbol <=> UnlimitedNaturalExp.symbol
	    mappingMetaDataRegistry.installFeatureToFeatureMap(ExpressionsPackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP__INTEGER_SYMBOL, EssentialOCLPackage.Literals.UNLIMITED_NATURAL_EXP__SYMBOL);
	    // UnlimitedNaturalLiteralExp <=> UnlimitedNaturalExp
	    mappingMetaDataRegistry.installClassPair(this, org.eclipse.ocl.ecore.EcorePackage.Literals.UNLIMITED_NATURAL_LITERAL_EXP, EssentialOCLPackage.Literals.UNLIMITED_NATURAL_EXP);
	    //
	    // Everything else is regularly same-named
	    //
	    mappingMetaDataRegistry.installPackagePair(this, org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, EssentialOCLPackage.eINSTANCE);
	}

	protected void installPackage(ResourceSet resourceSet, EPackage ePackage) {
		EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
		packageRegistry.put(ePackage.getNsURI(), ePackage);
	}

	/**
	 * Return true if ecoreEClass is a derivation of ETypedElement corresponding to a TypedElement
	 * that is not also a derivation of MultiplicityElement.
	 * 
	 * @param ecoreEClass
	 * @return
	 */
	protected boolean isNotMultiplicityElement(EClass ecoreEClass) {
		return ExpressionsPackage.Literals.COLLECTION_LITERAL_PART.isSuperTypeOf(ecoreEClass)
			|| ExpressionsPackage.Literals.OCL_EXPRESSION.isSuperTypeOf(ecoreEClass)
			|| ExpressionsPackage.Literals.TUPLE_LITERAL_PART.isSuperTypeOf(ecoreEClass)
			|| ExpressionsPackage.Literals.VARIABLE.isSuperTypeOf(ecoreEClass);
	}
}