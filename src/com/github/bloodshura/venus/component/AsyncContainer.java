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

package com.github.bloodshura.venus.component;

import com.github.bloodshura.venus.executor.Context;

/**
 * AsyncContainer.java
 *
 * @author <a href="https://www.github.com/BloodShura">BloodShura</a> (João Vitor Verona Biazibetti)
 * @contact joaaoverona@gmail.com
 * @date 13/05/16 - 22:45
 * @since GAMMA - 0x3
 */
public class AsyncContainer extends Container {
  private final boolean daemon;

  public AsyncContainer(boolean daemon) {
    this.daemon = daemon;
  }

  public boolean isDaemon() {
    return daemon;
  }

  @Override
  public void setParent(Container parent) {
    super.setParent(parent);
    this.context = new Context(this, parent.getContext());
  }

  @Override
  public String toString() {
    return isDaemon() ? "async(daemon)" : "async()";
  }
}