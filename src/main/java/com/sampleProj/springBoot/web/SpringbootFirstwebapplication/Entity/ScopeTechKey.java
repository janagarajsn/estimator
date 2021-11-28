package com.sampleProj.springBoot.web.SpringbootFirstwebapplication.Entity;

import java.io.Serializable;

public class ScopeTechKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int scopeId;
	private int techid;

	public ScopeTechKey(int scopeId, int techid) {
		super();
		this.scopeId = scopeId;
		this.techid = techid;
	}

	public ScopeTechKey() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + scopeId;
		result = prime * result + techid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScopeTechKey other = (ScopeTechKey) obj;
		if (scopeId != other.scopeId)
			return false;
		if (techid != other.techid)
			return false;
		return true;
	}

}
