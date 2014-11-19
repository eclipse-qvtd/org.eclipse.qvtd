/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc;

import org.eclipse.jdt.annotation.NonNull;


// TODO: Auto-generated Javadoc
/**
 * The Interface TraceRecord.
 */
public interface TraceRecord {
	
	
	@NonNull CoreBindings getCoreBindings();

	@NonNull PrimitivesBindings getPrimitivesBindings();

	@NonNull RelationsBindings getRelationsBindings();
	/**
	 * Was executed.
	 *
	 * @return true, if successful
	 */
	boolean hasExecuted();
	
	/**
	 * Was executed.
	 *
	 * @param executed the executed
	 */
	void setExecuted(boolean executed);
	
}
