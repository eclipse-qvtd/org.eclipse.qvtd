/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class InitializeDiagramHandler extends AbstractHandler
{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			String reason = "A selection directly or indirectly associated with a model resource is required.";
			String message = "Nothing selected.";
			InitializeDiagramUtils.openError(activeShell, message, reason);
			return null;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection)currentSelection;
		Set<@NonNull EObject> selectedEObjects = new HashSet<>();
		ResourceSet resourceSet = null;
		for (Object selection : structuredSelection) {
			if (selection instanceof IFile) {
				String fullPath = ((IFile)selection).getFullPath().toString();
				URI modelURI = URI.createPlatformResourceURI(fullPath, true);
				if (resourceSet == null) {
					resourceSet = new ResourceSetImpl();
					Map<String, Object> extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
				//	extensionToFactoryMap.putAll(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
					extensionToFactoryMap.put("xml", new GenericXMLResourceFactoryImpl()); // e.g. for plugin.xml
				//	extensionToFactoryMap.put("*", new XMLResourceFactoryImpl());
				}
				Resource modelResource = resourceSet.getResource(modelURI, true);
				selectedEObjects.addAll(modelResource.getContents());
			}
			else if (selection instanceof EObject) {
				selectedEObjects.add((EObject)selection);
			}
			else if (selection instanceof Resource) {
				Resource modelResource = (Resource)selection;
				selectedEObjects.addAll(modelResource.getContents());
			}
			else {
				String reason = "A selection directly or indirectly associated with a model resource is required.";
				String message = "Unsuitable selection: " + selection.getClass().getName() + ".";
				InitializeDiagramUtils.openError(activeShell, message, reason);
				return null;
			}
		}

		InitializeDiagramDialog initializeDiagramDialog = new InitializeDiagramDialog(activeShell, selectedEObjects);
	//	assert initializeDiagramDialog.getShell() != null;
		int status = initializeDiagramDialog.open();
		if ((status == Status.OK) && (initializeDiagramDialog.getShell() == null)) {		// !null for forced Eclipse exit
			// Convert selection-space elements to URIs for reloading in the Sirius-space.
			List<@NonNull URI> selectedElements = initializeDiagramDialog.getSelectedCheckedElements();
			URI masterSessionURI = initializeDiagramDialog.getMasterSessionURI();
			String representationDiagramName = initializeDiagramDialog.getRepresentationDiagramName();
			URI slaveSessionURI = initializeDiagramDialog.getSlaveSessionURI();
			RepresentationDescription registryRepresentationDescription = initializeDiagramDialog.getRegistryRepresentationDescription();
			InitializeDiagramJob.scheduleNewWhenPossible(masterSessionURI, registryRepresentationDescription, slaveSessionURI, representationDiagramName, selectedElements);
		}
		return null;
	}
}
