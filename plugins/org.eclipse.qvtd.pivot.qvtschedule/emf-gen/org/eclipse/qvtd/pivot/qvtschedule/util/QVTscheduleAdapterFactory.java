/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage
 * @generated
 */
public class QVTscheduleAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTschedulePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTscheduleAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QVTschedulePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTscheduleSwitch<@Nullable Adapter> modelSwitch =
			new QVTscheduleSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseAbstractDatum(AbstractDatum object) {
				return createAbstractDatumAdapter();
			}
			@Override
			public Adapter caseBasicMappingRegion(BasicMappingRegion object) {
				return createBasicMappingRegionAdapter();
			}
			@Override
			public Adapter caseCastEdge(CastEdge object) {
				return createCastEdgeAdapter();
			}
			@Override
			public Adapter caseClassDatum(ClassDatum object) {
				return createClassDatumAdapter();
			}
			@Override
			public Adapter caseClassDatumAnalysis(ClassDatumAnalysis object) {
				return createClassDatumAnalysisAdapter();
			}
			@Override
			public Adapter caseComposedNode(ComposedNode object) {
				return createComposedNodeAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseConnectionEnd(ConnectionEnd object) {
				return createConnectionEndAdapter();
			}
			@Override
			public Adapter caseConnectionRole(ConnectionRole object) {
				return createConnectionRoleAdapter();
			}
			@Override
			public <CE extends ConnectionEnd> Adapter caseDatumConnection(DatumConnection<CE> object) {
				return createDatumConnectionAdapter();
			}
			@Override
			public Adapter caseDependencyNode(DependencyNode object) {
				return createDependencyNodeAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseEdgeConnection(EdgeConnection object) {
				return createEdgeConnectionAdapter();
			}
			@Override
			public Adapter caseErrorNode(ErrorNode object) {
				return createErrorNodeAdapter();
			}
			@Override
			public Adapter caseExpressionEdge(ExpressionEdge object) {
				return createExpressionEdgeAdapter();
			}
			@Override
			public Adapter caseInputNode(InputNode object) {
				return createInputNodeAdapter();
			}
			@Override
			public Adapter caseIteratedEdge(IteratedEdge object) {
				return createIteratedEdgeAdapter();
			}
			@Override
			public Adapter caseIteratorNode(IteratorNode object) {
				return createIteratorNodeAdapter();
			}
			@Override
			public Adapter caseLoadingRegion(LoadingRegion object) {
				return createLoadingRegionAdapter();
			}
			@Override
			public Adapter caseMappingAction(MappingAction object) {
				return createMappingActionAdapter();
			}
			@Override
			public Adapter caseMappingRegion(MappingRegion object) {
				return createMappingRegionAdapter();
			}
			@Override
			public Adapter caseMicroMappingRegion(MicroMappingRegion object) {
				return createMicroMappingRegionAdapter();
			}
			@Override
			public Adapter caseNamedMappingRegion(NamedMappingRegion object) {
				return createNamedMappingRegionAdapter();
			}
			@Override
			public Adapter caseNavigableEdge(NavigableEdge object) {
				return createNavigableEdgeAdapter();
			}
			@Override
			public Adapter caseNavigationEdge(NavigationEdge object) {
				return createNavigationEdgeAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseNodeConnection(NodeConnection object) {
				return createNodeConnectionAdapter();
			}
			@Override
			public Adapter caseNullNode(NullNode object) {
				return createNullNodeAdapter();
			}
			@Override
			public Adapter caseOperationNode(OperationNode object) {
				return createOperationNodeAdapter();
			}
			@Override
			public Adapter caseOperationRegion(OperationRegion object) {
				return createOperationRegionAdapter();
			}
			@Override
			public Adapter casePatternTypedNode(PatternTypedNode object) {
				return createPatternTypedNodeAdapter();
			}
			@Override
			public Adapter casePatternVariableNode(PatternVariableNode object) {
				return createPatternVariableNodeAdapter();
			}
			@Override
			public Adapter casePredicateEdge(PredicateEdge object) {
				return createPredicateEdgeAdapter();
			}
			@Override
			public Adapter casePropertyDatum(PropertyDatum object) {
				return createPropertyDatumAdapter();
			}
			@Override
			public Adapter caseRecursionEdge(RecursionEdge object) {
				return createRecursionEdgeAdapter();
			}
			@Override
			public Adapter caseRegion(Region object) {
				return createRegionAdapter();
			}
			@Override
			public Adapter caseRole(Role object) {
				return createRoleAdapter();
			}
			@Override
			public Adapter caseScheduleModel(ScheduleModel object) {
				return createScheduleModelAdapter();
			}
			@Override
			public Adapter caseScheduledRegion(ScheduledRegion object) {
				return createScheduledRegionAdapter();
			}
			@Override
			public Adapter caseSymbolable(Symbolable object) {
				return createSymbolableAdapter();
			}
			@Override
			public Adapter caseTrueNode(TrueNode object) {
				return createTrueNodeAdapter();
			}
			@Override
			public Adapter caseUnknownNode(UnknownNode object) {
				return createUnknownNodeAdapter();
			}
			@Override
			public Adapter caseVariableNode(VariableNode object) {
				return createVariableNodeAdapter();
			}
			@Override
			public Adapter caseDomainUsage(DomainUsage object) {
				return createDomainUsageAdapter();
			}
			@Override
			public Adapter caseGraphEdge(GraphEdge object) {
				return createGraphEdgeAdapter();
			}
			@Override
			public Adapter caseGraphNode(GraphNode object) {
				return createGraphNodeAdapter();
			}
			@Override
			public Adapter caseToDOTable(ToDOTable object) {
				return createToDOTableAdapter();
			}
			@Override
			public Adapter caseVisitable(Visitable object) {
				return createVisitableAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseNamespace(Namespace object) {
				return createNamespaceAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum
	 * @generated
	 */
	public Adapter createAbstractDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion <em>Basic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion
	 * @generated
	 */
	public Adapter createBasicMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge <em>Cast Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge
	 * @generated
	 */
	public Adapter createCastEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum
	 * @generated
	 */
	public Adapter createClassDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis <em>Class Datum Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis
	 * @generated
	 */
	public Adapter createClassDatumAnalysisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ComposedNode <em>Composed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ComposedNode
	 * @generated
	 */
	public Adapter createComposedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @generated
	 */
	public Adapter createConnectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @generated
	 */
	public Adapter createConnectionRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection <em>Datum Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection
	 * @generated
	 */
	public Adapter createDatumConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyNode
	 * @generated
	 */
	public Adapter createDependencyNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection <em>Edge Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection
	 * @generated
	 */
	public Adapter createEdgeConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel <em>Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel
	 * @generated
	 */
	public Adapter createScheduleModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion <em>Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion
	 * @generated
	 */
	public Adapter createScheduledRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @generated
	 */
	public Adapter createSymbolableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.TrueNode <em>True Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TrueNode
	 * @generated
	 */
	public Adapter createTrueNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.UnknownNode <em>Unknown Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.UnknownNode
	 * @generated
	 */
	public Adapter createUnknownNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode <em>Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode
	 * @generated
	 */
	public Adapter createVariableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage <em>Domain Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage
	 * @generated
	 */
	public Adapter createDomainUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge <em>Graph Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge
	 * @generated
	 */
	public Adapter createGraphEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode <em>Graph Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode
	 * @generated
	 */
	public Adapter createGraphNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable <em>To DO Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable
	 * @generated
	 */
	public Adapter createToDOTableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ErrorNode <em>Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ErrorNode
	 * @generated
	 */
	public Adapter createErrorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge <em>Expression Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge
	 * @generated
	 */
	public Adapter createExpressionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.InputNode <em>Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.InputNode
	 * @generated
	 */
	public Adapter createInputNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge <em>Iterated Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge
	 * @generated
	 */
	public Adapter createIteratedEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratorNode <em>Iterator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratorNode
	 * @generated
	 */
	public Adapter createIteratorNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion <em>Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion
	 * @generated
	 */
	public Adapter createLoadingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction
	 * @generated
	 */
	public Adapter createMappingActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion <em>Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion
	 * @generated
	 */
	public Adapter createMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion <em>Micro Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion
	 * @generated
	 */
	public Adapter createMicroMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion <em>Named Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion
	 * @generated
	 */
	public Adapter createNamedMappingRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge <em>Navigable Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge
	 * @generated
	 */
	public Adapter createNavigableEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge <em>Navigation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge
	 * @generated
	 */
	public Adapter createNavigationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection <em>Node Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection
	 * @generated
	 */
	public Adapter createNodeConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullNode <em>Null Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullNode
	 * @generated
	 */
	public Adapter createNullNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationNode
	 * @generated
	 */
	public Adapter createOperationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion <em>Operation Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion
	 * @generated
	 */
	public Adapter createOperationRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode <em>Pattern Typed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode
	 * @generated
	 */
	public Adapter createPatternTypedNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode <em>Pattern Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode
	 * @generated
	 */
	public Adapter createPatternVariableNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge <em>Predicate Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge
	 * @generated
	 */
	public Adapter createPredicateEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum
	 * @generated
	 */
	public Adapter createPropertyDatumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge <em>Recursion Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge
	 * @generated
	 */
	public Adapter createRecursionEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.pivot.qvtschedule.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region
	 * @generated
	 */
	public Adapter createRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.util.Visitable
	 * @generated
	 */
	public Adapter createVisitableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.utilities.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.utilities.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Namespace
	 * @generated
	 */
	public Adapter createNamespaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //QVTscheduleAdapterFactory
