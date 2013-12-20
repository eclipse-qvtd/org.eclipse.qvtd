package org.eclipse.qvtd.debug.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.qvtd.debug.evaluator.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.stubs.ASTSyntheticNode;
import org.eclipse.qvtd.debug.stubs.ASTSyntheticNodeAccess;
import org.eclipse.qvtd.debug.stubs.EvaluationUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

/**
 * Helps to build QVT stack trace from a given state of QVT code execution.
 */
public class QvtStackTraceBuilder {
	
	private static final String UNKNOWN_NAME = "<Unknown>"; //$NON-NLS-1$
	private static final int UNKNOWN_LINE_NUM = -1;
	
	private IDebugEvaluationEnvironment fEvalEnv;

	/**
	 * Constructs stack trace builder for the given evaluation environment.
	 * 
	 * @param evalEnv
	 *            the evaluation environment representing the top stack trace
	 *            
	 * @param astNodeIPOffset explicit the AST node offset representing the current instruction 
	 *		pointer of execution in a QVT module
	 */
	public QvtStackTraceBuilder(IDebugEvaluationEnvironment evalEnv) {
		if(evalEnv == null) {
			throw new IllegalArgumentException();
		}
		
		fEvalEnv = evalEnv;
	}
	
	/**
	 * Builds the stack trace corresponding to evaluation environments hierarchy
	 * associated with this builder.
	 * 
	 * @return list of QVT stack elements
	 */
    public List<QVTStackTraceElement> buildStackTrace() {
    	LinkedList<QVTStackTraceElement> elements = new LinkedList<QVTStackTraceElement>();
    	
    	for (IDebugEvaluationEnvironment nextEnv = fEvalEnv; nextEnv != null; nextEnv = nextEnv.getParentEvaluationEnvironment()) {
    		// skip all the root execution environments as they 
    		// are not bound to any module code locations
    		IDebugEvaluationEnvironment parent = nextEnv.getParentEvaluationEnvironment();
			if (parent != null) {
        		// skip all stack frames not running in a module, 
        		// IOW possible non QVT transformation clients
        		if (parent.getTransformation() != null) {		
        			elements.addLast(createStackElement(nextEnv));
        		}
    		}
    	}
    	
    	IDebugEvaluationEnvironment rootEnv = fEvalEnv.getRootEvaluationEnvironment();
    	IDebugEvaluationEnvironment aggregatingEnv = EvaluationUtil.getAggregatingContext(rootEnv);
		if(aggregatingEnv != null) {
			List<QVTStackTraceElement> aggregatedStackTrace = new QvtStackTraceBuilder(aggregatingEnv).buildStackTrace();			
			List<QVTStackTraceElement> result = new ArrayList<QVTStackTraceElement>(elements.size() + aggregatedStackTrace.size());
			result.addAll(elements);
			result.addAll(aggregatedStackTrace);
			return result;
		}
    	return Collections.unmodifiableList(elements);
    }

    private QVTStackTraceElement createStackElement(IDebugEvaluationEnvironment env) {
    	String unitName = null;
    	String moduleName = UNKNOWN_NAME;
    	String operName = UNKNOWN_NAME;
    	int lineNumber = UNKNOWN_LINE_NUM;    	
    	
    	Type module = null;
    	NamedElement operation = env.getOperation();

    	int resultOffset = getCurrentASTOffset(env);
		
    	Transformation currentTransformation = env.getTransformation();
    	if (currentTransformation == null) {
    		throw new IllegalArgumentException("Currently executed model is not set in environment"); //$NON-NLS-1$
    	}
    	
    	moduleName = currentTransformation.getName();
    	
		if(operation == null) {
			// we must be executing a module instance initialization - synthetic constructor
	    	operName = moduleName;
	    	
	    	if (env.getCurrentIP() == module || resultOffset < -1) {
	    		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.getASTNode(module);
		    	if(astNode != null) {
		    		resultOffset = astNode.getStartPosition();
		    	}
	    	}
		} else {
    		operName = operation.getName();	    		
//    		EClassifier contextType = QvtOperationalParserUtil.getContextualType(operation);
//    		if(contextType != null) {
//    			operName = contextType.getName() + "::" + operName;
//    		}
		}

		IModuleSourceInfo sourceInfo = ASTBindingHelper.getModuleSourceBinding(module);
		if(sourceInfo != null) {
			URI uri = sourceInfo.getSourceURI();
			unitName = uri.lastSegment();
			if(resultOffset >= 0) {
				lineNumber = sourceInfo.getLineNumberProvider().getLineNumber(resultOffset);
			}
		}
    	
    	return new QVTStackTraceElement(moduleName, operName, unitName, lineNumber);
    }

	private static int getCurrentASTOffset(IDebugEvaluationEnvironment evalEnv) {
    	// TODO - for cases that AST does not fill all offset
    	// traverse up to the enclosing operation scope, taking the closest 
    	// offset which has been initialized    	
    	Element currentIPObject = evalEnv.getCurrentIP();
    	
    	if (currentIPObject instanceof Element) {
    		Element astNode = (Element) currentIPObject;
    		
			if (ASTBindingHelper.getStartPosition(astNode) < 0 && astNode instanceof VariableExp) {
				// Remark: special processing for implicit source variables represented as
				// synthetic variable expression in AST. These do not have any CST representation
				// but are rather synthetic nodes => point to the call AST
				if (astNode.eContainer() instanceof FeatureCallExp) {
					astNode = (FeatureCallExp) astNode.eContainer();
				}
			}    		
    		
    		return ASTBindingHelper.getStartPosition(astNode);
    	}
    	
		ASTSyntheticNode astNode = ASTSyntheticNodeAccess.getASTNode(currentIPObject);
		if(astNode != null) {
			return astNode.getStartPosition();
		}
    	
    	return -1;
    }
}
