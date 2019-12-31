/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtimperativecs.*;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BufferStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeCSFactoryImpl extends EFactoryImpl implements QVTimperativeCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTimperativeCSFactory init() {
		try {
			QVTimperativeCSFactory theQVTimperativeCSFactory = (QVTimperativeCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTimperativeCSPackage.eNS_URI);
			if (theQVTimperativeCSFactory != null) {
				return theQVTimperativeCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTimperativeCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case 0: return createAddStatementCS();
			case 1: return createAppendParameterBindingCS();
			case 2: return createAppendParameterCS();
			case 3: return createBufferStatementCS();
			case 4: return createCheckStatementCS();
			case 5: return createDeclareStatementCS();
			case 6: return createDirectionCS();
			case 7: return createEntryPointCS();
			case 8: return createGuardParameterBindingCS();
			case 9: return createGuardParameterCS();
			case 10: return createLoopParameterBindingCS();
			case 11: return createMappingCS();
			case 12: return createMappingCallCS();
			case 13: return createMappingLoopCS();
			case 17: return createNewStatementCS();
			case 19: return createParamDeclarationCS();
			case 20: return createQueryCS();
			case 21: return createSetStatementCS();
			case 22: return createSimpleParameterBindingCS();
			case 23: return createSimpleParameterCS();
			case 24: return createSpeculateStatementCS();
			case 26: return createTopLevelCS();
			case 27: return createTransformationCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull AddStatementCS createAddStatementCS() {
		AddStatementCSImpl addStatementCS = new AddStatementCSImpl();
		return addStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull AppendParameterBindingCS createAppendParameterBindingCS() {
		AppendParameterBindingCSImpl appendParameterBindingCS = new AppendParameterBindingCSImpl();
		return appendParameterBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull AppendParameterCS createAppendParameterCS() {
		AppendParameterCSImpl appendParameterCS = new AppendParameterCSImpl();
		return appendParameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BufferStatementCS createBufferStatementCS() {
		BufferStatementCSImpl bufferStatementCS = new BufferStatementCSImpl();
		return bufferStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CheckStatementCS createCheckStatementCS() {
		CheckStatementCSImpl checkStatementCS = new CheckStatementCSImpl();
		return checkStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DeclareStatementCS createDeclareStatementCS() {
		DeclareStatementCSImpl declareStatementCS = new DeclareStatementCSImpl();
		return declareStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DirectionCS createDirectionCS() {
		DirectionCSImpl directionCS = new DirectionCSImpl();
		return directionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EntryPointCS createEntryPointCS() {
		EntryPointCSImpl entryPointCS = new EntryPointCSImpl();
		return entryPointCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardParameterBindingCS createGuardParameterBindingCS() {
		GuardParameterBindingCSImpl guardParameterBindingCS = new GuardParameterBindingCSImpl();
		return guardParameterBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardParameterCS createGuardParameterCS() {
		GuardParameterCSImpl guardParameterCS = new GuardParameterCSImpl();
		return guardParameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull LoopParameterBindingCS createLoopParameterBindingCS() {
		LoopParameterBindingCSImpl loopParameterBindingCS = new LoopParameterBindingCSImpl();
		return loopParameterBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCS createMappingCS() {
		MappingCSImpl mappingCS = new MappingCSImpl();
		return mappingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCallCS createMappingCallCS() {
		MappingCallCSImpl mappingCallCS = new MappingCallCSImpl();
		return mappingCallCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingLoopCS createMappingLoopCS() {
		MappingLoopCSImpl mappingLoopCS = new MappingLoopCSImpl();
		return mappingLoopCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ParamDeclarationCS createParamDeclarationCS() {
		ParamDeclarationCSImpl paramDeclarationCS = new ParamDeclarationCSImpl();
		return paramDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull QueryCS createQueryCS() {
		QueryCSImpl queryCS = new QueryCSImpl();
		return queryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NewStatementCS createNewStatementCS() {
		NewStatementCSImpl newStatementCS = new NewStatementCSImpl();
		return newStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SetStatementCS createSetStatementCS() {
		SetStatementCSImpl setStatementCS = new SetStatementCSImpl();
		return setStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SimpleParameterBindingCS createSimpleParameterBindingCS() {
		SimpleParameterBindingCSImpl simpleParameterBindingCS = new SimpleParameterBindingCSImpl();
		return simpleParameterBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SimpleParameterCS createSimpleParameterCS() {
		SimpleParameterCSImpl simpleParameterCS = new SimpleParameterCSImpl();
		return simpleParameterCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpeculateStatementCS createSpeculateStatementCS() {
		SpeculateStatementCSImpl speculateStatementCS = new SpeculateStatementCSImpl();
		return speculateStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeCSPackage getQVTimperativeCSPackage() {
		return (QVTimperativeCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTimperativeCSPackage getPackage() {
		return QVTimperativeCSPackage.eINSTANCE;
	}

} //QVTimperativeCSTFactoryImpl
