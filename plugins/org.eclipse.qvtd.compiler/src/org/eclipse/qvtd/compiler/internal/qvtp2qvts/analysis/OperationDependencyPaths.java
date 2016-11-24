/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * OperationDependencyPaths describes the set of alternative usages of an analyzed operation input/output value.
 *
 * Each usage is a sequence of dependency steps, rooted by a ClassDependencyStep and optionally suffixed by
 * NavigationDependencySteps.
 *
 * Each usage comprises overt usages that contribute to the analyze value and further hidden usages
 * that are used behind the scenes. e.g. a.b=c, has Boolean as an explicit return and A::b, C as hidden usages.
 */
public interface OperationDependencyPaths
{
	/**
	 * Return the hidden paths as an ordered iterable.
	 */
	@NonNull Iterable<@NonNull List<@NonNull OperationDependencyStep>> getHiddenPaths();

	/**
	 * Return the return paths as an ordered iterable.
	 */
	@NonNull Iterable<@NonNull List<@NonNull OperationDependencyStep>> getReturnPaths();
}