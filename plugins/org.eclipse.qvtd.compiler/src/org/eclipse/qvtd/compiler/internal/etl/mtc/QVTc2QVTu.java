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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
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

		private boolean allReferencedVariablesInInputDomain(@NonNull Element a) {
			VariableDeclaration referredVariable = getReferredMappingVariable(a);
			if ((referredVariable != null) && !isInputDomain(basicGetArea(referredVariable))) {
				return false;
			}
			for (TreeIterator<EObject> tit = a.eAllContents(); tit.hasNext(); ) {
				referredVariable = getReferredMappingVariable(tit.next());
				if ((referredVariable != null) && !isInputDomain(basicGetArea(referredVariable))) {
					return false;
				}
			}
			return true;
		}

		private boolean allReferencedVariablesInOutputDomain(@NonNull Element a) {
			VariableDeclaration referredVariable = getReferredMappingVariable(a);
			if ((referredVariable != null) && !isOutputDomain(basicGetArea(referredVariable))) {
				return false;
			}
			for (TreeIterator<EObject> tit = a.eAllContents(); tit.hasNext(); ) {
				referredVariable = getReferredMappingVariable(tit.next());
				if ((referredVariable != null) && !isOutputDomain(basicGetArea(referredVariable))) {
					return false;
				}
			}
			return true;
		}

		private boolean anyReferencedBottomMiddleDomainVariables(@NonNull OCLExpression value) {
			VariableDeclaration referredVariable = getReferredMappingVariable(value);
			if (isMiddleDomainVariable(referredVariable)) {
				return true;
			}
			for (TreeIterator<EObject> tit = value.eAllContents(); tit.hasNext(); ) {
				referredVariable = getReferredMappingVariable(tit.next());
				if (isMiddleDomainVariable(referredVariable)) {
					return true;
				}
			}
			return false;
		}

		private boolean anyReferencedMiddleDomainVariables(@NonNull OCLExpression value) {
			VariableDeclaration referredVariable = getReferredMappingVariable(value);
			if ((referredVariable != null) && isMiddleDomain(basicGetArea(referredVariable))) {
				return true;
			}
			for (TreeIterator<EObject> tit = value.eAllContents(); tit.hasNext(); ) {
				referredVariable = getReferredMappingVariable(tit.next());
				if ((referredVariable != null) && isMiddleDomain(basicGetArea(referredVariable))) {
					return true;
				}
			}
			return false;
		}

	    /**
	     * Create an ocl expression from an assignment than can be used as the
	     * condition expression of a predicate.
	     *
	     * @param aIn the a in
	     * @param environmentFactory the environment factory
	     * @return the operation call exp
	     */
	    private OperationCallExp assignmentToOclExp(@NonNull Assignment aIn) {
	        OperationCallExp exp = PivotFactory.eINSTANCE.createOperationCallExp();
	        for (Operation op : environmentFactory.getStandardLibrary().getOclAnyType().getOwnedOperations()) {
	            if (op.getName().equals("=")) {
	                exp.setReferredOperation(op);
	                exp.setName(op.getName());
	                exp.setType(op.getType());
	                break;
	            }
	        }
	        exp.getOwnedArguments().add(EcoreUtil.copy(aIn.getValue()));
	        if (aIn instanceof PropertyAssignment) {
	            PropertyCallExp sourceExp = PivotFactory.eINSTANCE.createPropertyCallExp();
	            sourceExp.setReferredProperty(((PropertyAssignment) aIn).getTargetProperty());
	            sourceExp.setType(((PropertyAssignment) aIn).getTargetProperty().getType());
	            sourceExp.setOwnedSource(EcoreUtil.copy(((PropertyAssignment) aIn).getSlotExpression()));
	            exp.setOwnedSource(sourceExp);
	        } else { // aIn instanceof VariableAssignment
	            VariableExp varExp = PivotFactory.eINSTANCE.createVariableExp();
	            varExp.setIsImplicit(false);
	            varExp.setReferredVariable(((VariableAssignment) aIn).getTargetVariable());
	            exp.setOwnedSource(varExp);
	        }
	        return exp;
	    }

		private @Nullable Area basicGetArea(@Nullable VariableDeclaration variable) {
			return QVTcoreBaseUtil.getContainingArea(variable);
		}

		//
		//	Assignments may mutate to Predicates.
		//
		@Override
		protected void doAssignments(@NonNull BottomPattern bIn, @NonNull BottomPattern bOut) {
			GuardPattern gOut = context.equivalentTarget(bIn.getArea().getGuardPattern());
			assert gOut != null;
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
			GuardPattern gOut = context.equivalentTarget(bIn.getArea().getGuardPattern());
			assert gOut != null;
			for (RealizedVariable rvIn : ClassUtil.nullFree(bIn.getRealizedVariable())) {
				Variable vOut = create(rvIn);
				if (vOut instanceof RealizedVariable) {
					bOut.getRealizedVariable().add((RealizedVariable) vOut);
				}
				else {
					gOut.getVariable().add(vOut);
				}
			}
		}

		private @NonNull Area getContainingArea(@NonNull VariableDeclaration variable) {
			Area targetArea = QVTcoreBaseUtil.getContainingArea(variable);
			assert targetArea != null;
			return targetArea;
		}

		private @Nullable VariableDeclaration getReferredMappingVariable(@Nullable EObject value) {
			if (value instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)value).getReferredVariable();
				EObject eContainer = referredVariable.eContainer();
				if (eContainer instanceof Transformation) {			// "this" is not a mapping variable (has no domain)
					return null;
				}
				if (eContainer instanceof LoopExp) {				// iterators/accumulators are not mapping variables (has no domain)
					return null;
				}
				return referredVariable;
			}
			else {
				return null;
			}
		}

		private @Nullable Area getSourceVariableArea(@Nullable OCLExpression exp) {
			if (exp instanceof VariableExp) {
				Variable expV = (Variable) ((VariableExp)exp).getReferredVariable(); 
				return basicGetArea(expV);
			} else if (exp instanceof CallExp) {
				return getSourceVariableArea(((CallExp) exp).getOwnedSource());
			} else if (exp instanceof IfExp) {
				return getSourceVariableArea(((IfExp) exp).getOwnedCondition());
			} else if (exp instanceof LiteralExp) {
				return null;
			}
			return null;
		}

		private boolean isMiddleDomainVariable(@Nullable VariableDeclaration variable) {
			if (variable == null) {
				return false;
			}
			CorePattern pattern = QVTcoreBaseUtil.getContainingPattern(variable);
			if (!(pattern instanceof BottomPattern)) {
				return false;
			}
			return pattern.getArea() instanceof Mapping;
		}

		//
		//	CoreDomains enforcement is aligned to the direction
		//
		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			CoreDomain dOut = super.visitCoreDomain(dIn);
			String name = dIn.getTypedModel().getName();
			dOut.setName(name);			// Redundant replication of Epsilon functionality
			if (qvtuConfiguration.isInput(name)) {
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
			String externalURI = mIn.getExternalURI();
			if (externalURI.endsWith(".qvtcas")) {
				externalURI = externalURI.replace(".qvtcas", ".qvtu.qvtcas");
			}
			else if (externalURI.endsWith(".qvtc")) {
				externalURI = externalURI.replace(".qvtc", ".qvtu.qvtcas");
			}
			mOut.setExternalURI(externalURI);
			return mOut;
		}

		/*
		 * Override to suppresses nested scopes since QVTc references can be cross-domain and we convert mappings 1:1.
		 */
		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			MappingMode mappingMode = getMappingMode(mIn);
			if (mappingMode == null) {
				return null;
			}
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			doMapping(mIn, mOut);
	        return mOut;
		}

		//
		//	Output only bottom predicates are discarded.
		//
		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
//			boolean oldResult = true;
//			if ((pIn.getPattern() instanceof BottomPattern) && allReferencedVariablesInOutputDomain(pIn)) {
//				oldResult = false;
//			}
//			else if ((pIn.getPattern() instanceof BottomPattern) && anyReferencedVariableInMiddleOrOutputDomain(pIn)) {
//				oldResult = false;
//			}
			if ((pIn.getPattern() instanceof BottomPattern) && !allReferencedVariablesInInputDomain(pIn)) {
//				assert !oldResult;
				return null;
			}
//			if (!oldResult) {
//				anyReferencedNonInputDomainVariables2(pIn);
//				allReferencedVariablesInOutputDomain(pIn);
//				anyReferencedVariableInMiddleOrOutputDomain(pIn);
//			}
//			assert oldResult;
/*			OCLExpression conditionExpression = pIn.getConditionExpression();
			if (conditionExpression instanceof OperationCallExp) {
				OperationCallExp callExp = (OperationCallExp)conditionExpression;
				if ("=".equals(callExp.getReferredOperation().getName()) && (callExp.getOwnedArguments().size() == 1)) {		// FIXME more accuracy
					OCLExpression leftExpression= callExp.getOwnedSource();
					OCLExpression rightExpression= callExp.getOwnedArguments().get(0);
					if ((leftExpression != null) && (rightExpression != null)) {
						PropertyCallExp middlePropertyAccess = isMiddleDomainPropertyAccess(leftExpression);
						if ((middlePropertyAccess != null) && isInputDomainExpression(rightExpression)) {
							return convertToPropertyAssignment(middlePropertyAccess, rightExpression);
						}
						middlePropertyAccess = isMiddleDomainPropertyAccess(rightExpression);
						if ((middlePropertyAccess != null) && isInputDomainExpression(leftExpression)) {
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
			OCLExpression slotExpression = paIn.getSlotExpression();
			OCLExpression value = paIn.getValue();
			assert (slotExpression != null) && (value != null);
//			Area sourceArea = getSourceVariableArea(value);
			Area targetArea = getSourceVariableArea(slotExpression);
			//
			// A backward "p.q := v" rewrites as a forward "v := p.q". 
			//
			if (isInputDomain(targetArea) && (value instanceof VariableExp) && anyReferencedMiddleDomainVariables(value)) {		// isMtoL
				VariableAssignment vaOut = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
				context.addTrace(paIn, vaOut);
	            return vaOut;
			}
			if (isNonOutputDomain(targetArea) &&								// is RtoM or MtoL or RtoL
					!(value instanceof VariableExp) &&			// why?
					!(value instanceof NullLiteralExp) &&		// why?
					allReferencedVariablesInOutputDomain(value)) {
				return null;
			}
			if (isInputDomain(targetArea) && (targetArea instanceof Mapping) && anyReferencedBottomMiddleDomainVariables(value)) {	// isMtoM
				return null;
			}
/*			if (isInputDomain(sourceArea)) {
				VariableDeclaration referredVariable = getReferredMappingVariable(value);
				if (isMiddleDomainVariable(referredVariable)) {	
//					return null;
				}
//				if (referredVariable != null) {
//					Area area = basicGetArea(referredVariable);
//					if (isMiddleDomain(area) && (area instanceof BottomPattern)) {		// FIXME are is never a BottomPattern
//						return null;
//					}
//				}
			}
			if (isMiddleDomain(sourceArea)) {								// isLocaltoM
				VariableDeclaration referredVariable = getReferredMappingVariable(value);
				if (isMiddleDomainVariable(referredVariable)) {	
					return null;
				}
//				if (referredVariable != null) {
//					Area area = basicGetArea(referredVariable);
//					if (isMiddleDomain(area) && (area instanceof BottomPattern)) {		// FIXME are is never a BottomPattern
//						return null;
//					}
//				}
			} */

			if (isInputDomain(targetArea) && anyReferencedMiddleDomainVariables(value)) {		// isMtoL
				// Assignments to Predicates
//				Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
//				context.addTrace(paIn, pOut);
//	            pOut.setConditionExpression(MtcUtil.assignmentToOclExp(paIn, environmentFactory));
//	            return pOut;
				return null;
			}
			if (isInputDomain(targetArea) && allReferencedVariablesInInputDomain(paIn)) {
				// Assignments to Predicates
				Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
				context.addTrace(paIn, pOut);
				pOut.setConditionExpression(assignmentToOclExp(paIn));
	            return pOut;
			}
			PropertyAssignment paOut = (PropertyAssignment) super.visitPropertyAssignment(paIn);
			assert paOut != null;
			if (qvtuConfiguration.isCheckMode() && paIn.isIsDefault() && isOutputDomain(paIn.getBottomPattern().getArea())) {
				// Default assignments
				paOut.setIsDefault(false);
			}
			return paOut;
		}

		//
		//	Input domain RealizedVariables are changed to unrealized Variables.
		//
		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
			Area aIn = getContainingArea(rvIn);
			if (isInputDomain(aIn)) {
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
			Variable targetVariable = vaIn.getTargetVariable();
			OCLExpression value = vaIn.getValue();
			assert (targetVariable != null) && (value != null);
			Area targetArea = getContainingArea(targetVariable);
			if (isInputDomain(targetArea) && !allReferencedVariablesInInputDomain(value)) {	// an output-to-input assignment
				return null;
			}
//			if (isInputDomain1(targetArea) && anyReferencedMiddleDomainVariables(value)) {	// isMtoL
//				return null;
//			}
//			if (isMiddleDomain(targetArea) /*&& !(value instanceof VariableExp)*/ && allMatchReferencedOutputDomainVariables(value)) {	// isRtoM
//				return null;
//			}
			if ((targetArea instanceof Mapping) && anyReferencedBottomMiddleDomainVariables(value)) {	// isMtoM
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

		/*
		 * Override to handle the backward "p.q := v" rewrite as "v := p.q". 
		 */
		@Override
		public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment vaOut) {
			Element pIn = context.equivalentSource(vaOut);
			if (pIn instanceof PropertyAssignment) {
				return convertToVariableAssignment((PropertyAssignment)pIn, vaOut);
			}
			else {
				return super.visitVariableAssignment(vaOut);
			}
		}
	 }
	
	private enum DomainMode {
		INPUT,
		MIDDLE,
		OUTPUT
	}
	
	private static final int IS_INPUT_MASK = 1;
	private static final int IS_OUTPUT_MASK = 2;
	
	private enum MappingMode {
		NULL(0),
		LEFT2MIDDLE(IS_INPUT_MASK),
		MIDDLE2RIGHT(IS_OUTPUT_MASK),
		LEFT2RIGHT(IS_INPUT_MASK | IS_OUTPUT_MASK);
		
		private int flags;
		
		private MappingMode(int flags) { this.flags = flags; }

		private @NonNull MappingMode get(int flagsUnion) {
			switch (flagsUnion) {
				case 1 : return LEFT2MIDDLE;
				case 2 : return MIDDLE2RIGHT;
				case 3 : return LEFT2RIGHT;
			}
			return NULL;
		}

		public @NonNull MappingMode asInput() {
			return get(flags | IS_INPUT_MASK);
		}

		public @NonNull MappingMode asOutput() {
			return get(flags | IS_OUTPUT_MASK);
		}
		
		public boolean hasInputDomain() { return (flags & IS_INPUT_MASK) != 0; }
		public boolean hasOutputDomain() { return (flags & IS_OUTPUT_MASK) != 0; }

		public @NonNull MappingMode union(@NonNull MappingMode anotherMappingMode) {
			return get(flags | anotherMappingMode.flags);
		}
	}

	private final @NonNull QVTuConfiguration qvtuConfiguration;
	
	/**
	 * Cached INPUT/MIDDLE/OUTPUT state of each Area, aggregating refined and/or local states.
	 */
	private final @NonNull Map<@NonNull Area, @NonNull DomainMode> domain2mode = new HashMap<@NonNull Area, @NonNull DomainMode>();

	/**
	 * Cached LEFT2MIDDLE/MIDDLE2RIGHT/LEFT2RIGHT state of each top or local Mapping aggregating refined states.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull MappingMode> mapping2mode = new HashMap<@NonNull Mapping, @NonNull MappingMode>();

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

	private @Nullable MappingMode getComposedMappingMode(@NonNull Mapping mapping) {
		MappingMode mergedMode = MappingMode.NULL;
		for (@NonNull Domain domain: ClassUtil.nullFree(mapping.getDomain())) {
			String name = domain.getTypedModel().getName();
			if (qvtuConfiguration.isInput(name)) {
				mergedMode = mergedMode.asInput();
				domain2mode.put((CoreDomain)domain, DomainMode.INPUT);
			}
			else if (qvtuConfiguration.isOutput(name)) {
				if (!domain.isIsEnforceable()) {
					return null;
				}
				mergedMode = mergedMode.asOutput();
				domain2mode.put((CoreDomain)domain, DomainMode.OUTPUT);
			}
		}
		for (@NonNull Mapping localMapping : ClassUtil.nullFree(mapping.getLocal())) {
			MappingMode mappingMode = getMappingMode(localMapping);
			if (mappingMode == null) {
				return null;
			}
			mergedMode = mergedMode.union(mappingMode);
		}
		return mergedMode;
	}

	private @Nullable MappingMode getMappingMode(@NonNull Mapping mapping) {
		MappingMode mergedMode = mapping2mode.get(mapping);
		if (mergedMode == null) {
			mergedMode = getComposedMappingMode(mapping);
			if (mergedMode == null) {
				return null;
			}
			for (@NonNull Mapping refinedMapping : ClassUtil.nullFree(mapping.getSpecification())) {
				MappingMode composedMappingMode = getComposedMappingMode(refinedMapping);
				if (composedMappingMode == null) {
					return null;
				}
				mergedMode = mergedMode.union(composedMappingMode);
			}
			mapping2mode.put(mapping, mergedMode);
			setMappingDomainModes(mapping, mergedMode);
		}
		return mergedMode;
	}
	
	private boolean isInputDomain(@Nullable Area area) {
		if (area == null) {
			return false;
		}
		DomainMode domainMode = domain2mode.get(area);
		assert domainMode != null;
		return domainMode == DomainMode.INPUT;
	}

	private boolean isMiddleDomain(@Nullable Area area) {
		if (area == null) {
			return false;
		}
		DomainMode domainMode = domain2mode.get(area);
		assert domainMode != null;
		return domainMode == DomainMode.MIDDLE;
	}
	
	private boolean isNonOutputDomain(@Nullable Area area) {
		if (area == null) {
			return false;
		}
		DomainMode domainMode = domain2mode.get(area);
		assert domainMode != null;
		return domainMode != DomainMode.OUTPUT;
	}
	
	private boolean isOutputDomain(@Nullable Area area) {
		if (area == null) {
			return false;
		}
		DomainMode domainMode = domain2mode.get(area);
		assert domainMode != null;
		return domainMode == DomainMode.OUTPUT;
	}

	private void setMappingDomainModes(@NonNull Mapping mapping, @NonNull MappingMode mode) {
		domain2mode.put(mapping, !mode.hasInputDomain() ? DomainMode.INPUT : !mode.hasOutputDomain() ? DomainMode.OUTPUT : DomainMode.MIDDLE);
		for (@NonNull Mapping localMapping : ClassUtil.nullFree(mapping.getLocal())) {
			setMappingDomainModes(localMapping, mode);
		}
	}
}
