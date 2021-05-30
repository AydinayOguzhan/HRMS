package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstacts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeDao verificationCodeDao;
	
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public DataResult<List<VerificationCode>> GetAll() {
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll());
	}

	@Override
	public DataResult<List<VerificationCode>> GetAllByUserId(int userId) {
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.getAllByUserId(userId));
	}

	@Override
	public Result add(VerificationCode code) {
		this.verificationCodeDao.save(code);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result checkVerificationCode(int userId, String verificationCode) {
		var codes = this.GetAllByUserId(userId);
		for (var code : codes.getData()) {
			if (code.getCode().contains(verificationCode) && !code.isVerified()) {
				code.setVerified(true);
				this.update(code);
				return new SuccessResult("E-posta doğrulaması başarılı");
			}
		}
		return new ErrorResult("Doğrulama işlemi başarısız. Kod daha önceden kullanılmış olabilir."); 
	}

	@Override
	public Result update(VerificationCode code) {
		verificationCodeDao.save(code);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public DataResult<String> createVerificationCode() {
		Random random = new Random();
		String number1 = Integer.toString(random.nextInt(10));
		String number2 = Integer.toString(random.nextInt(10));
		String number3 = Integer.toString(random.nextInt(10));
		String number4 = Integer.toString(random.nextInt(10));
		String code = number1 + number2 + number3 + number4;
		return new SuccessDataResult<String>(code,"Oluşturma işlemi başarılı");
	}

	@Override
	public Result refreshVerificationCode(int userId) {
		var codes = this.GetAllByUserId(userId);
		for (var code : codes.getData()) {
			if (code.isVerified() != true) {
				code.setVerified(true);
				this.update(code);
			}
		}
		var code = this.createVerificationCode();
		var verificationCode = this.setVerificationCode(code.getData(), userId);
		this.add(verificationCode.getData());
		return new SuccessResult("İşlem başarılı. E-mailinizi kontrol ediniz");
	}

	@Override
	public DataResult<VerificationCode> setVerificationCode(String code, int userId) {
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(code);
		verificationCode.setUserId(userId);
		verificationCode.setVerified(false);
		return new SuccessDataResult<VerificationCode>(verificationCode);
	}

}
