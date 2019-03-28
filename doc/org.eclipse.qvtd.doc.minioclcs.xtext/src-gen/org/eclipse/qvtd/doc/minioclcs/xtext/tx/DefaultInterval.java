/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\evaluation\DefaultInterval.java
 *
 * Do not edit this file. 
 */
/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tx;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractIntervalInternal;

/**
 * DefaultInterval provides the standard implementation of the scheduling interval manager.
 */
public class DefaultInterval extends AbstractIntervalInternal
{
	public DefaultInterval(@NonNull InvocationManager invocationManager, int intervalIndex) {
		super(invocationManager, intervalIndex);
	}
}