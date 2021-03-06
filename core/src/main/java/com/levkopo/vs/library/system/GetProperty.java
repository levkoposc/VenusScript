package com.levkopo.vs.library.system;

import com.levkopo.vs.Config;
import com.levkopo.vs.exception.runtime.ScriptRuntimeException;
import com.levkopo.vs.executor.Context;
import com.levkopo.vs.function.FunctionCallDescriptor;
import com.levkopo.vs.function.Method;
import com.levkopo.vs.function.annotation.MethodArgs;
import com.levkopo.vs.function.annotation.MethodName;
import com.levkopo.vs.value.StringValue;
import com.levkopo.vs.value.Value;

@MethodArgs({ StringValue.class, Value.class })
@MethodName("getProperty")
public class GetProperty extends Method {
	@Override
	public Value call(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
		StringValue key = (StringValue) descriptor.get(0);
		Object value;
		if(key.value().startsWith("VS_")){
			value = Config.values().get(key.value().replaceAll("VS_", ""));
		}else value = System.getProperty(key.value());

		Value result = Value.construct(value);

		return result != null ? result : descriptor.get(1);
	}
}