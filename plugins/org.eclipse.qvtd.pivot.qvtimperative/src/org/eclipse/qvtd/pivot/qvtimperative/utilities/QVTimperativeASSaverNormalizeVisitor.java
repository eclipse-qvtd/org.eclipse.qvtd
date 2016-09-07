/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.utilities;

import java.util.Comparator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.CorePattern;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeASSaverNormalizeVisitor;

public class QVTimperativeASSaverNormalizeVisitor extends AbstractQVTimperativeASSaverNormalizeVisitor
{
	protected static final class PredicateComparator implements Comparator<@NonNull Predicate>
	{
		public static final @NonNull Comparator<@NonNull Predicate> INSTANCE = new PredicateComparator();

		@Override
		public int compare(@NonNull Predicate o1, @NonNull Predicate o2) {
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
	public @Nullable Object visitBottomPattern(@NonNull BottomPattern object) {
		List<@NonNull Assignment> assignments = ClassUtil.nullFree(object.getAssignment());
		ClassUtil.sort(assignments, new AssignmentComparator(assignments));
		ClassUtil.sort(ClassUtil.nullFree(object.getRealizedVariable()), NameUtil.NAMEABLE_COMPARATOR);
		return super.visitBottomPattern(object);
	}

	@Override
	public @Nullable Object visitCorePattern(@NonNull CorePattern object) {
		ClassUtil.sort(ClassUtil.nullFree(object.getPredicate()), PredicateComparator.INSTANCE);
		QVTimperativeUtil.sortPatternVariables(ClassUtil.nullFree(object.getVariable()));
		return super.visitPattern(object);
	}

	@Override
	public @Nullable Boolean visitMappingCall(@NonNull MappingCall object) {
		ClassUtil.sort(ClassUtil.nullFree(object.getBinding()), QVTimperativeUtil.MappingCallBindingComparator.INSTANCE);
		return null;
	}
}
