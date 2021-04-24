package com.mvvm.model;

public class LogState {
    private int id;
    private int employeeId;
    private int windowId;
    private int acId;
    private int dehumidifierId;
    private int humidifierId;
    private String employeesAction;

    public LogState() {
    }

    public LogState(int id, int employeeId, int windowId, int acId, int dehumidifierId, int humidifierId, String employeesAction) {
        this.id = id;
        this.employeeId = employeeId;
        this.windowId = windowId;
        this.acId = acId;
        this.dehumidifierId = dehumidifierId;
        this.humidifierId = humidifierId;
        this.employeesAction = employeesAction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public int getDehumidifierId() {
        return dehumidifierId;
    }

    public void setDehumidifierId(int dehumidifierId) {
        this.dehumidifierId = dehumidifierId;
    }

    public int getHumidifierId() {
        return humidifierId;
    }

    public void setHumidifierId(int humidifierId) {
        this.humidifierId = humidifierId;
    }

    public String getEmployeesAction() {
        return employeesAction;
    }

    public void setEmployeesAction(String employeesAction) {
        this.employeesAction = employeesAction;
    }
}
