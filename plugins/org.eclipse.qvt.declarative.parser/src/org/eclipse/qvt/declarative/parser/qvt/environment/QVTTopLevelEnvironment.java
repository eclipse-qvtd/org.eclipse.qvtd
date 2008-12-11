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
package org.eclipse.qvt.declarative.parser.qvt.environment;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.parser.environment.CSTRootEnvironment;

public abstract class QVTTopLevelEnvironment<E extends IQVTNodeEnvironment, CST extends CSTNode> extends CSTRootEnvironment<E, CST> implements IQVTNodeEnvironment
{
	private final EPackage.Registry qvtRegistry;

	protected QVTTopLevelEnvironment(IQVTFileEnvironment parent, XMIResource astResource, CST cstNode) {
		super(parent, astResource, cstNode);
		qvtRegistry = parent.getRegistry();
	}

	protected void addPackage(EPackage ePackage) {
		ast.getContents().add(ePackage);
		qvtRegistry.put(ePackage.getName(), ePackage);
		getFileEnvironment().initializePackageNs(ePackage);
	}

	protected void addSubPackage(EPackage ePackage, EPackage childPackage) {
		ePackage.getESubpackages().add(childPackage);
		getFileEnvironment().initializePackageNs(childPackage);
	}

	@Override
	protected QVTFormattingHelper createFormattingHelper() {
		return new QVTFormattingHelper(this);
	}
	
/*	public List<EPackage> getEPackages() {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		for (Object object : qvtRegistry.values())
			if (object instanceof EPackage)
				ePackages.add((EPackage) object);
		EPackage orphanPackage = getTypeResolver().getOrphanPackage();
		if ((orphanPackage != null) && (ePackages.size() > 0)) {
			EPackage firstPackage = ePackages.get(0);
			firstPackage.getEClassifiers().addAll(orphanPackage.getEClassifiers());
		}
		return ePackages;
	} */

	public String getModelName(EObject object) {
		return null;
	}	

	public Transformation getTransformation() {
		return null;			// Never happens
	}

	@Override
	public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
		return (Variable) super.lookupImplicitSourceForOperation(name, params);
	}

	@Override
	public Variable lookupImplicitSourceForProperty(String name) {
		return (Variable) super.lookupImplicitSourceForProperty(name);
	}

	public EClass lookupImportedClass(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier instanceof EClass)
				return (EClass) eClassifier;
		}
		return null;
	}

	public EClassifier lookupImportedClassifier(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier != null)
				return eClassifier;
		}
		return null;
	}

	public Transformation lookupImportedTransformation(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier instanceof Transformation)
				return (Transformation) eClassifier;
		}
		return null;
	}

/*	public void parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		URI sourceURI = file.getURI();
		analyzer.parseToAST(sourceURI);
	}

	public CSTNode parseToCST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		return analyzer.parseToCST();
	} 

	public AbstractQVTAnalyzer<E> parseToTokens(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		return analyzer;
	} */

/*	public boolean parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		if (!analyzer.parseToCST())
 			return false;
		if (isCancelled())
			return false;
		if (!analyzer.analyze(this))
 			return false;
		XMIUtils.assignIds(ast, "ast");
		return true;
	} */

	protected String resolveSynonym(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) {
		if ("+".equals(name) && (args.size() == 1)) {
			EClassifier oclString = getOCLStandardLibrary().getString();
			EClassifier ownerType = getTypeResolver().resolve(owner);
			EClassifier argType = getTypeResolver().resolve(args.get(0).getType());
			if ((ownerType == oclString) && (argType == oclString))
				name = "concat";
		}
		return name;
	}

	/**
	 * QVT classifier lookups must occur with respect to multiple context packages.
	 * The inherited behaviour must therefore be re-implemented by derived classes.
	 */
	@Override
	public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		return null;
	}

	@Override
	public EOperation tryLookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) throws LookupException {
		name = resolveSynonym(owner, name, args);
		return super.tryLookupOperation(owner, name, args);
	}

	public EReference tryLookupOppositeProperty(EClass eClass, String propertyName) throws LookupException {
		return null;
	}

	public Transformation tryLookupTransformation(List<String> pathName) throws LookupException {
		EPackage ePackage = tryLookupPackage(pathName);
		if (ePackage == null)
			return null;
		if (ePackage instanceof Transformation)
			return (Transformation) ePackage;
		throw new LookupException("Not a transformation", Collections.singletonList(ePackage));
	}

	public Variable tryLookupVariable(String name) throws LookupException {
		return null;
	}
}
