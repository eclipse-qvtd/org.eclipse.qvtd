/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\evaluation\AbstractInvocation.java
 *
 * Do not edit this file. 
 */
/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tx;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractInvocationInternal;

/**
 * AbstractInvocation provides the mandatory shared functionality of the intrusive blocked/waiting linked list functionality.
 * at-since 1.1
 */
public abstract class AbstractInvocation extends AbstractInvocationInternal
{
	public abstract static class Incremental extends AbstractInvocation implements Invocation.Incremental
	{
		public static final @NonNull List<@NonNull Object> EMPTY_OBJECT_LIST = Collections.emptyList();
		public static final @NonNull List<SlotState.@NonNull Incremental> EMPTY_SLOT_LIST = Collections.emptyList();

		private Set<@NonNull Object> createdObjects = null;
		private Set<SlotState.@NonNull Incremental> readSlots = null;
		private Set<SlotState.@NonNull Incremental> writeSlots = null;

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

		@Override
		public @NonNull Iterable<@NonNull Object> getCreatedObjects() {
			return createdObjects != null ? createdObjects : EMPTY_OBJECT_LIST;
		}

		@Override
		public @NonNull Iterable<SlotState.@NonNull Incremental> getReadSlots() {
			return readSlots != null ? readSlots : EMPTY_SLOT_LIST;
		}

		@Override
		public @NonNull Iterable<SlotState.@NonNull Incremental> getWriteSlots() {
			return writeSlots != null ? writeSlots : EMPTY_SLOT_LIST;
		}
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocation(this);
	}
}