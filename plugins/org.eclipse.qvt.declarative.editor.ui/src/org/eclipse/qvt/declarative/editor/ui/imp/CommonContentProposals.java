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
 * $Id: CommonContentProposals.java,v 1.9 2008/12/05 22:18:28 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lpg.lpgjavaruntime.ErrorToken;
import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.ecore.utils.TracingOption;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController.TokenKind;
import org.eclipse.qvt.declarative.parser.environment.IHasName;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.swt.graphics.Image;

public class CommonContentProposals
{
	public static TracingOption proposalDebug = new TracingOption(QVTEditorPlugin.PLUGIN_ID, "proposal/debug");

	protected final CommonParseController commonParseController;
	protected final int offset;
	protected final Map<Object, ICommonProposal> map;
	protected CommonParseController.ParsedResult parsedResult;
	protected CSTNode cstRoot;
	protected IToken tokenAtOffset;
	protected String prefixAtOffset;
	
	public CommonContentProposals(CommonParseController commonParseController, int offset) {
		this.commonParseController = commonParseController;
		this.offset = offset;
		this.map = new HashMap<Object, ICommonProposal>();
	}

	/**
	 * Accumulate the candidate if it represents a suitable proposal.
	 */
	protected void addIdentifierProposalCandidate(List<EStructuralFeature> usages, EObject candidate) {
		if (checkName(usages, candidate) && checkType(usages, candidate) && !map.containsKey(candidate)) {
			ILabelProvider labelProvider = commonParseController.getLabelProvider();
			String newText = EcoreUtils.formatName(candidate);
			String displayText = newText + " - " + EcoreUtils.formatQualifiedName(candidate.eContainer(), "::");
			Image image = labelProvider.getImage(candidate);
			String oldText = getTokenAtOffsetString();
			map.put(candidate, new CommonProposal(displayText, tokenAtOffset.getStartOffset(), newText, oldText, offset, image));
		}
	}

	protected void addIdentifierProposals(CSTNode cstNode) {
		Object astNode = cstNode.getAst();
		if ((astNode == null) && (cstNode instanceof IdentifierCS)) {
			astNode = ((CSTNode) cstNode.eContainer()).getAst();
			if ((astNode != null) && proposalDebug.isActive())
				proposalDebug.println("Missing astNode deduced for " + astNode.getClass().getSimpleName());
		}
		if (astNode == null) {
			map.put(null, new CommonNonProposal("Internal error: no AST node to select completion proposal for " + cstNode.getClass().getSimpleName(), "", offset));
			return;
		}
		if (proposalDebug.isActive())
			proposalDebug.println("Proposal for '" + prefixAtOffset + "' " + cstNode.getClass().getSimpleName() + " " + astNode.getClass().getSimpleName());
		if (astNode instanceof EObject) {
			List<EStructuralFeature> usages = computeUsage((EObject) astNode);
			for (Resource resource : getResources(usages, (EObject) astNode))
				for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext(); )
					addIdentifierProposalCandidate(usages, i.next());
		}
	}

	protected void addIdentifierKeywordProposals(CSTNode cstNode) {
		for (ICommonKeyword keyword : commonParseController.getKeywords()) {
			if (keyword.isIdentifier(cstNode)) {
				String keywordText = keyword.getText();
				if (offset < tokenAtOffset.getStartOffset())
					map.put(keyword, new CommonProposal(keywordText, offset, keywordText, "", offset, null));
				else if (keywordText.startsWith(prefixAtOffset))
					map.put(keyword, new CommonProposal(keywordText, tokenAtOffset.getStartOffset(), keywordText, getTokenAtOffsetString(), offset, null));
			}
		}
	}

	protected void addKeywordProposals() {
		for (ICommonKeyword keyword : commonParseController.getKeywords()) {
			String keywordText = keyword.getText();
			if (offset < tokenAtOffset.getStartOffset())
				map.put(keyword, new CommonProposal(keywordText, offset, keywordText, "", offset, null));
			else if (keywordText.startsWith(prefixAtOffset))
				map.put(keyword, new CommonProposal(keywordText, tokenAtOffset.getStartOffset(), keywordText, getTokenAtOffsetString(), offset, null));
		}
	}

	protected void addStringProposals() {
		Collection<Resource> resources = parsedResult.getFileEnvironment().getResourcesVisibleAt(null);
		for (Resource resource : resources)
			for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext(); )
				addStringProposalCandidate(i.next());
	}

	protected void addStringProposalCandidate(EObject candidate) {
		if (candidate instanceof StringLiteralExp) {
			String string = ((StringLiteralExp<?>)candidate).getStringSymbol();
			if (!map.containsKey(string) && string.startsWith(prefixAtOffset.length() > 0 ? prefixAtOffset.substring(1) : "")) {
				String newText = "'" + string + "'";
				String displayText = string;
//				ILabelProvider labelProvider = commonParseController.getLabelProvider();
				Image image = null; // FIXME labelProvider.getImage(string);
				map.put(string, new CommonProposal(displayText, tokenAtOffset.getStartOffset(), newText, getTokenAtOffsetString(), offset, image));
			}
		}
	}

	/**
	 * Return true if the name of eObject is suitable for the usages with prefixAtOffset.
	 */
	protected boolean checkName(List<EStructuralFeature> usages, EObject eObject) {
		String name = getName(eObject);
		if (name == null)
			return false;
		return name.startsWith(prefixAtOffset);
	}

	/**
	 * Return true if the type of eObject is suitable as the target of the usages.
	 */
	protected boolean checkType(List<EStructuralFeature> usages, EObject eObject) {
		if (usages.isEmpty())
			return false;
		for (EStructuralFeature requiredUsage : usages) {
			EClassifier requiredType = requiredUsage.getEType();
			Set<EClass> completableClasses = getCompletableTypes(requiredType);
			if (completableClasses == null)
				return false;
			EClass eClass = eObject.eClass();
			boolean completable = false;
			for (EClass completableClass : completableClasses) {
				if ((requiredType == completableClass) || completableClass.isSuperTypeOf(eClass)) {
					completable = true;
					break;
				}
			}
			if (!completable)
				return false;
		}
		return true;
	}

	public void computeProposals() {
		parsedResult = commonParseController.getCurrentAst();
		if (parsedResult == null) {
			if (proposalDebug.isActive())
				proposalDebug.println("No Parsed Result");
			map.put(null, new CommonNonProposal("no info available due to Internal error", "", offset));
			return;
		}
		cstRoot = parsedResult.getCST();
		if (cstRoot == null) {
			if (proposalDebug.isActive())
				proposalDebug.println("No CST");
			map.put(null, new CommonNonProposal("no info available due to Syntax error(s)", "", offset));
			return;
		}
		tokenAtOffset = getToken();
		prefixAtOffset = getPrefix();
		TokenKind tokenKind = commonParseController.getTokenKind(tokenAtOffset.getKind());
		switch (tokenKind) {
			case IDENTIFIER: {
				CommonNodeLocator locator = commonParseController.getCreationFactory().createNodeLocator(parsedResult.getRootEnvironment());
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				if (node == null) {
					if (proposalDebug.isActive())
						proposalDebug.println("No CST node");
					map.put(null, new CommonNonProposal("no info available due to Syntax error(s)", "", offset));
				}
				else {
					addIdentifierProposals(node);
					addIdentifierKeywordProposals(node);
					if (map.isEmpty())
						map.put(null, new CommonNonProposal("no completion exists for '" + prefixAtOffset + "' " + node.getClass().getSimpleName() + " " + node.getAst().getClass().getSimpleName(), "", offset));
				}
				break;
			}
			case ERROR: {
				CommonNodeLocator locator = commonParseController.getCreationFactory().createNodeLocator(parsedResult.getRootEnvironment());
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				addIdentifierProposals(node);
				addIdentifierKeywordProposals(node);
				addKeywordProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for keyword: " + prefixAtOffset, "", offset));
				break;
			}
			case KEYWORD: {
				CommonNodeLocator locator = commonParseController.getCreationFactory().createNodeLocator(parsedResult.getRootEnvironment());
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				if ((node instanceof IHasName) || (node instanceof SimpleNameCS)) {
					addIdentifierProposals(node);
					addIdentifierKeywordProposals(node);
				}
				else
					addKeywordProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for keyword: " + prefixAtOffset, "", offset));
				break;
			}
			case STRING: {
				addStringProposals();
				if (map.isEmpty())
					map.put(null, new CommonNonProposal("no completion exists for string: " + prefixAtOffset, "", offset));
				break;
			}
			default: {
				map.put(null, new CommonNonProposal("no completion exists for " + tokenKind + ": " + prefixAtOffset, "", offset));
			}
		}
	}

	/**
	 * Return the most EStructuralFeatures for which astNode is or could be the target.
	 */
	protected List<EStructuralFeature> computeUsage(EObject astNode) {
		List<EStructuralFeature> usages = new ArrayList<EStructuralFeature>();
		Object rootAst = cstRoot.getAst();
		Resource resource = rootAst instanceof Resource ? (Resource)rootAst : null;
		if (resource == null)
			resource = astNode.eResource();
		Collection<EStructuralFeature.Setting> settings = EcoreUtil.UsageCrossReferencer.find(astNode, resource);
		for (EStructuralFeature.Setting setting : settings) {
			EStructuralFeature structuralFeature = setting.getEStructuralFeature();
			if (!usages.contains(structuralFeature))
				usages.add(structuralFeature);
		}
		EStructuralFeature containingFeature = astNode.eContainingFeature();
		if ((containingFeature == null) && (astNode instanceof EPackage))			// Provide a plausible containment feature
			containingFeature = EcorePackage.Literals.EPACKAGE__ESUBPACKAGES;		//  for nodes at the root of the resource 
		if (containingFeature != null) {
			if (!usages.contains(containingFeature))
				usages.add(containingFeature);
		}
		return usages;
	}

	public Set<EClass> getCompletableTypes(EClassifier requiredType) {
		Set<EClass> completableClasses = new HashSet<EClass>();
		if (requiredType instanceof EClass)
			completableClasses.add((EClass)requiredType);
		return completableClasses;
	}

	protected String getName(EObject eObject) {
		if (eObject instanceof ENamedElement)
			return ((ENamedElement) eObject).getName();
		else if (eObject instanceof IHasName)
			return ((IHasName)eObject).getName(); 
		else
			return null;
	}

	protected String getPrefix() {
		if (commonParseController.isCompleteable(tokenAtOffset.getKind()))
			if ((tokenAtOffset.getStartOffset() <= offset) && (offset <= tokenAtOffset.getEndOffset() + 1))
				return getTokenAtOffsetString().substring(0, offset - tokenAtOffset.getStartOffset());
		return "";
	}

	/**
	 * Return the resources that may provide definitions to use in place of astNode
	 * as the target of requiredUsage.
	 */
	protected Collection<Resource> getResources(List<EStructuralFeature> usages, EObject astNode) {
		return parsedResult.getFileEnvironment().getResourcesVisibleAt(astNode);
	}
	
	protected IToken getToken() {
		AbstractParser stream = commonParseController.getParser();
		IToken errorToken = stream.getErrorTokenAtCharacter(offset);
		if (errorToken != null)
			return errorToken;
		int index = stream.getTokenIndexAtCharacter(offset);
		int tokenIndex = (index < 0 ? -(index - 1) : index);
		IToken token = stream.getIToken(tokenIndex);
		int previousIndex = stream.getPrevious(tokenIndex);
		IToken previousToken = stream.getIToken(previousIndex);
		int previousIndexKind = previousToken.getKind();
		boolean isIdentifier = commonParseController.isIdentifier(previousIndexKind);
		boolean isKeyword = commonParseController.isKeyword(previousIndexKind);
		boolean atEnd = offset == previousToken.getEndOffset() + 1;
		return ((isIdentifier || isKeyword) && atEnd) ? previousToken : token;
	}

	protected String getTokenAtOffsetString() {
		return tokenAtOffset instanceof ErrorToken ? "" : tokenAtOffset.toString();
	}

	/**
	 * Sort the computed proposals into the order in which they appear to the user.
	 */
	public ICompletionProposal[] sortProposals() {
		List<ICommonProposal> list = new ArrayList<ICommonProposal>(map.values());
		Collections.sort(list);
		return list.toArray(new ICommonProposal[list.size()]);
	}
}