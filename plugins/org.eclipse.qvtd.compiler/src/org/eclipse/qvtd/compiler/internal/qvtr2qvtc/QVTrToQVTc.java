/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.ecore.as2es.AS2Ecore;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.DebugTraceBack;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrToQVTc
{
	/**
	 * An ExpressionCopier deep copies an OCLExpression tree, exploiting the forward traceability of context to
	 * update references and using sibling to distinguish multiple targets.
	 */
	@SuppressWarnings("serial")
	protected class ExpressionCopier extends EcoreUtil.Copier
	{	
		private final @Nullable Element sibling;

		public ExpressionCopier(@Nullable Element sibling) {
			this.sibling = sibling;
		}

		@Override
		public EObject get(Object oIn) {
			if (oIn instanceof Element) {
				List<Element> oOuts = source2targets.get(oIn);
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
	
	private final @NonNull EnvironmentFactory environmentFactory;	
	private final @NonNull Resource qvtrResource;
	private final @NonNull Resource qvtcResource;
	private final @NonNull Map<@NonNull Element, @NonNull Element> target2source = new HashMap<@NonNull Element, @NonNull Element>();
	private final @NonNull Map<@NonNull Element, @NonNull List<@NonNull Element>> source2targets = new HashMap<@NonNull Element, @NonNull List<@NonNull Element>>();
	
	private final @NonNull List<@NonNull EObject> potentialOrphans = new ArrayList<@NonNull EObject>();
	private final @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages = new ArrayList<org.eclipse.ocl.pivot.@NonNull Package>();
	private final @NonNull List<@NonNull Transformation> coreTransformations = new ArrayList<@NonNull Transformation>();
	private final @NonNull Map<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class> relationToTraceClass = new HashMap<@NonNull Relation, org.eclipse.ocl.pivot.@NonNull Class>();
	// Un-navigable opposites
	//
	//	The Key that identifies each Class.
	// FIXME can there be two keys for the sane Class?
	//
	private final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Key> class2key = new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Key>();
	private final @NonNull Map<@NonNull Variable, @NonNull TemplateExp> variable2templateExp = new HashMap<@NonNull Variable, @NonNull TemplateExp>();
	private final @NonNull Map<@NonNull Relation, @NonNull List<@NonNull RelationCallExp>> relationCallExpsForRelation = new HashMap<@NonNull Relation, @NonNull List<@NonNull RelationCallExp>>();
	private final @NonNull Map<@NonNull RelationCallExp, @NonNull Relation> invokingRelationsForRelationCallExp = new HashMap<@NonNull RelationCallExp, @NonNull Relation>();
	
	private @NonNull CoreModel coreModel;
	
	/**
	 * The lazily created named RealizedVariables in each CorePattern.
	 */
	private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull RealizedVariable>> pattern2name2realizedVariable
			= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull RealizedVariable>>();	
	
	/**
	 * The lazily created named RealizedVariables in each CorePattern.
	 */
	private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull Variable>> pattern2name2variable
			= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull String, @NonNull Variable>>();	
	
	/**
	 * The lazily created RealizedVariables per Relation Variable in each CorePattern.
	 */
	private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull RealizedVariable>> pattern2variable2realizedVariable
			= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull RealizedVariable>>();

	/**
	 * The lazily created Core Variable for each Relation Variable in each CorePattern.
	 */
	private @NonNull Map<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull Variable>> pattern2variable2variable
			= new HashMap<@NonNull CorePattern, @NonNull Map<@NonNull Variable, @NonNull Variable>>();

	/**
	 * The core Transformation for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, @NonNull Transformation> relationalTransformation2coreTransformation
			= new HashMap<@NonNull RelationalTransformation, @NonNull Transformation>();	

	/**
	 * The trace Package for each RelationalTransformation.
	 */
	private @NonNull Map<@NonNull RelationalTransformation, org.eclipse.ocl.pivot.@NonNull Package> relationalTransformation2tracePackage
			= new HashMap<@NonNull RelationalTransformation, org.eclipse.ocl.pivot.@NonNull Package>();	
	
	/**
	 * The lazily created named CoreDomain in each Rule.
	 */
	private @NonNull Map<@NonNull Rule, @NonNull Map<@NonNull String, @NonNull CoreDomain>> rule2name2coreDomain
			= new HashMap<@NonNull Rule, @NonNull Map<@NonNull String, @NonNull CoreDomain>>();	
	
	/**
	 * The lazily created named Trace Properties in each Trace Class.
	 */
	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Map<@NonNull String, @NonNull Property>> traceClass2name2traceProperty
			= new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Map<@NonNull String, @NonNull Property>>();	

	/**
	 * The lazily created named Core mappings for each transformation.
	 */
	private @NonNull Map<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>> transformation2name2mapping
			= new HashMap<@NonNull Transformation, @NonNull Map<@NonNull String, @NonNull Mapping>>();
	
	/**
	 * The core Variable for each relation Variable
	 */
	private final @NonNull Map<@NonNull Variable, @NonNull Variable> variable2variable = new HashMap<@NonNull Variable, @NonNull Variable>();
	
	public QVTrToQVTc(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource qvtcResource) {	
		this.environmentFactory = environmentFactory;
		this.qvtrResource = qvtrResource;		
		this.qvtcResource = qvtcResource;
//		this.traceResource = traceResource;
		this.coreModel = QVTcoreFactory.eINSTANCE.createCoreModel();
        
		// Create a cache of opposite relations and copy imports
		TreeIterator<EObject> it = qvtrResource.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Key) {
				Key key = (Key)eo;
				org.eclipse.ocl.pivot.Class identifies = key.getIdentifies();
				assert identifies != null;
				class2key.put(identifies, key);
			}
			// Populate bindsTo of DomainPattern
			if (eo instanceof Pattern) {
				Pattern p = (Pattern) eo;
				for (Predicate pred : p.getPredicate()) {
					OCLExpression conditionExpression = pred.getConditionExpression();
					assert conditionExpression != null;
					p.getBindsTo().addAll(getVarsOfExp(conditionExpression));
				}
				if (eo instanceof DomainPattern) {
					DomainPattern dp = (DomainPattern) eo;
					TemplateExp te = dp.getTemplateExpression();
					dp.getBindsTo().add(te.getBindsTo());
					if (te instanceof ObjectTemplateExp) {
						dp.getBindsTo().addAll(getNestedBindToVariable((ObjectTemplateExp) te));
					}
				}
			}
			if (eo instanceof TemplateExp) {
				TemplateExp te = (TemplateExp) eo;
				Variable bindsTo = te.getBindsTo();
				assert bindsTo != null;
				variable2templateExp.put(bindsTo, te);
			}
			if (eo instanceof RelationCallExp) {
				RelationCallExp ri = (RelationCallExp) eo; 
				Relation r = ri.getReferredRelation();
				assert r != null;
				Predicate p = (Predicate) ri.eContainer();
				Pattern pattern = p.getPattern();
				if (pattern.eContainer() instanceof Relation) {
					Relation ir = (Relation) pattern.eContainer();
					if (ir.getWhere() == pattern) {
						List<RelationCallExp> relationCallExps = relationCallExpsForRelation.get(r);
						if (relationCallExps != null) {
							relationCallExps.add(ri);
						} else {
							List<RelationCallExp> callExps = new ArrayList<RelationCallExp>();
							callExps.add(ri);
							relationCallExpsForRelation.put(r, callExps);
						}
						invokingRelationsForRelationCallExp.put(ri, ir);
					}
				}
			}
			if (eo instanceof Import) {
				this.coreModel.getOwnedImports().add((Import) EcoreUtil.copy(eo));
			}
		}
	}
	
	
    public void addDebugCopies(@NonNull Map<EObject, EObject> copier) {
	    for (EObject eSource : copier.keySet()) {
	    	EObject eTarget = copier.get(eSource);
	    	if (eTarget != null) {
	    		putTrace((Element)eTarget, (Element)eSource);
	    	}
	    }
	}
	
	public void addOrphan(@NonNull EObject eObject) {
		potentialOrphans.add(eObject);
	}

	/*public*/ @NonNull <T extends Element> T copy(@NonNull T eIn, @Nullable Element sibling) {
//		if (eIn == null) {
//			return null;
//		}
		EcoreUtil.Copier copier = new ExpressionCopier(sibling);
		@SuppressWarnings("unchecked") T eOut = (T) copier.copy(eIn);			
	    copier.copyReferences();
	    addDebugCopies(copier);
	    assert eOut != null;
		return eOut;
	}

	public @NonNull OperationCallExp createOperationCallExp() {
		OperationCallExp oce = PivotFactory.eINSTANCE.createOperationCallExp();
		assert oce != null;
		addOrphan(oce);
		return oce;
	}


	public @NonNull Predicate createPredicate() {
		Predicate pd = QVTbaseFactory.eINSTANCE.createPredicate();
		assert pd != null;
		addOrphan(pd);
		return pd;
	}

	public @NonNull PropertyAssignment createPropertyAssignment() {
		PropertyAssignment a = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
		assert a != null;
		addOrphan(a);
		return a;
	}
	
	
	public @NonNull PropertyCallExp createPropertyCallExp() {
		PropertyCallExp pce = PivotFactory.eINSTANCE.createPropertyCallExp();
		assert pce != null;
		addOrphan(pce);
		return pce;
	}


	public @NonNull VariableExp createVariableExp() {
		VariableExp ve = PivotFactory.eINSTANCE.createVariableExp();
		assert ve != null;
		addOrphan(ve);
		return ve;
	}

	// Save the qvtc resource
	public void dispose() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
	}

	public void execute() {
		for (EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				transformToTracePackages(tracePackages, ClassUtil.nullFree(((RelationModel)eObject).getOwnedPackages()));
			}
		}
		for (EObject eObject : qvtrResource.getContents()) {
			if (eObject instanceof RelationModel) {
				transformToCoreTransformations(coreTransformations, ClassUtil.nullFree(((RelationModel)eObject).getOwnedPackages()));
			}
		}
		for (RelationalTransformation relationalTransformation : relationalTransformation2coreTransformation.keySet()) {
			for (Rule rule : relationalTransformation.getRule()) {
				if (rule instanceof Relation) {
					TopLevelRelationToMappingForEnforcement topLevelRelationToMappingForEnforcement = new TopLevelRelationToMappingForEnforcement(this);
					topLevelRelationToMappingForEnforcement.doTopLevelRelationToMappingForEnforcement((Relation)rule);
				}
			}
		}
		for (RelationalTransformation relationalTransformation : relationalTransformation2coreTransformation.keySet()) {
			for (Rule rule : relationalTransformation.getRule()) {
				if (rule instanceof Relation) {
					InvokedRelationToMappingForEnforcement invokedRelationToMappingForEnforcement = new InvokedRelationToMappingForEnforcement(this);
					invokedRelationToMappingForEnforcement.doInvokedRelationToMappingForEnforcement((Relation)rule);
				}
			}
		}
		for (Transformation coreTransformation : relationalTransformation2coreTransformation.values()) {
			for (Element target : target2source.keySet()) {
				if (QVTbaseUtil.getContainingTransformation(target) == coreTransformation) {
					DebugTraceBack traceBack = QVTbaseFactory.eINSTANCE.createDebugTraceBack();
					traceBack.setTarget(target);
					traceBack.getSources().add(target2source.get(target));
					coreTransformation.getOwnedDebugTraceBacks().add(traceBack);
				}
			}
		}
	}

	/*public*/ @NonNull Transformation getCoreTransformation(@NonNull RelationalTransformation relationalTransformation) {
		return ClassUtil.nonNullState(relationalTransformation2coreTransformation.get(relationalTransformation));
	}

	/*public*/ @NonNull Variable getCoreVariable(@NonNull Variable relationVariable) {
		return ClassUtil.nonNullState(variable2variable.get(relationVariable));
	}
	
	public @NonNull DomainPattern getDomainPattern(@NonNull Domain d) {
		List<@NonNull DomainPattern> pattern = ClassUtil.nullFree(((RelationDomain) d).getPattern());
		assert pattern.size() == 1;
		DomainPattern domainPattern = pattern.get(0);
		assert domainPattern != null;
		return domainPattern;
	}
	
	/*public*/ @NonNull Relation getInvokingRelationForRelationCallExp(@NonNull RelationCallExp e) {	
		return ClassUtil.nonNullState(invokingRelationsForRelationCallExp.get(e));
	}

	public @Nullable Key getKeyforType(@NonNull Type type) {
		return class2key.get(type);
	}
	
	private @NonNull Set<@NonNull Variable> getNestedBindToVariable(@NonNull ObjectTemplateExp ote) {
		Set<@NonNull Variable> vars = new HashSet<@NonNull Variable>();
		for (PropertyTemplateItem p : ote.getPart()) {
			OCLExpression e = p.getValue();
			assert e != null;
			if (e instanceof ObjectTemplateExp) {
				Variable bindsTo = ((ObjectTemplateExp)e).getBindsTo();
				assert bindsTo != null;
				vars.add(bindsTo);
				vars.addAll(getNestedBindToVariable((ObjectTemplateExp) e));
			} else {
				vars.addAll(getVarsOfExp(e));
			}
		}
		return vars;
	}
	
	public Predicate getPredicateForRelationCallExp(RelationCallExp ri) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcResource;
	}

	public @NonNull List<@NonNull RelationCallExp> getRelationCallExpsForRelation(@NonNull Relation r) {		
		return ClassUtil.nonNullState(relationCallExpsForRelation.get(r));
	}
	
	/* =============  Queries ============= */
	// TODO bug 45386 // ?? this is suspect for more than 2 domains. // FIXME What is 'shared'? a) any two domains b) output/any-input c) all domains
	public @NonNull Set<@NonNull Variable> getSharedDomainVars(@NonNull Relation r) {	
		Set<@NonNull Variable> vars = new HashSet<@NonNull Variable>();
		for (Domain d : ClassUtil.nullFree(r.getDomain())) {
			for (DomainPattern domainPattern : ClassUtil.nullFree(((RelationDomain) d).getPattern())) {
				List<@NonNull Variable> bt = ClassUtil.nullFree(domainPattern.getBindsTo()); 
				if (vars.isEmpty()) {
					vars.addAll(bt);
				} else {
					vars.retainAll(bt);
				}
			}
		}
		return vars;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}

	/*public*/ @Nullable TemplateExp getTemplateExpression(@NonNull Variable dv) {		
		return variable2templateExp.get(dv);
	}
	
	/*public*/ org.eclipse.ocl.pivot.@NonNull Class getTraceClass(@NonNull Relation relation) {		
		return ClassUtil.nonNullState(relationToTraceClass.get(relation));
	}

	/*public*/ org.eclipse.ocl.pivot.@NonNull Package getTracePackage(@NonNull RelationalTransformation relationalTransformation) {
		return ClassUtil.nonNullState(relationalTransformation2tracePackage.get(relationalTransformation));
	}
	
	/*
	 * Get variables occurring in an OCL expression
	 */
	public @NonNull Set<@NonNull Variable> getVarsOfExp(@NonNull OCLExpression e) {
		
		Set<@NonNull Variable> vs1 = new HashSet<@NonNull Variable>();
		if (e instanceof VariableExp) {
			VariableDeclaration referredVariable = ((VariableExp)e).getReferredVariable();
			if (referredVariable instanceof Variable) {
				vs1.add((Variable)referredVariable);
			}
		}
		else if (e instanceof ObjectTemplateExp) {
			ObjectTemplateExp te = (ObjectTemplateExp) e;
			Variable bindsTo = te.getBindsTo();
			if (bindsTo != null) {
				vs1.add((Variable)bindsTo);
			}
		}
		for (TreeIterator<EObject> tit = e.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable instanceof Variable) {
					vs1.add((Variable)referredVariable);
				}
			}
			else if (eObject instanceof ObjectTemplateExp) {
				ObjectTemplateExp te = (ObjectTemplateExp)eObject;
				Variable bindsTo = te.getBindsTo();
				if (bindsTo != null) {
					vs1.add((Variable)bindsTo);
				}
			}
		}
		// FIXME this function is not complete! It needs to be completed for other 
		// type of expressions
		Set<@NonNull Variable> vs = new HashSet<@NonNull Variable>();
		if (e instanceof VariableExp) {
			Variable referredVariable = (Variable) ((VariableExp) e).getReferredVariable();
			assert referredVariable != null;
			vs.add(referredVariable);
		} else if (e instanceof OperationCallExp) {
			OperationCallExp oc = (OperationCallExp) e;
			OCLExpression ownedSource = oc.getOwnedSource();
			assert ownedSource != null;
			vs.addAll(getVarsOfExp(ownedSource));
			for (OCLExpression a : ClassUtil.nullFree(oc.getOwnedArguments())) {
				vs.addAll(getVarsOfExp(a));
			}
		} else if (e instanceof PropertyCallExp) {
			OCLExpression ownedSource = ((PropertyCallExp) e).getOwnedSource();
			assert ownedSource != null;
			vs.addAll(getVarsOfExp( ownedSource));
		} else if (e instanceof RelationCallExp) {
			RelationCallExp rc = (RelationCallExp) e;
			for (OCLExpression a : ClassUtil.nullFree(rc.getArgument())) {
				vs.addAll(getVarsOfExp(a));
			}
		} else if (e instanceof EnumLiteralExp) {
			
		} 
		else if (e instanceof ObjectTemplateExp) {
			ObjectTemplateExp te = (ObjectTemplateExp) e;
			Variable bindsTo = te.getBindsTo();
			assert bindsTo != null;
			vs.add(bindsTo);
			for (PropertyTemplateItem p : te.getPart()) {
				OCLExpression value = p.getValue();
				assert value != null;
				vs.addAll(getVarsOfExp(value));
			}
		} else if (e instanceof CollectionTemplateExp) {
			CollectionTemplateExp cte = (CollectionTemplateExp) e;
			for (OCLExpression m : ClassUtil.nullFree(cte.getMember()))
				vs.addAll(getVarsOfExp(m));
		}
		else {
			assert false : "getVarsOfExp() missing case for " + e.eClass().getName();
		}
		assert vs.equals(vs1);
		return vs;
	}

	// Create the top rules, and search the input model for the appropriate types, when possible?
	public void prepare() {
		try {
			qvtrResource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// EXIT!
		} finally {
//			if (qvtrModel.isLoaded()) {
				//RuleFactory factory = new RuleFactory();
				//rules = factory.createTopRules(this);
//				ruleFactories = new Rule.Factory[] {
//						RelationalTransformationToMappingTransformation.FACTORY,
//						RelationToTraceClass.FACTORY
//				};
//			}
		}
	}
	
	/*public*/ void putCoreTransformation(@NonNull RelationalTransformation relationTransformation, @NonNull Transformation coreTransformation) {		
		relationalTransformation2coreTransformation.put(relationTransformation, coreTransformation);
		putTrace(coreTransformation, relationTransformation);
	}


	/*public*/ void putCoreVariable(@NonNull Variable relationVariable, @NonNull Variable coreVariable) {
		Variable oldVal = variable2variable.put(relationVariable, coreVariable);
		// Variables should only be traced once
		if (oldVal != null) {
			System.out.println("putCoreVariable replacing value for " + relationVariable.getName());
		}
		putTrace(coreVariable, relationVariable);
	}

	/*public*/ void putRelationTrace(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class traceClass) {		
		relationToTraceClass.put(r, traceClass);
//		putTrace(traceClass, r);
	}
	
	private void putTrace(@NonNull Element coreElement, @NonNull Element relationElement) {
//		if (relationElement != null) {
			Element oldRelationElement = target2source.put(coreElement, relationElement);
			assert oldRelationElement == null;
			List<@NonNull Element> targets = source2targets.get(relationElement);
			if (targets == null) {
				targets = new ArrayList<@NonNull Element> ();
				source2targets.put(relationElement, targets);
			}
			targets.add(coreElement);
//		}
	}
	
	/*public*/ void putTracePackage(@NonNull RelationalTransformation rt, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {		
		relationalTransformation2tracePackage.put(rt, tracePackage);
//		putTrace(tracePackage, rt);
	}

	public void saveCore(@NonNull Resource asResource, @NonNull Map<?, ?> options) throws IOException {
        this.coreModel.setExternalURI(asResource.getURI().toString());
        // Copy imports
        
        org.eclipse.ocl.pivot.Package corePackage = PivotFactory.eINSTANCE.createPackage();
        corePackage.setName("");
        this.coreModel.getOwnedPackages().add(corePackage);
        asResource.getContents().add(this.coreModel);
        corePackage.getOwnedClasses().addAll(coreTransformations);
		for (EObject eObject : potentialOrphans) {
			if (eObject.eContainer() == null) {
				asResource.getContents().add(eObject);
			}
		}
		asResource.save(options);
	}

	public void saveTrace(@NonNull Resource asResource,  @NonNull Map<?, ?> options) throws IOException {
        Model root = PivotFactory.eINSTANCE.createModel();
        URI traceURI = PivotUtilInternal.getNonASURI(asResource.getURI());
		root.setExternalURI(traceURI.toString());
        asResource.getContents().add(root);
        for (org.eclipse.ocl.pivot.Package p : tracePackages) {
            root.getOwnedPackages().add(p);
            // Add the package to the CoreModel imports, there should be only one!!
            Import i = PivotFactory.eINSTANCE.createImport();
            i.setName(p.getName());
            i.setImportedNamespace(p);
            coreModel.getOwnedImports().add(i);
        }
		AS2Ecore as2ecore = new AS2Ecore((EnvironmentFactoryInternal) environmentFactory, traceURI, null);
		XMLResource ecoreResource = as2ecore.convertResource(asResource, traceURI);
		ecoreResource.save(options);
	}

	private void transformToCoreTransformations(@NonNull List<@NonNull Transformation> coreTransformations, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) {
		for (org.eclipse.ocl.pivot.Package relationPackage : relationPackages) {
			for (org.eclipse.ocl.pivot.Class relationClass : relationPackage.getOwnedClasses()) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToMappingTransformation relationalTransformationToMappingTransformation = new RelationalTransformationToMappingTransformation(this);
					Transformation coreTransformation = relationalTransformationToMappingTransformation.doRelationalTransformationToMappingTransformation((RelationalTransformation)relationClass);
					coreTransformations.add(coreTransformation);
				}
			}
			transformToCoreTransformations(coreTransformations, ClassUtil.nullFree(relationPackage.getOwnedPackages()));
		}
	}
	
	private void transformToTracePackages(@NonNull List<org.eclipse.ocl.pivot.@NonNull Package> tracePackages, @NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> relationPackages) {
		for (org.eclipse.ocl.pivot.Package relationPackage : relationPackages) {
			for (org.eclipse.ocl.pivot.Class relationClass : relationPackage.getOwnedClasses()) {
				if (relationClass instanceof RelationalTransformation) {
					RelationalTransformationToTracePackage relationalTransformationToTracePackage = new RelationalTransformationToTracePackage(this);
					org.eclipse.ocl.pivot.Package tracePackage = relationalTransformationToTracePackage.doRelationalTransformationToTracePackage((RelationalTransformation)relationClass);
					tracePackages.add(tracePackage);
				}
			}
			transformToTracePackages(tracePackages, ClassUtil.nullFree(relationPackage.getOwnedPackages()));
		}
	}

	/**
	 * Lazily create the name CoreDomain for a coreRule.
	 */
	/*public*/ @NonNull CoreDomain whenCoreDomain(@NonNull Rule coreRule, @NonNull String name) {
		Map<@NonNull String, @NonNull CoreDomain> name2coreDomain = rule2name2coreDomain.get(coreRule);
		if (name2coreDomain == null) {
			name2coreDomain = new HashMap<@NonNull String, @NonNull CoreDomain>();
			rule2name2coreDomain.put(coreRule, name2coreDomain);
		}
		CoreDomain coreDomain = name2coreDomain.get(name);
		if (coreDomain == null) {
			coreDomain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			coreDomain.setName(name);
			coreDomain.setRule(coreRule);
			name2coreDomain.put(name, coreDomain);
//			putTrace(coreDomain, coreRule);
			GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			coreDomain.setGuardPattern(guardPattern);
//			putTrace(guardPattern, coreRule);
			BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			coreDomain.setBottomPattern(bottomPattern);
//			putTrace(bottomPattern, coreRule);
		}
		return coreDomain;
	}

	/**
	 * Lazily create the name Mapping for a coreTransformation.
	 */
	/*public*/ @NonNull Mapping whenMapping(@NonNull Relation relation, @NonNull String name) {
		RelationalTransformation rt = (RelationalTransformation) relation.getTransformation();
		assert rt != null;
		@NonNull Transformation coreTransformation = getCoreTransformation(rt);
		Map<@NonNull String, @NonNull Mapping> name2mapping = transformation2name2mapping.get(coreTransformation);
		if (name2mapping == null) {
			name2mapping = new HashMap<@NonNull String, @NonNull Mapping>();
			transformation2name2mapping.put(coreTransformation, name2mapping);
		}
		Mapping coreMapping = name2mapping.get(name);
		if (coreMapping == null) {
			coreMapping = QVTcoreFactory.eINSTANCE.createMapping();
			putTrace(coreMapping, relation);
			coreMapping.setName(name);
			coreMapping.setTransformation(coreTransformation);
			name2mapping.put(name, coreMapping);
//			putTrace(coreMapping, coreTransformation);
			GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			coreMapping.setGuardPattern(guardPattern);
//			putTrace(guardPattern, coreTransformation);
			BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			coreMapping.setBottomPattern(bottomPattern);
//			putTrace(bottomPattern, coreTransformation);
		}
		return coreMapping;
	}

	/**
	 * Lazily create the RealizedVariable for a corePattern corresponding to a relationVariable.
	 */
	/*public*/ @NonNull RealizedVariable whenRealizedVariable(@NonNull BottomPattern corePattern, @NonNull Variable relationVariable) {	
		Map<@NonNull Variable, @NonNull RealizedVariable> variable2realizedVariable = pattern2variable2realizedVariable.get(corePattern);
		if (variable2realizedVariable == null) {
			variable2realizedVariable = new HashMap<@NonNull Variable, @NonNull RealizedVariable>();
			pattern2variable2realizedVariable.put(corePattern, variable2realizedVariable);
		}
		RealizedVariable realizedVariable = variable2realizedVariable.get(relationVariable);
		if (realizedVariable == null) {
			String name = relationVariable.getName();
			Type type = relationVariable.getType();
			assert (name != null) && (type != null);
			realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			realizedVariable.setName(name);
			realizedVariable.setType(type);
			realizedVariable.setIsRequired(true);
			variable2realizedVariable.put(relationVariable, realizedVariable);
			corePattern.getRealizedVariable().add(realizedVariable);
			putCoreVariable(relationVariable, realizedVariable);
		}
		return realizedVariable;
	}
	
	/**
	 * Lazily create the name RealizedVariable for a corePattern with a type.
	 */
	/*public*/ @NonNull RealizedVariable whenRealizedVariable(@NonNull BottomPattern corePattern, @NonNull String name, @NonNull Type type) {	
		Map<@NonNull String, @NonNull RealizedVariable> name2realizedVariable = pattern2name2realizedVariable.get(corePattern);
		if (name2realizedVariable == null) {
			name2realizedVariable = new HashMap<@NonNull String, @NonNull RealizedVariable>();
			pattern2name2realizedVariable.put(corePattern, name2realizedVariable);
		}
		RealizedVariable realizedVariable = name2realizedVariable.get(name);
		if (realizedVariable == null) {
			realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			realizedVariable.setName(name);
			realizedVariable.setType(type);
			realizedVariable.setIsRequired(true);;
			name2realizedVariable.put(name, realizedVariable);
			corePattern.getRealizedVariable().add(realizedVariable);
//			putTrace(realizedVariable, corePattern);
		}
		else {
			assert realizedVariable.getType() == type;
		}
		return realizedVariable;
	}
	
	/**
	 * Lazily create the name Property for a traceClass with a type.
	 */
	/*public*/ @NonNull Property whenTraceProperty(org.eclipse.ocl.pivot.@NonNull Class traceClass, @NonNull String name, @NonNull Type type) {
		Map<@NonNull String, @NonNull Property> name2traceProperty = traceClass2name2traceProperty.get(traceClass);
		if (name2traceProperty == null) {
			name2traceProperty = new HashMap<@NonNull String, @NonNull Property>();
			traceClass2name2traceProperty.put(traceClass, name2traceProperty);
		}
		Property traceProperty = name2traceProperty.get(name);
		if (traceProperty == null) {
			traceProperty = PivotFactory.eINSTANCE.createProperty();
			traceProperty.setName(name);
			traceProperty.setType(type);
			traceProperty.setIsRequired(true);
			name2traceProperty.put(name, traceProperty);
			traceProperty.setOwningClass(traceClass);
			if (!(type instanceof DataType)) {
				Property oppositeProperty = PivotFactory.eINSTANCE.createProperty();
				oppositeProperty.setName(traceClass.getName());		// FIXME unique, mutable Class
				oppositeProperty.setType(traceClass);
				oppositeProperty.setIsRequired(true);
				oppositeProperty.setIsImplicit(true);
				oppositeProperty.setOwningClass((org.eclipse.ocl.pivot.@NonNull Class)type);
				traceProperty.setOpposite(oppositeProperty);
				oppositeProperty.setOpposite(traceProperty);
//				putTrace(oppositeProperty, type);
			}
//			putTrace(traceProperty, traceClass);
		}
		else {
			assert traceProperty.getType() == type;
		}
		return traceProperty;
	}
	
	/**
	 * Lazily create the Variable for a corePattern corresponding to a relationVariable.
	 */
	/*public*/ @NonNull Variable whenVariable(@NonNull CorePattern corePattern, @NonNull Variable relationVariable) {
		Map<@NonNull Variable, @NonNull Variable> variable2variable = pattern2variable2variable.get(corePattern);
		if (variable2variable == null) {
			variable2variable = new HashMap<@NonNull Variable, @NonNull Variable>();
			pattern2variable2variable.put(corePattern, variable2variable);
		}
		Variable coreVariable = variable2variable.get(relationVariable);
		if (coreVariable == null) {
			String name = relationVariable.getName();
			Type type = relationVariable.getType();
			assert (name != null) && (type != null);
			coreVariable = PivotFactory.eINSTANCE.createVariable();
			coreVariable.setName(name);
			coreVariable.setType(type);
			coreVariable.setIsRequired(relationVariable.isIsRequired());
			variable2variable.put(relationVariable, coreVariable);
			corePattern.getVariable().add(coreVariable);
			putCoreVariable(relationVariable, coreVariable);
		}
		return coreVariable;
	}
	
	/**
	 * Lazily create the name Variable for a corePattern with a type.
	 */
	/*public*/ @NonNull Variable whenVariable(@NonNull CorePattern corePattern, @NonNull String name, @NonNull Type type) {
		Map<@NonNull String, @NonNull Variable> name2variable = pattern2name2variable.get(corePattern);
		if (name2variable == null) {
			name2variable = new HashMap<@NonNull String, @NonNull Variable>();
			pattern2name2variable.put(corePattern, name2variable);
		}
		Variable coreVariable = name2variable.get(name);
		if (coreVariable == null) {
			coreVariable = PivotFactory.eINSTANCE.createVariable();
			coreVariable.setName(name);
			coreVariable.setType(type);
			coreVariable.setIsRequired(true);
			name2variable.put(name, coreVariable);
			corePattern.getVariable().add(coreVariable);
			putTrace(coreVariable, corePattern);
		}
		else {
			assert coreVariable.getType() == type;
		}
		return coreVariable;
	}
}
