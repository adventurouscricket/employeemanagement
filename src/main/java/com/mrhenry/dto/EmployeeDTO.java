package com.mrhenry.dto;

import java.util.List;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String grid;

    public List<EmployeeDTO> getResults() {
        return results;
    }

    public void setResults(List<EmployeeDTO> results) {
        this.results = results;
    }

    private List<EmployeeDTO> results;

    public String getAction() {
        return action;
    }

    private String action;

    public EmployeeDTO() {}

    public void setAction(String action) {
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
