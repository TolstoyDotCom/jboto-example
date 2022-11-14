/*
 * Copyright 2022 Chris Kelly
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.tolstoy.examples.jboto.example1;

import com.tolstoy.jboto.api.IProduct;
import com.tolstoy.jboto.api.IEnvironment;
import com.tolstoy.jboto.api.IBasicCommand;

public class AddHeadlight implements IBasicCommand {
	public AddHeadlight() {
	}

	public void run( IProduct product, IEnvironment env, Object extra, int index ) throws Exception {
		Car car = (Car) product;
		OurEnvironment ourEnv = (OurEnvironment) env;
		String headlightName = (String) extra;

		car.addHeadlight( headlightName );
	}
}
