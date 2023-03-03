package spring.sfgapp.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

/**
 * DatabaseFile Class
 */
@Entity
@Table(name = "files")
@Data
public class DatabaseFile {
	/**
	 * Properties
	 */
	/** Identifier */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long fileId;
	/** File name */
	private String fileName;
	/** Type of file */
	private String fileType;
	/** File data */
	@Lob
	@Column(length = 1024 * 1024 * 512)
	private byte[] data;

	/**
	 * Constructors
	 */
	/** Default */
	public DatabaseFile() {

	}

	/** Argued */
	public DatabaseFile(String fileName, String fileType, byte[] data) {
		this.fileName = fileName;
		this.fileType = fileType;

		if (data == null) {
			this.data = new byte[0];
		} else {
			this.data = Arrays.copyOf(data, data.length);
		}
	}
}
