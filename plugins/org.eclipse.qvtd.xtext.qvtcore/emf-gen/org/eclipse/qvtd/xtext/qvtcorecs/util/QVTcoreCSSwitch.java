/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ModelElementCS;
import org.eclipse.ocl.xtext.basecs.NamedElementCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.ocl.xtext.basecs.RootCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.TemplateableElementCS;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.TypedElementCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;
import org.eclipse.qvtd.xtext.qvtcorecs.*;

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
 * @see org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage
 * @generated
 */
public class QVTcoreCSSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTcoreCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreCSSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTcoreCSPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case 0: {
				AreaCS areaCS = (AreaCS)theEObject;
				T result = caseAreaCS(areaCS);
				if (result == null) result = caseNamedElementCS(areaCS);
				if (result == null) result = caseModelElementCS(areaCS);
				if (result == null) result = casePivotableElementCS(areaCS);
				if (result == null) result = caseElementCS(areaCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 1: {
				BottomPatternCS bottomPatternCS = (BottomPatternCS)theEObject;
				T result = caseBottomPatternCS(bottomPatternCS);
				if (result == null) result = casePatternCS(bottomPatternCS);
				if (result == null) result = caseModelElementCS(bottomPatternCS);
				if (result == null) result = casePivotableElementCS(bottomPatternCS);
				if (result == null) result = caseElementCS(bottomPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 2: {
				DirectionCS directionCS = (DirectionCS)theEObject;
				T result = caseDirectionCS(directionCS);
				if (result == null) result = caseNamedElementCS(directionCS);
				if (result == null) result = caseModelElementCS(directionCS);
				if (result == null) result = casePivotableElementCS(directionCS);
				if (result == null) result = caseElementCS(directionCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 3: {
				DomainCS domainCS = (DomainCS)theEObject;
				T result = caseDomainCS(domainCS);
				if (result == null) result = caseAreaCS(domainCS);
				if (result == null) result = caseNamedElementCS(domainCS);
				if (result == null) result = caseModelElementCS(domainCS);
				if (result == null) result = casePivotableElementCS(domainCS);
				if (result == null) result = caseElementCS(domainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 4: {
				EnforcementOperationCS enforcementOperationCS = (EnforcementOperationCS)theEObject;
				T result = caseEnforcementOperationCS(enforcementOperationCS);
				if (result == null) result = caseModelElementCS(enforcementOperationCS);
				if (result == null) result = casePivotableElementCS(enforcementOperationCS);
				if (result == null) result = caseElementCS(enforcementOperationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 5: {
				GuardPatternCS guardPatternCS = (GuardPatternCS)theEObject;
				T result = caseGuardPatternCS(guardPatternCS);
				if (result == null) result = casePatternCS(guardPatternCS);
				if (result == null) result = caseModelElementCS(guardPatternCS);
				if (result == null) result = casePivotableElementCS(guardPatternCS);
				if (result == null) result = caseElementCS(guardPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 6: {
				MappingCS mappingCS = (MappingCS)theEObject;
				T result = caseMappingCS(mappingCS);
				if (result == null) result = caseNamedElementCS(mappingCS);
				if (result == null) result = caseModelElementCS(mappingCS);
				if (result == null) result = casePivotableElementCS(mappingCS);
				if (result == null) result = caseElementCS(mappingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 7: {
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)theEObject;
				T result = caseParamDeclarationCS(paramDeclarationCS);
				if (result == null) result = caseTypedElementCS(paramDeclarationCS);
				if (result == null) result = caseNamedElementCS(paramDeclarationCS);
				if (result == null) result = caseModelElementCS(paramDeclarationCS);
				if (result == null) result = casePivotableElementCS(paramDeclarationCS);
				if (result == null) result = caseElementCS(paramDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 8: {
				PatternCS patternCS = (PatternCS)theEObject;
				T result = casePatternCS(patternCS);
				if (result == null) result = caseModelElementCS(patternCS);
				if (result == null) result = casePivotableElementCS(patternCS);
				if (result == null) result = caseElementCS(patternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 9: {
				PredicateCS predicateCS = (PredicateCS)theEObject;
				T result = casePredicateCS(predicateCS);
				if (result == null) result = caseExpCS(predicateCS);
				if (result == null) result = caseModelElementCS(predicateCS);
				if (result == null) result = casePivotableElementCS(predicateCS);
				if (result == null) result = caseElementCS(predicateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 10: {
				PredicateOrAssignmentCS predicateOrAssignmentCS = (PredicateOrAssignmentCS)theEObject;
				T result = casePredicateOrAssignmentCS(predicateOrAssignmentCS);
				if (result == null) result = caseExpCS(predicateOrAssignmentCS);
				if (result == null) result = caseModelElementCS(predicateOrAssignmentCS);
				if (result == null) result = casePivotableElementCS(predicateOrAssignmentCS);
				if (result == null) result = caseElementCS(predicateOrAssignmentCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 11: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseTypedElementCS(queryCS);
				if (result == null) result = caseJavaImplementationCS(queryCS);
				if (result == null) result = caseNamedElementCS(queryCS);
				if (result == null) result = caseModelElementCS(queryCS);
				if (result == null) result = casePivotableElementCS(queryCS);
				if (result == null) result = caseElementCS(queryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 12: {
				RealizeableVariableCS realizeableVariableCS = (RealizeableVariableCS)theEObject;
				T result = caseRealizeableVariableCS(realizeableVariableCS);
				if (result == null) result = caseTypedElementCS(realizeableVariableCS);
				if (result == null) result = caseNamedElementCS(realizeableVariableCS);
				if (result == null) result = caseModelElementCS(realizeableVariableCS);
				if (result == null) result = casePivotableElementCS(realizeableVariableCS);
				if (result == null) result = caseElementCS(realizeableVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 13: {
				RealizedVariableCS realizedVariableCS = (RealizedVariableCS)theEObject;
				T result = caseRealizedVariableCS(realizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(realizedVariableCS);
				if (result == null) result = caseTypedElementCS(realizedVariableCS);
				if (result == null) result = caseNamedElementCS(realizedVariableCS);
				if (result == null) result = caseModelElementCS(realizedVariableCS);
				if (result == null) result = casePivotableElementCS(realizedVariableCS);
				if (result == null) result = caseElementCS(realizedVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 14: {
				TopLevelCS topLevelCS = (TopLevelCS)theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null) result = caseRootPackageCS(topLevelCS);
				if (result == null) result = casePackageOwnerCS(topLevelCS);
				if (result == null) result = caseRootCS(topLevelCS);
				if (result == null) result = caseModelElementCS(topLevelCS);
				if (result == null) result = casePivotableElementCS(topLevelCS);
				if (result == null) result = caseElementCS(topLevelCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 15: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = caseAbstractTransformationCS(transformationCS);
				if (result == null) result = caseClassCS(transformationCS);
				if (result == null) result = caseNamedElementCS(transformationCS);
				if (result == null) result = caseTypeCS(transformationCS);
				if (result == null) result = caseTemplateableElementCS(transformationCS);
				if (result == null) result = caseModelElementCS(transformationCS);
				if (result == null) result = casePivotableElementCS(transformationCS);
				if (result == null) result = caseElementCS(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case 16: {
				UnrealizedVariableCS unrealizedVariableCS = (UnrealizedVariableCS)theEObject;
				T result = caseUnrealizedVariableCS(unrealizedVariableCS);
				if (result == null) result = caseRealizeableVariableCS(unrealizedVariableCS);
				if (result == null) result = caseTypedElementCS(unrealizedVariableCS);
				if (result == null) result = caseNamedElementCS(unrealizedVariableCS);
				if (result == null) result = caseModelElementCS(unrealizedVariableCS);
				if (result == null) result = casePivotableElementCS(unrealizedVariableCS);
				if (result == null) result = caseElementCS(unrealizedVariableCS);
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
	 * Returns the result of interpreting the object as an instance of '<em>Predicate CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateCS(PredicateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate Or Assignment CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate Or Assignment CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateOrAssignmentCS(PredicateOrAssignmentCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Java Implementation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Implementation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaImplementationCS(JavaImplementationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Owner CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Owner CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageOwnerCS(PackageOwnerCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootPackageCS(RootPackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCS(TypeCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Templateable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateableElementCS(TemplateableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassCS(ClassCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Transformation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractTransformationCS(AbstractTransformationCS object) {
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

} //QVTcoreCSTSwitch
