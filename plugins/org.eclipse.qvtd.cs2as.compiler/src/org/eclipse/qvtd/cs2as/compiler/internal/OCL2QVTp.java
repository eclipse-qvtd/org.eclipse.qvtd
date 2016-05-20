package org.eclipse.qvtd.cs2as.compiler.internal;

import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.firstToUpperCase;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContainers;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContents;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getAllContentsIncludingSelf;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getCreationMappingName;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getExpressionContextType;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getModel;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getOwningPackage;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getSuperClasses;
import static org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTpUtil.getUpdateMappingName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipse.ocl.pivot.ids.PackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
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

	private static class ClonsMap {
		
		private static class ImportKey {
			
			private Import anImport;
			
			public ImportKey (Import anImport) {
				this.anImport = anImport;
			}
			
			@Override
			public String toString() {
				// FIXME we may want to distinguish between Package and Model imports
				return getModel().apply(anImport.getImportedNamespace()).toString();
			}
			
			@Override
			public int hashCode() {
				return toString().hashCode();
			}
			
			@Override
			public boolean equals(Object obj) {
				if (obj instanceof ImportKey) {
					return obj.toString().equals(toString());
				}
				return super.equals(obj);
			}
		}
		
		private Model newModel;
		private Map<PackageId, Package> p2p = new HashMap<PackageId,Package>();
		private Map<TypeId, Class> c2c = new HashMap<TypeId,Class>();
		private Map<Operation, Operation> o2o = new HashMap<Operation,Operation>();
		private Map<ImportKey, Import> i2i = new HashMap<ImportKey,Import>();
		
		public ClonsMap(Model newModel) {
			this.newModel = newModel;
			for (Import anImport : newModel.getOwnedImports()) { // We introduce the newModel ownedImports as if they were clonned to avoid duplications
				ImportKey importKey = new ImportKey(anImport);
				i2i.put(importKey,anImport);
			}
		}
		
		@NonNull
		public Operation getNewOperation(Operation oldOperation) { 
		
			Operation id = oldOperation;
			Operation newOp = o2o.get(id);
			if (newOp == null) { // If not cloned yet
				newOp = EcoreUtil.copy(oldOperation); // NB self variable should be copied
				o2o.put(id,newOp);
				Class newClass = getNewClass(oldOperation.getOwningClass());
				newClass.getOwnedOperations().add(newOp);
			}
			return newOp;
		}
		
		@Nullable
		public Operation getCachedOperation(Operation oldOperation) {
			Operation op = o2o.get(oldOperation);
			assert(op != null);
			return op; 
		}
		
		@NonNull
		private Class getNewClass(Class oldClass) { 
			
			TypeId id = oldClass.getTypeId();
			Class newClass = c2c.get(id);
			if (newClass == null) { // If not cloned yet
				newClass = EcoreUtil.copy(oldClass);
				newClass.getOwnedOperations().clear(); // We remove all operations. They we will be manually cloned
				c2c.put(id,newClass);
				Package newPackage = getNewPackage(oldClass.getOwningPackage());
				newPackage.getOwnedClasses().add(newClass);
			}
			return newClass;
		}		
		
		
		@NonNull
		private Package getNewPackage(Package oldPackage) { 
			
			PackageId id = oldPackage.getPackageId();
			Package newPackage = p2p.get(id);
			if (newPackage == null) { // If not cloned yet
				newPackage = PivotFactory.eINSTANCE.createPackage();
				newPackage.setName(oldPackage.getName());
				newPackage.setURI(oldPackage.getURI());
				newPackage.setNsPrefix(oldPackage.getNsPrefix());
				p2p.put(id,newPackage);
				newModel.getOwnedPackages().add(newPackage);
			}
			return newPackage;
		}	
		
		@NonNull
		public Import getNewPackageImport(Import anImport) {
			
			ImportKey importKey = new ImportKey(anImport);
			Import newImport = i2i.get(importKey);
			if (newImport == null) {
				newImport = EcoreUtil.copy(anImport);
				i2i.put(importKey, newImport);
				newModel.getOwnedImports().add(newImport);
			}
			return newImport;
		}
	}
	private @NonNull Logger logger = Logger.getLogger(getClass().getName());
	private @NonNull EnvironmentFactory envFact;
	private @NonNull String traceabilityPropName;
	private @Nullable Map<?,?> saveOptions;
	private Operation oclAsTypeOp;
	//private Operation oclAnyEqualsOp;
	private Operation notOp;
	
	public static final @NonNull String RIGHT_MODEL_TYPE_NAME = "rightAS";
	public static final @NonNull String LEFT_MODEL_TYPE_NAME = "leftCS";
	
	public OCL2QVTp(@NonNull EnvironmentFactory envFact, @NonNull String traceabilityPropName) {
		this.envFact = envFact;
		this.traceabilityPropName = traceabilityPropName;
		this.oclAsTypeOp = getOclAnyOclAsTypeOp();
	//	this.oclAnyEqualsOp = getOclAnyEqualsOp();
		this.notOp = getBooleanNotOp();
	}
	
	public Resource run(ResourceSet resourceSet, URI oclDocURI, List<URI> extendedURIs) {
		return run(resourceSet, oclDocURI, extendedURIs,true); 
	}
	
	/**
	 * @param resourceSet
	 * @param oclDocURI
	 * @param selfContainedTransformation <code>true</code> if any referred OCL operation (from imported OCL docs) should be cloned in the new QVT transformation
	 * @return
	 */
	public Resource run(ResourceSet resourceSet, URI oclDocURI, List<URI> extendedURIs, boolean selfContainedTransformation) {
		
		if (!"oclas".equals(oclDocURI.fileExtension())) {
			throw new IllegalArgumentException(oclDocURI.toString() + " is not an .oclas URI");
		}
		Resource input = resourceSet.getResource(oclDocURI, true);
		EObject rootModel = input.getContents().get(0);
		if (rootModel instanceof Model) {
			Model model = (Model) rootModel;
			CoreModel outputModel = oclModelToImperativeModel(selfContainedTransformation).apply(model);
			
			// We create the output resource
			URI outputURI = oclDocURI.trimFileExtension().trimFileExtension().appendFileExtension("qvtp.qvtcas");
			Resource outputResource = resourceSet.createResource(outputURI);
			outputResource.getContents().add(outputModel);
			if (selfContainedTransformation) {
				ClonsMap copyHelper = cloneImportedOperationsAndEcoreImports(model, outputModel, extendedURIs);
				updateOpCallExpressions(outputModel, copyHelper);
			}
			return outputResource;
		
		} else {
			throw new IllegalArgumentException(oclDocURI.toString() + " doesn't contain an OCL Model");
		}
	}
	
	private TypedModel leftTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
	private TypedModel rightTypedModel = QVTbaseFactory.eINSTANCE.createTypedModel();
	
	public Function<Model, CoreModel> oclModelToImperativeModel(boolean selfContainedTransf) {
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
				.filter(importToImportGuard(selfContainedTransf))
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
		return iModel;
		};
	}
	
	// When we have a selfContainedTransf, we want to skip those imports related to .ocl documents
	protected Predicate<@NonNull Import> importToImportGuard(boolean selfContainedTransf) {
		return oclImport -> {
			if (selfContainedTransf &&
				isOclDocImport().test(oclImport)) {
				return false;
			}
			return true;
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
			asTypeOpCallExp.setReferredOperation(oclAsTypeOp);
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

	
	private  ClonsMap cloneImportedOperationsAndEcoreImports(Model oldModel, Model newModel, List<URI> extendedASURIs) {
		
		Model newOCL = PivotFactory.eINSTANCE.createModel();
		URI newOCLURI = URI.createURI(newModel.getExternalURI()).appendFileExtension("oclas");
		newOCL.setExternalURI(newOCLURI.toString());
		
		ClonsMap clonsMap = new ClonsMap(newOCL);
		doCloneImportedOperationsAndImports(oldModel, clonsMap, new HashSet<Model>(), extendedASURIs);
		updateOpCallExpressions(newOCL, clonsMap);
		
		Import newOCLimport = PivotFactory.eINSTANCE.createImport();
		newOCLimport.setImportedNamespace(newOCL);
		newModel.getOwnedImports().add(newOCLimport);
		
		Resource resource = envFact.getMetamodelManager().getASResourceSet().createResource(newOCLURI);
		resource.getContents().add(newOCL);
		try {
			resource.save(saveOptions);
		} catch (IOException e) {
			logger.severe("qvtp.qvtcas.ocl OCL file could not be saved");
		}
		
		return clonsMap;
	}
	
	private void doCloneImportedOperationsAndImports(Model oldModel, ClonsMap clonsMap, Set<Model> visitedModels, List<URI> extendedASURIs) {
		
		if (!visitedModels.contains(oldModel)) {
			visitedModels.add(oldModel);
			for (Import anImport : oldModel.getOwnedImports()) {
				if (isOclDocImport().test(anImport)
					&& ! isExtendedCS2ASImport(extendedASURIs).test(anImport)) {
					Model model = getModel().apply(anImport.getImportedNamespace());
					for (Package p : model.getOwnedPackages()) {
						for (Class c : p.getOwnedClasses()) {
							for (Operation o : c.getOwnedOperations()) {
								clonsMap.getNewOperation(o);
							}
						}
					}
					doCloneImportedOperationsAndImports(model,clonsMap,visitedModels, extendedASURIs);
				} else if (isEcoreDocImport().test(anImport)) {
					clonsMap.getNewPackageImport(anImport);
				}
			}
		}
	}
	
	private void updateOpCallExpressions(Model newModel, ClonsMap copyHelper) {
		
		for (Package p : newModel.getOwnedPackages()) {
			for (Class c : p.getOwnedClasses()) {
				for (Operation o : c.getOwnedOperations()) {
					TreeIterator<EObject> contents = o.eAllContents();
					while (contents.hasNext()) {
						EObject eObject = contents.next();
						if (eObject instanceof OperationCallExp) {
							OperationCallExp opCallExp = (OperationCallExp) eObject;
							if (isAstOpCallExp().test(opCallExp)) {
								EcoreUtil.replace(opCallExp, rewriteAstOperationCallAsTypeCastedPropertyCall(opCallExp));
							} else {
								updateOpCallExpression(opCallExp, copyHelper);
							}
						}
					}
				}
				if (c instanceof Transformation) {
					Transformation t = (Transformation) c;
					for (Rule r : t.getRule()) {
						TreeIterator<EObject> contents = r.eAllContents();
						while (contents.hasNext()) {
							EObject eObject = contents.next();
							if (eObject instanceof OperationCallExp) {
								updateOpCallExpression((OperationCallExp) eObject, copyHelper);
							}
						}
					}
				}
			}
		}

	}
	
	private void updateOpCallExpression(OperationCallExp opCallExp, ClonsMap copyHelper) {
		Operation oclOp = opCallExp.getReferredOperation();
		if (isOclDocOp().test(oclOp) // We are only interested in ops belonging to a model corresponding to an Ocl Doc
			&& !refersToContainingOperation().test(opCallExp)) { // and opCallExps that do not refer to operations that contains them
			Operation newOp = copyHelper.getCachedOperation(oclOp);
			opCallExp.setReferredOperation(newOp);
		}
	}
	private OCLExpression doReplacements(OCLExpression oclExp, Variable leftVar) {
		
		List<OCLExpression> result = new ArrayList<OCLExpression>();// Simple work aroound to the forEach constraint ;
		result.add(oclExp);
		getAllContentsIncludingSelf().apply(oclExp).forEach(x -> {
			if (isSelfVarExp().test(x)) {
				((VariableExp)x).setReferredVariable(leftVar);
			} else if(isAstOpCallExp().test(x)) {
				OperationCallExp exp = (OperationCallExp) x;
				OperationCallExp asTypeOpCallExp = rewriteAstOperationCallAsTypeCastedPropertyCall(exp);
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
	
	private OperationCallExp rewriteAstOperationCallAsTypeCastedPropertyCall(OperationCallExp astOpCallExp) {
		PropertyCallExp astPropCallExp = PivotFactory.eINSTANCE.createPropertyCallExp();
		OCLExpression tmp = astOpCallExp.getOwnedSource();
		astOpCallExp.setOwnedSource(null);
		astPropCallExp.setOwnedSource(tmp);
		astPropCallExp.setReferredProperty(getTraceabilityProperty(astPropCallExp.getOwnedSource().getType()));
		astPropCallExp.setType(astPropCallExp.getReferredProperty().getType());
		// Copying remaining changeable OpCallExp properties (excepting ownedArguments and referredOperation)
		astPropCallExp.setTypeValue(astOpCallExp.getTypeValue());
		astPropCallExp.getOwnedComments().addAll(astOpCallExp.getOwnedComments());
		astPropCallExp.getOwnedExtensions().addAll(astOpCallExp.getOwnedExtensions());
		astPropCallExp.setName(astOpCallExp.getName());
		astPropCallExp.setIsSafe(astOpCallExp.isIsSafe());
		astPropCallExp.setIsRequired(astOpCallExp.isIsRequired());
		astPropCallExp.setIsImplicit(astOpCallExp.isIsImplicit());
		astPropCallExp.setIsPre(astOpCallExp.isIsPre());
		// end of copy
		
		Type castType = astOpCallExp.getType();
		OperationCallExp asTypeOpCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		asTypeOpCallExp.setOwnedSource(astPropCallExp);
		asTypeOpCallExp.setReferredOperation(oclAsTypeOp);
		asTypeOpCallExp.setType(castType);
		asTypeOpCallExp.setIsSafe(astPropCallExp.isIsSafe());
		
		TypeExp argTypeExp = PivotFactory.eINSTANCE.createTypeExp();
		argTypeExp.setReferredType(castType);
		argTypeExp.setType(getOclMetaClass());
		
		asTypeOpCallExp.getOwnedArguments().add(argTypeExp);
		return asTypeOpCallExp;
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
			notOpCallExp.setReferredOperation(notOp);
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
	
	private Predicate<Operation> isOclDocOp() { 
		return element -> {
			Model model = getModel().apply(element);
			if (model == null) {
				return false;
			} else {
				return isOclModel().test(model);
			}
		};
	}
	
//	private Predicate<Operation> isOclLibOp() { 
//		return element -> {
//			Class pClass = element.getOwningClass();
//			if (pClass == null) return false;
//			Package pPackage = pClass.getOwningPackage();
//			if (pPackage == null) return false;
//			return OCLstdlibPackage.eNS_URI.equals(pPackage.getURI());
//		};
//	}
	
	private Predicate<@NonNull Import> isOclDocImport() {
		return element -> {
			Namespace referredNamespace = element.getImportedNamespace();
			if (referredNamespace instanceof Model) {
				Model model = (Model) referredNamespace;
				return isOclModel().test(model);
			}
			return false;
		};
	}
	
	private Predicate<@NonNull Model> isOclModel() {
		return element -> {
			URI extURI = URI.createURI(element.getExternalURI());
			if ("oclas".equals(extURI.fileExtension())
				|| "ocl".equals(extURI.fileExtension())
				|| "qvtcas".equals(extURI.fileExtension())) {
				return true;
			} else {
				return false;
			}
		};
	}
	
	private Predicate<@NonNull Import> isEcoreDocImport() {
		return element -> {
			Namespace ns = element.getImportedNamespace();
			if (ns instanceof Package) {
				ns = getModel().apply(ns);
			}
			if (ns instanceof Model) {
				Model model = (Model) ns;
				return isEcoreModel().test(model);
			}
			return  false;
		};
	}
	
	private Predicate<@NonNull Model> isEcoreModel() {
		return element -> {
			URI extURI = URI.createURI(element.getExternalURI());
			if ("ecore".equals(extURI.fileExtension())
				|| "ecoreas".equals(extURI.fileExtension())) {
				return true;
			} else {
				return false;
			}
		};
	}
	 
	private Predicate<@NonNull Import> isExtendedCS2ASImport(List<URI> extendedASURIs) {
		return element -> {
			if (!isOclDocImport().test(element) || extendedASURIs.isEmpty()) {
				return false;
			}
			URI importURI = URI.createURI(getModel().apply(element.getImportedNamespace()).getExternalURI());
			if (!"oclas".equals(importURI.fileExtension())) {
				importURI = importURI.appendFileExtension("oclas");	// We are interested in OCL AS uris	
			}
			return extendedASURIs.contains(importURI);
		};
	}
	
	private Predicate<OperationCallExp> refersToContainingOperation() {
		return element -> {
			EObject container = element.eContainer();
			while (container != null) {
				if (container instanceof Operation) {
					Operation containingOp = (Operation) container;
					return containingOp.equals(element.getReferredOperation());
				}
				container = container.eContainer();
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
		Set<Class> allClasses = getSuperClasses().apply(aClass);
		allClasses.add(aClass);
		return allClasses.stream()
			.flatMap(x -> x.getOwnedProperties().stream())
			.filter(x -> traceabilityPropName.equals(x.getName()))
			.findFirst().get();
	}
	

//	private @NonNull Operation getOclAnyEqualsOp() {
//		return envFact.getStandardLibrary().getOclAnyType().getOwnedOperations().stream()
//			.filter(x -> "=".equals(x.getName()))
//			.findFirst().get();
//	}
	
	private @NonNull Class getOclMetaClass() { 
		return envFact.getStandardLibrary().getClassType();
	}
	
	private @NonNull Operation getOclAnyOclAsTypeOp() {
		return envFact.getStandardLibrary().getOclAnyType().getOwnedOperations().stream()
			.filter(x -> "oclAsType".equals(x.getName()))
			.findFirst().get();
	}
	
	private @NonNull Class getBooleanPrimitiveType() {
		return envFact.getStandardLibrary().getBooleanType();
		
	}
	
	private @NonNull Operation getBooleanNotOp() {
		return envFact.getStandardLibrary().getBooleanType().getOwnedOperations().stream()
				.filter(x -> "not".equals(x.getName()))
				.findFirst().get();
	}
	
	private Predicate<OCLExpression> isBooleanNotOpCallExp() {
		return exp -> {
			return exp instanceof OperationCallExp &&
					((OperationCallExp)exp).getReferredOperation() == notOp;
		};
	}
	
}
