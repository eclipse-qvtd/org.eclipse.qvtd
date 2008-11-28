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
 * $Id: CommonTreeModelBuilder.java,v 1.3 2008/11/28 17:27:22 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.qvt.declarative.editor.AbstractOutlineElement;
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
		protected final Class<OutlineBehavior> outlineBehaviorClass;

		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition, Class<N> nodeClass) {
			this(editorDefinition, nodeClass, OutlineBehavior.class);
		}
		
		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition, Class<N> nodeClass, Class<OutlineBehavior> outlineBehaviorClass) {
			super(nodeClass);
			this.editorDefinition = editorDefinition;
			this.outlineBehaviorClass = outlineBehaviorClass;
		}

		@Override
		protected Object enterCollection(Collection<?> collection) {
			for (Object o : collection)
				enter(o);
			return null;
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
			if (astNode instanceof EObject) {
				EStructuralFeature feature = element.getFeature();
				Object selection = ((EObject)astNode).eGet(feature, false);
				enter(selection);
			} else
				unexpectedEnterOutline(astNode, element);
		}

		protected void enterOutlineGroup(N astNode, OutlineGroup group) {
			EList<AbstractOutlineElement> elements = group.getElements();
			if (!elements.isEmpty()) {					// Non-dummy group
				boolean isFlat = (group.getName() == null) && (group.getImage() == null);
				if (!isFlat)
					pushSubItem(group);
				else
					createSubItem(group);
				for (AbstractOutlineElement childElement : elements)
					enterElement(astNode, childElement);
				if (!isFlat)
					popSubItem();
			}
		}
		
		@Override
		public Object postVisit(N astNode) {
			popSubItem();
			return super.postVisit(astNode);
		}

		@Override
		public boolean preVisit(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, outlineBehaviorClass);
			boolean isTerminal = (behavior != null) && behavior.getElements().isEmpty();
			return preVisit(astNode, isTerminal);
		}

		protected boolean preVisit(N astNode, boolean isTerminal) {
			if (isTerminal) {
				createSubItem(astNode);
				return false;
			}
			else {				
				pushSubItem(astNode);
				return true;
			}
		}
		
		protected void unexpectedEnterOutline(N astNode, AbstractOutlineElement element) {
			QVTEditorPlugin.logError("Unexpected enter outline for a '" + element.getClass().getName() + "' at a '" + astNode.getClass().getSimpleName() + "' by a '" + getClass().getSimpleName() + "'", null);
		}

		@Override
		public void visitEObject(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, outlineBehaviorClass);
			if (behavior != null) {
				EList<AbstractOutlineElement> elements = behavior.getElements();
				if (!elements.isEmpty()) {					// Explicit outline
					for (AbstractOutlineElement element : elements)
						enterElement(astNode, element);
					return;
				}
			}
			super.visitEObject(astNode);					// Default containment outline
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
