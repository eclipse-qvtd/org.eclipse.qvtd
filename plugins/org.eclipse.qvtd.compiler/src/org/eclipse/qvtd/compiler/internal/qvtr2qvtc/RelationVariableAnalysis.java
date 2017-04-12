/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * A RelationVariableAnalysis accumulates the usage of a relation variable and eventually synthesizes an appropriate core variable.
 */
public class RelationVariableAnalysis extends AbstractVariableAnalysis
{
	enum Strategy {
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
	 * Non-null non-enforced domain defining this variable, set by setOtherBound.
	 */
	private @Nullable CoreDomain cOtherBound = null;
	/**
	 * Non-null non-enforced domain referencing this variable, set by setOtherReferred.
	 */
	private @Nullable CoreDomain cOtherReferred = null;
	//	private @Nullable Area cThisArea = null;
	/**
	 * True if this variable is a root variable, set by setIsRoot.
	 */
	private boolean isRoot = false;
	/**
	 * Non-null domain of a when invocation that references this variable.
	 */
	private @Nullable CoreDomain cWhenDomain = null;
	/**
	 * Non-null domain of a where invocation that references this variable.
	 */
	private @Nullable CoreDomain cWhereDomain = null;
	// Analysis conclusion
	/**
	 * FIXME: eliminate this derived state
	 */
	private @Nullable Area cPredicateArea = null;
	/**
	 * The startegy appropriate to the analysis contributions.
	 */
	private @Nullable Strategy strategy = null;
	/**
	 * The corresponding synthesized core variable.
	 */
	private @Nullable Variable cVariable;

	public RelationVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull Variable rVariable) {
		super(variablesAnalysis, ClassUtil.nonNullState(rVariable.getName()));
		assert !"this".equals(rVariable.getName());
		this.rVariable = rVariable;
		assert !(rVariable instanceof IteratorVariable);
		assert !(rVariable instanceof LetVariable);
	}

	/**
	 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
	 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
	 * @throws CompilerChainException
	 */
	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		Key rKey2 = rKey;
		boolean isKeyed = getStrategy() == Strategy.KEYED;
		if (isKeyed && (rKey2 != null)) {
			if (rKey2.getPart().contains(targetProperty)) {
				return;
			}
			if (rKey2.getOppositePart().contains(targetProperty.getOpposite())) {
				return;
			}
		}
		Variable cVariable2 = getCoreVariable();
		List<@NonNull Assignment> cMiddleBottomAssignments = QVTcoreUtil.Internal.getOwnedAssignmentsList(variablesAnalysis.getMiddleBottomPattern());
		if (isPartial == null) {
			isPartial = targetProperty.isIsMany() && !(cExpression.getType() instanceof CollectionType);
		}
		//		if (isPartial == isPartial2) {
		VariableExp cSlotVariableExp = variablesAnalysis.createVariableExp(cVariable2);
		NavigationAssignment cAssignment = variablesAnalysis.createNavigationAssignment(cSlotVariableExp, targetProperty, cExpression, isPartial);
		QVTr2QVTc.SYNTHESIS.println("  addPropertyAssignment " + cAssignment);
		variablesAnalysis.assertNewAssignment(cMiddleBottomAssignments, cAssignment);
		cMiddleBottomAssignments.add(cAssignment);
		return;
		//		}
		/*		Property cOppositeProperty = targetProperty.getOpposite();
		if ((cOppositeProperty != null) && (cExpression instanceof VariableExp) && (!cOppositeProperty.isIsMany() || (cVariable2.getType() instanceof CollectionType))) {
			VariableExp cSlotVariableExp = (VariableExp)cExpression;
			NavigationAssignment cAssignment = variablesAnalysis.createNavigationAssignment(cSlotVariableExp, cOppositeProperty, variablesAnalysis.createVariableExp(cVariable2), isPartial);
			QVTr2QVTc.SYNTHESIS.println("  addOppositePropertyAssignment " + cAssignment);
			variablesAnalysis.assertNewAssignment(cMiddleBottomAssignments, cAssignment);
			cMiddleBottomAssignments.add(cAssignment);
			return;
		} */
		//		throw new IllegalStateException("Unsupported collection assign " + cVariable2 + " . " + targetProperty + " := " + cExpression);
	}

	public @Nullable RealizedVariable basicGetCoreRealizedVariable() {
		return (RealizedVariable)cVariable;
	}

	public @Nullable Variable basicGetCoreVariable() {
		return cVariable;
	}

	@Override
	public void check() {
		if (cVariable == null) {
			System.err.println("No cVariable for " + this);
			return;
		}
		CorePattern cPattern = getCorePattern();
		boolean isRealized =  getStrategy() == Strategy.REALIZED_BOTTOM;
		assert (cVariable != null) && ((cVariable.eContainer() == cPattern) || (cVariable instanceof IteratorVariable) || (cVariable instanceof LetVariable));
		assert (cVariable instanceof RealizedVariable) == (isRealized && !(cVariable.getType() instanceof DataType));
	}

	private @NonNull Strategy computeStrategy() {
		if ((cWhenDomain == null) && !(variablesAnalysis.isInvoked() && isRoot) && isEnforcedBound && (rKey != null)) { // isKeyed()
			assert rEnforcedTypedModel != null;
			assert rKey != null;
			//			assert rTemplateExp == null;
			assert isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert cOtherBound == null;
			assert cOtherReferred == null;
			//			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.KEYED;
		}
		else if ((cWhenDomain == null) && !(variablesAnalysis.isInvoked() && isRoot) && isEnforcedBound && (rKey == null)) { // isRealized()
			assert rEnforcedTypedModel != null;
			assert rKey == null;
			assert rTemplateExp != null;
			assert isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert cOtherBound == null;
			assert cOtherReferred == null;
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
			assert cOtherBound == null;
			//			assert cOtherReferred == null;
			//			assert isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.ENFORCED_GUARD;
		}
		else if ((cWhenDomain != null)
				|| (isEnforcedBound && variablesAnalysis.isInvoked() && isRoot) //rKey != null;
				|| (!isEnforcedBound && (cOtherBound != null) && isRoot)
				|| (!isEnforcedBound && (cOtherBound == null) && !(isEnforcedReferred && (cOtherReferred != null)) && (cOtherReferred == null) && (cPredicateArea == null) && isEnforcedReferred && (cOtherReferred == null))) {
			assert rEnforcedTypedModel == null;
			//			assert rKey == null;
			//			assert rTemplateExp != null;
			assert !isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert (cOtherBound != null) || (cOtherReferred != null) || (cWhenDomain != null) || (cWhereDomain != null);
			//			assert isRoot;
			return Strategy.OTHER_GUARD;
		}
		else if (cOtherBound != null) {
			assert rEnforcedTypedModel == null;
			assert rKey == null;
			//			assert rTemplateExp != null;
			assert !isEnforcedBound;
			//			assert !isEnforcedReferred;
			assert cOtherBound != null;
			//			assert cOtherReferred == null;
			assert !isRoot;
			//			assert cWhenDomain == null;
			//			assert cWhereDomain == null;
			return Strategy.OTHER_BOTTOM;
		}
		else if (isEnforcedReferred && (cOtherReferred != null)) {
			assert rEnforcedTypedModel == null;
			assert rKey == null;
			assert rTemplateExp == null;
			assert !isEnforcedBound;
			assert isEnforcedReferred;
			assert cOtherBound == null;
			assert cOtherReferred != null;
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
			assert (cOtherBound != null) || (cOtherReferred != null) || (cWhenDomain != null) || (cWhereDomain != null);
			assert !isRoot;
			return Strategy.OTHER_BOTTOM;
		}
	}

	@Override
	public @NonNull CorePattern getCorePattern() {
		/*		Area cArea = null;
		boolean isGuard = false;
		if (cWhenDomain != null) {
			isGuard = true;
			//				assert isEnforcedBound || (otherBound != null);
			cArea = cWhenDomain; //isEnforcedBound ? cEnforcedDomain : otherBound;
		}
		//				else if (isWhere) {
		//				}
		else if (isEnforcedBound) {
			isGuard = variablesAnalysis.isInvoked && isRoot; //rKey != null;
			cArea = /*rKey != null ? variablesAnalysis.cMapping :* / variablesAnalysis.cEnforcedDomain;
		}
		else if (cOtherBound != null) {
			isGuard = isRoot;
			cArea = cOtherBound;
		}
		else if (isEnforcedReferred && (cOtherReferred != null)) {
			isGuard = false;
			cArea = variablesAnalysis.cMapping;
		}
		else if (cOtherReferred != null) {
			isGuard = false;
			cArea = cOtherReferred;
		}
		else if (cPredicateArea != null) {
			isGuard = false;
			cArea = cPredicateArea;
		}
		//		else if (cThisArea != null) {
		//			isGuard = false;
		//			cArea = cThisArea;
		//		}
		else if (isEnforcedReferred && (cOtherReferred == null)) {
			isGuard = true;
			cArea = variablesAnalysis.cEnforcedDomain;
		}
		assert cArea != null;
		assert isGuard == (strategy2 == Strategy.ENFORCED_GUARD) || (strategy2 == Strategy.OTHER_GUARD);
		CorePattern cPattern = null; */
		switch (getStrategy()) {
			case ENFORCED_GUARD:
				return QVTcoreUtil.getGuardPattern(variablesAnalysis.cEnforcedDomain);
			case KEYED:
				return QVTcoreUtil.getBottomPattern(variablesAnalysis.cEnforcedDomain);
			case OTHER_BOTTOM:
				return QVTcoreUtil.getBottomPattern(getOtherDomain());
			case OTHER_GUARD:
				return QVTcoreUtil.getGuardPattern(getOtherDomain());
			case REALIZED_BOTTOM:
				return QVTcoreUtil.getBottomPattern(variablesAnalysis.cEnforcedDomain);
			case SHARED_BOTTOM:
				return variablesAnalysis.cMiddleBottomPattern;
		}
		throw new IllegalStateException("A " + strategy + " variable has no CoreDomain");
	}

	@Override
	public @NonNull Variable getCoreVariable() throws CompilerChainException {
		Variable cVariable2 = cVariable;
		if (cVariable2 == null) {
			cVariable2 = synthesize();
		}
		return cVariable2;
	}

	private @NonNull CoreDomain getOtherDomain() throws IllegalStateException {
		if (cOtherBound != null) {
			return cOtherBound;
		}
		else if (cOtherReferred != null) {
			return cOtherReferred;
		}
		else if (cWhenDomain != null) {
			return cWhenDomain;
		}
		else if (cWhereDomain != null) {
			return cWhereDomain;
		}
		throw new IllegalStateException("Failed to determine other pattern for " + this);
	}

	@Override
	public @NonNull Variable getRelationVariable() {
		return rVariable;
	}

	protected @NonNull Strategy getStrategy() {
		Strategy strategy2 = strategy;
		if (strategy2 == null) {
			strategy = strategy2 = computeStrategy();
		}
		return strategy2;
	}

	@Override
	public boolean hasWhenDomain() {
		return cWhenDomain != null;
	}

	private void initializeKeyedVariable(@NonNull Variable cKeyedVariable) throws CompilerChainException {
		TypedModel rEnforcedTypedModel2 = ClassUtil.nonNull(rEnforcedTypedModel);
		Key rKey2 = ClassUtil.nonNull(rKey);
		Function function = variablesAnalysis.qvtr2qvtc.getKeyFunction(rEnforcedTypedModel2, rKey2);
		List<@NonNull OCLExpression> asArguments = new ArrayList<@NonNull OCLExpression>();
		if (rTemplateExp instanceof ObjectTemplateExp) {
			ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)rTemplateExp;
			for (@NonNull Parameter keyParameter : ClassUtil.nullFree(function.getOwnedParameters())) {
				OCLExpression parameterExp = variablesAnalysis.getTemplateExp(objectTemplateExp, keyParameter);
				if (parameterExp instanceof TemplateExp) {
					Variable rVariable = ClassUtil.nonNullState(((TemplateExp)parameterExp).getBindsTo());
					Variable cVariable = variablesAnalysis.getCoreVariable(rVariable);
					asArguments.add(variablesAnalysis.createVariableExp(cVariable));
				}
				else if (parameterExp instanceof VariableExp) {
					Variable rVariable = (Variable) ClassUtil.nonNullState(((VariableExp)parameterExp).getReferredVariable());
					Variable cVariable = variablesAnalysis.getCoreVariable(rVariable);
					asArguments.add(variablesAnalysis.createVariableExp(cVariable));
				}
				else {
					throw new CompilerChainException("Missing ''{1}'' value for ''{0}'' key.", rKey2.getIdentifies().getName(), keyParameter.getName());
					//					asArguments.add(variablesAnalysis.createInvalidExpression());
				}
			}
		}
		Variable cThisVariable = variablesAnalysis.getCoreThisVariable();
		OCLExpression asConstructor = variablesAnalysis.createOperationCallExp(variablesAnalysis.createVariableExp(cThisVariable), function, asArguments);
		//			addConditionPredicate(cMiddleBottomPattern, createVariableExp(cKeyedVariable), asConstructor);
		@NonNull VariableAssignment cVariableAssignment = variablesAnalysis.createVariableAssignment(cKeyedVariable, asConstructor);
		variablesAnalysis.getMiddleBottomPattern().getAssignment().add(cVariableAssignment);
	}

	@Override
	public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @NonNull TypedModel rEnforcedTypedModel, @Nullable Key rKey) {
		assert strategy == null;
		assert !isEnforcedBound;
		assert this.cOtherBound == null;
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
	public void setOtherBound(@NonNull CoreDomain otherDomain) {
		assert strategy == null;
		assert !isEnforcedBound;
		assert this.cOtherBound == null;
		this.cOtherBound = otherDomain;
	}

	@Override
	public void setOtherReferred(@NonNull CoreDomain cOtherDomain) {
		assert strategy == null;
		assert (this.cOtherReferred == null) || (this.cOtherReferred == cOtherDomain);
		this.cOtherReferred = cOtherDomain;
	}

	@Override
	public void setPredicate(@NonNull Area cPredicateArea) {
		assert strategy == null;
		this.cPredicateArea = cPredicateArea;
	}

	@Override
	public void setWhen(@NonNull CoreDomain cWhenDomain) {
		assert strategy == null;
		assert (this.cWhenDomain == null) || (this.cWhenDomain == cWhenDomain);
		this.cWhenDomain = cWhenDomain;
	}

	@Override
	public void setWhere(@NonNull CoreDomain cWhereDomain) {
		assert strategy == null;
		assert (this.cWhereDomain == null) || (this.cWhereDomain == cWhereDomain);
		this.cWhereDomain = cWhereDomain;
	}

	protected @NonNull Variable synthesize() throws CompilerChainException {
		Variable cVariable2 = cVariable;
		if (cVariable2 == null) {
			Strategy strategy2 = getStrategy();
			Type type = QVTrelationUtil.getType(rVariable);
			switch (strategy2) {
				case ENFORCED_GUARD: {
					cVariable2 = variablesAnalysis.createGuardVariable(name, type, rVariable.isIsRequired(), null);
					variablesAnalysis.cEnforcedDomain.getGuardPattern().getVariable().add(cVariable2);
					break;
				}
				case KEYED: {
					cVariable2 = variablesAnalysis.createBottomVariable(name, type, true, null);
					initializeKeyedVariable(cVariable2);			// FIXME can recurse - is stability guaranteed?
					variablesAnalysis.cEnforcedDomain.getBottomPattern().getVariable().add(cVariable2);
					break;
				}
				case OTHER_BOTTOM: {
					cVariable2 = variablesAnalysis.createBottomVariable(name, type, rVariable.isIsRequired(), null);
					getOtherDomain().getBottomPattern().getVariable().add(cVariable2);
					break;
				}
				case OTHER_GUARD: {
					cVariable2 = variablesAnalysis.createGuardVariable(name, type, rVariable.isIsRequired(), null);
					getOtherDomain().getGuardPattern().getVariable().add(cVariable2);
					break;
				}
				case REALIZED_BOTTOM: {
					if ((type instanceof CollectionType)) {
						cVariable2 = variablesAnalysis.createBottomVariable(name, type, rVariable.isIsRequired(), null);
						variablesAnalysis.cEnforcedDomain.getBottomPattern().getVariable().add(cVariable2);
					}
					else {
						RealizedVariable cRealizedVariable = variablesAnalysis.createRealizedVariable(name, type);
						variablesAnalysis.cEnforcedDomain.getBottomPattern().getRealizedVariable().add(cRealizedVariable);
						cVariable2 = cRealizedVariable;
					}
					break;
				}
				case SHARED_BOTTOM: {
					cVariable2 = variablesAnalysis.createBottomVariable(name, type, rVariable.isIsRequired(), null);
					variablesAnalysis.cMiddleBottomPattern.getVariable().add(cVariable2);
					break;
				}
				default: {
					throw new IllegalStateException("Failed to identify strategy for variable " + this);
				}
			}
			cVariable = cVariable2;
			variablesAnalysis.addVariableAnalysis(this);
		}
		return cVariable2;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(rVariable.toString());
		if (cWhenDomain != null) {
			s.append(" WHEN:" + cWhenDomain.getName());
		}
		if (cWhereDomain != null) {
			s.append(" WHERE:" + cWhereDomain.getName());
		}
		if (variablesAnalysis.isWhened()) {
			s.append(" WHENED");
		}
		if (variablesAnalysis.isWhered()) {
			s.append(" WHERED");
		}
		if (cPredicateArea != null) {
			s.append(" PREDICATE:" + (cPredicateArea instanceof CoreDomain ? ((CoreDomain)cPredicateArea).getName() : null));
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
		if (cOtherBound != null) {
			s.append(" OTHER:" + cOtherBound.getName());
		}
		else if (cOtherReferred != null) {
			s.append(" other:" + cOtherReferred.getName());
		}
		if (rTemplateExp != null) {
			s.append(" " + rTemplateExp);
		}
		return s.toString();
	}
}