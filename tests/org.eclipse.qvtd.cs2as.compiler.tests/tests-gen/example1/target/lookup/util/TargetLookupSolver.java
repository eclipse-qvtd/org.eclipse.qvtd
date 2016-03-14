/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example1/TargetMM1.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example1.target.lookup.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;

import example1.target.util.TargetQualifiedLookupVisitor;
import example1.target.util.TargetUnqualifiedA1LookupVisitor;
import example1.target.util.TargetUnqualifiedA2LookupVisitor;
import example1.target.util.TargetUnqualifiedBLookupVisitor;
import example1.target.util.TargetUnqualifiedCLookupVisitor;

public class TargetLookupSolver {
	
	protected final @NonNull Executor executor;
	
	public TargetLookupSolver (@NonNull Executor executor) {
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
	
	public TargetLookupResult<example1.target.A1> _lookupUnqualifiedA1(example1.target.util.Visitable context, java.lang.String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A1,aName);
		TargetUnqualifiedA1LookupVisitor _lookupVisitor = new TargetUnqualifiedA1LookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A1>
				(_lookupEnv.getNamedElementsByKind(example1.target.A1.class));
	}
	
	public TargetLookupResult<example1.target.A2> _lookupUnqualifiedA2(example1.target.util.Visitable context, java.lang.String aName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.A2,aName);
		TargetUnqualifiedA2LookupVisitor _lookupVisitor = new TargetUnqualifiedA2LookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.A2>
				(_lookupEnv.getNamedElementsByKind(example1.target.A2.class));
	}
	
	public TargetLookupResult<example1.target.B> _lookupUnqualifiedB(example1.target.util.Visitable context, java.lang.String bName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.B,bName);
		TargetUnqualifiedBLookupVisitor _lookupVisitor = new TargetUnqualifiedBLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.B>
				(_lookupEnv.getNamedElementsByKind(example1.target.B.class));
	}
	
	public TargetLookupResult<example1.target.C> _lookupUnqualifiedC(example1.target.util.Visitable context, java.lang.String cName) {
		TargetSingleResultLookupEnvironment _lookupEnv = new TargetSingleResultLookupEnvironment(executor, example1.target.TargetPackage.Literals.C,cName);
		TargetUnqualifiedCLookupVisitor _lookupVisitor = new TargetUnqualifiedCLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new TargetLookupResultImpl<example1.target.C>
				(_lookupEnv.getNamedElementsByKind(example1.target.C.class));
	}
}
