package cloudlion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloudlion.database.File;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Long> {

    Optional<File> findOneByFileName(String fileName);
}
