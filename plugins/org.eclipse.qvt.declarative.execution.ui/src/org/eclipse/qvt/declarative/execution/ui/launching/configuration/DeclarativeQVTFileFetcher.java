/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: DeclarativeQVTFileFetcher.java,v 1.2 2008/10/09 17:20:59 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.ui.launching.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.qvt.declarative.editor.qvtrelation.ui.QVTrNature;

public class DeclarativeQVTFileFetcher {

	protected Set<IFile> qvtFiles = new HashSet<IFile>();
	
	public final static String QVT_RELATIONS_FILE_EXTENSION = "qvtr";
	
	public final static String QVT_CORE_FILE_EXTENSION = "qvtc";
	
	public DeclarativeQVTFileFetcher(IContainer scope) {
		List<IJavaProject> javaProjects = new ArrayList<IJavaProject>();
		if (scope instanceof IWorkspaceRoot) {
			IWorkspaceRoot workspaceRoot = (IWorkspaceRoot) scope;
			for (IProject project : workspaceRoot.getProjects()) {
				try {
					if(project.isOpen() && project.hasNature(QVTrNature.class.getName())){
						javaProjects.add(JavaCore.create(project));
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (scope instanceof IProject) {
			IProject project = (IProject)scope;
			javaProjects.add(JavaCore.create(project));
		}
		collect(javaProjects);
	}
	
	private void collect(List<IJavaProject> javaProjects) {
		for (IJavaProject javaProject : javaProjects) {
			try {
				IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
				for (IClasspathEntry classpathEntry : classpathEntries) {
					if(classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						visit(classpathEntry.getPath());
					}
				}
			} catch (JavaModelException e) {
			}
		}
	}
	
	private void visit(IPath path) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			String fileExtension = file.getFileExtension();
			if (fileExtension.equals(QVT_CORE_FILE_EXTENSION) || fileExtension.equals(QVT_RELATIONS_FILE_EXTENSION)) {
				qvtFiles.add(file);
			}
		}
		if (resource instanceof IContainer) {
			IContainer container = (IContainer) resource;
			try {
				IResource[] resources = container.members();
				for (IResource member : resources){
					visit(member.getFullPath());
				}
			} catch (CoreException e) {
				System.out.println(e);
			}
		}
	}
	
	public Set<IFile> getQVTfiles() {
		System.out.println("qvtfiles = "+qvtFiles);
		return qvtFiles;
	}
}
