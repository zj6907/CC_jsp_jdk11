package com.example.domain.validator.bif;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import com.example.domain.form.bif.BranchCondForm;

@Component
public class BranchCondFormValidator {

	public void validate(String action, BranchCondForm f, BindingResult br) {
		if (action.equals("ALL")) {
			// bankCode1
			String bankCode1 = f.getBankCode1();
			if (!StringUtils.hasText(bankCode1))
				br.rejectValue("bankCode1", "bankCode1.noText");
			else if (!bankCode1.matches("\\d+"))
				br.rejectValue("bankCode1", "bankCode1.nonDigits");
			else if (bankCode1.length() != 4)
				br.rejectValue("bankCode1", "bankCode1.lengthNot4");
		} else if (action.equals("SPECIFIC")) {
			// bankCode2
			String bankCode2 = f.getBankCode2();
			if (!StringUtils.hasText(bankCode2))
				br.rejectValue("bankCode2", "bankCode2.noText");
			else if (!bankCode2.matches("\\d+"))
				br.rejectValue("bankCode2", "bankCode2.nonDigits");
			else if (bankCode2.length() != 4)
				br.rejectValue("bankCode2", "bankCode2.lengthNot4");

			// branchCode
			String branchCode = f.getBranchCode();
			if (!StringUtils.hasText(branchCode))
				br.rejectValue("branchCode", "branchCode.noText");
			else if (!branchCode.matches("\\d+"))
				br.rejectValue("branchCode", "branchCode.nonDigits");
			else if (branchCode.length() > 4)
				br.rejectValue("branchCode", "branchCode.lengthOver4");
		}

	}

}
