package com.xyz.gym_management_sys.vo;

import java.io.Serializable;

import com.xyz.gym_management_sys.po.FieldType;

public class FieldVO implements Serializable
{
	private int fieldId;
	private String fieldName;
//	private int fieldTypeId;
	private int fieldStatement;
	private float fieldBorrowUnitvalent;//单价
	private FieldType fieldType;
}
