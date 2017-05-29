/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * A RelationVariableAnalysis accumulates the usage of a relation variable and eventually synthesizes an appropriate core variable.
 */
public class RelationVariableAnalysis extends AbstractVariableAnalysis
{
	public enum Strategy {
		ENFORCED_GUARD,
		KEYED,
		OTHER_BOTTOM,
		OTHER_GUARD,
		REALIZED_BOTTOM,
		SHARED_BOTTOM
	};
	// Constructed state
	/**
	 * The original relation variable.
	 */
	protected final @NonNull Variable rVariable;
	// Analysis contributions
	/**
	 * The enforced TypedModel of a TemplateExp.bindsTo that this variable, set by setIsEnforcedBound.
	 */
	private @Nullable TypedModel rEnforcedTypedModel = null;
	/**
	 * A Key that unifies usage of a TemplateExp.bindsTo that this variable, set by setIsEnforcedBound.
	 */
	private @Nullable Key rKey = null;
	/**
	 * A TemplateExp.bindsTo that this variable, set by setIsEnforcedBound.
	 */
	private @Nullable TemplateExp rTemplateExp = null;
	/**
	 * True if this variable is enforced, set by setIsEnforcedBound.
	 */
	private boolean isEnforcedBound = false;
	/**
	 * True if this variable is referenced by an enforced domain, set by setIsEnforcedReferred.
	 */
	private boolean isEnforcedReferred = false;
	/**
	 * Non-null non-enforced TypedModel defining this variable, set by setOtherBound.
	 */
	private @Nullable TypedModel rOtherBound = null;
	/**
	 * Non-null non-enforced TypedModel referencing this variable, set by setOtherReferred.
	 */
	private @Nullable TypedModel rOtherReferred = null;
	//	private @Nullable Area cThisArea = null;
	/**
	 * True if this variable is a root variable, set by setIsRoot.
	 */
	private boolean isRoot = false;
	/**
	 * Non-null domain of a when invocation that references this variable.
	 */
	private @Nullable TypedModel rWhenTypedModel = null;
	/**
	 * Non-null domain of a where invocation that references this variable.
	 */
	private @Nullable TypedModel rWhereTypedModel = null;
	// Analysis conclusion
	/**
	 * FIXME: eliminate this derived state
	 */
	private @Nullable TypedModel rPredicateTypedModel = null;
	/**
	 * The strategy appropriate to the analysis contributions.
	 */
	private @Nullable Strategy strategy = null;

	public RelationVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull Variable rVariable) {
		super(variablesAnalysis/*, ClassUtil.nonNullState(rVariable.getName())*/);
		assert !"this".equals(rVariable.getName());
		this.rVariable = rVariable;
		assert !(rVariable instanceof IteratorVariable);
		assert !(rVariable instanceof LetVariable);
	}

	private @NonNull Strategy computeStrategy() {
		if ((rWhenTypedModel == null) && !(variablesAnalysis.isInvoked() && isRoot) && isEnforcedBound && (rKey != null)) { // isKeyed()
			assert rEnforcedTypedModel != null;
			assert rKey != null;
			//			assert rTemplateExp == null;
			assert isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert rOtherBound == null;
			assert rOtherReferred == null;
			//			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.KEYED;
		}
		else if ((rWhenTypedModel == null) && !(variablesAnalysis.isWhered() && isRoot) && isEnforcedBound && (rKey == null)) { // isRealized()
			assert rEnforcedTypedModel != null;
			assert rKey == null;
			assert rTemplateExp != null;
			assert isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert rOtherBound == null;
			assert rOtherReferred == null;
			//			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.REALIZED_BOTTOM;
		}
		else if (rEnforcedTypedModel != null) {
			assert rEnforcedTypedModel != null;
			//			assert rKey == null;
			//			assert rTemplateExp != null;
			assert isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert rOtherBound == null;
			//			assert cOtherReferred == null;
			//			assert isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.ENFORCED_GUARD;
		}
		else if ((rWhenTypedModel != null)
				|| (isEnforcedBound && variablesAnalysis.isInvoked() && isRoot) //rKey != null;
				|| (!isEnforcedBound && (rOtherBound != null) && isRoot)
				|| (!isEnforcedBound && (rOtherBound == null) && !(isEnforcedReferred && (rOtherReferred != null)) && (rOtherReferred == null) && (rPredicateTypedModel == null) && isEnforcedReferred && (rOtherReferred == null))) {
			assert rEnforcedTypedModel == null;
			//			assert rKey == null;
			//			assert rTemplateExp != null;
			assert !isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert (rOtherBound != null) || (rOtherReferred != null) || (rWhenTypedModel != null) || (rWhereTypedModel != null);
			//			assert isRoot;
			return Strategy.OTHER_GUARD;
		}
		else if (rOtherBound != null) {
			assert rEnforcedTypedModel == null;
			assert rKey == null;
			//			assert rTemplateExp != null;
			assert !isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert rOtherBound != null;
			//			assert cOtherReferred == null;
			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.OTHER_BOTTOM;
		}
		else if (isEnforcedReferred && (rOtherReferred != null)) {
			assert rEnforcedTypedModel == null;
			assert rKey == null;
			assert rTemplateExp == null;
			assert !isEnforcedBound;
			assert isEnforcedReferred;
			assert rOtherBound == null;
			assert rOtherReferred != null;
			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.SHARED_BOTTOM;
		}
		else {
			assert rEnforcedTypedModel == null;
			assert rKey == null;
			//			assert rTemplateExp != null;
			assert !isEnforcedBound;
			assert !isEnforcedReferred;
			assert (rOtherBound != null) || (rOtherReferred != null) || (rWhenTypedModel != null) || (rWhereTypedModel != null);
			assert !isRoot;
			return Strategy.OTHER_BOTTOM;
		}
	}

	public TypedModel getrEnforcedTypedModel() {
		return rEnforcedTypedModel;
	}

	public Key getrKey() {
		return rKey;
	}

	public TemplateExp getrTemplateExp() {
		return rTemplateExp;
	}

	public TypedModel getrOtherBound() {
		return rOtherBound;
	}

	public TypedModel getrOtherReferred() {
		return rOtherReferred;
	}

	public TypedModel getrWhenTypedModel() {
		return rWhenTypedModel;
	}

	public TypedModel getrWhereTypedModel() {
		return rWhereTypedModel;
	}

	@Override
	public @NonNull Variable getRelationVariable() {
		return rVariable;
	}

	public @NonNull Strategy getStrategy() {
		Strategy strategy2 = strategy;
		if (strategy2 == null) {
			strategy = strategy2 = computeStrategy();
		}
		return strategy2;
	}

	@Override
	public boolean hasWhenDomain() {
		return rWhenTypedModel != null;
	}

	@Override
	public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @NonNull TypedModel rEnforcedTypedModel, @Nullable Key rKey) {
		assert strategy == null;
		assert !isEnforcedBound;
		assert this.rOtherBound == null;
		assert this.rEnforcedTypedModel == null;
		assert this.rKey == null;
		assert this.rTemplateExp == null;
		this.isEnforcedBound = true;
		this.rTemplateExp = rTemplateExp;
		this.rEnforcedTypedModel = rEnforcedTypedModel;
		this.rKey = rKey;
	}

	@Override
	public void setIsEnforcedReferred() {
		assert strategy == null;
		this.isEnforcedReferred = true;
	}

	@Override
	public void setIsRoot() {
		assert strategy == null;
		this.isRoot = true;
	}

	@Override
	public void setOtherBound(@NonNull TypedModel rOtherTypedModel) {
		assert strategy == null;
		assert !isEnforcedBound;
		assert this.rOtherBound == null;
		this.rOtherBound = rOtherTypedModel;
	}

	@Override
	public void setOtherReferred(@NonNull TypedModel rOtherTypedModel) {
		assert strategy == null;
		assert (this.rOtherReferred == null) || (this.rOtherReferred == rOtherTypedModel);
		this.rOtherReferred = rOtherTypedModel;
	}

	@Override
	public void setPredicate(@NonNull TypedModel rPredicateTypedModel) {
		assert strategy == null;
		this.rPredicateTypedModel = rPredicateTypedModel;
	}

	@Override
	public void setWhen(@NonNull TypedModel rWhenTypedModel) {
		assert strategy == null;
		assert (this.rWhenTypedModel == null) || (this.rWhenTypedModel == rWhenTypedModel);
		this.rWhenTypedModel = rWhenTypedModel;
	}

	@Override
	public void setWhere(@NonNull TypedModel rWhereTypedModel) {
		assert strategy == null;
		assert (this.rWhereTypedModel == null) || (this.rWhereTypedModel == rWhereTypedModel);
		this.rWhereTypedModel = rWhereTypedModel;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(rVariable.toString());
		if (rWhenTypedModel != null) {
			s.append(" WHEN:" + rWhenTypedModel.getName());
		}
		if (rWhereTypedModel != null) {
			s.append(" WHERE:" + rWhereTypedModel.getName());
		}
		if (variablesAnalysis.isWhened()) {
			s.append(" WHENED");
		}
		if (variablesAnalysis.isWhered()) {
			s.append(" WHERED");
		}
		if (rPredicateTypedModel != null) {
			s.append(" PREDICATE:" + rPredicateTypedModel.getName());
		}
		if (isRoot) {
			s.append(" ROOT");
		}
		if (rKey != null) {
			s.append(" KEYED");
		}
		if (isEnforcedBound) {
			s.append(" ENFORCED");
		}
		else if (isEnforcedReferred) {
			s.append(" enforced");
		}
		if (rOtherBound != null) {
			s.append(" OTHER:" + rOtherBound.getName());
		}
		else if (rOtherReferred != null) {
			s.append(" other:" + rOtherReferred.getName());
		}
		if (rTemplateExp != null) {
			s.append(" " + rTemplateExp);
		}
		return s.toString();
	}
}