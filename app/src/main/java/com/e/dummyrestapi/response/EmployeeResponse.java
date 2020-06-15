package com.e.dummyrestapi.response;

import com.e.dummyrestapi.model.Employee;

import java.util.List;

public class EmployeeResponse {

    public String status;
    public List<Employee> data;

    public EmployeeResponse(String status, List<Employee> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}
