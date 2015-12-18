/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

/**
 * ConnectionRole defines which of many possible roles a connection plays
 */
public interface ConnectionRole extends GraphStringBuilder.GraphEdge
{
	@Nullable String getArrowhead();

	@NonNull String getColor();

	/**
	 * Return a label for the connection, null for none. 
	 */
	@Nullable String getLabel();

	/**
	 * Return the pen width with which this connection is drawn. 
	 */
	@NonNull Integer getPenwidth();

	/**
	 * Return the line style with which this connection is drawn, null for solid.
	 */
	@Nullable String getStyle();

	boolean isMandatory();
	boolean isPassed();
	boolean isPreferred();

	@NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole);
}