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
 * $Id: CommonTreeModelBuilder.java,v 1.1 2008/08/09 17:49:00 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.editor.OutlineBehavior;
import org.eclipse.qvt.declarative.parser.utils.ASTandCST;
import org.eclipse.qvt.declarative.parser.utils.CommonASTVisitor;
import org.eclipse.qvt.declarative.parser.utils.CommonCSTVisitor;

public abstract class CommonTreeModelBuilder extends TreeModelBuilderBase
{
	protected class CommonASTModelVisitor extends CommonASTVisitor<Object>
	{
		protected final CommonEditorDefinition editorDefinition;
		
		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition) {
			this.editorDefinition = editorDefinition;
		}
		
		@Override
		public Object postVisit(Notifier astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, OutlineBehavior.class);
			if (behavior != null) {
				if (behavior.isContainer())
					popSubItem();
			}
			return super.postVisit(astNode);
		}

		@Override
		public boolean preVisit(Notifier astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, OutlineBehavior.class);
			if (behavior != null) {
				boolean terminal = behavior.isTerminal();
				if (behavior.isContainer() && !terminal)
					pushSubItem(astNode);
				else
					createSubItem(astNode);
				if (terminal)
					return false;
			}
			return true;
		}
	}

	protected class CommonCSTModelVisitor extends CommonCSTVisitor<Object>
	{
		protected final CommonEditorDefinition editorDefinition;
		
		public CommonCSTModelVisitor(CommonEditorDefinition editorDefinition) {
			this.editorDefinition = editorDefinition;
		}
		
		@Override
		public Object postVisit(CSTNode cstNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(cstNode, OutlineBehavior.class);
			if (behavior != null) {
				if (behavior.isContainer())
					popSubItem();
			}
			return super.postVisit(cstNode);
		}

		@Override
		public boolean preVisit(CSTNode cstNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(cstNode, OutlineBehavior.class);
			if (behavior != null) {
				boolean terminal = behavior.isTerminal();
				if (behavior.isContainer() && !terminal)
					pushSubItem(cstNode);
				else
					createSubItem(cstNode);
				if (terminal)
					return false;
			}
			return true;
		}
	}

	protected CommonASTModelVisitor createASTVisitor(
			CommonEditorDefinition editorDefinition) {
		return new CommonASTModelVisitor(editorDefinition);
	}

	protected CommonCSTModelVisitor createCSTVisitor(
			CommonEditorDefinition editorDefinition) {
		return new CommonCSTModelVisitor(editorDefinition);
	}

	protected abstract ICommonPlugin getPlugin();

	@Override
	public void visitTree(Object root) {
		if (root instanceof ASTandCST)
			root = ((ASTandCST) root).resolve();
		CommonEditorDefinition editorDefinition = getPlugin().getEditorDefinition();
		if (root instanceof CSTNode)
			CommonCSTModelVisitor.acceptAt(createCSTVisitor(editorDefinition), ((CSTNode)root));
		else if (root instanceof Notifier)
			CommonASTModelVisitor.acceptAt(createASTVisitor(editorDefinition), ((Notifier)root));
	}
}
