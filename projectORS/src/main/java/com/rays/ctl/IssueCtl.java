package com.rays.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.IssueDTO;
import com.rays.form.IssueForm;
import com.rays.service.IssueServiceInt;

@RestController
@RequestMapping(value = "Issue")
public class IssueCtl extends BaseCtl<IssueForm, IssueDTO, IssueServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		IssueDTO dto = new IssueDTO();

		List list = new ArrayList();

		list.add("Open");
		list.add("In Progress");
		list.add("Hold");
		list.add("Resolved");
		list.add("Close");

		res.addResult("issuelist", list);

		return res;
	}

}
