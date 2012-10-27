/**
 */
package org.eclipse.qvtd.pivot.qvtcore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CoreModelImpl extends BaseModelImpl implements CoreModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.CORE_MODEL;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTcoreVisitor<R>)visitor).visitCoreModel(this);
	}
} //CoreModelImpl
