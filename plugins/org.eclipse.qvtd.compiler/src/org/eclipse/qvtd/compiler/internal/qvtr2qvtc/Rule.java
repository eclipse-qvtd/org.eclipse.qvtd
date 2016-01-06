/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RuleBindings;


/**
 * The Rule interface.
 */
public interface Rule {
	
	
	public interface Factory {
		
		@Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull EObject eo);
		
		@Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull List<EObject> eos);
		
		@NonNull List<Rule> getRules(@NonNull QvtrToQvtcTransformation transformation,
				@NonNull Resource inputModelm);
	}

	public interface SubRecord {
		
		@NonNull RuleBindings getRuleBindings();
		
		/**
		 * Return the keys for all relations bindings of this rule.
		 */
		RuleBindings.@NonNull KeySet getRuleBindingsKeys();
	}
	
	/**
	 * Derive input elements.
	 */
	void check();
	
	/**
	 * Instantiate output elements.
	 */
	void instantiateOutput();
	

	@NonNull RuleBindings getRuleBindings();
	
	/**
	 * Return the keys for all relations bindings of this rule.
	 */
	RuleBindings.@NonNull KeySet getRuleBindingsKeys();
	
	/**
	 * Was executed.
	 *
	 * @return true, if successful
	 */
	boolean hasExecuted();
	
	/**
	 * Assing values to output elements' attributes.
	 *
	 */
	public void setAttributes();	
	
	/**
	 * Was executed.
	 *
	 * @param executed the executed
	 */
	void setExecuted(boolean executed);
	
	/**
	 * When.
	 *
	 * @return true, if successful
	 */
	public boolean when();
	
	/**
	 * Where.
	 *
	 * @param transformation the transformation
	 */
	public void where();
	
}
