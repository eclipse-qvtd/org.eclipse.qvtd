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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.parser.environment.CSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;

public abstract class QVTFileEnvironment<R extends ICSTRootEnvironment, E extends IQVTNodeEnvironment, CST extends CSTNode> extends CSTFileEnvironment<R, E, CST> implements IQVTFileEnvironment
{
	protected QVTFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

	@Override
	protected QVTTypeResolverImpl createTypeResolver(Resource resource) {
		return new QVTTypeResolverImpl(this, resource);
	}

	public Collection<Resource> getResourcesVisibleAt(EObject astNode) {
		List<Resource> resources = new ArrayList<Resource>();
		if (ast != null)
			resources.add(ast);
		resources.addAll(getResourceSet().getResources());
		return resources;
	}

	@Override
	public QVTTypeResolverImpl getTypeResolver() {
		return (QVTTypeResolverImpl) super.getTypeResolver();
	}

	@Override
	public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
		return QVTReflectionImpl.INSTANCE;
	}

	@Override
	protected void postParse(R rootEnvironment) {
		EPackage orphanPackage = getTypeResolver().getOrphanPackage();
		EList<EObject> astContents = ast.getContents();
		if (orphanPackage != null) {
			if (!astContents.isEmpty() && (astContents.get(0) instanceof EPackage)) {
				((EPackage)astContents.get(0)).getEClassifiers().addAll(orphanPackage.getEClassifiers());
			}
			else {
				initializePackageNs(orphanPackage);
				astContents.add(orphanPackage);
			}
		}
		super.postParse(rootEnvironment);
	}

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

	public void saveCST(CSTNode cstNode, URI uri) throws IOException {
		Resource resource = getResourceSet().createResource(uri);
		XMIUtils.assignLinearIds(resource, "cst");
		resource.save(null);
	}
}
