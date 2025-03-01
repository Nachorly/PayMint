package com.paymint.users.models.mappers;

import com.paymint.users.models.entities.User;
import com.paymint.users.models.entities.UserEntity;
import com.paymint.users.models.valueobjects.*;

import java.time.LocalDate;

public class UserEntityMapper {

    public static User toDomain(UserEntity userEntity) {
        return new User(
                new UserId(userEntity.getId()),
                new AccountStatus(userEntity.getAccountStatus()),
                new DateOfBirth(LocalDate.parse(userEntity.getDateOfBirth())),
                new NationalId(userEntity.getNationalId()),
                new Email(userEntity.getEmail()),
                new Name(userEntity.getName()),
                new Password(userEntity.getPassword()),
                new PhoneNumber(userEntity.getPhone()),
                new Address(userEntity.getStreet(), userEntity.getCity(), userEntity.getPostalCode(), userEntity.getCountry()),
                new Role(userEntity.getRole())
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId().value());
        userEntity.setAccountStatus(user.getAccountStatus().value());
        userEntity.setDateOfBirth(user.getDateOfBirth().value().toString());
        userEntity.setNationalId(user.getNationalId().value());
        userEntity.setEmail(user.getEmail().value());
        userEntity.setName(user.getName().value());
        userEntity.setPassword(user.getPassword().hashedValue());
        userEntity.setPhone(user.getPhoneNumber().value());
        userEntity.setCity(user.getAddress().city());
        userEntity.setCountry(user.getAddress().country());
        userEntity.setPostalCode(user.getAddress().postalCode());
        userEntity.setRole(user.getRole().value());
        userEntity.setUsername(user.getName().value());
        return userEntity;
    }
}
