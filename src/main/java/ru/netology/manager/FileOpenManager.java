package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FileOpenManager {

    Map<String, String> files = new HashMap<>();

    public Map <String, String> addNewApplication(String fileExtension, String application) {
        files.put(fileExtension, application);
        return files;
    }

    public String getApplicationByFileExtension(String fileExtension) {
        for (String file : files.keySet()) {
            if (files.containsKey(fileExtension.toLowerCase())) {
                return files.get(fileExtension.toLowerCase());
            }
        }
        return null;
    }

    public Map<String, String> removeApplicationBindingToExtension(String fileExtension) {
        for(String file : files.keySet()) {
            if(files.containsKey(fileExtension.toLowerCase())) {
                files.remove(fileExtension.toLowerCase());
                return files;
            }
        }
        return files;
    }

//    метод с учетом игнорирования регистра названия расширения

//    public Map<String, String> removeApplicationBindingToExtension2(String fileExtension) {
//        for(String file : files.keySet()) {
//            if(files.containsKey(fileExtension) && file.equalsIgnoreCase(fileExtension)) {
//                files.remove(fileExtension);
//                return files;
//            }
//        }
//        return files;
//    }

    public Set<String> getListOfAllRegisteredExtensions() {
        return files.keySet();
    }

    public Set<String> getListOfAllApplicationsBindingToExtensions() {
        return new HashSet<>(files.values());
        }
}
