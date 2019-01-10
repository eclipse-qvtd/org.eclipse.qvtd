/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/models/SimpleClasses/Classes.genmodel
 * template: org.eclipse.ocl.examples.build.xtend.GenerateAutoLookupInfrastructureXtend
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.lookup.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import example2.classes.util.ClassesUnqualifiedClassLookupVisitor;
import example2.classes.util.ClassesUnqualifiedPackageLookupVisitor;
import example2.classes.util.ClassesQualifiedClassLookupVisitor;
import example2.classes.util.ClassesQualifiedPackageLookupVisitor;


public class ClassesLookupSolver {
	
	protected final @NonNull Executor executor;
	
	public ClassesLookupSolver (@NonNull Executor executor) {
		this.executor = executor;
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
	
	public ClassesLookupResult<example2.classes.Package> _lookupUnqualifiedPackage(example2.classes.util.Visitable context, java.lang.String pName) {
		ClassesSingleResultLookupEnvironment _lookupEnv = new ClassesSingleResultLookupEnvironment(executor, example2.classes.ClassesPackage.Literals.PACKAGE,pName);
		ClassesUnqualifiedPackageLookupVisitor _lookupVisitor = new ClassesUnqualifiedPackageLookupVisitor(_lookupEnv);
		context.accept(_lookupVisitor);
		return new ClassesLookupResultImpl<example2.classes.Package>
				(_lookupEnv.getNamedElementsByKind(example2.classes.Package.class));
	}
}
