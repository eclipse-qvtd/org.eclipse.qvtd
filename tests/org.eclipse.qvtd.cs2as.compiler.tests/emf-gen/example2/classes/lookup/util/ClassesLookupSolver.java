/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/example2/Classes.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.lookup.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import example2.classes.util.ClassesUnqualifiedClassLookupVisitor;
import example2.classes.util.ClassesUnqualifiedOperationLookupVisitor;
import example2.classes.util.ClassesUnqualifiedPackageLookupVisitor;
import example2.classes.util.ClassesUnqualifiedPropertyLookupVisitor;
import example2.classes.util.ClassesExportedPropertyLookupVisitor;
import example2.classes.util.ClassesExportedOperationLookupVisitor;
import example2.classes.util.ClassesQualifiedClassLookupVisitor;
import example2.classes.util.ClassesQualifiedOperationLookupVisitor;
import example2.classes.util.ClassesQualifiedPackageLookupVisitor;
import example2.classes.util.ClassesQualifiedPropertyLookupVisitor;


public class ClassesLookupSolver {
	
	protected final @NonNull Executor executor;
	
	public ClassesLookupSolver (@NonNull Executor executor) {
		this.executor = executor;
	}
	
	
	public ClassesLookupResult<example2.classes.Operation> _lookupExportedOperation(example2.classes.Class context, java.lang.Object importer, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesExportedOperationLookupVisitor _lookupVisitor = new ClassesExportedOperationLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupExportedProperty(example2.classes.Class context, java.lang.Object importer, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesExportedPropertyLookupVisitor _lookupVisitor = new ClassesExportedPropertyLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
	
	public ClassesLookupResult<example2.classes.Operation> _lookupQualifiedOperation(example2.classes.Class context, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesQualifiedOperationLookupVisitor _lookupVisitor = new ClassesQualifiedOperationLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupQualifiedProperty(example2.classes.Class context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesQualifiedPropertyLookupVisitor _lookupVisitor = new ClassesQualifiedPropertyLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
	
	public ClassesLookupResult<example2.classes.Class> _lookupQualifiedClass(example2.classes.Package context, java.lang.String cName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.CLASS,cName);
		ClassesQualifiedClassLookupVisitor _lookupVisitor = new ClassesQualifiedClassLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Class>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Class.class));
	}
	
	public ClassesLookupResult<example2.classes.Package> _lookupQualifiedPackage(example2.classes.Package context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PACKAGE,pName);
		ClassesQualifiedPackageLookupVisitor _lookupVisitor = new ClassesQualifiedPackageLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Package>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Package.class));
	}
	
	public ClassesLookupResult<example2.classes.Class> _lookupUnqualifiedClass(example2.classes.util.Visitable context, java.lang.String cName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.CLASS,cName);
		ClassesUnqualifiedClassLookupVisitor _lookupVisitor = new ClassesUnqualifiedClassLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Class>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Class.class));
	}
	
	public ClassesLookupResult<example2.classes.Operation> _lookupUnqualifiedOperation(example2.classes.util.Visitable context, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesUnqualifiedOperationLookupVisitor _lookupVisitor = new ClassesUnqualifiedOperationLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Package> _lookupUnqualifiedPackage(example2.classes.util.Visitable context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PACKAGE,pName);
		ClassesUnqualifiedPackageLookupVisitor _lookupVisitor = new ClassesUnqualifiedPackageLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Package>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Package.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupUnqualifiedProperty(example2.classes.util.Visitable context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesUnqualifiedPropertyLookupVisitor _lookupVisitor = new ClassesUnqualifiedPropertyLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
}
