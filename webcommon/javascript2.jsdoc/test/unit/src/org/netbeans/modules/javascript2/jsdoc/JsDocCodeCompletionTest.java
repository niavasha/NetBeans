/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.javascript2.jsdoc;

import org.netbeans.modules.javascript2.editor.*;

/**
 *
 * @author Martin Fousek <marfous@oracle.com>
 */
public class JsDocCodeCompletionTest extends JsCodeCompletionBase {

    public JsDocCodeCompletionTest(String testName) {
        super(testName);
    }
  
    public void testAllCompletion() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @^param {int} One The first number to add", false);
    }

    public void testNoCompletion() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * ^@param {int} One The first number to add", false);
    }

    public void testParamCompletion2() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @p^aram {int} One The first number to add", false);
    }

    public void testParamCompletion3() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @pa^ram {int} One The first number to add", false);
    }

    public void testParamCompletion4() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @par^am {int} One The first number to add", false);
    }

    public void testParamCompletion5() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @para^m {int} One The first number to add", false);
    }

    public void testParamCompletion6() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @param^ {int} One The first number to add", false);
    }

    public void testMethodCompletion1() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @m^e", false);
    }

    public void testMethodCompletion2() throws Exception {
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", " * @me^", false);
    }

    public void testReturnCompletion() throws Exception {
        // @return tag should still offer @return and @returns entries
        checkCompletion("testfiles/jsdoc/classWithJsDoc.js", "* @return^ {Shape|Coordinate} A new shape.", false);
    }

}
