package org.eclipse.qvtd.cs2as.compiler.internal;

import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.firstToUpperCase;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContainers;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContents;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContentsIncludingSelf;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getCreationMappingName;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getExpressionContextType;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getSuperClasses;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getUpdateMappingName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Namespace;
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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;

public class OCL2QVTp {

	private @NonNull Logger logger = Logger.getLogger(getClass().getName());
	private @NonNull EnvironmentFactory envFact;
	private @NonNull String traceabilityPropName;
	private @Nullable Map<?,?> saveOptions;
	
	public static final @NonNull String RIGHT_MODEL_TYPE_NAME = "rightAS";
	public static final @NonNull String LEFT_MODEL_TYPE_NAME = "leftCS";
	
	public OCL2QVTp(@NonNull EnvironmentFactory envFact, @NonNull String traceabilityPropName) {
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
			URI outputURI = oclDocURI.trimFileExtension().trimFileExtension().appendFileExtension("qvtp.qvtcas");
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
		
		iModel.setExternalURI(oclModel.getExternalURI().replace(".ocl", ".qvtp.qvtcas")); // When the externalURI is set, also is its name
		iModel.getOwnedImports().addAll(oclModel.getOwnedImports().stream()
				.map(importToImport())
				.collect(Collectors.toList()));
		
		Package pPackage = PivotFactory.eINSTANCE.createPackage();
		pPackage.setName("");
		iModel.getOwnedPackages().add(pPackage);
		
		Transformation pTx = QVTbaseFactory.eINSTANCE.createTransformation();
		pTx.setName(iModel.getName().replace('.', '_')); // FIXME . as part of the name is causing issues in the CG);
		pPackage.getOwnedClasses().add(pTx);
		
		List<Package> importedPackges = new ArrayList<Package>();
		for (Namespace ns : iModel.getOwnedImports().stream()
							.map(x -> x.getImportedNamespace())
							.collect(Collectors.toList())) {
			if (ns instanceof Model) {
				importedPackges.addAll(((Model)ns).getOwnedPackages());
			} else if (ns instanceof Package) {
				importedPackges.add((Package) ns);
			} else {
				logger.warning("imported namespace not recognised: " + ns.getName());
			}
		}
		
		leftTypedModel.setName(LEFT_MODEL_TYPE_NAME);
		leftTypedModel.getUsedPackage().add(
				importedPackges.stream()
				.filter(p -> p.getName().equals(getExpressionContextType().apply(shadowExps.get(0)).getOwningPackage().getName()))
				.findFirst().get());
		pTx.getModelParameter().add(leftTypedModel);
		
		rightTypedModel.setName(RIGHT_MODEL_TYPE_NAME);
		rightTypedModel.getUsedPackage().add(
				importedPackges.stream()
				.filter(p -> p.getName().equals(shadowExps.get(0).getType().getOwningPackage().getName()))
				.findFirst().get());
		pTx.getModelParameter().add(rightTypedModel);
		
		pTx.getRule().addAll(shadowExps.stream()
				.filter(shadowExpToCreationMappingGuard())
				.map(shadowExpToCreationMapping())
				.collect(Collectors.toList()));
		
		pTx.getRule().addAll(shadowParts.stream()
				.filter(shadowPartToUpdateMappingGuard())
				.map(shadowPartToUpdateMapping())
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
			
			GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			mapping.setGuardPattern(guardPattern);
			mapping.setBottomPattern(bottomPattern);
			
			PropertyAssignment pAssignment = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			VariableExp value = PivotFactory.eINSTANCE.createVariableExp();
			value.setReferredVariable(rightDomain.getBottomPattern().getRealizedVariable().get(0));
			value.setType(value.getReferredVariable().getType());
			
			VariableExp slotExpression = PivotFactory.eINSTANCE.createVariableExp();
			slotExpression.setReferredVariable(leftVar);
			slotExpression.setType(slotExpression.getReferredVariable().getType());
			
			pAssignment.setValue(value);
			pAssignment.setSlotExpression(slotExpression);
			pAssignment.setTargetProperty(getTraceabilityProperty(slotExpression.getType()));
			
			bottomPattern.getAssignment().add(pAssignment);
			updateGuardPattern(shadowExp, guardPattern, leftVar);
			
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
			CoreDomain rightDomain = createUpdateMapping_RightDomain(shadowExp);
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
			
			TypeExp argTypeExp = PivotFactory.eINSTANCE.createTypeExp();
			argTypeExp.setReferredType(shadowExp.getType());
			argTypeExp.setType(getOclMetaClass());
			
			asTypeOpCallExp.getOwnedArguments().add(argTypeExp);
			
			PropertyAssignment pAssignment = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			pAssignment.setTargetProperty(refProp);
			pAssignment.setValue(createPropertyAssignmentValue(shadowPart, leftVar));
			pAssignment.setSlotExpression(asTypeOpCallExp);
			
			GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
			BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
			mapping.setGuardPattern(guardPattern);
			mapping.setBottomPattern(bottomPattern);
			
			bottomPattern.getAssignment().add(pAssignment);
			
			updateGuardPattern(shadowExp,  guardPattern, leftVar);
			return mapping;
		};
	}
	
	
	private CoreDomain createCreationMapping_LeftDomain(ShadowExp shadowExp) {
		
		Class contextType = getExpressionContextType().apply(shadowExp);
		CoreDomain domain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		domain.setTypedModel(leftTypedModel);
		domain.setIsCheckable(true);
		
		GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		domain.setGuardPattern(guardPattern);
		domain.setBottomPattern(bottomPattern);
		
		Variable variable = PivotFactory.eINSTANCE.createVariable();
		variable.setName("l"+firstToUpperCase().apply(contextType.getName()));
		variable.setType(contextType);
		
		guardPattern.getVariable().add(variable);
		
		return domain;
	}
	
	private CoreDomain createCreationMapping_RightDomain(ShadowExp shadowExp) {

		Class constructedType = shadowExp.getType();
		CoreDomain domain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		domain.setTypedModel(rightTypedModel);
		domain.setIsEnforceable(true);
		
		GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		domain.setGuardPattern(guardPattern);
		domain.setBottomPattern(bottomPattern);
		
		RealizedVariable variable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		variable.setName("r"+firstToUpperCase().apply(constructedType.getName()));
		variable.setType(constructedType);
		
		bottomPattern.getRealizedVariable().add(variable);
		return domain;
	}
	
	private CoreDomain createUpdateMapping_LeftDomain(ShadowExp shadowExp) {
		// It's exactly the same domain as we have for the creation mappings
		return createCreationMapping_LeftDomain(shadowExp);
	}
	
	private CoreDomain createUpdateMapping_RightDomain(ShadowExp shadowExp) {
		CoreDomain domain = QVTcoreBaseFactory.eINSTANCE.createCoreDomain();
		domain.setTypedModel(rightTypedModel);
		domain.setIsEnforceable(true);
		
		GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		domain.setGuardPattern(guardPattern);
		domain.setBottomPattern(bottomPattern);
		
		return domain;
	}
	
	private OCLExpression createPropertyAssignmentValue(ShadowPart shadowPart, Variable leftVar) {
		
		// FIXME what happens with synthetised types ????
		OCLExpression initExp = shadowPart.getOwnedInit();
		OCLExpression newInitExp = EcoreUtil.copy(initExp);
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
				
				TypeExp argTypeExp = PivotFactory.eINSTANCE.createTypeExp();
				argTypeExp.setReferredType(castType);
				argTypeExp.setType(getOclMetaClass());
				
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
	
	/*private List<OperationCallExp> getAstCalls(ShadowPart shadowPart) {
		return getAllContentsIncludingSelf().apply(shadowPart.getOwnedInit())
			.filter(isAstOpCallExp())
			.map(OperationCallExp.class::cast)
			.collect(Collectors.toList());
	}*/
	
	private @NonNull Property getTraceabilityProperty(Type type) {
		Class aClass = type.isClass();
		assert(aClass != null);
		Set<Class> allClasses = getSuperClasses().apply(aClass);
		allClasses.add(aClass);
		return allClasses.stream()
			.flatMap(x -> x.getOwnedProperties().stream())
			.filter(x -> traceabilityPropName.equals(x.getName()))
			.findFirst().get();
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
	
}