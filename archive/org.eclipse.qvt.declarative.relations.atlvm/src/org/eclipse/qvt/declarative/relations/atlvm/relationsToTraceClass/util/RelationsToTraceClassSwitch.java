/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassSwitch.java,v 1.2 2009/02/24 17:31:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage
 * @generated
 */
public class RelationsToTraceClassSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RelationsToTraceClassPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationsToTraceClassSwitch() {
		if (modelPackage == null) {
			modelPackage = RelationsToTraceClassPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RelationsToTraceClassPackage.TTRANSFORMATION_TO_PACKAGE: {
				TTransformationToPackage tTransformationToPackage = (TTransformationToPackage)theEObject;
				T result = caseTTransformationToPackage(tTransformationToPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationsToTraceClassPackage.TRELATION_TO_TRACE_CLASS: {
				TRelationToTraceClass tRelationToTraceClass = (TRelationToTraceClass)theEObject;
				T result = caseTRelationToTraceClass(tRelationToTraceClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RelationsToTraceClassPackage.TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS: {
				TSubTemplateToTraceClassProps tSubTemplateToTraceClassProps = (TSubTemplateToTraceClassProps)theEObject;
				T result = caseTSubTemplateToTraceClassProps(tSubTemplateToTraceClassProps);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTransformation To Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTransformation To Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTransformationToPackage(TTransformationToPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TRelation To Trace Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TRelation To Trace Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTRelationToTraceClass(TRelationToTraceClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TSub Template To Trace Class Props</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TSub Template To Trace Class Props</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTSubTemplateToTraceClassProps(TSubTemplateToTraceClassProps object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //RelationsToTraceClassSwitch
