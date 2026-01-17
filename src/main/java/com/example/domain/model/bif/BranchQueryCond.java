package com.example.domain.model.bif;

import lombok.Data;

@Data
public class BranchQueryCond {
	
	private String action;

	private String systemBankCode;

	private String bankCode;

	private String branchCode;

	private Integer limit;

}
