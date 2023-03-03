package spring.sfgapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.sfgapp.entity.DatabaseFile;

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Long> {
	/**
	 * Methods
	 */
	/** Find the file by id and name from repository */
	Optional<DatabaseFile> findByFileIdAndFileName(Long fileId, String fileName);
	
	// Check if the file with the same contents existed
	boolean existsByData(byte[] bytes);
}
