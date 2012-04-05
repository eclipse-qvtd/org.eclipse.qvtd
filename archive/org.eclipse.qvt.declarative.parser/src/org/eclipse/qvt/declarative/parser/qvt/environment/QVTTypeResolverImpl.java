/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvt.environment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractTypeResolver;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.qvt.declarative.parser.utils.OCLUtils;

@SuppressWarnings("restriction")		// FIXME awaiting Bugzilla 182994
public class QVTTypeResolverImpl extends AbstractTypeResolver<EPackage, EClassifier, EOperation, EStructuralFeature, EParameter>
{	// FIXME derive from org.eclipse.ocl.ecore.TypeResolverImpl and eliminate TupleFactory once bugzilla 182994 resolved
	private EPackage orphanPackage = null;
	
	/**
     * Initializes me with an environment.  I create my own resource for
     * persistence of model-based types.
     * 
     * @param env the environment that I persist
     */
	public QVTTypeResolverImpl(IQVTEnvironment env) {
		super(env);
	}
	
    /**
     * Initializes me with a resource in which I will persist the model-based
     * types that I generate in my associated {@link Environment}.
     * 
     * @param env my environment
     * @param resource my resource
     */
	public QVTTypeResolverImpl(IQVTEnvironment env, Resource resource) {
		super(env, resource);
	}
    
    // Documentation copied from the inherited implementation
    @Override protected Resource createResource() {
		throw new UnsupportedOperationException(getClass().getName() + ".createResource");
	}
    
    // Documentation copied from the inherited implementation
    @Override
    protected EPackage createTuplePackage() {
        EPackage result = super.createTuplePackage();
        
        result.setEFactoryInstance(new TupleFactory());
        
        return result;
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected EPackage createPackage(String name) {
    	if (orphanPackage == null) {
    		orphanPackage = EcoreFactory.eINSTANCE.createEPackage();
    		orphanPackage.setName(OCLUtils.OCL_ORPHANS_PACKAGE_NAME);
    	}
        return orphanPackage;
    }
    
    // Documentation copied from the inherited specification
    @Override
	protected EPackage findPackage(String name) {
		return orphanPackage;
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected void addClassifier(EPackage pkg, EClassifier classifier) {
        pkg.getEClassifiers().add(classifier);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addOperation(EClassifier owner, EOperation operation) {
        ((EClass) owner).getEOperations().add(operation);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addProperty(EClassifier owner, EStructuralFeature property) {
        ((EClass) owner).getEStructuralFeatures().add(property);
    }
	
//    @Override
//	protected CollectionType<EClassifier, EOperation> createCollectionType(
//			CollectionKind kind, EClassifier elementType) {
//		if ((kind == CollectionKind.SET_LITERAL) && "Key".equals(elementType.getName()))
//			return super.createCollectionType(kind, elementType);
//		else
//			return super.createCollectionType(kind, elementType);
//	}

	// Documentation copied from the inherited specification
    @Override
	protected EClass createShadowClass(EClassifier type) {
		return OCLStandardLibraryImpl.createShadowClass(type);
	}
    
	@Override
	protected TypeType<EClassifier, EOperation> createTypeType(EClassifier type) {
		TypeType<EClassifier, EOperation> typeType = super.createTypeType(type);
		if ((typeType instanceof ENamedElement) && TypeType.SINGLETON_NAME.equals(typeType.getName()))
			((ENamedElement) typeType).setName(type.getName()); 		// FIXME workaround for Bugzilla 213274
		return typeType;
	}

	private TypeType<EClassifier, EOperation> oclTypeType = null;
	@Override
	protected TypeType<EClassifier, EOperation> findTypeType(EClassifier type) {
    	if (type instanceof AnyType) {
    		if (oclTypeType == null) {
        		EClassifier oclType = getEnvironment().getOCLStandardLibrary().getOclType();
        		@SuppressWarnings("unchecked")
    			TypeType<EClassifier, EOperation> castOclTypeType = (TypeType<EClassifier, EOperation>) oclType;
        		oclTypeType = castOclTypeType;
    		}
    		if (type == oclTypeType.getReferredType())
        		return oclTypeType;					// Workaround 226455
    	}
		return super.findTypeType(type);
	}

	public EPackage getOrphanPackage() {
		return orphanPackage;
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected EClassifier getShadowedClassifier(EClassifier shadow) {
        if (shadow instanceof EClass) {
            return OCLStandardLibraryImpl.getRealClassifier((EClass) shadow);
        }
        
        return null;
	}
}
