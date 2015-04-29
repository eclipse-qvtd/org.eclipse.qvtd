/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.evaluation;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

public interface TypedModelInstance
{
	@NonNull Set<Object> getAllObjects();
	@NonNull Set<Object> getObjectsOfKind(@NonNull org.eclipse.ocl.pivot.Class type);
	@NonNull Set<Object> getObjectsOfType(@NonNull org.eclipse.ocl.pivot.Class type);
	@NonNull Set<Object> getRootObjects();
}
