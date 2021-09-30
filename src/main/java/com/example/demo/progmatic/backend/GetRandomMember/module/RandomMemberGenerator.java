package com.example.demo.progmatic.backend.GetRandomMember.module;

import com.example.demo.progmatic.backend.GetRandomMember.config.ConfigReader;
import com.example.demo.progmatic.backend.GetRandomMember.exceptions.MyException;
import com.example.demo.progmatic.backend.GetRandomMember.model.Member;
import com.example.demo.progmatic.backend.GetRandomMember.util.DocumentReader;
import com.example.demo.progmatic.backend.GetRandomMember.util.MyRandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RandomMemberGenerator {
    @Autowired
    ConfigReader configReader;
    DocumentReader documentReader;
    MyRandomGenerator myRandomGenerator;

    @Autowired
    public RandomMemberGenerator(DocumentReader documentReader, MyRandomGenerator myRandomGenerator) {
        this.documentReader = documentReader;
        this.myRandomGenerator = myRandomGenerator;
        System.out.println("RandomGenerator started!");
        try {
            List<Member> memberList = documentReader.loadMembers();
            System.out.println(memberList.get(myRandomGenerator.getRandom(memberList.size())).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void post() {
        System.out.println("RandomMember: " + configReader.getResource());
    }
}
