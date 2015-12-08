package cloudlion.database;

import javax.persistence.*;

@Entity
@Table(name = "project_user")
public class ProjectUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

	@ManyToOne
    @JoinColumn(name = "project_id", nullable = false, updatable = false)
    private Project project;
    
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProjectUser{" +
        		"id=" + id +
                "userId=" + user.getId() +
                "projectId=" + project.getId() +
                '}';
    }
}
