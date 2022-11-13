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

import java.util.List;
import java.util.ArrayList;

import com.tolstoy.jboto.api.IProduct;

public class Car implements IProduct {
	private String licensePlateNumber;
	private final List<String> features, headlights;

	Car() {
		this.licensePlateNumber = "";
		this.features = new ArrayList<String>();
		this.headlights = new ArrayList<String>();
	}

	public void addFeature( String val ) {
		features.add( val );
	}

	public List<String> getFeatures() {
		return features;
	}

	public void addHeadlight( String val ) {
		headlights.add( val );
	}

	public List<String> getHeadlights() {
		return headlights;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber( String val ) {
		licensePlateNumber = val;
	}

	@Override
	public String toString() {
		return "car with license plate number " + getLicensePlateNumber() + " has these headlights: " + getHeadlights() + " and these features: " + getFeatures();
	}
}
