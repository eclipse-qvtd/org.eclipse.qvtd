package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

public class QVTc2QVTu {

	private EnvironmentFactory environmentFactory;
	private Configuration config;
	Map<Variable, Variable> refinedVars = new HashMap<Variable, Variable>();
    

	public QVTc2QVTu(EnvironmentFactory environmentFactory, Configuration config) {
		super();
        this.environmentFactory = environmentFactory;
        this.config = config;
	}
	
	public void execute(CoreModel model) {

        for (org.eclipse.ocl.pivot.Package p : model.getOwnedPackages()) {
            for (Class c : p.getOwnedClasses()) {
                if (c instanceof Transformation) {
                    direct((Transformation) c);
                }
            }
        }
    }
	
	/**
	 * Using the desired direction:
	 * 	Remove assignments in the unwanted direction
	 *  Change out-to-middle assignments to predicates
	 *  Change input realized variables to variables  
	 * @param t
	 */
	private void direct(Transformation t) {
		// TODO Auto-generated method stub
		for (Rule r : t.getRule()) {
			migrateVariables((Mapping) r);
            direct((Mapping) r);
        }
		// Delete rv from model
		for (Variable rv : refinedVars.keySet()) {
			EcoreUtil.delete(rv, true);
		}
	}
	
	private void migrateVariables(Mapping m) {
		
		changeRealizedToVariable(m);
		fixRealizedVariableReferences(m);
	}
	
	private void fixRealizedVariableReferences(Mapping m) {
		for (Domain d : m.getDomain()) {
			MtcUtil.fixReferences((Area) d, refinedVars);
		}
		MtcUtil.fixReferences(m, refinedVars);
		for (Mapping lm : m.getLocal()) {
			fixRealizedVariableReferences(lm);
		}
		// Extending mappings can also have references that need fixing
//		for (Mapping rm : m.getRefinement()) {
//			fixRealizedVariableReferences(rm);
//		}
	}
	
	private void changeRealizedToVariable(Mapping m) {
		
		for (Domain d : m.getDomain()) {
			if (MtcUtil.isInputDomain((Area) d, config)) {
				for (RealizedVariable rv : ((Area) d).getBottomPattern().getRealizedVariable()) {
					//References to rv must be fixed
					Variable v = PivotFactory.eINSTANCE.createVariable();
					v.setName(rv.getName());
					v.setType(rv.getType());
					((Area) d).getBottomPattern().getVariable().add(v);
					refinedVars.put(rv, v);
				}
			}
		}
		for (Mapping lm : m.getLocal()) {
			changeRealizedToVariable(lm);
		}
	}

	private void direct(Mapping m) {
		// Delete Assignments
		for (PropertyAssignment a : MtcUtil.getAllPropertyAssignments(m)) {
			if (MtcUtil.isMtoL(a, config) ||
					MtcUtil.isRtoM(a, config) ||
					MtcUtil.isLocaltoM(a, config)) {
				EcoreUtil.delete(a, true);
			} else if (MtcUtil.isFromInputDomain(a.getSlotExpression(), config) &&
					allReferencedVariablesInInputDomain(a)) {
				// Assignments to Predicates
				Predicate pOUt = QVTbaseFactory.eINSTANCE.createPredicate();
	            pOUt.setConditionExpression(MtcUtil.assignmentToOclExp(a, environmentFactory));
	            CorePattern cp = (CorePattern) a.eContainer();
	            EcoreUtil.delete(a, true);
	            cp.getPredicate().add(pOUt);
			} else if(MtcUtil.isCheckMode(config) &&
					a.isIsDefault() &&
					MtcUtil.isOutputDomain(a.getBottomPattern().getArea(), config)
					) {
				// Default assignments
				a.setIsDefault(false);
			}
		}
		for (VariableAssignment a : MtcUtil.getAllVariableAssignments(m)) {
			if (MtcUtil.isMtoL(a, config) ||
					MtcUtil.isRtoM(a, config) ||
					MtcUtil.isMtoM(a, config)) {
				EcoreUtil.delete(a, true);
			}
		}
		for (Predicate p : MtcUtil.getAllPredicates(m)) {
			if (p.getPattern() instanceof BottomPattern &&
					allReferencedVariablesInOutputDomain(p)) {
				EcoreUtil.delete(p, true);
			}
		}
		for (Domain d : m.getDomain()) {
			d.setName(d.getTypedModel().getName());			// Redundant replication of Epsilon functionality
			if (MtcUtil.isInputDomain((Area) d, config)) {
				d.setIsEnforceable(false);
				d.setIsCheckable(true);
			} else {
				if (MtcUtil.isCheckMode(config)) {
					d.setIsEnforceable(false);
				} else if (MtcUtil.isEnforceMode(config)) {
					d.setIsCheckable(false);
				}
			}
		}
		for (Mapping lm : m.getLocal()) {
			direct(lm);
		}
	}

	private boolean allReferencedVariablesInInputDomain(PropertyAssignment a) {
		for (Variable v : MtcUtil.findReferencedVariables(a)) {
			if (!MtcUtil.isInputDomain(MtcUtil.getArea(v), config)) {
				return false;
			}
		}
		return true;
	}

	private boolean allReferencedVariablesInOutputDomain(Predicate p) {
		for (Variable v : MtcUtil.findReferencedVariables(p.getConditionExpression())) {
			if (!MtcUtil.isOutputDomain(MtcUtil.getArea(v), config)) {
				return false;
			}
		}
		return true;
	}
}
