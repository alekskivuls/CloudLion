package cloudlion.database.validator;

import cloudlion.database.FileCreateForm;
import cloudlion.service.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileCreateFormValidator implements Validator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCreateFormValidator.class);
    private final FileService fileService;

    @Autowired
    public FileCreateFormValidator(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(FileCreateForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LOGGER.debug("Validating {}", target);
        FileCreateForm form = (FileCreateForm) target;
        validateName(errors, form);
    }

    private void validateName(Errors errors, FileCreateForm form) {
        if (fileService.getFileByFileName(form.getFileName()).isPresent()) {
            errors.reject("file.exists", "File with this name already exists");
        }
    }
}
