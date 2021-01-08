/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.tools.projectWizard.wizard;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.jetbrains.kotlin.test.TestRoot;
import org.junit.runner.RunWith;

/*
 * This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}.
 * DO NOT MODIFY MANUALLY.
 */
@SuppressWarnings("all")
@TestRoot("project-wizard/idea")
@TestDataPath("$CONTENT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public abstract class YamlNewWizardProjectImportTestGenerated extends AbstractYamlNewWizardProjectImportTest {
    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../cli/testData/buildFileGeneration")
    public static class GradleKts extends AbstractYamlNewWizardProjectImportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestGradleKts, this, testDataFilePath);
        }

        @TestMetadata("android")
        public void testAndroid() throws Exception {
            runTest("../cli/testData/buildFileGeneration/android/");
        }

        @TestMetadata("jsNodeAndBrowserTargets")
        public void testJsNodeAndBrowserTargets() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jsNodeAndBrowserTargets/");
        }

        @TestMetadata("jvmTarget")
        public void testJvmTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTarget/");
        }

        @TestMetadata("jvmTargetWithJava")
        public void testJvmTargetWithJava() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTargetWithJava/");
        }

        @TestMetadata("jvmToJvmDependency")
        public void testJvmToJvmDependency() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependency/");
        }

        @TestMetadata("jvmToJvmDependencyWithSingleRoot")
        public void testJvmToJvmDependencyWithSingleRoot() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependencyWithSingleRoot/");
        }

        @TestMetadata("kotlinJvm")
        public void testKotlinJvm() throws Exception {
            runTest("../cli/testData/buildFileGeneration/kotlinJvm/");
        }

        @TestMetadata("nativeForCurrentSystem")
        public void testNativeForCurrentSystem() throws Exception {
            runTest("../cli/testData/buildFileGeneration/nativeForCurrentSystem/");
        }

        @TestMetadata("simpleMultiplatform")
        public void testSimpleMultiplatform() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleMultiplatform/");
        }

        @TestMetadata("simpleNativeTarget")
        public void testSimpleNativeTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleNativeTarget/");
        }

        @TestMetadata("singlePlatformJsBrowser")
        public void testSinglePlatformJsBrowser() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsBrowser/");
        }

        @TestMetadata("singlePlatformJsNode")
        public void testSinglePlatformJsNode() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsNode/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../cli/testData/buildFileGeneration")
    public static class GradleGroovy extends AbstractYamlNewWizardProjectImportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestGradleGroovy, this, testDataFilePath);
        }

        @TestMetadata("android")
        public void testAndroid() throws Exception {
            runTest("../cli/testData/buildFileGeneration/android/");
        }

        @TestMetadata("jsNodeAndBrowserTargets")
        public void testJsNodeAndBrowserTargets() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jsNodeAndBrowserTargets/");
        }

        @TestMetadata("jvmTarget")
        public void testJvmTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTarget/");
        }

        @TestMetadata("jvmTargetWithJava")
        public void testJvmTargetWithJava() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTargetWithJava/");
        }

        @TestMetadata("jvmToJvmDependency")
        public void testJvmToJvmDependency() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependency/");
        }

        @TestMetadata("jvmToJvmDependencyWithSingleRoot")
        public void testJvmToJvmDependencyWithSingleRoot() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependencyWithSingleRoot/");
        }

        @TestMetadata("kotlinJvm")
        public void testKotlinJvm() throws Exception {
            runTest("../cli/testData/buildFileGeneration/kotlinJvm/");
        }

        @TestMetadata("nativeForCurrentSystem")
        public void testNativeForCurrentSystem() throws Exception {
            runTest("../cli/testData/buildFileGeneration/nativeForCurrentSystem/");
        }

        @TestMetadata("simpleMultiplatform")
        public void testSimpleMultiplatform() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleMultiplatform/");
        }

        @TestMetadata("simpleNativeTarget")
        public void testSimpleNativeTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleNativeTarget/");
        }

        @TestMetadata("singlePlatformJsBrowser")
        public void testSinglePlatformJsBrowser() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsBrowser/");
        }

        @TestMetadata("singlePlatformJsNode")
        public void testSinglePlatformJsNode() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsNode/");
        }
    }

    @RunWith(JUnit3RunnerWithInners.class)
    @TestMetadata("../cli/testData/buildFileGeneration")
    public static class Maven extends AbstractYamlNewWizardProjectImportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTestMaven, this, testDataFilePath);
        }

        @TestMetadata("android")
        public void testAndroid() throws Exception {
            runTest("../cli/testData/buildFileGeneration/android/");
        }

        @TestMetadata("jsNodeAndBrowserTargets")
        public void testJsNodeAndBrowserTargets() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jsNodeAndBrowserTargets/");
        }

        @TestMetadata("jvmTarget")
        public void testJvmTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTarget/");
        }

        @TestMetadata("jvmTargetWithJava")
        public void testJvmTargetWithJava() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmTargetWithJava/");
        }

        @TestMetadata("jvmToJvmDependency")
        public void testJvmToJvmDependency() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependency/");
        }

        @TestMetadata("jvmToJvmDependencyWithSingleRoot")
        public void testJvmToJvmDependencyWithSingleRoot() throws Exception {
            runTest("../cli/testData/buildFileGeneration/jvmToJvmDependencyWithSingleRoot/");
        }

        @TestMetadata("kotlinJvm")
        public void testKotlinJvm() throws Exception {
            runTest("../cli/testData/buildFileGeneration/kotlinJvm/");
        }

        @TestMetadata("nativeForCurrentSystem")
        public void testNativeForCurrentSystem() throws Exception {
            runTest("../cli/testData/buildFileGeneration/nativeForCurrentSystem/");
        }

        @TestMetadata("simpleMultiplatform")
        public void testSimpleMultiplatform() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleMultiplatform/");
        }

        @TestMetadata("simpleNativeTarget")
        public void testSimpleNativeTarget() throws Exception {
            runTest("../cli/testData/buildFileGeneration/simpleNativeTarget/");
        }

        @TestMetadata("singlePlatformJsBrowser")
        public void testSinglePlatformJsBrowser() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsBrowser/");
        }

        @TestMetadata("singlePlatformJsNode")
        public void testSinglePlatformJsNode() throws Exception {
            runTest("../cli/testData/buildFileGeneration/singlePlatformJsNode/");
        }
    }
}
