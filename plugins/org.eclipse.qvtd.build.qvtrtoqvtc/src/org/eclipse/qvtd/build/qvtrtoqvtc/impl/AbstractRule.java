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
package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings.KeySet;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;

public class AbstractRule implements Rule
{
	
	public static abstract class Factory {
		
		public abstract @Nullable Rule createRule(@NonNull QvtrToQvtcTransformation transformation,  @NonNull EObject eo);
		
		public @NonNull List<Rule> getRules(@NonNull QvtrToQvtcTransformation transformation, @NonNull Resource inputModel) {
			List<Rule> rules = new ArrayList<Rule>();
			TreeIterator<EObject> it = inputModel.getAllContents();
			while(it.hasNext()) {
				EObject eo = it.next();
				Rule rule = createRule(transformation, eo);
				if (rule != null) {
					rules.add(rule);
				}
			}
			return rules;
		}
	}
	
	protected final @NonNull QvtrToQvtcTransformation transformation;
	private boolean executed = false;
	protected RelationsBindings relationsBindings;
	protected CoreBindings coreBindings;
	

	protected AbstractRule(@NonNull QvtrToQvtcTransformation transformation) {
		this.transformation = transformation;
	}
	
	
	@Override
	@NonNull
	public RelationsBindings getRelationsBindings() {
		
		return relationsBindings;
	}
	
	@Override
	@NonNull
	public CoreBindings getCoreBindings() {
		
		return coreBindings;
	}


	@Override
	@NonNull
	public RelationsBindings.KeySet getRelationsBindingsKeys() {
		return (RelationsBindings.KeySet) relationsBindings.keySet();
	}
	
	@Override
	@NonNull
	public CoreBindings.KeySet getCoreBindingsKeys() {
		return (CoreBindings.KeySet) coreBindings.keySet();
	}


	@Override
	public boolean hasExecuted() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<EObject> instantiateOutputElements(
			Map<Class<? extends EObject>, List<EObject>> outputModelElements) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void setAttributes() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setExecuted(boolean executed) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean when(@NonNull TransformationTraceData traceData) {
		
		return false;
	}


	@Override
	public void where() {
		
	}
}
