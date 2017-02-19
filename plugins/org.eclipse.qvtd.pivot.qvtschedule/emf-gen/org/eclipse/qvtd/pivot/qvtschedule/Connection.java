/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getConnection()
 * @model abstract="true" superTypes="org.eclipse.ocl.pivot.Element org.eclipse.ocl.pivot.Nameable org.eclipse.qvtd.pivot.qvtschedule.Symbolable org.eclipse.qvtd.pivot.qvtschedule.Visitable2"
 * @generated
 */
public interface Connection extends Element, Nameable, Symbolable, Visitable2
{
	void destroy();

	/**
	 * Return a non-standard style for the arrow head.
	 */
	@Nullable String getArrowhead();

	/**
	 * Return the color with which this edge is drawn.
	 */
	@NonNull String getColor();

	@NonNull ConnectionRole getConnectionRole();

	/**
	 * Return a formatted label to accompany the edge, or null for no label.
	 */
	@Nullable String getLabel();
	@NonNull ScheduledRegion getRegion();
	void toCallGraph(@NonNull GraphStringBuilder s);
	void toRegionGraph(@NonNull ScheduledRegion scheduledRegion, @NonNull GraphStringBuilder s);
	void toGraph(@NonNull GraphStringBuilder s);
} // Connection
