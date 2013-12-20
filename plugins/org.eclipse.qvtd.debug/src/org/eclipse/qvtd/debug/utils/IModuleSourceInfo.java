package org.eclipse.qvtd.debug.utils;

import org.eclipse.emf.common.util.URI;

/**
 * Interface allows adapting of a compiled Module to its source information.
 */
public interface IModuleSourceInfo {
	/**
	 * Gets the name of the module source file.
	 * @return the name string
	 */
	URI getSourceURI();
		
	/**
	 * Gets the line number provider operating on the module source contents.
	 * @return the provider instance
	 */
	LineNumberProvider getLineNumberProvider();
}