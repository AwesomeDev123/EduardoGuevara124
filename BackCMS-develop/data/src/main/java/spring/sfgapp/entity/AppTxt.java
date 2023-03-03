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
@Table(name = "APPTXT")
public class AppTxt extends BaseEntity {
	@Builder
	public AppTxt(Long id, int appTxtOrder, String appTxtName, String appTxtTitle, String apptxtSbTitle,
			String appTxtMsg, String appTxtSbMsg, String appTxtFrom, String appTxtTo, Set<AppAgree> appAgreeTxtSet,
			Set<AppImg> appImgTxtSet) {
		super(id);
		this.appTxtOrder = appTxtOrder;
		this.appTxtName = appTxtName;
		this.appTxtTitle = appTxtTitle;
		this.apptxtSbTitle = apptxtSbTitle;
		this.appTxtMsg = appTxtMsg;
		this.appTxtSbMsg = appTxtSbMsg;
		this.appTxtFrom = appTxtFrom;
		this.appTxtTo = appTxtTo;
		if (appAgreeTxtSet != null) {
			this.appAgreeTxtSet = appAgreeTxtSet;
		}
		if (appImgTxtSet != null) {
			this.appImgTxtSet = appImgTxtSet;
		}
	}

	@Column(name = "app_txt_order")
	private int appTxtOrder;
	@Column(name = "app_txt_name")
	private String appTxtName;
	@Column(name = "app_txt_title")
	private String appTxtTitle;
	@Column(name = "app_txt_sb_title")
	private String apptxtSbTitle;
	@Column(name = "app_txt_msg")
	private String appTxtMsg;
	@Column(name = "app_txt_sb_msg")
	private String appTxtSbMsg;
	@Column(name = "app_txt_from")
	private String appTxtFrom;
	@Column(name = "app_txt_to")
	private String appTxtTo;

	@ManyToOne
	@JoinColumn(name = "app_module_id")
	private AppMod appMod;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "txtAgree")
	private Set<AppAgree> appAgreeTxtSet = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "txtImage")
	private Set<AppImg> appImgTxtSet = new HashSet<>();
}
