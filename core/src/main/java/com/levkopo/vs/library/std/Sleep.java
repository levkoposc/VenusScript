package com.levkopo.vs.library.std;

import com.levkopo.vs.exception.runtime.ScriptRuntimeException;
import com.levkopo.vs.executor.Context;
import com.levkopo.vs.function.FunctionCallDescriptor;
import com.levkopo.vs.function.VoidMethod;
import com.levkopo.vs.function.annotation.MethodArgs;
import com.levkopo.vs.function.annotation.MethodName;
import com.levkopo.vs.value.IntegerValue;

import java.util.concurrent.TimeUnit;

@MethodArgs(IntegerValue.class)
@MethodName("sleep")
public class Sleep extends VoidMethod {
	@Override
	public void callVoid(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
		IntegerValue timeInMillis = (IntegerValue) descriptor.get(0);
		try {
			TimeUnit.MILLISECONDS.sleep(timeInMillis.value());
		} catch (InterruptedException ignored) {}
	}
}