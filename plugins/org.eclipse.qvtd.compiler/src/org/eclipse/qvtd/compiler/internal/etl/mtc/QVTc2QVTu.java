/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial research
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

/**
 * QVTc2QVTu transforms a QVTc transformation to impose the single direction defined by a QVTuConfiguration.
 * - the output domain is enforced
 * - other domains are not-enforced
 */
public class QVTc2QVTu extends AbstractQVTc2QVTc
{
	protected class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTc2QVTu>
	{
		public CreateVisitor(@NonNull QVTc2QVTu context) {
			super(context);
		}

		private boolean allReferencedVariablesInInputDomain(@NonNull PropertyAssignment a) {
			for (Variable v : MtcUtil.findReferencedVariables(a)) {
				if (!qvtuConfiguration.isInputDomain(QVTcoreBaseUtil.getContainingArea(v))) {
					return false;
				}
			}
			return true;
		}

		private boolean allReferencedVariablesInOutputDomain(@NonNull Predicate p) {
			for (Variable v : MtcUtil.findReferencedVariables(p.getConditionExpression())) {
				if (!qvtuConfiguration.isOutputDomain(QVTcoreBaseUtil.getContainingArea(v))) {
					return false;
				}
			}
			return true;
		}

		private boolean anyReferencedVariableInMiddleOrOutputDomain(@NonNull Predicate p) {
			for (Variable v : MtcUtil.findReferencedVariables(p.getConditionExpression())) {
				Area containingArea = QVTcoreBaseUtil.getContainingArea(v);
				if (qvtuConfiguration.isOutputDomain(containingArea) || qvtuConfiguration.isMiddleDomain(containingArea)) {
					return true;
				}
			}
			return false;
		}

/*		private @NonNull PropertyAssignment convertToPropertyAssignment(@NonNull PropertyCallExp propertyCallExp, @NonNull OCLExpression rightExpression) {
			PropertyAssignment paOut = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			context.addTrace((Predicate)propertyCallExp.eContainer().eContainer(), paOut);
			paOut.setTargetProperty(propertyCallExp.getReferredProperty());
			return paOut;
		} */
	
		//
		//	Assignments may mutate to Predicates.
		//
		@Override
		protected void doAssignments(@NonNull BottomPattern bIn, @NonNull BottomPattern bOut) {
			for (@NonNull Assignment aIn : ClassUtil.nullFree(bIn.getAssignment())) {
				Element aOut = create(aIn);
				if (aOut instanceof Predicate) {
					bOut.getPredicate().add((Predicate) aOut);
				}
				else if (aOut instanceof Assignment) {
					bOut.getAssignment().add((Assignment) aOut);
				}
				else if (aOut != null) {
					throw new UnsupportedOperationException();
				}
			}
		}

		//
		//	RealizedVariables may mutate to Variables.
		//
		@Override
		protected void doRealizedVariables(@NonNull BottomPattern bIn, @NonNull BottomPattern bOut) {
			for (RealizedVariable rvIn : ClassUtil.nullFree(bIn.getRealizedVariable())) {
				Variable vOut = create(rvIn);
				if (vOut instanceof RealizedVariable) {
					bOut.getRealizedVariable().add((RealizedVariable) vOut);
				}
				else {
					bOut.getVariable().add(vOut);
				}
			}
		}

		//
		//	CoreDomains enforcement is aligned to the direction
		//
		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			CoreDomain dOut = super.visitCoreDomain(dIn);
			dOut.setName(dIn.getTypedModel().getName());			// Redundant replication of Epsilon functionality
			if (context.qvtuConfiguration.isInputDomain(dIn)) {
				dOut.setIsEnforceable(false);
				dOut.setIsCheckable(true);
			} else {
				if (qvtuConfiguration.isCheckMode()) {
					dOut.setIsEnforceable(false);
				} else if (qvtuConfiguration.isEnforceMode()) {
					dOut.setIsCheckable(false);
				}
			}
			return dOut;
		}

		/*
		 * Override to redefine external URI.
		 */
		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
			CoreModel mOut = super.visitCoreModel(mIn);
			mOut.setExternalURI(mIn.getExternalURI().replace(".qvtcas", ".qvtu.qvtcas"));
			return mOut;
		}

		/*
		 * Override to suppresses nested scopes since QVTc references can be cross-domain and we convert mappings 1:1.
		 */
		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			doMapping(mIn, mOut);
	        return mOut;
		}

		//
		//	Output only bottom predicates are discarded.
		//
		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			if ((pIn.getPattern() instanceof BottomPattern) && allReferencedVariablesInOutputDomain(pIn)) {
				return null;
			}
			if ((pIn.getPattern() instanceof BottomPattern) && anyReferencedVariableInMiddleOrOutputDomain(pIn)) {
				return null;
			}
/*			OCLExpression conditionExpression = pIn.getConditionExpression();
			if (conditionExpression instanceof OperationCallExp) {
				OperationCallExp callExp = (OperationCallExp)conditionExpression;
				if ("=".equals(callExp.getReferredOperation().getName()) && (callExp.getOwnedArguments().size() == 1)) {		// FIXME more accuracy
					OCLExpression leftExpression= callExp.getOwnedSource();
					OCLExpression rightExpression= callExp.getOwnedArguments().get(0);
					if ((leftExpression != null) && (rightExpression != null)) {
						PropertyCallExp middlePropertyAccess = qvtuConfiguration.isMiddleDomainPropertyAccess(leftExpression);
						if ((middlePropertyAccess != null) && qvtuConfiguration.isInputDomainExpression(rightExpression)) {
							return convertToPropertyAssignment(middlePropertyAccess, rightExpression);
						}
						middlePropertyAccess = qvtuConfiguration.isMiddleDomainPropertyAccess(rightExpression);
						if ((middlePropertyAccess != null) && qvtuConfiguration.isInputDomainExpression(leftExpression)) {
							return convertToPropertyAssignment(middlePropertyAccess, leftExpression);
						}
					}
				}
			} */
			return super.visitPredicate(pIn);
		}

		//
		//	Right-to-Middle and Local-to-Middle property assignments are discarded.
		//	Left-to-Left and Middle-to-Left property assignments change to predicates.
		//	Left defaults are non-defaults.
		//
		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			if (qvtuConfiguration.isRtoM(paIn) || qvtuConfiguration.isLocaltoM(paIn)) {
				return null;
			}
			if (qvtuConfiguration.isMtoL(paIn)) {
				// Assignments to Predicates
//				Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
//				context.addTrace(paIn, pOut);
//	            pOut.setConditionExpression(MtcUtil.assignmentToOclExp(paIn, environmentFactory));
//	            return pOut;
				return null;
			}
			if (qvtuConfiguration.isFromInputDomain(paIn.getSlotExpression()) && allReferencedVariablesInInputDomain(paIn)) {
				// Assignments to Predicates
				Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
				context.addTrace(paIn, pOut);
				pOut.setConditionExpression(MtcUtil.assignmentToOclExp(paIn, environmentFactory));
	            return pOut;
			}
			if (qvtuConfiguration.isCheckMode() && paIn.isIsDefault() &&
					qvtuConfiguration.isOutputDomain(paIn.getBottomPattern().getArea())
					) {
				// Default assignments
				Element paOut = super.visitPropertyAssignment(paIn);
				assert paOut != null;
				((PropertyAssignment)paOut).setIsDefault(false);
				return paOut;
			}
			return super.visitPropertyAssignment(paIn);
		}

		//
		//	Input domain RealizedVariables are changed to unrealized Variables.
		//
		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
			Area aIn = QVTcoreBaseUtil.getContainingArea(rvIn);
			if (context.qvtuConfiguration.isInputDomain(aIn)) {
				Variable vOut = PivotFactory.eINSTANCE.createVariable();
				assert vOut != null;
				context.addTrace(rvIn, vOut);
				vOut.setName(rvIn.getName());
				vOut.setType(rvIn.getType());
				vOut.setIsRequired(rvIn.isIsRequired());
		        return vOut;
			}
			else {
				return super.visitRealizedVariable(rvIn);
			}
		}

		//
		//	Right-to-Middle and Middle-to-Middle variable assignments are discarded.
		//	Middle-to-Left variable assignments change to predicates.
		//
		//	FIXME why different to PropertyAssignments
		//
		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaIn) {
			if (qvtuConfiguration.isMtoL(vaIn) || qvtuConfiguration.isRtoM(vaIn) || qvtuConfiguration.isMtoM(vaIn)) {
				return null;
			}
			return super.visitVariableAssignment(vaIn);
		}
	}
	
	protected class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTc2QVTu>
	{
		public UpdateVisitor(@NonNull QVTc2QVTu context) {
			super(context);
		}

		/*
		 * Override to suppresses nested scopes since QVTc references can be cross-domain and we convert mappings 1:1.
		 */
		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mOut) {
			return doMapping(mOut);
		}

		//
		//	Predicates that were PropertyAssignments need a comparison to be synthesized.
		//
		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof PropertyAssignment) {
				return convertToPredicate((PropertyAssignment) pIn, pOut);
			}
			else {
				return super.visitPredicate(pOut);
			}
		}
	 }
	
	private final @NonNull QVTuConfiguration qvtuConfiguration;

	public QVTc2QVTu(@NonNull EnvironmentFactory environmentFactory, @NonNull QVTuConfiguration qvtuConfiguration) {
		super(environmentFactory);
        this.qvtuConfiguration = qvtuConfiguration;
	}

	@Override
	protected @NonNull CreateVisitor createCreateVisitor() {
		return new CreateVisitor(this);
	}

	@Override
	protected @NonNull UpdateVisitor createUpdateVisitor() {
		return new UpdateVisitor(this);
	}
}
