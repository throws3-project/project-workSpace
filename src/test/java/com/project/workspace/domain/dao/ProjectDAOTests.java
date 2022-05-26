package com.project.workspace.domain.dao;

import com.project.workspace.domain.repository.ProjectRepository;
import com.project.workspace.domain.vo.ProjectVO;
import com.project.workspace.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectDAOTests {
    @Autowired
    private ProjectDAO projectDAO;
    private ProjectRepository projectRepository;


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

//@Test
//    public void insertSelectProjectNum(){
//
//    projectDAO.insertSelectProjectNum(1L, "projectName", "projectPart", "projectLocation", "o", "o", "projectContent", "projectImg", "projectImgUuid", "projectImgPath");
//
//}

}
