package tn.esprit.spring.Controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Controller;

@Controller(value = "addArticleController")
@ELBeanName(value = "addArticleController")
@Join(path = "/add-article", to = "add-article.jsf")
public class AddArticleController {

//	private Part uploadedFile;
//
//	FileStorageServiceImpl fileStorageServiceImpl;
//	public Part getUploadedFile() {
//		return uploadedFile;
//	}
//
//	public void setUploadedFile(Part uploadedFile) {
//		this.uploadedFile = uploadedFile;
//	}
//	
//		public void saveFile(){
//			String newFileName=fileStorageServiceImpl.UploadImage(uploadedFile);
//			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
//			.path(newFileName).toUriString();
//			System.out.println(fileDownloadUri);
//}
//			
			
}
