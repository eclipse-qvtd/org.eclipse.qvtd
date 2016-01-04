package org.eclipse.qvtd.compiler.internal.etl.scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleFactory;

public class QVTp2QVTg {
	
	private Schedule dg;
	
	// Caches
	private Map<TypedModel, Map<org.eclipse.ocl.pivot.Class, ClassDatum>> typedModel2class2datum = new HashMap<TypedModel, Map<org.eclipse.ocl.pivot.Class, ClassDatum>>();
	
	private Map<AbstractMapping, List<OperationCallExp>> mapping2opCallExps = new HashMap<AbstractMapping, List<OperationCallExp>>();
	private Map<AbstractMapping, List<PropertyAssignment>> mapping2propAssigns = new HashMap<AbstractMapping, List<PropertyAssignment>>();
	private Map<AbstractMapping, List<NavigationCallExp>> mapping2navCallExps = new HashMap<AbstractMapping, List<NavigationCallExp>>();
	
	private final @NonNull RootDomainUsageAnalysis domainUsageAnalysis;
	private final @NonNull ClassRelationships classRelationships;
	

	public QVTp2QVTg(@NonNull RootDomainUsageAnalysis domainAnalysis, @NonNull ClassRelationships classRelationships) {
		this.domainUsageAnalysis = domainAnalysis;
		this.classRelationships = classRelationships;
	}

	private void clearCaches() {
		typedModel2class2datum.clear();
		mapping2opCallExps.clear();
		mapping2propAssigns.clear();
		mapping2navCallExps.clear();
	}
	
	private void computeInitialCaches(Transformation tx) {
		
		for (Rule rule : tx.getRule()) {
			AbstractMapping mapping = (AbstractMapping) rule;
			TreeIterator<EObject> it = mapping.eAllContents();
			while (it.hasNext()) {
				EObject eObj = it.next();
				if (eObj instanceof OperationCallExp) {
					List<OperationCallExp> opCallExps = mapping2opCallExps.get(mapping);
					if (opCallExps == null) {
						opCallExps = new ArrayList<OperationCallExp>();
						mapping2opCallExps.put(mapping, opCallExps);
					}
					opCallExps.add((OperationCallExp)eObj);
				} else if (eObj instanceof PropertyAssignment) {
					List<PropertyAssignment> propAssigns = mapping2propAssigns.get(mapping);
					if (propAssigns == null) {
						propAssigns = new ArrayList<PropertyAssignment>();
						mapping2propAssigns.put(mapping, propAssigns);
					}
					propAssigns.add((PropertyAssignment)eObj);
				} else if (eObj instanceof NavigationCallExp) {
					List<NavigationCallExp> navCallExps = mapping2navCallExps.get(mapping);
					if (navCallExps == null) {
						navCallExps = new ArrayList<NavigationCallExp>();
						mapping2navCallExps.put(mapping, navCallExps);
					}
					navCallExps.add((NavigationCallExp)eObj);
				}
			}
		}
		
	}
	public void run(@NonNull Resource qvtpModel, @NonNull Resource qvtsModel) {
		clearCaches();
		
		dg = ScheduleFactory.eINSTANCE.createSchedule();
				
		BaseModel iModel = (BaseModel) qvtpModel.getContents().get(0);
		org.eclipse.ocl.pivot.Package txPackage = iModel.getOwnedPackages().get(0);
		Transformation tx = (Transformation) txPackage.getOwnedClasses().get(0);
		
		computeInitialCaches(tx);
		for (Rule rule : tx.getRule()) {
			createMappingAction((AbstractMapping) rule);
		}
		
		// We add the result to the output result
		qvtsModel.getContents().clear();
		qvtsModel.getContents().add(dg);
	}
	
	protected MappingAction createMappingAction(AbstractMapping mapping) {
		
		MappingAction ma = ScheduleFactory.eINSTANCE.createMappingAction();
		
		ma.setSchedule(dg);
		ma.setMapping(mapping);
	
		for (@SuppressWarnings("null") @NonNull Variable inputVar : getInputVariables(mapping)) {
			TypedModel typedModel = getTypedModel(inputVar);
			ma.getParameters().add(createDataParameter(inputVar));
			ma.getRequisites().add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)inputVar.getType())));

		}
		
		for (@SuppressWarnings("null") @NonNull RealizedVariable outputVar : getOutputVariables(mapping)) {
			TypedModel typedModel = getTypedModel(outputVar);
			ma.getResults().add(createDataParameter(outputVar));
			ma.getProductions().add(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)outputVar.getType())));
		}
		
		for (NavigationCallExp propRead : getPropertyNavigations(mapping)){
			ma.getRequisites().add(getPropertyDatum(propRead));
		}
		
		for (PropertyAssignment propWrite : getPropertyAssignments(mapping)){
			ma.getProductions().addAll(getPropertyDatum(propWrite));
			
		}
		
		for (OperationCallExp opCall : getOperationCallExps(mapping)) {
			org.eclipse.ocl.pivot.Class context = getContextType(opCall);
			ma.getRequisites().addAll(getPropertyDatums(opCall, context, new HashMap<org.eclipse.ocl.pivot.Class, Set<Operation>>(), new HashMap<Variable, Set<org.eclipse.ocl.pivot.Class>>()));
		}
		
		return ma;
	}

	protected DataParameter createDataParameter(@NonNull Variable variable) {
		TypedModel typedModel = getTypedModel(variable);
		DataParameter dp = ScheduleFactory.eINSTANCE.createDataParameter();
		dp.setVariable(variable);
		dp.setDatum(getClassDatum(typedModel, ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class)variable.getType())));		
		return dp;
	}
	
	@NonNull
	protected ClassDatum createClassDatum(@NonNull TypedModel typedModel, @NonNull org.eclipse.ocl.pivot.Class aClass) {
		ClassDatum cDatum = ScheduleFactory.eINSTANCE.createClassDatum();
		cDatum.setSchedule(dg);
		cDatum.setType(aClass);
		cDatum.setTypedModel(typedModel);
		for (@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class superClass : aClass.getSuperClasses()) {
			ClassDatum superCDatum = getClassDatum(typedModel, superClass);
			cDatum.getSuper().add(superCDatum);
		}
		
		return cDatum;
	}
	
	public @NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull org.eclipse.ocl.pivot.Class aClass) {
		Map<org.eclipse.ocl.pivot.Class, ClassDatum> class2datum = typedModel2class2datum.get(typedModel);
		if (class2datum == null) {
			class2datum = new HashMap<org.eclipse.ocl.pivot.Class, ClassDatum>();
			typedModel2class2datum.put(typedModel, class2datum);
		}
		ClassDatum cDatum = class2datum.get(aClass);
		if (cDatum == null) {
			cDatum = createClassDatum(typedModel, aClass);
			class2datum.put(aClass, cDatum);
		}
		return cDatum;
	}
	
	public @NonNull ClassRelationships getClassRelationships() {
		return classRelationships;
	}

	@NonNull
	protected PropertyDatum createPropertyDatum(@NonNull TypedModel typedModel, @NonNull org.eclipse.ocl.pivot.Class context, Property property) {
		
		PropertyDatum pDatum = ScheduleFactory.eINSTANCE.createPropertyDatum();
		ClassDatum classDatum = getClassDatum(typedModel, context);
		pDatum.setTypedModel(classDatum.getTypedModel());
		pDatum.setProperty(property);
		pDatum.setClassDatum(classDatum);
		if (context != property.getOwningClass()) {
			for (@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class superClass : context.getSuperClasses()) {
				PropertyDatum superPropDatum = getPropertyDatum(typedModel, superClass, property);
				pDatum.getSuper().add(superPropDatum);
			}
			
		}
		return pDatum;
	}
	
	@NonNull
	protected PropertyDatum getPropertyDatum(@NonNull TypedModel typedModel, @NonNull org.eclipse.ocl.pivot.Class context, Property property) {
		ClassDatum cDatum = getClassDatum(typedModel, context);
		for (PropertyDatum pDatum : cDatum.getPropertyDatums()) {
			if (pDatum.getProperty().equals(property)) {
				return pDatum;
			}
		}
		// If not found we create it
		return createPropertyDatum(typedModel, context, property);
	}
	
	
	protected List<Variable> getInputVariables(AbstractMapping mapping) {

		List<Variable> mInputVars = new ArrayList<Variable>();
		mInputVars.addAll(mapping.getGuardPattern().getVariable());
	
		for (Domain domain : mapping.getDomain()) {
			CoreDomain cDomain = (CoreDomain) domain;
			mInputVars.addAll(cDomain.getGuardPattern().getVariable());
		}
		
		// TODO what about refinements ?
		return mInputVars;
	}
	
	protected List<RealizedVariable> getOutputVariables(AbstractMapping mapping) {
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
	
	protected List<NavigationCallExp> getPropertyNavigations(AbstractMapping mapping) {		
		List<NavigationCallExp> navCallExps = mapping2navCallExps.get(mapping);
		return navCallExps == null ? Collections.<NavigationCallExp>emptyList() : navCallExps;
	}

	protected List<PropertyAssignment> getPropertyAssignments(AbstractMapping mapping) {	
		List<PropertyAssignment> propAssigns = mapping2propAssigns.get(mapping);
		return propAssigns == null ? Collections.<PropertyAssignment>emptyList() : propAssigns;
	}
	
	protected List<OperationCallExp> getOperationCallExps(AbstractMapping mapping) {
		List<OperationCallExp> opCallExps = mapping2opCallExps.get(mapping);
		return opCallExps == null ? Collections.<OperationCallExp>emptyList() : opCallExps;
	}
	
	@NonNull
	protected PropertyDatum getPropertyDatum(NavigationCallExp navCallExp) {
		
		org.eclipse.ocl.pivot.Class context = ClassUtil.nonNullState((org.eclipse.ocl.pivot.Class) navCallExp.getOwnedSource().getType());
		return getPropertyDatum(navCallExp, context );
	}
	
	@NonNull
	protected PropertyDatum getPropertyDatum(NavigationCallExp navCallExp, @NonNull org.eclipse.ocl.pivot.Class context) {
		
		Property property = null;
		if (navCallExp instanceof PropertyCallExp) {
			property = ((PropertyCallExp) navCallExp).getReferredProperty();
		} else if (navCallExp instanceof OppositePropertyCallExp) {
			property = ((OppositePropertyCallExp) navCallExp).getReferredProperty().getOpposite();		
		} else {
			throw new IllegalStateException("Kind of NavigationCallExp not processed");
		}
		Iterator<TypedModel> typedModels = getTypedModels(navCallExp).iterator();
		if (!typedModels.hasNext()) {
			throw new IllegalStateException("No TypedModel for " + navCallExp);
		}
		@SuppressWarnings("null") @NonNull TypedModel typedModel = typedModels.next();
		if (typedModels.hasNext()) {
			typedModel = getTypedModel(ClassUtil.nonNullState(navCallExp.getOwnedSource()));
//			throw new IllegalStateException("Ambiguous TypedModel: " + typedModel + " for " + navCallExp);
		}
//		Property opposite = property.getOpposite();
//		if (property.isIsComposite() || ((opposite != null) && opposite.isIsComposite())) {
//			TypedModel typedModel = getTypedModel(navCallExp.getOwnedSource());
//			return getPropertyDatum(typedModel, context, property);
//		}
//		else {
//			TypedModel typedModel = getTypedModel(navCallExp);
			return getPropertyDatum(typedModel, context, property);
//		}
	}
	
	@NonNull
	protected Set<PropertyDatum> getPropertyDatum(PropertyAssignment propAssign) {
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		Property targetProp = propAssign.getTargetProperty();
		OCLExpression slotExpression = ClassUtil.nonNullState(propAssign.getSlotExpression());
		TypedModel typedModel = getTypedModel(slotExpression);
		PropertyDatum targetDatum = getPropertyDatum(typedModel, ClassUtil.nonNullState(slotExpression.getType().isClass()), targetProp);
		result.add(targetDatum);
		Property oppositeProp = targetProp.getOpposite();
		if (oppositeProp != null) {
			PropertyDatum oppositeDatum = getPropertyDatum(typedModel, ClassUtil.nonNullState(getElementClass(targetProp)), oppositeProp);
			targetDatum.setOpposite(oppositeDatum);
			result.add(oppositeDatum);
		}
		return result;
	}
	
	private Set<PropertyDatum> getPropertyDatums(OperationCallExp opCall, org.eclipse.ocl.pivot.Class context, Map<org.eclipse.ocl.pivot.Class, Set<Operation>> type2VisitedOps, Map<Variable, Set<org.eclipse.ocl.pivot.Class>> variable2BoundContext) {
		
		Set<Operation> visitedOps = type2VisitedOps.get(context);
		if (visitedOps == null) {
			visitedOps = new HashSet<Operation>();
			type2VisitedOps.put(context, visitedOps);
		}

		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		Operation op = ClassUtil.nonNullState(opCall.getReferredOperation());

		if (!visitedOps.contains(op)) {
			visitedOps.add(op);
			if (isOclContainerOp(op)) {
				for (@SuppressWarnings("null") @NonNull TypedModel typedModel : getTypedModels(opCall)) {
					for (@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class newContext : getComputedContexts(opCall, variable2BoundContext)) {
						result.addAll(analyseOclContainerCall(typedModel, newContext));
					}
				}
			} else {
				result.addAll(getPropertyDatums(op, context, type2VisitedOps));
			}
		}
		return result;
	}
	
	private Set<PropertyDatum> getPropertyDatums(Operation op, org.eclipse.ocl.pivot.Class context, Map<org.eclipse.ocl.pivot.Class, Set<Operation>> type2VisitedOps) {
		
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		LanguageExpression langExp = op.getBodyExpression();
		if (langExp instanceof ExpressionInOCL) {
			ExpressionInOCL expInOCL = (ExpressionInOCL) langExp;
			if (expInOCL.getOwnedBody() != null) {
				Map<Variable, Set<org.eclipse.ocl.pivot.Class>> variable2BoundContext = new HashMap<Variable, Set<org.eclipse.ocl.pivot.Class>>();
				Set<org.eclipse.ocl.pivot.Class> boundContexts = new LinkedHashSet<org.eclipse.ocl.pivot.Class>();
				boundContexts.add(context);
				variable2BoundContext.put(expInOCL.getOwnedContext(), boundContexts);
				TreeIterator<EObject> it = expInOCL.eAllContents();
				while (it.hasNext()) {
					EObject eObject = it.next();
					if (eObject instanceof LetExp) {
						updateVariableBindings((LetExp) eObject, variable2BoundContext);
					} else if (eObject instanceof NavigationCallExp) { // FIXME OppositeCallExp ?
						NavigationCallExp navCallExp = (NavigationCallExp)eObject;
						for (@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class newContext : getComputedContexts(navCallExp, variable2BoundContext)) {
							result.add(getPropertyDatum(navCallExp, newContext));
						}
					} else if (eObject instanceof OperationCallExp) {
						OperationCallExp opCallExp = (OperationCallExp) eObject;
						for (org.eclipse.ocl.pivot.Class newContext : getComputedContexts(opCallExp, variable2BoundContext)) {
							result.addAll(getPropertyDatums(opCallExp, newContext, type2VisitedOps, variable2BoundContext));
						}
					}
				}
			}
		}
		return result;
	}

	private @NonNull TypedModel getTypedModel(@NonNull Element element) {
		DomainUsage domainUsage = getUsage(element);
		if (domainUsage == null) {
			getUsage(element);
			throw new IllegalStateException("No DomainUsage for " + element);
		}
		Iterator<TypedModel> typedModels = getTypedModels(element).iterator();
		if (!typedModels.hasNext()) {
			throw new IllegalStateException("No TypedModel for " + element);
		}
		@SuppressWarnings("null") @NonNull TypedModel typedModel = typedModels.next();
		if (typedModels.hasNext()) {
			getUsage(element);
			throw new IllegalStateException("Ambiguous TypedModel: " + domainUsage + " for " + element);
		}
		return typedModel;
	}

	private @NonNull Iterable<TypedModel> getTypedModels(@NonNull Element element) {
		DomainUsage domainUsage = getUsage(element);
		if (domainUsage == null) {
			getUsage(element);
			throw new IllegalStateException("No DomainUsage for " + element);
		}
		return domainUsage.getTypedModels();
	}

	private @Nullable DomainUsage getUsage(@NonNull Element element) {
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			DomainUsageAnalysis analysis = domainUsageAnalysis.getAnalysis(operation);
			return analysis.getUsage(element);
		}
		else {
			return domainUsageAnalysis.getUsage(element);
		}
	}
	
	private boolean isOclContainerOp(@NonNull Operation op) {
		return op.getOperationId() == domainUsageAnalysis.getOclContainerId();
//		return "oclContainer".equals(op.getName()) && op.getOwnedParameters().isEmpty();
	}

	private Set<PropertyDatum> analyseOclContainerCall(@NonNull TypedModel typedModel, @NonNull org.eclipse.ocl.pivot.Class context) {
		
		Set<PropertyDatum> result = new LinkedHashSet<PropertyDatum>();
		
		for (@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class parentClass : getContainingTypes(context)) {
			for (Property prop : parentClass.getOwnedProperties()) {
				if (prop.isIsComposite()) {
					Set<org.eclipse.ocl.pivot.Class> allSuperAndSubClasses = getAllSuperAndSubClassesIncludingSelf(context);
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
						result.add(getPropertyDatum(typedModel, parentClass, prop));
					}
				}	
				}
				
		}
		return result;
		
	}

	
	private void updateVariableBindings(LetExp letExp , Map<Variable, Set<org.eclipse.ocl.pivot.Class>> variable2BoundContext ) {

		Variable variable = letExp.getOwnedVariable();
		variable2BoundContext.put(variable, computeContexts(variable.getOwnedInit(), variable2BoundContext));
	}

	// TODO cache
	private Set<org.eclipse.ocl.pivot.Class> computeContexts(OCLExpression oclExp, Map<Variable, Set<org.eclipse.ocl.pivot.Class>> variable2BoundContext) {
	
		Set<org.eclipse.ocl.pivot.Class >result = new LinkedHashSet<org.eclipse.ocl.pivot.Class>();
		if (oclExp instanceof VariableExp) {
			VariableExp varExp = (VariableExp) oclExp;
			Set<org.eclipse.ocl.pivot.Class> context = variable2BoundContext.get(varExp.getReferredVariable());
			if (context != null) { // FIXME is this check needed ?
				result.addAll(context);
			} else {
				result.add(varExp.getType().isClass());
			}
		} else if (oclExp instanceof CallExp) {
			CallExp callExp = (CallExp) oclExp;
			if (callExp instanceof OperationCallExp && 
					isOclContainerOp(ClassUtil.nonNullState(((OperationCallExp)callExp).getReferredOperation()))) {
				for(@SuppressWarnings("null") @NonNull org.eclipse.ocl.pivot.Class oclContainerOpContext : computeContexts(callExp.getOwnedSource(), variable2BoundContext)) {
					result.addAll(getContainingTypes(oclContainerOpContext));
				}
			} else {
				result.add(callExp.getType().isClass());
			}
		} else if (oclExp instanceof ShadowExp) {
			result.add(((ShadowExp)oclExp).getType());

		} else {
			throw new IllegalStateException("OCLExpression has not been considered yet");
		}
		return result;
	}

	// This is needed when analysing Property/Operation call exps so that they exploit the statically computed context
	// carried on through the analysis.
	// TODO cache
	private Set<org.eclipse.ocl.pivot.Class> getComputedContexts(CallExp callExp, Map<Variable, Set<org.eclipse.ocl.pivot.Class>> variable2BoundContext) {
		OCLExpression source = callExp.getOwnedSource();
		return computeContexts(source, variable2BoundContext);
	}
	private Set<org.eclipse.ocl.pivot.Class> getContainingTypes(@NonNull org.eclipse.ocl.pivot.Class aClass) {
		return classRelationships.getContainerClasses(aClass);
	}
	
	private org.eclipse.ocl.pivot.Class getContextType(CallExp callExp) {
		OCLExpression ownedSource = callExp.getOwnedSource();
		return ownedSource != null ? ownedSource.getType().isClass() : null;
	}
	
	private Set<org.eclipse.ocl.pivot.Class> getAllSuperClasses(@NonNull org.eclipse.ocl.pivot.Class context) {
		return classRelationships.getAllSuperClasses(context);
	}

//	private Set<Class> getAllSuperClassesIncludingSelf(Class context) {
//		Set<Class> result = new LinkedHashSet<Class>();
//		result.addAll(getAllSuperClasses(context));
//		result.add(context);
//		return result;
//	}

	private Set<org.eclipse.ocl.pivot.Class> getAllSubClasses(@NonNull org.eclipse.ocl.pivot.Class context) {
		return classRelationships.getAllSubClasses(context);
	}

//	private Set<Class> getAllSubClassesIncludingSelf(Class context) {
//		Set<Class> result = new LinkedHashSet<Class>();
//		result.addAll(getAllSubClasses(context));
//		result.add(context);
//		return result;
//	}
	
	private Set<org.eclipse.ocl.pivot.Class> getAllSuperAndSubClasses(@NonNull org.eclipse.ocl.pivot.Class context) {		
		Set<org.eclipse.ocl.pivot.Class> result = new LinkedHashSet<org.eclipse.ocl.pivot.Class>();
		result.addAll(getAllSuperClasses(context));
		result.addAll(getAllSubClasses(context));
		return result;
	}

	private Set<org.eclipse.ocl.pivot.Class> getAllSuperAndSubClassesIncludingSelf(@NonNull org.eclipse.ocl.pivot.Class context) {
		Set<org.eclipse.ocl.pivot.Class> result = getAllSuperAndSubClasses(context);
		result.add(context);
		return result;
	}
	
	private org.eclipse.ocl.pivot.Class getElementClass(TypedElement tElement) {
		Type type = tElement.getType();
		if (type instanceof CollectionType) {
			return ((CollectionType) type).getElementType().isClass();
		} else {
			return type.isClass();
		}
	}
}
