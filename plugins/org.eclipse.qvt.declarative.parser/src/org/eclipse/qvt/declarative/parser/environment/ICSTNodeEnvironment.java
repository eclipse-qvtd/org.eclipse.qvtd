/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
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
 * $Id: ICSTNodeEnvironment.java,v 1.3 2009/12/23 14:53:22 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.environment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.qvt.declarative.ecore.utils.CSTFormattingHelper;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

public interface ICSTNodeEnvironment extends ICSTEnvironment
{

	public boolean checkFeatureCompatibility(CSTNode cstNode, EClassifier featureType, OCLExpression oclExpression);
	
	/**
	 * Create and return an InvalidLiteralExp mapped to cstNode.
	 * 
	 * @param cstNode that provoked the invalid literal.
	 * @return the InvalidLiteralExp
	 */
	public InvalidLiteralExp createInvalidLiteralExp(CSTNode cstNode);
	
	/**
	 * Create and return a nested environment for the cstNode, typically to
	 * avoid the need to invoke setCSTNode to change and restore an outer OCL
	 * expression environment.
	 */
	public ICSTNodeEnvironment createNestedEnvironment(CSTNode cstNode);

	/**
	 * Return the error message for a LookupException, typically by appending details
	 * of the ambiguities to the standard exception message.
	 * 
	 * @param e lookup exception
	 * @return full message
	 */
	public String formatLookupException(LookupException e);

	public Object getASTNode();	

	public CSTNode getCSTNode();	

	/**
	 * Return the enhanced functionality formatting helper.
	 */
	public CSTFormattingHelper getFormatter();

	/**
     * Generates a new, unique name for an implicit iterator variable.
	 */
//	public String generateImplicitName();   // FIXME Workaround for bug 246469
	
	public ICSTRootEnvironment getRootEnvironment();
    
	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable attribute has been generated.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EAttribute getUnresolvedAttribute();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable class has been generated.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EClass getUnresolvedClass();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable classifier has been generated. The return value may be silently changed to
	 * an unresolved data type or class once more context is available.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EClassifier getUnresolvedClassifier();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable data type has been generated.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EDataType getUnresolvedDataType();

	/**
	 * Return the environment that supervises definitions fopr unresolved references.
	 */
	public UnresolvedEnvironment getUnresolvedEnvironment();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable operation has been generated.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EOperation getUnresolvedOperation();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable property has been generated. The return value may be silently changed to
	 * an unresolved attribute or reference once more context is available.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EStructuralFeature getUnresolvedProperty();

	/**
	 * Get an error return value whose usage indicates that an error message diagnosing
	 * an unsuitable reference has been generated.
	 */
	@Deprecated // Use getUnresolvedEnvironment().getXXX to create a context-specific element
	public EReference getUnresolvedReference();

	/**
	 * Return false if eObject was created to resolve an unresolved reference.
	 */
	public boolean isResolved(EObject eObject);
	
	/**
	 * Define the current CSTNode during analysis, returning the previous one.
	 * The CSTNode is normally correctly set during construction, but may be
	 * temporarily changed so that a narrower context is available to an error that
	 * uses the current CST node as its context.
	 */
	@Deprecated // Use createNestedEnvironment()
	public CSTNode setCSTNode(CSTNode cstNode);
	public void setNameFromIdentifier(ENamedElement astNode, IdentifierCS cstNode);
	public void setNameFromIdentifier(ENamedElement fromAstNode, IdentifierCS cstNode, Object toAstNode);
}
