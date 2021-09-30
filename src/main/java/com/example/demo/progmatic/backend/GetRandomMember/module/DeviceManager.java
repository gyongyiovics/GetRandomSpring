package com.example.demo.progmatic.backend.GetRandomMember.module;

import com.example.demo.progmatic.backend.GetRandomMember.config.ConfigReader;
import com.example.demo.progmatic.backend.GetRandomMember.model.Device;
import com.example.demo.progmatic.backend.GetRandomMember.util.RegexUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DeviceManager {
    public static List<Device> loadDevicesFromFile() {
        List<Device> deviceList = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(ConfigReader.getDeviceResource()));
            lines.forEach(line -> {
                Device device = findDeviceInLine(line);
                if(device != null) {
                    deviceList.add(device);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceList;
    }

    public static Device findDeviceInLine(String line) {
        String regex = "(?<=Android [7-9].{0,10}; )(.*?)(?= MIUI| Build)";
        String name = RegexUtil.findMatch(line, regex);
        if(name != null) {
            return new Device(name);
        }
        return null;
    }
}
