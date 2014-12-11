/*******************************************************************************
 * Copyright (c) 2014 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.qvtrtoqvtc;

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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseBottomPatternKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseCoreDomainKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseGuardPatternKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreMappingKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreVariableKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToTracePackage;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.TopLevelRelationToMappingForEnforcement;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceDataImpl;
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
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QvtrToQvtcTransformation
{
	private final @NonNull TransformationTraceData traceData;
	private final @NonNull Resource qvtrModel;
	private final @NonNull Resource qvtcModel;
	
	@SuppressWarnings("unused")
	private final @Nullable Resource qvtcTraceModel;
//	private Rule.Factory[] ruleFactories;
	
	private final @NonNull List<EObject> potentialOrphans = new ArrayList<EObject>();
	private final @NonNull List<EObject> traceRoots = new ArrayList<EObject>();
	private final @NonNull List<EObject> coreRoots = new ArrayList<EObject>();
	private final @NonNull Map<Variable, Variable> variableTrace = new HashMap<Variable, Variable>();
	
	private Map<Type, Key> keysforTypes = new HashMap<Type, Key>();
	private Map <Variable, TemplateExp> templateExpforVaraibless = new HashMap<Variable, TemplateExp>();
	private boolean doGlobalSearch = true;
	private final @NonNull MetaModelManager metaModelManager;

	private QVTcoreMappingKey mappings = new QVTcoreMappingKey();
	
	private QVTcoreBaseGuardPatternKey guardPatterns = new QVTcoreBaseGuardPatternKey();

	private QVTcoreBaseBottomPatternKey botttomPatterns = new QVTcoreBaseBottomPatternKey();
	
	private QVTcoreBaseCoreDomainKey coreDomains = new QVTcoreBaseCoreDomainKey();

	private PivotPropertyKey properties = new PivotPropertyKey();

	private QVTcoreVariableKey variables = new QVTcoreVariableKey();
	
	private QVTcoreVariableKey realizedVariables = new QVTcoreVariableKey();
	
	public QvtrToQvtcTransformation(@NonNull MetaModelManager metaModelManager, @NonNull Resource qvtrModel, @NonNull Resource qvtcModel, @Nullable Resource qvtcTraceModel) {
		
		this.metaModelManager = metaModelManager;
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
		this.qvtcTraceModel = qvtcTraceModel;
		traceData = new TransformationTraceDataImpl();
		// Create a cache of opposite relations
		TreeIterator<EObject> it = qvtrModel.getAllContents();
		while(it.hasNext()) {
			EObject eo = it.next();
			if (eo instanceof Key) {
				keysforTypes.put(((Key)eo).getIdentifies(), (Key) eo);
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
				templateExpforVaraibless.put(te.getBindsTo(), te);
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
		for (EObject eObject : potentialOrphans) {
			if (eObject.eContainer() == null) {
				coreRoots.add(eObject);
			}
		}
	}
	
	public void executeFactory(@NonNull Rule.Factory factory) {
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
			@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule rule) {
		
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
	
	public Property findProperty(@NonNull String name, @NonNull Type owningType) {
		
		Property p = null;
		if (doGlobalSearch) {
			p = properties.get(name, owningType);
		}
		if (p == null) {
			p = PivotFactory.eINSTANCE.createProperty();
			assert p!= null;
			p.setName(name);
			p.setOwningType(owningType);
			properties.add(p);
		}
		return p;
	}

	public @NonNull RealizedVariable findRealizedVariable(@NonNull String name,
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
	
	
	public @NonNull Variable findVariable(@NonNull String name,
			@NonNull Type type, @NonNull CorePattern pattern) {
		
		Variable v = null;
		if (doGlobalSearch) {
			v = (Variable) variables.get(name, type, pattern);
			// A variable search can also be for a realized variable
			if (v == null) {
				v = (RealizedVariable) realizedVariables.get(name, type, pattern);
			}
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
		return keysforTypes.get(type);
	}
	
	/**
	 * @return the metaModelManager
	 */
	public MetaModelManager getMetaModelManager() {
		return metaModelManager;
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
	
	public @NonNull Collection<? extends EObject> getTraceRoots() {
		return traceRoots;
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


	public void putVariableTrace(@NonNull Variable rv, @NonNull Variable mv) {
		
		variableTrace.put(rv, mv);
	}


	public void saveTrace(@NonNull Resource asResource, @NonNull Collection<? extends EObject> eObjects, @NonNull Map<Object, Object> options) throws IOException {
        Root root = PivotFactory.eINSTANCE.createRoot();
        root.setExternalURI(asResource.getURI().toString());
        asResource.getContents().add(root);
        for (EObject eObject : eObjects) {
        	if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
                root.getNestedPackage().add((org.eclipse.ocl.examples.pivot.Package)eObject);
        	}
        	else {
        		asResource.getContents().add(eObject);
        	}
        }
		asResource.save(options);
	}
	
	public void saveCore(@NonNull Resource asResource, @NonNull Collection<? extends EObject> eObjects, @NonNull Map<Object, Object> options) throws IOException {
        CoreModel root = QVTcoreFactory.eINSTANCE.createCoreModel();
        root.setExternalURI(asResource.getURI().toString());
        asResource.getContents().add(root);
        for (EObject eObject : eObjects) {
        	if (eObject instanceof org.eclipse.ocl.examples.pivot.Package) {
                root.getNestedPackage().add((org.eclipse.ocl.examples.pivot.Package)eObject);
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
		
		return templateExpforVaraibless.get(dv);
	}

}
