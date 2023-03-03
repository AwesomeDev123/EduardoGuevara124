package spring.sfgapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPTPLATE")
public class AppTplate extends BaseEntity {
	@Builder
	public AppTplate(long id, String appTplateName) {
		super(id);
		this.appTplateName = appTplateName;
	}

	@Column(name = "app_tplate_name")
	private String appTplateName;

	@ManyToOne
	@JoinColumn(name = "app_module_id")
	private AppMod appMod;

}
