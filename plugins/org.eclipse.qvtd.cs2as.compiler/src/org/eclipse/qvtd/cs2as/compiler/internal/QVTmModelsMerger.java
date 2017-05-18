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
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public class QVTmModelsMerger {


	/**
	 * <p>
	 * Utility to merge the QVTm models result of the OCL2QVTm transformation on different CS2AS descriptions.
	 * </p>
	 *
	 * <ul>
	 * The merge utility will simply consist of:
	 * <li> Merging all the qvtm {@link Mapping mappings} in one qvtm {@link Transformation transformation} </li>
	 * <li> Merging all the {@link Import imports} in the containing qvtm {@link CoreModel model}, taking care of import duplications </li>
	 * </ul>
	 *
	 * @param extendedQVTmModels a list of the QVTm models to merge
	 * @return a clone of the first QVTm model of the provided list, having merged the remaining QVTm models of that list
	 */
	public static void merge(EnvironmentFactory envF, Resource targetQVTmModel, List<Resource> extendedQVTmModels) {

		CoreModel qvtmModel = getCoreModel(targetQVTmModel);
		Map<Class, List<Mapping>> inputType2RefiningMapping = getRefiningMappingInputTypes(qvtmModel);
		for (Resource extendedQVTmModel : extendedQVTmModels) {
			doMerge(envF, qvtmModel, getCoreModel(extendedQVTmModel), inputType2RefiningMapping);
		}
	}

	private static Map<Class, List<Mapping>> getRefiningMappingInputTypes(CoreModel qvtmModel) {

		Map<Class, List<Mapping>> result = new HashMap<Class, List<Mapping>>();
		Package _package = qvtmModel.getOwnedPackages().get(0);
		Transformation tx = (Transformation) _package.getOwnedClasses().get(0);
		for (Rule rule : tx.getRule()) {
			Mapping mapping = (Mapping) rule;
			Variable inputVar = getInputVariable(mapping);
			Class refiningType = (Class)inputVar.getType();
			List<Mapping> refiningMappings = result.get(refiningType);
			if (refiningMappings == null) {
				refiningMappings = new ArrayList<Mapping>();
				result.put(refiningType, refiningMappings);
			}
			refiningMappings.add(mapping);
		}
		return result;
	}
	/**
	 * @param resultQVTmModel
	 * @param mergedQVTmModel
	 * @param refMapInputTypes a list of the types involved in the mappings of the extending QVTm model
	 */
	private static void doMerge(EnvironmentFactory envF, CoreModel resultQVTmModel, CoreModel mergedQVTmModel, Map<Class, List<Mapping>> inputType2RefiningMapping) {

		// Imports
		Set<Namespace> alreadyImportedNamespaces = new HashSet<Namespace>();
		Set<Import> importsToRemove = new HashSet<Import>();
		for (Import _import : resultQVTmModel.getOwnedImports()) {
			Namespace importedNS = _import.getImportedNamespace();
			alreadyImportedNamespaces.add(importedNS);
			if (doesNamespaceCorrespondToMergedQVTmModel(mergedQVTmModel, importedNS)) {
				importsToRemove.add(_import);
			}
		}
		// Add a copy of the imported NS
		for (Import _import : mergedQVTmModel.getOwnedImports()) {
			Namespace importedNS = _import.getImportedNamespace();
			if (!alreadyImportedNamespaces.contains(importedNS)) {
				resultQVTmModel.getOwnedImports().add(EcoreUtil.copy(_import));
			}
		}

		for (Import _import : importsToRemove) {
			resultQVTmModel.getOwnedImports().remove(_import);
		}


		Transformation resultTransformation = getTransformation(resultQVTmModel);
		Transformation mergedTransformation = getTransformation(mergedQVTmModel);

		// TypedModels
		Map<String, List<Package>> tmName2oldUsedPackages = new HashMap<String, List<Package>>();
		for (TypedModel typedModel : mergedTransformation.getModelParameter()) {
			tmName2oldUsedPackages.put(typedModel.getName(),typedModel.getUsedPackage());
		}
		Map<String, TypedModel> tmName2newTypedModel = new HashMap<String, TypedModel>();
		for (TypedModel typedModel : resultTransformation.getModelParameter()) {
			typedModel.getUsedPackage().addAll(tmName2oldUsedPackages.get(typedModel.getName()));
			tmName2newTypedModel.put(typedModel.getName(), typedModel);
		}

		// Mapping rules
		EList<Rule> resultRules = resultTransformation.getRule();
		for (Rule rule : mergedTransformation.getRule()) {
			Mapping baseRule = (Mapping) EcoreUtil.copy(rule);
			refactorMapping(envF, baseRule, inputType2RefiningMapping, tmName2newTypedModel);
			resultRules.add(baseRule);
		}


	}

	private static boolean doesNamespaceCorrespondToMergedQVTmModel(CoreModel mergedQVTmModel, Namespace ns) {

		if (ns instanceof Model && isAnOCLModel(ns)) {
			URI qvtmModelURI = URI.createURI(mergedQVTmModel.getExternalURI());
			assert assertCorrectQVTmModelFileExtenion(qvtmModelURI);
			URI importedNSURI = URI.createURI(((Model) ns).getExternalURI());
			String fileName1 = qvtmModelURI.trimFragment().trimFileExtension().trimFileExtension().lastSegment(); // xxx.qvtm.qvias
			String fileName2 = importedNSURI.trimFragment().trimFileExtension().trimFileExtension(). lastSegment();	// xxx.ocl or xxx.ocl.oclas
			return ClassUtil.nonNullState(fileName1).equals(fileName2);
		}
		return false;
	}

	private static boolean isAnOCLModel(Namespace ns) {

		URI nsURI = URI.createURI(((Model) ns).getExternalURI());
		if ("ocl".equals(nsURI.fileExtension())) {
			return true;
		}
		if (! "oclas".equals(nsURI.fileExtension())) {
			return false;
		}
		if (! "ocl".equals(nsURI.trimFileExtension().fileExtension())) {
			return false;
		}
		return true;
	}

	private static Transformation getTransformation(CoreModel iModel) {


		for (org.eclipse.ocl.pivot.Package aPackage : iModel.getOwnedPackages()) {
			for (org.eclipse.ocl.pivot.Class aClass : aPackage.getOwnedClasses()) {
				if (aClass instanceof Transformation) {
					return (Transformation) aClass;
				}
			}
		}

		throw new IllegalStateException(MessageFormat.format("The QVTd model '{0}' does not have a Transformation element.", iModel.getExternalURI()));
	}

	private static CoreModel getCoreModel(Resource qvtmResource) {

		for (EObject eContent : qvtmResource.getContents()) {
			if (eContent instanceof CoreModel) {
				return (CoreModel) eContent;
			}
		}
		throw new IllegalStateException(MessageFormat.format("The QVTd model '{0}' does not have an CoreModel element.", qvtmResource.getURI()));
	}

	private static boolean assertCorrectQVTmModelFileExtenion(URI qvtmModelURI ) {

		assert qvtmModelURI.fileExtension().equals("qvtcas");
		assert qvtmModelURI.trimFileExtension().fileExtension().equals("qvtm");
		return true;
	}

	private static void refactorMapping (EnvironmentFactory envF, Mapping mappingToRefactor, Map<Class, List<Mapping>> inputType2extendingMapping,
			Map<String, TypedModel> tmName2newTypedModel) {

		// TypedModel refactor
		for (Domain domain : mappingToRefactor.getDomain()) {
			domain.setTypedModel(tmName2newTypedModel.get(domain.getTypedModel().getName()));
		}

		Variable inputVar = getInputVariable(mappingToRefactor);
		Type refinedType = inputVar.getType();
		for (Entry<Class, List<Mapping>> mEntry : inputType2extendingMapping.entrySet()) {
			Class refiningType = mEntry.getKey();
			for (Mapping refiningMapping : mEntry.getValue()){
				List<Class> superClasses = new ArrayList<Class>();
				computeAllSuperClasses(refiningType, superClasses);
				if (superClasses.contains(refinedType)) {
					// We check the mapping name, to ensure it's the correct refining mapping
					String refinedMappingName = mappingToRefactor.getName();
					String refiningMappingName = refiningMapping.getName();
					if (refinedMappingName.startsWith("c")){	// if it's a creation mapping
						if (refiningMappingName.startsWith("c")) {
							doMappingRefactoring(envF, mappingToRefactor, refiningMapping, inputVar, refiningType);
						}
					} else if (refinedMappingName.startsWith("u")) {
						if (refiningMappingName.startsWith("u")) {
							String refinedUMappingFeature = refinedMappingName.split("u.*_")[1];
							String refiningUMappingFeature = refiningMappingName.split("u.*_")[1];
							if (refinedUMappingFeature.equals(refiningUMappingFeature)) {
								doMappingRefactoring(envF, mappingToRefactor, refiningMapping, inputVar, refiningType);
							}
						}
					} else {
						//This point should never be reached given the mapping naming convention introduced in OCL2QVTm.
						throw new IllegalStateException("This point should never be reached given the mapping naming convention introduced in OCL2QVTm.");
					}
				}
			}
		}
	}

	private static void doMappingRefactoring(EnvironmentFactory envF, Mapping mappingToRefactor, Mapping refiningMapping, Variable inputVar, Class refiningType) {

		// We add the guard
		Predicate predicate = QVTbaseFactory.eINSTANCE.createPredicate();
		predicate.setConditionExpression(createOclIsKindOfOperationCall(envF, inputVar, refiningType));
		mappingToRefactor.getGuardPattern().getPredicate().add(predicate);
		// And set the refinement
		refiningMapping.setOverridden(mappingToRefactor);
	}

	private static Variable getInputVariable(Mapping mapping) {
		// In OCL2QVTm the first one is always the input domain with a unique input variable
		CoreDomain inputDomain = (CoreDomain) mapping.getDomain().get(0);
		return inputDomain.getGuardPattern().getVariable().get(0);
	}
	private static void computeAllSuperClasses(Class aClass, List<Class> allSuperClasses) {

		for (Class superClass : aClass.getSuperClasses()) {
			if (!allSuperClasses.contains(superClass)) {
				allSuperClasses.add(superClass);
				computeAllSuperClasses(superClass, allSuperClasses);
			}
		}
	}

	private static OCLExpression createOclIsKindOfOperationCall(EnvironmentFactory envF, Variable inputVar, Class refiningType) {

		// oclIsKindOf OperationCallExp
		OperationCallExp opCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		CompletePackage cPackage = envF.getCompleteModel().getCompletePackage(envF.getStandardLibrary().getPackage());
		CompleteClass cClass = cPackage.getCompleteClass(envF.getStandardLibrary().getOclAnyType());
		Operation oclIsKindOfOp = cClass.getOperations(FeatureFilter.SELECT_NON_STATIC, "oclIsKindOf").iterator().next();

		opCallExp.setReferredOperation(oclIsKindOfOp);
		opCallExp.setName(oclIsKindOfOp.getName());
		opCallExp.setType(oclIsKindOfOp.getType());

		// We set the source

		VariableExp source = PivotFactory.eINSTANCE.createVariableExp();
		source.setReferredVariable(inputVar);
		source.setName(inputVar.getName());
		source.setType(inputVar.getType());
		opCallExp.setOwnedSource(source);

		// We set the argument
		TypeExp arg = PivotFactory.eINSTANCE.createTypeExp();
		arg.setType(envF.getStandardLibrary().getClassType());
		arg.setReferredType(refiningType);
		opCallExp.getOwnedArguments().add(arg);

		return createNotOperation(envF, opCallExp);
	}

	private static OperationCallExp createNotOperation(EnvironmentFactory envF, OCLExpression expToNegate) {

		// not OperationCallExp
		OperationCallExp opCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		CompletePackage cPackage = envF.getCompleteModel().getPrimitiveCompletePackage();
		CompleteClass cClass = cPackage.getCompleteClass(envF.getStandardLibrary().getBooleanType());
		Operation oclIsKindOfOp = cClass.getOperations(FeatureFilter.SELECT_NON_STATIC, "not").iterator().next();

		opCallExp.setReferredOperation(oclIsKindOfOp);
		opCallExp.setName(oclIsKindOfOp.getName());
		opCallExp.setType(oclIsKindOfOp.getType());

		// we set the source
		opCallExp.setOwnedSource(expToNegate);
		return opCallExp;
	}
}
