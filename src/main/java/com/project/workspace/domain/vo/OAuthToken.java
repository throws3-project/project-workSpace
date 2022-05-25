package com.project.workspace.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String id_token;
    private String expires_in;
    private String scope;
    private String refresh_token_expires_in;
}
