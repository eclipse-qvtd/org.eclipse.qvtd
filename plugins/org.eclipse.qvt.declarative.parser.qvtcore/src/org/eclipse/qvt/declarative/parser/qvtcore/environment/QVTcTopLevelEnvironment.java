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
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.environment.CSTChildEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;

public class QVTcTopLevelEnvironment extends QVTTopLevelEnvironment<IQVTcNodeEnvironment, TopLevelCS> implements IQVTcNodeEnvironment
{
	public QVTcTopLevelEnvironment(QVTcFileEnvironment parent, XMIResource astResource, TopLevelCS cstNode) {
		super(parent, astResource, cstNode);
	}

	public QVTcTransformationEnvironment createEnvironment(TransformationCS transformationCS) {
		PathNameCS transformationPathName = transformationCS.getPathName();
		QVTcTransformationEnvironment environment;
		try {
			environment = getEnvironment(transformationPathName);
		} catch (LookupException e) {
			analyzerError("Illegal transformation name " + e.toString(), "transformationCS", transformationCS);
			return null;
		}
		if (environment == null) {
			List<String> transformationName = AbstractQVTAnalyzer.createSequenceOfNames(transformationPathName, null);
			environment = new QVTcTransformationEnvironment(this, transformationCS);
			Transformation transformation = environment.getTransformation();
			int transformationNameSize = transformationName.size();
			if (transformationNameSize <= 1)
				addPackage(transformation);
			else {
				try {
					EPackage ePackage = tryLookupPackage(transformationName.subList(0, 1));
					if (ePackage == null) {
						ePackage = EcoreFactory.eINSTANCE.createEPackage();
						initASTMapping(ePackage, transformationPathName, null);
						ePackage.setName(transformationName.get(0));
						addPackage(ePackage);
					}
					for (int i = 1; i < transformationNameSize-1; i++) {
						String name = transformationName.get(i);
						EPackage childPackage = EcoreUtils.getNamedElement(ePackage.getESubpackages(), name);
						if (childPackage == null) {
							childPackage = EcoreFactory.eINSTANCE.createEPackage();
							initASTMapping(childPackage, transformationPathName, null);
							childPackage.setName(name);
							addSubPackage(ePackage, childPackage);
						}
						ePackage = childPackage;
					}
					addSubPackage(ePackage, transformation);
				} catch (LookupException e) {		// Cannot happen
				}
			}
		}
		else {
			CSTNode cstNode = environment.getCSTNode();
			/*if (!(cstNode instanceof TransformationCS))
				environment.setCSTNode(transformationCS);
			else*/ if (cstNode != transformationCS) {
				analyzerError("Duplicate transformation definition", "transformationCS", transformationCS);
			}
		}
		return environment;
	}

	@Override
	public QVTcFormattingHelper createFormattingHelper() {
		return new QVTcFormattingHelper(this);
	}

	public QVTcNestedEnvironment createNestedEnvironment(CSTNode cstNode) {
		return new QVTcNestedEnvironment(this, cstNode);
	}

	@Override
	protected QVTcUnresolvedEnvironment createUnresolvedEnvironment() {
		return new QVTcUnresolvedEnvironment(this);
	}

	public QVTcTransformationEnvironment getEnvironment(TransformationCS transformationCS) {
		try {
			return getEnvironment(transformationCS.getPathName());
		} catch (LookupException e) {
			return null;		// Error during create
		}
	}

	public QVTcTransformationEnvironment getEnvironment(PathNameCS transformationName) throws LookupException {
		return getEnvironment(AbstractQVTAnalyzer.createSequenceOfNames(transformationName, null));
	}

	public QVTcTransformationEnvironment getEnvironment(List<String> transformationName) throws LookupException {
		Transformation transformation = tryLookupTransformation(transformationName);
		return CSTChildEnvironment.getEnvironmentFromAST(transformation, QVTcTransformationEnvironment.class);
	}

	@Override
	public QVTcUnresolvedEnvironment getUnresolvedEnvironment() {
		return (QVTcUnresolvedEnvironment) super.getUnresolvedEnvironment();
	}

	public Mapping tryLookupMapping(String name) {
		return null;		// Should never be called
	}
}
