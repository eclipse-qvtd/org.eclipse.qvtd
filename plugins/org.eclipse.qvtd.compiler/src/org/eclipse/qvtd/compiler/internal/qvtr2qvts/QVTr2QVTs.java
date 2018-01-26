/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Comment;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.DatumCaches;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.TransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.AbstractExtendingQVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

import com.google.common.collect.Lists;

public class QVTr2QVTs extends AbstractQVTb2QVTs
{
	/**
	 * The CreateVisitor performs the mostly 1:1 creation of the QVTm output tree from the QVTm input tree.
	 *
	 * References are left unresolved. OCLExpressions are not copied. doXXX methods provide join points for derived implementations.
	 */
	protected static class CreateVisitor extends AbstractExtendingQVTrelationVisitor<Element, QVTr2QVTs>
	{
		protected final @NonNull ScheduleManager scheduleManager;
		protected final @NonNull QVTuConfiguration qvtuConfiguration;
		private @Nullable RelationAnalysis relationAnalysis = null;

		public CreateVisitor(@NonNull QVTr2QVTs context, @NonNull QVTuConfiguration qvtuConfiguration) {
			super(context);
			this.scheduleManager = context.getScheduleManager();
			this.qvtuConfiguration = qvtuConfiguration;
		}

		public <T extends Element> void acceptAll(/*@NonNull*/ Iterable<T> sources) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				source.accept(this);
			}
		}

		public <T extends Element> @Nullable T create(@Nullable T source) {
			if (source == null) {
				return null;
			}
			@SuppressWarnings("unchecked") @Nullable T target = (T) source.accept(this);
			return target;
		}

		public <T extends Element> void createAll(/*@NonNull*/ Iterable<T> sources, /*@NonNull*/ List<? super T> targets) {
			for (@SuppressWarnings("null")@NonNull T source : sources) {
				@SuppressWarnings("unchecked") T target = (T) source.accept(this);
				if (target != null) {
					targets.add(target);
				}
			}
		}

		private void doPackage(org.eclipse.ocl.pivot.@NonNull Package pIn, @NonNull ScheduleModel mOut) {
			for (org.eclipse.ocl.pivot.@NonNull Package p : PivotUtil.getOwnedPackages(pIn)) {
				doPackage(p, mOut);
			}
			for (org.eclipse.ocl.pivot.@NonNull Class cIn : PivotUtil.getOwnedClasses(pIn)) {
				cIn.accept(this);
				//				if (cOut instanceof ScheduledRegion) {
				//					if (mOut.getOwnedScheduledRegion() != null) {
				//						context.addProblem(new CompilerChainException("Multiple scheduled regions"));
				//					}
				//					mOut.setOwnedScheduledRegion((ScheduledRegion) cOut);
				//				}
			}
		}

		protected @NonNull RelationAnalysis getRelationAnalysis() {
			return ClassUtil.nonNullState(relationAnalysis);
		}

		protected @NonNull RuleRegion getRuleRegion() {
			return getRelationAnalysis().getRegion();
		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public Element visitCollectionTemplateExp(@NonNull CollectionTemplateExp cteIn) {
			return visiting(cteIn);
		}

		@Override
		public @Nullable Element visitComment(@NonNull Comment cIn) {
			Comment cOut = PivotFactory.eINSTANCE.createComment();
			context.addTrace(cIn, cOut);
			cOut.setBody(cIn.getBody());
			createAll(cIn.getOwnedComments(), cOut.getOwnedComments());
			return cOut;
		}

		@Override
		public Element visitDomainPattern(@NonNull DomainPattern dpIn) {
			QVTrelationUtil.getOwnedTemplateExpression(dpIn).accept(this);
			return null;
		}

		@Override
		public @Nullable Element visitImport(@NonNull Import iIn) {
			Import iOut = context.createImport(iIn);
			createAll(iIn.getOwnedComments(), iOut.getOwnedComments());
			return iOut;
		}

		@Override
		public Element visitOCLExpression(@NonNull OCLExpression object) {
			return null;
		}

		@Override
		public Element visitObjectTemplateExp(@NonNull ObjectTemplateExp oteIn) {
			//			Variable vIn = QVTrelationUtil.getBindsTo(oteIn);
			//			RuleRegion ruleRegion = getRuleRegion();
			//			Node sourceNode = ruleRegion.getNode(vIn);
			acceptAll(QVTrelationUtil.getOwnedParts(oteIn));
			OCLExpression whereIn = oteIn.getWhere();
			if (whereIn != null) {
				getRelationAnalysis().analyzePredicate(whereIn);
			}
			return null;
		}

		@Override
		public @Nullable Element visitPackage(org.eclipse.ocl.pivot.@NonNull Package pIn) {
			if (PivotConstants.ORPHANAGE_URI.equals(pIn.getURI())) {
				return null;
			}
			org.eclipse.ocl.pivot.Package pOut = context.createPackage(pIn);
			//			createAll(pIn.getOwnedClasses(), pOut.getOwnedClasses());
			createAll(pIn.getOwnedPackages(), pOut.getOwnedPackages());
			createAll(pIn.getOwnedComments(), pOut.getOwnedComments());
			return pOut;
		}

		@Override
		public Element visitPropertyTemplateItem(@NonNull PropertyTemplateItem ptiIn) {
			OCLExpression targetExpression = getRelationAnalysis().analyzePropertyTemplateItem(ptiIn);
			targetExpression.accept(this);
			return null;
		}

		@Override
		public @NonNull MappingRegion visitRelation(@NonNull Relation rIn) {
			TransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(QVTbaseUtil.getOwningTransformation(rIn));
			RelationAnalysis relationAnalysis = this.relationAnalysis = (RelationAnalysis) transformationAnalysis.getRuleAnalysis(rIn);
			RuleRegion rOut = relationAnalysis.getRegion();
			assert rOut.getReferredRule() == rIn;
			context.pushScope(rOut);
			context.addTrace(rIn, rOut);
			for (@NonNull VariableDeclaration vIn : QVTrelationUtil.getOwnedVariables(rIn)) {
				relationAnalysis.analyzeVariableDeclaration(vIn);
			}
			Pattern whenIn = rIn.getWhen();
			if (whenIn != null) {
				for (@NonNull Predicate pIn : QVTrelationUtil.getOwnedPredicates(whenIn)) {
					relationAnalysis.analyzePredicate(QVTrelationUtil.getConditionExpression(pIn));
				}
			}
			Pattern whereIn = rIn.getWhere();
			if (whereIn != null) {
				for (@NonNull Predicate pIn : QVTrelationUtil.getOwnedPredicates(whereIn)) {
					relationAnalysis.analyzePredicate(QVTrelationUtil.getConditionExpression(pIn));
				}
			}
			//			rOut.setName(rIn.getName());
			acceptAll(QVTrelationUtil.getOwnedDomains(rIn));
			acceptAll(QVTrelationUtil.getOwnedVariables(rIn));
			createAll(rIn.getOwnedComments(), rOut.getOwnedComments());
			relationAnalysis = null;
			context.popScope();
			return rOut;
		}

		@Override
		public Element visitRelationDomain(@NonNull RelationDomain rdIn) {
			acceptAll(QVTrelationUtil.getOwnedPatterns(rdIn));
			return null;
		}

		@Override
		public @NonNull ScheduleModel visitRelationModel(@NonNull RelationModel mIn) {
			ScheduleModel mOut = scheduleManager.getScheduleModel(); // QVTscheduleFactory.eINSTANCE.createScheduleModel();
			context.pushScope(mOut);
			context.addTrace(mIn, mOut);
			createAll(mIn.getOwnedImports(), mOut.getOwnedImports());
			//			createAll(mIn.getOwnedPackages(), mOut.getOwnedPackages());
			for (org.eclipse.ocl.pivot.@NonNull Package p : PivotUtil.getOwnedPackages(mIn)) {
				doPackage(p, mOut);
			}
			//			if (mOut.getOwnedScheduledRegion() == null) {
			//				context.addProblem(new CompilerChainException("No scheduled region"));
			//			}
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			context.popScope();
			return mOut;
		}

		@Override
		public @NonNull ScheduledRegion visitRelationalTransformation(@NonNull RelationalTransformation tIn) {
			ScheduledRegion tOut = QVTscheduleFactory.eINSTANCE.createScheduledRegion();
			scheduleManager.getScheduleModel().getOwnedScheduledRegions().add(tOut);
			tOut.setReferredTransformation(tIn);
			context.addTrace(tIn, tOut);
			tOut.setName(tIn.getName());
			//			tOut.setOwnedContext(create(tIn.getOwnedContext()));
			//			createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
			//			createAll(tIn.getModelParameter(), tOut.getModelParameter());
			//			List<MappingRegion> ownedRegions = tOut.getMappingRegions();
			//						createAll(tIn.getRule(), ownedRegions);
			for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(tIn)) {
				MappingRegion rOut = (MappingRegion) relation.accept(this);
				if (rOut != null) {
					scheduleManager.setScheduledRegion(rOut, tOut);
					//					ownedRegions.add(target);
				}
			}
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
			return tOut;
		}

		@Override
		public Element visitSharedVariable(@NonNull SharedVariable svIn) {
			getRelationAnalysis().analyzeVariable(svIn);
			return null;
		}

		@Override
		public Element visitTemplateVariable(@NonNull TemplateVariable svIn) {
			//			getRelationAnalysis().analyzeVariable(svIn);
			return null;
		}
	}

	//	protected final @NonNull QVTuConfiguration qvtuConfiguration;
	protected final @NonNull CreateVisitor createVisitor;
	//	protected final @NonNull UpdateVisitor updateVisitor;

	//	private TypedModel middleTypedModelTarget = null;

	/**
	 * Forward traceability from a source object to its targets for the current mapping. Top level entries ourside a maping are indexed for the null mapping.
	 */
	private final @NonNull Map<@Nullable Nameable, @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>>> scope2source2targets = new HashMap<>();

	private final @NonNull Stack<@NonNull Nameable> scopeStack = new Stack<>();
	/**
	 * Reverse traceability from a target object to its source.
	 */
	private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<>();

	/**
	 * Reverse traceability from a target object to its source.
	 */
	private final @NonNull Map<@NonNull Element, @NonNull Element> debugCopy2source = new HashMap<>();

	private @Nullable Resource debugSource = null;
	private @Nullable Resource debugTarget = null;

	public QVTr2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory,
			@NonNull QVTuConfiguration qvtuConfiguration, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTrelationScheduleManager(environmentFactory, qvtuConfiguration, schedulerOptions), problemHandler);
		//		this.qvtuConfiguration = qvtuConfiguration;
		this.createVisitor = new CreateVisitor(this, qvtuConfiguration);
		//		this.updateVisitor = new UpdateVisitor(this);
	}

	/*	public void addDebugCopies(@NonNull Map<EObject, EObject> copier) {
		for (EObject eSource : copier.keySet()) {
			EObject eTarget = copier.get(eSource);
			assert (eSource != null) && (eTarget != null);
			debugCopy2source.put((Element)eTarget, (Element)eSource);
		}
	} */

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 *
	 * @param source the source of the trace
	 * @param generated the list of generated objects
	 * @param context the context in which the trace is valid
	 */
	public void addTrace(@NonNull Element source, @NonNull Element target) {
		target2source.put(target, source);
		//
		Nameable scope = scopeStack.peek();
		Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = scope2source2targets.get(scope);
		if (source2targets == null) {
			source2targets = new HashMap<>();
			scope2source2targets.put(scope, source2targets);
		}
		List<@NonNull Element> targets = source2targets.get(source);
		if (targets == null) {
			targets = new ArrayList<>();
			source2targets.put(source, targets);
		}
		assert !targets.contains(target);
		targets.add(target);
	}

	protected @Nullable Element basicEquivalentSource(@Nullable Element target) {
		if (target == null) {
			return null;
		}
		assert target.eResource() != debugSource : "source element used for basicEquivalentSource " + target;
		return target2source.get(target);
	}

	protected @NonNull DatumCaches createDatumCaches() {
		return new QVTrelationDatumCaches((QVTrelationScheduleManager) scheduleManager);
	}

	protected @NonNull Import createImport(@NonNull Import iIn) {
		Import iOut = createImport(iIn.getName(), ClassUtil.nonNull(iIn.getImportedNamespace()));
		addTrace(iIn, iOut);
		return iOut;
	}

	protected org.eclipse.ocl.pivot.@NonNull Package createPackage(org.eclipse.ocl.pivot.@NonNull Package pIn) {
		org.eclipse.ocl.pivot.Package pOut = createPackage(ClassUtil.nonNull(pIn.getName()), pIn.getNsPrefix(), pIn.getURI());
		addTrace(pIn, pOut);
		return pOut;
	}

	@Override
	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	protected @NonNull <T extends Element> T equivalentSource(@NonNull T target) {
		assert target.eResource() != debugSource : "source element used for equivalentSource " + target;
		@SuppressWarnings("unchecked") T source = (T) target2source.get(target);
		assert source != null;
		return source;
	}

	protected @NonNull <T extends Element> T equivalentTarget(/*@NonNull*/ T source) {
		assert source != null;
		assert source.eResource() != debugTarget : "target element used for equivalentTarget " + source;
		List<@NonNull Element> targets = null;
		for (int i = scopeStack.size(); (targets == null) && (--i >= 0); ) {
			Nameable scope = scopeStack.get(i);
			Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = scope2source2targets.get(scope);
			if (source2targets != null) {
				targets = source2targets.get(source);
			}
		}
		if (targets != null) {
			//		    assert targets.size() == 1;			-- multiple entries are allowed, the first/primary entry is used
			@SuppressWarnings("unchecked") T target = (T)targets.get(0);
			assert target != null;
			return target;
		}
		else {
			return source;
		}
	}

	public @NonNull List<@NonNull MappingRegion> getActiveRegions() {
		return new ArrayList<>();
	}

	//	protected @NonNull TypedModel getMiddleTypedModelTarget() {
	//		assert middleTypedModelTarget != null;
	//		return middleTypedModelTarget;
	//	}

	//	protected @NonNull RuleRegion getRuleRegionScope() {
	//		return (RuleRegion) scopeStack.peek();
	//	}

	//    protected @NonNull NamedElement getScope() {
	//    	return scopeStack.peek();
	//    }

	public void popScope() {
		scopeStack.pop();
	}

	public void pushScope(@NonNull Nameable scope) {
		assert !scopeStack.contains(scope);
		scopeStack.push(scope);
	}

	//	protected void setDebugSource(@NonNull Resource debugSource) {
	//		this.debugSource =  debugSource;
	//	}

	//	protected void setMiddleTypedModelTarget(@NonNull TypedModel middleTypedModelTarget) {
	//		this.middleTypedModelTarget = middleTypedModelTarget;
	//	}

	public void transform(@NonNull Resource source, @NonNull Resource target, @Nullable String traceNsURI, @NonNull Resource traceResource) throws IOException {
		debugSource = source;
		debugTarget = target;
		//
		//	Do the transformation for each CoreModel. First a createVisitor descent of the input, then an updateVisitor descent of the output.
		//
		List<@NonNull EObject> mOuts = target.getContents();
		for (EObject eContent : source.getContents()) {
			if (eContent instanceof RelationModel) {
				RelationModel mIn = (RelationModel) eContent;
				try {
					ScheduleModel mOut = (ScheduleModel) mIn.accept(createVisitor);
					assert mOut != null;
					mOuts.add(mOut);
					//			mOut.accept(updateVisitor);
				}
				catch (WrappedException e) {
					Throwable t = e.getCause();
					if (t instanceof IOException) {
						throw (IOException)t;
					}
					throw e;
				}
			}
		}
		for (@NonNull TransformationAnalysis transformationAnalysis : scheduleManager.getTransformationAnalyses()) {
			for (@NonNull RuleAnalysis mappingRegion : transformationAnalysis.getRuleAnalyses()) {
				mappingRegion.registerConsumptionsAndProductions();
			}
		}
		if (AbstractQVTb2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull TransformationAnalysis transformationAnalysis : scheduleManager.getTransformationAnalyses()) {
				for (@NonNull RuleAnalysis mappingRegion : transformationAnalysis.getRuleAnalyses()) {
					mappingRegion.registerConsumptionsAndProductions();
				}
				List<@NonNull RuleAnalysis> ruleAnalyses = Lists.newArrayList(transformationAnalysis.getRuleAnalyses());
				Collections.sort(ruleAnalyses, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
				for (@NonNull RuleAnalysis ruleAnalysis : ruleAnalyses) {
					scheduleManager.writeDebugGraphs(ruleAnalysis.getRegion(), null);
				}
			}
		}
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs("0-init", true, true, true);
		}
		//
		//	Debug code to conform that every output object is traceable to some input object.
		//
		for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
			EObject eTarget = tit.next();
			EObject eSource = target2source.get(eTarget);
			EObject eCopied = debugCopy2source.get(eTarget);
			if ((eSource == null) && (eCopied == null)) {
				System.err.println("No source for " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
			}
		}

		// FIXME the following lines should go obsolete
		List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, target);
		if (missingOperationCallSources != null) {
			System.err.println("Missing OperationCallExp sources  were fixed up for '" + target.getURI() + "'");
		}
	}
}
