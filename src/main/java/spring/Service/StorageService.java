package spring.Service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.config.ImageUtils;
import spring.entity.ImageData;
import spring.entity.InsuranceBooking;
import spring.repo.InsuranceBookingRepository;
import spring.repo.StorageRepository;

@Service
public class StorageService {
	
	 @Autowired
	    private StorageRepository repository;
	 @Autowired
	    private InsuranceBookingRepository insuranceBookingRepository;
	 
	    public String uploadImage(MultipartFile file, long id) throws IOException {
	    	        Optional<InsuranceBooking> a= insuranceBookingRepository.findById(id);
	    	        if(a==null)
	    	        return	"plese give coorect insurabce booking id";
	    	        
	        ImageData imageData = repository.save(ImageData.builder()
	        		.bid(a.get())
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtils.compressImage(file.getBytes())).build());
	        if (imageData != null) {
	            return "file uploaded successfully : " + file.getOriginalFilename()+"    "+imageData.getId();
	        }
	        return null;
	    }

	    public byte[] downloadImage(long claimid){
	        Optional<ImageData> dbImageData = repository.findById( claimid);
	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
	        return images;
	    }
}
