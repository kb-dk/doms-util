/*
 * $Id: LogStatusMessage.java 545 2010-08-25 12:58:58Z kchristiansen $
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

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import dk.statsbiblioteket.doms.domsutil.surveyable.Severity;
import dk.statsbiblioteket.doms.domsutil.surveyable.StatusMessage;
import dk.statsbiblioteket.util.qa.QAInfo;

import javax.xml.bind.annotation.XmlRootElement;

/** A status message tuple initialised with a log event. */
@XmlRootElement
@QAInfo(author = "kfc",
        reviewers = "jrg",
        level = QAInfo.Level.NORMAL,
        state = QAInfo.State.QA_OK)
public class LogStatusMessage extends StatusMessage {
    /**
     * Helper method to map logging level to severity.
     * Severity maps to YELLOW for warnings, RED for fatal and error.
     * All else GREEN.
     *
     * @param level A log level.
     * @return The severity.
     */
    private static Severity getSeverity(Level level) {
        switch (level.toInt()) {
            case Level.FATAL_INT:
            case Level.ERROR_INT:
                return Severity.RED;
            case Level.WARN_INT:
                return Severity.YELLOW;
            default:
                return Severity.GREEN;
        }
    }

    /**
     * Helper method to map logging level to severity.
     * Severity maps to YELLOW for warnings, RED for fatal and error.
     * All else GREEN.
     *
     * @param level A log level.
     * @return The severity.
     */
    private static Severity getSeverity(ch.qos.logback.classic.Level level) {
        switch (level.toInt()) {
            case Level.FATAL_INT:
            case Level.ERROR_INT:
                return Severity.RED;
            case Level.WARN_INT:
                return Severity.YELLOW;
            default:
                return Severity.GREEN;
        }
    }

    /**
     * Initialise the status message by converting the relevant fields from the
     * log event.
     * Severity maps to YELLOW for warnings, RED for fatal and error.
     * All else GREEN.
     *
     * @param event The log event.
     */
    public LogStatusMessage(LoggingEvent event) {
        super();
        setMessage(event.getRenderedMessage());
        setSeverity(getSeverity(event.getLevel()));
        setTime(event.getTimeStamp());
        setLogMessage(true);
    }

    /**
     * Initialise the status message by converting the relevant fields from the
     * log event.
     * Severity maps to YELLOW for warnings, RED for fatal and error.
     * All else GREEN.
     *
     * @param event The log event.
     */
    public LogStatusMessage(ILoggingEvent event) {
        super();
        setMessage(event.getFormattedMessage());
        setSeverity(getSeverity(event.getLevel()));
        setTime(event.getTimeStamp());
        setLogMessage(true);
    }
}
