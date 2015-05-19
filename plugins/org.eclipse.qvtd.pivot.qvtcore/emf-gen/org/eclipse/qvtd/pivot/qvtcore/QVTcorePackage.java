/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtcore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTcore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvtc";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtcore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull QVTcorePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl <em>Core Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreModel()
	 * @generated
	 */
	int CORE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__ANNOTATING_COMMENTS = QVTbasePackage.BASE_MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_ANNOTATIONS = QVTbasePackage.BASE_MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_COMMENTS = QVTbasePackage.BASE_MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_EXTENSIONS = QVTbasePackage.BASE_MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__NAME = QVTbasePackage.BASE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_CONSTRAINTS = QVTbasePackage.BASE_MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__EXTERNAL_URI = QVTbasePackage.BASE_MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_IMPORTS = QVTbasePackage.BASE_MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_PACKAGES = QVTbasePackage.BASE_MODEL__OWNED_PACKAGES;

	/**
	 * The number of structural features of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_FEATURE_COUNT = QVTbasePackage.BASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ANNOTATING_COMMENTS = QVTcoreBasePackage.ABSTRACT_MAPPING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_ANNOTATIONS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_COMMENTS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_EXTENSIONS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = QVTcoreBasePackage.ABSTRACT_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DOMAIN = QVTcoreBasePackage.ABSTRACT_MAPPING__DOMAIN;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IS_DEFAULT = QVTcoreBasePackage.ABSTRACT_MAPPING__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDES = QVTcoreBasePackage.ABSTRACT_MAPPING__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TRANSFORMATION = QVTcoreBasePackage.ABSTRACT_MAPPING__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDDEN = QVTcoreBasePackage.ABSTRACT_MAPPING__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GUARD_PATTERN = QVTcoreBasePackage.ABSTRACT_MAPPING__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__BOTTOM_PATTERN = QVTcoreBasePackage.ABSTRACT_MAPPING__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONTEXT = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__LOCAL = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refinement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__REFINEMENT = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SPECIFICATION = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 4;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CoreModel
	 * @generated
	 */
	EClass getCoreModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Context();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Specification();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Local();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refinement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Refinement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcoreFactory getQVTcoreFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl <em>Core Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreModel()
		 * @generated
		 */
		EClass CORE_MODEL = eINSTANCE.getCoreModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONTEXT = eINSTANCE.getMapping_Context();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SPECIFICATION = eINSTANCE.getMapping_Specification();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__LOCAL = eINSTANCE.getMapping_Local();

		/**
		 * The meta object literal for the '<em><b>Refinement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__REFINEMENT = eINSTANCE.getMapping_Refinement();

	}

} //QVTcorePackage
