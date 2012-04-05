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
package org.eclipse.qvt.declarative.parser.environment;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.utils.CSTFormattingHelper;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;

public abstract class CSTChildEnvironment<E extends ICSTNodeEnvironment, P extends ICSTNodeEnvironment, AST extends Notifier, CST extends CSTNode> extends CSTNodeEnvironment<E, AST, CST>
{
	protected final ICSTRootEnvironment rootEnvironment;
	protected int errorStart = 0;
	protected int errorEnd = 0;
	
	protected CSTChildEnvironment(P parent, AST astNode, CST cstNode) {
		super(parent, astNode, cstNode);
		rootEnvironment = parent.getRootEnvironment();
		assert (rootEnvironment != null);
		initASTMapping(astNode, cstNode);
	}

	public boolean checkFeatureCompatibility(CSTNode cstNode, EClassifier featureType, OCLExpression oclExpression) {
		return rootEnvironment.checkFeatureCompatibility(cstNode, featureType, oclExpression);
	}

	@Override
	public CSTNode getASTMapping(Object object) {
		return rootEnvironment.getASTMapping(object);
	}

	@Override
	public Map<Object, CSTNode> getASTNodeToCSTNodeMap() {
		return rootEnvironment.getASTNodeToCSTNodeMap();
	}
	
	public ICSTFileEnvironment getFileEnvironment() {
		return rootEnvironment.getFileEnvironment();
	}

	@Override
	public CSTFormattingHelper getFormatter() {
		return rootEnvironment.getFormatter();
	}

	@SuppressWarnings("unchecked")
	public P getParentEnvironment() {
		return (P) getInternalParent();
	}

	@Override
	public AbstractParser getParser() {
		return rootEnvironment.getParser();
	}

	@Override
	public ProblemHandler getProblemHandler() {
		return rootEnvironment.getProblemHandler();
	}

	public AbstractModelResolver getResolver() {
		return rootEnvironment.getResolver();
	}
	
	public ICSTRootEnvironment getRootEnvironment() {
		return rootEnvironment;
	}

	@Override
	public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
		return rootEnvironment.getUMLReflection();
	}

	public UnresolvedEnvironment getUnresolvedEnvironment() {
		return rootEnvironment.getUnresolvedEnvironment();
	}

	@Override
	public void initASTMapping(Object astNode, CSTNode cstNode) {
		rootEnvironment.initASTMapping(astNode, cstNode);
	}

	@Override
	public void initASTMapping(Object fromAstNode, CSTNode cstNode, Object toAstNode) {
		rootEnvironment.initASTMapping(fromAstNode, cstNode, toAstNode);
	}

	public boolean isResolved(EObject eObject) {
		return rootEnvironment.isResolved(eObject);
	}

	@Override @Deprecated
	public final EClassifier lookupAssociationClassReference(EClassifier owner, String name) {
		try {
			return tryLookupAssociationClassReference(owner, name);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupAssociationClassReference cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EClassifier lookupClassifier(List<String> names) {
		try {
			return tryLookupClassifier(names);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupClassifier cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	}

	protected EClassifier lookupOCLAssociationClassReference(EClassifier owner, String name) {
		return super.lookupAssociationClassReference(owner, name);
	}

	protected EClassifier lookupOCLClassifier(List<String> names) {
		return super.lookupClassifier(names);
	}

	/**
	 * Return the implicit source for an operation by performing the inherited OCL lookup.
	 */
	protected Variable lookupOCLImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
		return (Variable) super.lookupImplicitSourceForOperation(name, params);
	}

	/**
	 * Return the implicit source for a property by performing the inherited OCL lookup.
	 */
	protected Variable lookupOCLImplicitSourceForProperty(String name) {
		return (Variable) super.lookupImplicitSourceForProperty(name);
	}

	protected EOperation lookupOCLOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		return super.lookupOperation(owner, name, args);
	}

	protected EPackage lookupOCLPackage(List<String> path) {
		return super.lookupPackage(path);
	}

	protected EStructuralFeature lookupOCLProperty(EClassifier owner, String name) {
		return super.lookupProperty(owner, name);
	}

	protected EClassifier lookupOCLSignal(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		return super.lookupSignal(owner, name, args);
	}

	@Override @Deprecated
	public final EOperation lookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		try {
			return tryLookupOperation(owner, name, args);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupOperation cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EOperation)
					return (EOperation) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EPackage lookupPackage(List<String> path) {
		try {
			return tryLookupPackage(path);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupPackage cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EPackage)
					return (EPackage) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EStructuralFeature lookupProperty(EClassifier owner, String name) {
		try {
			return tryLookupProperty(owner, name);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupProperty cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EStructuralFeature)
					return (EStructuralFeature) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EClassifier lookupSignal(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		try {
			return tryLookupSignal(owner, name, args);
		} catch (LookupException e) {
			QVTParserPlugin.logError("Deprecated lookupSignal cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	}

	@Override protected void removedVariable(String name, org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable, boolean isExplicit) {
	}

	@Override
	public EClassifier tryLookupAssociationClassReference(EClassifier owner,
			String name) throws LookupException {
		EClassifier result = super.lookupAssociationClassReference(owner, name);
		if (result != null)
			return result;
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupAssociationClassReference(owner, name);
		return null;
	}

	@Override
	public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EClassifier result = super.lookupClassifier(names);
		if (result != null)
			return result;
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupClassifier(names);
		return null;
	}

	@Override
	public EOperation tryLookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) throws LookupException {
		EOperation result = super.lookupOperation(owner, name, args);
		if (result != null)
			return result;
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupOperation(owner, name, args);
		return null;
	}

	@Override
	public EPackage tryLookupPackage(List<String> names) throws LookupException {
		EPackage result = super.lookupPackage(names);
		if (result != null)
			return result;
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupPackage(names);
		return null;
	}

	@Override
	public EStructuralFeature tryLookupProperty(EClassifier owner, String name)
			throws LookupException {
		if (name == null)
			return null;
		EStructuralFeature result = super.lookupProperty(owner, name);
		if (result != null)
			return result;

        
        // looks up non-navigable named ends as well as unnamed ends.  Hence
        // the possibility of ambiguity
//        result = lookupNonNavigableEnd(owner, name);
        
//        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
//            result = lookupNonNavigableEnd(owner, AbstractOCLAnalyzer.unescape(name));
//        }
		
		
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupProperty(owner, name);
		return null;
	}

	@Override
	public EClassifier tryLookupSignal(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) throws LookupException {
		EClassifier result = super.lookupSignal(owner, name, args);
		if (result != null)
			return result;
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupSignal(owner, name, args);
		return null;
	}

	public void validateASTMappings(List<EPackage> ePackages) {
		for (EPackage ePackage : ePackages) {
			for (TreeIterator<EObject> i = ePackage.eAllContents(); i.hasNext(); ) {
				EObject eObject = i.next();
				if (getASTMapping(eObject) != null)
					;
				else if (eObject instanceof EGenericType)
					;
				else if (eObject instanceof CollectionType)
					;
				else if (eObject instanceof TypeType)
					;
				else if (eObject instanceof InvalidLiteralExp)	// FIXME Workaround bug 237126
					;
				else
					System.out.println(formatName(eObject.eClass()) + " : " + formatQualifiedName(eObject) + " has no mapping to a CST node");
			}
		}
	}
}
