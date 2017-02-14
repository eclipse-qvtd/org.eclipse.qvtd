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

import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.firstToUpperCase;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getAllContainers;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getAllContents;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getAllContentsIncludingSelf;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getCreationMappingName;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getExpressionContextType;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getOwningPackage;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getSuperClasses;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTmUtil.getUpdateMappingName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;

public class OCL2QVTm {

	//	private @NonNull Logger logger = Logger.getLogger(getClass().getName());
	private @NonNull EnvironmentFactory envFact;
	private @NonNull String traceabilityPropName;
	//	private @Nullable Map<?,?> saveOptions;

	public static final @NonNull String RIGHT_MODEL_TYPE_NAME = "rightAS";
	public static final @NonNull String LEFT_MODEL_TYPE_NAME = "leftCS";

	public OCL2QVTm(@NonNull EnvironmentFactory envFact, @NonNull String traceabilityPropName) {
		this.envFact = envFact;
		this.traceabilityPropName = traceabilityPropName;
	}

	public Resource run(ResourceSet resourceSet, URI oclDocURI) {

		if (!"oclas".equals(oclDocURI.fileExtension())) {
			throw new IllegalArgumentException(oclDocURI.toString() + " is not an .oclas URI");
		}
		Resource input = resourceSet.getResource(oclDocURI, true);
		EObject rootModel = input.getContents().get(0);
		if (rootModel instanceof Model) {
			Model model = (Model) rootModel;
			CoreModel outputModel = oclModelToImperativeModel().apply(model);

			// We create the output resource
			URI outputURI = oclDocURI.trimFileExtension().trimFileExtension().appendFileExtension("qvtm.qvtcas");
			Resource outputResource = resourceSet.createResource(outputURI);
			outputResource.getContents().add(outputModel);
			return outputResource;

		} else {
			throw new IllegalArgumentException(oclDocURI.toString() + " doesn't contain an OCL Model");
		}
	}

	private TypedModel leftTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
	private TypedModel rightTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();

	public Function<Model, CoreModel> oclModelToImperativeModel() {
		return oclModel -> {

			CoreModel iModel = QVTcoreFactory.eINSTANCE.createCoreModel();

			List<Operation> allAstOps = getAllContents().apply(oclModel)
					.filter(isAstOp())
					.map(Operation.class::cast).collect(Collectors.toList());
			List<ShadowExp> shadowExps = allAstOps.stream()
					.flatMap(getAllContents())
					.filter(ShadowExp.class::isInstance)
					.map(ShadowExp.class::cast).collect(Collectors.toList());
			List<ShadowPart> shadowParts =  allAstOps.stream()
					.flatMap(getAllContents())
					.filter(ShadowPart.class::isInstance)
					.map(ShadowPart.class::cast).collect(Collectors.toList());

			iModel.setExternalURI(oclModel.getExternalURI().replace(".ocl", ".qvtm.qvtcas")); // When the externalURI is set, also is its name
			iModel.getOwnedImports().addAll(oclModel.getOwnedImports().stream()
				.map(importToImport())
				.collect(Collectors.toList()));

			Package pPackage = PivotFactory.eINSTANCE.createPackage();
			pPackage.setName("");
			iModel.getOwnedPackages().add(pPackage);

			Transformation pTx = QVTbaseFactory.eINSTANCE.createTransformation();
			pTx.setName(iModel.getName().replace('.', '_')); // FIXME . as part of the name is causing issues in the CG);
			pPackage.getOwnedClasses().add(pTx);

			leftTypedModel.setName(LEFT_MODEL_TYPE_NAME);
			leftTypedModel.getUsedPackage().addAll(shadowExps.stream()
				.map(getExpressionContextType())
				.map(getOwningPackage())
				.collect(Collectors.toSet()));
			pTx.getModelParameter().add(leftTypedModel);

			rightTypedModel.setName(RIGHT_MODEL_TYPE_NAME);
			rightTypedModel.getUsedPackage().addAll(shadowExps.stream()
				.map(x -> x.getType())
				.map(getOwningPackage())
				.collect(Collectors.toSet()));
			pTx.getModelParameter().add(rightTypedModel);

			pTx.getRule().addAll(shadowExps.stream()
				.filter(shadowExpToCreationMappingGuard())
				.map(shadowExpToCreationMapping())
				.collect(Collectors.toList()));

			pTx.getRule().addAll(shadowParts.stream()
				.filter(shadowPartToUpdateMappingGuard())
				.map(shadowPartToUpdateMapping())
				.collect(Collectors.toList()));

			pTx.getRule().addAll(allAstOps.stream()
				.filter(astOpWithNoShadowExps2UpdateMappingGuard())
				.map(astOpWithNoShadowExps2UpdateMapping())
				.collect(Collectors.toList()));
			return iModel;
		};
	}

	public Function<@NonNull Import, @NonNull Import> importToImport(){
		return oclImport -> {
			Import pImport = PivotFactory.eINSTANCE.createImport();
			pImport.setName(oclImport.getName());
			pImport.setImportedNamespace(oclImport.getImportedNamespace());
			return pImport;
		};
	}

	protected Predicate<@NonNull ShadowExp> shadowExpToCreationMappingGuard() {
		return shadowExp -> {
			return ! getAllContainers().apply(shadowExp)
					.anyMatch(ShadowExp.class::isInstance);
		};
	}

	public Function<@NonNull ShadowExp, @NonNull Mapping>  shadowExpToCreationMapping() {
		return shadowExp -> {
			Mapping mapping = QVTcoreFactory.eINSTANCE.createMapping();
			mapping.setName(getCreationMappingName().apply(shadowExp));

			CoreDomain leftDomain = createCreationMapping_LeftDomain(shadowExp);
			CoreDomain rightDomain = createCreationMapping_RightDomain(shadowExp);
			mapping.getDomain().add(leftDomain);
			mapping.getDomain().add(rightDomain);

			Variable leftVar = leftDomain.getGuardPattern().getVariable().get(0);

			GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
			BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
			mapping.setGuardPattern(guardPattern);
			mapping.setBottomPattern(bottomPattern);

			PropertyAssignment pAssignment = QVTcoreFactory.eINSTANCE.createPropertyAssignment();
			VariableExp value = PivotUtil.createVariableExp(rightDomain.getBottomPattern().getRealizedVariable().get(0));

			VariableExp slotExpression = PivotUtil.createVariableExp(leftVar);

			pAssignment.setValue(value);
			pAssignment.setSlotExpression(slotExpression);
			pAssignment.setTargetProperty(getTraceabilityProperty(slotExpression.getType()));

			bottomPattern.getAssignment().add(pAssignment);
			updateGuardPattern(shadowExp, guardPattern, leftVar);


			workaround495327(getAllContainers().apply(shadowExp)
				.filter(Operation.class::isInstance)
				.map(Operation.class::cast)
				.findFirst().get()
				,mapping,leftDomain);
			return mapping;
		};
	}


	protected Predicate<@NonNull ShadowPart> shadowPartToUpdateMappingGuard() {
		return shadowPart -> {
			ShadowExp containingShadowExp = (ShadowExp) shadowPart.eContainer(); // FIXME this should be in Pivot
			return shadowExpToCreationMappingGuard().test(containingShadowExp);
		};
	}

	public Function<@NonNull ShadowPart, @NonNull Mapping>  shadowPartToUpdateMapping() {
		return shadowPart -> {
			Mapping mapping = QVTcoreFactory.eINSTANCE.createMapping();
			mapping.setName(getUpdateMappingName().apply(shadowPart));

			ShadowExp shadowExp = (ShadowExp) shadowPart.eContainer();
			Property refProp = shadowPart.getReferredProperty();

			CoreDomain leftDomain = createUpdateMapping_LeftDomain(shadowExp);
			CoreDomain rightDomain = createUpdateMapping_RightDomain();
			mapping.getDomain().add(leftDomain);
			mapping.getDomain().add(rightDomain);

			Variable leftVar = leftDomain.getGuardPattern().getVariable().get(0);

			VariableExp varExp = PivotFactory.eINSTANCE.createVariableExp();
			varExp.setReferredVariable(leftVar);
			varExp.setType(varExp.getReferredVariable().getType());
			Property tracebilityProperty = getTraceabilityProperty(varExp.getType());

			PropertyCallExp astPropCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
			astPropCallExp.setOwnedSource(varExp);
			astPropCallExp.setReferredProperty(tracebilityProperty);
			astPropCallExp.setType(astPropCallExp.getReferredProperty().getType());

			OperationCallExp asTypeOpCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
			asTypeOpCallExp.setOwnedSource(astPropCallExp);
			asTypeOpCallExp.setReferredOperation(getOclAnyOclAsTypeOp());
			asTypeOpCallExp.setType(shadowExp.getType());

			TypeExp argTypeExp = createTypeExp(shadowExp.getType());
			argTypeExp.setType(getOclMetaClass());

			asTypeOpCallExp.getOwnedArguments().add(argTypeExp);

			PropertyAssignment pAssignment = QVTcoreFactory.eINSTANCE.createPropertyAssignment();
			pAssignment.setTargetProperty(refProp);
			pAssignment.setValue(createPropertyAssignmentValue(shadowPart.getOwnedInit(), leftVar));
			pAssignment.setSlotExpression(asTypeOpCallExp);

			GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
			BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
			mapping.setGuardPattern(guardPattern);
			mapping.setBottomPattern(bottomPattern);

			bottomPattern.getAssignment().add(pAssignment);
			updateGuardPattern(shadowExp,  guardPattern, leftVar);

			workaround495327(getAllContainers().apply(shadowExp)
				.filter(Operation.class::isInstance)
				.map(Operation.class::cast)
				.findFirst().get()
				,mapping,leftDomain);
			return mapping;
		};
	}


	protected Predicate<@NonNull Operation> astOpWithNoShadowExps2UpdateMappingGuard() {
		return operation -> {

			return isAstOp().test(operation)
					&& !isInvalidOp().test(operation)
					&& !getAllContents().apply(operation).anyMatch(x -> x instanceof ShadowExp);
		};
	}

	public Function<@NonNull Operation, @NonNull Mapping>  astOpWithNoShadowExps2UpdateMapping() {
		return operation -> {
			Mapping mapping = QVTcoreFactory.eINSTANCE.createMapping();
			mapping.setName(getAstPropUpdateMappingName().apply(operation));

			CoreDomain leftDomain = createUpdateMapping_LeftDomain(operation);
			CoreDomain rightDomain = createUpdateMapping_RightDomain();
			mapping.getDomain().add(leftDomain);
			mapping.getDomain().add(rightDomain);

			Variable leftVar = leftDomain.getGuardPattern().getVariable().get(0);

			GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
			BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
			mapping.setGuardPattern(guardPattern);
			mapping.setBottomPattern(bottomPattern);

			VariableExp varExp = PivotFactory.eINSTANCE.createVariableExp();
			varExp.setReferredVariable(leftVar);
			varExp.setType(leftVar.getType());


			PropertyAssignment pAssignment = QVTcoreFactory.eINSTANCE.createPropertyAssignment();
			ExpressionInOCL bodyExp = (ExpressionInOCL) operation.getBodyExpression();
			pAssignment.setTargetProperty(getTraceabilityProperty(varExp.getType()));
			pAssignment.setValue(createPropertyAssignmentValue(bodyExp.getOwnedBody(), leftVar));
			pAssignment.setSlotExpression(varExp);

			bottomPattern.getAssignment().add(pAssignment);

			workaround495327(operation,mapping,leftDomain);
			return mapping;
		};
	}


	private CoreDomain createDomain() {

		CoreDomain domain = QVTcoreFactory.eINSTANCE.createCoreDomain();
		GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
		BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
		domain.setGuardPattern(guardPattern);
		domain.setBottomPattern(bottomPattern);
		return domain;
	}

	private CoreDomain createLeftDomain(Type type) {

		CoreDomain domain = createDomain();
		domain.setTypedModel(leftTypedModel);
		domain.setIsCheckable(true);

		Variable variable = QVTcoreFactory.eINSTANCE.createGuardVariable();
		variable.setName("l"+firstToUpperCase().apply(type.getName()));
		variable.setType(type);

		domain.getGuardPattern().getVariable().add(variable);
		return domain;
	}

	// No realized variable
	private CoreDomain createRightDomain() {

		CoreDomain domain = createDomain();
		domain.setTypedModel(rightTypedModel);
		domain.setIsEnforceable(true);
		return domain;
	}

	private CoreDomain createRightDomain(Type type) {

		CoreDomain domain = createRightDomain();

		RealizedVariable variable = QVTcoreFactory.eINSTANCE.createRealizedVariable();
		variable.setName("r"+firstToUpperCase().apply(type.getName()));
		variable.setType(type);

		domain.getBottomPattern().getRealizedVariable().add(variable);
		return domain;

	}


	private CoreDomain createCreationMapping_LeftDomain(ShadowExp shadowExp) {
		return createLeftDomain(getExpressionContextType().apply(shadowExp));
	}

	private CoreDomain createCreationMapping_RightDomain(ShadowExp shadowExp) {
		return createRightDomain(shadowExp.getType());
	}


	private CoreDomain createUpdateMapping_LeftDomain(ShadowExp shadowExp) {
		// It's exactly the same domain as we have for the creation mappings
		return createLeftDomain(getExpressionContextType().apply(shadowExp));
	}

	private CoreDomain createUpdateMapping_RightDomain() {
		// We don't create a realized variable
		return createRightDomain();
	}

	private CoreDomain createUpdateMapping_LeftDomain(Operation operation ) {
		return createLeftDomain(operation.getOwningClass());
	}

	private OCLExpression createPropertyAssignmentValue(OCLExpression exp, Variable leftVar) {

		// FIXME what happens with synthetised types ????
		OCLExpression newInitExp = EcoreUtil.copy(exp);
		//We need to replace the OCL refered "self" varible by the QVTi domain "leftVar" and ast op calls
		return doReplacements(newInitExp, leftVar);
	}

	private OCLExpression doReplacements(OCLExpression oclExp, Variable leftVar) {

		List<OCLExpression> result = new ArrayList<OCLExpression>();// Simple work aroound to the forEach constraint ;
		result.add(oclExp);
		getAllContentsIncludingSelf().apply(oclExp).forEach(x -> {
			if (isSelfVarExp().test(x)) {
				((VariableExp)x).setReferredVariable(leftVar);
			} else if(isAstOpCallExp().test(x)) {
				OperationCallExp exp = (OperationCallExp) x;
				PropertyCallExp astPropCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
				astPropCallExp.setOwnedSource(exp.getOwnedSource());
				astPropCallExp.setReferredProperty(getTraceabilityProperty(astPropCallExp.getOwnedSource().getType()));
				astPropCallExp.setType(astPropCallExp.getReferredProperty().getType());
				// Copying remaining changeable OpCallExp properties (excepting ownedArguments and referredOperation)
				astPropCallExp.setTypeValue(exp.getTypeValue());
				astPropCallExp.getOwnedComments().addAll(exp.getOwnedComments());
				astPropCallExp.getOwnedExtensions().addAll(exp.getOwnedExtensions());
				astPropCallExp.setName(exp.getName());
				astPropCallExp.setIsSafe(exp.isIsSafe());
				astPropCallExp.setIsRequired(exp.isIsRequired());
				astPropCallExp.setIsImplicit(exp.isIsImplicit());
				astPropCallExp.setIsPre(exp.isIsPre());
				// end of copy

				Type castType = exp.getType();
				OperationCallExp asTypeOpCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
				asTypeOpCallExp.setOwnedSource(astPropCallExp);
				asTypeOpCallExp.setReferredOperation(getOclAnyOclAsTypeOp());
				asTypeOpCallExp.setType(castType);
				asTypeOpCallExp.setIsSafe(astPropCallExp.isIsSafe());

				TypeExp argTypeExp = createTypeExp(castType);
				asTypeOpCallExp.getOwnedArguments().add(argTypeExp);

				if (result.contains(exp)) { // if exp is the initial oclExp, the new asTypeOpCallExp will be the new result
					result.remove(exp);
					result.add(asTypeOpCallExp);
				} else {
					EcoreUtil.replace(exp,asTypeOpCallExp);
				}
				EcoreUtil.delete(exp);
			}
		});
		return result.get(0);
	}

	/**
	 * Function which takes into account that the shadow is embedded inside of an IfExp
	 * so that the guard pattern have the proper guards associated to the the IfExp
	 */
	private void updateGuardPattern(ShadowExp shadowExp, GuardPattern guardPattern, Variable leftVar) {

		EObject container = shadowExp.eContainer();

		if (container instanceof IfExp) {
			IfExp ifExp = (IfExp) container;
			OCLExpression condition = ifExp.getOwnedCondition();
			List<OCLExpression> guardPredicates = new ArrayList<OCLExpression>();
			if (ifExp.getOwnedThen() == shadowExp) {
				guardPredicates.add(EcoreUtil.copy(condition));
			} else { // it's the else
				guardPredicates.add(createNegatedExpression(condition));
			}

			container = container.eContainer();
			// FIXME create a cached operation to improve performance
			while (container instanceof IfExp) {
				ifExp = (IfExp) container;
				guardPredicates.add(createNegatedExpression(ifExp.getOwnedCondition()));
				container = container.eContainer();
			}

			// We need to replace the OCL refered "self" varible by the QVTi domain "leftVar"
			Collections.reverse(guardPredicates);
			for (OCLExpression guardPredicate : guardPredicates ) {
				org.eclipse.qvtd.pivot.qvtbase.Predicate predicate = QVTbaseFactory.eINSTANCE.createPredicate();
				predicate.setConditionExpression(doReplacements(guardPredicate, leftVar));
				guardPattern.getPredicate().add(predicate);
			}
		}
	}

	private OCLExpression createNegatedExpression(OCLExpression oclExp){
		// We don't want to create a 'not not conditionExp'
		if (isBooleanNotOpCallExp().test(oclExp)) {
			OperationCallExp notOpCallExp = (OperationCallExp) oclExp;
			return EcoreUtil.copy(notOpCallExp.getOwnedSource());
		} else {
			OperationCallExp notOpCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
			notOpCallExp.setName("not");
			notOpCallExp.setReferredOperation(getBooleanNotOp());
			notOpCallExp.setType(getBooleanPrimitiveType());
			notOpCallExp.setOwnedSource(EcoreUtil.copy(oclExp));
			return notOpCallExp;
		}
	}


	private Predicate<EObject> isSelfVarExp() {
		return element -> {
			return element instanceof VariableExp &&
					"self".equals(((VariableExp)element).getReferredVariable().getName());
		};
	}

	private Predicate<EObject> isAstOpCallExp() {
		return element -> {
			return element instanceof OperationCallExp &&
					isAstOp().test(((OperationCallExp)element).getReferredOperation());
		};
	}

	private Predicate<EObject> isAstOp() {
		return element -> {
			return element instanceof Operation &&
					"ast".equals(((Operation)element).getName());
		};
	}

	private Predicate<EObject> isInvalidOp() {
		return element -> {
			if (element instanceof Operation) {
				LanguageExpression exp = ((Operation) element).getBodyExpression();
				if (exp instanceof ExpressionInOCL) {
					OCLExpression bodyExp = ((ExpressionInOCL) exp).getOwnedBody();
					return bodyExp.getType() == envFact.getStandardLibrary().getOclInvalidType();
				}
			}
			return false;
		};
	}

	/*private List<OperationCallExp> getAstCalls(ShadowPart shadowPart) {
		return getAllContentsIncludingSelf().apply(shadowPart.getOwnedInit())
			.filter(isAstOpCallExp())
			.map(OperationCallExp.class::cast)
			.collect(Collectors.toList());
	}*/

	private @NonNull Property getTraceabilityProperty(Type type) {
		Class aClass = type.isClass();
		assert(aClass != null);
		Class pClass = envFact.getMetamodelManager().getPrimaryClass(aClass);
		Set<Class> allClasses = getSuperClasses().apply(pClass);
		allClasses.add(pClass);
		return allClasses.stream()
				.flatMap(x -> x.getOwnedProperties().stream())
				.filter(x -> traceabilityPropName.equals(x.getName()))
				.findFirst().get();
	}


	private Function<@NonNull Operation, @NonNull String> getAstPropUpdateMappingName() {
		return op -> {
			return 'u' + op.getOwningClass().getName() + '_' + traceabilityPropName;
		};
	}

	private @NonNull Operation getOclAnyEqualsOp() {
		Class oclAny = envFact.getStandardLibrary().getOclAnyType();
		return envFact.getMetamodelManager().getPrimaryClass(oclAny).getOwnedOperations().stream()
				.filter(x -> "=".equals(x.getName()))
				.findFirst().get();
	}

	private @NonNull Class getOclMetaClass() {
		return envFact.getStandardLibrary().getClassType();
	}

	private @NonNull Operation getOclAnyOclAsTypeOp() {
		Class oclAny = envFact.getStandardLibrary().getOclAnyType();
		return envFact.getMetamodelManager().getPrimaryClass(oclAny).getOwnedOperations().stream()
				.filter(x -> "oclAsType".equals(x.getName()))
				.findFirst().get();
	}

	private @NonNull Operation getOclAnyOclIsTypeOfOp() {
		Class oclAny = envFact.getStandardLibrary().getOclAnyType();
		return envFact.getMetamodelManager().getPrimaryClass(oclAny).getOwnedOperations().stream()
				.filter(x -> "oclIsTypeOf".equals(x.getName()))
				.findFirst().get();
	}

	private @NonNull Class getBooleanPrimitiveType() {
		return envFact.getStandardLibrary().getBooleanType();

	}

	private @NonNull Operation getBooleanNotOp() {
		Class boolType = envFact.getStandardLibrary().getBooleanType();
		return envFact.getMetamodelManager().getPrimaryClass(boolType).getOwnedOperations().stream()
				.filter(x -> "not".equals(x.getName()))
				.findFirst().get();
	}

	private Predicate<OCLExpression> isBooleanNotOpCallExp() {
		return exp -> {
			return exp instanceof OperationCallExp &&
					((OperationCallExp)exp).getReferredOperation() == getBooleanNotOp();
		};
	}

	// TODO promote to PivotUtil
	private TypeExp createTypeExp(Type type) {
		TypeExp argTypeExp = PivotFactory.eINSTANCE.createTypeExp();
		argTypeExp.setReferredType(type);
		argTypeExp.setType(getOclMetaClass());
		return argTypeExp;
	}

	// To workaround limitation of Bug 495327: Any mapping related to a non-final ast() operation
	// will include an additional guard to ensure that only strictly instance of (oclTypeOf) the source type
	// are considered. Therefor, any instance of a subtype won't ever be considered by this mapping
	private void workaround495327(Operation op, Mapping mapping, CoreDomain leftDomain) {
		PivotMetamodelManager mm = (PivotMetamodelManager) envFact.getMetamodelManager();
		if (!mm.getFinalAnalysis().isFinal(op)) {
			GuardPattern guard = mapping.getGuardPattern();
			Variable leftVar = leftDomain.getGuardPattern().getVariable().get(0);

			org.eclipse.qvtd.pivot.qvtbase.Predicate predicate = QVTbaseFactory.eINSTANCE.createPredicate();
			PivotHelper helper = new PivotHelper(envFact);
			VariableExp sourceExp = helper.createVariableExp(leftVar);
			TypeExp argTypeExp = createTypeExp(leftVar.getType());
			predicate.setConditionExpression(helper.createOperationCallExp(sourceExp, getOclAnyOclIsTypeOfOp(), Collections.singletonList(argTypeExp)));

			guard.getPredicate().add(predicate);
		}
	}
}