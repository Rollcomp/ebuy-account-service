package org.ebuy.dto;

import lombok.Getter;
import lombok.Setter;
import org.ebuy.model.Gender;
import org.ebuy.model.Membership;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@Getter
@Setter
public class UserDto {

    private Long id;
    private String email;
    private Gender gender;
    private Membership membership;
    private String lastUsedAddress;

}
