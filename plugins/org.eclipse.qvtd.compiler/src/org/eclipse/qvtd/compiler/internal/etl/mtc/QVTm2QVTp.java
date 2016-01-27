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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractExtendingQVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The Class QVTmToQVTip.
 */
public class QVTm2QVTp
{
	/**
	 * An ExpressionCopier deep copies an OCLExpression tree, exploiting the forward traceability of context to
	 * update references and using sibling to distinguish multiple targets.
	 */
	@SuppressWarnings("serial")
	protected static class ExpressionCopier extends EcoreUtil.Copier
	{	
		private final @NonNull QVTm2QVTp context;
		private final @Nullable Element sibling;

		public ExpressionCopier(@NonNull QVTm2QVTp context, @Nullable Element sibling) {
			this.context = context;
			this.sibling = sibling;
		}

		@Override
		public EObject get(Object oIn) {
			if (oIn instanceof Element) {
				List<Element> oOuts = context.basicEquivalentTargets((Element)oIn);
				if (oOuts != null) {
					if (sibling == null) {
						assert oOuts.size() == 1;
						return oOuts.get(0);
					}
					Mapping containingMapping = QVTcoreUtil.getContainingMapping(sibling);
					assert containingMapping != null;
					Element theCopy = null;
					for (Element oOut : oOuts) {
						Mapping aMapping = QVTcoreUtil.getContainingMapping(oOut);
						if ((aMapping == containingMapping) || (aMapping == null)) {
							assert theCopy == null;
							theCopy = oOut;
						}
					}
//FIXME				assert theCopy != null;
					return theCopy;
				}
			}
			return super.get(oIn);
		}
	}
	
	/**
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTp output tree from the QVTm input tree.
	 * 
	 * References are left unresolved. OCLExpressions are not copied.
	 */
    protected static class CreateVisitor extends AbstractExtendingQVTcoreVisitor<Element, QVTm2QVTp>
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

		private @NonNull <T extends Element> T create(/*@NonNull*/ T source) {
	        @SuppressWarnings("unchecked") T target = (T) source.accept(this);
	        assert target != null;
	        return target;
		}

		private <T extends Element> void createAll(/*@NonNull*/ Iterable<T> sources, /*@NonNull*/ List<? super T> targets) {
	    	for (@SuppressWarnings("null")@NonNull T source : sources) {
		        @SuppressWarnings("unchecked") T target = (T) source.accept(this);
		        if (target != null) {
		        	targets.add(target);
		        }
	    	}
	    }

		private @NonNull Mapping doVisitMapping(@NonNull Mapping mIn, @NonNull String mappingName) {
			@SuppressWarnings("null")@NonNull Mapping mOut = QVTcoreFactory.eINSTANCE.createMapping();
			context.addTrace(mIn, mOut);
	        mOut.setName(mappingName);
	        mOut.setGuardPattern(QVTcoreBaseFactory.eINSTANCE.createGuardPattern());
	        mOut.setBottomPattern(QVTcoreBaseFactory.eINSTANCE.createBottomPattern());
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
	        return mOut;
	    }

		private @NonNull Mapping doVisitMapping_1(@NonNull Mapping mIn) {
			String name = mIn.getName();
			assert name != null;
			Mapping mOut = doVisitMapping(mIn, name);
			//
			// LMR.L to LMR.L
			//
			for (Domain d : mIn.getDomain()) {
				if (!d.isIsEnforceable()) {
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
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
			}
			//
			// LMR.M to LM.R
			//
			{
				CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
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
			for (Domain d : mIn.getDomain()) {
				if (!d.isIsCheckable()) {
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
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
			for (Domain d : mIn.getDomain()) {
				if (!d.isIsEnforceable()) {
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
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
							@SuppressWarnings("null")@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
							context.addTrace(aIn, pOut);
							mOut.getGuardPattern().getPredicate().add(pOut);
						}
					}
				}
			}
			//
			//	LMR.R to MR.R 
			//
			for (Domain d : mIn.getDomain()) {
				if (!d.isIsCheckable()) {
					CoreDomain dIn = (CoreDomain)d;
					CoreDomain dOut = create(dIn);
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
			if (usage.isCheckable() && !usage.isEnforceable()) {
				return true;
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				DomainUsage eObjectUsage = domainUsageAnalysis.getUsage(eObject);
				assert eObjectUsage != null;
				if (eObjectUsage.isCheckable() && !eObjectUsage.isEnforceable()) { // && !(eObject instanceof NullLiteralExp)) {
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
			if (usage.isEnforceable() && !usage.isCheckable()) {
				return true;
			}
			for (TreeIterator<EObject> tit = element.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				assert eObject != null;
				DomainUsage eObjectUsage = domainUsageAnalysis.getUsage(eObject);
				assert eObjectUsage != null;
				if (eObjectUsage.isEnforceable() && !eObjectUsage.isCheckable()) { // && !(eObject instanceof NullLiteralExp)) {
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
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @NonNull BottomPattern visitBottomPattern(@NonNull BottomPattern bIn) {
			@SuppressWarnings("null")@NonNull BottomPattern bOut = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			context.addTrace(bIn, bOut);
			// BottomPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return bOut;
	    }

		@Override
		public @Nullable Element visitComment(@NonNull Comment cIn) {
			@SuppressWarnings("null")@NonNull Comment cOut = PivotFactory.eINSTANCE.createComment();
			context.addTrace(cIn, cOut);
			cOut.setBody(cIn.getBody());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		}

		@Override
		public @Nullable Element visitCoreDomain(@NonNull CoreDomain dIn) {
			@SuppressWarnings("null")@NonNull CoreDomain dOut = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			context.addTrace(dIn, dOut);
			dOut.setIsCheckable(dIn.isIsCheckable());
			dOut.setIsEnforceable(dIn.isIsEnforceable());
			dOut.setGuardPattern(create(dIn.getGuardPattern()));
			dOut.setBottomPattern(create(dIn.getBottomPattern()));
			createAll(dIn.getOwnedComments(), dOut.getOwnedComments());
			return dOut;
		}

		@Override
		public @Nullable Element visitCoreModel(@NonNull CoreModel mIn) {
		    @SuppressWarnings("null")@NonNull CoreModel mOut = QVTcoreFactory.eINSTANCE.createCoreModel();
		    context.addTrace(mIn, mOut);
		    mOut.setExternalURI(mIn.getExternalURI().replace(".qvtm.qvtc", ".qvtp.qvtc"));
		    createAll(mIn.getOwnedPackages(), mOut.getOwnedPackages());
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
		    return mOut;
		}

		@Override
		public @NonNull Function visitFunction(@NonNull Function fIn) {
			@SuppressWarnings("null")@NonNull Function fOut = QVTbaseFactory.eINSTANCE.createFunction();
			context.addTrace(fIn, fOut);
			fOut.setName(fIn.getName());
			fOut.setIsRequired(fIn.isIsRequired());
			fOut.setIsStatic(fIn.isIsStatic());
			fOut.setIsTypeof(fIn.isIsTypeof());
			createAll(fIn.getOwnedParameters(), fOut.getOwnedParameters());
			createAll(fIn.getOwnedComments(), fOut.getOwnedComments());
		    return fOut;
		}

		@Override
		public @NonNull FunctionParameter visitFunctionParameter(@NonNull FunctionParameter fpIn) {
			@SuppressWarnings("null")@NonNull FunctionParameter fpOut = QVTbaseFactory.eINSTANCE.createFunctionParameter();
			context.addTrace(fpIn, fpOut);
			fpOut.setName(fpIn.getName());
			fpOut.setIsRequired(fpIn.isIsRequired());
			fpOut.setIsTypeof(fpIn.isIsTypeof());
			createAll(fpIn.getOwnedComments(), fpOut.getOwnedComments());
			return fpOut;
		}

		@Override
		public @NonNull GuardPattern visitGuardPattern(@NonNull GuardPattern gIn) {
			@SuppressWarnings("null")@NonNull GuardPattern gOut = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			context.addTrace(gIn, gOut);
			// GuardPattern children are provided in a partitioned-domain-specific fashion by a derived visitMapping.
	        return gOut;
	    }

		@Override
		public @Nullable Element visitMapping(@NonNull Mapping mIn) {
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

		@Override
		public @Nullable Element visitPackage(@NonNull Package pIn) {
		    @SuppressWarnings("null")@NonNull Package pOut = PivotFactory.eINSTANCE.createPackage();
		    context.addTrace(pIn, pOut);
		    pOut.setName(pIn.getName());
		    createAll(pIn.getOwnedClasses(), pOut.getOwnedClasses());
		    createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
		    return pOut;
		}

		@Override
		public @Nullable Element visitPredicate(@NonNull Predicate pIn) {
			@SuppressWarnings("null")@NonNull Predicate pOut = QVTbaseFactory.eINSTANCE.createPredicate();
	        context.addTrace(pIn, pOut);
	        // The condition expression is copied during update once replacement variables exist.
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
	        return pOut;
	    }

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paIn) {
			@SuppressWarnings("null")@NonNull PropertyAssignment paOut = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			context.addTrace(paIn, paOut);
			paOut.setIsDefault(paIn.isIsDefault());
			paOut.setTargetProperty(paIn.getTargetProperty());
			createAll(paIn.getOwnedComments(), paOut.getOwnedComments());
	        return paOut;
		}

		@Override
		public @Nullable Element visitRealizedVariable(@NonNull RealizedVariable rvIn) {
	        Variable rvOut = convertRealizedVariable2Variable ? PivotFactory.eINSTANCE.createVariable() : QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
            assert rvOut != null;
	        context.addTrace(rvIn, rvOut);
			rvOut.setName(rvIn.getName());
			rvOut.setIsImplicit(rvIn.isIsImplicit());
			rvOut.setType(rvIn.getType());
			createAll(rvIn.getOwnedComments(), rvOut.getOwnedComments());
	        return rvOut;
	    }

		@Override
		public @Nullable Element visitTransformation(@NonNull Transformation tIn) {
			context.getDomainUsageAnalysis().analyzeTransformation(tIn);
			@SuppressWarnings("null")@NonNull Transformation tOut = QVTbaseFactory.eINSTANCE.createTransformation();
			context.addTrace(tIn, tOut);
		    tOut.setName(tIn.getName());
		    createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
		    createAll(tIn.getModelParameter(), tOut.getModelParameter());
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
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
		    return tOut;
		}

		@Override
		public @Nullable Element visitTypedModel(@NonNull TypedModel tmIn) {
			@SuppressWarnings("null")@NonNull TypedModel tmOut = QVTbaseFactory.eINSTANCE.createTypedModel();
			context.addTrace(tmIn, tmOut);
			String name = tmIn.getName();
			if (name == null) {
				name = QVTimperativeUtil.MIDDLE_DOMAIN_NAME;
				context.setMiddleTypedModelTarget(tmOut);
			}
			tmOut.setName(name);
			tmOut.getUsedPackage().addAll(tmIn.getUsedPackage());
			createAll(tmIn.getOwnedComments(), tmOut.getOwnedComments());
		    return tmOut;
		}

		@Override
		public @Nullable Element visitVariable(@NonNull Variable vIn) {
			@SuppressWarnings("null")@NonNull Variable vOut = PivotFactory.eINSTANCE.createVariable();
			context.addTrace(vIn, vOut);
			createAll(vIn.getOwnedComments(), vOut.getOwnedComments());
	        return vOut;
	    }

		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaIn) {
			@SuppressWarnings("null")@NonNull PropertyAssignment vaOut = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			context.addTrace(vaIn, vaOut);
			vaOut.setIsDefault(vaIn.isIsDefault());
			createAll(vaIn.getOwnedComments(), vaOut.getOwnedComments());
	        return vaOut;
		}
    }

	/**
	 * The UpdateVisitor resolves the references and creates the OCLEXpressions omitted by the CreateVisitor..
	 */
    protected static class UpdateVisitor extends AbstractExtendingQVTcoreVisitor<Object, QVTm2QVTp>
    {
		public UpdateVisitor(@NonNull QVTm2QVTp context) {
			super(context);
		}

		private @Nullable <T extends Element> T copy(@Nullable T eIn, @Nullable Element sibling) {
			if (eIn == null) {
				return null;
			}
			assert context != null;
			EcoreUtil.Copier copier = new ExpressionCopier(context, sibling);
			@SuppressWarnings("unchecked") T eOut = (T) copier.copy(eIn);			
		    copier.copyReferences();
			return eOut;
		}

		private <T extends Element> void updateAllChildren(/*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T target : targets) {
				target.accept(this);
	        }
		}

		private <T extends Element> void updateAllReferences(/*@NonNull*/ List<T> sources, /*@NonNull*/ List<T> targets) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				targets.add(context.equivalentSource(source));
	        }
		}

		private void updateChild(/*@NonNull*/ Element target) {
			target.accept(this);
		}

		@Override
		public @Nullable Object visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public @Nullable Object visitBottomPattern(@NonNull BottomPattern bOut) {
	        updateAllChildren(bOut.getAssignment());
	        updateAllChildren(bOut.getPredicate());
	        updateAllChildren(bOut.getRealizedVariable());
	        updateAllChildren(bOut.getVariable());
			return null;
		}

		@Override
		public @Nullable Object visitCoreDomain(@NonNull CoreDomain dOut) {
			CoreDomain dIn = context.basicEquivalentSource(dOut);
			TypedModel tmOut;
			if (dIn != null) {
				tmOut = context.equivalentTarget(dIn.getTypedModel());
			}
			else {
				tmOut = context.getMiddleTypedModelTarget();
			}
			dOut.setTypedModel(tmOut);
			dOut.setName(tmOut.getName());
			updateChild(dOut.getGuardPattern());
			updateChild(dOut.getBottomPattern());
			return null;
		}

		@Override
		public @Nullable Object visitCoreModel(@NonNull CoreModel mOut) {
		    CoreModel mIn = context.equivalentSource(mOut);
		    for (Import oi : mIn.getOwnedImports()) {
		        mOut.getOwnedImports().add(EcoreUtil.copy(oi));
		    }
			updateAllChildren(mOut.getOwnedPackages());
			return null;
		}

		@Override
		public @Nullable Element visitFunction(@NonNull Function fOut) {
			Function fIn = context.equivalentSource(fOut);
			fOut.setQueryExpression(copy(fIn.getQueryExpression(), null));
			fOut.setType(fIn.getType());
//			fOut.setTypeValue(fIn.getTypeValue());
			updateAllChildren(fOut.getOwnedParameters());
	        return null;
	    }

		@Override
		public @Nullable Object visitFunctionParameter(@NonNull FunctionParameter fpOut) {
			FunctionParameter fpIn = context.equivalentSource(fpOut);
			fpOut.setType(fpIn.getType());
			fpOut.setTypeValue(fpIn.getTypeValue());
			return null;
		}

		@Override
		public @Nullable Object visitGuardPattern(@NonNull GuardPattern gOut) {
	        updateAllChildren(gOut.getPredicate());
	        updateAllChildren(gOut.getVariable());
	        return null;
	    }

		@Override
		public @NonNull Mapping visitMapping(@NonNull Mapping mOut) {
	        Mapping mIn = context.equivalentSource(mOut);
	        updateChild(mOut.getGuardPattern());
	        updateChild(mOut.getBottomPattern());
	        updateAllChildren(mOut.getDomain());
			return mIn;
		}

		@Override
		public @Nullable Object visitPackage(@NonNull Package pOut) {
			updateAllChildren(pOut.getOwnedClasses());
			return null;
		}

		@Override
		public @Nullable Object visitPredicate(@NonNull Predicate pOut) {
			Element pIn = context.equivalentSource(pOut);
			if (pIn instanceof PropertyAssignment) {
				PropertyAssignment paIn = (PropertyAssignment)pIn;
				OCLExpression slotExp = copy(paIn.getSlotExpression(), pOut);
				assert slotExp != null;
				Property targetProperty = paIn.getTargetProperty();
				assert targetProperty != null;
				OCLExpression propertyCallExp = PivotUtil.createPropertyCallExp(slotExp, targetProperty);
				OCLExpression valueExp = copy(paIn.getValue(), pOut);
				Class oclAnyType = context.getEnvironmentFactory().getStandardLibrary().getOclAnyType();
				Operation eqOperation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
				assert eqOperation != null;
				OCLExpression compareExp = PivotUtil.createOperationCallExp(propertyCallExp, eqOperation, valueExp);
				compareExp.setName(eqOperation.getName());		// FIXME Redundant legacy compatibility
				pOut.setConditionExpression(compareExp);
			}
			else {
				pOut.setConditionExpression(copy(((Predicate)pIn).getConditionExpression(), pOut));
			}
			return null;
		}

		@Override
		public @Nullable Element visitPropertyAssignment(@NonNull PropertyAssignment paOut) {
			PropertyAssignment paIn = context.equivalentSource(paOut);
			paOut.setSlotExpression(copy(paIn.getSlotExpression(), paOut));
			paOut.setValue(copy(paIn.getValue(), paOut));
	        return paIn;
		}

		@Override
		public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable rvOut) {
			Variable vIn = context.equivalentSource(rvOut);
			rvOut.setOwnedInit(copy(vIn.getOwnedInit(), rvOut));
			return vIn;
		}

		@Override
		public @Nullable Object visitTransformation(@NonNull Transformation tOut) {
		    updateAllChildren(tOut.getOwnedOperations());
		    updateAllChildren(tOut.getModelParameter());
		    updateAllChildren(tOut.getRule());
			return null;
		}

		@Override
		public @Nullable Object visitTypedModel(@NonNull TypedModel tmOut) {
			TypedModel tmIn = context.equivalentSource(tmOut);
		    updateAllReferences(tmIn.getDependsOn(), tmOut.getDependsOn());
			return null;
		}

		@Override
		public @Nullable Object visitVariable(@NonNull Variable vOut) {
	        Variable vIn = context.equivalentSource(vOut);
	        vOut.setName(vIn.getName());
	        vOut.setIsImplicit(vIn.isIsImplicit());
	        vOut.setIsRequired(vIn.isIsRequired());
	        vOut.setOwnedInit(copy(vIn.getOwnedInit(), vOut));
	        vOut.setType(vIn.getType());
	        vOut.setTypeValue(vIn.getTypeValue());
			return vIn;
		}

		@Override
		public @Nullable Element visitVariableAssignment(@NonNull VariableAssignment vaOut) {
			VariableAssignment vaIn = context.equivalentSource(vaOut);
			vaOut.setTargetVariable(context.equivalentTarget(vaIn.getTargetVariable()));
			vaOut.setValue(copy(vaIn.getValue(), vaOut));
	        return vaIn;
		}
	}
		
    protected final @NonNull EnvironmentFactory environmentFactory;
    protected final @NonNull RootDomainUsageAnalysis domainAnalysis;
    protected final @NonNull CreateVisitor createVisitor;
    protected final @NonNull UpdateVisitor updateVisitor;
	private TypedModel middleTypedModelTarget = null;
    
    /**
     * Forward traceability from a source object to its one or more targets; at most one target per cobtaining mapping.
     */
    private final @NonNull Map<Element, List<Element>> source2targets = new HashMap<Element, List<Element>>();
    
    /**
     * Reverse traceability from a target object to its source.
     */
    private final @NonNull Map<Element, Element> target2source = new HashMap<Element, Element>();
	
    /**
     * Create a new QVTm to QVTp transformation using an environmentFactory.
     *
     * It may be used once by invoking transform(). Repeated transform() calls are beyond the current design.
     */
    public QVTm2QVTp(@NonNull EnvironmentFactory environmentFactory) {
        this.environmentFactory = environmentFactory;
		this.domainAnalysis = new QVTcoreDomainUsageAnalysis((EnvironmentFactoryInternal) environmentFactory);
		this.createVisitor = new CreateVisitor(this);
		this.updateVisitor = new UpdateVisitor(this);
	}
	
    /**
     * Create a new trace for the given list of generated objects for the given
     * context.
     *
     * @param source the source of the trace
     * @param generated the list of generated objects
     * @param context the context in which the trace is valid
     */
	private void addTrace(@NonNull Element source, @NonNull Element target) {
    	target2source.put(target, source);
    	List<Element> targets = source2targets.get(source);
    	if (targets == null) {
    		targets = new ArrayList<Element>();
    		source2targets.put(source, targets);
    	}
    	assert !targets.contains(target);
    	targets.add(target);
    }

	private @Nullable <T extends Element> T basicEquivalentSource(@NonNull T target) {
    	assert target.eResource() == null : "source element used for equivalentSource " + target;
    	@SuppressWarnings("unchecked") T source = (T) target2source.get(target);
    	return source;
	}

	private @Nullable <T extends Element> List<T> basicEquivalentTargets(/*@NonNull*/ T source) {
    	assert source != null;
    	@SuppressWarnings("unchecked") List<T> targets = (List<T>) source2targets.get(source);
    	return targets;
    }

	private @NonNull <T extends Element> T equivalentSource(@NonNull T target) {
    	assert target.eResource() == null : "source element used for equivalentSource " + target;
    	@SuppressWarnings("unchecked") T source = (T) target2source.get(target);
    	assert source != null;
    	return source;
    }

	private @NonNull <T extends Element> T equivalentTarget(/*@NonNull*/ T source) {
    	assert source != null;
    	@SuppressWarnings("unchecked") List<T> targets = (List<T>) source2targets.get(source);
    	assert targets != null;
	    assert targets.size() == 1;
	    T target = targets.get(0);
	    assert target != null;
		return target;
    }
    
	private @NonNull RootDomainUsageAnalysis getDomainUsageAnalysis() {
		return domainAnalysis;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	private @NonNull TypedModel getMiddleTypedModelTarget() {
		assert middleTypedModelTarget != null;
		return middleTypedModelTarget;
	}

	private void setMiddleTypedModelTarget(@NonNull TypedModel middleTypedModelTarget) {
		this.middleTypedModelTarget = middleTypedModelTarget;
	}

    public void transform(@NonNull Resource source, @NonNull Resource target) {
        for (EObject eContent : source.getContents()) {
            if (eContent instanceof CoreModel) {
                CoreModel mIn = (CoreModel) eContent;
        		CoreModel mOut = (CoreModel) mIn.accept(createVisitor);
        		assert mOut != null;
                mOut.accept(updateVisitor);
                target.getContents().add(mOut);
            }
        }
        // FIXME Following code fixes up missing source. Should be fixed earlier.
        List<OperationCallExp> missingSources = null; 
	    for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
	    	EObject eObject = tit.next();
	    	if (eObject instanceof OperationCallExp) {
	    		OperationCallExp operationCallExp = (OperationCallExp)eObject;
	    		if (operationCallExp.getOwnedSource() == null) {
	    			if (missingSources == null) {
	    				missingSources = new ArrayList<OperationCallExp>();
	    			}
	    			missingSources.add(operationCallExp);
	    		}
	    	}
	    }
	    if (missingSources != null) {
			StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
	    	for (OperationCallExp operationCallExp : missingSources) {
    			Transformation transformation = QVTbaseUtil.getContainingTransformation(operationCallExp);
    			if (transformation != null) {
    				Variable thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, transformation);
					operationCallExp.setOwnedSource(PivotUtil.createVariableExp(thisVariable));
    			}
	    	}
	    }
    }
}
