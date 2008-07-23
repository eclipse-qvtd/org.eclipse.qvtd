/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CancellationException;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.importer.rose.builder.RoseUtil;
import org.eclipse.emf.importer.rose.builder.UnitTreeNode;
import org.eclipse.emf.importer.rose.parser.RoseNode;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporter;

/**
 * Provide functions to process a Rose UML file.
 * <p>
 * The derived implementation supports access to inherited tables by the derived
 * RoseUMLEcoreBuilder, maintenance of a monitor and access to the {ordered} constraint. 
 */
public class RoseUMLUtil extends RoseUtil
{
	protected final RoseUMLImporter roseUMLImporter;
	
    public RoseUMLUtil(RoseUMLImporter roseUMLImporter, URIConverter uriConverter)
    {
        super(uriConverter);
        this.roseUMLImporter = roseUMLImporter;
        roseEcoreBuilder = new RoseUMLEcoreBuilder(this);
    }

	@Override public UnitTreeNode createRoseUnitTreeAndTable(String fileNameNodeValue, UnitTreeNode topNode) throws Exception {
		notifySubTask("Loading " + fileNameNodeValue, 0);
		return super.createRoseUnitTreeAndTable(fileNameNodeValue, topNode);
	}

	/**
  	 * Return the Rose Constraints string as a list of individual constraints formed
  	 * by splitting at commas and then trimming whitespace.
  	 * @param roseNode
  	 * @return the individual constraints
  	 */
	public List<String> getConstraints(RoseNode roseNode) {
		String constraintString = roseNode.getConstraints();
		if (constraintString == null)
			return Collections.emptyList();
		List<String> constraints = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(constraintString, ",");
		while (tokenizer.hasMoreTokens())
			constraints.add(tokenizer.nextToken().trim());
		return constraints;
	}

	public Object getQuid(String quid) {
		return quidTable.get(quid);
	}

	/**
	 * Return true if roseNode has an 'ordered' constraint.
	 * @param roseNode
	 * @return true if ordered
	 */
	public boolean hasOrderedConstraint(RoseNode roseNode) {
		List<String> constraints = getConstraints(roseNode);
	    for (String constraint : constraints)
	    	if ("ordered".equals(constraint))
	    		return true;
	    return false;
	}

	protected void notifySubTask(String subTaskName, int worked) {
		Monitor monitor = roseUMLImporter.getMonitor();
		if (monitor != null) {
			if (monitor.isCanceled())
				throw new CancellationException("Cancellation requested");
			monitor.subTask(subTaskName);
			monitor.worked(worked);
		}
	}

	@Override public void processUnitTree(UnitTreeNode unitTree) throws Exception {
		notifySubTask("Parsing Rose Model", 1);
		super.processUnitTree(unitTree);
	}

	public void putRef(EReference ref, String quid) {
		refTable.put(ref, quid);	
	}

	public void putType(EObject eObject, String name) {
		typeTable.put(eObject, name);	
	}
}
