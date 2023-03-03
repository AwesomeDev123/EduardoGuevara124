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
@Table(name = "CMSMASTER")
public class CmsMaster extends BaseEntity {
	@Builder
	public CmsMaster(Long id, int idOrder, int idTemplate, String mainTitle, String subtitleTop,
			String subtitleBottom) {
		super(id);
		this.idOrder = idOrder;
		this.idTemplate = idTemplate;
		this.mainTitle = mainTitle;
		this.subtitleTop = subtitleTop;
		this.subtitleBottom = subtitleBottom;
		/*
		 * if (cmsLabelSet != null) { this.cmsLabelSet = cmsLabelSet; }
		 */
		if (cmsDetailSet != null) {
			this.cmsDetailSet = cmsDetailSet;
		}
	}

	@Column(name = "id_App")
	private Long idApp;
	@Column(name = "id_Order")
	private int idOrder;
	@Column(name = "id_template")
	private int idTemplate;
	@Column(name = "main_title")
	private String mainTitle;
	@Column(name = "subtitle_top")
	private String subtitleTop;
	@Column(name = "subtitle_bottom")
	private String subtitleBottom;

	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsLabelMap") private
	 * Set<CmsDetLabels> cmsLabelSet = new HashSet<>();
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cmsMaster", fetch = FetchType.EAGER)
	private Set<CmsDetail> cmsDetailSet = new HashSet<>();
	// https://www.youtube.com/watch?v=VLlDaIcb3jE
	// https://www.youtube.com/watch?v=ucuVbL-tsUY&t=191s
}
