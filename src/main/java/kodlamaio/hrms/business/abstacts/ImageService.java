package kodlamaio.hrms.business.abstacts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<Map> uploadImage(MultipartFile file, int userId)throws IOException;
	
	DataResult<Map> deleteImage(int userId)throws Exception;
	
	DataResult<String> getUserImage(int userId);
}
