package spring.sfgapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import spring.sfgapp.enums.eApps;
import spring.sfgapp.enums.eCountry;
import spring.sfgapp.enums.eStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REGUSER")
public class RegUser extends BaseEntity {
	@Builder
	public RegUser(Long id, String idUser, eApps idApp, eCountry idCountry, String regUserName, eStatus regUserStatus,
			String regAppName, LocalDate regUserFrom, LocalDate regUserTo, User regUserMap) {
		super(id);
		this.idApp = idApp;
		this.regAppName = regAppName;
		this.idCountry = idCountry;
		this.idUser = idUser;
		this.regUserName = regUserName;
		this.regUserStatus = regUserStatus;
		this.regUserFrom = regUserFrom;
		this.regUserTo = regUserTo;
		this.regUserMap = regUserMap;
	}

	@Column(name = "id_user")
	private String idUser;
	@Column(name = "id_app")
	private eApps idApp;
	@Column(name = "id_country")
	private eCountry idCountry;
	@Column(name = "reg_user_status")
	private eStatus regUserStatus;
	@Column(name = "reg_user_name")
	private String regUserName;
	@Column(name = "reg_app_name")
	private String regAppName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "reg_user_from")
	private LocalDate regUserFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "reg_user_to")
	private LocalDate regUserTo;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User regUserMap;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regAppMap")
	private Set<RegApp> regAppHashSet = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regPayMap")
	private Set<RegPay> regPayHashSet = new HashSet<>();

}
