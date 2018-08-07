/*
 * Copyright (c) 2013-2018, João Vitor Verona Biazibetti - All Rights Reserved
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * https://www.github.com/BloodShura
 */

package com.github.bloodshura.ignitium.venus.value;

import com.github.bloodshura.ignitium.charset.TextBuilder;
import com.github.bloodshura.ignitium.collection.tuple.Pair;
import com.github.bloodshura.ignitium.venus.component.object.ObjectDefinition;
import com.github.bloodshura.ignitium.venus.executor.Context;
import com.github.bloodshura.ignitium.venus.executor.VariableStructure;

public class ObjectValue extends Value {
	private final Context context;
	private final ObjectDefinition definition;

	public ObjectValue(ObjectDefinition definition, Context context) {
		super(definition.getType());
		this.context = context;
		this.definition = definition;
	}

	@Override
	public ObjectValue clone() {
		return new ObjectValue(getDefinition(), getContext().clone());
	}

	public Context getContext() {
		return context;
	}

	public ObjectDefinition getDefinition() {
		return definition;
	}

	@Override
	public Object value() {
		return this;
	}

	@Override
	public String toString() {
		TextBuilder attributes = new TextBuilder().setSeparator(", ");

		for (Pair<String, VariableStructure> pair : getContext().getVariables()) {
			attributes.append(pair.getLeft() + ": " + pair.getRight() + " [" + pair.getRight().getValue().getType() + ']');
		}

		return getDefinition().getName() + "(" + attributes + ')';
	}
}