package spring.sfgapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APPIMG")
public class AppImg extends BaseEntity {
	@Builder
	public AppImg(Long id, String imgImp, String imgName) {
		super(id);
		this.imgImp = imgImp;
		this.imgName = imgName;
	}

	@Column(name = "img_imp")
	private String imgImp;
	@Column(name = "img_name")
	private String imgName;

	@ManyToOne
	@JoinColumn(name = "imgTxt_id")
	private AppTxt txtImage;

	@ManyToOne
	@JoinColumn(name = "imgOpt_id")
	private AppOpt agreeImg;

}
