package com.example.domain.model.bif;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BranchInfoView {

	private String systemBankCode;
	private String bankCode;
	private String branchCode;
	private String branchName;
	private String branchNameKanji;
	private String commment;

}
