package com.example.domain.service.bif;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.form.bif.BranchCondForm;
import com.example.domain.model.bif.BranchInfoView;
import com.example.domain.model.bif.BranchQueryCond;
import com.example.domain.repository.entity.BranchInfoEntity;
import com.example.domain.repository.mapper.bif.BranchMapper;

@Service
public class BranchService {

	@Autowired
	private BranchMapper mapper;

	public List<BranchInfoView> execute(String action, BranchCondForm f) {
		List<BranchInfoEntity> entities = mapper.queryBranchInfos(getCond(action, f));
		List<BranchInfoView> vList = convert(entities);
		return vList;
	}

	private BranchQueryCond getCond(String action, BranchCondForm f) {
		BranchQueryCond cond = new BranchQueryCond();
		cond.setAction(action);
		cond.setSystemBankCode(f.isTrainingBank() ? "9997" : "9998");
		cond.setBankCode(action.equals("ALL") ? f.getBankCode1() : f.getBankCode2());
		if (action.equals("SPECIFIC"))
			cond.setBranchCode(f.getBranchCode());
		cond.setLimit(1000);
		return cond;
	}

	private List<BranchInfoView> convert(List<BranchInfoEntity> entities) {
		return null;
	}

}
