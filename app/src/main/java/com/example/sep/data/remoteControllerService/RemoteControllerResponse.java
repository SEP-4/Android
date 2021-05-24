package com.example.sep.data.remoteControllerService;

import com.example.sep.model.AC;
import com.example.sep.model.Humidifier;
import com.example.sep.model.Window;

public class RemoteControllerResponse {
    private int gym_ID;
    private int state;
    private int targetTemperature;
    private String message;

    public AC getACState(){
        return new AC(gym_ID, state, targetTemperature);
    }

    public AC turnOffAC(){
        return new AC(message);
    }

    public AC turnOnAC(){
        return new AC(message);
    }

    public Window openWindow(){
        return new Window(message);
    }

    public Window closeWindow(){
        return new Window(message);
    }

    public Window getWindowState(){
        return new Window(gym_ID, state);
    }

    public Humidifier turnOnHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier turnOffHumidifier(){
        return new Humidifier(message);
    }

    public Humidifier getHumidifierState(){
        return new Humidifier(gym_ID, state);
    }
}
