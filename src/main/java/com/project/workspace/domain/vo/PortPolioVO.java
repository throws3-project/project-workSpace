package com.project.workspace.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PortPolioVO {
    Long portNum;
    Long userNum;
    String portUrl;
}
