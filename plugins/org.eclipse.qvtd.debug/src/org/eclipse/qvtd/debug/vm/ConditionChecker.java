/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.debug.utils.DebugUtils;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;

public class ConditionChecker {

	public static final int ERR_CODE_COMPILATION = 100;
	public static final int ERR_CODE_EVALUATION = 110;
	
	private final String fConditionBody;
	private final Element fTargetASTElement;
	
	private OCLExpression fConditionAST;
	private IStatus fConditionError;


	public ConditionChecker(String conditionBody, Element targetASTElement) {
		if(conditionBody == null || targetASTElement == null) {
			throw new IllegalArgumentException();
		}
		
		fConditionBody = conditionBody;
		fTargetASTElement = targetASTElement;
	}
		
	public Object evaluate(DebugQVTiEvaluationVisitor mainEvaluator) throws CoreException {
		OCLExpression condition = null; //getConditionAST();
		if (fConditionError != null) {
			throw new CoreException(fConditionError);
		}
		
		assert condition != null;
		// FIXME - use a watching thread to interrupt infinite loop execution
		EvaluationEnvironment evalEnv = DebugUtils.cloneEvaluationEnv(mainEvaluator.getEvaluationEnvironment());
		QVTiEvaluationVisitorImpl dedicatedVisitor = new QVTiEvaluationVisitorImpl(mainEvaluator.getEnvironment(), evalEnv, null);

		try {
			return condition.accept(dedicatedVisitor);
		} catch (Throwable e) {
			throw new CoreException(QVTODebugCore.createError(
					e.toString(), ERR_CODE_EVALUATION, e));
		}
	}

	public boolean checkCondition(DebugQVTiEvaluationVisitor mainEvaluator) throws CoreException {
		return Boolean.TRUE.equals(evaluate(mainEvaluator));
	}
	
	public Type getConditionType() {
		if (fConditionAST != null) { 
			return fConditionAST.getType();
		}
		return null;
	}
	

/*    private ASTElementContextEnv getEnvironmentForASTElement() {
		QvtOperationalEnvFactory factory = new QvtOperationalEnvFactory();
		QvtOperationalEnv rootEnv = null;

    	EObject moduleContext = fTargetASTElement;    	
    	while(moduleContext != null) {
    		if(moduleContext instanceof Module) {
    			rootEnv = QVTODebugUtil.getEnvironment((Module) moduleContext);
    			break;
    		}
    		moduleContext = moduleContext.eContainer();
    	}

    	if(rootEnv == null) {
    		rootEnv = factory.createEnvironment();
    	}

		QvtOperationalEnv contextEnv = null;    	
    	EObject operContext = fTargetASTElement;    	
    	while(operContext != null) {
    		if(operContext instanceof EOperation) {
    			contextEnv = factory.createOperationContext(rootEnv, (EOperation) operContext);
    		}
    		operContext = operContext.eContainer();
    	}
    	
    	if(contextEnv == null) {
    		contextEnv = rootEnv;
    	}
    	
    	ASTElementContextEnv targetContextEnv = new ASTElementContextEnv(contextEnv, fTargetASTElement);
		return targetContextEnv;
    } */
    
/*	private OCLExpression<EClassifier> getConditionAST() {
		if(fConditionError != null) {
			return null;
		}

		if (fConditionAST == null) { 
			fConditionAST = analyzeCondition();
		}
		
		return fConditionAST;
	} */
	    
/*    private OCLExpressionCS parseCondition(QvtOperationalEnv env) {    	
        try {        	
            QVTOLexer lexer = new QVTOLexer(env, new OCLInput(fConditionBody).getContent());
            
            LightweightParser parser = new LightweightParser(lexer);            
            parser.enableCSTTokens(true);
            parser.getIPrsStream().resetTokenStream();            
            lexer.lexer(parser.getIPrsStream());
            CSTNode cst = parser.parser(10);
            if(cst instanceof OCLExpressionCS) {
            	return (OCLExpressionCS) cst;
            }		
            
            env.reportError("Not an OCL expression", -1, -1); //$NON-NLS-1$
        } catch (ParserException ex) {
        	// add parser error to environment
            env.reportError(ex.toString(), -1, -1);            
        }
        
        return null;
    } */

/*    private OCLExpression<EClassifier> analyzeCondition()  {
    	ASTElementContextEnv env = getEnvironmentForASTElement();
        OCLExpressionCS conditionCS = parseCondition(env);		
        OCLExpression<EClassifier> ast = null;
        
        if (conditionCS != null && !env.hasErrors()) {
            OCLLexer oclLexer = new OCLLexer(env, new char[0]);
            
            QvtCompilerOptions options = new QvtCompilerOptions(); 
            options.setReportErrors(true);
            options.setShowAnnotations(false);
            options.setSourceLineNumbersEnabled(false);
            try {
	            QvtOperationalVisitorCS visitor = new QvtOperationalVisitorCS(oclLexer, env, options);            
	            ast = visitor.analyzeExpressionCS(conditionCS, env);
	            if(ast == null) { // || ast.getType() != env.getOCLStandardLibrary().getBoolean()) {
	            	//env.reportError("Boolean type condition required", conditionCS);
	            	env.reportError("Invalid expression", conditionCS);
	            }
            } catch (Throwable e) {
            	fConditionError = QVTODebugCore.createError("Failed to parse condition", ERR_CODE_COMPILATION,  e);
            	QVTODebugCore.log(e);
            	return null;
			}
        }

    	if(env.hasErrors()) {
    		fConditionError = QVTODebugCore.createError(env.getErrorTxtBuffer().toString(), ERR_CODE_COMPILATION, null);
    	}
    	
        return ast;
    } */
}
