package cloudlion.database;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class FileCreateForm {

	@NotNull
    @NotEmpty
    private String fileName = "";

    @NotEmpty
    private String text = "";
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "FileCreateForm{" +
                ", filename=" + fileName +
                ", text=" + text +
                '}';
    }

}
