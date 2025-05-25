package com.example.usergems.model.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CompanyObj {
    String companyName;
    String companyLinkedinUrl;
    Integer employees;
}
