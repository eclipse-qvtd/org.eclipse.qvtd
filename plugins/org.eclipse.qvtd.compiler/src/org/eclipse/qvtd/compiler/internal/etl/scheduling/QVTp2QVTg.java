package org.eclipse.qvtd.compiler.internal.etl.scheduling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleFactory;

public class QVTp2QVTg {
	
	private Schedule dg; 
	
	private Set<Variable> mappingsVariables = new HashSet<Variable>();
	
	// Caches
	private Map<Class, ClassDatum> class2datum = new HashMap<>();

	
	private Map<Element, DomainUsage> duAnalysis;
	private ClassRelationships cRels;
	
	private void clearCaches() {
		class2datum.clear();
		mappingsVariables.clear();
	}
	
	private void computeInitialCaches(Transformation tx) {
				
		TreeIterator<EObject> it =  tx.eAllContents();
		while (it.hasNext()) {
			EObject eObj = it.next();
			if (eObj instanceof Variable) {
				EObject container = eObj.eContainer();
				if (container instanceof CorePattern) {
					mappingsVariables.add((Variable) eObj);
				}
			}
		}
	}
	public void run(@NonNull Resource qvtpModel, @NonNull Resource qvtsModel,
				@NonNull ClassRelationships cRels, @NonNull Map<Element, DomainUsage> duAnalysis) {
		clearCaches();
		this.cRels = cRels;
		this.duAnalysis = duAnalysis;
		
		dg = ScheduleFactory.eINSTANCE.createSchedule();
				
		ImperativeModel iModel = (ImperativeModel) qvtpModel.getContents().get(0);
		Package txPackage = iModel.getOwnedPackages().get(0);
		Transformation tx = (Transformation) txPackage.getOwnedClasses().get(0);
		
		computeInitialCaches(tx);
		for (Rule rule : tx.getRule()) {
			createMappingAction((Mapping) rule);
		}
		
		// We add the result to the output result
		qvtsModel.getContents().clear();
		qvtsModel.getContents().add(dg);
	}
	
	protected MappingAction createMappingAction(Mapping mapping) {
		
		MappingAction ma = ScheduleFactory.eINSTANCE.createMappingAction();
		
		ma.setSchedule(dg);
		ma.setMapping(mapping);
		
		for (Variable inputVar : getInputVariables(mapping)) {
			ma.getParameters().add(createDataParameter(inputVar));
			ma.getRequisites().add(getClassDatum((Class)inputVar.getType()));

		}
		
		for (RealizedVariable outputVar : getOutputVariables(mapping)) {
			ma.getResults().add(createDataParameter(outputVar));
			ma.getProductions().add(getClassDatum((Class)outputVar.getType()));
		}
		
		for (NavigationCallExp propRead : getPropertyNavigations(mapping)){
			ma.getRequisites().add(getPropertyDatum(propRead));
		}
		
		for (PropertyAssignment propWrite : getPropertyAssignments(mapping)){
			ma.getProductions().addAll(getPropertyDatum(propWrite));
			
		}
		
		for (OperationCallExp opCall : getOperationCallExps(mapping)) {
			Class context = getContextType(opCall);
			ma.getRequisites().addAll(getPropertyDatums(opCall, context, new HashMap<Class, Set<Operation>>(), new HashMap<Variable, Set<Class>>()));
		}
		
		return ma;
	}
	
	

	protected DataParameter createDataParameter(Variable variable) {
		
		DataParameter dp = ScheduleFactory.eINSTANCE.createDataParameter();
		dp.setVariable(variable);
		dp.setDatum(getClassDatum((Class)variable.getType()));		
		// FIXME Domain usage ?
		// DomainUsage du = duAnalysis.getUsage(variable);
		//dp.getDatum().setDomain(du == null ? null : du.getTypedModel());
		return dp;
	}
	
	@NonNull
	protected ClassDatum createClassDatum(Class aClass) {
		
		Set<Variable> var = getCorePatternVariables(aClass);
		CoreDomain domain = var.isEmpty() ? null : (CoreDomain)getOpposittePattern(var.iterator().next()).getArea();
				
		ClassDatum cDatum = ScheduleFactory.eINSTANCE.createClassDatum();
		cDatum.setSchedule(dg);
		cDatum.setType(aClass);
		cDatum.setDomain(domain); //(domain == null ? null : domain.getTypedModel());
		for (Class superClass : aClass.getSuperClasses()) {
			ClassDatum superCDatum = getClassDatum(superClass);
			cDatum.getSuper().add(superCDatum);
		}
		
		return cDatum;
	}
	
	@NonNull
	protected ClassDatum getClassDatum(Class aClass) {
		
		ClassDatum cDatum = class2datum.get(aClass);
		if (cDatum == null) {
			cDatum = createClassDatum(aClass);
			class2datum.put(aClass, cDatum);
		}
		return cDatum;
	}

	@NonNull
	protected PropertyDatum createPropertyDatum(Class context, Property property) {
		
		PropertyDatum pDatum = ScheduleFactory.eINSTANCE.createPropertyDatum();
		ClassDatum classDatum = getClassDatum(context);
		pDatum.setDomain(classDatum.getDomain());
		pDatum.setProperty(property);
		pDatum.setClassDatum(classDatum);
		if (context != property.getOwningClass()) {
			for (Class superClass : context.getSuperClasses()) {
				PropertyDatum superPropDatum = getPropertyDatum(superClass, property);
				pDatum.getSuper().add(superPropDatum);
			}
			
		}
		return pDatum;
	}
	
	@NonNull
	protected PropertyDatum getPropertyDatum(Class context, Property property) {
		ClassDatum cDatum = getClassDatum(context);
		for (PropertyDatum pDatum : cDatum.getPropertyDatums()) {
			if (pDatum.getProperty().equals(property)) {
				return pDatum;
			}
		}
		// If not found we create it
		return createPropertyDatum(context, property);
	}
	
	
	protected List<Variable> getInputVariables(Mapping mapping) {

		List<Variable> mInputVars = new ArrayList<Variable>();
		mInputVars.addAll(mapping.getGuardPattern().getVariable());
	
		for (Domain domain : mapping.getDomain()) {
			CoreDomain cDomain = (CoreDomain) domain;
			mInputVars.addAll(cDomain.getGuardPattern().getVariable());
		}
		
		// TODO what about refinements ?
		return mInputVars;
	}
	
	protected List<RealizedVariable> getOutputVariables(Mapping mapping) {
		List<RealizedVariable> mOutputVars = new ArrayList<RealizedVariable>();
		mOutputVars.addAll(mapping.getBottomPattern().getRealizedVariable());
		
		for (Domain domain : mapping.getDomain()) {
			CoreDomain cDomain = (CoreDomain) domain;
			mOutputVars.addAll(cDomain.getBottomPattern().getRealizedVariable());
		}	
		
		// TODO what about refinements ?
		return mOutputVars;
	}
	
	
	// Property datum analysis
	
	protected List<NavigationCallExp> getPropertyNavigations(Mapping mapping) {
		List<NavigationCallExp> propReads = new ArrayList<NavigationCallExp>();
		TreeIterator<EObject> it =  mapping.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof NavigationCallExp) {
				propReads.add((NavigationCallExp) eObject);
			}
		}
		return propReads;
	}

	protected List<PropertyAssignment> getPropertyAssignments(Mapping mapping) {
		List<PropertyAssignment> propWrites = new ArrayList<PropertyAssignment>();
		TreeIterator<EObject> it =  mapping.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof PropertyAssignment) {
				propWrites.add((PropertyAssignment) eObject);
			}
		}
		return propWrites;
	}
	
	protected List<OperationCallExp> getOperationCallExps(Mapping mapping) {
		List<OperationCallExp> propReads = new ArrayList<OperationCallExp>();
		TreeIterator<EObject> it =  mapping.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof OperationCallExp) {
				propReads.add((OperationCallExp) eObject);
			}
		}
		return propReads;
	}
	
	
	@NonNull
	protected PropertyDatum getPropertyDatum(NavigationCallExp navCallExp) {
		
		Class context = (Class) navCallExp.getOwnedSource().getType();
		return getPropertyDatum(navCallExp, context );
	}
	
	@NonNull
	protected PropertyDatum getPropertyDatum(NavigationCallExp navCallExp, Class context) {
		
		Property property = null;
		if (navCallExp instanceof PropertyCallExp) {
			property = ((PropertyCallExp) navCallExp).getReferredProperty();
		} else if (navCallExp instanceof OppositePropertyCallExp) {
			property = ((OppositePropertyCallExp) navCallExp).getReferredProperty().getOpposite();		
		} else {
			throw new IllegalStateException("Kind of NavigationCallExp not processed");
		}
		
		return getPropertyDatum(context, property);
	}
	
	@NonNull
	protected Set<PropertyDatum> getPropertyDatum(PropertyAssignment propAssign) {
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		Property targetProp = propAssign.getTargetProperty();
		PropertyDatum targetDatum = getPropertyDatum(propAssign.getSlotExpression().getType().isClass(), targetProp);
		result.add(targetDatum);
		Property oppositeProp = targetProp.getOpposite();
		if (oppositeProp != null) {
			PropertyDatum oppositeDatum = getPropertyDatum(getElementClass(targetProp), oppositeProp);
			targetDatum.setOpposite(oppositeDatum);
			result.add(oppositeDatum);
		}
		return result;
	}
	
	private Set<PropertyDatum> getPropertyDatums(OperationCallExp opCall, Class context, Map<Class, Set<Operation>> type2VisitedOps, Map<Variable, Set<Class>> variable2BoundContext) {
		
		Set<Operation> visitedOps = type2VisitedOps.get(context);
		if (visitedOps == null) {
			visitedOps = new HashSet<Operation>();
			type2VisitedOps.put(context, visitedOps);
		}

		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		Operation op = opCall.getReferredOperation();

		if (!visitedOps.contains(op)) {
			visitedOps.add(op);
			if (isOclContainerOp(op)) {
				for (Class newContext : getComputedContexts(opCall, variable2BoundContext)) {
					result.addAll(analyseOclContainerCall(newContext));
				}
			} else {
				result.addAll(getPropertyDatums(op, context, type2VisitedOps));
			}
		}
		return result;
	}
	
	private Set<PropertyDatum> getPropertyDatums(Operation op, Class context, Map<Class, Set<Operation>> type2VisitedOps) {
		
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		LanguageExpression langExp = op.getBodyExpression();
		if (langExp instanceof ExpressionInOCL) {
			ExpressionInOCL expInOCL = (ExpressionInOCL) langExp;
			if (expInOCL.getOwnedBody() != null) {
				Map<Variable, Set<Class>> variable2BoundContext = new HashMap<Variable, Set<Class>>();
				Set<Class> boundContexts = new LinkedHashSet<Class>();
				boundContexts.add(context);
				variable2BoundContext.put(expInOCL.getOwnedContext(), boundContexts);
				TreeIterator<EObject> it = expInOCL.eAllContents();
				while (it.hasNext()) {
					EObject eObject = it.next();
					if (eObject instanceof LetExp) {
						updateVariableBindings((LetExp) eObject, variable2BoundContext);
					} else if (eObject instanceof NavigationCallExp) { // FIXME OppositeCallExp ?
						NavigationCallExp navCallExp = (NavigationCallExp)eObject;
						for (Class newContext : getComputedContexts(navCallExp, variable2BoundContext)) {
							result.add(getPropertyDatum(navCallExp, newContext));
						}
					} else if (eObject instanceof OperationCallExp) {
						OperationCallExp opCallExp = (OperationCallExp) eObject;
						for (Class newContext : getComputedContexts(opCallExp, variable2BoundContext)) {
							result.addAll(getPropertyDatums(opCallExp, newContext, type2VisitedOps, variable2BoundContext));
						}
					}
				}
			}
		}
		return result;
	}
	
	private boolean isOclContainerOp(Operation op) {
		// FIXME make this check more robust
		return "oclContainer".equals(op.getName()) && op.getOwnedParameters().isEmpty();
	}

	private Set<PropertyDatum> analyseOclContainerCall(Class context) {
		
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		
		for (Class parentClass : getContainingTypes(context)) {
			for (Property prop : parentClass.getOwnedProperties()) {
				if (prop.isIsComposite()) {
					Set<Class> allSuperAndSubClasses = getAllSuperAndSubClassesIncludingSelf(context);
					if (allSuperAndSubClasses.contains(getElementClass(prop))) {
						// self.print("\tOCL Container property  for ");
						// prop.println(" : ");	
						// FIXME I'm getting non-deterministic QVTs 2 Graphml transformations
						// when there are references to non-navigable (inexistent) properties
						// in .oclas. Example3: Kiama
						// For the time being, let's create the dependency on the forward
						// containment property
						//var opposite = prop.opposite;
						//result.add(opposite.getOrCreatePropertyDatum(self));
						result.add(getPropertyDatum(parentClass, prop));
					}
				}	
				}
				
		}
		return result;
		
	}

	
	private void updateVariableBindings(LetExp letExp , Map<Variable, Set<Class>> variable2BoundContext ) {

		Variable variable = letExp.getOwnedVariable();
		variable2BoundContext.put(variable, computeContexts(variable.getOwnedInit(), variable2BoundContext));
	}

	// TODO cache
	private Set<Class> computeContexts(OCLExpression oclExp, Map<Variable, Set<Class>> variable2BoundContext) {
	
		Set<Class >result = new LinkedHashSet<Class>();
		if (oclExp instanceof VariableExp) {
			VariableExp varExp = (VariableExp) oclExp;
			Set<Class> context = variable2BoundContext.get(varExp.getReferredVariable());
			if (context != null) { // FIXME is this check needed ?
				result.addAll(context);
			} else {
				result.add(varExp.getType().isClass());
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp && 
					isOclContainerOp(((OperationCallExp)callExp).getReferredOperation())) {
				for(Class oclContainerOpContext : computeContexts(callExp.getOwnedSource(), variable2BoundContext)) {
					result.addAll(getContainingTypes(oclContainerOpContext));
				}
			} else {
				result.add(callExp.getType().isClass());
			}
		} else {
			throw new IllegalStateException("OCLExpression has not been considered yet");
		}
		return result;
	}

	// This is needed when analysing Property/Operation call exps so that they exploit the statically computed context
	// carried on through the analysis.
	// TODO cache
	private Set<Class> getComputedContexts(CallExp callExp, Map<Variable, Set<Class>> variable2BoundContext) {
		OCLExpression source = callExp.getOwnedSource();
		return computeContexts(source, variable2BoundContext);
	}
	private Set<Class> getContainingTypes(Class aClass) {
		return cRels.getContainerClasses(aClass);
	}
	
	private Class getContextType(CallExp callExp) {
		OCLExpression ownedSource = callExp.getOwnedSource();
		return ownedSource != null ? ownedSource.getType().isClass() : null;
	}
	
	private Set<Class> getAllSuperClasses(Class context) {
		return cRels.getAllSuperClasses(context);
	}

	private Set<Class> getAllSuperClassesIncludingSelf(Class context) {
		Set<Class> result = new LinkedHashSet<Class>();
		result.addAll(getAllSuperClasses(context));
		result.add(context);
		return result;
	}

	private Set<Class> getAllSubClasses(Class context) {
		return cRels.getAllSubClasses(context);
	}

	private Set<Class> getAllSubClassesIncludingSelf(Class context) {
		Set<Class> result = new LinkedHashSet<Class>();
		result.addAll(getAllSubClasses(context));
		result.add(context);
		return result;
	}
	
	private Set<Class> getAllSuperAndSubClasses(Class context) {		
		Set<Class> result = new LinkedHashSet<Class>();
		result.addAll(getAllSuperClasses(context));
		result.addAll(getAllSubClasses(context));
		return result;
	}

	private Set<Class> getAllSuperAndSubClassesIncludingSelf(Class context) {
		Set<Class> result = getAllSuperAndSubClasses(context);
		result.add(context);
		return result;
	}
	
	private Class getElementClass(TypedElement tElement) {
		Type type = tElement.getType();
		if (type instanceof CollectionType) {
			return ((CollectionType) type).getElementType().isClass();
		} else {
			return type.isClass();
		}
	}
	
	
	// Return the core pattern variables related to this type
	// TODO cache
	// FIXME transliterated as it is, but the logic doesn't make any sense.
	private Set<Variable> getCorePatternVariables(Class aType) {

		Set<Variable> result = new LinkedHashSet<Variable>();
		Set<Class> superClassesWithCorePatternVariables = new HashSet<Class>();
		for (Class superClass : getAllSuperClasses(aType)) {
			if (existsCorePatternVariable(superClass)) {
				superClassesWithCorePatternVariables.add(superClass);
			}
		}
		
		for (Variable corePatternVar : mappingsVariables) {
			Type varType = corePatternVar.getType();
			if (aType.equals(varType)
				|| superClassesWithCorePatternVariables.contains(aType)) {
					result.add(corePatternVar);
			}
		}
		return result;
	}
	
	private boolean existsCorePatternVariable(Class aType) {
		return getCorePatternVariables(aType).isEmpty();
	}
	
	private CorePattern getOpposittePattern(Variable var) {
		EObject container = var.eContainer();
		return container instanceof CorePattern ? (CorePattern) container : null;
	}
}
