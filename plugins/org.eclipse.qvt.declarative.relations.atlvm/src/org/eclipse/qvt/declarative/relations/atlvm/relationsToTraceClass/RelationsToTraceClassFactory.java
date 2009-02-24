/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassFactory.java,v 1.2 2009/02/24 17:31:29 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage
 * @generated
 */
public interface RelationsToTraceClassFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationsToTraceClassFactory eINSTANCE = org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>TTransformation To Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TTransformation To Package</em>'.
	 * @generated
	 */
	TTransformationToPackage createTTransformationToPackage();

	/**
	 * Returns a new object of class '<em>TRelation To Trace Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TRelation To Trace Class</em>'.
	 * @generated
	 */
	TRelationToTraceClass createTRelationToTraceClass();

	/**
	 * Returns a new object of class '<em>TSub Template To Trace Class Props</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TSub Template To Trace Class Props</em>'.
	 * @generated
	 */
	TSubTemplateToTraceClassProps createTSubTemplateToTraceClassProps();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RelationsToTraceClassPackage getRelationsToTraceClassPackage();

} //RelationsToTraceClassFactory
