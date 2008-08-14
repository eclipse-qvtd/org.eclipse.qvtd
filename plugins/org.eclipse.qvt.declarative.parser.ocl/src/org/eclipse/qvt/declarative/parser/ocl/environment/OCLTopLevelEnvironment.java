/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
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
 * $Id: OCLTopLevelEnvironment.java,v 1.1 2008/08/14 07:52:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.ocl.environment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.emof.EssentialOCL.util.EssentialOCLMappingMetaData;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractModelResolver;
import org.eclipse.qvt.declarative.modelregistry.model.ModelNameAccessor;
import org.eclipse.qvt.declarative.modelregistry.model.Registration;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.ocl.OCLFileAnalyzer;
import org.eclipse.qvt.declarative.parser.ocl.OCLParsingError;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTTopLevelEnvironment.LPGProgressMonitor;
import org.eclipse.qvt.declarative.parser.utils.StringUtils;

public class OCLTopLevelEnvironment extends OCLEnvironment implements IFileEnvironment
{
	public static final String PACKAGE_NAME_SEPARATOR = ".";

	protected class OCLEnvironmentFactory extends EcoreEnvironmentFactory implements EcoreEnvironmentFactory.Lookup<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	{
		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
			if (!(parent instanceof OCLEnvironment)) {
				throw new IllegalArgumentException(
					"Parent environment must be an OCLFileEnvironment: " + parent); //$NON-NLS-1$
			}
			return new OCLEnvironment((OCLEnvironment)parent, null);
		}

		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createClassifierContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				EClassifier context) {
			if (context == null)
				throw new OCLParsingError("Missing classifier context");
			return super.createClassifierContext(parent, context);
		}

		@Override public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOperationContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				EOperation operation) {
			if (operation == null)
				throw new OCLParsingError("Missing operation context");
			return super.createOperationContext(parent, operation);
		}

		@Deprecated @Override
		public final Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createPackageContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				List<String> pathname) {
			return super.createPackageContext(parent, pathname);
		}


		@Deprecated
		@Override protected final EPackage lookupPackage(List<String> pathname) {
			return OCLTopLevelEnvironment.this.lookupPackage(pathname);
		}
		
		public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> tryCreatePackageContext(
				Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
				List<String> pathname) throws LookupException {
			EPackage contextPackage = tryLookupPackage(pathname);        
	        return (contextPackage == null)? null : super.createPackageContext(parent, contextPackage);
		}

		public EPackage tryLookupPackage(List<String> names) throws LookupException {
			return OCLTopLevelEnvironment.this.tryLookupPackage(names);
		}
	}

	protected EcoreEnvironmentFactory derivedFactory;
	protected final AbstractFileHandle file;
	private OCLFileAnalyzer analyzer = null;
	protected AbstractModelResolver resolver = null;
	private Map<String, List<EPackage>> packagePath = null;

	public OCLTopLevelEnvironment(AbstractFileHandle file, ResourceSet resourceSet) {
		super(new EPackageRegistryImpl(), null);
		this.file = file;
		resolver = new AbstractModelResolver(file);	
		resolver.setResourceSet(resourceSet);
		setCSTNode(cstNode);
	}

	public void addToPackagePath(EList<? extends EObject> contents, String path) {
		for (EObject eObject : contents) {
			if (eObject instanceof EPackage) {
				EPackage ePackage = (EPackage) eObject;
				String fullPackageName = path != null ? (path + PACKAGE_NAME_SEPARATOR + ePackage.getName()) : ePackage.getName();
				List<EPackage> ePackages = packagePath.get(fullPackageName);
				if (ePackages == null) {
					ePackages = new ArrayList<EPackage>();
					packagePath.put(fullPackageName, ePackages);
				}
				ePackages.add(ePackage);
				addToPackagePath(ePackage.getESubpackages(), fullPackageName);
			}
		}
	}

	public Resource createASTResource(Collection<? extends EObject> asts, URI uri) {
		Resource resource = getResourceSet().createResource(uri, getContentTypeIdentifier());
		if (resource != null) {
			if (asts != null)
				for (EObject ast : asts)
					if (ast != null)
						resource.getContents().add(ast);
			XMIUtils.assignIds(resource, "ast");
		}
		return resource;
	}

	protected OCLFileAnalyzer createAnalyzer() {
		return new OCLFileAnalyzer(this);
	}

	public OCLFileAnalyzer getAnalyzer() {
		if (analyzer == null)
			analyzer = createAnalyzer();
		return analyzer;
	}

	protected String getContentTypeIdentifier() {
		return EssentialOCLMappingMetaData.INSTANCE.getEcoreContentTypeIdentifier();	// FIXME Use an MDT-OCL defined value once available
	}

	@Override public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getFactory() {
		if (derivedFactory == null)
			derivedFactory = new OCLEnvironmentFactory();
		return derivedFactory;
	}

	public Map<String, List<EPackage>> getPackagePath() {
		if (packagePath == null) {
			packagePath = new HashMap<String, List<EPackage>>();
			for (Registration<ModelNameAccessor> registration : resolver.getRegistrations(ModelNameAccessor.class)) {
				try {
					Resource resource = resolver.getResource(registration);
					if (resource != null)
						addToPackagePath(resource.getContents(), null);
				} catch (IOException e) {
					QVTParserPlugin.logError("Failed to load " + registration, e);
				} catch (WrappedException e) {
					QVTParserPlugin.logError("Failed to load " + registration, e.exception());
				}
			}
		}
		return packagePath;
	}

	public ResourceSet getResourceSet() {
		return resolver.getResourceSet();
	}

	protected OCLFileAnalyzer initializeAnalyzer(Reader reader) throws CoreException, FileNotFoundException, IOException {
		OCLFileAnalyzer analyzer = getAnalyzer();
// FIXME		analyzer.reset();
		analyzer.setFileName(file.getName());
//		analyzer.setResolver(resolver);
		if (reader == null)
			reader = new InputStreamReader(file.getContents());
		else if (!file.exists())
			return null;
		analyzer.initialize(reader);
		return analyzer;
	}

	protected void initializeMonitor(IProgressMonitor monitor) {
		setMonitor(new LPGProgressMonitor(monitor));
	}

	public Collection<? extends EObject> parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		OCLFileAnalyzer analyzer = initializeAnalyzer(reader);
		URI sourceURI = file.getURI();
		return analyzer.parseToAST(sourceURI);
	}

	public CSTNode parseToCST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		OCLFileAnalyzer analyzer = initializeAnalyzer(reader);
		return analyzer.parseToCST();
	}

	public OCLFileAnalyzer parseToTokens(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		OCLFileAnalyzer analyzer = initializeAnalyzer(reader);
		return analyzer;
	}

	public void saveCST(CSTNode cstNode, URI uri) throws IOException {
		Resource resource = getResourceSet().createResource(uri);
		XMIUtils.assignIds(resource, "cst");
		resource.save(null);
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EClassifier eClassifier = super.tryLookupClassifier(names);
		if (eClassifier != null)
			return eClassifier;
		if (names.size() > 1) {
            List<String> newNames = names.subList(0, names.size() - 1);
			EPackage pkg = tryLookupPackage(newNames);
			if (pkg != null) {
				String name = names.get(names.size() - 1);
		        EClassifier result = pkg.getEClassifier(name);
		        if ((result == null) && OCLAnalyzer.isEscaped(name)) {
		            // try the unescaped name
		            result = pkg.getEClassifier(OCLAnalyzer.unescape(name));
		        }
				return result;
			}
		}
		return null;
	}

	@Override public EPackage tryLookupPackage(List<String> path) throws LookupException {
		EPackage ePackage = super.tryLookupPackage(path);
		if (ePackage != null)
			return ePackage;
		String fullPackagePath = StringUtils.splice(path, PACKAGE_NAME_SEPARATOR);
		Map<String, List<EPackage>> packagePath = getPackagePath();
		List<EPackage> ePackages = packagePath.get(fullPackagePath);
		if ((ePackages == null) || (ePackages.size() == 0)) {
//			analyzerError(cstNode, "typeName", "Unknown package '" + formatString(fullPackagePath) + "'");
			return null;
		}
		if (ePackages.size() > 1)
			throw new LookupException("Ambiguous package '" + formatString(fullPackagePath) + "'");
		return ePackages.get(0);
	}

/*	@Override
	public void validate(Resource resource) {
		if (resource instanceof AdaptingXMIResource)
			resource = ((AdaptingXMIResource)resource).getTarget();
		if (resource == null)
			return;
		Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> validator = ValidationVisitor.getInstance(this);
		for (EObject astNode : resource.getContents()) {
			if (astNode instanceof Visitable)
				((Visitable) astNode).accept(validator);
			else if (astNode instanceof Constraint)
				validator.visitConstraint((Constraint) astNode);
			else
				validatorError("Expected AST node to be Visitable or a Constraint", null, astNode);
		}
	} */
}
