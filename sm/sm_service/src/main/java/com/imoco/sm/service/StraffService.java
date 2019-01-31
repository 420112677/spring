package com.imoco.sm.service;

import java.util.List;

import com.imoco.sm.entity.Staff;

public interface StraffService {
void add(Staff staff);
void remove(Integer id);
void edit(Staff staff);
Staff  get(Integer id);
List<Staff> getAll();
}
