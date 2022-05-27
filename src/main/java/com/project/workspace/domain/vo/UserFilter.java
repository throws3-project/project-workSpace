package com.project.workspace.domain.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class UserFilter {
    String locationFilter;
    String skillFilter;
    int limit;
}
