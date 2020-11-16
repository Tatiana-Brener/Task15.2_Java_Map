package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class File {

    private String fileExtension;
    private String application;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(fileExtension, file.fileExtension) &&
                Objects.equals(application, file.application);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileExtension, application);
    }

    @Override
    public String toString() {
        return "File{" +
                "fileExtension='" + fileExtension + '\'' +
                ", application='" + application + '\'' +
                '}';
    }

}
