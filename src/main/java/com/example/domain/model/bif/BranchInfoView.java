package com.example.domain.model.bif;

import lombok.Data;

@Data
public class BranchInfoView {

	private String systemBankCode;
	private String bankCode;
	private String branchCode;
	private String branchName;
	private String branchNameKanji;
	private String commment;

}
