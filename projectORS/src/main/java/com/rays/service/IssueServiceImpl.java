package com.rays.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.IssueDAOInt;
import com.rays.dto.IssueDTO;

@Service
@Transactional
public class IssueServiceImpl extends BaseServiceImpl<IssueDTO, IssueDAOInt>  implements IssueServiceInt{

	
	
}
