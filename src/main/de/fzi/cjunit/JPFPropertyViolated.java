/*
 * This file is covered by the terms of the Common Public License v1.0.
 *
 * Copyright (c) SZEDER Gábor
 *
 * Parts of this software were developed within the JEOPARD research
 * project, which received funding from the European Union's Seventh
 * Framework Programme under grant agreement No. 216682.
 */

package de.fzi.cjunit;

import static de.fzi.cjunit.util.LineSeparator.lineSeparator;

import gov.nasa.jpf.Property;


/**
 * This exception is thrown when a property is violated while the test is run
 * under Java PathFinder.
 */
public class JPFPropertyViolated extends Error {

	private static final long serialVersionUID = 1L;

	private Property violatedProperty;

	/**
	 * @param violatedProperty	the property which was violated during
	 *				the test run
	 */
	public JPFPropertyViolated(Property violatedProperty) {
		super(new String("Property '"
				+ violatedProperty.getClass().getName()
				+ "' violated" + lineSeparator
				+ violatedProperty.getErrorMessage()));
		this.violatedProperty = violatedProperty;
	}

	/**
	 * @return	the property which was violated during the test run
	 */
	public Property getViolatedProperty() {
		return violatedProperty;
	}
}
