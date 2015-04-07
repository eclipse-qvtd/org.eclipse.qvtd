/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.cs2as.tests.models.example1.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Evaluator;

import example1.env.Environment;
import example1.env.impl.EnvironmentImpl;
import example1.target.NamedElement;

public class LookupEnvironment extends EnvironmentImpl   {
	
	private @NonNull Evaluator evaluator;
	private @NonNull String name;
	
	public LookupEnvironment(@NonNull Evaluator evaluator, @NonNull String name) {
		this.evaluator = evaluator;
		this.name = name;
	}
	
	@Override
	@NonNull
	public Evaluator getEvaluator() {
		return evaluator;
	}
	
	@Override
	public boolean hasFinalResult() {
		for (NamedElement element : getNamedElements()) {
			if (name.equals(element.getName())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	@NonNull
	public Environment addElement(@Nullable NamedElement namedElement) {
		if (namedElement != null) {
			if (name.equals(namedElement.getName())) {
				EList<NamedElement> elements = getNamedElements();
				if (!elements.contains(namedElement)) { 	// FIXME use a set ?
					elements.add(namedElement);
				}
			}
		}
		return this;
	}
	
	@Override
	@NonNull
	public <NE extends NamedElement > Environment addElements(
			@Nullable EList<NE> namedElements) {
		
		if (namedElements != null) {
			for (NamedElement namedElement : namedElements) {
				addElement(namedElement);
			}	
		}
		return this;
	}
}
