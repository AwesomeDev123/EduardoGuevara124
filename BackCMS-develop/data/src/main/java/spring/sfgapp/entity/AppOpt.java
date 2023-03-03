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
@Table(name = "APPOPT")
public class AppOpt extends BaseEntity {

	@Builder
	public AppOpt(Long id, String optImpGuide, String optName, String optDsc, String optValFrom, String optValTo,
			String optTitle, String optSubTitle, String optSrcImgUrl, String optTitleImg, String optSrcIconUrl,
			String optTitleIcon, Set<AppAgree> appAgreeOptSet, Set<AppImg> appImgOptset, int optSrcImgId, int optSrcIconId) {
		super(id);
		this.optImpGuide = optImpGuide;
		this.optName = optName;
		this.optDsc = optDsc;
		this.optValFrom = optValFrom;
		this.optValTo = optValTo;
		this.optTitle = optTitle;
		this.optSubTitle = optSubTitle;
		this.optSrcImgUrl = optSrcImgUrl;
		this.optTitleImg = optTitleImg;
		this.optSrcIconUrl = optSrcIconUrl;
		this.optTitleIcon = optTitleIcon;
		if (appImgOptset != null) {
			this.appImgOptset = appImgOptset;
		}
		if (appAgreeOptSet != null) {
			this.appAgreeOptSet = appAgreeOptSet;
		}
		this.optSrcImgId = optSrcImgId;
		this.optSrcIconId = optSrcIconId;
	}

	@Column(name = "opt_imp_guide")
	private String optImpGuide;
	@Column(name = "opt_name")
	private String optName;
	@Column(name = "opt_dsc")
	private String optDsc;
	@Column(name = "opt_val_from")
	private String optValFrom;
	@Column(name = "optValTo")
	private String optValTo;
	@Column(name = "opt_title")
	private String optTitle;
	@Column(name = "opt_subtitl")
	private String optSubTitle;
//	@Lob
//	@Column(name = "opt_src_img", columnDefinition = "BLOB")
//	private Byte[] optSrcImg;
	@Column(name = "opt_title_img")
	private String optTitleImg;
//	@Lob
//	@Column(name = "opt_src_ico", columnDefinition = "BLOB")
//	private Byte[] optSrcIcon;
	@Column(name = "opt_title_ico")
	private String optTitleIcon;
	
	@Column(name = "opt_src_img_id")
	private int optSrcImgId;
	@Column(name = "opt_src_icon_id")
	private int optSrcIconId;
	@Column(name = "opt_src_img_url")
	private String optSrcImgUrl;
	@Column(name = "opt_src_icon_url")
	private String optSrcIconUrl;
	

	@ManyToOne
	@JoinColumn(name = "app_module_id")
	private AppMod appMod;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agreeOpt")
	private Set<AppAgree> appAgreeOptSet = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agreeImg")
	private Set<AppImg> appImgOptset = new HashSet<>();

}
