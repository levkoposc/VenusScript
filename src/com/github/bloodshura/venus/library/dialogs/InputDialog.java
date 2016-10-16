//////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016, João Vitor Verona Biazibetti - All Rights Reserved                /
//                                                                                       /
// This program is free software: you can redistribute it and/or modify                  /
// it under the terms of the GNU General Public License as published by                  /
// the Free Software Foundation, either version 3 of the License, or                     /
// (at your option) any later version.                                                   /
//                                                                                       /
// This program is distributed in the hope that it will be useful,                       /
// but WITHOUT ANY WARRANTY; without even the implied warranty of                        /
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the                          /
// GNU General Public License for more details.                                          /
//                                                                                       /
// You should have received a copy of the GNU General Public License                     /
// along with this program. If not, see <http://www.gnu.org/licenses/>.                  /
//                                                                                       /
// https://www.github.com/BloodShura                                                     /
//////////////////////////////////////////////////////////////////////////////////////////

package com.github.bloodshura.venus.library.dialogs;

import com.github.bloodshura.dialogs.XDialogs;
import com.github.bloodshura.venus.exception.runtime.ScriptRuntimeException;
import com.github.bloodshura.venus.executor.Context;
import com.github.bloodshura.venus.function.FunctionCallDescriptor;
import com.github.bloodshura.venus.function.Method;
import com.github.bloodshura.venus.function.annotation.MethodName;
import com.github.bloodshura.venus.function.annotation.MethodVarArgs;
import com.github.bloodshura.venus.value.StringValue;
import com.github.bloodshura.venus.value.Value;
import com.github.bloodshura.x.charset.build.TextBuilder;
import com.github.bloodshura.x.util.Pool;

/**
 * InputDialog.java
 *
 * @author <a href="https://www.github.com/BloodShura">BloodShura</a> (João Vitor Verona Biazibetti)
 * @contact joaaoverona@gmail.com
 * @date 14/05/16 - 19:52
 * @since GAMMA - 0x3
 */
@MethodName("inputDialog")
@MethodVarArgs
public class InputDialog extends Method {
  @Override
  public Value call(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
    if (descriptor.isEmpty()) {
      return new StringValue(Pool.EMPTY_STRING);
    }

    String title = descriptor.transform(0, Value::toString, null);
    TextBuilder message = Pool.newBuilder();
    int offset = descriptor.count() > 1 ? 1 : 0;

    for (int i = offset; i < descriptor.count(); i++) {
      message.append(descriptor.get(i));
      message.newLine();
    }

    String input = XDialogs.askInput(title, message);

    return new StringValue(input != null ? input : Pool.EMPTY_STRING);
  }
}