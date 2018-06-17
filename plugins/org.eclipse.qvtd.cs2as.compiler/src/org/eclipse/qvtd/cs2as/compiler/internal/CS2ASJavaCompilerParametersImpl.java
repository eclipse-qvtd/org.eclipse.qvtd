/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;

public class CS2ASJavaCompilerParametersImpl implements CS2ASJavaCompilerParameters  {
	private @NonNull String lookupSolverName;
	private @NonNull String savePath;
	private @Nullable String packagePrefix;

	private @NonNull String lookupResultName;
	//	private @NonNull String namedElementClassName;
	private boolean isIncremental = false;
	private @NonNull Map<@NonNull String, @NonNull String> packageRenameMap = new HashMap<@NonNull String, @NonNull String>();
	private @Nullable List<@NonNull String> classpathProjectNames = null;
	private @Nullable ClassLoader classLoader = null;



	public CS2ASJavaCompilerParametersImpl(@NonNull String lookupSolverClassName,
			@NonNull String lookupResultClassName,
			@NonNull String savePath) {
		this.lookupSolverName = lookupSolverClassName;
		this.savePath = savePath;
		this.lookupResultName = lookupResultClassName;
	}

	public void addClassPathProjectName(@NonNull String classpathProjectName) {
		List<@NonNull String> classpathProjectNames2 = classpathProjectNames;
		if (classpathProjectNames2 == null) {
			classpathProjectNames = classpathProjectNames2 = new ArrayList<>();
		}
		classpathProjectNames2.add(classpathProjectName);
	}

	/**
	 * Defines a package rename only from some package to another package.
	 */
	public void addPackageRename(@NonNull String fromPackage, @NonNull String toPackage) {
		packageRenameMap.put(fromPackage, toPackage);
	}

	@Override
	public @Nullable ClassLoader getClassLoader() {
		return classLoader;
	}

	@Override
	public @Nullable List<@NonNull String> getClassPathProjectNames() {
		return classpathProjectNames;
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
	public @Nullable String getPackagePrefix() {
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

	public void setClassLoader(@Nullable ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void setIsIncremental(boolean isIncremental) {
		this.isIncremental = isIncremental;
	}

	public void setPackagePrefix(@Nullable String packagePrefix) {
		this.packagePrefix = packagePrefix;
	}
}
