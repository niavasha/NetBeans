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
package org.netbeans.core.windows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.netbeans.junit.NbModuleSuite;
import org.netbeans.junit.NbTestCase;
import org.openide.windows.WindowManager;

public class InvokeWhenUIReadInHeadlessModeTest extends NbTestCase {

    public InvokeWhenUIReadInHeadlessModeTest(String name) {
        super(name);
    }

    public static junit.framework.Test suite() {
        return NbModuleSuite.emptyConfiguration().
            gui(false).
            addTest(InvokeWhenUIReadInHeadlessModeTest.class).
            suite();
    }


    public void testInvokeWhenReadInHeadlessMode() throws Exception {
        final CountDownLatch cdl = new CountDownLatch(1);
        WindowManager.getDefault().invokeWhenUIReady(new Runnable() {
            @Override
            public void run() {
                cdl.countDown();
            }
        });
        cdl.await(15, TimeUnit.SECONDS);
        assertEquals("Eventually the runnable is invoked", 0, cdl.getCount());
    }
}
