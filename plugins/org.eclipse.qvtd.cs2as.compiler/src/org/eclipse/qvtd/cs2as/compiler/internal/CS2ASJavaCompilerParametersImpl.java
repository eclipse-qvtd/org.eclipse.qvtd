/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;

public class CS2ASJavaCompilerParametersImpl implements CS2ASJavaCompilerParameters  {

	private @NonNull String lookupSolverName;
	private @Nullable String savePath;
	private @NonNull String packagePrefix;
	private @NonNull String lookupResultName;
	
	public CS2ASJavaCompilerParametersImpl(@NonNull String lookupSolverClassName,
			@Nullable String lookupResultClassName,
			@Nullable String savePath, @NonNull String packagePrefix) {
		this.lookupSolverName = lookupSolverClassName;
		this.savePath = savePath;
		this.packagePrefix = packagePrefix;
		this.lookupResultName = lookupResultClassName;
	}
	
	/**
	 * @return the fully qualified name of the lookup resolver class
	 */
	@NonNull
	public String getLookupSolverClassName() {
		return lookupSolverName;
	}
	
	/**
	 * @return the fully qualified name of the lookup result class
	 */
	@Nullable
	public String getLookupResultClassName() {
		return lookupResultName; 
	}

	/**
	 * @return the path in which the CGed transformation will be saved
	 */
	@NonNull
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @return the java package name in which the CGed transformation will be created
	 */
	@NonNull
	public String getPackageName() {
		return packagePrefix;
	}
	

	
}
