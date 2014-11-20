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
package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.Rule;

public class AbstractTraceRecord implements Rule {
	
	
	
	public AbstractTraceRecord(@NonNull CoreBindings coreBindings) {
		this.coreBindings = coreBindings;
	}
	
	public @NonNull CoreBindings getCoreBindings() {
		return coreBindings;
	}

	@Override
	public @NonNull PrimitivesBindings getPrimitivesBindings() {
		return coreBindings.getPrimitivesBindings();
	}

	@Override
	public @NonNull RelationsBindings getRelationsBindings() {
		return coreBindings.getRelationsBindings();
	}

	@Override
	public boolean hasExecuted() {
		return executed;
	}
	
	/**
	 * @param executed the executed to set
	 */
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
}
