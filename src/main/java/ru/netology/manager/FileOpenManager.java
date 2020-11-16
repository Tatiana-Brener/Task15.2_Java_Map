package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.File;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FileOpenManager {

    Map<String, String> files = new HashMap<>();

    public Map<String, String> addNewApplication(String fileExtension, String application) {
        Map<String, String> addedApplication = new HashMap<>();
        addedApplication.put(fileExtension, application);
        return addedApplication;
    }

    public String getApplication(String fileExtension) {
        for(Map.Entry file : files.entrySet()) {
            if (file.getKey() == fileExtension) {
                return files.get(fileExtension);
            }
        }
        return null;
    }

    public Map<String, String> removeApplicationBindingToExtension(String fileExtension) {
        for(Map.Entry file : files.entrySet()) {
            if(file.getKey() == fileExtension) {
                files.remove(fileExtension);
                return files;
            }
        }
        return files;
    }

    public Set<String> getListOfAllRegisteredExtensions() {
        Set<String> extensions = files.keySet();
        return extensions;
    }

    public Set<String> getListOfAllApplicationsBindingToExtensions() {
        Set<String> applications = new HashSet<>(files.values());
            return applications;
        }
}
