/*
 * $Id: LogRegistryInstantiationException.java 545 2010-08-25 12:58:58Z kchristiansen $
 * $Revision: 545 $
 * $Date: 2010-08-25 14:58:58 +0200 (Wed, 25 Aug 2010) $
 * $Author: kchristiansen $
 *
 * The DOMS project.
 * Copyright (C) 2007-2010  The State and University Library
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package dk.statsbiblioteket.doms.domsutil.surveillance.logappender;

/** An exception that reports trouble when instantiating a LogRegistry. */
public class LogRegistryInstantiationException extends RuntimeException {
    /**
     * Initiate an exception for LogRegistry instantiation.
     *
     * @param message The message.
     * @param cause The cause.
     */
    public LogRegistryInstantiationException(String message, Throwable cause) {
        super(message, cause);
    }
}
