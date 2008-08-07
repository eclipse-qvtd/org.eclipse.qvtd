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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;
import org.eclipse.qvt.declarative.parser.unresolved.UnresolvedPackage;

/**
 * CSTEnvironment revises the EcoreEnvironment behaviour to support operation in an
 * a shallow environment hierarchy, in which lookups are presumed to be resolved
 * locally and the results may be ambiguous.
 * <p>
 * lookupXXX methods are therefore deprecated in favour of tryLookupXXX methods
 * that support a LookupException to report ambiguous lookups.
 * <p>
 * Look-ups are performed first using the derived implementation assuming
 * that the derived application is OCL-like. A failed derived look-up
 * is then delegated to the parent environment.
 * <p>
 * This provides a default semantics that may often be useful. It is expected
 * that derived environments will re-implement whenever another semantics is needed.
 * Total re-implementation of semantics by a derived environment is supported by
 * the ability to use the lookupOCLXXX method to access the underyling OCL functionality.
 *
 * @param <E> The derived ICSTEnvironment from which all environments derive
 * @param <P> The derived E of the parent environment
 */
public abstract class CSTEnvironment<E extends ICSTEnvironment, P extends E> extends EcoreEnvironment implements ICSTEnvironment
{
	private final class WorkaroundDiagnostician extends Diagnostician {
		private final class WorkaroundOclValidator extends org.eclipse.ocl.ecore.util.EcoreValidator {
			public WorkaroundOclValidator(WorkaroundEmfValidator emfValidator) {
				ecoreValidator = emfValidator;
			}
		}

		private final class WorkaroundEmfValidator extends
				org.eclipse.emf.ecore.util.EcoreValidator {
			@Override
			public boolean validateEClassifier_WellFormedInstanceTypeName(EClassifier classifier, DiagnosticChain diagnostics, Map<Object, Object> context) {
				if (classifier instanceof TypeType)		// FIXME Workaround Bug 241426
					return true;
				return super.validateEClassifier_WellFormedInstanceTypeName(classifier, diagnostics, context);
			}
		}

		public WorkaroundDiagnostician() {
			WorkaroundEmfValidator newEmfValidator = new WorkaroundEmfValidator();
			WorkaroundOclValidator newOclValidator = new WorkaroundOclValidator(newEmfValidator);
			eValidatorRegistry.put(org.eclipse.emf.ecore.EcorePackage.eINSTANCE, newEmfValidator);
			eValidatorRegistry.put(org.eclipse.ocl.ecore.EcorePackage.eINSTANCE, newOclValidator);
		}
	}

	protected final ICSTEnvironment rootEnvironment;
	protected CSTNode cstNode;
	protected int errorStart = 0;
	protected int errorEnd = 0;
	private Monitor monitor = null;

	protected CSTEnvironment(EPackage.Registry reg) {
		super(reg);
		rootEnvironment = this;
	}

	protected CSTEnvironment(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
		rootEnvironment = this;
	}
	
	protected CSTEnvironment(P parent, CSTNode cstNode) {
		super(parent);
		setCSTNode(cstNode);
		this.rootEnvironment = parent.getRootEnvironment();
	}

	/**
	 * Create the recipient of EValidator diagnostics. The default implementation creates a
	 * ProblemHandlerDiagnosticChain to redirect diagnostics to the ProblemHandler.
	 */
	protected ProblemHandlerDiagnosticChain createDiagnosticChain() {
		return new ProblemHandlerDiagnosticChain(this);
	}

	/**
	 * Create and return a Diagnostician for validator report processing.
	 * 
	 * @return the Diagnostician
	 */
	protected Diagnostician createDiagnostician() {
		return new WorkaroundDiagnostician();
	}

	public InvalidLiteralExp createInvalidLiteralExp(CSTNode cstNode) {
		InvalidLiteralExp invalidLiteralExp = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidLiteralExp();
		initASTMapping(invalidLiteralExp, cstNode);
		return invalidLiteralExp;
	}

	/**
	 * Create and return the SubstitutionLabelProvider to provide object descriptions
	 * in validator messages. The diagnostician may be returned directly. The default
	 * implementation returns getFormatter().
	 * 
	 * @param diagnostician processing the validator diagnostics
	 * @return the SubstitutionLabelProvider
	 */
	protected EValidator.SubstitutionLabelProvider createSubstitutionLabelProvider(Diagnostician diagnostician) {
		return getFormatter();
	}

	public String formatLookupException(LookupException e) {
		List<?> matches = e.getAmbiguousMatches();
		List<String> matchNames = new ArrayList<String>();
		for (Object match : matches)
			matchNames.add(formatQualifiedName(match));				
		Collections.sort(matchNames);
		StringBuilder s = new StringBuilder();
		s.append(e.getMessage());
		String separator = " { ";
		for (String matchName : matchNames) {
			s.append(separator);
			s.append(matchName);
			separator = ", ";
		}
		s.append(" }");
		return s.toString();
	}
	
	public String formatName(Object object) {
		return getFormatter().formatName(object);
	}

	public String formatPath(List<String> names) {
		return getFormatter().formatPath(names);
	}

	@Deprecated
	public String formatPathName(Object object) {
		return formatQualifiedName(object);
	}

	public String formatQualifiedName(Object object) {
		return getFormatter().formatQualifiedName(object);
	}

	public String formatString(String string) {
		return getFormatter().formatString(string);
	}

	public String formatType(Object type) {
		return getFormatter().formatType(type);
	}

	@Override
	public CSTNode getASTMapping(Object object) {
		if ((rootEnvironment != this) && (rootEnvironment != null))
			return rootEnvironment.getASTMapping(object);
		else
			return super.getASTMapping(object);
	}

	@Override
	public Map<Object, CSTNode> getASTNodeToCSTNodeMap() {
//		if ((rootEnvironment != this) && (rootEnvironment != null))
//			return rootEnvironment.getASTNodeToCSTNodeMap();	// FIXME ?? add to ICSTEnvironment
//		else
			return super.getASTNodeToCSTNodeMap();
	}

	public CSTNode getCSTNode() {
		return cstNode;
	}	

	@Override
	public CSTFormattingHelper getFormatter() {
		return CSTFormattingHelper.INSTANCE;
	}
    
	public Monitor getMonitor() {
		return monitor;
	}

	@Override public ProblemHandler getProblemHandler() {
		if ((rootEnvironment != this) && (rootEnvironment != null))
			return rootEnvironment.getProblemHandler();
		else
			return super.getProblemHandler();
	}

	@SuppressWarnings("unchecked")
	public P getParentEnvironment() {
		return (P) getInternalParent();
	}
	
	public ICSTEnvironment getRootEnvironment() {
		return rootEnvironment;
	}
   
	public EAttribute getUnresolvedAttribute() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedAttribute();
	}

	public EClass getUnresolvedClass() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass();
	}

	public EClassifier getUnresolvedClassifier() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClassifier();
	}

	public EDataType getUnresolvedDataType() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedDataType();
	}

	public EOperation getUnresolvedOperation() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass().getEOperations().get(0);
	}

	public EStructuralFeature getUnresolvedProperty() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedProperty();
	}

	public EReference getUnresolvedReference() {
		return UnresolvedPackage.eINSTANCE.getUnresolvedClass_UnresolvedReference();
	}

	@Override
	public void initASTMapping(Object astNode, CSTNode cstNode) {
		if ((rootEnvironment != this) && (rootEnvironment != null))
			rootEnvironment.initASTMapping(astNode, cstNode);
		else
			super.initASTMapping(astNode, cstNode);
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

	public CSTNode setCSTNode(CSTNode cstNode) {
		CSTNode oldCSTNode = this.cstNode;
		this.cstNode = cstNode;
		return oldCSTNode;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public String toString() {
		String parentString = getInternalParent() != null ? (getInternalParent().toString() + ".") : "";
		CSTNode cstNode = getCSTNode();
		String childString = cstNode instanceof IHasName ? ((IHasName)cstNode).getName() : getClass().getSimpleName();
		return parentString + childString;
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
		EStructuralFeature result = super.lookupProperty(owner, name);
		if (result != null)
			return result;
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

	public void validate(Resource resource) {
		if (resource == null)
			return;
	   	Diagnostician diagnostician = createDiagnostician();
	   	EValidator.SubstitutionLabelProvider substitutionLabelProvider = createSubstitutionLabelProvider(diagnostician);
	    Map<Object, Object> context = new HashMap<Object, Object>();
	    context.put(EValidator.SubstitutionLabelProvider.class, substitutionLabelProvider);
	    context.put(EValidator.class, diagnostician);
	    context.put(ICSTEnvironment.class, this);
	    context.put(Environment.class, this); //Used by derived EValidator that cannot see ICSTEnvironment
		DiagnosticChain diagnosticChain = createDiagnosticChain();
		for (EObject astNode : resource.getContents())
		    diagnostician.validate(astNode, diagnosticChain, context);
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
				else
					System.out.println(formatName(eObject.eClass()) + " : " + formatQualifiedName(eObject) + " has no mapping to a CST node");
			}
		}
	}
}
