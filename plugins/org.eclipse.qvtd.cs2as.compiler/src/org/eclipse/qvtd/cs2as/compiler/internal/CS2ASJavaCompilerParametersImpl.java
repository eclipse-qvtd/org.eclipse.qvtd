package org.eclipse.qvtd.cs2as.compiler.internal;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;

public class CS2ASJavaCompilerParametersImpl implements CS2ASJavaCompilerParameters  {

	private @NonNull String envClassName;
	private @NonNull String visitorClassName;
	private @Nullable String savePath;
	private @NonNull String packagePrefix;
	private @NonNull String namedElementClassName;
	
	public CS2ASJavaCompilerParametersImpl(@NonNull String envClassName, @NonNull String visitorClassName,
			@Nullable String namedElementClassName,
			@Nullable String savePath, @NonNull String packagePrefix) {
		this.envClassName = envClassName;
		this.visitorClassName = visitorClassName;
		this.savePath = savePath;
		this.packagePrefix = packagePrefix;
		this.namedElementClassName = namedElementClassName;
	}
	
	/**
	 * @return the fully qualified name of the environment class
	 */
	@NonNull
	public String getEnviromentClassName() {
		return envClassName;
	}
	
	/**
	 * @return the fully qualified name of the lookup visitor class
	 */
	@NonNull
	public String getVisitorClassName() {
		return visitorClassName;
	}
	
	/**
	 * If there is no common NamedElement class name. Object should be used by the CG
	 * 
	 * @return the fully qualified name of the common named element class
	 */
	@Nullable
	public String getNamedElementClassName() {
		return namedElementClassName; 
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
