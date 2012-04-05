/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTcCSTSwitch.java,v 1.1 2008/07/23 10:06:42 qglineur Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.qvt.declarative.parser.environment.IHasName;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.PatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizeableVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS;

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
 * @see org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage
 * @generated
 */
public class QVTcCSTSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTcCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTcCSTPackage.eINSTANCE;
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
			case QVTcCSTPackage.AREA_CS: {
				AreaCS areaCS = (AreaCS)theEObject;
				T result = caseAreaCS(areaCS);
				if (result == null) result = caseIdentifiedCS(areaCS);
				if (result == null) result = caseCSTNode(areaCS);
				if (result == null) result = caseIHasName(areaCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.ASSIGNMENT_CS: {
				AssignmentCS assignmentCS = (AssignmentCS)theEObject;
				T result = caseAssignmentCS(assignmentCS);
				if (result == null) result = caseOCLExpressionCS(assignmentCS);
				if (result == null) result = caseCSTNode(assignmentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.BOTTOM_PATTERN_CS: {
				BottomPatternCS bottomPatternCS = (BottomPatternCS)theEObject;
				T result = caseBottomPatternCS(bottomPatternCS);
				if (result == null) result = casePatternCS(bottomPatternCS);
				if (result == null) result = caseCSTNode(bottomPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.DIRECTION_CS: {
				DirectionCS directionCS = (DirectionCS)theEObject;
				T result = caseDirectionCS(directionCS);
				if (result == null) result = caseIdentifiedCS(directionCS);
				if (result == null) result = caseCSTNode(directionCS);
				if (result == null) result = caseIHasName(directionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.DOMAIN_CS: {
				DomainCS domainCS = (DomainCS)theEObject;
				T result = caseDomainCS(domainCS);
				if (result == null) result = caseAreaCS(domainCS);
				if (result == null) result = caseIdentifiedCS(domainCS);
				if (result == null) result = caseCSTNode(domainCS);
				if (result == null) result = caseIHasName(domainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.ENFORCEMENT_OPERATION_CS: {
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)theEObject;
				T result = caseEnforcementOperationCS(enforcementOperationCS);
				if (result == null) result = caseCSTNode(enforcementOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.GUARD_PATTERN_CS: {
				GuardPatternCS guardPatternCS = (GuardPatternCS)theEObject;
				T result = caseGuardPatternCS(guardPatternCS);
				if (result == null) result = casePatternCS(guardPatternCS);
				if (result == null) result = caseCSTNode(guardPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.MAPPING_CS: {
				MappingCS mappingCS = (MappingCS)theEObject;
				T result = caseMappingCS(mappingCS);
				if (result == null) result = caseIdentifiedCS(mappingCS);
				if (result == null) result = caseCSTNode(mappingCS);
				if (result == null) result = caseIHasName(mappingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.PARAM_DECLARATION_CS: {
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)theEObject;
				T result = caseParamDeclarationCS(paramDeclarationCS);
				if (result == null) result = caseCSTNode(paramDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.PATTERN_CS: {
				PatternCS patternCS = (PatternCS)theEObject;
				T result = casePatternCS(patternCS);
				if (result == null) result = caseCSTNode(patternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.QUERY_CS: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseCSTNode(queryCS);
				if (result == null) result = caseIHasName(queryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.REALIZEABLE_VARIABLE_CS: {
				RealizeableVariableCS realizeableVariableCS = (RealizeableVariableCS)theEObject;
				T result = caseRealizeableVariableCS(realizeableVariableCS);
				if (result == null) result = caseIdentifiedCS(realizeableVariableCS);
				if (result == null) result = caseCSTNode(realizeableVariableCS);
				if (result == null) result = caseIHasName(realizeableVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.REALIZED_VARIABLE_CS: {
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)theEObject;
				T result = caseRealizedVariableCS(realizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(realizedVariableCS);
				if (result == null) result = caseIdentifiedCS(realizedVariableCS);
				if (result == null) result = caseCSTNode(realizedVariableCS);
				if (result == null) result = caseIHasName(realizedVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.TOP_LEVEL_CS: {
				TopLevelCS topLevelCS = (TopLevelCS)theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null) result = caseCSTNode(topLevelCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.TRANSFORMATION_CS: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = caseCSTNode(transformationCS);
				if (result == null) result = caseIHasName(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcCSTPackage.UNREALIZED_VARIABLE_CS: {
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)theEObject;
				T result = caseUnrealizedVariableCS(unrealizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(unrealizedVariableCS);
				if (result == null) result = caseIdentifiedCS(unrealizedVariableCS);
				if (result == null) result = caseCSTNode(unrealizedVariableCS);
				if (result == null) result = caseIHasName(unrealizedVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Area CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Area CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAreaCS(AreaCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentCS(AssignmentCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bottom Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bottom Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBottomPatternCS(BottomPatternCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direction CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direction CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectionCS(DirectionCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCS(MappingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamDeclarationCS(ParamDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternCS(PatternCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryCS(QueryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realizeable Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realizeable Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealizeableVariableCS(RealizeableVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Level CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLevelCS(TopLevelCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationCS(TransformationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unrealized Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unrealized Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnrealizedVariableCS(UnrealizedVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enforcement Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enforcement Operation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnforcementOperationCS(EnforcementOperationCS object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHas Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHas Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIHasName(IHasName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identified CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identified CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiedCS(IdentifiedCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainCS(DomainCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardPatternCS(GuardPatternCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Realized Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realized Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealizedVariableCS(RealizedVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTNode(CSTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpressionCS(OCLExpressionCS object) {
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

} //EqvtcCSTSwitch
