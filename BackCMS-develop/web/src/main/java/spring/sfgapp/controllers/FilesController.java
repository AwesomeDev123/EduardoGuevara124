package spring.sfgapp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import spring.sfgapp.entity.DatabaseFile;
import spring.sfgapp.entity.FileInfo;
import spring.sfgapp.model.Response;
import spring.sfgapp.services.FilesStorageService;

@RestController
@CrossOrigin(origins = {"*"}, maxAge = 4200, methods = {RequestMethod.POST, RequestMethod.OPTIONS}, allowedHeaders = {"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers"}, exposedHeaders = {"Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"})
@RequestMapping({"/file", "/files"})
public class FilesController {
	@Autowired
	FilesStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
//		String message = "";
		Response response = null;
		try {
			response = storageService.save(file);
//			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			
//			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} catch (Exception e) {
//			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {

		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			/*
			 * String url = MvcUriComponentsBuilder .fromMethodName(FilesController.class,
			 * "getFile", path.getFileName().toString()).build().toString();
			 */
			UriComponents url = MvcUriComponentsBuilder.fromMethodName(FilesController.class, "getFile", new Object())
					.build();
			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/download/{fileId}/{filename:.+}")
	public ResponseEntity<?> getFile(@PathVariable Long fileId, @PathVariable String filename) {
		try {
			DatabaseFile databaseFile = storageService.getFile(fileId, filename);
			return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
	                .body(new ByteArrayResource(databaseFile.getData()));
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}		
		
	}
}