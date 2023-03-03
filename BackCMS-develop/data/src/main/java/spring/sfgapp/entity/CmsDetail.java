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
@Table(name = "CMSDETAIL")
public class CmsDetail extends BaseEntity {
	@Builder
	public CmsDetail(Long id, int idCms, int idOrder, String title, String subtitle) {
		super(id);
		this.idCms = idCms;
		this.idOrder = idOrder;
		this.title = title;
		this.subtitle = subtitle;
	}

	@Column(name = "id_Cms")
	private int idCms;
	@Column(name = "id_Order")
	private int idOrder;
	@Column(name = "title")
	private String title;
	@Column(name = "subtitle")
	private String subtitle;

	@ManyToOne
	private CmsMaster cmsMaster;

}
