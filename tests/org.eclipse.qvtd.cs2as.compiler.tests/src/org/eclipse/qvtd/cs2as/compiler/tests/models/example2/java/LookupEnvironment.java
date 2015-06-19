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
package org.eclipse.qvtd.cs2as.compiler.tests.models.example2.java;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;

import example2.classes.NamedElement;
import example2.classescs.PathElementCS;
import example2.env.Environment;
import example2.env.impl.EnvironmentImpl;


public class LookupEnvironment extends EnvironmentImpl   {
	
	private @NonNull Executor executor;
	private @NonNull String name;
	
	public LookupEnvironment(@NonNull Executor executor, @NonNull String name) {
		this.executor = executor;
		this.name = name;
	}
	
	public LookupEnvironment(@NonNull Executor executor, @NonNull PathElementCS pathElement) {
		this.executor = executor;
		this.name = pathElement.getName();
	}
	
	@Override
	@NonNull
	public Executor getExecutor() {
		return executor;
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
