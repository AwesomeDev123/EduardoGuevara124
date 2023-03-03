package spring.sfgapp.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CMSLABEL")
public class CmsDetLabels extends BaseEntity {
	@Builder
	public CmsDetLabels(Long id, int idOrder, int idTemplate, String label, String urlImage) {
		super(id);
		this.idOrder = idOrder;
		this.idTemplate = idTemplate;
		this.label = label;
		this.urlImage = urlImage;

	}

	@Column(name = "id_Cms")
	private int idCms;
	@Column(name = "id_Order")
	private int idOrder;
	@Column(name = "id_template")
	private int idTemplate;
	@Column(name = "label")
	private String label;
	@Column(name = "url_Image")
	private String urlImage;

}
