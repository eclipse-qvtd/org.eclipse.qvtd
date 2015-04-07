/**
 */
package example1.target.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import example1.target.A3;
import example1.target.TargetPackage;
import example1.target.util.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A3</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class A3Impl extends A2Impl implements A3 {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TargetPackage.Literals.A3;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitA3(this);
	}

} //A3Impl
