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
 * $Id: CommonTreeModelBuilder.java,v 1.2 2008/08/24 19:06:07 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.qvt.declarative.editor.AbstractOutlineElement;
import org.eclipse.qvt.declarative.editor.EditorPackage;
import org.eclipse.qvt.declarative.editor.OutlineBehavior;
import org.eclipse.qvt.declarative.editor.OutlineElement;
import org.eclipse.qvt.declarative.editor.OutlineGroup;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;
import org.eclipse.qvt.declarative.parser.utils.CommonASTVisitor;

public class CommonTreeModelBuilder extends TreeModelBuilderBase
{
	protected class CommonASTModelVisitor<N> extends CommonASTVisitor<Object, N>
	{
		protected final CommonEditorDefinition editorDefinition;
		
		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition, Class<N> nodeClass) {
			super(nodeClass);
			this.editorDefinition = editorDefinition;
		}

		protected void enterElement(N astNode, AbstractOutlineElement element) {
			if (element instanceof OutlineElement)
				enterOutlineElement(astNode, ((OutlineElement) element));
			else if (element instanceof OutlineGroup)
				enterOutlineGroup(astNode, ((OutlineGroup) element));
			else
				unexpectedEnterOutline(astNode, element);
		}

		protected void enterOutlineElement(N astNode, OutlineElement element) {
			if (astNode instanceof EObject)
				enter(((EObject)astNode).eGet(element.getFeature(), false));
			else
				unexpectedEnterOutline(astNode, element);
		}

		protected void enterOutlineGroup(N astNode, OutlineGroup group) {
			for (AbstractOutlineElement element : group.getElements())
				enterElement(astNode, element);
		}
		
		@Override
		public Object postVisit(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, OutlineBehavior.class);
			if (behavior != null)
				popSubItem();
			return super.postVisit(astNode);
		}

		@Override
		public boolean preVisit(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, OutlineBehavior.class);
			if (behavior != null) {
				boolean terminal = behavior.eIsSet(EditorPackage.Literals.OUTLINE_BEHAVIOR__ELEMENTS)
					&& behavior.getElements().isEmpty();
				if (!terminal)
					pushSubItem(astNode);
				else
					createSubItem(astNode);
				if (terminal)
					return false;
			}
			return true;
		}
		
		protected void unexpectedEnterOutline(N astNode, AbstractOutlineElement element) {
			QVTEditorPlugin.logError("Unexpected enter outline for a '" + element.getClass().getName() + "' at a '" + astNode.getClass().getSimpleName() + "' by a '" + getClass().getSimpleName() + "'", null);
		}

		@Override
		public void visitEObject(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, OutlineBehavior.class);
			if ((behavior != null) && behavior.eIsSet(EditorPackage.Literals.OUTLINE_BEHAVIOR__ELEMENTS)) {
				for (AbstractOutlineElement element : behavior.getElements())
					enterElement(astNode, element);
				return;
			}
			super.visitEObject(astNode);
		}
	}

	protected final ICreationFactory creationFactory;
	protected final boolean showAST;
	protected final Map<Object, ModelTreeNode> itemMap = new HashMap<Object, ModelTreeNode>();
	
	public CommonTreeModelBuilder(ICreationFactory creationFactory, boolean showAST) {
		this.creationFactory = creationFactory;
		this.showAST = showAST;
	}

	protected CommonASTModelVisitor<Notifier> createASTVisitor(CommonEditorDefinition editorDefinition) {
		return new CommonASTModelVisitor<Notifier>(editorDefinition, Notifier.class);
	}

	@Override
	protected ModelTreeNode createSubItem(Object n, int category) {
		ModelTreeNode item = super.createSubItem(n, category);
		itemMap.put(n, item);
		return item;
	}

	@Override
	protected ModelTreeNode createTopItem(Object n, int category) {
		ModelTreeNode item = super.createTopItem(n, category);
		itemMap.clear();
		itemMap.put(n, item);
		return item;
	}

	public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	public ModelTreeNode getItem(Object n) {
		return itemMap.get(n);
	}
	
	public ICommonPlugin getPlugin() {
		return creationFactory.getPlugin();
	}

	@Override
	public void visitTree(Object root) {
		if (root instanceof ASTandCST)
			root = showAST ? ((ASTandCST) root).getAST() : ((ASTandCST) root).getCST();
		CommonEditorDefinition editorDefinition = getPlugin().getEditorDefinition();
		createASTVisitor(editorDefinition).enter(root);
	}
}
