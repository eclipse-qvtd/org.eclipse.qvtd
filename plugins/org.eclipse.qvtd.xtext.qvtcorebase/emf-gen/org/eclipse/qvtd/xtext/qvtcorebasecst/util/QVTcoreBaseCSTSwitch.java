/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorebasecst.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS;

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
 * @see org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage
 * @generated
 */
public class QVTcoreBaseCSTSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTcoreBaseCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreBaseCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTcoreBaseCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTcoreBaseCSTPackage.ABSTRACT_MAPPING_CS: {
				AbstractMappingCS abstractMappingCS = (AbstractMappingCS)theEObject;
				T result = caseAbstractMappingCS(abstractMappingCS);
				if (result == null) result = caseNamedElementCS(abstractMappingCS);
				if (result == null) result = caseModelElementCS(abstractMappingCS);
				if (result == null) result = caseNameable(abstractMappingCS);
				if (result == null) result = casePivotableElementCS(abstractMappingCS);
				if (result == null) result = caseElementCS(abstractMappingCS);
				if (result == null) result = casePivotable(abstractMappingCS);
				if (result == null) result = caseVisitableCS(abstractMappingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.AREA_CS: {
				AreaCS areaCS = (AreaCS)theEObject;
				T result = caseAreaCS(areaCS);
				if (result == null) result = caseNamedElementCS(areaCS);
				if (result == null) result = caseModelElementCS(areaCS);
				if (result == null) result = caseNameable(areaCS);
				if (result == null) result = casePivotableElementCS(areaCS);
				if (result == null) result = caseElementCS(areaCS);
				if (result == null) result = casePivotable(areaCS);
				if (result == null) result = caseVisitableCS(areaCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.ASSIGNMENT_CS: {
				AssignmentCS assignmentCS = (AssignmentCS)theEObject;
				T result = caseAssignmentCS(assignmentCS);
				if (result == null) result = caseExpCS(assignmentCS);
				if (result == null) result = caseModelElementCS(assignmentCS);
				if (result == null) result = casePivotableElementCS(assignmentCS);
				if (result == null) result = caseElementCS(assignmentCS);
				if (result == null) result = casePivotable(assignmentCS);
				if (result == null) result = caseVisitableCS(assignmentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.BOTTOM_PATTERN_CS: {
				BottomPatternCS bottomPatternCS = (BottomPatternCS)theEObject;
				T result = caseBottomPatternCS(bottomPatternCS);
				if (result == null) result = casePatternCS(bottomPatternCS);
				if (result == null) result = caseModelElementCS(bottomPatternCS);
				if (result == null) result = casePivotableElementCS(bottomPatternCS);
				if (result == null) result = caseElementCS(bottomPatternCS);
				if (result == null) result = casePivotable(bottomPatternCS);
				if (result == null) result = caseVisitableCS(bottomPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.DIRECTION_CS: {
				DirectionCS directionCS = (DirectionCS)theEObject;
				T result = caseDirectionCS(directionCS);
				if (result == null) result = caseNamedElementCS(directionCS);
				if (result == null) result = caseModelElementCS(directionCS);
				if (result == null) result = caseNameable(directionCS);
				if (result == null) result = casePivotableElementCS(directionCS);
				if (result == null) result = caseElementCS(directionCS);
				if (result == null) result = casePivotable(directionCS);
				if (result == null) result = caseVisitableCS(directionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.DOMAIN_CS: {
				DomainCS domainCS = (DomainCS)theEObject;
				T result = caseDomainCS(domainCS);
				if (result == null) result = caseAreaCS(domainCS);
				if (result == null) result = caseNamedElementCS(domainCS);
				if (result == null) result = caseModelElementCS(domainCS);
				if (result == null) result = caseNameable(domainCS);
				if (result == null) result = casePivotableElementCS(domainCS);
				if (result == null) result = caseElementCS(domainCS);
				if (result == null) result = casePivotable(domainCS);
				if (result == null) result = caseVisitableCS(domainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS: {
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)theEObject;
				T result = caseEnforcementOperationCS(enforcementOperationCS);
				if (result == null) result = caseModelElementCS(enforcementOperationCS);
				if (result == null) result = casePivotableElementCS(enforcementOperationCS);
				if (result == null) result = caseElementCS(enforcementOperationCS);
				if (result == null) result = casePivotable(enforcementOperationCS);
				if (result == null) result = caseVisitableCS(enforcementOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.GUARD_PATTERN_CS: {
				GuardPatternCS guardPatternCS = (GuardPatternCS)theEObject;
				T result = caseGuardPatternCS(guardPatternCS);
				if (result == null) result = casePatternCS(guardPatternCS);
				if (result == null) result = caseModelElementCS(guardPatternCS);
				if (result == null) result = casePivotableElementCS(guardPatternCS);
				if (result == null) result = caseElementCS(guardPatternCS);
				if (result == null) result = casePivotable(guardPatternCS);
				if (result == null) result = caseVisitableCS(guardPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.PARAM_DECLARATION_CS: {
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)theEObject;
				T result = caseParamDeclarationCS(paramDeclarationCS);
				if (result == null) result = caseTypedElementCS(paramDeclarationCS);
				if (result == null) result = caseNamedElementCS(paramDeclarationCS);
				if (result == null) result = caseModelElementCS(paramDeclarationCS);
				if (result == null) result = caseNameable(paramDeclarationCS);
				if (result == null) result = casePivotableElementCS(paramDeclarationCS);
				if (result == null) result = caseElementCS(paramDeclarationCS);
				if (result == null) result = casePivotable(paramDeclarationCS);
				if (result == null) result = caseVisitableCS(paramDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.PATTERN_CS: {
				PatternCS patternCS = (PatternCS)theEObject;
				T result = casePatternCS(patternCS);
				if (result == null) result = caseModelElementCS(patternCS);
				if (result == null) result = casePivotableElementCS(patternCS);
				if (result == null) result = caseElementCS(patternCS);
				if (result == null) result = casePivotable(patternCS);
				if (result == null) result = caseVisitableCS(patternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.QUERY_CS: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseTypedElementCS(queryCS);
				if (result == null) result = caseNamedElementCS(queryCS);
				if (result == null) result = caseModelElementCS(queryCS);
				if (result == null) result = caseNameable(queryCS);
				if (result == null) result = casePivotableElementCS(queryCS);
				if (result == null) result = caseElementCS(queryCS);
				if (result == null) result = casePivotable(queryCS);
				if (result == null) result = caseVisitableCS(queryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.REALIZEABLE_VARIABLE_CS: {
				RealizeableVariableCS realizeableVariableCS = (RealizeableVariableCS)theEObject;
				T result = caseRealizeableVariableCS(realizeableVariableCS);
				if (result == null) result = caseTypedElementCS(realizeableVariableCS);
				if (result == null) result = caseNamedElementCS(realizeableVariableCS);
				if (result == null) result = caseModelElementCS(realizeableVariableCS);
				if (result == null) result = caseNameable(realizeableVariableCS);
				if (result == null) result = casePivotableElementCS(realizeableVariableCS);
				if (result == null) result = caseElementCS(realizeableVariableCS);
				if (result == null) result = casePivotable(realizeableVariableCS);
				if (result == null) result = caseVisitableCS(realizeableVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.REALIZED_VARIABLE_CS: {
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)theEObject;
				T result = caseRealizedVariableCS(realizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(realizedVariableCS);
				if (result == null) result = caseTypedElementCS(realizedVariableCS);
				if (result == null) result = caseNamedElementCS(realizedVariableCS);
				if (result == null) result = caseModelElementCS(realizedVariableCS);
				if (result == null) result = caseNameable(realizedVariableCS);
				if (result == null) result = casePivotableElementCS(realizedVariableCS);
				if (result == null) result = caseElementCS(realizedVariableCS);
				if (result == null) result = casePivotable(realizedVariableCS);
				if (result == null) result = caseVisitableCS(realizedVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.TRANSFORMATION_CS: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = casePackageCS(transformationCS);
				if (result == null) result = caseNamespaceCS(transformationCS);
				if (result == null) result = caseNamedElementCS(transformationCS);
				if (result == null) result = caseModelElementCS(transformationCS);
				if (result == null) result = caseNameable(transformationCS);
				if (result == null) result = casePivotableElementCS(transformationCS);
				if (result == null) result = caseElementCS(transformationCS);
				if (result == null) result = casePivotable(transformationCS);
				if (result == null) result = caseVisitableCS(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTcoreBaseCSTPackage.UNREALIZED_VARIABLE_CS: {
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)theEObject;
				T result = caseUnrealizedVariableCS(unrealizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(unrealizedVariableCS);
				if (result == null) result = caseTypedElementCS(unrealizedVariableCS);
				if (result == null) result = caseNamedElementCS(unrealizedVariableCS);
				if (result == null) result = caseModelElementCS(unrealizedVariableCS);
				if (result == null) result = caseNameable(unrealizedVariableCS);
				if (result == null) result = casePivotableElementCS(unrealizedVariableCS);
				if (result == null) result = caseElementCS(unrealizedVariableCS);
				if (result == null) result = casePivotable(unrealizedVariableCS);
				if (result == null) result = caseVisitableCS(unrealizedVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Mapping CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Mapping CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractMappingCS(AbstractMappingCS object) {
		return null;
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
	public T caseEnforcementOperationCS(EnforcementOperationCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotableElementCS(PivotableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementCS(TypedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceCS(NamespaceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QVTcoreBaseCSTSwitch
