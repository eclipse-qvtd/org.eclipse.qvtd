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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.build.qvtrtoqvtc.evaluation.RuleFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceDataImpl;

public class QvtrToQvtcTransformation
{
	private final @NonNull TransformationTraceData traceData;
	private final @NonNull Resource qvtrModel;
	private final @NonNull Resource qvtcModel;
	@SuppressWarnings("unused")
	private final @Nullable Resource qvtcTraceModel;
	private List<ConstrainedRule> rules;
	@SuppressWarnings("unused")
	private Map<EClass, List<EObject>> allInstancesCache;
	private final @NonNull Map<Class<? extends EObject>, List<EObject>> qvtcModelElements = new HashMap<Class<? extends EObject>, List<EObject>>();
	private final @NonNull Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements = new HashMap<Class<? extends EObject>, List<EObject>>();

	public QvtrToQvtcTransformation(@NonNull Resource qvtrModel, @NonNull Resource qvtcModel, @Nullable Resource qvtcTraceModel) {
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
		this.qvtcTraceModel = qvtcTraceModel;
		allInstancesCache = new HashMap<EClass, List<EObject>>();
		traceData = new TransformationTraceDataImpl();
	}
	
	// Save the qvtc resource
	public void dispose() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
	}

	public void execute() {
		// Only invoke "top" rules
		for (ConstrainedRule rule: rules) {
			if (rule != null) {
				// Top rules need binding of inputs from the resource
				for (RelationsBindings bindings : rule.findInputMatches(qvtrModel)) {
					if (bindings != null) {
						TraceRecord record = executeTopLevelRule(bindings);
						if ((record != null) && !record.hasExecuted()) {
							traceData.deleteRecord(record);
							record = null;
						}
					}
				}
			}
		}
	}
	
	public void executeNestedRule(@NonNull CoreBindings coreBindings) {
		RelationsBindings relationsBindings = coreBindings.getRelationsBindings();
		ConstrainedRule rule = relationsBindings.getRule();
		if (rule.when(relationsBindings)) {
			for (EObject eo : rule.instantiateOutputElements(qvtcModelElements, coreBindings)) {
				if (qvtcModelElements.containsKey(eo.getClass())) {
					qvtcModelElements.get(eo.getClass()).add(eo);
				} else {
					List<EObject> temp = new ArrayList<EObject>();
					temp.add(eo);
					qvtcModelElements.put(eo.getClass(), temp);
				}
			}
			coreBindings.getTraceRecord().setExecuted(true);
			rule.setAttributes(coreBindings);
			rule.where(coreBindings);
		}
	}
	
	public TraceRecord executeTopLevelRule(@NonNull RelationsBindings relationsBindings) {
		TraceRecord record = null;
//		if (!record.hasExecuted()) {
			CoreBindings coreBindings = relationsBindings.getCoreBindings();
			ConstrainedRule rule = relationsBindings.getRule();
			if (rule.when(relationsBindings)) {
				for (EObject eo : rule.instantiateOutputElements(qvtcModelElements, coreBindings)) {
					if (qvtcModelElements.containsKey(eo.getClass())) {
						qvtcModelElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcModelElements.put(eo.getClass(), temp);
					}
				}
				for (EObject eo : rule.instantiateMiddleElements(qvtcMiddleElements, coreBindings)) {
					if (qvtcMiddleElements.containsKey(eo.getClass())) {
						qvtcMiddleElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcMiddleElements.put(eo.getClass(), temp);
					}
				}
				// After output instantiation the record can be said to be executed
				// so recursive/nested mappings can be invoked
				record = coreBindings.getTraceRecord();
				record.setExecuted(true);
				rule.setAttributes(coreBindings);
				rule.where(coreBindings);
			}
//		}
		return record;
	}

	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcModel;
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
			if (qvtrModel.isLoaded()) {
				RuleFactory factory = new RuleFactory();
				rules = factory.createTopRules(this);
			}
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
