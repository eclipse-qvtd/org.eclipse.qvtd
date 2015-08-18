/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.lookup.util;

import org.eclipse.ocl.pivot.evaluation.Executor;

public class TargetLookupSolver {
	
	private Executor executor;
		
	public TargetLookupSolver (Executor executor) {
		this.executor = executor;
	}
	
	
	public TargetLookupResult<example1.target.B> _lookupQualifiedB(example1.target.A1 fromElement, String bName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.B, bName);
		TargetQualificationLookupVisitor _lookupVisitor = new TargetQualificationLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.B>
				(_lookupEnv.getNamedElementsByKind(example1.target.B.class));
	}
	
	public TargetLookupResult<example1.target.C> _lookupQualifiedC(example1.target.A2 fromElement, String cName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.C, cName);
		TargetQualificationLookupVisitor _lookupVisitor = new TargetQualificationLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.C>
				(_lookupEnv.getNamedElementsByKind(example1.target.C.class));
	}
	
	public TargetLookupResult<example1.target.A1> _lookupA1(example1.target.util.Visitable fromElement, String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A1, aName);
		TargetDefaultLookupVisitor _lookupVisitor = new TargetDefaultLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A1>
				(_lookupEnv.getNamedElementsByKind(example1.target.A1.class));
	}
	
	public TargetLookupResult<example1.target.A2> _lookupA2(example1.target.util.Visitable fromElement, String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A2, aName);
		TargetDefaultLookupVisitor _lookupVisitor = new TargetDefaultLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A2>
				(_lookupEnv.getNamedElementsByKind(example1.target.A2.class));
	}
	
	public TargetLookupResult<example1.target.B> _lookupB(example1.target.util.Visitable fromElement, String bName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.B, bName);
		TargetDefaultLookupVisitor _lookupVisitor = new TargetDefaultLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.B>
				(_lookupEnv.getNamedElementsByKind(example1.target.B.class));
	}
	
	public TargetLookupResult<example1.target.C> _lookupC(example1.target.util.Visitable fromElement, String cName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.C, cName);
		TargetDefaultLookupVisitor _lookupVisitor = new TargetDefaultLookupVisitor(_lookupEnv);
		fromElement.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.C>
				(_lookupEnv.getNamedElementsByKind(example1.target.C.class));
	}
}
