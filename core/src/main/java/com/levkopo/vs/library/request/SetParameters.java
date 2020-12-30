package com.levkopo.vs.library.request;

import com.levkopo.vs.exception.runtime.ScriptRuntimeException;
import com.levkopo.vs.executor.Context;
import com.levkopo.vs.function.FunctionCallDescriptor;
import com.levkopo.vs.function.Method;
import com.levkopo.vs.function.annotation.MethodArgs;
import com.levkopo.vs.function.annotation.MethodName;
import com.levkopo.vs.value.MapValue;
import com.levkopo.vs.value.ObjectValue;
import com.levkopo.vs.value.Value;

@MethodName("setParameters")
@MethodArgs({MapValue.class})
public class SetParameters extends Method {
    @Override
    public Value call(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
        ObjectValue this_ = (ObjectValue) context.getVar("this").getValue();
        context.setVar("parameters", descriptor.get(0));
        return this_;
    }
}
