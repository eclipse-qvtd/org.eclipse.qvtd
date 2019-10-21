package org.eclipse.qvtd.compiler.internal.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.common.TypedModelConfiguration.Mode;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TypedModelsConfiguration specifies how each TypedModel is to be used during execution.
 */
public class TypedModelsConfiguration
{
	public static @NonNull Iterable<@NonNull TypedModelsConfiguration> createTypedModelsConfigurations(@NonNull String outputName) {
		return createTypedModelsConfigurations(Collections.singletonList(Collections.singletonList(outputName)));
	}

	public static @NonNull Iterable<@NonNull TypedModelsConfiguration> createTypedModelsConfigurations(@NonNull Iterable<@NonNull Iterable<@NonNull String>> outputNamesList) {
		List<@NonNull TypedModelsConfiguration> typedModelsConfigurations = new ArrayList<>();
		for (@NonNull Iterable<@NonNull String> outputNames : outputNamesList) {
			TypedModelsConfiguration typedModelsConfiguration = new TypedModelsConfiguration();
			for (@NonNull String outputName : outputNames) {
				typedModelsConfiguration.addTypedModelConfiguration(new TypedModelConfiguration(outputName, TypedModelConfiguration.Mode.OUTPUT));
			}
			typedModelsConfigurations.add(typedModelsConfiguration);
		}
		return typedModelsConfigurations;
	}

	/*	public static @NonNull TypedModelsConfiguration createTypedModelsConfiguration(@NonNull Mode mode, @NonNull Iterable<@NonNull String> enforcedOutputNames) throws IOException {
				List<@NonNull TypedModelConfiguration> typedModelConfigurations = new ArrayList<>();
		//		List<@NonNull TypedModel> inputTypedModels = new ArrayList<>();
		//		List<@NonNull TypedModel> outputTypedModels = new ArrayList<>();
		//		List<@NonNull TypedModel> intermediateTypedModels = new ArrayList<>();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			if (!typedModel.isIsTrace()) {
				String modelName = typedModel.getName();
				if (Iterables.contains(enforcedOutputNames, modelName)) {
					if (outputTypedModels.size() > 1) {
						//	throw new CompilerChainException("Ambiguous output domain(s) ''{0}''", enforcedOutputNames);
						System.out.println("Ambiguous output domain(s) " + enforcedOutputNames);
					}
					typedModelConfigurations.add(new TypedModelConfiguration(modelName, TypedModelConfiguration.Mode.CHECK));
				}
				else {
					//					inputNames.add(modelName);
					typedModelConfigurations.add(typedModel);
				}
				for (@NonNull TypedModel dependsOn : QVTbaseUtil.getDependsOns(typedModel)) {
					if (!intermediateTypedModels.contains(dependsOn)) {
						typedModelConfigurations.add(dependsOn);
					}
				}
			}
		}
		if (outputTypedModels.isEmpty()) {
			throw new CompilerChainException("Unknown output domain(s) ''{0}''", enforcedOutputNames);
		}
		inputTypedModels.removeAll(intermediateTypedModels);
		TypedModelsConfiguration typedModelsConfiguration = new TypedModelsConfiguration(mode);
		for (@NonNull String enforcedOutputName : enforcedOutputNames) {
			typedModelsConfiguration.addTypedModelConfiguration(new TypedModelConfiguration(enforcedOutputName, TypedModelConfiguration.Mode.ENFORCE));
		}
		return typedModelsConfiguration;
	} */

	private final @NonNull Map<@Nullable String, @NonNull TypedModelConfiguration> name2typedModelConfigurations = new HashMap<>();
	private final @NonNull List<@NonNull TypedModel> inputTypedModels = new ArrayList<>();
	private final @NonNull List<@NonNull TypedModel> intermediateTypedModels = new ArrayList<>();
	private final @NonNull List<@NonNull TypedModel> outputOnlyTypedModels = new ArrayList<>();
	private final @NonNull List<@NonNull TypedModel> outputTypedModels = new ArrayList<>();
	private final @NonNull List<@NonNull TypedModel> unusedTypedModels = new ArrayList<>();

	public TypedModelsConfiguration(@NonNull String... enforcedOutputNames) {
		if (enforcedOutputNames != null) {
			for (@NonNull String enforcedOutputName : enforcedOutputNames) {
				addTypedModelConfiguration(new TypedModelConfiguration(enforcedOutputName, TypedModelConfiguration.Mode.OUTPUT));
			}
		}
	}

	public void addTypedModelConfiguration(@NonNull TypedModelConfiguration typedModelConfiguration) {
		String name = typedModelConfiguration.getName();
		TypedModelConfiguration oldTypedModel = name2typedModelConfigurations.put(name, typedModelConfiguration);
		assert oldTypedModel == null;
	}

	public @NonNull Iterable<@NonNull TypedModel> getInputTypedModels() {
		return inputTypedModels;
	}

	public @NonNull Iterable<@NonNull TypedModel> getIntermediateTypedModels() {
		return intermediateTypedModels;
	}

	public @NonNull Iterable<@NonNull TypedModel> getOutputOnlyTypedModels() {
		return outputOnlyTypedModels;
	}

	public @NonNull Iterable<@NonNull TypedModel> getOutputTypedModels() {
		return outputTypedModels;
	}

	public @NonNull TypedModel getTargetTypedModel() {
		return outputTypedModels.get(0);
	}

	public @NonNull TypedModelConfiguration getTypedModelConfiguration(@NonNull TypedModel typedModel) {
		return ClassUtil.nonNullState(name2typedModelConfigurations.get(typedModel.getName()));
	}

	public @NonNull Iterable<@NonNull TypedModel> getUnusedTypedModels() {
		return unusedTypedModels;
	}

	public boolean hasTargetTypedModel() {
		return outputTypedModels.size() > 0;
	}

	public boolean isInput(@NonNull TypedModel typedModel) {
		return inputTypedModels.contains(typedModel);
	}

	public boolean isIntermediate(@NonNull TypedModel typedModel) {
		return intermediateTypedModels.contains(typedModel);
	}

	public boolean isOutput(@NonNull TypedModel typedModel) {
		return outputTypedModels.contains(typedModel);
	}

	/**
	 * Locate the TypedModel corresponding to each configured name and create default configurations
	 * for all unconfigured domains.
	 *
	 * Returns null if successful, or a new-line-separated concatenation of explanatory error messages if not.
	 */
	public @Nullable String reconcile(@NonNull Transformation transformation) {
		inputTypedModels.clear();			// Allow re-reconcilaiation of QVTc as QVTm
		intermediateTypedModels.clear();
		outputOnlyTypedModels.clear();
		outputTypedModels.clear();
		unusedTypedModels.clear();
		Iterable<@NonNull TypedModel> typedModels = QVTbaseUtil.getModelParameters(transformation);
		for (@NonNull TypedModel typedModel : typedModels) {
			String name = typedModel.getName();
			if (!name2typedModelConfigurations.containsKey(name)) {
				Mode mode = typedModel.isIsPrimitive() || typedModel.isIsThis() || typedModel.isIsTrace()? TypedModelConfiguration.Mode.INTERMEDIATE : TypedModelConfiguration.Mode.INPUT;
				TypedModelConfiguration typedModelConfiguration = new TypedModelConfiguration(name, mode);
				addTypedModelConfiguration(typedModelConfiguration);
			}
		}
		StringBuilder s = null;
		for (@NonNull TypedModelConfiguration typedModelConfiguration : name2typedModelConfigurations.values()) {
			String s2 = typedModelConfiguration.reconcile(typedModels);
			if (s2 != null) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append("\n");
				}
				s.append(s2);
			}
			if (typedModelConfiguration.isInput()) {
				TypedModel typedModel = typedModelConfiguration.basicGetTypedModel();
				if (typedModel != null) {
					inputTypedModels.add(typedModel);
				}
			}
			if (typedModelConfiguration.isIntermediate()) {
				TypedModel typedModel = typedModelConfiguration.basicGetTypedModel();
				if (typedModel != null) {			// Skip QVTc null wrt QVTm middle
					intermediateTypedModels.add(typedModel);
				}
			}
			if (typedModelConfiguration.isOutput()) {
				TypedModel typedModel = typedModelConfiguration.getTypedModel();
				outputTypedModels.add(typedModel);
				if (!typedModelConfiguration.isInput()) {
					outputOnlyTypedModels.add(typedModel);
				}
			}
			if (typedModelConfiguration.isUnused()) {
				TypedModel typedModel = typedModelConfiguration.basicGetTypedModel();
				if (typedModel != null) {			// Skip QVTc null wrt QVTm middle
					unusedTypedModels.add(typedModel);
				}
			}
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;
		s.append("{");
		for (@NonNull TypedModel typedModel : inputTypedModels) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(typedModel.getName());
			isFirst = false;
		}
		s.append("}->{");
		isFirst = true;
		for (@NonNull TypedModel typedModel : intermediateTypedModels) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(typedModel.getName());
			isFirst = false;
		}
		s.append("}->{");
		isFirst = true;
		for (@NonNull TypedModel typedModel : outputTypedModels) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(typedModel.getName());
			isFirst = false;
		}
		s.append("}");
		return s.toString();
	}
}
