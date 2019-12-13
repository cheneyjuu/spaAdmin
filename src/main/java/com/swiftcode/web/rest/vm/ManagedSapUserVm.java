package com.swiftcode.web.rest.vm;

import com.swiftcode.service.dto.SapUserDTO;

import javax.validation.constraints.Size;

/**
 * ManagedSapUserVm Class
 *
 * @author Ray
 * @date 2019/12/12 18:58
 */
public class ManagedSapUserVm extends SapUserDTO {
    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedSapUserVm() {
        // Empty constructor needed for Jackson.
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
