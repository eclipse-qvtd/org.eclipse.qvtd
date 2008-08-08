/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.utils;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * CommonCSTVisitor defines a default visitor to a Notifier-based
 * (EObject or Resource or ResourceSet) AST using EObject.eContents(),
 * Resource.getContents(), REsourceSet.getResources() to perform tree descent.
 */
public abstract class CommonASTVisitor<T> implements ICommonASTVisitor<T>
{
	public static <T, V extends CommonASTVisitor<T>> T acceptAt(V v, Notifier astNode) {
		return astNode != null ? v.visit(astNode) : null;
	}

	protected T result = null;

	public boolean preVisit(Notifier astNode) {
		return true;
	}

	public T postVisit(Notifier astNode) {
		return result;
	}

	public T visit(Notifier astNode) {
		if (!preVisit(astNode))
			return null;
		if (astNode instanceof EObject)
			visitEObject((EObject)astNode);
		else if (astNode instanceof Resource)
			visitResource((Resource)astNode);
		else if (astNode instanceof ResourceSet)
			visitResourceSet((ResourceSet)astNode);
		else
			visitNotifier(astNode);
		return postVisit(astNode);		
	}

	protected void visitEObject(EObject astNode) {
		for (EObject eObject : astNode.eContents())
			visit(eObject);
	}

	protected void visitNotifier(Notifier astNode) {
		System.out.println(getClass().getSimpleName() + ".unimplementedVisitor: " + astNode.getClass().getName());
	}

	protected void visitResource(Resource astNode) {
		for (EObject eObject : astNode.getContents())
			visit(eObject);
	}

	protected void visitResourceSet(ResourceSet astNode) {
		for (Resource resource : astNode.getResources())
			visit(resource);
	}
}