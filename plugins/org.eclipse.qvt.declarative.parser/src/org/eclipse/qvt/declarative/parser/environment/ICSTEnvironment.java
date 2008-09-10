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
package org.eclipse.qvt.declarative.parser.environment;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;

public interface ICSTEnvironment extends Environment.Internal<
	EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>,
	Environment.Lookup<EPackage, EClassifier, EOperation, EStructuralFeature>
{
	/**
	 * Create and return an InvalidLiteralExp mapped to cstNode.
	 * 
	 * @param cstNode that provoked the invalid literal.
	 * @return the InvalidLiteralExp
	 */
	public InvalidLiteralExp createInvalidLiteralExp(CSTNode cstNode);

	/**
     * Generates a new, unique name for an implicit iterator variable.
	 */
	public String generateImplicitName();   // FIXME Workaround for bug 246469
	
	public CSTFormattingHelper getFormatter();
	public Monitor getMonitor();
	public ICSTEnvironment getRootEnvironment();
    
	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable attribute has been generated.
	 */
	public EAttribute getUnresolvedAttribute();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable class has been generated.
	 */
	public EClass getUnresolvedClass();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable classifier has been generated. The return value may be silently changed to
	 * an unresolved data type or class once more context is available.
	 */
	public EClassifier getUnresolvedClassifier();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable data type has been generated.
	 */
	public EDataType getUnresolvedDataType();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable operation has been generated.
	 */
	public EOperation getUnresolvedOperation();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable property has been generated. The return value may be silently changed to
	 * an unresolved attribute or reference once more context is available.
	 */
	public EStructuralFeature getUnresolvedProperty();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable reference has been generated.
	 */
	public EReference getUnresolvedReference();
	
	/**
	 * Define the current CSTNode during analysis, returning the previous one.
	 * The CSTNode is normally correctly set during construction, but may be
	 * temporarily changed so that a narrower context is available to an error that
	 * uses the current CST node as its context.
	 */
	public CSTNode setCSTNode(CSTNode cstNode);
}
