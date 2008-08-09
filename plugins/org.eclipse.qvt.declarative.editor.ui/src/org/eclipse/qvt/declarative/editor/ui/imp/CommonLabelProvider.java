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
 * $Id: CommonLabelProvider.java,v 1.2 2008/08/09 17:48:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.ILabelProvider;
import org.eclipse.imp.utils.MarkerUtils;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.qvt.declarative.editor.LabelBehavior;
import org.eclipse.qvt.declarative.editor.LabelElement;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * CommonLabelProvider provides the LabelProvider functionality for
 * an IMP editor, using the EditorDefinition model to configure behavior.
 */
public abstract class CommonLabelProvider implements ILabelProvider
{
	private Set<ILabelProviderListener> fListeners = new HashSet<ILabelProviderListener>();
	protected ExtendedImageRegistry imageRegistry = new ExtendedImageRegistry();
	private Image errorImageOverlay = null;
	private Image warningImageOverlay = null;

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
		if (!pathEClass.isSuperTypeOf(objectEClass))
			throw new IllegalArgumentException("Incompatible " + objectEClass.getName() + " for " + pathEClass.getName());
		return ((EObject)object).eGet(path);
	}

	public void dispose() {}

	/**
	 * Provide a formatted exception arising while identifying the object contributing to the index'th part of node's label.
	 */
	protected String formatException(Throwable e, Object node, int index) {
		return "<" + e.getClass().getSimpleName() + ">";
	}

	protected String formatExpression(OCLExpressionCS expr) {
		// FIXME Rest of the expressions
		return "<" + expr.getClass().getSimpleName() + ">";
	}

	/**
	 * Provide a formatted string for object contributing to the index'th part of node's label.
	 */
	protected String formatObject(Object object, Object node, int index) {
		String s = object != null ? object.toString() : null;
		return s != null ? s : "";
	}

	/**
	 * Provide a formatted string for object contributing to the index'th part of node's label.
	 */
	protected String formatObjects(Object[] object, Object node, int index) {
		String s = object != null ? object.toString() : null;
		return s != null ? s : "";
	}

	protected String formatType(TypeCS type) {
		if (type instanceof PrimitiveTypeCS) {
			return ((PrimitiveTypeCS)type).getValue();
		}
		// FIXME Rest of the types
		return "<" + type.getClass().getSimpleName() + ">";
	}

	protected Object getASTorCSTNode(Object element) {
		if (element instanceof ModelTreeNode)
			return ((ModelTreeNode) element).getASTNode();
		else if (element instanceof ASTandCST)
			return ((ASTandCST) element).resolve();
		else
			return element;
	}

	protected Image getErrorImageOverlay() {
		if (errorImageOverlay == null)
			errorImageOverlay = getImage(QVTEditorPlugin.getDefault().getBundle(), "icons/error_ovr.gif");
		return errorImageOverlay;
	}
	
	public Image getImage(Object element) {
		Object node = getASTorCSTNode(element);
		CommonEditorDefinition commonEditorDefinition = getPlugin().getEditorDefinition();
		LabelBehavior behavior = commonEditorDefinition.getBehavior(node, LabelBehavior.class);
		if (behavior == null)
			return null;
		Image image = getImage(getPlugin().getBundle(), behavior.getImage());
		if (image == null)
			return null;
		Collection<Image> overlays = getOverlayImages(node);
		if ((overlays == null) || overlays.isEmpty())
			return image;
		List<Object> images = new ArrayList<Object>(overlays.size()+1);
		images.add(image);
		images.addAll(overlays);
		return imageRegistry.getImage(new ComposedImage(images));
	}

	protected Image getImage(Bundle defaultBundle, String imagePath) {
		Bundle bundle = defaultBundle;
		String imageFile = imagePath;
		if (imagePath.startsWith("/")) {
			int index = imagePath.indexOf('/', 1);
			if (index > 1) {
				String bundlePath = imagePath.substring(1, index);
				bundle = Platform.getBundle(bundlePath);
				imageFile = imagePath.substring(index+1);
			}
		}
		Path path = new Path(imageFile);
		URL url = FileLocator.find(bundle, path, null);
		if (url == null)
			return null;
		Image image = imageRegistry.getImage(url);
		return image;
	}

	protected Collection<Image> getOverlayImages(Object node) {
		if (node instanceof IFile) {
			IFile file = (IFile) node;
			int sev = MarkerUtils.getMaxProblemMarkerSeverity(file, IResource.DEPTH_ONE);
			switch (sev) {
			case IMarker.SEVERITY_ERROR:
				return Collections.singletonList(getErrorImageOverlay());
			case IMarker.SEVERITY_WARNING:
				return Collections.singletonList(getWarningImageOverlay());
			}
		}
		return null;
	}

	protected Image getWarningImageOverlay() {
		if (warningImageOverlay == null)
			warningImageOverlay = getImage(QVTEditorPlugin.getDefault().getBundle(), "icons/warn_ovr.gif");
		return warningImageOverlay;
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
				objects[i] = formatObject(object, node, i);
			}
			catch (Throwable e) {
				objects[i] = formatException(e, node, i);
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
