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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
	 * A RelationVariableAnalysis accumulates the usage of a relation variable and eventually synthesizes an appropriate core variable.
	 */
	public class RelationVariableAnalysis extends AbstractVariableAnalysis
	{
		protected final @NonNull Variable rVariable;
		private @Nullable Key rKey = null;
		private @Nullable TemplateExp rTemplateExp = null;
		private boolean isEnforcedBound = false;
		private boolean isEnforcedReferred = false;
		private @Nullable CoreDomain cOtherBound = null;
		private @Nullable CoreDomain cOtherReferred = null;
		private @Nullable Area cPredicateArea = null;
		private @Nullable Area cThisArea = null;
		private boolean isRoot = false;
		private @Nullable CoreDomain cWhenDomain = null;
		private @Nullable CoreDomain cWhereDomain = null;
		private @Nullable Variable cVariable;
		
		public RelationVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull Variable rVariable) {
			super(variablesAnalysis, ClassUtil.nonNullState(rVariable.getName()));
			assert !"this".equals(rVariable.getName());
			this.rVariable = rVariable;
		}

		/**
		 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
		 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
		 */
		@Override
		public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression) {
			Key rKey2 = rKey;
			if (isKeyed() && (rKey2 != null)) {
				if (rKey2.getPart().contains(targetProperty)) {
					return;
				}
				if (rKey2.getOppositePart().contains(targetProperty.getOpposite())) {
					return;
				}
			}
			Variable cVariable2 = getCoreVariable();
			List<Assignment> cMiddleBottomAssignments = variablesAnalysis.getMiddleBottomPattern().getAssignment();
			if (!targetProperty.isIsMany() || (cExpression.getType() instanceof CollectionType)) {
				VariableExp cSlotVariableExp = variablesAnalysis.createVariableExp(cVariable2);
				NavigationAssignment cAssignment = variablesAnalysis.createNavigationAssignment(cSlotVariableExp, targetProperty, cExpression);
				QVTr2QVTc.SYNTHESIS.println("  addPropertyAssignment " + cAssignment);
				variablesAnalysis.assertNewAssignment(cMiddleBottomAssignments, cAssignment);
				cMiddleBottomAssignments.add(cAssignment);
				return;
			}
			Property cOppositeProperty = targetProperty.getOpposite();
			if ((cOppositeProperty != null) && (cExpression instanceof VariableExp) && (!cOppositeProperty.isIsMany() || (cVariable2.getType() instanceof CollectionType))) {
				VariableExp cSlotVariableExp = (VariableExp)cExpression;
				NavigationAssignment cAssignment = variablesAnalysis.createNavigationAssignment(cSlotVariableExp, cOppositeProperty, variablesAnalysis.createVariableExp(cVariable2));
				QVTr2QVTc.SYNTHESIS.println("  addOppositePropertyAssignment " + cAssignment);
				variablesAnalysis.assertNewAssignment(cMiddleBottomAssignments, cAssignment);
				cMiddleBottomAssignments.add(cAssignment);
				return;
			}
			throw new IllegalStateException("Unsupported collection assign " + cVariable2 + " . " + targetProperty + " := " + cExpression);
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
			boolean isRealized = isRealized();
			assert (cVariable != null) && (cVariable.eContainer() == cPattern);
			assert (cVariable instanceof RealizedVariable) == isRealized;
		}
		
		@Override
		public @NonNull CorePattern getCorePattern() {
			Area cArea = null;
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
				cArea = rKey != null ? variablesAnalysis.cMapping : variablesAnalysis.cEnforcedDomain;
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
			else if (cThisArea != null) {
				isGuard = false;
				cArea = cThisArea;
			}
			assert cArea != null;
			return ClassUtil.nonNullState(isGuard ? cArea.getGuardPattern() : cArea.getBottomPattern());
		}

		@Override
		public @NonNull Variable getCoreVariable() {
			Variable cVariable2 = cVariable;
			if (cVariable2 == null) {
				cVariable2 = synthesize();
			}
			return cVariable2;
		}

		@Override
		public @NonNull Variable getRelationVariable() {
			return rVariable;
		}
		
		private void initializeKeyedVariable(@NonNull Variable cKeyedVariable) {
			Function function = variablesAnalysis.qvtr2qvtc.getKeyFunction(ClassUtil.nonNull(rKey));
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
						asArguments.add(variablesAnalysis.createInvalidExpression());
					}
				}
			}
			Variable cThisVariable = variablesAnalysis.getCoreThisVariable();
			OCLExpression asConstructor = variablesAnalysis.createOperationCallExp(variablesAnalysis.createVariableExp(cThisVariable), function, asArguments);
//			addConditionPredicate(cMiddleBottomPattern, createVariableExp(cKeyedVariable), asConstructor);
			@NonNull VariableAssignment cVariableAssignment = variablesAnalysis.createVariableAssignment(cKeyedVariable, asConstructor);
			variablesAnalysis.getMiddleBottomPattern().getAssignment().add(cVariableAssignment);
		}
		
		private boolean isKeyed() {
			boolean isKeyed = false;
			if (cWhenDomain != null) {
			}
			else if (variablesAnalysis.isInvoked && isRoot) {
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isKeyed = rKey != null;
			}
			return isKeyed;
		}
		
		private boolean isRealized() {
			boolean isRealized = false;
			if (cWhenDomain != null) {
			}
			else if (variablesAnalysis.isInvoked && isRoot) {
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isRealized = rKey == null;
			}
			return isRealized;
		}

		@Override
		public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @Nullable Key rKey) {
			assert !isEnforcedBound;
			assert this.cOtherBound == null;
			assert this.rKey == null;
			assert this.rTemplateExp == null;
			this.isEnforcedBound = true;
			this.rTemplateExp = rTemplateExp;
			this.rKey = rKey;
		}

		@Override
		public void setIsEnforcedReferred() {
			this.isEnforcedReferred = true;
		}

		@Override
		public void setIsRoot() {
			this.isRoot = true;
		}

		@Override
		public void setOtherBound(@NonNull CoreDomain otherDomain) {
			assert !isEnforcedBound;
			assert this.cOtherBound == null;
			this.cOtherBound = otherDomain;
		}

		@Override
		public void setOtherReferred(@NonNull CoreDomain cOtherDomain) {
			assert (this.cOtherReferred == null) || (this.cOtherReferred == cOtherDomain);
			this.cOtherReferred = cOtherDomain;
		}

		@Override
		public void setPredicate(@NonNull Area cPredicateArea) {
			this.cPredicateArea = cPredicateArea;
		}

		@Override
		public void setWhen(@NonNull CoreDomain cWhenDomain) {
			assert (this.cWhenDomain == null) || (this.cWhenDomain == cWhenDomain);
			this.cWhenDomain = cWhenDomain;
		}

		@Override
		public void setWhere(@NonNull CoreDomain cWhereDomain) {
			assert (this.cWhereDomain == null) || (this.cWhereDomain == cWhereDomain);
			this.cWhereDomain = cWhereDomain;
		}

		protected @NonNull Variable synthesize() {
			Variable cVariable2 = cVariable;
			if (cVariable2 == null) {
				CorePattern cPattern = getCorePattern();
				boolean isKeyed = isKeyed();
				boolean isRealized = isRealized();
				//
				Type type = ClassUtil.nonNullState(rVariable.getType());
				if (isKeyed) {
					cVariable2 = variablesAnalysis.createVariable(name, type, true, null);
					initializeKeyedVariable(cVariable2);
					cPattern.getVariable().add(cVariable2);
				}
				else if (!isRealized) {
					cVariable2 = variablesAnalysis.createVariable(name, type, rVariable.isIsRequired(), null);
					cPattern.getVariable().add(cVariable2);
				}
				else  {
					RealizedVariable cRealizedVariable = variablesAnalysis.createRealizedVariable(name, type);
					((BottomPattern)cPattern).getRealizedVariable().add(cRealizedVariable);
					cVariable2 = cRealizedVariable;
				}
				cVariable = cVariable2;
				variablesAnalysis.addVariableAnalysis(this);
			}
			return cVariable2;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(rVariable.toString());
			if (cWhenDomain != null) {
				s.append(" WHEN:" + cWhenDomain.getName());
			}
			if (cWhereDomain != null) {
				s.append(" WHERE:" + cWhereDomain.getName());
			}
			if (variablesAnalysis.isInvoked) {
				s.append(" INVOKED");
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