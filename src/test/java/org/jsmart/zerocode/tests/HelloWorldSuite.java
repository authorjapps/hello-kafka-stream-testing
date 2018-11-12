package org.jsmart.zerocode.tests;

import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.TestPackageRoot;
import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runner.RunWith;

@TargetEnv("application_hosts.properties")
@RunWith(ZeroCodePackageRunner.class)
@TestPackageRoot("tests") //<--- Root of the package to pick all tests including sub-folders
public class HelloWorldSuite {

}
