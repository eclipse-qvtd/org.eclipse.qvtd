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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2MiddleType;

public class AbstractTracingStrategy implements TracingStrategy
{
	@Override
	public boolean needsGlobalSuccess(@NonNull Rule2MiddleType relation2MiddleType) {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return getClass().getSimpleName();
	}

	public static class AbstractRelation2TraceClassTracingStrategy extends AbstractTracingStrategy
	{
		@Override
		public boolean needsGlobalSuccess(@NonNull Rule2MiddleType relation2MiddleType) {
			assert relation2MiddleType instanceof Relation2TraceClass;
			return true;
		}
	}

	public static class HasDispatcherTracingStrategy extends AbstractTracingStrategy
	{
		public static final @NonNull TracingStrategy INSTANCE = new HasDispatcherTracingStrategy();
	}

	public static class HasInterfaceTracingStrategy extends AbstractRelation2TraceClassTracingStrategy
	{
		public static final @NonNull TracingStrategy INSTANCE = new HasInterfaceTracingStrategy();
	}

	public static class HasPredicatedElementTracingStrategy extends AbstractRelation2TraceClassTracingStrategy
	{
		public static final @NonNull TracingStrategy INSTANCE = new HasPredicatedElementTracingStrategy();
	}

	public static class HasWhenInvocationTracingStrategy extends AbstractRelation2TraceClassTracingStrategy
	{
		public static final @NonNull TracingStrategy INSTANCE = new HasWhenInvocationTracingStrategy();
	}
}