package spring.sfgapp.uploads;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import spring.sfgapp.entity.DatabaseFile;
import spring.sfgapp.model.Response;
import spring.sfgapp.repositories.DatabaseFileRepository;
import spring.sfgapp.services.FilesStorageService;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	
	@Autowired
    private DatabaseFileRepository dbFileRepository;

	private final Path root = Paths.get("uploads");

	@Override
	public void init() {
		try {
			Files.createDirectories(root);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	@Override
	public Response save(MultipartFile file) {
		try {

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

//			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));

			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			// Check if the same file existed
//	        if (dbFileRepository.existsByData(file.getBytes())) {
//	        	throw new AlreadyExistedException(fileName + " file");
//	        }

			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
			
			dbFile = dbFileRepository.save(dbFile);
			
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/file" + "/download" + "/")
	                .path(dbFile.getFileId() + "/")
	                .path(dbFile.getFileName())
	                .toUriString();
			
			return new Response(dbFile.getFileId(),fileName, fileDownloadUri, file.getContentType(), file.getSize());
		} catch (Exception e) {
			if (e instanceof FileAlreadyExistsException) {
				throw new RuntimeException("A file of that name already exists.");
			}

			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
	
	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}
	
	@Override
	public DatabaseFile getFile(Long fileId, String fileName) throws Exception {
		return dbFileRepository.findByFileIdAndFileName(fileId, fileName)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}
}