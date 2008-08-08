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
 * $Id: CommonLabelProvider.java,v 1.1 2008/08/08 16:42:46 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.net.URL;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.qvt.declarative.editor.LabelBehavior;
import org.eclipse.qvt.declarative.editor.LabelElement;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;
import org.eclipse.swt.graphics.Image;

/**
 * CommonLabelProvider provides the LabelProvider functionality for
 * an IMP editor, using the EditorDefinition model to configure behavior.
 */
public abstract class CommonLabelProvider implements ILabelProvider
{
	private Set<ILabelProviderListener> fListeners = new HashSet<ILabelProviderListener>();

	public void addListener(ILabelProviderListener listener) {
		fListeners.add(listener);
	}

	protected Object checkedGet(Object object, EStructuralFeature path) {
		if (path == null)
			throw new NullPointerException("Null path element");
		if (object == null)
			throw new NullPointerException("Null path object");
		if (!(object instanceof EObject))
			throw new ClassCastException("Non EObject");
		EClass objectEClass = ((EObject)object).eClass();
		EClass pathEClass = path.getEContainingClass();
		if (!(object instanceof EObject))
			throw new IllegalArgumentException("Incomaptible " + objectEClass.getName() + " for " + pathEClass.getName());
		return ((EObject)object).eGet(path);
	}

	public void dispose() {}

	protected Object getASTorCSTNode(Object element) {
		if (element instanceof ModelTreeNode)
			return ((ModelTreeNode) element).getASTNode();
		else if (element instanceof ASTandCST)
			return ((ASTandCST) element).resolve();
		else
			return element;
	}
	
	public Image getImage(Object element) {
		Object node = getASTorCSTNode(element);
		ICommonPlugin plugin = getPlugin();
		CommonEditorDefinition commonEditorDefinition = plugin.getEditorDefinition();
		LabelBehavior behavior = commonEditorDefinition.getBehavior(node, LabelBehavior.class);
		if (behavior != null) {
			String imageFile = behavior.getImage();
			ImageRegistry imageRegistry = plugin.getImageRegistry();
			Image image = imageRegistry.get(imageFile);
			if (image == null) {
				Path path = new Path(imageFile);
				URL url = FileLocator.find(plugin.getBundle(), path, null);
				if (url != null) {
					ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
					imageRegistry.put(imageFile, imageDescriptor);
					image = imageRegistry.get(imageFile);;
				}
			}
			if (image != null)
				return image;
		}
		return null;
	}

	protected abstract ICommonPlugin getPlugin();

	public String getText(Object element) {
		Object node = getASTorCSTNode(element);
		CommonEditorDefinition commonEditorDefinition = getPlugin().getEditorDefinition();
		LabelBehavior behavior = commonEditorDefinition.getBehavior(node, LabelBehavior.class);
		if (behavior == null)
			return null;
		if (!(node instanceof EObject))
			return null;
		String format = behavior.getFormat();
		EList<LabelElement> labelElements = behavior.getElements();
		int iMax = labelElements.size();
		Object[] objects = new Object[iMax];
		for (int i = 0; i < iMax; i++) {
			try {
				LabelElement labelElement = labelElements.get(i);
				Object object = node;
				for (EReference path : labelElement.getPath())
					object = checkedGet(object, path);
				if (object instanceof EObject)
					object = checkedGet(object, labelElement.getEnd());
				objects[i] = object;
			}
			catch (Throwable e) {
				objects[i] = "<" + e.getClass().getSimpleName() + ">";
			}
		}
	    return MessageFormat.format(format, objects);
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		fListeners.remove(listener);
	}
}
