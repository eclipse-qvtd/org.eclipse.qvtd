/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;

/**
 * VariablesAnalysis manages all the variables in use by a Relation and its corresponding Mapping.
 */
public class VariablesAnalysis extends QVTcoreHelper
{
	protected final @NonNull RelationAnalysis relationAnalysis;
	protected boolean isWhened;
	protected boolean isWhered;

	public VariablesAnalysis(@NonNull RelationAnalysis relationAnalysis, boolean isWhened, boolean isWhered) {
		super(relationAnalysis.getEnvironmentFactory());
		this.relationAnalysis = relationAnalysis;
		this.isWhened = isWhened;
		this.isWhered = isWhered;
	}

	/**
	 * True if analysis of a relation invoked within a when or where clause.
	 */
	public boolean isInvoked() {
		return isWhened() || isWhered();
	}

	/**
	 * True if analysis of a relation invoked within a when clause.
	 */
	public boolean isWhened() {
		return isWhened;
	}

	/**
	 * True if analysis of a relation invoked within a where clause.
	 */
	public boolean isWhered() {
		return isWhered;
	}
}
