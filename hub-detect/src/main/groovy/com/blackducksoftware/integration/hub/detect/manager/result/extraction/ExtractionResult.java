/**
 * hub-detect
 *
 * Copyright (C) 2018 Black Duck Software, Inc.
 * http://www.blackducksoftware.com/
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.blackducksoftware.integration.hub.detect.manager.result.extraction;

import java.util.HashSet;
import java.util.List;

import com.blackducksoftware.integration.hub.detect.model.BomToolGroupType;
import com.blackducksoftware.integration.hub.detect.model.DetectCodeLocation;

public class ExtractionResult {
    private final HashSet<BomToolGroupType> failedBomTools;
    private final HashSet<BomToolGroupType> successfulBomTools;
    private final List<DetectCodeLocation> detectCodeLocations;

    public ExtractionResult(final List<DetectCodeLocation> detectCodeLocations, final HashSet<BomToolGroupType> successfulBomTools, final HashSet<BomToolGroupType> failedBomTools) {
        this.failedBomTools = failedBomTools;
        this.successfulBomTools = successfulBomTools;
        this.detectCodeLocations = detectCodeLocations;
    }


    public boolean getSuccess() {
        return true;
    }

    public List<DetectCodeLocation> getDetectCodeLocations() {
        return detectCodeLocations;
    }

    public HashSet<BomToolGroupType> getSuccessfulBomToolTypes() {
        return successfulBomTools;
    }

    public HashSet<BomToolGroupType> getFailedBomToolTypes() {
        return failedBomTools;
    }
}