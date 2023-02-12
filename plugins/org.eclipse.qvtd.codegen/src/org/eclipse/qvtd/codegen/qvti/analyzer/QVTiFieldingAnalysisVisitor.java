package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer.ReturnState;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiFieldingAnalysisVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;

public class QVTiFieldingAnalysisVisitor extends AbstractQVTiFieldingAnalysisVisitor
{
	public QVTiFieldingAnalysisVisitor(@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn) {
		super(context, requiredReturn);
	}

	@Override
	protected @NonNull QVTiFieldingAnalysisVisitor getMustBeThrownVisitor() {
		return (QVTiFieldingAnalysisVisitor)super.getMustBeThrownVisitor();
	}

	/*	@Override
	protected @NonNull FieldingAnalysisVisitor getNestedVisitor(@NonNull CGOperation cgOperation) {
		Operation asOperation = CGUtil.getAST(cgOperation);
		if (asOperation instanceof Iteration) {
			return asOperation.isIsValidating() ? getMustBeCaughtVisitor() : getMustBeThrownVisitor();		// Perhaps nothing can be caught in QVTi
		}
		return super.getNestedVisitor(cgOperation);
	} */

	@Override
	public @NonNull ReturnState visitCGAccumulator(@NonNull CGAccumulator cgAccumulator) {
		if (!(cgAccumulator.getAst() instanceof BufferStatement)) {
			return super.visitCGAccumulator(cgAccumulator);
		}
		assert cgAccumulator.getInit() == null;
		//	if (!cgAccumulator.isNonInvalid()) {
		//		cgAccumulator.isNonInvalid();		// XXX
		//	}
		assert cgAccumulator.isNonInvalid();
		cgAccumulator.setCaught(false);
		return ReturnState.IS_VALID;
	}

	@Override
	public @NonNull ReturnState visitCGMapping(@NonNull CGMapping object) {
		if (object.toString().contains("mFtoP1__Daughter2Female__persons")) {
			getClass();			// XXX
		}
		return super.visitCGMapping(object);
	}

	@Override
	public @NonNull ReturnState visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		QVTiFieldingAnalysisVisitor mustBeThrownVisitor = getMustBeThrownVisitor();
		if (mustBeThrownVisitor != this) {
			return mustBeThrownVisitor.visit(cgMappingCall);
		}
		else {
			return super.visitCGMappingCall(cgMappingCall);
		}
	}

	@Override
	public @NonNull ReturnState visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		String s = String.valueOf(cgMappingLoop.getAst());
		//	System.out.println("\t" + s);
		if (s.contains("select(")) {
			getClass();		// XXX
		}
		QVTiFieldingAnalysisVisitor mustBeThrownVisitor = getMustBeThrownVisitor();
		mustBeThrownVisitor.visit(CGUtil.getSource(cgMappingLoop));
		for (CGIterator cgIterator : CGUtil.getIterators(cgMappingLoop)) {
			mustBeThrownVisitor.visit(cgIterator);
		}
		for (CGIterator cgCoIterator : CGUtil.getCoIterators(cgMappingLoop)) {
			mustBeThrownVisitor.visit(cgCoIterator);
		}
		CGValuedElement cgBody = CGUtil.getBody(cgMappingLoop);
		mustBeThrownVisitor.visit(cgBody);
		// Although individual body evaluations are executed concurrently, the preamble is thrown.
		cgMappingLoop.setCaught(false);
		return ReturnState.IS_THROWN;
	}

	/*		@Override
	public @NonNull Boolean visitCGMappingLoop(@NonNull CGMappingLoop cgElement) {
		//			return visitCGIterationCallExp(object);
		rewriteAsThrown(cgElement.getSource());
		for (CGIterator cgIterator : cgElement.getIterators()) {
			cgIterator.accept(this);
		}
		//			if (cgElement.getReferredIteration().isValidating()) {
		//				rewriteAsCaught(cgElement.getBody());
		//			}
		//			else {
		rewriteAsThrown(cgElement.getBody());
		//			}
		cgElement.setCaught(false);
		return false;
	} */

	@Override
	public @NonNull ReturnState visitCGVariable(@NonNull CGVariable cgVariable) {
		CGValuedElement cgInit = cgVariable.getInit();
		if (cgInit != null) {
			return super.visitCGVariable(cgVariable);
		}
		VariableDeclaration asVariable = CGUtil.getAST(cgVariable);
		assert asVariable instanceof NewStatement;
		cgVariable.setCaught(false);
		return ReturnState.IS_VALID;			// XXX ???
	}

	/*	@Override
	public @NonNull ReturnState visitCGVariableExp(@NonNull CGVariableExp cgVariableExp) {
		CGVariable cgVariable = CGUtil.getReferredVariable(cgVariableExp);
		Element asVariable = cgVariable.getAst();
		if (asVariable instanceof NewStatement) {		// XXX
			getClass();
		}
		if (!(asVariable instanceof NewStatement) && !(asVariable instanceof OppositePropertyCallExp)) {		// XXX
			return super.visitCGVariableExp(cgVariableExp);
		}
		if (!cgVariable.isNonInvalid()) {			// If the CGVariable could be invalid
			if (!cgVariable.isCaught()) {
				CGValuedElement cgInit = cgVariable.getInit();
				assert cgInit == null;
			}
			if (requiredReturn == ReturnState.IS_THROWN) {
				insertThrow(cgVariableExp);
			}
		}
		cgVariableExp.setCaught(cgVariable.isCaught());
		return requiredReturn;
	} */
}