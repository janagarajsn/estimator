package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ScopeTechKey.class)
public class ScopeTechRel {
	@Id
	private int scopeId;
	@Id
	private int techid;

	public ScopeTechRel(int scopeId, int techid) {
		super();
		this.scopeId = scopeId;
		this.techid = techid;
	}

	public ScopeTechRel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ScopeTechRel [scopeId=" + scopeId + ", techid=" + techid + "]";
	}

	public int getScopeId() {
		return scopeId;
	}

	public void setScopeId(int scopeId) {
		this.scopeId = scopeId;
	}

	public int getTechid() {
		return techid;
	}

	public void setTechid(int techid) {
		this.techid = techid;
	}
}
