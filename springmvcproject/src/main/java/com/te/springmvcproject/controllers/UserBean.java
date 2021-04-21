package com.te.springmvcproject.controllers;

import java.io.Serializable;

import lombok.Data;


@Data
public class UserBean implements Serializable{
	
	private String user;
	
	private int pwd;
}
