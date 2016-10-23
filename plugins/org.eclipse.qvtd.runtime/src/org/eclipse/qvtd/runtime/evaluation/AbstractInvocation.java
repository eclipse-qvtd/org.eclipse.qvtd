/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationInternal;

/**
 * AbstractInvocation provides the mandatory shared functionality of the intrusive blocked/waiting linked list functionality.
 */
public abstract class AbstractInvocation extends AbstractInvocationInternal
{
	public abstract static class Incremental extends AbstractInvocation implements Invocation.Incremental
	{
		public static final @NonNull List<@NonNull Object> EMPTY_OBJECT_LIST = Collections.emptyList();
		public static final @NonNull List<SlotState.@NonNull Incremental> EMPTY_SLOT_LIST = Collections.emptyList();

		protected final @NonNull InvocationConstructor constructor;
		protected final int sequence;

		private Set<@NonNull Object> createdObjects = null;
		private Set<SlotState.@NonNull Incremental> readSlots = null;
		private Set<SlotState.@NonNull Incremental> writeSlots = null;

		protected Incremental(InvocationConstructor.@NonNull Incremental constructor) {
			super(constructor);
			this.constructor = constructor;
			this.sequence = constructor.nextSequence();
		}

		@Override
		public void addCreatedObject(@NonNull Object createdObject) {
			if (createdObjects == null) {
				createdObjects = new HashSet<>();
			}
			createdObjects.add(createdObject);
		}

		@Override
		public void addReadSlot(SlotState.@NonNull Incremental readSlot) {
			if (readSlots == null) {
				readSlots = new HashSet<>();
			}
			readSlots.add(readSlot);
			readSlot.addTargetInternal(this);
		}

		@Override
		public void addWriteSlot(SlotState.@NonNull Incremental writeSlot) {
			if (writeSlots == null) {
				writeSlots = new HashSet<>();
			}
			writeSlots.add(writeSlot);
			writeSlot.addSourceInternal(this);
		}

		protected @NonNull Connection createConnection(@NonNull String name, @NonNull CollectionTypeId typeId, boolean isStrict) {
			return constructor.getInterval().createConnection(name, typeId, isStrict);
		}

		protected Connection.@NonNull Incremental createIncrementalConnection(@NonNull String name, @NonNull CollectionTypeId typeId, boolean isStrict) {
			return constructor.getInterval().createIncrementalConnection(name, typeId, isStrict);
		}

		@Override
		public @NonNull Iterable<@NonNull Object> getCreatedObjects() {
			return createdObjects != null ? createdObjects : EMPTY_OBJECT_LIST;
		}

		@Override
		public @NonNull String getName() {
			return constructor.getName() + "-" + sequence;
		}

		@Override
		public @NonNull Iterable<SlotState.@NonNull Incremental> getReadSlots() {
			return readSlots != null ? readSlots : EMPTY_SLOT_LIST;
		}

		@Override
		public @NonNull Iterable<SlotState.@NonNull Incremental> getWriteSlots() {
			return writeSlots != null ? writeSlots : EMPTY_SLOT_LIST;
		}

		@Override
		public @NonNull String toString() {
			return getName();
		}
	}

	protected AbstractInvocation(@NonNull InvocationConstructor constructor) {
		super(constructor.getInterval());
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocation(this);
	}

	@Override
	public @NonNull String getName() {
		return toString().replace("@",  "\n@");
	}
}