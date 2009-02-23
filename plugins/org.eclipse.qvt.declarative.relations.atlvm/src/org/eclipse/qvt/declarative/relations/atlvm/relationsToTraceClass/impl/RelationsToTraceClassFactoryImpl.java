/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassFactoryImpl.java,v 1.1 2009/02/23 18:14:57 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationsToTraceClassFactoryImpl extends EFactoryImpl implements RelationsToTraceClassFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationsToTraceClassFactory init() {
		try {
			RelationsToTraceClassFactory theRelationsToTraceClassFactory = (RelationsToTraceClassFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/RelationsToTraceClass"); 
			if (theRelationsToTraceClassFactory != null) {
				return theRelationsToTraceClassFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RelationsToTraceClassFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationsToTraceClassFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS: return createTRelationToTraceClass();
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS: return createTSubTemplateToTraceClassProps();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TRelationToTraceClass createTRelationToTraceClass() {
		TRelationToTraceClassImpl tRelationToTraceClass = new TRelationToTraceClassImpl();
		return tRelationToTraceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TSubTemplateToTraceClassProps createTSubTemplateToTraceClassProps() {
		TSubTemplateToTraceClassPropsImpl tSubTemplateToTraceClassProps = new TSubTemplateToTraceClassPropsImpl();
		return tSubTemplateToTraceClassProps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationsToTraceClassPackage getRelationsToTraceClassPackage() {
		return (RelationsToTraceClassPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RelationsToTraceClassPackage getPackage() {
		return RelationsToTraceClassPackage.eINSTANCE;
	}

} //RelationsToTraceClassFactoryImpl
