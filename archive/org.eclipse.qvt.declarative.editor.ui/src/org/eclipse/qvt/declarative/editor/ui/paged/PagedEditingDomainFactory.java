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
package org.eclipse.qvt.declarative.editor.ui.paged;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;

/**
 * An editing domain factory registered on the extension point to create our
 * shared editing domain for QVT model editors.
 */
public class PagedEditingDomainFactory implements TransactionalEditingDomain.Factory {
	
	/**
	 * This is an implementation of a context that knows about this editing domain.
	 * It is used to help implement 
	 * {@link #getEditingDomainFor(java.lang.Object) getEditingDomainFor(Object)}
	 * and {@link #getEditingDomainFor(org.eclipse.emf.ecore.EObject) getEditingDomainFor(EObject)}
	 * An instance of this is created if needed in the constructor.
	 * 
	 */
	protected class AdaptingXMIEditingDomainResourceSet extends ResourceSetImpl implements IEditingDomainProvider
	{		// FIXME WIP Is this necessary at all now
			//  probably not; try WorkspaceEditingDomainFactory
			//   or AdapterFactoryEditingDomainResourceSet
			//    or perhaps a ResourceSet adapter
		private TransactionalEditingDomain editingDomain;

		public TransactionalEditingDomain getEditingDomain() {
	    	return editingDomain;
	    }

		public void setEditingDomain(TransactionalEditingDomain editingDomain) {	// FIXME Perhaps an adapter would be more flexible albeit a little slower
	    	this.editingDomain = editingDomain;
	    }
	}

	public TransactionalEditingDomain createEditingDomain() {
		// Ensure that we use a ResourceSet that loads EMOF resources and adapts them to Ecore
		return createEditingDomain(new AdaptingXMIEditingDomainResourceSet());
	}

	public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
		// create an editing domain with a default resource set implementation
		//    and delegating command execution to the default (workbench)
		//    operation history
		TransactionalEditingDomain result = WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain(rset);
		((AdaptingXMIEditingDomainResourceSet)rset).setEditingDomain(result);
		// add an exception handler to the editing domain's command stack
//		((TransactionalCommandStack) result.getCommandStack()).setExceptionHandler(
//FIXME				new CommandStackExceptionHandler());	
		return result;
	}

	public TransactionalEditingDomain getEditingDomain(ResourceSet rset) {
		return ((AdaptingXMIEditingDomainResourceSet)rset).getEditingDomain();
	}

}
