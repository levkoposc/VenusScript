package com.levkopo.vs.library.math;

import com.levkopo.vs.exception.runtime.ScriptRuntimeException;
import com.levkopo.vs.executor.Context;
import com.levkopo.vs.function.FunctionCallDescriptor;
import com.levkopo.vs.function.Method;
import com.levkopo.vs.function.annotation.MethodArgs;
import com.levkopo.vs.function.annotation.MethodName;
import com.levkopo.vs.value.DecimalValue;
import com.levkopo.vs.value.Value;

import java.util.Random;

@MethodArgs({ DecimalValue.class, DecimalValue.class })
@MethodName("randDecimal")
public class RandDecimal extends Method {
	@Override
	public Value call(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
		DecimalValue min = (DecimalValue) descriptor.get(0);
		DecimalValue max = (DecimalValue) descriptor.get(1);
		double minValue = min.value();
		double maxValue = max.value();

		if (minValue > maxValue) {
			double temp = maxValue;

			maxValue = minValue;
			minValue = temp;
		}

		Random r = new Random();
		return new DecimalValue(minValue + (maxValue - minValue) * r.nextDouble());
	}
}