package spring.sfgapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "REGPAY")
public class RegPay extends BaseEntity {
	@Builder
	public RegPay(Long id, String idUser, LocalDate payFrom, LocalDate payTo, String payDoc, LocalDate docDue,
			String docNumber, Double payAmount) {
		super(id);
		this.idUser = idUser;
		this.payFrom = payFrom;
		this.payTo = payTo;
		this.payDoc = payDoc;
		this.docDue = docDue;
		this.docNumber = docNumber;
		this.payAmount = payAmount;
	}

	@Column(name = "iduser")
	private String idUser;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "pay_from")
	private LocalDate payFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "pay_to")
	private LocalDate payTo;
	@Column(name = "pay_doc")
	private String payDoc;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "doc_due")
	private LocalDate docDue;
	@Column(name = "doc_number")
	private String docNumber;
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_FLOAT, pattern = "9999999.00")
	@Column(name = "pay_amount")
	private Double payAmount;

	@ManyToOne
	@JoinColumn(name = "pay_id")
	private RegPay regPayMap;
}