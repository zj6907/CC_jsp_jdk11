package com.example.domain.session.bif;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.example.domain.form.bif.BranchCondForm;

import lombok.Data;

@Data
@Component
@SessionScope
public class BranchCondSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private BranchCondForm form;

}
