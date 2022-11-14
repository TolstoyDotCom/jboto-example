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
import com.tolstoy.jboto.api.framework.IPackageAlias;
import com.tolstoy.jboto.api.framework.IFQNResolverFactory;
import com.tolstoy.jboto.api.framework.IFQNResolver;
import com.tolstoy.jboto.app.framework.FQNResolverFactory;
import com.tolstoy.jboto.app.framework.FrameworkFactory;

public final class Example1 {
	private static final Logger logger = LogManager.getLogger( Example1.class );

	//	most of the classes are in this package
	private static final String DEFAULT_PACKAGE_NAME = "com.tolstoy.examples.jboto.example1";

	//	for this example, two of the classes have been moved to this package
	private static final String CONTRIVED_EXAMPLE_PACKAGE_NAME = "com.tolstoy.examples.jboto.example1.samplepackage";

	private Example1() throws Exception {
		Car product = new Car();
		OurEnvironment env = new OurEnvironment();

		String testJSON = IOUtils.toString( getClass().getResource( "/test.json" ), StandardCharsets.UTF_8 );

		IFrameworkFactory frameworkFactory = new FrameworkFactory( createResolver() );

		IFramework framework = frameworkFactory.makeFrameworkFromJSON( "test", testJSON );

		logger.info( "\n" + framework.toDebugString( "" ) );

		logger.info( "PRODUCT BEFORE: " + product );

		framework.run( product, env, null, 0 );

		logger.info( "PRODUCT AFTER: " + product );
	}

	/**
	 * Our JBoto implementations are in two packages: DEFAULT_PACKAGE_NAME and CONTRIVED_EXAMPLE_PACKAGE_NAME.
	 * To avoid having to fully-qualify each class name in the JSON, we use aliases.
	 * In this case, "sample" is an alias for the CONTRIVED_EXAMPLE_PACKAGE_NAME package.
	 * In the JSON, the classname for PaintIt is "sample:PaintIt".
	 * We set DEFAULT_PACKAGE_NAME as the default for classnames in the JSON that don't have an alias.
	 */
	private IFQNResolver createResolver() throws Exception {
		IFQNResolverFactory resolverFactory = new FQNResolverFactory();
		List<IPackageAlias> aliases = new ArrayList<IPackageAlias>( 1 );

		IPackageAlias sampleAlias = resolverFactory.makePackageAlias( "sample", CONTRIVED_EXAMPLE_PACKAGE_NAME );
		aliases.add( sampleAlias );

		IFQNResolver resolver = resolverFactory.makeResolver( DEFAULT_PACKAGE_NAME, aliases );

		return resolver;
	}

	public static void main( final String[] args ) throws Exception {
		new Example1();
	}
}
