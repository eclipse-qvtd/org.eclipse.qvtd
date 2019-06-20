/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2MiddleType;

/**
 * Each derived TracingStrategy identifies a behaviour that the trace class/interface of a Relation must exhibit.
 */
public interface TracingStrategy
{
	boolean needsGlobalSuccess(@NonNull RuleAnalysis2MiddleType relationAnalysis2MiddleType);
}