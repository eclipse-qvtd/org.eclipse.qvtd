/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.umlx.qvtr2umlx.QVTr2UMLX;
import org.eclipse.qvtd.umlx.umlx2qvtr.UMLX2QVTr;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtrelation.tests.QVTrTestUtil;

import com.google.common.collect.Lists;

/**
 * Tests that load a model and verify that there are no unresolved proxies as a result.
 */
public class UMLXSerializeTests extends LoadTestCase
{
	/*	protected void doLoad_QVTr(URI inputURI, URI pivotURI) throws IOException {
		OCL ocl = OCL.newInstance(getProjectMap());
		doLoad_Concrete(ocl, inputURI, pivotURI, null);
		ocl.dispose();
	} */

	protected void doLoadTest(URI inputURI, URI pivotURI, URI umlxURI) throws Exception {
		OCL ocl = OCL.newInstance(getProjectMap());
		Resource qvtrResource = doLoad_Concrete(ocl, inputURI, pivotURI, null);
		Resource umlxResource = qvtrResource.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl.getEnvironmentFactory(), qvtrResource, umlxResource);
		qvtr2umlx.transform();
		umlxResource.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource);
		//
		ocl.dispose();
	}

	protected void doRoundTripTest(@NonNull URI inputURI1, @NonNull URI pivotURI1, @NonNull URI umlxURI, @NonNull URI pivotURI2, boolean skipCompare) throws Exception {
		QVTrelation ocl1 = QVTrelation.newInstance(getProjectMap());
		Resource qvtrResource1 = doLoad_Concrete(ocl1, inputURI1, pivotURI1, null);
		Resource umlxResource1 = qvtrResource1.getResourceSet().createResource(umlxURI);
		QVTr2UMLX qvtr2umlx = new QVTr2UMLX(ocl1.getEnvironmentFactory(), qvtrResource1, umlxResource1);
		qvtr2umlx.transform();
		umlxResource1.save(null);
		//
		assertNoValidationErrors(umlxURI.toString(), umlxResource1);
		//
		QVTrelation ocl2 = QVTrelation.newInstance(getProjectMap());
		Resource umlxResource2 = ocl2.getResourceSet().getResource(umlxURI, true);
		Resource qvtrResource2 = ocl2.getMetamodelManager().getASResourceSet().createResource(pivotURI2);
		UMLX2QVTr umlx2qvtr = new UMLX2QVTr(ocl2.getEnvironmentFactory(), umlxResource2, qvtrResource2);
		umlx2qvtr.transform();
		qvtrResource2.save(TestsXMLUtil.defaultSavingOptions);
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
		ocl1.dispose();
		ocl2.dispose();
	}

	private void normalize(@NonNull Resource qvtrResource) {
		for (TreeIterator<EObject> tit = qvtrResource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Relation) {
				normalizeRelation((Relation)eObject);
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
								Property asProperty = ((PropertyTemplateItem)eContainer).getReferredProperty();
								if ((asProperty == null) || asProperty.isIsComposite()) {
									canBeShared = false;
									break;
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
		QVTrTestUtil.doQVTrelationSetup();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
		super.setUp();
	}

	public void testUMLXLoad_Forward2Reverse_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse.qvtr", true);
		URI pivotURI = getProjectFileURI("Forward2Reverse.qvtras");
		URI umlxURI = getProjectFileURI("Forward2Reverse.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_Keys_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/models/Keys.qvtr", true);
		URI pivotURI = getProjectFileURI("Keys.qvtras");
		URI umlxURI = getProjectFileURI("Keys.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_RelToCore_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/RelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("RelToCore.qvtras");
		URI umlxURI = getProjectFileURI("RelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SeqToStm_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm.qvtr", true);
		URI pivotURI = getProjectFileURI("SeqToStm.qvtras");
		URI umlxURI = getProjectFileURI("SeqToStm.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXLoad_SimplerRelToCore_qvtr() throws Exception {
		URI inputURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI = getProjectFileURI("SimplerRelToCore.qvtras");
		URI umlxURI = getProjectFileURI("SimplerRelToCore.umlx");
		doLoadTest(inputURI, pivotURI, umlxURI);
	}

	public void testUMLXRoundtrip_Forward2Reverse_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse.qvtr", true);
		URI pivotURI1 = getProjectFileURI("Forward2Reverse.qvtras");
		URI umlxURI = getProjectFileURI("Forward2Reverse.umlx");
		URI pivotURI2 = getProjectFileURI("Forward2Reverse.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_HierarchicalStateMachine2FlatStateMachine_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr", true);
		URI pivotURI1 = getProjectFileURI("HierarchicalStateMachine2FlatStateMachine.qvtras");
		URI umlxURI = getProjectFileURI("HierarchicalStateMachine2FlatStateMachine.umlx");
		URI pivotURI2 = getProjectFileURI("HierarchicalStateMachine2FlatStateMachine.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_Iterated2Iterated_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/iterated2iterated/Iterated2Iterated.qvtr", true);
		URI pivotURI1 = getProjectFileURI("Iterated2Iterated.qvtras");
		URI umlxURI = getProjectFileURI("Iterated2Iterated.umlx");
		URI pivotURI2 = getProjectFileURI("Iterated2Iterated.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_Keys_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/models/Keys.qvtr", true);
		URI pivotURI1 = getProjectFileURI("Keys.qvtras");
		URI umlxURI = getProjectFileURI("Keys.umlx");
		URI pivotURI2 = getProjectFileURI("Keys.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_PN2SC_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/pn2sc/PetriNet2StateChart.qvtr", true);
		URI pivotURI1 = getProjectFileURI("PetriNet2StateChart.qvtras");
		URI umlxURI = getProjectFileURI("PetriNet2StateChart.umlx");
		URI pivotURI2 = getProjectFileURI("PetriNet2StateChart.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_SeqToStm_qvtr() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtrelation.tests/src/org/eclipse/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm.qvtr", true);
		URI pivotURI1 = getProjectFileURI("SeqToStm.qvtras");
		URI umlxURI = getProjectFileURI("SeqToStm.umlx");
		URI pivotURI2 = getProjectFileURI("SeqToStm.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, false);
	}

	public void testUMLXRoundtrip_SimplerRelToCore_qvtr() throws Exception {
		URI inputURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.reltocore/qvtrsrc/SimplerRelToCore.qvtr", true);
		URI pivotURI1 = getProjectFileURI("SimplerRelToCore.qvtras");
		URI umlxURI = getProjectFileURI("SimplerRelToCore.umlx");
		URI pivotURI2 = getProjectFileURI("SimplerRelToCore.regenerated.qvtras");
		doRoundTripTest(inputURI1, pivotURI1, umlxURI, pivotURI2, true);	// FIXME BUG 511230
	}
}
