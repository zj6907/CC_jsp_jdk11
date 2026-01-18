package com.example.domain.service.bif;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		List<BranchInfoView> viewList = convert(entities);
		return viewList;
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

	@SuppressWarnings("unused")
	private List<BranchInfoView> convert(List<BranchInfoEntity> entities) {
		List<BranchInfoView> vList = new ArrayList<BranchInfoView>();
		entities.forEach(e -> {
			// get main Branch info
			BranchInfoView v1 = new BranchInfoView();
			v1.setSystemBankCode(e.getSystemBankCode());
			v1.setBankCode(e.getBankCode());
			v1.setBranchCode(e.getBranchCode());
			v1.setBranchName(e.getBranchName());
			v1.setBranchNameKanji(e.getBranchNameKanji());
			v1.setCommment(e.getCommment());
			vList.add(v1);

			// get branch optional name
			// @formatter:off
			List<Function<BranchInfoEntity, String>> optNameGetters = List.of(
					BranchInfoEntity::getOptBranchName1,
				    BranchInfoEntity::getOptBranchName2,
				    BranchInfoEntity::getOptBranchName3,
				    BranchInfoEntity::getOptBranchName4,
				    BranchInfoEntity::getOptBranchName5,
				    BranchInfoEntity::getOptBranchName6,
				    BranchInfoEntity::getOptBranchName7,
				    BranchInfoEntity::getOptBranchName8,
				    BranchInfoEntity::getOptBranchName9
				);

			// get branch optional name Kanji
			List<Function<BranchInfoEntity, String>> optNameKanjiGetters = List.of(
					BranchInfoEntity::getOptBranchNameKanji1,
				    BranchInfoEntity::getOptBranchNameKanji2,
				    BranchInfoEntity::getOptBranchNameKanji3,
				    BranchInfoEntity::getOptBranchNameKanji4,
				    BranchInfoEntity::getOptBranchNameKanji5,
				    BranchInfoEntity::getOptBranchNameKanji6,
				    BranchInfoEntity::getOptBranchNameKanji7,
				    BranchInfoEntity::getOptBranchNameKanji8,
				    BranchInfoEntity::getOptBranchNameKanji9
				);
			// @formatter:on

			IntStream.range(0, 9).forEach(i -> {
				String name = optNameGetters.get(i).apply(e);
				if (StringUtils.hasText(name)) {
					BranchInfoView v2 = new BranchInfoView();
					v2.setBranchName(name);
					v2.setBranchNameKanji(optNameKanjiGetters.get(i).apply(e));
					vList.add(v2);
				}
			});
		});

		return vList;
	}

	List<Object> extractSeries(Object pojo, String prefix) throws Exception {
		List<Object> result = new ArrayList<>();

		BeanInfo beanInfo = Introspector.getBeanInfo(pojo.getClass());
		for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
			String name = pd.getName();
			if (name.matches(prefix + "[1-9]")) {
				Object value = pd.getReadMethod().invoke(pojo);
				result.add(value);
			}
		}
		return result;
	}

}
