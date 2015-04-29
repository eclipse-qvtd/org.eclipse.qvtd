package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface CS2ASJavaCompilerParameters extends OCL2JavaTxCompilerParams {
	
	
	/**
	 * @return the fully qualified name of the environment class
	 */
	@NonNull
	public String getEnviromentClassName();
	
	/**
	 * @return the fully qualified name of the lookup visitor class
	 */
	@NonNull
	public String getVisitorClassName();
	
	/**
	 * If there is no common NamedElement class name. Object should be used by the CG
	 * 
	 * @return the fully qualified name of the common named element class
	 */
	@Nullable
	public String getNamedElementClassName(); 

	/**
	 * @return the path in which the CGed transformation will be saved
	 */
	@NonNull
	public String getSavePath(); 

	/**
	 * @return the java package name in which the CGed transformation will be created
	 */
	@NonNull
	public String getPackageName();
	
}
