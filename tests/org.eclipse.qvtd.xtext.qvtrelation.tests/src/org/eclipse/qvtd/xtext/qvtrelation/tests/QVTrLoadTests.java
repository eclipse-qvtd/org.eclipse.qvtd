/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.library.ImplementationManager;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.Resumable;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class QVTrLoadTests extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	public void doLoad_ModelMorf(@NonNull String stem, @NonNull String @NonNull [] messages) throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/models/" + stem + ".qvtr", true);
		URI pivotURI = getTestURI(stem + ".qvtras");
		doLoad_Concrete(inputURI, pivotURI, messages);
	}

	protected void doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @NonNull [] messages) throws Exception {
		//	ClassLoader cl0 = getClass().getClassLoader();
		//	assert cl0 != null;
		//	OCL ocl = QVTrelation.newInstance(getTestProjectManager());
		//	EnvironmentFactoryAdapter environmentFactoryAdapter = EnvironmentFactoryAdapter.find(ocl.getResourceSet());
		//	assert environmentFactoryAdapter != null;
		//	ImplementationManager implementationManager = environmentFactoryAdapter.getMetamodelManager().getImplementationManager();
		//	@NonNull List<@NonNull ClassLoader> classLoaders = implementationManager.getClassLoaders();
		//	if (!classLoaders.contains(cl0)) {
		//		implementationManager.addClassLoader(cl0);
		//	}
		Resumable<@NonNull Resource, ?> resumableThread = doLoad_Concrete(inputURI, pivotURI, messages, null);
		resumableThread.syncResume();
		//	ocl.dispose();
	}

	//	@Override
	public void doLoad_Concrete(@NonNull URI inputURI, @NonNull String @Nullable [] messages) throws Exception {
		//	OCL ocl = QVTbase.newInstance(getTestProjectManager(), null);
		//		OCL ocl = OCL.newInstance(getProjectMap());
		URI pivotURI = getTestURIWithExtension(inputURI, QVTrelationUtil.QVTRAS_FILE_EXTENSION);
		Resumable<@NonNull Resource, ?> resumableThread = doLoad_Concrete(inputURI, pivotURI, messages, null);
		resumableThread.syncResume();
		//	ocl.dispose();
	}

	public @NonNull Resumable<@NonNull Resource, ?>  doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		QVTrelationEnvironmentThreadFactory environmentThreadFactory = new QVTrelationEnvironmentThreadFactory(getTestProjectManager()) {

			@Override
			public @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
				QVTimperativeEnvironmentFactory environmentFactory = super.createEnvironmentFactory();
				ClassLoader cl0 = getClass().getClassLoader();
				assert cl0 != null;
				PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
				ImplementationManager implementationManager = metamodelManager.getImplementationManager();
				@NonNull List<@NonNull ClassLoader> classLoaders = implementationManager.getClassLoaders();
				if (!classLoaders.contains(cl0)) {
					implementationManager.addClassLoader(cl0);
				}
				return environmentFactory;
			}
		};
		if (severity != null) {
			environmentThreadFactory.setSeverity(severity);
		}
		return doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
	}

	@Override
	protected void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		super.setUp();
		//		getProjectMap().
		//		ProjectMap.getAdapter(resourceSet);
	}

	public void testQVTrLoad_AbstractToConcrete_qvtr() throws Exception {
		doLoad_ModelMorf("AbstractToConcrete/AbstractToConcrete", new @NonNull String[] {
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key ClassMM::Type {ClassMM::Type::name}'"
		});
	}

	public void testQVTrLoad_ClassModelToClassModel_qvtr() throws Exception {
		doLoad_ModelMorf("ClassModelToClassModel/ClassModelToClassModel", new @NonNull String[] {
			"The 'RelationCallExp::WhereInvocationIsANonTopRelation' constraint is violated for 'classToClass(c1, c2)'"
		});
	}

	public void testQVTrLoad_DNF_bbox_qvtr() throws Exception {
		doLoad_ModelMorf("DNF_bbox/DNF_bbox", NO_MESSAGES);
	}

	public void testQVTrLoad_DNF_qvtr() throws Exception {
		doLoad_ModelMorf("DNF/DNF", NO_MESSAGES);
	}

	public void testQVTrLoad_HstmToStm_qvtr() throws Exception {
		doLoad_ModelMorf("HstmToStm/hstmtostm", NO_MESSAGES);
	}

	public void testQVTrLoad_Import_qvtr() throws Exception {
		doLoad_ModelMorf("Import/UmlToRdbms_1", NO_MESSAGES);
	}

	public void testQVTrLoad_Keys_qvtr() throws Exception {
		doLoad_Concrete(getModelsURI("misc/Keys.qvtr"), new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies}'",
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies, QVTRelation::Key::part}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::NamedElement {EMOF::NamedElement::name}'"
		});
	}

	public void testQVTrLoad_MiToSiSimple_qvtr() throws Exception {
		//		doLoad_ModelMorf("MiToSi/mitosi");
		doLoad_Concrete(getModelsURI("mitosi/MiToSiSimple.qvtr"), NO_MESSAGES);
	}

	public void testQVTrLoad_Packages_qvtr() throws Exception {
		doLoad_Concrete(getModelsURI("misc/Packages.qvtr"), NO_MESSAGES);
	}

	public void testQVTrLoad_ATL2QVTr_qvtr() throws Exception {
		//		ProjectMap.getAdapter(resourceSet);
		BaseLinkingService.DEBUG_RETRY.setState(true);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		URI pivotURI = getTestURI("ATL2QVTr.qvtras");
		doLoad_Concrete(inputURI, pivotURI, new @NonNull String[] {});
	}

	public void testQVTrLoad_RelToCore_qvtr() throws Exception {
		//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/model/RelToCore.qvtr", true);
		URI pivotURI = getTestURI("RelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI, new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::Type {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key QVTBase::Transformation {EMOF::NamedElement::name}'",
			"The 'RelationCallExp::WhereInvocationIsANonTopRelation' constraint is violated for 'RelationalTransformationToMappingTransformation(rt, mt)'"
		});
	}

	public void testQVTrLoad_SimplerRelToCore_qvtr() throws Exception {
		//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/model/SimplerRelToCore.qvtr", true);
		URI pivotURI = getTestURI("SimplerRelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI, new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::Type {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key QVTBase::Transformation {EMOF::NamedElement::name}'",
			"The 'RelationCallExp::WhereInvocationIsANonTopRelation' constraint is violated for 'RelationalTransformationToMappingTransformation(rt, mt)'",
			"The 'Rule::AbstractRuleIsOverridden' constraint is violated for 'relation RExpToMExp'"
		});
	}

	public void testQVTrLoad_SeqToStm_qvtr() throws Exception {
		doLoad_ModelMorf("SeqToStm/SeqToStm", NO_MESSAGES);
	}

	public void testQVTrLoad_SeqToStmc_CT_qvtr() throws Exception {
		doLoad_ModelMorf("SeqToStmc_CT/SeqToStmc", NO_MESSAGES);
	}

	public void testQVTrLoad_UmlToRdbms_qvtr() throws Exception {
		doLoad_ModelMorf("UmlToRdbms/UmlToRdbms", NO_MESSAGES);
	}

	public void testQVTrLoad_UmlToRel_qvtr() throws Exception {
		doLoad_ModelMorf("UmlToRel/UmlToRel", NO_MESSAGES);
	}
}
