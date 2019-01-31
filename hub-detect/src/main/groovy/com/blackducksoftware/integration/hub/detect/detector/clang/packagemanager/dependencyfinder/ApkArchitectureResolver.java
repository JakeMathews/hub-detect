package com.blackducksoftware.integration.hub.detect.detector.clang.packagemanager.dependencyfinder;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import com.blackducksoftware.integration.hub.detect.detector.clang.packagemanager.ClangPackageManagerInfo;
import com.blackducksoftware.integration.hub.detect.util.executable.ExecutableOutput;
import com.blackducksoftware.integration.hub.detect.util.executable.ExecutableRunner;
import com.blackducksoftware.integration.hub.detect.util.executable.ExecutableRunnerException;

public class ApkArchitectureResolver {
    private Optional<String> architecture = Optional.empty();
    private boolean hasAttemptedResolution = false;

    public Optional<String> resolveArchitecture(ClangPackageManagerInfo currentPackageManager, File workingDirectory, ExecutableRunner executableRunner) throws ExecutableRunnerException {
        if (hasAttemptedResolution){
            return architecture;
        } else if (currentPackageManager.getPkgArchitectureArgs().isPresent()){
            hasAttemptedResolution = true;
            String cmd = currentPackageManager.getPkgMgrCmdString();
            List<String> args = currentPackageManager.getPkgArchitectureArgs().get();
            ExecutableOutput architectureOutput = executableRunner.executeQuietly(workingDirectory, cmd, args);
            architecture = Optional.ofNullable(architectureOutput.getStandardOutput().trim());
            return architecture;
        } else {
            hasAttemptedResolution = true;
            architecture = Optional.empty();
            return architecture;
        }
    }
}