package com.project.workspace.domain.repository;

import com.project.workspace.domain.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
public class ProjectRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectSkillRepository projectSkillRepository;
    @Autowired
    private ProjectPersonRepository projectPersonRepository;
    @Autowired
    private ProjectReferenceRepository projectReferenceRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    @Autowired
    private ProjectLikeRepository projectLikeRepository;

    // 프로젝트 생성
//    @Test
//    public void insertTest(){
//        UserVO userVO = userRepository.findById(1L).get();
//        projectRepository.save(ProjectVO.builder().projectName("1").projectContent("1").projectImg("1").projectImgPath("1").projectImgUuid("1").projectLocation("1").projectOnOff("1").projectPart("1").projectPlatform("1").projectStatus("1").projectTotal(1L).loginCount(1L).userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        userRepository.findById(1L).get().getProjects().stream().map(ProjectVO::toString).forEach(log::info);
//    }

    // 프로젝트 스킬
//    @Test
//    public void insertTest(){
//        ProjectVO projectVO = projectRepository.findById(1L).get();
//        projectSkillRepository.save(ProjectSkillVO.builder().projectSkill("1").projectVO(projectVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        projectRepository.findById(1L).get().getSkills().stream().map(ProjectSkillVO::toString).forEach(log::info);
//    }

    // 프로젝트 사람
//    @Test
//    public void insertTest(){
//        ProjectVO projectVO = projectRepository.findById(1L).get();
//        projectPersonRepository.save(ProjectPersonVO.builder().projectCount(1L).projectMainSkill("1").projectSubSkill("1").projectVO(projectVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        projectRepository.findById(1L).get().getPersons().stream().map(ProjectPersonVO::toString).forEach(log::info);
//    }

    // 프로젝트 레퍼런스
//    @Test
//    public void insertTest(){
//        ProjectVO projectVO = projectRepository.findById(1L).get();
//        projectReferenceRepository.save(ProjectReferenceVO.builder().projectUrl("1").projectVO(projectVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        projectRepository.findById(1L).get().getReferences().stream().map(ProjectReferenceVO::toString).forEach(log::info);
//    }

    // 프로젝트 멤버
//    @Test
//    public void insertTest(){
//        ProjectVO projectVO = projectRepository.findById(1L).get();
//        UserVO userVO = userRepository.findById(1L).get();
//        projectMemberRepository.save(ProjectMemberVO.builder().projectMemberStatus("1").projectPart("1").projectMotive("1").projectVO(projectVO).userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        projectRepository.findById(1L).get().getMembers().stream().map(ProjectMemberVO::toString).forEach(log::info);
//    }

    // 프로젝트 좋아요
//    @Test
//    public void insertTest(){
//        ProjectVO projectVO = projectRepository.findById(1L).get();
//        UserVO userVO = userRepository.findById(1L).get();
//        projectLikeRepository.save(ProjectLikeVO.builder().projectVO(projectVO).userVO(userVO).build());
//    }
//    @Test
//    @Transactional
//    public void selectTest(){
//        projectRepository.findById(1L).get().getLikes().stream().map(ProjectLikeVO::toString).forEach(log::info);
//    }
}
