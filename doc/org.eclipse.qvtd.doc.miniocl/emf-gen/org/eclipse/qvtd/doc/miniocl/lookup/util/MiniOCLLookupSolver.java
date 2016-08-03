/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.doc.miniocl.lookup.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLExportedOperationLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLExportedPackageLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLExportedPropertyLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLQualifiedClassLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLQualifiedOperationLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLQualifiedPackageLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLQualifiedPropertyLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedClassLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedNamedElementLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedOperationLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedPackageLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedPropertyLookupVisitor;
import org.eclipse.qvtd.doc.miniocl.util.MiniOCLUnqualifiedVariableLookupVisitor;


public class MiniOCLLookupSolver {
	
	protected final @NonNull Executor executor;
	
	public MiniOCLLookupSolver (@NonNull Executor executor) {
		this.executor = executor;
	}
	
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Operation> _lookupExportedOperation(org.eclipse.qvtd.doc.miniocl.Class context, java.lang.Object importer, java.lang.String oName, java.util.List<org.eclipse.qvtd.doc.miniocl.OCLExpression> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.OPERATION,oName,filter);
		MiniOCLExportedOperationLookupVisitor _lookupVisitor = new MiniOCLExportedOperationLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Operation.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupExportedProperty(org.eclipse.qvtd.doc.miniocl.Class context, java.lang.Object importer, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PROPERTY,pName);
		MiniOCLExportedPropertyLookupVisitor _lookupVisitor = new MiniOCLExportedPropertyLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Property.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Operation> _lookupQualifiedOperation(org.eclipse.qvtd.doc.miniocl.Class context, java.lang.String oName, java.util.List<org.eclipse.qvtd.doc.miniocl.OCLExpression> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.OPERATION,oName,filter);
		MiniOCLQualifiedOperationLookupVisitor _lookupVisitor = new MiniOCLQualifiedOperationLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Operation.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupQualifiedProperty(org.eclipse.qvtd.doc.miniocl.Class context, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PROPERTY,pName);
		MiniOCLQualifiedPropertyLookupVisitor _lookupVisitor = new MiniOCLQualifiedPropertyLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Property.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupQualifiedClass(org.eclipse.qvtd.doc.miniocl.Package context, java.lang.String cName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.CLASS,cName);
		MiniOCLQualifiedClassLookupVisitor _lookupVisitor = new MiniOCLQualifiedClassLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Class>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Class.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Package> _lookupQualifiedPackage(org.eclipse.qvtd.doc.miniocl.Package context, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PACKAGE,pName);
		MiniOCLQualifiedPackageLookupVisitor _lookupVisitor = new MiniOCLQualifiedPackageLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Package.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Package> _lookupExportedPackage(org.eclipse.qvtd.doc.miniocl.Root context, java.lang.Object importer, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PACKAGE,pName);
		MiniOCLExportedPackageLookupVisitor _lookupVisitor = new MiniOCLExportedPackageLookupVisitor(_lookupEnv, importer);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Package.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Class> _lookupUnqualifiedClass(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String cName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.CLASS,cName);
		MiniOCLUnqualifiedClassLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedClassLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Class>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Class.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.NamedElement> _lookupUnqualifiedNamedElement(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String nName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.NAMED_ELEMENT,nName);
		MiniOCLUnqualifiedNamedElementLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedNamedElementLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.NamedElement>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.NamedElement.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Operation> _lookupUnqualifiedOperation(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String oName, java.util.List<org.eclipse.qvtd.doc.miniocl.OCLExpression> args) {
		OperationFilter filter = new OperationFilter(executor, args);
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.OPERATION,oName,filter);
		MiniOCLUnqualifiedOperationLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedOperationLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Operation>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Operation.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Package> _lookupUnqualifiedPackage(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PACKAGE,pName);
		MiniOCLUnqualifiedPackageLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedPackageLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Package>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Package.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Property> _lookupUnqualifiedProperty(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String pName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.PROPERTY,pName);
		MiniOCLUnqualifiedPropertyLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedPropertyLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Property>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Property.class));
	}
	
	public MiniOCLLookupResult<org.eclipse.qvtd.doc.miniocl.Variable> _lookupUnqualifiedVariable(org.eclipse.qvtd.doc.miniocl.util.Visitable context, java.lang.String vName) {
		MiniOCLSingleResultLookupEnvironment _lookupEnv = new MiniOCLSingleResultLookupEnvironment(executor, org.eclipse.qvtd.doc.miniocl.MiniOCLPackage.Literals.VARIABLE,vName);
		MiniOCLUnqualifiedVariableLookupVisitor _lookupVisitor = new MiniOCLUnqualifiedVariableLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new MiniOCLLookupResultImpl<org.eclipse.qvtd.doc.miniocl.Variable>
				(_lookupEnv.getNamedElementsByKind(org.eclipse.qvtd.doc.miniocl.Variable.class));
	}
}
