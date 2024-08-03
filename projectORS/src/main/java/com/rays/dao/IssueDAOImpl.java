package com.rays.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.IssueDTO;

@Repository
public class IssueDAOImpl extends BaseDAOImpl<IssueDTO> implements IssueDAOInt {

	@Override
	protected List<Predicate> getWhereClause(IssueDTO dto, CriteriaBuilder builder, Root<IssueDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (isNotNull(dto.getOpenDate())) {

			whereCondition.add(builder.equal(qRoot.get("openDate"), dto.getOpenDate()));
		}

		if (!isEmptyString(dto.getTitle())) {
			whereCondition.add(builder.like(qRoot.get("title"), dto.getTitle() + "%"));
		}

		if (!isEmptyString(dto.getDescription())) {
			whereCondition.add(builder.like(qRoot.get("description"), dto.getDescription() + "%"));

		}

		if (!isEmptyString(dto.getAssignTo())) {
			whereCondition.add(builder.like(qRoot.get("assignTo"), dto.getAssignTo() + "%"));
		}

		if (isEmptyString(dto.getStatus())) {
			whereCondition.add(builder.like(qRoot.get("status"), dto.getStatus() + "%"));
		}
		return whereCondition;
	}

	@Override
	public Class<IssueDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return IssueDTO.class;
	}

}
