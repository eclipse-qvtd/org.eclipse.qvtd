/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * The Class QVTiTracingEvaluationVisitor is a decorator visitor that prints
 * AST, variable values and other information useful for debugging.
 * 
 * @author Horacio Hoyos
 */
public abstract class QVTiAbstractTracingEvaluationVisitor extends QVTiEvaluationVisitorDecorator
{
	
	protected static Logger logger = Logger.getLogger("QVTiTrace");
	
	/** The Constant DEFAULT_INDENT. */
	protected static final String DEFAULT_INDENT = "  ";
	
	/** The verbose level low. */
	static int VERBOSE_LEVEL_LOW = 0;
	
	/** The verbose level med. */
	static int VERBOSE_LEVEL_MED = 1;
	
	/** The verbose level high. */
	static int VERBOSE_LEVEL_HIGH = 2;
	
	/** The verbose level. */
	protected static int verboseLevel = VERBOSE_LEVEL_LOW;
	
	/** The indent level. */
	private int indentLevel = 0;
	

	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 */
	public QVTiAbstractTracingEvaluationVisitor(@NonNull IQVTiEvaluationVisitor decorated) {
		
		this(decorated, 0);
		if (logger.getAppender("QVTTrace") == null) {
			FileAppender appender = new FileAppender();
			// configure the appender here, with file location, etc
			appender.setFile("QVTTrace.log");
			appender.setName("QVTTrace");
			appender.setLayout(new PatternLayout(PatternLayout.DEFAULT_CONVERSION_PATTERN));
			appender.setAppend(false);
			appender.activateOptions();
			logger.addAppender(appender);
		}
		logger.setAdditivity(false);
		logger.setLevel(Level.DEBUG);
	}
	
	/**
	 * Instantiates a new QVTi tracing evaluation visitor.
	 *
	 * @param decorated the decorated
	 * @param indentLevel the indent level
	 */
	protected QVTiAbstractTracingEvaluationVisitor(@NonNull IQVTiEvaluationVisitor decorated, int indentLevel) {
		
		super(decorated);
		this.indentLevel = indentLevel;
	}
	
		
	/**
	 * Gets the verbose level.
	 *
	 * @return the verbose level
	 */
	public int getVerboseLevel() {
		return verboseLevel;
	}

	
	/**
	 * Sets the verbose level.
	 *
	 * @param verboseLevel the new verbose level
	 */
	public void setVerboseLevel(int verboseLevel) {
		QVTiAbstractTracingEvaluationVisitor.verboseLevel = verboseLevel;
	}
	
	/**
	 * Gets the indent.
	 *
	 * @return the indent
	 */
	protected @NonNull String getIndent() {
		
		StringBuilder outputBuffer = new StringBuilder(indentLevel);
		for (int i = 0; i < indentLevel; i++){
		   outputBuffer.append(DEFAULT_INDENT);
		}
		return outputBuffer.toString();
	}
	
//	@Override
//	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
//		return delegate.getRegexPattern(regex);
//	}

	/**
	 * Safe print.
	 *
	 * @param element the element
	 * @return the string
	 */
	protected @NonNull String safePrint(@Nullable Element element) {
		return element != null ? PrettyPrinter.print(element) : "null";
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.Assignment)
	 */
	@Override
	public @Nullable Object visitAssignment(@NonNull Assignment assignment) {
		
		indentLevel++;
		try {
			Object value = safeVisit(assignment.getValue());
			// Unbox to asign to ecore type
	        value = delegate.getEnvironmentFactory().getIdResolver().unboxedValueOf(value);
	        logger.info(getIndent() + "VisitAssignment " + prettyPrint(assignment.getESObject())
	        		+ " := " + prettyPrint(value));
		} catch (InvalidValueException ex) {
			logger.info(getIndent() + "VisitAssignment " + prettyPrint(assignment.getESObject())
	        		+ " := Invalid expression" );
		}
		Object result = delegate.visitAssignment(assignment);
		indentLevel--;
		return result;
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain)
	 */
	@Override
    public @Nullable Object visitCoreDomain(@NonNull CoreDomain coreDomain) {
		logger.info(getIndent() + "CoreDomain " + coreDomain.getName());
		indentLevel++;
		Object result = delegate.visitCoreDomain(coreDomain);
		indentLevel--;
    	return result;
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern)
	 */
	@Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern guardPattern) {
		
		if (guardPattern.getArea() instanceof CoreDomain) {
			logger.info(getIndent() + "Visiting CoreDomain GuardPattern");
		}
		if (guardPattern.getArea() instanceof Mapping) {
			logger.info(getIndent() + "Visiting Mapping GuardPattern");
		}
		indentLevel++;
		// Some variables are assigned after visit
		List<Variable> nullVars = new ArrayList<Variable>();
		for (@SuppressWarnings("null")@NonNull Variable v : guardPattern.getVariable()) {
			if (delegate.getEvaluationEnvironment().getValueOf(v) == null) {
				nullVars.add(v);
				OCLExpression initExp = v.getOwnedInit();
				if (initExp != null) {
					indentLevel++;
					logger.info(getIndent()  + "Variable " + v.getName() + " init value:" + safePrint(initExp));
					indentLevel--;
				}
			} else {
				logger.info(getIndent() + "Variable " + v.getName() + ": " + prettyPrint(delegate.getEvaluationEnvironment().getValueOf(v)));
			}
		}
		Object result = delegate.visitGuardPattern(guardPattern);
		if (result == Boolean.TRUE) {
			for (Variable v : nullVars) {
				logger.info(getIndent() + "Variable " + v.getName() + ": " + prettyPrint(delegate.getEvaluationEnvironment().getValueOf(v)));
			}
		}
		if (guardPattern.getPredicate().size() == 0) {
			logger.info(getIndent() + "GuardPattern has no predicates.");
		} else {
			logger.info(getIndent() + "GuardPattern result: " + result);
		}
		indentLevel--;
    	return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel)
	 */
	@Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
		
		return delegate.visitImperativeModel(imperativeModel);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ocl.pivot.util.AbstractExtendingVisitor#visitIteratorExp(org.eclipse.ocl.pivot.IteratorExp)
	 */
	@Override
	public @Nullable Object visitIteratorExp(org.eclipse.ocl.pivot.@NonNull IteratorExp object) {
		
		return delegate.visitIteratorExp(object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitMapping(org.eclipse.qvtd.pivot.qvtimperative.Mapping)
	 */
	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
		
		logger.info(getIndent() + "Mapping " + mapping.getName());
		indentLevel++;
		Object result = delegate.visitMapping(mapping);
		indentLevel--;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.MappingCall)
	 */
	@Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
		logger.info(getIndent() + "Visiting MappingCall, calling: " + mappingCall.getReferredMapping().getName());
		indentLevel++;
		Object result = delegate.visitMappingCall(mappingCall);
		indentLevel--;
		return result;
	}

	@Override
	public @Nullable Object visitMappingLoop(@NonNull MappingLoop mappingLoop) {
		logger.info(getIndent() + "Visiting MappingLoop, binding: " + mappingLoop.getOwnedIterators().get(0).getName());
		indentLevel++;
		Object result = delegate.visitMappingLoop(mappingLoop);
		indentLevel--;
		return result;
	}

	@Override
	public @Nullable Object visitMappingSequence(@NonNull MappingSequence mappingSequence) {
		Object result = delegate.visitMappingSequence(mappingSequence);
		return result;
	}

	@Override
	public @Nullable Object visitMappingStatement(@NonNull MappingStatement vappingStatement) {
		return visiting(vappingStatement);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment)
	 */
	@Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		
		try {
			Object value = safeVisit(propertyAssignment.getValue());
	        // Unbox to asign to ecore type
	        value = delegate.getEnvironmentFactory().getIdResolver().unboxedValueOf(value);
	        logger.info(getIndent() + "VisitPropertyAssignment " + propertyAssignment.getSlotExpression()
        		+ "." + propertyAssignment.getTargetProperty().getName() + " = " + prettyPrint(value));
		} catch (InvalidValueException ex) {
			logger.info(getIndent() + "VisitPropertyAssignment " + propertyAssignment.getSlotExpression()
        		+ "." + propertyAssignment.getTargetProperty().getName() + " = InvalidValueException" );
		}
        //indentLevel++;
		Object result = delegate.visitPropertyAssignment(propertyAssignment);
		//indentLevel--;
		return result;
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitTransformation(org.eclipse.qvtd.pivot.qvtbase.Transformation)
	 */
	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		logger.info("---- Transformation " + transformation.getName() + " ----");
		indentLevel++;
		Object result = delegate.visitTransformation(transformation);
		indentLevel--;
		logger.info("---- Transformation End ----");
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitPredicate(org.eclipse.qvtd.pivot.qvtbase.Predicate)
	 */
	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {	
		
		OCLExpression exp = predicate.getConditionExpression();
		Object value = safeVisit(exp);
		logger.info(getIndent() + "Predicate " + safePrint(exp) + " is " + String.valueOf(value));
		return delegate.visitPredicate(predicate);
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorDecorator#visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment)
	 */
	@Override
	public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		Variable v = variableAssignment.getTargetVariable();
		logger.info(getIndent() + "VisitVariableAssignment " + v
				+ ": " + ((BasicEvaluationVisitor)delegate).safeVisit(variableAssignment.getValue()));
		indentLevel++;
		Object result = delegate.visitVariableAssignment(variableAssignment);
		indentLevel--;
		return result;
	}
	

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull VariablePredicate variablePredicate) {
		Variable v = variablePredicate.getTargetVariable();
		logger.info(getIndent() + "VisitVariablePredicate " + v
				+ ": " + ((BasicEvaluationVisitor)delegate).safeVisit(variablePredicate.getConditionExpression()));
		indentLevel++;
		Object result = delegate.visitVariablePredicate(variablePredicate);
		indentLevel--;
		return result;
	}
	
	/**
	 * Pretty print Objects. EObjects are printed at 1 level depth (i.e. no 
	 * navigation through associations). Other objects are printed as Strings
	 *
	 * @param object the object
	 * @return the string
	 */
	protected String prettyPrint(Object object) {
		
		List<String> lines = new ArrayList<String>();
		if (object instanceof EObject) {
			EObject eo = (EObject) object;
			EClass eClass = eo.eClass();
			lines.add(eClass.getName() + " [" + Integer.toHexString(eo.hashCode()) + "] {"); // 
			indentLevel++;
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				Object value = eo.eGet(feature);
				String line = getIndent() + feature.getName() + " = ";
				if (value instanceof Collection<?>) {
					int size = ((Collection<?>)value).size(); 
					if (size > 0) {
						line += "[" + ((EObject)((Iterable<?>) value).iterator().next()).eClass().getName() + "] x " + size;
					} else {
						line += "[ ]";
					}
				} else if (value instanceof EObject) {
					eClass = ((EObject) value).eClass();
					line += eClass.getName() + " [" + Integer.toHexString(value.hashCode()) + "]";
				} else {
					if (value == null) {
						line += "[ null ]";
					} else {
						line += String.valueOf(value);
					}
				}
				lines.add(line);
			}
			lines.add(getIndent() + "}");
			indentLevel--;
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				sb.append(line).append('\n');
			}
			sb.delete(sb.length()-1, sb.length());
			return sb.toString();
		} else {
			return String.valueOf(object);
		}
	}
	
	protected String prettyPrintUnident(Object object) {
		List<String> lines = new ArrayList<String>();
		if (object instanceof EObject) {
			EObject eo = (EObject) object;
			EClass eClass = eo.eClass();
			lines.add(eClass.getName() + " [" + Integer.toHexString(eo.hashCode()) + "] {"); // 
			indentLevel++;
			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
				Object value = eo.eGet(feature);
				String line =  DEFAULT_INDENT + feature.getName() + " = ";
				if (value instanceof Collection<?>) {
					int size = ((Collection<?>)value).size(); 
					if (size > 0) {
						line += "[" + ((EObject)((Iterable<?>) value).iterator().next()).eClass().getName() + "] x " + size;
					} else {
						line += "[ ]";
					}
				} else if (value instanceof EObject) {
					eClass = ((EObject) value).eClass();
					line += eClass.getName() + " [" + Integer.toHexString(value.hashCode()) + "]";
				} else {
					if (value == null) {
						line += "[ null ]";
					} else {
						line += String.valueOf(value);
					}
				}
				lines.add(line);
			}
			lines.add(DEFAULT_INDENT + "}");
			indentLevel--;
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				sb.append(line).append('\n');
			}
			sb.delete(sb.length()-1, sb.length());
			return sb.toString();
		} else {
			return String.valueOf(object);
		}
		
		
	}
}
