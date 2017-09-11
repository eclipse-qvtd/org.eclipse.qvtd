/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.Pivotable;
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
import org.eclipse.ocl.xtext.basecs.util.VisitableCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.*;

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
 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage
 * @generated
 */
public class QVTimperativeCSSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTimperativeCSPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeCSSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTimperativeCSPackage.eINSTANCE;
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
			case QVTimperativeCSPackage.ADD_STATEMENT_CS: {
				AddStatementCS addStatementCS = (AddStatementCS)theEObject;
				T result = caseAddStatementCS(addStatementCS);
				if (result == null) result = caseMappingStatementCS(addStatementCS);
				if (result == null) result = caseObservableStatementCS(addStatementCS);
				if (result == null) result = caseStatementCS(addStatementCS);
				if (result == null) result = caseModelElementCS(addStatementCS);
				if (result == null) result = casePivotableElementCS(addStatementCS);
				if (result == null) result = caseElementCS(addStatementCS);
				if (result == null) result = casePivotable(addStatementCS);
				if (result == null) result = caseVisitableCS(addStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.APPEND_PARAMETER_BINDING_CS: {
				AppendParameterBindingCS appendParameterBindingCS = (AppendParameterBindingCS)theEObject;
				T result = caseAppendParameterBindingCS(appendParameterBindingCS);
				if (result == null) result = caseMappingParameterBindingCS(appendParameterBindingCS);
				if (result == null) result = caseExpCS(appendParameterBindingCS);
				if (result == null) result = caseModelElementCS(appendParameterBindingCS);
				if (result == null) result = casePivotableElementCS(appendParameterBindingCS);
				if (result == null) result = caseElementCS(appendParameterBindingCS);
				if (result == null) result = casePivotable(appendParameterBindingCS);
				if (result == null) result = caseVisitableCS(appendParameterBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.APPEND_PARAMETER_CS: {
				AppendParameterCS appendParameterCS = (AppendParameterCS)theEObject;
				T result = caseAppendParameterCS(appendParameterCS);
				if (result == null) result = caseMappingParameterCS(appendParameterCS);
				if (result == null) result = caseTypedElementCS(appendParameterCS);
				if (result == null) result = caseNamedElementCS(appendParameterCS);
				if (result == null) result = caseModelElementCS(appendParameterCS);
				if (result == null) result = caseNameable(appendParameterCS);
				if (result == null) result = casePivotableElementCS(appendParameterCS);
				if (result == null) result = caseElementCS(appendParameterCS);
				if (result == null) result = casePivotable(appendParameterCS);
				if (result == null) result = caseVisitableCS(appendParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.BUFFER_STATEMENT_CS: {
				BufferStatementCS bufferStatementCS = (BufferStatementCS)theEObject;
				T result = caseBufferStatementCS(bufferStatementCS);
				if (result == null) result = caseTypedElementCS(bufferStatementCS);
				if (result == null) result = caseStatementCS(bufferStatementCS);
				if (result == null) result = caseNamedElementCS(bufferStatementCS);
				if (result == null) result = caseModelElementCS(bufferStatementCS);
				if (result == null) result = caseNameable(bufferStatementCS);
				if (result == null) result = casePivotableElementCS(bufferStatementCS);
				if (result == null) result = caseElementCS(bufferStatementCS);
				if (result == null) result = casePivotable(bufferStatementCS);
				if (result == null) result = caseVisitableCS(bufferStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.CHECK_STATEMENT_CS: {
				CheckStatementCS checkStatementCS = (CheckStatementCS)theEObject;
				T result = caseCheckStatementCS(checkStatementCS);
				if (result == null) result = caseObservableStatementCS(checkStatementCS);
				if (result == null) result = caseStatementCS(checkStatementCS);
				if (result == null) result = caseModelElementCS(checkStatementCS);
				if (result == null) result = casePivotableElementCS(checkStatementCS);
				if (result == null) result = caseElementCS(checkStatementCS);
				if (result == null) result = casePivotable(checkStatementCS);
				if (result == null) result = caseVisitableCS(checkStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.DECLARE_STATEMENT_CS: {
				DeclareStatementCS declareStatementCS = (DeclareStatementCS)theEObject;
				T result = caseDeclareStatementCS(declareStatementCS);
				if (result == null) result = caseTypedElementCS(declareStatementCS);
				if (result == null) result = caseObservableStatementCS(declareStatementCS);
				if (result == null) result = caseNamedElementCS(declareStatementCS);
				if (result == null) result = caseStatementCS(declareStatementCS);
				if (result == null) result = caseModelElementCS(declareStatementCS);
				if (result == null) result = caseNameable(declareStatementCS);
				if (result == null) result = casePivotableElementCS(declareStatementCS);
				if (result == null) result = caseElementCS(declareStatementCS);
				if (result == null) result = casePivotable(declareStatementCS);
				if (result == null) result = caseVisitableCS(declareStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.DIRECTION_CS: {
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
			case QVTimperativeCSPackage.GUARD_PARAMETER_BINDING_CS: {
				GuardParameterBindingCS guardParameterBindingCS = (GuardParameterBindingCS)theEObject;
				T result = caseGuardParameterBindingCS(guardParameterBindingCS);
				if (result == null) result = caseMappingParameterBindingCS(guardParameterBindingCS);
				if (result == null) result = caseExpCS(guardParameterBindingCS);
				if (result == null) result = caseModelElementCS(guardParameterBindingCS);
				if (result == null) result = casePivotableElementCS(guardParameterBindingCS);
				if (result == null) result = caseElementCS(guardParameterBindingCS);
				if (result == null) result = casePivotable(guardParameterBindingCS);
				if (result == null) result = caseVisitableCS(guardParameterBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS: {
				GuardParameterCS guardParameterCS = (GuardParameterCS)theEObject;
				T result = caseGuardParameterCS(guardParameterCS);
				if (result == null) result = caseMappingParameterCS(guardParameterCS);
				if (result == null) result = caseTypedElementCS(guardParameterCS);
				if (result == null) result = caseNamedElementCS(guardParameterCS);
				if (result == null) result = caseModelElementCS(guardParameterCS);
				if (result == null) result = caseNameable(guardParameterCS);
				if (result == null) result = casePivotableElementCS(guardParameterCS);
				if (result == null) result = caseElementCS(guardParameterCS);
				if (result == null) result = casePivotable(guardParameterCS);
				if (result == null) result = caseVisitableCS(guardParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.LOOP_PARAMETER_BINDING_CS: {
				LoopParameterBindingCS loopParameterBindingCS = (LoopParameterBindingCS)theEObject;
				T result = caseLoopParameterBindingCS(loopParameterBindingCS);
				if (result == null) result = caseMappingParameterBindingCS(loopParameterBindingCS);
				if (result == null) result = caseExpCS(loopParameterBindingCS);
				if (result == null) result = caseModelElementCS(loopParameterBindingCS);
				if (result == null) result = casePivotableElementCS(loopParameterBindingCS);
				if (result == null) result = caseElementCS(loopParameterBindingCS);
				if (result == null) result = casePivotable(loopParameterBindingCS);
				if (result == null) result = caseVisitableCS(loopParameterBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_CS: {
				MappingCS mappingCS = (MappingCS)theEObject;
				T result = caseMappingCS(mappingCS);
				if (result == null) result = caseNamedElementCS(mappingCS);
				if (result == null) result = caseModelElementCS(mappingCS);
				if (result == null) result = caseNameable(mappingCS);
				if (result == null) result = casePivotableElementCS(mappingCS);
				if (result == null) result = caseElementCS(mappingCS);
				if (result == null) result = casePivotable(mappingCS);
				if (result == null) result = caseVisitableCS(mappingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_CALL_CS: {
				MappingCallCS mappingCallCS = (MappingCallCS)theEObject;
				T result = caseMappingCallCS(mappingCallCS);
				if (result == null) result = caseMappingStatementCS(mappingCallCS);
				if (result == null) result = caseStatementCS(mappingCallCS);
				if (result == null) result = caseModelElementCS(mappingCallCS);
				if (result == null) result = casePivotableElementCS(mappingCallCS);
				if (result == null) result = caseElementCS(mappingCallCS);
				if (result == null) result = casePivotable(mappingCallCS);
				if (result == null) result = caseVisitableCS(mappingCallCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_LOOP_CS: {
				MappingLoopCS mappingLoopCS = (MappingLoopCS)theEObject;
				T result = caseMappingLoopCS(mappingLoopCS);
				if (result == null) result = caseMappingStatementCS(mappingLoopCS);
				if (result == null) result = caseObservableStatementCS(mappingLoopCS);
				if (result == null) result = caseStatementCS(mappingLoopCS);
				if (result == null) result = caseModelElementCS(mappingLoopCS);
				if (result == null) result = casePivotableElementCS(mappingLoopCS);
				if (result == null) result = caseElementCS(mappingLoopCS);
				if (result == null) result = casePivotable(mappingLoopCS);
				if (result == null) result = caseVisitableCS(mappingLoopCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_PARAMETER_CS: {
				MappingParameterCS mappingParameterCS = (MappingParameterCS)theEObject;
				T result = caseMappingParameterCS(mappingParameterCS);
				if (result == null) result = caseTypedElementCS(mappingParameterCS);
				if (result == null) result = caseNamedElementCS(mappingParameterCS);
				if (result == null) result = caseModelElementCS(mappingParameterCS);
				if (result == null) result = caseNameable(mappingParameterCS);
				if (result == null) result = casePivotableElementCS(mappingParameterCS);
				if (result == null) result = caseElementCS(mappingParameterCS);
				if (result == null) result = casePivotable(mappingParameterCS);
				if (result == null) result = caseVisitableCS(mappingParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_PARAMETER_BINDING_CS: {
				MappingParameterBindingCS mappingParameterBindingCS = (MappingParameterBindingCS)theEObject;
				T result = caseMappingParameterBindingCS(mappingParameterBindingCS);
				if (result == null) result = caseExpCS(mappingParameterBindingCS);
				if (result == null) result = caseModelElementCS(mappingParameterBindingCS);
				if (result == null) result = casePivotableElementCS(mappingParameterBindingCS);
				if (result == null) result = caseElementCS(mappingParameterBindingCS);
				if (result == null) result = casePivotable(mappingParameterBindingCS);
				if (result == null) result = caseVisitableCS(mappingParameterBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.MAPPING_STATEMENT_CS: {
				MappingStatementCS mappingStatementCS = (MappingStatementCS)theEObject;
				T result = caseMappingStatementCS(mappingStatementCS);
				if (result == null) result = caseStatementCS(mappingStatementCS);
				if (result == null) result = caseModelElementCS(mappingStatementCS);
				if (result == null) result = casePivotableElementCS(mappingStatementCS);
				if (result == null) result = caseElementCS(mappingStatementCS);
				if (result == null) result = casePivotable(mappingStatementCS);
				if (result == null) result = caseVisitableCS(mappingStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.NEW_STATEMENT_CS: {
				NewStatementCS newStatementCS = (NewStatementCS)theEObject;
				T result = caseNewStatementCS(newStatementCS);
				if (result == null) result = caseTypedElementCS(newStatementCS);
				if (result == null) result = caseObservableStatementCS(newStatementCS);
				if (result == null) result = caseNamedElementCS(newStatementCS);
				if (result == null) result = caseStatementCS(newStatementCS);
				if (result == null) result = caseModelElementCS(newStatementCS);
				if (result == null) result = caseNameable(newStatementCS);
				if (result == null) result = casePivotableElementCS(newStatementCS);
				if (result == null) result = caseElementCS(newStatementCS);
				if (result == null) result = casePivotable(newStatementCS);
				if (result == null) result = caseVisitableCS(newStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.OBSERVABLE_STATEMENT_CS: {
				ObservableStatementCS observableStatementCS = (ObservableStatementCS)theEObject;
				T result = caseObservableStatementCS(observableStatementCS);
				if (result == null) result = caseStatementCS(observableStatementCS);
				if (result == null) result = caseModelElementCS(observableStatementCS);
				if (result == null) result = casePivotableElementCS(observableStatementCS);
				if (result == null) result = caseElementCS(observableStatementCS);
				if (result == null) result = casePivotable(observableStatementCS);
				if (result == null) result = caseVisitableCS(observableStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.PARAM_DECLARATION_CS: {
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
			case QVTimperativeCSPackage.QUERY_CS: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseTypedElementCS(queryCS);
				if (result == null) result = caseJavaImplementationCS(queryCS);
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
			case QVTimperativeCSPackage.SET_STATEMENT_CS: {
				SetStatementCS setStatementCS = (SetStatementCS)theEObject;
				T result = caseSetStatementCS(setStatementCS);
				if (result == null) result = caseObservableStatementCS(setStatementCS);
				if (result == null) result = caseStatementCS(setStatementCS);
				if (result == null) result = caseModelElementCS(setStatementCS);
				if (result == null) result = casePivotableElementCS(setStatementCS);
				if (result == null) result = caseElementCS(setStatementCS);
				if (result == null) result = casePivotable(setStatementCS);
				if (result == null) result = caseVisitableCS(setStatementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.SIMPLE_PARAMETER_BINDING_CS: {
				SimpleParameterBindingCS simpleParameterBindingCS = (SimpleParameterBindingCS)theEObject;
				T result = caseSimpleParameterBindingCS(simpleParameterBindingCS);
				if (result == null) result = caseMappingParameterBindingCS(simpleParameterBindingCS);
				if (result == null) result = caseExpCS(simpleParameterBindingCS);
				if (result == null) result = caseModelElementCS(simpleParameterBindingCS);
				if (result == null) result = casePivotableElementCS(simpleParameterBindingCS);
				if (result == null) result = caseElementCS(simpleParameterBindingCS);
				if (result == null) result = casePivotable(simpleParameterBindingCS);
				if (result == null) result = caseVisitableCS(simpleParameterBindingCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.SIMPLE_PARAMETER_CS: {
				SimpleParameterCS simpleParameterCS = (SimpleParameterCS)theEObject;
				T result = caseSimpleParameterCS(simpleParameterCS);
				if (result == null) result = caseMappingParameterCS(simpleParameterCS);
				if (result == null) result = caseTypedElementCS(simpleParameterCS);
				if (result == null) result = caseNamedElementCS(simpleParameterCS);
				if (result == null) result = caseModelElementCS(simpleParameterCS);
				if (result == null) result = caseNameable(simpleParameterCS);
				if (result == null) result = casePivotableElementCS(simpleParameterCS);
				if (result == null) result = caseElementCS(simpleParameterCS);
				if (result == null) result = casePivotable(simpleParameterCS);
				if (result == null) result = caseVisitableCS(simpleParameterCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.STATEMENT_CS: {
				StatementCS statementCS = (StatementCS)theEObject;
				T result = caseStatementCS(statementCS);
				if (result == null) result = caseModelElementCS(statementCS);
				if (result == null) result = casePivotableElementCS(statementCS);
				if (result == null) result = caseElementCS(statementCS);
				if (result == null) result = casePivotable(statementCS);
				if (result == null) result = caseVisitableCS(statementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.TOP_LEVEL_CS: {
				TopLevelCS topLevelCS = (TopLevelCS)theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null) result = caseRootPackageCS(topLevelCS);
				if (result == null) result = casePackageOwnerCS(topLevelCS);
				if (result == null) result = caseRootCS(topLevelCS);
				if (result == null) result = caseModelElementCS(topLevelCS);
				if (result == null) result = casePivotableElementCS(topLevelCS);
				if (result == null) result = caseElementCS(topLevelCS);
				if (result == null) result = casePivotable(topLevelCS);
				if (result == null) result = caseVisitableCS(topLevelCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTimperativeCSPackage.TRANSFORMATION_CS: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = caseAbstractTransformationCS(transformationCS);
				if (result == null) result = caseClassCS(transformationCS);
				if (result == null) result = caseNamedElementCS(transformationCS);
				if (result == null) result = caseTypeCS(transformationCS);
				if (result == null) result = caseTemplateableElementCS(transformationCS);
				if (result == null) result = caseModelElementCS(transformationCS);
				if (result == null) result = caseNameable(transformationCS);
				if (result == null) result = casePivotableElementCS(transformationCS);
				if (result == null) result = caseElementCS(transformationCS);
				if (result == null) result = casePivotable(transformationCS);
				if (result == null) result = caseVisitableCS(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddStatementCS(AddStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Append Parameter Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Append Parameter Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppendParameterBindingCS(AppendParameterBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Append Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Append Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAppendParameterCS(AppendParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBufferStatementCS(BufferStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckStatementCS(CheckStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declare Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declare Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclareStatementCS(DeclareStatementCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Guard Parameter Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Parameter Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardParameterBindingCS(GuardParameterBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardParameterCS(GuardParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Parameter Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Parameter Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopParameterBindingCS(LoopParameterBindingCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Call CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Call CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingCallCS(MappingCallCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Loop CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Loop CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingLoopCS(MappingLoopCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingParameterCS(MappingParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Parameter Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Parameter Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingParameterBindingCS(MappingParameterBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingStatementCS(MappingStatementCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>New Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewStatementCS(NewStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Observable Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Observable Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObservableStatementCS(ObservableStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetStatementCS(SetStatementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Parameter Binding CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Parameter Binding CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleParameterBindingCS(SimpleParameterBindingCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Parameter CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Parameter CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleParameterCS(SimpleParameterCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatementCS(StatementCS object) {
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

} //QVTimperativeCSTSwitch
