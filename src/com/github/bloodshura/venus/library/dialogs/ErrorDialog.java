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
import com.github.bloodshura.venus.function.VoidMethod;
import com.github.bloodshura.venus.function.annotation.MethodName;
import com.github.bloodshura.venus.function.annotation.MethodVarArgs;
import com.github.bloodshura.venus.value.Value;
import com.github.bloodshura.x.charset.build.TextBuilder;
import com.github.bloodshura.x.sys.enumeration.AlertType;
import com.github.bloodshura.x.util.Pool;

@MethodName("errorDialog")
@MethodVarArgs
public class ErrorDialog extends VoidMethod {
  @Override
  public void callVoid(Context context, FunctionCallDescriptor descriptor) throws ScriptRuntimeException {
    if (descriptor.isEmpty()) {
      return;
    }

    String title = descriptor.transform(0, Value::toString, null);
    TextBuilder message = Pool.newBuilder();
    int offset = descriptor.count() > 1 ? 1 : 0;

    for (int i = offset; i < descriptor.count(); i++) {
      message.append(descriptor.get(i));
      message.newLine();
    }

    XDialogs.show(AlertType.ERROR, title, message);
  }
}