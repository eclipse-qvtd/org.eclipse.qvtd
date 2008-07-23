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
package org.eclipse.qvt.declarative.importer.roseuml.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CancellationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporter;
import org.eclipse.qvt.declarative.importer.roseuml.RoseUMLImporterPlugin;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

/**
 * Action to load selected Ropse UML model and emit it as {per-package, all-packages, flattened
 * packages}, {EMOF, Ecore}, {minimal, maximal, exact} associations models.
 */
public class ConversionAction implements IObjectActionDelegate
{
	private IFile file;

	public ConversionAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IProgressService service = PlatformUI.getWorkbench().getProgressService(); 
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
	        public void run(IProgressMonitor monitor) {
	        	String title = "Convert Rose UML to Ecore and EMOF";
	        	SubMonitor subMonitor = SubMonitor.convert(monitor);
	        	subMonitor.beginTask(title, 10);
	        	subMonitor.subTask("Load Rose model");
	        	if (!nextTask(subMonitor, title + ": Load Model", 1))
	        		return;
	    		RoseUMLImporter roseImporter = new RoseUMLImporter();
//	    		roseImporter.setUseSemiOpposites(true);
	    		roseImporter.setModelFile(file);
	    		IPath location = file.getLocation();
	    		roseImporter.getPathMap().put("CURDIR", location.removeLastSegments(1).toString());;
	    		try {
	    			Diagnostic diagnostic = roseImporter.computeEPackages(BasicMonitor.toMonitor(subMonitor.newChild(4)));
	    			int severity = diagnostic.getSeverity();
	    			if (severity != Diagnostic.OK) {
						RoseUMLImporterPlugin.showError(Utils.formatDiagnostic(diagnostic, ""), null);
	    			}	    			
				} catch (CancellationException e) {
					if (!monitor.isCanceled())
						RoseUMLImporterPlugin.showError("Failed to compute Rose content", e);
					return;
				} catch (Exception e) {
					RoseUMLImporterPlugin.showError("Failed to compute Rose content", e);
					return;
				}
	    		List<EPackage> ePackages = roseImporter.getEPackages();
	     		PackageManager packageManager = new PackageManager(file);
	        	if (!nextTask(subMonitor, title + ": Emit models", 1))
	        		return;
	    		OneWayAssociations oneWayAssocs = new OneWayAssociations(ePackages);
	        	oneWayAssocs.minimise();
	        	packageManager.save(subMonitor, ePackages, "");
/*	        	if (!nextTask(subMonitor, title + ": Emit max models", 1))
	        		return;
	        	oneWayAssocs.maximise();
	        	packageManager.save(subMonitor, ePackages, ".max");
	        	if (!nextTask(subMonitor, title + ": Emit min models", 1))
	        		return;
	        	oneWayAssocs.minimise();
	        	packageManager.save(subMonitor, ePackages, ".min"); */
	        	if (!nextTask(subMonitor, title + ": Emit traditional models", 1))
	        		return;
	    		if (Utils.convertToTraditionalEMOF(ePackages)) {
		    		packageManager.setEcorePath("traditionalEcore");
		    		packageManager.setEMOFPath("traditionalEMOF");
		    		packageManager.save(subMonitor, ePackages, "");
	    		}
	    		subMonitor.worked(1);
	        }
	    };
		try {
			service.run(true, true, runnable);
		} catch (InvocationTargetException e) {
			RoseUMLImporterPlugin.showError("Failed to start Rose converter", e);
		} catch (InterruptedException e) {
		}
	}

	protected boolean nextTask(SubMonitor subMonitor, String taskName, int worked) {
		subMonitor.worked(worked);
    	if (subMonitor.isCanceled())
    		return false;
    	subMonitor.setTaskName(taskName);
    	return true;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		file = (IFile) ((IStructuredSelection)selection).getFirstElement();
	}
}
