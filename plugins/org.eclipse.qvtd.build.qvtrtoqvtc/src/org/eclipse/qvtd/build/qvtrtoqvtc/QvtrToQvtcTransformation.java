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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseBottomPatternKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseCoreDomainKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreBaseGuardPatternKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.QVTcoreMappingKey;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToTracePackage;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RuleBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.TopLevelRelationToMappingForEnforcement;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceDataImpl;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;

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

	public QvtrToQvtcTransformation(@NonNull Resource qvtrModel, @NonNull Resource qvtcModel, @Nullable Resource qvtcTraceModel) {
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
		this.qvtcTraceModel = qvtcTraceModel;
		traceData = new TransformationTraceDataImpl();
	}

	public void addOrphan(@NonNull EObject eObject) {
		potentialOrphans.add(eObject);
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
	/*			for (EObject eo : rule.enforce(qvtcModelElements)) {
					if (qvtcModelElements.containsKey(eo.getClass())) {
						qvtcModelElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcModelElements.put(eo.getClass(), temp);
					}
				} */
				rule.setExecuted(true);
				rule.where();
				rule.setAttributes();
				
			}
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

	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcModel;
	}

	public @Nullable Rule getRecord(@NonNull RuleBindings relationsBindings) {
		return traceData.getRecord(relationsBindings);
	}

	public @NonNull Collection<? extends EObject> getCoreRoots() {
		return coreRoots;
	}

	public @NonNull Collection<? extends EObject> getTraceRoots() {
		return traceRoots;
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
	
	QVTcoreMappingKey mappings = new QVTcoreMappingKey();
	
	public @NonNull Mapping findMapping(@NonNull String mn, @NonNull Transformation mt) {
		Mapping m = mappings.get(mn, mt);
		if (m == null) {
			m = QVTcoreFactory.eINSTANCE.createMapping();
			m.setName(mn);
			m.setTransformation(mt);
			mappings.add(m);
			addOrphan(m);
		}
		assert m!= null;
		return m;
	}
	
	QVTcoreBaseGuardPatternKey guardPatterns = new QVTcoreBaseGuardPatternKey();

	public @NonNull GuardPattern findGuardPattern(@NonNull Area area) {
		GuardPattern mg = guardPatterns.get(area);
		if (mg == null) {
			mg = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			mg.setArea(area);
			guardPatterns.add(mg);
			addOrphan(mg);
		}
		assert mg!= null;
		return mg;
	}
	
	QVTcoreBaseBottomPatternKey botttomPatterns = new QVTcoreBaseBottomPatternKey();

	public @NonNull BottomPattern findBottomPattern(@NonNull Area area) {
		BottomPattern mb = botttomPatterns.get(area);
		if (mb == null) {
			mb = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			mb.setArea(area);
			mb.getBindsTo();
			botttomPatterns.add(mb);
			addOrphan(mb);
		}
		assert mb!= null;
		return mb;
	}
	
	QVTcoreBaseCoreDomainKey coreDomains = new QVTcoreBaseCoreDomainKey();

	public @NonNull CoreDomain findCoreDomain(String name, org.eclipse.qvtd.pivot.qvtbase.Rule rule) {
		
		CoreDomain md = coreDomains.get(name, rule);
		if (md == null) {
			md = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
			md.setName(name);
			md.setRule(rule);
			coreDomains.add(md);
			addOrphan(md);
		}
		assert md!= null;
		return md;
	}
	
	PivotVariableKey variables = new PivotVariableKey();
	PivotVariableKey realizedVariables = new PivotVariableKey();
	
	public @NonNull RealizedVariable findRealizedVariable(String name, Type type) {
		RealizedVariable rv = (RealizedVariable) realizedVariables.get(name, type);
		if (rv == null) {
			rv = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
			rv.setName(name);
			rv.setType(type);
			realizedVariables.add(rv);
			addOrphan(rv);
		}
		return rv;
	}
	
	public void save(@NonNull Resource asResource, @NonNull Collection<? extends EObject> eObjects, @NonNull Map<Object, Object> options) throws IOException {
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

}
