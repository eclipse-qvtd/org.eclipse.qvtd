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
import example2.classes.util.ClassesUnqualifiedLookupVisitor;
import example2.classes.util.ClassesQualifiedLookupVisitor;
import example2.classes.util.ClassesExportedLookupVisitor;

public class ClassesLookupSolver {
	
	protected final @NonNull Executor executor;
	
	public ClassesLookupSolver (@NonNull Executor executor) {
		this.executor = executor;
	}
	
	
	public ClassesLookupResult<example2.classes.Operation> _lookupExportedOperation(example2.classes.Class context, java.lang.Object importer, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesExportedLookupVisitor _lookupVisitor = new ClassesExportedLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupExportedProperty(example2.classes.Class context, java.lang.Object importer, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesExportedLookupVisitor _lookupVisitor = new ClassesExportedLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
	
	public ClassesLookupResult<example2.classes.Operation> _lookupQualifiedOperation(example2.classes.Class context, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesQualifiedLookupVisitor _lookupVisitor = new ClassesQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupQualifiedProperty(example2.classes.Class context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesQualifiedLookupVisitor _lookupVisitor = new ClassesQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
	
	public ClassesLookupResult<example2.classes.Class> _lookupQualifiedClass(example2.classes.Package context, java.lang.String cName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.CLASS,cName);
		ClassesQualifiedLookupVisitor _lookupVisitor = new ClassesQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Class>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Class.class));
	}
	
	public ClassesLookupResult<example2.classes.Package> _lookupQualifiedPackage(example2.classes.Package context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PACKAGE,pName);
		ClassesQualifiedLookupVisitor _lookupVisitor = new ClassesQualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Package>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Package.class));
	}
	
	public ClassesLookupResult<example2.classes.Class> _lookupClass(example2.classes.util.Visitable context, java.lang.String cName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.CLASS,cName);
		ClassesUnqualifiedLookupVisitor _lookupVisitor = new ClassesUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Class>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Class.class));
	}
	
	public ClassesLookupResult<example2.classes.Operation> _lookupOperation(example2.classes.util.Visitable context, java.lang.String oName, java.util.List<example2.classes.Argument> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.OPERATION,oName,filter);
		ClassesUnqualifiedLookupVisitor _lookupVisitor = new ClassesUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Operation>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Operation.class));
	}
	
	public ClassesLookupResult<example2.classes.Package> _lookupPackage(example2.classes.util.Visitable context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PACKAGE,pName);
		ClassesUnqualifiedLookupVisitor _lookupVisitor = new ClassesUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Package>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Package.class));
	}
	
	public ClassesLookupResult<example2.classes.Property> _lookupProperty(example2.classes.util.Visitable context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PROPERTY,pName);
		ClassesUnqualifiedLookupVisitor _lookupVisitor = new ClassesUnqualifiedLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Property>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Property.class));
	}
}
