/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonEditorDefinition.java,v 1.4 2008/08/11 08:01:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.qvt.declarative.editor.Behavior;
import org.eclipse.qvt.declarative.editor.EcoreNode;
import org.eclipse.qvt.declarative.editor.EditorDefinition;
import org.eclipse.qvt.declarative.editor.EditorFactory;
import org.eclipse.qvt.declarative.editor.EditorPackage;
import org.eclipse.qvt.declarative.editor.JavaNode;
import org.eclipse.qvt.declarative.editor.Node;

/**
 * CommonEditorDefinition, typically instantiated in an
 * editing plugin, provides facilities to use the model-defined editor
 * definition provided by URL as its construction argument.
 */
public class CommonEditorDefinition implements IResourceChangeListener, IResourceDeltaVisitor
{
	public static CommonEditorDefinition create(ICommonPlugin plugin, String editorFile) {
		CommonEditorDefinition editorDefinition = null;
		Path path = new Path(editorFile);
		URL url = FileLocator.find(plugin.getBundle(), path, null);
		try {
			URL resolvedURL = FileLocator.resolve(url);
			editorDefinition = new CommonEditorDefinition(resolvedURL);			
		} catch (IOException e) {
			plugin.logException("Failed to load '" + String.valueOf(path) + "'", e);
		} finally {
			if (editorDefinition == null)
				editorDefinition = new CommonEditorDefinition(null);			
		}
		return editorDefinition;
	}

	protected final URL editorURL;
    protected EditorDefinition editorDefinition = null;
	private Map<EClassifier, EcoreNode> ecoreMap = null;
	private Map<Class<?>, JavaNode> javaMap = null;

    public CommonEditorDefinition(URL editorURL) {
    	this.editorURL = editorURL;
		EditorPackage.eINSTANCE.getClass();
		if (editorURL != null)
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    public void dispose() {
    	if (editorURL != null)
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    }
    
	protected EcoreNode findEcoreClass(EClass aClass) {
		EcoreNode ecoreNode = ecoreMap.get(aClass);
		if (ecoreNode != null)
			return ecoreNode; 
		for (EClass cClass : aClass.getESuperTypes()) {
			ecoreNode = findEcoreClass(cClass);
			if (ecoreNode != null)
				return ecoreNode; 
		}
		return null;
	}

	protected JavaNode findJavaClass(Class<?> aClass) {
		JavaNode javaNode = javaMap.get(aClass);
		if (javaNode != null)
			return javaNode; 
		Class<?> bClass = aClass.getSuperclass();
		if (bClass != null) {
			javaNode = findJavaClass(bClass);
			if (javaNode != null)
				return javaNode; 
		}
		for (Class<?> cClass : aClass.getInterfaces()) {
			javaNode = findJavaClass(cClass);
			if (javaNode != null)
				return javaNode; 
		}
		return null;
	}

	public <T extends Behavior> T getBehavior(Object object, Class<T> behaviorClass) {
		for (Node node = getNode(object); node != null; node = node.getBase()) {
			for (Behavior behavior : node.getBehavior()) {
				if (behaviorClass.isAssignableFrom(behavior.getClass())) {
					@SuppressWarnings("unchecked")
					T castBehavior = (T) behavior;
					return castBehavior;
				}
			}
		}
		return null;
	}

	public EditorDefinition getEditorDefinition() {
		if ((editorDefinition == null) && (editorURL != null)) {
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("editor", new XMIResourceFactoryImpl());
				Resource resource = resourceSet.createResource(URI.createURI(editorURL.toString()));
				resource.load(editorURL.openStream(), null);
				editorDefinition = (EditorDefinition) resource.getContents().get(0);	// FIXME cast, multiplicity checks
				EcoreUtil.resolveAll(editorDefinition);
				for (Node node : editorDefinition.getNode()) {
					if (node instanceof EcoreNode) {
						if (ecoreMap == null)
							ecoreMap = new HashMap<EClassifier, EcoreNode>();
						ecoreMap.put(((EcoreNode)node).getElement(), (EcoreNode)node);
					}
					else if (node instanceof JavaNode) {
						if (javaMap == null)
							javaMap = new HashMap<Class<?>, JavaNode>();
						try {
							javaMap.put(Class.forName(((JavaNode)node).getName()), (JavaNode)node);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (editorDefinition == null)
					editorDefinition = EditorFactory.eINSTANCE.createEditorDefinition();			
			}
		}
		return editorDefinition;
	}

	public Node getNode(Object object) {
		if (object == null)
			return null;
		if (editorDefinition == null)
			getEditorDefinition();
		if (object instanceof EObject)
			return ecoreMap != null ? findEcoreClass(((EObject)object).eClass()) : null; 
		else
			return javaMap != null ? findJavaClass(object.getClass()) : null; 
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			IResourceDelta delta = event.getDelta();
			try {
				delta.accept(this);
			} catch (CoreException e) {
			}
		}
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (resource instanceof IFile) {
			int deltaKind = delta.getKind();
			if ((deltaKind == IResourceDelta.REMOVED)
			 || (deltaKind == IResourceDelta.CHANGED)
			 || (deltaKind == IResourceDelta.REPLACED)) {
				try {
					URL fileURL = resource.getLocationURI().toURL();
					if (fileURL.equals(editorURL)) {
						editorDefinition = null;
						return false;
					}
				} catch (MalformedURLException e) {
				}
			}
		}
		return true;
	}
}
