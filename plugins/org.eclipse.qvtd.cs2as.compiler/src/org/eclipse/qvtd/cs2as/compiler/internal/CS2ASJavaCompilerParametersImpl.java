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
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;

public class CS2ASJavaCompilerParametersImpl implements CS2ASJavaCompilerParameters  {
	private @NonNull String lookupSolverName;
	private @NonNull String savePath;
	private @NonNull String packagePrefix;
	private @NonNull String lookupResultName;
	//	private @NonNull String namedElementClassName;
	private boolean isIncremental = false;
	private @NonNull Map<@NonNull String, @NonNull String> packageRenameMap = new HashMap<@NonNull String, @NonNull String>();

	public CS2ASJavaCompilerParametersImpl(@NonNull String lookupSolverClassName,
			@NonNull String lookupResultClassName,
			@NonNull String savePath, @NonNull String packagePrefix) {
		this.lookupSolverName = lookupSolverClassName;
		this.savePath = savePath;
		this.packagePrefix = packagePrefix;
		this.lookupResultName = lookupResultClassName;
	}

	/**
	 * Defines a package rename only from some package to another package.
	 */
	public void addPackageRename(@NonNull String fromPackage, @NonNull String toPackage) {
		packageRenameMap.put(fromPackage, toPackage);
	}

	/**
	 * @return the fully qualified name of the lookup resolver class
	 */
	@Override
	public @NonNull String getLookupSolverClassName() {
		return lookupSolverName;
	}

	/**
	 * @return the fully qualified name of the lookup result class
	 */
	@Override
	public @NonNull String getLookupResultClassName() {
		return lookupResultName;
	}

	/**
	 * @return the path in which the CGed transformation will be saved
	 */
	@Override
	public @NonNull String getSavePath() {
		return savePath;
	}

	/**
	 * @return the java package name in which the CGed transformation will be created
	 */
	@Override
	@NonNull
	public String getPackageName() {
		return packagePrefix;
	}

	@Override
	public @NonNull Map<@NonNull String, @NonNull String> getPackageRenames() {
		return packageRenameMap;
	}

	@Override
	public boolean isIncremental() {
		return isIncremental;
	}

	@Override
	public void setIsIncremental(boolean isIncremental) {
		this.isIncremental = isIncremental;
	}
}
