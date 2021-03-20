/*******************************************************************************
 * Copyright (c) 2016, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.FileURIHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.Resumable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.qvtr2umlx.QVTr2UMLX;
import org.eclipse.qvtd.umlx.umlx2qvtr.UMLX2QVTr;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.QVTrTestThread;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

import com.google.common.collect.Lists;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class UMLXSerializeTests extends LoadTestCase
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTbase.newInstance(getTestProjectManager(), null);
	}

	public @NonNull Resumable<@NonNull Resource, ?>  doLoad_Concrete(@NonNull URI inputURI, @NonNull URI pivotURI, @NonNull String @Nullable [] messages, StatusCodes.@Nullable Severity severity) throws Exception {
		QVTrelationEnvironmentThreadFactory environmentThreadFactory = new QVTrelationEnvironmentThreadFactory(getTestProjectManager())
		{
			@Override
			public @NonNull QVTrEnvironmentFactory createEnvironmentFactory() {
				QVTrEnvironmentFactory environmentFactory = super.createEnvironmentFactory();
				if (severity != null) {
					environmentFactory.setSafeNavigationValidationSeverity(severity);
				}
				return environmentFactory;
			}
		};
		if (severity != null) {
			environmentThreadFactory.setSeverity(severity);
		}
		return doLoad_Concrete(environmentThreadFactory, inputURI, pivotURI, messages, severity);
	}

	protected void doLoadTest(URI inputURI, URI pivotURI, URI umlxURI) throws Exception {
		Resumable<@NonNull Resource, ?> loadThread = doLoad_Concrete(inputURI, pivotURI, null, null);
		Resource qvtrResource = loadThread.getResult();
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(loadThread.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource);
		//
		loadThread.syncResume();
	}

	protected void doRoundTripTest(@NonNull String path, @NonNull String stem, boolean skipCompare) throws Exception {
//		QVTrelation ocl1 = QVTrelation.newInstance(getTestProjectManager());
		URI inputURI1 = getResourceURI(path + stem + ".qvtr");
		URI pivotURI1 = getTestURI(stem + ".qvtras");
		URI umlxURI = getTestURI(path + stem + ".umlx");
		URI pivotURI2 = getTestURI(stem + ".regenerated.qvtras");


		Resumable<@NonNull Resource, ?> qvtr2umlxResumable1 = doLoad_Concrete(inputURI1, pivotURI1, null, null);
		Resource qvtrResource1 = qvtr2umlxResumable1.getResult();

		URIConverter uriConverter = qvtr2umlxResumable1.getEnvironmentFactory().getResourceSet().getURIConverter();
		URI normalizedURI = uriConverter.normalize(umlxURI);
		URIHandler uriHandler = uriConverter.getURIHandler(normalizedURI);
		if (!(uriHandler instanceof FileURIHandlerImpl)) {		// platform:/plugin on Hudson
			umlxURI = getTestURI(stem + ".umlx");
		}
		final URI umlxURIfinal = umlxURI;

		Resource umlxResource1 = qvtrResource1.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(qvtr2umlxResumable1.getEnvironmentFactory(), qvtrResource1, umlxResource1);
		qvtr2umlx.transform();
		umlxResource1.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource1);
	//	ocl1.deactivate();
		//
		QVTrTestThread<@NonNull Resource> umlx2qvtrThread2 = new QVTrTestThread<@NonNull Resource>("UMLX2QVTr", getTestProjectManager())
		{
			@Override
			protected @NonNull Resource runWithModel(@NonNull ResourceSet resourceSet) throws Exception {
				Resource umlxResource2 = getEnvironmentFactory().getResourceSet().getResource(umlxURIfinal, true);
				Resource qvtrResource2 = getMetamodelManager().getASResourceSet().createResource(pivotURI2);
				UMLX2QVTr umlx2qvtr = new UMLX2QVTr(ocl.getEnvironmentFactory(), umlxResource2, qvtrResource2);
				umlx2qvtr.transform();
				qvtrResource2.save(CompilerUtil.defaultSavingOptions);
				syncSuspend(qvtrResource2);
				return qvtrResource2;
			}
		};
		Resumable<@NonNull Resource, ?> umlx2qvtrResumable2 = umlx2qvtrThread2.syncStart();
		Resource qvtrResource2 = umlx2qvtrResumable2.getResult();
		//
		Model asModel1 = PivotUtil.getModel(qvtrResource1);
		Model asModel2 = PivotUtil.getModel(qvtrResource2);
		asModel2.setName(asModel1.getName());
		asModel2.setExternalURI(asModel1.getExternalURI());
		TestsXMLUtil.resetTransients(qvtrResource1);
		TestsXMLUtil.resetTransients(qvtrResource2);
		normalize(qvtrResource1);
		normalize(qvtrResource2);
		if (!skipCompare) {				// FIXME BUG 511230
			assertSameModel(qvtrResource1, qvtrResource2);
		}
		qvtr2umlxResumable1.syncResume();
		umlx2qvtrResumable2.syncResume();
	}

	private void normalize(@NonNull Resource qvtrResource) {
		for (TreeIterator<EObject> tit = qvtrResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Relation) {
				normalizeRelation((Relation)eObject);
				tit.prune();
			}
			else if (eObject instanceof Import) {
				((Import)eObject).getOwnedComments().clear();
				tit.prune();
			}
		}
	}

	/**
	 * For non-composed leaf template elements there is a free choice to use a shared or template variable. Since there may be multiple
	 * candidate sites for the template variable, normalize by using a shared variable.
	 */
	private void normalizeRelation(@NonNull Relation asRelation) {
		//
		//	Find all references to all variables within the Relation
		//
		Map<@NonNull VariableDeclaration, @NonNull List<@NonNull Element>> variable2reference = new HashMap<>();
		List<OCLExpression> whenExpressions = new ArrayList<>();
		//		whenExpressions.add(asRelation.getWhen());
		for (@NonNull EObject eObject : new TreeIterable(asRelation, true)) {
			List<@NonNull VariableDeclaration> referredVariables = null;
			if (eObject instanceof VariableExp) {
				referredVariables = Lists.newArrayList(((VariableExp)eObject).getReferredVariable());
			}
			else if (eObject instanceof TemplateExp) {
				TemplateExp templateExp = (TemplateExp)eObject;
				referredVariables = Lists.newArrayList(templateExp.getBindsTo());
				if (eObject instanceof CollectionTemplateExp) {
					referredVariables.add(((CollectionTemplateExp)eObject).getRest());
				}
				OCLExpression where = templateExp.getWhere();
				if (where != null) {
					whenExpressions.add(where);
				}
			}
			else if (eObject instanceof DomainPattern) {
				referredVariables = Lists.newArrayList(((DomainPattern)eObject).getBindsTo());
			}
			if (referredVariables != null) {
				for (@NonNull VariableDeclaration referredVariable : referredVariables) {
					List<@NonNull Element> references = variable2reference.get(referredVariable);
					if (references == null) {
						references = new ArrayList<>();
						variable2reference.put(referredVariable, references);
					}
					references.add((Element)eObject);
				}
			}
		}
		//
		//	Replace leaf non-composite template variables
		//
		for (@NonNull VariableDeclaration variable : variable2reference.keySet()) {
			List<@NonNull Element> references = variable2reference.get(variable);
			assert references != null;
			if (variable instanceof TemplateVariable) {
				boolean canBeShared = true;
				for (@NonNull Element reference : references) {
					if (reference instanceof TemplateExp) {
						EObject eContainer = reference.eContainer();
						if (eContainer instanceof PropertyTemplateItem) {
							if (reference instanceof ObjectTemplateExp) {
								ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)reference;
								if (!objectTemplateExp.getPart().isEmpty()) {
									canBeShared = false;
									break;
								}
								Property asProperty = QVTrelationUtil.getReferredProperty(((PropertyTemplateItem)eContainer));
								if ((asProperty == null) || asProperty.isIsComposite()) {
									// perhaps this needs a further is there a when/where reference??
									//									canBeShared = false;
									//									break;
								}
							}
							else if (reference instanceof CollectionTemplateExp) {
								CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)reference;
								if (!collectionTemplateExp.getMember().isEmpty()) {
									canBeShared = false;
									break;
								}
								if (collectionTemplateExp.getRest() != null) {
									canBeShared = false;
									break;
								}
							}
						}
						else {
							canBeShared = false;
							break;
						}
					}
					//					EReference eContainmentFeature = reference.eContainmentFeature();
					//					EClassifier eType = eContainmentFeature.getEType();
					//					if (!eType.isInstance(PivotPackage.Literals.OCL_EXPRESSION)) {
					//						canBeShared = false;
					//						break;
					//					}
				}
				if (canBeShared) {
					VariableDeclaration sharedVariable = QVTrelationFactory.eINSTANCE.createSharedVariable();
					sharedVariable.setName(variable.getName());
					sharedVariable.setType(variable.getType());
					//					sharedVariable.setIsImplicit(variable.isIsImplicit());
					sharedVariable.setIsRequired(variable.isIsRequired());
					//					sharedVariable.setOwnedInit(variable.get);
					QVTbaseUtil.replaceChild(variable, sharedVariable);
					for (@NonNull Element reference : references) {
						if (reference instanceof VariableExp) {
							((VariableExp)reference).setReferredVariable(sharedVariable);
						}
						else if (reference instanceof ObjectTemplateExp) {
							QVTbaseUtil.replaceChild(reference, PivotUtil.createVariableExp(sharedVariable));
						}
						else if (reference instanceof CollectionTemplateExp) {
							QVTbaseUtil.replaceChild(reference, PivotUtil.createVariableExp(sharedVariable));
						}
						else if (reference instanceof DomainPattern) {
							((DomainPattern)reference).getBindsTo().remove(variable);
						}
					}
				}
			}
		}
		//
		//	Replace domain where's by relation when's
		//
		Pattern whenPattern = asRelation.getWhen();
		for (OCLExpression whenExpression : whenExpressions) {
			PivotUtilInternal.resetContainer(whenExpression);
			Predicate asPredicate = QVTbaseFactory.eINSTANCE.createPredicate();
			asPredicate.setConditionExpression(whenExpression);
			if (whenPattern == null) {
				whenPattern = QVTbaseFactory.eINSTANCE.createPattern();
				asRelation.setWhen(whenPattern);
			}
			whenPattern.getPredicate().add(asPredicate);
		}
	}


	@Override
	protected void setUp() throws Exception {
		XtextCompilerUtil.doQVTrelationSetup();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
		super.setUp();
	}

	public void testUMLXLoad_Forward2Reverse_qvtr() throws Exception {
		URI inputURI = getResourceURI("org.eclipse.qvtd.xtext.qvtrelation.tests/models/forward2reverse/Forward2Reverse.qvtr");
		URI pivotURI = getTestURI("Forward2Reverse.qvtras");
		URI umlxURI = getTestURI("Forward2Reverse.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_Keys_qvtr() throws Exception {
		URI inputURI = getResourceURI("org.eclipse.qvtd.xtext.qvtrelation.tests/models/misc/Keys.qvtr");
		URI pivotURI = getTestURI("Keys.qvtras");
		URI umlxURI = getTestURI("Keys.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_RelToCore_qvtr() throws Exception {
		URI inputURI = getResourceURI("org.eclipse.qvtd.examples.qvtrelation.reltocore/model/RelToCore.qvtr");
		URI pivotURI =  getTestURI("RelToCore.qvtras");
		URI umlxURI = getTestURI("RelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SeqToStm_qvtr() throws Exception {
		URI inputURI = getResourceURI("org.eclipse.qvtd.xtext.qvtrelation.tests/models/seq2stm/SeqToStm.qvtr");
		URI pivotURI = getTestURI("SeqToStm.qvtras");
		URI umlxURI = getTestURI("SeqToStm.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SimplerRelToCore_qvtr() throws Exception {
		URI inputURI = getResourceURI("org.eclipse.qvtd.examples.qvtrelation.reltocore/model/SimplerRelToCore.qvtr");
		URI pivotURI = getTestURI("SimplerRelToCore.qvtras");
		URI umlxURI = getTestURI("SimplerRelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXRoundtrip_Forward2Reverse_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/forward2reverse/", "Forward2Reverse", true);
	}

	public void testUMLXRoundtrip_HierarchicalStateMachine2FlatStateMachine_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/hstm2fstm/", "HierarchicalStateMachine2FlatStateMachine", true);
	}

	public void testUMLXRoundtrip_Iterated2Iterated_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/iterated2iterated/", "Iterated2Iterated", true);
	}

	public void testUMLXRoundtrip_Keys_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/misc/", "Keys", true);
	}

	public void testUMLXRoundtrip_MiToSiSimple_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/mitosi/", "MiToSiSimple", true);
	}

	public void testUMLXRoundtrip_PN2SC_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/pn2sc/", "PetriNet2StateChart", true);
	}

	public void testUMLXRoundtrip_SeqToStm_qvtr() throws Exception {
//		BaseLinkingService.DEBUG_RETRY.setState(true);
		doRoundTripTest("org.eclipse.qvtd.xtext.qvtrelation.tests/models/seq2stm/", "SeqToStm", true);
	}

	public void testUMLXRoundtrip_SimplerRelToCore_qvtr() throws Exception {
		doRoundTripTest("org.eclipse.qvtd.examples.qvtrelation.reltocore/model/", "SimplerRelToCore", true);
	}
}
