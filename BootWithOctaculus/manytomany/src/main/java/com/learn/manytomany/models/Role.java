package com.learn.manytomany.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role {

	@Id
	private int id;
	private String roleName;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.EAGER)
	private Set<User> employees;

	public Role() {
		super();
	}

	public Role(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", Role name=" + roleName + "]";
	}
}
