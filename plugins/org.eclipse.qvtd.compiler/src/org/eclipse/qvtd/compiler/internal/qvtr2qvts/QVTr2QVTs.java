/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.io.IOException;
import java.util.ArrayList;
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
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
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
	protected static class QVTr2QVTsVisitor extends AbstractExtendingQVTrelationVisitor<Element, QVTr2QVTs>
	{
		protected final @NonNull QVTrelationScheduleManager scheduleManager;
		private @Nullable RelationAnalysis relationAnalysis = null;

		public QVTr2QVTsVisitor(@NonNull QVTr2QVTs context) {
			super(context);
			this.scheduleManager = context.getScheduleManager();
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
				//				if (cOut instanceof RootRegion) {
				//					if (mOut.getOwnedRootRegion() != null) {
				//						context.addProblem(new CompilerChainException("Multiple scheduled regions"));
				//					}
				//					mOut.setOwnedRootRegion((RootRegion) cOut);
				//				}
			}
		}

		protected @NonNull RelationAnalysis getRelationAnalysis() {
			return ClassUtil.nonNullState(relationAnalysis);
		}

		protected @NonNull RuleRegion getRuleRegion() {
			return getRelationAnalysis().getRegion();
		}

		public void transform(@NonNull Resource source, @NonNull Resource target) throws IOException {
			List<@NonNull EObject> mOuts = target.getContents();
			for (EObject eContent : source.getContents()) {
				if (eContent instanceof RelationModel) {
					RelationModel mIn = (RelationModel) eContent;
					try {
						ScheduleModel mOut = (ScheduleModel) mIn.accept(this);
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
		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}

		@Override
		public Element visitCollectionTemplateExp(@NonNull CollectionTemplateExp cteIn) {
			for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(cteIn)) {
				member.accept(this);
			}
			// ?? rest ??
			RelationAnalysis relationAnalysis2 = getRelationAnalysis();
			relationAnalysis2.synthesizeCollectionTemplate(cteIn);
			OCLExpression whereIn = cteIn.getWhere();
			if (whereIn != null) {
				relationAnalysis2.synthesizePredicate(whereIn);
			}
			return null;
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
			RelationAnalysis relationAnalysis2 = getRelationAnalysis();
			Variable templateVariable = QVTrelationUtil.getBindsTo(oteIn);
			List<@NonNull PropertyTemplateItem> propertyTemplateItems = QVTrelationUtil.Internal.getOwnedPartsList(oteIn);
			if (relationAnalysis2.isKeyedRealization(templateVariable)) {
				RelationalTransformationAnalysis transformationAnalysis = relationAnalysis2.getTransformationAnalysis();
				org.eclipse.qvtd.pivot.qvtrelation.Key key = transformationAnalysis.getKeyForType(QVTrelationUtil.getType(templateVariable));
				assert key != null;
				Iterable<@NonNull Property> keyParts = QVTrelationUtil.getOwnedParts(key);
				Iterable<@NonNull Property> keyOppositeParts = QVTrelationUtil.getOwnedOppositeParts(key);
				Map<@NonNull Property, @NonNull Node> property2node = new HashMap<>();
				//				@NonNull Node[] argNodes = new @NonNull Node[Iterables.size(keyParts) + Iterables.size(keyOppositeParts)];
				//				int argIndex = 0;
				for (@NonNull Property keyPart : keyParts) {
					boolean gotIt = false;
					for (@NonNull PropertyTemplateItem propertyTemplateItem : propertyTemplateItems) {
						if (keyPart == QVTrelationUtil.getReferredProperty(propertyTemplateItem)) {
							Node partNode = relationAnalysis2.synthesizeKeyTemplatePart(propertyTemplateItem);
							assert partNode != null;
							property2node.put(keyPart, partNode);
							gotIt = true;
							break;
						}
					}
					assert gotIt;		// FIXME container
				}
				for (@NonNull Property keyOppositePart : keyOppositeParts) {
					boolean gotIt = false;
					Property keyPart = QVTrelationUtil.getOpposite(keyOppositePart);
					for (@NonNull PropertyTemplateItem propertyTemplateItem : propertyTemplateItems) {
						if (keyPart == QVTrelationUtil.getReferredProperty(propertyTemplateItem)) {
							Node partNode = relationAnalysis2.synthesizeKeyTemplatePart(propertyTemplateItem);
							assert partNode != null;
							property2node.put(keyPart, partNode);
							gotIt = true;
							break;
						}
					}
					assert gotIt;		// FIXME container
				}
				relationAnalysis2.synthesizeKeyTemplate(templateVariable, property2node);
			}
			else {
				for (@NonNull PropertyTemplateItem propertyTemplateItem : propertyTemplateItems) {
					propertyTemplateItem.accept(this);
				}
				//				for (@NonNull PropertyTemplateItem propertyTemplateItem : propertyTemplateItems) {
				//					OCLExpression targetExpression = relationAnalysis2.synthesizeObjectTemplatePart(propertyTemplateItem);
				//					targetExpression.accept(this);
				//				}
			}
			OCLExpression whereIn = oteIn.getWhere();
			if (whereIn != null) {
				relationAnalysis2.synthesizePredicate(whereIn);
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
			OCLExpression targetExpression = QVTrelationUtil.getOwnedValue(ptiIn);
			targetExpression.accept(this);
			/*OCLExpression targetExpression =*/ getRelationAnalysis().synthesizeObjectTemplatePart(ptiIn);
			//			targetExpression.accept(this);
			return null; //super.visitPropertyTemplateItem(ptiIn);
		}

		@Override
		public @NonNull MappingRegion visitRelation(@NonNull Relation rIn) {
			RelationalTransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(QVTbaseUtil.getOwningTransformation(rIn));
			RelationAnalysis relationAnalysis = this.relationAnalysis = transformationAnalysis.getRuleAnalysis(rIn);
			RuleRegion rOut = relationAnalysis.getRegion();
			assert rOut.getReferredRule() == rIn;
			context.pushScope(rOut);
			context.addTrace(rIn, rOut);
			//			rOut.setName(rIn.getName());
			//
			//	First create all the pattern variable nodes.
			//
			for (@NonNull VariableDeclaration vIn : QVTrelationUtil.getOwnedVariables(rIn)) {
				//				if (!QVTrelationUtil.isTraceClassVariable(vIn)) {
				relationAnalysis.synthesizeVariableDeclaration(vIn);
				//				}
			}
			acceptAll(QVTrelationUtil.getOwnedVariables(rIn));		// FIXME does nothing, reuse as earlier traversal
			//
			//	Then join up those that have pattern relationships.
			//
			acceptAll(QVTrelationUtil.getOwnedDomains(rIn));
			//
			//	Before installing the predicates that may re-navigate pattern edges.
			//
			Pattern whenIn = rIn.getWhen();
			if (whenIn != null) {
				for (@NonNull Predicate pIn : QVTrelationUtil.getOwnedPredicates(whenIn)) {
					relationAnalysis.synthesizePredicate(QVTrelationUtil.getOwnedConditionExpression(pIn));
				}
			}
			Pattern whereIn = rIn.getWhere();
			if (whereIn != null) {
				for (@NonNull Predicate pIn : QVTrelationUtil.getOwnedPredicates(whereIn)) {
					relationAnalysis.synthesizePredicate(QVTrelationUtil.getOwnedConditionExpression(pIn));
				}
			}
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
				if (!Orphanage.isTypeOrphanage(p)) {
					doPackage(p, mOut);
				}
			}
			//			if (mOut.getOwnedRootRegion() == null) {
			//				context.addProblem(new CompilerChainException("No scheduled region"));
			//			}
			createAll(mIn.getOwnedComments(), mOut.getOwnedComments());
			context.popScope();
			return mOut;
		}

		@Override
		public @NonNull RootRegion visitRelationalTransformation(@NonNull RelationalTransformation tIn) {
			RootRegion tOut = scheduleManager.getTransformationAnalysis(tIn).getRootRegion();
			context.addTrace(tIn, tOut);
			//			tOut.setOwnedContext(create(tIn.getOwnedContext()));
			//			createAll(tIn.getOwnedOperations(), tOut.getOwnedOperations());
			//			createAll(tIn.getModelParameter(), tOut.getModelParameter());
			//			List<MappingRegion> ownedRegions = tOut.getMappingRegions();
			//						createAll(tIn.getRule(), ownedRegions);
			for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(tIn)) {
				@SuppressWarnings("unused")MappingRegion rOut = (MappingRegion) relation.accept(this);
			}
			createAll(tIn.getOwnedComments(), tOut.getOwnedComments());
			return tOut;
		}

		@Override
		public Element visitSharedVariable(@NonNull SharedVariable svIn) {
			// SharedVariables are lazily synthesized on demand, thereby re-using the initExpression
			// node when correctly typed, and avoiding cretaing dead unused variables to confuse the head analysis.
			//			getRelationAnalysis().synthesizeSharedVariable(svIn);
			return null;
		}

		@Override
		public Element visitTemplateVariable(@NonNull TemplateVariable svIn) {
			// TemplateVariables are  synthesized by the TemplateExp that binds them.
			//			getRelationAnalysis().analyzeVariable(svIn);
			return null;
		}
	}

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

	public QVTr2QVTs(@NonNull EnvironmentFactory environmentFactory, @NonNull ProblemHandler problemHandler,
			@NonNull QVTuConfiguration qvtuConfiguration, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTrelationScheduleManager(environmentFactory, problemHandler, qvtuConfiguration, schedulerOptions), problemHandler);
		//		this.qvtuConfiguration = qvtuConfiguration;
		//		this.createVisitor = new CreateVisitor(this, qvtuConfiguration);
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

	//	public @NonNull List<@NonNull MappingRegion> getActiveRegions() {
	//		return new ArrayList<>();
	//	}

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

	@Override
	public @NonNull QVTrelationScheduleManager getScheduleManager() {
		return (QVTrelationScheduleManager) super.getScheduleManager();
	}

	public void pushScope(@NonNull Nameable scope) {
		assert !scopeStack.contains(scope);
		scopeStack.push(scope);
	}

	//	protected void setDebugSource(@NonNull Resource debugSource) {
	//		this.debugSource =  debugSource;
	//	}

	public @NonNull Map<@NonNull RootRegion, @NonNull Iterable<@NonNull MappingRegion>> transform(@NonNull Resource source, @NonNull Resource target, @Nullable String traceNsURI, @NonNull Resource traceResource) throws IOException {
		// FIXME the following lines should go obsolete
		List<OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, target);
		if (missingOperationCallSources != null) {
			System.err.println("Missing OperationCallExp sources were fixed up for '" + target.getURI() + "'");
		}
		boolean missingTraceArtefacts = QVTrelationUtil.rewriteMissingTraceArtefacts(environmentFactory, source);
		if (missingTraceArtefacts) {
			System.err.println("Missing trace TypedModel.Class artefacts were fixed up for '" + target.getURI() + "'");
		}
		//
		QVTrelationScheduleManager scheduleManager2 = getScheduleManager();
		debugSource = source;
		debugTarget = target;
		//
		//	Perform the pre-analysis that relies solely on traversal of the QVTr source model.
		//	- Establish which domain each element is part of
		//	- Establish which output variables are reachable by composition from their root
		//
		scheduleManager.analyzeSourceModel();
		//
		Iterable<@NonNull AbstractTransformationAnalysis> transformationAnalyses = scheduleManager2.getOrderedTransformationAnalyses();
		List<@NonNull TransformationAnalysis2TracePackage> transformationAnalysis2tracePackages = new ArrayList<>();
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : transformationAnalyses) {
			transformationAnalysis2tracePackages.add(transformationAnalysis.getTransformationAnalysis2TracePackage());
		}
		//
		//	Create a trace group to supervise the trace synthesis of each relation.
		//
		for (@NonNull TransformationAnalysis2TracePackage transformationAnalysis2tracePackage : transformationAnalysis2tracePackages) {
			transformationAnalysis2tracePackage.createRuleAnalysis2TraceGroups();
		}
		//
		//	Use the QVTr2QVTsVisitor in a tree descent to synthesize the QVTs elements that correspond directly to QVTr elements.
		//	Inter-relation elements are accumulated by InvocationAnalysis instances in the RuleAnalysis2TraceGroup.
		//
		QVTr2QVTsVisitor qvtr2qvtsVisitor = new QVTr2QVTsVisitor(this);
		qvtr2qvtsVisitor.transform(source, target);
		//
		//	Analyze the trace classes and interfaces to determine their inheritance and properties
		//
		for (@NonNull TransformationAnalysis2TracePackage transformationAnalysis2tracePackage : transformationAnalysis2tracePackages) {
			transformationAnalysis2tracePackage.analyzeTraceElements();
		}
		//
		//	Synthesize the trace nodes and edges to add support for overrides/when/where invocations.
		//
		for (@NonNull TransformationAnalysis2TracePackage transformationAnalysis2tracePackage : transformationAnalysis2tracePackages) {
			transformationAnalysis2tracePackage.synthesizeTraceElements();
		}
		/**
		 * Perform the independent local analysis of each Rule.
		 */
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : transformationAnalyses) {
			transformationAnalysis.analyzeMappingRegions();
		}
		//	for (@NonNull MappingRegion mappingRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager2.getScheduleModel())) {
		//		scheduleManager.writeDebugGraphs(mappingRegion, null);
		//	}
		//
		//	Create trace Model/Package/Class/Property instances
		//
		Model traceModel = PivotFactory.eINSTANCE.createModel();
		traceModel.setExternalURI(traceResource.getURI().toString());
		traceResource.getContents().add(traceModel);
		for (@NonNull TransformationAnalysis2TracePackage transformationAnalysis2tracePackage : transformationAnalysis2tracePackages) {
			org.eclipse.ocl.pivot.Package tracePackage = transformationAnalysis2tracePackage.synthesizeTraceModel();
			traceModel.getOwnedPackages().add(tracePackage);
			TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
			traceTypedModel.getUsedPackage().add(tracePackage);
			scheduleManager.analyzeTracePackage(traceTypedModel, tracePackage);
		}
		for (@NonNull MappingRegion mappingRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager2.getScheduleModel())) {
			scheduleManager2.writeDebugGraphs(mappingRegion, null);
		}
		scheduleManager2.analyzeOriginalContents();
		scheduleManager2.writeDebugGraphs("0-init", true, true, false);
		//
		//	Debug code to confirm that every output object is traceable to some input object.
		//
		for (TreeIterator<EObject> tit = target.getAllContents(); tit.hasNext(); ) {
			EObject eTarget = tit.next();
			EObject eSource = target2source.get(eTarget);
			EObject eCopied = debugCopy2source.get(eTarget);
			if ((eSource == null) && (eCopied == null)) {
				// FIXME				System.err.println("No source for " + eTarget.eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget)) + ":" + eTarget + " / " + eTarget.eContainer().eClass().getName() + "@" + Integer.toString(System.identityHashCode(eTarget.eContainer())));
			}
		}

		Map<@NonNull RootRegion, @NonNull Iterable<@NonNull RuleRegion>> rootRegion2activeRegions = scheduleManager2.analyzeTransformations();
		//
		//		List<@NonNull MappingRegion> orderedRegions = new ArrayList<>();
		//		for (@NonNull MappingRegion ruleRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager2.getScheduleModel())) {
		//			Rule rule = QVTscheduleUtil.getReferredRule(ruleRegion);
		//			RuleAnalysis mappingAnalysis = getRuleAnalysis(rule);
		//			orderedRegions.add(mappingAnalysis.getRuleRegion());
		//			orderedRegions.add(ruleRegion);
		//			mappingRegion.resolveRecursion();
		//		}
		Map<@NonNull RootRegion, @NonNull Iterable<@NonNull MappingRegion>> rootRegion2mergedRegions = new HashMap<>();
		/*		if (!scheduleManager.isNoEarlyMerge()) {
			for (@NonNull RootRegion rootRegion : rootRegion2activeRegions.keySet()) {
				Iterable<@NonNull RuleRegion> activeRegions = rootRegion2activeRegions.get(rootRegion);
				assert activeRegions != null;
				List<@NonNull MappingRegion> mergedRegions = new ArrayList<>(EarlyMerger.merge(scheduleManager, activeRegions));
				rootRegion2mergedRegions.put(rootRegion, mergedRegions);
			}
		}
		else { */
		for (@NonNull RootRegion rootRegion : rootRegion2activeRegions.keySet()) {
			Iterable<@NonNull RuleRegion> activeRegions = rootRegion2activeRegions.get(rootRegion);
			assert activeRegions != null;
			rootRegion2mergedRegions.put(rootRegion, Lists.newArrayList(activeRegions));
		}
		//		}
		return rootRegion2mergedRegions;
	}
}
