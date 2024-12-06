/**
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.qvtd.xtext.qvtbasecs.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage
 * @generated
 */
public class QVTbaseCSValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final QVTbaseCSValidator INSTANCE = new QVTbaseCSValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.qvtd.xtext.qvtbasecs";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTbaseCSValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return QVTbaseCSPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case 0:
				return validateAbstractTransformationCS((AbstractTransformationCS)value, diagnostics, context);
			case 1:
				return validateCompoundTargetElementCS((CompoundTargetElementCS)value, diagnostics, context);
			case 2:
				return validateDummyQVTbaseConstraintClass((DummyQVTbaseConstraintClass)value, diagnostics, context);
			case 3:
				return validateQualifiedPackageCS((QualifiedPackageCS)value, diagnostics, context);
			case 4:
				return validateSimpleTargetElementCS((SimpleTargetElementCS)value, diagnostics, context);
			case 5:
				return validateTargetCS((TargetCS)value, diagnostics, context);
			case 6:
				return validateTargetElementCS((TargetElementCS)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractTransformationCS(AbstractTransformationCS abstractTransformationCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(abstractTransformationCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompoundTargetElementCS(CompoundTargetElementCS compoundTargetElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(compoundTargetElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDummyQVTbaseConstraintClass(DummyQVTbaseConstraintClass dummyQVTbaseConstraintClass, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(dummyQVTbaseConstraintClass, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(dummyQVTbaseConstraintClass, diagnostics, context);
		if (result || diagnostics != null) result &= validateDummyQVTbaseConstraintClass_DummyConstraint(dummyQVTbaseConstraintClass, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DummyConstraint constraint of '<em>Dummy QV Tbase Constraint Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDummyQVTbaseConstraintClass_DummyConstraint(DummyQVTbaseConstraintClass dummyQVTbaseConstraintClass, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "DummyConstraint", getObjectLabel(dummyQVTbaseConstraintClass, context) },
						 new Object[] { dummyQVTbaseConstraintClass },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedPackageCS(QualifiedPackageCS qualifiedPackageCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(qualifiedPackageCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimpleTargetElementCS(SimpleTargetElementCS simpleTargetElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(simpleTargetElementCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetCS(TargetCS targetCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(targetCS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTargetElementCS(TargetElementCS targetElementCS, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(targetElementCS, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //QVTbaseCSValidator
