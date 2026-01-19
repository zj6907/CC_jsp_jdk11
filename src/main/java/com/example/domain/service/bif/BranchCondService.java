package com.example.domain.service.bif;

import java.util.Objects;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.form.bif.BranchCondForm;
import com.example.domain.session.bif.BranchCondSession;

@Service
public class BranchCondService {

	@Autowired
	private ObjectFactory<BranchCondSession> sessObj;

	public BranchCondForm getForm() {
		BranchCondSession sess = sessObj.getObject();
		BranchCondForm form = Objects.requireNonNullElse(sess.getForm(), new BranchCondForm());
		return form;
	}

	public void saveForm(BranchCondForm f) {
		sessObj.getObject().setForm(f);
	}

}
