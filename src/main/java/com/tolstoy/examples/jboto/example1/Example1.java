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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tolstoy.jboto.api.framework.IFrameworkFactory;
import com.tolstoy.jboto.api.framework.IFramework;
import com.tolstoy.jboto.app.framework.FrameworkFactory;

public final class Example1 {
	private static final Logger logger = LogManager.getLogger( Example1.class );

	private Example1() throws Exception {
		Car product = new Car();
		OurEnvironment env = new OurEnvironment();

		String testJSON = IOUtils.toString( getClass().getResource( "/test.json" ), StandardCharsets.UTF_8 );

		IFrameworkFactory factory = new FrameworkFactory( "com.tolstoy.examples.jboto.example1" );

		IFramework framework = factory.makeFrameworkFromJSON( "test", testJSON );

		logger.info( "\n" + framework.toDebugString( "" ) );

		logger.info( "PRODUCT BEFORE: " + product );

		framework.run( product, env, null );

		logger.info( "PRODUCT AFTER: " + product );
	}

	public static void main( final String[] args ) throws Exception {
		new Example1();
	}
}
