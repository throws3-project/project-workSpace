package com.project.workspace.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectDAOTests {
    @Autowired
    private ProjectDAO projectDAO;


//    @Test
//    public void TestInsertProject(){
//        projectDAO.insertProject(1L, "ㅇ","ㅇ","ㅇ","ㅇ","ㅇ","ㅇ","ㅇ","ㅇ","ㅇ", 1L);
//    }

//    @Test
//    public void TestInsertProjectMember(){
//        projectDAO.insertProjectMember(1L, 1L,"ㅇ","ㅇ");
//    }

//    @Test
//    public void TestInsertProjectPerson(){
//        projectDAO.insertProjectPerson(1L, "o","ㅇ",1L);
//    }

//    @Test
//    public void TestInsertProjectReference(){
//        projectDAO.insertProjectReference(1L, "o");
//    }

//    @Test
//    public void TestInsertProjectSkill(){
//        projectDAO.insertProjectSkill(1L, "o");
//    }

//    @Test
//    public void TestInsertLikeProject(){
//        projectDAO.insertLikeProject(1L, 1L);
//    }



}
