package cloudlion.domain;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id", nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "project_id", nullable = false, updatable = false)
    private Project project;
	
    @Column(name = "file_name", nullable = false, unique = true)
    private String fileName;
    
    @Column(name = "text", nullable = false, unique = true, length = 100000)
    private String text;
    
    public Long getId() {
        return id;
    }
    
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
        return "File{" +
        		"id=" + id +
                "projectId=" + project.getId() +
                '}';
    }
}
