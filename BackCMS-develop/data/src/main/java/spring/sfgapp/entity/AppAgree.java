package spring.sfgapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPAGREE")
public class AppAgree extends BaseEntity {
//The @Builder annotation produces complex builder APIs for your classes.
// @Builder lets you automatically produce the code required to have your class be instantiable with code such as: Person. builder()
	@Builder
	public AppAgree(Long id, String appAgreeTxt, String appAgreeIco, String appAgreeImg, String appRecomTxt,
			String appRecomIco, String appRecomImg) {
		super(id);
		this.appAgreeTxt = appAgreeTxt;
		this.appAgreeIco = appAgreeIco;
		this.appAgreeImg = appAgreeImg;
		this.appRecomTxt = appRecomTxt;
		this.appRecomIco = appRecomIco;
		this.appRecomImg = appRecomImg;
	}

	@Column(name = "app_agree_txt")
	private String appAgreeTxt;
	@Column(name = "app_agree_ico")
	private String appAgreeIco;
	@Column(name = "app_gree_imga")
	private String appAgreeImg;
	@Column(name = "app_recom_txt")
	private String appRecomTxt;
	@Column(name = "app_recom_ico")
	private String appRecomIco;
	@Column(name = "app_recom_img")
	private String appRecomImg;

	@ManyToOne
	@JoinColumn(name = "agreeOpt_id")
	private AppOpt agreeOpt;

	@ManyToOne
	@JoinColumn(name = "txtAgree_id")
	private AppTxt txtAgree;

}
