package com.paymint.users.converters;

import com.paymint.ConverterService;
import com.paymint.users.dto.UserDTO;
import com.paymint.users.models.entities.User;
import com.paymint.users.models.valueobjects.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserConverterService implements ConverterService {
    public static User userRequestToDomain(UserDTO userRequest) {
        return new User(
                new UserId(UUID.randomUUID().toString()),
                new AccountStatus(userRequest.getAccountStatus()),
                new DateOfBirth(userRequest.getDateOfBirth()),
                new NationalId(userRequest.getNationalId()),
                new Email(userRequest.getEmail()),
                new Name(userRequest.getName()),
                new Password(userRequest.getPassword()),
                new PhoneNumber(userRequest.getPhoneNumber()),
                new Address(
                        userRequest.getStreet(),
                        userRequest.getCity(),
                        userRequest.getPostalCode(),
                        userRequest.getCountry()
                ),
                new Role(userRequest.getRole())
        );
    }
}
