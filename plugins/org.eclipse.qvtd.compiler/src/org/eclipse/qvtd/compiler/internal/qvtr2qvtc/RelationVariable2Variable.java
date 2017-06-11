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
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationVariableAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationVariableAnalysis.Strategy;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
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
public class RelationVariable2Variable extends AbstractVariable2Variable
{
	private final @NonNull RelationVariableAnalysis variableAnalysis;
	/**
	 * The corresponding synthesized core variable.
	 */
	private @Nullable Variable cVariable;

	public RelationVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull Variable rVariable) {
		super(variablesAnalysis, QVTrelationUtil.getName(rVariable));
		this.variableAnalysis = new RelationVariableAnalysis(variablesAnalysis, rVariable);
	}

	/**
	 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
	 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
	 * @throws CompilerChainException
	 */
	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		Key rKey = variableAnalysis.getrKey();
		boolean isKeyed = variableAnalysis.getStrategy() == Strategy.KEYED;
		if (isKeyed && (rKey != null)) {
			if (rKey.getPart().contains(targetProperty)) {
				return;
			}
			if (rKey.getOppositePart().contains(targetProperty.getOpposite())) {
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
		boolean isRealized =  variableAnalysis.getStrategy() == Strategy.REALIZED_BOTTOM;
		assert (cVariable != null) && ((cVariable.eContainer() == cPattern) || (cVariable instanceof IteratorVariable) || (cVariable instanceof LetVariable));
		assert (cVariable instanceof RealizedVariable) == (isRealized && !(cVariable.getType() instanceof DataType));
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
		Strategy strategy = variableAnalysis.getStrategy();
		switch (strategy) {
			case ENFORCED_GUARD:
				return QVTcoreUtil.getGuardPattern(variablesAnalysis.cEnforcedDomain);
			case KEYED:
				return QVTcoreUtil.getBottomPattern(variablesAnalysis.cEnforcedDomain);
			case OTHER_BOTTOM:
				return QVTcoreUtil.getBottomPattern(variablesAnalysis.getCoreDomain(getOtherTypedModel()));
			case OTHER_GUARD:
				return QVTcoreUtil.getGuardPattern(variablesAnalysis.getCoreDomain(getOtherTypedModel()));
			case REALIZED_BOTTOM:
				return QVTcoreUtil.getBottomPattern(variablesAnalysis.cEnforcedDomain);
			case SHARED_BOTTOM:
				return variablesAnalysis.cMiddleBottomPattern;
		}
		throw new IllegalStateException("A " + strategy + " variable has no CoreDomain");
	}

	@Override
	public @NonNull Variable getCoreVariable() {
		Variable cVariable2 = cVariable;
		if (cVariable2 == null) {
			cVariable2 = synthesize();
		}
		return cVariable2;
	}

	private @NonNull TypedModel getOtherTypedModel() throws IllegalStateException {
		TypedModel rOtherBound = variableAnalysis.getrOtherBound();
		if (rOtherBound != null) {
			return rOtherBound;
		}
		TypedModel rOtherReferred = variableAnalysis.getrOtherReferred();
		if (rOtherReferred != null) {
			return rOtherReferred;
		}
		TypedModel rPredicate = variableAnalysis.getrPredicate();
		if (rPredicate != null) {
			return rPredicate;
		}
		TypedModel rWhenTypedModel = variableAnalysis.getrWhenTypedModel();
		if (rWhenTypedModel != null) {
			return rWhenTypedModel;
		}
		TypedModel rWhereTypedModel = variableAnalysis.getrWhereTypedModel();
		if (rWhereTypedModel != null) {
			return rWhereTypedModel;
		}
		throw new IllegalStateException("Failed to determine other pattern for " + this);
	}

	@Override
	public @Nullable Variable getRelationVariable() {
		return variableAnalysis.getRelationVariable();
	}

	@Override
	public boolean hasWhenDomain() {
		return variableAnalysis.hasWhenDomain();
	}

	private void initializeKeyedVariable(@NonNull Variable cKeyedVariable) {
		TypedModel rEnforcedTypedModel2 = ClassUtil.nonNull(variableAnalysis.getrEnforcedTypedModel());
		Key rKey2 = ClassUtil.nonNull(variableAnalysis.getrKey());
		Function function = variablesAnalysis.getRelationAnalysis().getTransformationAnalysis().getKeyFunction(rEnforcedTypedModel2, rKey2);
		List<@NonNull OCLExpression> asArguments = new ArrayList<@NonNull OCLExpression>();
		TemplateExp rTemplateExp = variableAnalysis.getrTemplateExp();
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
					throw new IllegalStateException(NLS.bind("Missing ''{1}'' value for ''{0}'' key.", rKey2.getIdentifies().getName(), keyParameter.getName()));
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
		variableAnalysis.setIsEnforcedBound(rTemplateExp, rEnforcedTypedModel, rKey);
	}

	@Override
	public void setIsEnforcedReferred() {
		variableAnalysis.setIsEnforcedReferred();
	}

	@Override
	public void setIsRoot() {
		variableAnalysis.setIsRoot();
	}

	@Override
	public void setOtherBound(@NonNull TypedModel rOtherTypedModel) {
		variableAnalysis.setOtherBound(rOtherTypedModel);
	}

	@Override
	public void setOtherReferred(@NonNull TypedModel rOtherTypedModel) {
		variableAnalysis.setOtherReferred(rOtherTypedModel);
	}

	@Override
	public void setPredicate(@NonNull TypedModel rPredicateTypedModel) {
		variableAnalysis.setPredicate(rPredicateTypedModel);
	}

	@Override
	public void setWhen(@NonNull TypedModel rWhenTypedModel) {
		variableAnalysis.setWhen(rWhenTypedModel);
	}

	@Override
	public void setWhere(@NonNull TypedModel rWhereTypedModel) {
		variableAnalysis.setWhere(rWhereTypedModel);
	}

	protected @NonNull Variable synthesize() {
		Variable cVariable2 = cVariable;
		if (cVariable2 == null) {
			Strategy strategy = variableAnalysis.getStrategy();
			Variable rVariable = variableAnalysis.getRelationVariable();
			Type type = QVTrelationUtil.getType(rVariable);
			switch (strategy) {
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
					variablesAnalysis.getCoreDomain(getOtherTypedModel()).getBottomPattern().getVariable().add(cVariable2);
					break;
				}
				case OTHER_GUARD: {
					cVariable2 = variablesAnalysis.createGuardVariable(name, type, rVariable.isIsRequired(), null);
					variablesAnalysis.getCoreDomain(getOtherTypedModel()).getGuardPattern().getVariable().add(cVariable2);
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
}