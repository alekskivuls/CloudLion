package cloudlion.service.file;

import java.util.Collection;
import java.util.Optional;

import cloudlion.database.File;
import cloudlion.database.FileCreateForm;

public interface FileService {

    Optional<File> getFileById(long id);

    Optional<File> getFileByFileName(String fileName);

    Collection<File> getAllFiles();

    File create(FileCreateForm form);

}
