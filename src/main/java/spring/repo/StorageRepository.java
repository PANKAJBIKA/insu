package spring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.entity.ImageData;
@Repository
public  interface StorageRepository extends JpaRepository<ImageData, Long> {
	 Optional<ImageData>  findByName(String fileName);
	ImageData save(ImageData imageData);	
}
