package spring.sfgapp.model;

import lombok.Data;

/**
 * Response Class
 */
@Data
public class Response {
	/**
	 * Properties
	 */
	/** File id */
	private Long fileId;
	/** File name */
    private String fileName;
    /** Download URI of file */
    private String fileDownloadUri;
    /** Type of file */
    private String fileType;
    /** Size of file */
    private long size;

    /**
     * Constructors
     */
    public Response(Long fileId, String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileId = fileId;
    	this.fileName        = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType        = fileType;
        this.size            = size;
    }
}
