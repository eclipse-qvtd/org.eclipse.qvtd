/*******************************************************************************
 * Copyright (c) 2015 University of York and Others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The Class QVTmToQVTip.
 */
public class QVTm2QVTp extends AbstractQVTc2QVTc
{
	/**
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTp output tree from the QVTm input tree.
	 * 
	 * References are left unresolved. OCLExpressions are not copied.
	 */
    protected static class CreateVisitor extends AbstractCreateVisitor<@NonNull QVTm2QVTp>
    {
		/**
		 * Set true while migrating LMR.M-bottom realized variables to MR.L guard variables.
		 */
		protected boolean convertRealizedVariable2Variable = false;

		/**
		 * Set true/false to distinguish the dual invocation of visitMapping().
		 */
		private boolean generateLM = false;

		public CreateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		@Override
		protected void doRules(@NonNull Transformation tIn, @NonNull Transformation tOut) {
		    List<Rule> outRules = tOut.getRule();
		    //
		    //	Generate two mappings per mapping, using generateLM to separate "_LM" and "_MR".
		    //
			for (@SuppressWarnings("null")@NonNull Rule inRule : tIn.getRule()) {
				if (isSingleInput((Mapping)inRule)) {
					outRules.add(create(inRule));
				}
				else {
					generateLM = true;
					outRules.add(create(inRule));
					generateLM = false;
					outRules.add(create(inRule));
				}
			}
		}

		private @NonNull Mapping doVisitMapping(@NonNull Mapping mIn, @NonNull String mappingName) {
			@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
	        mOut.setName(mappingName);
			mOut.setGuardPattern(create(mIn.getGuardPattern()));
			mOut.setBottomPattern(create(mIn.getBottomPattern()));
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
	        return mOut;
	    }

		private @NonNull Mapping doVisitMapping_1(@NonNull Mapping mIn) {
			String name = mIn.getName();
//			System.out.println(name);
			assert name != null;
			Mapping mOut = doVisitMapping(mIn, name);
			//
			// LMR.L to LMR.L
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
//				System.out.println("  " + d + " " + d.isIsEnforceable());
				if (!isEnforceable) {
					assert !d.isIsEnforceable();
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
					assert dOut != null;
					createAll(dIn.getGuardPattern().getPredicate(), mOut.getGuardPattern().getPredicate());		// Colocate all predicates
					createAll(dIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
					createAll(dIn.getBottomPattern().getVariable(), dOut.getGuardPattern().getVariable());		// Colocate all variables
					createAll(dIn.getBottomPattern().getPredicate(), mOut.getGuardPattern().getPredicate());		// Colocate all variables
					mOut.getDomain().add(dOut);
				}
			}
			//
			// LMR.M to LMR.M
			//
			{
				for (@SuppressWarnings("null")@NonNull Predicate pIn : mIn.getGuardPattern().getPredicate()) {
					mOut.getGuardPattern().getPredicate().add(create(pIn));
				}
				for (@SuppressWarnings("null")@NonNull Assignment aIn : mIn.getBottomPattern().getAssignment()) {
					mOut.getBottomPattern().getAssignment().add(create(aIn));
				}
				createAll(mIn.getBottomPattern().getPredicate(), mOut.getBottomPattern().getPredicate());
				createAll(mIn.getBottomPattern().getVariable(), mOut.getBottomPattern().getVariable());
			}
			//
			// LMR.M to LM.R
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
//				System.out.println("  middle");
				context.addTrace(mIn, dOut);
				dOut.setIsCheckable(false);
				dOut.setIsEnforceable(true);
				dOut.setGuardPattern(create(mIn.getGuardPattern()));
				dOut.setBottomPattern(create(mIn.getBottomPattern()));
				createAll(mIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
				createAll(mIn.getBottomPattern().getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
				mOut.getDomain().add(dOut);
			}
			//
			// LMR.R to LMR.R
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
//				System.out.println("  " + d + " " + d.isIsEnforceable());
				if (isEnforceable) {
					assert d.isIsEnforceable();
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
					assert dOut != null;
					createAll(dIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
					createAll(dIn.getBottomPattern().getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
					for (@SuppressWarnings("null")@NonNull Assignment aIn : dIn.getBottomPattern().getAssignment()) {
						mOut.getBottomPattern().getAssignment().add(create(aIn));
					}
					mOut.getDomain().add(0, dOut);			// FIXME preserve legacy ordering
				}
			}
			return mOut;
		}

		private @NonNull Mapping doVisitMapping_LM(@NonNull Mapping mIn) {
			Mapping mOut = doVisitMapping(mIn, mIn.getName() + "_LM");
			//
			// LMR.L to LM.L
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
				if (!isEnforceable) {
					assert !d.isIsEnforceable();
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
					assert dOut != null;
					createAll(dIn.getGuardPattern().getPredicate(), mOut.getGuardPattern().getPredicate());		// Colocate all predicates
					createAll(dIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
					createAll(dIn.getBottomPattern().getVariable(), dOut.getGuardPattern().getVariable());		// Colocate all variables
					createAll(dIn.getBottomPattern().getPredicate(), mOut.getGuardPattern().getPredicate());		// Colocate all variables
					mOut.getDomain().add(dOut);
				}
			}
			//
			// LMR.M to LM.M
			//
			{
				RootDomainUsageAnalysis domainUsageAnalysis = context.getDomainUsageAnalysis();
				for (@SuppressWarnings("null")@NonNull Predicate pIn : mIn.getGuardPattern().getPredicate()) {
					if (!isRight(domainUsageAnalysis, pIn)) {
						mOut.getGuardPattern().getPredicate().add(create(pIn));
					}
				}
				for (@SuppressWarnings("null")@NonNull Assignment aIn : mIn.getBottomPattern().getAssignment()) {
					if (!isRight(domainUsageAnalysis, aIn)) {
						mOut.getBottomPattern().getAssignment().add(create(aIn));
					}
				}
			}
			//
			// LMR.M to LM.R
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
				context.addTrace(mIn, dOut);
				dOut.setIsCheckable(false);
				dOut.setIsEnforceable(true);
				dOut.setGuardPattern(create(mIn.getGuardPattern()));
				dOut.setBottomPattern(create(mIn.getBottomPattern()));
				createAll(mIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
				createAll(mIn.getBottomPattern().getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
				mOut.getDomain().add(dOut);
			}
			return mOut;
		}

		private @NonNull Mapping doVisitMapping_MR(@NonNull Mapping mIn) {
			Mapping mOut = doVisitMapping(mIn, mIn.getName() + "_MR");
			//
			// LMR.M to MR.L
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
				context.addTrace(mIn, dOut);
				dOut.setIsCheckable(true);
				dOut.setIsEnforceable(false);
				dOut.setGuardPattern(create(mIn.getGuardPattern()));
				dOut.setBottomPattern(create(mIn.getBottomPattern()));
				convertRealizedVariable2Variable = true;
				createAll(mIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
				createAll(mIn.getBottomPattern().getRealizedVariable(), dOut.getGuardPattern().getVariable());
				convertRealizedVariable2Variable = false;
				mOut.getDomain().add(dOut);
			}
			//
			// LMR.M to MR.M
			//
			{
				RootDomainUsageAnalysis domainUsageAnalysis = context.getDomainUsageAnalysis();
				for (@SuppressWarnings("null")@NonNull Predicate pIn : mIn.getGuardPattern().getPredicate()) {
					if (!isLeft(domainUsageAnalysis, pIn)) {
						mOut.getGuardPattern().getPredicate().add(create(pIn));
					}
				}
				for (@SuppressWarnings("null")@NonNull Assignment aIn : mIn.getBottomPattern().getAssignment()) {
					if (isRight(domainUsageAnalysis, aIn)) {
						mOut.getBottomPattern().getAssignment().add(create(aIn));
					}
					else if (aIn instanceof PropertyAssignment) {
						boolean isLeft = isLeft(domainUsageAnalysis, aIn);
						@SuppressWarnings("unused") boolean isR = isRight(domainUsageAnalysis, aIn);
						boolean isMiddle = isMiddle(domainUsageAnalysis, aIn);
						if (isMiddle && !isLeft) { // || (aIn.getValue() instanceof NullLiteralExp)) {
							@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
							context.addTrace(aIn, pOut);
							mOut.getGuardPattern().getPredicate().add(pOut);
						}
					}
				}
			}
			//
			//	LMR.R to MR.R 
			//
			for (Domain d : ClassUtil.nullFree(mIn.getDomain())) {
				boolean isEnforceable = context.isEnforceableTransformationWide(d);
				if (isEnforceable) {
					assert d.isIsEnforceable();
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
					assert dOut != null;
					createAll(dIn.getGuardPattern().getVariable(), dOut.getGuardPattern().getVariable());
					createAll(dIn.getBottomPattern().getRealizedVariable(), dOut.getBottomPattern().getRealizedVariable());
					for (@SuppressWarnings("null")@NonNull Assignment aIn : dIn.getBottomPattern().getAssignment()) {
						mOut.getBottomPattern().getAssignment().add(create(aIn));
					}
					mOut.getDomain().add(0, dOut);			// FIXME preserve legacy ordering
				}
			}
			return mOut;
		}

		private boolean isLeft(@NonNull RootDomainUsageAnalysis domainUsageAnalysis, @NonNull Element element) {
			DomainUsage usage = domainUsageAnalysis.getUsage(element);
			assert usage != null;
			if (usage.isInput() && !usage.isOutput()) {
				return true;
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				DomainUsage eObjectUsage = domainUsageAnalysis.getUsage(eObject);
				assert eObjectUsage != null;
				if (eObjectUsage.isInput() && !eObjectUsage.isOutput()) { // && !(eObject instanceof NullLiteralExp)) {
					return true;
				}
			}
			return false;
		}

		private boolean isMiddle(@NonNull RootDomainUsageAnalysis domainUsageAnalysis, @NonNull Element element) {
			DomainUsage usage = domainUsageAnalysis.getUsage(element);
			assert usage != null;
			if (usage.isMiddle()) {
				return true;
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				DomainUsage eObjectUsage = domainUsageAnalysis.getUsage(eObject);
				assert eObjectUsage != null;
				if (eObjectUsage.isMiddle()) { // && !(eObject instanceof NullLiteralExp)) {
					return true;
				}
			}
			return false;
		}

		private boolean isRight(@NonNull RootDomainUsageAnalysis domainUsageAnalysis, @NonNull Element element) {
			DomainUsage usage = domainUsageAnalysis.getUsage(element);
			assert usage != null;
			if (usage.isOutput() && !usage.isInput()) {
				return true;
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				DomainUsage eObjectUsage = domainUsageAnalysis.getUsage(eObject);
				assert eObjectUsage != null;
				if (eObjectUsage.isOutput() && !eObjectUsage.isInput()) { // && !(eObject instanceof NullLiteralExp)) {
					return true;
				}
			}
			return false;
		}

		private boolean isSingleInput(@NonNull Mapping mIn) {
			int guardCount = mIn.getGuardPattern().getVariable().size();
			for (Domain dIn : mIn.getDomain()) {
				guardCount += ((CoreDomain)dIn).getGuardPattern().getVariable().size();
			}
			return guardCount <= 1;
		}

		@Override
		public @NonNull BottomPattern visitBottomPattern(@NonNull BottomPattern bIn) {
			BottomPattern bOut = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			context.addTrace(bIn, bOut);
			// BottomPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return bOut;
	    }

		@Override
		public @NonNull CoreDomain visitCoreDomain(@NonNull CoreDomain dIn) {
			boolean isEnforceable = context.isEnforceableTransformationWide(dIn);
			assert dIn.isIsEnforceable() == isEnforceable;
			return super.visitCoreDomain(dIn);
		}

		@Override
		public @NonNull CoreModel visitCoreModel(@NonNull CoreModel mIn) {
		    @NonNull CoreModel mOut = super.visitCoreModel(mIn);
		    mOut.setExternalURI(mIn.getExternalURI().replace(".qvtm.qvtc", ".qvtp.qvtc"));
		    return mOut;
		}

		@Override
		public @NonNull GuardPattern visitGuardPattern(@NonNull GuardPattern gIn) {
			GuardPattern gOut = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			context.addTrace(gIn, gOut);
			// GuardPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return gOut;
	    }

		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
			try {
				if (isSingleInput(mIn)) {
					return doVisitMapping_1(mIn);
				}
				else if (generateLM) {
					return doVisitMapping_LM(mIn);
				}
				else {
					return doVisitMapping_MR(mIn);
				}
			}
			finally {
				context.popScope();
			}
		}

		@Override
		public @NonNull Variable visitRealizedVariable(@NonNull RealizedVariable rvIn) {
			if (convertRealizedVariable2Variable) {
				return super.visitVariable(rvIn);
			}
			else {
				return super.visitRealizedVariable(rvIn);
			}
		}

		@Override
		public @NonNull Transformation visitTransformation(@NonNull Transformation tIn) {
			context.getDomainUsageAnalysis().analyzeTransformation(tIn);
			return super.visitTransformation(tIn);
		}

		@Override
		public @NonNull TypedModel visitTypedModel(@NonNull TypedModel tmIn) {
			@NonNull TypedModel tmOut = super.visitTypedModel(tmIn);
			String name = tmIn.getName();
			if (name == null) {
				name = QVTimperativeUtil.MIDDLE_DOMAIN_NAME;
				tmOut.setName(name);
			}
		    return tmOut;
		}
    }

	/**
	 * The UpdateVisitor resolves the references and creates the OCLEXpressions omitted by the CreateVisitor..
	 */
    protected static class UpdateVisitor extends AbstractUpdateVisitor<@NonNull QVTm2QVTp>
    {
		public UpdateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof PropertyAssignment) {
				return convertToPredicate((PropertyAssignment) pIn, pOut);
			}
			else {
				pOut.setConditionExpression(copy(((Predicate)pIn).getConditionExpression(), pOut));
			}
			return null;
		}
	}
		
    protected final @NonNull RootDomainUsageAnalysis domainAnalysis;

    /**
     * Set of all TypedModels that are enforceable for all domains in each trasformation. 
     */
    private final @NonNull Map<@NonNull Transformation, @NonNull Set<@NonNull TypedModel>> transformation2enforceableTypedModels = new HashMap<@NonNull Transformation, @NonNull Set<@NonNull TypedModel>>();
	
    /**
     * Create a new QVTm to QVTp transformation using an environmentFactory.
     *
     * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
     */
    public QVTm2QVTp(@NonNull EnvironmentFactory environmentFactory) {
        super(environmentFactory);
		this.domainAnalysis = new QVTcoreDomainUsageAnalysis(environmentFactory);
	}

	@Override
	protected @NonNull CreateVisitor createCreateVisitor() {
		return new CreateVisitor(this);
	}

	@Override
	protected @NonNull UpdateVisitor createUpdateVisitor() {
		return new UpdateVisitor(this);
	}

	private @NonNull RootDomainUsageAnalysis getDomainUsageAnalysis() {
		return domainAnalysis;
	}

	private boolean isEnforceableTransformationWide(@NonNull Domain domain) {
		Transformation transformation = QVTbaseUtil.getContainingTransformation(domain);
		assert transformation != null;
		Set<@NonNull TypedModel> enforceableTypedModels = transformation2enforceableTypedModels.get(transformation);
		if (enforceableTypedModels == null) {
			enforceableTypedModels = QVTbaseUtil.getEnforceableTypedModels(transformation);
			transformation2enforceableTypedModels.put(transformation, enforceableTypedModels);
		}
		TypedModel typedModel = domain.getTypedModel();
		return enforceableTypedModels.contains(typedModel);
	}
}
