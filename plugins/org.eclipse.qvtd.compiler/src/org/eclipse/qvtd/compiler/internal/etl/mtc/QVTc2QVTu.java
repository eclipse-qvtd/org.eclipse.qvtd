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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

public class QVTc2QVTu extends AbstractQVTc2QVTc
{
	protected class CreateVisitor extends AbstractCreateVisitor<QVTc2QVTu>
	{
		public CreateVisitor(@NonNull QVTc2QVTu context) {
			super(QVTc2QVTu.this);
		}
		
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

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
			CoreModel mOut = super.visitCoreModel(mIn);
			mOut.setExternalURI(mIn.getExternalURI().replace(".qvtcas", ".qvtu.qvtcas"));
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
				Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
				context.addTrace(paIn, pOut);
	            pOut.setConditionExpression(MtcUtil.assignmentToOclExp(paIn, environmentFactory));
	            return pOut;
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
	
	protected class UpdateVisitor extends AbstractUpdateVisitor<QVTc2QVTu>
	{
		public UpdateVisitor(@NonNull QVTc2QVTu context) {
			super(context);
		}

		//
		//	Predicates that were PropertAssignments need a comparison to be synthesized.
		//
		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof PropertyAssignment) {
				PropertyAssignment paIn = (PropertyAssignment)pIn;
		    	OCLExpression slotExpression = copy(paIn.getSlotExpression(), pOut);
				Property targetProperty = paIn.getTargetProperty();
		    	assert (slotExpression != null) && (targetProperty != null);
		        OCLExpression valueExpression = copy(paIn.getValue(), pOut);
				PropertyCallExp propertyCallExp = PivotUtil.createPropertyCallExp(slotExpression, targetProperty);
				context.addTrace(pIn, propertyCallExp);
				propertyCallExp.eUnset(PivotPackage.Literals.TYPED_ELEMENT__IS_REQUIRED);		// FIXME redundant compatibility
		        Operation equalsOperation = getEqualsOperation();
				OperationCallExp operationCallExp = PivotUtil.createOperationCallExp(propertyCallExp, equalsOperation, valueExpression);
				context.addTrace(pIn, operationCallExp);
				operationCallExp.setName(equalsOperation.getName());		// FIXME redundant compatibility
				pOut.setConditionExpression(operationCallExp);
				checkOut(pOut);
				return null;
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
}
