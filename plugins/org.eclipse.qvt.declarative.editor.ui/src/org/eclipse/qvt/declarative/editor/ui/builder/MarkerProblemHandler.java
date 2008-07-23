/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;

public abstract class MarkerProblemHandler<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> extends AbstractProblemHandler
{
	public static final String BUILDER_ID = "builderId";
	public static Map<ProblemHandler.Severity, Integer> severityMap = new HashMap<ProblemHandler.Severity, Integer>();
	
	static {
		severityMap.put(ProblemHandler.Severity.ERROR, Integer.valueOf(IMarker.SEVERITY_ERROR));
		severityMap.put(ProblemHandler.Severity.FATAL, Integer.valueOf(IMarker.SEVERITY_ERROR));
		severityMap.put(ProblemHandler.Severity.INFO, Integer.valueOf(IMarker.SEVERITY_INFO));
		severityMap.put(ProblemHandler.Severity.WARNING, Integer.valueOf(IMarker.SEVERITY_WARNING));
	}

	protected final ICreationFactory creationFactory;
	protected final IResource resource;
	protected String page = null;
	protected Map<Integer, List<Map<String, Object>>> entries = null;		// Map of line number to list of markers attributes for line

	public MarkerProblemHandler(ICreationFactory creationFactory, IResource resource) {
		super(null);
		this.creationFactory = creationFactory;
		this.resource = resource;
	}

	public void addMarker(int severity, String message, int lineNumber, int charStart, int charEnd) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(IMarker.MESSAGE, message);
		attributes.put(IMarker.SEVERITY, Integer.valueOf(severity));
		if (lineNumber == -1) {
			lineNumber = 1;
		}
		Integer lineKey = Integer.valueOf(lineNumber);
		attributes.put(IMarker.LINE_NUMBER, lineKey);
		if (charStart <= charEnd) {
			attributes.put(IMarker.CHAR_START, Integer.valueOf(charStart));
			attributes.put(IMarker.CHAR_END, Integer.valueOf(charEnd));
		}
		attributes.put(BUILDER_ID, creationFactory.getBuilderId());
		if (entries == null)
			entries = new HashMap<Integer, List<Map<String, Object>>>();
		List<Map<String, Object>> lineEntries = entries.get(lineKey);
		if (lineEntries == null) {
			lineEntries = new ArrayList<Map<String, Object>>();
			entries.put(lineKey, lineEntries);
		}
		lineEntries.add(attributes);
	}
	
	@Override public void flush(Monitor monitor) {
		//	Re-use existing markers wherever possible
		//	a) since many rebuilds generate the same errors
		//	b) to avoid a marker being deleted by a refreshMarkers on editor entry before
		//		gotoMarker is invoked to go to a pre-existing context.
		if (resource.exists()) {
			IWorkspaceRunnable action = new IWorkspaceRunnable()
			{
				public void run(IProgressMonitor monitor) throws CoreException {
					String markerId = creationFactory.getProblemMarkerId();
					if (entries != null) {
						IMarker[] oldMarkers = resource.findMarkers(markerId, false, IResource.DEPTH_ZERO);
						for (IMarker oldMarker : oldMarkers) {
							Map<?, ?> oldAttributes = oldMarker.getAttributes();
							List<Map<String, Object>> lineEntries = entries.get(oldAttributes.get(IMarker.LINE_NUMBER));
							if (lineEntries != null) {
								for (Map<String, Object> newAttributes : lineEntries) {
									if (isSameMarker(oldAttributes, newAttributes)) {
										lineEntries.remove(newAttributes);
										oldMarker = null;
										break;
									}							
								}
							}
							if (oldMarker != null)
								oldMarker.delete();
						}
						for (List<Map<String, Object>> lineEntries : entries.values()) {
							for (Map<String, Object> entry : lineEntries) {
								IMarker marker = resource.createMarker(markerId);
								marker.setAttributes(entry);
							}
						}
					}
					else
						resource.deleteMarkers(markerId, false, IResource.DEPTH_ZERO);
				}
			};
			try {
				IProgressMonitor progressMonitor = monitor != null ? BasicMonitor.toIProgressMonitor(monitor) : new NullProgressMonitor();
				resource.getWorkspace().run(action, resource, IWorkspace.AVOID_UPDATE, progressMonitor);
			} catch (CoreException e) {
				QVTEditorPlugin.logError("Failed to update resource markers", e);
			}
		}
	}

	@Override public void handleProblem(ProblemHandler.Severity problemSeverity, ProblemHandler.Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		int line = -1;
		if (startOffset >= 0) {
			int leftToken = Math.abs(getParser().getTokenIndexAtCharacter(startOffset));	// abs to move non-token to predecessor
			if (leftToken >= 0)
				line = getParser().getLine(leftToken);
		}
		Integer severity = severityMap.get(problemSeverity);
		addMarker(severity != null ? severity.intValue() : IMarker.SEVERITY_ERROR,
				processingPhase + ": " + problemMessage, line, startOffset, endOffset+1);
	}		

	/**
	 * Return true if newAttributes and oldAttributes provide the same marker description.
	 */
	public boolean isSameMarker(Map<?, ?> oldAttributes, Map<String, Object> newAttributes) {
		Set<?> oldKeys = oldAttributes.keySet();
		Set<String> newKeys = newAttributes.keySet();
		if (oldKeys.size() != newKeys.size())
			return false;
		for (String key : newKeys) {
			if (!oldAttributes.containsKey(key))
				return false;
			Object oldValue = oldAttributes.get(key);
			Object newValue = newAttributes.get(key);
			if (oldValue == newValue)
				continue;
			if (oldValue == null)
				return false;
			if (newValue == null)
				return false;
			if (!oldValue.equals(newValue))
				return false;
		}
		return true;
	}			
	
	public void setPage(String page) {
		this.page = page;
	}
}