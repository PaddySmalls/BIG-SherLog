package com.big.sherlog.testAgent;

import com.big.sherlog.dummy.DummyClass;
import com.big.sherlog.util.JavassistUtils;

/**
 * Created by patrick.kleindienst on 03.06.2015.
 */
public class TestAgentMain {
	private static final String	dummyClassName	= "com.big.instr.dummy.DummyClass";
	private static final String	dummyMethodName	= "printSomething";

	public static void main(String[] args) {
		DummyClass dummyClass = new DummyClass();
		dummyClass.printSomething();
		TestAgent.instrumentationService.doInstrumentation(dummyClassName, dummyMethodName, JavassistUtils.getSignaturesForMethod(dummyClassName,
				dummyMethodName).get(0));

		dummyClass.printSomething();
		TestAgent.instrumentationService.restoreClass(DummyClass.class);
		dummyClass.printSomething();
	}
}
