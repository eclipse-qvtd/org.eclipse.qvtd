package org.eclipse.qvtd.debug.vm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrame;
import org.eclipse.qvtd.debug.vm.protocol.VMVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

public class VMUtils
{
	public static @Nullable VMStackFrame createStackFrame(long frameID, List<UnitLocation> stack) {	
		UnitLocation location = lookupEnvironmentByID(frameID, stack);
		if (location != null) {
			return createStackFrame(location);
		}

		// invalid stack frame
		return null;
	}
	
	public static VMStackFrame[] createStackFrame(List<UnitLocation> stack) {
		List<VMStackFrame> result = new ArrayList<VMStackFrame>();
		
		int i = 0;
		for (UnitLocation location : stack) {
			// include variables only for the current (top level) stack
			result.add(createStackFrame(location, i++ == 0));
		}

		return result.toArray(new VMStackFrame[result.size()]);
	}
	
	public static VMStackFrame createStackFrame(UnitLocation location) {
		return createStackFrame(location, true);
	}
	
	private static VMStackFrame createStackFrame(UnitLocation location, boolean includeVars) {
		IDebugEvaluationEnvironment evalEnv = location.getEvalEnv();
		Type module = location.getModule();
		String moduleName = (module != null) ? module.getName() : "<null>"; //$NON-NLS-1$
		
		NamedElement operation = location.getOperation();
		String operSignature = (operation != null) ? getOperationSignature(operation)
				: null; //MessageFormat.format("<{0}>", moduleName); //$NON-NLS-1$
		
		List<VMVariable> vars = VariableFinder.getVariables(evalEnv);
		VMStackFrame vmStackFrame = new VMStackFrame(evalEnv.getID(), location.getURI().toString(), moduleName, 
					operSignature, location.getLineNum(), location.getStartPosition(), location.getEndPosition(), vars.toArray(new VMVariable[vars.size()]));
		return vmStackFrame;
	}
	
	private static String getOperationSignature(NamedElement operation) {
        StringBuilder buf = new StringBuilder();
/*    	EClassifier ctxType = QvtOperationalParserUtil.getContextualType(operation);        
        if (ctxType != null) {
            buf.append(ctxType.getName()).append("::"); //$NON-NLS-1$            
        } */

        buf.append(operation.getName());        
        buf.append('(');
        if (operation instanceof Operation) {
	        boolean isFirst = true;;
	        for (Parameter param : ((Operation)operation).getOwnedParameter()) {
	            if (!isFirst) {
	                buf.append(", ");
	            }
	            Type type = param.getType();
	            buf.append(type.getName());            
	            isFirst = false;
	        }
        }
        else if (operation instanceof Mapping) {
/*	        boolean isFirst = true;;
	        for (Variable param : ((Mapping)operation).getAllVariables()) {
	            if (!isFirst) {
	                buf.append(", ");
	            }
	            Type type = param.getType();
	            buf.append(type.getName());            
	            isFirst = false;
	        } */
        }
        buf.append(')');
        
        return buf.toString();
    }
	
	public static UnitLocation lookupEnvironmentByID(long id, List<UnitLocation> stack) {
		for (UnitLocation location : stack) {
			IDebugEvaluationEnvironment evalEnv = location.getEvalEnv();
			if (evalEnv.getID() == id) {
				return location;
			}
		}

		return null;
	}
}
