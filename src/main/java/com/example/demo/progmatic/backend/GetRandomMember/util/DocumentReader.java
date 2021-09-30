package com.example.demo.progmatic.backend.GetRandomMember.util;

import com.example.demo.progmatic.backend.GetRandomMember.config.ConfigReader;
import com.example.demo.progmatic.backend.GetRandomMember.exceptions.MyException;
import com.example.demo.progmatic.backend.GetRandomMember.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DocumentReader {
    //TODO: why is this not required here?
    @Autowired
    ConfigReader configReader;

    public List<Member> loadMembers() throws MyException {
        List<Member> members = new ArrayList<>();

        try {
            Stream<String> stream = Files.lines(Paths.get(configReader.getResource()));
            stream.forEach(line -> {
                if (!line.contains(configReader.getCommentPrefix()))        // commented lines will be ignored
                    if (!line.contains(configReader.getPresentedPrefix()))
                        members.add(new Member(line));
                    else
                        members.add(new Member(line, true));
                else {
                    // TODO check commentPrefix position
                    // TODO if prefix position != 0
                    // TODO substring
                }
            });
            if (members.isEmpty()) {
                System.out.println("There is no member in the input file");
                throw new MyException();
            }
            System.out.println(members.size() + " member loaded!");
        } catch(NoSuchFileException e) {
            System.out.println("Rossz elérési út lett megadva!");
            System.out.println(e.getMessage());

            throw new MyException();
        } catch (IOException e) {
            System.out.println("Unknown error");
            e.printStackTrace();

            throw new MyException();
        }
        return members;
    }
}
