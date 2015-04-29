/**
 */
package org.eclipse.qvtd.cs2as.compiler.cgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.util.CS2ASCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Lookup Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CGLookupCallExpImpl extends CGOperationCallExpImpl implements CGLookupCallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGLookupCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CS2ASCGPackage.Literals.CG_LOOKUP_CALL_EXP;
	}
	
	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(CGModelVisitor<R> visitor) {
		return (R) ((CS2ASCGModelVisitor<?>)visitor).visitCGLookupCallExp(this);
	}

	// FIXME use the CGModelSpecs
	@Override
	public boolean isUnboxed() {
		return true;
	}
	
	@Override
	public boolean isBoxed() {
		return false;
	}

} //CGLookupCallExpImpl
