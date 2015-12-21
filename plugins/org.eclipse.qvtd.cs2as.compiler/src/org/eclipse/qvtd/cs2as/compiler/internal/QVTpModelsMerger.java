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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class QVTpModelsMerger {

	
	/**
	 * <p>
	 * Utility to merge the QVTp models result of the OCL2QVTp transformation on different CS2AS descriptions.
	 * </p>
	 * 
	 * <ul>
	 * The merge utility will simply consist of:
	 * <li> Merging all the qvtp {@link Mapping mappings} in one qvtp {@link Transformation transformation} </li>
	 * <li> Merging all the {@link Import imports} in the containing qvtp {@link ImperativeModel model}, taking care of import duplications </li>
	 * </ul>
	 *   
	 * @param qvtpModels a list of the QVTp models to merge
	 * @return a clone of the first QVTp model of the provided list, having merged the remaining QVTp models of that list  
	 */
	public static PivotModel merge(EnvironmentFactory envF, List<PivotModel> qvtpModels) {
		
		PivotModel firstModel = qvtpModels.get(0);
		ImperativeModel qvtpModel = getImperativeModel(firstModel);
		Map<Class, List<Mapping>> inputType2RefiningMapping = getRefiningMappingInputTypes(qvtpModel);
		for (int i=1; i < qvtpModels.size(); i++) {
			doMerge(envF, qvtpModel, getImperativeModel(qvtpModels.get(i)), inputType2RefiningMapping);
		}
		
		return firstModel;
		
	}
	
	private static Map<Class, List<Mapping>> getRefiningMappingInputTypes(ImperativeModel qvtpModel) {
		
		Map<Class, List<Mapping>> result = new HashMap<Class, List<Mapping>>();
		Package _package = qvtpModel.getOwnedPackages().get(0);
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
	 * @param resultQVTpModel
	 * @param mergedQVTpModel
	 * @param refMapInputTypes a list of the types involved in the mappings of the extending QVTp model
	 */
	private static void doMerge(EnvironmentFactory envF, ImperativeModel resultQVTpModel, ImperativeModel mergedQVTpModel, Map<Class, List<Mapping>> inputType2RefiningMapping) {
		
		// Imports
		Set<Namespace> alreadyImportedNamespaces = new HashSet<Namespace>();
		Set<Import> importsToRemove = new HashSet<Import>();
		for (Import _import : resultQVTpModel.getOwnedImports()) {
			Namespace importedNS = _import.getImportedNamespace();
			alreadyImportedNamespaces.add(importedNS);
			if (doesNamespaceCorrespondToMergedQVTpModel(mergedQVTpModel, importedNS)) {
				importsToRemove.add(_import);
			}
		}
		// Add a copy of the imported NS
		for (Import _import : mergedQVTpModel.getOwnedImports()) {
			Namespace importedNS = _import.getImportedNamespace();
			if (!alreadyImportedNamespaces.contains(importedNS)) {
				resultQVTpModel.getOwnedImports().add(EcoreUtil.copy(_import));
			}
		}
		
		for (Import _import : importsToRemove) {
			resultQVTpModel.getOwnedImports().remove(_import);
		}

		// Mapping rules
		Transformation resultTransformation = getTransformation(resultQVTpModel);
		Transformation mergedTransformation = getTransformation(mergedQVTpModel);
		EList<Rule> resultRules = resultTransformation.getRule();
		for (Rule rule : mergedTransformation.getRule()) {
			Mapping baseRule = (Mapping) EcoreUtil.copy(rule);
			refactorMapping(envF, baseRule, inputType2RefiningMapping);
			resultRules.add(baseRule);
		}
	}
	
	private static boolean doesNamespaceCorrespondToMergedQVTpModel(ImperativeModel mergedQVTpModel, Namespace ns) {
		
		if (ns instanceof Model && isAnOCLModel(ns)) { 
			URI qvtpModelURI = URI.createURI(mergedQVTpModel.getExternalURI());
			assert assertCorrectQVTpModelFileExtenion(qvtpModelURI);
			URI importedNSURI = URI.createURI(((Model) ns).getExternalURI());
			String fileName1 = qvtpModelURI.trimFragment().trimFileExtension().trimFileExtension().lastSegment(); // xxx.qvtp.qvias
			String fileName2 = importedNSURI.trimFragment().trimFileExtension().trimFileExtension(). lastSegment();	// xxx.ocl or xxx.ocl.oclas
			return fileName1.equals(fileName2);
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

	private static Transformation getTransformation(ImperativeModel iModel) {
				

	    for (org.eclipse.ocl.pivot.Package aPackage : iModel.getOwnedPackages()) {
	    	for (org.eclipse.ocl.pivot.Class aClass : aPackage.getOwnedClasses()) {
	    		if (aClass instanceof Transformation) {
	    			return (Transformation) aClass;
	    		}	
	    	}
	    }
		
		throw new IllegalStateException(MessageFormat.format("The QVTd model '{0}' does not have a Transformation element.", iModel.getExternalURI()));
	}
	
	private static ImperativeModel getImperativeModel(PivotModel qvtpModel) {
		
		Resource modelImpl = qvtpModel.getResource();
		for (EObject eContent : modelImpl.getContents()) {
			if (eContent instanceof ImperativeModel) {
				return (ImperativeModel) eContent;
			}
		}
		throw new IllegalStateException(MessageFormat.format("The QVTd model '{0}' does not have an ImperativeModel element.", modelImpl.getURI()));
	}
	
	private static boolean assertCorrectQVTpModelFileExtenion(URI qvtpModelURI ) {
		
		assert qvtpModelURI.fileExtension().equals("qvtias");
		assert qvtpModelURI.trimFileExtension().fileExtension().equals("qvtp");
		return true;
	}
	
	private static void refactorMapping (EnvironmentFactory envF, Mapping mappingToRefactor, Map<Class, List<Mapping>> inputType2extendingMapping) {
		
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
						//This point should never be reached given the mapping naming convention introduced in OCL2QVTp.
						throw new IllegalStateException("This point should never be reached given the mapping naming convention introduced in OCL2QVTp."); 
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
		refiningMapping.setOverrides(mappingToRefactor);
	}
	
	private static Variable getInputVariable(Mapping mapping) {		
		// In OCL2QVTp the first one is always the input domain with a unique input variable
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
