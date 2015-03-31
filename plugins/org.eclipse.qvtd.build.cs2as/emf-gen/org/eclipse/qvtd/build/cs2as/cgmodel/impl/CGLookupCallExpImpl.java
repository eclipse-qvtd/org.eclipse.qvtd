/**
 */
package org.eclipse.qvtd.build.cs2as.cgmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.qvtd.build.cs2as.cgmodel.CGLookupCallExp;
import org.eclipse.qvtd.build.cs2as.cgmodel.CS2ASCGPackage;

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
	
	@Override
	public boolean isUnboxed() {
		return true;
	}
	
	@Override
	public boolean isBoxed() {
		return false;
	}
	
	public @Nullable <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return visitor.visitCGOperationCallExp(this);
	}

} //CGLookupCallExpImpl
