/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class LoadTests extends LoadTestCase
{
	public void doLoad_ModelMorf(@NonNull String stem, @NonNull String @NonNull [] messages) throws IOException {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.modelmorf/qvtrsrc/" + stem + ".qvtr", true);
		URI pivotURI = getProjectFileURI(stem + ".qvtras");
		doLoad_Concrete(inputURI, pivotURI, messages);
	}

	protected void doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @NonNull [] messages) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		doLoad_Concrete(ocl, inputURI, pivotURI, messages);
		ocl.dispose();
	}

	@Override
	public void doLoad_Concrete(@NonNull String inputName, @NonNull String @Nullable [] messages) throws IOException {
		OCL ocl = QVTbase.newInstance(getProjectMap(), null);
		//		OCL ocl = OCL.newInstance(getProjectMap());
		URI inputURI = getProjectFileURI(inputName);
		URI pivotURI = inputURI.trimFileExtension().appendFileExtension("qvtras");
		doLoad_Concrete(ocl, inputURI, pivotURI, messages);
		ocl.dispose();
	}


	@Override
	protected void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTrTestUtil.doQVTrelationSetup();
		super.setUp();
		//		getProjectMap().
		//		ProjectMap.getAdapter(resourceSet);
	}

	public void testLoad_AbstractToConcrete_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("AbstractToConcrete/AbstractToConcrete", new @NonNull String[] {
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key ClassMM::Type {ClassMM::Type::name}'"
		});
	}

	public void testLoad_ClassModelToClassModel_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("ClassModelToClassModel/ClassModelToClassModel", NO_MESSAGES);
	}

	public void testLoad_DNF_bbox_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("DNF_bbox/DNF_bbox", NO_MESSAGES);
	}

	public void testLoad_DNF_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("DNF/DNF", NO_MESSAGES);
	}

	public void testLoad_HstmToStm_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("HstmToStm/hstmtostm", NO_MESSAGES);
	}

	public void testLoad_Import_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("Import/UmlToRdbms_1", NO_MESSAGES);
	}

	public void testLoad_Keys_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("models/Keys.qvtr", new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies}'",
			"The 'Key::IdentifiesIsUnique' constraint is violated for 'key QVTRelation::Key {QVTRelation::Key::identifies, QVTRelation::Key::part}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::NamedElement {EMOF::NamedElement::name}'"
		});
	}

	public void testLoad_MiToSiSimple_qvtr() throws IOException, InterruptedException {
		//		doLoad_ModelMorf("MiToSi/mitosi");
		doLoad_Concrete("mitosi/MiToSiSimple.qvtr", NO_MESSAGES);
	}

	public void testLoad_Packages_qvtr() throws IOException, InterruptedException {
		doLoad_Concrete("models/Packages.qvtr", NO_MESSAGES);
	}

	public void testLoad_RelToCore_qvtr() throws IOException, InterruptedException {
		//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("RelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI, new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::Type {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key QVTBase::Transformation {EMOF::NamedElement::name}'"
		});
	}

	public void testLoad_SimplerRelToCore_qvtr() throws IOException, InterruptedException {
		//		ProjectMap.getAdapter(resourceSet);
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("SimplerRelToCore.qvtras");
		doLoad_Concrete(inputURI, pivotURI, new @NonNull String[] {		// FIXME delete once Bug 512532 resolved
			"The 'Key::IdentifiesIsNotAbstract' constraint is violated for 'key EMOF::Type {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key EMOF::Class {EMOF::NamedElement::name}'",
			"The 'Key::NoSuperKeys' constraint is violated for 'key QVTBase::Transformation {EMOF::NamedElement::name}'"
		});
	}

	public void testLoad_SeqToStm_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("SeqToStm/SeqToStm", NO_MESSAGES);
	}

	public void testLoad_SeqToStmc_CT_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("SeqToStmc_CT/SeqToStmc", NO_MESSAGES);
	}

	public void testLoad_UmlToRdbms_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("UmlToRdbms/UmlToRdbms", NO_MESSAGES);
	}

	public void testLoad_UmlToRel_qvtr() throws IOException, InterruptedException {
		doLoad_ModelMorf("UmlToRel/UmlToRel", NO_MESSAGES);
	}
}
