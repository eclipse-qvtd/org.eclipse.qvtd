/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractQVTscheduleASSaverNormalizeVisitor;

public class QVTscheduleASSaverNormalizeVisitor extends AbstractQVTscheduleASSaverNormalizeVisitor
{
	private static class PartitionComparator implements Comparator<@NonNull MappingPartition>
	{
		public static final @NonNull PartitionComparator INSTANCE = new PartitionComparator();

		@Override
		public int compare(@NonNull MappingPartition o1, @NonNull MappingPartition o2) {
			List<Integer> p1 = o1.getPasses();
			List<Integer> p2 = o2.getPasses();
			int i1 = p1.size() > 0 ? p1.get(0) : 0;
			int i2 = p2.size() > 0 ? p2.get(0) : 0;
			if (i1 != i2) {
				return i1 - i2;
			}
			return o1.getName().compareTo(o2.getName());
		}
	}

	protected QVTscheduleASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitCompositePartition(@NonNull CompositePartition compositePartition) {
		ECollections.sort((EList<@NonNull MappingPartition>)compositePartition.getOwnedMappingPartitions(), PartitionComparator.INSTANCE);
		return super.visitCompositePartition(compositePartition);
	}
}
