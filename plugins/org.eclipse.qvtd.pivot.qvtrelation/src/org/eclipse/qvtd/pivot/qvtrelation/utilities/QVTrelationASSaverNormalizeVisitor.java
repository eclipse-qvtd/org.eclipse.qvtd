/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractQVTrelationASSaverNormalizeVisitor;

public class QVTrelationASSaverNormalizeVisitor extends AbstractQVTrelationASSaverNormalizeVisitor
{
	protected static final class PredicateComparator implements Comparator<@NonNull Predicate>
	{
		public static final @NonNull Comparator<@NonNull Predicate> INSTANCE = new PredicateComparator();

		@Override
		public int compare(@NonNull Predicate o1, @NonNull Predicate o2) {
			String n1 = o1.toString();
			String n2 = o2.toString();
			return n1.compareTo(n2);
		}
	}

	protected static final class RelationDomainComparator implements Comparator<@NonNull Domain>
	{
		public static final @NonNull Comparator<@NonNull Domain> INSTANCE = new RelationDomainComparator();

		@Override
		public int compare(@NonNull Domain o1, @NonNull Domain o2) {
			TypedModel tm1 = o1.getTypedModel();
			TypedModel tm2 = o2.getTypedModel();
			if (tm1 == null) {
				if (tm2 == null) {
					return System.identityHashCode(o1) - System.identityHashCode(o2);			// Two primitive domains 'never' happen
				}
				else {
					return -1;
				}
			}
			else {
				if (tm2 == null) {
					return 1;
				}
				else {
					String n1 = PivotUtil.getName(tm1);
					String n2 = PivotUtil.getName(tm2);
					return n1.compareTo(n2);
				}
			}
		}
	}

	protected static final class VariablesComparator implements Comparator<@NonNull Variable>
	{
		/**
		 * Normal shared variables are sorted by depth of variable referencing then by name to avod forward references.
		 */
		private final @NonNull Map<@NonNull Variable, @NonNull Integer> variable2depth = new HashMap<>();

		public VariablesComparator(@NonNull Iterable<@NonNull Variable> asVariables) {
			Map<@NonNull Variable, @NonNull Set<@NonNull VariableDeclaration>> variableDefinition2variableReferences = new HashMap<>();
			for (@NonNull Variable asVariable : asVariables) {
				OCLExpression asExpression = asVariable.getOwnedInit();
				if (asExpression != null) {
					Set<@NonNull VariableDeclaration> asReferences = new HashSet<>();
					variableDefinition2variableReferences.put(asVariable, asReferences);
					for (EObject eObject : new TreeIterable(asExpression, true)) {
						if (eObject instanceof VariableExp) {
							asReferences.add(PivotUtil.getReferredVariable((VariableExp)eObject));
						}
					}
				}
			}
			for (boolean tryAgain = true; tryAgain; ) {
				tryAgain = false;
				for (@NonNull Variable asVariableDefinition : variableDefinition2variableReferences.keySet()) {
					Set<@NonNull VariableDeclaration> asReferences = variableDefinition2variableReferences.get(asVariableDefinition);
					assert asReferences != null;
					for (@NonNull VariableDeclaration asVariableReference : new ArrayList<>(asReferences)) {
						Set<@NonNull VariableDeclaration> asNestedReferences = variableDefinition2variableReferences.get(asVariableReference);
						if ((asNestedReferences != null) && asReferences.addAll(asNestedReferences)) {
							tryAgain = true;
						}
					}
				}
			}
			Set<@NonNull Variable> residualVariables = new HashSet<>(variableDefinition2variableReferences.keySet());
			for (int depth = 1; !residualVariables.isEmpty(); depth = depth+1) {
				List<@NonNull Variable> thisDepth = new ArrayList<>();
				for (@NonNull Variable asVariableDefinition : residualVariables) {
					Set<@NonNull VariableDeclaration> asReferences = variableDefinition2variableReferences.get(asVariableDefinition);
					assert asReferences != null;
					boolean noReferences = true;
					for (@NonNull VariableDeclaration asVariableReference : asReferences) {
						if (residualVariables.contains(asVariableReference)) {
							noReferences = false;
							break;
						}
					}
					if (noReferences) {
						thisDepth.add(asVariableDefinition);
						variable2depth.put(asVariableDefinition, depth);
					}
				}
				if (thisDepth.isEmpty()) {
					break;
				}
				residualVariables.removeAll(thisDepth);
			}
		}

		@Override
		public int compare(@NonNull Variable o1, @NonNull Variable o2) {
			if (o1.isIsImplicit()) {
				if (o2.isIsImplicit()) {
					String n1 = o1.getType().toString();
					String n2 = o2.getType().toString();
					return n1.compareTo(n2);		// FIXME use hierarchical position to avoid ambiguity with duplicate types
				}
				else {
					return 1;
				}
			}
			else {
				if (o2.isIsImplicit()) {
					return -1;
				}
				else {
					Integer d1 = variable2depth.get(o1);
					Integer d2 = variable2depth.get(o2);
					if (d1 == null) {
						d1 = 0;
					}
					if (d2 == null) {
						d2 = 0;
					}
					if (d1 != d2) {
						return d1 - d2;
					}
					String n1 = PivotUtil.getName(o1);
					String n2 = PivotUtil.getName(o2);
					return n1.compareTo(n2);
				}
			}
		}
	}

	public QVTrelationASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitDomainPattern(@NonNull DomainPattern object) {
		@SuppressWarnings("null") Comparator<@NonNull Nameable> nameableComparator = NameUtil.NAMEABLE_COMPARATOR;
		ClassUtil.sort(QVTrelationUtil.Internal.getBindsToList(object), nameableComparator);
		return null;
	}

	@Override
	public @Nullable Object visitRelation(@NonNull Relation object) {
		// Domain Ordering is significant
		List<@NonNull Variable> ownedVariablesList = QVTrelationUtil.Internal.getOwnedVariablesList(object);
		if (ownedVariablesList.size() > 1) {
			ClassUtil.sort(ownedVariablesList, new VariablesComparator(ownedVariablesList));
			int iNext = 1;
			for (@NonNull Variable asVariable : ownedVariablesList) {
				if (asVariable.isIsImplicit()) {
					asVariable.setName("_" + iNext++);
				}
			}
		}
		Pattern asWhen = object.getWhen();
		if (asWhen != null) {
			List<@NonNull Predicate> asPredicates = QVTrelationUtil.Internal.getPredicatesList(asWhen);
			if (asPredicates.size() > 1) {
				ClassUtil.sort(asPredicates, PredicateComparator.INSTANCE);
			}
		}
		Pattern asWhere = object.getWhere();
		if (asWhere != null) {
			List<@NonNull Predicate> asPredicates = QVTrelationUtil.Internal.getPredicatesList(asWhere);
			if (asPredicates.size() > 1) {
				ClassUtil.sort(asPredicates, PredicateComparator.INSTANCE);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitRelationDomain(@NonNull RelationDomain object) {
		return null;
	}

	@Override
	public @Nullable Object visitRelationalTransformation(@NonNull RelationalTransformation object) {
		@SuppressWarnings("null") Comparator<@NonNull Nameable> nameableComparator = NameUtil.NAMEABLE_COMPARATOR;
		ClassUtil.sort(QVTrelationUtil.Internal.getOwnedRelationsList(object), nameableComparator);
		return super.visitRelationalTransformation(object);
	}
}
