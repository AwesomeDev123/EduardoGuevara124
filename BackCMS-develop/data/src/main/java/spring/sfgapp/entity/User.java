package spring.sfgapp.entity;

import lombok.*;
import spring.sfgapp.model.Person;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER")
public class User extends Person {
	@Builder
	public User(Long id, String firstName, String lastName, String phoneNumber, String emailAddress,
			List<RegUser> regUserList) {
		super(id, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		if (regUserList != null) {
			this.regUserList = regUserList;
		}
	}

	public User(Long id, String firstName, String lastName, String phoneNumber, String emailAddress) {
		super(id, firstName, lastName);
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	@Column(name = "phone_Number")
	private String phoneNumber;
	@Column(name = "email_Address")
	private String emailAddress;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "regUserMap")
	private List<RegUser> regUserList;

}
