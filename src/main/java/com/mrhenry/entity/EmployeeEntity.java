package com.mrhenry.entity;

public class EmployeeEntity {
    
    private Long id;
    private String name;
    private String grid;

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
