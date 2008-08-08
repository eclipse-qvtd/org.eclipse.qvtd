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
 * $Id: CommonEditorDefinition.java,v 1.1 2008/08/08 16:42:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.qvt.declarative.editor.EditorPackage;
import org.eclipse.qvt.declarative.editor.JavaNode;
import org.eclipse.qvt.declarative.editor.Node;

/**
 * CommonEditorDefinition, typically instantiated as a stic in an
 * editing plugin, provides facilities to use the model-defined editor
 * definition provided by URL as its construction argument.
 */
public class CommonEditorDefinition
{
	protected final URL editorURL;
    protected EditorDefinition editorDefinition = null;
	private Map<EClassifier, EcoreNode> ecoreMap = null;
	private Map<Class<?>, JavaNode> javaMap = null;

    public CommonEditorDefinition(URL editorURL) {
    	this.editorURL = editorURL;
		EditorPackage.eINSTANCE.getClass();
    }

	public EditorDefinition getEditorDefinition() {
		if (editorDefinition == null) {
			try {
				URL resolvedURL = FileLocator.resolve(editorURL);
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("editor", new XMIResourceFactoryImpl());
				Resource resource = resourceSet.createResource(URI.createURI(resolvedURL.toString()));
				resource.load(resolvedURL.openStream(), null);
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
			}
		}
		return editorDefinition;
	}

	public Node getNode(Object object) {
		if (object == null)
			return null;
		if (editorDefinition == null)
			getEditorDefinition();
		if (object instanceof EObject) {
			EClassifier eClassifier = ((EObject)object).eClass();
			EcoreNode ecoreNode = ecoreMap != null ? ecoreMap.get(eClassifier) : null;
			if (ecoreNode == null) {
				// FIXME inheritance search
			}
			return ecoreNode;
		}
		Class<?> oClass = object.getClass();
		JavaNode javaNode = javaMap != null ? javaMap.get(oClass) : null;
		if (javaNode == null) {
			// FIXME inheritance search
		}
		return javaNode;
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
}
