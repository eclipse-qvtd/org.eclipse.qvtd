package org.eclipse.qvtd.build.qvtrtoqvtc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.qvtd.build.qvtrtoqvtc.evaluation.RuleFactory;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceData;
import org.eclipse.qvtd.build.qvtrtoqvtc.utilities.TransformationTraceDataImpl;

public class QvtrToQvtcTransformation {
	
	TransformationTraceData traceData;
	private Resource qvtrModel;
	private Resource qvtcModel;
	private Resource qvtcTraceModel;
	private List<ConstrainedRule> rules;
	private Map<EClass, List<EObject>> allInstancesCache;
	private Map<Class<? extends EObject>, List<EObject>> qvtcModelElements;
	private Map<Class<? extends EObject>, List<EObject>> qvtcMiddleElements;
	
	
	
	public QvtrToQvtcTransformation(Resource qvtrModel, Resource qvtcModel,
			Resource qvtcTraceModel) {
		this.qvtrModel = qvtrModel;		
		this.qvtcModel = qvtcModel;
		this.qvtcTraceModel = qvtcTraceModel;
		allInstancesCache = new HashMap<EClass, List<EObject>>();
		traceData = new TransformationTraceDataImpl();
		qvtcModelElements = new HashMap<Class<? extends EObject>, List<EObject>>();
		qvtcMiddleElements = new HashMap<Class<? extends EObject>, List<EObject>>();
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
				rules = factory.createTopRules();
			}
		}
	}

	public void execute() {
		
		// Only invoke "top" rules
		for(ConstrainedRule rule: rules) {
			// Top rules need binding of inputs from the resource
			List<Bindings> loopData = rule.findInputMatches(qvtrModel);
			executeRuleInLoop(rule, loopData);
		}
		       
	}
	
	private void executeRuleInLoop(ConstrainedRule rule,
			List<Bindings> loopData) {
		for (Bindings bindings : loopData) {
			TraceRecord record = executeRule(rule, bindings);
			if (!record.wasExecuted()) {
				traceData.deleteRecord(record);
				record = null;
			}
		}
	}


	// Save the qvtc resource
	public void finalize() {
		// What about the trace model? we need to separate them
		//qvtcSource.getContents().addAll(traceData.getRootOutputELements());
	}
	
	
	public TraceRecord executeRule(ConstrainedRule rule, Bindings bindings) {
		TraceRecord record = traceData.getRecord(rule, bindings);
		if (!record.wasExecuted()) {
			if (rule.when(this)) {
				for (EObject eo : rule.instantiateOutputElements(qvtcModelElements)) {
					if (qvtcModelElements.containsKey(eo.getClass())) {
						qvtcModelElements.get(eo.getClass()).add(eo);
					} else {
						List<EObject> temp = new ArrayList<EObject>();
						temp.add(eo);
						qvtcModelElements.put(eo.getClass(), temp);
					}
				}
				for (EObject eo : rule.instantiateMiddleElements(qvtcMiddleElements)) {
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
				record.wasExecuted(true);
				rule.setAttributes();
				rule.where(this);
			}
		}
		return record;
	}
	
	public void executeRule(ConstrainedRule rule, TraceRecord record) {
		if (rule.when(this)) {
			for (EObject eo : rule.instantiateOutputElements(qvtcModelElements)) {
				if (qvtcModelElements.containsKey(eo.getClass())) {
					qvtcModelElements.get(eo.getClass()).add(eo);
				} else {
					List<EObject> temp = new ArrayList<EObject>();
					temp.add(eo);
					qvtcModelElements.put(eo.getClass(), temp);
				}
			}
			record.wasExecuted(true);
			rule.setAttributes();
			rule.where(this);
		}
	}


	/**
	 * @return the qvtcSource
	 */
	public Resource getQvtcSource() {
		return qvtcModel;
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
