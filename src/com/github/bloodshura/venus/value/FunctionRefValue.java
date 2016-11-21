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

package com.github.bloodshura.venus.value;

import com.github.bloodshura.venus.compiler.KeywordDefinitions;
import com.github.bloodshura.venus.type.PrimitiveType;
import com.github.bloodshura.x.util.layer.XApi;

public class FunctionRefValue extends Value {
  private final String value;

  public FunctionRefValue(String value) {
    super(PrimitiveType.FUNCTION_REFERENCE);
    XApi.requireNonNull(value, "value");

    this.value = value;
  }

  @Override
  public FunctionRefValue clone() {
    return new FunctionRefValue(value());
  }

  @Override
  public String toString() {
    return KeywordDefinitions.FUNCTION_REFERENCE + value();
  }

  @Override
  public String value() {
    return value;
  }
}