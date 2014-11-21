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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToMappingTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.impl.RelationalTransformationToTracePackage;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceDataImpl;

public class QvtrToQvtcTransformation
{
	private final @NonNull TransformationTraceData traceData;
	private final @NonNull Resource qvtrModel;
	private final @NonNull Resource qvtcModel;
	
	@SuppressWarnings("unused")
	private final @Nullable Resource qvtcTraceModel;
//	private Rule.Factory[] ruleFactories;
	
	@SuppressWarnings("unused")
	private Map<EClass, List<EObject>> allInstancesCache;
	private final @NonNull List<EObject> potentialOrphans = new ArrayList<EObject>();
	private final @NonNull List<EObject> traceRoots = new ArrayList<EObject>();
	private final @NonNull List<EObject> coreRoots = new ArrayList<EObject>();

	public QvtrToQvtcTransformation(@NonNull Resource qvtrModel, @NonNull Resource qvtcModel, @Nullable Resource qvtcTraceModel) {
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
		this.qvtcTraceModel = qvtcTraceModel;
		allInstancesCache = new HashMap<EClass, List<EObject>>();
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
		rule.check();
		if (rule.when()) {
			rule.enforce();
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
			rule.setAttributes();
			rule.where();
		}
	}
	
	public void executeTopLevelRule(@NonNull Rule rule) {
		rule.check();
		if (!rule.hasExecuted()) {
			if (rule.when()) {
				rule.enforce();
/*				for (EObject eo : rule.enforce(potentialOrphans)) {
					if (qvtcModelElements.containsKey(eo.getClass())) {
						qvtcModelElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcModelElements.put(eo.getClass(), temp);
					}
				} */
				/*
				for (EObject eo : rule.instantiateMiddleElements(qvtcMiddleElements)) {
					if (qvtcMiddleElements.containsKey(eo.getClass())) {
						qvtcMiddleElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcMiddleElements.put(eo.getClass(), temp);
					}
				}
				*/
				// After output instantiation the record can be said to be executed
				// so recursive/nested mappings can be invoked
				rule.setExecuted(true);
				rule.setAttributes();
				rule.where();
			}
		}
	}

	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcModel;
	}

	public @Nullable Rule getRecord(@NonNull RelationsBindings relationsBindings) {
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

	/*
	private void findAndSetInputElements(ConstrainedRule rule,
			Resource rt) {
		
		if (rule instanceof RelationalTransformationToMappingTransformation) {
			// rt
			if (allInstancesCache.containsKey(RelationalTransformation.class)) {
				rule.setInputElements(allInstancesCache.get(ec));
			} else {
				EList<EObject> allInstances = new BasicEList<EObject>();
				TreeIterator<EObject> it = qvtrSource.getAllContents();
				while(it.hasNext()) {
					EObject eo = it.next();
					if (eo.eClass().equals(ec)) {
						allInstances.add(eo);
					} else if(eo.eClass().getEAllSuperTypes().contains(ec)) {
						allInstances.add(eo);
					}
				}
				allInstancesCache.put(ec, allInstances);
				rule.setInputElements((EList<EObject>) allInstances);
			}
		}
		
	}
	*/

}
