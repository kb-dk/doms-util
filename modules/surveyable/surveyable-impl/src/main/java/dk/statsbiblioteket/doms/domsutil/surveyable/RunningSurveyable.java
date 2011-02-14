/*
 * $Id: EcmSurveyable.java 1393 2010-12-20 14:07:08Z blekinge $
 * $Revision: 1393 $
 * $Date: 2010-12-20 15:07:08 +0100 (Mon, 20 Dec 2010) $
 * $Author: blekinge $
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

package dk.statsbiblioteket.doms.domsutil.surveyable;

import dk.statsbiblioteket.doms.webservices.configuration.ConfigCollection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/* @QAInfo(author = "kfc",
        state = QAInfo.State.QA_NEEDED,
        level = QAInfo.Level.NORMAL,
        reviewers = "jrg") */
public class RunningSurveyable implements Surveyable {
    /** The name this status reports. */


    /** Log for this class. */
    private final Log log = LogFactory.getLog(getClass());

    /**
     * Always returns that status "Running".
     * @param l Ignored
     * @return Status "Running".
     */
    public Status getStatusSince(long l) {
        log.trace("Enter getStatusSince(" + l + ")");

        Status status = new Status();
        StatusMessage statusMessage = new StatusMessage();

        statusMessage.setLogMessage(false);
        statusMessage.setSeverity(Severity.GREEN);
        statusMessage.setTime(System.currentTimeMillis());
        statusMessage.setMessage("Running");
        status.setName(ConfigCollection
                .getProperties()
                .getProperty(
                "dk.statsbiblioteket.doms.surveillance.logappender.LoggerName",
                "Unnamed"));
        status.getMessages().add(statusMessage);
        return status;
    }

    /**
     * Reports exactly the same as getStatusSince(0L).
     * @return Status.
     */
    public Status getStatus() {
        log.trace("Enter getStatus()");

        return getStatusSince(0L);
    }
}
