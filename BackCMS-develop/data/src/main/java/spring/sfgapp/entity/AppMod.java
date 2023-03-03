package spring.sfgapp.entity;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPMOD")
public class AppMod extends BaseEntity {

	@Builder
	public AppMod(Long id, Long appModIndex, String appModName, Long appModTplate, Long appModImage, Long appModTxt,
			Long appModOpt, Long appModAgree, Set<AppTplate> appTplateSet, Set<AppTxt> appTxtSet,
			Set<AppOpt> appOptSet) {
		super(id);
		this.appModIndex = appModIndex;
		this.appModTplate = appModTplate;
		this.appModName = appModName;
		this.appModImage = appModImage;
		this.appModTxt = appModTxt;
		this.appModOpt = appModOpt;
		this.appModAgree = appModAgree;

		if (appTplateSet != null) {
			this.appTplateSet = appTplateSet;
		}

		if (appTxtSet != null) {
			this.appTxtSet = appTxtSet;
		}

		if (appOptSet != null) {
			this.appOptSet = appOptSet;
		}
	}

	@Column(name = "app_mod_index")
	private Long appModIndex;
	@Column(name = "app_mod_name")
	private String appModName;
	@Column(name = "app_mod_tplate")
	private Long appModTplate;
	@Column(name = "app_mod_image")
	private Long appModImage;
	@Column(name = "app_mod_txt")
	private Long appModTxt;
	@Column(name = "app_mod_opt")
	private Long appModOpt;
	@Column(name = "app_mod_agree")
	private Long appModAgree;

	@ManyToOne
	@JoinColumn(name = "registry_id")
	private RegApp registryUser;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appMod")
	private Set<AppTplate> appTplateSet = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appMod")
	private Set<AppTxt> appTxtSet = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appMod")
	private Set<AppOpt> appOptSet = new HashSet<>();
}
