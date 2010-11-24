ant: Android TestConverter -> Junit xml
=======================================

Usage:
======

- Copy the testcovertertask.jar to your classpath (or classpath-ref).

- Call the task according regarding your task-definition, i. e. "parsereport"
  It requires 2 parameters:
  - input: result (file) from a previous executed junit android test with argument -r (for raw output
    format). @see example below (target "test")
  - output: file where to store the generated junit-xml compatible file to.


Example use:
============

<project name="example">

    <path id="libs.classpath">
        <fileset dir="../libs" includes="**/*.jar" />
    </path>
    <taskdef name="parsereport" classname="de.mobiletechcon.testconvertertask.ConverterTask"
        classpathref="libs.classpath" />

    <target name="parse-report">
        <echo>Generate junit xml</echo>
        <parsereport input="${tmpfile}" output="reports/report-junit.xml" />
    </target>

    <!-- This target executes the android junit test -->
    <property name="tmpfile" value="_tmptestresults.txt" />
    <target name="test">
        <echo>Testing</echo>
        <exec executable="${sdk-location}/tools/adb" output="${tmpfile}">
            <arg value="shell" />
            <arg value="am" />
            <arg value="instrument" />
            <arg value="-r" />
            <arg value="-w" />
            <arg value="<YOUR-TEST-PACKAGE>/android.test.InstrumentationTestRunner" />
        </exec>
    </target>
</project>
