package com.example.domain.repository.mapper.bif;

import java.util.List;

import com.example.domain.model.bif.BranchQueryCond;
import com.example.domain.repository.entity.BranchInfoEntity;

public interface BranchMapper {
	
	List<BranchInfoEntity> queryBranchInfos(BranchQueryCond cond);

}
