package com.example.sep.data.remoteControllerService;

import com.example.sep.model.AC;
import com.example.sep.model.Humidifier;
import com.example.sep.model.Window;

public class RemoteControllerResponse {
    private int gym_ID;
    private int state;
    private int targetTemperature;
    private String message;
    private int automation;

    public AC getACState(){
        return new AC(gym_ID, state, targetTemperature, automation);
    }

    public AC turnOffAC(){
        return new AC(message);
    }

    public AC turnOnAC(){
        return new AC(message);
    }

    public AC turnOffAutomationAC(){
        return new AC(message);
    }

    public AC turnOnAutomationAC(){
        return new AC(message);
    }

    public Window openWindow(){
        return new Window(message);
    }

    public Window closeWindow(){
        return new Window(message);
    }

    public Window openWindowAutomation(){
        return new Window(message);
    }

    public Window closeWindowAutomation(){
        return new Window(message);
    }

    public Window getWindowState(){
        return new Window(gym_ID, state, automation);
    }

    public Humidifier turnOnHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier turnOffHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier turnOnAutomationHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier turnOffAutomationHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier getHumidifierState(){
        return new Humidifier(gym_ID, state, automation);
    }
}
