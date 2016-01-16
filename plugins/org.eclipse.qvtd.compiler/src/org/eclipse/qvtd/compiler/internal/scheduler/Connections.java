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

/**
 * Connections provides factory instances for creating the various forms of connections.
 */
public class Connections
{	
	private static final class MandatoryConnectionRole extends AbstractConnectionRole
	{
		@Override
		public @NonNull String getStyle() {
			return "dashed";
		}

		@Override
		public boolean isMandatory() {
			return true;
		}

		@Override
		public boolean isPreferred() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isPassed()) {
				return connectionRole;
			}
			if (connectionRole.isPreferred()) {
				return this;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«mandatory»";
		}
	}
	
	private static final class PassedConnectionRole extends AbstractConnectionRole
	{
		@Override
		public boolean isPassed() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isMandatory()) {
				return this;
			}
			if (connectionRole.isPreferred()) {
				return this;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«passed»";
		}
	}

	private static final class PreferredConnectionRole extends AbstractConnectionRole
	{
		@Override
		public @NonNull String getStyle() {
			return "dotted";
		}

		@Override
		public boolean isMandatory() {
			return false;
		}

		@Override
		public boolean isPreferred() {
			return true;
		}

		@Override
		public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
			if (connectionRole.isPassed()) {
				return connectionRole;
			}
			if (connectionRole.isMandatory()) {
				return connectionRole;
			}
			return super.merge(connectionRole);
		}

		@Override
		public @NonNull String toString() {
			return "«preferred»";
		}
	}

	/**
	 * A MANDATORY connection 'passes' a used input that must be fully computed before use. This is typically for a
	 * collection, since it is not possible to determine when a last partial addition is the last, therefore all
	 * additions must occur before any access.
	 */
	public static final @NonNull ConnectionRole MANDATORY = new MandatoryConnectionRole();		

	/**
	 * A PASSED connection passes a required input. This is typically from an introducer/producer/join to
	 * a consumer's head. A value must actually be passed by the call.
	 */
	public static final @NonNull ConnectionRole PASSED = new PassedConnectionRole();		
	
	/**
	 * A PREFERRED connection 'passes' a used input that is beneficially but not necessarily computed before use. 
	 * If not computed before use, run-time overheads are incurred to defer reads until writes have occurred.
	 */
	public static final @NonNull ConnectionRole PREFERRED = new PreferredConnectionRole();
}