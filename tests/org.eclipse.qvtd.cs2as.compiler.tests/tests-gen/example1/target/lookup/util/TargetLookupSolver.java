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

import example1.target.util.TargetQualifiedLookupVisitor;
import example1.target.util.TargetUnqualifiedLookupVisitor;


public class TargetLookupSolver {
	
	private Executor executor;
		
	public TargetLookupSolver (Executor executor) {
		this.executor = executor;
	}
	
	
	public TargetLookupResult<example1.target.B> _lookupQualifiedB(example1.target.A1 context, java.lang.String bName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.B,bName);
		TargetQualifiedLookupVisitor _lookupVisitor = new TargetQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.B>
				(_lookupEnv.getNamedElementsByKind(example1.target.B.class));
	}
	
	public TargetLookupResult<example1.target.C> _lookupQualifiedC(example1.target.A2 context, java.lang.String cName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.C,cName);
		TargetQualifiedLookupVisitor _lookupVisitor = new TargetQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.C>
				(_lookupEnv.getNamedElementsByKind(example1.target.C.class));
	}
	
	public TargetLookupResult<example1.target.A1> _lookupA1(example1.target.util.Visitable context, java.lang.String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A1,aName);
		TargetUnqualifiedLookupVisitor _lookupVisitor = new TargetUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A1>
				(_lookupEnv.getNamedElementsByKind(example1.target.A1.class));
	}
	
	public TargetLookupResult<example1.target.A2> _lookupA2(example1.target.util.Visitable context, java.lang.String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A2,aName);
		TargetUnqualifiedLookupVisitor _lookupVisitor = new TargetUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A2>
				(_lookupEnv.getNamedElementsByKind(example1.target.A2.class));
	}
	
	public TargetLookupResult<example1.target.B> _lookupB(example1.target.util.Visitable context, java.lang.String bName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.B,bName);
		TargetUnqualifiedLookupVisitor _lookupVisitor = new TargetUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.B>
				(_lookupEnv.getNamedElementsByKind(example1.target.B.class));
	}
	
	public TargetLookupResult<example1.target.C> _lookupC(example1.target.util.Visitable context, java.lang.String cName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.C,cName);
		TargetUnqualifiedLookupVisitor _lookupVisitor = new TargetUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.C>
				(_lookupEnv.getNamedElementsByKind(example1.target.C.class));
	}
}
