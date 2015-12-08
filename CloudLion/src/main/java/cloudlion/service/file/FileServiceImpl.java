package cloudlion.service.file;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cloudlion.database.File;
import cloudlion.database.FileCreateForm;
import cloudlion.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public Optional<File> getFileById(long id) {
        LOGGER.debug("Getting file={}", id);
        return Optional.ofNullable(fileRepository.findOne(id));
    }

    @Override
    public Optional<File> getFileByFileName(String fileName) {
        LOGGER.debug("Getting file by filename={}", fileName);
        return fileRepository.findOneByFileName(fileName);
    }

    @Override
    public Collection<File> getAllFiles() {
        LOGGER.debug("Getting all files");
        return fileRepository.findAll(new Sort("email"));
    }

    @Override
    public File create(FileCreateForm form) {
        File file = new File();
        file.setFileName(form.getFileName());
        file.setText(form.getText());
        System.out.println(file);
        return fileRepository.save(file);
    }

}
