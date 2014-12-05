package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.AnyType;
import org.eclipse.ocl.examples.pivot.AssociationClass;
import org.eclipse.ocl.examples.pivot.AssociationClassCallExp;
import org.eclipse.ocl.examples.pivot.BagType;
import org.eclipse.ocl.examples.pivot.Behavior;
import org.eclipse.ocl.examples.pivot.BooleanLiteralExp;
import org.eclipse.ocl.examples.pivot.CallExp;
import org.eclipse.ocl.examples.pivot.CallOperationAction;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.CollectionItem;
import org.eclipse.ocl.examples.pivot.CollectionLiteralExp;
import org.eclipse.ocl.examples.pivot.CollectionLiteralPart;
import org.eclipse.ocl.examples.pivot.CollectionRange;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Comment;
import org.eclipse.ocl.examples.pivot.ConnectionPointReference;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ConstructorExp;
import org.eclipse.ocl.examples.pivot.ConstructorPart;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.DynamicBehavior;
import org.eclipse.ocl.examples.pivot.DynamicElement;
import org.eclipse.ocl.examples.pivot.DynamicProperty;
import org.eclipse.ocl.examples.pivot.DynamicType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ElementExtension;
import org.eclipse.ocl.examples.pivot.EnumLiteralExp;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.Feature;
import org.eclipse.ocl.examples.pivot.FeatureCallExp;
import org.eclipse.ocl.examples.pivot.FinalState;
import org.eclipse.ocl.examples.pivot.IfExp;
import org.eclipse.ocl.examples.pivot.Import;
import org.eclipse.ocl.examples.pivot.IntegerLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.InvalidType;
import org.eclipse.ocl.examples.pivot.IterateExp;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.IteratorExp;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LetExp;
import org.eclipse.ocl.examples.pivot.Library;
import org.eclipse.ocl.examples.pivot.LiteralExp;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.MessageExp;
import org.eclipse.ocl.examples.pivot.MessageType;
import org.eclipse.ocl.examples.pivot.Metaclass;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.NavigationCallExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.NumericLiteralExp;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.OperationTemplateParameter;
import org.eclipse.ocl.examples.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.examples.pivot.OrderedSetType;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.PackageableElement;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.Precedence;
import org.eclipse.ocl.examples.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Profile;
import org.eclipse.ocl.examples.pivot.ProfileApplication;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.PropertyCallExp;
import org.eclipse.ocl.examples.pivot.Pseudostate;
import org.eclipse.ocl.examples.pivot.RealLiteralExp;
import org.eclipse.ocl.examples.pivot.Region;
import org.eclipse.ocl.examples.pivot.Root;
import org.eclipse.ocl.examples.pivot.SelfType;
import org.eclipse.ocl.examples.pivot.SendSignalAction;
import org.eclipse.ocl.examples.pivot.SequenceType;
import org.eclipse.ocl.examples.pivot.SetType;
import org.eclipse.ocl.examples.pivot.Signal;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.StateExp;
import org.eclipse.ocl.examples.pivot.StateMachine;
import org.eclipse.ocl.examples.pivot.Stereotype;
import org.eclipse.ocl.examples.pivot.StringLiteralExp;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateParameterType;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Transition;
import org.eclipse.ocl.examples.pivot.Trigger;
import org.eclipse.ocl.examples.pivot.TupleLiteralExp;
import org.eclipse.ocl.examples.pivot.TupleLiteralPart;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeExp;
import org.eclipse.ocl.examples.pivot.TypeExtension;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.examples.pivot.UnspecifiedType;
import org.eclipse.ocl.examples.pivot.UnspecifiedValueExp;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableDeclaration;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.Vertex;
import org.eclipse.ocl.examples.pivot.VoidType;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.util.PivotSwitch;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;

/**
 * A set of operations to correctly copy an OCLExp
 * @generated
 */
public class OCLExpCopy extends PivotSwitch<Element> {

    @NonNull private QvtrToQvtcTransformation transformation;
    
    public OCLExpCopy(@NonNull QvtrToQvtcTransformation transformation) {
        this.transformation = transformation;
    }
    
    
    /**
     * @generated
     */
    @Override 
	public Element caseAnnotation(Annotation in) {
        
	    final Annotation out = PivotFactory.eINSTANCE.createAnnotation();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    return (Annotation) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseAnyType(AnyType in) {
        
	    final AnyType out = PivotFactory.eINSTANCE.createAnyType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (AnyType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseAssociationClass(AssociationClass in) {
        
	    final AssociationClass out = PivotFactory.eINSTANCE.createAssociationClass();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (AssociationClass) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseAssociationClassCallExp(AssociationClassCallExp in) {
        
	    final AssociationClassCallExp out = PivotFactory.eINSTANCE.createAssociationClassCallExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setNavigationSource((Property) caseProperty(in.getNavigationSource()));
        out.setReferredAssociationClass((AssociationClass) caseAssociationClass(in.getReferredAssociationClass()));
	    return (AssociationClassCallExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseBagType(BagType in) {
        
	    final BagType out = PivotFactory.eINSTANCE.createBagType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setElementType((Type) caseType(in.getElementType()));
	    return (BagType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseBooleanLiteralExp(BooleanLiteralExp in) {
        
	    final BooleanLiteralExp out = PivotFactory.eINSTANCE.createBooleanLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setBooleanSymbol(in.isBooleanSymbol());
        out.setType((Type) caseType(in.getType()));
	    return (BooleanLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseCallOperationAction(CallOperationAction in) {
        
	    final CallOperationAction out = PivotFactory.eINSTANCE.createCallOperationAction();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setOperation((Operation) caseOperation(in.getOperation()));
	    return (CallOperationAction) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseClass(Class in) {
        
	    final Class out = PivotFactory.eINSTANCE.createClass();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (Class) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseCollectionItem(CollectionItem in) {
        
	    final CollectionItem out = PivotFactory.eINSTANCE.createCollectionItem();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setItem((OCLExpression) caseOCLExpression(in.getItem()));
	    return (CollectionItem) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseCollectionLiteralExp(CollectionLiteralExp in) {
        
	    final CollectionLiteralExp out = PivotFactory.eINSTANCE.createCollectionLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setKind(in.getKind());
        out.setType((Type) caseType(in.getType()));
	    return (CollectionLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseCollectionRange(CollectionRange in) {
        
	    final CollectionRange out = PivotFactory.eINSTANCE.createCollectionRange();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setFirst((OCLExpression) caseOCLExpression(in.getFirst()));
        out.setLast((OCLExpression) caseOCLExpression(in.getLast()));
	    return (CollectionRange) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseCollectionType(CollectionType in) {
        
	    final CollectionType out = PivotFactory.eINSTANCE.createCollectionType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setElementType((Type) caseType(in.getElementType()));
	    return (CollectionType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseComment(Comment in) {
        
	    final Comment out = PivotFactory.eINSTANCE.createComment();
	    assert out != null;
	    out.setBody(in.getBody());
	    return (Comment) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseConnectionPointReference(ConnectionPointReference in) {
        
	    final ConnectionPointReference out = PivotFactory.eINSTANCE.createConnectionPointReference();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setContainer((Region) caseRegion(in.getContainer()));
        out.setState((State) caseState(in.getState()));
	    return (ConnectionPointReference) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseConstraint(Constraint in) {
        
	    final Constraint out = PivotFactory.eINSTANCE.createConstraint();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsCallable(in.isCallable());
        out.setOwningState((State) caseState(in.getOwningState()));
        out.setSpecification((OpaqueExpression) caseOpaqueExpression(in.getSpecification()));
        out.setTransition((Transition) caseTransition(in.getTransition()));
	    return (Constraint) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseConstructorExp(ConstructorExp in) {
        
	    final ConstructorExp out = PivotFactory.eINSTANCE.createConstructorExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setValue(in.getValue());
        out.setType((Type) caseType(in.getType()));
	    return (ConstructorExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseConstructorPart(ConstructorPart in) {
        
	    final ConstructorPart out = PivotFactory.eINSTANCE.createConstructorPart();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setInitExpression((OCLExpression) caseOCLExpression(in.getInitExpression()));
        out.setReferredProperty((Property) caseProperty(in.getReferredProperty()));
	    return (ConstructorPart) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDataType(DataType in) {
        
	    final DataType out = PivotFactory.eINSTANCE.createDataType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
	    return (DataType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDetail(Detail in) {
        
	    final Detail out = PivotFactory.eINSTANCE.createDetail();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.getValue().addAll(in.getValue());
	    return (Detail) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDynamicBehavior(DynamicBehavior in) {
        
	    final DynamicBehavior out = PivotFactory.eINSTANCE.createDynamicBehavior();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setTransition((Transition) caseTransition(in.getTransition()));
        out.setMetaType((Type) caseType(in.getMetaType()));
	    return (DynamicBehavior) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDynamicElement(DynamicElement in) {
        
	    final DynamicElement out = PivotFactory.eINSTANCE.createDynamicElement();
	    assert out != null;
        out.setMetaType((Type) caseType(in.getMetaType()));
	    return (DynamicElement) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDynamicProperty(DynamicProperty in) {
        
	    final DynamicProperty out = PivotFactory.eINSTANCE.createDynamicProperty();
	    assert out != null;
	    out.setDefault(in.getDefault());
        out.setReferredProperty((Property) caseProperty(in.getReferredProperty()));
	    return (DynamicProperty) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseDynamicType(DynamicType in) {
        
	    final DynamicType out = PivotFactory.eINSTANCE.createDynamicType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setMetaType((Type) caseType(in.getMetaType()));
	    return (DynamicType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseElementExtension(ElementExtension in) {
        
	    final ElementExtension out = PivotFactory.eINSTANCE.createElementExtension();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsApplied(in.isApplied());
	    out.setIsRequired(in.isRequired());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBase((Element) caseElement(in.getBase()));
        out.setStereotype((Stereotype) caseStereotype(in.getStereotype()));
	    return (ElementExtension) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseEnumLiteralExp(EnumLiteralExp in) {
        
	    final EnumLiteralExp out = PivotFactory.eINSTANCE.createEnumLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setReferredEnumLiteral((EnumerationLiteral) caseEnumerationLiteral(in.getReferredEnumLiteral()));
	    return (EnumLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseEnumeration(Enumeration in) {
        
	    final Enumeration out = PivotFactory.eINSTANCE.createEnumeration();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
	    return (Enumeration) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseEnumerationLiteral(EnumerationLiteral in) {
        
	    final EnumerationLiteral out = PivotFactory.eINSTANCE.createEnumerationLiteral();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setValue(in.getValue());
        out.setEnumeration((Enumeration) caseEnumeration(in.getEnumeration()));
	    return (EnumerationLiteral) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseExpressionInOCL(ExpressionInOCL in) {
        
	    final ExpressionInOCL out = PivotFactory.eINSTANCE.createExpressionInOCL();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setOwnedExpressionInOCL((ExpressionInOCL) caseExpressionInOCL(in.getOwnedExpressionInOCL()));
        out.setBodyExpression((OCLExpression) caseOCLExpression(in.getBodyExpression()));
        out.setContextVariable((Variable) caseVariable(in.getContextVariable()));
        out.setResultVariable((Variable) caseVariable(in.getResultVariable()));
	    return (ExpressionInOCL) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseFinalState(FinalState in) {
        
	    final FinalState out = PivotFactory.eINSTANCE.createFinalState();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsSubmachineState(in.isSubmachineState());
        out.setContainer((Region) caseRegion(in.getContainer()));
        out.setDoActivity((Behavior) caseBehavior(in.getDoActivity()));
        out.setEntry((Behavior) caseBehavior(in.getEntry()));
        out.setExit((Behavior) caseBehavior(in.getExit()));
        out.setRedefinedState((State) caseState(in.getRedefinedState()));
        out.setStateInvariant((Constraint) caseConstraint(in.getStateInvariant()));
        out.setSubmachine((StateMachine) caseStateMachine(in.getSubmachine()));
	    return (FinalState) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseIfExp(IfExp in) {
        
	    final IfExp out = PivotFactory.eINSTANCE.createIfExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setCondition((OCLExpression) caseOCLExpression(in.getCondition()));
        out.setElseExpression((OCLExpression) caseOCLExpression(in.getElseExpression()));
        out.setThenExpression((OCLExpression) caseOCLExpression(in.getThenExpression()));
	    return (IfExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseImport(Import in) {
        
	    final Import out = PivotFactory.eINSTANCE.createImport();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setImportedNamespace((Namespace) caseNamespace(in.getImportedNamespace()));
	    return (Import) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseIntegerLiteralExp(IntegerLiteralExp in) {
        
	    final IntegerLiteralExp out = PivotFactory.eINSTANCE.createIntegerLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setIntegerSymbol(in.getIntegerSymbol());
        out.setType((Type) caseType(in.getType()));
	    return (IntegerLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseInvalidLiteralExp(InvalidLiteralExp in) {
        
	    final InvalidLiteralExp out = PivotFactory.eINSTANCE.createInvalidLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
	    return (InvalidLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseInvalidType(InvalidType in) {
        
	    final InvalidType out = PivotFactory.eINSTANCE.createInvalidType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (InvalidType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseIterateExp(IterateExp in) {
        
	    final IterateExp out = PivotFactory.eINSTANCE.createIterateExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setBody((OCLExpression) caseOCLExpression(in.getBody()));
        out.setReferredIteration((Iteration) caseIteration(in.getReferredIteration()));
        out.setResult((Variable) caseVariable(in.getResult()));
	    return (IterateExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseIteration(Iteration in) {
        
	    final Iteration out = PivotFactory.eINSTANCE.createIteration();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setIsInvalidating(in.isInvalidating());
	    out.setIsValidating(in.isValidating());
        out.setType((Type) caseType(in.getType()));
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setBodyExpression((OpaqueExpression) caseOpaqueExpression(in.getBodyExpression()));
        out.setOwningType((Type) caseType(in.getOwningType()));
        out.setPrecedence((Precedence) casePrecedence(in.getPrecedence()));
	    return (Iteration) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseIteratorExp(IteratorExp in) {
        
	    final IteratorExp out = PivotFactory.eINSTANCE.createIteratorExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setBody((OCLExpression) caseOCLExpression(in.getBody()));
        out.setReferredIteration((Iteration) caseIteration(in.getReferredIteration()));
	    return (IteratorExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseLambdaType(LambdaType in) {
        
	    final LambdaType out = PivotFactory.eINSTANCE.createLambdaType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setContextType((Type) caseType(in.getContextType()));
        out.setResultType((Type) caseType(in.getResultType()));
	    return (LambdaType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseLetExp(LetExp in) {
        
	    final LetExp out = PivotFactory.eINSTANCE.createLetExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setIn((OCLExpression) caseOCLExpression(in.getIn()));
        out.setVariable((Variable) caseVariable(in.getVariable()));
	    return (LetExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseLibrary(Library in) {
        
	    final Library out = PivotFactory.eINSTANCE.createLibrary();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setNestingPackage((Package) casePackage(in.getNestingPackage()));
	    return (Library) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseMessageExp(MessageExp in) {
        
	    final MessageExp out = PivotFactory.eINSTANCE.createMessageExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setCalledOperation((CallOperationAction) caseCallOperationAction(in.getCalledOperation()));
        out.setSentSignal((SendSignalAction) caseSendSignalAction(in.getSentSignal()));
        out.setTarget((OCLExpression) caseOCLExpression(in.getTarget()));
	    return (MessageExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseMessageType(MessageType in) {
        
	    final MessageType out = PivotFactory.eINSTANCE.createMessageType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setReferredOperation((Operation) caseOperation(in.getReferredOperation()));
        out.setReferredSignal((Signal) caseSignal(in.getReferredSignal()));
	    return (MessageType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseNullLiteralExp(NullLiteralExp in) {
        
	    final NullLiteralExp out = PivotFactory.eINSTANCE.createNullLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
	    return (NullLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOpaqueExpression(OpaqueExpression in) {
        
	    final OpaqueExpression out = PivotFactory.eINSTANCE.createOpaqueExpression();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.getBody().addAll(in.getBody());
        out.getLanguage().addAll(in.getLanguage());
        out.setType((Type) caseType(in.getType()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setOwnedExpressionInOCL((ExpressionInOCL) caseExpressionInOCL(in.getOwnedExpressionInOCL()));
	    return (OpaqueExpression) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOperation(Operation in) {
        
	    final Operation out = PivotFactory.eINSTANCE.createOperation();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setIsInvalidating(in.isInvalidating());
	    out.setIsValidating(in.isValidating());
        out.setType((Type) caseType(in.getType()));
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setBodyExpression((OpaqueExpression) caseOpaqueExpression(in.getBodyExpression()));
        out.setOwningType((Type) caseType(in.getOwningType()));
        out.setPrecedence((Precedence) casePrecedence(in.getPrecedence()));
	    return (Operation) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOperationCallExp(OperationCallExp in) {
        
	    final OperationCallExp out = PivotFactory.eINSTANCE.createOperationCallExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setReferredOperation((Operation) caseOperation(in.getReferredOperation()));
	    return (OperationCallExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOperationTemplateParameter(OperationTemplateParameter in) {
        
	    final OperationTemplateParameter out = PivotFactory.eINSTANCE.createOperationTemplateParameter();
	    assert out != null;
        out.setDefault((ParameterableElement) caseParameterableElement(in.getDefault()));
        out.setOwnedDefault((ParameterableElement) caseParameterableElement(in.getOwnedDefault()));
        out.setOwnedParameteredElement((ParameterableElement) caseParameterableElement(in.getOwnedParameteredElement()));
        out.setParameteredElement((ParameterableElement) caseParameterableElement(in.getParameteredElement()));
        out.setSignature((TemplateSignature) caseTemplateSignature(in.getSignature()));
	    return (OperationTemplateParameter) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOppositePropertyCallExp(OppositePropertyCallExp in) {
        
	    final OppositePropertyCallExp out = PivotFactory.eINSTANCE.createOppositePropertyCallExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setNavigationSource((Property) caseProperty(in.getNavigationSource()));
        out.setReferredProperty((Property) caseProperty(in.getReferredProperty()));
	    return (OppositePropertyCallExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseOrderedSetType(OrderedSetType in) {
        
	    final OrderedSetType out = PivotFactory.eINSTANCE.createOrderedSetType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setElementType((Type) caseType(in.getElementType()));
	    return (OrderedSetType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element casePackage(Package in) {
        
	    final Package out = PivotFactory.eINSTANCE.createPackage();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setNestingPackage((Package) casePackage(in.getNestingPackage()));
	    return (Package) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseParameter(Parameter in) {
        
	    final Parameter out = PivotFactory.eINSTANCE.createParameter();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setOperation((Operation) caseOperation(in.getOperation()));
	    return (Parameter) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element casePrecedence(Precedence in) {
        
	    final Precedence out = PivotFactory.eINSTANCE.createPrecedence();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setAssociativity(in.getAssociativity());
	    out.setOrder(in.getOrder());
	    return (Precedence) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element casePrimitiveType(PrimitiveType in) {
        
	    final PrimitiveType out = PivotFactory.eINSTANCE.createPrimitiveType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
	    return (PrimitiveType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseProfile(Profile in) {
        
	    final Profile out = PivotFactory.eINSTANCE.createProfile();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setNsPrefix(in.getNsPrefix());
	    out.setNsURI(in.getNsURI());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setNestingPackage((Package) casePackage(in.getNestingPackage()));
	    return (Profile) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseProfileApplication(ProfileApplication in) {
        
	    final ProfileApplication out = PivotFactory.eINSTANCE.createProfileApplication();
	    assert out != null;
	    out.setIsStrict(in.isStrict());
        out.setAppliedProfile((Profile) caseProfile(in.getAppliedProfile()));
        out.setApplyingPackage((Package) casePackage(in.getApplyingPackage()));
	    return (ProfileApplication) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseProperty(Property in) {
        
	    final Property out = PivotFactory.eINSTANCE.createProperty();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplementation(in.getImplementation());
	    out.setImplementationClass(in.getImplementationClass());
	    out.setDefault(in.getDefault());
	    out.setImplicit(in.isImplicit());
	    out.setIsComposite(in.isComposite());
	    out.setIsDerived(in.isDerived());
	    out.setIsID(in.isID());
	    out.setIsReadOnly(in.isReadOnly());
	    out.setIsResolveProxies(in.isResolveProxies());
	    out.setIsTransient(in.isTransient());
	    out.setIsUnsettable(in.isUnsettable());
	    out.setIsVolatile(in.isVolatile());
        out.setType((Type) caseType(in.getType()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setAssociationClass((AssociationClass) caseAssociationClass(in.getAssociationClass()));
        out.setDefaultExpression((OpaqueExpression) caseOpaqueExpression(in.getDefaultExpression()));
        out.setOpposite((Property) caseProperty(in.getOpposite()));
        out.setOwningType((Type) caseType(in.getOwningType()));
        out.setReferredProperty((Property) caseProperty(in.getReferredProperty()));
	    return (Property) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element casePropertyCallExp(PropertyCallExp in) {
        
	    final PropertyCallExp out = PivotFactory.eINSTANCE.createPropertyCallExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
	    out.setIsPre(in.isPre());
        out.setType((Type) caseType(in.getType()));
        out.setSource((OCLExpression) caseOCLExpression(in.getSource()));
        out.setNavigationSource((Property) caseProperty(in.getNavigationSource()));
        out.setReferredProperty((Property) caseProperty(in.getReferredProperty()));
	    return (PropertyCallExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element casePseudostate(Pseudostate in) {
        
	    final Pseudostate out = PivotFactory.eINSTANCE.createPseudostate();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setKind(in.getKind());
        out.setContainer((Region) caseRegion(in.getContainer()));
        out.setState((State) caseState(in.getState()));
        out.setStateMachine((StateMachine) caseStateMachine(in.getStateMachine()));
	    return (Pseudostate) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseRealLiteralExp(RealLiteralExp in) {
        
	    final RealLiteralExp out = PivotFactory.eINSTANCE.createRealLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setRealSymbol(in.getRealSymbol());
        out.setType((Type) caseType(in.getType()));
	    return (RealLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseRegion(Region in) {
        
	    final Region out = PivotFactory.eINSTANCE.createRegion();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setExtendedRegion((Region) caseRegion(in.getExtendedRegion()));
        out.setState((State) caseState(in.getState()));
        out.setStateMachine((StateMachine) caseStateMachine(in.getStateMachine()));
	    return (Region) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseRoot(Root in) {
        
	    final Root out = PivotFactory.eINSTANCE.createRoot();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setExternalURI(in.getExternalURI());
	    return (Root) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseSelfType(SelfType in) {
        
	    final SelfType out = PivotFactory.eINSTANCE.createSelfType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (SelfType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseSendSignalAction(SendSignalAction in) {
        
	    final SendSignalAction out = PivotFactory.eINSTANCE.createSendSignalAction();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setSignal((Signal) caseSignal(in.getSignal()));
	    return (SendSignalAction) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseSequenceType(SequenceType in) {
        
	    final SequenceType out = PivotFactory.eINSTANCE.createSequenceType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setElementType((Type) caseType(in.getElementType()));
	    return (SequenceType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseSetType(SetType in) {
        
	    final SetType out = PivotFactory.eINSTANCE.createSetType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
	    out.setLower(in.getLower());
	    out.setUpper(in.getUpper());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
        out.setElementType((Type) caseType(in.getElementType()));
	    return (SetType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseSignal(Signal in) {
        
	    final Signal out = PivotFactory.eINSTANCE.createSignal();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    return (Signal) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseState(State in) {
        
	    final State out = PivotFactory.eINSTANCE.createState();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsSubmachineState(in.isSubmachineState());
        out.setContainer((Region) caseRegion(in.getContainer()));
        out.setDoActivity((Behavior) caseBehavior(in.getDoActivity()));
        out.setEntry((Behavior) caseBehavior(in.getEntry()));
        out.setExit((Behavior) caseBehavior(in.getExit()));
        out.setRedefinedState((State) caseState(in.getRedefinedState()));
        out.setStateInvariant((Constraint) caseConstraint(in.getStateInvariant()));
        out.setSubmachine((StateMachine) caseStateMachine(in.getSubmachine()));
	    return (State) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseStateExp(StateExp in) {
        
	    final StateExp out = PivotFactory.eINSTANCE.createStateExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setReferredState((State) caseState(in.getReferredState()));
	    return (StateExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseStateMachine(StateMachine in) {
        
	    final StateMachine out = PivotFactory.eINSTANCE.createStateMachine();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setTransition((Transition) caseTransition(in.getTransition()));
	    return (StateMachine) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseStereotype(Stereotype in) {
        
	    final Stereotype out = PivotFactory.eINSTANCE.createStereotype();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (Stereotype) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseStringLiteralExp(StringLiteralExp in) {
        
	    final StringLiteralExp out = PivotFactory.eINSTANCE.createStringLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setStringSymbol(in.getStringSymbol());
        out.setType((Type) caseType(in.getType()));
	    return (StringLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTemplateBinding(TemplateBinding in) {
        
	    final TemplateBinding out = PivotFactory.eINSTANCE.createTemplateBinding();
	    assert out != null;
        out.setBoundElement((TemplateableElement) caseTemplateableElement(in.getBoundElement()));
        out.setSignature((TemplateSignature) caseTemplateSignature(in.getSignature()));
	    return (TemplateBinding) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTemplateParameter(TemplateParameter in) {
        
	    final TemplateParameter out = PivotFactory.eINSTANCE.createTemplateParameter();
	    assert out != null;
        out.setDefault((ParameterableElement) caseParameterableElement(in.getDefault()));
        out.setOwnedDefault((ParameterableElement) caseParameterableElement(in.getOwnedDefault()));
        out.setOwnedParameteredElement((ParameterableElement) caseParameterableElement(in.getOwnedParameteredElement()));
        out.setParameteredElement((ParameterableElement) caseParameterableElement(in.getParameteredElement()));
        out.setSignature((TemplateSignature) caseTemplateSignature(in.getSignature()));
	    return (TemplateParameter) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTemplateParameterSubstitution(TemplateParameterSubstitution in) {
        
	    final TemplateParameterSubstitution out = PivotFactory.eINSTANCE.createTemplateParameterSubstitution();
	    assert out != null;
        out.setActual((ParameterableElement) caseParameterableElement(in.getActual()));
        out.setFormal((TemplateParameter) caseTemplateParameter(in.getFormal()));
        out.setOwnedActual((ParameterableElement) caseParameterableElement(in.getOwnedActual()));
        out.setTemplateBinding((TemplateBinding) caseTemplateBinding(in.getTemplateBinding()));
	    return (TemplateParameterSubstitution) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTemplateParameterType(TemplateParameterType in) {
        
	    final TemplateParameterType out = PivotFactory.eINSTANCE.createTemplateParameterType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setSpecification(in.getSpecification());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (TemplateParameterType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTemplateSignature(TemplateSignature in) {
        
	    final TemplateSignature out = PivotFactory.eINSTANCE.createTemplateSignature();
	    assert out != null;
        out.setTemplate((TemplateableElement) caseTemplateableElement(in.getTemplate()));
	    return (TemplateSignature) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTransition(Transition in) {
        
	    final Transition out = PivotFactory.eINSTANCE.createTransition();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setKind(in.getKind());
        out.setContainer((Region) caseRegion(in.getContainer()));
        out.setEffect((Behavior) caseBehavior(in.getEffect()));
        out.setGuard((Constraint) caseConstraint(in.getGuard()));
        out.setSource((Vertex) caseVertex(in.getSource()));
        out.setTarget((Vertex) caseVertex(in.getTarget()));
	    return (Transition) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTrigger(Trigger in) {
        
	    final Trigger out = PivotFactory.eINSTANCE.createTrigger();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
        out.setState((State) caseState(in.getState()));
        out.setTransition((Transition) caseTransition(in.getTransition()));
	    return (Trigger) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTupleLiteralExp(TupleLiteralExp in) {
        
	    final TupleLiteralExp out = PivotFactory.eINSTANCE.createTupleLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
	    return (TupleLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTupleLiteralPart(TupleLiteralPart in) {
        
	    final TupleLiteralPart out = PivotFactory.eINSTANCE.createTupleLiteralPart();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setInitExpression((OCLExpression) caseOCLExpression(in.getInitExpression()));
	    return (TupleLiteralPart) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTupleType(TupleType in) {
        
	    final TupleType out = PivotFactory.eINSTANCE.createTupleType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
	    out.setIsSerializable(in.isSerializable());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setBehavioralType((Type) caseType(in.getBehavioralType()));
	    return (TupleType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseType(Type in) {
        
	    final Type out = PivotFactory.eINSTANCE.createType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (Type) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTypeExp(TypeExp in) {
        
	    final TypeExp out = PivotFactory.eINSTANCE.createTypeExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
        out.setReferredType((Type) caseType(in.getReferredType()));
	    return (TypeExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTypeExtension(TypeExtension in) {
        
	    final TypeExtension out = PivotFactory.eINSTANCE.createTypeExtension();
	    assert out != null;
	    out.setIsRequired(in.isRequired());
        out.setStereotype((Stereotype) caseStereotype(in.getStereotype()));
        out.setType((Type) caseType(in.getType()));
	    return (TypeExtension) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseTypeTemplateParameter(TypeTemplateParameter in) {
        
	    final TypeTemplateParameter out = PivotFactory.eINSTANCE.createTypeTemplateParameter();
	    assert out != null;
	    out.setAllowSubstitutable(in.isAllowSubstitutable());
        out.setDefault((ParameterableElement) caseParameterableElement(in.getDefault()));
        out.setOwnedDefault((ParameterableElement) caseParameterableElement(in.getOwnedDefault()));
        out.setOwnedParameteredElement((ParameterableElement) caseParameterableElement(in.getOwnedParameteredElement()));
        out.setParameteredElement((ParameterableElement) caseParameterableElement(in.getParameteredElement()));
        out.setSignature((TemplateSignature) caseTemplateSignature(in.getSignature()));
	    return (TypeTemplateParameter) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseUnlimitedNaturalLiteralExp(UnlimitedNaturalLiteralExp in) {
        
	    final UnlimitedNaturalLiteralExp out = PivotFactory.eINSTANCE.createUnlimitedNaturalLiteralExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setUnlimitedNaturalSymbol(in.getUnlimitedNaturalSymbol());
        out.setType((Type) caseType(in.getType()));
	    return (UnlimitedNaturalLiteralExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseUnspecifiedType(UnspecifiedType in) {
        
	    final UnspecifiedType out = PivotFactory.eINSTANCE.createUnspecifiedType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
        out.setLowerBound((Type) caseType(in.getLowerBound()));
        out.setUpperBound((Type) caseType(in.getUpperBound()));
	    return (UnspecifiedType) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseUnspecifiedValueExp(UnspecifiedValueExp in) {
        
	    final UnspecifiedValueExp out = PivotFactory.eINSTANCE.createUnspecifiedValueExp();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
        out.setType((Type) caseType(in.getType()));
	    return (UnspecifiedValueExp) out;
	}
    
    /**
     * @generated
     */
    @Override 
	public Element caseVariable(Variable in) {
        
	    final Variable out = PivotFactory.eINSTANCE.createVariable();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setIsRequired(in.isRequired());
	    out.setImplicit(in.isImplicit());
        out.setType((Type) caseType(in.getType()));
        out.setInitExpression((OCLExpression) caseOCLExpression(in.getInitExpression()));
        out.setRepresentedParameter((Parameter) caseParameter(in.getRepresentedParameter()));
	    return (Variable) out;
	}
    /**
     * @generated
     */
    @Override 
    public Element caseVariableExp(VariableExp in) {
        
        final VariableExp out = PivotFactory.eINSTANCE.createVariableExp();
        assert out != null;
        out.setIsStatic(in.isStatic());
        out.setName(in.getName());
        out.setIsRequired(in.isRequired());
        out.setImplicit(in.isImplicit());
        out.setType((Type) caseType(in.getType()));
        out.setReferredVariable(transformation.getVariableTrace((Variable) in.getReferredVariable()));
        return (VariableExp) out;
    }
    
    /**
     * @generated
     */
    @Override 
	public Element caseVoidType(VoidType in) {
        
	    final VoidType out = PivotFactory.eINSTANCE.createVoidType();
	    assert out != null;
	    out.setIsStatic(in.isStatic());
	    out.setName(in.getName());
	    out.setInstanceClassName(in.getInstanceClassName());
	    out.setIsAbstract(in.isAbstract());
	    out.setIsActive(in.isActive());
	    out.setIsInterface(in.isInterface());
        out.setOwnedTemplateSignature((TemplateSignature) caseTemplateSignature(in.getOwnedTemplateSignature()));
        out.setUnspecializedElement((TemplateableElement) caseTemplateableElement(in.getUnspecializedElement()));
        out.setOwningTemplateParameter((TemplateParameter) caseTemplateParameter(in.getOwningTemplateParameter()));
        out.setTemplateParameter((TemplateParameter) caseTemplateParameter(in.getTemplateParameter()));
        out.setPackage((Package) casePackage(in.getPackage()));
	    return (VoidType) out;
	}
}

