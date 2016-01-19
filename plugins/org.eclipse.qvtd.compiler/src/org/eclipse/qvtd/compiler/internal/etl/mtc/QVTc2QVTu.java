package org.eclipse.qvtd.compiler.internal.etl.mtc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.utils.MtcUtil;
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
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

public class QVTc2QVTu
{
	private final @NonNull EnvironmentFactory environmentFactory;
	private final @NonNull QVTuConfiguration qvtuConfiguration;
	private final @NonNull Map<@NonNull Variable, @NonNull Variable> refinedVars = new HashMap<@NonNull Variable, @NonNull Variable>();

	public QVTc2QVTu(@NonNull EnvironmentFactory environmentFactory, @NonNull QVTuConfiguration qvtuConfiguration) {
		super();
        this.environmentFactory = environmentFactory;
        this.qvtuConfiguration = qvtuConfiguration;
	}
	
	public void execute(@NonNull CoreModel model) {

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
	private void direct(@NonNull Transformation t) {
		for (Rule r : ClassUtil.nullFree(t.getRule())) {
			migrateVariables((Mapping) r);
            direct((Mapping) r);
        }
		// Delete rv from model
		for (Variable rv : refinedVars.keySet()) {
			EcoreUtil.delete(rv, true);
		}
	}
	
	private void migrateVariables(@NonNull Mapping m) {
		
		changeRealizedToVariable(m);
		fixRealizedVariableReferences(m);
	}
	
	private void fixRealizedVariableReferences(@NonNull Mapping m) {
		for (Domain d : ClassUtil.nullFree(m.getDomain())) {
			MtcUtil.fixReferences((Area) d, refinedVars);
		}
		MtcUtil.fixReferences(m, refinedVars);
		for (Mapping lm : ClassUtil.nullFree(m.getLocal())) {
			fixRealizedVariableReferences(lm);
		}
		// Extending mappings can also have references that need fixing
//		for (Mapping rm : m.getRefinement()) {
//			fixRealizedVariableReferences(rm);
//		}
	}
	
	private void changeRealizedToVariable(@NonNull Mapping m) {
		
		for (Domain d : m.getDomain()) {
			if (qvtuConfiguration.isInputDomain((Area) d)) {
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
		for (Mapping lm : ClassUtil.nullFree(m.getLocal())) {
			changeRealizedToVariable(lm);
		}
	}

	private void direct(@NonNull Mapping m) {
		// Delete Assignments
		for (PropertyAssignment a : MtcUtil.getAllPropertyAssignments(m)) {
			if (qvtuConfiguration.isMtoL(a) || qvtuConfiguration.isRtoM(a) || qvtuConfiguration.isLocaltoM(a)) {
				EcoreUtil.delete(a, true);
			} else if (qvtuConfiguration.isFromInputDomain(a.getSlotExpression()) &&
					allReferencedVariablesInInputDomain(a)) {
				// Assignments to Predicates
				Predicate pOUt = QVTbaseFactory.eINSTANCE.createPredicate();
	            pOUt.setConditionExpression(MtcUtil.assignmentToOclExp(a, environmentFactory));
	            CorePattern cp = (CorePattern) a.eContainer();
	            EcoreUtil.delete(a, true);
	            cp.getPredicate().add(pOUt);
			} else if(qvtuConfiguration.isCheckMode() &&
					a.isIsDefault() &&
					qvtuConfiguration.isOutputDomain(a.getBottomPattern().getArea())
					) {
				// Default assignments
				a.setIsDefault(false);
			}
		}
		for (VariableAssignment a : MtcUtil.getAllVariableAssignments(m)) {
			if (qvtuConfiguration.isMtoL(a) || qvtuConfiguration.isRtoM(a) || qvtuConfiguration.isMtoM(a)) {
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
			if (qvtuConfiguration.isInputDomain((Area) d)) {
				d.setIsEnforceable(false);
				d.setIsCheckable(true);
			} else {
				if (qvtuConfiguration.isCheckMode()) {
					d.setIsEnforceable(false);
				} else if (qvtuConfiguration.isEnforceMode()) {
					d.setIsCheckable(false);
				}
			}
		}
		for (Mapping lm : ClassUtil.nullFree(m.getLocal())) {
			direct(lm);
		}
	}

	private boolean allReferencedVariablesInInputDomain(@NonNull PropertyAssignment a) {
		for (Variable v : MtcUtil.findReferencedVariables(a)) {
			if (!qvtuConfiguration.isInputDomain(QVTcoreBaseUtil.getContainingArea(v))) {
				return false;
			}
		}
		return true;
	}

	private boolean allReferencedVariablesInOutputDomain(@NonNull Predicate p) {
		for (Variable v : MtcUtil.findReferencedVariables(p.getConditionExpression())) {
			if (!qvtuConfiguration.isOutputDomain(QVTcoreBaseUtil.getContainingArea(v))) {
				return false;
			}
		}
		return true;
	}
}
