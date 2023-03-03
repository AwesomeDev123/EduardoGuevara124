package spring.sfgapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import spring.sfgapp.enums.eStatus;
import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REGAPP")
public class RegApp extends BaseEntity {
	@Builder
	public RegApp(Long id, String appName, eStatus appStatus, LocalDate appStaFrom, LocalDate appStaTo,
			RegApp regAppMap) {
		super(id);
		this.appName = appName;
		this.appStatus = appStatus;
		this.appStaFrom = appStaFrom;
		this.appStaTo = appStaTo;
		this.regAppMap = regAppMap;
	}

	@Column(name = "app_name")
	private String appName;

	@Column(name = "app_status")
	private eStatus appStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "app_sta_from")
	private LocalDate appStaFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "app_sta_to")
	private LocalDate appStaTo;

	@ManyToOne
	@JoinColumn(name = "regapp_id")
	private RegApp regAppMap;
}
