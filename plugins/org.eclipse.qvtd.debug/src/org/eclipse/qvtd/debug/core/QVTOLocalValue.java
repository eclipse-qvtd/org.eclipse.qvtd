package org.eclipse.qvtd.debug.core;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.data.VMVariable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.VariableFinder;

public class QVTOLocalValue extends QVTOValue {
	
	public static class LocalValue {
		public Object valueObject;
		public EClassifier valueType;
	}
	
	public QVTOLocalValue(IQVTODebugTarget debugTarget, long frameID,
			String[] varPath, LocalValue evalResult, @NonNull IDebugEvaluationEnvironment evaluationEnvironment) {
		super(debugTarget, createVmVar(varPath, evalResult, evaluationEnvironment), frameID);
		myFrameID = frameID;
		this.evaluationEnvironment = evaluationEnvironment;
	}
	
	@Override
	public IVariable[] getVariables() throws DebugException {
		List<VMVariable> variables = requestVariables();
		List<IVariable> result = new ArrayList<IVariable>();
		
		for (VMVariable nextVar : variables) {
			result.add(new QVTOLocalVariable(getQVTODebugTarget(), nextVar, myFrameID, evaluationEnvironment));
		}					
		
		return result.toArray(new IVariable[result.size()]);
	}
	
	@Override
	protected List<VMVariable> requestVariables() throws DebugException {
		List<VMVariable> vars = new ArrayList<VMVariable>();
		new VariableFinder(evaluationEnvironment, true).collectChildVars(vmVar.valueObject,
				VariableFinder.getVariablePath(VariableFinder.parseURI(vmVar.variableURI)), null, vars);
		return vars;
	}
	
	private static VMVariable createVmVar(String[] varPath, LocalValue evalResult, EvaluationEnvironment evalEnv) {
		VMVariable var = new VMVariable();
		var.name = varPath.length > 0 ? varPath[varPath.length-1] : String.valueOf(null);
		var.kind = VMVariable.LOCAL;
		var.variableURI = VariableFinder.createURI(varPath).toString();
		var.valueObject = evalResult.valueObject;
		VariableFinder.setValueAndType(var, evalResult.valueObject, evalResult.valueType, evalEnv);
		return var;
	}

	private final long myFrameID;
	private final @NonNull IDebugEvaluationEnvironment evaluationEnvironment;
}
