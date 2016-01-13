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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.InvokedRelationToMappingForEnforcement;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.QVTcoreBaseBottomPatternKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.QVTcoreBaseCoreDomainKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.QVTcoreBaseGuardPatternKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.QVTcoreMappingKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.QVTcoreVariableKey;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RelationalTransformationToTracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RuleBindings;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.TopLevelRelationToMappingForEnforcement;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.utilities.TransformationTraceDataImpl;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
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
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QvtrToQvtcTransformation
{
	private final @NonNull TransformationTraceData traceData;
	private final @NonNull Resource qvtrModel;
	private final @NonNull Resource qvtcModel;
	
//	private final @Nullable Resource qvtcTraceModel;
//	private Rule.Factory[] ruleFactories;
	
	private final @NonNull List<EObject> potentialOrphans = new ArrayList<EObject>();
	private final @NonNull List<EObject> traceRoots = new ArrayList<EObject>();
	private final @NonNull List<EObject> coreRoots = new ArrayList<EObject>();
	private final @NonNull Map<Variable, Variable> variableTrace = new HashMap<Variable, Variable>();
	private final @NonNull Map<Relation, org.eclipse.ocl.pivot.Class> relationToTraceClass = new HashMap<Relation, org.eclipse.ocl.pivot.Class>();
	private final @NonNull Map<RelationalTransformation, org.eclipse.ocl.pivot.Package>  transformationToPackage = new HashMap<RelationalTransformation, org.eclipse.ocl.pivot.Package>();
	// Un-navigable opposites
	private final Map<Type, Key> keyForType = new HashMap<Type, Key>();
	private final Map <Variable, TemplateExp> templateExpForVaraible = new HashMap<Variable, TemplateExp>();
	private final Map<Relation, List<RelationCallExp>> relationCallExpsForRelation = new HashMap<Relation, List<RelationCallExp>>();
	private final Map<RelationCallExp, Relation> invokingRelationsForRelationCallExp = new HashMap<RelationCallExp, Relation>();
	
	private boolean doGlobalSearch = true;
	private final @NonNull EnvironmentFactory environmentFactory;

	private QVTcoreMappingKey mappings = new QVTcoreMappingKey();
	
	private QVTcoreBaseGuardPatternKey guardPatterns = new QVTcoreBaseGuardPatternKey();

	private QVTcoreBaseBottomPatternKey botttomPatterns = new QVTcoreBaseBottomPatternKey();
	
	private QVTcoreBaseCoreDomainKey coreDomains = new QVTcoreBaseCoreDomainKey();

	private PivotPropertyKey properties = new PivotPropertyKey();

	private QVTcoreVariableKey variables = new QVTcoreVariableKey();
	
	private QVTcoreVariableKey realizedVariables = new QVTcoreVariableKey();
	private CoreModel coreModel;
	
	
	public QvtrToQvtcTransformation(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource qvtrModel, @NonNull Resource qvtcModel, @Nullable Resource qvtcTraceModel) {
		
		this.environmentFactory = environmentFactory;
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
//		this.qvtcTraceModel = qvtcTraceModel;
		traceData = new TransformationTraceDataImpl();
		this.coreModel = QVTcoreFactory.eINSTANCE.createCoreModel();
        
		// Create a cache of opposite relations and copy imports
		TreeIterator<EObject> it = qvtrModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Key) {
				keyForType.put(((Key)eo).getIdentifies(), (Key) eo);
			}
			// Populate bindsTo of DomainPattern
			if (eo instanceof Pattern) {
				Pattern p = (Pattern) eo;
				for (Predicate pred : p.getPredicate()) {
					p.getBindsTo().addAll(getVarsOfExp(pred.getConditionExpression()));
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
				templateExpForVaraible.put(te.getBindsTo(), te);
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
	
	
	public void addOrphan(@NonNull EObject eObject) {
		potentialOrphans.add(eObject);
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
		executeFactory(RelationalTransformationToTracePackage.FACTORY);
		for (EObject eObject : potentialOrphans) {
			if (eObject.eContainer() == null) {
				traceRoots.add(eObject);
			}
		}
		potentialOrphans.clear();
		executeFactory(RelationalTransformationToMappingTransformation.FACTORY);
		executeFactory(TopLevelRelationToMappingForEnforcement.FACTORY);
		executeFactory(InvokedRelationToMappingForEnforcement.FACTORY);
		for (EObject eObject : potentialOrphans) {
			if (eObject.eContainer() == null) {
				coreRoots.add(eObject);
			}
		}
	}
	
	public void executeFactory(Rule.@NonNull Factory factory) {
		for (Rule rule : factory.getRules(this, qvtrModel)) {
			if (rule != null) {
				executeTopLevelRule(rule);
				if (rule.hasExecuted()) {
					traceData.addRecord(rule);
				}
			}
		}
	}
	
	public void executeNestedRule(@NonNull Rule rule) {
		if (!rule.hasExecuted()) {
			rule.check();
			if (rule.when()) {
				rule.instantiateOutput();
				rule.setExecuted(true);
				rule.where();
				rule.setAttributes();
			}
		}
		if (rule.hasExecuted()) {
			traceData.addRecord(rule);
		}
	}
	
	public void executeTopLevelRule(@NonNull Rule rule) {
		if (!rule.hasExecuted()) {
			rule.check();
			if (rule.when()) {
				rule.instantiateOutput();
				// After output instantiation the record can be said to be executed
				// so recursive/nested mappings can be invoked
				rule.setExecuted(true);
				rule.where();
				rule.setAttributes();
				
			}
		}
	}
	
	public @NonNull BottomPattern findBottomPattern(@NonNull Area area) {
		
		BottomPattern mb = null;
		if (doGlobalSearch) {
			mb = botttomPatterns.get(area);
		}
		if (mb == null) {
			mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			assert mb!= null;
			mb.setArea(area);
			mb.getBindsTo();
			botttomPatterns.add(mb);
			//addOrphan(mb);
		}
		return mb;
	}

	public @NonNull CoreDomain findCoreDomain(@NonNull String name,
			org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule rule) {
		
		CoreDomain md = null;
		if (doGlobalSearch) {
			md = coreDomains.get(name, rule);
		}
		if (md == null) {
			md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			assert md!= null;
			md.setName(name);
			md.setRule(rule);
			coreDomains.add(md);
			//addOrphan(md);
		}
		return md;
	}
	
	public @NonNull GuardPattern findGuardPattern(@NonNull Area area) {
		
		GuardPattern mg = null;
		if (doGlobalSearch) {
			 mg = guardPatterns.get(area);
		}
		if (mg == null) {
			mg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			assert mg!= null;
			mg.setArea(area);
			guardPatterns.add(mg);
			//addOrphan(mg);
		}
		
		return mg;
	}

	public @NonNull Mapping findMapping(@NonNull String mn, @NonNull Transformation mt) {
		
		Mapping m = null;
		if (doGlobalSearch) {
			m = mappings.get(mn, mt);
		}
		if (m == null) {
			m = QVTcoreFactory.eINSTANCE.createMapping();
			assert m!= null;
			m.setName(mn);
			m.setTransformation(mt);
			mappings.add(m);
		}
		return m;
	}
	
	public Property findProperty(@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class owningType) {
		
		Property p = null;
		if (doGlobalSearch) {
			p = properties.get(name, owningType);
		}
		if (p == null) {
			p = PivotFactory.eINSTANCE.createProperty();
			assert p!= null;
			p.setName(name);
			p.setOwningClass(owningType);
			properties.add(p);
		}
		return p;
	}

	public @NonNull RealizedVariable findRealizedVariable(@NonNull Variable sv,
			@NonNull CorePattern pattern) {
		
		RealizedVariable rv = null;
		String name = sv.getName();
		Type type = sv.getType();
		assert (name != null) && (type != null);
		if (doGlobalSearch) {
			rv = (RealizedVariable) realizedVariables.get(name, type, pattern);
		}
		if (rv == null) {
			rv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			assert rv!= null;
			rv.setName(name);
			rv.setType(type);
			realizedVariables.add(rv, pattern);
			pattern.getVariable().add(rv);
			putVariableTrace(sv, rv);
		}
		return rv;
	}
	
	public @NonNull RealizedVariable findTraceRealizedVariable(@NonNull String name,
			@NonNull Type type, @NonNull CorePattern pattern) {
		
		RealizedVariable rv = null;
		if (doGlobalSearch) {
			rv = (RealizedVariable) realizedVariables.get(name, type, pattern);
		}
		if (rv == null) {
			rv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			assert rv!= null;
			rv.setName(name);
			rv.setType(type);
			realizedVariables.add(rv, pattern);
			pattern.getVariable().add(rv);
		}
		return rv;
	}
	
	public @NonNull Variable findVariable(@NonNull Variable sv,
			@NonNull CorePattern pattern) {
		
		Variable v = null;
		String name = sv.getName();
		Type type = sv.getType();
		assert (name != null) && (type != null);
		if (doGlobalSearch) {
			v = variables.get(name, type, pattern);
		}
		if (v == null) {
			v = PivotFactory.eINSTANCE.createVariable();
			assert v!= null;
			v.setName(name);
			v.setType(type);
			variables.add(v, pattern);
			pattern.getVariable().add(v);
			putVariableTrace(sv, v);
		}
		return v;
	}
	
	public @NonNull Variable findVariable(@NonNull String name,
			@NonNull Type type, @NonNull CorePattern pattern) {
		
		Variable v = null;
		if (doGlobalSearch) {
			v = variables.get(name, type, pattern);
		}
		if (v == null) {
			v = PivotFactory.eINSTANCE.createVariable();
			assert v!= null;
			v.setName(name);
			v.setType(type);
			variables.add(v, pattern);
			pattern.getVariable().add(v);
		}
		return v;
	}


	public @NonNull Collection<? extends EObject> getCoreRoots() {
		return coreRoots;
	}
	
	public @Nullable Key getKeyforType(@NonNull Type type) {
		return keyForType.get(type);
	}
	
	/**
	 * @return the metamodelManager
	 */
//	public MetamodelManager getMetamodelManager() {
//	return metamodelManager;
//}
	public @NonNull StandardLibrary getStandardLibrary() {
		return environmentFactory.getStandardLibrary();
	}
	
	private Set<Variable> getNestedBindToVariable(ObjectTemplateExp ote) {
		Set<Variable> vars = new HashSet<Variable>();
		for (PropertyTemplateItem p : ote.getPart()) {
			OCLExpression e = p.getValue();
			if (e instanceof ObjectTemplateExp) {
				vars.add(((ObjectTemplateExp)e).getBindsTo());
				vars.addAll(getNestedBindToVariable((ObjectTemplateExp) e));
			} else {
				vars.addAll(getVarsOfExp(e));
			}
		}
		return vars;
	}
	
	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcModel;
	}
	
	public @Nullable Rule getRecord(@NonNull RuleBindings relationsBindings) {
		return traceData.getRecord(relationsBindings);
	}
	
	public @Nullable Relation getInvokingRelationForRelationCallExp(@NonNull RelationCallExp e) {
		
		return invokingRelationsForRelationCallExp.get(e);
	}
	
	public @Nullable List<RelationCallExp> getRelationCallExpsForRelation(@NonNull Relation r) {
		
		return relationCallExpsForRelation.get(r);
	}
	
	public @NonNull Collection<? extends EObject> getTraceRoots() {
		return traceRoots;
	}
	
	public org.eclipse.ocl.pivot.@Nullable Class getRelationTrace(@NonNull Relation relation) {
		
		return relationToTraceClass.get(relation);
	}
	
	public org.eclipse.ocl.pivot.@Nullable Package getTransformationToPackageTrace(RelationalTransformation rt) {
		
		return transformationToPackage.get(rt);
	}

	public @Nullable Variable getVariableTrace(@NonNull Variable referredVariable) {
		
		return variableTrace.get(referredVariable);
	}
	

	private Set<Variable> getVarsOfExp(OCLExpression e) {
		QVTr2QVTcRelations rels = new QVTr2QVTcRelations(this);
		return rels.getVarsOfExp(e);
	}


	/**
	 * @return the doGlobalSearch
	 */
	public boolean isDoGlobalSearch() {
		return doGlobalSearch;
	}


	// Create the top rules, and search the input model for the appropriate types, when possible?
	public void prepare() {
		try {
			qvtrModel.load(null);
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

	public void putRelationTrace(@NonNull Relation r, org.eclipse.ocl.pivot.@NonNull Class rc) {
		
		relationToTraceClass.put(r, rc);
	}
	
	public void putTransformationToPackageTrace(RelationalTransformation rt, org.eclipse.ocl.pivot.Package p) {
		
		transformationToPackage.put(rt, p);
	}
	
	public void putVariableTrace(@NonNull Variable rv, @NonNull Variable mv) {
		
		Variable oldVal = variableTrace.put(rv, mv);
		// Variables should only be traced once
		if (oldVal != null) {
			System.out.println("putVariableTrace replacing value for " + rv.getName());
		}
	}


	public void saveTrace(@NonNull Resource asResource, @NonNull Collection<? extends EObject> eObjects, @NonNull Map<?, ?> options) throws IOException {
        Model root = PivotFactory.eINSTANCE.createModel();
        root.setExternalURI(asResource.getURI().toString());
        asResource.getContents().add(root);
        for (EObject eObject : eObjects) {
        	if (eObject instanceof org.eclipse.ocl.pivot.Package) {
        		org.eclipse.ocl.pivot.Package p = (org.eclipse.ocl.pivot.Package)eObject; 
                root.getOwnedPackages().add(p);
                // Add the package to the CoreModel imports, there should be only one!!
                Import i = PivotFactory.eINSTANCE.createImport();
                i.setName(p.getName());
                i.setImportedNamespace(p);
                this.coreModel.getOwnedImports().add(i);
        	}
        	else {
        		asResource.getContents().add(eObject);
        	}
        }
		asResource.save(options);
	}
	
	public void saveCore(@NonNull Resource asResource, @NonNull Collection<? extends EObject> eObjects, @NonNull Map<?, ?> options) throws IOException {
        this.coreModel.setExternalURI(asResource.getURI().toString());
        // Copy imports
        
        Package capsule = PivotFactory.eINSTANCE.createPackage();
        this.coreModel.getOwnedPackages().add(capsule);
        asResource.getContents().add(this.coreModel);
        for (EObject eObject : eObjects) {
        	if (eObject instanceof org.eclipse.qvtd.pivot.qvtbase.Transformation) {
                capsule.getOwnedClasses().add((org.eclipse.qvtd.pivot.qvtbase.Transformation) eObject);
        	}
        	else {
        		asResource.getContents().add(eObject);
        	}
        }
		asResource.save(options);
	}

	/**
	 * @param doGlobalSearch TRUE to enable global search, FALSE to disable it
	 */
	public void setDoGlobalSearch(boolean doGlobalSearch) {
		this.doGlobalSearch = doGlobalSearch;
	}

	
	public TemplateExp getTemplateExpression(Variable dv) {
		
		return templateExpForVaraible.get(dv);
	}


	public Predicate getPredicateForRelationCallExp(RelationCallExp ri) {
		// TODO Auto-generated method stub
		return null;
	}

}
