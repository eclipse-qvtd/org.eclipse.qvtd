package org.eclipse.qvtd.compiler.internal.etl.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;


/**
 * The MtcUtil Class.
 */
public class MtcUtil {

    /**
     * Create an ocl expression from an assignment than can be used as the
     * condition expression of a predicate.
     *
     * @param aIn the a in
     * @param environmentFactory the environment factory
     * @return the operation call exp
     */
    public static OperationCallExp assignmentToOclExp(Assignment aIn, EnvironmentFactory environmentFactory) {
        OperationCallExp exp = PivotFactory.eINSTANCE.createOperationCallExp();
        for (Operation op : environmentFactory.getStandardLibrary().getOclAnyType().getOwnedOperations()) {
            if (op.getName().equals("=")) {
                exp.setReferredOperation(op);
                exp.setName(op.getName());
                exp.setType(op.getType());
                break;
            }
        }
        exp.getOwnedArguments().add(EcoreUtil.copy(aIn.getValue()));
        if (aIn instanceof PropertyAssignment) {
            PropertyCallExp sourceExp = PivotFactory.eINSTANCE.createPropertyCallExp();
            sourceExp.setReferredProperty(((PropertyAssignment) aIn).getTargetProperty());
            sourceExp.setType(((PropertyAssignment) aIn).getTargetProperty().getType());
            sourceExp.setOwnedSource(EcoreUtil.copy(((PropertyAssignment) aIn).getSlotExpression()));
            exp.setOwnedSource(sourceExp);
        } else { // aIn instanceof VariableAssignment
            VariableExp varExp = PivotFactory.eINSTANCE.createVariableExp();
            varExp.setIsImplicit(false);
            varExp.setReferredVariable(((VariableAssignment) aIn).getTargetVariable());
            exp.setOwnedSource(varExp);
        }
        return exp;
    }
    
    /**
     * Find all expressions of the given expression type nested in the OCL
     * expression.
     *
     * @param <T> the generic type
     * @param exp the exp
     * @param type the type
     * @return the sets the
     */
    public static <T> Set<T> findExpsOfType(OCLExpression exp, java.lang.Class<T> type) {
        Set<T> vars = new HashSet<T>();
        if (type.isInstance(exp)) {
            vars.add(type.cast(exp));
        }
        if (exp instanceof OperationCallExp) {
            OCLExpression source = ((CallExp) exp).getOwnedSource();
            if (source != null)
                vars.addAll(findExpsOfType(source, type));
            for (OCLExpression arg : ((OperationCallExp) exp).getOwnedArguments()) {
                vars.addAll(findExpsOfType(arg, type));
            }
        } else if (exp instanceof PropertyCallExp) {
            vars.addAll(findExpsOfType(((CallExp) exp).getOwnedSource(), type));
        } else if (exp instanceof IfExp) {
            IfExp ifexp = (IfExp) exp;
            vars.addAll(findExpsOfType(ifexp.getOwnedCondition(), type));
            vars.addAll(findExpsOfType(ifexp.getOwnedElse(), type));
            vars.addAll(findExpsOfType(ifexp.getOwnedThen(), type));
        } else if (exp instanceof CollectionLiteralExp) {
            // TODO Check that it is a collection of variables.
            // TODO what if it is a collection of collections or other OCL types?
            for (CollectionLiteralPart p : ((CollectionLiteralExp) exp).getOwnedParts()) {
                if (p instanceof CollectionItem) {
                    vars.addAll(findExpsOfType(((CollectionItem) p).getOwnedItem(), type));
                } else if (p instanceof CollectionRange) {
                    vars.addAll(findExpsOfType(((CollectionRange) p).getOwnedFirst(), type));
                    vars.addAll(findExpsOfType(((CollectionRange) p).getOwnedLast(), type));
                } else {
                    System.err.println("Error! Add findVariableExp() for " + p.eClass() + " in collections");
                }
            }
        } else if (exp instanceof IteratorExp) {
            IteratorExp itexp = (IteratorExp) exp;
            // Ignore iterator variables
            vars.addAll(findExpsOfType(itexp.getOwnedBody(), type));
            vars.addAll(findExpsOfType(itexp.getOwnedSource(), type));
        } else if (exp instanceof LiteralExp || exp instanceof TypeExp) {
          // Noting to add
        } else if (!(exp instanceof VariableExp)) { // VarExp can not be recursed into
            System.err.println("Error! Add findVariableExp() for " + exp.eClass());
        }
        return vars;
    }
    
    /**
     * Find all operation call expressions nested in the assigment.
     *
     * @param a the a
     * @return the sets the
     */
    public static Set<OperationCallExp> findOpCallExps(Assignment a) {
        Set<OperationCallExp> exps = MtcUtil.findExpsOfType(a.getValue(), OperationCallExp.class);
        if (a instanceof PropertyAssignment) {
            exps.addAll(MtcUtil.findExpsOfType(((PropertyAssignment) a).getSlotExpression(), OperationCallExp.class));
        }
        return exps;
    }

    /**
     * Find all operation call expressions nested in the predicate.
     *
     * @param p the p
     * @return the sets the
     */
    public static Set<OperationCallExp> findOpCallExps(Predicate p) {
        Set<OperationCallExp> exps = MtcUtil.findExpsOfType(p.getConditionExpression(), OperationCallExp.class);
        return exps;
    }

    /**
     * Find referenced variables in the assignment.
     *
     * @param ass the assignment
     * @return the sets the
     */
    public static Set<Variable> findReferencedVariables(Assignment ass) {

        Set<Variable> vars = findReferencedVariables(ass.getValue());
        if (ass instanceof PropertyAssignment) {
            vars.addAll(findReferencedVariables(((PropertyAssignment) ass).getSlotExpression()));
        } else if (ass instanceof VariableAssignment) {
            vars.add(((VariableAssignment) ass).getTargetVariable());
        }
        return vars;
    }

    /**
     * Find referenced variables in the OCL expression.
     *
     * @param exp the exp
     * @return the sets the
     */
    public static Set<Variable> findReferencedVariables(OCLExpression exp) {

        return findReferencedVariables(exp, null);
    }


    /**
     * Find referenced variables in the OCL expression, excluding the given
     * variables.
     *
     * @param exp the exp
     * @param exclude the excluded variables
     * @return the sets the
     */
    public static Set<Variable> findReferencedVariables(OCLExpression exp, List<Variable> exclude) {
        Set<Variable> vars = new HashSet<Variable>();
        for (VariableExp varexp : MtcUtil.findVariableExps(exp)) {
            if (!(varexp.getReferredVariable().eContainer() instanceof IteratorExp)) {
                vars.add((Variable) varexp.getReferredVariable());
            }
        }
        return vars;
    }

    /**
     * Find variable expressions in the Assignment.
     *
     * @param ass the ass
     * @return the sets the
     */
    public static Set<VariableExp> findVariableExps(Assignment ass) {

        Set<VariableExp> exps = MtcUtil.findVariableExps(ass.getValue());
        if (ass instanceof PropertyAssignment) {
            exps.addAll(MtcUtil.findVariableExps(((PropertyAssignment) ass).getSlotExpression()));
        }
        return exps;
    }

    /**
     * Find all variable expressions nested in the OCL expression.
     *
     * @param exp the exp
     * @return the sets the
     */
    public static Set<VariableExp> findVariableExps(OCLExpression exp) {
        Set<VariableExp> exps = findExpsOfType(exp, VariableExp.class);
        return exps;
    }

    /**
     * Find variable expressions in the Predicate.
     *
     * @param pred the pred
     * @return the sets the
     */
    public static Set<VariableExp> findVariableExps(Predicate pred) {

        return MtcUtil.findVariableExps(pred.getConditionExpression());
    }

    /**
     * Fix references to variables in the Area
     *
     * @param source the source
     * @param refinedVars the refined vars
     */
    public static void fixReferences(Area source, Map<Variable, Variable> refinedVars) {
        for (Variable gv : source.getGuardPattern().getVariable()) {
            if (gv.getOwnedInit() != null)
                fixReferences(gv.getOwnedInit(), refinedVars);
        }
        for (Variable bv : source.getBottomPattern().getVariable()) {
            if (bv.getOwnedInit() != null)
                fixReferences(bv.getOwnedInit(), refinedVars);
        }
        for (RealizedVariable brv : source.getBottomPattern().getRealizedVariable()) {
            if (brv.getOwnedInit() != null)
                fixReferences(brv.getOwnedInit(), refinedVars);
        }
        // Copy all predicates and assignments, might generate duplicates?
        for (Predicate p : source.getGuardPattern().getPredicate()) {
            fixReferences(p, refinedVars);
        }
        for (Predicate p : source.getBottomPattern().getPredicate()) {
            fixReferences(p, refinedVars);
        }
        for (Assignment a : source.getBottomPattern().getAssignment()) {
            fixReferences(a, refinedVars);
        }

    }
    
    /**
     * Fix references in the assignments
     *
     * @param a the a
     * @param refinedVars the refined vars
     */
    public static void fixReferences(Assignment a, Map<Variable, Variable> refinedVars) {

        fixReferences(a.getValue(), refinedVars);
        if (a instanceof PropertyAssignment) {
            fixReferences(((PropertyAssignment) a).getSlotExpression(), refinedVars);
        } else if (a instanceof VariableAssignment) {
            if (refinedVars.containsKey(((VariableAssignment) a).getTargetVariable())) {
                ((VariableAssignment) a).setTargetVariable(refinedVars.get(((VariableAssignment) a).getTargetVariable()));
            }
        }

    }
    
	/**
	 * Fix references in the OCL expression
	 *
	 * @param exp the exp
	 * @param refinedVars the refined vars
	 */
	public static void fixReferences(OCLExpression exp, Map<Variable, Variable> refinedVars) {
        for (VariableExp vExp : MtcUtil.findVariableExps(exp)) {
            fixVariableReferences(vExp, refinedVars);
            assert vExp.getReferredVariable() != null;
        }

    }
	
    /**
     * Fix references in the predicate
     * 
     * @param p the p
     * @param refinedVars the refined vars
     */
    public static void fixReferences(Predicate p, Map<Variable, Variable> refinedVars) {
        fixReferences(p.getConditionExpression(), refinedVars);

    }

	/**
	 * Fix variable references.
	 *
	 * @param varexp the varexp
	 * @param refinedVars the refined vars
	 */
	public static void fixVariableReferences(VariableExp varexp, Map<Variable, Variable> refinedVars) {

        Variable varIn = (Variable) varexp.getReferredVariable();
        if (varIn.eContainer() instanceof CorePattern) {
            if (refinedVars.containsKey(varIn))
                varexp.setReferredVariable(refinedVars.get(varIn));
        }
    }
	
	/**
	 * Gets the all property assignments in the Area
	 *
	 * @param a the a
	 * @return the all property assignments
	 */
	public static List<Predicate> getAllPredicates(Area a) {
		List<Predicate> result = new ArrayList<Predicate>();
		result.addAll(a.getGuardPattern().getPredicate());
		result.addAll(a.getBottomPattern().getPredicate());
		return result;
	}

	/**
	 * Get all property assignments in the Mapping.
	 *
	 * @param m the m
	 * @return the all property assignments
	 */
	public static List<Predicate> getAllPredicates(Mapping m) {
		
		List<Predicate> result = new ArrayList<Predicate>();
		for (Domain d : m.getDomain()) {
			result.addAll(getAllPredicates((CoreDomain) d));
		}
		result.addAll(getAllPredicates((Area) m));
		return result;
	}
	
	/**
	 * Gets the all property assignments in the Area
	 *
	 * @param a the a
	 * @return the all property assignments
	 */
	public static List<PropertyAssignment> getAllPropertyAssignments(Area a) {
		List<PropertyAssignment> result = new ArrayList<PropertyAssignment>();
		for (Assignment assg : a.getBottomPattern().getAssignment()) {
			if (assg instanceof PropertyAssignment) {
				result.add((PropertyAssignment) assg);
			}
		}
		return result;
	}
	
	/**
	 * Get all property assignments in the mapping.
	 *
	 * @param m the m
	 * @return the all property assignments
	 */
	public static List<PropertyAssignment> getAllPropertyAssignments(Mapping m) {
		
		List<PropertyAssignment> result = new ArrayList<PropertyAssignment>();
		for (Domain d : m.getDomain()) {
			result.addAll(getAllPropertyAssignments((CoreDomain) d));
		}
		result.addAll(getAllPropertyAssignments((Area) m));
		return result;
	}
	
	/**
	 * Gets the all variable assignments.
	 *
	 * @param a the a
	 * @return the all variable assignments
	 */
	public static List<VariableAssignment> getAllVariableAssignments(Area a) {
		List<VariableAssignment> result = new ArrayList<VariableAssignment>();
		for (Assignment assg : a.getBottomPattern().getAssignment()) {
			if (assg instanceof VariableAssignment) {
				result.add((VariableAssignment) assg);
			}
		}
		return result;
	}
	
	/**
	 * Gets the all variable assignments.
	 *
	 * @param m the m
	 * @return the all variable assignments
	 */
	public static List<VariableAssignment> getAllVariableAssignments(Mapping m) {
		List<VariableAssignment> result = new ArrayList<VariableAssignment>();
		for (Domain d : m.getDomain()) {
			result.addAll(getAllVariableAssignments((CoreDomain) d));
		}
		result.addAll(getAllVariableAssignments((Area) m));
		return result;
	}

	/**
	 * Gets the area.
	 *
	 * @param exp the exp
	 * @return the area
	 */
	public static Area getArea(OCLExpression exp) {
		if (exp instanceof VariableExp) {
			Variable expV = (Variable) ((VariableExp)exp).getReferredVariable(); 
			return getArea(expV);
		} else if (exp instanceof CallExp) {
			return getArea(((CallExp) exp).getOwnedSource());
		} else if (exp instanceof IfExp) {
			return getArea(((IfExp) exp).getOwnedCondition());
		} else if (exp instanceof LiteralExp) {
			return null;
		}
		return null;
	}

	/**
	 * Gets the area.
	 *
	 * @param expV the exp v
	 * @return the area
	 */
	public static Area getArea(Variable expV) {
		if (expV.getType() != null) {
			CorePattern cp = oppositePattern(expV);
			if (cp!= null)
			return cp.getArea();
		}
		return null;
	}
	
	/**
	 * Checks if is check mode.
	 *
	 * @param config the config
	 * @return true, if is check mode
	 */
	public static boolean isCheckMode(Configuration config) {
    	return config.getMode().equals(Mode.CHECK);
    }
	
	public static boolean isEnforceMode(Configuration config) {
		return config.getMode().equals(Mode.ENFORCE);
	}

	/**
	 * Checks if is from input domain.
	 *
	 * @param exp the exp
	 * @param config the config
	 * @return true, if is from input domain
	 */
	public static boolean isFromInputDomain(OCLExpression exp, Configuration config) {
		return isInputDomain(getArea(exp), config);
	}
	
	/**
	 * Checks if is from middle domain.
	 *
	 * @param exp the exp
	 * @param config the config
	 * @return true, if is from middle domain
	 */
	public static boolean isFromMiddleDomain(OCLExpression exp, Configuration config) {
		return isMiddleDomain(getArea(exp));
	}
	
	/**
	 * Checks if is input domain.
	 *
	 * @param area the area
	 * @param config the config
	 * @return true, if is input domain
	 */
	public static boolean isInputDomain(Area area, Configuration config) {
        return (area instanceof CoreDomain) && config.getInputDirection().getName().equals(((Domain) area).getName());
		
//		return (area instanceof CoreDomain) &&
//				config.getInputDirection().stream()
//					.map(Direction::getName)
//					.collect(Collectors.toList())
//					.contains(((CoreDomain) area).getName());
	}
	
	/**
	 * Is a local variable to M .
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is localto m
	 */
	public static boolean isLocaltoM(PropertyAssignment a, Configuration config) {
		if (isFromMiddleDomain(a.getValue(), config) &&
				(a.getValue() instanceof VariableExp)) {
			Variable var = (Variable) ((VariableExp)a.getValue()).getReferredVariable();
			return isMiddleDomain(getArea(var)) &&
					(getArea(var) instanceof BottomPattern);
		}
		return false;
				
	}
	
	/**
     * Checks if is middle assignment.
     *
     * @param aIn the assignment
     * @return true, if is middle assignment
     */
	public static boolean isMiddleAssignment(Assignment aIn) {
        boolean use = true;
        BottomPattern cp = aIn.getBottomPattern();
        if (cp.getArea() instanceof Mapping) {
            for (Variable var : findReferencedVariables(aIn)) {
                Area area = getArea(var);
                if (area instanceof CoreDomain) {
                    use = false;
                    break;
                }
            }

        } else {
            use = false;
        }
        return use;
    }
	
	/**
	 * Checks if is middle domain.
	 *
	 * @param area the area
	 * @return true, if is middle domain
	 */
	public static boolean isMiddleDomain(Area area) {
		
		return area instanceof Mapping;
	}
	
	/**
	 * Is a Middle to Left assignment.
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is mto l
	 */
	public static boolean isMtoL(PropertyAssignment a, Configuration config) {
		return isFromInputDomain(a.getSlotExpression(), config) &&
				anyReferencedMiddleDomainVariables(a.getValue());
	}
	private static boolean anyReferencedMiddleDomainVariables(OCLExpression value) {
		for (Variable v : findReferencedVariables(value)) {
			if (isMiddleDomain(getArea(v))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is middle to left.
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is mto l
	 */
	public static boolean isMtoL(VariableAssignment a, Configuration config) {
		return isInputDomain(getArea(a.getTargetVariable()), config) &&
				anyReferencedMiddleDomainVariables(a.getValue());
	}
	
	/**
	 * Checks if is middle to middle.
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is mto m
	 */
	public static boolean isMtoM(VariableAssignment a, Configuration config) {
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				anyReferencedBottomMiddleDomainVariables(a.getValue());
	}
	private static boolean anyReferencedBottomMiddleDomainVariables(OCLExpression value) {
		for (Variable v : findReferencedVariables(value)) {
			if (isMiddleDomain(getArea(v)) && (oppositePattern(v) instanceof BottomPattern)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is output domain.
	 * @param config the config
	 * @param domain the domain
	 *
	 * @return true, if is output domain
	 */
	public static boolean isOutputDomain(Area area, Configuration config) {
//        return (area instanceof CoreDomain) && config.getOutputDirection().getName().equals(((Domain) area).getName());
		if (!(area instanceof CoreDomain)) {
			return false;
		}
		String name = ((CoreDomain) area).getName();
		for (Direction outputDirection : config.getOutputDirection()) {
			if (ClassUtil.safeEquals(outputDirection.getName(), name)) {
				return true;
			}
		}
		return false;
    }

	/**
	 * Is a Right to Middle assignment.
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is rto m
	 */
	public static boolean isRtoM(PropertyAssignment a, Configuration config) {
		return isFromMiddleDomain(a.getSlotExpression(), config) &&
				!(a.getValue() instanceof VariableExp) &&
				!(a.getValue() instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(a.getValue(), config);
	}
	private static boolean allMatchReferencedOutputDomainVariables(OCLExpression value, Configuration config) {
		for (Variable v : findReferencedVariables(value)) {
			if (!isOutputDomain(getArea(v), config)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if is rto m.
	 *
	 * @param a the a
	 * @param config the config
	 * @return true, if is rto m
	 */
	public static boolean isRtoM(VariableAssignment a, Configuration config) {
		return isMiddleDomain(getArea(a.getTargetVariable())) &&
				!(a.getValue() instanceof VariableExp) &&
				// TODO variable assignments to null? !(a.getValue() instanceof NullLiteralExp) &&
				allMatchReferencedOutputDomainVariables(a.getValue(), config);
	}

    /**
     * Opposite pattern.
     *
     * @param expV the exp v
     * @return the core pattern
     */
    public static CorePattern oppositePattern(Variable expV) {
		if (expV.eContainer() instanceof CorePattern)
			return (CorePattern) expV.eContainer();
		return null;
	}

}
