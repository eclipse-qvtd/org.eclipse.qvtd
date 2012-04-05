/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvt.environment;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.parser.environment.ICSTNodeEnvironment;

public interface IQVTNodeEnvironment extends ICSTNodeEnvironment, IQVTEnvironment
{
	public boolean checkFeatureCompatibility(CSTNode cstNode, EClassifier featureType, OCLExpression oclExpression);

	/**
	 * Return the source model name prefix that identifies the origin of eObject. 
	 * @param eObject
	 * @return the prefix or null if not known
	 */
	public String getModelName(EObject eObject);
	public Transformation getTransformation();
	
	/**
	 * Return the implicit source for an operation by delegating to the parent environment if possible,
	 * otherwise performing the inherited OCL lookup.
	 */
	public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params);
	
	/**
	 * Return the implicit source for a property by delegating to the parent environment if possible,
	 * otherwise performing the inherited OCL lookup.
	 */
	public Variable lookupImplicitSourceForProperty(String name);
	public Transformation lookupImportedTransformation(String name);

	/**
	 * Return the property with a non-navigable opposite named propertyName
	 * that may have an eClass as its target. Return null if no such property
	 * available. Throw a LookupException if more than one is available.
	 */
	public EReference tryLookupOppositeProperty(EClass eClass, String propertyName) throws LookupException;
	
	public Transformation tryLookupTransformation(List<String> pathName) throws LookupException;

	/**
	 * Return the Variable visible as name in this environment.
     */
	public Variable tryLookupVariable(String name) throws LookupException;
}
