/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.Comparator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeASSaverNormalizeVisitor;

public class QVTimperativeASSaverNormalizeVisitor extends AbstractQVTimperativeASSaverNormalizeVisitor
{
	protected static final class OperationComparator implements Comparator<@NonNull Operation>
	{
		public static final @NonNull Comparator<@NonNull Operation> INSTANCE = new OperationComparator();

		@Override
		public int compare(@NonNull Operation o1, @NonNull Operation o2) {
			String n1 = o1.getOperationId().getDisplayName();
			String n2 = o2.getOperationId().getDisplayName();
			return n1.compareTo(n2);
		}
	}

	protected static final class PredicateComparator implements Comparator<@NonNull CheckStatement>
	{
		public static final @NonNull Comparator<@NonNull CheckStatement> INSTANCE = new PredicateComparator();

		@Override
		public int compare(@NonNull CheckStatement o1, @NonNull CheckStatement o2) {
			String n1 = o1.toString();
			String n2 = o2.toString();
			if (n1 == null) n1 = "";
			if (n2 == null) n2 = "";
			return n1.compareTo(n2);
		}
	}

	public QVTimperativeASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitMapping(@NonNull Mapping object) {
		//		List<@NonNull CheckVariableStatement> assignments = ClassUtil.nullFree(object.getBottomAssignments());
		//		ClassUtil.sort(assignments, new AssignmentComparator(assignments));
		//		ClassUtil.sort(ClassUtil.nullFree(object.getGuardPredicates()), PredicateComparator.INSTANCE);
		//		QVTimperativeUtil.sortPatternVariables(ClassUtil.nullFree(object.getInoutVariables()));
		//		QVTimperativeUtil.sortPatternVariables(ClassUtil.nullFree(object.getOwnedPredicateVariables()));
		//		ClassUtil.sort(ClassUtil.nullFree(object.getRealizedVariable()), NameUtil.NAMEABLE_COMPARATOR);
		return super.visitMapping(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		ClassUtil.sort(ClassUtil.nullFree(object.getOwnedMappingParameterBindings()), QVTimperativeUtil.MappingParameterBindingComparator.INSTANCE);
		return null;
	}

	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation object) {
		ClassUtil.sort(ClassUtil.nullFree(object.getOwnedOperations()), OperationComparator.INSTANCE);
		return super.visitTransformation(object);
	}
}
