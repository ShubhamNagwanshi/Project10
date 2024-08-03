package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ProjectDTO;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl<ProjectDTO>implements ProjectDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ProjectDTO dto, CriteriaBuilder builder, Root<ProjectDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (!isEmptyString(dto.getCategory())) {

			whereCondition.add(builder.like(qRoot.get("category"), dto.getCategory() + "%"));
		}
		if (isNotNull(dto.getOpenDate())) {

			whereCondition.add(builder.equal(qRoot.get("openDate"), dto.getOpenDate()));
		}

		if (!isEmptyString(dto.getVersion())) {

			whereCondition.add(builder.equal(qRoot.get("version"), dto.getVersion() + "%"));
		}

		
		// TODO Auto-generated method stub
		return whereCondition;
	}

	@Override
	public Class<ProjectDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ProjectDTO.class;
	}

	

}
