/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConstrainedRule.
 */
public interface ConstrainedRule {
	
	/**
	 * Gets the loop data.
	 *
	 * @param inputModel the input model
	 * @return the loop data
	 */
	public @NonNull List<RelationsBindings> findInputMatches(@NonNull Resource inputModel);

	/**
	 * Return the keys for all core bindings of this rule.
	 */
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys();

	/**
	 * Return the keys for all primitive bindings of this rule.
	 */
	public @NonNull PrimitivesBindings.KeySet getPrimitivesBindingsKeys();

	/**
	 * Return the keys for all relations bindings of this rule.
	 */
	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys();
	
	/**
	 * Instantiate output elements.
	 *
	 * @param qvtcModelElements the qvtc model elements
	 * @return the list
	 */
	public List<EObject> instantiateOutputElements(Map<Class<? extends EObject>, List<EObject>> qvtcModelElements, @NonNull CoreBindings coreBindings);
	
	/**
	 * Instantiate middle elements.
	 *
	 * @param qvtcMiddleElements the qvtc middle elements
	 * @return the list
	 */
	public List<EObject> instantiateMiddleElements(Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements, @NonNull CoreBindings coreBindings);
	
	/**
	 * Match a Bindings to the types requried by the rule 
	 * @param tr 
	 * @param bindings
	 * @return
	 */
	public boolean matchBindings(@NonNull Rule tr, @NonNull RelationsBindings relationsBindings);
	
	/**
	 * Sets the attributes.
	 */
	public void setAttributes(@NonNull CoreBindings coreBindings);
	/**
	 * When.
	 *
	 * @param transformation the transformation
	 * @return true, if successful
	 */
	public boolean when(@NonNull RelationsBindings relationsBindings);	
	
	/**
	 * Where.
	 *
	 * @param transformation the transformation
	 */
	public void where(@NonNull CoreBindings coreBindings);
}
