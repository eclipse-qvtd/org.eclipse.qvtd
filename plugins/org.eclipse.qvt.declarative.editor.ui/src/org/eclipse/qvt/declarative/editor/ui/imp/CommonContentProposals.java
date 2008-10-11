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
 * $Id: CommonContentProposals.java,v 1.1 2008/10/11 15:38:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.PrsStream;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonParseController.TokenKind;
import org.eclipse.qvt.declarative.parser.environment.IHasName;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.swt.graphics.Image;

public class CommonContentProposals
{
	protected final CommonParseController commonParseController;
	protected final int offset;
	protected final Map<Notifier, CommonProposal> map;
	protected CommonParseController.ParsedResult parsedResult;
	protected CSTNode cstRoot;
	protected IToken tokenAtOffset;
	protected String prefixAtOffset;
	
	public CommonContentProposals(CommonParseController commonParseController, int offset) {
		this.commonParseController = commonParseController;
		this.offset = offset;
		this.map = new HashMap<Notifier, CommonProposal>();
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
			map.put(candidate, new CommonProposal(displayText, newText, prefixAtOffset, offset, image));
		}
	}

	protected void addIdentifierProposals(CSTNode node) {
		Object astNode = node.getAst();
		if ((astNode == null) && (node instanceof IdentifierCS)) {
			astNode = ((CSTNode) node.eContainer()).getAst();
			if (astNode != null)
				System.out.println("Missing astNode deduced for " + astNode.getClass().getSimpleName());
		}
		System.out.println("Proposal for '" + prefixAtOffset + "' " + node.getClass().getSimpleName() + " " + (astNode != null ? astNode.getClass().getSimpleName() : "???"));
		if (astNode instanceof EObject) {
			List<EStructuralFeature> usages = computeUsage((EObject) astNode);
			for (Resource resource : getResources(usages, (EObject) astNode))
				for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext(); )
					addIdentifierProposalCandidate(usages, i.next());
		}
		if (map.isEmpty())
			map.put(null, new CommonProposal("no completion exists for '" + prefixAtOffset + "' " + node.getClass().getSimpleName() + " " + (astNode != null ? astNode.getClass().getSimpleName() : "???"), "", offset));
	}

	protected void addKeywordProposals() {
		Image image = null;
		for (String keyword : commonParseController.getKeywords())
			if (keyword.startsWith(prefixAtOffset))
				map.put(null, new CommonProposal(keyword, keyword, prefixAtOffset, offset, image));						
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
			EClass requiredClass = requiredType instanceof EClass ? (EClass)requiredType : null;
			EClass eClass = eObject.eClass();
			boolean okType = (requiredType == eClass) || ((requiredClass != null) && requiredClass.isSuperTypeOf(eClass));
			if (!okType)
				return false;
		}
		return true;
	}

	public void computeProposals() {
		parsedResult = commonParseController.getCurrentAst();
		if (parsedResult == null) {
			System.out.println("No Parsed Result");
			map.put(null, new CommonProposal("no info available due to Internal error", "", offset));
			return;
		}
		cstRoot = parsedResult.getCST();
		if (cstRoot == null) {
			System.out.println("No CST");
			map.put(null, new CommonProposal("no info available due to Syntax error(s)", "", offset));
			return;
		}
		tokenAtOffset = getToken();
		prefixAtOffset = getPrefix();
		TokenKind tokenKind = commonParseController.getTokenKind(tokenAtOffset.getKind());
		switch (tokenKind) {
			case IDENTIFIER: {
				CommonNodeLocator locator = commonParseController.getCreationFactory().createNodeLocator(parsedResult.getFileEnvironment());
				CSTNode node = (CSTNode) locator.findNode(cstRoot, tokenAtOffset.getStartOffset(), tokenAtOffset.getEndOffset());
				if (node == null) {
					System.out.println("No CST node");
					map.put(null, new CommonProposal("no info available due to Syntax error(s)", "", offset));
				}
				else
					addIdentifierProposals(node);
				break;
			}
			case KEYWORD: {
				addKeywordProposals();
				if (map.isEmpty())
					map.put(null, new CommonProposal("no completion exists for keyword: " + prefixAtOffset, "", offset));
				break;
			}
			default: {
				map.put(null, new CommonProposal("no completion exists for " + tokenKind + ": " + prefixAtOffset, "", offset));
			}
		}
	}

	/**
	 * Return the most EStructuralFeatures for which astNode is the target.
	 */
	protected List<EStructuralFeature> computeUsage(EObject astNode) {
		List<EStructuralFeature> usages = new ArrayList<EStructuralFeature>();
		Object rootAst = cstRoot.getAst();
		Resource resource = rootAst instanceof Resource ? (Resource)rootAst : null;
		if (resource == null)
			resource = astNode.eResource();
		Collection<EStructuralFeature.Setting> settings = EcoreUtil.UsageCrossReferencer.find(astNode, resource);
		for (EStructuralFeature.Setting setting : settings)
			usages.add(setting.getEStructuralFeature());
		EStructuralFeature containingFeature = astNode.eContainingFeature();
		if (containingFeature != null)
			usages.add(containingFeature);
		return usages;
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
				return tokenAtOffset.toString().substring(0, offset - tokenAtOffset.getStartOffset());
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
		PrsStream stream = commonParseController.getParser();
		int index = stream.getTokenIndexAtCharacter(offset), token_index = (index < 0 ? -(index - 1)
				: index), previous_index = stream.getPrevious(token_index);
		int previousIndexKind = stream.getKind(previous_index);
		boolean isIdentifier = commonParseController.isIdentifier(previousIndexKind);
		boolean isKeyword = commonParseController.isKeyword(previousIndexKind);
		boolean atEnd = offset == stream.getEndOffset(previous_index) + 1;
		return stream.getIToken(((isIdentifier || isKeyword) && atEnd) ? previous_index : token_index);
	}

	/**
	 * Sort the computed proposals into the order in which they appear to the user.
	 */
	public ICompletionProposal[] sortProposals() {
		List<CommonProposal> list = new ArrayList<CommonProposal>(map.values());
		Collections.sort(list);
		return list.toArray(new ICommonProposal<?>[list.size()]);
	}
}