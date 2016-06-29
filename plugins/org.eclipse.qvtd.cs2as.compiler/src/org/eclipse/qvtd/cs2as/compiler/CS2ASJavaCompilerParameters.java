/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

public interface CS2ASJavaCompilerParameters extends OCL2JavaTxCompilerParams {


	/**
	 * @return the fully qualified name of the lookup resolver class
	 */
	public @NonNull String getLookupSolverClassName();


	/**
	 * @return the fully qualified name of the lookup result class
	 */
	public @NonNull String getLookupResultClassName();

	/**
	 * @return the path in which the CGed transformation will be saved
	 */

	public @NonNull String getSavePath();

	/**
	 * @return the java package name in which the CGed transformation will be created
	 */
	public @NonNull String getPackageName();

	/**
	 * @return the map of Java package renames to replicate the localization of the run-time packages.
	 */
	public @NonNull Map<@NonNull String, @NonNull String> getPackageRenames();

	/**
	 * @return true to generate an incremental transformation
	 */
	public boolean isIncremental();

	public void setIsIncremental(boolean isIncremental);
}
