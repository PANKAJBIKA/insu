package spring.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import spring.Service.StorageService;
@RestController
@RequestMapping("/claim")
public class claim {
	@Autowired
	private StorageService service;

	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file,@RequestParam long id) throws IOException {
		String uploadImage = service.uploadImage(file,id);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/{claimid}")
	public ResponseEntity<?> downloadImage(@PathVariable long claimid){
		byte[] imageData=service.downloadImage(claimid);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("application/pdf"))
				.body(imageData);

	}
	  

}
