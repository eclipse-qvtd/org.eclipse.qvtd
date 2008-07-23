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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.QVTcAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;

public class QVTcTopLevelEnvironment extends QVTTopLevelEnvironment<IQVTcEnvironment> implements IQVTcEnvironment
{
	private final Map<Transformation, QVTcTransformationEnvironment> transformationMap = new HashMap<Transformation, QVTcTransformationEnvironment>();
	
	public QVTcTopLevelEnvironment(AbstractFileHandle file, ResourceSet resourceSet) {
		super(file, resourceSet);
	}

	@Override protected QVTcAnalyzer createAnalyzer() {
		return new QVTcAnalyzer(this);
	}

	public QVTcTransformationEnvironment createEnvironment(TransformationCS transformationCS) {
		List<String> transformationName = transformationCS.getPathName().getSequenceOfNames();
		QVTcTransformationEnvironment environment;
		try {
			environment = getEnvironment(transformationName);
		} catch (LookupException e) {
			analyzerError("Illegal transformation name " + e.toString(), "transformationCS", transformationCS);
			return null;
		}
		if (environment == null) {
			environment = new QVTcTransformationEnvironment(this, transformationCS);
			Transformation transformation = environment.getTransformation();
			transformationMap.put(transformation, environment);
			int transformationNameSize = transformationName.size();
			if (transformationNameSize <= 1)
				addPackage(transformation);
			else {
				try {
					EPackage ePackage = tryLookupPackage(transformationName.subList(0, 1));
					if (ePackage == null) {
						ePackage = EcoreFactory.eINSTANCE.createEPackage();
						initASTMapping(ePackage, transformationCS.getPathName());
						ePackage.setName(transformationName.get(0));
						addPackage(ePackage);
					}
					for (int i = 1; i < transformationNameSize-1; i++) {
						String name = transformationName.get(i);
						EPackage childPackage = EcoreUtils.getNamedElement(ePackage.getESubpackages(), name);
						if (childPackage == null) {
							childPackage = EcoreFactory.eINSTANCE.createEPackage();
							initASTMapping(childPackage, transformationCS.getPathName());
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
			if (!(cstNode instanceof TransformationCS))
				environment.setCSTNode(transformationCS);
			else if (cstNode != transformationCS) {
				analyzerError("Duplicate transformation definition", "transformationCS", transformationCS);
			}
		}
		return environment;
	}

	@Override
	public QVTcFormattingHelper createFormatter() {
		return new QVTcFormattingHelper(this);
	}

	public QVTcTransformationEnvironment getEnvironment(TransformationCS transformationCS) {
		try {
			return getEnvironment(transformationCS.getPathName().getSequenceOfNames());
		} catch (LookupException e) {
			return null;		// Error during create
		}
	}

	@Override
	protected String getContentTypeIdentifier() {
		return QVTCorePackage.eCONTENT_TYPE;
	}

	public QVTcTransformationEnvironment getEnvironment(List<String> transformationName) throws LookupException {
		Transformation transformation = tryLookupTransformation(transformationName);
		return transformationMap.get(transformation);
	}

	public Mapping tryLookupMapping(String name) {
		return null;		// Should never be called
	}
}
